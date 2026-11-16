package d.m;

import android.annotation.SuppressLint;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class d0 extends i0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f827e = true;

    d0() {
    }

    @Override // d.m.i0
    public void a(View view) {
    }

    @Override // d.m.i0
    @SuppressLint({"NewApi"})
    public float c(View view) {
        if (f827e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f827e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // d.m.i0
    public void d(View view) {
    }

    @Override // d.m.i0
    @SuppressLint({"NewApi"})
    public void f(View view, float f2) {
        if (f827e) {
            try {
                view.setTransitionAlpha(f2);
                return;
            } catch (NoSuchMethodError unused) {
                f827e = false;
            }
        }
        view.setAlpha(f2);
    }
}
