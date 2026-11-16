package d.b.a.b;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a<K, V> extends b<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashMap<K, b.c<K, V>> f711f = new HashMap<>();

    @Override // d.b.a.b.b
    protected b.c<K, V> c(K k) {
        return this.f711f.get(k);
    }

    public boolean contains(K k) {
        return this.f711f.containsKey(k);
    }

    @Override // d.b.a.b.b
    public V g(K k, V v) {
        b.c<K, V> cVarC = c(k);
        if (cVarC != null) {
            return cVarC.c;
        }
        this.f711f.put(k, f(k, v));
        return null;
    }

    @Override // d.b.a.b.b
    public V h(K k) {
        V v = (V) super.h(k);
        this.f711f.remove(k);
        return v;
    }

    public Map.Entry<K, V> i(K k) {
        if (contains(k)) {
            return this.f711f.get(k).f715e;
        }
        return null;
    }
}
