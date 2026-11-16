package f.a.m.g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class e extends AtomicLong implements ThreadFactory {
    final String b;
    final int c;

    public e(String str) {
        this(str, 5);
    }

    public e(String str, int i) {
        this.b = str;
        this.c = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.b + '-' + incrementAndGet());
        thread.setPriority(this.c);
        thread.setDaemon(true);
        return thread;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.b + "]";
    }
}
