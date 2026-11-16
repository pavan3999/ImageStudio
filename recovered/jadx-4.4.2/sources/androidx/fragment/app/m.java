package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    private static boolean F = false;
    private ArrayList<Boolean> A;
    private ArrayList<Fragment> B;
    private ArrayList<j> C;
    private p D;
    private boolean b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList<androidx.fragment.app.a> f311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<Fragment> f312e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private OnBackPressedDispatcher f314g;
    private ArrayList<g> j;
    androidx.fragment.app.j<?> o;
    androidx.fragment.app.f p;
    private Fragment q;
    Fragment r;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private ArrayList<androidx.fragment.app.a> z;
    private final ArrayList<h> a = new ArrayList<>();
    private final s c = new s();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k f313f = new k(this);
    private final androidx.activity.b h = new a(false);
    private final AtomicInteger i = new AtomicInteger();
    private ConcurrentHashMap<Fragment, HashSet<d.f.g.a>> k = new ConcurrentHashMap<>();
    private final u.g l = new b();
    private final l m = new l(this);
    int n = -1;
    private androidx.fragment.app.i s = null;
    private androidx.fragment.app.i t = new c();
    private Runnable E = new d();

    class a extends androidx.activity.b {
        a(boolean z) {
            super(z);
        }

        @Override // androidx.activity.b
        public void b() {
            m.this.m0();
        }
    }

    class b implements u.g {
        b() {
        }

        @Override // androidx.fragment.app.u.g
        public void a(Fragment fragment, d.f.g.a aVar) {
            if (aVar.b()) {
                return;
            }
            m.this.I0(fragment, aVar);
        }

        @Override // androidx.fragment.app.u.g
        public void b(Fragment fragment, d.f.g.a aVar) {
            m.this.c(fragment, aVar);
        }
    }

    class c extends androidx.fragment.app.i {
        c() {
        }

        @Override // androidx.fragment.app.i
        public Fragment a(ClassLoader classLoader, String str) {
            androidx.fragment.app.j<?> jVar = m.this.o;
            return jVar.b(jVar.i(), str, null);
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.Q(true);
        }
    }

    class e extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ View b;
        final /* synthetic */ Fragment c;

        e(m mVar, ViewGroup viewGroup, View view, Fragment fragment) {
            this.a = viewGroup;
            this.b = view;
            this.c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.endViewTransition(this.b);
            animator.removeListener(this);
            Fragment fragment = this.c;
            View view = fragment.H;
            if (view == null || !fragment.z) {
                return;
            }
            view.setVisibility(8);
        }
    }

    public static abstract class f {
        public abstract void a(m mVar, Fragment fragment, Bundle bundle);

        public abstract void b(m mVar, Fragment fragment, Context context);

        public abstract void c(m mVar, Fragment fragment, Bundle bundle);

        public abstract void d(m mVar, Fragment fragment);

        public abstract void e(m mVar, Fragment fragment);

        public abstract void f(m mVar, Fragment fragment);

        public abstract void g(m mVar, Fragment fragment, Context context);

        public abstract void h(m mVar, Fragment fragment, Bundle bundle);

        public abstract void i(m mVar, Fragment fragment);

        public abstract void j(m mVar, Fragment fragment, Bundle bundle);

        public abstract void k(m mVar, Fragment fragment);

        public abstract void l(m mVar, Fragment fragment);

        public abstract void m(m mVar, Fragment fragment, View view, Bundle bundle);

        public abstract void n(m mVar, Fragment fragment);
    }

    public interface g {
        void a();
    }

    interface h {
        boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    private class i implements h {
        final String a;
        final int b;
        final int c;

        i(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // androidx.fragment.app.m.h
        public boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = m.this.r;
            if (fragment == null || this.b >= 0 || this.a != null || !fragment.o().E0()) {
                return m.this.G0(arrayList, arrayList2, this.a, this.b, this.c);
            }
            return false;
        }
    }

    static class j implements Fragment.e {
        final boolean a;
        final androidx.fragment.app.a b;
        private int c;

        j(androidx.fragment.app.a aVar, boolean z) {
            this.a = z;
            this.b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.e
        public void a() {
            int i = this.c - 1;
            this.c = i;
            if (i != 0) {
                return;
            }
            this.b.q.Q0();
        }

        @Override // androidx.fragment.app.Fragment.e
        public void b() {
            this.c++;
        }

        void c() {
            androidx.fragment.app.a aVar = this.b;
            aVar.q.n(aVar, this.a, false, false);
        }

        void d() {
            boolean z = this.c > 0;
            for (Fragment fragment : this.b.q.f0()) {
                fragment.j1(null);
                if (z && fragment.P()) {
                    fragment.l1();
                }
            }
            androidx.fragment.app.a aVar = this.b;
            aVar.q.n(aVar, this.a, !z, true);
        }

        public boolean e() {
            return this.c == 0;
        }
    }

    private void C(Fragment fragment) {
        if (fragment == null || !fragment.equals(V(fragment.f291f))) {
            return;
        }
        fragment.T0();
    }

    private boolean F0(String str, int i2, int i3) {
        Q(false);
        P(true);
        Fragment fragment = this.r;
        if (fragment != null && i2 < 0 && str == null && fragment.o().E0()) {
            return true;
        }
        boolean zG0 = G0(this.z, this.A, str, i2, i3);
        if (zG0) {
            this.b = true;
            try {
                K0(this.z, this.A);
                m();
            } catch (Throwable th) {
                m();
                throw th;
            }
        }
        X0();
        L();
        this.c.b();
        return zG0;
    }

    private int H0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, d.d.b<Fragment> bVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            androidx.fragment.app.a aVar = arrayList.get(i5);
            boolean zBooleanValue = arrayList2.get(i5).booleanValue();
            if (aVar.A() && !aVar.y(arrayList, i5 + 1, i3)) {
                if (this.C == null) {
                    this.C = new ArrayList<>();
                }
                j jVar = new j(aVar, zBooleanValue);
                this.C.add(jVar);
                aVar.C(jVar);
                if (zBooleanValue) {
                    aVar.t();
                } else {
                    aVar.u(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                a(bVar);
            }
        }
        return i4;
    }

    private void J(int i2) {
        try {
            this.b = true;
            this.c.d(i2);
            y0(i2, false);
            this.b = false;
            Q(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    private void K0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        U(arrayList, arrayList2);
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!arrayList.get(i2).o) {
                if (i3 != i2) {
                    T(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (arrayList2.get(i2).booleanValue()) {
                    while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).o) {
                        i3++;
                    }
                }
                T(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            T(arrayList, arrayList2, i3, size);
        }
    }

    private void L() {
        if (this.y) {
            this.y = false;
            W0();
        }
    }

    private void M0() {
        if (this.j != null) {
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                this.j.get(i2).a();
            }
        }
    }

    private void N() {
        if (this.k.isEmpty()) {
            return;
        }
        for (Fragment fragment : this.k.keySet()) {
            j(fragment);
            A0(fragment, fragment.G());
        }
    }

    static int O0(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private void P(boolean z) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.o == null) {
            if (!this.x) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.o.j().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            l();
        }
        if (this.z == null) {
            this.z = new ArrayList<>();
            this.A = new ArrayList<>();
        }
        this.b = true;
        try {
            U(null, null);
        } finally {
            this.b = false;
        }
    }

    private static void S(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            androidx.fragment.app.a aVar = arrayList.get(i2);
            if (arrayList2.get(i2).booleanValue()) {
                aVar.p(-1);
                aVar.u(i2 == i3 + (-1));
            } else {
                aVar.p(1);
                aVar.t();
            }
            i2++;
        }
    }

    private void T(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        int i5 = i2;
        boolean z = arrayList.get(i5).o;
        ArrayList<Fragment> arrayList3 = this.B;
        if (arrayList3 == null) {
            this.B = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.B.addAll(this.c.m());
        Fragment fragmentJ0 = j0();
        boolean z2 = false;
        for (int i6 = i5; i6 < i3; i6++) {
            androidx.fragment.app.a aVar = arrayList.get(i6);
            fragmentJ0 = !arrayList2.get(i6).booleanValue() ? aVar.v(this.B, fragmentJ0) : aVar.D(this.B, fragmentJ0);
            z2 = z2 || aVar.f330g;
        }
        this.B.clear();
        if (!z) {
            u.C(this, arrayList, arrayList2, i2, i3, false, this.l);
        }
        S(arrayList, arrayList2, i2, i3);
        if (z) {
            d.d.b<Fragment> bVar = new d.d.b<>();
            a(bVar);
            int iH0 = H0(arrayList, arrayList2, i2, i3, bVar);
            w0(bVar);
            i4 = iH0;
        } else {
            i4 = i3;
        }
        if (i4 != i5 && z) {
            u.C(this, arrayList, arrayList2, i2, i4, true, this.l);
            y0(this.n, true);
        }
        while (i5 < i3) {
            androidx.fragment.app.a aVar2 = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue() && aVar2.s >= 0) {
                aVar2.s = -1;
            }
            aVar2.B();
            i5++;
        }
        if (z2) {
            M0();
        }
    }

    private void U(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        ArrayList<j> arrayList3 = this.C;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            j jVar = this.C.get(i2);
            if (arrayList == null || jVar.a || (iIndexOf2 = arrayList.indexOf(jVar.b)) == -1 || arrayList2 == null || !arrayList2.get(iIndexOf2).booleanValue()) {
                if (jVar.e() || (arrayList != null && jVar.b.y(arrayList, 0, arrayList.size()))) {
                    this.C.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || jVar.a || (iIndexOf = arrayList.indexOf(jVar.b)) == -1 || arrayList2 == null || !arrayList2.get(iIndexOf).booleanValue()) {
                        jVar.d();
                    }
                }
                i2++;
            } else {
                this.C.remove(i2);
                i2--;
                size--;
            }
            jVar.c();
            i2++;
        }
    }

    private void U0(Fragment fragment) {
        ViewGroup viewGroupD0 = d0(fragment);
        if (viewGroupD0 != null) {
            if (viewGroupD0.getTag(d.i.b.visible_removing_fragment_view_tag) == null) {
                viewGroupD0.setTag(d.i.b.visible_removing_fragment_view_tag, fragment);
            }
            ((Fragment) viewGroupD0.getTag(d.i.b.visible_removing_fragment_view_tag)).h1(fragment.w());
        }
    }

    private void W0() {
        for (Fragment fragment : this.c.k()) {
            if (fragment != null) {
                C0(fragment);
            }
        }
    }

    private void X0() {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                this.h.f(b0() > 0 && r0(this.q));
            } else {
                this.h.f(true);
            }
        }
    }

    private void Z() {
        if (this.C != null) {
            while (!this.C.isEmpty()) {
                this.C.remove(0).d();
            }
        }
    }

    private void a(d.d.b<Fragment> bVar) {
        int i2 = this.n;
        if (i2 < 1) {
            return;
        }
        int iMin = Math.min(i2, 3);
        for (Fragment fragment : this.c.m()) {
            if (fragment.b < iMin) {
                A0(fragment, iMin);
                if (fragment.H != null && !fragment.z && fragment.L) {
                    bVar.add(fragment);
                }
            }
        }
    }

    private boolean a0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                return false;
            }
            int size = this.a.size();
            boolean zA = false;
            for (int i2 = 0; i2 < size; i2++) {
                zA |= this.a.get(i2).a(arrayList, arrayList2);
            }
            this.a.clear();
            this.o.j().removeCallbacks(this.E);
            return zA;
        }
    }

    private p c0(Fragment fragment) {
        return this.D.h(fragment);
    }

    private ViewGroup d0(Fragment fragment) {
        if (fragment.x > 0 && this.p.g()) {
            View viewC = this.p.c(fragment.x);
            if (viewC instanceof ViewGroup) {
                return (ViewGroup) viewC;
            }
        }
        return null;
    }

    private void j(Fragment fragment) {
        HashSet<d.f.g.a> hashSet = this.k.get(fragment);
        if (hashSet != null) {
            Iterator<d.f.g.a> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            p(fragment);
            this.k.remove(fragment);
        }
    }

    static Fragment k0(View view) {
        Object tag = view.getTag(d.i.b.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    private void l() {
        if (t0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void m() {
        this.b = false;
        this.A.clear();
        this.z.clear();
    }

    private void o(Fragment fragment) {
        Animator animator;
        if (fragment.H != null) {
            androidx.fragment.app.e.d dVarB = androidx.fragment.app.e.b(this.o.i(), this.p, fragment, !fragment.z);
            if (dVarB == null || (animator = dVarB.b) == null) {
                if (dVarB != null) {
                    fragment.H.startAnimation(dVarB.a);
                    dVarB.a.start();
                }
                fragment.H.setVisibility((!fragment.z || fragment.N()) ? 0 : 8);
                if (fragment.N()) {
                    fragment.g1(false);
                }
            } else {
                animator.setTarget(fragment.H);
                if (!fragment.z) {
                    fragment.H.setVisibility(0);
                } else if (fragment.N()) {
                    fragment.g1(false);
                } else {
                    ViewGroup viewGroup = fragment.G;
                    View view = fragment.H;
                    viewGroup.startViewTransition(view);
                    dVarB.b.addListener(new e(this, viewGroup, view, fragment));
                }
                dVarB.b.start();
            }
        }
        if (fragment.l && q0(fragment)) {
            this.u = true;
        }
        fragment.M = false;
        fragment.k0(fragment.z);
    }

    private void p(Fragment fragment) {
        fragment.J0();
        this.m.n(fragment, false);
        fragment.G = null;
        fragment.H = null;
        fragment.S = null;
        fragment.T.h(null);
        fragment.o = false;
    }

    static boolean p0(int i2) {
        return F || Log.isLoggable("FragmentManager", i2);
    }

    private boolean q0(Fragment fragment) {
        return (fragment.D && fragment.E) || fragment.u.k();
    }

    private void v0(r rVar) {
        Fragment fragmentI = rVar.i();
        if (this.c.c(fragmentI.f291f)) {
            if (p0(2)) {
                Log.v("FragmentManager", "Removed fragment from active set " + fragmentI);
            }
            this.c.o(rVar);
            L0(fragmentI);
        }
    }

    private void w0(d.d.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragmentI = bVar.i(i2);
            if (!fragmentI.l) {
                View viewA1 = fragmentI.a1();
                fragmentI.N = viewA1.getAlpha();
                viewA1.setAlpha(0.0f);
            }
        }
    }

    boolean A(MenuItem menuItem) {
        if (this.n < 1) {
            return false;
        }
        for (Fragment fragment : this.c.m()) {
            if (fragment != null && fragment.O0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:125:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:47:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:51:0x00fd  */
    void A0(Fragment fragment, int i2) {
        Fragment fragmentV;
        ViewGroup viewGroup;
        r rVarL = this.c.l(fragment.f291f);
        int i3 = 1;
        if (rVarL == null) {
            rVarL = new r(this.m, fragment);
            rVarL.q(1);
        }
        int iMin = Math.min(i2, rVarL.c());
        int i4 = fragment.b;
        androidx.fragment.app.e.d dVarB = null;
        if (i4 <= iMin) {
            if (i4 < iMin && !this.k.isEmpty()) {
                j(fragment);
            }
            int i5 = fragment.b;
            if (i5 != -1) {
                if (i5 != 0) {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 == 3) {
                            }
                        }
                        if (iMin > 3) {
                            rVarL.m();
                        }
                    }
                    if (iMin > 2) {
                        rVarL.r();
                    }
                    if (iMin > 3) {
                        rVarL.m();
                    }
                }
                if (iMin > -1) {
                    rVarL.h();
                }
                if (iMin > 1) {
                    rVarL.e(this.p);
                    rVarL.a();
                    rVarL.l();
                }
                if (iMin > 2) {
                    rVarL.r();
                }
                if (iMin > 3) {
                    rVarL.m();
                }
            } else if (iMin > -1) {
                if (p0(3)) {
                    Log.d("FragmentManager", "moveto ATTACHED: " + fragment);
                }
                Fragment fragment2 = fragment.h;
                if (fragment2 != null) {
                    if (!fragment2.equals(V(fragment2.f291f))) {
                        throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.h + " that does not belong to this FragmentManager!");
                    }
                    Fragment fragment3 = fragment.h;
                    if (fragment3.b < 1) {
                        A0(fragment3, 1);
                    }
                    fragment.i = fragment.h.f291f;
                    fragment.h = null;
                }
                String str = fragment.i;
                if (str != null) {
                    Fragment fragmentV2 = V(str);
                    if (fragmentV2 == null) {
                        throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.i + " that does not belong to this FragmentManager!");
                    }
                    if (fragmentV2.b < 1) {
                        A0(fragmentV2, 1);
                    }
                }
                rVarL.b(this.o, this, this.q);
            }
            if (iMin > 0) {
                rVarL.d();
            }
            if (iMin > -1) {
                rVarL.h();
            }
            if (iMin > 1) {
                rVarL.e(this.p);
                rVarL.a();
                rVarL.l();
            }
            if (iMin > 2) {
                rVarL.r();
            }
            if (iMin > 3) {
                rVarL.m();
            }
        } else if (i4 > iMin) {
            if (i4 != 0) {
                boolean z = false;
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 == 4) {
                                if (iMin < 4) {
                                    rVarL.j();
                                }
                            }
                        }
                        if (iMin < 3) {
                            rVarL.s();
                        }
                    }
                    if (iMin < 2) {
                        if (p0(3)) {
                            Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                        }
                        if (fragment.H != null && this.o.n(fragment) && fragment.f289d == null) {
                            rVarL.p();
                        }
                        View view = fragment.H;
                        if (view != null && (viewGroup = fragment.G) != null) {
                            viewGroup.endViewTransition(view);
                            fragment.H.clearAnimation();
                            if (!fragment.R()) {
                                if (this.n > -1 && !this.x && fragment.H.getVisibility() == 0 && fragment.N >= 0.0f) {
                                    dVarB = androidx.fragment.app.e.b(this.o.i(), this.p, fragment, false);
                                }
                                fragment.N = 0.0f;
                                ViewGroup viewGroup2 = fragment.G;
                                View view2 = fragment.H;
                                if (dVarB != null) {
                                    fragment.k1(iMin);
                                    androidx.fragment.app.e.a(fragment, dVarB, this.l);
                                }
                                viewGroup2.removeView(view2);
                                if (viewGroup2 != fragment.G) {
                                    return;
                                }
                            }
                        }
                        if (this.k.get(fragment) == null) {
                            p(fragment);
                        } else {
                            fragment.k1(iMin);
                        }
                    }
                }
                if (iMin >= 1) {
                    i3 = iMin;
                } else {
                    if (fragment.m && !fragment.O()) {
                        z = true;
                    }
                    if (z || this.D.n(fragment)) {
                        v0(rVarL);
                    } else {
                        String str2 = fragment.i;
                        if (str2 != null && (fragmentV = V(str2)) != null && fragmentV.C()) {
                            fragment.h = fragmentV;
                        }
                    }
                    if (this.k.get(fragment) != null) {
                        fragment.k1(iMin);
                    } else {
                        rVarL.f(this.o, this.D);
                        i3 = iMin;
                    }
                }
                if (i3 < 0) {
                    rVarL.g(this.D);
                }
                iMin = i3;
            } else {
                i3 = iMin;
                if (i3 < 0) {
                    rVarL.g(this.D);
                }
                iMin = i3;
            }
        }
        if (fragment.b != iMin) {
            if (p0(3)) {
                Log.d("FragmentManager", "moveToState: Fragment state for " + fragment + " not updated inline; expected state " + iMin + " found " + fragment.b);
            }
            fragment.b = iMin;
        }
    }

    void B(Menu menu) {
        if (this.n < 1) {
            return;
        }
        for (Fragment fragment : this.c.m()) {
            if (fragment != null) {
                fragment.P0(menu);
            }
        }
    }

    void B0() {
        if (this.o == null) {
            return;
        }
        this.v = false;
        this.w = false;
        for (Fragment fragment : this.c.m()) {
            if (fragment != null) {
                fragment.T();
            }
        }
    }

    void C0(Fragment fragment) {
        if (fragment.I) {
            if (this.b) {
                this.y = true;
            } else {
                fragment.I = false;
                A0(fragment, this.n);
            }
        }
    }

    void D() {
        J(3);
    }

    public void D0(int i2, int i3) {
        if (i2 >= 0) {
            O(new i(null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    void E(boolean z) {
        for (Fragment fragment : this.c.m()) {
            if (fragment != null) {
                fragment.R0(z);
            }
        }
    }

    public boolean E0() {
        return F0(null, -1, 0);
    }

    boolean F(Menu menu) {
        boolean z = false;
        if (this.n < 1) {
            return false;
        }
        for (Fragment fragment : this.c.m()) {
            if (fragment != null && fragment.S0(menu)) {
                z = true;
            }
        }
        return z;
    }

    void G() {
        X0();
        C(this.r);
    }

    boolean G0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList<androidx.fragment.app.a> arrayList3 = this.f311d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f311d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i2 >= 0) {
                int size2 = this.f311d.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.a aVar = this.f311d.get(size2);
                    if ((str != null && str.equals(aVar.w())) || (i2 >= 0 && i2 == aVar.s)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        androidx.fragment.app.a aVar2 = this.f311d.get(size2);
                        if (str == null || !str.equals(aVar2.w())) {
                            if (i2 < 0 || i2 != aVar2.s) {
                                break;
                            }
                        }
                    }
                }
                i4 = size2;
            } else {
                i4 = -1;
            }
            if (i4 == this.f311d.size() - 1) {
                return false;
            }
            for (int size3 = this.f311d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f311d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    void H() {
        this.v = false;
        this.w = false;
        J(4);
    }

    void I() {
        this.v = false;
        this.w = false;
        J(3);
    }

    void I0(Fragment fragment, d.f.g.a aVar) {
        HashSet<d.f.g.a> hashSet = this.k.get(fragment);
        if (hashSet != null && hashSet.remove(aVar) && hashSet.isEmpty()) {
            this.k.remove(fragment);
            if (fragment.b < 3) {
                p(fragment);
                A0(fragment, fragment.G());
            }
        }
    }

    void J0(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.r);
        }
        boolean z = !fragment.O();
        if (!fragment.A || z) {
            this.c.p(fragment);
            if (q0(fragment)) {
                this.u = true;
            }
            fragment.m = true;
            U0(fragment);
        }
    }

    void K() {
        this.w = true;
        J(2);
    }

    void L0(Fragment fragment) {
        if (t0()) {
            if (p0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.D.m(fragment) && p0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public void M(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f312e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                Fragment fragment = this.f312e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList2 = this.f311d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                androidx.fragment.app.a aVar = this.f311d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.r(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.i.get());
        synchronized (this.a) {
            int size3 = this.a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i4 = 0; i4 < size3; i4++) {
                    h hVar = this.a.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(hVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.p);
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.v);
        printWriter.print(" mStopped=");
        printWriter.print(this.w);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.x);
        if (this.u) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.u);
        }
    }

    void N0(Parcelable parcelable) {
        r rVar;
        if (parcelable == null) {
            return;
        }
        o oVar = (o) parcelable;
        if (oVar.b == null) {
            return;
        }
        this.c.q();
        for (q qVar : oVar.b) {
            if (qVar != null) {
                Fragment fragmentG = this.D.g(qVar.c);
                if (fragmentG != null) {
                    if (p0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragmentG);
                    }
                    rVar = new r(this.m, fragmentG, qVar);
                } else {
                    rVar = new r(this.m, this.o.i().getClassLoader(), e0(), qVar);
                }
                Fragment fragmentI = rVar.i();
                fragmentI.s = this;
                if (p0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragmentI.f291f + "): " + fragmentI);
                }
                rVar.k(this.o.i().getClassLoader());
                this.c.n(rVar);
                rVar.q(this.n);
            }
        }
        for (Fragment fragment : this.D.j()) {
            if (!this.c.c(fragment.f291f)) {
                if (p0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + oVar.b);
                }
                A0(fragment, 1);
                fragment.m = true;
                A0(fragment, -1);
            }
        }
        this.c.r(oVar.c);
        if (oVar.f316d != null) {
            this.f311d = new ArrayList<>(oVar.f316d.length);
            int i2 = 0;
            while (true) {
                androidx.fragment.app.b[] bVarArr = oVar.f316d;
                if (i2 >= bVarArr.length) {
                    break;
                }
                androidx.fragment.app.a aVarJ = bVarArr[i2].j(this);
                if (p0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + aVarJ.s + "): " + aVarJ);
                    PrintWriter printWriter = new PrintWriter(new d.f.j.b("FragmentManager"));
                    aVarJ.s("  ", printWriter, false);
                    printWriter.close();
                }
                this.f311d.add(aVarJ);
                i2++;
            }
        } else {
            this.f311d = null;
        }
        this.i.set(oVar.f317e);
        String str = oVar.f318f;
        if (str != null) {
            Fragment fragmentV = V(str);
            this.r = fragmentV;
            C(fragmentV);
        }
    }

    void O(h hVar, boolean z) {
        if (!z) {
            if (this.o == null) {
                if (!this.x) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            l();
        }
        synchronized (this.a) {
            if (this.o == null) {
                if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.a.add(hVar);
                Q0();
            }
        }
    }

    Parcelable P0() {
        int size;
        Z();
        N();
        Q(true);
        this.v = true;
        ArrayList<q> arrayListS = this.c.s();
        androidx.fragment.app.b[] bVarArr = null;
        if (arrayListS.isEmpty()) {
            if (p0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> arrayListT = this.c.t();
        ArrayList<androidx.fragment.app.a> arrayList = this.f311d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            bVarArr = new androidx.fragment.app.b[size];
            for (int i2 = 0; i2 < size; i2++) {
                bVarArr[i2] = new androidx.fragment.app.b(this.f311d.get(i2));
                if (p0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f311d.get(i2));
                }
            }
        }
        o oVar = new o();
        oVar.b = arrayListS;
        oVar.c = arrayListT;
        oVar.f316d = bVarArr;
        oVar.f317e = this.i.get();
        Fragment fragment = this.r;
        if (fragment != null) {
            oVar.f318f = fragment.f291f;
        }
        return oVar;
    }

    boolean Q(boolean z) {
        P(z);
        boolean z2 = false;
        while (a0(this.z, this.A)) {
            this.b = true;
            try {
                K0(this.z, this.A);
                m();
                z2 = true;
            } catch (Throwable th) {
                m();
                throw th;
            }
        }
        X0();
        L();
        this.c.b();
        return z2;
    }

    void Q0() {
        synchronized (this.a) {
            boolean z = (this.C == null || this.C.isEmpty()) ? false : true;
            boolean z2 = this.a.size() == 1;
            if (z || z2) {
                this.o.j().removeCallbacks(this.E);
                this.o.j().post(this.E);
                X0();
            }
        }
    }

    void R(h hVar, boolean z) {
        if (z && (this.o == null || this.x)) {
            return;
        }
        P(z);
        if (hVar.a(this.z, this.A)) {
            this.b = true;
            try {
                K0(this.z, this.A);
                m();
            } catch (Throwable th) {
                m();
                throw th;
            }
        }
        X0();
        L();
        this.c.b();
    }

    void R0(Fragment fragment, boolean z) {
        ViewGroup viewGroupD0 = d0(fragment);
        if (viewGroupD0 == null || !(viewGroupD0 instanceof androidx.fragment.app.g)) {
            return;
        }
        ((androidx.fragment.app.g) viewGroupD0).setDrawDisappearingViewsLast(!z);
    }

    void S0(Fragment fragment, androidx.lifecycle.d.b bVar) {
        if (fragment.equals(V(fragment.f291f)) && (fragment.t == null || fragment.s == this)) {
            fragment.Q = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void T0(Fragment fragment) {
        if (fragment == null || (fragment.equals(V(fragment.f291f)) && (fragment.t == null || fragment.s == this))) {
            Fragment fragment2 = this.r;
            this.r = fragment;
            C(fragment2);
            C(this.r);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    Fragment V(String str) {
        return this.c.f(str);
    }

    void V0(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.z) {
            fragment.z = false;
            fragment.M = !fragment.M;
        }
    }

    public Fragment W(int i2) {
        return this.c.g(i2);
    }

    public Fragment X(String str) {
        return this.c.h(str);
    }

    Fragment Y(String str) {
        return this.c.i(str);
    }

    void b(androidx.fragment.app.a aVar) {
        if (this.f311d == null) {
            this.f311d = new ArrayList<>();
        }
        this.f311d.add(aVar);
    }

    public int b0() {
        ArrayList<androidx.fragment.app.a> arrayList = this.f311d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    void c(Fragment fragment, d.f.g.a aVar) {
        if (this.k.get(fragment) == null) {
            this.k.put(fragment, new HashSet<>());
        }
        this.k.get(fragment).add(aVar);
    }

    void d(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        u0(fragment);
        if (fragment.A) {
            return;
        }
        this.c.a(fragment);
        fragment.m = false;
        if (fragment.H == null) {
            fragment.M = false;
        }
        if (q0(fragment)) {
            this.u = true;
        }
    }

    void e(Fragment fragment) {
        if (t0()) {
            if (p0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.D.e(fragment) && p0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public androidx.fragment.app.i e0() {
        androidx.fragment.app.i iVar = this.s;
        if (iVar != null) {
            return iVar;
        }
        Fragment fragment = this.q;
        return fragment != null ? fragment.s.e0() : this.t;
    }

    int f() {
        return this.i.getAndIncrement();
    }

    public List<Fragment> f0() {
        return this.c.m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    void g(androidx.fragment.app.j<?> jVar, androidx.fragment.app.f fVar, Fragment fragment) {
        p pVarI;
        androidx.lifecycle.g gVar;
        if (this.o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.o = jVar;
        this.p = fVar;
        this.q = fragment;
        if (fragment != null) {
            X0();
        }
        if (jVar instanceof androidx.activity.c) {
            androidx.activity.c cVar = (androidx.activity.c) jVar;
            this.f314g = cVar.d();
            if (fragment != null) {
                gVar = cVar;
                gVar = fragment;
            }
            gVar = cVar;
            this.f314g.a(gVar, this.h);
        }
        if (fragment != null) {
            pVarI = fragment.s.c0(fragment);
        } else {
            pVarI = jVar instanceof androidx.lifecycle.t ? p.i(((androidx.lifecycle.t) jVar).f()) : new p(false);
        }
        this.D = pVarI;
    }

    LayoutInflater.Factory2 g0() {
        return this.f313f;
    }

    void h(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.A) {
            fragment.A = false;
            if (fragment.l) {
                return;
            }
            this.c.a(fragment);
            if (p0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (q0(fragment)) {
                this.u = true;
            }
        }
    }

    l h0() {
        return this.m;
    }

    public t i() {
        return new androidx.fragment.app.a(this);
    }

    Fragment i0() {
        return this.q;
    }

    public Fragment j0() {
        return this.r;
    }

    boolean k() {
        boolean zQ0 = false;
        for (Fragment fragment : this.c.k()) {
            if (fragment != null) {
                zQ0 = q0(fragment);
            }
            if (zQ0) {
                return true;
            }
        }
        return false;
    }

    androidx.lifecycle.s l0(Fragment fragment) {
        return this.D.k(fragment);
    }

    void m0() {
        Q(true);
        if (this.h.c()) {
            E0();
        } else {
            this.f314g.c();
        }
    }

    void n(androidx.fragment.app.a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.u(z3);
        } else {
            aVar.t();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            u.C(this, arrayList, arrayList2, 0, 1, true, this.l);
        }
        if (z3) {
            y0(this.n, true);
        }
        for (Fragment fragment : this.c.k()) {
            if (fragment != null && fragment.H != null && fragment.L && aVar.x(fragment.x)) {
                float f2 = fragment.N;
                if (f2 > 0.0f) {
                    fragment.H.setAlpha(f2);
                }
                if (z3) {
                    fragment.N = 0.0f;
                } else {
                    fragment.N = -1.0f;
                    fragment.L = false;
                }
            }
        }
    }

    void n0(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.z) {
            return;
        }
        fragment.z = true;
        fragment.M = true ^ fragment.M;
        U0(fragment);
    }

    public boolean o0() {
        return this.x;
    }

    void q(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.A) {
            return;
        }
        fragment.A = true;
        if (fragment.l) {
            if (p0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.c.p(fragment);
            if (q0(fragment)) {
                this.u = true;
            }
            U0(fragment);
        }
    }

    void r() {
        this.v = false;
        this.w = false;
        J(2);
    }

    boolean r0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        m mVar = fragment.s;
        return fragment.equals(mVar.j0()) && r0(mVar.q);
    }

    void s(Configuration configuration) {
        for (Fragment fragment : this.c.m()) {
            if (fragment != null) {
                fragment.D0(configuration);
            }
        }
    }

    boolean s0(int i2) {
        return this.n >= i2;
    }

    boolean t(MenuItem menuItem) {
        if (this.n < 1) {
            return false;
        }
        for (Fragment fragment : this.c.m()) {
            if (fragment != null && fragment.E0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean t0() {
        return this.v || this.w;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.q;
        if (fragment == null) {
            androidx.fragment.app.j<?> jVar = this.o;
            if (jVar != null) {
                sb.append(jVar.getClass().getSimpleName());
                sb.append("{");
                obj = this.o;
            } else {
                sb.append("null");
            }
            sb.append("}}");
            return sb.toString();
        }
        sb.append(fragment.getClass().getSimpleName());
        sb.append("{");
        obj = this.q;
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("}");
        sb.append("}}");
        return sb.toString();
    }

    void u() {
        this.v = false;
        this.w = false;
        J(1);
    }

    void u0(Fragment fragment) {
        if (this.c.c(fragment.f291f)) {
            return;
        }
        r rVar = new r(this.m, fragment);
        rVar.k(this.o.i().getClassLoader());
        this.c.n(rVar);
        if (fragment.C) {
            if (fragment.B) {
                e(fragment);
            } else {
                L0(fragment);
            }
            fragment.C = false;
        }
        rVar.q(this.n);
        if (p0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    boolean v(Menu menu, MenuInflater menuInflater) {
        if (this.n < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.c.m()) {
            if (fragment != null && fragment.G0(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.f312e != null) {
            for (int i2 = 0; i2 < this.f312e.size(); i2++) {
                Fragment fragment2 = this.f312e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.g0();
                }
            }
        }
        this.f312e = arrayList;
        return z;
    }

    void w() {
        this.x = true;
        Q(true);
        N();
        J(-1);
        this.o = null;
        this.p = null;
        this.q = null;
        if (this.f314g != null) {
            this.h.d();
            this.f314g = null;
        }
    }

    void x() {
        J(1);
    }

    void x0(Fragment fragment) {
        if (!this.c.c(fragment.f291f)) {
            if (p0(3)) {
                Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.n + "since it is not added to " + this);
                return;
            }
            return;
        }
        z0(fragment);
        if (fragment.H != null) {
            Fragment fragmentJ = this.c.j(fragment);
            if (fragmentJ != null) {
                View view = fragmentJ.H;
                ViewGroup viewGroup = fragment.G;
                int iIndexOfChild = viewGroup.indexOfChild(view);
                int iIndexOfChild2 = viewGroup.indexOfChild(fragment.H);
                if (iIndexOfChild2 < iIndexOfChild) {
                    viewGroup.removeViewAt(iIndexOfChild2);
                    viewGroup.addView(fragment.H, iIndexOfChild);
                }
            }
            if (fragment.L && fragment.G != null) {
                float f2 = fragment.N;
                if (f2 > 0.0f) {
                    fragment.H.setAlpha(f2);
                }
                fragment.N = 0.0f;
                fragment.L = false;
                androidx.fragment.app.e.d dVarB = androidx.fragment.app.e.b(this.o.i(), this.p, fragment, true);
                if (dVarB != null) {
                    Animation animation = dVarB.a;
                    if (animation != null) {
                        fragment.H.startAnimation(animation);
                    } else {
                        dVarB.b.setTarget(fragment.H);
                        dVarB.b.start();
                    }
                }
            }
        }
        if (fragment.M) {
            o(fragment);
        }
    }

    void y() {
        for (Fragment fragment : this.c.m()) {
            if (fragment != null) {
                fragment.M0();
            }
        }
    }

    void y0(int i2, boolean z) {
        androidx.fragment.app.j<?> jVar;
        if (this.o == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i2 != this.n) {
            this.n = i2;
            Iterator<Fragment> it = this.c.m().iterator();
            while (it.hasNext()) {
                x0(it.next());
            }
            for (Fragment fragment : this.c.k()) {
                if (fragment != null && !fragment.L) {
                    x0(fragment);
                }
            }
            W0();
            if (this.u && (jVar = this.o) != null && this.n == 4) {
                jVar.o();
                this.u = false;
            }
        }
    }

    void z(boolean z) {
        for (Fragment fragment : this.c.m()) {
            if (fragment != null) {
                fragment.N0(z);
            }
        }
    }

    void z0(Fragment fragment) {
        A0(fragment, this.n);
    }
}
