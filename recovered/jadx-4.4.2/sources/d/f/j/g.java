package d.f.j;

/* JADX INFO: loaded from: classes.dex */
public class g<T> extends f<T> {
    private final Object c;

    public g(int i) {
        super(i);
        this.c = new Object();
    }

    @Override // d.f.j.f, d.f.j.e
    public boolean a(T t) {
        boolean zA;
        synchronized (this.c) {
            zA = super.a(t);
        }
        return zA;
    }

    @Override // d.f.j.f, d.f.j.e
    public T b() {
        T t;
        synchronized (this.c) {
            t = (T) super.b();
        }
        return t;
    }
}
