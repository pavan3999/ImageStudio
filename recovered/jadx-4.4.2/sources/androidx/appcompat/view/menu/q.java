package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.l0;

/* JADX INFO: loaded from: classes.dex */
final class q extends k implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, m, View.OnKeyListener {
    private static final int w = d.a.g.abc_popup_menu_item_layout;
    private final Context c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f f103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f105g;
    private final int h;
    private final int i;
    final l0 j;
    private PopupWindow.OnDismissListener m;
    private View n;
    View o;
    private m.a p;
    ViewTreeObserver q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean v;
    final ViewTreeObserver.OnGlobalLayoutListener k = new a();
    private final View.OnAttachStateChangeListener l = new b();
    private int u = 0;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!q.this.a() || q.this.j.x()) {
                return;
            }
            View view = q.this.o;
            if (view == null || !view.isShown()) {
                q.this.dismiss();
            } else {
                q.this.j.b();
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = q.this.q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    q.this.q = view.getViewTreeObserver();
                }
                q qVar = q.this;
                qVar.q.removeGlobalOnLayoutListener(qVar.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i, int i2, boolean z) {
        this.c = context;
        this.f102d = gVar;
        this.f104f = z;
        this.f103e = new f(gVar, LayoutInflater.from(context), this.f104f, w);
        this.h = i;
        this.i = i2;
        Resources resources = context.getResources();
        this.f105g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.a.d.abc_config_prefDialogWidth));
        this.n = view;
        this.j = new l0(this.c, null, this.h, this.i);
        gVar.c(this, context);
    }

    private boolean z() {
        View view;
        if (a()) {
            return true;
        }
        if (this.r || (view = this.n) == null) {
            return false;
        }
        this.o = view;
        this.j.G(this);
        this.j.H(this);
        this.j.F(true);
        View view2 = this.o;
        boolean z = this.q == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.q = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.k);
        }
        view2.addOnAttachStateChangeListener(this.l);
        this.j.z(view2);
        this.j.C(this.u);
        if (!this.s) {
            this.t = k.o(this.f103e, null, this.c, this.f105g);
            this.s = true;
        }
        this.j.B(this.t);
        this.j.E(2);
        this.j.D(n());
        this.j.b();
        ListView listViewG = this.j.g();
        listViewG.setOnKeyListener(this);
        if (this.v && this.f102d.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.c).inflate(d.a.g.abc_popup_menu_header_item_layout, (ViewGroup) listViewG, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f102d.x());
            }
            frameLayout.setEnabled(false);
            listViewG.addHeaderView(frameLayout, null, false);
        }
        this.j.o(this.f103e);
        this.j.b();
        return true;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a() {
        return !this.r && this.j.a();
    }

    @Override // androidx.appcompat.view.menu.p
    public void b() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void c(g gVar, boolean z) {
        if (gVar != this.f102d) {
            return;
        }
        dismiss();
        m.a aVar = this.p;
        if (aVar != null) {
            aVar.c(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        if (a()) {
            this.j.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void e(m.a aVar) {
        this.p = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean f(r rVar) {
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.c, rVar, this.o, this.f104f, this.h, this.i);
            lVar.j(this.p);
            lVar.g(k.x(rVar));
            lVar.i(this.m);
            this.m = null;
            this.f102d.e(false);
            int iF = this.j.f();
            int iK = this.j.k();
            if ((Gravity.getAbsoluteGravity(this.u, d.f.k.r.v(this.n)) & 7) == 5) {
                iF += this.n.getWidth();
            }
            if (lVar.n(iF, iK)) {
                m.a aVar = this.p;
                if (aVar == null) {
                    return true;
                }
                aVar.d(rVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView g() {
        return this.j.g();
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean h() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void i(boolean z) {
        this.s = false;
        f fVar = this.f103e;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void l(g gVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.r = true;
        this.f102d.close();
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.k);
            this.q = null;
        }
        this.o.removeOnAttachStateChangeListener(this.l);
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.k
    public void p(View view) {
        this.n = view;
    }

    @Override // androidx.appcompat.view.menu.k
    public void r(boolean z) {
        this.f103e.d(z);
    }

    @Override // androidx.appcompat.view.menu.k
    public void s(int i) {
        this.u = i;
    }

    @Override // androidx.appcompat.view.menu.k
    public void t(int i) {
        this.j.e(i);
    }

    @Override // androidx.appcompat.view.menu.k
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.m = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void v(boolean z) {
        this.v = z;
    }

    @Override // androidx.appcompat.view.menu.k
    public void w(int i) {
        this.j.m(i);
    }
}
