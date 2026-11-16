package d.d;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a<K, V> extends g<K, V> implements Map<K, V> {
    f<K, V> i;

    /* JADX INFO: renamed from: d.d.a$a, reason: collision with other inner class name */
    class C0043a extends f<K, V> {
        C0043a() {
        }

        @Override // d.d.f
        protected void a() {
            a.this.clear();
        }

        @Override // d.d.f
        protected Object b(int i, int i2) {
            return a.this.c[(i << 1) + i2];
        }

        @Override // d.d.f
        protected Map<K, V> c() {
            return a.this;
        }

        @Override // d.d.f
        protected int d() {
            return a.this.f749d;
        }

        @Override // d.d.f
        protected int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // d.d.f
        protected int f(Object obj) {
            return a.this.h(obj);
        }

        @Override // d.d.f
        protected void g(K k, V v) {
            a.this.put(k, v);
        }

        @Override // d.d.f
        protected void h(int i) {
            a.this.k(i);
        }

        @Override // d.d.f
        protected V i(int i, V v) {
            return a.this.l(i, v);
        }
    }

    public a() {
    }

    public a(int i) {
        super(i);
    }

    public a(g gVar) {
        super(gVar);
    }

    private f<K, V> n() {
        if (this.i == null) {
            this.i = new C0043a();
        }
        return this.i;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return n().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return n().m();
    }

    public boolean o(Collection<?> collection) {
        return f.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.f749d + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return n().n();
    }
}
