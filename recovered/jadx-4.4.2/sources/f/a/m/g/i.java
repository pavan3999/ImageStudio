package f.a.m.g;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class i extends f.a.h {
    private static final i a = new i();

    static final class a implements Runnable {
        private final Runnable b;
        private final c c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f984d;

        a(Runnable runnable, c cVar, long j) {
            this.b = runnable;
            this.c = cVar;
            this.f984d = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c.f988e) {
                return;
            }
            long jA = this.c.a(TimeUnit.MILLISECONDS);
            long j = this.f984d;
            if (j > jA) {
                long j2 = j - jA;
                if (j2 > 0) {
                    try {
                        Thread.sleep(j2);
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        f.a.n.a.j(e2);
                        return;
                    }
                }
            }
            if (this.c.f988e) {
                return;
            }
            this.b.run();
        }
    }

    static final class b implements Comparable<b> {
        final Runnable b;
        final long c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f985d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile boolean f986e;

        b(Runnable runnable, Long l, int i) {
            this.b = runnable;
            this.c = l.longValue();
            this.f985d = i;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int iB = f.a.m.b.a.b(this.c, bVar.c);
            return iB == 0 ? f.a.m.b.a.a(this.f985d, bVar.f985d) : iB;
        }
    }

    static final class c extends f.a.h.b implements f.a.j.b {
        final PriorityBlockingQueue<b> b = new PriorityBlockingQueue<>();
        private final AtomicInteger c = new AtomicInteger();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicInteger f987d = new AtomicInteger();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile boolean f988e;

        class a implements Runnable {
            final /* synthetic */ b b;

            a(b bVar) {
                this.b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.b.f986e = true;
                c.this.b.remove(this.b);
            }
        }

        c() {
        }

        @Override // f.a.h.b
        public f.a.j.b b(Runnable runnable) {
            return d(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // f.a.h.b
        public f.a.j.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            long jA = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return d(new a(runnable, this, jA), jA);
        }

        f.a.j.b d(Runnable runnable, long j) {
            if (this.f988e) {
                return f.a.m.a.c.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.f987d.incrementAndGet());
            this.b.add(bVar);
            if (this.c.getAndIncrement() != 0) {
                return f.a.j.c.d(new a(bVar));
            }
            int iAddAndGet = 1;
            while (true) {
                b bVarPoll = this.b.poll();
                if (bVarPoll == null) {
                    iAddAndGet = this.c.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return f.a.m.a.c.INSTANCE;
                    }
                } else if (!bVarPoll.f986e) {
                    bVarPoll.b.run();
                }
            }
        }

        @Override // f.a.j.b
        public void e() {
            this.f988e = true;
        }
    }

    i() {
    }

    public static i d() {
        return a;
    }

    @Override // f.a.h
    public f.a.h.b a() {
        return new c();
    }

    @Override // f.a.h
    public f.a.j.b b(Runnable runnable) {
        runnable.run();
        return f.a.m.a.c.INSTANCE;
    }

    @Override // f.a.h
    public f.a.j.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            runnable.run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            f.a.n.a.j(e2);
        }
        return f.a.m.a.c.INSTANCE;
    }
}
