package d.f.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final h a;
    private static final d.d.e<String, Typeface> b;

    static {
        h dVar;
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            dVar = new g();
        } else if (i >= 26) {
            dVar = new f();
        } else if (i < 24 || !e.m()) {
            dVar = Build.VERSION.SDK_INT >= 21 ? new d() : new h();
        } else {
            dVar = new e();
        }
        a = dVar;
        b = new d.d.e<>(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i) {
        Typeface typefaceG;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (typefaceG = g(context, typeface, i)) == null) ? Typeface.create(typeface, i) : typefaceG;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, d.f.h.b.f[] fVarArr, int i) {
        return a.c(context, cancellationSignal, fVarArr, i);
    }

    public static Typeface c(Context context, androidx.core.content.c.c.a aVar, Resources resources, int i, int i2, androidx.core.content.c.f.a aVar2, Handler handler, boolean z) {
        Typeface typefaceB;
        if (aVar instanceof androidx.core.content.c.c.d) {
            androidx.core.content.c.c.d dVar = (androidx.core.content.c.c.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.a() == 0) {
                z2 = true;
            }
            typefaceB = d.f.h.b.g(context, dVar.b(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            typefaceB = a.b(context, (androidx.core.content.c.c.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (typefaceB != null) {
                    aVar2.b(typefaceB, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (typefaceB != null) {
            b.d(e(resources, i, i2), typefaceB);
        }
        return typefaceB;
    }

    public static Typeface d(Context context, Resources resources, int i, String str, int i2) {
        Typeface typefaceE = a.e(context, resources, i, str, i2);
        if (typefaceE != null) {
            b.d(e(resources, i, i2), typefaceE);
        }
        return typefaceE;
    }

    private static String e(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface f(Resources resources, int i, int i2) {
        return b.c(e(resources, i, i2));
    }

    private static Typeface g(Context context, Typeface typeface, int i) {
        androidx.core.content.c.c.b bVarI = a.i(typeface);
        if (bVarI == null) {
            return null;
        }
        return a.b(context, bVarI, context.getResources(), i);
    }
}
