package d.f.g;

import android.os.Build;
import android.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private boolean a;
    private InterfaceC0045a b;
    private Object c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f759d;

    /* JADX INFO: renamed from: d.f.g.a$a, reason: collision with other inner class name */
    public interface InterfaceC0045a {
        void a();
    }

    private void d() {
        while (this.f759d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            if (this.a) {
                return;
            }
            this.a = true;
            this.f759d = true;
            InterfaceC0045a interfaceC0045a = this.b;
            Object obj = this.c;
            if (interfaceC0045a != null) {
                try {
                    interfaceC0045a.a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f759d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                ((CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.f759d = false;
                notifyAll();
            }
        }
    }

    public boolean b() {
        boolean z;
        synchronized (this) {
            z = this.a;
        }
        return z;
    }

    public void c(InterfaceC0045a interfaceC0045a) {
        synchronized (this) {
            d();
            if (this.b == interfaceC0045a) {
                return;
            }
            this.b = interfaceC0045a;
            if (this.a && interfaceC0045a != null) {
                interfaceC0045a.a();
            }
        }
    }
}
