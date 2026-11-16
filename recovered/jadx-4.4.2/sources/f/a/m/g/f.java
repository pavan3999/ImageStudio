package f.a.m.g;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes.dex */
public final class f extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, f.a.j.b {
    static final Object c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Object f982d = new Object();
    final Runnable b;

    public f(Runnable runnable, f.a.m.a.a aVar) {
        super(2);
        this.b = runnable;
        lazySet(0, aVar);
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == f982d) {
                return;
            }
            if (obj == c) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // f.a.j.b
    public void e() {
        Object obj;
        Object obj2;
        Object obj3;
        while (true) {
            Object obj4 = get(1);
            if (obj4 == f982d || obj4 == (obj3 = c)) {
                break;
            }
            if (compareAndSet(1, obj4, obj3)) {
                if (obj4 == null) {
                    break;
                }
                ((Future) obj4).cancel(true);
                break;
            }
        }
        do {
            obj = get(0);
            if (obj == f982d || obj == (obj2 = c) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((f.a.m.a.a) obj).b(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        try {
            this.b.run();
        } catch (Throwable th) {
            try {
                f.a.n.a.j(th);
            } finally {
                Object obj3 = get(0);
                if (obj3 != c && obj3 != null && compareAndSet(0, obj3, f982d)) {
                    ((f.a.m.a.a) obj3).b(this);
                }
                do {
                    obj = get(1);
                    if (obj == c) {
                        break;
                    }
                } while (!compareAndSet(1, obj, f982d));
            }
        }
        Object obj4 = get(0);
        if (obj4 != c && obj4 != null && compareAndSet(0, obj4, f982d)) {
            ((f.a.m.a.a) obj4).b(this);
        }
        do {
            if (r1 == obj2) {
                return;
            }
        } while (!compareAndSet(1, get(i), f982d));
    }
}
