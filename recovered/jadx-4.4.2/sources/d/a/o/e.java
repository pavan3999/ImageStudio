package d.a.o;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class e extends b implements androidx.appcompat.view.menu.g.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ActionBarContextView f697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b.a f698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private WeakReference<View> f699g;
    private boolean h;
    private androidx.appcompat.view.menu.g i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.f696d = context;
        this.f697e = actionBarContextView;
        this.f698f = aVar;
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(actionBarContextView.getContext());
        gVar.S(1);
        this.i = gVar;
        gVar.R(this);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void a(androidx.appcompat.view.menu.g gVar) {
        k();
        this.f697e.l();
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean b(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        return this.f698f.c(this, menuItem);
    }

    @Override // d.a.o.b
    public void c() {
        if (this.h) {
            return;
        }
        this.h = true;
        this.f697e.sendAccessibilityEvent(32);
        this.f698f.b(this);
    }

    @Override // d.a.o.b
    public View d() {
        WeakReference<View> weakReference = this.f699g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // d.a.o.b
    public Menu e() {
        return this.i;
    }

    @Override // d.a.o.b
    public MenuInflater f() {
        return new g(this.f697e.getContext());
    }

    @Override // d.a.o.b
    public CharSequence g() {
        return this.f697e.getSubtitle();
    }

    @Override // d.a.o.b
    public CharSequence i() {
        return this.f697e.getTitle();
    }

    @Override // d.a.o.b
    public void k() {
        this.f698f.a(this, this.i);
    }

    @Override // d.a.o.b
    public boolean l() {
        return this.f697e.j();
    }

    @Override // d.a.o.b
    public void m(View view) {
        this.f697e.setCustomView(view);
        this.f699g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // d.a.o.b
    public void n(int i) {
        o(this.f696d.getString(i));
    }

    @Override // d.a.o.b
    public void o(CharSequence charSequence) {
        this.f697e.setSubtitle(charSequence);
    }

    @Override // d.a.o.b
    public void q(int i) {
        r(this.f696d.getString(i));
    }

    @Override // d.a.o.b
    public void r(CharSequence charSequence) {
        this.f697e.setTitle(charSequence);
    }

    @Override // d.a.o.b
    public void s(boolean z) {
        super.s(z);
        this.f697e.setTitleOptional(z);
    }
}
