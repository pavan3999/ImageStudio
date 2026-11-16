package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.f;
import androidx.core.widget.i;
import com.google.android.material.internal.g;
import com.google.android.material.internal.h;
import d.f.k.r;
import e.a.a.a.a0.n;
import e.a.a.a.j;
import e.a.a.a.k;
import e.a.a.a.x.c;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends f implements Checkable, n {
    private static final int[] p = {R.attr.state_checkable};
    private static final int[] q = {R.attr.state_checked};
    private static final int r = j.Widget_MaterialComponents_Button;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.material.button.a f555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinkedHashSet<a> f556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f558g;
    private ColorStateList h;
    private Drawable i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private boolean n;
    private int o;

    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    interface b {
        void a(MaterialButton materialButton, boolean z);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.a.a.a.b.materialButtonStyle);
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        super(g.f(context, attributeSet, i, r), attributeSet, i);
        this.f556e = new LinkedHashSet<>();
        this.m = false;
        this.n = false;
        Context context2 = getContext();
        TypedArray typedArrayK = g.k(context2, attributeSet, k.MaterialButton, i, r, new int[0]);
        this.l = typedArrayK.getDimensionPixelSize(k.MaterialButton_iconPadding, 0);
        this.f558g = h.c(typedArrayK.getInt(k.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.h = c.a(getContext(), typedArrayK, k.MaterialButton_iconTint);
        this.i = c.d(getContext(), typedArrayK, k.MaterialButton_icon);
        this.o = typedArrayK.getInteger(k.MaterialButton_iconGravity, 1);
        this.j = typedArrayK.getDimensionPixelSize(k.MaterialButton_iconSize, 0);
        com.google.android.material.button.a aVar = new com.google.android.material.button.a(this, e.a.a.a.a0.k.e(context2, attributeSet, i, r).m());
        this.f555d = aVar;
        aVar.o(typedArrayK);
        typedArrayK.recycle();
        setCompoundDrawablePadding(this.l);
        e(this.i != null);
    }

    private boolean b() {
        return r.v(this) == 1;
    }

    private boolean c() {
        com.google.android.material.button.a aVar = this.f555d;
        return (aVar == null || aVar.m()) ? false : true;
    }

    private void d(boolean z) {
        if (z) {
            i.i(this, this.i, null, null, null);
        } else {
            i.i(this, null, null, this.i, null);
        }
    }

    private void e(boolean z) {
        Drawable drawable = this.i;
        boolean z2 = false;
        if (drawable != null) {
            Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            this.i = drawableMutate;
            androidx.core.graphics.drawable.a.o(drawableMutate, this.h);
            PorterDuff.Mode mode = this.f558g;
            if (mode != null) {
                androidx.core.graphics.drawable.a.p(this.i, mode);
            }
            int intrinsicWidth = this.j;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.i.getIntrinsicWidth();
            }
            int intrinsicHeight = this.j;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.i;
            int i = this.k;
            drawable2.setBounds(i, 0, intrinsicWidth + i, intrinsicHeight);
        }
        int i2 = this.o;
        boolean z3 = i2 == 1 || i2 == 2;
        if (z) {
            d(z3);
            return;
        }
        Drawable[] drawableArrA = i.a(this);
        Drawable drawable3 = drawableArrA[0];
        Drawable drawable4 = drawableArrA[2];
        if ((z3 && drawable3 != this.i) || (!z3 && drawable4 != this.i)) {
            z2 = true;
        }
        if (z2) {
            d(z3);
        }
    }

    private void f() {
        if (this.i == null || getLayout() == null) {
            return;
        }
        int i = this.o;
        if (i == 1 || i == 3) {
            this.k = 0;
            e(false);
            return;
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        int iMin = Math.min((int) paint.measureText(string), getLayout().getEllipsizedWidth());
        int intrinsicWidth = this.j;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.i.getIntrinsicWidth();
        }
        int measuredWidth = (((((getMeasuredWidth() - iMin) - r.z(this)) - intrinsicWidth) - this.l) - r.A(this)) / 2;
        if (b() != (this.o == 4)) {
            measuredWidth = -measuredWidth;
        }
        if (this.k != measuredWidth) {
            this.k = measuredWidth;
            e(false);
        }
    }

    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    public boolean a() {
        com.google.android.material.button.a aVar = this.f555d;
        return aVar != null && aVar.n();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (c()) {
            return this.f555d.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.i;
    }

    public int getIconGravity() {
        return this.o;
    }

    public int getIconPadding() {
        return this.l;
    }

    public int getIconSize() {
        return this.j;
    }

    public ColorStateList getIconTint() {
        return this.h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f558g;
    }

    public ColorStateList getRippleColor() {
        if (c()) {
            return this.f555d.f();
        }
        return null;
    }

    public e.a.a.a.a0.k getShapeAppearanceModel() {
        if (c()) {
            return this.f555d.g();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (c()) {
            return this.f555d.h();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (c()) {
            return this.f555d.i();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.f, d.f.k.q
    public ColorStateList getSupportBackgroundTintList() {
        return c() ? this.f555d.j() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.f, d.f.k.q
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return c() ? this.f555d.k() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.m;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e.a.a.a.a0.h.f(this, this.f555d.d());
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (a()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, p);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, q);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.google.android.material.button.a aVar;
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT != 21 || (aVar = this.f555d) == null) {
            return;
        }
        aVar.B(i4 - i2, i3 - i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        f();
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        f();
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (c()) {
            this.f555d.p(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (c()) {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            } else {
                Log.w("MaterialButton", "Do not set the background; MaterialButton manages its own background drawable.");
                this.f555d.q();
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? d.a.k.a.a.d(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (c()) {
            this.f555d.r(z);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (a() && isEnabled() && this.m != z) {
            this.m = z;
            refreshDrawableState();
            if (this.n) {
                return;
            }
            this.n = true;
            Iterator<a> it = this.f556e.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.m);
            }
            this.n = false;
        }
    }

    public void setCornerRadius(int i) {
        if (c()) {
            this.f555d.s(i);
        }
    }

    public void setCornerRadiusResource(int i) {
        if (c()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        if (c()) {
            this.f555d.d().S(f2);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.i != drawable) {
            this.i = drawable;
            e(true);
        }
    }

    public void setIconGravity(int i) {
        if (this.o != i) {
            this.o = i;
            f();
        }
    }

    public void setIconPadding(int i) {
        if (this.l != i) {
            this.l = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? d.a.k.a.a.d(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.j != i) {
            this.j = i;
            e(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.h != colorStateList) {
            this.h = colorStateList;
            e(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f558g != mode) {
            this.f558g = mode;
            e(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(d.a.k.a.a.c(getContext(), i));
    }

    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    void setOnPressedChangeListenerInternal(b bVar) {
        this.f557f = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        b bVar = this.f557f;
        if (bVar != null) {
            bVar.a(this, z);
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (c()) {
            this.f555d.t(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        if (c()) {
            setRippleColor(d.a.k.a.a.c(getContext(), i));
        }
    }

    @Override // e.a.a.a.a0.n
    public void setShapeAppearanceModel(e.a.a.a.a0.k kVar) {
        if (!c()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f555d.u(kVar);
    }

    void setShouldDrawSurfaceColorStroke(boolean z) {
        if (c()) {
            this.f555d.v(z);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (c()) {
            this.f555d.w(colorStateList);
        }
    }

    public void setStrokeColorResource(int i) {
        if (c()) {
            setStrokeColor(d.a.k.a.a.c(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (c()) {
            this.f555d.x(i);
        }
    }

    public void setStrokeWidthResource(int i) {
        if (c()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.f, d.f.k.q
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (c()) {
            this.f555d.y(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.f, d.f.k.q
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (c()) {
            this.f555d.z(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.m);
    }
}
