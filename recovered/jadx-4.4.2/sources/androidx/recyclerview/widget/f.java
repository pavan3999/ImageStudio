package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class f {
    int b;
    int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f468e;
    boolean h;
    boolean i;
    boolean a = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f469f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f470g = 0;

    f() {
    }

    boolean a(RecyclerView.a0 a0Var) {
        int i = this.c;
        return i >= 0 && i < a0Var.b();
    }

    View b(RecyclerView.v vVar) {
        View viewO = vVar.o(this.c);
        this.c += this.f467d;
        return viewO;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.f467d + ", mLayoutDirection=" + this.f468e + ", mStartLine=" + this.f469f + ", mEndLine=" + this.f470g + '}';
    }
}
