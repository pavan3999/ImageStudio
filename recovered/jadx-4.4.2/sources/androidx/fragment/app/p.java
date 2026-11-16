package androidx.fragment.app;

import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class p extends androidx.lifecycle.q {
    private static final androidx.lifecycle.r.a h = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f320e;
    private final HashMap<String, Fragment> b = new HashMap<>();
    private final HashMap<String, p> c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<String, androidx.lifecycle.s> f319d = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f321f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f322g = false;

    static class a implements androidx.lifecycle.r.a {
        a() {
        }

        @Override // androidx.lifecycle.r.a
        public <T extends androidx.lifecycle.q> T a(Class<T> cls) {
            return new p(true);
        }
    }

    p(boolean z) {
        this.f320e = z;
    }

    static p i(androidx.lifecycle.s sVar) {
        return (p) new androidx.lifecycle.r(sVar, h).a(p.class);
    }

    @Override // androidx.lifecycle.q
    protected void d() {
        if (m.p0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f321f = true;
    }

    boolean e(Fragment fragment) {
        if (this.b.containsKey(fragment.f291f)) {
            return false;
        }
        this.b.put(fragment.f291f, fragment);
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        return this.b.equals(pVar.b) && this.c.equals(pVar.c) && this.f319d.equals(pVar.f319d);
    }

    void f(Fragment fragment) {
        if (m.p0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        p pVar = this.c.get(fragment.f291f);
        if (pVar != null) {
            pVar.d();
            this.c.remove(fragment.f291f);
        }
        androidx.lifecycle.s sVar = this.f319d.get(fragment.f291f);
        if (sVar != null) {
            sVar.a();
            this.f319d.remove(fragment.f291f);
        }
    }

    Fragment g(String str) {
        return this.b.get(str);
    }

    p h(Fragment fragment) {
        p pVar = this.c.get(fragment.f291f);
        if (pVar != null) {
            return pVar;
        }
        p pVar2 = new p(this.f320e);
        this.c.put(fragment.f291f, pVar2);
        return pVar2;
    }

    public int hashCode() {
        return (((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.f319d.hashCode();
    }

    Collection<Fragment> j() {
        return this.b.values();
    }

    androidx.lifecycle.s k(Fragment fragment) {
        androidx.lifecycle.s sVar = this.f319d.get(fragment.f291f);
        if (sVar != null) {
            return sVar;
        }
        androidx.lifecycle.s sVar2 = new androidx.lifecycle.s();
        this.f319d.put(fragment.f291f, sVar2);
        return sVar2;
    }

    boolean l() {
        return this.f321f;
    }

    boolean m(Fragment fragment) {
        return this.b.remove(fragment.f291f) != null;
    }

    boolean n(Fragment fragment) {
        if (this.b.containsKey(fragment.f291f)) {
            return this.f320e ? this.f321f : !this.f322g;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f319d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
