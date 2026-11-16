package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public class x0 implements d0 {
    Toolbar a;
    private int b;
    private View c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f227g;
    private boolean h;
    CharSequence i;
    private CharSequence j;
    private CharSequence k;
    Window.Callback l;
    boolean m;
    private c n;
    private int o;
    private int p;
    private Drawable q;

    class a implements View.OnClickListener {
        final androidx.appcompat.view.menu.a b;

        a() {
            this.b = new androidx.appcompat.view.menu.a(x0.this.a.getContext(), 0, R.id.home, 0, 0, x0.this.i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            x0 x0Var = x0.this;
            Window.Callback callback = x0Var.l;
            if (callback == null || !x0Var.m) {
                return;
            }
            callback.onMenuItemSelected(0, this.b);
        }
    }

    class b extends d.f.k.x {
        private boolean a = false;
        final /* synthetic */ int b;

        b(int i) {
            this.b = i;
        }

        @Override // d.f.k.w
        public void a(View view) {
            if (this.a) {
                return;
            }
            x0.this.a.setVisibility(this.b);
        }

        @Override // d.f.k.x, d.f.k.w
        public void b(View view) {
            x0.this.a.setVisibility(0);
        }

        @Override // d.f.k.x, d.f.k.w
        public void c(View view) {
            this.a = true;
        }
    }

    public x0(Toolbar toolbar, boolean z) {
        this(toolbar, z, d.a.h.abc_action_bar_up_description, d.a.e.abc_ic_ab_back_material);
    }

    public x0(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.f227g = toolbar.getNavigationIcon();
        w0 w0VarU = w0.u(toolbar.getContext(), null, d.a.j.ActionBar, d.a.a.actionBarStyle, 0);
        this.q = w0VarU.g(d.a.j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence charSequenceP = w0VarU.p(d.a.j.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceP)) {
                G(charSequenceP);
            }
            CharSequence charSequenceP2 = w0VarU.p(d.a.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceP2)) {
                F(charSequenceP2);
            }
            Drawable drawableG = w0VarU.g(d.a.j.ActionBar_logo);
            if (drawableG != null) {
                B(drawableG);
            }
            Drawable drawableG2 = w0VarU.g(d.a.j.ActionBar_icon);
            if (drawableG2 != null) {
                setIcon(drawableG2);
            }
            if (this.f227g == null && (drawable = this.q) != null) {
                E(drawable);
            }
            w(w0VarU.k(d.a.j.ActionBar_displayOptions, 0));
            int iN = w0VarU.n(d.a.j.ActionBar_customNavigationLayout, 0);
            if (iN != 0) {
                z(LayoutInflater.from(this.a.getContext()).inflate(iN, (ViewGroup) this.a, false));
                w(this.b | 16);
            }
            int iM = w0VarU.m(d.a.j.ActionBar_height, 0);
            if (iM > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = iM;
                this.a.setLayoutParams(layoutParams);
            }
            int iE = w0VarU.e(d.a.j.ActionBar_contentInsetStart, -1);
            int iE2 = w0VarU.e(d.a.j.ActionBar_contentInsetEnd, -1);
            if (iE >= 0 || iE2 >= 0) {
                this.a.H(Math.max(iE, 0), Math.max(iE2, 0));
            }
            int iN2 = w0VarU.n(d.a.j.ActionBar_titleTextStyle, 0);
            if (iN2 != 0) {
                Toolbar toolbar2 = this.a;
                toolbar2.L(toolbar2.getContext(), iN2);
            }
            int iN3 = w0VarU.n(d.a.j.ActionBar_subtitleTextStyle, 0);
            if (iN3 != 0) {
                Toolbar toolbar3 = this.a;
                toolbar3.K(toolbar3.getContext(), iN3);
            }
            int iN4 = w0VarU.n(d.a.j.ActionBar_popupTheme, 0);
            if (iN4 != 0) {
                this.a.setPopupTheme(iN4);
            }
        } else {
            this.b = y();
        }
        w0VarU.v();
        A(i);
        this.k = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new a());
    }

    private void H(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    private void I() {
        if ((this.b & 4) != 0) {
            if (TextUtils.isEmpty(this.k)) {
                this.a.setNavigationContentDescription(this.p);
            } else {
                this.a.setNavigationContentDescription(this.k);
            }
        }
    }

    private void J() {
        Toolbar toolbar;
        Drawable drawable;
        if ((this.b & 4) != 0) {
            toolbar = this.a;
            drawable = this.f227g;
            if (drawable == null) {
                drawable = this.q;
            }
        } else {
            toolbar = this.a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void K() {
        Drawable drawable;
        int i = this.b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f226f) == null) {
            drawable = this.f225e;
        }
        this.a.setLogo(drawable);
    }

    private int y() {
        if (this.a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.a.getNavigationIcon();
        return 15;
    }

    public void A(int i) {
        if (i == this.p) {
            return;
        }
        this.p = i;
        if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
            C(this.p);
        }
    }

    public void B(Drawable drawable) {
        this.f226f = drawable;
        K();
    }

    public void C(int i) {
        D(i == 0 ? null : v().getString(i));
    }

    public void D(CharSequence charSequence) {
        this.k = charSequence;
        I();
    }

    public void E(Drawable drawable) {
        this.f227g = drawable;
        J();
    }

    public void F(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    public void G(CharSequence charSequence) {
        this.h = true;
        H(charSequence);
    }

    @Override // androidx.appcompat.widget.d0
    public boolean a() {
        return this.a.O();
    }

    @Override // androidx.appcompat.widget.d0
    public void b(Menu menu, androidx.appcompat.view.menu.m.a aVar) {
        if (this.n == null) {
            c cVar = new c(this.a.getContext());
            this.n = cVar;
            cVar.p(d.a.f.action_menu_presenter);
        }
        this.n.e(aVar);
        this.a.I((androidx.appcompat.view.menu.g) menu, this.n);
    }

    @Override // androidx.appcompat.widget.d0
    public boolean c() {
        return this.a.z();
    }

    @Override // androidx.appcompat.widget.d0
    public void collapseActionView() {
        this.a.e();
    }

    @Override // androidx.appcompat.widget.d0
    public void d() {
        this.m = true;
    }

    @Override // androidx.appcompat.widget.d0
    public boolean e() {
        return this.a.A();
    }

    @Override // androidx.appcompat.widget.d0
    public boolean f() {
        return this.a.d();
    }

    @Override // androidx.appcompat.widget.d0
    public boolean g() {
        return this.a.w();
    }

    @Override // androidx.appcompat.widget.d0
    public CharSequence getTitle() {
        return this.a.getTitle();
    }

    @Override // androidx.appcompat.widget.d0
    public void h() {
        this.a.f();
    }

    @Override // androidx.appcompat.widget.d0
    public void i(androidx.appcompat.view.menu.m.a aVar, androidx.appcompat.view.menu.g.a aVar2) {
        this.a.J(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.d0
    public d.f.k.v j(int i, long j) {
        d.f.k.v vVarC = d.f.k.r.c(this.a);
        vVarC.a(i == 0 ? 1.0f : 0.0f);
        vVarC.d(j);
        vVarC.f(new b(i));
        return vVarC;
    }

    @Override // androidx.appcompat.widget.d0
    public int k() {
        return this.b;
    }

    @Override // androidx.appcompat.widget.d0
    public void l(int i) {
        this.a.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.d0
    public void m() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.d0
    public Menu n() {
        return this.a.getMenu();
    }

    @Override // androidx.appcompat.widget.d0
    public boolean o() {
        return this.a.v();
    }

    @Override // androidx.appcompat.widget.d0
    public void p(int i) {
        B(i != 0 ? d.a.k.a.a.d(v(), i) : null);
    }

    @Override // androidx.appcompat.widget.d0
    public void q(p0 p0Var) {
        View view = this.c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.a;
            if (parent == toolbar) {
                toolbar.removeView(this.c);
            }
        }
        this.c = p0Var;
        if (p0Var == null || this.o != 2) {
            return;
        }
        this.a.addView(p0Var, 0);
        Toolbar.e eVar = (Toolbar.e) this.c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) eVar).width = -2;
        ((ViewGroup.MarginLayoutParams) eVar).height = -2;
        eVar.a = 8388691;
        p0Var.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.d0
    public ViewGroup r() {
        return this.a;
    }

    @Override // androidx.appcompat.widget.d0
    public void s(boolean z) {
    }

    @Override // androidx.appcompat.widget.d0
    public void setIcon(int i) {
        setIcon(i != 0 ? d.a.k.a.a.d(v(), i) : null);
    }

    @Override // androidx.appcompat.widget.d0
    public void setIcon(Drawable drawable) {
        this.f225e = drawable;
        K();
    }

    @Override // androidx.appcompat.widget.d0
    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    @Override // androidx.appcompat.widget.d0
    public void setWindowTitle(CharSequence charSequence) {
        if (this.h) {
            return;
        }
        H(charSequence);
    }

    @Override // androidx.appcompat.widget.d0
    public void t() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.d0
    public void u(boolean z) {
        this.a.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.d0
    public Context v() {
        return this.a.getContext();
    }

    @Override // androidx.appcompat.widget.d0
    public void w(int i) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i2 = this.b ^ i;
        this.b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    I();
                }
                J();
            }
            if ((i2 & 3) != 0) {
                K();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.a.setTitle(this.i);
                    toolbar = this.a;
                    charSequence = this.j;
                } else {
                    charSequence = null;
                    this.a.setTitle((CharSequence) null);
                    toolbar = this.a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i2 & 16) == 0 || (view = this.f224d) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.a.addView(view);
            } else {
                this.a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.d0
    public int x() {
        return this.o;
    }

    public void z(View view) {
        View view2 = this.f224d;
        if (view2 != null && (this.b & 16) != 0) {
            this.a.removeView(view2);
        }
        this.f224d = view;
        if (view == null || (this.b & 16) == 0) {
            return;
        }
        this.a.addView(view);
    }
}
