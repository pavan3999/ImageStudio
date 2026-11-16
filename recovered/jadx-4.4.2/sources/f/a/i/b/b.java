package f.a.i.b;

import android.os.Handler;
import android.os.Message;
import f.a.h;
import f.a.j.c;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class b extends h {
    private final Handler a;

    private static final class a extends h.b {
        private final Handler b;
        private volatile boolean c;

        a(Handler handler) {
            this.b = handler;
        }

        @Override // f.a.h.b
        public f.a.j.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.c) {
                return c.a();
            }
            RunnableC0076b runnableC0076b = new RunnableC0076b(this.b, f.a.n.a.l(runnable));
            Message messageObtain = Message.obtain(this.b, runnableC0076b);
            messageObtain.obj = this;
            this.b.sendMessageDelayed(messageObtain, Math.max(0L, timeUnit.toMillis(j)));
            if (!this.c) {
                return runnableC0076b;
            }
            this.b.removeCallbacks(runnableC0076b);
            return c.a();
        }

        @Override // f.a.j.b
        public void e() {
            this.c = true;
            this.b.removeCallbacksAndMessages(this);
        }
    }

    /* JADX INFO: renamed from: f.a.i.b.b$b, reason: collision with other inner class name */
    private static final class RunnableC0076b implements Runnable, f.a.j.b {
        private final Handler b;
        private final Runnable c;

        RunnableC0076b(Handler handler, Runnable runnable) {
            this.b = handler;
            this.c = runnable;
        }

        @Override // f.a.j.b
        public void e() {
            this.b.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.c.run();
            } catch (Throwable th) {
                IllegalStateException illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.", th);
                f.a.n.a.j(illegalStateException);
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, illegalStateException);
            }
        }
    }

    b(Handler handler) {
        this.a = handler;
    }

    @Override // f.a.h
    public h.b a() {
        return new a(this.a);
    }

    @Override // f.a.h
    public f.a.j.b c(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        RunnableC0076b runnableC0076b = new RunnableC0076b(this.a, f.a.n.a.l(runnable));
        this.a.postDelayed(runnableC0076b, Math.max(0L, timeUnit.toMillis(j)));
        return runnableC0076b;
    }
}
