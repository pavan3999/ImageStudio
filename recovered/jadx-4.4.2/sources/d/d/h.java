package d.d;

/* JADX INFO: loaded from: classes.dex */
public class h<E> implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f750f = new Object();
    private boolean b;
    private int[] c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f752e;

    public h() {
        this(10);
    }

    public h(int i) {
        this.b = false;
        if (i == 0) {
            this.c = c.a;
            this.f751d = c.c;
        } else {
            int iE = c.e(i);
            this.c = new int[iE];
            this.f751d = new Object[iE];
        }
    }

    private void d() {
        int i = this.f752e;
        int[] iArr = this.c;
        Object[] objArr = this.f751d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f750f) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.f752e = i2;
    }

    public void a(int i, E e2) {
        int i2 = this.f752e;
        if (i2 != 0 && i <= this.c[i2 - 1]) {
            i(i, e2);
            return;
        }
        if (this.b && this.f752e >= this.c.length) {
            d();
        }
        int i3 = this.f752e;
        if (i3 >= this.c.length) {
            int iE = c.e(i3 + 1);
            int[] iArr = new int[iE];
            Object[] objArr = new Object[iE];
            int[] iArr2 = this.c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f751d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.c = iArr;
            this.f751d = objArr;
        }
        this.c[i3] = i;
        this.f751d[i3] = e2;
        this.f752e = i3 + 1;
    }

    public void b() {
        int i = this.f752e;
        Object[] objArr = this.f751d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f752e = 0;
        this.b = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.c = (int[]) this.c.clone();
            hVar.f751d = (Object[]) this.f751d.clone();
            return hVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E e(int i) {
        return f(i, null);
    }

    public E f(int i, E e2) {
        int iA = c.a(this.c, this.f752e, i);
        if (iA >= 0) {
            Object[] objArr = this.f751d;
            if (objArr[iA] != f750f) {
                return (E) objArr[iA];
            }
        }
        return e2;
    }

    public int g(E e2) {
        if (this.b) {
            d();
        }
        for (int i = 0; i < this.f752e; i++) {
            if (this.f751d[i] == e2) {
                return i;
            }
        }
        return -1;
    }

    public int h(int i) {
        if (this.b) {
            d();
        }
        return this.c[i];
    }

    public void i(int i, E e2) {
        int iA = c.a(this.c, this.f752e, i);
        if (iA >= 0) {
            this.f751d[iA] = e2;
            return;
        }
        int iA2 = iA ^ (-1);
        if (iA2 < this.f752e) {
            Object[] objArr = this.f751d;
            if (objArr[iA2] == f750f) {
                this.c[iA2] = i;
                objArr[iA2] = e2;
                return;
            }
        }
        if (this.b && this.f752e >= this.c.length) {
            d();
            iA2 = c.a(this.c, this.f752e, i) ^ (-1);
        }
        int i2 = this.f752e;
        if (i2 >= this.c.length) {
            int iE = c.e(i2 + 1);
            int[] iArr = new int[iE];
            Object[] objArr2 = new Object[iE];
            int[] iArr2 = this.c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f751d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.c = iArr;
            this.f751d = objArr2;
        }
        int i3 = this.f752e;
        if (i3 - iA2 != 0) {
            int[] iArr3 = this.c;
            int i4 = iA2 + 1;
            System.arraycopy(iArr3, iA2, iArr3, i4, i3 - iA2);
            Object[] objArr4 = this.f751d;
            System.arraycopy(objArr4, iA2, objArr4, i4, this.f752e - iA2);
        }
        this.c[iA2] = i;
        this.f751d[iA2] = e2;
        this.f752e++;
    }

    public void j(int i) {
        int iA = c.a(this.c, this.f752e, i);
        if (iA >= 0) {
            Object[] objArr = this.f751d;
            Object obj = objArr[iA];
            Object obj2 = f750f;
            if (obj != obj2) {
                objArr[iA] = obj2;
                this.b = true;
            }
        }
    }

    public int k() {
        if (this.b) {
            d();
        }
        return this.f752e;
    }

    public E l(int i) {
        if (this.b) {
            d();
        }
        return (E) this.f751d[i];
    }

    public String toString() {
        if (k() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f752e * 28);
        sb.append('{');
        for (int i = 0; i < this.f752e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(h(i));
            sb.append('=');
            E eL = l(i);
            if (eL != this) {
                sb.append(eL);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
