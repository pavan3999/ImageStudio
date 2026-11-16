package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import com.google.android.material.internal.h;
import d.f.k.r;
import e.a.a.a.a0.g;
import e.a.a.a.a0.k;
import e.a.a.a.a0.n;
import e.a.a.a.b;
import e.a.a.a.x.c;

/* JADX INFO: loaded from: classes.dex */
class a {
    private static final boolean s;
    private final MaterialButton a;
    private k b;
    private int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f562g;
    private int h;
    private PorterDuff.Mode i;
    private ColorStateList j;
    private ColorStateList k;
    private ColorStateList l;
    private Drawable m;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q;
    private LayerDrawable r;

    static {
        s = Build.VERSION.SDK_INT >= 21;
    }

    a(MaterialButton materialButton, k kVar) {
        this.a = materialButton;
        this.b = kVar;
    }

    private void A(k kVar) {
        if (d() != null) {
            d().setShapeAppearanceModel(kVar);
        }
        if (l() != null) {
            l().setShapeAppearanceModel(kVar);
        }
        if (c() != null) {
            c().setShapeAppearanceModel(kVar);
        }
    }

    private void C() {
        g gVarD = d();
        g gVarL = l();
        if (gVarD != null) {
            gVarD.Z(this.h, this.k);
            if (gVarL != null) {
                gVarL.Y(this.h, this.n ? e.a.a.a.q.a.c(this.a, b.colorSurface) : 0);
            }
        }
    }

    private InsetDrawable D(Drawable drawable) {
        return new InsetDrawable(drawable, this.c, this.f560e, this.f559d, this.f561f);
    }

    private Drawable a() {
        g gVar = new g(this.b);
        gVar.L(this.a.getContext());
        androidx.core.graphics.drawable.a.o(gVar, this.j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            androidx.core.graphics.drawable.a.p(gVar, mode);
        }
        gVar.Z(this.h, this.k);
        g gVar2 = new g(this.b);
        gVar2.setTint(0);
        gVar2.Y(this.h, this.n ? e.a.a.a.q.a.c(this.a, b.colorSurface) : 0);
        if (s) {
            g gVar3 = new g(this.b);
            this.m = gVar3;
            androidx.core.graphics.drawable.a.n(gVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(e.a.a.a.y.b.a(this.l), D(new LayerDrawable(new Drawable[]{gVar2, gVar})), this.m);
            this.r = rippleDrawable;
            return rippleDrawable;
        }
        e.a.a.a.y.a aVar = new e.a.a.a.y.a(this.b);
        this.m = aVar;
        androidx.core.graphics.drawable.a.o(aVar, e.a.a.a.y.b.a(this.l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar, this.m});
        this.r = layerDrawable;
        return D(layerDrawable);
    }

    private g e(boolean z) {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (g) (s ? (LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable() : this.r).getDrawable(!z ? 1 : 0);
    }

    private g l() {
        return e(true);
    }

    void B(int i, int i2) {
        Drawable drawable = this.m;
        if (drawable != null) {
            drawable.setBounds(this.c, this.f560e, i2 - this.f559d, i - this.f561f);
        }
    }

    int b() {
        return this.f562g;
    }

    public n c() {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return (n) (this.r.getNumberOfLayers() > 2 ? this.r.getDrawable(2) : this.r.getDrawable(1));
    }

    g d() {
        return e(false);
    }

    ColorStateList f() {
        return this.l;
    }

    k g() {
        return this.b;
    }

    ColorStateList h() {
        return this.k;
    }

    int i() {
        return this.h;
    }

    ColorStateList j() {
        return this.j;
    }

    PorterDuff.Mode k() {
        return this.i;
    }

    boolean m() {
        return this.o;
    }

    boolean n() {
        return this.q;
    }

    void o(TypedArray typedArray) {
        this.c = typedArray.getDimensionPixelOffset(e.a.a.a.k.MaterialButton_android_insetLeft, 0);
        this.f559d = typedArray.getDimensionPixelOffset(e.a.a.a.k.MaterialButton_android_insetRight, 0);
        this.f560e = typedArray.getDimensionPixelOffset(e.a.a.a.k.MaterialButton_android_insetTop, 0);
        this.f561f = typedArray.getDimensionPixelOffset(e.a.a.a.k.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(e.a.a.a.k.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(e.a.a.a.k.MaterialButton_cornerRadius, -1);
            this.f562g = dimensionPixelSize;
            u(this.b.w(dimensionPixelSize));
            this.p = true;
        }
        this.h = typedArray.getDimensionPixelSize(e.a.a.a.k.MaterialButton_strokeWidth, 0);
        this.i = h.c(typedArray.getInt(e.a.a.a.k.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.j = c.a(this.a.getContext(), typedArray, e.a.a.a.k.MaterialButton_backgroundTint);
        this.k = c.a(this.a.getContext(), typedArray, e.a.a.a.k.MaterialButton_strokeColor);
        this.l = c.a(this.a.getContext(), typedArray, e.a.a.a.k.MaterialButton_rippleColor);
        this.q = typedArray.getBoolean(e.a.a.a.k.MaterialButton_android_checkable, false);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(e.a.a.a.k.MaterialButton_elevation, 0);
        int iA = r.A(this.a);
        int paddingTop = this.a.getPaddingTop();
        int iZ = r.z(this.a);
        int paddingBottom = this.a.getPaddingBottom();
        this.a.setInternalBackground(a());
        g gVarD = d();
        if (gVarD != null) {
            gVarD.S(dimensionPixelSize2);
        }
        r.p0(this.a, iA + this.c, paddingTop + this.f560e, iZ + this.f559d, paddingBottom + this.f561f);
    }

    void p(int i) {
        if (d() != null) {
            d().setTint(i);
        }
    }

    void q() {
        this.o = true;
        this.a.setSupportBackgroundTintList(this.j);
        this.a.setSupportBackgroundTintMode(this.i);
    }

    void r(boolean z) {
        this.q = z;
    }

    void s(int i) {
        if (this.p && this.f562g == i) {
            return;
        }
        this.f562g = i;
        this.p = true;
        u(this.b.w(i));
    }

    void t(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            if (s && (this.a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.a.getBackground()).setColor(e.a.a.a.y.b.a(colorStateList));
            } else {
                if (s || !(this.a.getBackground() instanceof e.a.a.a.y.a)) {
                    return;
                }
                ((e.a.a.a.y.a) this.a.getBackground()).setTintList(e.a.a.a.y.b.a(colorStateList));
            }
        }
    }

    void u(k kVar) {
        this.b = kVar;
        A(kVar);
    }

    void v(boolean z) {
        this.n = z;
        C();
    }

    void w(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            C();
        }
    }

    void x(int i) {
        if (this.h != i) {
            this.h = i;
            C();
        }
    }

    void y(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            if (d() != null) {
                androidx.core.graphics.drawable.a.o(d(), this.j);
            }
        }
    }

    void z(PorterDuff.Mode mode) {
        if (this.i != mode) {
            this.i = mode;
            if (d() == null || this.i == null) {
                return;
            }
            androidx.core.graphics.drawable.a.p(d(), this.i);
        }
    }
}
