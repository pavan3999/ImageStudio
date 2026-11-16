package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class u {
    private static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    private static final w b;
    private static final w c;

    static class a implements Runnable {
        final /* synthetic */ g b;
        final /* synthetic */ Fragment c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.f.g.a f335d;

        a(g gVar, Fragment fragment, d.f.g.a aVar) {
            this.b = gVar;
            this.c = fragment;
            this.f335d = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a(this.c, this.f335d);
        }
    }

    static class b implements Runnable {
        final /* synthetic */ ArrayList b;

        b(ArrayList arrayList) {
            this.b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            u.B(this.b, 4);
        }
    }

    static class c implements Runnable {
        final /* synthetic */ g b;
        final /* synthetic */ Fragment c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.f.g.a f336d;

        c(g gVar, Fragment fragment, d.f.g.a aVar) {
            this.b = gVar;
            this.c = fragment;
            this.f336d = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a(this.c, this.f336d);
        }
    }

    static class d implements Runnable {
        final /* synthetic */ Object b;
        final /* synthetic */ w c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f337d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Fragment f338e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f339f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ArrayList f340g;
        final /* synthetic */ ArrayList h;
        final /* synthetic */ Object i;

        d(Object obj, w wVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.b = obj;
            this.c = wVar;
            this.f337d = view;
            this.f338e = fragment;
            this.f339f = arrayList;
            this.f340g = arrayList2;
            this.h = arrayList3;
            this.i = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.b;
            if (obj != null) {
                this.c.p(obj, this.f337d);
                this.f340g.addAll(u.k(this.c, this.b, this.f338e, this.f339f, this.f337d));
            }
            if (this.h != null) {
                if (this.i != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(this.f337d);
                    this.c.q(this.i, this.h, arrayList);
                }
                this.h.clear();
                this.h.add(this.f337d);
            }
        }
    }

    static class e implements Runnable {
        final /* synthetic */ Fragment b;
        final /* synthetic */ Fragment c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f341d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d.d.a f342e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f343f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ w f344g;
        final /* synthetic */ Rect h;

        e(Fragment fragment, Fragment fragment2, boolean z, d.d.a aVar, View view, w wVar, Rect rect) {
            this.b = fragment;
            this.c = fragment2;
            this.f341d = z;
            this.f342e = aVar;
            this.f343f = view;
            this.f344g = wVar;
            this.h = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            u.f(this.b, this.c, this.f341d, this.f342e, false);
            View view = this.f343f;
            if (view != null) {
                this.f344g.k(view, this.h);
            }
        }
    }

    static class f implements Runnable {
        final /* synthetic */ w b;
        final /* synthetic */ d.d.a c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f345d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ h f346e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f347f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f348g;
        final /* synthetic */ Fragment h;
        final /* synthetic */ Fragment i;
        final /* synthetic */ boolean j;
        final /* synthetic */ ArrayList k;
        final /* synthetic */ Object l;
        final /* synthetic */ Rect m;

        f(w wVar, d.d.a aVar, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.b = wVar;
            this.c = aVar;
            this.f345d = obj;
            this.f346e = hVar;
            this.f347f = arrayList;
            this.f348g = view;
            this.h = fragment;
            this.i = fragment2;
            this.j = z;
            this.k = arrayList2;
            this.l = obj2;
            this.m = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.d.a<String, View> aVarH = u.h(this.b, this.c, this.f345d, this.f346e);
            if (aVarH != null) {
                this.f347f.addAll(aVarH.values());
                this.f347f.add(this.f348g);
            }
            u.f(this.h, this.i, this.j, aVarH, false);
            Object obj = this.f345d;
            if (obj != null) {
                this.b.A(obj, this.k, this.f347f);
                View viewT = u.t(aVarH, this.f346e, this.l, this.j);
                if (viewT != null) {
                    this.b.k(viewT, this.m);
                }
            }
        }
    }

    interface g {
        void a(Fragment fragment, d.f.g.a aVar);

        void b(Fragment fragment, d.f.g.a aVar);
    }

    static class h {
        public Fragment a;
        public boolean b;
        public androidx.fragment.app.a c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Fragment f349d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f350e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public androidx.fragment.app.a f351f;

        h() {
        }
    }

    static {
        b = Build.VERSION.SDK_INT >= 21 ? new v() : null;
        c = x();
    }

    private static void A(w wVar, Object obj, Object obj2, d.d.a<String, View> aVar, boolean z, androidx.fragment.app.a aVar2) {
        ArrayList<String> arrayList = aVar2.m;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = aVar.get((z ? aVar2.n : aVar2.m).get(0));
        wVar.v(obj, view);
        if (obj2 != null) {
            wVar.v(obj2, view);
        }
    }

    static void B(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    static void C(m mVar, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z, g gVar) {
        if (mVar.n < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            androidx.fragment.app.a aVar = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                e(aVar, sparseArray, z);
            } else {
                c(aVar, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(mVar.o.i());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int iKeyAt = sparseArray.keyAt(i4);
                d.d.a<String, String> aVarD = d(iKeyAt, arrayList, arrayList2, i, i2);
                h hVar = (h) sparseArray.valueAt(i4);
                if (z) {
                    o(mVar, iKeyAt, hVar, view, aVarD, gVar);
                } else {
                    n(mVar, iKeyAt, hVar, view, aVarD, gVar);
                }
            }
        }
    }

    private static void a(ArrayList<View> arrayList, d.d.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View viewM = aVar.m(size);
            if (collection.contains(d.f.k.r.B(viewM))) {
                arrayList.add(viewM);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x006e  */
    /* JADX WARN: Code duplicated, block: B:57:0x0070  */
    /* JADX WARN: Code duplicated, block: B:63:0x007d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x007f  */
    /* JADX WARN: Code duplicated, block: B:65:0x0082  */
    /* JADX WARN: Code duplicated, block: B:69:0x008a  */
    /* JADX WARN: Code duplicated, block: B:70:0x008c  */
    private static void b(androidx.fragment.app.a aVar, t.a aVar2, SparseArray<h> sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        View view;
        boolean z7;
        Fragment fragment = aVar2.b;
        if (fragment == null || (i = fragment.x) == 0) {
            return;
        }
        int i2 = z ? a[aVar2.a] : aVar2.a;
        boolean z8 = false;
        if (i2 == 1) {
            if (z2) {
                z3 = fragment.L;
            } else if (!fragment.l || fragment.z) {
                z3 = false;
            } else {
                z3 = true;
            }
            z8 = z3;
            z4 = true;
            z6 = false;
            z5 = false;
        } else if (i2 == 3) {
            boolean z9 = fragment.l;
            if (z2 ? !z9 || fragment.z : z9 || (view = fragment.H) == null || view.getVisibility() != 0 || fragment.N < 0.0f) {
                z7 = false;
            } else {
                z7 = true;
            }
            z5 = z7;
            z4 = false;
            z6 = true;
        } else if (i2 != 4) {
            if (i2 != 5) {
                if (i2 != 6) {
                    if (i2 != 7) {
                        z4 = false;
                    } else {
                        if (z2) {
                            z3 = fragment.L;
                        } else {
                            if (fragment.l) {
                            }
                            z3 = false;
                        }
                        z8 = z3;
                        z4 = true;
                    }
                }
                boolean z10 = fragment.l;
                if (z2) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                z5 = z7;
                z4 = false;
                z6 = true;
            } else {
                if (!z2) {
                    z3 = fragment.z;
                } else if (fragment.M && !fragment.z && fragment.l) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z8 = z3;
                z4 = true;
            }
            z6 = false;
            z5 = false;
        } else {
            if (!z2 ? !(!fragment.l || fragment.z) : fragment.M && fragment.l && fragment.z) {
                z7 = false;
            } else {
                z7 = true;
            }
            z5 = z7;
            z4 = false;
            z6 = true;
        }
        h hVarP = sparseArray.get(i);
        if (z8) {
            hVarP = p(hVarP, sparseArray, i);
            hVarP.a = fragment;
            hVarP.b = z;
            hVarP.c = aVar;
        }
        if (!z2 && z4) {
            if (hVarP != null && hVarP.f349d == fragment) {
                hVarP.f349d = null;
            }
            m mVar = aVar.q;
            if (fragment.b < 1 && mVar.n >= 1 && !aVar.o) {
                mVar.u0(fragment);
                mVar.A0(fragment, 1);
            }
        }
        if (z5 && (hVarP == null || hVarP.f349d == null)) {
            hVarP = p(hVarP, sparseArray, i);
            hVarP.f349d = fragment;
            hVarP.f350e = z;
            hVarP.f351f = aVar;
        }
        if (z2 || !z6 || hVarP == null || hVarP.a != fragment) {
            return;
        }
        hVarP.a = null;
    }

    public static void c(androidx.fragment.app.a aVar, SparseArray<h> sparseArray, boolean z) {
        int size = aVar.a.size();
        for (int i = 0; i < size; i++) {
            b(aVar, aVar.a.get(i), sparseArray, false, z);
        }
    }

    private static d.d.a<String, String> d(int i, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        d.d.a<String, String> aVar = new d.d.a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            androidx.fragment.app.a aVar2 = arrayList.get(i4);
            if (aVar2.x(i)) {
                boolean zBooleanValue = arrayList2.get(i4).booleanValue();
                ArrayList<String> arrayList5 = aVar2.m;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (zBooleanValue) {
                        arrayList3 = aVar2.m;
                        arrayList4 = aVar2.n;
                    } else {
                        ArrayList<String> arrayList6 = aVar2.m;
                        arrayList3 = aVar2.n;
                        arrayList4 = arrayList6;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String strRemove = aVar.remove(str2);
                        if (strRemove != null) {
                            aVar.put(str, strRemove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(androidx.fragment.app.a aVar, SparseArray<h> sparseArray, boolean z) {
        if (aVar.q.p.g()) {
            for (int size = aVar.a.size() - 1; size >= 0; size--) {
                b(aVar, aVar.a.get(size), sparseArray, true, z);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z, d.d.a<String, View> aVar, boolean z2) {
        androidx.core.app.f fVarR = z ? fragment2.r() : fragment.r();
        if (fVarR != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(aVar.i(i));
                arrayList.add(aVar.m(i));
            }
            if (z2) {
                fVarR.c(arrayList2, arrayList, null);
            } else {
                fVarR.b(arrayList2, arrayList, null);
            }
        }
    }

    private static boolean g(w wVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!wVar.e(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    static d.d.a<String, View> h(w wVar, d.d.a<String, String> aVar, Object obj, h hVar) {
        androidx.core.app.f fVarR;
        ArrayList<String> arrayList;
        String strQ;
        Fragment fragment = hVar.a;
        View viewJ = fragment.J();
        if (aVar.isEmpty() || obj == null || viewJ == null) {
            aVar.clear();
            return null;
        }
        d.d.a<String, View> aVar2 = new d.d.a<>();
        wVar.j(aVar2, viewJ);
        androidx.fragment.app.a aVar3 = hVar.c;
        if (hVar.b) {
            fVarR = fragment.t();
            arrayList = aVar3.m;
        } else {
            fVarR = fragment.r();
            arrayList = aVar3.n;
        }
        if (arrayList != null) {
            aVar2.o(arrayList);
            aVar2.o(aVar.values());
        }
        if (fVarR != null) {
            fVarR.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    String strQ2 = q(aVar, str);
                    if (strQ2 != null) {
                        aVar.remove(strQ2);
                    }
                } else if (!str.equals(d.f.k.r.B(view)) && (strQ = q(aVar, str)) != null) {
                    aVar.put(strQ, d.f.k.r.B(view));
                }
            }
        } else {
            y(aVar, aVar2);
        }
        return aVar2;
    }

    private static d.d.a<String, View> i(w wVar, d.d.a<String, String> aVar, Object obj, h hVar) {
        androidx.core.app.f fVarT;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = hVar.f349d;
        d.d.a<String, View> aVar2 = new d.d.a<>();
        wVar.j(aVar2, fragment.a1());
        androidx.fragment.app.a aVar3 = hVar.f351f;
        if (hVar.f350e) {
            fVarT = fragment.r();
            arrayList = aVar3.n;
        } else {
            fVarT = fragment.t();
            arrayList = aVar3.m;
        }
        if (arrayList != null) {
            aVar2.o(arrayList);
        }
        if (fVarT != null) {
            fVarT.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(d.f.k.r.B(view))) {
                    aVar.put(d.f.k.r.B(view), aVar.remove(str));
                }
            }
        } else {
            aVar.o(aVar2.keySet());
        }
        return aVar2;
    }

    private static w j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object objS = fragment.s();
            if (objS != null) {
                arrayList.add(objS);
            }
            Object objD = fragment.D();
            if (objD != null) {
                arrayList.add(objD);
            }
            Object objF = fragment.F();
            if (objF != null) {
                arrayList.add(objF);
            }
        }
        if (fragment2 != null) {
            Object objQ = fragment2.q();
            if (objQ != null) {
                arrayList.add(objQ);
            }
            Object objA = fragment2.A();
            if (objA != null) {
                arrayList.add(objA);
            }
            Object objE = fragment2.E();
            if (objE != null) {
                arrayList.add(objE);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        w wVar = b;
        if (wVar != null && g(wVar, arrayList)) {
            return b;
        }
        w wVar2 = c;
        if (wVar2 != null && g(wVar2, arrayList)) {
            return c;
        }
        if (b == null && c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList<View> k(w wVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View viewJ = fragment.J();
        if (viewJ != null) {
            wVar.f(arrayList2, viewJ);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        wVar.b(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(w wVar, ViewGroup viewGroup, View view, d.d.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Rect rect;
        Fragment fragment = hVar.a;
        Fragment fragment2 = hVar.f349d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar.b;
        Object objU = aVar.isEmpty() ? null : u(wVar, fragment, fragment2, z);
        d.d.a<String, View> aVarI = i(wVar, aVar, objU, hVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(aVarI.values());
            obj3 = objU;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, aVarI, true);
        if (obj3 != null) {
            rect = new Rect();
            wVar.z(obj3, view, arrayList);
            A(wVar, obj3, obj2, aVarI, hVar.f350e, hVar.f351f);
            if (obj != null) {
                wVar.u(obj, rect);
            }
        } else {
            rect = null;
        }
        d.f.k.p.a(viewGroup, new f(wVar, aVar, obj3, hVar, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj3;
    }

    private static Object m(w wVar, ViewGroup viewGroup, View view, d.d.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = hVar.a;
        Fragment fragment2 = hVar.f349d;
        if (fragment != null) {
            fragment.a1().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar.b;
        Object objU = aVar.isEmpty() ? null : u(wVar, fragment, fragment2, z);
        d.d.a<String, View> aVarI = i(wVar, aVar, objU, hVar);
        d.d.a<String, View> aVarH = h(wVar, aVar, objU, hVar);
        if (aVar.isEmpty()) {
            if (aVarI != null) {
                aVarI.clear();
            }
            if (aVarH != null) {
                aVarH.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, aVarI, aVar.keySet());
            a(arrayList2, aVarH, aVar.values());
            obj3 = objU;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, aVarI, true);
        if (obj3 != null) {
            arrayList2.add(view);
            wVar.z(obj3, view, arrayList);
            A(wVar, obj3, obj2, aVarI, hVar.f350e, hVar.f351f);
            Rect rect2 = new Rect();
            View viewT = t(aVarH, hVar, obj, z);
            if (viewT != null) {
                wVar.u(obj, rect2);
            }
            rect = rect2;
            view2 = viewT;
        } else {
            view2 = null;
            rect = null;
        }
        d.f.k.p.a(viewGroup, new e(fragment, fragment2, z, aVarH, view2, wVar, rect));
        return obj3;
    }

    private static void n(m mVar, int i, h hVar, View view, d.d.a<String, String> aVar, g gVar) {
        Fragment fragment;
        Fragment fragment2;
        w wVarJ;
        Object obj;
        ViewGroup viewGroup = mVar.p.g() ? (ViewGroup) mVar.p.c(i) : null;
        if (viewGroup == null || (wVarJ = j((fragment2 = hVar.f349d), (fragment = hVar.a))) == null) {
            return;
        }
        boolean z = hVar.b;
        boolean z2 = hVar.f350e;
        Object objR = r(wVarJ, fragment, z);
        Object objS = s(wVarJ, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objL = l(wVarJ, viewGroup, view, aVar, hVar, arrayList, arrayList2, objR, objS);
        if (objR == null && objL == null) {
            obj = objS;
            if (obj == null) {
                return;
            }
        } else {
            obj = objS;
        }
        ArrayList<View> arrayListK = k(wVarJ, obj, fragment2, arrayList, view);
        Object obj2 = (arrayListK == null || arrayListK.isEmpty()) ? null : obj;
        wVarJ.a(objR, view);
        Object objV = v(wVarJ, objR, obj2, objL, fragment, hVar.b);
        if (fragment2 != null && arrayListK != null && (arrayListK.size() > 0 || arrayList.size() > 0)) {
            d.f.g.a aVar2 = new d.f.g.a();
            gVar.b(fragment2, aVar2);
            wVarJ.w(fragment2, objV, aVar2, new c(gVar, fragment2, aVar2));
        }
        if (objV != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            wVarJ.t(objV, objR, arrayList3, obj2, arrayListK, objL, arrayList2);
            z(wVarJ, viewGroup, fragment, view, arrayList2, objR, arrayList3, obj2, arrayListK);
            wVarJ.x(viewGroup, arrayList2, aVar);
            wVarJ.c(viewGroup, objV);
            wVarJ.s(viewGroup, arrayList2, aVar);
        }
    }

    private static void o(m mVar, int i, h hVar, View view, d.d.a<String, String> aVar, g gVar) {
        Fragment fragment;
        Fragment fragment2;
        w wVarJ;
        Object obj;
        ViewGroup viewGroup = mVar.p.g() ? (ViewGroup) mVar.p.c(i) : null;
        if (viewGroup == null || (wVarJ = j((fragment2 = hVar.f349d), (fragment = hVar.a))) == null) {
            return;
        }
        boolean z = hVar.b;
        boolean z2 = hVar.f350e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objR = r(wVarJ, fragment, z);
        Object objS = s(wVarJ, fragment2, z2);
        Object objM = m(wVarJ, viewGroup, view, aVar, hVar, arrayList2, arrayList, objR, objS);
        if (objR == null && objM == null) {
            obj = objS;
            if (obj == null) {
                return;
            }
        } else {
            obj = objS;
        }
        ArrayList<View> arrayListK = k(wVarJ, obj, fragment2, arrayList2, view);
        ArrayList<View> arrayListK2 = k(wVarJ, objR, fragment, arrayList, view);
        B(arrayListK2, 4);
        Object objV = v(wVarJ, objR, obj, objM, fragment, z);
        if (fragment2 != null && arrayListK != null && (arrayListK.size() > 0 || arrayList2.size() > 0)) {
            d.f.g.a aVar2 = new d.f.g.a();
            gVar.b(fragment2, aVar2);
            wVarJ.w(fragment2, objV, aVar2, new a(gVar, fragment2, aVar2));
        }
        if (objV != null) {
            w(wVarJ, obj, fragment2, arrayListK);
            ArrayList<String> arrayListO = wVarJ.o(arrayList);
            wVarJ.t(objV, objR, arrayListK2, obj, arrayListK, objM, arrayList);
            wVarJ.c(viewGroup, objV);
            wVarJ.y(viewGroup, arrayList2, arrayList, arrayListO, aVar);
            B(arrayListK2, 0);
            wVarJ.A(objM, arrayList2, arrayList);
        }
    }

    private static h p(h hVar, SparseArray<h> sparseArray, int i) {
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        sparseArray.put(i, hVar2);
        return hVar2;
    }

    private static String q(d.d.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.m(i))) {
                return aVar.i(i);
            }
        }
        return null;
    }

    private static Object r(w wVar, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return wVar.g(z ? fragment.A() : fragment.q());
    }

    private static Object s(w wVar, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return wVar.g(z ? fragment.D() : fragment.s());
    }

    static View t(d.d.a<String, View> aVar, h hVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        androidx.fragment.app.a aVar2 = hVar.c;
        if (obj == null || aVar == null || (arrayList = aVar2.m) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get((z ? aVar2.m : aVar2.n).get(0));
    }

    private static Object u(w wVar, Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return wVar.B(wVar.g(z ? fragment2.F() : fragment.E()));
    }

    private static Object v(w wVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean zK;
        if (obj == null || obj2 == null || fragment == null) {
            zK = true;
        } else {
            zK = z ? fragment.k() : fragment.j();
        }
        return zK ? wVar.n(obj2, obj, obj3) : wVar.m(obj2, obj, obj3);
    }

    private static void w(w wVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.l && fragment.z && fragment.M) {
            fragment.g1(true);
            wVar.r(obj, fragment.J(), arrayList);
            d.f.k.p.a(fragment.G, new b(arrayList));
        }
    }

    private static w x() {
        try {
            return (w) Class.forName("d.m.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void y(d.d.a<String, String> aVar, d.d.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.m(size))) {
                aVar.k(size);
            }
        }
    }

    private static void z(w wVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        d.f.k.p.a(viewGroup, new d(obj, wVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }
}
