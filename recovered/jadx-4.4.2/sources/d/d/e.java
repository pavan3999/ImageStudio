package d.d;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e<K, V> {
    private final LinkedHashMap<K, V> a;
    private int b;
    private int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f740g;
    private int h;

    public e(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = i;
        this.a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int e(K k, V v) {
        int iF = f(k, v);
        if (iF >= 0) {
            return iF;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    protected V a(K k) {
        return null;
    }

    protected void b(boolean z, K k, V v, V v2) {
    }

    public final V c(K k) {
        V vPut;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.a.get(k);
            if (v != null) {
                this.f740g++;
                return v;
            }
            this.h++;
            V vA = a(k);
            if (vA == null) {
                return null;
            }
            synchronized (this) {
                this.f738e++;
                vPut = this.a.put(k, vA);
                if (vPut != null) {
                    this.a.put(k, vPut);
                } else {
                    this.b += e(k, vA);
                }
            }
            if (vPut != null) {
                b(false, k, vA, vPut);
                return vPut;
            }
            g(this.c);
            return vA;
        }
    }

    public final V d(K k, V v) {
        V vPut;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f737d++;
            this.b += e(k, v);
            vPut = this.a.put(k, v);
            if (vPut != null) {
                this.b -= e(k, vPut);
            }
        }
        if (vPut != null) {
            b(false, k, vPut, v);
        }
        g(this.c);
        return vPut;
    }

    protected int f(K k, V v) {
        return 1;
    }

    public void g(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.b < 0 || (this.a.isEmpty() && this.b != 0)) {
                    break;
                }
                if (this.b > i && !this.a.isEmpty()) {
                    Map.Entry<K, V> next = this.a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.a.remove(key);
                    this.b -= e(key, value);
                    this.f739f++;
                }
                return;
            }
            b(true, key, value, null);
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    public final synchronized String toString() {
        int i;
        i = this.f740g + this.h;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.c), Integer.valueOf(this.f740g), Integer.valueOf(this.h), Integer.valueOf(i != 0 ? (this.f740g * 100) / i : 0));
    }
}
