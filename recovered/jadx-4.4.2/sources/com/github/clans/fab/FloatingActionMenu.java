package com.github.clans.fab;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionMenu extends ViewGroup {
    private boolean A;
    private int B;
    private float C;
    private float D;
    private float E;
    private int F;
    private int G;
    private int H;
    private Drawable I;
    private int J;
    private Interpolator K;
    private Interpolator L;
    private boolean M;
    private boolean N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private ImageView T;
    private boolean U;
    private int V;
    private i W;
    private ValueAnimator a0;
    private AnimatorSet b;
    private ValueAnimator b0;
    private AnimatorSet c;
    private int c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AnimatorSet f496d;
    private int d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f497e;
    private Context e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FloatingActionButton f498f;
    private String f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f499g;
    private boolean g0;
    private int h;
    GestureDetector h0;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private Handler m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private ColorStateList t;
    private float u;
    private int v;
    private boolean w;
    private int x;
    private int y;
    private int z;

    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FloatingActionMenu.this.setBackgroundColor(Color.argb(((Integer) valueAnimator.getAnimatedValue()).intValue(), this.a, this.b, this.c));
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        b(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FloatingActionMenu.this.setBackgroundColor(Color.argb(((Integer) valueAnimator.getAnimatedValue()).intValue(), this.a, this.b, this.c));
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FloatingActionMenu floatingActionMenu = FloatingActionMenu.this;
            floatingActionMenu.v(floatingActionMenu.M);
        }
    }

    class d extends GestureDetector.SimpleOnGestureListener {
        d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return FloatingActionMenu.this.U && FloatingActionMenu.this.t();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            FloatingActionMenu floatingActionMenu = FloatingActionMenu.this;
            floatingActionMenu.h(floatingActionMenu.M);
            return true;
        }
    }

    class e implements Runnable {
        final /* synthetic */ FloatingActionButton b;
        final /* synthetic */ boolean c;

        e(FloatingActionButton floatingActionButton, boolean z) {
            this.b = floatingActionButton;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FloatingActionMenu.this.t()) {
                return;
            }
            if (this.b != FloatingActionMenu.this.f498f) {
                this.b.I(this.c);
            }
            com.github.clans.fab.a aVar = (com.github.clans.fab.a) this.b.getTag(com.github.clans.fab.e.fab_label);
            if (aVar == null || !aVar.r()) {
                return;
            }
            aVar.x(this.c);
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FloatingActionMenu.this.k = true;
            if (FloatingActionMenu.this.W != null) {
                FloatingActionMenu.this.W.a(true);
            }
        }
    }

    class g implements Runnable {
        final /* synthetic */ FloatingActionButton b;
        final /* synthetic */ boolean c;

        g(FloatingActionButton floatingActionButton, boolean z) {
            this.b = floatingActionButton;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FloatingActionMenu.this.t()) {
                if (this.b != FloatingActionMenu.this.f498f) {
                    this.b.u(this.c);
                }
                com.github.clans.fab.a aVar = (com.github.clans.fab.a) this.b.getTag(com.github.clans.fab.e.fab_label);
                if (aVar == null || !aVar.r()) {
                    return;
                }
                aVar.q(this.c);
            }
        }
    }

    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FloatingActionMenu.this.k = false;
            if (FloatingActionMenu.this.W != null) {
                FloatingActionMenu.this.W.a(false);
            }
        }
    }

    public interface i {
        void a(boolean z);
    }

    public FloatingActionMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionMenu(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = new AnimatorSet();
        this.c = new AnimatorSet();
        this.f497e = com.github.clans.fab.g.a(getContext(), 0.0f);
        this.h = com.github.clans.fab.g.a(getContext(), 0.0f);
        this.i = com.github.clans.fab.g.a(getContext(), 0.0f);
        this.m = new Handler();
        this.p = com.github.clans.fab.g.a(getContext(), 4.0f);
        this.q = com.github.clans.fab.g.a(getContext(), 8.0f);
        this.r = com.github.clans.fab.g.a(getContext(), 4.0f);
        this.s = com.github.clans.fab.g.a(getContext(), 8.0f);
        this.v = com.github.clans.fab.g.a(getContext(), 3.0f);
        this.C = 4.0f;
        this.D = 1.0f;
        this.E = 3.0f;
        this.M = true;
        this.S = true;
        this.h0 = new GestureDetector(getContext(), new d());
        o(context, attributeSet);
    }

    private void f(FloatingActionButton floatingActionButton) {
        String labelText = floatingActionButton.getLabelText();
        if (TextUtils.isEmpty(labelText)) {
            return;
        }
        com.github.clans.fab.a aVar = new com.github.clans.fab.a(this.e0);
        aVar.setClickable(true);
        aVar.setFab(floatingActionButton);
        aVar.setShowAnimation(AnimationUtils.loadAnimation(getContext(), this.n));
        aVar.setHideAnimation(AnimationUtils.loadAnimation(getContext(), this.o));
        if (this.R > 0) {
            aVar.setTextAppearance(getContext(), this.R);
            aVar.setShowShadow(false);
            aVar.setUsingStyle(true);
        } else {
            aVar.w(this.x, this.y, this.z);
            aVar.setShowShadow(this.w);
            aVar.setCornerRadius(this.v);
            if (this.O > 0) {
                setLabelEllipsize(aVar);
            }
            aVar.setMaxLines(this.P);
            aVar.y();
            aVar.setTextSize(0, this.u);
            aVar.setTextColor(this.t);
            int shadowRadius = this.s;
            int shadowRadius2 = this.p;
            if (this.w) {
                shadowRadius += floatingActionButton.getShadowRadius() + Math.abs(floatingActionButton.getShadowXOffset());
                shadowRadius2 += floatingActionButton.getShadowRadius() + Math.abs(floatingActionButton.getShadowYOffset());
            }
            aVar.setPadding(shadowRadius, shadowRadius2, this.s, this.p);
            if (this.P < 0 || this.N) {
                aVar.setSingleLine(this.N);
            }
        }
        aVar.setText(labelText);
        aVar.setOnClickListener(floatingActionButton.getOnClickListener());
        addView(aVar);
        floatingActionButton.setTag(com.github.clans.fab.e.fab_label, aVar);
    }

    private int g(int i2) {
        double d2 = i2;
        Double.isNaN(d2);
        Double.isNaN(d2);
        return (int) ((0.03d * d2) + d2);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0015 A[PHI: r0
      0x0015: PHI (r0v13 float) = (r0v3 float), (r0v16 float) binds: [B:16:0x0023, B:9:0x0013] A[DONT_GENERATE, DONT_INLINE]] */
    private void i() {
        float f2;
        float f3 = 135.0f;
        if (this.V == 0) {
            f2 = this.d0 == 0 ? -135.0f : 135.0f;
            if (this.d0 == 0) {
                f3 = -135.0f;
            }
        } else {
            f2 = this.d0 == 0 ? 135.0f : -135.0f;
            if (this.d0 != 0) {
                f3 = -135.0f;
            }
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.T, "rotation", f2, 0.0f);
        this.b.play(ObjectAnimator.ofFloat(this.T, "rotation", 0.0f, f3));
        this.c.play(objectAnimatorOfFloat);
        this.b.setInterpolator(this.K);
        this.c.setInterpolator(this.L);
        this.b.setDuration(300L);
        this.c.setDuration(300L);
    }

    private void j() {
        for (int i2 = 0; i2 < this.j; i2++) {
            if (getChildAt(i2) != this.T) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) getChildAt(i2);
                if (floatingActionButton.getTag(com.github.clans.fab.e.fab_label) == null) {
                    f(floatingActionButton);
                    FloatingActionButton floatingActionButton2 = this.f498f;
                    if (floatingActionButton == floatingActionButton2) {
                        floatingActionButton2.setOnClickListener(new c());
                    }
                }
            }
        }
    }

    private void k() {
        FloatingActionButton floatingActionButton = new FloatingActionButton(getContext());
        this.f498f = floatingActionButton;
        boolean z = this.A;
        floatingActionButton.c = z;
        if (z) {
            floatingActionButton.f488e = com.github.clans.fab.g.a(getContext(), this.C);
            this.f498f.f489f = com.github.clans.fab.g.a(getContext(), this.D);
            this.f498f.f490g = com.github.clans.fab.g.a(getContext(), this.E);
        }
        this.f498f.E(this.F, this.G, this.H);
        FloatingActionButton floatingActionButton2 = this.f498f;
        floatingActionButton2.f487d = this.B;
        floatingActionButton2.b = this.Q;
        floatingActionButton2.J();
        this.f498f.setLabelText(this.f0);
        ImageView imageView = new ImageView(getContext());
        this.T = imageView;
        imageView.setImageDrawable(this.I);
        addView(this.f498f, super.generateDefaultLayoutParams());
        addView(this.T);
        i();
    }

    private void o(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.github.clans.fab.f.FloatingActionMenu, 0, 0);
        this.f497e = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.f.FloatingActionMenu_menu_buttonSpacing, this.f497e);
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.f.FloatingActionMenu_menu_labels_margin, this.h);
        int i2 = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.f.FloatingActionMenu_menu_labels_position, 0);
        this.d0 = i2;
        this.n = typedArrayObtainStyledAttributes.getResourceId(com.github.clans.fab.f.FloatingActionMenu_menu_labels_showAnimation, i2 == 0 ? com.github.clans.fab.b.fab_slide_in_from_right : com.github.clans.fab.b.fab_slide_in_from_left);
        this.o = typedArrayObtainStyledAttributes.getResourceId(com.github.clans.fab.f.FloatingActionMenu_menu_labels_hideAnimation, this.d0 == 0 ? com.github.clans.fab.b.fab_slide_out_to_right : com.github.clans.fab.b.fab_slide_out_to_left);
        this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.f.FloatingActionMenu_menu_labels_paddingTop, this.p);
        this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.f.FloatingActionMenu_menu_labels_paddingRight, this.q);
        this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.f.FloatingActionMenu_menu_labels_paddingBottom, this.r);
        this.s = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.f.FloatingActionMenu_menu_labels_paddingLeft, this.s);
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(com.github.clans.fab.f.FloatingActionMenu_menu_labels_textColor);
        this.t = colorStateList;
        if (colorStateList == null) {
            this.t = ColorStateList.valueOf(-1);
        }
        this.u = typedArrayObtainStyledAttributes.getDimension(com.github.clans.fab.f.FloatingActionMenu_menu_labels_textSize, getResources().getDimension(com.github.clans.fab.c.labels_text_size));
        this.v = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.f.FloatingActionMenu_menu_labels_cornerRadius, this.v);
        this.w = typedArrayObtainStyledAttributes.getBoolean(com.github.clans.fab.f.FloatingActionMenu_menu_labels_showShadow, true);
        this.x = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.f.FloatingActionMenu_menu_labels_colorNormal, -13421773);
        this.y = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.f.FloatingActionMenu_menu_labels_colorPressed, -12303292);
        this.z = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.f.FloatingActionMenu_menu_labels_colorRipple, 1728053247);
        this.A = typedArrayObtainStyledAttributes.getBoolean(com.github.clans.fab.f.FloatingActionMenu_menu_showShadow, true);
        this.B = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.f.FloatingActionMenu_menu_shadowColor, 1711276032);
        this.C = typedArrayObtainStyledAttributes.getDimension(com.github.clans.fab.f.FloatingActionMenu_menu_shadowRadius, this.C);
        this.D = typedArrayObtainStyledAttributes.getDimension(com.github.clans.fab.f.FloatingActionMenu_menu_shadowXOffset, this.D);
        this.E = typedArrayObtainStyledAttributes.getDimension(com.github.clans.fab.f.FloatingActionMenu_menu_shadowYOffset, this.E);
        this.F = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.f.FloatingActionMenu_menu_colorNormal, -2473162);
        this.G = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.f.FloatingActionMenu_menu_colorPressed, -1617853);
        this.H = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.f.FloatingActionMenu_menu_colorRipple, -1711276033);
        this.J = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.f.FloatingActionMenu_menu_animationDelayPerItem, 50);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(com.github.clans.fab.f.FloatingActionMenu_menu_icon);
        this.I = drawable;
        if (drawable == null) {
            this.I = getResources().getDrawable(com.github.clans.fab.d.fab_add);
        }
        this.N = typedArrayObtainStyledAttributes.getBoolean(com.github.clans.fab.f.FloatingActionMenu_menu_labels_singleLine, false);
        this.O = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.f.FloatingActionMenu_menu_labels_ellipsize, 0);
        this.P = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.f.FloatingActionMenu_menu_labels_maxLines, -1);
        this.Q = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.f.FloatingActionMenu_menu_fab_size, 0);
        this.R = typedArrayObtainStyledAttributes.getResourceId(com.github.clans.fab.f.FloatingActionMenu_menu_labels_style, 0);
        this.V = typedArrayObtainStyledAttributes.getInt(com.github.clans.fab.f.FloatingActionMenu_menu_openDirection, 0);
        this.c0 = typedArrayObtainStyledAttributes.getColor(com.github.clans.fab.f.FloatingActionMenu_menu_backgroundColor, 0);
        if (typedArrayObtainStyledAttributes.hasValue(com.github.clans.fab.f.FloatingActionMenu_menu_fab_label)) {
            this.g0 = true;
            this.f0 = typedArrayObtainStyledAttributes.getString(com.github.clans.fab.f.FloatingActionMenu_menu_fab_label);
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.github.clans.fab.f.FloatingActionMenu_menu_labels_padding)) {
            r(typedArrayObtainStyledAttributes.getDimensionPixelSize(com.github.clans.fab.f.FloatingActionMenu_menu_labels_padding, 0));
        }
        this.K = new OvershootInterpolator();
        this.L = new AnticipateInterpolator();
        this.e0 = new ContextThemeWrapper(getContext(), this.R);
        p();
        k();
        q(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void p() {
        int iAlpha = Color.alpha(this.c0);
        int iRed = Color.red(this.c0);
        int iGreen = Color.green(this.c0);
        int iBlue = Color.blue(this.c0);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, iAlpha);
        this.a0 = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(300L);
        this.a0.addUpdateListener(new a(iRed, iGreen, iBlue));
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(iAlpha, 0);
        this.b0 = valueAnimatorOfInt2;
        valueAnimatorOfInt2.setDuration(300L);
        this.b0.addUpdateListener(new b(iRed, iGreen, iBlue));
    }

    private void q(TypedArray typedArray) {
        setMenuButtonShowAnimation(AnimationUtils.loadAnimation(getContext(), typedArray.getResourceId(com.github.clans.fab.f.FloatingActionMenu_menu_fab_show_animation, com.github.clans.fab.b.fab_scale_up)));
        setMenuButtonHideAnimation(AnimationUtils.loadAnimation(getContext(), typedArray.getResourceId(com.github.clans.fab.f.FloatingActionMenu_menu_fab_hide_animation, com.github.clans.fab.b.fab_scale_down)));
    }

    private void r(int i2) {
        this.p = i2;
        this.q = i2;
        this.r = i2;
        this.s = i2;
    }

    private boolean s() {
        return this.c0 != 0;
    }

    private void setLabelEllipsize(com.github.clans.fab.a aVar) {
        TextUtils.TruncateAt truncateAt;
        int i2 = this.O;
        if (i2 == 1) {
            truncateAt = TextUtils.TruncateAt.START;
        } else if (i2 == 2) {
            truncateAt = TextUtils.TruncateAt.MIDDLE;
        } else if (i2 == 3) {
            truncateAt = TextUtils.TruncateAt.END;
        } else if (i2 != 4) {
            return;
        } else {
            truncateAt = TextUtils.TruncateAt.MARQUEE;
        }
        aVar.setEllipsize(truncateAt);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    public int getAnimationDelayPerItem() {
        return this.J;
    }

    public AnimatorSet getIconToggleAnimatorSet() {
        return this.f496d;
    }

    public int getMenuButtonColorNormal() {
        return this.F;
    }

    public int getMenuButtonColorPressed() {
        return this.G;
    }

    public int getMenuButtonColorRipple() {
        return this.H;
    }

    public String getMenuButtonLabelText() {
        return this.f0;
    }

    public ImageView getMenuIconView() {
        return this.T;
    }

    public void h(boolean z) {
        if (t()) {
            if (s()) {
                this.b0.start();
            }
            if (this.S) {
                AnimatorSet animatorSet = this.f496d;
                if (animatorSet != null) {
                    animatorSet.start();
                } else {
                    this.c.start();
                    this.b.cancel();
                }
            }
            this.l = false;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if ((childAt instanceof FloatingActionButton) && childAt.getVisibility() != 8) {
                    i2++;
                    this.m.postDelayed(new g((FloatingActionButton) childAt, z), i3);
                    i3 += this.J;
                }
            }
            this.m.postDelayed(new h(), (i2 + 1) * this.J);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public ViewGroup.MarginLayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public ViewGroup.MarginLayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bringChildToFront(this.f498f);
        bringChildToFront(this.T);
        this.j = getChildCount();
        j();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingRight = this.d0 == 0 ? ((i4 - i2) - (this.f499g / 2)) - getPaddingRight() : (this.f499g / 2) + getPaddingLeft();
        boolean z2 = this.V == 0;
        int measuredHeight = z2 ? ((i5 - i3) - this.f498f.getMeasuredHeight()) - getPaddingBottom() : getPaddingTop();
        int measuredWidth = paddingRight - (this.f498f.getMeasuredWidth() / 2);
        FloatingActionButton floatingActionButton = this.f498f;
        floatingActionButton.layout(measuredWidth, measuredHeight, floatingActionButton.getMeasuredWidth() + measuredWidth, this.f498f.getMeasuredHeight() + measuredHeight);
        int measuredWidth2 = paddingRight - (this.T.getMeasuredWidth() / 2);
        int measuredHeight2 = ((this.f498f.getMeasuredHeight() / 2) + measuredHeight) - (this.T.getMeasuredHeight() / 2);
        ImageView imageView = this.T;
        imageView.layout(measuredWidth2, measuredHeight2, imageView.getMeasuredWidth() + measuredWidth2, this.T.getMeasuredHeight() + measuredHeight2);
        if (z2) {
            measuredHeight = measuredHeight + this.f498f.getMeasuredHeight() + this.f497e;
        }
        for (int i6 = this.j - 1; i6 >= 0; i6--) {
            View childAt = getChildAt(i6);
            if (childAt != this.T) {
                FloatingActionButton floatingActionButton2 = (FloatingActionButton) childAt;
                if (floatingActionButton2.getVisibility() != 8) {
                    int measuredWidth3 = paddingRight - (floatingActionButton2.getMeasuredWidth() / 2);
                    if (z2) {
                        measuredHeight = (measuredHeight - floatingActionButton2.getMeasuredHeight()) - this.f497e;
                    }
                    if (floatingActionButton2 != this.f498f) {
                        floatingActionButton2.layout(measuredWidth3, measuredHeight, floatingActionButton2.getMeasuredWidth() + measuredWidth3, floatingActionButton2.getMeasuredHeight() + measuredHeight);
                        if (!this.l) {
                            floatingActionButton2.u(false);
                        }
                    }
                    View view = (View) floatingActionButton2.getTag(com.github.clans.fab.e.fab_label);
                    if (view != null) {
                        int measuredWidth4 = ((this.g0 ? this.f499g : floatingActionButton2.getMeasuredWidth()) / 2) + this.h;
                        int i7 = this.d0 == 0 ? paddingRight - measuredWidth4 : measuredWidth4 + paddingRight;
                        int measuredWidth5 = this.d0 == 0 ? i7 - view.getMeasuredWidth() : view.getMeasuredWidth() + i7;
                        int i8 = this.d0 == 0 ? measuredWidth5 : i7;
                        if (this.d0 != 0) {
                            i7 = measuredWidth5;
                        }
                        int measuredHeight3 = (measuredHeight - this.i) + ((floatingActionButton2.getMeasuredHeight() - view.getMeasuredHeight()) / 2);
                        view.layout(i8, measuredHeight3, i7, view.getMeasuredHeight() + measuredHeight3);
                        if (!this.l) {
                            view.setVisibility(4);
                        }
                    }
                    measuredHeight = z2 ? measuredHeight - this.f497e : measuredHeight + childAt.getMeasuredHeight() + this.f497e;
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        this.f499g = 0;
        measureChildWithMargins(this.T, i2, 0, i3, 0);
        for (int i4 = 0; i4 < this.j; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8 && childAt != this.T) {
                measureChildWithMargins(childAt, i2, 0, i3, 0);
                this.f499g = Math.max(this.f499g, childAt.getMeasuredWidth());
            }
        }
        int i5 = 0;
        int i6 = 0;
        int iMax = 0;
        while (true) {
            if (i6 >= this.j) {
                break;
            }
            View childAt2 = getChildAt(i6);
            if (childAt2.getVisibility() != 8 && childAt2 != this.T) {
                int measuredWidth = childAt2.getMeasuredWidth() + 0;
                int measuredHeight = i5 + childAt2.getMeasuredHeight();
                com.github.clans.fab.a aVar = (com.github.clans.fab.a) childAt2.getTag(com.github.clans.fab.e.fab_label);
                if (aVar != null) {
                    int measuredWidth2 = (this.f499g - childAt2.getMeasuredWidth()) / (this.g0 ? 1 : 2);
                    measureChildWithMargins(aVar, i2, childAt2.getMeasuredWidth() + aVar.n() + this.h + measuredWidth2, i3, 0);
                    iMax = Math.max(iMax, measuredWidth + aVar.getMeasuredWidth() + measuredWidth2);
                }
                i5 = measuredHeight;
            }
            i6++;
        }
        int iMax2 = Math.max(this.f499g, iMax + this.h) + getPaddingLeft() + getPaddingRight();
        int iG = g(i5 + (this.f497e * (this.j - 1)) + getPaddingTop() + getPaddingBottom());
        if (getLayoutParams().width == -1) {
            iMax2 = ViewGroup.getDefaultSize(getSuggestedMinimumWidth(), i2);
        }
        if (getLayoutParams().height == -1) {
            iG = ViewGroup.getDefaultSize(getSuggestedMinimumHeight(), i3);
        }
        setMeasuredDimension(iMax2, iG);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.U ? this.h0.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void setAnimated(boolean z) {
        this.M = z;
        this.b.setDuration(z ? 300L : 0L);
        this.c.setDuration(z ? 300L : 0L);
    }

    public void setAnimationDelayPerItem(int i2) {
        this.J = i2;
    }

    public void setClosedOnTouchOutside(boolean z) {
        this.U = z;
    }

    public void setIconAnimated(boolean z) {
        this.S = z;
    }

    public void setIconAnimationCloseInterpolator(Interpolator interpolator) {
        this.c.setInterpolator(interpolator);
    }

    public void setIconAnimationInterpolator(Interpolator interpolator) {
        this.b.setInterpolator(interpolator);
        this.c.setInterpolator(interpolator);
    }

    public void setIconAnimationOpenInterpolator(Interpolator interpolator) {
        this.b.setInterpolator(interpolator);
    }

    public void setIconToggleAnimatorSet(AnimatorSet animatorSet) {
        this.f496d = animatorSet;
    }

    public void setMenuButtonColorNormal(int i2) {
        this.F = i2;
        this.f498f.setColorNormal(i2);
    }

    public void setMenuButtonColorNormalResId(int i2) {
        this.F = getResources().getColor(i2);
        this.f498f.setColorNormalResId(i2);
    }

    public void setMenuButtonColorPressed(int i2) {
        this.G = i2;
        this.f498f.setColorPressed(i2);
    }

    public void setMenuButtonColorPressedResId(int i2) {
        this.G = getResources().getColor(i2);
        this.f498f.setColorPressedResId(i2);
    }

    public void setMenuButtonColorRipple(int i2) {
        this.H = i2;
        this.f498f.setColorRipple(i2);
    }

    public void setMenuButtonColorRippleResId(int i2) {
        this.H = getResources().getColor(i2);
        this.f498f.setColorRippleResId(i2);
    }

    public void setMenuButtonHideAnimation(Animation animation) {
        this.f498f.setHideAnimation(animation);
    }

    public void setMenuButtonLabelText(String str) {
        this.f498f.setLabelText(str);
    }

    public void setMenuButtonShowAnimation(Animation animation) {
        this.f498f.setShowAnimation(animation);
    }

    public void setOnMenuButtonClickListener(View.OnClickListener onClickListener) {
        this.f498f.setOnClickListener(onClickListener);
    }

    public void setOnMenuToggleListener(i iVar) {
        this.W = iVar;
    }

    public boolean t() {
        return this.k;
    }

    public void u(boolean z) {
        if (t()) {
            return;
        }
        if (s()) {
            this.a0.start();
        }
        if (this.S) {
            AnimatorSet animatorSet = this.f496d;
            if (animatorSet == null) {
                this.c.cancel();
                animatorSet = this.b;
            }
            animatorSet.start();
        }
        this.l = true;
        int i2 = 0;
        int i3 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if ((childAt instanceof FloatingActionButton) && childAt.getVisibility() != 8) {
                i2++;
                this.m.postDelayed(new e((FloatingActionButton) childAt, z), i3);
                i3 += this.J;
            }
        }
        this.m.postDelayed(new f(), (i2 + 1) * this.J);
    }

    public void v(boolean z) {
        if (t()) {
            h(z);
        } else {
            u(z);
        }
    }
}
