package d.m;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class e0 extends d0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f832f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f833g = true;

    e0() {
    }

    @Override // d.m.i0
    @SuppressLint({"NewApi"})
    public void h(View view, Matrix matrix) {
        if (f832f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f832f = false;
            }
        }
    }

    @Override // d.m.i0
    @SuppressLint({"NewApi"})
    public void i(View view, Matrix matrix) {
        if (f833g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f833g = false;
            }
        }
    }
}
