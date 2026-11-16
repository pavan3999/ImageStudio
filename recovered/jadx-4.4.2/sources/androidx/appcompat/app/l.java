package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.p0;
import d.f.k.r;
import d.f.k.v;
import d.f.k.w;
import d.f.k.x;
import d.f.k.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class l extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {
    private static final Interpolator B = new AccelerateInterpolator();
    private static final Interpolator C = new DecelerateInterpolator();
    final y A;
    Context a;
    private Context b;
    ActionBarOverlayLayout c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ActionBarContainer f47d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    d0 f48e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ActionBarContextView f49f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    View f50g;
    p0 h;
    private boolean i;
    d j;
    d.a.o.b k;
    d.a.o.b.a l;
    private boolean m;
    private ArrayList<androidx.appcompat.app.a.b> n;
    private boolean o;
    private int p;
    boolean q;
    boolean r;
    boolean s;
    private boolean t;
    private boolean u;
    d.a.o.h v;
    private boolean w;
    boolean x;
    final w y;
    final w z;

    class a extends x {
        a() {
        }

        @Override // d.f.k.w
        public void a(View view) {
            View view2;
            l lVar = l.this;
            if (lVar.q && (view2 = lVar.f50g) != null) {
                view2.setTranslationY(0.0f);
                l.this.f47d.setTranslationY(0.0f);
            }
            l.this.f47d.setVisibility(8);
            l.this.f47d.setTransitioning(false);
            l lVar2 = l.this;
            lVar2.v = null;
            lVar2.x();
            ActionBarOverlayLayout actionBarOverlayLayout = l.this.c;
            if (actionBarOverlayLayout != null) {
                r.a0(actionBarOverlayLayout);
            }
        }
    }

    class b extends x {
        b() {
        }

        @Override // d.f.k.w
        public void a(View view) {
            l lVar = l.this;
            lVar.v = null;
            lVar.f47d.requestLayout();
        }
    }

    class c implements y {
        c() {
        }

        @Override // d.f.k.y
        public void a(View view) {
            ((View) l.this.f47d.getParent()).invalidate();
        }
    }

    public class d extends d.a.o.b implements androidx.appcompat.view.menu.g.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Context f51d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final androidx.appcompat.view.menu.g f52e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private d.a.o.b.a f53f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private WeakReference<View> f54g;

        public d(Context context, d.a.o.b.a aVar) {
            this.f51d = context;
            this.f53f = aVar;
            androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
            gVar.S(1);
            this.f52e = gVar;
            gVar.R(this);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void a(androidx.appcompat.view.menu.g gVar) {
            if (this.f53f == null) {
                return;
            }
            k();
            l.this.f49f.l();
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean b(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            d.a.o.b.a aVar = this.f53f;
            if (aVar != null) {
                return aVar.c(this, menuItem);
            }
            return false;
        }

        @Override // d.a.o.b
        public void c() {
            l lVar = l.this;
            if (lVar.j != this) {
                return;
            }
            if (l.w(lVar.r, lVar.s, false)) {
                this.f53f.b(this);
            } else {
                l lVar2 = l.this;
                lVar2.k = this;
                lVar2.l = this.f53f;
            }
            this.f53f = null;
            l.this.v(false);
            l.this.f49f.g();
            l.this.f48e.r().sendAccessibilityEvent(32);
            l lVar3 = l.this;
            lVar3.c.setHideOnContentScrollEnabled(lVar3.x);
            l.this.j = null;
        }

        @Override // d.a.o.b
        public View d() {
            WeakReference<View> weakReference = this.f54g;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // d.a.o.b
        public Menu e() {
            return this.f52e;
        }

        @Override // d.a.o.b
        public MenuInflater f() {
            return new d.a.o.g(this.f51d);
        }

        @Override // d.a.o.b
        public CharSequence g() {
            return l.this.f49f.getSubtitle();
        }

        @Override // d.a.o.b
        public CharSequence i() {
            return l.this.f49f.getTitle();
        }

        @Override // d.a.o.b
        public void k() {
            if (l.this.j != this) {
                return;
            }
            this.f52e.d0();
            try {
                this.f53f.a(this, this.f52e);
            } finally {
                this.f52e.c0();
            }
        }

        @Override // d.a.o.b
        public boolean l() {
            return l.this.f49f.j();
        }

        @Override // d.a.o.b
        public void m(View view) {
            l.this.f49f.setCustomView(view);
            this.f54g = new WeakReference<>(view);
        }

        @Override // d.a.o.b
        public void n(int i) {
            o(l.this.a.getResources().getString(i));
        }

        @Override // d.a.o.b
        public void o(CharSequence charSequence) {
            l.this.f49f.setSubtitle(charSequence);
        }

        @Override // d.a.o.b
        public void q(int i) {
            r(l.this.a.getResources().getString(i));
        }

        @Override // d.a.o.b
        public void r(CharSequence charSequence) {
            l.this.f49f.setTitle(charSequence);
        }

        @Override // d.a.o.b
        public void s(boolean z) {
            super.s(z);
            l.this.f49f.setTitleOptional(z);
        }

        public boolean t() {
            this.f52e.d0();
            try {
                return this.f53f.d(this, this.f52e);
            } finally {
                this.f52e.c0();
            }
        }
    }

    public l(Activity activity, boolean z) {
        new ArrayList();
        this.n = new ArrayList<>();
        this.p = 0;
        this.q = true;
        this.u = true;
        this.y = new a();
        this.z = new b();
        this.A = new c();
        View decorView = activity.getWindow().getDecorView();
        D(decorView);
        if (z) {
            return;
        }
        this.f50g = decorView.findViewById(R.id.content);
    }

    public l(Dialog dialog) {
        new ArrayList();
        this.n = new ArrayList<>();
        this.p = 0;
        this.q = true;
        this.u = true;
        this.y = new a();
        this.z = new b();
        this.A = new c();
        D(dialog.getWindow().getDecorView());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private d0 A(View view) {
        if (view instanceof d0) {
            return (d0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void C() {
        if (this.t) {
            this.t = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            M(false);
        }
    }

    private void D(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(d.a.f.decor_content_parent);
        this.c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f48e = A(view.findViewById(d.a.f.action_bar));
        this.f49f = (ActionBarContextView) view.findViewById(d.a.f.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(d.a.f.action_bar_container);
        this.f47d = actionBarContainer;
        d0 d0Var = this.f48e;
        if (d0Var == null || this.f49f == null || actionBarContainer == null) {
            throw new IllegalStateException(l.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.a = d0Var.v();
        boolean z = (this.f48e.k() & 4) != 0;
        if (z) {
            this.i = true;
        }
        d.a.o.a aVarB = d.a.o.a.b(this.a);
        J(aVarB.a() || z);
        H(aVarB.g());
        TypedArray typedArrayObtainStyledAttributes = this.a.obtainStyledAttributes(null, d.a.j.ActionBar, d.a.a.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(d.a.j.ActionBar_hideOnContentScroll, false)) {
            I(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.a.j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            G(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void H(boolean z) {
        this.o = z;
        if (z) {
            this.f47d.setTabContainer(null);
            this.f48e.q(this.h);
        } else {
            this.f48e.q(null);
            this.f47d.setTabContainer(this.h);
        }
        boolean z2 = B() == 2;
        p0 p0Var = this.h;
        if (p0Var != null) {
            if (z2) {
                p0Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.c;
                if (actionBarOverlayLayout != null) {
                    r.a0(actionBarOverlayLayout);
                }
            } else {
                p0Var.setVisibility(8);
            }
        }
        this.f48e.u(!this.o && z2);
        this.c.setHasNonEmbeddedTabs(!this.o && z2);
    }

    private boolean K() {
        return r.J(this.f47d);
    }

    private void L() {
        if (this.t) {
            return;
        }
        this.t = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.c;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        M(false);
    }

    private void M(boolean z) {
        if (w(this.r, this.s, this.t)) {
            if (this.u) {
                return;
            }
            this.u = true;
            z(z);
            return;
        }
        if (this.u) {
            this.u = false;
            y(z);
        }
    }

    static boolean w(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    public int B() {
        return this.f48e.x();
    }

    public void E(boolean z) {
        F(z ? 4 : 0, 4);
    }

    public void F(int i, int i2) {
        int iK = this.f48e.k();
        if ((i2 & 4) != 0) {
            this.i = true;
        }
        this.f48e.w((i & i2) | ((i2 ^ (-1)) & iK));
    }

    public void G(float f2) {
        r.j0(this.f47d, f2);
    }

    public void I(boolean z) {
        if (z && !this.c.w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.x = z;
        this.c.setHideOnContentScrollEnabled(z);
    }

    public void J(boolean z) {
        this.f48e.s(z);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        d.a.o.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
            this.v = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b(boolean z) {
        this.q = z;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(int i) {
        this.p = i;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
        if (this.s) {
            return;
        }
        this.s = true;
        M(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        if (this.s) {
            this.s = false;
            M(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f() {
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        d0 d0Var = this.f48e;
        if (d0Var == null || !d0Var.o()) {
            return false;
        }
        this.f48e.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z) {
        if (z == this.m) {
            return;
        }
        this.m = z;
        int size = this.n.size();
        for (int i = 0; i < size; i++) {
            this.n.get(i).a(z);
        }
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f48e.k();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(d.a.a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.b = new ContextThemeWrapper(this.a, i);
            } else {
                this.b = this.a;
            }
        }
        return this.b;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        H(d.a.o.a.b(this.a).g());
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i, KeyEvent keyEvent) {
        Menu menuE;
        d dVar = this.j;
        if (dVar == null || (menuE = dVar.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z) {
        if (this.i) {
            return;
        }
        E(z);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z) {
        d.a.o.h hVar;
        this.w = z;
        if (z || (hVar = this.v) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.a
    public void t(CharSequence charSequence) {
        this.f48e.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public d.a.o.b u(d.a.o.b.a aVar) {
        d dVar = this.j;
        if (dVar != null) {
            dVar.c();
        }
        this.c.setHideOnContentScrollEnabled(false);
        this.f49f.k();
        d dVar2 = new d(this.f49f.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.j = dVar2;
        dVar2.k();
        this.f49f.h(dVar2);
        v(true);
        this.f49f.sendAccessibilityEvent(32);
        return dVar2;
    }

    public void v(boolean z) {
        v vVarJ;
        v vVarF;
        if (z) {
            L();
        } else {
            C();
        }
        if (!K()) {
            if (z) {
                this.f48e.l(4);
                this.f49f.setVisibility(0);
                return;
            } else {
                this.f48e.l(0);
                this.f49f.setVisibility(8);
                return;
            }
        }
        if (z) {
            vVarF = this.f48e.j(4, 100L);
            vVarJ = this.f49f.f(0, 200L);
        } else {
            vVarJ = this.f48e.j(0, 200L);
            vVarF = this.f49f.f(8, 100L);
        }
        d.a.o.h hVar = new d.a.o.h();
        hVar.d(vVarF, vVarJ);
        hVar.h();
    }

    void x() {
        d.a.o.b.a aVar = this.l;
        if (aVar != null) {
            aVar.b(this.k);
            this.k = null;
            this.l = null;
        }
    }

    public void y(boolean z) {
        View view;
        d.a.o.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        if (this.p != 0 || (!this.w && !z)) {
            this.y.a(null);
            return;
        }
        this.f47d.setAlpha(1.0f);
        this.f47d.setTransitioning(true);
        d.a.o.h hVar2 = new d.a.o.h();
        float f2 = -this.f47d.getHeight();
        if (z) {
            int[] iArr = {0, 0};
            this.f47d.getLocationInWindow(iArr);
            f2 -= iArr[1];
        }
        v vVarC = r.c(this.f47d);
        vVarC.k(f2);
        vVarC.i(this.A);
        hVar2.c(vVarC);
        if (this.q && (view = this.f50g) != null) {
            v vVarC2 = r.c(view);
            vVarC2.k(f2);
            hVar2.c(vVarC2);
        }
        hVar2.f(B);
        hVar2.e(250L);
        hVar2.g(this.y);
        this.v = hVar2;
        hVar2.h();
    }

    public void z(boolean z) {
        View view;
        View view2;
        d.a.o.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        this.f47d.setVisibility(0);
        if (this.p == 0 && (this.w || z)) {
            this.f47d.setTranslationY(0.0f);
            float f2 = -this.f47d.getHeight();
            if (z) {
                int[] iArr = {0, 0};
                this.f47d.getLocationInWindow(iArr);
                f2 -= iArr[1];
            }
            this.f47d.setTranslationY(f2);
            d.a.o.h hVar2 = new d.a.o.h();
            v vVarC = r.c(this.f47d);
            vVarC.k(0.0f);
            vVarC.i(this.A);
            hVar2.c(vVarC);
            if (this.q && (view2 = this.f50g) != null) {
                view2.setTranslationY(f2);
                v vVarC2 = r.c(this.f50g);
                vVarC2.k(0.0f);
                hVar2.c(vVarC2);
            }
            hVar2.f(C);
            hVar2.e(250L);
            hVar2.g(this.z);
            this.v = hVar2;
            hVar2.h();
        } else {
            this.f47d.setAlpha(1.0f);
            this.f47d.setTranslationY(0.0f);
            if (this.q && (view = this.f50g) != null) {
                view.setTranslationY(0.0f);
            }
            this.z.a(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.c;
        if (actionBarOverlayLayout != null) {
            r.a0(actionBarOverlayLayout);
        }
    }
}
