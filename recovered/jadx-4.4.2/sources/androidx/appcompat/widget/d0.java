package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public interface d0 {
    boolean a();

    void b(Menu menu, androidx.appcompat.view.menu.m.a aVar);

    boolean c();

    void collapseActionView();

    void d();

    boolean e();

    boolean f();

    boolean g();

    CharSequence getTitle();

    void h();

    void i(androidx.appcompat.view.menu.m.a aVar, androidx.appcompat.view.menu.g.a aVar2);

    d.f.k.v j(int i, long j);

    int k();

    void l(int i);

    void m();

    Menu n();

    boolean o();

    void p(int i);

    void q(p0 p0Var);

    ViewGroup r();

    void s(boolean z);

    void setIcon(int i);

    void setIcon(Drawable drawable);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t();

    void u(boolean z);

    Context v();

    void w(int i);

    int x();
}
