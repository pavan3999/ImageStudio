package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes.dex */
class i {
    private final CompoundButton a;
    private ColorStateList b = null;
    private PorterDuff.Mode c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f172d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f173e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f174f;

    i(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    void a() {
        Drawable drawableA = androidx.core.widget.c.a(this.a);
        if (drawableA != null) {
            if (this.f172d || this.f173e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawableA).mutate();
                if (this.f172d) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.b);
                }
                if (this.f173e) {
                    androidx.core.graphics.drawable.a.p(drawableMutate, this.c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.a.getDrawableState());
                }
                this.a.setButtonDrawable(drawableMutate);
            }
        }
    }

    int b(int i) {
        Drawable drawableA;
        return (Build.VERSION.SDK_INT >= 17 || (drawableA = androidx.core.widget.c.a(this.a)) == null) ? i : i + drawableA.getIntrinsicWidth();
    }

    ColorStateList c() {
        return this.b;
    }

    PorterDuff.Mode d() {
        return this.c;
    }

    void e(AttributeSet attributeSet, int i) {
        boolean z;
        int resourceId;
        int resourceId2;
        TypedArray typedArrayObtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, d.a.j.CompoundButton, i, 0);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(d.a.j.CompoundButton_buttonCompat) || (resourceId2 = typedArrayObtainStyledAttributes.getResourceId(d.a.j.CompoundButton_buttonCompat, 0)) == 0) {
                z = false;
            } else {
                try {
                    this.a.setButtonDrawable(d.a.k.a.a.d(this.a.getContext(), resourceId2));
                    z = true;
                } catch (Resources.NotFoundException unused) {
                    z = false;
                }
            }
            if (!z && typedArrayObtainStyledAttributes.hasValue(d.a.j.CompoundButton_android_button) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(d.a.j.CompoundButton_android_button, 0)) != 0) {
                this.a.setButtonDrawable(d.a.k.a.a.d(this.a.getContext(), resourceId));
            }
            if (typedArrayObtainStyledAttributes.hasValue(d.a.j.CompoundButton_buttonTint)) {
                androidx.core.widget.c.c(this.a, typedArrayObtainStyledAttributes.getColorStateList(d.a.j.CompoundButton_buttonTint));
            }
            if (typedArrayObtainStyledAttributes.hasValue(d.a.j.CompoundButton_buttonTintMode)) {
                androidx.core.widget.c.d(this.a, e0.e(typedArrayObtainStyledAttributes.getInt(d.a.j.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    void f() {
        if (this.f174f) {
            this.f174f = false;
        } else {
            this.f174f = true;
            a();
        }
    }

    void g(ColorStateList colorStateList) {
        this.b = colorStateList;
        this.f172d = true;
        a();
    }

    void h(PorterDuff.Mode mode) {
        this.c = mode;
        this.f173e = true;
        a();
    }
}
