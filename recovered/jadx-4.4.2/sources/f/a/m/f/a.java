package f.a.m.f;

import f.a.m.h.c;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes.dex */
public final class a<T> implements Object<T> {
    static final int j = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object k = new Object();
    int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    AtomicReferenceArray<Object> f966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f967g;
    AtomicReferenceArray<Object> h;
    final AtomicLong b = new AtomicLong();
    final AtomicLong i = new AtomicLong();

    public a(int i) {
        int iA = c.a(Math.max(8, i));
        int i2 = iA - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(iA + 1);
        this.f966f = atomicReferenceArray;
        this.f965e = i2;
        a(iA);
        this.h = atomicReferenceArray;
        this.f967g = i2;
        this.f964d = i2 - 1;
        r(0L);
    }

    private void a(int i) {
        this.c = Math.min(i / 4, j);
    }

    private static int b(int i) {
        return i;
    }

    private static int c(long j2, int i) {
        int i2 = ((int) j2) & i;
        b(i2);
        return i2;
    }

    private long e() {
        return this.i.get();
    }

    private long f() {
        return this.b.get();
    }

    private long i() {
        return this.i.get();
    }

    private static <E> Object j(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    private AtomicReferenceArray<Object> k(AtomicReferenceArray<Object> atomicReferenceArray) {
        int length = atomicReferenceArray.length() - 1;
        b(length);
        return (AtomicReferenceArray) j(atomicReferenceArray, length);
    }

    private long l() {
        return this.b.get();
    }

    private T m(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i) {
        this.h = atomicReferenceArray;
        int iC = c(j2, i);
        T t = (T) j(atomicReferenceArray, iC);
        if (t != null) {
            p(atomicReferenceArray, iC, null);
            o(j2 + 1);
        }
        return t;
    }

    private void n(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f966f = atomicReferenceArray2;
        this.f964d = (j3 + j2) - 1;
        p(atomicReferenceArray2, i, t);
        q(atomicReferenceArray, atomicReferenceArray2);
        p(atomicReferenceArray, i, k);
        r(j2 + 1);
    }

    private void o(long j2) {
        this.i.lazySet(j2);
    }

    private static void p(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private void q(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        int length = atomicReferenceArray.length() - 1;
        b(length);
        p(atomicReferenceArray, length, atomicReferenceArray2);
    }

    private void r(long j2) {
        this.b.lazySet(j2);
    }

    private boolean s(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i) {
        p(atomicReferenceArray, i, t);
        r(j2 + 1);
        return true;
    }

    public void clear() {
        while (true) {
            if (d() == null && isEmpty()) {
                return;
            }
        }
    }

    public T d() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.h;
        long jE = e();
        int i = this.f967g;
        int iC = c(jE, i);
        T t = (T) j(atomicReferenceArray, iC);
        boolean z = t == k;
        if (t == null || z) {
            if (z) {
                return m(k(atomicReferenceArray), jE, i);
            }
            return null;
        }
        p(atomicReferenceArray, iC, null);
        o(jE + 1);
        return t;
    }

    public boolean h(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.f966f;
        long jF = f();
        int i = this.f965e;
        int iC = c(jF, i);
        if (jF < this.f964d) {
            return s(atomicReferenceArray, t, jF, iC);
        }
        long j2 = ((long) this.c) + jF;
        if (j(atomicReferenceArray, c(j2, i)) == null) {
            this.f964d = j2 - 1;
            return s(atomicReferenceArray, t, jF, iC);
        }
        if (j(atomicReferenceArray, c(1 + jF, i)) == null) {
            return s(atomicReferenceArray, t, jF, iC);
        }
        n(atomicReferenceArray, jF, iC, t, i);
        return true;
    }

    public boolean isEmpty() {
        return l() == i();
    }
}
