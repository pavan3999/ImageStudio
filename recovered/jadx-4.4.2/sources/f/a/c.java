package f.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class c<T> implements f<T> {
    public static int b() {
        return b.a();
    }

    public static <T> c<T> c(e<T> eVar) {
        f.a.m.b.a.c(eVar, "source is null");
        return f.a.n.a.i(new f.a.m.e.a.b(eVar));
    }

    @Override // f.a.f
    public final void a(g<? super T> gVar) {
        f.a.m.b.a.c(gVar, "observer is null");
        try {
            g<? super T> gVarM = f.a.n.a.m(this, gVar);
            f.a.m.b.a.c(gVarM, "Plugin returned null Observer");
            f(gVarM);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            f.a.k.b.b(th);
            f.a.n.a.j(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final c<T> d(h hVar) {
        return e(hVar, false, b());
    }

    public final c<T> e(h hVar, boolean z, int i) {
        f.a.m.b.a.c(hVar, "scheduler is null");
        f.a.m.b.a.d(i, "bufferSize");
        return f.a.n.a.i(new f.a.m.e.a.c(this, hVar, z, i));
    }

    protected abstract void f(g<? super T> gVar);

    public final c<T> g(h hVar) {
        f.a.m.b.a.c(hVar, "scheduler is null");
        return f.a.n.a.i(new f.a.m.e.a.d(this, hVar));
    }
}
