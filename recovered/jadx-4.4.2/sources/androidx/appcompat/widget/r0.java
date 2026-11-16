package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
class r0 {
    private static final ThreadLocal<TypedValue> a = new ThreadLocal<>();
    static final int[] b = {-16842910};
    static final int[] c = {R.attr.state_focused};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[] f207d = {R.attr.state_pressed};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f208e = {R.attr.state_checked};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[] f209f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f210g = new int[1];

    public static int a(Context context, int i) {
        ColorStateList colorStateListD = d(context, i);
        if (colorStateListD != null && colorStateListD.isStateful()) {
            return colorStateListD.getColorForState(b, colorStateListD.getDefaultColor());
        }
        TypedValue typedValueE = e();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueE, true);
        return c(context, i, typedValueE.getFloat());
    }

    public static int b(Context context, int i) {
        int[] iArr = f210g;
        iArr[0] = i;
        w0 w0VarT = w0.t(context, null, iArr);
        try {
            return w0VarT.b(0, 0);
        } finally {
            w0VarT.v();
        }
    }

    static int c(Context context, int i, float f2) {
        int iB = b(context, i);
        return d.f.d.a.d(iB, Math.round(Color.alpha(iB) * f2));
    }

    public static ColorStateList d(Context context, int i) {
        int[] iArr = f210g;
        iArr[0] = i;
        w0 w0VarT = w0.t(context, null, iArr);
        try {
            return w0VarT.c(0);
        } finally {
            w0VarT.v();
        }
    }

    private static TypedValue e() {
        TypedValue typedValue = a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        a.set(typedValue2);
        return typedValue2;
    }
}
