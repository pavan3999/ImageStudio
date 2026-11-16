package f.a.m.g;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class h extends f.a.h {
    static final e b;
    static final ScheduledExecutorService c;
    final AtomicReference<ScheduledExecutorService> a;

    static final class a extends f.a.h.b {
        final ScheduledExecutorService b;
        final f.a.j.a c = new f.a.j.a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f983d;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.b = scheduledExecutorService;
        }

        @Override // f.a.h.b
        public f.a.j.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f983d) {
                return f.a.m.a.c.INSTANCE;
            }
            f fVar = new f(f.a.n.a.l(runnable), this.c);
            this.c.a(fVar);
            try {
                fVar.a(j <= 0 ? this.b.submit((Callable) fVar) : this.b.schedule((Callable) fVar, j, timeUnit));
                return fVar;
            } catch (RejectedExecutionException e2) {
                e();
                f.a.n.a.j(e2);
                return f.a.m.a.c.INSTANCE;
            }
        }

        @Override // f.a.j.b
        public void e() {
            if (this.f983d) {
                return;
            }
            this.f983d = true;
            this.c.e();
        }
    }

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        c = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        b = new e("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())));
    }

    public h() {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.a = atomicReference;
        atomicReference.lazySet(d());
    }

    static ScheduledExecutorService d() {
        return g.a(b);
    }

    @Override // f.a.h
    public f.a.h.b a() {
        return new a(this.a.get());
    }

    @Override // f.a.h
    public f.a.j.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        Runnable runnableL = f.a.n.a.l(runnable);
        try {
            return f.a.j.c.b(j <= 0 ? this.a.get().submit(runnableL) : this.a.get().schedule(runnableL, j, timeUnit));
        } catch (RejectedExecutionException e2) {
            f.a.n.a.j(e2);
            return f.a.m.a.c.INSTANCE;
        }
    }
}
