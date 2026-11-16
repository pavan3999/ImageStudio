package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
class l {
    private final CopyOnWriteArrayList<a> a = new CopyOnWriteArrayList<>();
    private final m b;

    private static final class a {
        final m.f a;
        final boolean b;
    }

    l(m mVar) {
        this.b = mVar;
    }

    void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragmentI0 = this.b.i0();
        if (fragmentI0 != null) {
            fragmentI0.z().h0().a(fragment, bundle, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.b) {
                aVar.a.a(this.b, fragment, bundle);
            }
        }
    }

    void b(Fragment fragment, Context context, boolean z) {
        Fragment fragmentI0 = this.b.i0();
        if (fragmentI0 != null) {
            fragmentI0.z().h0().b(fragment, context, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.b) {
                aVar.a.b(this.b, fragment, context);
            }
        }
    }

    void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragmentI0 = this.b.i0();
        if (fragmentI0 != null) {
            fragmentI0.z().h0().c(fragment, bundle, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.b) {
                aVar.a.c(this.b, fragment, bundle);
            }
        }
    }

    void d(Fragment fragment, boolean z) {
        Fragment fragmentI0 = this.b.i0();
        if (fragmentI0 != null) {
            fragmentI0.z().h0().d(fragment, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.b) {
                aVar.a.d(this.b, fragment);
            }
        }
    }

    void e(Fragment fragment, boolean z) {
        Fragment fragmentI0 = this.b.i0();
        if (fragmentI0 != null) {
            fragmentI0.z().h0().e(fragment, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.b) {
                aVar.a.e(this.b, fragment);
            }
        }
    }

    void f(Fragment fragment, boolean z) {
        Fragment fragmentI0 = this.b.i0();
        if (fragmentI0 != null) {
            fragmentI0.z().h0().f(fragment, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.b) {
                aVar.a.f(this.b, fragment);
            }
        }
    }

    void g(Fragment fragment, Context context, boolean z) {
        Fragment fragmentI0 = this.b.i0();
        if (fragmentI0 != null) {
            fragmentI0.z().h0().g(fragment, context, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.b) {
                aVar.a.g(this.b, fragment, context);
            }
        }
    }

    void h(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragmentI0 = this.b.i0();
        if (fragmentI0 != null) {
            fragmentI0.z().h0().h(fragment, bundle, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.b) {
                aVar.a.h(this.b, fragment, bundle);
            }
        }
    }

    void i(Fragment fragment, boolean z) {
        Fragment fragmentI0 = this.b.i0();
        if (fragmentI0 != null) {
            fragmentI0.z().h0().i(fragment, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.b) {
                aVar.a.i(this.b, fragment);
            }
        }
    }

    void j(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragmentI0 = this.b.i0();
        if (fragmentI0 != null) {
            fragmentI0.z().h0().j(fragment, bundle, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.b) {
                aVar.a.j(this.b, fragment, bundle);
            }
        }
    }

    void k(Fragment fragment, boolean z) {
        Fragment fragmentI0 = this.b.i0();
        if (fragmentI0 != null) {
            fragmentI0.z().h0().k(fragment, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.b) {
                aVar.a.k(this.b, fragment);
            }
        }
    }

    void l(Fragment fragment, boolean z) {
        Fragment fragmentI0 = this.b.i0();
        if (fragmentI0 != null) {
            fragmentI0.z().h0().l(fragment, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.b) {
                aVar.a.l(this.b, fragment);
            }
        }
    }

    void m(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragmentI0 = this.b.i0();
        if (fragmentI0 != null) {
            fragmentI0.z().h0().m(fragment, view, bundle, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.b) {
                aVar.a.m(this.b, fragment, view, bundle);
            }
        }
    }

    void n(Fragment fragment, boolean z) {
        Fragment fragmentI0 = this.b.i0();
        if (fragmentI0 != null) {
            fragmentI0.z().h0().n(fragment, true);
        }
        for (a aVar : this.a) {
            if (!z || aVar.b) {
                aVar.a.n(this.b, fragment);
            }
        }
    }
}
