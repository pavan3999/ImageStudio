package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class h {
    private final j<?> a;

    private h(j<?> jVar) {
        this.a = jVar;
    }

    public static h b(j<?> jVar) {
        d.f.j.h.d(jVar, "callbacks == null");
        return new h(jVar);
    }

    public void a(Fragment fragment) {
        j<?> jVar = this.a;
        jVar.f310e.g(jVar, jVar, fragment);
    }

    public void c() {
        this.a.f310e.r();
    }

    public void d(Configuration configuration) {
        this.a.f310e.s(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.a.f310e.t(menuItem);
    }

    public void f() {
        this.a.f310e.u();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.a.f310e.v(menu, menuInflater);
    }

    public void h() {
        this.a.f310e.w();
    }

    public void i() {
        this.a.f310e.y();
    }

    public void j(boolean z) {
        this.a.f310e.z(z);
    }

    public boolean k(MenuItem menuItem) {
        return this.a.f310e.A(menuItem);
    }

    public void l(Menu menu) {
        this.a.f310e.B(menu);
    }

    public void m() {
        this.a.f310e.D();
    }

    public void n(boolean z) {
        this.a.f310e.E(z);
    }

    public boolean o(Menu menu) {
        return this.a.f310e.F(menu);
    }

    public void p() {
        this.a.f310e.H();
    }

    public void q() {
        this.a.f310e.I();
    }

    public void r() {
        this.a.f310e.K();
    }

    public boolean s() {
        return this.a.f310e.Q(true);
    }

    public Fragment t(String str) {
        return this.a.f310e.Y(str);
    }

    public m u() {
        return this.a.f310e;
    }

    public void v() {
        this.a.f310e.B0();
    }

    public View w(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.f310e.g0().onCreateView(view, str, context, attributeSet);
    }

    public void x(Parcelable parcelable) {
        j<?> jVar = this.a;
        if (!(jVar instanceof androidx.lifecycle.t)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        jVar.f310e.N0(parcelable);
    }

    public Parcelable y() {
        return this.a.f310e.P0();
    }
}
