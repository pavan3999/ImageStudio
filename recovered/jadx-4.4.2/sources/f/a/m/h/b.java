package f.a.m.h;

/* JADX INFO: loaded from: classes.dex */
public final class b<T> {
    final float a;
    int b;
    int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    T[] f990e;

    public b() {
        this(16, 0.75f);
    }

    public b(int i, float f2) {
        this.a = f2;
        int iA = c.a(i);
        this.b = iA - 1;
        this.f989d = (int) (f2 * iA);
        this.f990e = (T[]) new Object[iA];
    }

    static int c(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public boolean a(T t) {
        T t2;
        T[] tArr = this.f990e;
        int i = this.b;
        int iC = c(t.hashCode()) & i;
        T t3 = tArr[iC];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                iC = (iC + 1) & i;
                t2 = tArr[iC];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[iC] = t;
        int i2 = this.c + 1;
        this.c = i2;
        if (i2 >= this.f989d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.f990e;
    }

    void d() {
        T[] tArr = this.f990e;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new Object[i];
        int i3 = this.c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                this.b = i2;
                this.f989d = (int) (i * this.a);
                this.f990e = tArr2;
                return;
            }
            do {
                length--;
            } while (tArr[length] == null);
            int iC = c(tArr[length].hashCode()) & i2;
            if (tArr2[iC] != null) {
                do {
                    iC = (iC + 1) & i2;
                } while (tArr2[iC] != null);
            }
            tArr2[iC] = tArr[length];
            i3 = i4;
        }
    }

    public boolean e(T t) {
        T t2;
        T[] tArr = this.f990e;
        int i = this.b;
        int iC = c(t.hashCode()) & i;
        T t3 = tArr[iC];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return f(iC, tArr, i);
        }
        do {
            iC = (iC + 1) & i;
            t2 = tArr[iC];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return f(iC, tArr, i);
    }

    boolean f(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t != null) {
                    int iC = c(t.hashCode()) & i2;
                    if (i > i3) {
                        if (i >= iC && iC > i3) {
                            break;
                        }
                        i4 = i3 + 1;
                    } else {
                        if (i >= iC || iC > i3) {
                            break;
                        }
                        i4 = i3 + 1;
                    }
                } else {
                    tArr[i] = null;
                    return true;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }
}
