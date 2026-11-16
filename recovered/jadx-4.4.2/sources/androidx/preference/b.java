package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences(c(context), b());
    }

    private static int b() {
        return 0;
    }

    private static String c(Context context) {
        return context.getPackageName() + "_preferences";
    }

    SharedPreferences.Editor d() {
        throw null;
    }

    public a e() {
        throw null;
    }

    public SharedPreferences f() {
        throw null;
    }
}
