package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class s {
    private final ArrayList<Fragment> a = new ArrayList<>();
    private final HashMap<String, r> b = new HashMap<>();

    s() {
    }

    void a(Fragment fragment) {
        if (this.a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.a) {
            this.a.add(fragment);
        }
        fragment.l = true;
    }

    void b() {
        this.b.values().removeAll(Collections.singleton(null));
    }

    boolean c(String str) {
        return this.b.containsKey(str);
    }

    void d(int i) {
        Iterator<Fragment> it = this.a.iterator();
        while (it.hasNext()) {
            r rVar = this.b.get(it.next().f291f);
            if (rVar != null) {
                rVar.q(i);
            }
        }
        for (r rVar2 : this.b.values()) {
            if (rVar2 != null) {
                rVar2.q(i);
            }
        }
    }

    void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.b.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments:");
            for (r rVar : this.b.values()) {
                printWriter.print(str);
                if (rVar != null) {
                    Fragment fragmentI = rVar.i();
                    printWriter.println(fragmentI);
                    fragmentI.c(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size; i++) {
                Fragment fragment = this.a.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    Fragment f(String str) {
        r rVar = this.b.get(str);
        if (rVar != null) {
            return rVar.i();
        }
        return null;
    }

    Fragment g(int i) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.a.get(size);
            if (fragment != null && fragment.w == i) {
                return fragment;
            }
        }
        for (r rVar : this.b.values()) {
            if (rVar != null) {
                Fragment fragmentI = rVar.i();
                if (fragmentI.w == i) {
                    return fragmentI;
                }
            }
        }
        return null;
    }

    Fragment h(String str) {
        if (str != null) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.a.get(size);
                if (fragment != null && str.equals(fragment.y)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (r rVar : this.b.values()) {
            if (rVar != null) {
                Fragment fragmentI = rVar.i();
                if (str.equals(fragmentI.y)) {
                    return fragmentI;
                }
            }
        }
        return null;
    }

    Fragment i(String str) {
        Fragment fragmentH;
        for (r rVar : this.b.values()) {
            if (rVar != null && (fragmentH = rVar.i().h(str)) != null) {
                return fragmentH;
            }
        }
        return null;
    }

    Fragment j(Fragment fragment) {
        ViewGroup viewGroup = fragment.G;
        View view = fragment.H;
        if (viewGroup != null && view != null) {
            for (int iIndexOf = this.a.indexOf(fragment) - 1; iIndexOf >= 0; iIndexOf--) {
                Fragment fragment2 = this.a.get(iIndexOf);
                if (fragment2.G == viewGroup && fragment2.H != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    List<Fragment> k() {
        ArrayList arrayList = new ArrayList();
        Iterator<r> it = this.b.values().iterator();
        while (it.hasNext()) {
            r next = it.next();
            arrayList.add(next != null ? next.i() : null);
        }
        return arrayList;
    }

    r l(String str) {
        return this.b.get(str);
    }

    List<Fragment> m() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    void n(r rVar) {
        this.b.put(rVar.i().f291f, rVar);
    }

    void o(r rVar) {
        Fragment fragmentI = rVar.i();
        for (r rVar2 : this.b.values()) {
            if (rVar2 != null) {
                Fragment fragmentI2 = rVar2.i();
                if (fragmentI.f291f.equals(fragmentI2.i)) {
                    fragmentI2.h = fragmentI;
                    fragmentI2.i = null;
                }
            }
        }
        this.b.put(fragmentI.f291f, null);
        String str = fragmentI.i;
        if (str != null) {
            fragmentI.h = f(str);
        }
    }

    void p(Fragment fragment) {
        synchronized (this.a) {
            this.a.remove(fragment);
        }
        fragment.l = false;
    }

    void q() {
        this.b.clear();
    }

    void r(List<String> list) {
        this.a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment fragmentF = f(str);
                if (fragmentF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (m.p0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragmentF);
                }
                a(fragmentF);
            }
        }
    }

    ArrayList<q> s() {
        ArrayList<q> arrayList = new ArrayList<>(this.b.size());
        for (r rVar : this.b.values()) {
            if (rVar != null) {
                Fragment fragmentI = rVar.i();
                q qVarO = rVar.o();
                arrayList.add(qVarO);
                if (m.p0(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragmentI + ": " + qVarO.n);
                }
            }
        }
        return arrayList;
    }

    ArrayList<String> t() {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.a.size());
            for (Fragment fragment : this.a) {
                arrayList.add(fragment.f291f);
                if (m.p0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment.f291f + "): " + fragment);
                }
            }
            return arrayList;
        }
    }
}
