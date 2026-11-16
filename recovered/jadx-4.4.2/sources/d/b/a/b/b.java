package d.b.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    c<K, V> b;
    private c<K, V> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f712d = new WeakHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f713e = 0;

    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // d.b.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f715e;
        }

        @Override // d.b.a.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f714d;
        }
    }

    /* JADX INFO: renamed from: d.b.a.b.b$b, reason: collision with other inner class name */
    private static class C0042b<K, V> extends e<K, V> {
        C0042b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // d.b.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f714d;
        }

        @Override // d.b.a.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f715e;
        }
    }

    static class c<K, V> implements Map.Entry<K, V> {
        final K b;
        final V c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        c<K, V> f714d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        c<K, V> f715e;

        c(K k, V v) {
            this.b = k;
            this.c = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.b.equals(cVar.b) && this.c.equals(cVar.c);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.c;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.b.hashCode() ^ this.c.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.b + "=" + this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {
        private c<K, V> b;
        private boolean c = true;

        d() {
        }

        @Override // d.b.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.b;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f715e;
                this.b = cVar3;
                this.c = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.c) {
                this.c = false;
                cVar = b.this.b;
            } else {
                c<K, V> cVar2 = this.b;
                cVar = cVar2 != null ? cVar2.f714d : null;
            }
            this.b = cVar;
            return this.b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.c) {
                return b.this.b != null;
            }
            c<K, V> cVar = this.b;
            return (cVar == null || cVar.f714d == null) ? false : true;
        }
    }

    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {
        c<K, V> b;
        c<K, V> c;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.b = cVar2;
            this.c = cVar;
        }

        private c<K, V> e() {
            c<K, V> cVar = this.c;
            c<K, V> cVar2 = this.b;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // d.b.a.b.b.f
        public void a(c<K, V> cVar) {
            if (this.b == cVar && cVar == this.c) {
                this.c = null;
                this.b = null;
            }
            c<K, V> cVar2 = this.b;
            if (cVar2 == cVar) {
                this.b = b(cVar2);
            }
            if (this.c == cVar) {
                this.c = e();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.c;
            this.c = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c != null;
        }
    }

    interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> a() {
        C0042b c0042b = new C0042b(this.c, this.b);
        this.f712d.put(c0042b, Boolean.FALSE);
        return c0042b;
    }

    public Map.Entry<K, V> b() {
        return this.b;
    }

    protected c<K, V> c(K k) {
        c<K, V> cVar = this.b;
        while (cVar != null && !cVar.b.equals(k)) {
            cVar = cVar.f714d;
        }
        return cVar;
    }

    public b<K, V>.d d() {
        b<K, V>.d dVar = new d();
        this.f712d.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    protected c<K, V> f(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.f713e++;
        c<K, V> cVar2 = this.c;
        if (cVar2 == null) {
            this.b = cVar;
        } else {
            cVar2.f714d = cVar;
            cVar.f715e = cVar2;
        }
        this.c = cVar;
        return cVar;
    }

    public V g(K k, V v) {
        c<K, V> cVarC = c(k);
        if (cVarC != null) {
            return cVarC.c;
        }
        f(k, v);
        return null;
    }

    public V h(K k) {
        c<K, V> cVarC = c(k);
        if (cVarC == null) {
            return null;
        }
        this.f713e--;
        if (!this.f712d.isEmpty()) {
            Iterator<f<K, V>> it = this.f712d.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(cVarC);
            }
        }
        c<K, V> cVar = cVarC.f715e;
        if (cVar != null) {
            cVar.f714d = cVarC.f714d;
        } else {
            this.b = cVarC.f714d;
        }
        c<K, V> cVar2 = cVarC.f714d;
        if (cVar2 != null) {
            cVar2.f715e = cVarC.f715e;
        } else {
            this.c = cVarC.f715e;
        }
        cVarC.f714d = null;
        cVarC.f715e = null;
        return cVarC.c;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.b, this.c);
        this.f712d.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f713e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
