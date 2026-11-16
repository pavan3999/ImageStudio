package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.g, androidx.lifecycle.t, androidx.savedstate.b {
    static final Object W = new Object();
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    private boolean F;
    ViewGroup G;
    View H;
    boolean I;
    c K;
    boolean L;
    boolean M;
    float N;
    LayoutInflater O;
    boolean P;
    androidx.lifecycle.h R;
    x S;
    androidx.savedstate.a U;
    private int V;
    Bundle c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    SparseArray<Parcelable> f289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Boolean f290e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Bundle f292g;
    Fragment h;
    int j;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    int r;
    m s;
    j<?> t;
    Fragment v;
    int w;
    int x;
    String y;
    boolean z;
    int b = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f291f = UUID.randomUUID().toString();
    String i = null;
    private Boolean k = null;
    m u = new n();
    boolean E = true;
    boolean J = true;
    androidx.lifecycle.d.b Q = androidx.lifecycle.d.b.RESUMED;
    androidx.lifecycle.l<androidx.lifecycle.g> T = new androidx.lifecycle.l<>();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.b();
        }
    }

    class b extends f {
        b() {
        }

        @Override // androidx.fragment.app.f
        public View c(int i) {
            View view = Fragment.this.H;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException("Fragment " + this + " does not have a view");
        }

        @Override // androidx.fragment.app.f
        public boolean g() {
            return Fragment.this.H != null;
        }
    }

    static class c {
        View a;
        Animator b;
        int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f293d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f294e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f295f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f296g;
        Object h;
        Object i;
        Object j;
        Object k;
        Boolean l;
        Boolean m;
        androidx.core.app.f n;
        androidx.core.app.f o;
        boolean p;
        e q;
        boolean r;

        c() {
            Object obj = Fragment.W;
            this.f296g = obj;
            this.h = null;
            this.i = obj;
            this.j = null;
            this.k = obj;
            this.n = null;
            this.o = null;
        }
    }

    public static class d extends RuntimeException {
        public d(String str, Exception exc) {
            super(str, exc);
        }
    }

    interface e {
        void a();

        void b();
    }

    public Fragment() {
        K();
    }

    private void K() {
        this.R = new androidx.lifecycle.h(this);
        this.U = androidx.savedstate.a.a(this);
        if (Build.VERSION.SDK_INT >= 19) {
            this.R.a(new androidx.lifecycle.e() { // from class: androidx.fragment.app.Fragment.2
                @Override // androidx.lifecycle.e
                public void g(androidx.lifecycle.g gVar, androidx.lifecycle.d.a aVar) {
                    View view;
                    if (aVar != androidx.lifecycle.d.a.ON_STOP || (view = Fragment.this.H) == null) {
                        return;
                    }
                    view.cancelPendingInputEvents();
                }
            });
        }
    }

    @Deprecated
    public static Fragment M(Context context, String str, Bundle bundle) {
        try {
            Fragment fragmentNewInstance = i.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragmentNewInstance.getClass().getClassLoader());
                fragmentNewInstance.f1(bundle);
            }
            return fragmentNewInstance;
        } catch (IllegalAccessException e2) {
            throw new d("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new d("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new d("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new d("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    private c g() {
        if (this.K == null) {
            this.K = new c();
        }
        return this.K;
    }

    public Object A() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.i;
        return obj == W ? s() : obj;
    }

    public void A0(Bundle bundle) {
        this.F = true;
    }

    public final Resources B() {
        return Z0().getResources();
    }

    void B0(Bundle bundle) {
        this.u.B0();
        this.b = 2;
        this.F = false;
        U(bundle);
        if (this.F) {
            this.u.r();
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public final boolean C() {
        return this.B;
    }

    void C0() {
        this.u.g(this.t, new b(), this);
        this.b = 0;
        this.F = false;
        X(this.t.i());
        if (this.F) {
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onAttach()");
    }

    public Object D() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.f296g;
        return obj == W ? q() : obj;
    }

    void D0(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.u.s(configuration);
    }

    public Object E() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        return cVar.j;
    }

    boolean E0(MenuItem menuItem) {
        if (this.z) {
            return false;
        }
        return Z(menuItem) || this.u.t(menuItem);
    }

    public Object F() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.k;
        return obj == W ? E() : obj;
    }

    void F0(Bundle bundle) {
        this.u.B0();
        this.b = 1;
        this.F = false;
        this.U.c(bundle);
        a0(bundle);
        this.P = true;
        if (this.F) {
            this.R.i(androidx.lifecycle.d.a.ON_CREATE);
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onCreate()");
    }

    int G() {
        c cVar = this.K;
        if (cVar == null) {
            return 0;
        }
        return cVar.c;
    }

    boolean G0(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.z) {
            return false;
        }
        if (this.D && this.E) {
            z = true;
            d0(menu, menuInflater);
        }
        return z | this.u.v(menu, menuInflater);
    }

    public final String H(int i) {
        return B().getString(i);
    }

    void H0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.u.B0();
        this.q = true;
        this.S = new x();
        View viewE0 = e0(layoutInflater, viewGroup, bundle);
        this.H = viewE0;
        if (viewE0 != null) {
            this.S.c();
            this.T.h(this.S);
        } else {
            if (this.S.f()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.S = null;
        }
    }

    public final Fragment I() {
        String str;
        Fragment fragment = this.h;
        if (fragment != null) {
            return fragment;
        }
        m mVar = this.s;
        if (mVar == null || (str = this.i) == null) {
            return null;
        }
        return mVar.V(str);
    }

    void I0() {
        this.u.w();
        this.R.i(androidx.lifecycle.d.a.ON_DESTROY);
        this.b = 0;
        this.F = false;
        this.P = false;
        f0();
        if (this.F) {
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public View J() {
        return this.H;
    }

    void J0() {
        this.u.x();
        if (this.H != null) {
            this.S.b(androidx.lifecycle.d.a.ON_DESTROY);
        }
        this.b = 1;
        this.F = false;
        h0();
        if (this.F) {
            d.k.a.a.b(this).c();
            this.q = false;
        } else {
            throw new y("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    void K0() {
        this.b = -1;
        this.F = false;
        i0();
        this.O = null;
        if (this.F) {
            if (this.u.o0()) {
                return;
            }
            this.u.w();
            this.u = new n();
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onDetach()");
    }

    void L() {
        K();
        this.f291f = UUID.randomUUID().toString();
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.r = 0;
        this.s = null;
        this.u = new n();
        this.t = null;
        this.w = 0;
        this.x = 0;
        this.y = null;
        this.z = false;
        this.A = false;
    }

    LayoutInflater L0(Bundle bundle) {
        LayoutInflater layoutInflaterJ0 = j0(bundle);
        this.O = layoutInflaterJ0;
        return layoutInflaterJ0;
    }

    void M0() {
        onLowMemory();
        this.u.y();
    }

    boolean N() {
        c cVar = this.K;
        if (cVar == null) {
            return false;
        }
        return cVar.r;
    }

    void N0(boolean z) {
        n0(z);
        this.u.z(z);
    }

    final boolean O() {
        return this.r > 0;
    }

    boolean O0(MenuItem menuItem) {
        if (this.z) {
            return false;
        }
        return (this.D && this.E && o0(menuItem)) || this.u.A(menuItem);
    }

    boolean P() {
        c cVar = this.K;
        if (cVar == null) {
            return false;
        }
        return cVar.p;
    }

    void P0(Menu menu) {
        if (this.z) {
            return;
        }
        if (this.D && this.E) {
            p0(menu);
        }
        this.u.B(menu);
    }

    public final boolean Q() {
        return this.m;
    }

    void Q0() {
        this.u.D();
        if (this.H != null) {
            this.S.b(androidx.lifecycle.d.a.ON_PAUSE);
        }
        this.R.i(androidx.lifecycle.d.a.ON_PAUSE);
        this.b = 3;
        this.F = false;
        q0();
        if (this.F) {
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onPause()");
    }

    final boolean R() {
        Fragment fragmentY = y();
        return fragmentY != null && (fragmentY.Q() || fragmentY.R());
    }

    void R0(boolean z) {
        r0(z);
        this.u.E(z);
    }

    public final boolean S() {
        m mVar = this.s;
        if (mVar == null) {
            return false;
        }
        return mVar.t0();
    }

    boolean S0(Menu menu) {
        boolean z = false;
        if (this.z) {
            return false;
        }
        if (this.D && this.E) {
            z = true;
            s0(menu);
        }
        return z | this.u.F(menu);
    }

    void T() {
        this.u.B0();
    }

    void T0() {
        boolean zR0 = this.s.r0(this);
        Boolean bool = this.k;
        if (bool == null || bool.booleanValue() != zR0) {
            this.k = Boolean.valueOf(zR0);
            t0(zR0);
            this.u.G();
        }
    }

    public void U(Bundle bundle) {
        this.F = true;
    }

    void U0() {
        this.u.B0();
        this.u.Q(true);
        this.b = 4;
        this.F = false;
        v0();
        if (this.F) {
            this.R.i(androidx.lifecycle.d.a.ON_RESUME);
            if (this.H != null) {
                this.S.b(androidx.lifecycle.d.a.ON_RESUME);
            }
            this.u.H();
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onResume()");
    }

    public void V(int i, int i2, Intent intent) {
    }

    void V0(Bundle bundle) {
        w0(bundle);
        this.U.d(bundle);
        Parcelable parcelableP0 = this.u.P0();
        if (parcelableP0 != null) {
            bundle.putParcelable("android:support:fragments", parcelableP0);
        }
    }

    @Deprecated
    public void W(Activity activity) {
        this.F = true;
    }

    void W0() {
        this.u.B0();
        this.u.Q(true);
        this.b = 3;
        this.F = false;
        x0();
        if (this.F) {
            this.R.i(androidx.lifecycle.d.a.ON_START);
            if (this.H != null) {
                this.S.b(androidx.lifecycle.d.a.ON_START);
            }
            this.u.I();
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onStart()");
    }

    public void X(Context context) {
        this.F = true;
        j<?> jVar = this.t;
        Activity activityH = jVar == null ? null : jVar.h();
        if (activityH != null) {
            this.F = false;
            W(activityH);
        }
    }

    void X0() {
        this.u.K();
        if (this.H != null) {
            this.S.b(androidx.lifecycle.d.a.ON_STOP);
        }
        this.R.i(androidx.lifecycle.d.a.ON_STOP);
        this.b = 2;
        this.F = false;
        y0();
        if (this.F) {
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onStop()");
    }

    public void Y(Fragment fragment) {
    }

    public final androidx.fragment.app.d Y0() {
        androidx.fragment.app.d dVarI = i();
        if (dVarI != null) {
            return dVarI;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public boolean Z(MenuItem menuItem) {
        return false;
    }

    public final Context Z0() {
        Context contextP = p();
        if (contextP != null) {
            return contextP;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @Override // androidx.lifecycle.g
    public androidx.lifecycle.d a() {
        return this.R;
    }

    public void a0(Bundle bundle) {
        this.F = true;
        b1(bundle);
        if (this.u.s0(1)) {
            return;
        }
        this.u.u();
    }

    public final View a1() {
        View viewJ = J();
        if (viewJ != null) {
            return viewJ;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    void b() {
        c cVar = this.K;
        e eVar = null;
        if (cVar != null) {
            cVar.p = false;
            e eVar2 = cVar.q;
            cVar.q = null;
            eVar = eVar2;
        }
        if (eVar != null) {
            eVar.a();
        }
    }

    public Animation b0(int i, boolean z, int i2) {
        return null;
    }

    void b1(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.u.N0(parcelable);
        this.u.u();
    }

    public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.w));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.x));
        printWriter.print(" mTag=");
        printWriter.println(this.y);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.b);
        printWriter.print(" mWho=");
        printWriter.print(this.f291f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.n);
        printWriter.print(" mInLayout=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.z);
        printWriter.print(" mDetached=");
        printWriter.print(this.A);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.E);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.D);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.B);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.J);
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.s);
        }
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.t);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.v);
        }
        if (this.f292g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f292g);
        }
        if (this.c != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.c);
        }
        if (this.f289d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f289d);
        }
        Fragment fragmentI = I();
        if (fragmentI != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(fragmentI);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.j);
        }
        if (w() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(w());
        }
        if (this.G != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.G);
        }
        if (this.H != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.H);
        }
        if (l() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(l());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(G());
        }
        if (p() != null) {
            d.k.a.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.u + ":");
        this.u.M(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public Animator c0(int i, boolean z, int i2) {
        return null;
    }

    final void c1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f289d;
        if (sparseArray != null) {
            this.H.restoreHierarchyState(sparseArray);
            this.f289d = null;
        }
        this.F = false;
        A0(bundle);
        if (this.F) {
            if (this.H != null) {
                this.S.b(androidx.lifecycle.d.a.ON_CREATE);
            }
        } else {
            throw new y("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void d0(Menu menu, MenuInflater menuInflater) {
    }

    void d1(View view) {
        g().a = view;
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry e() {
        return this.U.b();
    }

    public View e0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.V;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    void e1(Animator animator) {
        g().b = animator;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // androidx.lifecycle.t
    public androidx.lifecycle.s f() {
        m mVar = this.s;
        if (mVar != null) {
            return mVar.l0(this);
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public void f0() {
        this.F = true;
    }

    public void f1(Bundle bundle) {
        if (this.s != null && S()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f292g = bundle;
    }

    public void g0() {
    }

    void g1(boolean z) {
        g().r = z;
    }

    Fragment h(String str) {
        return str.equals(this.f291f) ? this : this.u.Y(str);
    }

    public void h0() {
        this.F = true;
    }

    void h1(int i) {
        if (this.K == null && i == 0) {
            return;
        }
        g().f293d = i;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final androidx.fragment.app.d i() {
        j<?> jVar = this.t;
        if (jVar == null) {
            return null;
        }
        return (androidx.fragment.app.d) jVar.h();
    }

    public void i0() {
        this.F = true;
    }

    void i1(int i) {
        if (this.K == null && i == 0) {
            return;
        }
        g();
        this.K.f294e = i;
    }

    public boolean j() {
        Boolean bool;
        c cVar = this.K;
        if (cVar == null || (bool = cVar.m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public LayoutInflater j0(Bundle bundle) {
        return v(bundle);
    }

    void j1(e eVar) {
        g();
        e eVar2 = this.K.q;
        if (eVar == eVar2) {
            return;
        }
        if (eVar != null && eVar2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        c cVar = this.K;
        if (cVar.p) {
            cVar.q = eVar;
        }
        if (eVar != null) {
            eVar.b();
        }
    }

    public boolean k() {
        Boolean bool;
        c cVar = this.K;
        if (cVar == null || (bool = cVar.l) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void k0(boolean z) {
    }

    void k1(int i) {
        g().c = i;
    }

    View l() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        return cVar.a;
    }

    @Deprecated
    public void l0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.F = true;
    }

    public void l1() {
        m mVar = this.s;
        if (mVar == null || mVar.o == null) {
            g().p = false;
        } else if (Looper.myLooper() != this.s.o.j().getLooper()) {
            this.s.o.j().postAtFrontOfQueue(new a());
        } else {
            b();
        }
    }

    Animator m() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        return cVar.b;
    }

    public void m0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.F = true;
        j<?> jVar = this.t;
        Activity activityH = jVar == null ? null : jVar.h();
        if (activityH != null) {
            this.F = false;
            l0(activityH, attributeSet, bundle);
        }
    }

    public final Bundle n() {
        return this.f292g;
    }

    public void n0(boolean z) {
    }

    public final m o() {
        if (this.t != null) {
            return this.u;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public boolean o0(MenuItem menuItem) {
        return false;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.F = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Y0().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.F = true;
    }

    public Context p() {
        j<?> jVar = this.t;
        if (jVar == null) {
            return null;
        }
        return jVar.i();
    }

    public void p0(Menu menu) {
    }

    public Object q() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        return cVar.f295f;
    }

    public void q0() {
        this.F = true;
    }

    androidx.core.app.f r() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        return cVar.n;
    }

    public void r0(boolean z) {
    }

    public Object s() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        return cVar.h;
    }

    public void s0(Menu menu) {
    }

    androidx.core.app.f t() {
        c cVar = this.K;
        if (cVar == null) {
            return null;
        }
        return cVar.o;
    }

    public void t0(boolean z) {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f291f);
        sb.append(")");
        if (this.w != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.w));
        }
        if (this.y != null) {
            sb.append(" ");
            sb.append(this.y);
        }
        sb.append('}');
        return sb.toString();
    }

    public final Object u() {
        j<?> jVar = this.t;
        if (jVar == null) {
            return null;
        }
        return jVar.l();
    }

    public void u0(int i, String[] strArr, int[] iArr) {
    }

    @Deprecated
    public LayoutInflater v(Bundle bundle) {
        j<?> jVar = this.t;
        if (jVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterM = jVar.m();
        d.f.k.e.b(layoutInflaterM, this.u.g0());
        return layoutInflaterM;
    }

    public void v0() {
        this.F = true;
    }

    int w() {
        c cVar = this.K;
        if (cVar == null) {
            return 0;
        }
        return cVar.f293d;
    }

    public void w0(Bundle bundle) {
    }

    int x() {
        c cVar = this.K;
        if (cVar == null) {
            return 0;
        }
        return cVar.f294e;
    }

    public void x0() {
        this.F = true;
    }

    public final Fragment y() {
        return this.v;
    }

    public void y0() {
        this.F = true;
    }

    public final m z() {
        m mVar = this.s;
        if (mVar != null) {
            return mVar;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public void z0(View view, Bundle bundle) {
    }
}
