package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import d.f.k.r;
import e.a.a.a.a0.n;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class b {
    static final TimeInterpolator F = e.a.a.a.l.a.c;
    static final int[] G = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] H = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    static final int[] I = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] J = {R.attr.state_hovered, R.attr.state_enabled};
    static final int[] K = {R.attr.state_enabled};
    static final int[] L = new int[0];
    private ViewTreeObserver.OnPreDrawListener E;
    e.a.a.a.a0.k a;
    e.a.a.a.a0.g b;
    Drawable c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    com.google.android.material.floatingactionbutton.a f603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Drawable f604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f605f;
    float h;
    float i;
    float j;
    int k;
    private final com.google.android.material.internal.e l;
    private e.a.a.a.l.h m;
    private e.a.a.a.l.h n;
    private Animator o;
    private e.a.a.a.l.h p;
    private e.a.a.a.l.h q;
    private float r;
    private int t;
    private ArrayList<Animator.AnimatorListener> v;
    private ArrayList<Animator.AnimatorListener> w;
    private ArrayList<i> x;
    final FloatingActionButton y;
    final e.a.a.a.z.b z;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f606g = true;
    private float s = 1.0f;
    private int u = 0;
    private final Rect A = new Rect();
    private final RectF B = new RectF();
    private final RectF C = new RectF();
    private final Matrix D = new Matrix();

    class a extends AnimatorListenerAdapter {
        private boolean a;
        final /* synthetic */ boolean b;
        final /* synthetic */ j c;

        a(boolean z, j jVar) {
            this.b = z;
            this.c = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.u = 0;
            b.this.o = null;
            if (this.a) {
                return;
            }
            b.this.y.b(this.b ? 8 : 4, this.b);
            j jVar = this.c;
            if (jVar != null) {
                jVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.y.b(0, this.b);
            b.this.u = 1;
            b.this.o = animator;
            this.a = false;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.b$b, reason: collision with other inner class name */
    class C0025b extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;
        final /* synthetic */ j b;

        C0025b(boolean z, j jVar) {
            this.a = z;
            this.b = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.u = 0;
            b.this.o = null;
            j jVar = this.b;
            if (jVar != null) {
                jVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.y.b(0, this.a);
            b.this.u = 2;
            b.this.o = animator;
        }
    }

    class c extends e.a.a.a.l.g {
        c() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            b.this.s = f2;
            return super.evaluate(f2, matrix, matrix2);
        }
    }

    class d implements TypeEvaluator<Float> {
        FloatEvaluator a = new FloatEvaluator();

        d(b bVar) {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f2, Float f3, Float f4) {
            float fFloatValue = this.a.evaluate(f2, (Number) f3, (Number) f4).floatValue();
            if (fFloatValue < 0.1f) {
                fFloatValue = 0.0f;
            }
            return Float.valueOf(fFloatValue);
        }
    }

    class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            b.this.F();
            return true;
        }
    }

    private class f extends l {
        f(b bVar) {
            super(bVar, null);
        }

        @Override // com.google.android.material.floatingactionbutton.b.l
        protected float a() {
            return 0.0f;
        }
    }

    private class g extends l {
        g() {
            super(b.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.b.l
        protected float a() {
            b bVar = b.this;
            return bVar.h + bVar.i;
        }
    }

    private class h extends l {
        h() {
            super(b.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.b.l
        protected float a() {
            b bVar = b.this;
            return bVar.h + bVar.j;
        }
    }

    interface i {
        void a();

        void b();
    }

    interface j {
        void a();

        void b();
    }

    private class k extends l {
        k() {
            super(b.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.b.l
        protected float a() {
            return b.this.h;
        }
    }

    private abstract class l extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private boolean a;
        private float b;
        private float c;

        private l() {
        }

        /* synthetic */ l(b bVar, a aVar) {
            this();
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.c0((int) this.c);
            this.a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.a) {
                e.a.a.a.a0.g gVar = b.this.b;
                this.b = gVar == null ? 0.0f : gVar.v();
                this.c = a();
                this.a = true;
            }
            b bVar = b.this;
            float f2 = this.b;
            bVar.c0((int) (f2 + ((this.c - f2) * valueAnimator.getAnimatedFraction())));
        }
    }

    b(FloatingActionButton floatingActionButton, e.a.a.a.z.b bVar) {
        this.y = floatingActionButton;
        this.z = bVar;
        com.google.android.material.internal.e eVar = new com.google.android.material.internal.e();
        this.l = eVar;
        eVar.a(G, i(new h()));
        this.l.a(H, i(new g()));
        this.l.a(I, i(new g()));
        this.l.a(J, i(new g()));
        this.l.a(K, i(new k()));
        this.l.a(L, i(new f(this)));
        this.r = this.y.getRotation();
    }

    private boolean W() {
        return r.J(this.y) && !this.y.isInEditMode();
    }

    private void d0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new d(this));
    }

    private void g(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.y.getDrawable();
        if (drawable == null || this.t == 0) {
            return;
        }
        RectF rectF = this.B;
        RectF rectF2 = this.C;
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        int i2 = this.t;
        rectF2.set(0.0f, 0.0f, i2, i2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i3 = this.t;
        matrix.postScale(f2, f2, i3 / 2.0f, i3 / 2.0f);
    }

    private AnimatorSet h(e.a.a.a.l.h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.y, (Property<FloatingActionButton, Float>) View.ALPHA, f2);
        hVar.e("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.y, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        hVar.e("scale").a(objectAnimatorOfFloat2);
        d0(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.y, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        hVar.e("scale").a(objectAnimatorOfFloat3);
        d0(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        g(f4, this.D);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.y, new e.a.a.a.l.f(), new c(), new Matrix(this.D));
        hVar.e("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        e.a.a.a.l.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private ValueAnimator i(l lVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(F);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(lVar);
        valueAnimator.addUpdateListener(lVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private e.a.a.a.l.h k() {
        if (this.n == null) {
            this.n = e.a.a.a.l.h.c(this.y.getContext(), e.a.a.a.a.design_fab_hide_motion_spec);
        }
        e.a.a.a.l.h hVar = this.n;
        d.f.j.h.c(hVar);
        return hVar;
    }

    private e.a.a.a.l.h l() {
        if (this.m == null) {
            this.m = e.a.a.a.l.h.c(this.y.getContext(), e.a.a.a.a.design_fab_show_motion_spec);
        }
        e.a.a.a.l.h hVar = this.m;
        d.f.j.h.c(hVar);
        return hVar;
    }

    private ViewTreeObserver.OnPreDrawListener q() {
        if (this.E == null) {
            this.E = new e();
        }
        return this.E;
    }

    void A() {
    }

    void B() {
        ViewTreeObserver viewTreeObserver = this.y.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.E;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.E = null;
        }
    }

    void C(int[] iArr) {
        this.l.d(iArr);
    }

    void D(float f2, float f3, float f4) {
        b0();
        c0(f2);
    }

    void E(Rect rect) {
        e.a.a.a.z.b bVar;
        Drawable insetDrawable;
        d.f.j.h.d(this.f604e, "Didn't initialize content background");
        if (V()) {
            insetDrawable = new InsetDrawable(this.f604e, rect.left, rect.top, rect.right, rect.bottom);
            bVar = this.z;
        } else {
            bVar = this.z;
            insetDrawable = this.f604e;
        }
        bVar.c(insetDrawable);
    }

    void F() {
        float rotation = this.y.getRotation();
        if (this.r != rotation) {
            this.r = rotation;
            Z();
        }
    }

    void G() {
        ArrayList<i> arrayList = this.x;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    void H() {
        ArrayList<i> arrayList = this.x;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    boolean I() {
        return true;
    }

    void J(ColorStateList colorStateList) {
        e.a.a.a.a0.g gVar = this.b;
        if (gVar != null) {
            gVar.setTintList(colorStateList);
        }
        com.google.android.material.floatingactionbutton.a aVar = this.f603d;
        if (aVar == null) {
            return;
        }
        aVar.a(colorStateList);
        throw null;
    }

    void K(PorterDuff.Mode mode) {
        e.a.a.a.a0.g gVar = this.b;
        if (gVar != null) {
            gVar.setTintMode(mode);
        }
    }

    final void L(float f2) {
        if (this.h != f2) {
            this.h = f2;
            D(f2, this.i, this.j);
        }
    }

    void M(boolean z) {
        this.f605f = z;
    }

    final void N(e.a.a.a.l.h hVar) {
        this.q = hVar;
    }

    final void O(float f2) {
        if (this.i != f2) {
            this.i = f2;
            D(this.h, f2, this.j);
        }
    }

    final void P(float f2) {
        this.s = f2;
        Matrix matrix = this.D;
        g(f2, matrix);
        this.y.setImageMatrix(matrix);
    }

    final void Q(float f2) {
        if (this.j != f2) {
            this.j = f2;
            D(this.h, this.i, f2);
        }
    }

    void R(ColorStateList colorStateList) {
        Drawable drawable = this.c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, e.a.a.a.y.b.a(colorStateList));
        }
    }

    void S(boolean z) {
        this.f606g = z;
        b0();
    }

    final void T(e.a.a.a.a0.k kVar) {
        this.a = kVar;
        e.a.a.a.a0.g gVar = this.b;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(kVar);
        }
        Object obj = this.c;
        if (obj instanceof n) {
            ((n) obj).setShapeAppearanceModel(kVar);
        }
        com.google.android.material.floatingactionbutton.a aVar = this.f603d;
        if (aVar == null) {
            return;
        }
        aVar.b(kVar);
        throw null;
    }

    final void U(e.a.a.a.l.h hVar) {
        this.p = hVar;
    }

    boolean V() {
        return true;
    }

    final boolean X() {
        return !this.f605f || this.y.getSizeDimension() >= this.k;
    }

    void Y(j jVar, boolean z) {
        if (x()) {
            return;
        }
        Animator animator = this.o;
        if (animator != null) {
            animator.cancel();
        }
        if (!W()) {
            this.y.b(0, z);
            this.y.setAlpha(1.0f);
            this.y.setScaleY(1.0f);
            this.y.setScaleX(1.0f);
            P(1.0f);
            if (jVar != null) {
                jVar.a();
                return;
            }
            return;
        }
        if (this.y.getVisibility() != 0) {
            this.y.setAlpha(0.0f);
            this.y.setScaleY(0.0f);
            this.y.setScaleX(0.0f);
            P(0.0f);
        }
        e.a.a.a.l.h hVarL = this.p;
        if (hVarL == null) {
            hVarL = l();
        }
        AnimatorSet animatorSetH = h(hVarL, 1.0f, 1.0f, 1.0f);
        animatorSetH.addListener(new C0025b(z, jVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.v;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetH.addListener(it.next());
            }
        }
        animatorSetH.start();
    }

    void Z() {
        FloatingActionButton floatingActionButton;
        int i2;
        if (Build.VERSION.SDK_INT == 19) {
            if (this.r % 90.0f != 0.0f) {
                i2 = 1;
                if (this.y.getLayerType() != 1) {
                    floatingActionButton = this.y;
                    floatingActionButton.setLayerType(i2, null);
                }
            } else if (this.y.getLayerType() != 0) {
                floatingActionButton = this.y;
                i2 = 0;
                floatingActionButton.setLayerType(i2, null);
            }
        }
        e.a.a.a.a0.g gVar = this.b;
        if (gVar != null) {
            gVar.X((int) this.r);
        }
    }

    final void a0() {
        P(this.s);
    }

    final void b0() {
        Rect rect = this.A;
        r(rect);
        E(rect);
        this.z.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void c0(float f2) {
        e.a.a.a.a0.g gVar = this.b;
        if (gVar != null) {
            gVar.S(f2);
        }
    }

    public void d(Animator.AnimatorListener animatorListener) {
        if (this.w == null) {
            this.w = new ArrayList<>();
        }
        this.w.add(animatorListener);
    }

    void e(Animator.AnimatorListener animatorListener) {
        if (this.v == null) {
            this.v = new ArrayList<>();
        }
        this.v.add(animatorListener);
    }

    void f(i iVar) {
        if (this.x == null) {
            this.x = new ArrayList<>();
        }
        this.x.add(iVar);
    }

    final Drawable j() {
        return this.f604e;
    }

    float m() {
        return this.h;
    }

    boolean n() {
        return this.f605f;
    }

    final e.a.a.a.l.h o() {
        return this.q;
    }

    float p() {
        return this.i;
    }

    void r(Rect rect) {
        int sizeDimension = this.f605f ? (this.k - this.y.getSizeDimension()) / 2 : 0;
        float fM = this.f606g ? m() + this.j : 0.0f;
        int iMax = Math.max(sizeDimension, (int) Math.ceil(fM));
        int iMax2 = Math.max(sizeDimension, (int) Math.ceil(fM * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    float s() {
        return this.j;
    }

    final e.a.a.a.a0.k t() {
        return this.a;
    }

    final e.a.a.a.l.h u() {
        return this.p;
    }

    void v(j jVar, boolean z) {
        if (w()) {
            return;
        }
        Animator animator = this.o;
        if (animator != null) {
            animator.cancel();
        }
        if (!W()) {
            this.y.b(z ? 8 : 4, z);
            if (jVar != null) {
                jVar.b();
                return;
            }
            return;
        }
        e.a.a.a.l.h hVarK = this.q;
        if (hVarK == null) {
            hVarK = k();
        }
        AnimatorSet animatorSetH = h(hVarK, 0.0f, 0.0f, 0.0f);
        animatorSetH.addListener(new a(z, jVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.w;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetH.addListener(it.next());
            }
        }
        animatorSetH.start();
    }

    boolean w() {
        if (this.y.getVisibility() == 0) {
            return this.u == 1;
        }
        return this.u != 2;
    }

    boolean x() {
        if (this.y.getVisibility() != 0) {
            return this.u == 2;
        }
        return this.u != 1;
    }

    void y() {
        this.l.c();
    }

    void z() {
        e.a.a.a.a0.g gVar = this.b;
        if (gVar != null) {
            e.a.a.a.a0.h.f(this.y, gVar);
        }
        if (I()) {
            this.y.getViewTreeObserver().addOnPreDrawListener(q());
        }
    }
}
