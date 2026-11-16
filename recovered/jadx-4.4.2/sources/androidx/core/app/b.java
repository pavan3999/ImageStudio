package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Handler f255g = new Handler(Looper.getMainLooper());
    protected static final Class<?> a = a();
    protected static final Field b = b();
    protected static final Field c = f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final Method f252d = d(a);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final Method f253e = c(a);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final Method f254f = e(a);

    static class a implements Runnable {
        final /* synthetic */ d b;
        final /* synthetic */ Object c;

        a(d dVar, Object obj) {
            this.b = dVar;
            this.c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a = this.c;
        }
    }

    /* JADX INFO: renamed from: androidx.core.app.b$b, reason: collision with other inner class name */
    static class RunnableC0007b implements Runnable {
        final /* synthetic */ Application b;
        final /* synthetic */ d c;

        RunnableC0007b(Application application, d dVar) {
            this.b = application;
            this.c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.unregisterActivityLifecycleCallbacks(this.c);
        }
    }

    static class c implements Runnable {
        final /* synthetic */ Object b;
        final /* synthetic */ Object c;

        c(Object obj, Object obj2) {
            this.b = obj;
            this.c = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (b.f252d != null) {
                    b.f252d.invoke(this.b, this.c, Boolean.FALSE, "AppCompat recreation");
                } else {
                    b.f253e.invoke(this.b, this.c, Boolean.FALSE);
                }
            } catch (RuntimeException e2) {
                if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                    throw e2;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    private static final class d implements Application.ActivityLifecycleCallbacks {
        Object a;
        private Activity b;
        private boolean c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f256d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f257e = false;

        d(Activity activity) {
            this.b = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.b == activity) {
                this.b = null;
                this.f256d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f256d || this.f257e || this.c || !b.h(this.a, activity)) {
                return;
            }
            this.f257e = true;
            this.a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.b == activity) {
                this.c = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i = Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    protected static boolean h(Object obj, Activity activity) {
        try {
            Object obj2 = c.get(activity);
            if (obj2 != obj) {
                return false;
            }
            f255g.postAtFrontOfQueue(new c(b.get(activity), obj2));
            return true;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f254f == null) {
            return false;
        }
        if (f253e == null && f252d == null) {
            return false;
        }
        try {
            Object obj2 = c.get(activity);
            if (obj2 == null || (obj = b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            d dVar = new d(activity);
            application.registerActivityLifecycleCallbacks(dVar);
            f255g.post(new a(dVar, obj2));
            try {
                if (g()) {
                    f254f.invoke(obj, obj2, null, null, 0, Boolean.FALSE, null, null, Boolean.FALSE, Boolean.FALSE);
                } else {
                    activity.recreate();
                }
                return true;
            } finally {
                f255g.post(new RunnableC0007b(application, dVar));
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
