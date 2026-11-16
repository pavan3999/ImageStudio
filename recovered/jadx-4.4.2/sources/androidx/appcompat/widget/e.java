package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class e {
    private final View a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private u0 f159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private u0 f160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private u0 f161f;
    private int c = -1;
    private final j b = j.b();

    e(View view) {
        this.a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f161f == null) {
            this.f161f = new u0();
        }
        u0 u0Var = this.f161f;
        u0Var.a();
        ColorStateList colorStateListM = d.f.k.r.m(this.a);
        if (colorStateListM != null) {
            u0Var.f213d = true;
            u0Var.a = colorStateListM;
        }
        PorterDuff.Mode modeN = d.f.k.r.n(this.a);
        if (modeN != null) {
            u0Var.c = true;
            u0Var.b = modeN;
        }
        if (!u0Var.f213d && !u0Var.c) {
            return false;
        }
        j.i(drawable, u0Var, this.a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i = Build.VERSION.SDK_INT;
        if (i > 21) {
            return this.f159d != null;
        }
        return i == 21;
    }

    void b() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            u0 u0Var = this.f160e;
            if (u0Var != null) {
                j.i(background, u0Var, this.a.getDrawableState());
                return;
            }
            u0 u0Var2 = this.f159d;
            if (u0Var2 != null) {
                j.i(background, u0Var2, this.a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        u0 u0Var = this.f160e;
        if (u0Var != null) {
            return u0Var.a;
        }
        return null;
    }

    PorterDuff.Mode d() {
        u0 u0Var = this.f160e;
        if (u0Var != null) {
            return u0Var.b;
        }
        return null;
    }

    void e(AttributeSet attributeSet, int i) {
        w0 w0VarU = w0.u(this.a.getContext(), attributeSet, d.a.j.ViewBackgroundHelper, i, 0);
        try {
            if (w0VarU.r(d.a.j.ViewBackgroundHelper_android_background)) {
                this.c = w0VarU.n(d.a.j.ViewBackgroundHelper_android_background, -1);
                ColorStateList colorStateListF = this.b.f(this.a.getContext(), this.c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            if (w0VarU.r(d.a.j.ViewBackgroundHelper_backgroundTint)) {
                d.f.k.r.g0(this.a, w0VarU.c(d.a.j.ViewBackgroundHelper_backgroundTint));
            }
            if (w0VarU.r(d.a.j.ViewBackgroundHelper_backgroundTintMode)) {
                d.f.k.r.h0(this.a, e0.e(w0VarU.k(d.a.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            w0VarU.v();
        }
    }

    void f(Drawable drawable) {
        this.c = -1;
        h(null);
        b();
    }

    void g(int i) {
        this.c = i;
        j jVar = this.b;
        h(jVar != null ? jVar.f(this.a.getContext(), i) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f159d == null) {
                this.f159d = new u0();
            }
            u0 u0Var = this.f159d;
            u0Var.a = colorStateList;
            u0Var.f213d = true;
        } else {
            this.f159d = null;
        }
        b();
    }

    void i(ColorStateList colorStateList) {
        if (this.f160e == null) {
            this.f160e = new u0();
        }
        u0 u0Var = this.f160e;
        u0Var.a = colorStateList;
        u0Var.f213d = true;
        b();
    }

    void j(PorterDuff.Mode mode) {
        if (this.f160e == null) {
            this.f160e = new u0();
        }
        u0 u0Var = this.f160e;
        u0Var.b = mode;
        u0Var.c = true;
        b();
    }
}
