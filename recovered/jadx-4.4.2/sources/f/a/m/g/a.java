package f.a.m.g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class a extends f.a.h {
    static final e c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final c f969e;
    final AtomicReference<b> a = new AtomicReference<>(b);
    static final b b = new b(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f968d = d(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* JADX INFO: renamed from: f.a.m.g.a$a, reason: collision with other inner class name */
    static final class C0078a extends f.a.h.b {
        private final f.a.m.a.d b = new f.a.m.a.d();
        private final f.a.j.a c = new f.a.j.a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final f.a.m.a.d f970d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final c f971e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f972f;

        C0078a(c cVar) {
            this.f971e = cVar;
            f.a.m.a.d dVar = new f.a.m.a.d();
            this.f970d = dVar;
            dVar.a(this.b);
            this.f970d.a(this.c);
        }

        @Override // f.a.h.b
        public f.a.j.b b(Runnable runnable) {
            return this.f972f ? f.a.m.a.c.INSTANCE : this.f971e.d(runnable, 0L, null, this.b);
        }

        @Override // f.a.h.b
        public f.a.j.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.f972f ? f.a.m.a.c.INSTANCE : this.f971e.d(runnable, j, timeUnit, this.c);
        }

        @Override // f.a.j.b
        public void e() {
            if (this.f972f) {
                return;
            }
            this.f972f = true;
            this.f970d.e();
        }
    }

    static final class b {
        final int a;
        final c[] b;
        long c;

        b(int i) {
            this.a = i;
            this.b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.b[i2] = new c(a.c);
            }
        }

        public c a() {
            int i = this.a;
            if (i == 0) {
                return a.f969e;
            }
            c[] cVarArr = this.b;
            long j = this.c;
            this.c = 1 + j;
            return cVarArr[(int) (j % ((long) i))];
        }

        public void b() {
            for (c cVar : this.b) {
                cVar.e();
            }
        }
    }

    static final class c extends d {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new e("RxComputationShutdown"));
        f969e = cVar;
        cVar.e();
        c = new e("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())));
    }

    public a() {
        e();
    }

    static int d(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    @Override // f.a.h
    public f.a.h.b a() {
        return new C0078a(this.a.get().a());
    }

    @Override // f.a.h
    public f.a.j.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.a.get().a().f(runnable, j, timeUnit);
    }

    public void e() {
        b bVar = new b(f968d);
        if (this.a.compareAndSet(b, bVar)) {
            return;
        }
        bVar.b();
    }
}
