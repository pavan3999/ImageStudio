package f.a.m.a;

/* JADX INFO: loaded from: classes.dex */
public enum c implements f.a.m.c.a<Object> {
    INSTANCE,
    NEVER;

    @Override // f.a.m.c.c
    public void clear() {
    }

    @Override // f.a.m.c.c
    public Object d() {
        return null;
    }

    @Override // f.a.j.b
    public void e() {
    }

    @Override // f.a.m.c.b
    public int g(int i) {
        return i & 2;
    }

    @Override // f.a.m.c.c
    public boolean h(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // f.a.m.c.c
    public boolean isEmpty() {
        return true;
    }
}
