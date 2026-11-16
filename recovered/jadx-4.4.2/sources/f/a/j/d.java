package f.a.j;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
final class d extends e<Future<?>> {
    private final boolean b;

    d(Future<?> future, boolean z) {
        super(future);
        this.b = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // f.a.j.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(Future<?> future) {
        future.cancel(this.b);
    }
}
