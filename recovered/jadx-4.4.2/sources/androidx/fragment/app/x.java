package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
class x implements androidx.lifecycle.g {
    private androidx.lifecycle.h b = null;

    x() {
    }

    @Override // androidx.lifecycle.g
    public androidx.lifecycle.d a() {
        c();
        return this.b;
    }

    void b(androidx.lifecycle.d.a aVar) {
        this.b.i(aVar);
    }

    void c() {
        if (this.b == null) {
            this.b = new androidx.lifecycle.h(this);
        }
    }

    boolean f() {
        return this.b != null;
    }
}
