package f.a.i.a;

import f.a.h;
import f.a.k.b;
import f.a.l.c;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static volatile c<Callable<h>, h> a;
    private static volatile c<h, h> b;

    static <T, R> R a(c<T, R> cVar, T t) {
        try {
            return cVar.a(t);
        } catch (Throwable th) {
            b.a(th);
            throw null;
        }
    }

    static h b(c<Callable<h>, h> cVar, Callable<h> callable) {
        h hVar = (h) a(cVar, callable);
        if (hVar != null) {
            return hVar;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static h c(Callable<h> callable) {
        try {
            h hVarCall = callable.call();
            if (hVarCall != null) {
                return hVarCall;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            b.a(th);
            throw null;
        }
    }

    public static h d(Callable<h> callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        c<Callable<h>, h> cVar = a;
        return cVar == null ? c(callable) : b(cVar, callable);
    }

    public static h e(h hVar) {
        if (hVar == null) {
            throw new NullPointerException("scheduler == null");
        }
        c<h, h> cVar = b;
        return cVar == null ? hVar : (h) a(cVar, hVar);
    }
}
