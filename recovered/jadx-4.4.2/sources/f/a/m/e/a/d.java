package f.a.m.e.a;

import f.a.f;
import f.a.g;
import f.a.h;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class d<T> extends f.a.m.e.a.a<T, T> {
    final h b;

    class a implements Runnable {
        final /* synthetic */ b b;

        a(b bVar) {
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a.a(this.b);
        }
    }

    static final class b<T> extends AtomicReference<f.a.j.b> implements g<T>, f.a.j.b {
        final g<? super T> b;
        final AtomicReference<f.a.j.b> c = new AtomicReference<>();

        b(g<? super T> gVar) {
            this.b = gVar;
        }

        @Override // f.a.g
        public void a() {
            this.b.a();
        }

        @Override // f.a.g
        public void b(T t) {
            this.b.b(t);
        }

        @Override // f.a.g
        public void c(Throwable th) {
            this.b.c(th);
        }

        void d(f.a.j.b bVar) {
            f.a.m.a.b.d(this, bVar);
        }

        @Override // f.a.j.b
        public void e() {
            f.a.m.a.b.a(this.c);
            f.a.m.a.b.a(this);
        }

        @Override // f.a.g
        public void f(f.a.j.b bVar) {
            f.a.m.a.b.d(this.c, bVar);
        }
    }

    public d(f<T> fVar, h hVar) {
        super(fVar);
        this.b = hVar;
    }

    @Override // f.a.c
    public void f(g<? super T> gVar) {
        b bVar = new b(gVar);
        gVar.f(bVar);
        bVar.d(this.b.b(new a(bVar)));
    }
}
