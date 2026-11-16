package f.a.o;

import f.a.m.g.i;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    static final f.a.h a;

    /* JADX INFO: renamed from: f.a.o.a$a, reason: collision with other inner class name */
    static class CallableC0081a implements Callable<f.a.h> {
        CallableC0081a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f.a.h call() {
            return h.a;
        }
    }

    static class b implements Callable<f.a.h> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f.a.h call() {
            return e.a;
        }
    }

    static class c implements Callable<f.a.h> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f.a.h call() {
            return f.a;
        }
    }

    static class d implements Callable<f.a.h> {
        d() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f.a.h call() {
            return g.a;
        }
    }

    static final class e {
        static final f.a.h a = new f.a.m.g.a();
    }

    static final class f {
        static final f.a.h a = new f.a.m.g.b();
    }

    static final class g {
        static final f.a.h a = f.a.m.g.c.d();
    }

    static final class h {
        static final f.a.h a = new f.a.m.g.h();
    }

    static {
        f.a.n.a.h(new CallableC0081a());
        f.a.n.a.e(new b());
        a = f.a.n.a.f(new c());
        i.d();
        f.a.n.a.g(new d());
    }

    public static f.a.h a() {
        return f.a.n.a.k(a);
    }
}
