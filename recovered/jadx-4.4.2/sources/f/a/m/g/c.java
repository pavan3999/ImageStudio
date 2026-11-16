package f.a.m.g;

/* JADX INFO: loaded from: classes.dex */
public final class c extends f.a.h {
    private static final c b = new c();
    private static final e a = new e("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    private c() {
    }

    public static c d() {
        return b;
    }

    @Override // f.a.h
    public f.a.h.b a() {
        return new d(a);
    }
}
