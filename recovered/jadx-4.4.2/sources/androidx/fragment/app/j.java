package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class j<E> extends f {
    private final Activity b;
    private final Context c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final m f310e;

    j(Activity activity, Context context, Handler handler, int i) {
        this.f310e = new n();
        this.b = activity;
        d.f.j.h.d(context, "context == null");
        this.c = context;
        d.f.j.h.d(handler, "handler == null");
        this.f309d = handler;
    }

    j(d dVar) {
        this(dVar, dVar, new Handler(), 0);
    }

    @Override // androidx.fragment.app.f
    public View c(int i) {
        return null;
    }

    @Override // androidx.fragment.app.f
    public boolean g() {
        return true;
    }

    Activity h() {
        return this.b;
    }

    Context i() {
        return this.c;
    }

    Handler j() {
        return this.f309d;
    }

    void k(Fragment fragment) {
    }

    public abstract E l();

    public LayoutInflater m() {
        return LayoutInflater.from(this.c);
    }

    public boolean n(Fragment fragment) {
        return true;
    }

    public void o() {
    }
}
