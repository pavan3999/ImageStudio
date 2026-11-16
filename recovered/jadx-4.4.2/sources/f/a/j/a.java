package f.a.j;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a implements b, f.a.m.a.a {
    f.a.m.h.b<b> b;
    volatile boolean c;

    @Override // f.a.m.a.a
    public boolean a(b bVar) {
        f.a.m.b.a.c(bVar, "d is null");
        if (!this.c) {
            synchronized (this) {
                if (!this.c) {
                    f.a.m.h.b<b> bVar2 = this.b;
                    if (bVar2 == null) {
                        bVar2 = new f.a.m.h.b<>();
                        this.b = bVar2;
                    }
                    bVar2.a(bVar);
                    return true;
                }
            }
        }
        bVar.e();
        return false;
    }

    @Override // f.a.m.a.a
    public boolean b(b bVar) {
        f.a.m.b.a.c(bVar, "Disposable item is null");
        if (this.c) {
            return false;
        }
        synchronized (this) {
            if (this.c) {
                return false;
            }
            f.a.m.h.b<b> bVar2 = this.b;
            if (bVar2 != null && bVar2.e(bVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // f.a.m.a.a
    public boolean c(b bVar) {
        if (!b(bVar)) {
            return false;
        }
        bVar.e();
        return true;
    }

    void d(f.a.m.h.b<b> bVar) {
        if (bVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : bVar.b()) {
            if (obj instanceof b) {
                try {
                    ((b) obj).e();
                } catch (Throwable th) {
                    f.a.k.b.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
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
            f.a.m.h.b<b> bVar = this.b;
            this.b = null;
            d(bVar);
        }
    }

    public boolean f() {
        return this.c;
    }
}
