package com.google.android.material.bottomsheet;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import d.f.k.r;
import e.a.a.a.a0.k;
import e.a.a.a.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    private static final int K = j.Widget_Design_BottomSheet_Modal;
    int A;
    WeakReference<V> B;
    WeakReference<View> C;
    private final ArrayList<e> D;
    private VelocityTracker E;
    int F;
    private int G;
    boolean H;
    private Map<View, Integer> I;
    private final d.h.b.c.AbstractC0059c J;
    private int a;
    private boolean b;
    private float c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f545e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f547g;
    private e.a.a.a.a0.g h;
    private k i;
    private boolean j;
    private BottomSheetBehavior<V>.g k;
    private ValueAnimator l;
    int m;
    int n;
    int o;
    float p;
    int q;
    float r;
    boolean s;
    private boolean t;
    int u;
    d.h.b.c v;
    private boolean w;
    private int x;
    private boolean y;
    int z;

    class a implements Runnable {
        final /* synthetic */ View b;
        final /* synthetic */ int c;

        a(View view, int i) {
            this.b = view;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.f0(this.b, this.c);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.h != null) {
                BottomSheetBehavior.this.h.U(fFloatValue);
            }
        }
    }

    class c extends d.h.b.c.AbstractC0059c {
        c() {
        }

        @Override // d.h.b.c.AbstractC0059c
        public int a(View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // d.h.b.c.AbstractC0059c
        public int b(View view, int i, int i2) {
            int iR = BottomSheetBehavior.this.R();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return d.f.f.a.b(i, iR, bottomSheetBehavior.s ? bottomSheetBehavior.A : bottomSheetBehavior.q);
        }

        @Override // d.h.b.c.AbstractC0059c
        public int e(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.s ? bottomSheetBehavior.A : bottomSheetBehavior.q;
        }

        @Override // d.h.b.c.AbstractC0059c
        public void j(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.e0(1);
            }
        }

        @Override // d.h.b.c.AbstractC0059c
        public void k(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.P(i2);
        }

        /* JADX WARN: Code duplicated, block: B:6:0x0010  */
        @Override // d.h.b.c.AbstractC0059c
        public void l(View view, float f2, float f3) {
            int i;
            int i2 = 4;
            if (f3 < 0.0f) {
                if (BottomSheetBehavior.this.b) {
                    i = BottomSheetBehavior.this.n;
                } else {
                    int top = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    int i3 = bottomSheetBehavior.o;
                    if (top > i3) {
                        i = i3;
                        i2 = 6;
                    } else {
                        i = bottomSheetBehavior.m;
                    }
                }
                i2 = 3;
            } else {
                BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                if (bottomSheetBehavior2.s && bottomSheetBehavior2.h0(view, f3) && (view.getTop() > BottomSheetBehavior.this.q || Math.abs(f2) < Math.abs(f3))) {
                    i = BottomSheetBehavior.this.A;
                    i2 = 5;
                } else if (f3 == 0.0f || Math.abs(f2) > Math.abs(f3)) {
                    int top2 = view.getTop();
                    if (!BottomSheetBehavior.this.b) {
                        BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                        int i4 = bottomSheetBehavior3.o;
                        if (top2 < i4) {
                            if (top2 < Math.abs(top2 - bottomSheetBehavior3.q)) {
                                i = BottomSheetBehavior.this.m;
                                i2 = 3;
                            }
                        } else if (Math.abs(top2 - i4) < Math.abs(top2 - BottomSheetBehavior.this.q)) {
                        }
                        i = BottomSheetBehavior.this.o;
                        i2 = 6;
                    } else if (Math.abs(top2 - BottomSheetBehavior.this.n) < Math.abs(top2 - BottomSheetBehavior.this.q)) {
                        i = BottomSheetBehavior.this.n;
                        i2 = 3;
                    }
                    i = BottomSheetBehavior.this.q;
                } else {
                    if (!BottomSheetBehavior.this.b) {
                        int top3 = view.getTop();
                        if (Math.abs(top3 - BottomSheetBehavior.this.o) < Math.abs(top3 - BottomSheetBehavior.this.q)) {
                            i = BottomSheetBehavior.this.o;
                            i2 = 6;
                        }
                    }
                    i = BottomSheetBehavior.this.q;
                }
            }
            BottomSheetBehavior.this.i0(view, i2, i, true);
        }

        @Override // d.h.b.c.AbstractC0059c
        public boolean m(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.u;
            if (i2 == 1 || bottomSheetBehavior.H) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.F == i) {
                WeakReference<View> weakReference = bottomSheetBehavior.C;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.B;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    class d implements d.f.k.a0.f {
        final /* synthetic */ int a;

        d(int i) {
            this.a = i;
        }

        @Override // d.f.k.a0.f
        public boolean a(View view, d.f.k.a0.f.a aVar) {
            BottomSheetBehavior.this.d0(this.a);
            return true;
        }
    }

    public static abstract class e {
        public abstract void a(View view, float f2);

        public abstract void b(View view, int i);
    }

    protected static class f extends d.h.a.a {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f549d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f550e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f551f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f552g;
        boolean h;

        static class a implements Parcelable.ClassLoaderCreator<f> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i) {
                return new f[i];
            }
        }

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f549d = parcel.readInt();
            this.f550e = parcel.readInt();
            this.f551f = parcel.readInt() == 1;
            this.f552g = parcel.readInt() == 1;
            this.h = parcel.readInt() == 1;
        }

        public f(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f549d = bottomSheetBehavior.u;
            this.f550e = ((BottomSheetBehavior) bottomSheetBehavior).f544d;
            this.f551f = ((BottomSheetBehavior) bottomSheetBehavior).b;
            this.f552g = bottomSheetBehavior.s;
            this.h = ((BottomSheetBehavior) bottomSheetBehavior).t;
        }

        @Override // d.h.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f549d);
            parcel.writeInt(this.f550e);
            parcel.writeInt(this.f551f ? 1 : 0);
            parcel.writeInt(this.f552g ? 1 : 0);
            parcel.writeInt(this.h ? 1 : 0);
        }
    }

    private class g implements Runnable {
        private final View b;
        private boolean c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f553d;

        g(View view, int i) {
            this.b = view;
            this.f553d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.h.b.c cVar = BottomSheetBehavior.this.v;
            if (cVar == null || !cVar.k(true)) {
                BottomSheetBehavior.this.e0(this.f553d);
            } else {
                r.V(this.b, this);
            }
            this.c = false;
        }
    }

    public BottomSheetBehavior() {
        this.a = 0;
        this.b = true;
        this.k = null;
        this.p = 0.5f;
        this.r = -1.0f;
        this.u = 4;
        this.D = new ArrayList<>();
        this.J = new c();
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        this.a = 0;
        this.b = true;
        this.k = null;
        this.p = 0.5f;
        this.r = -1.0f;
        this.u = 4;
        this.D = new ArrayList<>();
        this.J = new c();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.a.a.a.k.BottomSheetBehavior_Layout);
        this.f547g = typedArrayObtainStyledAttributes.hasValue(e.a.a.a.k.BottomSheetBehavior_Layout_shapeAppearance);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(e.a.a.a.k.BottomSheetBehavior_Layout_backgroundTint);
        if (zHasValue) {
            N(context, attributeSet, zHasValue, e.a.a.a.x.c.a(context, typedArrayObtainStyledAttributes, e.a.a.a.k.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            M(context, attributeSet, zHasValue);
        }
        O();
        if (Build.VERSION.SDK_INT >= 21) {
            this.r = typedArrayObtainStyledAttributes.getDimension(e.a.a.a.k.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(e.a.a.a.k.BottomSheetBehavior_Layout_behavior_peekHeight);
        Z((typedValuePeekValue == null || (i = typedValuePeekValue.data) != -1) ? typedArrayObtainStyledAttributes.getDimensionPixelSize(e.a.a.a.k.BottomSheetBehavior_Layout_behavior_peekHeight, -1) : i);
        Y(typedArrayObtainStyledAttributes.getBoolean(e.a.a.a.k.BottomSheetBehavior_Layout_behavior_hideable, false));
        W(typedArrayObtainStyledAttributes.getBoolean(e.a.a.a.k.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        c0(typedArrayObtainStyledAttributes.getBoolean(e.a.a.a.k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        b0(typedArrayObtainStyledAttributes.getInt(e.a.a.a.k.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        X(typedArrayObtainStyledAttributes.getFloat(e.a.a.a.k.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        V(typedArrayObtainStyledAttributes.getInt(e.a.a.a.k.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        typedArrayObtainStyledAttributes.recycle();
        this.c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void J(V v, d.f.k.a0.c.a aVar, int i) {
        r.Z(v, aVar, null, new d(i));
    }

    private void K() {
        int iMax = this.f545e ? Math.max(this.f546f, this.A - ((this.z * 9) / 16)) : this.f544d;
        if (this.b) {
            this.q = Math.max(this.A - iMax, this.n);
        } else {
            this.q = this.A - iMax;
        }
    }

    private void L() {
        this.o = (int) (this.A * (1.0f - this.p));
    }

    private void M(Context context, AttributeSet attributeSet, boolean z) {
        N(context, attributeSet, z, null);
    }

    private void N(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.f547g) {
            this.i = k.e(context, attributeSet, e.a.a.a.b.bottomSheetStyle, K).m();
            e.a.a.a.a0.g gVar = new e.a.a.a.a0.g(this.i);
            this.h = gVar;
            gVar.L(context);
            if (z && colorStateList != null) {
                this.h.T(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
            this.h.setTint(typedValue.data);
        }
    }

    private void O() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.l = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.l.addUpdateListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int R() {
        return this.b ? this.n : this.m;
    }

    private float S() {
        VelocityTracker velocityTracker = this.E;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.c);
        return this.E.getYVelocity(this.F);
    }

    private void T() {
        this.F = -1;
        VelocityTracker velocityTracker = this.E;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.E = null;
        }
    }

    private void U(f fVar) {
        int i = this.a;
        if (i == 0) {
            return;
        }
        if (i == -1 || (i & 1) == 1) {
            this.f544d = fVar.f550e;
        }
        int i2 = this.a;
        if (i2 == -1 || (i2 & 2) == 2) {
            this.b = fVar.f551f;
        }
        int i3 = this.a;
        if (i3 == -1 || (i3 & 4) == 4) {
            this.s = fVar.f552g;
        }
        int i4 = this.a;
        if (i4 == -1 || (i4 & 8) == 8) {
            this.t = fVar.h;
        }
    }

    private void g0(int i) {
        V v = this.B.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && r.I(v)) {
            v.post(new a(v, i));
        } else {
            f0(v, i);
        }
    }

    private void j0() {
        V v;
        int i;
        d.f.k.a0.c.a aVar;
        WeakReference<V> weakReference = this.B;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        r.X(v, 524288);
        r.X(v, 262144);
        r.X(v, 1048576);
        if (this.s && this.u != 5) {
            J(v, d.f.k.a0.c.a.h, 5);
        }
        int i2 = this.u;
        if (i2 == 3) {
            i = this.b ? 4 : 6;
            aVar = d.f.k.a0.c.a.f792g;
        } else {
            if (i2 != 4) {
                if (i2 != 6) {
                    return;
                }
                J(v, d.f.k.a0.c.a.f792g, 4);
                J(v, d.f.k.a0.c.a.f791f, 3);
                return;
            }
            i = this.b ? 3 : 6;
            aVar = d.f.k.a0.c.a.f791f;
        }
        J(v, aVar, i);
    }

    private void k0(int i) {
        ValueAnimator valueAnimator;
        if (i == 2) {
            return;
        }
        boolean z = i == 3;
        if (this.j != z) {
            this.j = z;
            if (this.h == null || (valueAnimator = this.l) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.l.reverse();
                return;
            }
            float f2 = z ? 0.0f : 1.0f;
            this.l.setFloatValues(1.0f - f2, f2);
            this.l.start();
        }
    }

    private void l0(boolean z) {
        int iIntValue;
        WeakReference<V> weakReference = this.B;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.I != null) {
                    return;
                } else {
                    this.I = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.B.get()) {
                    if (z) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.I.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        iIntValue = 4;
                    } else {
                        Map<View, Integer> map = this.I;
                        if (map != null && map.containsKey(childAt)) {
                            iIntValue = this.I.get(childAt).intValue();
                        }
                    }
                    r.m0(childAt, iIntValue);
                }
            }
            if (z) {
                return;
            }
            this.I = null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.x = 0;
        this.y = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0082  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void C(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        int iR;
        int i2 = 3;
        if (v.getTop() == R()) {
            e0(3);
            return;
        }
        WeakReference<View> weakReference = this.C;
        if (weakReference != null && view == weakReference.get() && this.y) {
            if (this.x > 0) {
                iR = R();
            } else if (this.s && h0(v, S())) {
                iR = this.A;
                i2 = 5;
            } else if (this.x == 0) {
                int top = v.getTop();
                if (!this.b) {
                    int i3 = this.o;
                    if (top < i3) {
                        if (top < Math.abs(top - this.q)) {
                            iR = this.m;
                        }
                    } else if (Math.abs(top - i3) >= Math.abs(top - this.q)) {
                        iR = this.q;
                        i2 = 4;
                    }
                    iR = this.o;
                    i2 = 6;
                } else if (Math.abs(top - this.n) < Math.abs(top - this.q)) {
                    iR = this.n;
                } else {
                    iR = this.q;
                    i2 = 4;
                }
            } else {
                if (!this.b) {
                    int top2 = v.getTop();
                    if (Math.abs(top2 - this.o) < Math.abs(top2 - this.q)) {
                        iR = this.o;
                        i2 = 6;
                    }
                }
                iR = this.q;
                i2 = 4;
            }
            i0(v, i2, iR, false);
            this.y = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.u == 1 && actionMasked == 0) {
            return true;
        }
        d.h.b.c cVar = this.v;
        if (cVar != null) {
            cVar.z(motionEvent);
        }
        if (actionMasked == 0) {
            T();
        }
        if (this.E == null) {
            this.E = VelocityTracker.obtain();
        }
        this.E.addMovement(motionEvent);
        if (actionMasked == 2 && !this.w && Math.abs(this.G - motionEvent.getY()) > this.v.u()) {
            this.v.b(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.w;
    }

    void P(int i) {
        float f2;
        float fR;
        V v = this.B.get();
        if (v == null || this.D.isEmpty()) {
            return;
        }
        int i2 = this.q;
        if (i > i2) {
            f2 = i2 - i;
            fR = this.A - i2;
        } else {
            f2 = i2 - i;
            fR = i2 - R();
        }
        float f3 = f2 / fR;
        for (int i3 = 0; i3 < this.D.size(); i3++) {
            this.D.get(i3).a(v, f3);
        }
    }

    View Q(View view) {
        if (r.K(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewQ = Q(viewGroup.getChildAt(i));
            if (viewQ != null) {
                return viewQ;
            }
        }
        return null;
    }

    public void V(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.m = i;
    }

    public void W(boolean z) {
        if (this.b == z) {
            return;
        }
        this.b = z;
        if (this.B != null) {
            K();
        }
        e0((this.b && this.u == 6) ? 3 : this.u);
        j0();
    }

    public void X(float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.p = f2;
    }

    public void Y(boolean z) {
        if (this.s != z) {
            this.s = z;
            if (!z && this.u == 5) {
                d0(4);
            }
            j0();
        }
    }

    public void Z(int i) {
        a0(i, false);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
    public final void a0(int i, boolean z) {
        V v;
        boolean z2 = true;
        if (i == -1) {
            if (this.f545e) {
                z2 = false;
            } else {
                this.f545e = true;
            }
        } else if (this.f545e || this.f544d != i) {
            this.f545e = false;
            this.f544d = Math.max(0, i);
        } else {
            z2 = false;
        }
        if (!z2 || this.B == null) {
            return;
        }
        K();
        if (this.u != 4 || (v = this.B.get()) == null) {
            return;
        }
        if (z) {
            g0(this.u);
        } else {
            v.requestLayout();
        }
    }

    public void b0(int i) {
        this.a = i;
    }

    public void c0(boolean z) {
        this.t = z;
    }

    public void d0(int i) {
        if (i == this.u) {
            return;
        }
        if (this.B != null) {
            g0(i);
            return;
        }
        if (i == 4 || i == 3 || i == 6 || (this.s && i == 5)) {
            this.u = i;
        }
    }

    void e0(int i) {
        V v;
        if (this.u == i) {
            return;
        }
        this.u = i;
        WeakReference<V> weakReference = this.B;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (i == 6 || i == 3) {
            l0(true);
        } else if (i == 5 || i == 4) {
            l0(false);
        }
        k0(i);
        for (int i2 = 0; i2 < this.D.size(); i2++) {
            this.D.get(i2).b(v, i);
        }
        j0();
    }

    void f0(View view, int i) {
        int iR;
        int i2;
        if (i == 4) {
            iR = this.q;
        } else if (i == 6) {
            int i3 = this.o;
            if (!this.b || i3 > (i2 = this.n)) {
                iR = i3;
            } else {
                iR = i2;
                i = 3;
            }
        } else if (i == 3) {
            iR = R();
        } else {
            if (!this.s || i != 5) {
                throw new IllegalArgumentException("Illegal state argument: " + i);
            }
            iR = this.A;
        }
        i0(view, i, iR, false);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        super.g(fVar);
        this.B = null;
        this.v = null;
    }

    boolean h0(View view, float f2) {
        if (this.t) {
            return true;
        }
        return view.getTop() >= this.q && Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.q)) / ((float) this.f544d) > 0.5f;
    }

    void i0(View view, int i, int i2, boolean z) {
        if (!(z ? this.v.F(view.getLeft(), i2) : this.v.H(view, view.getLeft(), i2))) {
            e0(i);
            return;
        }
        e0(2);
        k0(i);
        if (this.k == null) {
            this.k = new g(view, i);
        }
        if (((g) this.k).c) {
            this.k.f553d = i;
            return;
        }
        BottomSheetBehavior<V>.g gVar = this.k;
        gVar.f553d = i;
        r.V(view, gVar);
        ((g) this.k).c = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void j() {
        super.j();
        this.B = null;
        this.v = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        d.h.b.c cVar;
        if (!v.isShown()) {
            this.w = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            T();
        }
        if (this.E == null) {
            this.E = VelocityTracker.obtain();
        }
        this.E.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.G = (int) motionEvent.getY();
            if (this.u != 2) {
                WeakReference<View> weakReference = this.C;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.B(view, x, this.G)) {
                    this.F = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.H = true;
                }
            }
            this.w = this.F == -1 && !coordinatorLayout.B(v, x, this.G);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.H = false;
            this.F = -1;
            if (this.w) {
                this.w = false;
                return false;
            }
        }
        if (!this.w && (cVar = this.v) != null && cVar.G(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.C;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.w || this.u == 1 || coordinatorLayout.B(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.v == null || Math.abs(((float) this.G) - motionEvent.getY()) <= ((float) this.v.u())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i) {
        int iR;
        e.a.a.a.a0.g gVar;
        if (r.s(coordinatorLayout) && !r.s(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.B == null) {
            this.f546f = coordinatorLayout.getResources().getDimensionPixelSize(e.a.a.a.d.design_bottom_sheet_peek_height_min);
            this.B = new WeakReference<>(v);
            if (this.f547g && (gVar = this.h) != null) {
                r.f0(v, gVar);
            }
            e.a.a.a.a0.g gVar2 = this.h;
            if (gVar2 != null) {
                float fQ = this.r;
                if (fQ == -1.0f) {
                    fQ = r.q(v);
                }
                gVar2.S(fQ);
                boolean z = this.u == 3;
                this.j = z;
                this.h.U(z ? 0.0f : 1.0f);
            }
            j0();
            if (r.t(v) == 0) {
                r.m0(v, 1);
            }
        }
        if (this.v == null) {
            this.v = d.h.b.c.m(coordinatorLayout, this.J);
        }
        int top = v.getTop();
        coordinatorLayout.I(v, i);
        this.z = coordinatorLayout.getWidth();
        int height = coordinatorLayout.getHeight();
        this.A = height;
        this.n = Math.max(0, height - v.getHeight());
        L();
        K();
        int i2 = this.u;
        if (i2 == 3) {
            iR = R();
        } else if (i2 == 6) {
            iR = this.o;
        } else {
            if (!this.s || i2 != 5) {
                int i3 = this.u;
                if (i3 == 4) {
                    iR = this.q;
                } else if (i3 == 1 || i3 == 2) {
                    r.P(v, top - v.getTop());
                }
                this.C = new WeakReference<>(Q(v));
                return true;
            }
            iR = this.A;
        }
        r.P(v, iR);
        this.C = new WeakReference<>(Q(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.C;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.u != 3 || super.o(coordinatorLayout, v, view, f2, f3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void q(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        int i4;
        if (i3 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.C;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i5 = top - i2;
        if (i2 > 0) {
            if (i5 < R()) {
                iArr[1] = top - R();
                r.P(v, -iArr[1]);
                i4 = 3;
                e0(i4);
            } else {
                iArr[1] = i2;
                r.P(v, -i2);
                e0(1);
            }
        } else if (i2 < 0 && !view.canScrollVertically(-1)) {
            int i6 = this.q;
            if (i5 <= i6 || this.s) {
                iArr[1] = i2;
                r.P(v, -i2);
                e0(1);
            } else {
                iArr[1] = top - i6;
                r.P(v, -iArr[1]);
                i4 = 4;
                e0(i4);
            }
        }
        P(v.getTop());
        this.x = i2;
        this.y = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void x(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        f fVar = (f) parcelable;
        super.x(coordinatorLayout, v, fVar.j());
        U(fVar);
        int i = fVar.f549d;
        if (i == 1 || i == 2) {
            i = 4;
        }
        this.u = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable y(CoordinatorLayout coordinatorLayout, V v) {
        return new f(super.y(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }
}
