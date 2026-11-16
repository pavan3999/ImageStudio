package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static b f641e;
    private final Object a = new Object();
    private final Handler b = new Handler(Looper.getMainLooper(), new a());
    private c c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f642d;

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.d((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.b$b, reason: collision with other inner class name */
    interface InterfaceC0027b {
        void a(int i);

        void b();
    }

    private static class c {
        final WeakReference<InterfaceC0027b> a;
        int b;
        boolean c;

        c(int i, InterfaceC0027b interfaceC0027b) {
            this.a = new WeakReference<>(interfaceC0027b);
            this.b = i;
        }

        boolean a(InterfaceC0027b interfaceC0027b) {
            return interfaceC0027b != null && this.a.get() == interfaceC0027b;
        }
    }

    private b() {
    }

    private boolean a(c cVar, int i) {
        InterfaceC0027b interfaceC0027b = cVar.a.get();
        if (interfaceC0027b == null) {
            return false;
        }
        this.b.removeCallbacksAndMessages(cVar);
        interfaceC0027b.a(i);
        return true;
    }

    static b c() {
        if (f641e == null) {
            f641e = new b();
        }
        return f641e;
    }

    private boolean f(InterfaceC0027b interfaceC0027b) {
        c cVar = this.c;
        return cVar != null && cVar.a(interfaceC0027b);
    }

    private boolean g(InterfaceC0027b interfaceC0027b) {
        c cVar = this.f642d;
        return cVar != null && cVar.a(interfaceC0027b);
    }

    private void l(c cVar) {
        int i = cVar.b;
        if (i == -2) {
            return;
        }
        if (i <= 0) {
            i = i == -1 ? 1500 : 2750;
        }
        this.b.removeCallbacksAndMessages(cVar);
        Handler handler = this.b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i);
    }

    private void n() {
        c cVar = this.f642d;
        if (cVar != null) {
            this.c = cVar;
            this.f642d = null;
            InterfaceC0027b interfaceC0027b = cVar.a.get();
            if (interfaceC0027b != null) {
                interfaceC0027b.b();
            } else {
                this.c = null;
            }
        }
    }

    public void b(InterfaceC0027b interfaceC0027b, int i) {
        c cVar;
        synchronized (this.a) {
            if (f(interfaceC0027b)) {
                cVar = this.c;
            } else if (g(interfaceC0027b)) {
                cVar = this.f642d;
            }
            a(cVar, i);
        }
    }

    void d(c cVar) {
        synchronized (this.a) {
            if (this.c == cVar || this.f642d == cVar) {
                a(cVar, 2);
            }
        }
    }

    public boolean e(InterfaceC0027b interfaceC0027b) {
        boolean z;
        synchronized (this.a) {
            z = f(interfaceC0027b) || g(interfaceC0027b);
        }
        return z;
    }

    public void h(InterfaceC0027b interfaceC0027b) {
        synchronized (this.a) {
            if (f(interfaceC0027b)) {
                this.c = null;
                if (this.f642d != null) {
                    n();
                }
            }
        }
    }

    public void i(InterfaceC0027b interfaceC0027b) {
        synchronized (this.a) {
            if (f(interfaceC0027b)) {
                l(this.c);
            }
        }
    }

    public void j(InterfaceC0027b interfaceC0027b) {
        synchronized (this.a) {
            if (f(interfaceC0027b) && !this.c.c) {
                this.c.c = true;
                this.b.removeCallbacksAndMessages(this.c);
            }
        }
    }

    public void k(InterfaceC0027b interfaceC0027b) {
        synchronized (this.a) {
            if (f(interfaceC0027b) && this.c.c) {
                this.c.c = false;
                l(this.c);
            }
        }
    }

    public void m(int i, InterfaceC0027b interfaceC0027b) {
        synchronized (this.a) {
            if (f(interfaceC0027b)) {
                this.c.b = i;
                this.b.removeCallbacksAndMessages(this.c);
                l(this.c);
                return;
            }
            if (g(interfaceC0027b)) {
                this.f642d.b = i;
            } else {
                this.f642d = new c(i, interfaceC0027b);
            }
            if (this.c == null || !a(this.c, 4)) {
                this.c = null;
                n();
            }
        }
    }
}
