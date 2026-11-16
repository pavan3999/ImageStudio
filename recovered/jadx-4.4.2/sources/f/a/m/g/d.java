package f.a.m.g;

import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class d extends f.a.h.b implements f.a.j.b {
    private final ScheduledExecutorService b;
    volatile boolean c;

    public d(ThreadFactory threadFactory) {
        this.b = g.a(threadFactory);
    }

    @Override // f.a.h.b
    public f.a.j.b b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // f.a.h.b
    public f.a.j.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.c ? f.a.m.a.c.INSTANCE : d(runnable, j, timeUnit, null);
    }

    public f d(Runnable runnable, long j, TimeUnit timeUnit, f.a.m.a.a aVar) {
        f fVar = new f(f.a.n.a.l(runnable), aVar);
        if (aVar != null && !aVar.a(fVar)) {
            return fVar;
        }
        try {
            fVar.a(j <= 0 ? this.b.submit((Callable) fVar) : this.b.schedule((Callable) fVar, j, timeUnit));
        } catch (RejectedExecutionException e2) {
            aVar.c(fVar);
            f.a.n.a.j(e2);
        }
        return fVar;
    }

    @Override // f.a.j.b
    public void e() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.shutdownNow();
    }

    public f.a.j.b f(Runnable runnable, long j, TimeUnit timeUnit) {
        Runnable runnableL = f.a.n.a.l(runnable);
        try {
            return f.a.j.c.b(j <= 0 ? this.b.submit(runnableL) : this.b.schedule(runnableL, j, timeUnit));
        } catch (RejectedExecutionException e2) {
            f.a.n.a.j(e2);
            return f.a.m.a.c.INSTANCE;
        }
    }
}
