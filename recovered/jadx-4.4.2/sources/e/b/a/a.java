package e.b.a;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static boolean a = false;
    public static boolean b = true;
    public static int c = 20000;

    /* JADX INFO: renamed from: e.b.a.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0072a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum b {
        VERBOSE,
        ERROR,
        DEBUG,
        WARN
    }

    public static e.b.a.c.b a(boolean z) {
        return b(z, 0);
    }

    public static e.b.a.c.b b(boolean z, int i) {
        return c(z, i, e.b.a.c.b.A, 3);
    }

    public static e.b.a.c.b c(boolean z, int i, e.b.a.c.b.d dVar, int i2) {
        return z ? e.b.a.c.b.J(i, dVar, i2) : e.b.a.c.b.K(i);
    }

    public static void d(String str) {
        g(null, str, b.DEBUG, null);
    }

    public static void e(String str, b bVar, Exception exc) {
        g(null, str, bVar, exc);
    }

    public static void f(String str, String str2) {
        g(str, str2, b.DEBUG, null);
    }

    public static void g(String str, String str2, b bVar, Exception exc) {
        if (str2 == null || str2.equals("") || !a) {
            return;
        }
        if (str == null) {
            str = "RootShell v1.6";
        }
        int i = C0072a.a[bVar.ordinal()];
        if (i == 1) {
            Log.v(str, str2);
            return;
        }
        if (i == 2) {
            Log.e(str, str2, exc);
        } else if (i == 3) {
            Log.d(str, str2);
        } else {
            if (i != 4) {
                return;
            }
            Log.w(str, str2);
        }
    }
}
