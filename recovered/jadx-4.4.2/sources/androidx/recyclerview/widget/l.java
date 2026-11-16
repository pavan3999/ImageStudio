package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class l {
    static int a(RecyclerView.a0 a0Var, j jVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.J() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(oVar.h0(view) - oVar.h0(view2)) + 1;
        }
        return Math.min(jVar.n(), jVar.d(view2) - jVar.g(view));
    }

    static int b(RecyclerView.a0 a0Var, j jVar, View view, View view2, RecyclerView.o oVar, boolean z, boolean z2) {
        if (oVar.J() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (a0Var.b() - Math.max(oVar.h0(view), oVar.h0(view2))) - 1) : Math.max(0, Math.min(oVar.h0(view), oVar.h0(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(jVar.d(view2) - jVar.g(view)) / (Math.abs(oVar.h0(view) - oVar.h0(view2)) + 1))) + (jVar.m() - jVar.g(view)));
        }
        return iMax;
    }

    static int c(RecyclerView.a0 a0Var, j jVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.J() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return a0Var.b();
        }
        return (int) (((jVar.d(view2) - jVar.g(view)) / (Math.abs(oVar.h0(view) - oVar.h0(view2)) + 1)) * a0Var.b());
    }
}
