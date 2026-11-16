package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class e implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final ThreadLocal<e> f460f = new ThreadLocal<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static Comparator<c> f461g = new a();
    long c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f462d;
    ArrayList<RecyclerView> b = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<c> f463e = new ArrayList<>();

    static class a implements Comparator<c> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            if ((cVar.f465d == null) != (cVar2.f465d == null)) {
                return cVar.f465d == null ? 1 : -1;
            }
            boolean z = cVar.a;
            if (z != cVar2.a) {
                return z ? -1 : 1;
            }
            int i = cVar2.b - cVar.b;
            if (i != 0) {
                return i;
            }
            int i2 = cVar.c - cVar2.c;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    }

    @SuppressLint({"VisibleForTests"})
    static class b implements RecyclerView.o.c {
        int a;
        int b;
        int[] c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f464d;

        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.f464d * 2;
            int[] iArr = this.c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[i3 * 2];
                this.c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.c;
            iArr4[i3] = i;
            iArr4[i3 + 1] = i2;
            this.f464d++;
        }

        void b() {
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f464d = 0;
        }

        void c(RecyclerView recyclerView, boolean z) {
            this.f464d = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || oVar == null || !oVar.u0()) {
                return;
            }
            if (z) {
                if (!recyclerView.mAdapterHelper.p()) {
                    oVar.p(recyclerView.mAdapter.c(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                oVar.o(this.a, this.b, recyclerView.mState, this);
            }
            int i = this.f464d;
            if (i > oVar.m) {
                oVar.m = i;
                oVar.n = z;
                recyclerView.mRecycler.K();
            }
        }

        boolean d(int i) {
            if (this.c != null) {
                int i2 = this.f464d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    static class c {
        public boolean a;
        public int b;
        public int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f465d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f466e;

        c() {
        }

        public void a() {
            this.a = false;
            this.b = 0;
            this.c = 0;
            this.f465d = null;
            this.f466e = 0;
        }
    }

    e() {
    }

    private void b() {
        c cVar;
        int size = this.b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.b.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.c(recyclerView, false);
                i += recyclerView.mPrefetchRegistry.f464d;
            }
        }
        this.f463e.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.b.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.mPrefetchRegistry;
                int iAbs = Math.abs(bVar.a) + Math.abs(bVar.b);
                for (int i5 = 0; i5 < bVar.f464d * 2; i5 += 2) {
                    if (i3 >= this.f463e.size()) {
                        cVar = new c();
                        this.f463e.add(cVar);
                    } else {
                        cVar = this.f463e.get(i3);
                    }
                    int i6 = bVar.c[i5 + 1];
                    cVar.a = i6 <= iAbs;
                    cVar.b = iAbs;
                    cVar.c = i6;
                    cVar.f465d = recyclerView2;
                    cVar.f466e = bVar.c[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.f463e, f461g);
    }

    private void c(c cVar, long j) {
        RecyclerView.d0 d0VarI = i(cVar.f465d, cVar.f466e, cVar.a ? Long.MAX_VALUE : j);
        if (d0VarI == null || d0VarI.b == null || !d0VarI.s() || d0VarI.t()) {
            return;
        }
        h(d0VarI.b.get(), j);
    }

    private void d(long j) {
        for (int i = 0; i < this.f463e.size(); i++) {
            c cVar = this.f463e.get(i);
            if (cVar.f465d == null) {
                return;
            }
            c(cVar, j);
            cVar.a();
        }
    }

    static boolean e(RecyclerView recyclerView, int i) {
        int iJ = recyclerView.mChildHelper.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.i(i2));
            if (childViewHolderInt.c == i && !childViewHolderInt.t()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.j() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        b bVar = recyclerView.mPrefetchRegistry;
        bVar.c(recyclerView, true);
        if (bVar.f464d != 0) {
            try {
                d.f.g.b.a("RV Nested Prefetch");
                recyclerView.mState.f(recyclerView.mAdapter);
                for (int i = 0; i < bVar.f464d * 2; i += 2) {
                    i(recyclerView, bVar.c[i], j);
                }
                d.f.g.b.b();
            } catch (Throwable th) {
                d.f.g.b.b();
                throw th;
            }
        }
    }

    private RecyclerView.d0 i(RecyclerView recyclerView, int i, long j) {
        if (e(recyclerView, i)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.d0 d0VarI = vVar.I(i, false, j);
            if (d0VarI != null) {
                if (!d0VarI.s() || d0VarI.t()) {
                    vVar.a(d0VarI, false);
                } else {
                    vVar.B(d0VarI.a);
                }
            }
            return d0VarI;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.b.add(recyclerView);
    }

    void f(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.c == 0) {
            this.c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.e(i, i2);
    }

    void g(long j) {
        b();
        d(j);
    }

    public void j(RecyclerView recyclerView) {
        this.b.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            d.f.g.b.a("RV Prefetch");
            if (!this.b.isEmpty()) {
                int size = this.b.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.b.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f462d);
                }
            }
        } finally {
            this.c = 0L;
            d.f.g.b.b();
        }
    }
}
