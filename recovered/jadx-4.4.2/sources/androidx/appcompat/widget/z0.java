package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: loaded from: classes.dex */
class z0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    private static z0 k;
    private static z0 l;
    private final View b;
    private final CharSequence c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Runnable f235e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Runnable f236f = new b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f237g;
    private int h;
    private a1 i;
    private boolean j;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z0.this.g(false);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z0.this.c();
        }
    }

    private z0(View view, CharSequence charSequence) {
        this.b = view;
        this.c = charSequence;
        this.f234d = d.f.k.s.c(ViewConfiguration.get(view.getContext()));
        b();
        this.b.setOnLongClickListener(this);
        this.b.setOnHoverListener(this);
    }

    private void a() {
        this.b.removeCallbacks(this.f235e);
    }

    private void b() {
        this.f237g = Integer.MAX_VALUE;
        this.h = Integer.MAX_VALUE;
    }

    private void d() {
        this.b.postDelayed(this.f235e, ViewConfiguration.getLongPressTimeout());
    }

    private static void e(z0 z0Var) {
        z0 z0Var2 = k;
        if (z0Var2 != null) {
            z0Var2.a();
        }
        k = z0Var;
        if (z0Var != null) {
            z0Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        z0 z0Var = k;
        if (z0Var != null && z0Var.b == view) {
            e(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new z0(view, charSequence);
            return;
        }
        z0 z0Var2 = l;
        if (z0Var2 != null && z0Var2.b == view) {
            z0Var2.c();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private boolean h(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f237g) <= this.f234d && Math.abs(y - this.h) <= this.f234d) {
            return false;
        }
        this.f237g = x;
        this.h = y;
        return true;
    }

    void c() {
        if (l == this) {
            l = null;
            a1 a1Var = this.i;
            if (a1Var != null) {
                a1Var.c();
                this.i = null;
                b();
                this.b.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (k == this) {
            e(null);
        }
        this.b.removeCallbacks(this.f236f);
    }

    void g(boolean z) {
        long longPressTimeout;
        if (d.f.k.r.I(this.b)) {
            e(null);
            z0 z0Var = l;
            if (z0Var != null) {
                z0Var.c();
            }
            l = this;
            this.j = z;
            a1 a1Var = new a1(this.b.getContext());
            this.i = a1Var;
            a1Var.e(this.b, this.f237g, this.h, this.j, this.c);
            this.b.addOnAttachStateChangeListener(this);
            if (this.j) {
                longPressTimeout = 2500;
            } else {
                longPressTimeout = ((d.f.k.r.C(this.b) & 1) == 1 ? 3000L : 15000L) - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.b.removeCallbacks(this.f236f);
            this.b.postDelayed(this.f236f, longPressTimeout);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.i != null && this.j) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.b.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.b.isEnabled() && this.i == null && h(motionEvent)) {
            e(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f237g = view.getWidth() / 2;
        this.h = view.getHeight() / 2;
        g(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
