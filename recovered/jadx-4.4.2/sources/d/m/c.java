package d.m;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends m {
    private static final String[] N = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> O = new b(PointF.class, "boundsOrigin");
    private static final Property<k, PointF> P = new C0062c(PointF.class, "topLeft");
    private static final Property<k, PointF> Q = new d(PointF.class, "bottomRight");
    private static final Property<View, PointF> R = new e(PointF.class, "bottomRight");
    private static final Property<View, PointF> S = new f(PointF.class, "topLeft");
    private static final Property<View, PointF> T = new g(PointF.class, "position");
    private static d.m.k U = new d.m.k();
    private int[] K = new int[2];
    private boolean L = false;
    private boolean M = false;

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ BitmapDrawable b;
        final /* synthetic */ View c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f818d;

        a(c cVar, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f2) {
            this.a = viewGroup;
            this.b = bitmapDrawable;
            this.c = view;
            this.f818d = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c0.b(this.a).b(this.b);
            c0.g(this.c, this.f818d);
        }
    }

    static class b extends Property<Drawable, PointF> {
        private Rect a;

        b(Class cls, String str) {
            super(cls, str);
            this.a = new Rect();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.a);
            Rect rect = this.a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.a);
            this.a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.a);
        }
    }

    /* JADX INFO: renamed from: d.m.c$c, reason: collision with other inner class name */
    static class C0062c extends Property<k, PointF> {
        C0062c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    static class d extends Property<k, PointF> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    static class e extends Property<View, PointF> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            c0.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    static class f extends Property<View, PointF> {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            c0.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    static class g extends Property<View, PointF> {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            c0.f(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    class h extends AnimatorListenerAdapter {
        final /* synthetic */ k a;
        private k mViewBounds;

        h(c cVar, k kVar) {
            this.a = kVar;
            this.mViewBounds = this.a;
        }
    }

    class i extends AnimatorListenerAdapter {
        private boolean a;
        final /* synthetic */ View b;
        final /* synthetic */ Rect c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f819d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f820e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f821f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f822g;

        i(c cVar, View view, Rect rect, int i, int i2, int i3, int i4) {
            this.b = view;
            this.c = rect;
            this.f819d = i;
            this.f820e = i2;
            this.f821f = i3;
            this.f822g = i4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            d.f.k.r.i0(this.b, this.c);
            c0.f(this.b, this.f819d, this.f820e, this.f821f, this.f822g);
        }
    }

    class j extends n {
        boolean a = false;
        final /* synthetic */ ViewGroup b;

        j(c cVar, ViewGroup viewGroup) {
            this.b = viewGroup;
        }

        @Override // d.m.n, d.m.m.f
        public void b(m mVar) {
            x.c(this.b, false);
            this.a = true;
        }

        @Override // d.m.m.f
        public void c(m mVar) {
            if (!this.a) {
                x.c(this.b, false);
            }
            mVar.P(this);
        }

        @Override // d.m.n, d.m.m.f
        public void d(m mVar) {
            x.c(this.b, false);
        }

        @Override // d.m.n, d.m.m.f
        public void e(m mVar) {
            x.c(this.b, true);
        }
    }

    private static class k {
        private int a;
        private int b;
        private int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f823d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private View f824e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f825f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f826g;

        k(View view) {
            this.f824e = view;
        }

        private void b() {
            c0.f(this.f824e, this.a, this.b, this.c, this.f823d);
            this.f825f = 0;
            this.f826g = 0;
        }

        void a(PointF pointF) {
            this.c = Math.round(pointF.x);
            this.f823d = Math.round(pointF.y);
            int i = this.f826g + 1;
            this.f826g = i;
            if (this.f825f == i) {
                b();
            }
        }

        void c(PointF pointF) {
            this.a = Math.round(pointF.x);
            this.b = Math.round(pointF.y);
            int i = this.f825f + 1;
            this.f825f = i;
            if (i == this.f826g) {
                b();
            }
        }
    }

    private void c0(s sVar) {
        View view = sVar.b;
        if (!d.f.k.r.J(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        sVar.a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        sVar.a.put("android:changeBounds:parent", sVar.b.getParent());
        if (this.M) {
            sVar.b.getLocationInWindow(this.K);
            sVar.a.put("android:changeBounds:windowX", Integer.valueOf(this.K[0]));
            sVar.a.put("android:changeBounds:windowY", Integer.valueOf(this.K[1]));
        }
        if (this.L) {
            sVar.a.put("android:changeBounds:clip", d.f.k.r.o(view));
        }
    }

    private boolean d0(View view, View view2) {
        if (!this.M) {
            return true;
        }
        s sVarT = t(view, true);
        if (sVarT == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == sVarT.b) {
            return true;
        }
        return false;
    }

    @Override // d.m.m
    public String[] D() {
        return N;
    }

    @Override // d.m.m
    public void g(s sVar) {
        c0(sVar);
    }

    @Override // d.m.m
    public void j(s sVar) {
        c0(sVar);
    }

    @Override // d.m.m
    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        int i2;
        View view;
        ObjectAnimator objectAnimatorA;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator animatorC;
        Path pathA;
        Property<View, PointF> property;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map<String, Object> map = sVar.a;
        Map<String, Object> map2 = sVar2.a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar2.b;
        if (!d0(viewGroup2, viewGroup3)) {
            int iIntValue = ((Integer) sVar.a.get("android:changeBounds:windowX")).intValue();
            int iIntValue2 = ((Integer) sVar.a.get("android:changeBounds:windowY")).intValue();
            int iIntValue3 = ((Integer) sVar2.a.get("android:changeBounds:windowX")).intValue();
            int iIntValue4 = ((Integer) sVar2.a.get("android:changeBounds:windowY")).intValue();
            if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.K);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(bitmapCreateBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            float fC = c0.c(view2);
            c0.g(view2, 0.0f);
            c0.b(viewGroup).d(bitmapDrawable);
            d.m.g gVarV = v();
            int[] iArr = this.K;
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, d.m.i.a(O, gVarV.a(iIntValue - iArr[0], iIntValue2 - iArr[1], iIntValue3 - iArr[0], iIntValue4 - iArr[1])));
            objectAnimatorOfPropertyValuesHolder.addListener(new a(this, viewGroup, bitmapDrawable, view2, fC));
            return objectAnimatorOfPropertyValuesHolder;
        }
        Rect rect2 = (Rect) sVar.a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) sVar2.a.get("android:changeBounds:bounds");
        int i4 = rect2.left;
        int i5 = rect3.left;
        int i6 = rect2.top;
        int i7 = rect3.top;
        int i8 = rect2.right;
        int i9 = rect3.right;
        int i10 = rect2.bottom;
        int i11 = rect3.bottom;
        int i12 = i8 - i4;
        int i13 = i10 - i6;
        int i14 = i9 - i5;
        int i15 = i11 - i7;
        Rect rect4 = (Rect) sVar.a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) sVar2.a.get("android:changeBounds:clip");
        if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
            i2 = 0;
        } else {
            i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
            if (i8 != i9 || i10 != i11) {
                i2++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i2++;
        }
        if (i2 <= 0) {
            return null;
        }
        if (this.L) {
            c0.f(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
            if (i4 == i5 && i6 == i7) {
                objectAnimatorA = null;
            } else {
                view = view2;
                objectAnimatorA = d.m.f.a(view, T, v().a(i4, i6, i5, i7));
            }
            if (rect4 == null) {
                i3 = 0;
                rect = new Rect(0, 0, i12, i13);
            } else {
                i3 = 0;
                rect = rect4;
            }
            Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
            if (rect.equals(rect6)) {
                objectAnimator = null;
            } else {
                d.f.k.r.i0(view, rect);
                d.m.k kVar = U;
                Object[] objArr = new Object[2];
                objArr[i3] = rect;
                objArr[1] = rect6;
                ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", kVar, objArr);
                objectAnimatorOfObject.addListener(new i(this, view, rect5, i5, i7, i9, i11));
                objectAnimator = objectAnimatorOfObject;
            }
            animatorC = r.c(objectAnimatorA, objectAnimator);
        } else {
            c0.f(view, i4, i6, i8, i10);
            if (i2 == 2) {
                if (i12 == i14 && i13 == i15) {
                    pathA = v().a(i4, i6, i5, i7);
                    property = T;
                } else {
                    k kVar2 = new k(view);
                    ObjectAnimator objectAnimatorA2 = d.m.f.a(kVar2, P, v().a(i4, i6, i5, i7));
                    ObjectAnimator objectAnimatorA3 = d.m.f.a(kVar2, Q, v().a(i8, i10, i9, i11));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                    animatorSet.addListener(new h(this, kVar2));
                    animatorC = animatorSet;
                }
            } else if (i4 == i5 && i6 == i7) {
                pathA = v().a(i8, i10, i9, i11);
                property = R;
            } else {
                pathA = v().a(i4, i6, i5, i7);
                property = S;
            }
            animatorC = d.m.f.a(view, property, pathA);
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            x.c(viewGroup4, true);
            a(new j(this, viewGroup4));
        }
        return animatorC;
    }
}
