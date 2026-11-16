package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import d.f.k.z;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    static final Handler s;
    private static final boolean t;
    private static final int[] u;
    private static final String v;
    private final ViewGroup a;
    private final Context b;
    protected final v c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.material.snackbar.a f630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f633g;
    private Rect i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private List<r<B>> o;
    private Behavior p;
    private final AccessibilityManager q;
    private final Runnable h = new j();
    com.google.android.material.snackbar.b.InterfaceC0027b r = new m();

    public static class Behavior extends SwipeDismissBehavior<View> {
        private final s k = new s(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void O(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.k.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean E(View view) {
            return this.k.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.k.b(coordinatorLayout, view, motionEvent);
            return super.k(coordinatorLayout, view, motionEvent);
        }
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.I();
        }
    }

    class b extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.H(this.a);
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.c.setScaleX(fFloatValue);
            BaseTransientBottomBar.this.c.setScaleY(fFloatValue);
        }
    }

    class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.I();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f630d.b(70, 180);
        }
    }

    class f implements ValueAnimator.AnimatorUpdateListener {
        private int a;
        final /* synthetic */ int b;

        f(int i) {
            this.b = i;
            this.a = this.b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.t) {
                d.f.k.r.P(BaseTransientBottomBar.this.c, iIntValue - this.a);
            } else {
                BaseTransientBottomBar.this.c.setTranslationY(iIntValue);
            }
            this.a = iIntValue;
        }
    }

    class g extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        g(int i) {
            this.a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.H(this.a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f630d.a(0, 180);
        }
    }

    class h implements ValueAnimator.AnimatorUpdateListener {
        private int a = 0;

        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.t) {
                d.f.k.r.P(BaseTransientBottomBar.this.c, iIntValue - this.a);
            } else {
                BaseTransientBottomBar.this.c.setTranslationY(iIntValue);
            }
            this.a = iIntValue;
        }
    }

    static class i implements Handler.Callback {
        i() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                ((BaseTransientBottomBar) message.obj).O();
                return true;
            }
            if (i != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).E(message.arg1);
            return true;
        }
    }

    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int iZ;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.c == null || baseTransientBottomBar.b == null || (iZ = (BaseTransientBottomBar.this.z() - BaseTransientBottomBar.this.C()) + ((int) BaseTransientBottomBar.this.c.getTranslationY())) >= BaseTransientBottomBar.this.m) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.c.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.v, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.m - iZ;
            BaseTransientBottomBar.this.c.requestLayout();
        }
    }

    class k implements d.f.k.o {
        k() {
        }

        @Override // d.f.k.o
        public z a(View view, z zVar) {
            BaseTransientBottomBar.this.j = zVar.a();
            BaseTransientBottomBar.this.k = zVar.b();
            BaseTransientBottomBar.this.l = zVar.c();
            BaseTransientBottomBar.this.U();
            return zVar;
        }
    }

    class l extends d.f.k.a {
        l() {
        }

        @Override // d.f.k.a
        public void g(View view, d.f.k.a0.c cVar) {
            super.g(view, cVar);
            cVar.a(1048576);
            cVar.b0(true);
        }

        @Override // d.f.k.a
        public boolean j(View view, int i, Bundle bundle) {
            if (i != 1048576) {
                return super.j(view, i, bundle);
            }
            BaseTransientBottomBar.this.t();
            return true;
        }
    }

    class m implements com.google.android.material.snackbar.b.InterfaceC0027b {
        m() {
        }

        @Override // com.google.android.material.snackbar.b.InterfaceC0027b
        public void a(int i) {
            Handler handler = BaseTransientBottomBar.s;
            handler.sendMessage(handler.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.b.InterfaceC0027b
        public void b() {
            Handler handler = BaseTransientBottomBar.s;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    class n implements t {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseTransientBottomBar.this.H(3);
            }
        }

        n() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        public void onViewAttachedToWindow(View view) {
            WindowInsets rootWindowInsets;
            if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = BaseTransientBottomBar.this.c.getRootWindowInsets()) == null) {
                return;
            }
            BaseTransientBottomBar.this.m = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            BaseTransientBottomBar.this.U();
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        public void onViewDetachedFromWindow(View view) {
            if (BaseTransientBottomBar.this.F()) {
                BaseTransientBottomBar.s.post(new a());
            }
        }
    }

    class o implements u {
        o() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.u
        public void a(View view, int i, int i2, int i3, int i4) {
            BaseTransientBottomBar.this.c.setOnLayoutChangeListener(null);
            BaseTransientBottomBar.this.P();
        }
    }

    class p implements SwipeDismissBehavior.b {
        p() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.b
        public void a(View view) {
            view.setVisibility(8);
            BaseTransientBottomBar.this.u(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.b
        public void b(int i) {
            if (i == 0) {
                com.google.android.material.snackbar.b.c().k(BaseTransientBottomBar.this.r);
            } else if (i == 1 || i == 2) {
                com.google.android.material.snackbar.b.c().j(BaseTransientBottomBar.this.r);
            }
        }
    }

    class q implements Runnable {
        q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v vVar = BaseTransientBottomBar.this.c;
            if (vVar == null) {
                return;
            }
            vVar.setVisibility(0);
            if (BaseTransientBottomBar.this.c.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.Q();
            } else {
                BaseTransientBottomBar.this.S();
            }
        }
    }

    public static abstract class r<B> {
        public void a(B b, int i) {
        }

        public void b(B b) {
        }
    }

    public static class s {
        private com.google.android.material.snackbar.b.InterfaceC0027b a;

        public s(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.L(0.1f);
            swipeDismissBehavior.J(0.6f);
            swipeDismissBehavior.M(0);
        }

        public boolean a(View view) {
            return view instanceof v;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.B(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.b.c().j(this.a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.b.c().k(this.a);
            }
        }

        public void c(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.a = baseTransientBottomBar.r;
        }
    }

    protected interface t {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    protected interface u {
        void a(View view, int i, int i2, int i3, int i4);
    }

    protected static class v extends FrameLayout {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final View.OnTouchListener f635g = new a();
        private u b;
        private t c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f636d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f637e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float f638f;

        static class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        protected v(Context context, AttributeSet attributeSet) {
            super(com.google.android.material.internal.g.f(context, attributeSet, 0, 0), attributeSet);
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.a.a.a.k.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(e.a.a.a.k.SnackbarLayout_elevation)) {
                d.f.k.r.j0(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(e.a.a.a.k.SnackbarLayout_elevation, 0));
            }
            this.f636d = typedArrayObtainStyledAttributes.getInt(e.a.a.a.k.SnackbarLayout_animationMode, 0);
            this.f637e = typedArrayObtainStyledAttributes.getFloat(e.a.a.a.k.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            this.f638f = typedArrayObtainStyledAttributes.getFloat(e.a.a.a.k.SnackbarLayout_actionTextColorAlpha, 1.0f);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f635g);
            setFocusable(true);
        }

        float getActionTextColorAlpha() {
            return this.f638f;
        }

        int getAnimationMode() {
            return this.f636d;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.f637e;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            t tVar = this.c;
            if (tVar != null) {
                tVar.onViewAttachedToWindow(this);
            }
            d.f.k.r.a0(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            t tVar = this.c;
            if (tVar != null) {
                tVar.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            u uVar = this.b;
            if (uVar != null) {
                uVar.a(this, i, i2, i3, i4);
            }
        }

        void setAnimationMode(int i) {
            this.f636d = i;
        }

        void setOnAttachStateChangeListener(t tVar) {
            this.c = tVar;
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f635g);
            super.setOnClickListener(onClickListener);
        }

        void setOnLayoutChangeListener(u uVar) {
            this.b = uVar;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        t = i2 >= 16 && i2 <= 19;
        u = new int[]{e.a.a.a.b.snackbarStyle};
        v = BaseTransientBottomBar.class.getSimpleName();
        s = new Handler(Looper.getMainLooper(), new i());
    }

    protected BaseTransientBottomBar(ViewGroup viewGroup, View view, com.google.android.material.snackbar.a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.a = viewGroup;
        this.f630d = aVar;
        Context context = viewGroup.getContext();
        this.b = context;
        com.google.android.material.internal.g.a(context);
        v vVar = (v) LayoutInflater.from(this.b).inflate(A(), this.a, false);
        this.c = vVar;
        if (vVar.getBackground() == null) {
            d.f.k.r.f0(this.c, s());
        }
        if (view instanceof SnackbarContentLayout) {
            ((SnackbarContentLayout) view).c(this.c.getActionTextColorAlpha());
        }
        this.c.addView(view);
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.i = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        d.f.k.r.e0(this.c, 1);
        d.f.k.r.m0(this.c, 1);
        d.f.k.r.k0(this.c, true);
        d.f.k.r.o0(this.c, new k());
        d.f.k.r.c0(this.c, new l());
        this.q = (AccessibilityManager) this.b.getSystemService("accessibility");
    }

    private int B() {
        int height = this.c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int C() {
        int[] iArr = new int[2];
        this.c.getLocationOnScreen(iArr);
        return iArr[1] + this.c.getHeight();
    }

    private boolean G() {
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) layoutParams).f() instanceof SwipeDismissBehavior);
    }

    private void K(CoordinatorLayout.f fVar) {
        SwipeDismissBehavior<? extends View> swipeDismissBehaviorX = this.p;
        if (swipeDismissBehaviorX == null) {
            swipeDismissBehaviorX = x();
        }
        if (swipeDismissBehaviorX instanceof Behavior) {
            ((Behavior) swipeDismissBehaviorX).O(this);
        }
        swipeDismissBehaviorX.K(new p());
        fVar.o(swipeDismissBehaviorX);
        if (this.f633g == null) {
            fVar.f245g = 80;
        }
    }

    private boolean M() {
        return this.m > 0 && !this.f632f && G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        if (L()) {
            p();
        } else {
            this.c.setVisibility(0);
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        ValueAnimator valueAnimatorV = v(0.0f, 1.0f);
        ValueAnimator valueAnimatorY = y(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorV, valueAnimatorY);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new a());
        animatorSet.start();
    }

    private void R(int i2) {
        ValueAnimator valueAnimatorV = v(1.0f, 0.0f);
        valueAnimatorV.setDuration(75L);
        valueAnimatorV.addListener(new b(i2));
        valueAnimatorV.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        int iB = B();
        if (t) {
            d.f.k.r.P(this.c, iB);
        } else {
            this.c.setTranslationY(iB);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iB, 0);
        valueAnimator.setInterpolator(e.a.a.a.l.a.b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new e());
        valueAnimator.addUpdateListener(new f(iB));
        valueAnimator.start();
    }

    private void T(int i2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, B());
        valueAnimator.setInterpolator(e.a.a.a.l.a.b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new g(i2));
        valueAnimator.addUpdateListener(new h());
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || this.i == null) {
            Log.w(v, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        int i2 = this.f633g != null ? this.n : this.j;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        Rect rect = this.i;
        marginLayoutParams.bottomMargin = rect.bottom + i2;
        marginLayoutParams.leftMargin = rect.left + this.k;
        marginLayoutParams.rightMargin = rect.right + this.l;
        this.c.requestLayout();
        if (Build.VERSION.SDK_INT < 29 || !M()) {
            return;
        }
        this.c.removeCallbacks(this.h);
        this.c.post(this.h);
    }

    private void q(int i2) {
        if (this.c.getAnimationMode() == 1) {
            R(i2);
        } else {
            T(i2);
        }
    }

    private int r() {
        View view = this.f633g;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        this.a.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.a.getHeight()) - i2;
    }

    private Drawable s() {
        v vVar = this.c;
        int iG = e.a.a.a.q.a.g(vVar, e.a.a.a.b.colorSurface, e.a.a.a.b.colorOnSurface, vVar.getBackgroundOverlayColorAlpha());
        float dimension = this.c.getResources().getDimension(e.a.a.a.d.mtrl_snackbar_background_corner_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(iG);
        gradientDrawable.setCornerRadius(dimension);
        return gradientDrawable;
    }

    private ValueAnimator v(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(e.a.a.a.l.a.a);
        valueAnimatorOfFloat.addUpdateListener(new c());
        return valueAnimatorOfFloat;
    }

    private ValueAnimator y(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(e.a.a.a.l.a.f918d);
        valueAnimatorOfFloat.addUpdateListener(new d());
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int z() {
        WindowManager windowManager = (WindowManager) this.b.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    protected int A() {
        return D() ? e.a.a.a.h.mtrl_layout_snackbar : e.a.a.a.h.design_layout_snackbar;
    }

    protected boolean D() {
        TypedArray typedArrayObtainStyledAttributes = this.b.obtainStyledAttributes(u);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    final void E(int i2) {
        if (L() && this.c.getVisibility() == 0) {
            q(i2);
        } else {
            H(i2);
        }
    }

    public boolean F() {
        return com.google.android.material.snackbar.b.c().e(this.r);
    }

    void H(int i2) {
        com.google.android.material.snackbar.b.c().h(this.r);
        List<r<B>> list = this.o;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.o.get(size).a(this, i2);
            }
        }
        ViewParent parent = this.c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.c);
        }
    }

    void I() {
        com.google.android.material.snackbar.b.c().i(this.r);
        List<r<B>> list = this.o;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.o.get(size).b(this);
            }
        }
    }

    public B J(int i2) {
        this.f631e = i2;
        return this;
    }

    boolean L() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.q.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void N() {
        com.google.android.material.snackbar.b.c().m(w(), this.r);
    }

    final void O() {
        this.c.setOnAttachStateChangeListener(new n());
        if (this.c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                K((CoordinatorLayout.f) layoutParams);
            }
            this.n = r();
            U();
            this.c.setVisibility(4);
            this.a.addView(this.c);
        }
        if (d.f.k.r.J(this.c)) {
            P();
        } else {
            this.c.setOnLayoutChangeListener(new o());
        }
    }

    void p() {
        this.c.post(new q());
    }

    public void t() {
        u(3);
    }

    protected void u(int i2) {
        com.google.android.material.snackbar.b.c().b(this.r, i2);
    }

    public int w() {
        return this.f631e;
    }

    protected SwipeDismissBehavior<? extends View> x() {
        return new Behavior();
    }
}
