package d.m;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class h0 extends g0 {
    h0() {
    }

    @Override // d.m.d0, d.m.i0
    public float c(View view) {
        return view.getTransitionAlpha();
    }

    @Override // d.m.f0, d.m.i0
    public void e(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // d.m.d0, d.m.i0
    public void f(View view, float f2) {
        view.setTransitionAlpha(f2);
    }

    @Override // d.m.g0, d.m.i0
    public void g(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // d.m.e0, d.m.i0
    public void h(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // d.m.e0, d.m.i0
    public void i(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
