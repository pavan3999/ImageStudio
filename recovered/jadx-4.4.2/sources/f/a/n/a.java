package f.a.n;

import f.a.g;
import f.a.h;
import f.a.l.b;
import f.a.l.c;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    static volatile b<Throwable> a;
    static volatile c<Runnable, Runnable> b;
    static volatile c<Callable<h>, h> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static volatile c<Callable<h>, h> f991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static volatile c<Callable<h>, h> f992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static volatile c<Callable<h>, h> f993f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static volatile c<h, h> f994g;
    static volatile c<f.a.c, f.a.c> h;
    static volatile f.a.l.a<f.a.c, g, g> i;

    static <T, U, R> R a(f.a.l.a<T, U, R> aVar, T t, U u) {
        try {
            return aVar.a(t, u);
        } catch (Throwable th) {
            throw f.a.m.h.a.a(th);
        }
    }

    static <T, R> R b(c<T, R> cVar, T t) {
        try {
            return cVar.a(t);
        } catch (Throwable th) {
            throw f.a.m.h.a.a(th);
        }
    }

    static h c(c<Callable<h>, h> cVar, Callable<h> callable) {
        Object objB = b(cVar, callable);
        f.a.m.b.a.c(objB, "Scheduler Callable result can't be null");
        return (h) objB;
    }

    static h d(Callable<h> callable) {
        try {
            h hVarCall = callable.call();
            f.a.m.b.a.c(hVarCall, "Scheduler Callable result can't be null");
            return hVarCall;
        } catch (Throwable th) {
            throw f.a.m.h.a.a(th);
        }
    }

    public static h e(Callable<h> callable) {
        f.a.m.b.a.c(callable, "Scheduler Callable can't be null");
        c<Callable<h>, h> cVar = c;
        return cVar == null ? d(callable) : c(cVar, callable);
    }

    public static h f(Callable<h> callable) {
        f.a.m.b.a.c(callable, "Scheduler Callable can't be null");
        c<Callable<h>, h> cVar = f992e;
        return cVar == null ? d(callable) : c(cVar, callable);
    }

    public static h g(Callable<h> callable) {
        f.a.m.b.a.c(callable, "Scheduler Callable can't be null");
        c<Callable<h>, h> cVar = f993f;
        return cVar == null ? d(callable) : c(cVar, callable);
    }

    public static h h(Callable<h> callable) {
        f.a.m.b.a.c(callable, "Scheduler Callable can't be null");
        c<Callable<h>, h> cVar = f991d;
        return cVar == null ? d(callable) : c(cVar, callable);
    }

    public static <T> f.a.c<T> i(f.a.c<T> cVar) {
        c<f.a.c, f.a.c> cVar2 = h;
        return cVar2 != null ? (f.a.c) b(cVar2, cVar) : cVar;
    }

    public static void j(Throwable th) {
        b<Throwable> bVar = a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (bVar != null) {
            try {
                bVar.a(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                n(th2);
            }
        }
        th.printStackTrace();
        n(th);
    }

    public static h k(h hVar) {
        c<h, h> cVar = f994g;
        return cVar == null ? hVar : (h) b(cVar, hVar);
    }

    public static Runnable l(Runnable runnable) {
        c<Runnable, Runnable> cVar = b;
        return cVar == null ? runnable : (Runnable) b(cVar, runnable);
    }

    public static <T> g<? super T> m(f.a.c<T> cVar, g<? super T> gVar) {
        f.a.l.a<f.a.c, g, g> aVar = i;
        return aVar != null ? (g) a(aVar, cVar, gVar) : gVar;
    }

    static void n(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }
}
