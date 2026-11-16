package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
class r {
    private final l a;
    private final Fragment b;
    private int c = -1;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[androidx.lifecycle.d.b.values().length];
            a = iArr;
            try {
                iArr[androidx.lifecycle.d.b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[androidx.lifecycle.d.b.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[androidx.lifecycle.d.b.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    r(l lVar, Fragment fragment) {
        this.a = lVar;
        this.b = fragment;
    }

    r(l lVar, Fragment fragment, q qVar) {
        this.a = lVar;
        this.b = fragment;
        fragment.f289d = null;
        fragment.r = 0;
        fragment.o = false;
        fragment.l = false;
        Fragment fragment2 = fragment.h;
        fragment.i = fragment2 != null ? fragment2.f291f : null;
        Fragment fragment3 = this.b;
        fragment3.h = null;
        Bundle bundle = qVar.n;
        fragment3.c = bundle == null ? new Bundle() : bundle;
    }

    r(l lVar, ClassLoader classLoader, i iVar, q qVar) {
        this.a = lVar;
        this.b = iVar.a(classLoader, qVar.b);
        Bundle bundle = qVar.k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        this.b.f1(qVar.k);
        Fragment fragment = this.b;
        fragment.f291f = qVar.c;
        fragment.n = qVar.f323d;
        fragment.p = true;
        fragment.w = qVar.f324e;
        fragment.x = qVar.f325f;
        fragment.y = qVar.f326g;
        fragment.B = qVar.h;
        fragment.m = qVar.i;
        fragment.A = qVar.j;
        fragment.z = qVar.l;
        fragment.Q = androidx.lifecycle.d.b.values()[qVar.m];
        Bundle bundle2 = qVar.n;
        if (bundle2 != null) {
            this.b.c = bundle2;
        } else {
            this.b.c = new Bundle();
        }
        if (m.p0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + this.b);
        }
    }

    private Bundle n() {
        Bundle bundle = new Bundle();
        this.b.V0(bundle);
        this.a.j(this.b, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.b.H != null) {
            p();
        }
        if (this.b.f289d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.b.f289d);
        }
        if (!this.b.J) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.b.J);
        }
        return bundle;
    }

    void a() {
        if (m.p0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.b);
        }
        Fragment fragment = this.b;
        fragment.B0(fragment.c);
        l lVar = this.a;
        Fragment fragment2 = this.b;
        lVar.a(fragment2, fragment2.c, false);
    }

    void b(j<?> jVar, m mVar, Fragment fragment) {
        Fragment fragment2 = this.b;
        fragment2.t = jVar;
        fragment2.v = fragment;
        fragment2.s = mVar;
        this.a.g(fragment2, jVar.i(), false);
        this.b.C0();
        Fragment fragment3 = this.b;
        Fragment fragment4 = fragment3.v;
        if (fragment4 == null) {
            jVar.k(fragment3);
        } else {
            fragment4.Y(fragment3);
        }
        this.a.b(this.b, jVar.i(), false);
    }

    int c() {
        int iMin = this.c;
        Fragment fragment = this.b;
        if (fragment.n) {
            if (fragment.o) {
                iMin = Math.max(iMin, 1);
            } else {
                iMin = iMin < 2 ? Math.min(iMin, fragment.b) : Math.min(iMin, 1);
            }
        }
        if (!this.b.l) {
            iMin = Math.min(iMin, 1);
        }
        Fragment fragment2 = this.b;
        if (fragment2.m) {
            iMin = fragment2.O() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        Fragment fragment3 = this.b;
        if (fragment3.I && fragment3.b < 3) {
            iMin = Math.min(iMin, 2);
        }
        int i = a.a[this.b.Q.ordinal()];
        if (i == 1) {
            return iMin;
        }
        if (i != 2) {
            return i != 3 ? Math.min(iMin, -1) : Math.min(iMin, 1);
        }
        return Math.min(iMin, 3);
    }

    void d() {
        if (m.p0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.b);
        }
        Fragment fragment = this.b;
        if (fragment.P) {
            fragment.b1(fragment.c);
            this.b.b = 1;
            return;
        }
        this.a.h(fragment, fragment.c, false);
        Fragment fragment2 = this.b;
        fragment2.F0(fragment2.c);
        l lVar = this.a;
        Fragment fragment3 = this.b;
        lVar.c(fragment3, fragment3.c, false);
    }

    void e(f fVar) {
        String resourceName;
        if (this.b.n) {
            return;
        }
        if (m.p0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.b);
        }
        ViewGroup viewGroup = null;
        Fragment fragment = this.b;
        ViewGroup viewGroup2 = fragment.G;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i = fragment.x;
            if (i != 0) {
                if (i == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.b + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fVar.c(i);
                if (viewGroup == null) {
                    Fragment fragment2 = this.b;
                    if (!fragment2.p) {
                        try {
                            resourceName = fragment2.B().getResourceName(this.b.x);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.b.x) + " (" + resourceName + ") for fragment " + this.b);
                    }
                }
            }
        }
        Fragment fragment3 = this.b;
        fragment3.G = viewGroup;
        fragment3.H0(fragment3.L0(fragment3.c), viewGroup, this.b.c);
        View view = this.b.H;
        if (view != null) {
            boolean z = false;
            view.setSaveFromParentEnabled(false);
            Fragment fragment4 = this.b;
            fragment4.H.setTag(d.i.b.fragment_container_view_tag, fragment4);
            if (viewGroup != null) {
                viewGroup.addView(this.b.H);
            }
            Fragment fragment5 = this.b;
            if (fragment5.z) {
                fragment5.H.setVisibility(8);
            }
            d.f.k.r.a0(this.b.H);
            Fragment fragment6 = this.b;
            fragment6.z0(fragment6.H, fragment6.c);
            l lVar = this.a;
            Fragment fragment7 = this.b;
            lVar.m(fragment7, fragment7.H, fragment7.c, false);
            Fragment fragment8 = this.b;
            if (fragment8.H.getVisibility() == 0 && this.b.G != null) {
                z = true;
            }
            fragment8.L = z;
        }
    }

    void f(j<?> jVar, p pVar) {
        if (m.p0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.b);
        }
        Fragment fragment = this.b;
        boolean zIsChangingConfigurations = true;
        boolean z = fragment.m && !fragment.O();
        if (!(z || pVar.n(this.b))) {
            this.b.b = 0;
            return;
        }
        if (jVar instanceof androidx.lifecycle.t) {
            zIsChangingConfigurations = pVar.l();
        } else if (jVar.i() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) jVar.i()).isChangingConfigurations();
        }
        if (z || zIsChangingConfigurations) {
            pVar.f(this.b);
        }
        this.b.I0();
        this.a.d(this.b, false);
    }

    void g(p pVar) {
        if (m.p0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.b);
        }
        this.b.K0();
        boolean z = false;
        this.a.e(this.b, false);
        Fragment fragment = this.b;
        fragment.b = -1;
        fragment.t = null;
        fragment.v = null;
        fragment.s = null;
        if (fragment.m && !fragment.O()) {
            z = true;
        }
        if (z || pVar.n(this.b)) {
            if (m.p0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.b);
            }
            this.b.L();
        }
    }

    void h() {
        Fragment fragment = this.b;
        if (fragment.n && fragment.o && !fragment.q) {
            if (m.p0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.b);
            }
            Fragment fragment2 = this.b;
            fragment2.H0(fragment2.L0(fragment2.c), null, this.b.c);
            View view = this.b.H;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.b;
                fragment3.H.setTag(d.i.b.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.b;
                if (fragment4.z) {
                    fragment4.H.setVisibility(8);
                }
                Fragment fragment5 = this.b;
                fragment5.z0(fragment5.H, fragment5.c);
                l lVar = this.a;
                Fragment fragment6 = this.b;
                lVar.m(fragment6, fragment6.H, fragment6.c, false);
            }
        }
    }

    Fragment i() {
        return this.b;
    }

    void j() {
        if (m.p0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.b);
        }
        this.b.Q0();
        this.a.f(this.b, false);
    }

    void k(ClassLoader classLoader) {
        Bundle bundle = this.b.c;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.b;
        fragment.f289d = fragment.c.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.b;
        fragment2.i = fragment2.c.getString("android:target_state");
        Fragment fragment3 = this.b;
        if (fragment3.i != null) {
            fragment3.j = fragment3.c.getInt("android:target_req_state", 0);
        }
        Fragment fragment4 = this.b;
        Boolean bool = fragment4.f290e;
        if (bool != null) {
            fragment4.J = bool.booleanValue();
            this.b.f290e = null;
        } else {
            fragment4.J = fragment4.c.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment5 = this.b;
        if (fragment5.J) {
            return;
        }
        fragment5.I = true;
    }

    void l() {
        if (m.p0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this.b);
        }
        Fragment fragment = this.b;
        if (fragment.H != null) {
            fragment.c1(fragment.c);
        }
        this.b.c = null;
    }

    void m() {
        if (m.p0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.b);
        }
        this.b.U0();
        this.a.i(this.b, false);
        Fragment fragment = this.b;
        fragment.c = null;
        fragment.f289d = null;
    }

    q o() {
        q qVar = new q(this.b);
        if (this.b.b <= -1 || qVar.n != null) {
            qVar.n = this.b.c;
        } else {
            Bundle bundleN = n();
            qVar.n = bundleN;
            if (this.b.i != null) {
                if (bundleN == null) {
                    qVar.n = new Bundle();
                }
                qVar.n.putString("android:target_state", this.b.i);
                int i = this.b.j;
                if (i != 0) {
                    qVar.n.putInt("android:target_req_state", i);
                }
            }
        }
        return qVar;
    }

    void p() {
        if (this.b.H == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.b.H.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.b.f289d = sparseArray;
        }
    }

    void q(int i) {
        this.c = i;
    }

    void r() {
        if (m.p0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.b);
        }
        this.b.W0();
        this.a.k(this.b, false);
    }

    void s() {
        if (m.p0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.b);
        }
        this.b.X0();
        this.a.l(this.b, false);
    }
}
