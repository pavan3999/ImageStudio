package d.m;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class m implements Cloneable {
    private static final int[] H = {2, 1, 3, 4};
    private static final g I = new a();
    private static ThreadLocal<d.d.a<Animator, d>> J = new ThreadLocal<>();
    p D;
    private e E;
    private d.d.a<String, String> F;
    private ArrayList<s> u;
    private ArrayList<s> v;
    private String b = getClass().getName();
    private long c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f845d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TimeInterpolator f846e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList<Integer> f847f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ArrayList<View> f848g = new ArrayList<>();
    private ArrayList<String> h = null;
    private ArrayList<Class<?>> i = null;
    private ArrayList<Integer> j = null;
    private ArrayList<View> k = null;
    private ArrayList<Class<?>> l = null;
    private ArrayList<String> m = null;
    private ArrayList<Integer> n = null;
    private ArrayList<View> o = null;
    private ArrayList<Class<?>> p = null;
    private t q = new t();
    private t r = new t();
    q s = null;
    private int[] t = H;
    boolean w = false;
    ArrayList<Animator> x = new ArrayList<>();
    private int y = 0;
    private boolean z = false;
    private boolean A = false;
    private ArrayList<f> B = null;
    private ArrayList<Animator> C = new ArrayList<>();
    private g G = I;

    static class a extends g {
        a() {
        }

        @Override // d.m.g
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    }

    class b extends AnimatorListenerAdapter {
        final /* synthetic */ d.d.a a;

        b(d.d.a aVar) {
            this.a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.remove(animator);
            m.this.x.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            m.this.x.add(animator);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m.this.p();
            animator.removeListener(this);
        }
    }

    private static class d {
        View a;
        String b;
        s c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        m0 f849d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        m f850e;

        d(View view, String str, m mVar, m0 m0Var, s sVar) {
            this.a = view;
            this.b = str;
            this.c = sVar;
            this.f849d = m0Var;
            this.f850e = mVar;
        }
    }

    public static abstract class e {
    }

    public interface f {
        void a(m mVar);

        void b(m mVar);

        void c(m mVar);

        void d(m mVar);

        void e(m mVar);
    }

    private static boolean H(s sVar, s sVar2, String str) {
        Object obj = sVar.a.get(str);
        Object obj2 = sVar2.a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void I(d.d.a<View, s> aVar, d.d.a<View, s> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View viewValueAt = sparseArray.valueAt(i);
            if (viewValueAt != null && G(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && G(view)) {
                s sVar = aVar.get(viewValueAt);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.u.add(sVar);
                    this.v.add(sVar2);
                    aVar.remove(viewValueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void J(d.d.a<View, s> aVar, d.d.a<View, s> aVar2) {
        s sVarRemove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View viewI = aVar.i(size);
            if (viewI != null && G(viewI) && (sVarRemove = aVar2.remove(viewI)) != null && G(sVarRemove.b)) {
                this.u.add(aVar.k(size));
                this.v.add(sVarRemove);
            }
        }
    }

    private void K(d.d.a<View, s> aVar, d.d.a<View, s> aVar2, d.d.d<View> dVar, d.d.d<View> dVar2) {
        View viewF;
        int iM = dVar.m();
        for (int i = 0; i < iM; i++) {
            View viewN = dVar.n(i);
            if (viewN != null && G(viewN) && (viewF = dVar2.f(dVar.i(i))) != null && G(viewF)) {
                s sVar = aVar.get(viewN);
                s sVar2 = aVar2.get(viewF);
                if (sVar != null && sVar2 != null) {
                    this.u.add(sVar);
                    this.v.add(sVar2);
                    aVar.remove(viewN);
                    aVar2.remove(viewF);
                }
            }
        }
    }

    private void L(d.d.a<View, s> aVar, d.d.a<View, s> aVar2, d.d.a<String, View> aVar3, d.d.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i = 0; i < size; i++) {
            View viewM = aVar3.m(i);
            if (viewM != null && G(viewM) && (view = aVar4.get(aVar3.i(i))) != null && G(view)) {
                s sVar = aVar.get(viewM);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.u.add(sVar);
                    this.v.add(sVar2);
                    aVar.remove(viewM);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void M(t tVar, t tVar2) {
        d.d.a<View, s> aVar = new d.d.a<>(tVar.a);
        d.d.a<View, s> aVar2 = new d.d.a<>(tVar2.a);
        int i = 0;
        while (true) {
            int[] iArr = this.t;
            if (i >= iArr.length) {
                c(aVar, aVar2);
                return;
            }
            int i2 = iArr[i];
            if (i2 == 1) {
                J(aVar, aVar2);
            } else if (i2 == 2) {
                L(aVar, aVar2, tVar.f851d, tVar2.f851d);
            } else if (i2 == 3) {
                I(aVar, aVar2, tVar.b, tVar2.b);
            } else if (i2 == 4) {
                K(aVar, aVar2, tVar.c, tVar2.c);
            }
            i++;
        }
    }

    private void S(Animator animator, d.d.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            e(animator);
        }
    }

    private void c(d.d.a<View, s> aVar, d.d.a<View, s> aVar2) {
        for (int i = 0; i < aVar.size(); i++) {
            s sVarM = aVar.m(i);
            if (G(sVarM.b)) {
                this.u.add(sVarM);
                this.v.add(null);
            }
        }
        for (int i2 = 0; i2 < aVar2.size(); i2++) {
            s sVarM2 = aVar2.m(i2);
            if (G(sVarM2.b)) {
                this.v.add(sVarM2);
                this.u.add(null);
            }
        }
    }

    private static void d(t tVar, View view, s sVar) {
        tVar.a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.b.indexOfKey(id) >= 0) {
                tVar.b.put(id, null);
            } else {
                tVar.b.put(id, view);
            }
        }
        String strB = d.f.k.r.B(view);
        if (strB != null) {
            if (tVar.f851d.containsKey(strB)) {
                tVar.f851d.put(strB, null);
            } else {
                tVar.f851d.put(strB, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.c.h(itemIdAtPosition) < 0) {
                    d.f.k.r.l0(view, true);
                    tVar.c.j(itemIdAtPosition, view);
                    return;
                }
                View viewF = tVar.c.f(itemIdAtPosition);
                if (viewF != null) {
                    d.f.k.r.l0(viewF, false);
                    tVar.c.j(itemIdAtPosition, null);
                }
            }
        }
    }

    private void h(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.j;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.k;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.l;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (this.l.get(i).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s sVar = new s(view);
                    if (z) {
                        j(sVar);
                    } else {
                        g(sVar);
                    }
                    sVar.c.add(this);
                    i(sVar);
                    d(z ? this.q : this.r, view, sVar);
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.n;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.o;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.p;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.p.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                h(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    private static d.d.a<Animator, d> x() {
        d.d.a<Animator, d> aVar = J.get();
        if (aVar != null) {
            return aVar;
        }
        d.d.a<Animator, d> aVar2 = new d.d.a<>();
        J.set(aVar2);
        return aVar2;
    }

    public List<String> A() {
        return this.h;
    }

    public List<Class<?>> B() {
        return this.i;
    }

    public List<View> C() {
        return this.f848g;
    }

    public String[] D() {
        return null;
    }

    public s E(View view, boolean z) {
        q qVar = this.s;
        if (qVar != null) {
            return qVar.E(view, z);
        }
        return (z ? this.q : this.r).a.get(view);
    }

    public boolean F(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] strArrD = D();
        if (strArrD == null) {
            Iterator<String> it = sVar.a.keySet().iterator();
            while (it.hasNext()) {
                if (H(sVar, sVar2, it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrD) {
            if (!H(sVar, sVar2, str)) {
            }
        }
        return false;
        return true;
    }

    boolean G(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.j;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.k;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.l;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (this.l.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.m != null && d.f.k.r.B(view) != null && this.m.contains(d.f.k.r.B(view))) {
            return false;
        }
        if ((this.f847f.size() == 0 && this.f848g.size() == 0 && (((arrayList = this.i) == null || arrayList.isEmpty()) && ((arrayList2 = this.h) == null || arrayList2.isEmpty()))) || this.f847f.contains(Integer.valueOf(id)) || this.f848g.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.h;
        if (arrayList6 != null && arrayList6.contains(d.f.k.r.B(view))) {
            return true;
        }
        if (this.i != null) {
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                if (this.i.get(i2).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void N(View view) {
        if (this.A) {
            return;
        }
        d.d.a<Animator, d> aVarX = x();
        int size = aVarX.size();
        m0 m0VarD = c0.d(view);
        for (int i = size - 1; i >= 0; i--) {
            d dVarM = aVarX.m(i);
            if (dVarM.a != null && m0VarD.equals(dVarM.f849d)) {
                d.m.a.b(aVarX.i(i));
            }
        }
        ArrayList<f> arrayList = this.B;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.B.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((f) arrayList2.get(i2)).d(this);
            }
        }
        this.z = true;
    }

    void O(ViewGroup viewGroup) {
        d dVar;
        this.u = new ArrayList<>();
        this.v = new ArrayList<>();
        M(this.q, this.r);
        d.d.a<Animator, d> aVarX = x();
        int size = aVarX.size();
        m0 m0VarD = c0.d(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator animatorI = aVarX.i(i);
            if (animatorI != null && (dVar = aVarX.get(animatorI)) != null && dVar.a != null && m0VarD.equals(dVar.f849d)) {
                s sVar = dVar.c;
                View view = dVar.a;
                s sVarE = E(view, true);
                s sVarT = t(view, true);
                if (sVarE == null && sVarT == null) {
                    sVarT = this.r.a.get(view);
                }
                if (!(sVarE == null && sVarT == null) && dVar.f850e.F(sVar, sVarT)) {
                    if (animatorI.isRunning() || animatorI.isStarted()) {
                        animatorI.cancel();
                    } else {
                        aVarX.remove(animatorI);
                    }
                }
            }
        }
        o(viewGroup, this.q, this.r, this.u, this.v);
        T();
    }

    public m P(f fVar) {
        ArrayList<f> arrayList = this.B;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.B.size() == 0) {
            this.B = null;
        }
        return this;
    }

    public m Q(View view) {
        this.f848g.remove(view);
        return this;
    }

    public void R(View view) {
        if (this.z) {
            if (!this.A) {
                d.d.a<Animator, d> aVarX = x();
                int size = aVarX.size();
                m0 m0VarD = c0.d(view);
                for (int i = size - 1; i >= 0; i--) {
                    d dVarM = aVarX.m(i);
                    if (dVarM.a != null && m0VarD.equals(dVarM.f849d)) {
                        d.m.a.c(aVarX.i(i));
                    }
                }
                ArrayList<f> arrayList = this.B;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.B.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((f) arrayList2.get(i2)).e(this);
                    }
                }
            }
            this.z = false;
        }
    }

    protected void T() {
        a0();
        d.d.a<Animator, d> aVarX = x();
        for (Animator animator : this.C) {
            if (aVarX.containsKey(animator)) {
                a0();
                S(animator, aVarX);
            }
        }
        this.C.clear();
        p();
    }

    public m U(long j) {
        this.f845d = j;
        return this;
    }

    public void V(e eVar) {
        this.E = eVar;
    }

    public m W(TimeInterpolator timeInterpolator) {
        this.f846e = timeInterpolator;
        return this;
    }

    public void X(g gVar) {
        if (gVar == null) {
            gVar = I;
        }
        this.G = gVar;
    }

    public void Y(p pVar) {
        this.D = pVar;
    }

    public m Z(long j) {
        this.c = j;
        return this;
    }

    public m a(f fVar) {
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.add(fVar);
        return this;
    }

    protected void a0() {
        if (this.y == 0) {
            ArrayList<f> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((f) arrayList2.get(i)).a(this);
                }
            }
            this.A = false;
        }
        this.y++;
    }

    public m b(View view) {
        this.f848g.add(view);
        return this;
    }

    String b0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f845d != -1) {
            str2 = str2 + "dur(" + this.f845d + ") ";
        }
        if (this.c != -1) {
            str2 = str2 + "dly(" + this.c + ") ";
        }
        if (this.f846e != null) {
            str2 = str2 + "interp(" + this.f846e + ") ";
        }
        if (this.f847f.size() <= 0 && this.f848g.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f847f.size() > 0) {
            for (int i = 0; i < this.f847f.size(); i++) {
                if (i > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f847f.get(i);
            }
        }
        if (this.f848g.size() > 0) {
            for (int i2 = 0; i2 < this.f848g.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f848g.get(i2);
            }
        }
        return str3 + ")";
    }

    protected void e(Animator animator) {
        if (animator == null) {
            p();
            return;
        }
        if (q() >= 0) {
            animator.setDuration(q());
        }
        if (y() >= 0) {
            animator.setStartDelay(y() + animator.getStartDelay());
        }
        if (s() != null) {
            animator.setInterpolator(s());
        }
        animator.addListener(new c());
        animator.start();
    }

    protected void f() {
        for (int size = this.x.size() - 1; size >= 0; size--) {
            this.x.get(size).cancel();
        }
        ArrayList<f> arrayList = this.B;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.B.clone();
        int size2 = arrayList2.size();
        for (int i = 0; i < size2; i++) {
            ((f) arrayList2.get(i)).b(this);
        }
    }

    public abstract void g(s sVar);

    void i(s sVar) {
        String[] strArrB;
        if (this.D == null || sVar.a.isEmpty() || (strArrB = this.D.b()) == null) {
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= strArrB.length) {
                z = true;
                break;
            } else if (!sVar.a.containsKey(strArrB[i])) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        this.D.a(sVar);
    }

    public abstract void j(s sVar);

    void k(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        d.d.a<String, String> aVar;
        l(z);
        if ((this.f847f.size() > 0 || this.f848g.size() > 0) && (((arrayList = this.h) == null || arrayList.isEmpty()) && ((arrayList2 = this.i) == null || arrayList2.isEmpty()))) {
            for (int i = 0; i < this.f847f.size(); i++) {
                View viewFindViewById = viewGroup.findViewById(this.f847f.get(i).intValue());
                if (viewFindViewById != null) {
                    s sVar = new s(viewFindViewById);
                    if (z) {
                        j(sVar);
                    } else {
                        g(sVar);
                    }
                    sVar.c.add(this);
                    i(sVar);
                    d(z ? this.q : this.r, viewFindViewById, sVar);
                }
            }
            for (int i2 = 0; i2 < this.f848g.size(); i2++) {
                View view = this.f848g.get(i2);
                s sVar2 = new s(view);
                if (z) {
                    j(sVar2);
                } else {
                    g(sVar2);
                }
                sVar2.c.add(this);
                i(sVar2);
                d(z ? this.q : this.r, view, sVar2);
            }
        } else {
            h(viewGroup, z);
        }
        if (z || (aVar = this.F) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(this.q.f851d.remove(this.F.i(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.q.f851d.put(this.F.m(i4), view2);
            }
        }
    }

    void l(boolean z) {
        t tVar;
        if (z) {
            this.q.a.clear();
            this.q.b.clear();
            tVar = this.q;
        } else {
            this.r.a.clear();
            this.r.b.clear();
            tVar = this.r;
        }
        tVar.c.b();
    }

    @Override // 
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public m clone() {
        try {
            m mVar = (m) super.clone();
            mVar.C = new ArrayList<>();
            mVar.q = new t();
            mVar.r = new t();
            mVar.u = null;
            mVar.v = null;
            return mVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0043  */
    protected void o(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        Animator animatorN;
        int i;
        int i2;
        View view;
        Animator animator;
        s sVar;
        Animator animator2;
        s sVar2;
        d.d.a<Animator, d> aVarX = x();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long jMin = Long.MAX_VALUE;
        int i3 = 0;
        while (i3 < size) {
            s sVar3 = arrayList.get(i3);
            s sVar4 = arrayList2.get(i3);
            if (sVar3 != null && !sVar3.c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.c.contains(this)) {
                sVar4 = null;
            }
            if (sVar3 == null && sVar4 == null) {
                i = size;
                i2 = i3;
            } else if (!(sVar3 == null || sVar4 == null || F(sVar3, sVar4)) || (animatorN = n(viewGroup, sVar3, sVar4)) == null) {
                i = size;
                i2 = i3;
            } else {
                if (sVar4 != null) {
                    view = sVar4.b;
                    String[] strArrD = D();
                    if (strArrD != null && strArrD.length > 0) {
                        sVar2 = new s(view);
                        i = size;
                        s sVar5 = tVar2.a.get(view);
                        if (sVar5 != null) {
                            int i4 = 0;
                            while (i4 < strArrD.length) {
                                sVar2.a.put(strArrD[i4], sVar5.a.get(strArrD[i4]));
                                i4++;
                                i3 = i3;
                                sVar5 = sVar5;
                            }
                        }
                        i2 = i3;
                        int size2 = aVarX.size();
                        int i5 = 0;
                        while (true) {
                            if (i5 >= size2) {
                                animator2 = animatorN;
                                break;
                            }
                            d dVar = aVarX.get(aVarX.i(i5));
                            if (dVar.c != null && dVar.a == view && dVar.b.equals(u()) && dVar.c.equals(sVar2)) {
                                animator2 = null;
                                break;
                            }
                            i5++;
                        }
                    } else {
                        i = size;
                        i2 = i3;
                        animator2 = animatorN;
                        sVar2 = null;
                    }
                    animator = animator2;
                    sVar = sVar2;
                } else {
                    i = size;
                    i2 = i3;
                    view = sVar3.b;
                    animator = animatorN;
                    sVar = null;
                }
                if (animator != null) {
                    p pVar = this.D;
                    if (pVar != null) {
                        long jC = pVar.c(viewGroup, this, sVar3, sVar4);
                        sparseIntArray.put(this.C.size(), (int) jC);
                        jMin = Math.min(jC, jMin);
                    }
                    aVarX.put(animator, new d(view, u(), this, c0.d(viewGroup), sVar));
                    this.C.add(animator);
                    jMin = jMin;
                }
            }
            i3 = i2 + 1;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                Animator animator3 = this.C.get(sparseIntArray.keyAt(i6));
                animator3.setStartDelay((((long) sparseIntArray.valueAt(i6)) - jMin) + animator3.getStartDelay());
            }
        }
    }

    protected void p() {
        int i = this.y - 1;
        this.y = i;
        if (i == 0) {
            ArrayList<f> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((f) arrayList2.get(i2)).c(this);
                }
            }
            for (int i3 = 0; i3 < this.q.c.m(); i3++) {
                View viewN = this.q.c.n(i3);
                if (viewN != null) {
                    d.f.k.r.l0(viewN, false);
                }
            }
            for (int i4 = 0; i4 < this.r.c.m(); i4++) {
                View viewN2 = this.r.c.n(i4);
                if (viewN2 != null) {
                    d.f.k.r.l0(viewN2, false);
                }
            }
            this.A = true;
        }
    }

    public long q() {
        return this.f845d;
    }

    public e r() {
        return this.E;
    }

    public TimeInterpolator s() {
        return this.f846e;
    }

    s t(View view, boolean z) {
        q qVar = this.s;
        if (qVar != null) {
            return qVar.t(view, z);
        }
        ArrayList<s> arrayList = z ? this.u : this.v;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            s sVar = arrayList.get(i2);
            if (sVar == null) {
                return null;
            }
            if (sVar.b == view) {
                i = i2;
                break;
            }
        }
        if (i >= 0) {
            return (z ? this.v : this.u).get(i);
        }
        return null;
    }

    public String toString() {
        return b0("");
    }

    public String u() {
        return this.b;
    }

    public g v() {
        return this.G;
    }

    public p w() {
        return this.D;
    }

    public long y() {
        return this.c;
    }

    public List<Integer> z() {
        return this.f847f;
    }
}
