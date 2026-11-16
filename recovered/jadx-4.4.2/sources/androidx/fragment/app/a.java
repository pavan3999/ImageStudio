package androidx.fragment.app;

import android.util.Log;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class a extends t implements m.h {
    final m q;
    boolean r;
    int s;

    /* JADX WARN: Illegal instructions before constructor call */
    a(m mVar) {
        i iVarE0 = mVar.e0();
        j<?> jVar = mVar.o;
        super(iVarE0, jVar != null ? jVar.i().getClassLoader() : null);
        this.s = -1;
        this.q = mVar;
    }

    private static boolean z(t.a aVar) {
        Fragment fragment = aVar.b;
        return (fragment == null || !fragment.l || fragment.H == null || fragment.A || fragment.z || !fragment.P()) ? false : true;
    }

    boolean A() {
        for (int i = 0; i < this.a.size(); i++) {
            if (z(this.a.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void B() {
        if (this.p != null) {
            for (int i = 0; i < this.p.size(); i++) {
                this.p.get(i).run();
            }
            this.p = null;
        }
    }

    void C(Fragment.e eVar) {
        for (int i = 0; i < this.a.size(); i++) {
            t.a aVar = this.a.get(i);
            if (z(aVar)) {
                aVar.b.j1(eVar);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    Fragment D(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            t.a aVar = this.a.get(size);
            int i = aVar.a;
            if (i == 1) {
                arrayList.remove(aVar.b);
            } else if (i != 3) {
                switch (i) {
                    case 6:
                        arrayList.add(aVar.b);
                        break;
                    case 7:
                        arrayList.remove(aVar.b);
                        break;
                    case 8:
                        fragment = null;
                        break;
                    case 9:
                        fragment = aVar.b;
                        break;
                    case 10:
                        aVar.h = aVar.f334g;
                        break;
                }
            } else {
                arrayList.add(aVar.b);
            }
        }
        return fragment;
    }

    @Override // androidx.fragment.app.m.h
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (m.p0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f330g) {
            return true;
        }
        this.q.b(this);
        return true;
    }

    @Override // androidx.fragment.app.t
    public int f() {
        return q(false);
    }

    @Override // androidx.fragment.app.t
    public int g() {
        return q(true);
    }

    @Override // androidx.fragment.app.t
    public void h() {
        j();
        this.q.R(this, false);
    }

    @Override // androidx.fragment.app.t
    public void i() {
        j();
        this.q.R(this, true);
    }

    @Override // androidx.fragment.app.t
    void k(int i, Fragment fragment, String str, int i2) {
        super.k(i, fragment, str, i2);
        fragment.s = this.q;
    }

    @Override // androidx.fragment.app.t
    public t l(Fragment fragment) {
        m mVar = fragment.s;
        if (mVar == null || mVar == this.q) {
            super.l(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    void p(int i) {
        if (this.f330g) {
            if (m.p0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                t.a aVar = this.a.get(i2);
                Fragment fragment = aVar.b;
                if (fragment != null) {
                    fragment.r += i;
                    if (m.p0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.b + " to " + aVar.b.r);
                    }
                }
            }
        }
    }

    int q(boolean z) {
        if (this.r) {
            throw new IllegalStateException("commit already called");
        }
        if (m.p0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new d.f.j.b("FragmentManager"));
            r("  ", printWriter);
            printWriter.close();
        }
        this.r = true;
        this.s = this.f330g ? this.q.f() : -1;
        this.q.O(this, z);
        return this.s;
    }

    public void r(String str, PrintWriter printWriter) {
        s(str, printWriter, true);
    }

    public void s(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.h);
            printWriter.print(" mIndex=");
            printWriter.print(this.s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.r);
            if (this.f329f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f329f));
            }
            if (this.b != 0 || this.c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.c));
            }
            if (this.f327d != 0 || this.f328e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f327d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f328e));
            }
            if (this.i != 0 || this.j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.j);
            }
            if (this.k != 0 || this.l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.l);
            }
        }
        if (this.a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            t.a aVar = this.a.get(i);
            switch (aVar.a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.b);
            if (z) {
                if (aVar.c != 0 || aVar.f331d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f331d));
                }
                if (aVar.f332e != 0 || aVar.f333f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f332e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f333f));
                }
            }
        }
    }

    void t() {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            t.a aVar = this.a.get(i);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.i1(this.f329f);
            }
            switch (aVar.a) {
                case 1:
                    fragment.h1(aVar.c);
                    this.q.R0(fragment, false);
                    this.q.d(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                case 3:
                    fragment.h1(aVar.f331d);
                    this.q.J0(fragment);
                    break;
                case 4:
                    fragment.h1(aVar.f331d);
                    this.q.n0(fragment);
                    break;
                case 5:
                    fragment.h1(aVar.c);
                    this.q.R0(fragment, false);
                    this.q.V0(fragment);
                    break;
                case 6:
                    fragment.h1(aVar.f331d);
                    this.q.q(fragment);
                    break;
                case 7:
                    fragment.h1(aVar.c);
                    this.q.R0(fragment, false);
                    this.q.h(fragment);
                    break;
                case 8:
                    this.q.T0(fragment);
                    break;
                case 9:
                    this.q.T0(null);
                    break;
                case 10:
                    this.q.S0(fragment, aVar.h);
                    break;
            }
            if (!this.o && aVar.a != 1 && fragment != null) {
                this.q.x0(fragment);
            }
        }
        if (this.o) {
            return;
        }
        m mVar = this.q;
        mVar.y0(mVar.n, true);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.s >= 0) {
            sb.append(" #");
            sb.append(this.s);
        }
        if (this.h != null) {
            sb.append(" ");
            sb.append(this.h);
        }
        sb.append("}");
        return sb.toString();
    }

    void u(boolean z) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            t.a aVar = this.a.get(size);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.i1(m.O0(this.f329f));
            }
            switch (aVar.a) {
                case 1:
                    fragment.h1(aVar.f333f);
                    this.q.R0(fragment, true);
                    this.q.J0(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                case 3:
                    fragment.h1(aVar.f332e);
                    this.q.d(fragment);
                    break;
                case 4:
                    fragment.h1(aVar.f332e);
                    this.q.V0(fragment);
                    break;
                case 5:
                    fragment.h1(aVar.f333f);
                    this.q.R0(fragment, true);
                    this.q.n0(fragment);
                    break;
                case 6:
                    fragment.h1(aVar.f332e);
                    this.q.h(fragment);
                    break;
                case 7:
                    fragment.h1(aVar.f333f);
                    this.q.R0(fragment, true);
                    this.q.q(fragment);
                    break;
                case 8:
                    this.q.T0(null);
                    break;
                case 9:
                    this.q.T0(fragment);
                    break;
                case 10:
                    this.q.S0(fragment, aVar.f334g);
                    break;
            }
            if (!this.o && aVar.a != 3 && fragment != null) {
                this.q.x0(fragment);
            }
        }
        if (this.o || !z) {
            return;
        }
        m mVar = this.q;
        mVar.y0(mVar.n, true);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b2  */
    Fragment v(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.a.size()) {
            t.a aVar = this.a.get(i);
            int i2 = aVar.a;
            if (i2 == 1) {
                arrayList.add(aVar.b);
            } else if (i2 == 2) {
                Fragment fragment3 = aVar.b;
                int i3 = fragment3.x;
                boolean z = false;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment4 = arrayList.get(size);
                    if (fragment4.x == i3) {
                        if (fragment4 == fragment3) {
                            z = true;
                        } else {
                            if (fragment4 == fragment2) {
                                this.a.add(i, new t.a(9, fragment4));
                                i++;
                                fragment2 = null;
                            }
                            t.a aVar2 = new t.a(3, fragment4);
                            aVar2.c = aVar.c;
                            aVar2.f332e = aVar.f332e;
                            aVar2.f331d = aVar.f331d;
                            aVar2.f333f = aVar.f333f;
                            this.a.add(i, aVar2);
                            arrayList.remove(fragment4);
                            i++;
                        }
                    }
                }
                if (z) {
                    this.a.remove(i);
                    i--;
                } else {
                    aVar.a = 1;
                    arrayList.add(fragment3);
                }
            } else if (i2 == 3 || i2 == 6) {
                arrayList.remove(aVar.b);
                Fragment fragment5 = aVar.b;
                if (fragment5 == fragment2) {
                    this.a.add(i, new t.a(9, fragment5));
                    i++;
                    fragment2 = null;
                }
            } else if (i2 == 7) {
                arrayList.add(aVar.b);
            } else if (i2 == 8) {
                this.a.add(i, new t.a(9, fragment2));
                i++;
                fragment2 = aVar.b;
            }
            i++;
        }
        return fragment2;
    }

    public String w() {
        return this.h;
    }

    boolean x(int i) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.a.get(i2).b;
            int i3 = fragment != null ? fragment.x : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    boolean y(ArrayList<a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.a.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.a.get(i4).b;
            int i5 = fragment != null ? fragment.x : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    a aVar = arrayList.get(i6);
                    int size2 = aVar.a.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = aVar.a.get(i7).b;
                        if ((fragment2 != null ? fragment2.x : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }
}
