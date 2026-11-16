package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class s {
    private final HashMap<String, q> a = new HashMap<>();

    public final void a() {
        Iterator<q> it = this.a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.a.clear();
    }

    final q b(String str) {
        return this.a.get(str);
    }

    Set<String> c() {
        return new HashSet(this.a.keySet());
    }

    final void d(String str, q qVar) {
        q qVarPut = this.a.put(str, qVar);
        if (qVarPut != null) {
            qVarPut.d();
        }
    }
}
