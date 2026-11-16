package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class a extends androidx.core.content.a {
    private static c c;

    /* JADX INFO: renamed from: androidx.core.app.a$a, reason: collision with other inner class name */
    static class RunnableC0006a implements Runnable {
        final /* synthetic */ String[] b;
        final /* synthetic */ Activity c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f251d;

        RunnableC0006a(String[] strArr, Activity activity, int i) {
            this.b = strArr;
            this.c = activity;
            this.f251d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.b.length];
            PackageManager packageManager = this.c.getPackageManager();
            String packageName = this.c.getPackageName();
            int length = this.b.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.b[i], packageName);
            }
            ((b) this.c).onRequestPermissionsResult(this.f251d, this.b, iArr);
        }
    }

    public interface b {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public interface c {
        boolean a(Activity activity, String[] strArr, int i);

        boolean b(Activity activity, int i, int i2, Intent intent);
    }

    public interface d {
        void b(int i);
    }

    public static void h(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static c i() {
        return c;
    }

    public static void j(Activity activity) {
        if (Build.VERSION.SDK_INT < 28 && androidx.core.app.b.i(activity)) {
            return;
        }
        activity.recreate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void k(Activity activity, String[] strArr, int i) {
        c cVar = c;
        if (cVar == null || !cVar.a(activity, strArr, i)) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof d) {
                    ((d) activity).b(i);
                }
                activity.requestPermissions(strArr, i);
            } else if (activity instanceof b) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0006a(strArr, activity, i));
            }
        }
    }
}
