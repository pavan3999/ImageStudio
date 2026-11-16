package e.a.a.a.a0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m {

    @Deprecated
    public float a;

    @Deprecated
    public float b;

    @Deprecated
    public float c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<f> f911g = new ArrayList();
    private final List<g> h = new ArrayList();

    class a extends g {
        final /* synthetic */ List b;
        final /* synthetic */ Matrix c;

        a(m mVar, List list, Matrix matrix) {
            this.b = list;
            this.c = matrix;
        }

        @Override // e.a.a.a.a0.m.g
        public void a(Matrix matrix, e.a.a.a.z.a aVar, int i, Canvas canvas) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(this.c, aVar, i, canvas);
            }
        }
    }

    static class b extends g {
        private final d b;

        public b(d dVar) {
            this.b = dVar;
        }

        @Override // e.a.a.a.a0.m.g
        public void a(Matrix matrix, e.a.a.a.z.a aVar, int i, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.b.k(), this.b.o(), this.b.l(), this.b.j()), i, this.b.m(), this.b.n());
        }
    }

    static class c extends g {
        private final e b;
        private final float c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f912d;

        public c(e eVar, float f2, float f3) {
            this.b = eVar;
            this.c = f2;
            this.f912d = f3;
        }

        @Override // e.a.a.a.a0.m.g
        public void a(Matrix matrix, e.a.a.a.z.a aVar, int i, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.b.c - this.f912d, this.b.b - this.c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.c, this.f912d);
            matrix2.preRotate(c());
            aVar.b(canvas, matrix2, rectF, i);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.b.c - this.f912d) / (this.b.b - this.c)));
        }
    }

    public static class d extends f {
        private static final RectF h = new RectF();

        @Deprecated
        public float b;

        @Deprecated
        public float c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f913d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f914e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f915f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f916g;

        public d(float f2, float f3, float f4, float f5) {
            q(f2);
            u(f3);
            r(f4);
            p(f5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f914e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f913d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f915f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f916g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.c;
        }

        private void p(float f2) {
            this.f914e = f2;
        }

        private void q(float f2) {
            this.b = f2;
        }

        private void r(float f2) {
            this.f913d = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f2) {
            this.f915f = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f2) {
            this.f916g = f2;
        }

        private void u(float f2) {
            this.c = f2;
        }

        @Override // e.a.a.a.a0.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            h.set(k(), o(), l(), j());
            path.arcTo(h, m(), n(), false);
            path.transform(matrix);
        }
    }

    public static class e extends f {
        private float b;
        private float c;

        @Override // e.a.a.a.a0.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.b, this.c);
            path.transform(matrix);
        }
    }

    public static abstract class f {
        protected final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    static abstract class g {
        static final Matrix a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, e.a.a.a.z.a aVar, int i, Canvas canvas);

        public final void b(e.a.a.a.z.a aVar, int i, Canvas canvas) {
            a(a, aVar, i, canvas);
        }
    }

    public m() {
        m(0.0f, 0.0f);
    }

    private void b(float f2) {
        if (f() == f2) {
            return;
        }
        float f3 = ((f2 - f()) + 360.0f) % 360.0f;
        if (f3 > 180.0f) {
            return;
        }
        d dVar = new d(h(), i(), h(), i());
        dVar.s(f());
        dVar.t(f3);
        this.h.add(new b(dVar));
        o(f2);
    }

    private void c(g gVar, float f2, float f3) {
        b(f2);
        this.h.add(gVar);
        o(f3);
    }

    private float f() {
        return this.f909e;
    }

    private float g() {
        return this.f910f;
    }

    private void o(float f2) {
        this.f909e = f2;
    }

    private void p(float f2) {
        this.f910f = f2;
    }

    private void q(float f2) {
        this.c = f2;
    }

    private void r(float f2) {
        this.f908d = f2;
    }

    private void s(float f2) {
        this.a = f2;
    }

    private void t(float f2) {
        this.b = f2;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        d dVar = new d(f2, f3, f4, f5);
        dVar.s(f6);
        dVar.t(f7);
        this.f911g.add(dVar);
        b bVar = new b(dVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        c(bVar, f6, z ? (180.0f + f8) % 360.0f : f8);
        double d2 = f8;
        q(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))));
        r(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f911g.size();
        for (int i = 0; i < size; i++) {
            this.f911g.get(i).a(matrix, path);
        }
    }

    g e(Matrix matrix) {
        b(g());
        return new a(this, new ArrayList(this.h), matrix);
    }

    float h() {
        return this.c;
    }

    float i() {
        return this.f908d;
    }

    float j() {
        return this.a;
    }

    float k() {
        return this.b;
    }

    public void l(float f2, float f3) {
        e eVar = new e();
        eVar.b = f2;
        eVar.c = f3;
        this.f911g.add(eVar);
        c cVar = new c(eVar, h(), i());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        q(f2);
        r(f3);
    }

    public void m(float f2, float f3) {
        n(f2, f3, 270.0f, 0.0f);
    }

    public void n(float f2, float f3, float f4, float f5) {
        s(f2);
        t(f3);
        q(f2);
        r(f3);
        o(f4);
        p((f4 + f5) % 360.0f);
        this.f911g.clear();
        this.h.clear();
    }
}
