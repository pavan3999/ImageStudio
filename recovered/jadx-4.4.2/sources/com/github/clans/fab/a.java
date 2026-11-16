package com.github.clans.fab;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class a extends TextView {
    private static final Xfermode t = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    private int b;
    private int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f507g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private FloatingActionButton n;
    private Animation o;
    private Animation p;
    private boolean q;
    private boolean r;
    GestureDetector s;

    /* JADX INFO: renamed from: com.github.clans.fab.a$a, reason: collision with other inner class name */
    class C0020a extends ViewOutlineProvider {
        C0020a(a aVar) {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setOval(0, 0, view.getWidth(), view.getHeight());
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            a.this.s();
            if (a.this.n != null) {
                a.this.n.z();
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            a.this.t();
            if (a.this.n != null) {
                a.this.n.A();
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    private class c extends Drawable {
        private Paint a;
        private Paint b;

        private c() {
            this.a = new Paint(1);
            this.b = new Paint(1);
            a();
        }

        /* synthetic */ c(a aVar, C0020a c0020a) {
            this();
        }

        private void a() {
            a.this.setLayerType(1, null);
            this.a.setStyle(Paint.Style.FILL);
            this.a.setColor(a.this.j);
            this.b.setXfermode(a.t);
            if (a.this.isInEditMode()) {
                return;
            }
            this.a.setShadowLayer(a.this.b, a.this.c, a.this.f504d, a.this.f505e);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            RectF rectF = new RectF(a.this.b + Math.abs(a.this.c), a.this.b + Math.abs(a.this.f504d), a.this.h, a.this.i);
            canvas.drawRoundRect(rectF, a.this.m, a.this.m, this.a);
            canvas.drawRoundRect(rectF, a.this.m, a.this.m, this.b);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public a(Context context) {
        super(context);
        this.f507g = true;
        this.r = true;
        this.s = new GestureDetector(getContext(), new b());
    }

    private int k() {
        if (this.i == 0) {
            this.i = getMeasuredHeight();
        }
        return getMeasuredHeight() + m();
    }

    private int l() {
        if (this.h == 0) {
            this.h = getMeasuredWidth();
        }
        return getMeasuredWidth() + n();
    }

    @TargetApi(21)
    private Drawable o() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, p(this.k));
        stateListDrawable.addState(new int[0], p(this.j));
        if (!g.c()) {
            this.f506f = stateListDrawable;
            return stateListDrawable;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{this.l}), stateListDrawable, null);
        setOutlineProvider(new C0020a(this));
        setClipToOutline(true);
        this.f506f = rippleDrawable;
        return rippleDrawable;
    }

    private Drawable p(int i) {
        int i2 = this.m;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{i2, i2, i2, i2, i2, i2, i2, i2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    @TargetApi(21)
    private void setBackgroundCompat(Drawable drawable) {
        if (g.b()) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    private void setShadow(FloatingActionButton floatingActionButton) {
        this.f505e = floatingActionButton.getShadowColor();
        this.b = floatingActionButton.getShadowRadius();
        this.c = floatingActionButton.getShadowXOffset();
        this.f504d = floatingActionButton.getShadowYOffset();
        this.f507g = floatingActionButton.t();
    }

    private void u() {
        if (this.p != null) {
            this.o.cancel();
            startAnimation(this.p);
        }
    }

    private void v() {
        if (this.o != null) {
            this.p.cancel();
            startAnimation(this.o);
        }
    }

    int m() {
        if (this.f507g) {
            return this.b + Math.abs(this.f504d);
        }
        return 0;
    }

    int n() {
        if (this.f507g) {
            return this.b + Math.abs(this.c);
        }
        return 0;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(l(), k());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        FloatingActionButton floatingActionButton = this.n;
        if (floatingActionButton == null || floatingActionButton.getOnClickListener() == null || !this.n.isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            t();
            this.n.A();
        }
        this.s.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    void q(boolean z) {
        if (z) {
            u();
        }
        setVisibility(4);
    }

    boolean r() {
        return this.r;
    }

    @TargetApi(21)
    void s() {
        if (this.q) {
            this.f506f = getBackground();
        }
        Drawable drawable = this.f506f;
        if (drawable instanceof StateListDrawable) {
            ((StateListDrawable) drawable).setState(new int[]{R.attr.state_pressed});
        } else if (g.c()) {
            Drawable drawable2 = this.f506f;
            if (drawable2 instanceof RippleDrawable) {
                RippleDrawable rippleDrawable = (RippleDrawable) drawable2;
                rippleDrawable.setState(new int[]{R.attr.state_enabled, R.attr.state_pressed});
                rippleDrawable.setHotspot(getMeasuredWidth() / 2, getMeasuredHeight() / 2);
                rippleDrawable.setVisible(true, true);
            }
        }
        setPressed(true);
    }

    void setCornerRadius(int i) {
        this.m = i;
    }

    void setFab(FloatingActionButton floatingActionButton) {
        this.n = floatingActionButton;
        setShadow(floatingActionButton);
    }

    void setHandleVisibilityChanges(boolean z) {
        this.r = z;
    }

    void setHideAnimation(Animation animation) {
        this.p = animation;
    }

    void setShowAnimation(Animation animation) {
        this.o = animation;
    }

    void setShowShadow(boolean z) {
        this.f507g = z;
    }

    void setUsingStyle(boolean z) {
        this.q = z;
    }

    @TargetApi(21)
    void t() {
        if (this.q) {
            this.f506f = getBackground();
        }
        Drawable drawable = this.f506f;
        if (drawable instanceof StateListDrawable) {
            ((StateListDrawable) drawable).setState(new int[0]);
        } else if (g.c()) {
            Drawable drawable2 = this.f506f;
            if (drawable2 instanceof RippleDrawable) {
                RippleDrawable rippleDrawable = (RippleDrawable) drawable2;
                rippleDrawable.setState(new int[0]);
                rippleDrawable.setHotspot(getMeasuredWidth() / 2, getMeasuredHeight() / 2);
                rippleDrawable.setVisible(true, true);
            }
        }
        setPressed(false);
    }

    void w(int i, int i2, int i3) {
        this.j = i;
        this.k = i2;
        this.l = i3;
    }

    void x(boolean z) {
        if (z) {
            v();
        }
        setVisibility(0);
    }

    void y() {
        LayerDrawable layerDrawable;
        if (this.f507g) {
            layerDrawable = new LayerDrawable(new Drawable[]{new c(this, null), o()});
            layerDrawable.setLayerInset(1, this.b + Math.abs(this.c), this.b + Math.abs(this.f504d), this.b + Math.abs(this.c), this.b + Math.abs(this.f504d));
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{o()});
        }
        setBackgroundCompat(layerDrawable);
    }
}
