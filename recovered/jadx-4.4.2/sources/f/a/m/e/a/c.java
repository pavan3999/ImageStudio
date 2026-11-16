package f.a.m.e.a;

import f.a.f;
import f.a.g;
import f.a.h;
import f.a.m.g.i;

/* JADX INFO: loaded from: classes.dex */
public final class c<T> extends f.a.m.e.a.a<T, T> {
    final h b;
    final boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f959d;

    static final class a<T> extends f.a.m.d.a<T> implements g<T>, Runnable {
        final g<? super T> b;
        final h.b c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f960d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f961e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        f.a.m.c.c<T> f962f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        f.a.j.b f963g;
        Throwable h;
        volatile boolean i;
        volatile boolean j;
        int k;
        boolean l;

        a(g<? super T> gVar, h.b bVar, boolean z, int i) {
            this.b = gVar;
            this.c = bVar;
            this.f960d = z;
            this.f961e = i;
        }

        @Override // f.a.g
        public void a() {
            if (this.i) {
                return;
            }
            this.i = true;
            l();
        }

        @Override // f.a.g
        public void b(T t) {
            if (this.i) {
                return;
            }
            if (this.k != 2) {
                this.f962f.h(t);
            }
            l();
        }

        @Override // f.a.g
        public void c(Throwable th) {
            if (this.i) {
                f.a.n.a.j(th);
                return;
            }
            this.h = th;
            this.i = true;
            l();
        }

        @Override // f.a.m.c.c
        public void clear() {
            this.f962f.clear();
        }

        @Override // f.a.m.c.c
        public T d() {
            return this.f962f.d();
        }

        @Override // f.a.j.b
        public void e() {
            if (this.j) {
                return;
            }
            this.j = true;
            this.f963g.e();
            this.c.e();
            if (getAndIncrement() == 0) {
                this.f962f.clear();
            }
        }

        @Override // f.a.g
        public void f(f.a.j.b bVar) {
            if (f.a.m.a.b.f(this.f963g, bVar)) {
                this.f963g = bVar;
                if (bVar instanceof f.a.m.c.a) {
                    f.a.m.c.a aVar = (f.a.m.c.a) bVar;
                    int iG = aVar.g(7);
                    if (iG == 1) {
                        this.k = iG;
                        this.f962f = aVar;
                        this.i = true;
                        this.b.f(this);
                        l();
                        return;
                    }
                    if (iG == 2) {
                        this.k = iG;
                        this.f962f = aVar;
                        this.b.f(this);
                        return;
                    }
                }
                this.f962f = new f.a.m.f.a(this.f961e);
                this.b.f(this);
            }
        }

        @Override // f.a.m.c.b
        public int g(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.l = true;
            return 2;
        }

        boolean i(boolean z, boolean z2, g<? super T> gVar) {
            if (this.j) {
                this.f962f.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.h;
            if (this.f960d) {
                if (!z2) {
                    return false;
                }
                if (th != null) {
                    gVar.c(th);
                } else {
                    gVar.a();
                }
                this.c.e();
                return true;
            }
            if (th != null) {
                this.f962f.clear();
                gVar.c(th);
                this.c.e();
                return true;
            }
            if (!z2) {
                return false;
            }
            gVar.a();
            this.c.e();
            return true;
        }

        @Override // f.a.m.c.c
        public boolean isEmpty() {
            return this.f962f.isEmpty();
        }

        void j() {
            int iAddAndGet = 1;
            while (!this.j) {
                boolean z = this.i;
                Throwable th = this.h;
                if (this.f960d || !z || th == null) {
                    this.b.b(null);
                    if (z) {
                        Throwable th2 = this.h;
                        if (th2 != null) {
                            this.b.c(th2);
                        } else {
                            this.b.a();
                        }
                    } else {
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    }
                } else {
                    this.b.c(th);
                }
                this.c.e();
                return;
            }
        }

        void k() {
            f.a.m.c.c<T> cVar = this.f962f;
            g<? super T> gVar = this.b;
            int iAddAndGet = 1;
            while (!i(this.i, cVar.isEmpty(), gVar)) {
                while (true) {
                    boolean z = this.i;
                    try {
                        T tD = cVar.d();
                        boolean z2 = tD == null;
                        if (i(z, z2, gVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        } else {
                            gVar.b(tD);
                        }
                    } catch (Throwable th) {
                        f.a.k.b.b(th);
                        this.f963g.e();
                        cVar.clear();
                        gVar.c(th);
                        return;
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        void l() {
            if (getAndIncrement() == 0) {
                this.c.b(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.l) {
                j();
            } else {
                k();
            }
        }
    }

    public c(f<T> fVar, h hVar, boolean z, int i) {
        super(fVar);
        this.b = hVar;
        this.c = z;
        this.f959d = i;
    }

    @Override // f.a.c
    protected void f(g<? super T> gVar) {
        h hVar = this.b;
        if (hVar instanceof i) {
            this.a.a(gVar);
        } else {
            this.a.a(new a(gVar, hVar.a(), this.c, this.f959d));
        }
    }
}
