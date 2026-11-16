package com.redlee90.imagekitchenforandroid;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class TouchImageView extends ImageView {
    Matrix b;
    int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    PointF f676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    PointF f677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f679g;
    float[] h;
    int i;
    int j;
    float k;
    protected float l;
    protected float m;
    int n;
    ScaleGestureDetector o;

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            TouchImageView.this.o.onTouchEvent(motionEvent);
            PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
            int action = motionEvent.getAction();
            if (action == 0) {
                TouchImageView.this.f676d.set(pointF);
                TouchImageView touchImageView = TouchImageView.this;
                touchImageView.f677e.set(touchImageView.f676d);
                TouchImageView.this.c = 1;
            } else if (action == 1) {
                TouchImageView touchImageView2 = TouchImageView.this;
                touchImageView2.c = 0;
                int iAbs = (int) Math.abs(pointF.x - touchImageView2.f677e.x);
                int iAbs2 = (int) Math.abs(pointF.y - TouchImageView.this.f677e.y);
                if (iAbs < 3 && iAbs2 < 3) {
                    TouchImageView.this.performClick();
                }
            } else if (action == 2) {
                TouchImageView touchImageView3 = TouchImageView.this;
                if (touchImageView3.c == 1) {
                    float f2 = pointF.x;
                    PointF pointF2 = touchImageView3.f676d;
                    float f3 = f2 - pointF2.x;
                    float f4 = pointF.y - pointF2.y;
                    float fB = touchImageView3.b(f3, touchImageView3.i, touchImageView3.l * touchImageView3.k);
                    TouchImageView touchImageView4 = TouchImageView.this;
                    TouchImageView.this.b.postTranslate(fB, touchImageView4.b(f4, touchImageView4.j, touchImageView4.m * touchImageView4.k));
                    TouchImageView.this.a();
                    TouchImageView.this.f676d.set(pointF.x, pointF.y);
                }
            } else if (action == 6) {
                TouchImageView.this.c = 0;
            }
            TouchImageView touchImageView5 = TouchImageView.this;
            touchImageView5.setImageMatrix(touchImageView5.b);
            TouchImageView.this.invalidate();
            return true;
        }
    }

    private class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private b() {
        }

        /* synthetic */ b(TouchImageView touchImageView, a aVar) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:4:0x0012 A[PHI: r4
          0x0012: PHI (r4v4 float) = (r4v0 float), (r4v1 float) binds: [B:3:0x0010, B:6:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            Matrix matrix;
            float focusX;
            float focusY;
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            TouchImageView touchImageView = TouchImageView.this;
            float f2 = touchImageView.k;
            float f3 = f2 * scaleFactor;
            touchImageView.k = f3;
            float f4 = touchImageView.f679g;
            if (f3 > f4) {
                touchImageView.k = f4;
                scaleFactor = f4 / f2;
            } else {
                f4 = touchImageView.f678f;
                if (f3 < f4) {
                    touchImageView.k = f4;
                    scaleFactor = f4 / f2;
                }
            }
            TouchImageView touchImageView2 = TouchImageView.this;
            float f5 = touchImageView2.l;
            float f6 = touchImageView2.k;
            if (f5 * f6 <= touchImageView2.i || touchImageView2.m * f6 <= touchImageView2.j) {
                TouchImageView touchImageView3 = TouchImageView.this;
                matrix = touchImageView3.b;
                focusX = touchImageView3.i / 2;
                focusY = touchImageView3.j / 2;
            } else {
                matrix = touchImageView2.b;
                focusX = scaleGestureDetector.getFocusX();
                focusY = scaleGestureDetector.getFocusY();
            }
            matrix.postScale(scaleFactor, scaleFactor, focusX, focusY);
            TouchImageView.this.a();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.c = 2;
            return true;
        }
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.f676d = new PointF();
        this.f677e = new PointF();
        this.f678f = 1.0f;
        this.f679g = 3.0f;
        this.k = 1.0f;
        d(context);
    }

    private void d(Context context) {
        super.setClickable(true);
        this.o = new ScaleGestureDetector(context, new b(this, null));
        Matrix matrix = new Matrix();
        this.b = matrix;
        this.h = new float[9];
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
        setOnTouchListener(new a());
    }

    void a() {
        this.b.getValues(this.h);
        float[] fArr = this.h;
        float f2 = fArr[2];
        float f3 = fArr[5];
        float fC = c(f2, this.i, this.l * this.k);
        float fC2 = c(f3, this.j, this.m * this.k);
        if (fC == 0.0f && fC2 == 0.0f) {
            return;
        }
        this.b.postTranslate(fC, fC2);
    }

    float b(float f2, float f3, float f4) {
        if (f4 <= f3) {
            return 0.0f;
        }
        return f2;
    }

    float c(float f2, float f3, float f4) {
        float f5;
        float f6 = f3 - f4;
        if (f4 <= f3) {
            f5 = f6;
            f6 = 0.0f;
        } else {
            f5 = 0.0f;
        }
        if (f2 < f6) {
            return (-f2) + f6;
        }
        if (f2 > f5) {
            return (-f2) + f5;
        }
        return 0.0f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        this.i = View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        this.j = size;
        int i4 = this.n;
        if ((i4 == this.i && i4 == size) || this.i == 0 || (i3 = this.j) == 0) {
            return;
        }
        this.n = i3;
        if (this.k == 1.0f) {
            Drawable drawable = getDrawable();
            if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
                return;
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Log.d("bmSize", "bmWidth: " + intrinsicWidth + " bmHeight : " + intrinsicHeight);
            float f2 = (float) intrinsicWidth;
            float f3 = (float) intrinsicHeight;
            float fMin = Math.min(((float) this.i) / f2, ((float) this.j) / f3);
            this.b.setScale(fMin, fMin);
            float f4 = (((float) this.j) - (f3 * fMin)) / 2.0f;
            float f5 = (this.i - (fMin * f2)) / 2.0f;
            this.b.postTranslate(f5, f4);
            this.l = this.i - (f5 * 2.0f);
            this.m = this.j - (f4 * 2.0f);
            setImageMatrix(this.b);
        }
        a();
    }

    public void setMaxZoom(float f2) {
        this.f679g = f2;
    }
}
