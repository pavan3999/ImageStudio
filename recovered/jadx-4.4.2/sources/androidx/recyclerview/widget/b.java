package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class b {
    final InterfaceC0016b a;
    final a b = new a();
    final List<View> c = new ArrayList();

    static class a {
        long a = 0;
        a b;

        a() {
        }

        private void c() {
            if (this.b == null) {
                this.b = new a();
            }
        }

        void a(int i) {
            if (i < 64) {
                this.a &= (1 << i) ^ (-1);
                return;
            }
            a aVar = this.b;
            if (aVar != null) {
                aVar.a(i - 64);
            }
        }

        int b(int i) {
            a aVar = this.b;
            if (aVar == null) {
                return i >= 64 ? Long.bitCount(this.a) : Long.bitCount(this.a & ((1 << i) - 1));
            }
            return i < 64 ? Long.bitCount(this.a & ((1 << i) - 1)) : aVar.b(i - 64) + Long.bitCount(this.a);
        }

        boolean d(int i) {
            if (i < 64) {
                return (this.a & (1 << i)) != 0;
            }
            c();
            return this.b.d(i - 64);
        }

        void e(int i, boolean z) {
            if (i >= 64) {
                c();
                this.b.e(i - 64, z);
                return;
            }
            boolean z2 = (this.a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.a;
            this.a = ((j2 & (j ^ (-1))) << 1) | (j2 & j);
            if (z) {
                h(i);
            } else {
                a(i);
            }
            if (z2 || this.b != null) {
                c();
                this.b.e(0, z2);
            }
        }

        boolean f(int i) {
            if (i >= 64) {
                c();
                return this.b.f(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.a & j) != 0;
            long j2 = this.a & (j ^ (-1));
            this.a = j2;
            long j3 = j - 1;
            this.a = (j2 & j3) | Long.rotateRight((j3 ^ (-1)) & j2, 1);
            a aVar = this.b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.b.f(0);
            }
            return z;
        }

        void g() {
            this.a = 0L;
            a aVar = this.b;
            if (aVar != null) {
                aVar.g();
            }
        }

        void h(int i) {
            if (i < 64) {
                this.a |= 1 << i;
            } else {
                c();
                this.b.h(i - 64);
            }
        }

        public String toString() {
            if (this.b == null) {
                return Long.toBinaryString(this.a);
            }
            return this.b.toString() + "xx" + Long.toBinaryString(this.a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    interface InterfaceC0016b {
        View a(int i);

        void b(int i);

        void c(View view);

        void d(View view, int i, ViewGroup.LayoutParams layoutParams);

        void e(View view);

        void f(View view, int i);

        int g(View view);

        int h();

        void i(int i);

        void j();

        RecyclerView.d0 k(View view);
    }

    b(InterfaceC0016b interfaceC0016b) {
        this.a = interfaceC0016b;
    }

    private int h(int i) {
        if (i < 0) {
            return -1;
        }
        int iH = this.a.h();
        int i2 = i;
        while (i2 < iH) {
            int iB = i - (i2 - this.b.b(i2));
            if (iB == 0) {
                while (this.b.d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iB;
        }
        return -1;
    }

    private void l(View view) {
        this.c.add(view);
        this.a.e(view);
    }

    private boolean t(View view) {
        if (!this.c.remove(view)) {
            return false;
        }
        this.a.c(view);
        return true;
    }

    void a(View view, int i, boolean z) {
        int iH = i < 0 ? this.a.h() : h(i);
        this.b.e(iH, z);
        if (z) {
            l(view);
        }
        this.a.f(view, iH);
    }

    void b(View view, boolean z) {
        a(view, -1, z);
    }

    void c(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iH = i < 0 ? this.a.h() : h(i);
        this.b.e(iH, z);
        if (z) {
            l(view);
        }
        this.a.d(view, iH, layoutParams);
    }

    void d(int i) {
        int iH = h(i);
        this.b.f(iH);
        this.a.b(iH);
    }

    View e(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.c.get(i2);
            RecyclerView.d0 d0VarK = this.a.k(view);
            if (d0VarK.m() == i && !d0VarK.t() && !d0VarK.v()) {
                return view;
            }
        }
        return null;
    }

    View f(int i) {
        return this.a.a(h(i));
    }

    int g() {
        return this.a.h() - this.c.size();
    }

    View i(int i) {
        return this.a.a(i);
    }

    int j() {
        return this.a.h();
    }

    void k(View view) {
        int iG = this.a.g(view);
        if (iG >= 0) {
            this.b.h(iG);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    int m(View view) {
        int iG = this.a.g(view);
        if (iG == -1 || this.b.d(iG)) {
            return -1;
        }
        return iG - this.b.b(iG);
    }

    boolean n(View view) {
        return this.c.contains(view);
    }

    void o() {
        this.b.g();
        for (int size = this.c.size() - 1; size >= 0; size--) {
            this.a.c(this.c.get(size));
            this.c.remove(size);
        }
        this.a.j();
    }

    void p(View view) {
        int iG = this.a.g(view);
        if (iG < 0) {
            return;
        }
        if (this.b.f(iG)) {
            t(view);
        }
        this.a.i(iG);
    }

    void q(int i) {
        int iH = h(i);
        View viewA = this.a.a(iH);
        if (viewA == null) {
            return;
        }
        if (this.b.f(iH)) {
            t(viewA);
        }
        this.a.i(iH);
    }

    boolean r(View view) {
        int iG = this.a.g(view);
        if (iG == -1) {
            t(view);
            return true;
        }
        if (!this.b.d(iG)) {
            return false;
        }
        this.b.f(iG);
        t(view);
        this.a.i(iG);
        return true;
    }

    void s(View view) {
        int iG = this.a.g(view);
        if (iG < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.b.d(iG)) {
            this.b.a(iG);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.b.toString() + ", hidden list:" + this.c.size();
    }
}
