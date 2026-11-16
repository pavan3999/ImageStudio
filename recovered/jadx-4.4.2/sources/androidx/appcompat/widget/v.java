package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: loaded from: classes.dex */
class v extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SeekBar f214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ColorStateList f216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f217g;
    private boolean h;
    private boolean i;

    v(SeekBar seekBar) {
        super(seekBar);
        this.f216f = null;
        this.f217g = null;
        this.h = false;
        this.i = false;
        this.f214d = seekBar;
    }

    private void f() {
        if (this.f215e != null) {
            if (this.h || this.i) {
                Drawable drawableR = androidx.core.graphics.drawable.a.r(this.f215e.mutate());
                this.f215e = drawableR;
                if (this.h) {
                    androidx.core.graphics.drawable.a.o(drawableR, this.f216f);
                }
                if (this.i) {
                    androidx.core.graphics.drawable.a.p(this.f215e, this.f217g);
                }
                if (this.f215e.isStateful()) {
                    this.f215e.setState(this.f214d.getDrawableState());
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.r
    void c(AttributeSet attributeSet, int i) {
        super.c(attributeSet, i);
        w0 w0VarU = w0.u(this.f214d.getContext(), attributeSet, d.a.j.AppCompatSeekBar, i, 0);
        Drawable drawableH = w0VarU.h(d.a.j.AppCompatSeekBar_android_thumb);
        if (drawableH != null) {
            this.f214d.setThumb(drawableH);
        }
        j(w0VarU.g(d.a.j.AppCompatSeekBar_tickMark));
        if (w0VarU.r(d.a.j.AppCompatSeekBar_tickMarkTintMode)) {
            this.f217g = e0.e(w0VarU.k(d.a.j.AppCompatSeekBar_tickMarkTintMode, -1), this.f217g);
            this.i = true;
        }
        if (w0VarU.r(d.a.j.AppCompatSeekBar_tickMarkTint)) {
            this.f216f = w0VarU.c(d.a.j.AppCompatSeekBar_tickMarkTint);
            this.h = true;
        }
        w0VarU.v();
        f();
    }

    void g(Canvas canvas) {
        if (this.f215e != null) {
            int max = this.f214d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f215e.getIntrinsicWidth();
                int intrinsicHeight = this.f215e.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f215e.setBounds(-i, -i2, i, i2);
                float width = ((this.f214d.getWidth() - this.f214d.getPaddingLeft()) - this.f214d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f214d.getPaddingLeft(), this.f214d.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f215e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    void h() {
        Drawable drawable = this.f215e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f214d.getDrawableState())) {
            this.f214d.invalidateDrawable(drawable);
        }
    }

    void i() {
        Drawable drawable = this.f215e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.f215e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f215e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f214d);
            androidx.core.graphics.drawable.a.m(drawable, d.f.k.r.v(this.f214d));
            if (drawable.isStateful()) {
                drawable.setState(this.f214d.getDrawableState());
            }
            f();
        }
        this.f214d.invalidate();
    }
}
