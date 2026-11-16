package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    private BitSet B;
    private boolean G;
    private boolean H;
    private e I;
    private int J;
    private int[] O;
    f[] t;
    j u;
    j v;
    private int w;
    private int x;
    private final androidx.recyclerview.widget.f y;
    private int s = -1;
    boolean z = false;
    boolean A = false;
    int C = -1;
    int D = RecyclerView.UNDEFINED_DURATION;
    d E = new d();
    private int F = 2;
    private final Rect K = new Rect();
    private final b L = new b();
    private boolean M = false;
    private boolean N = true;
    private final Runnable P = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.S1();
        }
    }

    class b {
        int a;
        int b;
        boolean c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f424d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f425e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int[] f426f;

        b() {
            c();
        }

        void a() {
            this.b = this.c ? StaggeredGridLayoutManager.this.u.i() : StaggeredGridLayoutManager.this.u.m();
        }

        void b(int i) {
            this.b = this.c ? StaggeredGridLayoutManager.this.u.i() - i : StaggeredGridLayoutManager.this.u.m() + i;
        }

        void c() {
            this.a = -1;
            this.b = RecyclerView.UNDEFINED_DURATION;
            this.c = false;
            this.f424d = false;
            this.f425e = false;
            int[] iArr = this.f426f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f426f;
            if (iArr == null || iArr.length < length) {
                this.f426f = new int[StaggeredGridLayoutManager.this.t.length];
            }
            for (int i = 0; i < length; i++) {
                this.f426f[i] = fVarArr[i].p(RecyclerView.UNDEFINED_DURATION);
            }
        }
    }

    public static class c extends RecyclerView.p {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        f f428e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f429f;

        public c(int i, int i2) {
            super(i, i2);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public final int e() {
            f fVar = this.f428e;
            if (fVar == null) {
                return -1;
            }
            return fVar.f437e;
        }

        public boolean f() {
            return this.f429f;
        }
    }

    static class d {
        int[] a;
        List<a> b;

        @SuppressLint({"BanParcelableUsage"})
        static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0014a();
            int b;
            int c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int[] f430d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            boolean f431e;

            /* JADX INFO: renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            static class C0014a implements Parcelable.Creator<a> {
                C0014a() {
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i) {
                    return new a[i];
                }
            }

            a() {
            }

            a(Parcel parcel) {
                this.b = parcel.readInt();
                this.c = parcel.readInt();
                this.f431e = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    int[] iArr = new int[i];
                    this.f430d = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            int j(int i) {
                int[] iArr = this.f430d;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.b + ", mGapDir=" + this.c + ", mHasUnwantedGapAfter=" + this.f431e + ", mGapPerSpan=" + Arrays.toString(this.f430d) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.b);
                parcel.writeInt(this.c);
                parcel.writeInt(this.f431e ? 1 : 0);
                int[] iArr = this.f430d;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f430d);
                }
            }
        }

        d() {
        }

        private int i(int i) {
            if (this.b == null) {
                return -1;
            }
            a aVarF = f(i);
            if (aVarF != null) {
                this.b.remove(aVarF);
            }
            int size = this.b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (this.b.get(i2).b >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            a aVar = this.b.get(i2);
            this.b.remove(i2);
            return aVar.b;
        }

        private void l(int i, int i2) {
            List<a> list = this.b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.b.get(size);
                int i3 = aVar.b;
                if (i3 >= i) {
                    aVar.b = i3 + i2;
                }
            }
        }

        private void m(int i, int i2) {
            List<a> list = this.b;
            if (list == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.b.get(size);
                int i4 = aVar.b;
                if (i4 >= i) {
                    if (i4 < i3) {
                        this.b.remove(size);
                    } else {
                        aVar.b = i4 - i2;
                    }
                }
            }
        }

        public void a(a aVar) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.b.get(i);
                if (aVar2.b == aVar.b) {
                    this.b.remove(i);
                }
                if (aVar2.b >= aVar.b) {
                    this.b.add(i, aVar);
                    return;
                }
            }
            this.b.add(aVar);
        }

        void b() {
            int[] iArr = this.a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.b = null;
        }

        void c(int i) {
            int[] iArr = this.a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[o(i)];
                this.a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i) {
            List<a> list = this.b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.b.get(size).b >= i) {
                        this.b.remove(size);
                    }
                }
            }
            return h(i);
        }

        public a e(int i, int i2, int i3, boolean z) {
            List<a> list = this.b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.b.get(i4);
                int i5 = aVar.b;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || aVar.c == i3 || (z && aVar.f431e))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i) {
            List<a> list = this.b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.b.get(size);
                if (aVar.b == i) {
                    return aVar;
                }
            }
            return null;
        }

        int g(int i) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        int h(int i) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int i2 = i(i);
            if (i2 == -1) {
                int[] iArr2 = this.a;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.a.length;
            }
            int i3 = i2 + 1;
            Arrays.fill(this.a, i, i3, -1);
            return i3;
        }

        void j(int i, int i2) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            c(i3);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.a, i, i3, -1);
            l(i, i2);
        }

        void k(int i, int i2) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            c(i3);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            m(i, i2);
        }

        void n(int i, f fVar) {
            c(i);
            this.a[i] = fVar.f437e;
        }

        int o(int i) {
            int length = this.a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();
        int b;
        int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f432d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int[] f433e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f434f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int[] f435g;
        List<d.a> h;
        boolean i;
        boolean j;
        boolean k;

        static class a implements Parcelable.Creator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i) {
                return new e[i];
            }
        }

        public e() {
        }

        e(Parcel parcel) {
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            int i = parcel.readInt();
            this.f432d = i;
            if (i > 0) {
                int[] iArr = new int[i];
                this.f433e = iArr;
                parcel.readIntArray(iArr);
            }
            int i2 = parcel.readInt();
            this.f434f = i2;
            if (i2 > 0) {
                int[] iArr2 = new int[i2];
                this.f435g = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.k = parcel.readInt() == 1;
            this.h = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f432d = eVar.f432d;
            this.b = eVar.b;
            this.c = eVar.c;
            this.f433e = eVar.f433e;
            this.f434f = eVar.f434f;
            this.f435g = eVar.f435g;
            this.i = eVar.i;
            this.j = eVar.j;
            this.k = eVar.k;
            this.h = eVar.h;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        void j() {
            this.f433e = null;
            this.f432d = 0;
            this.b = -1;
            this.c = -1;
        }

        void k() {
            this.f433e = null;
            this.f432d = 0;
            this.f434f = 0;
            this.f435g = null;
            this.h = null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.f432d);
            if (this.f432d > 0) {
                parcel.writeIntArray(this.f433e);
            }
            parcel.writeInt(this.f434f);
            if (this.f434f > 0) {
                parcel.writeIntArray(this.f435g);
            }
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeInt(this.k ? 1 : 0);
            parcel.writeList(this.h);
        }
    }

    class f {
        ArrayList<View> a = new ArrayList<>();
        int b = RecyclerView.UNDEFINED_DURATION;
        int c = RecyclerView.UNDEFINED_DURATION;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f436d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f437e;

        f(int i) {
            this.f437e = i;
        }

        void a(View view) {
            c cVarN = n(view);
            cVarN.f428e = this;
            this.a.add(view);
            this.c = RecyclerView.UNDEFINED_DURATION;
            if (this.a.size() == 1) {
                this.b = RecyclerView.UNDEFINED_DURATION;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f436d += StaggeredGridLayoutManager.this.u.e(view);
            }
        }

        void b(boolean z, int i) {
            int iL = z ? l(RecyclerView.UNDEFINED_DURATION) : p(RecyclerView.UNDEFINED_DURATION);
            e();
            if (iL == Integer.MIN_VALUE) {
                return;
            }
            if (!z || iL >= StaggeredGridLayoutManager.this.u.i()) {
                if (z || iL <= StaggeredGridLayoutManager.this.u.m()) {
                    if (i != Integer.MIN_VALUE) {
                        iL += i;
                    }
                    this.c = iL;
                    this.b = iL;
                }
            }
        }

        void c() {
            d.a aVarF;
            ArrayList<View> arrayList = this.a;
            View view = arrayList.get(arrayList.size() - 1);
            c cVarN = n(view);
            this.c = StaggeredGridLayoutManager.this.u.d(view);
            if (cVarN.f429f && (aVarF = StaggeredGridLayoutManager.this.E.f(cVarN.a())) != null && aVarF.c == 1) {
                this.c += aVarF.j(this.f437e);
            }
        }

        void d() {
            d.a aVarF;
            View view = this.a.get(0);
            c cVarN = n(view);
            this.b = StaggeredGridLayoutManager.this.u.g(view);
            if (cVarN.f429f && (aVarF = StaggeredGridLayoutManager.this.E.f(cVarN.a())) != null && aVarF.c == -1) {
                this.b -= aVarF.j(this.f437e);
            }
        }

        void e() {
            this.a.clear();
            q();
            this.f436d = 0;
        }

        public int f() {
            int size;
            int size2;
            if (StaggeredGridLayoutManager.this.z) {
                size = this.a.size() - 1;
                size2 = -1;
            } else {
                size = 0;
                size2 = this.a.size();
            }
            return i(size, size2, true);
        }

        public int g() {
            int size;
            int size2;
            if (StaggeredGridLayoutManager.this.z) {
                size = 0;
                size2 = this.a.size();
            } else {
                size = this.a.size() - 1;
                size2 = -1;
            }
            return i(size, size2, true);
        }

        int h(int i, int i2, boolean z, boolean z2, boolean z3) {
            int iM = StaggeredGridLayoutManager.this.u.m();
            int i3 = StaggeredGridLayoutManager.this.u.i();
            int i4 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.a.get(i);
                int iG = StaggeredGridLayoutManager.this.u.g(view);
                int iD = StaggeredGridLayoutManager.this.u.d(view);
                boolean z4 = false;
                boolean z5 = !z3 ? iG >= i3 : iG > i3;
                if (!z3 ? iD > iM : iD >= iM) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (iG >= iM && iD <= i3) {
                            return StaggeredGridLayoutManager.this.h0(view);
                        }
                    } else if (z2 || iG < iM || iD > i3) {
                        return StaggeredGridLayoutManager.this.h0(view);
                    }
                }
                i += i4;
            }
            return -1;
        }

        int i(int i, int i2, boolean z) {
            return h(i, i2, false, false, z);
        }

        public int j() {
            return this.f436d;
        }

        int k() {
            int i = this.c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            c();
            return this.c;
        }

        int l(int i) {
            int i2 = this.c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.a.size() == 0) {
                return i;
            }
            c();
            return this.c;
        }

        public View m(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.a.size() - 1;
                while (size >= 0) {
                    View view2 = this.a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.h0(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.h0(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.h0(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.h0(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        c n(View view) {
            return (c) view.getLayoutParams();
        }

        int o() {
            int i = this.b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            d();
            return this.b;
        }

        int p(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.a.size() == 0) {
                return i;
            }
            d();
            return this.b;
        }

        void q() {
            this.b = RecyclerView.UNDEFINED_DURATION;
            this.c = RecyclerView.UNDEFINED_DURATION;
        }

        void r(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                this.b = i2 + i;
            }
            int i3 = this.c;
            if (i3 != Integer.MIN_VALUE) {
                this.c = i3 + i;
            }
        }

        void s() {
            int size = this.a.size();
            View viewRemove = this.a.remove(size - 1);
            c cVarN = n(viewRemove);
            cVarN.f428e = null;
            if (cVarN.c() || cVarN.b()) {
                this.f436d -= StaggeredGridLayoutManager.this.u.e(viewRemove);
            }
            if (size == 1) {
                this.b = RecyclerView.UNDEFINED_DURATION;
            }
            this.c = RecyclerView.UNDEFINED_DURATION;
        }

        void t() {
            View viewRemove = this.a.remove(0);
            c cVarN = n(viewRemove);
            cVarN.f428e = null;
            if (this.a.size() == 0) {
                this.c = RecyclerView.UNDEFINED_DURATION;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f436d -= StaggeredGridLayoutManager.this.u.e(viewRemove);
            }
            this.b = RecyclerView.UNDEFINED_DURATION;
        }

        void u(View view) {
            c cVarN = n(view);
            cVarN.f428e = this;
            this.a.add(0, view);
            this.b = RecyclerView.UNDEFINED_DURATION;
            if (this.a.size() == 1) {
                this.c = RecyclerView.UNDEFINED_DURATION;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f436d += StaggeredGridLayoutManager.this.u.e(view);
            }
        }

        void v(int i) {
            this.b = i;
            this.c = i;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.o.d dVarI0 = RecyclerView.o.i0(context, attributeSet, i, i2);
        H2(dVarI0.a);
        J2(dVarI0.b);
        I2(dVarI0.c);
        this.y = new androidx.recyclerview.widget.f();
        a2();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0010, code lost:
    
        if (r4.f468e == (-1)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A2(RecyclerView.v vVar, androidx.recyclerview.widget.f fVar) {
        int iMin;
        if (!fVar.a || fVar.i) {
            return;
        }
        if (fVar.b != 0) {
            if (fVar.f468e == -1) {
                int i = fVar.f469f;
                int iM2 = i - m2(i);
                int iMin2 = iM2 < 0 ? fVar.f470g : fVar.f470g - Math.min(iM2, fVar.b);
                B2(vVar, iMin2);
                return;
            }
            int iN2 = n2(fVar.f470g) - fVar.f470g;
            if (iN2 < 0) {
                iMin = fVar.f469f;
            } else {
                iMin = Math.min(iN2, fVar.b) + fVar.f469f;
            }
            C2(vVar, iMin);
        }
    }

    private void B2(RecyclerView.v vVar, int i) {
        for (int iJ = J() - 1; iJ >= 0; iJ--) {
            View viewI = I(iJ);
            if (this.u.g(viewI) < i || this.u.q(viewI) < i) {
                return;
            }
            c cVar = (c) viewI.getLayoutParams();
            if (cVar.f429f) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    if (this.t[i2].a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].s();
                }
            } else if (cVar.f428e.a.size() == 1) {
                return;
            } else {
                cVar.f428e.s();
            }
            m1(viewI, vVar);
        }
    }

    private void C2(RecyclerView.v vVar, int i) {
        while (J() > 0) {
            View viewI = I(0);
            if (this.u.d(viewI) > i || this.u.p(viewI) > i) {
                return;
            }
            c cVar = (c) viewI.getLayoutParams();
            if (cVar.f429f) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    if (this.t[i2].a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].t();
                }
            } else if (cVar.f428e.a.size() == 1) {
                return;
            } else {
                cVar.f428e.t();
            }
            m1(viewI, vVar);
        }
    }

    private void D2() {
        if (this.v.k() == 1073741824) {
            return;
        }
        float fMax = 0.0f;
        int iJ = J();
        for (int i = 0; i < iJ; i++) {
            View viewI = I(i);
            float fE = this.v.e(viewI);
            if (fE >= fMax) {
                if (((c) viewI.getLayoutParams()).f()) {
                    fE = (fE * 1.0f) / this.s;
                }
                fMax = Math.max(fMax, fE);
            }
        }
        int i2 = this.x;
        int iRound = Math.round(fMax * this.s);
        if (this.v.k() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.v.n());
        }
        P2(iRound);
        if (this.x == i2) {
            return;
        }
        for (int i3 = 0; i3 < iJ; i3++) {
            View viewI2 = I(i3);
            c cVar = (c) viewI2.getLayoutParams();
            if (!cVar.f429f) {
                if (t2() && this.w == 1) {
                    int i4 = this.s;
                    int i5 = cVar.f428e.f437e;
                    viewI2.offsetLeftAndRight(((-((i4 - 1) - i5)) * this.x) - ((-((i4 - 1) - i5)) * i2));
                } else {
                    int i6 = cVar.f428e.f437e;
                    int i7 = this.w;
                    int i8 = (this.x * i6) - (i6 * i2);
                    if (i7 == 1) {
                        viewI2.offsetLeftAndRight(i8);
                    } else {
                        viewI2.offsetTopAndBottom(i8);
                    }
                }
            }
        }
    }

    private void E2() {
        this.A = (this.w == 1 || !t2()) ? this.z : !this.z;
    }

    private void G2(int i) {
        androidx.recyclerview.widget.f fVar = this.y;
        fVar.f468e = i;
        fVar.f467d = this.A != (i == -1) ? -1 : 1;
    }

    private void K2(int i, int i2) {
        for (int i3 = 0; i3 < this.s; i3++) {
            if (!this.t[i3].a.isEmpty()) {
                Q2(this.t[i3], i, i2);
            }
        }
    }

    private boolean L2(RecyclerView.a0 a0Var, b bVar) {
        boolean z = this.G;
        int iB = a0Var.b();
        bVar.a = z ? g2(iB) : c2(iB);
        bVar.b = RecyclerView.UNDEFINED_DURATION;
        return true;
    }

    private void M1(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].a(view);
        }
    }

    private void N1(b bVar) {
        boolean z;
        e eVar = this.I;
        int i = eVar.f432d;
        if (i > 0) {
            if (i == this.s) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    this.t[i2].e();
                    e eVar2 = this.I;
                    int i3 = eVar2.f433e[i2];
                    if (i3 != Integer.MIN_VALUE) {
                        i3 += eVar2.j ? this.u.i() : this.u.m();
                    }
                    this.t[i2].v(i3);
                }
            } else {
                eVar.k();
                e eVar3 = this.I;
                eVar3.b = eVar3.c;
            }
        }
        e eVar4 = this.I;
        this.H = eVar4.k;
        I2(eVar4.i);
        E2();
        e eVar5 = this.I;
        int i4 = eVar5.b;
        if (i4 != -1) {
            this.C = i4;
            z = eVar5.j;
        } else {
            z = this.A;
        }
        bVar.c = z;
        e eVar6 = this.I;
        if (eVar6.f434f > 1) {
            d dVar = this.E;
            dVar.a = eVar6.f435g;
            dVar.b = eVar6.h;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0036  */
    /* JADX WARN: Code duplicated, block: B:18:0x004d  */
    private void O2(int i, RecyclerView.a0 a0Var) {
        int iN;
        int iN2;
        int iC;
        androidx.recyclerview.widget.f fVar = this.y;
        boolean z = false;
        fVar.b = 0;
        fVar.c = i;
        if (x0() && (iC = a0Var.c()) != -1) {
            if (this.A == (iC < i)) {
                iN = this.u.n();
            } else {
                iN2 = this.u.n();
                iN = 0;
            }
            if (M()) {
                this.y.f469f = this.u.m() - iN2;
                this.y.f470g = this.u.i() + iN;
            } else {
                this.y.f470g = this.u.h() + iN;
                this.y.f469f = -iN2;
            }
            androidx.recyclerview.widget.f fVar2 = this.y;
            fVar2.h = false;
            fVar2.a = true;
            if (this.u.k() == 0 && this.u.h() == 0) {
                z = true;
            }
            fVar2.i = z;
        }
        iN = 0;
        iN2 = 0;
        if (M()) {
            this.y.f469f = this.u.m() - iN2;
            this.y.f470g = this.u.i() + iN;
        } else {
            this.y.f470g = this.u.h() + iN;
            this.y.f469f = -iN2;
        }
        androidx.recyclerview.widget.f fVar3 = this.y;
        fVar3.h = false;
        fVar3.a = true;
        if (this.u.k() == 0) {
            z = true;
        }
        fVar3.i = z;
    }

    private void Q1(View view, c cVar, androidx.recyclerview.widget.f fVar) {
        if (fVar.f468e == 1) {
            if (cVar.f429f) {
                M1(view);
                return;
            } else {
                cVar.f428e.a(view);
                return;
            }
        }
        if (cVar.f429f) {
            z2(view);
        } else {
            cVar.f428e.u(view);
        }
    }

    private void Q2(f fVar, int i, int i2) {
        int iJ = fVar.j();
        if (i == -1) {
            if (fVar.o() + iJ > i2) {
                return;
            }
        } else if (fVar.k() - iJ < i2) {
            return;
        }
        this.B.set(fVar.f437e, false);
    }

    private int R1(int i) {
        if (J() == 0) {
            return this.A ? 1 : -1;
        }
        return (i < j2()) != this.A ? -1 : 1;
    }

    private int R2(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private boolean T1(f fVar) {
        if (this.A) {
            if (fVar.k() < this.u.i()) {
                ArrayList<View> arrayList = fVar.a;
                return !fVar.n(arrayList.get(arrayList.size() - 1)).f429f;
            }
        } else if (fVar.o() > this.u.m()) {
            return !fVar.n(fVar.a.get(0)).f429f;
        }
        return false;
    }

    private int U1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return l.a(a0Var, this.u, e2(!this.N), d2(!this.N), this, this.N);
    }

    private int V1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return l.b(a0Var, this.u, e2(!this.N), d2(!this.N), this, this.N, this.A);
    }

    private int W1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return l.c(a0Var, this.u, e2(!this.N), d2(!this.N), this, this.N);
    }

    private int X1(int i) {
        if (i == 1) {
            return (this.w != 1 && t2()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.w != 1 && t2()) ? -1 : 1;
        }
        if (i == 17) {
            if (this.w == 0) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i == 33) {
            if (this.w == 1) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i == 66) {
            if (this.w == 0) {
                return 1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i == 130 && this.w == 1) {
            return 1;
        }
        return RecyclerView.UNDEFINED_DURATION;
    }

    private d.a Y1(int i) {
        d.a aVar = new d.a();
        aVar.f430d = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            aVar.f430d[i2] = i - this.t[i2].l(i);
        }
        return aVar;
    }

    private d.a Z1(int i) {
        d.a aVar = new d.a();
        aVar.f430d = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            aVar.f430d[i2] = this.t[i2].p(i) - i;
        }
        return aVar;
    }

    private void a2() {
        this.u = j.b(this, this.w);
        this.v = j.b(this, 1 - this.w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int b2(RecyclerView.v vVar, androidx.recyclerview.widget.f fVar, RecyclerView.a0 a0Var) {
        int i;
        int iL2;
        f fVarP2;
        int iE;
        int i2;
        int iE2;
        int iE3;
        int i3;
        int i4;
        ?? r9 = 0;
        this.B.set(0, this.s, true);
        if (this.y.i) {
            i = fVar.f468e == 1 ? Integer.MAX_VALUE : RecyclerView.UNDEFINED_DURATION;
        } else {
            i = fVar.f468e == 1 ? fVar.f470g + fVar.b : fVar.f469f - fVar.b;
        }
        K2(fVar.f468e, i);
        int i5 = this.A ? this.u.i() : this.u.m();
        boolean z = false;
        while (fVar.a(a0Var) && (this.y.i || !this.B.isEmpty())) {
            View viewB = fVar.b(vVar);
            c cVar = (c) viewB.getLayoutParams();
            int iA = cVar.a();
            int iG = this.E.g(iA);
            boolean z2 = iG == -1;
            if (z2) {
                fVarP2 = cVar.f429f ? this.t[r9] : p2(fVar);
                this.E.n(iA, fVarP2);
            } else {
                fVarP2 = this.t[iG];
            }
            f fVar2 = fVarP2;
            cVar.f428e = fVar2;
            if (fVar.f468e == 1) {
                d(viewB);
            } else {
                e(viewB, r9);
            }
            v2(viewB, cVar, r9);
            if (fVar.f468e == 1) {
                int iL3 = cVar.f429f ? l2(i5) : fVar2.l(i5);
                int iE4 = this.u.e(viewB) + iL3;
                if (z2 && cVar.f429f) {
                    d.a aVarY1 = Y1(iL3);
                    aVarY1.c = -1;
                    aVarY1.b = iA;
                    this.E.a(aVarY1);
                }
                i2 = iE4;
                iE = iL3;
            } else {
                int iO2 = cVar.f429f ? o2(i5) : fVar2.p(i5);
                iE = iO2 - this.u.e(viewB);
                if (z2 && cVar.f429f) {
                    d.a aVarZ1 = Z1(iO2);
                    aVarZ1.c = 1;
                    aVarZ1.b = iA;
                    this.E.a(aVarZ1);
                }
                i2 = iO2;
            }
            if (cVar.f429f && fVar.f467d == -1) {
                if (z2) {
                    this.M = true;
                } else {
                    if (!(fVar.f468e == 1 ? O1() : P1())) {
                        d.a aVarF = this.E.f(iA);
                        if (aVarF != null) {
                            aVarF.f431e = true;
                        }
                        this.M = true;
                    }
                }
            }
            Q1(viewB, cVar, fVar);
            if (t2() && this.w == 1) {
                int i6 = cVar.f429f ? this.v.i() : this.v.i() - (((this.s - 1) - fVar2.f437e) * this.x);
                iE3 = i6;
                iE2 = i6 - this.v.e(viewB);
            } else {
                int iM = cVar.f429f ? this.v.m() : (fVar2.f437e * this.x) + this.v.m();
                iE2 = iM;
                iE3 = this.v.e(viewB) + iM;
            }
            if (this.w == 1) {
                i3 = iE2;
                iE2 = iE;
                i4 = iE3;
            } else {
                i3 = iE;
                i4 = i2;
                i2 = iE3;
            }
            z0(viewB, i3, iE2, i4, i2);
            if (cVar.f429f) {
                K2(this.y.f468e, i);
            } else {
                Q2(fVar2, this.y.f468e, i);
            }
            A2(vVar, this.y);
            if (this.y.h && viewB.hasFocusable()) {
                if (cVar.f429f) {
                    this.B.clear();
                } else {
                    this.B.set(fVar2.f437e, false);
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            A2(vVar, this.y);
        }
        if (this.y.f468e == -1) {
            iL2 = this.u.m() - o2(this.u.m());
        } else {
            iL2 = l2(this.u.i()) - this.u.i();
        }
        if (iL2 > 0) {
            return Math.min(fVar.b, iL2);
        }
        return 0;
    }

    private int c2(int i) {
        int iJ = J();
        for (int i2 = 0; i2 < iJ; i2++) {
            int iH0 = h0(I(i2));
            if (iH0 >= 0 && iH0 < i) {
                return iH0;
            }
        }
        return 0;
    }

    private int g2(int i) {
        for (int iJ = J() - 1; iJ >= 0; iJ--) {
            int iH0 = h0(I(iJ));
            if (iH0 >= 0 && iH0 < i) {
                return iH0;
            }
        }
        return 0;
    }

    private void h2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int i;
        int iL2 = l2(RecyclerView.UNDEFINED_DURATION);
        if (iL2 != Integer.MIN_VALUE && (i = this.u.i() - iL2) > 0) {
            int i2 = i - (-F2(-i, vVar, a0Var));
            if (!z || i2 <= 0) {
                return;
            }
            this.u.r(i2);
        }
    }

    private void i2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int iM;
        int iO2 = o2(Integer.MAX_VALUE);
        if (iO2 != Integer.MAX_VALUE && (iM = iO2 - this.u.m()) > 0) {
            int iF2 = iM - F2(iM, vVar, a0Var);
            if (!z || iF2 <= 0) {
                return;
            }
            this.u.r(-iF2);
        }
    }

    private int l2(int i) {
        int iL = this.t[0].l(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int iL2 = this.t[i2].l(i);
            if (iL2 > iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    private int m2(int i) {
        int iP = this.t[0].p(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int iP2 = this.t[i2].p(i);
            if (iP2 > iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    private int n2(int i) {
        int iL = this.t[0].l(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int iL2 = this.t[i2].l(i);
            if (iL2 < iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    private int o2(int i) {
        int iP = this.t[0].p(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int iP2 = this.t[i2].p(i);
            if (iP2 < iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    private f p2(androidx.recyclerview.widget.f fVar) {
        int i;
        int i2;
        int i3 = -1;
        if (x2(fVar.f468e)) {
            i = this.s - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.s;
            i2 = 1;
        }
        f fVar2 = null;
        if (fVar.f468e == 1) {
            int i4 = Integer.MAX_VALUE;
            int iM = this.u.m();
            while (i != i3) {
                f fVar3 = this.t[i];
                int iL = fVar3.l(iM);
                if (iL < i4) {
                    fVar2 = fVar3;
                    i4 = iL;
                }
                i += i2;
            }
            return fVar2;
        }
        int i5 = RecyclerView.UNDEFINED_DURATION;
        int i6 = this.u.i();
        while (i != i3) {
            f fVar4 = this.t[i];
            int iP = fVar4.p(i6);
            if (iP > i5) {
                fVar2 = fVar4;
                i5 = iP;
            }
            i += i2;
        }
        return fVar2;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0025  */
    /* JADX WARN: Code duplicated, block: B:17:0x0028 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    /* JADX WARN: Code duplicated, block: B:20:0x0036  */
    /* JADX WARN: Code duplicated, block: B:21:0x003c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0044  */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x004d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    private void q2(int i, int i2, int i3) {
        int i4;
        int i5;
        int iK2;
        int iK3 = this.A ? k2() : j2();
        if (i3 == 8) {
            if (i < i2) {
                i4 = i2 + 1;
            } else {
                i4 = i + 1;
                i5 = i2;
            }
            this.E.h(i5);
            if (i3 != 1) {
                this.E.j(i, i2);
            } else if (i3 != 2) {
                this.E.k(i, i2);
            } else if (i3 == 8) {
                this.E.k(i, 1);
                this.E.j(i2, 1);
            }
            if (i4 <= iK3) {
                return;
            }
            if (this.A) {
                iK2 = j2();
            } else {
                iK2 = k2();
            }
            if (i5 <= iK2) {
                t1();
            }
        }
        i4 = i + i2;
        i5 = i;
        this.E.h(i5);
        if (i3 != 1) {
            this.E.j(i, i2);
        } else if (i3 != 2) {
            this.E.k(i, i2);
        } else if (i3 == 8) {
            this.E.k(i, 1);
            this.E.j(i2, 1);
        }
        if (i4 <= iK3) {
            return;
        }
        if (this.A) {
            iK2 = j2();
        } else {
            iK2 = k2();
        }
        if (i5 <= iK2) {
            t1();
        }
    }

    private void u2(View view, int i, int i2, boolean z) {
        j(view, this.K);
        c cVar = (c) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.K;
        int iR2 = R2(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.K;
        int iR3 = R2(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z ? H1(view, iR2, iR3, cVar) : F1(view, iR2, iR3, cVar)) {
            view.measure(iR2, iR3);
        }
    }

    private void v2(View view, c cVar, boolean z) {
        int iK;
        int iK2;
        if (!cVar.f429f) {
            if (this.w == 1) {
                iK = RecyclerView.o.K(this.x, p0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false);
            } else {
                iK = RecyclerView.o.K(o0(), p0(), e0() + f0(), ((ViewGroup.MarginLayoutParams) cVar).width, true);
                iK2 = RecyclerView.o.K(this.x, X(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false);
            }
            u2(view, iK, iK2, z);
        }
        if (this.w != 1) {
            u2(view, RecyclerView.o.K(o0(), p0(), e0() + f0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.J, z);
            return;
        }
        iK = this.J;
        iK2 = RecyclerView.o.K(W(), X(), g0() + d0(), ((ViewGroup.MarginLayoutParams) cVar).height, true);
        u2(view, iK, iK2, z);
    }

    /* JADX WARN: Code duplicated, block: B:89:0x014e  */
    private void w2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        boolean z2;
        e eVar;
        b bVar = this.L;
        if (!(this.I == null && this.C == -1) && a0Var.b() == 0) {
            k1(vVar);
            bVar.c();
            return;
        }
        boolean z3 = (bVar.f425e && this.C == -1 && this.I == null) ? false : true;
        if (z3) {
            bVar.c();
            if (this.I != null) {
                N1(bVar);
            } else {
                E2();
                bVar.c = this.A;
            }
            N2(a0Var, bVar);
            bVar.f425e = true;
        }
        if (this.I == null && this.C == -1 && (bVar.c != this.G || t2() != this.H)) {
            this.E.b();
            bVar.f424d = true;
        }
        if (J() > 0 && ((eVar = this.I) == null || eVar.f432d < 1)) {
            if (bVar.f424d) {
                for (int i = 0; i < this.s; i++) {
                    this.t[i].e();
                    int i2 = bVar.b;
                    if (i2 != Integer.MIN_VALUE) {
                        this.t[i].v(i2);
                    }
                }
            } else if (z3 || this.L.f426f == null) {
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].b(this.A, bVar.b);
                }
                this.L.d(this.t);
            } else {
                for (int i4 = 0; i4 < this.s; i4++) {
                    f fVar = this.t[i4];
                    fVar.e();
                    fVar.v(this.L.f426f[i4]);
                }
            }
        }
        w(vVar);
        this.y.a = false;
        this.M = false;
        P2(this.v.n());
        O2(bVar.a, a0Var);
        if (bVar.c) {
            G2(-1);
            b2(vVar, this.y, a0Var);
            G2(1);
        } else {
            G2(1);
            b2(vVar, this.y, a0Var);
            G2(-1);
        }
        androidx.recyclerview.widget.f fVar2 = this.y;
        fVar2.c = bVar.a + fVar2.f467d;
        b2(vVar, fVar2, a0Var);
        D2();
        if (J() > 0) {
            if (this.A) {
                h2(vVar, a0Var, true);
                i2(vVar, a0Var, false);
            } else {
                i2(vVar, a0Var, true);
                h2(vVar, a0Var, false);
            }
        }
        if (z && !a0Var.e()) {
            if (this.F != 0 && J() > 0 && (this.M || r2() != null)) {
                o1(this.P);
                z2 = S1();
            }
        }
        if (a0Var.e()) {
            this.L.c();
        }
        this.G = bVar.c;
        this.H = t2();
        if (z2) {
            this.L.c();
            w2(vVar, a0Var, false);
        }
    }

    private boolean x2(int i) {
        if (this.w == 0) {
            return (i == -1) != this.A;
        }
        return ((i == -1) == this.A) == t2();
    }

    private void z2(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].u(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C0(int i) {
        super.C0(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].r(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C1(Rect rect, int i, int i2) {
        int iN;
        int iN2;
        int iE0 = e0() + f0();
        int iG0 = g0() + d0();
        if (this.w == 1) {
            iN2 = RecyclerView.o.n(i2, rect.height() + iG0, b0());
            iN = RecyclerView.o.n(i, (this.x * this.s) + iE0, c0());
        } else {
            iN = RecyclerView.o.n(i, rect.width() + iE0, c0());
            iN2 = RecyclerView.o.n(i2, (this.x * this.s) + iG0, b0());
        }
        B1(iN, iN2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return this.w == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D0(int i) {
        super.D0(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].r(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    int F2(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (J() == 0 || i == 0) {
            return 0;
        }
        y2(i, a0Var);
        int iB2 = b2(vVar, this.y, a0Var);
        if (this.y.b >= iB2) {
            i = i < 0 ? -iB2 : iB2;
        }
        this.u.r(-i);
        this.G = this.A;
        androidx.recyclerview.widget.f fVar = this.y;
        fVar.b = 0;
        A2(vVar, fVar);
        return i;
    }

    public void H2(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        g(null);
        if (i == this.w) {
            return;
        }
        this.w = i;
        j jVar = this.u;
        this.u = this.v;
        this.v = jVar;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.I0(recyclerView, vVar);
        o1(this.P);
        for (int i = 0; i < this.s; i++) {
            this.t[i].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I1(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i) {
        g gVar = new g(recyclerView.getContext());
        gVar.p(i);
        J1(gVar);
    }

    public void I2(boolean z) {
        g(null);
        e eVar = this.I;
        if (eVar != null && eVar.i != z) {
            eVar.i = z;
        }
        this.z = z;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View J0(View view, int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View viewB;
        View viewM;
        if (J() == 0 || (viewB = B(view)) == null) {
            return null;
        }
        E2();
        int iX1 = X1(i);
        if (iX1 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) viewB.getLayoutParams();
        boolean z = cVar.f429f;
        f fVar = cVar.f428e;
        int iK2 = iX1 == 1 ? k2() : j2();
        O2(iK2, a0Var);
        G2(iX1);
        androidx.recyclerview.widget.f fVar2 = this.y;
        fVar2.c = fVar2.f467d + iK2;
        fVar2.b = (int) (this.u.n() * 0.33333334f);
        androidx.recyclerview.widget.f fVar3 = this.y;
        fVar3.h = true;
        fVar3.a = false;
        b2(vVar, fVar3, a0Var);
        this.G = this.A;
        if (!z && (viewM = fVar.m(iK2, iX1)) != null && viewM != viewB) {
            return viewM;
        }
        if (x2(iX1)) {
            for (int i2 = this.s - 1; i2 >= 0; i2--) {
                View viewM2 = this.t[i2].m(iK2, iX1);
                if (viewM2 != null && viewM2 != viewB) {
                    return viewM2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.s; i3++) {
                View viewM3 = this.t[i3].m(iK2, iX1);
                if (viewM3 != null && viewM3 != viewB) {
                    return viewM3;
                }
            }
        }
        boolean z2 = (this.z ^ true) == (iX1 == -1);
        if (!z) {
            View viewC = C(z2 ? fVar.f() : fVar.g());
            if (viewC != null && viewC != viewB) {
                return viewC;
            }
        }
        if (x2(iX1)) {
            for (int i4 = this.s - 1; i4 >= 0; i4--) {
                if (i4 != fVar.f437e) {
                    f[] fVarArr = this.t;
                    View viewC2 = C(z2 ? fVarArr[i4].f() : fVarArr[i4].g());
                    if (viewC2 != null && viewC2 != viewB) {
                        return viewC2;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.s; i5++) {
                f[] fVarArr2 = this.t;
                View viewC3 = C(z2 ? fVarArr2[i5].f() : fVarArr2[i5].g());
                if (viewC3 != null && viewC3 != viewB) {
                    return viewC3;
                }
            }
        }
        return null;
    }

    public void J2(int i) {
        g(null);
        if (i != this.s) {
            s2();
            this.s = i;
            this.B = new BitSet(this.s);
            this.t = new f[this.s];
            for (int i2 = 0; i2 < this.s; i2++) {
                this.t[i2] = new f(i2);
            }
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(AccessibilityEvent accessibilityEvent) {
        super.K0(accessibilityEvent);
        if (J() > 0) {
            View viewE2 = e2(false);
            View viewD2 = d2(false);
            if (viewE2 == null || viewD2 == null) {
                return;
            }
            int iH0 = h0(viewE2);
            int iH1 = h0(viewD2);
            if (iH0 < iH1) {
                accessibilityEvent.setFromIndex(iH0);
                accessibilityEvent.setToIndex(iH1);
            } else {
                accessibilityEvent.setFromIndex(iH1);
                accessibilityEvent.setToIndex(iH0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.I == null;
    }

    boolean M2(RecyclerView.a0 a0Var, b bVar) {
        int i;
        int iM;
        int iG;
        if (!a0Var.e() && (i = this.C) != -1) {
            if (i >= 0 && i < a0Var.b()) {
                e eVar = this.I;
                if (eVar == null || eVar.b == -1 || eVar.f432d < 1) {
                    View viewC = C(this.C);
                    if (viewC != null) {
                        bVar.a = this.A ? k2() : j2();
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.c) {
                                iM = this.u.i() - this.D;
                                iG = this.u.d(viewC);
                            } else {
                                iM = this.u.m() + this.D;
                                iG = this.u.g(viewC);
                            }
                            bVar.b = iM - iG;
                            return true;
                        }
                        if (this.u.e(viewC) > this.u.n()) {
                            bVar.b = bVar.c ? this.u.i() : this.u.m();
                            return true;
                        }
                        int iG2 = this.u.g(viewC) - this.u.m();
                        if (iG2 < 0) {
                            bVar.b = -iG2;
                            return true;
                        }
                        int i2 = this.u.i() - this.u.d(viewC);
                        if (i2 < 0) {
                            bVar.b = i2;
                            return true;
                        }
                        bVar.b = RecyclerView.UNDEFINED_DURATION;
                    } else {
                        int i3 = this.C;
                        bVar.a = i3;
                        int i4 = this.D;
                        if (i4 == Integer.MIN_VALUE) {
                            bVar.c = R1(i3) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i4);
                        }
                        bVar.f424d = true;
                    }
                } else {
                    bVar.b = RecyclerView.UNDEFINED_DURATION;
                    bVar.a = this.C;
                }
                return true;
            }
            this.C = -1;
            this.D = RecyclerView.UNDEFINED_DURATION;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int N(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.w == 1 ? this.s : super.N(vVar, a0Var);
    }

    void N2(RecyclerView.a0 a0Var, b bVar) {
        if (M2(a0Var, bVar) || L2(a0Var, bVar)) {
            return;
        }
        bVar.a();
        bVar.a = 0;
    }

    boolean O1() {
        int iL = this.t[0].l(RecyclerView.UNDEFINED_DURATION);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].l(RecyclerView.UNDEFINED_DURATION) != iL) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void P0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, d.f.k.a0.c cVar) {
        int iE;
        int i;
        int iE2;
        int i2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.O0(view, cVar);
            return;
        }
        c cVar2 = (c) layoutParams;
        if (this.w == 0) {
            iE = cVar2.e();
            i = cVar2.f429f ? this.s : 1;
            iE2 = -1;
            i2 = -1;
        } else {
            iE = -1;
            i = -1;
            iE2 = cVar2.e();
            i2 = cVar2.f429f ? this.s : 1;
        }
        cVar.Y(d.f.k.a0.c.C0052c.a(iE, i, iE2, i2, false, false));
    }

    boolean P1() {
        int iP = this.t[0].p(RecyclerView.UNDEFINED_DURATION);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].p(RecyclerView.UNDEFINED_DURATION) != iP) {
                return false;
            }
        }
        return true;
    }

    void P2(int i) {
        this.x = i / this.s;
        this.J = View.MeasureSpec.makeMeasureSpec(i, this.v.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R0(RecyclerView recyclerView, int i, int i2) {
        q2(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView) {
        this.E.b();
        t1();
    }

    boolean S1() {
        int iJ2;
        int iK2;
        if (J() == 0 || this.F == 0 || !r0()) {
            return false;
        }
        if (this.A) {
            iJ2 = k2();
            iK2 = j2();
        } else {
            iJ2 = j2();
            iK2 = k2();
        }
        if (iJ2 == 0 && r2() != null) {
            this.E.b();
        } else {
            if (!this.M) {
                return false;
            }
            int i = this.A ? -1 : 1;
            int i2 = iK2 + 1;
            d.a aVarE = this.E.e(iJ2, i2, i, true);
            if (aVarE == null) {
                this.M = false;
                this.E.d(i2);
                return false;
            }
            d.a aVarE2 = this.E.e(iJ2, aVarE.b, i * (-1), true);
            if (aVarE2 == null) {
                this.E.d(aVarE.b);
            } else {
                this.E.d(aVarE2.b + 1);
            }
        }
        u1();
        t1();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView, int i, int i2, int i3) {
        q2(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, int i, int i2) {
        q2(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView recyclerView, int i, int i2, Object obj) {
        q2(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        w2(vVar, a0Var, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.a0 a0Var) {
        super.Y0(a0Var);
        this.C = -1;
        this.D = RecyclerView.UNDEFINED_DURATION;
        this.I = null;
        this.L.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i) {
        int iR1 = R1(i);
        PointF pointF = new PointF();
        if (iR1 == 0) {
            return null;
        }
        if (this.w == 0) {
            pointF.x = iR1;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iR1;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.I = (e) parcelable;
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable d1() {
        int iP;
        int iM;
        int[] iArr;
        if (this.I != null) {
            return new e(this.I);
        }
        e eVar = new e();
        eVar.i = this.z;
        eVar.j = this.G;
        eVar.k = this.H;
        d dVar = this.E;
        if (dVar == null || (iArr = dVar.a) == null) {
            eVar.f434f = 0;
        } else {
            eVar.f435g = iArr;
            eVar.f434f = iArr.length;
            eVar.h = dVar.b;
        }
        if (J() > 0) {
            eVar.b = this.G ? k2() : j2();
            eVar.c = f2();
            int i = this.s;
            eVar.f432d = i;
            eVar.f433e = new int[i];
            for (int i2 = 0; i2 < this.s; i2++) {
                if (this.G) {
                    iP = this.t[i2].l(RecyclerView.UNDEFINED_DURATION);
                    if (iP != Integer.MIN_VALUE) {
                        iM = this.u.i();
                        iP -= iM;
                    }
                } else {
                    iP = this.t[i2].p(RecyclerView.UNDEFINED_DURATION);
                    if (iP != Integer.MIN_VALUE) {
                        iM = this.u.m();
                        iP -= iM;
                    }
                }
                eVar.f433e[i2] = iP;
            }
        } else {
            eVar.b = -1;
            eVar.c = -1;
            eVar.f432d = 0;
        }
        return eVar;
    }

    View d2(boolean z) {
        int iM = this.u.m();
        int i = this.u.i();
        View view = null;
        for (int iJ = J() - 1; iJ >= 0; iJ--) {
            View viewI = I(iJ);
            int iG = this.u.g(viewI);
            int iD = this.u.d(viewI);
            if (iD > iM && iG < i) {
                if (iD <= i || !z) {
                    return viewI;
                }
                if (view == null) {
                    view = viewI;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void e1(int i) {
        if (i == 0) {
            S1();
        }
    }

    View e2(boolean z) {
        int iM = this.u.m();
        int i = this.u.i();
        int iJ = J();
        View view = null;
        for (int i2 = 0; i2 < iJ; i2++) {
            View viewI = I(i2);
            int iG = this.u.g(viewI);
            if (this.u.d(viewI) > iM && iG < i) {
                if (iG >= iM || !z) {
                    return viewI;
                }
                if (view == null) {
                    view = viewI;
                }
            }
        }
        return view;
    }

    int f2() {
        View viewD2 = this.A ? d2(true) : e2(true);
        if (viewD2 == null) {
            return -1;
        }
        return h0(viewD2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.I == null) {
            super.g(str);
        }
    }

    int j2() {
        if (J() == 0) {
            return 0;
        }
        return h0(I(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.w == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int k0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.w == 0 ? this.s : super.k0(vVar, a0Var);
    }

    int k2() {
        int iJ = J();
        if (iJ == 0) {
            return 0;
        }
        return h0(I(iJ - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i, int i2, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        int iL;
        int iP;
        if (this.w != 0) {
            i = i2;
        }
        if (J() == 0 || i == 0) {
            return;
        }
        y2(i, a0Var);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.s) {
            this.O = new int[this.s];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.s; i4++) {
            androidx.recyclerview.widget.f fVar = this.y;
            if (fVar.f467d == -1) {
                iL = fVar.f469f;
                iP = this.t[i4].p(iL);
            } else {
                iL = this.t[i4].l(fVar.f470g);
                iP = this.y.f470g;
            }
            int i5 = iL - iP;
            if (i5 >= 0) {
                this.O[i3] = i5;
                i3++;
            }
        }
        Arrays.sort(this.O, 0, i3);
        for (int i6 = 0; i6 < i3 && this.y.a(a0Var); i6++) {
            cVar.a(this.y.c, this.O[i6]);
            androidx.recyclerview.widget.f fVar2 = this.y;
            fVar2.c += fVar2.f467d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.a0 a0Var) {
        return U1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return V1(a0Var);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0088  */
    /* JADX WARN: Code duplicated, block: B:38:0x008a  */
    View r2() {
        int i;
        int i2;
        boolean z;
        int iJ = J() - 1;
        BitSet bitSet = new BitSet(this.s);
        bitSet.set(0, this.s, true);
        byte b2 = (this.w == 1 && t2()) ? (byte) 1 : (byte) -1;
        if (this.A) {
            i = -1;
        } else {
            i = iJ + 1;
            iJ = 0;
        }
        int i3 = iJ < i ? 1 : -1;
        while (iJ != i) {
            View viewI = I(iJ);
            c cVar = (c) viewI.getLayoutParams();
            if (bitSet.get(cVar.f428e.f437e)) {
                if (T1(cVar.f428e)) {
                    return viewI;
                }
                bitSet.clear(cVar.f428e.f437e);
            }
            if (!cVar.f429f && (i2 = iJ + i3) != i) {
                View viewI2 = I(i2);
                if (this.A) {
                    int iD = this.u.d(viewI);
                    int iD2 = this.u.d(viewI2);
                    if (iD < iD2) {
                        return viewI;
                    }
                    if (iD == iD2) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    int iG = this.u.g(viewI);
                    int iG2 = this.u.g(viewI2);
                    if (iG > iG2) {
                        return viewI;
                    }
                    if (iG == iG2) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    if ((cVar.f428e.f437e - ((c) viewI2.getLayoutParams()).f428e.f437e < 0) != (b2 < 0)) {
                        return viewI;
                    }
                } else {
                    continue;
                }
            }
            iJ += i3;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return W1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean s0() {
        return this.F != 0;
    }

    public void s2() {
        this.E.b();
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.a0 a0Var) {
        return U1(a0Var);
    }

    boolean t2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return V1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return W1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return F2(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int i) {
        e eVar = this.I;
        if (eVar != null && eVar.b != i) {
            eVar.j();
        }
        this.C = i;
        this.D = RecyclerView.UNDEFINED_DURATION;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return F2(i, vVar, a0Var);
    }

    void y2(int i, RecyclerView.a0 a0Var) {
        int iJ2;
        int i2;
        if (i > 0) {
            iJ2 = k2();
            i2 = 1;
        } else {
            iJ2 = j2();
            i2 = -1;
        }
        this.y.a = true;
        O2(iJ2, a0Var);
        G2(i2);
        androidx.recyclerview.widget.f fVar = this.y;
        fVar.c = iJ2 + fVar.f467d;
        fVar.b = Math.abs(i);
    }
}
