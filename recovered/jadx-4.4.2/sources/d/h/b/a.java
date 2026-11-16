package d.h.b;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.recyclerview.widget.RecyclerView;
import d.d.h;
import d.f.k.a0.d;
import d.f.k.a0.e;
import d.f.k.r;
import d.f.k.u;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends d.f.k.a {
    private static final Rect n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, RecyclerView.UNDEFINED_DURATION, RecyclerView.UNDEFINED_DURATION);
    private static final d.h.b.b.a<d.f.k.a0.c> o = new C0057a();
    private static final d.h.b.b.InterfaceC0058b<h<d.f.k.a0.c>, d.f.k.a0.c> p = new b();
    private final AccessibilityManager h;
    private final View i;
    private c j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f808d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Rect f809e = new Rect();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Rect f810f = new Rect();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f811g = new int[2];
    int k = RecyclerView.UNDEFINED_DURATION;
    int l = RecyclerView.UNDEFINED_DURATION;
    private int m = RecyclerView.UNDEFINED_DURATION;

    /* JADX INFO: renamed from: d.h.b.a$a, reason: collision with other inner class name */
    static class C0057a implements d.h.b.b.a<d.f.k.a0.c> {
        C0057a() {
        }

        @Override // d.h.b.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(d.f.k.a0.c cVar, Rect rect) {
            cVar.k(rect);
        }
    }

    static class b implements d.h.b.b.InterfaceC0058b<h<d.f.k.a0.c>, d.f.k.a0.c> {
        b() {
        }

        @Override // d.h.b.b.InterfaceC0058b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public d.f.k.a0.c b(h<d.f.k.a0.c> hVar, int i) {
            return hVar.l(i);
        }

        @Override // d.h.b.b.InterfaceC0058b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int a(h<d.f.k.a0.c> hVar) {
            return hVar.k();
        }
    }

    private class c extends d {
        c() {
        }

        @Override // d.f.k.a0.d
        public d.f.k.a0.c a(int i) {
            return d.f.k.a0.c.L(a.this.H(i));
        }

        @Override // d.f.k.a0.d
        public d.f.k.a0.c c(int i) {
            int i2 = i == 2 ? a.this.k : a.this.l;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i2);
        }

        @Override // d.f.k.a0.d
        public boolean e(int i, int i2, Bundle bundle) {
            return a.this.P(i, i2, bundle);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.i = view;
        this.h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (r.t(view) == 0) {
            r.m0(view, 1);
        }
    }

    private static Rect D(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    private boolean E(Rect rect) {
        if (rect == null || rect.isEmpty() || this.i.getWindowVisibility() != 0) {
            return false;
        }
        View view = this.i;
        do {
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return parent != null;
            }
            view = (View) parent;
            if (view.getAlpha() <= 0.0f) {
                break;
            }
        } while (view.getVisibility() == 0);
        return false;
    }

    private static int F(int i) {
        if (i == 19) {
            return 33;
        }
        if (i != 21) {
            return i != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean G(int i, Rect rect) {
        Object objD;
        h<d.f.k.a0.c> hVarY = y();
        int i2 = this.l;
        int iH = RecyclerView.UNDEFINED_DURATION;
        d.f.k.a0.c cVarE = i2 == Integer.MIN_VALUE ? null : hVarY.e(i2);
        if (i == 1 || i == 2) {
            objD = d.h.b.b.d(hVarY, p, o, cVarE, i, r.v(this.i) == 1, false);
        } else {
            if (i != 17 && i != 33 && i != 66 && i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i3 = this.l;
            if (i3 != Integer.MIN_VALUE) {
                z(i3, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                D(this.i, i, rect2);
            }
            objD = d.h.b.b.c(hVarY, p, o, cVarE, rect2, i);
        }
        d.f.k.a0.c cVar = (d.f.k.a0.c) objD;
        if (cVar != null) {
            iH = hVarY.h(hVarY.g(cVar));
        }
        return T(iH);
    }

    private boolean Q(int i, int i2, Bundle bundle) {
        if (i2 == 1) {
            return T(i);
        }
        if (i2 == 2) {
            return o(i);
        }
        if (i2 != 64) {
            return i2 != 128 ? J(i, i2, bundle) : n(i);
        }
        return S(i);
    }

    private boolean R(int i, Bundle bundle) {
        return r.T(this.i, i, bundle);
    }

    private boolean S(int i) {
        int i2;
        if (!this.h.isEnabled() || !this.h.isTouchExplorationEnabled() || (i2 = this.k) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            n(i2);
        }
        this.k = i;
        this.i.invalidate();
        U(i, 32768);
        return true;
    }

    private void V(int i) {
        int i2 = this.m;
        if (i2 == i) {
            return;
        }
        this.m = i;
        U(i, 128);
        U(i2, 256);
    }

    private boolean n(int i) {
        if (this.k != i) {
            return false;
        }
        this.k = RecyclerView.UNDEFINED_DURATION;
        this.i.invalidate();
        U(i, 65536);
        return true;
    }

    private boolean p() {
        int i = this.l;
        return i != Integer.MIN_VALUE && J(i, 16, null);
    }

    private AccessibilityEvent q(int i, int i2) {
        return i != -1 ? r(i, i2) : s(i2);
    }

    private AccessibilityEvent r(int i, int i2) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
        d.f.k.a0.c cVarH = H(i);
        accessibilityEventObtain.getText().add(cVarH.u());
        accessibilityEventObtain.setContentDescription(cVarH.p());
        accessibilityEventObtain.setScrollable(cVarH.G());
        accessibilityEventObtain.setPassword(cVarH.F());
        accessibilityEventObtain.setEnabled(cVarH.B());
        accessibilityEventObtain.setChecked(cVarH.z());
        L(i, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(cVarH.n());
        e.c(accessibilityEventObtain, this.i, i);
        accessibilityEventObtain.setPackageName(this.i.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    private AccessibilityEvent s(int i) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i);
        this.i.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    private d.f.k.a0.c t(int i) {
        d.f.k.a0.c cVarJ = d.f.k.a0.c.J();
        cVarJ.c0(true);
        cVarJ.e0(true);
        cVarJ.V("android.view.View");
        cVarJ.R(n);
        cVarJ.S(n);
        cVarJ.k0(this.i);
        N(i, cVarJ);
        if (cVarJ.u() == null && cVarJ.p() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        cVarJ.k(this.f809e);
        if (this.f809e.equals(n)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int i2 = cVarJ.i();
        if ((i2 & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((i2 & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        cVarJ.i0(this.i.getContext().getPackageName());
        cVarJ.p0(this.i, i);
        if (this.k == i) {
            cVarJ.P(true);
            cVarJ.a(128);
        } else {
            cVarJ.P(false);
            cVarJ.a(64);
        }
        boolean z = this.l == i;
        if (z) {
            cVarJ.a(2);
        } else if (cVarJ.C()) {
            cVarJ.a(1);
        }
        cVarJ.f0(z);
        this.i.getLocationOnScreen(this.f811g);
        cVarJ.l(this.f808d);
        if (this.f808d.equals(n)) {
            cVarJ.k(this.f808d);
            if (cVarJ.b != -1) {
                d.f.k.a0.c cVarJ2 = d.f.k.a0.c.J();
                for (int i3 = cVarJ.b; i3 != -1; i3 = cVarJ2.b) {
                    cVarJ2.l0(this.i, -1);
                    cVarJ2.R(n);
                    N(i3, cVarJ2);
                    cVarJ2.k(this.f809e);
                    Rect rect = this.f808d;
                    Rect rect2 = this.f809e;
                    rect.offset(rect2.left, rect2.top);
                }
                cVarJ2.N();
            }
            this.f808d.offset(this.f811g[0] - this.i.getScrollX(), this.f811g[1] - this.i.getScrollY());
        }
        if (this.i.getLocalVisibleRect(this.f810f)) {
            this.f810f.offset(this.f811g[0] - this.i.getScrollX(), this.f811g[1] - this.i.getScrollY());
            if (this.f808d.intersect(this.f810f)) {
                cVarJ.S(this.f808d);
                if (E(this.f808d)) {
                    cVarJ.r0(true);
                }
            }
        }
        return cVarJ;
    }

    private d.f.k.a0.c u() {
        d.f.k.a0.c cVarK = d.f.k.a0.c.K(this.i);
        r.R(this.i, cVarK);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (cVarK.m() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            cVarK.c(this.i, ((Integer) arrayList.get(i)).intValue());
        }
        return cVarK;
    }

    private h<d.f.k.a0.c> y() {
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        h<d.f.k.a0.c> hVar = new h<>();
        for (int i = 0; i < arrayList.size(); i++) {
            hVar.i(i, t(i));
        }
        return hVar;
    }

    private void z(int i, Rect rect) {
        H(i).k(rect);
    }

    public final int A() {
        return this.l;
    }

    protected abstract int B(float f2, float f3);

    protected abstract void C(List<Integer> list);

    d.f.k.a0.c H(int i) {
        return i == -1 ? u() : t(i);
    }

    public final void I(boolean z, int i, Rect rect) {
        int i2 = this.l;
        if (i2 != Integer.MIN_VALUE) {
            o(i2);
        }
        if (z) {
            G(i, rect);
        }
    }

    protected abstract boolean J(int i, int i2, Bundle bundle);

    protected void K(AccessibilityEvent accessibilityEvent) {
    }

    protected void L(int i, AccessibilityEvent accessibilityEvent) {
    }

    protected void M(d.f.k.a0.c cVar) {
    }

    protected abstract void N(int i, d.f.k.a0.c cVar);

    protected void O(int i, boolean z) {
    }

    boolean P(int i, int i2, Bundle bundle) {
        return i != -1 ? Q(i, i2, bundle) : R(i2, bundle);
    }

    public final boolean T(int i) {
        int i2;
        if ((!this.i.isFocused() && !this.i.requestFocus()) || (i2 = this.l) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            o(i2);
        }
        this.l = i;
        O(i, true);
        U(i, 8);
        return true;
    }

    public final boolean U(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = this.i.getParent()) == null) {
            return false;
        }
        return u.h(parent, this.i, q(i, i2));
    }

    @Override // d.f.k.a
    public d b(View view) {
        if (this.j == null) {
            this.j = new c();
        }
        return this.j;
    }

    @Override // d.f.k.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        K(accessibilityEvent);
    }

    @Override // d.f.k.a
    public void g(View view, d.f.k.a0.c cVar) {
        super.g(view, cVar);
        M(cVar);
    }

    public final boolean o(int i) {
        if (this.l != i) {
            return false;
        }
        this.l = RecyclerView.UNDEFINED_DURATION;
        O(i, false);
        U(i, 8);
        return true;
    }

    public final boolean v(MotionEvent motionEvent) {
        if (!this.h.isEnabled() || !this.h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iB = B(motionEvent.getX(), motionEvent.getY());
            V(iB);
            return iB != Integer.MIN_VALUE;
        }
        if (action != 10 || this.m == Integer.MIN_VALUE) {
            return false;
        }
        V(RecyclerView.UNDEFINED_DURATION);
        return true;
    }

    public final boolean w(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return G(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return G(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int iF = F(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z = false;
                    while (i < repeatCount && G(iF, null)) {
                        i++;
                        z = true;
                    }
                    return z;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        p();
        return true;
    }

    public final int x() {
        return this.k;
    }
}
