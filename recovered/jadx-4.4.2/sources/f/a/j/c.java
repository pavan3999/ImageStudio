package f.a.j;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static b a() {
        return f.a.m.a.c.INSTANCE;
    }

    public static b b(Future<?> future) {
        f.a.m.b.a.c(future, "future is null");
        return c(future, true);
    }

    public static b c(Future<?> future, boolean z) {
        f.a.m.b.a.c(future, "future is null");
        return new d(future, z);
    }

    public static b d(Runnable runnable) {
        f.a.m.b.a.c(runnable, "run is null");
        return new f(runnable);
    }
}
