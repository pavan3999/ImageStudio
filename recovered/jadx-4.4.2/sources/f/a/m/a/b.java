package f.a.m.a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public enum b implements f.a.j.b {
    DISPOSED;

    public static boolean a(AtomicReference<f.a.j.b> atomicReference) {
        f.a.j.b andSet;
        f.a.j.b bVar = atomicReference.get();
        b bVar2 = DISPOSED;
        if (bVar == bVar2 || (andSet = atomicReference.getAndSet(bVar2)) == bVar2) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.e();
        return true;
    }

    public static boolean b(f.a.j.b bVar) {
        return bVar == DISPOSED;
    }

    public static void c() {
        f.a.n.a.j(new IllegalStateException("Disposable already set!"));
    }

    public static boolean d(AtomicReference<f.a.j.b> atomicReference, f.a.j.b bVar) {
        f.a.m.b.a.c(bVar, "d is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.e();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        c();
        return false;
    }

    public static boolean f(f.a.j.b bVar, f.a.j.b bVar2) {
        if (bVar2 == null) {
            f.a.n.a.j(new NullPointerException("next is null"));
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar2.e();
        c();
        return false;
    }

    @Override // f.a.j.b
    public void e() {
    }
}
