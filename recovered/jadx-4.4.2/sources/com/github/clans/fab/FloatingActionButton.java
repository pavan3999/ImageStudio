package com.github.clans.fab;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton extends ImageButton {
    private static final Xfermode W = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    private float A;
    private boolean B;
    private RectF C;
    private Paint D;
    private Paint E;
    private boolean F;
    private long G;
    private float H;
    private long I;
    private double J;
    private boolean K;
    private int L;
    private float M;
    private float N;
    private float O;
    private int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private int T;
    private boolean U;
    GestureDetector V;
    int b;
    boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f490g;
    private int h;
    private int i;
    private int j;
    private int k;
    private Drawable l;
    private int m;
    private Animation n;
    private Animation o;
    private String p;
    private View.OnClickListener q;
    private Drawable r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private boolean y;
    private float z;

    class a extends ViewOutlineProvider {
        a(FloatingActionButton floatingActionButton) {
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
            com.github.clans.fab.a aVar = (com.github.clans.fab.a) FloatingActionButton.this.getTag(com.github.clans.fab.e.fab_label);
            if (aVar != null) {
                aVar.s();
            }
            FloatingActionButton.this.z();
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            com.github.clans.fab.a aVar = (com.github.clans.fab.a) FloatingActionButton.this.getTag(com.github.clans.fab.e.fab_label);
            if (aVar != null) {
                aVar.t();
            }
            FloatingActionButton.this.A();
            return super.onSingleTapUp(motionEvent);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FloatingActionButton.this.q != null) {
                FloatingActionButton.this.q.onClick(FloatingActionButton.this);
            }
        }
    }

    private class d extends ShapeDrawable {
        private int a;
        private int b;

        private d(Shape shape) {
            super(shape);
            this.a = FloatingActionButton.this.t() ? FloatingActionButton.this.f488e + Math.abs(FloatingActionButton.this.f489f) : 0;
            this.b = FloatingActionButton.this.t() ? Math.abs(FloatingActionButton.this.f490g) + FloatingActionButton.this.f488e : 0;
            if (FloatingActionButton.this.u) {
                this.a += FloatingActionButton.this.v;
                this.b += FloatingActionButton.this.v;
            }
        }

        /* synthetic */ d(FloatingActionButton floatingActionButton, Shape shape, a aVar) {
            this(shape);
        }

        @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            setBounds(this.a, this.b, FloatingActionButton.this.o() - this.a, FloatingActionButton.this.n() - this.b);
            super.draw(canvas);
        }
    }

    static class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();
        float b;
        float c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f491d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f492e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f493f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f494g;
        int h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        boolean n;
        boolean o;

        static class a implements Parcelable.Creator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i) {
                return new e[i];
            }
        }

        private e(Parcel parcel) {
            super(parcel);
            this.b = parcel.readFloat();
            this.c = parcel.readFloat();
            this.i = parcel.readInt() != 0;
            this.f491d = parcel.readFloat();
            this.f492e = parcel.readInt();
            this.f493f = parcel.readInt();
            this.f494g = parcel.readInt();
            this.h = parcel.readInt();
            this.j = parcel.readInt() != 0;
            this.k = parcel.readInt() != 0;
            this.l = parcel.readInt() != 0;
            this.m = parcel.readInt() != 0;
            this.n = parcel.readInt() != 0;
            this.o = parcel.readInt() != 0;
        }

        /* synthetic */ e(Parcel parcel, a aVar) {
            this(parcel);
        }

        e(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.b);
            parcel.writeFloat(this.c);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeFloat(this.f491d);
            parcel.writeInt(this.f492e);
            parcel.writeInt(this.f493f);
            parcel.writeInt(this.f494g);
            parcel.writeInt(this.h);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeInt(this.k ? 1 : 0);
            parcel.writeInt(this.l ? 1 : 0);
            parcel.writeInt(this.m ? 1 : 0);
            parcel.writeInt(this.n ? 1 : 0);
            parcel.writeInt(this.o ? 1 : 0);
        }
    }

    private class f extends Drawable {
        private Paint a;
        private Paint b;
        private float c;

        private f() {
            this.a = new Paint(1);
            this.b = new Paint(1);
            a();
        }

        /* synthetic */ f(FloatingActionButton floatingActionButton, a aVar) {
            this();
        }

        private void a() {
            FloatingActionButton.this.setLayerType(1, null);
            this.a.setStyle(Paint.Style.FILL);
            this.a.setColor(FloatingActionButton.this.h);
            this.b.setXfermode(FloatingActionButton.W);
            if (!FloatingActionButton.this.isInEditMode()) {
                Paint paint = this.a;
                FloatingActionButton floatingActionButton = FloatingActionButton.this;
                paint.setShadowLayer(floatingActionButton.f488e, floatingActionButton.f489f, floatingActionButton.f490g, floatingActionButton.f487d);
            }
            this.c = FloatingActionButton.this.getCircleSize() / 2;
            if (FloatingActionButton.this.u && FloatingActionButton.this.U) {
                this.c += FloatingActionButton.this.v;
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.drawCircle(FloatingActionButton.this.l(), FloatingActionButton.this.m(), this.c, this.a);
            canvas.drawCircle(FloatingActionButton.this.l(), FloatingActionButton.this.m(), this.c, this.b);
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

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f488e = g.a(getContext(), 4.0f);
        this.f489f = g.a(getContext(), 1.0f);
        this.f490g = g.a(getContext(), 3.0f);
        this.m = g.a(getContext(), 24.0f);
        this.v = g.a(getContext(), 6.0f);
        this.z = -1.0f;
        this.A = -1.0f;
        this.C = new RectF();
        this.D = new Paint(1);
        this.E = new Paint(1);
        this.H = 195.0f;
        this.I = 0L;
        this.K = true;
        this.L = 16;
        this.T = 100;
        this.V = new GestureDetector(getContext(), new b());
        v(context, attributeSet, i);
    }

    private void D() {
        if (this.B) {
            return;
        }
        if (this.z == -1.0f) {
            this.z = getX();
        }
        if (this.A == -1.0f) {
            this.A = getY();
        }
        this.B = true;
    }

    private void G() {
        this.D.setColor(this.x);
        this.D.setStyle(Paint.Style.STROKE);
        this.D.setStrokeWidth(this.v);
        this.E.setColor(this.w);
        this.E.setStyle(Paint.Style.STROKE);
        this.E.setStrokeWidth(this.v);
    }

    private void H() {
        int shadowX = t() ? getShadowX() : 0;
        int shadowY = t() ? getShadowY() : 0;
        int i = this.v;
        this.C = new RectF((i / 2) + shadowX, (i / 2) + shadowY, (o() - shadowX) - (this.v / 2), (n() - shadowY) - (this.v / 2));
    }

    private void K() {
        float x;
        float y;
        if (this.u) {
            x = this.z > getX() ? getX() + this.v : getX() - this.v;
            y = this.A > getY() ? getY() + this.v : getY() - this.v;
        } else {
            x = this.z;
            y = this.A;
        }
        setX(x);
        setY(y);
    }

    private void L(long j) {
        long j2 = this.I;
        if (j2 < 200) {
            this.I = j2 + j;
            return;
        }
        double d2 = this.J;
        double d3 = j;
        Double.isNaN(d3);
        double d4 = d2 + d3;
        this.J = d4;
        if (d4 > 500.0d) {
            this.J = d4 - 500.0d;
            this.I = 0L;
            this.K = !this.K;
        }
        float fCos = (((float) Math.cos(((this.J / 500.0d) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
        float f2 = 270 - this.L;
        if (this.K) {
            this.M = fCos * f2;
            return;
        }
        float f3 = f2 * (1.0f - fCos);
        this.N += this.M - f3;
        this.M = f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCircleSize() {
        return getResources().getDimensionPixelSize(this.b == 0 ? com.github.clans.fab.c.fab_size_normal : com.github.clans.fab.c.fab_size_mini);
    }

    private int getShadowX() {
        return this.f488e + Math.abs(this.f489f);
    }

    private int getShadowY() {
        return this.f488e + Math.abs(this.f490g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float l() {
        return getMeasuredWidth() / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float m() {
        return getMeasuredHeight() / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n() {
        int circleSize = getCircleSize() + p();
        return this.u ? circleSize + (this.v * 2) : circleSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o() {
        int circleSize = getCircleSize() + q();
        return this.u ? circleSize + (this.v * 2) : circleSize;
    }

    private Drawable r(int i) {
        d dVar = new d(this, new OvalShape(), null);
        dVar.getPaint().setColor(i);
        return dVar;
    }

    @TargetApi(21)
    private Drawable s() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, r(this.j));
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, r(this.i));
        stateListDrawable.addState(new int[0], r(this.h));
        if (!g.c()) {
            this.r = stateListDrawable;
            return stateListDrawable;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{this.k}), stateListDrawable, null);
        setOutlineProvider(new a(this));
        setClipToOutline(true);
        this.r = rippleDrawable;
        return rippleDrawable;
    }

    @TargetApi(16)
    private void setBackgroundCompat(Drawable drawable) {
        if (g.b()) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    private void v(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.github.clans.fab.f.FloatingActionButton, i, 0);
        this.h = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.f.FloatingActionButton_fab_colorNormal, -2473162);
        this.i = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.f.FloatingActionButton_fab_colorPressed, -1617853);
        this.j = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.f.FloatingActionButton_fab_colorDisabled, -5592406);
        this.k = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.f.FloatingActionButton_fab_colorRipple, -1711276033);
        this.c = typedArrayObtainStyledAttributes.getBoolean(com.github.clans.fab.f.FloatingActionButton_fab_showShadow, true);
        this.f487d = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.f.FloatingActionButton_fab_shadowColor, 1711276032);
        this.f488e = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.f.FloatingActionButton_fab_shadowRadius, this.f488e);
        this.f489f = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.f.FloatingActionButton_fab_shadowXOffset, this.f489f);
        this.f490g = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.f.FloatingActionButton_fab_shadowYOffset, this.f490g);
        this.b = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.f.FloatingActionButton_fab_size, 0);
        this.p = typedArrayObtainStyledAttributes.getString(com.github.clans.fab.f.FloatingActionButton_fab_label);
        this.R = typedArrayObtainStyledAttributes.getBoolean(com.github.clans.fab.f.FloatingActionButton_fab_progress_indeterminate, false);
        this.w = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.f.FloatingActionButton_fab_progress_color, -16738680);
        this.x = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.f.FloatingActionButton_fab_progress_backgroundColor, 1291845632);
        this.T = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.f.FloatingActionButton_fab_progress_max, this.T);
        this.U = typedArrayObtainStyledAttributes.getBoolean(com.github.clans.fab.f.FloatingActionButton_fab_progress_showBackground, true);
        if (typedArrayObtainStyledAttributes.hasValue(com.github.clans.fab.f.FloatingActionButton_fab_progress)) {
            this.P = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.f.FloatingActionButton_fab_progress, 0);
            this.S = true;
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.github.clans.fab.f.FloatingActionButton_fab_elevationCompat)) {
            float dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.github.clans.fab.f.FloatingActionButton_fab_elevationCompat, 0);
            if (isInEditMode()) {
                setElevation(dimensionPixelOffset);
            } else {
                setElevationCompat(dimensionPixelOffset);
            }
        }
        x(typedArrayObtainStyledAttributes);
        w(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        if (isInEditMode()) {
            if (this.R) {
                setIndeterminate(true);
            } else if (this.S) {
                D();
                F(this.P, false);
            }
        }
        setClickable(true);
    }

    private void w(TypedArray typedArray) {
        this.o = AnimationUtils.loadAnimation(getContext(), typedArray.getResourceId(com.github.clans.fab.f.FloatingActionButton_fab_hideAnimation, com.github.clans.fab.b.fab_scale_down));
    }

    private void x(TypedArray typedArray) {
        this.n = AnimationUtils.loadAnimation(getContext(), typedArray.getResourceId(com.github.clans.fab.f.FloatingActionButton_fab_showAnimation, com.github.clans.fab.b.fab_scale_up));
    }

    @TargetApi(21)
    void A() {
        Drawable drawable = this.r;
        if (drawable instanceof StateListDrawable) {
            ((StateListDrawable) drawable).setState(new int[]{R.attr.state_enabled});
        } else if (g.c()) {
            RippleDrawable rippleDrawable = (RippleDrawable) this.r;
            rippleDrawable.setState(new int[]{R.attr.state_enabled});
            rippleDrawable.setHotspot(l(), m());
            rippleDrawable.setVisible(true, true);
        }
    }

    void B() {
        this.n.cancel();
        startAnimation(this.o);
    }

    void C() {
        this.o.cancel();
        startAnimation(this.n);
    }

    void E(int i, int i2, int i3) {
        this.h = i;
        this.i = i2;
        this.k = i3;
    }

    public synchronized void F(int i, boolean z) {
        if (this.F) {
            return;
        }
        this.P = i;
        this.Q = z;
        if (!this.B) {
            this.S = true;
            return;
        }
        this.u = true;
        this.y = true;
        H();
        D();
        J();
        if (i < 0) {
            i = 0;
        } else if (i > this.T) {
            i = this.T;
        }
        float f2 = i;
        if (f2 == this.O) {
            return;
        }
        this.O = this.T > 0 ? (f2 / this.T) * 360.0f : 0.0f;
        this.G = SystemClock.uptimeMillis();
        if (!z) {
            this.N = this.O;
        }
        invalidate();
    }

    public void I(boolean z) {
        if (y()) {
            if (z) {
                C();
            }
            super.setVisibility(0);
        }
    }

    void J() {
        LayerDrawable layerDrawable = t() ? new LayerDrawable(new Drawable[]{new f(this, null), s(), getIconDrawable()}) : new LayerDrawable(new Drawable[]{s(), getIconDrawable()});
        int iMax = getIconDrawable() != null ? Math.max(getIconDrawable().getIntrinsicWidth(), getIconDrawable().getIntrinsicHeight()) : -1;
        int circleSize = getCircleSize();
        if (iMax <= 0) {
            iMax = this.m;
        }
        int i = (circleSize - iMax) / 2;
        int iAbs = t() ? this.f488e + Math.abs(this.f489f) : 0;
        int iAbs2 = t() ? this.f488e + Math.abs(this.f490g) : 0;
        if (this.u) {
            int i2 = this.v;
            iAbs += i2;
            iAbs2 += i2;
        }
        int i3 = iAbs + i;
        int i4 = iAbs2 + i;
        layerDrawable.setLayerInset(t() ? 2 : 1, i3, i4, i3, i4);
        setBackgroundCompat(layerDrawable);
    }

    public int getButtonSize() {
        return this.b;
    }

    public int getColorDisabled() {
        return this.j;
    }

    public int getColorNormal() {
        return this.h;
    }

    public int getColorPressed() {
        return this.i;
    }

    public int getColorRipple() {
        return this.k;
    }

    Animation getHideAnimation() {
        return this.o;
    }

    protected Drawable getIconDrawable() {
        Drawable drawable = this.l;
        return drawable != null ? drawable : new ColorDrawable(0);
    }

    public String getLabelText() {
        return this.p;
    }

    com.github.clans.fab.a getLabelView() {
        return (com.github.clans.fab.a) getTag(com.github.clans.fab.e.fab_label);
    }

    public int getLabelVisibility() {
        com.github.clans.fab.a labelView = getLabelView();
        if (labelView != null) {
            return labelView.getVisibility();
        }
        return -1;
    }

    public synchronized int getMax() {
        return this.T;
    }

    View.OnClickListener getOnClickListener() {
        return this.q;
    }

    public synchronized int getProgress() {
        return this.F ? 0 : this.P;
    }

    public int getShadowColor() {
        return this.f487d;
    }

    public int getShadowRadius() {
        return this.f488e;
    }

    public int getShadowXOffset() {
        return this.f489f;
    }

    public int getShadowYOffset() {
        return this.f490g;
    }

    Animation getShowAnimation() {
        return this.n;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.u) {
            if (this.U) {
                canvas.drawArc(this.C, 360.0f, 360.0f, false, this.D);
            }
            boolean z = false;
            boolean z2 = true;
            if (this.F) {
                long jUptimeMillis = SystemClock.uptimeMillis() - this.G;
                float f4 = (jUptimeMillis * this.H) / 1000.0f;
                L(jUptimeMillis);
                float f5 = this.N + f4;
                this.N = f5;
                if (f5 > 360.0f) {
                    this.N = f5 - 360.0f;
                }
                this.G = SystemClock.uptimeMillis();
                float f6 = this.N - 90.0f;
                float f7 = this.L + this.M;
                if (isInEditMode()) {
                    f2 = 0.0f;
                    f3 = 135.0f;
                } else {
                    f2 = f6;
                    f3 = f7;
                }
                canvas.drawArc(this.C, f2, f3, false, this.E);
            } else {
                if (this.N != this.O) {
                    float fUptimeMillis = ((SystemClock.uptimeMillis() - this.G) / 1000.0f) * this.H;
                    float f8 = this.N;
                    float f9 = this.O;
                    this.N = f8 > f9 ? Math.max(f8 - fUptimeMillis, f9) : Math.min(f8 + fUptimeMillis, f9);
                    this.G = SystemClock.uptimeMillis();
                    z = true;
                }
                canvas.drawArc(this.C, -90.0f, this.N, false, this.E);
                z2 = z;
            }
            if (z2) {
                invalidate();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(o(), n());
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        this.N = eVar.b;
        this.O = eVar.c;
        this.H = eVar.f491d;
        this.v = eVar.f493f;
        this.w = eVar.f494g;
        this.x = eVar.h;
        this.R = eVar.l;
        this.S = eVar.m;
        this.P = eVar.f492e;
        this.Q = eVar.n;
        this.U = eVar.o;
        this.G = SystemClock.uptimeMillis();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.b = this.N;
        eVar.c = this.O;
        eVar.f491d = this.H;
        eVar.f493f = this.v;
        eVar.f494g = this.w;
        eVar.h = this.x;
        boolean z = this.F;
        eVar.l = z;
        eVar.m = this.u && this.P > 0 && !z;
        eVar.f492e = this.P;
        eVar.n = this.Q;
        eVar.o = this.U;
        return eVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        D();
        if (this.R) {
            setIndeterminate(true);
            this.R = false;
        } else if (this.S) {
            F(this.P, this.Q);
            this.S = false;
        } else if (this.y) {
            K();
            this.y = false;
        }
        super.onSizeChanged(i, i2, i3, i4);
        H();
        G();
        J();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0029  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.q != null && isEnabled()) {
            com.github.clans.fab.a aVar = (com.github.clans.fab.a) getTag(com.github.clans.fab.e.fab_label);
            if (aVar == null) {
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action == 1) {
                if (aVar != null) {
                    aVar.t();
                }
                A();
            } else if (action == 3) {
                if (aVar != null) {
                    aVar.t();
                }
                A();
            }
            this.V.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    int p() {
        if (t()) {
            return getShadowY() * 2;
        }
        return 0;
    }

    int q() {
        if (t()) {
            return getShadowX() * 2;
        }
        return 0;
    }

    public void setButtonSize(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Use @FabSize constants only!");
        }
        if (this.b != i) {
            this.b = i;
            J();
        }
    }

    public void setColorDisabled(int i) {
        if (i != this.j) {
            this.j = i;
            J();
        }
    }

    public void setColorDisabledResId(int i) {
        setColorDisabled(getResources().getColor(i));
    }

    public void setColorNormal(int i) {
        if (this.h != i) {
            this.h = i;
            J();
        }
    }

    public void setColorNormalResId(int i) {
        setColorNormal(getResources().getColor(i));
    }

    public void setColorPressed(int i) {
        if (i != this.i) {
            this.i = i;
            J();
        }
    }

    public void setColorPressedResId(int i) {
        setColorPressed(getResources().getColor(i));
    }

    public void setColorRipple(int i) {
        if (i != this.k) {
            this.k = i;
            J();
        }
    }

    public void setColorRippleResId(int i) {
        setColorRipple(getResources().getColor(i));
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        if (!g.c() || f2 <= 0.0f) {
            return;
        }
        super.setElevation(f2);
        if (!isInEditMode()) {
            this.s = true;
            this.c = false;
        }
        J();
    }

    @TargetApi(21)
    public void setElevationCompat(float f2) {
        this.f487d = 637534208;
        float f3 = f2 / 2.0f;
        this.f488e = Math.round(f3);
        this.f489f = 0;
        if (this.b == 0) {
            f3 = f2;
        }
        this.f490g = Math.round(f3);
        if (!g.c()) {
            this.c = true;
            J();
            return;
        }
        super.setElevation(f2);
        this.t = true;
        this.c = false;
        J();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        com.github.clans.fab.a aVar = (com.github.clans.fab.a) getTag(com.github.clans.fab.e.fab_label);
        if (aVar != null) {
            aVar.setEnabled(z);
        }
    }

    public void setHideAnimation(Animation animation) {
        this.o = animation;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.l != drawable) {
            this.l = drawable;
            J();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        Drawable drawable = getResources().getDrawable(i);
        if (this.l != drawable) {
            this.l = drawable;
            J();
        }
    }

    public synchronized void setIndeterminate(boolean z) {
        if (!z) {
            this.N = 0.0f;
        }
        this.u = z;
        this.y = true;
        this.F = z;
        this.G = SystemClock.uptimeMillis();
        H();
        D();
        J();
    }

    public void setLabelText(String str) {
        this.p = str;
        com.github.clans.fab.a labelView = getLabelView();
        if (labelView != null) {
            labelView.setText(str);
        }
    }

    public void setLabelVisibility(int i) {
        com.github.clans.fab.a labelView = getLabelView();
        if (labelView != null) {
            labelView.setVisibility(i);
            labelView.setHandleVisibilityChanges(i == 0);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && this.t) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin += getShadowX();
            marginLayoutParams.topMargin += getShadowY();
            marginLayoutParams.rightMargin += getShadowX();
            marginLayoutParams.bottomMargin += getShadowY();
        }
        super.setLayoutParams(layoutParams);
    }

    public synchronized void setMax(int i) {
        this.T = i;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.q = onClickListener;
        View view = (View) getTag(com.github.clans.fab.e.fab_label);
        if (view != null) {
            view.setOnClickListener(new c());
        }
    }

    public void setShadowColor(int i) {
        if (this.f487d != i) {
            this.f487d = i;
            J();
        }
    }

    public void setShadowColorResource(int i) {
        int color = getResources().getColor(i);
        if (this.f487d != color) {
            this.f487d = color;
            J();
        }
    }

    public void setShadowRadius(float f2) {
        this.f488e = g.a(getContext(), f2);
        requestLayout();
        J();
    }

    public void setShadowRadius(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        if (this.f488e != dimensionPixelSize) {
            this.f488e = dimensionPixelSize;
            requestLayout();
            J();
        }
    }

    public void setShadowXOffset(float f2) {
        this.f489f = g.a(getContext(), f2);
        requestLayout();
        J();
    }

    public void setShadowXOffset(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        if (this.f489f != dimensionPixelSize) {
            this.f489f = dimensionPixelSize;
            requestLayout();
            J();
        }
    }

    public void setShadowYOffset(float f2) {
        this.f490g = g.a(getContext(), f2);
        requestLayout();
        J();
    }

    public void setShadowYOffset(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        if (this.f490g != dimensionPixelSize) {
            this.f490g = dimensionPixelSize;
            requestLayout();
            J();
        }
    }

    public void setShowAnimation(Animation animation) {
        this.n = animation;
    }

    public synchronized void setShowProgressBackground(boolean z) {
        this.U = z;
    }

    public void setShowShadow(boolean z) {
        if (this.c != z) {
            this.c = z;
            J();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        com.github.clans.fab.a aVar = (com.github.clans.fab.a) getTag(com.github.clans.fab.e.fab_label);
        if (aVar != null) {
            aVar.setVisibility(i);
        }
    }

    public boolean t() {
        return !this.s && this.c;
    }

    public void u(boolean z) {
        if (y()) {
            return;
        }
        if (z) {
            B();
        }
        super.setVisibility(4);
    }

    public boolean y() {
        return getVisibility() == 4;
    }

    @TargetApi(21)
    void z() {
        Drawable drawable = this.r;
        if (drawable instanceof StateListDrawable) {
            ((StateListDrawable) drawable).setState(new int[]{R.attr.state_enabled, R.attr.state_pressed});
        } else if (g.c()) {
            RippleDrawable rippleDrawable = (RippleDrawable) this.r;
            rippleDrawable.setState(new int[]{R.attr.state_enabled, R.attr.state_pressed});
            rippleDrawable.setHotspot(l(), m());
            rippleDrawable.setVisible(true, true);
        }
    }
}
