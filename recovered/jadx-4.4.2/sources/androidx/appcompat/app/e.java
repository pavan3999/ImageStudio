package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    private static int b = -100;
    private static final d.d.b<WeakReference<e>> c = new d.d.b<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f24d = new Object();

    e() {
    }

    public static e e(Activity activity, d dVar) {
        return new f(activity, dVar);
    }

    public static e f(Dialog dialog, d dVar) {
        return new f(dialog, dVar);
    }

    public static int h() {
        return b;
    }

    static void n(e eVar) {
        synchronized (f24d) {
            x(eVar);
            c.add(new WeakReference<>(eVar));
        }
    }

    static void o(e eVar) {
        synchronized (f24d) {
            x(eVar);
        }
    }

    private static void x(e eVar) {
        synchronized (f24d) {
            Iterator<WeakReference<e>> it = c.iterator();
            while (it.hasNext()) {
                e eVar2 = it.next().get();
                if (eVar2 == eVar || eVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public abstract void A(View view);

    public abstract void B(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void C(Toolbar toolbar);

    public void D(int i) {
    }

    public abstract void E(CharSequence charSequence);

    public abstract void c(View view, ViewGroup.LayoutParams layoutParams);

    public void d(Context context) {
    }

    public abstract <T extends View> T g(int i);

    public int i() {
        return -100;
    }

    public abstract MenuInflater j();

    public abstract a k();

    public abstract void l();

    public abstract void m();

    public abstract void p(Configuration configuration);

    public abstract void q(Bundle bundle);

    public abstract void r();

    public abstract void s(Bundle bundle);

    public abstract void t();

    public abstract void u(Bundle bundle);

    public abstract void v();

    public abstract void w();

    public abstract boolean y(int i);

    public abstract void z(int i);
}
