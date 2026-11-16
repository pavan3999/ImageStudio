package d.c.a;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class a extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final f f717f;
    private boolean b;
    private boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Rect f718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e f719e;

    static {
        f bVar;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            bVar = new c();
        } else {
            bVar = i >= 17 ? new b() : new d();
        }
        f717f = bVar;
        f717f.l();
    }

    public ColorStateList getCardBackgroundColor() {
        return f717f.i(this.f719e);
    }

    public float getCardElevation() {
        return f717f.f(this.f719e);
    }

    public int getContentPaddingBottom() {
        return this.f718d.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f718d.left;
    }

    public int getContentPaddingRight() {
        return this.f718d.right;
    }

    public int getContentPaddingTop() {
        return this.f718d.top;
    }

    public float getMaxCardElevation() {
        return f717f.a(this.f719e);
    }

    public boolean getPreventCornerOverlap() {
        return this.c;
    }

    public float getRadius() {
        return f717f.b(this.f719e);
    }

    public boolean getUseCompatPadding() {
        return this.b;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!(f717f instanceof c)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f717f.g(this.f719e)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f717f.e(this.f719e)), View.MeasureSpec.getSize(i2)), mode2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        f717f.d(this.f719e, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f717f.d(this.f719e, colorStateList);
    }

    public void setCardElevation(float f2) {
        f717f.j(this.f719e, f2);
    }

    public void setMaxCardElevation(float f2) {
        f717f.k(this.f719e, f2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.c) {
            this.c = z;
            f717f.c(this.f719e);
        }
    }

    public void setRadius(float f2) {
        f717f.m(this.f719e, f2);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.b != z) {
            this.b = z;
            f717f.h(this.f719e);
        }
    }
}
