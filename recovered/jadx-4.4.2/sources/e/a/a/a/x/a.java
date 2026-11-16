package e.a.a.a.x;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes.dex */
public final class a extends f {
    private final Typeface a;
    private final InterfaceC0070a b;
    private boolean c;

    /* JADX INFO: renamed from: e.a.a.a.x.a$a, reason: collision with other inner class name */
    public interface InterfaceC0070a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0070a interfaceC0070a, Typeface typeface) {
        this.a = typeface;
        this.b = interfaceC0070a;
    }

    private void d(Typeface typeface) {
        if (this.c) {
            return;
        }
        this.b.a(typeface);
    }

    @Override // e.a.a.a.x.f
    public void a(int i) {
        d(this.a);
    }

    @Override // e.a.a.a.x.f
    public void b(Typeface typeface, boolean z) {
        d(typeface);
    }

    public void c() {
        this.c = true;
    }
}
