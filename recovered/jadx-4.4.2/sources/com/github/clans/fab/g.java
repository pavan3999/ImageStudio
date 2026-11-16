package com.github.clans.fab;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
final class g {
    static int a(Context context, float f2) {
        return Math.round(f2 * context.getResources().getDisplayMetrics().density);
    }

    static boolean b() {
        return Build.VERSION.SDK_INT >= 16;
    }

    static boolean c() {
        return Build.VERSION.SDK_INT >= 21;
    }
}
