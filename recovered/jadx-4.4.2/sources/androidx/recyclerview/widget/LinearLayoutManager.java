package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    int A;
    int B;
    private boolean C;
    d D;
    final a E;
    private final b F;
    private int G;
    private int[] H;
    int s;
    private c t;
    j u;
    private boolean v;
    private boolean w;
    boolean x;
    private boolean y;
    private boolean z;

    static class a {
        j a;
        int b;
        int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f381d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f382e;

        a() {
            e();
        }

        void a() {
            this.c = this.f381d ? this.a.i() : this.a.m();
        }

        public void b(View view, int i) {
            this.c = this.f381d ? this.a.d(view) + this.a.o() : this.a.g(view);
            this.b = i;
        }

        public void c(View view, int i) {
            int iO = this.a.o();
            if (iO >= 0) {
                b(view, i);
                return;
            }
            this.b = i;
            if (this.f381d) {
                int i2 = (this.a.i() - iO) - this.a.d(view);
                this.c = this.a.i() - i2;
                if (i2 > 0) {
                    int iE = this.c - this.a.e(view);
                    int iM = this.a.m();
                    int iMin = iE - (iM + Math.min(this.a.g(view) - iM, 0));
                    if (iMin < 0) {
                        this.c += Math.min(i2, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG = this.a.g(view);
            int iM2 = iG - this.a.m();
            this.c = iG;
            if (iM2 > 0) {
                int i3 = (this.a.i() - Math.min(0, (this.a.i() - iO) - this.a.d(view))) - (iG + this.a.e(view));
                if (i3 < 0) {
                    this.c -= Math.min(iM2, -i3);
                }
            }
        }

        boolean d(View view, RecyclerView.a0 a0Var) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < a0Var.b();
        }

        void e() {
            this.b = -1;
            this.c = RecyclerView.UNDEFINED_DURATION;
            this.f381d = false;
            this.f382e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.f381d + ", mValid=" + this.f382e + '}';
        }
    }

    protected static class b {
        public int a;
        public boolean b;
        public boolean c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f383d;

        protected b() {
        }

        void a() {
            this.a = 0;
            this.b = false;
            this.c = false;
            this.f383d = false;
        }
    }

    static class c {
        int b;
        int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f384d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f385e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f386f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f387g;
        boolean j;
        int k;
        boolean m;
        boolean a = true;
        int h = 0;
        int i = 0;
        List<RecyclerView.d0> l = null;

        c() {
        }

        private View e() {
            int size = this.l.size();
            for (int i = 0; i < size; i++) {
                View view = this.l.get(i).a;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f384d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View viewF = f(view);
            this.f384d = viewF == null ? -1 : ((RecyclerView.p) viewF.getLayoutParams()).a();
        }

        boolean c(RecyclerView.a0 a0Var) {
            int i = this.f384d;
            return i >= 0 && i < a0Var.b();
        }

        View d(RecyclerView.v vVar) {
            if (this.l != null) {
                return e();
            }
            View viewO = vVar.o(this.f384d);
            this.f384d += this.f385e;
            return viewO;
        }

        public View f(View view) {
            int iA;
            int size = this.l.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.l.get(i2).a;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (iA = (pVar.a() - this.f384d) * this.f385e) >= 0 && iA < i) {
                    view2 = view3;
                    if (iA == 0) {
                        break;
                    }
                    i = iA;
                }
            }
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();
        int b;
        int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f388d;

        static class a implements Parcelable.Creator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i) {
                return new d[i];
            }
        }

        public d() {
        }

        d(Parcel parcel) {
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.f388d = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.b = dVar.b;
            this.c = dVar.c;
            this.f388d = dVar.f388d;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        boolean j() {
            return this.b >= 0;
        }

        void k() {
            this.b = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.f388d ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = RecyclerView.UNDEFINED_DURATION;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        C2(i);
        D2(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = RecyclerView.UNDEFINED_DURATION;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.o.d dVarI0 = RecyclerView.o.i0(context, attributeSet, i, i2);
        C2(dVarI0.a);
        D2(dVarI0.c);
        E2(dVarI0.f408d);
    }

    private void A2() {
        this.x = (this.s == 1 || !q2()) ? this.w : !this.w;
    }

    private boolean F2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (J() == 0) {
            return false;
        }
        View viewV = V();
        if (viewV != null && aVar.d(viewV, a0Var)) {
            aVar.c(viewV, h0(viewV));
            return true;
        }
        if (this.v != this.y) {
            return false;
        }
        View viewI2 = aVar.f381d ? i2(vVar, a0Var) : j2(vVar, a0Var);
        if (viewI2 == null) {
            return false;
        }
        aVar.b(viewI2, h0(viewI2));
        if (!a0Var.e() && L1()) {
            if (this.u.g(viewI2) >= this.u.i() || this.u.d(viewI2) < this.u.m()) {
                aVar.c = aVar.f381d ? this.u.i() : this.u.m();
            }
        }
        return true;
    }

    private boolean G2(RecyclerView.a0 a0Var, a aVar) {
        int i;
        if (!a0Var.e() && (i = this.A) != -1) {
            if (i >= 0 && i < a0Var.b()) {
                aVar.b = this.A;
                d dVar = this.D;
                if (dVar != null && dVar.j()) {
                    boolean z = this.D.f388d;
                    aVar.f381d = z;
                    aVar.c = z ? this.u.i() - this.D.c : this.u.m() + this.D.c;
                    return true;
                }
                if (this.B != Integer.MIN_VALUE) {
                    boolean z2 = this.x;
                    aVar.f381d = z2;
                    aVar.c = z2 ? this.u.i() - this.B : this.u.m() + this.B;
                    return true;
                }
                View viewC = C(this.A);
                if (viewC == null) {
                    if (J() > 0) {
                        aVar.f381d = (this.A < h0(I(0))) == this.x;
                    }
                    aVar.a();
                } else {
                    if (this.u.e(viewC) > this.u.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.u.g(viewC) - this.u.m() < 0) {
                        aVar.c = this.u.m();
                        aVar.f381d = false;
                        return true;
                    }
                    if (this.u.i() - this.u.d(viewC) < 0) {
                        aVar.c = this.u.i();
                        aVar.f381d = true;
                        return true;
                    }
                    aVar.c = aVar.f381d ? this.u.d(viewC) + this.u.o() : this.u.g(viewC);
                }
                return true;
            }
            this.A = -1;
            this.B = RecyclerView.UNDEFINED_DURATION;
        }
        return false;
    }

    private void H2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (G2(a0Var, aVar) || F2(vVar, a0Var, aVar)) {
            return;
        }
        aVar.a();
        aVar.b = this.y ? a0Var.b() - 1 : 0;
    }

    private void I2(int i, int i2, boolean z, RecyclerView.a0 a0Var) {
        int iM;
        this.t.m = z2();
        this.t.f386f = i;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(a0Var, iArr);
        int iMax = Math.max(0, this.H[0]);
        int iMax2 = Math.max(0, this.H[1]);
        boolean z2 = i == 1;
        this.t.h = z2 ? iMax2 : iMax;
        c cVar = this.t;
        if (!z2) {
            iMax = iMax2;
        }
        cVar.i = iMax;
        if (z2) {
            this.t.h += this.u.j();
            View viewM2 = m2();
            this.t.f385e = this.x ? -1 : 1;
            c cVar2 = this.t;
            int iH0 = h0(viewM2);
            c cVar3 = this.t;
            cVar2.f384d = iH0 + cVar3.f385e;
            cVar3.b = this.u.d(viewM2);
            iM = this.u.d(viewM2) - this.u.i();
        } else {
            View viewN2 = n2();
            this.t.h += this.u.m();
            this.t.f385e = this.x ? 1 : -1;
            c cVar4 = this.t;
            int iH1 = h0(viewN2);
            c cVar5 = this.t;
            cVar4.f384d = iH1 + cVar5.f385e;
            cVar5.b = this.u.g(viewN2);
            iM = (-this.u.g(viewN2)) + this.u.m();
        }
        c cVar6 = this.t;
        cVar6.c = i2;
        if (z) {
            cVar6.c = i2 - iM;
        }
        this.t.f387g = iM;
    }

    private void J2(int i, int i2) {
        this.t.c = this.u.i() - i2;
        this.t.f385e = this.x ? -1 : 1;
        c cVar = this.t;
        cVar.f384d = i;
        cVar.f386f = 1;
        cVar.b = i2;
        cVar.f387g = RecyclerView.UNDEFINED_DURATION;
    }

    private void K2(a aVar) {
        J2(aVar.b, aVar.c);
    }

    private void L2(int i, int i2) {
        this.t.c = i2 - this.u.m();
        c cVar = this.t;
        cVar.f384d = i;
        cVar.f385e = this.x ? 1 : -1;
        c cVar2 = this.t;
        cVar2.f386f = -1;
        cVar2.b = i2;
        cVar2.f387g = RecyclerView.UNDEFINED_DURATION;
    }

    private void M2(a aVar) {
        L2(aVar.b, aVar.c);
    }

    private int O1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.a(a0Var, this.u, Y1(!this.z, true), X1(!this.z, true), this, this.z);
    }

    private int P1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.b(a0Var, this.u, Y1(!this.z, true), X1(!this.z, true), this, this.z, this.x);
    }

    private int Q1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.c(a0Var, this.u, Y1(!this.z, true), X1(!this.z, true), this, this.z);
    }

    private View V1() {
        return d2(0, J());
    }

    private View W1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return h2(vVar, a0Var, 0, J(), a0Var.b());
    }

    private View a2() {
        return d2(J() - 1, -1);
    }

    private View b2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return h2(vVar, a0Var, J() - 1, -1, a0Var.b());
    }

    private View f2() {
        return this.x ? V1() : a2();
    }

    private View g2() {
        return this.x ? a2() : V1();
    }

    private View i2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.x ? W1(vVar, a0Var) : b2(vVar, a0Var);
    }

    private View j2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.x ? b2(vVar, a0Var) : W1(vVar, a0Var);
    }

    private int k2(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int i2;
        int i3 = this.u.i() - i;
        if (i3 <= 0) {
            return 0;
        }
        int i4 = -B2(-i3, vVar, a0Var);
        int i5 = i + i4;
        if (!z || (i2 = this.u.i() - i5) <= 0) {
            return i4;
        }
        this.u.r(i2);
        return i2 + i4;
    }

    private int l2(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int iM;
        int iM2 = i - this.u.m();
        if (iM2 <= 0) {
            return 0;
        }
        int i2 = -B2(iM2, vVar, a0Var);
        int i3 = i + i2;
        if (!z || (iM = i3 - this.u.m()) <= 0) {
            return i2;
        }
        this.u.r(-iM);
        return i2 - iM;
    }

    private View m2() {
        return I(this.x ? 0 : J() - 1);
    }

    private View n2() {
        return I(this.x ? J() - 1 : 0);
    }

    private void t2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i, int i2) {
        if (!a0Var.g() || J() == 0 || a0Var.e() || !L1()) {
            return;
        }
        List<RecyclerView.d0> listK = vVar.k();
        int size = listK.size();
        int iH0 = h0(I(0));
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.d0 d0Var = listK.get(i5);
            if (!d0Var.v()) {
                byte b2 = (d0Var.m() < iH0) != this.x ? (byte) -1 : (byte) 1;
                int iE = this.u.e(d0Var.a);
                if (b2 == -1) {
                    i3 += iE;
                } else {
                    i4 += iE;
                }
            }
        }
        this.t.l = listK;
        if (i3 > 0) {
            L2(h0(n2()), i);
            c cVar = this.t;
            cVar.h = i3;
            cVar.c = 0;
            cVar.a();
            U1(vVar, this.t, a0Var, false);
        }
        if (i4 > 0) {
            J2(h0(m2()), i2);
            c cVar2 = this.t;
            cVar2.h = i4;
            cVar2.c = 0;
            cVar2.a();
            U1(vVar, this.t, a0Var, false);
        }
        this.t.l = null;
    }

    private void v2(RecyclerView.v vVar, c cVar) {
        if (!cVar.a || cVar.m) {
            return;
        }
        int i = cVar.f387g;
        int i2 = cVar.i;
        if (cVar.f386f == -1) {
            x2(vVar, i, i2);
        } else {
            y2(vVar, i, i2);
        }
    }

    private void w2(RecyclerView.v vVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                n1(i, vVar);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                n1(i3, vVar);
            }
        }
    }

    private void x2(RecyclerView.v vVar, int i, int i2) {
        int iJ = J();
        if (i < 0) {
            return;
        }
        int iH = (this.u.h() - i) + i2;
        if (this.x) {
            for (int i3 = 0; i3 < iJ; i3++) {
                View viewI = I(i3);
                if (this.u.g(viewI) < iH || this.u.q(viewI) < iH) {
                    w2(vVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = iJ - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View viewI2 = I(i5);
            if (this.u.g(viewI2) < iH || this.u.q(viewI2) < iH) {
                w2(vVar, i4, i5);
                return;
            }
        }
    }

    private void y2(RecyclerView.v vVar, int i, int i2) {
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int iJ = J();
        if (!this.x) {
            for (int i4 = 0; i4 < iJ; i4++) {
                View viewI = I(i4);
                if (this.u.d(viewI) > i3 || this.u.p(viewI) > i3) {
                    w2(vVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = iJ - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View viewI2 = I(i6);
            if (this.u.d(viewI2) > i3 || this.u.p(viewI2) > i3) {
                w2(vVar, i5, i6);
                return;
            }
        }
    }

    int B2(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (J() == 0 || i == 0) {
            return 0;
        }
        T1();
        this.t.a = true;
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        I2(i2, iAbs, true, a0Var);
        c cVar = this.t;
        int iU1 = cVar.f387g + U1(vVar, cVar, a0Var, false);
        if (iU1 < 0) {
            return 0;
        }
        if (iAbs > iU1) {
            i = i2 * iU1;
        }
        this.u.r(-i);
        this.t.k = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View C(int i) {
        int iJ = J();
        if (iJ == 0) {
            return null;
        }
        int iH0 = i - h0(I(0));
        if (iH0 >= 0 && iH0 < iJ) {
            View viewI = I(iH0);
            if (h0(viewI) == i) {
                return viewI;
            }
        }
        return super.C(i);
    }

    public void C2(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        g(null);
        if (i != this.s || this.u == null) {
            j jVarB = j.b(this, i);
            this.u = jVarB;
            this.E.a = jVarB;
            this.s = i;
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return new RecyclerView.p(-2, -2);
    }

    public void D2(boolean z) {
        g(null);
        if (z == this.w) {
            return;
        }
        this.w = z;
        t1();
    }

    public void E2(boolean z) {
        g(null);
        if (this.y == z) {
            return;
        }
        this.y = z;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    boolean G1() {
        return (X() == 1073741824 || p0() == 1073741824 || !q0()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.I0(recyclerView, vVar);
        if (this.C) {
            k1(vVar);
            vVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I1(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i) {
        g gVar = new g(recyclerView.getContext());
        gVar.p(i);
        J1(gVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View J0(View view, int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int iR1;
        A2();
        if (J() == 0 || (iR1 = R1(i)) == Integer.MIN_VALUE) {
            return null;
        }
        T1();
        I2(iR1, (int) (this.u.n() * 0.33333334f), false, a0Var);
        c cVar = this.t;
        cVar.f387g = RecyclerView.UNDEFINED_DURATION;
        cVar.a = false;
        U1(vVar, cVar, a0Var, true);
        View viewG2 = iR1 == -1 ? g2() : f2();
        View viewN2 = iR1 == -1 ? n2() : m2();
        if (!viewN2.hasFocusable()) {
            return viewG2;
        }
        if (viewG2 == null) {
            return null;
        }
        return viewN2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(AccessibilityEvent accessibilityEvent) {
        super.K0(accessibilityEvent);
        if (J() > 0) {
            accessibilityEvent.setFromIndex(Z1());
            accessibilityEvent.setToIndex(c2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.D == null && this.v == this.y;
    }

    protected void M1(RecyclerView.a0 a0Var, int[] iArr) {
        int i;
        int iO2 = o2(a0Var);
        if (this.t.f386f == -1) {
            i = 0;
        } else {
            i = iO2;
            iO2 = 0;
        }
        iArr[0] = iO2;
        iArr[1] = i;
    }

    void N1(RecyclerView.a0 a0Var, c cVar, RecyclerView.o.c cVar2) {
        int i = cVar.f384d;
        if (i < 0 || i >= a0Var.b()) {
            return;
        }
        cVar2.a(i, Math.max(0, cVar.f387g));
    }

    int R1(int i) {
        if (i == 1) {
            return (this.s != 1 && q2()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.s != 1 && q2()) ? -1 : 1;
        }
        if (i == 17) {
            if (this.s == 0) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i == 33) {
            if (this.s == 1) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i == 66) {
            if (this.s == 0) {
                return 1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i == 130 && this.s == 1) {
            return 1;
        }
        return RecyclerView.UNDEFINED_DURATION;
    }

    c S1() {
        return new c();
    }

    void T1() {
        if (this.t == null) {
            this.t = S1();
        }
    }

    int U1(RecyclerView.v vVar, c cVar, RecyclerView.a0 a0Var, boolean z) {
        int i = cVar.c;
        int i2 = cVar.f387g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.f387g = i2 + i;
            }
            v2(vVar, cVar);
        }
        int i3 = cVar.c + cVar.h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.m && i3 <= 0) || !cVar.c(a0Var)) {
                break;
            }
            bVar.a();
            s2(vVar, a0Var, cVar, bVar);
            if (!bVar.b) {
                cVar.b += bVar.a * cVar.f386f;
                if (!bVar.c || cVar.l != null || !a0Var.e()) {
                    int i4 = cVar.c;
                    int i5 = bVar.a;
                    cVar.c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.f387g;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + bVar.a;
                    cVar.f387g = i7;
                    int i8 = cVar.c;
                    if (i8 < 0) {
                        cVar.f387g = i7 + i8;
                    }
                    v2(vVar, cVar);
                }
                if (z && bVar.f383d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int iK2;
        int i5;
        View viewC;
        int iG;
        int i6;
        int i7 = -1;
        if (!(this.D == null && this.A == -1) && a0Var.b() == 0) {
            k1(vVar);
            return;
        }
        d dVar = this.D;
        if (dVar != null && dVar.j()) {
            this.A = this.D.b;
        }
        T1();
        this.t.a = false;
        A2();
        View viewV = V();
        if (!this.E.f382e || this.A != -1 || this.D != null) {
            this.E.e();
            a aVar = this.E;
            aVar.f381d = this.x ^ this.y;
            H2(vVar, a0Var, aVar);
            this.E.f382e = true;
        } else if (viewV != null && (this.u.g(viewV) >= this.u.i() || this.u.d(viewV) <= this.u.m())) {
            this.E.c(viewV, h0(viewV));
        }
        c cVar = this.t;
        cVar.f386f = cVar.k >= 0 ? 1 : -1;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(a0Var, iArr);
        int iMax = Math.max(0, this.H[0]) + this.u.m();
        int iMax2 = Math.max(0, this.H[1]) + this.u.j();
        if (a0Var.e() && (i5 = this.A) != -1 && this.B != Integer.MIN_VALUE && (viewC = C(i5)) != null) {
            if (this.x) {
                i6 = this.u.i() - this.u.d(viewC);
                iG = this.B;
            } else {
                iG = this.u.g(viewC) - this.u.m();
                i6 = this.B;
            }
            int i8 = i6 - iG;
            if (i8 > 0) {
                iMax += i8;
            } else {
                iMax2 -= i8;
            }
        }
        if (!this.E.f381d ? !this.x : this.x) {
            i7 = 1;
        }
        u2(vVar, a0Var, this.E, i7);
        w(vVar);
        this.t.m = z2();
        this.t.j = a0Var.e();
        this.t.i = 0;
        a aVar2 = this.E;
        if (aVar2.f381d) {
            M2(aVar2);
            c cVar2 = this.t;
            cVar2.h = iMax;
            U1(vVar, cVar2, a0Var, false);
            c cVar3 = this.t;
            i2 = cVar3.b;
            int i9 = cVar3.f384d;
            int i10 = cVar3.c;
            if (i10 > 0) {
                iMax2 += i10;
            }
            K2(this.E);
            c cVar4 = this.t;
            cVar4.h = iMax2;
            cVar4.f384d += cVar4.f385e;
            U1(vVar, cVar4, a0Var, false);
            c cVar5 = this.t;
            i = cVar5.b;
            int i11 = cVar5.c;
            if (i11 > 0) {
                L2(i9, i2);
                c cVar6 = this.t;
                cVar6.h = i11;
                U1(vVar, cVar6, a0Var, false);
                i2 = this.t.b;
            }
        } else {
            K2(aVar2);
            c cVar7 = this.t;
            cVar7.h = iMax2;
            U1(vVar, cVar7, a0Var, false);
            c cVar8 = this.t;
            i = cVar8.b;
            int i12 = cVar8.f384d;
            int i13 = cVar8.c;
            if (i13 > 0) {
                iMax += i13;
            }
            M2(this.E);
            c cVar9 = this.t;
            cVar9.h = iMax;
            cVar9.f384d += cVar9.f385e;
            U1(vVar, cVar9, a0Var, false);
            c cVar10 = this.t;
            i2 = cVar10.b;
            int i14 = cVar10.c;
            if (i14 > 0) {
                J2(i12, i);
                c cVar11 = this.t;
                cVar11.h = i14;
                U1(vVar, cVar11, a0Var, false);
                i = this.t.b;
            }
        }
        if (J() > 0) {
            if (this.x ^ this.y) {
                int iK3 = k2(i, vVar, a0Var, true);
                i3 = i2 + iK3;
                i4 = i + iK3;
                iK2 = l2(i3, vVar, a0Var, false);
            } else {
                int iL2 = l2(i2, vVar, a0Var, true);
                i3 = i2 + iL2;
                i4 = i + iL2;
                iK2 = k2(i4, vVar, a0Var, false);
            }
            i2 = i3 + iK2;
            i = i4 + iK2;
        }
        t2(vVar, a0Var, i2, i);
        if (a0Var.e()) {
            this.E.e();
        } else {
            this.u.s();
        }
        this.v = this.y;
    }

    View X1(boolean z, boolean z2) {
        int iJ;
        int iJ2;
        if (this.x) {
            iJ = 0;
            iJ2 = J();
        } else {
            iJ = J() - 1;
            iJ2 = -1;
        }
        return e2(iJ, iJ2, z, z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.a0 a0Var) {
        super.Y0(a0Var);
        this.D = null;
        this.A = -1;
        this.B = RecyclerView.UNDEFINED_DURATION;
        this.E.e();
    }

    View Y1(boolean z, boolean z2) {
        int iJ;
        int iJ2;
        if (this.x) {
            iJ = J() - 1;
            iJ2 = -1;
        } else {
            iJ = 0;
            iJ2 = J();
        }
        return e2(iJ, iJ2, z, z2);
    }

    public int Z1() {
        View viewE2 = e2(0, J(), false, true);
        if (viewE2 == null) {
            return -1;
        }
        return h0(viewE2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i) {
        if (J() == 0) {
            return null;
        }
        int i2 = (i < h0(I(0))) != this.x ? -1 : 1;
        return this.s == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.D = (d) parcelable;
            t1();
        }
    }

    public int c2() {
        View viewE2 = e2(J() - 1, -1, false, true);
        if (viewE2 == null) {
            return -1;
        }
        return h0(viewE2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable d1() {
        if (this.D != null) {
            return new d(this.D);
        }
        d dVar = new d();
        if (J() > 0) {
            T1();
            boolean z = this.v ^ this.x;
            dVar.f388d = z;
            if (z) {
                View viewM2 = m2();
                dVar.c = this.u.i() - this.u.d(viewM2);
                dVar.b = h0(viewM2);
            } else {
                View viewN2 = n2();
                dVar.b = h0(viewN2);
                dVar.c = this.u.g(viewN2) - this.u.m();
            }
        } else {
            dVar.k();
        }
        return dVar;
    }

    View d2(int i, int i2) {
        byte b2;
        int i3;
        int i4;
        T1();
        if (i2 > i) {
            b2 = 1;
        } else {
            b2 = i2 < i ? (byte) -1 : (byte) 0;
        }
        if (b2 == 0) {
            return I(i);
        }
        if (this.u.g(I(i)) < this.u.m()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return (this.s == 0 ? this.f405e : this.f406f).a(i, i2, i3, i4);
    }

    View e2(int i, int i2, boolean z, boolean z2) {
        T1();
        return (this.s == 0 ? this.f405e : this.f406f).a(i, i2, z ? 24579 : 320, z2 ? 320 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.D == null) {
            super.g(str);
        }
    }

    View h2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i, int i2, int i3) {
        T1();
        int iM = this.u.m();
        int i4 = this.u.i();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewI = I(i);
            int iH0 = h0(viewI);
            if (iH0 >= 0 && iH0 < i3) {
                if (((RecyclerView.p) viewI.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = viewI;
                    }
                } else {
                    if (this.u.g(viewI) < i4 && this.u.d(viewI) >= iM) {
                        return viewI;
                    }
                    if (view == null) {
                        view = viewI;
                    }
                }
            }
            i += i5;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.s == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.s == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i, int i2, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        if (this.s != 0) {
            i = i2;
        }
        if (J() == 0 || i == 0) {
            return;
        }
        T1();
        I2(i > 0 ? 1 : -1, Math.abs(i), true, a0Var);
        N1(a0Var, this.t, cVar);
    }

    @Deprecated
    protected int o2(RecyclerView.a0 a0Var) {
        if (a0Var.d()) {
            return this.u.n();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p(int i, RecyclerView.o.c cVar) {
        boolean z;
        int i2;
        d dVar = this.D;
        if (dVar == null || !dVar.j()) {
            A2();
            z = this.x;
            i2 = this.A;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            d dVar2 = this.D;
            z = dVar2.f388d;
            i2 = dVar2.b;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.G && i2 >= 0 && i2 < i; i4++) {
            cVar.a(i2, 0);
            i2 += i3;
        }
    }

    public int p2() {
        return this.s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.a0 a0Var) {
        return O1(a0Var);
    }

    protected boolean q2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return P1(a0Var);
    }

    public boolean r2() {
        return this.z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return Q1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean s0() {
        return true;
    }

    void s2(RecyclerView.v vVar, RecyclerView.a0 a0Var, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int iE0;
        int iF;
        View viewD = cVar.d(vVar);
        if (viewD == null) {
            bVar.b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) viewD.getLayoutParams();
        if (cVar.l == null) {
            if (this.x == (cVar.f386f == -1)) {
                d(viewD);
            } else {
                e(viewD, 0);
            }
        } else {
            if (this.x == (cVar.f386f == -1)) {
                b(viewD);
            } else {
                c(viewD, 0);
            }
        }
        A0(viewD, 0, 0);
        bVar.a = this.u.e(viewD);
        if (this.s == 1) {
            if (q2()) {
                iF = o0() - f0();
                iE0 = iF - this.u.f(viewD);
            } else {
                iE0 = e0();
                iF = this.u.f(viewD) + iE0;
            }
            int i4 = cVar.f386f;
            int i5 = cVar.b;
            if (i4 == -1) {
                i3 = i5;
                i2 = iF;
                i = i5 - bVar.a;
            } else {
                i = i5;
                i2 = iF;
                i3 = bVar.a + i5;
            }
        } else {
            int iG0 = g0();
            int iF2 = this.u.f(viewD) + iG0;
            int i6 = cVar.f386f;
            int i7 = cVar.b;
            if (i6 == -1) {
                i2 = i7;
                i = iG0;
                i3 = iF2;
                iE0 = i7 - bVar.a;
            } else {
                i = iG0;
                i2 = bVar.a + i7;
                i3 = iF2;
                iE0 = i7;
            }
        }
        z0(viewD, iE0, i, i2, i3);
        if (pVar.c() || pVar.b()) {
            bVar.c = true;
        }
        bVar.f383d = viewD.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.a0 a0Var) {
        return O1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return P1(a0Var);
    }

    void u2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return Q1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 1) {
            return 0;
        }
        return B2(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int i) {
        this.A = i;
        this.B = RecyclerView.UNDEFINED_DURATION;
        d dVar = this.D;
        if (dVar != null) {
            dVar.k();
        }
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 0) {
            return 0;
        }
        return B2(i, vVar, a0Var);
    }

    boolean z2() {
        return this.u.k() == 0 && this.u.h() == 0;
    }
}
