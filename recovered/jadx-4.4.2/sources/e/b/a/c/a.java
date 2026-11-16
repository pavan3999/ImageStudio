package e.b.a.c;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class a {
    protected boolean a;
    protected Context b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    c f944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Handler f945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected boolean f946g;
    String[] h;
    boolean i;
    boolean j;
    boolean k;
    int l;
    int m;
    int n;

    private class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.getData().getInt("action");
            String string = message.getData().getString("text");
            if (i == 1) {
                a aVar = a.this;
                aVar.c(aVar.m, string);
            } else if (i == 2) {
                a aVar2 = a.this;
                aVar2.a(aVar2.m, aVar2.l);
            } else {
                if (i != 3) {
                    return;
                }
                a aVar3 = a.this;
                aVar3.d(aVar3.m, string);
            }
        }
    }

    private class c extends Thread {
        private final a b;

        public c(a aVar) {
            this.b = aVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            a aVar = this.b;
            if (aVar.n > 0) {
                synchronized (aVar) {
                    try {
                        e.b.a.a.d("Command " + this.b.m + " is waiting for: " + this.b.n);
                        this.b.wait((long) this.b.n);
                    } catch (InterruptedException e2) {
                        e.b.a.a.d("Exception: " + e2);
                    }
                    if (!this.b.h()) {
                        e.b.a.a.d("Timeout Exception has occurred for command: " + this.b.m + ".");
                        a.this.l("Timeout Exception");
                    }
                }
            }
        }
    }

    public a(int i, int i2, String... strArr) {
        this.a = false;
        this.b = null;
        this.c = 0;
        this.f943d = 0;
        this.f944e = null;
        this.f945f = null;
        this.f946g = false;
        this.h = new String[0];
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = -1;
        this.m = 0;
        this.n = e.b.a.a.c;
        this.h = strArr;
        this.m = i;
        this.n = i2;
        e(e.b.a.a.b);
    }

    public a(int i, boolean z, String... strArr) {
        this.a = false;
        this.b = null;
        this.c = 0;
        this.f943d = 0;
        this.f944e = null;
        this.f945f = null;
        this.f946g = false;
        this.h = new String[0];
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = -1;
        this.m = 0;
        this.n = e.b.a.a.c;
        this.h = strArr;
        this.m = i;
        e(z);
    }

    public a(int i, String... strArr) {
        this.a = false;
        this.b = null;
        this.c = 0;
        this.f943d = 0;
        this.f944e = null;
        this.f945f = null;
        this.f946g = false;
        this.h = new String[0];
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = -1;
        this.m = 0;
        this.n = e.b.a.a.c;
        this.h = strArr;
        this.m = i;
        e(e.b.a.a.b);
    }

    private void e(boolean z) {
        this.k = z;
        if (Looper.myLooper() == null || !z) {
            e.b.a.a.d("CommandHandler not created");
        } else {
            e.b.a.a.d("CommandHandler created");
            this.f945f = new b();
        }
    }

    public void a(int i, int i2) {
    }

    protected final void b() {
        if (this.j) {
            return;
        }
        synchronized (this) {
            if (this.f945f == null || !this.k) {
                a(this.m, this.l);
            } else {
                Message messageObtainMessage = this.f945f.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("action", 2);
                messageObtainMessage.setData(bundle);
                this.f945f.sendMessage(messageObtainMessage);
            }
            e.b.a.a.d("Command " + this.m + " finished.");
            f();
        }
    }

    public void c(int i, String str) {
        e.b.a.a.f("Command", "ID: " + i + ", " + str);
        this.f943d = this.f943d + 1;
    }

    public void d(int i, String str) {
    }

    protected final void f() {
        this.i = true;
        notifyAll();
    }

    public final String g() {
        StringBuilder sb;
        String str;
        StringBuilder sb2 = new StringBuilder();
        int i = 0;
        if (!this.a) {
            while (true) {
                String[] strArr = this.h;
                if (i >= strArr.length) {
                    break;
                }
                sb2.append(strArr[i]);
                sb2.append('\n');
                i++;
            }
        } else {
            String path = this.b.getFilesDir().getPath();
            while (i < this.h.length) {
                if (Build.VERSION.SDK_INT > 22) {
                    sb = new StringBuilder();
                    sb.append("export CLASSPATH=");
                    sb.append(path);
                    sb.append("/anbuild.dex;");
                    sb.append(" app_process /system/bin ");
                    str = this.h[i];
                } else {
                    sb = new StringBuilder();
                    sb.append("dalvikvm -cp ");
                    sb.append(path);
                    sb.append("/anbuild.dex");
                    sb.append(" com.android.internal.util.WithFramework");
                    sb.append(" com.stericson.RootTools.containers.RootClass ");
                    str = this.h[i];
                }
                sb.append(str);
                sb2.append(sb.toString());
                sb2.append('\n');
                i++;
            }
        }
        return sb2.toString();
    }

    public final boolean h() {
        return this.i;
    }

    protected final void i(int i, String str) {
        this.c++;
        Handler handler = this.f945f;
        if (handler == null || !this.k) {
            c(i, str);
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putInt("action", 1);
        bundle.putString("text", str);
        messageObtainMessage.setData(bundle);
        this.f945f.sendMessage(messageObtainMessage);
    }

    protected final void j(int i) {
        synchronized (this) {
            this.l = i;
        }
    }

    protected final void k() {
        this.f946g = true;
        c cVar = new c(this);
        this.f944e = cVar;
        cVar.setPriority(1);
        this.f944e.start();
    }

    protected final void l(String str) {
        try {
            e.b.a.c.b.z();
            e.b.a.a.d("Terminating all shells.");
            m(str);
        } catch (IOException unused) {
        }
    }

    protected final void m(String str) {
        synchronized (this) {
            if (this.f945f == null || !this.k) {
                d(this.m, str);
            } else {
                Message messageObtainMessage = this.f945f.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("action", 3);
                bundle.putString("text", str);
                messageObtainMessage.setData(bundle);
                this.f945f.sendMessage(messageObtainMessage);
            }
            e.b.a.a.d("Command " + this.m + " did not finish because it was terminated. Termination reason: " + str);
            j(-1);
            this.j = true;
            f();
        }
    }
}
