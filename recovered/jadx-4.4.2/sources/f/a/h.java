package f.a;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    class a implements Runnable {
        final /* synthetic */ Runnable b;
        final /* synthetic */ b c;

        a(h hVar, Runnable runnable, b bVar) {
            this.b = runnable;
            this.c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } finally {
                this.c.e();
            }
        }
    }

    public static abstract class b implements f.a.j.b {
        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public f.a.j.b b(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract f.a.j.b c(Runnable runnable, long j, TimeUnit timeUnit);
    }

    static {
        TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15L).longValue());
    }

    public abstract b a();

    public f.a.j.b b(Runnable runnable) {
        return c(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public f.a.j.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        b bVarA = a();
        bVarA.c(new a(this, f.a.n.a.l(runnable), bVarA), j, timeUnit);
        return bVarA;
    }
}
