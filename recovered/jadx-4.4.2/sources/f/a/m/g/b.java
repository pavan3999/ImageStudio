package f.a.m.g;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class b extends f.a.h {
    static final e b;
    static final e c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final TimeUnit f973d = TimeUnit.SECONDS;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final c f974e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final a f975f;
    final AtomicReference<a> a = new AtomicReference<>(f975f);

    static final class a implements Runnable {
        private final long b;
        private final ConcurrentLinkedQueue<c> c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final f.a.j.a f976d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ScheduledExecutorService f977e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Future<?> f978f;

        a(long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            this.b = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.c = new ConcurrentLinkedQueue<>();
            this.f976d = new f.a.j.a();
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = null;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, b.c);
                long j2 = this.b;
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFutureScheduleWithFixedDelay = null;
            }
            this.f977e = scheduledExecutorServiceNewScheduledThreadPool;
            this.f978f = scheduledFutureScheduleWithFixedDelay;
        }

        void a() {
            if (this.c.isEmpty()) {
                return;
            }
            long jC = c();
            for (c cVar : this.c) {
                if (cVar.g() > jC) {
                    return;
                }
                if (this.c.remove(cVar)) {
                    this.f976d.c(cVar);
                }
            }
        }

        c b() {
            if (this.f976d.f()) {
                return b.f974e;
            }
            while (!this.c.isEmpty()) {
                c cVarPoll = this.c.poll();
                if (cVarPoll != null) {
                    return cVarPoll;
                }
            }
            c cVar = new c(b.b);
            this.f976d.a(cVar);
            return cVar;
        }

        long c() {
            return System.nanoTime();
        }

        void d(c cVar) {
            cVar.h(c() + this.b);
            this.c.offer(cVar);
        }

        void e() {
            this.f976d.e();
            Future<?> future = this.f978f;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f977e;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    /* JADX INFO: renamed from: f.a.m.g.b$b, reason: collision with other inner class name */
    static final class C0079b extends f.a.h.b {
        private final a c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final c f979d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicBoolean f980e = new AtomicBoolean();
        private final f.a.j.a b = new f.a.j.a();

        C0079b(a aVar) {
            this.c = aVar;
            this.f979d = aVar.b();
        }

        @Override // f.a.h.b
        public f.a.j.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.b.f() ? f.a.m.a.c.INSTANCE : this.f979d.d(runnable, j, timeUnit, this.b);
        }

        @Override // f.a.j.b
        public void e() {
            if (this.f980e.compareAndSet(false, true)) {
                this.b.e();
                this.c.d(this.f979d);
            }
        }
    }

    static final class c extends d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f981d;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f981d = 0L;
        }

        public long g() {
            return this.f981d;
        }

        public void h(long j) {
            this.f981d = j;
        }
    }

    static {
        a aVar = new a(0L, null);
        f975f = aVar;
        aVar.e();
        c cVar = new c(new e("RxCachedThreadSchedulerShutdown"));
        f974e = cVar;
        cVar.e();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        b = new e("RxCachedThreadScheduler", iMax);
        c = new e("RxCachedWorkerPoolEvictor", iMax);
    }

    public b() {
        d();
    }

    @Override // f.a.h
    public f.a.h.b a() {
        return new C0079b(this.a.get());
    }

    public void d() {
        a aVar = new a(60L, f973d);
        if (this.a.compareAndSet(f975f, aVar)) {
            return;
        }
        aVar.e();
    }
}
