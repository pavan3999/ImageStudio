package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {
    static final Object i = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f362g;
    private boolean h;
    final Object a = new Object();
    private d.b.a.b.b<m<? super T>, LiveData<T>.a> b = new d.b.a.b.b<>();
    int c = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    volatile Object f360e = i;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Object f359d = i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f361f = -1;

    class LifecycleBoundObserver extends LiveData<T>.a implements e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final g f363e;

        LifecycleBoundObserver(g gVar, m<? super T> mVar) {
            super(mVar);
            this.f363e = gVar;
        }

        @Override // androidx.lifecycle.e
        public void g(g gVar, d.a aVar) {
            if (this.f363e.a().b() == d.b.DESTROYED) {
                LiveData.this.g(this.a);
            } else {
                h(k());
            }
        }

        @Override // androidx.lifecycle.LiveData.a
        void i() {
            this.f363e.a().c(this);
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean j(g gVar) {
            return this.f363e == gVar;
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean k() {
            return this.f363e.a().b().a(d.b.STARTED);
        }
    }

    private abstract class a {
        final m<? super T> a;
        boolean b;
        int c = -1;

        a(m<? super T> mVar) {
            this.a = mVar;
        }

        void h(boolean z) {
            if (z == this.b) {
                return;
            }
            this.b = z;
            boolean z2 = LiveData.this.c == 0;
            LiveData.this.c += this.b ? 1 : -1;
            if (z2 && this.b) {
                LiveData.this.e();
            }
            LiveData liveData = LiveData.this;
            if (liveData.c == 0 && !this.b) {
                liveData.f();
            }
            if (this.b) {
                LiveData.this.c(this);
            }
        }

        void i() {
        }

        boolean j(g gVar) {
            return false;
        }

        abstract boolean k();
    }

    static void a(String str) {
        if (d.b.a.a.a.b().a()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void b(LiveData<T>.a aVar) {
        if (aVar.b) {
            if (!aVar.k()) {
                aVar.h(false);
                return;
            }
            int i2 = aVar.c;
            int i3 = this.f361f;
            if (i2 >= i3) {
                return;
            }
            aVar.c = i3;
            aVar.a.a((Object) this.f359d);
        }
    }

    void c(LiveData<T>.a aVar) {
        if (this.f362g) {
            this.h = true;
            return;
        }
        this.f362g = true;
        do {
            this.h = false;
            if (aVar != null) {
                b(aVar);
                aVar = null;
            } else {
                d.b.a.b.b<m<? super T>, LiveData<T>.a>.d dVarD = this.b.d();
                while (dVarD.hasNext()) {
                    b((a) dVarD.next().getValue());
                    if (this.h) {
                        break;
                    }
                }
            }
        } while (this.h);
        this.f362g = false;
    }

    public void d(g gVar, m<? super T> mVar) {
        a("observe");
        if (gVar.a().b() == d.b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(gVar, mVar);
        LiveData<T>.a aVarG = this.b.g(mVar, lifecycleBoundObserver);
        if (aVarG != null && !aVarG.j(gVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (aVarG != null) {
            return;
        }
        gVar.a().a(lifecycleBoundObserver);
    }

    protected void e() {
    }

    protected void f() {
    }

    public void g(m<? super T> mVar) {
        a("removeObserver");
        LiveData<T>.a aVarH = this.b.h(mVar);
        if (aVarH == null) {
            return;
        }
        aVarH.i();
        aVarH.h(false);
    }

    protected void h(T t) {
        a("setValue");
        this.f361f++;
        this.f359d = t;
        c(null);
    }
}
