package e.a.a.a.a0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: loaded from: classes.dex */
public class k {
    d a;
    d b;
    d c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    d f894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    e.a.a.a.a0.c f895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    e.a.a.a.a0.c f896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    e.a.a.a.a0.c f897g;
    e.a.a.a.a0.c h;
    f i;
    f j;
    f k;
    f l;

    public static final class b {
        private d a;
        private d b;
        private d c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d f898d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private e.a.a.a.a0.c f899e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private e.a.a.a.a0.c f900f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private e.a.a.a.a0.c f901g;
        private e.a.a.a.a0.c h;
        private f i;
        private f j;
        private f k;
        private f l;

        public b() {
            this.a = h.b();
            this.b = h.b();
            this.c = h.b();
            this.f898d = h.b();
            this.f899e = new e.a.a.a.a0.a(0.0f);
            this.f900f = new e.a.a.a.a0.a(0.0f);
            this.f901g = new e.a.a.a.a0.a(0.0f);
            this.h = new e.a.a.a.a0.a(0.0f);
            this.i = h.c();
            this.j = h.c();
            this.k = h.c();
            this.l = h.c();
        }

        public b(k kVar) {
            this.a = h.b();
            this.b = h.b();
            this.c = h.b();
            this.f898d = h.b();
            this.f899e = new e.a.a.a.a0.a(0.0f);
            this.f900f = new e.a.a.a.a0.a(0.0f);
            this.f901g = new e.a.a.a.a0.a(0.0f);
            this.h = new e.a.a.a.a0.a(0.0f);
            this.i = h.c();
            this.j = h.c();
            this.k = h.c();
            this.l = h.c();
            this.a = kVar.a;
            this.b = kVar.b;
            this.c = kVar.c;
            this.f898d = kVar.f894d;
            this.f899e = kVar.f895e;
            this.f900f = kVar.f896f;
            this.f901g = kVar.f897g;
            this.h = kVar.h;
            this.i = kVar.i;
            this.j = kVar.j;
            this.k = kVar.k;
            this.l = kVar.l;
        }

        private static float n(d dVar) {
            if (dVar instanceof j) {
                return ((j) dVar).a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).a;
            }
            return -1.0f;
        }

        public b A(e.a.a.a.a0.c cVar) {
            this.f899e = cVar;
            return this;
        }

        public b B(int i, e.a.a.a.a0.c cVar) {
            C(h.a(i));
            E(cVar);
            return this;
        }

        public b C(d dVar) {
            this.b = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                D(fN);
            }
            return this;
        }

        public b D(float f2) {
            this.f900f = new e.a.a.a.a0.a(f2);
            return this;
        }

        public b E(e.a.a.a.a0.c cVar) {
            this.f900f = cVar;
            return this;
        }

        public k m() {
            return new k(this);
        }

        public b o(float f2) {
            z(f2);
            D(f2);
            v(f2);
            r(f2);
            return this;
        }

        public b p(int i, e.a.a.a.a0.c cVar) {
            q(h.a(i));
            s(cVar);
            return this;
        }

        public b q(d dVar) {
            this.f898d = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                r(fN);
            }
            return this;
        }

        public b r(float f2) {
            this.h = new e.a.a.a.a0.a(f2);
            return this;
        }

        public b s(e.a.a.a.a0.c cVar) {
            this.h = cVar;
            return this;
        }

        public b t(int i, e.a.a.a.a0.c cVar) {
            u(h.a(i));
            w(cVar);
            return this;
        }

        public b u(d dVar) {
            this.c = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                v(fN);
            }
            return this;
        }

        public b v(float f2) {
            this.f901g = new e.a.a.a.a0.a(f2);
            return this;
        }

        public b w(e.a.a.a.a0.c cVar) {
            this.f901g = cVar;
            return this;
        }

        public b x(int i, e.a.a.a.a0.c cVar) {
            y(h.a(i));
            A(cVar);
            return this;
        }

        public b y(d dVar) {
            this.a = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                z(fN);
            }
            return this;
        }

        public b z(float f2) {
            this.f899e = new e.a.a.a.a0.a(f2);
            return this;
        }
    }

    public interface c {
        e.a.a.a.a0.c a(e.a.a.a.a0.c cVar);
    }

    public k() {
        this.a = h.b();
        this.b = h.b();
        this.c = h.b();
        this.f894d = h.b();
        this.f895e = new e.a.a.a.a0.a(0.0f);
        this.f896f = new e.a.a.a.a0.a(0.0f);
        this.f897g = new e.a.a.a.a0.a(0.0f);
        this.h = new e.a.a.a.a0.a(0.0f);
        this.i = h.c();
        this.j = h.c();
        this.k = h.c();
        this.l = h.c();
    }

    private k(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.f894d = bVar.f898d;
        this.f895e = bVar.f899e;
        this.f896f = bVar.f900f;
        this.f897g = bVar.f901g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i, int i2) {
        return c(context, i, i2, 0);
    }

    private static b c(Context context, int i, int i2, int i3) {
        return d(context, i, i2, new e.a.a.a.a0.a(i3));
    }

    private static b d(Context context, int i, int i2, e.a.a.a.a0.c cVar) {
        if (i2 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, e.a.a.a.k.ShapeAppearance);
        try {
            int i3 = typedArrayObtainStyledAttributes.getInt(e.a.a.a.k.ShapeAppearance_cornerFamily, 0);
            int i4 = typedArrayObtainStyledAttributes.getInt(e.a.a.a.k.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = typedArrayObtainStyledAttributes.getInt(e.a.a.a.k.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = typedArrayObtainStyledAttributes.getInt(e.a.a.a.k.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = typedArrayObtainStyledAttributes.getInt(e.a.a.a.k.ShapeAppearance_cornerFamilyBottomLeft, i3);
            e.a.a.a.a0.c cVarM = m(typedArrayObtainStyledAttributes, e.a.a.a.k.ShapeAppearance_cornerSize, cVar);
            e.a.a.a.a0.c cVarM2 = m(typedArrayObtainStyledAttributes, e.a.a.a.k.ShapeAppearance_cornerSizeTopLeft, cVarM);
            e.a.a.a.a0.c cVarM3 = m(typedArrayObtainStyledAttributes, e.a.a.a.k.ShapeAppearance_cornerSizeTopRight, cVarM);
            e.a.a.a.a0.c cVarM4 = m(typedArrayObtainStyledAttributes, e.a.a.a.k.ShapeAppearance_cornerSizeBottomRight, cVarM);
            e.a.a.a.a0.c cVarM5 = m(typedArrayObtainStyledAttributes, e.a.a.a.k.ShapeAppearance_cornerSizeBottomLeft, cVarM);
            b bVar = new b();
            bVar.x(i4, cVarM2);
            bVar.B(i5, cVarM3);
            bVar.t(i6, cVarM4);
            bVar.p(i7, cVarM5);
            return bVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i, int i2) {
        return f(context, attributeSet, i, i2, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        return g(context, attributeSet, i, i2, new e.a.a.a.a0.a(i3));
    }

    public static b g(Context context, AttributeSet attributeSet, int i, int i2, e.a.a.a.a0.c cVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.a.a.a.k.MaterialShape, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(e.a.a.a.k.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(e.a.a.a.k.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    private static e.a.a.a.a0.c m(TypedArray typedArray, int i, e.a.a.a.a0.c cVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue == null) {
            return cVar;
        }
        int i2 = typedValuePeekValue.type;
        if (i2 == 5) {
            return new e.a.a.a.a0.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i2 == 6 ? new i(typedValuePeekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public f h() {
        return this.k;
    }

    public d i() {
        return this.f894d;
    }

    public e.a.a.a.a0.c j() {
        return this.h;
    }

    public d k() {
        return this.c;
    }

    public e.a.a.a.a0.c l() {
        return this.f897g;
    }

    public f n() {
        return this.l;
    }

    public f o() {
        return this.j;
    }

    public f p() {
        return this.i;
    }

    public d q() {
        return this.a;
    }

    public e.a.a.a.a0.c r() {
        return this.f895e;
    }

    public d s() {
        return this.b;
    }

    public e.a.a.a.a0.c t() {
        return this.f896f;
    }

    public boolean u(RectF rectF) {
        boolean z = this.l.getClass().equals(f.class) && this.j.getClass().equals(f.class) && this.i.getClass().equals(f.class) && this.k.getClass().equals(f.class);
        float fA = this.f895e.a(rectF);
        return z && ((this.f896f.a(rectF) > fA ? 1 : (this.f896f.a(rectF) == fA ? 0 : -1)) == 0 && (this.h.a(rectF) > fA ? 1 : (this.h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f897g.a(rectF) > fA ? 1 : (this.f897g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.b instanceof j) && (this.a instanceof j) && (this.c instanceof j) && (this.f894d instanceof j));
    }

    public b v() {
        return new b(this);
    }

    public k w(float f2) {
        b bVarV = v();
        bVarV.o(f2);
        return bVarV.m();
    }

    public k x(c cVar) {
        b bVarV = v();
        bVarV.A(cVar.a(r()));
        bVarV.E(cVar.a(t()));
        bVarV.s(cVar.a(j()));
        bVarV.w(cVar.a(l()));
        return bVarV.m();
    }
}
