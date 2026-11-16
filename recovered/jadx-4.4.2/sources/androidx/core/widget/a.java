package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import d.f.k.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    private static final int s = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final View f277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f278e;
    private int h;
    private int i;
    private boolean m;
    boolean n;
    boolean o;
    boolean p;
    private boolean q;
    private boolean r;
    final C0010a b = new C0010a();
    private final Interpolator c = new AccelerateInterpolator();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f279f = {0.0f, 0.0f};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f280g = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] j = {0.0f, 0.0f};
    private float[] k = {0.0f, 0.0f};
    private float[] l = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    private static class C0010a {
        private int a;
        private int b;
        private float c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f281d;
        private float j;
        private int k;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f282e = Long.MIN_VALUE;
        private long i = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f283f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f284g = 0;
        private int h = 0;

        C0010a() {
        }

        private float e(long j) {
            if (j < this.f282e) {
                return 0.0f;
            }
            long j2 = this.i;
            if (j2 < 0 || j < j2) {
                return a.e((j - this.f282e) / this.a, 0.0f, 1.0f) * 0.5f;
            }
            long j3 = j - j2;
            float f2 = this.j;
            return (1.0f - f2) + (f2 * a.e(j3 / this.k, 0.0f, 1.0f));
        }

        private float g(float f2) {
            return ((-4.0f) * f2 * f2) + (f2 * 4.0f);
        }

        public void a() {
            if (this.f283f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fG = g(e(jCurrentAnimationTimeMillis));
            long j = jCurrentAnimationTimeMillis - this.f283f;
            this.f283f = jCurrentAnimationTimeMillis;
            float f2 = j * fG;
            this.f284g = (int) (this.c * f2);
            this.h = (int) (f2 * this.f281d);
        }

        public int b() {
            return this.f284g;
        }

        public int c() {
            return this.h;
        }

        public int d() {
            float f2 = this.c;
            return (int) (f2 / Math.abs(f2));
        }

        public int f() {
            float f2 = this.f281d;
            return (int) (f2 / Math.abs(f2));
        }

        public boolean h() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        public void i() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.f((int) (jCurrentAnimationTimeMillis - this.f282e), 0, this.b);
            this.j = e(jCurrentAnimationTimeMillis);
            this.i = jCurrentAnimationTimeMillis;
        }

        public void j(int i) {
            this.b = i;
        }

        public void k(int i) {
            this.a = i;
        }

        public void l(float f2, float f3) {
            this.c = f2;
            this.f281d = f3;
        }

        public void m() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f282e = jCurrentAnimationTimeMillis;
            this.i = -1L;
            this.f283f = jCurrentAnimationTimeMillis;
            this.j = 0.5f;
            this.f284g = 0;
            this.h = 0;
        }
    }

    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.p) {
                if (aVar.n) {
                    aVar.n = false;
                    aVar.b.m();
                }
                C0010a c0010a = a.this.b;
                if (c0010a.h() || !a.this.u()) {
                    a.this.p = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.o) {
                    aVar2.o = false;
                    aVar2.c();
                }
                c0010a.a();
                a.this.j(c0010a.b(), c0010a.c());
                r.V(a.this.f277d, this);
            }
        }
    }

    public a(View view) {
        this.f277d = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = (int) ((1575.0f * f2) + 0.5f);
        o(f3, f3);
        float f4 = (int) ((f2 * 315.0f) + 0.5f);
        p(f4, f4);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(s);
        r(500);
        q(500);
    }

    private float d(int i, float f2, float f3, float f4) {
        float fH = h(this.f279f[i], f3, this.f280g[i], f2);
        if (fH == 0.0f) {
            return 0.0f;
        }
        float f5 = this.j[i];
        float f6 = this.k[i];
        float f7 = this.l[i];
        float f8 = f5 * f4;
        return fH > 0.0f ? e(fH * f8, f6, f7) : -e((-fH) * f8, f6, f7);
    }

    static float e(float f2, float f3, float f4) {
        if (f2 > f4) {
            return f4;
        }
        return f2 < f3 ? f3 : f2;
    }

    static int f(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        return i < i2 ? i2 : i;
    }

    private float g(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i = this.h;
        if (i == 0 || i == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                if (this.p && this.h == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
        return 0.0f;
    }

    private float h(float f2, float f3, float f4, float f5) {
        float interpolation;
        float fE = e(f2 * f3, 0.0f, f4);
        float fG = g(f3 - f5, fE) - g(f5, fE);
        if (fG < 0.0f) {
            interpolation = -this.c.getInterpolation(-fG);
        } else {
            if (fG <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.c.getInterpolation(fG);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.n) {
            this.p = false;
        } else {
            this.b.i();
        }
    }

    private void v() {
        int i;
        if (this.f278e == null) {
            this.f278e = new b();
        }
        this.p = true;
        this.n = true;
        if (this.m || (i = this.i) <= 0) {
            this.f278e.run();
        } else {
            r.W(this.f277d, this.f278e, i);
        }
        this.m = true;
    }

    public abstract boolean a(int i);

    public abstract boolean b(int i);

    void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f277d.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public abstract void j(int i, int i2);

    public a k(int i) {
        this.i = i;
        return this;
    }

    public a l(int i) {
        this.h = i;
        return this;
    }

    public a m(boolean z) {
        if (this.q && !z) {
            i();
        }
        this.q = z;
        return this;
    }

    public a n(float f2, float f3) {
        float[] fArr = this.f280g;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public a o(float f2, float f3) {
        float[] fArr = this.l;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.q) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                i();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    i();
                }
            }
            return this.r && this.p;
        }
        this.o = true;
        this.m = false;
        this.b.l(d(0, motionEvent.getX(), view.getWidth(), this.f277d.getWidth()), d(1, motionEvent.getY(), view.getHeight(), this.f277d.getHeight()));
        if (!this.p && u()) {
            v();
        }
        if (this.r) {
            return false;
        }
    }

    public a p(float f2, float f3) {
        float[] fArr = this.k;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a q(int i) {
        this.b.j(i);
        return this;
    }

    public a r(int i) {
        this.b.k(i);
        return this;
    }

    public a s(float f2, float f3) {
        float[] fArr = this.f279f;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public a t(float f2, float f3) {
        float[] fArr = this.j;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    boolean u() {
        C0010a c0010a = this.b;
        int iF = c0010a.f();
        int iD = c0010a.d();
        return (iF != 0 && b(iF)) || (iD != 0 && a(iD));
    }
}
