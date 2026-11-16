package d.f.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private HandlerThread b;
    private Handler c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f772g;
    private final String h;
    private final Object a = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler.Callback f770e = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f769d = 0;

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                c.this.a();
                return true;
            }
            if (i != 1) {
                return true;
            }
            c.this.b((Runnable) message.obj);
            return true;
        }
    }

    class b implements Runnable {
        final /* synthetic */ Callable b;
        final /* synthetic */ Handler c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f773d;

        class a implements Runnable {
            final /* synthetic */ Object b;

            a(Object obj) {
                this.b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f773d.a(this.b);
            }
        }

        b(c cVar, Callable callable, Handler handler, d dVar) {
            this.b = callable;
            this.c = handler;
            this.f773d = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object objCall;
            try {
                objCall = this.b.call();
            } catch (Exception unused) {
                objCall = null;
            }
            this.c.post(new a(objCall));
        }
    }

    /* JADX INFO: renamed from: d.f.h.c$c, reason: collision with other inner class name */
    class RunnableC0047c implements Runnable {
        final /* synthetic */ AtomicReference b;
        final /* synthetic */ Callable c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ReentrantLock f774d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f775e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Condition f776f;

        RunnableC0047c(c cVar, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.b = atomicReference;
            this.c = callable;
            this.f774d = reentrantLock;
            this.f775e = atomicBoolean;
            this.f776f = condition;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.set(this.c.call());
            } catch (Exception unused) {
            }
            this.f774d.lock();
            try {
                this.f775e.set(false);
                this.f776f.signal();
            } finally {
                this.f774d.unlock();
            }
        }
    }

    public interface d<T> {
        void a(T t);
    }

    public c(String str, int i, int i2) {
        this.h = str;
        this.f772g = i;
        this.f771f = i2;
    }

    private void c(Runnable runnable) {
        synchronized (this.a) {
            if (this.b == null) {
                HandlerThread handlerThread = new HandlerThread(this.h, this.f772g);
                this.b = handlerThread;
                handlerThread.start();
                this.c = new Handler(this.b.getLooper(), this.f770e);
                this.f769d++;
            }
            this.c.removeMessages(0);
            this.c.sendMessage(this.c.obtainMessage(1, runnable));
        }
    }

    void a() {
        synchronized (this.a) {
            if (this.c.hasMessages(1)) {
                return;
            }
            this.b.quit();
            this.b = null;
            this.c = null;
        }
    }

    void b(Runnable runnable) {
        runnable.run();
        synchronized (this.a) {
            this.c.removeMessages(0);
            this.c.sendMessageDelayed(this.c.obtainMessage(0), this.f771f);
        }
    }

    public <T> void d(Callable<T> callable, d<T> dVar) {
        c(new b(this, callable, new Handler(), dVar));
    }

    public <T> T e(Callable<T> callable, int i) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionNewCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        c(new RunnableC0047c(this, atomicReference, callable, reentrantLock, atomicBoolean, conditionNewCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                T t = (T) atomicReference.get();
                reentrantLock.unlock();
                return t;
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = conditionNewCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    T t2 = (T) atomicReference.get();
                    reentrantLock.unlock();
                    return t2;
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
