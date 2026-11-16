package e.a.a.a.a0;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public class l {
    private final m[] a = new m[4];
    private final Matrix[] b = new Matrix[4];
    private final Matrix[] c = new Matrix[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PointF f902d = new PointF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final m f903e = new m();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float[] f904f = new float[2];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float[] f905g = new float[2];

    public interface a {
        void a(m mVar, Matrix matrix, int i);

        void b(m mVar, Matrix matrix, int i);
    }

    static final class b {
        public final k a;
        public final Path b;
        public final RectF c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a f906d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f907e;

        b(k kVar, float f2, RectF rectF, a aVar, Path path) {
            this.f906d = aVar;
            this.a = kVar;
            this.f907e = f2;
            this.c = rectF;
            this.b = path;
        }
    }

    public l() {
        for (int i = 0; i < 4; i++) {
            this.a[i] = new m();
            this.b[i] = new Matrix();
            this.c[i] = new Matrix();
        }
    }

    private float a(int i) {
        return (i + 1) * 90;
    }

    private void b(b bVar, int i) {
        this.f904f[0] = this.a[i].j();
        this.f904f[1] = this.a[i].k();
        this.b[i].mapPoints(this.f904f);
        Path path = bVar.b;
        float[] fArr = this.f904f;
        if (i == 0) {
            path.moveTo(fArr[0], fArr[1]);
        } else {
            path.lineTo(fArr[0], fArr[1]);
        }
        this.a[i].d(this.b[i], bVar.b);
        a aVar = bVar.f906d;
        if (aVar != null) {
            aVar.a(this.a[i], this.b[i], i);
        }
    }

    private void c(b bVar, int i) {
        int i2 = (i + 1) % 4;
        this.f904f[0] = this.a[i].h();
        this.f904f[1] = this.a[i].i();
        this.b[i].mapPoints(this.f904f);
        this.f905g[0] = this.a[i2].j();
        this.f905g[1] = this.a[i2].k();
        this.b[i2].mapPoints(this.f905g);
        float[] fArr = this.f904f;
        float f2 = fArr[0];
        float[] fArr2 = this.f905g;
        float fMax = Math.max(((float) Math.hypot(f2 - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
        float fI = i(bVar.c, i);
        this.f903e.m(0.0f, 0.0f);
        j(i, bVar.a).a(fMax, fI, bVar.f907e, this.f903e);
        this.f903e.d(this.c[i], bVar.b);
        a aVar = bVar.f906d;
        if (aVar != null) {
            aVar.b(this.f903e, this.c[i], i);
        }
    }

    private void f(int i, RectF rectF, PointF pointF) {
        float f2;
        float f3;
        if (i != 1) {
            if (i != 2) {
                f2 = i != 3 ? rectF.right : rectF.left;
                f3 = rectF.top;
            } else {
                f2 = rectF.left;
            }
            pointF.set(f2, f3);
        }
        f2 = rectF.right;
        f3 = rectF.bottom;
        pointF.set(f2, f3);
    }

    private c g(int i, k kVar) {
        if (i == 1) {
            return kVar.l();
        }
        if (i != 2) {
            return i != 3 ? kVar.t() : kVar.r();
        }
        return kVar.j();
    }

    private d h(int i, k kVar) {
        if (i == 1) {
            return kVar.k();
        }
        if (i != 2) {
            return i != 3 ? kVar.s() : kVar.q();
        }
        return kVar.i();
    }

    private float i(RectF rectF, int i) {
        float fCenterX;
        float f2;
        float[] fArr = this.f904f;
        m[] mVarArr = this.a;
        fArr[0] = mVarArr[i].c;
        fArr[1] = mVarArr[i].f908d;
        this.b[i].mapPoints(fArr);
        if (i == 1 || i == 3) {
            fCenterX = rectF.centerX();
            f2 = this.f904f[0];
        } else {
            fCenterX = rectF.centerY();
            f2 = this.f904f[1];
        }
        return Math.abs(fCenterX - f2);
    }

    private f j(int i, k kVar) {
        if (i == 1) {
            return kVar.h();
        }
        if (i != 2) {
            return i != 3 ? kVar.o() : kVar.p();
        }
        return kVar.n();
    }

    private void k(b bVar, int i) {
        h(i, bVar.a).b(this.a[i], 90.0f, bVar.f907e, bVar.c, g(i, bVar.a));
        float fA = a(i);
        this.b[i].reset();
        f(i, bVar.c, this.f902d);
        Matrix matrix = this.b[i];
        PointF pointF = this.f902d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.b[i].preRotate(fA);
    }

    private void l(int i) {
        this.f904f[0] = this.a[i].h();
        this.f904f[1] = this.a[i].i();
        this.b[i].mapPoints(this.f904f);
        float fA = a(i);
        this.c[i].reset();
        Matrix matrix = this.c[i];
        float[] fArr = this.f904f;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.c[i].preRotate(fA);
    }

    public void d(k kVar, float f2, RectF rectF, Path path) {
        e(kVar, f2, rectF, null, path);
    }

    public void e(k kVar, float f2, RectF rectF, a aVar, Path path) {
        path.rewind();
        b bVar = new b(kVar, f2, rectF, aVar, path);
        for (int i = 0; i < 4; i++) {
            k(bVar, i);
            l(i);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            b(bVar, i2);
            c(bVar, i2);
        }
        path.close();
    }
}
