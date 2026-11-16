package androidx.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.app.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.o;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends d implements g, t, androidx.savedstate.b, c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private s f1e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3g;
    private final h c = new h(this);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.savedstate.a f0d = androidx.savedstate.a.a(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final OnBackPressedDispatcher f2f = new OnBackPressedDispatcher(new a());

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.super.onBackPressed();
        }
    }

    static final class b {
        s a;

        b() {
        }
    }

    public ComponentActivity() {
        if (a() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            a().a(new e() { // from class: androidx.activity.ComponentActivity.2
                @Override // androidx.lifecycle.e
                public void g(g gVar, androidx.lifecycle.d.a aVar) {
                    if (aVar == androidx.lifecycle.d.a.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                        if (viewPeekDecorView != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        a().a(new e() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.e
            public void g(g gVar, androidx.lifecycle.d.a aVar) {
                if (aVar != androidx.lifecycle.d.a.ON_DESTROY || ComponentActivity.this.isChangingConfigurations()) {
                    return;
                }
                ComponentActivity.this.f().a();
            }
        });
        int i = Build.VERSION.SDK_INT;
        if (19 > i || i > 23) {
            return;
        }
        a().a(new ImmLeaksCleaner(this));
    }

    @Override // androidx.lifecycle.g
    public androidx.lifecycle.d a() {
        return this.c;
    }

    @Override // androidx.activity.c
    public final OnBackPressedDispatcher d() {
        return this.f2f;
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry e() {
        return this.f0d.b();
    }

    @Override // androidx.lifecycle.t
    public s f() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.f1e == null) {
            b bVar = (b) getLastNonConfigurationInstance();
            if (bVar != null) {
                this.f1e = bVar.a;
            }
            if (this.f1e == null) {
                this.f1e = new s();
            }
        }
        return this.f1e;
    }

    @Deprecated
    public Object l() {
        return null;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f2f.c();
    }

    @Override // androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f0d.c(bundle);
        o.f(this);
        int i = this.f3g;
        if (i != 0) {
            setContentView(i);
        }
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        b bVar;
        Object objL = l();
        s sVar = this.f1e;
        if (sVar == null && (bVar = (b) getLastNonConfigurationInstance()) != null) {
            sVar = bVar.a;
        }
        if (sVar == null && objL == null) {
            return null;
        }
        b bVar2 = new b();
        bVar2.a = sVar;
        return bVar2;
    }

    @Override // androidx.core.app.d, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.d dVarA = a();
        if (dVarA instanceof h) {
            ((h) dVarA).p(androidx.lifecycle.d.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f0d.d(bundle);
    }
}
