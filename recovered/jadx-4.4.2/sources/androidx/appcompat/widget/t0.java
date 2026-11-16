package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class t0 extends ContextWrapper {
    private static final Object c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ArrayList<WeakReference<t0>> f212d;
    private final Resources a;
    private final Resources.Theme b;

    private t0(Context context) {
        super(context);
        if (!b1.b()) {
            this.a = new v0(this, context.getResources());
            this.b = null;
            return;
        }
        b1 b1Var = new b1(this, context.getResources());
        this.a = b1Var;
        Resources.Theme themeNewTheme = b1Var.newTheme();
        this.b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    private static boolean a(Context context) {
        if ((context instanceof t0) || (context.getResources() instanceof v0) || (context.getResources() instanceof b1)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || b1.b();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (c) {
            if (f212d == null) {
                f212d = new ArrayList<>();
            } else {
                for (int size = f212d.size() - 1; size >= 0; size--) {
                    WeakReference<t0> weakReference = f212d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f212d.remove(size);
                    }
                }
                for (int size2 = f212d.size() - 1; size2 >= 0; size2--) {
                    WeakReference<t0> weakReference2 = f212d.get(size2);
                    t0 t0Var = weakReference2 != null ? weakReference2.get() : null;
                    if (t0Var != null && t0Var.getBaseContext() == context) {
                        return t0Var;
                    }
                }
            }
            t0 t0Var2 = new t0(context);
            f212d.add(new WeakReference<>(t0Var2));
            return t0Var2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.b;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
