package d.d;

/* JADX INFO: loaded from: classes.dex */
public class d<E> implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f734f = new Object();
    private boolean b;
    private long[] c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f736e;

    public d() {
        this(10);
    }

    public d(int i) {
        this.b = false;
        if (i == 0) {
            this.c = c.b;
            this.f735d = c.c;
        } else {
            int iF = c.f(i);
            this.c = new long[iF];
            this.f735d = new Object[iF];
        }
    }

    private void e() {
        int i = this.f736e;
        long[] jArr = this.c;
        Object[] objArr = this.f735d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f734f) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.f736e = i2;
    }

    public void a(long j, E e2) {
        int i = this.f736e;
        if (i != 0 && j <= this.c[i - 1]) {
            j(j, e2);
            return;
        }
        if (this.b && this.f736e >= this.c.length) {
            e();
        }
        int i2 = this.f736e;
        if (i2 >= this.c.length) {
            int iF = c.f(i2 + 1);
            long[] jArr = new long[iF];
            Object[] objArr = new Object[iF];
            long[] jArr2 = this.c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f735d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.c = jArr;
            this.f735d = objArr;
        }
        this.c[i2] = j;
        this.f735d[i2] = e2;
        this.f736e = i2 + 1;
    }

    public void b() {
        int i = this.f736e;
        Object[] objArr = this.f735d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f736e = 0;
        this.b = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.c = (long[]) this.c.clone();
            dVar.f735d = (Object[]) this.f735d.clone();
            return dVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    @Deprecated
    public void d(long j) {
        k(j);
    }

    public E f(long j) {
        return g(j, null);
    }

    public E g(long j, E e2) {
        int iB = c.b(this.c, this.f736e, j);
        if (iB >= 0) {
            Object[] objArr = this.f735d;
            if (objArr[iB] != f734f) {
                return (E) objArr[iB];
            }
        }
        return e2;
    }

    public int h(long j) {
        if (this.b) {
            e();
        }
        return c.b(this.c, this.f736e, j);
    }

    public long i(int i) {
        if (this.b) {
            e();
        }
        return this.c[i];
    }

    public void j(long j, E e2) {
        int iB = c.b(this.c, this.f736e, j);
        if (iB >= 0) {
            this.f735d[iB] = e2;
            return;
        }
        int iB2 = iB ^ (-1);
        if (iB2 < this.f736e) {
            Object[] objArr = this.f735d;
            if (objArr[iB2] == f734f) {
                this.c[iB2] = j;
                objArr[iB2] = e2;
                return;
            }
        }
        if (this.b && this.f736e >= this.c.length) {
            e();
            iB2 = c.b(this.c, this.f736e, j) ^ (-1);
        }
        int i = this.f736e;
        if (i >= this.c.length) {
            int iF = c.f(i + 1);
            long[] jArr = new long[iF];
            Object[] objArr2 = new Object[iF];
            long[] jArr2 = this.c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f735d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.c = jArr;
            this.f735d = objArr2;
        }
        int i2 = this.f736e;
        if (i2 - iB2 != 0) {
            long[] jArr3 = this.c;
            int i3 = iB2 + 1;
            System.arraycopy(jArr3, iB2, jArr3, i3, i2 - iB2);
            Object[] objArr4 = this.f735d;
            System.arraycopy(objArr4, iB2, objArr4, i3, this.f736e - iB2);
        }
        this.c[iB2] = j;
        this.f735d[iB2] = e2;
        this.f736e++;
    }

    public void k(long j) {
        int iB = c.b(this.c, this.f736e, j);
        if (iB >= 0) {
            Object[] objArr = this.f735d;
            Object obj = objArr[iB];
            Object obj2 = f734f;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.b = true;
            }
        }
    }

    public void l(int i) {
        Object[] objArr = this.f735d;
        Object obj = objArr[i];
        Object obj2 = f734f;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.b = true;
        }
    }

    public int m() {
        if (this.b) {
            e();
        }
        return this.f736e;
    }

    public E n(int i) {
        if (this.b) {
            e();
        }
        return (E) this.f735d[i];
    }

    public String toString() {
        if (m() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f736e * 28);
        sb.append('{');
        for (int i = 0; i < this.f736e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(i(i));
            sb.append('=');
            E eN = n(i);
            if (eN != this) {
                sb.append(eN);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
