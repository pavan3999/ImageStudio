package e.a.a.a.n;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import e.a.a.a.a0.k;
import e.a.a.a.a0.n;

/* JADX INFO: loaded from: classes.dex */
public class a extends d.c.a.a implements Checkable, n {
    private static final int[] l = {R.attr.state_checkable};
    private static final int[] m = {R.attr.state_checked};
    private static final int[] n = {e.a.a.a.b.state_dragged};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f922g;
    private boolean h;
    private boolean i;
    private boolean j;
    private InterfaceC0067a k;

    /* JADX INFO: renamed from: e.a.a.a.n.a$a, reason: collision with other inner class name */
    public interface InterfaceC0067a {
        void a(a aVar, boolean z);
    }

    private void d() {
        if (Build.VERSION.SDK_INT <= 26) {
            return;
        }
        this.f922g.a();
        throw null;
    }

    public boolean e() {
        b bVar = this.f922g;
        if (bVar == null) {
            return false;
        }
        bVar.o();
        throw null;
    }

    public boolean f() {
        return this.j;
    }

    @Override // d.c.a.a
    public ColorStateList getCardBackgroundColor() {
        this.f922g.c();
        throw null;
    }

    float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        this.f922g.d();
        throw null;
    }

    public ColorStateList getCheckedIconTint() {
        this.f922g.e();
        throw null;
    }

    @Override // d.c.a.a
    public int getContentPaddingBottom() {
        this.f922g.m();
        throw null;
    }

    @Override // d.c.a.a
    public int getContentPaddingLeft() {
        this.f922g.m();
        throw null;
    }

    @Override // d.c.a.a
    public int getContentPaddingRight() {
        this.f922g.m();
        throw null;
    }

    @Override // d.c.a.a
    public int getContentPaddingTop() {
        this.f922g.m();
        throw null;
    }

    public float getProgress() {
        this.f922g.g();
        throw null;
    }

    @Override // d.c.a.a
    public float getRadius() {
        this.f922g.f();
        throw null;
    }

    public ColorStateList getRippleColor() {
        this.f922g.h();
        throw null;
    }

    public k getShapeAppearanceModel() {
        this.f922g.i();
        throw null;
    }

    @Deprecated
    public int getStrokeColor() {
        this.f922g.j();
        throw null;
    }

    public ColorStateList getStrokeColorStateList() {
        this.f922g.k();
        throw null;
    }

    public int getStrokeWidth() {
        this.f922g.l();
        throw null;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f922g.b();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 3);
        if (e()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, l);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, m);
        }
        if (f()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, n);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(d.c.a.a.class.getName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(d.c.a.a.class.getName());
        accessibilityNodeInfo.setCheckable(e());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // d.c.a.a, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f922g.p(getMeasuredWidth(), getMeasuredHeight());
        throw null;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.h) {
            this.f922g.n();
            throw null;
        }
    }

    void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // d.c.a.a
    public void setCardBackgroundColor(int i) {
        this.f922g.q(ColorStateList.valueOf(i));
        throw null;
    }

    @Override // d.c.a.a
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f922g.q(colorStateList);
        throw null;
    }

    @Override // d.c.a.a
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        this.f922g.B();
        throw null;
    }

    public void setCheckable(boolean z) {
        this.f922g.r(z);
        throw null;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.i != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f922g.s(drawable);
        throw null;
    }

    public void setCheckedIconResource(int i) {
        this.f922g.s(d.a.k.a.a.d(getContext(), i));
        throw null;
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.f922g.t(colorStateList);
        throw null;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        this.f922g.A();
        throw null;
    }

    public void setDragged(boolean z) {
        if (this.j != z) {
            this.j = z;
            refreshDrawableState();
            d();
            invalidate();
        }
    }

    @Override // d.c.a.a
    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.f922g.C();
        throw null;
    }

    public void setOnCheckedChangeListener(InterfaceC0067a interfaceC0067a) {
        this.k = interfaceC0067a;
    }

    @Override // d.c.a.a
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.f922g.C();
        throw null;
    }

    public void setProgress(float f2) {
        this.f922g.v(f2);
        throw null;
    }

    @Override // d.c.a.a
    public void setRadius(float f2) {
        super.setRadius(f2);
        this.f922g.u(f2);
        throw null;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.f922g.w(colorStateList);
        throw null;
    }

    public void setRippleColorResource(int i) {
        this.f922g.w(d.a.k.a.a.c(getContext(), i));
        throw null;
    }

    @Override // e.a.a.a.a0.n
    public void setShapeAppearanceModel(k kVar) {
        this.f922g.x(kVar);
        throw null;
    }

    public void setStrokeColor(int i) {
        this.f922g.y(ColorStateList.valueOf(i));
        throw null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f922g.y(colorStateList);
        throw null;
    }

    public void setStrokeWidth(int i) {
        this.f922g.z(i);
        throw null;
    }

    @Override // d.c.a.a
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.f922g.C();
        throw null;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (e() && isEnabled()) {
            this.i = !this.i;
            refreshDrawableState();
            d();
            InterfaceC0067a interfaceC0067a = this.k;
            if (interfaceC0067a != null) {
                interfaceC0067a.a(this, this.i);
            }
        }
    }
}
