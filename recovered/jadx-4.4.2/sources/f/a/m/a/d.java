package f.a.m.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d implements f.a.j.b, a {
    List<f.a.j.b> b;
    volatile boolean c;

    @Override // f.a.m.a.a
    public boolean a(f.a.j.b bVar) {
        f.a.m.b.a.c(bVar, "d is null");
        if (!this.c) {
            synchronized (this) {
                if (!this.c) {
                    List linkedList = this.b;
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        this.b = linkedList;
                    }
                    linkedList.add(bVar);
                    return true;
                }
            }
        }
        bVar.e();
        return false;
    }

    @Override // f.a.m.a.a
    public boolean b(f.a.j.b bVar) {
        f.a.m.b.a.c(bVar, "Disposable item is null");
        if (this.c) {
            return false;
        }
        synchronized (this) {
            if (this.c) {
                return false;
            }
            List<f.a.j.b> list = this.b;
            if (list != null && list.remove(bVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // f.a.m.a.a
    public boolean c(f.a.j.b bVar) {
        if (!b(bVar)) {
            return false;
        }
        bVar.e();
        return true;
    }

    void d(List<f.a.j.b> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        Iterator<f.a.j.b> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().e();
            } catch (Throwable th) {
                f.a.k.b.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new f.a.k.a(arrayList);
            }
            throw f.a.m.h.a.a((Throwable) arrayList.get(0));
        }
    }

    @Override // f.a.j.b
    public void e() {
        if (this.c) {
            return;
        }
        synchronized (this) {
            if (this.c) {
                return;
            }
            this.c = true;
            List<f.a.j.b> list = this.b;
            this.b = null;
            d(list);
        }
    }
}
