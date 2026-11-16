package e.a.a.a.t;

import android.content.Context;
import android.graphics.Color;
import e.a.a.a.x.b;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private final boolean a;
    private final int b;
    private final int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f928d;

    public a(Context context) {
        this.a = b.b(context, e.a.a.a.b.elevationOverlayEnabled, false);
        this.b = e.a.a.a.q.a.a(context, e.a.a.a.b.elevationOverlayColor, 0);
        this.c = e.a.a.a.q.a.a(context, e.a.a.a.b.colorSurface, 0);
        this.f928d = context.getResources().getDisplayMetrics().density;
    }

    private boolean e(int i) {
        return d.f.d.a.d(i, 255) == this.c;
    }

    public float a(float f2) {
        float f3 = this.f928d;
        if (f3 <= 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f2 / f3)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i, float f2) {
        float fA = a(f2);
        return d.f.d.a.d(e.a.a.a.q.a.f(d.f.d.a.d(i, 255), this.b, fA), Color.alpha(i));
    }

    public int c(int i, float f2) {
        return (this.a && e(i)) ? b(i, f2) : i;
    }

    public boolean d() {
        return this.a;
    }
}
