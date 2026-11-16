package d.d;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f729f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object[] f730g = new Object[0];
    private static Object[] h;
    private static int i;
    private static Object[] j;
    private static int k;
    private int[] b;
    Object[] c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f<E, E> f732e;

    class a extends f<E, E> {
        a() {
        }

        @Override // d.d.f
        protected void a() {
            b.this.clear();
        }

        @Override // d.d.f
        protected Object b(int i, int i2) {
            return b.this.c[i];
        }

        @Override // d.d.f
        protected Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // d.d.f
        protected int d() {
            return b.this.f731d;
        }

        @Override // d.d.f
        protected int e(Object obj) {
            return b.this.e(obj);
        }

        @Override // d.d.f
        protected int f(Object obj) {
            return b.this.e(obj);
        }

        @Override // d.d.f
        protected void g(E e2, E e3) {
            b.this.add(e2);
        }

        @Override // d.d.f
        protected void h(int i) {
            b.this.h(i);
        }

        @Override // d.d.f
        protected E i(int i, E e2) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    public b(int i2) {
        if (i2 == 0) {
            this.b = f729f;
            this.c = f730g;
        } else {
            a(i2);
        }
        this.f731d = 0;
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                if (j != null) {
                    Object[] objArr = j;
                    this.c = objArr;
                    j = (Object[]) objArr[0];
                    this.b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    k--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                if (h != null) {
                    Object[] objArr2 = h;
                    this.c = objArr2;
                    h = (Object[]) objArr2[0];
                    this.b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    i--;
                    return;
                }
            }
        }
        this.b = new int[i2];
        this.c = new Object[i2];
    }

    private static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (k < 10) {
                    objArr[0] = j;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    j = objArr;
                    k++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                if (i < 10) {
                    objArr[0] = h;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    h = objArr;
                    i++;
                }
            }
        }
    }

    private f<E, E> d() {
        if (this.f732e == null) {
            this.f732e = new a();
        }
        return this.f732e;
    }

    private int f(Object obj, int i2) {
        int i3 = this.f731d;
        if (i3 == 0) {
            return -1;
        }
        int iA = c.a(this.b, i3, i2);
        if (iA < 0 || obj.equals(this.c[iA])) {
            return iA;
        }
        int i4 = iA + 1;
        while (i4 < i3 && this.b[i4] == i2) {
            if (obj.equals(this.c[i4])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iA - 1; i5 >= 0 && this.b[i5] == i2; i5--) {
            if (obj.equals(this.c[i5])) {
                return i5;
            }
        }
        return i4 ^ (-1);
    }

    private int g() {
        int i2 = this.f731d;
        if (i2 == 0) {
            return -1;
        }
        int iA = c.a(this.b, i2, 0);
        if (iA < 0 || this.c[iA] == null) {
            return iA;
        }
        int i3 = iA + 1;
        while (i3 < i2 && this.b[i3] == 0) {
            if (this.c[i3] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iA - 1; i4 >= 0 && this.b[i4] == 0; i4--) {
            if (this.c[i4] == null) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int i2;
        int iF;
        if (e2 == null) {
            iF = g();
            i2 = 0;
        } else {
            int iHashCode = e2.hashCode();
            i2 = iHashCode;
            iF = f(e2, iHashCode);
        }
        if (iF >= 0) {
            return false;
        }
        int i3 = iF ^ (-1);
        int i4 = this.f731d;
        if (i4 >= this.b.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.b;
            Object[] objArr = this.c;
            a(i5);
            int[] iArr2 = this.b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.c, 0, objArr.length);
            }
            c(iArr, objArr, this.f731d);
        }
        int i6 = this.f731d;
        if (i3 < i6) {
            int[] iArr3 = this.b;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.c;
            System.arraycopy(objArr2, i3, objArr2, i7, this.f731d - i3);
        }
        this.b[i3] = i2;
        this.c[i3] = e2;
        this.f731d++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        b(this.f731d + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public void b(int i2) {
        int[] iArr = this.b;
        if (iArr.length < i2) {
            Object[] objArr = this.c;
            a(i2);
            int i3 = this.f731d;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.b, 0, i3);
                System.arraycopy(objArr, 0, this.c, 0, this.f731d);
            }
            c(iArr, objArr, this.f731d);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.f731d;
        if (i2 != 0) {
            c(this.b, this.c, i2);
            this.b = f729f;
            this.c = f730g;
            this.f731d = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return e(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int e(Object obj) {
        return obj == null ? g() : f(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f731d; i2++) {
                try {
                    if (!set.contains(i(i2))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public E h(int i2) {
        Object[] objArr = this.c;
        E e2 = (E) objArr[i2];
        int i3 = this.f731d;
        if (i3 <= 1) {
            c(this.b, objArr, i3);
            this.b = f729f;
            this.c = f730g;
            this.f731d = 0;
        } else {
            int[] iArr = this.b;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i4 = this.f731d - 1;
                this.f731d = i4;
                if (i2 < i4) {
                    int[] iArr2 = this.b;
                    int i5 = i2 + 1;
                    System.arraycopy(iArr2, i5, iArr2, i2, i4 - i2);
                    Object[] objArr2 = this.c;
                    System.arraycopy(objArr2, i5, objArr2, i2, this.f731d - i2);
                }
                this.c[this.f731d] = null;
            } else {
                int i6 = i3 > 8 ? i3 + (i3 >> 1) : 8;
                int[] iArr3 = this.b;
                Object[] objArr3 = this.c;
                a(i6);
                this.f731d--;
                if (i2 > 0) {
                    System.arraycopy(iArr3, 0, this.b, 0, i2);
                    System.arraycopy(objArr3, 0, this.c, 0, i2);
                }
                int i7 = this.f731d;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr3, i8, this.b, i2, i7 - i2);
                    System.arraycopy(objArr3, i8, this.c, i2, this.f731d - i2);
                }
            }
        }
        return e2;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.b;
        int i2 = this.f731d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public E i(int i2) {
        return (E) this.c[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f731d <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return d().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iE = e(obj);
        if (iE < 0) {
            return false;
        }
        h(iE);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.f731d - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.c[i2])) {
                h(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f731d;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.f731d;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.c, 0, objArr, 0, i2);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f731d) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f731d));
        }
        System.arraycopy(this.c, 0, tArr, 0, this.f731d);
        int length = tArr.length;
        int i2 = this.f731d;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f731d * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f731d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            E eI = i(i2);
            if (eI != this) {
                sb.append(eI);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
