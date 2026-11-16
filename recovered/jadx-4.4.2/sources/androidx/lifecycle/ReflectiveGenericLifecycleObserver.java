package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements e {
    private final Object a;
    private final a.C0013a b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
        this.b = a.c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.e
    public void g(g gVar, d.a aVar) {
        this.b.a(gVar, aVar, this.a);
    }
}
