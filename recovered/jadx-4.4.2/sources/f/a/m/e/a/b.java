package f.a.m.e.a;

import f.a.e;
import f.a.g;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class b<T> extends f.a.c<T> {
    final e<T> a;

    static final class a<T> extends AtomicReference<f.a.j.b> implements f.a.d<T>, f.a.j.b {
        final g<? super T> b;

        a(g<? super T> gVar) {
            this.b = gVar;
        }

        @Override // f.a.a
        public void a() {
            if (c()) {
                return;
            }
            try {
                this.b.a();
            } finally {
                e();
            }
        }

        @Override // f.a.a
        public void b(T t) {
            if (t == null) {
                d(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                if (c()) {
                    return;
                }
                this.b.b(t);
            }
        }

        public boolean c() {
            return f.a.m.a.b.b(get());
        }

        public void d(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (c()) {
                f.a.n.a.j(th);
                return;
            }
            try {
                this.b.c(th);
            } finally {
                e();
            }
        }

        @Override // f.a.j.b
        public void e() {
            f.a.m.a.b.a(this);
        }
    }

    public b(e<T> eVar) {
        this.a = eVar;
    }

    @Override // f.a.c
    protected void f(g<? super T> gVar) {
        a aVar = new a(gVar);
        gVar.f(aVar);
        try {
            this.a.a(aVar);
        } catch (Throwable th) {
            f.a.k.b.b(th);
            aVar.d(th);
        }
    }
}
