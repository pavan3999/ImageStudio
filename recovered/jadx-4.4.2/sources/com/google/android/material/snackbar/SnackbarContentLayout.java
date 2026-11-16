package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import d.f.k.r;
import e.a.a.a.d;
import e.a.a.a.f;
import e.a.a.a.k;

/* JADX INFO: loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements a {
    private TextView b;
    private Button c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f640e;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.SnackbarLayout);
        this.f639d = typedArrayObtainStyledAttributes.getDimensionPixelSize(k.SnackbarLayout_android_maxWidth, -1);
        this.f640e = typedArrayObtainStyledAttributes.getDimensionPixelSize(k.SnackbarLayout_maxActionInlineWidth, -1);
        typedArrayObtainStyledAttributes.recycle();
    }

    private static void d(View view, int i, int i2) {
        if (r.L(view)) {
            r.p0(view, r.A(view), i, r.z(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    private boolean e(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.b.getPaddingTop() == i2 && this.b.getPaddingBottom() == i3) {
            return z;
        }
        d(this.b, i2, i3);
        return true;
    }

    @Override // com.google.android.material.snackbar.a
    public void a(int i, int i2) {
        this.b.setAlpha(1.0f);
        long j = i2;
        long j2 = i;
        this.b.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        if (this.c.getVisibility() == 0) {
            this.c.setAlpha(1.0f);
            this.c.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    @Override // com.google.android.material.snackbar.a
    public void b(int i, int i2) {
        this.b.setAlpha(0.0f);
        long j = i2;
        long j2 = i;
        this.b.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        if (this.c.getVisibility() == 0) {
            this.c.setAlpha(0.0f);
            this.c.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    void c(float f2) {
        if (f2 != 1.0f) {
            this.c.setTextColor(e.a.a.a.q.a.f(e.a.a.a.q.a.c(this, e.a.a.a.b.colorSurface), this.c.getCurrentTextColor(), f2));
        }
    }

    public Button getActionView() {
        return this.c;
    }

    public TextView getMessageView() {
        return this.b;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.b = (TextView) findViewById(f.snackbar_text);
        this.c = (Button) findViewById(f.snackbar_action);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0060  */
    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f639d > 0) {
            int measuredWidth = getMeasuredWidth();
            int i3 = this.f639d;
            if (measuredWidth > i3) {
                i = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                super.onMeasure(i, i2);
            }
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical);
        boolean z = false;
        boolean z2 = this.b.getLayout().getLineCount() > 1;
        if (!z2 || this.f640e <= 0 || this.c.getMeasuredWidth() <= this.f640e) {
            if (!z2) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (e(0, dimensionPixelSize, dimensionPixelSize)) {
                z = true;
            }
        } else if (e(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            z = true;
        }
        if (z) {
            super.onMeasure(i, i2);
        }
    }
}
