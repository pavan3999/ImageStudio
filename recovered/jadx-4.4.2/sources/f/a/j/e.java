package f.a.j;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
abstract class e<T> extends AtomicReference<T> implements b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e(T t) {
        super(t);
        f.a.m.b.a.c(t, "value is null");
    }

    public final boolean a() {
        return get() == null;
    }

    protected abstract void b(T t);

    @Override // f.a.j.b
    public final void e() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        b(andSet);
    }
}
