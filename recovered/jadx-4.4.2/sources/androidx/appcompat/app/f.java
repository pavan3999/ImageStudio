package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.b1;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.c1;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.w0;
import d.f.k.r;
import d.f.k.v;
import d.f.k.x;
import d.f.k.z;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
class f extends androidx.appcompat.app.e implements androidx.appcompat.view.menu.g.a, LayoutInflater.Factory2 {
    private static final Map<Class<?>, Integer> b0 = new d.d.a();
    private static final boolean c0;
    private static final int[] d0;
    private static boolean e0;
    private static final boolean f0;
    private boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    private boolean G;
    private o[] H;
    private o I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    boolean N;
    private int O;
    private int P;
    private boolean Q;
    private boolean R;
    private l S;
    private l T;
    boolean U;
    int V;
    private final Runnable W;
    private boolean X;
    private Rect Y;
    private Rect Z;
    private AppCompatViewInflater a0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Object f25e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Context f26f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Window f27g;
    private j h;
    final androidx.appcompat.app.d i;
    androidx.appcompat.app.a j;
    MenuInflater k;
    private CharSequence l;
    private c0 m;
    private h n;
    private p o;
    d.a.o.b p;
    ActionBarContextView q;
    PopupWindow r;
    Runnable s;
    v t;
    private boolean u;
    private boolean v;
    private ViewGroup w;
    private TextView x;
    private View y;
    private boolean z;

    static class a implements Thread.UncaughtExceptionHandler {
        final /* synthetic */ Thread.UncaughtExceptionHandler a;

        a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.a = uncaughtExceptionHandler;
        }

        private boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (!a(th)) {
                this.a.uncaughtException(thread, th);
                return;
            }
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            notFoundException.initCause(th.getCause());
            notFoundException.setStackTrace(th.getStackTrace());
            this.a.uncaughtException(thread, notFoundException);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            if ((fVar.V & 1) != 0) {
                fVar.T(0);
            }
            f fVar2 = f.this;
            if ((fVar2.V & 4096) != 0) {
                fVar2.T(108);
            }
            f fVar3 = f.this;
            fVar3.U = false;
            fVar3.V = 0;
        }
    }

    class c implements d.f.k.o {
        c() {
        }

        @Override // d.f.k.o
        public z a(View view, z zVar) {
            int iD = zVar.d();
            int iJ0 = f.this.J0(iD);
            if (iD != iJ0) {
                zVar = zVar.f(zVar.b(), iJ0, zVar.c(), zVar.a());
            }
            return r.Q(view, zVar);
        }
    }

    class d implements g0.a {
        d() {
        }

        @Override // androidx.appcompat.widget.g0.a
        public void a(Rect rect) {
            rect.top = f.this.J0(rect.top);
        }
    }

    class e implements ContentFrameLayout.a {
        e() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            f.this.R();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.f$f, reason: collision with other inner class name */
    class RunnableC0001f implements Runnable {

        /* JADX INFO: renamed from: androidx.appcompat.app.f$f$a */
        class a extends x {
            a() {
            }

            @Override // d.f.k.w
            public void a(View view) {
                f.this.q.setAlpha(1.0f);
                f.this.t.f(null);
                f.this.t = null;
            }

            @Override // d.f.k.x, d.f.k.w
            public void b(View view) {
                f.this.q.setVisibility(0);
            }
        }

        RunnableC0001f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.r.showAtLocation(fVar.q, 55, 0, 0);
            f.this.U();
            if (!f.this.B0()) {
                f.this.q.setAlpha(1.0f);
                f.this.q.setVisibility(0);
                return;
            }
            f.this.q.setAlpha(0.0f);
            f fVar2 = f.this;
            v vVarC = r.c(fVar2.q);
            vVarC.a(1.0f);
            fVar2.t = vVarC;
            f.this.t.f(new a());
        }
    }

    class g extends x {
        g() {
        }

        @Override // d.f.k.w
        public void a(View view) {
            f.this.q.setAlpha(1.0f);
            f.this.t.f(null);
            f.this.t = null;
        }

        @Override // d.f.k.x, d.f.k.w
        public void b(View view) {
            f.this.q.setVisibility(0);
            f.this.q.sendAccessibilityEvent(32);
            if (f.this.q.getParent() instanceof View) {
                r.a0((View) f.this.q.getParent());
            }
        }
    }

    private final class h implements androidx.appcompat.view.menu.m.a {
        h() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void c(androidx.appcompat.view.menu.g gVar, boolean z) {
            f.this.L(gVar);
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean d(androidx.appcompat.view.menu.g gVar) {
            Window.Callback callbackD0 = f.this.d0();
            if (callbackD0 == null) {
                return true;
            }
            callbackD0.onMenuOpened(108, gVar);
            return true;
        }
    }

    class i implements d.a.o.b.a {
        private d.a.o.b.a a;

        class a extends x {
            a() {
            }

            @Override // d.f.k.w
            public void a(View view) {
                f.this.q.setVisibility(8);
                f fVar = f.this;
                PopupWindow popupWindow = fVar.r;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (fVar.q.getParent() instanceof View) {
                    r.a0((View) f.this.q.getParent());
                }
                f.this.q.removeAllViews();
                f.this.t.f(null);
                f.this.t = null;
            }
        }

        public i(d.a.o.b.a aVar) {
            this.a = aVar;
        }

        @Override // d.a.o.b.a
        public boolean a(d.a.o.b bVar, Menu menu) {
            return this.a.a(bVar, menu);
        }

        @Override // d.a.o.b.a
        public void b(d.a.o.b bVar) {
            this.a.b(bVar);
            f fVar = f.this;
            if (fVar.r != null) {
                fVar.f27g.getDecorView().removeCallbacks(f.this.s);
            }
            f fVar2 = f.this;
            if (fVar2.q != null) {
                fVar2.U();
                f fVar3 = f.this;
                v vVarC = r.c(fVar3.q);
                vVarC.a(0.0f);
                fVar3.t = vVarC;
                f.this.t.f(new a());
            }
            f fVar4 = f.this;
            androidx.appcompat.app.d dVar = fVar4.i;
            if (dVar != null) {
                dVar.g(fVar4.p);
            }
            f.this.p = null;
        }

        @Override // d.a.o.b.a
        public boolean c(d.a.o.b bVar, MenuItem menuItem) {
            return this.a.c(bVar, menuItem);
        }

        @Override // d.a.o.b.a
        public boolean d(d.a.o.b bVar, Menu menu) {
            return this.a.d(bVar, menu);
        }
    }

    class j extends d.a.o.i {
        j(Window.Callback callback) {
            super(callback);
        }

        final ActionMode b(ActionMode.Callback callback) {
            d.a.o.f.a aVar = new d.a.o.f.a(f.this.f26f, callback);
            d.a.o.b bVarD0 = f.this.D0(aVar);
            if (bVarD0 != null) {
                return aVar.e(bVarD0);
            }
            return null;
        }

        @Override // d.a.o.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.S(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // d.a.o.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || f.this.p0(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // d.a.o.i, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // d.a.o.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // d.a.o.i, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            f.this.s0(i);
            return true;
        }

        @Override // d.a.o.i, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            f.this.t0(i);
        }

        @Override // d.a.o.i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar = menu instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menu : null;
            if (i == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.a0(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
            if (gVar != null) {
                gVar.a0(false);
            }
            return zOnPreparePanel;
        }

        @Override // d.a.o.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            androidx.appcompat.view.menu.g gVar;
            o oVarB0 = f.this.b0(0, true);
            if (oVarB0 == null || (gVar = oVarB0.j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, gVar, i);
            }
        }

        @Override // d.a.o.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return f.this.k0() ? b(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // d.a.o.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            return (f.this.k0() && i == 0) ? b(callback) : super.onWindowStartingActionMode(callback, i);
        }
    }

    private class k extends l {
        private final PowerManager c;

        k(Context context) {
            super();
            this.c = (PowerManager) context.getSystemService("power");
        }

        @Override // androidx.appcompat.app.f.l
        IntentFilter b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.f.l
        public int c() {
            return (Build.VERSION.SDK_INT < 21 || !this.c.isPowerSaveMode()) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.f.l
        public void d() {
            f.this.F();
        }
    }

    abstract class l {
        private BroadcastReceiver a;

        class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                l.this.d();
            }
        }

        l() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.a;
            if (broadcastReceiver != null) {
                try {
                    f.this.f26f.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.a == null) {
                this.a = new a();
            }
            f.this.f26f.registerReceiver(this.a, intentFilterB);
        }
    }

    private class m extends l {
        private final androidx.appcompat.app.k c;

        m(androidx.appcompat.app.k kVar) {
            super();
            this.c = kVar;
        }

        @Override // androidx.appcompat.app.f.l
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.f.l
        public int c() {
            return this.c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.f.l
        public void d() {
            f.this.F();
        }
    }

    private class n extends ContentFrameLayout {
        public n(Context context) {
            super(context);
        }

        private boolean c(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.S(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            f.this.N(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(d.a.k.a.a.d(getContext(), i));
        }
    }

    protected static final class o {
        int a;
        int b;
        int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f30d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f32f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ViewGroup f33g;
        View h;
        View i;
        androidx.appcompat.view.menu.g j;
        androidx.appcompat.view.menu.e k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        o(int i) {
            this.a = i;
        }

        androidx.appcompat.view.menu.n a(androidx.appcompat.view.menu.m.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(this.l, d.a.g.abc_list_menu_item_layout);
                this.k = eVar;
                eVar.e(aVar);
                this.j.b(this.k);
            }
            return this.k.b(this.f33g);
        }

        public boolean b() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.a().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.g gVar2 = this.j;
            if (gVar == gVar2) {
                return;
            }
            if (gVar2 != null) {
                gVar2.O(this.k);
            }
            this.j = gVar;
            if (gVar == null || (eVar = this.k) == null) {
                return;
            }
            gVar.b(eVar);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(d.a.a.actionBarPopupTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                themeNewTheme.applyStyle(i, true);
            }
            themeNewTheme.resolveAttribute(d.a.a.panelMenuListTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 == 0) {
                i2 = d.a.i.Theme_AppCompat_CompactMenu;
            }
            themeNewTheme.applyStyle(i2, true);
            d.a.o.d dVar = new d.a.o.d(context, 0);
            dVar.getTheme().setTo(themeNewTheme);
            this.l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(d.a.j.AppCompatTheme);
            this.b = typedArrayObtainStyledAttributes.getResourceId(d.a.j.AppCompatTheme_panelBackground, 0);
            this.f32f = typedArrayObtainStyledAttributes.getResourceId(d.a.j.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private final class p implements androidx.appcompat.view.menu.m.a {
        p() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void c(androidx.appcompat.view.menu.g gVar, boolean z) {
            androidx.appcompat.view.menu.g gVarD = gVar.D();
            boolean z2 = gVarD != gVar;
            f fVar = f.this;
            if (z2) {
                gVar = gVarD;
            }
            o oVarX = fVar.X(gVar);
            if (oVarX != null) {
                if (!z2) {
                    f.this.O(oVarX, z);
                } else {
                    f.this.K(oVarX.a, oVarX, gVarD);
                    f.this.O(oVarX, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean d(androidx.appcompat.view.menu.g gVar) {
            Window.Callback callbackD0;
            if (gVar != null) {
                return true;
            }
            f fVar = f.this;
            if (!fVar.B || (callbackD0 = fVar.d0()) == null || f.this.N) {
                return true;
            }
            callbackD0.onMenuOpened(108, gVar);
            return true;
        }
    }

    static {
        boolean z = false;
        c0 = Build.VERSION.SDK_INT < 21;
        d0 = new int[]{R.attr.windowBackground};
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21 && i2 <= 25) {
            z = true;
        }
        f0 = z;
        if (!c0 || e0) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        e0 = true;
    }

    f(Activity activity, androidx.appcompat.app.d dVar) {
        this(activity, null, dVar, activity);
    }

    f(Dialog dialog, androidx.appcompat.app.d dVar) {
        this(dialog.getContext(), dialog.getWindow(), dVar, dialog);
    }

    private f(Context context, Window window, androidx.appcompat.app.d dVar, Object obj) {
        Integer num;
        androidx.appcompat.app.c cVarG0;
        this.t = null;
        this.u = true;
        this.O = -100;
        this.W = new b();
        this.f26f = context;
        this.i = dVar;
        this.f25e = obj;
        if (this.O == -100 && (obj instanceof Dialog) && (cVarG0 = G0()) != null) {
            this.O = cVarG0.v().i();
        }
        if (this.O == -100 && (num = b0.get(this.f25e.getClass())) != null) {
            this.O = num.intValue();
            b0.remove(this.f25e.getClass());
        }
        if (window != null) {
            I(window);
        }
        androidx.appcompat.widget.j.h();
    }

    private int A0(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i2 != 9) {
            return i2;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private boolean C0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f27g.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || r.I((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void F0() {
        if (this.v) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private boolean G(boolean z) {
        if (this.N) {
            return false;
        }
        int iJ = J();
        boolean zH0 = H0(l0(iJ), z);
        if (iJ == 0) {
            a0().e();
        } else {
            l lVar = this.S;
            if (lVar != null) {
                lVar.a();
            }
        }
        if (iJ == 3) {
            Z().e();
        } else {
            l lVar2 = this.T;
            if (lVar2 != null) {
                lVar2.a();
            }
        }
        return zH0;
    }

    private androidx.appcompat.app.c G0() {
        for (Context baseContext = this.f26f; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof androidx.appcompat.app.c) {
                return (androidx.appcompat.app.c) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private void H() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.w.findViewById(R.id.content);
        View decorView = this.f27g.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f26f.obtainStyledAttributes(d.a.j.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(d.a.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(d.a.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes.hasValue(d.a.j.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes.getValue(d.a.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(d.a.j.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes.getValue(d.a.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(d.a.j.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes.getValue(d.a.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(d.a.j.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes.getValue(d.a.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private boolean H0(int i2, boolean z) {
        int i3;
        int i4 = this.f26f.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        boolean z2 = true;
        if (i2 != 1) {
            i3 = i2 != 2 ? i4 : 32;
        } else {
            i3 = 16;
        }
        boolean zJ0 = j0();
        boolean z3 = false;
        if ((f0 || i3 != i4) && !zJ0 && Build.VERSION.SDK_INT >= 17 && !this.K && (this.f25e instanceof ContextThemeWrapper)) {
            Configuration configuration = new Configuration();
            configuration.uiMode = (configuration.uiMode & (-49)) | i3;
            try {
                ((ContextThemeWrapper) this.f25e).applyOverrideConfiguration(configuration);
                z3 = true;
            } catch (IllegalStateException e2) {
                Log.e("AppCompatDelegate", "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()", e2);
            }
        }
        int i5 = this.f26f.getResources().getConfiguration().uiMode & 48;
        if (!z3 && i5 != i3 && z && !zJ0 && this.K && (Build.VERSION.SDK_INT >= 17 || this.L)) {
            Object obj = this.f25e;
            if (obj instanceof Activity) {
                androidx.core.app.a.j((Activity) obj);
                z3 = true;
            }
        }
        if (z3 || i5 == i3) {
            z2 = z3;
        } else {
            I0(i3, zJ0);
        }
        if (z2) {
            Object obj2 = this.f25e;
            if (obj2 instanceof androidx.appcompat.app.c) {
                ((androidx.appcompat.app.c) obj2).y(i2);
            }
        }
        return z2;
    }

    private void I(Window window) {
        if (this.f27g != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof j) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        j jVar = new j(callback);
        this.h = jVar;
        window.setCallback(jVar);
        w0 w0VarT = w0.t(this.f26f, null, d0);
        Drawable drawableH = w0VarT.h(0);
        if (drawableH != null) {
            window.setBackgroundDrawable(drawableH);
        }
        w0VarT.v();
        this.f27g = window;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void I0(int i2, boolean z) {
        Resources resources = this.f26f.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration, null);
        if (Build.VERSION.SDK_INT < 26) {
            androidx.appcompat.app.h.a(resources);
        }
        int i3 = this.P;
        if (i3 != 0) {
            this.f26f.setTheme(i3);
            if (Build.VERSION.SDK_INT >= 23) {
                this.f26f.getTheme().applyStyle(this.P, true);
            }
        }
        if (z) {
            Object obj = this.f25e;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.g) {
                    if (!((androidx.lifecycle.g) activity).a().b().a(androidx.lifecycle.d.b.STARTED)) {
                        return;
                    }
                } else if (!this.M) {
                    return;
                }
                activity.onConfigurationChanged(configuration);
            }
        }
    }

    private int J() {
        int i2 = this.O;
        return i2 != -100 ? i2 : androidx.appcompat.app.e.h();
    }

    private void M() {
        l lVar = this.S;
        if (lVar != null) {
            lVar.a();
        }
        l lVar2 = this.T;
        if (lVar2 != null) {
            lVar2.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r2v12, types: [android.view.Window] */
    private ViewGroup P() {
        ?? r0;
        ?? r1;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        TypedArray typedArrayObtainStyledAttributes = this.f26f.obtainStyledAttributes(d.a.j.AppCompatTheme);
        if (!typedArrayObtainStyledAttributes.hasValue(d.a.j.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(d.a.j.AppCompatTheme_windowNoTitle, false)) {
            y(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(d.a.j.AppCompatTheme_windowActionBar, false)) {
            y(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(d.a.j.AppCompatTheme_windowActionBarOverlay, false)) {
            y(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(d.a.j.AppCompatTheme_windowActionModeOverlay, false)) {
            y(10);
        }
        this.E = typedArrayObtainStyledAttributes.getBoolean(d.a.j.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        W();
        this.f27g.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f26f);
        if (this.F) {
            r0 = (ViewGroup) layoutInflaterFrom.inflate(this.D ? d.a.g.abc_screen_simple_overlay_action_mode : d.a.g.abc_screen_simple, (ViewGroup) null);
            if (Build.VERSION.SDK_INT >= 21) {
                r.o0(r0, new c());
            } else {
                ((g0) r0).setOnFitSystemWindowsListener(new d());
            }
        } else if (this.E) {
            viewGroup2 = (ViewGroup) layoutInflaterFrom.inflate(d.a.g.abc_dialog_title_material, (ViewGroup) null);
            this.C = false;
            this.B = false;
        } else if (this.B) {
            TypedValue typedValue = new TypedValue();
            this.f26f.getTheme().resolveAttribute(d.a.a.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new d.a.o.d(this.f26f, typedValue.resourceId) : this.f26f).inflate(d.a.g.abc_screen_toolbar, (ViewGroup) null);
            c0 c0Var = (c0) viewGroup.findViewById(d.a.f.decor_content_parent);
            this.m = c0Var;
            c0Var.setWindowCallback(d0());
            if (this.C) {
                this.m.h(109);
            }
            if (this.z) {
                this.m.h(2);
            }
            r1 = viewGroup;
            if (this.A) {
                this.m.h(5);
            }
        } else {
            r1 = 0;
        }
        if (r1 == 0) {
            r1 = r0;
            r1 = r0;
            r1 = viewGroup;
            r1 = viewGroup2;
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.B + ", windowActionBarOverlay: " + this.C + ", android:windowIsFloating: " + this.E + ", windowActionModeOverlay: " + this.D + ", windowNoTitle: " + this.F + " }");
        }
        r1 = r0;
        r1 = r0;
        r1 = viewGroup;
        if (this.m == null) {
            r1 = viewGroup2;
            this.x = (TextView) r1.findViewById(d.a.f.title);
        }
        r1 = viewGroup2;
        c1.c(r1);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) r1.findViewById(d.a.f.action_bar_activity_content);
        ViewGroup viewGroup3 = (ViewGroup) this.f27g.findViewById(R.id.content);
        if (viewGroup3 != null) {
            while (viewGroup3.getChildCount() > 0) {
                View childAt = viewGroup3.getChildAt(0);
                viewGroup3.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup3.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup3 instanceof FrameLayout) {
                ((FrameLayout) viewGroup3).setForeground(null);
            }
        }
        this.f27g.setContentView(r1);
        contentFrameLayout.setAttachListener(new e());
        return r1;
    }

    private void V() {
        if (this.v) {
            return;
        }
        this.w = P();
        CharSequence charSequenceC0 = c0();
        if (!TextUtils.isEmpty(charSequenceC0)) {
            c0 c0Var = this.m;
            if (c0Var != null) {
                c0Var.setWindowTitle(charSequenceC0);
            } else if (w0() != null) {
                w0().t(charSequenceC0);
            } else {
                TextView textView = this.x;
                if (textView != null) {
                    textView.setText(charSequenceC0);
                }
            }
        }
        H();
        u0(this.w);
        this.v = true;
        o oVarB0 = b0(0, false);
        if (this.N) {
            return;
        }
        if (oVarB0 == null || oVarB0.j == null) {
            i0(108);
        }
    }

    private void W() {
        if (this.f27g == null) {
            Object obj = this.f25e;
            if (obj instanceof Activity) {
                I(((Activity) obj).getWindow());
            }
        }
        if (this.f27g == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private l Z() {
        if (this.T == null) {
            this.T = new k(this.f26f);
        }
        return this.T;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0032  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    private void e0() {
        androidx.appcompat.app.l lVar;
        androidx.appcompat.app.a aVar;
        V();
        if (this.B && this.j == null) {
            Object obj = this.f25e;
            if (!(obj instanceof Activity)) {
                if (obj instanceof Dialog) {
                    lVar = new androidx.appcompat.app.l((Dialog) this.f25e);
                }
                aVar = this.j;
                if (aVar != null) {
                    aVar.r(this.X);
                }
            }
            lVar = new androidx.appcompat.app.l((Activity) this.f25e, this.C);
            this.j = lVar;
            aVar = this.j;
            if (aVar != null) {
                aVar.r(this.X);
            }
        }
    }

    private boolean f0(o oVar) {
        View view = oVar.i;
        if (view != null) {
            oVar.h = view;
            return true;
        }
        if (oVar.j == null) {
            return false;
        }
        if (this.o == null) {
            this.o = new p();
        }
        View view2 = (View) oVar.a(this.o);
        oVar.h = view2;
        return view2 != null;
    }

    private boolean g0(o oVar) {
        oVar.d(Y());
        oVar.f33g = new n(oVar.l);
        oVar.c = 81;
        return true;
    }

    private boolean h0(o oVar) {
        Context context = this.f26f;
        int i2 = oVar.a;
        if ((i2 == 0 || i2 == 108) && this.m != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(d.a.a.actionBarTheme, typedValue, true);
            Resources.Theme themeNewTheme = null;
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(d.a.a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(d.a.a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                d.a.o.d dVar = new d.a.o.d(context, 0);
                dVar.getTheme().setTo(themeNewTheme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.R(this);
        oVar.c(gVar);
        return true;
    }

    private void i0(int i2) {
        this.V = (1 << i2) | this.V;
        if (this.U) {
            return;
        }
        r.V(this.f27g.getDecorView(), this.W);
        this.U = true;
    }

    private boolean j0() {
        if (!this.R && (this.f25e instanceof Activity)) {
            PackageManager packageManager = this.f26f.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f26f, this.f25e.getClass()), 0);
                this.Q = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.Q = false;
            }
        }
        this.R = true;
        return this.Q;
    }

    private boolean o0(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        o oVarB0 = b0(i2, true);
        if (oVarB0.o) {
            return false;
        }
        return y0(oVarB0, keyEvent);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    private boolean r0(int i2, KeyEvent keyEvent) {
        boolean zY0;
        c0 c0Var;
        if (this.p != null) {
            return false;
        }
        boolean zG = true;
        o oVarB0 = b0(i2, true);
        if (i2 != 0 || (c0Var = this.m) == null || !c0Var.f() || ViewConfiguration.get(this.f26f).hasPermanentMenuKey()) {
            if (oVarB0.o || oVarB0.n) {
                boolean z = oVarB0.o;
                O(oVarB0, true);
                zG = z;
            } else if (oVarB0.m) {
                if (oVarB0.r) {
                    oVarB0.m = false;
                    zY0 = y0(oVarB0, keyEvent);
                } else {
                    zY0 = true;
                }
                if (zY0) {
                    v0(oVarB0, keyEvent);
                } else {
                    zG = false;
                }
            } else {
                zG = false;
            }
        } else if (this.m.e()) {
            zG = this.m.g();
        } else if (this.N || !y0(oVarB0, keyEvent)) {
            zG = false;
        } else {
            zG = this.m.a();
        }
        if (zG) {
            AudioManager audioManager = (AudioManager) this.f26f.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return zG;
    }

    private void v0(o oVar, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (oVar.o || this.N) {
            return;
        }
        if (oVar.a == 0) {
            if ((this.f26f.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback callbackD0 = d0();
        if (callbackD0 != null && !callbackD0.onMenuOpened(oVar.a, oVar.j)) {
            O(oVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f26f.getSystemService("window");
        if (windowManager != null && y0(oVar, keyEvent)) {
            if (oVar.f33g != null && !oVar.q) {
                View view = oVar.i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i2 = -1;
                }
                oVar.n = false;
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i2, -2, oVar.f30d, oVar.f31e, 1002, 8519680, -3);
                layoutParams2.gravity = oVar.c;
                layoutParams2.windowAnimations = oVar.f32f;
                windowManager.addView(oVar.f33g, layoutParams2);
                oVar.o = true;
            }
            ViewGroup viewGroup = oVar.f33g;
            if (viewGroup == null) {
                if (!g0(oVar) || oVar.f33g == null) {
                    return;
                }
            } else if (oVar.q && viewGroup.getChildCount() > 0) {
                oVar.f33g.removeAllViews();
            }
            if (!f0(oVar) || !oVar.b()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = oVar.h.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
            }
            oVar.f33g.setBackgroundResource(oVar.b);
            ViewParent parent = oVar.h.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(oVar.h);
            }
            oVar.f33g.addView(oVar.h, layoutParams3);
            if (!oVar.h.hasFocus()) {
                oVar.h.requestFocus();
            }
            i2 = -2;
            oVar.n = false;
            WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i2, -2, oVar.f30d, oVar.f31e, 1002, 8519680, -3);
            layoutParams4.gravity = oVar.c;
            layoutParams4.windowAnimations = oVar.f32f;
            windowManager.addView(oVar.f33g, layoutParams4);
            oVar.o = true;
        }
    }

    private boolean x0(o oVar, int i2, KeyEvent keyEvent, int i3) {
        androidx.appcompat.view.menu.g gVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((oVar.m || y0(oVar, keyEvent)) && (gVar = oVar.j) != null) {
            zPerformShortcut = gVar.performShortcut(i2, keyEvent, i3);
        }
        if (zPerformShortcut && (i3 & 1) == 0 && this.m == null) {
            O(oVar, true);
        }
        return zPerformShortcut;
    }

    private boolean y0(o oVar, KeyEvent keyEvent) {
        c0 c0Var;
        c0 c0Var2;
        c0 c0Var3;
        if (this.N) {
            return false;
        }
        if (oVar.m) {
            return true;
        }
        o oVar2 = this.I;
        if (oVar2 != null && oVar2 != oVar) {
            O(oVar2, false);
        }
        Window.Callback callbackD0 = d0();
        if (callbackD0 != null) {
            oVar.i = callbackD0.onCreatePanelView(oVar.a);
        }
        int i2 = oVar.a;
        boolean z = i2 == 0 || i2 == 108;
        if (z && (c0Var3 = this.m) != null) {
            c0Var3.d();
        }
        if (oVar.i == null && (!z || !(w0() instanceof androidx.appcompat.app.i))) {
            if (oVar.j == null || oVar.r) {
                if (oVar.j == null && (!h0(oVar) || oVar.j == null)) {
                    return false;
                }
                if (z && this.m != null) {
                    if (this.n == null) {
                        this.n = new h();
                    }
                    this.m.b(oVar.j, this.n);
                }
                oVar.j.d0();
                if (!callbackD0.onCreatePanelMenu(oVar.a, oVar.j)) {
                    oVar.c(null);
                    if (z && (c0Var = this.m) != null) {
                        c0Var.b(null, this.n);
                    }
                    return false;
                }
                oVar.r = false;
            }
            oVar.j.d0();
            Bundle bundle = oVar.s;
            if (bundle != null) {
                oVar.j.P(bundle);
                oVar.s = null;
            }
            if (!callbackD0.onPreparePanel(0, oVar.i, oVar.j)) {
                if (z && (c0Var2 = this.m) != null) {
                    c0Var2.b(null, this.n);
                }
                oVar.j.c0();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            oVar.p = z2;
            oVar.j.setQwertyMode(z2);
            oVar.j.c0();
        }
        oVar.m = true;
        oVar.n = false;
        this.I = oVar;
        return true;
    }

    private void z0(androidx.appcompat.view.menu.g gVar, boolean z) {
        c0 c0Var = this.m;
        if (c0Var == null || !c0Var.f() || (ViewConfiguration.get(this.f26f).hasPermanentMenuKey() && !this.m.c())) {
            o oVarB0 = b0(0, true);
            oVarB0.q = true;
            O(oVarB0, false);
            v0(oVarB0, null);
            return;
        }
        Window.Callback callbackD0 = d0();
        if (this.m.e() && z) {
            this.m.g();
            if (this.N) {
                return;
            }
            callbackD0.onPanelClosed(108, b0(0, true).j);
            return;
        }
        if (callbackD0 == null || this.N) {
            return;
        }
        if (this.U && (this.V & 1) != 0) {
            this.f27g.getDecorView().removeCallbacks(this.W);
            this.W.run();
        }
        o oVarB1 = b0(0, true);
        androidx.appcompat.view.menu.g gVar2 = oVarB1.j;
        if (gVar2 == null || oVarB1.r || !callbackD0.onPreparePanel(0, oVarB1.i, gVar2)) {
            return;
        }
        callbackD0.onMenuOpened(108, oVarB1.j);
        this.m.a();
    }

    @Override // androidx.appcompat.app.e
    public void A(View view) {
        V();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.h.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void B(View view, ViewGroup.LayoutParams layoutParams) {
        V();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.h.a().onContentChanged();
    }

    final boolean B0() {
        ViewGroup viewGroup;
        return this.v && (viewGroup = this.w) != null && r.J(viewGroup);
    }

    @Override // androidx.appcompat.app.e
    public void C(Toolbar toolbar) {
        Window window;
        Window.Callback callbackW;
        if (this.f25e instanceof Activity) {
            androidx.appcompat.app.a aVarK = k();
            if (aVarK instanceof androidx.appcompat.app.l) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.k = null;
            if (aVarK != null) {
                aVarK.n();
            }
            if (toolbar != null) {
                androidx.appcompat.app.i iVar = new androidx.appcompat.app.i(toolbar, c0(), this.h);
                this.j = iVar;
                window = this.f27g;
                callbackW = iVar.w();
            } else {
                this.j = null;
                window = this.f27g;
                callbackW = this.h;
            }
            window.setCallback(callbackW);
            m();
        }
    }

    @Override // androidx.appcompat.app.e
    public void D(int i2) {
        this.P = i2;
    }

    public d.a.o.b D0(d.a.o.b.a aVar) {
        androidx.appcompat.app.d dVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        d.a.o.b bVar = this.p;
        if (bVar != null) {
            bVar.c();
        }
        i iVar = new i(aVar);
        androidx.appcompat.app.a aVarK = k();
        if (aVarK != null) {
            d.a.o.b bVarU = aVarK.u(iVar);
            this.p = bVarU;
            if (bVarU != null && (dVar = this.i) != null) {
                dVar.c(bVarU);
            }
        }
        if (this.p == null) {
            this.p = E0(iVar);
        }
        return this.p;
    }

    @Override // androidx.appcompat.app.e
    public final void E(CharSequence charSequence) {
        this.l = charSequence;
        c0 c0Var = this.m;
        if (c0Var != null) {
            c0Var.setWindowTitle(charSequence);
            return;
        }
        if (w0() != null) {
            w0().t(charSequence);
            return;
        }
        TextView textView = this.x;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    d.a.o.b E0(d.a.o.b.a aVar) {
        d.a.o.b bVarH;
        Context dVar;
        androidx.appcompat.app.d dVar2;
        U();
        d.a.o.b bVar = this.p;
        if (bVar != null) {
            bVar.c();
        }
        if (!(aVar instanceof i)) {
            aVar = new i(aVar);
        }
        androidx.appcompat.app.d dVar3 = this.i;
        if (dVar3 == null || this.N) {
            bVarH = null;
        } else {
            try {
                bVarH = dVar3.h(aVar);
            } catch (AbstractMethodError unused) {
                bVarH = null;
            }
        }
        if (bVarH != null) {
            this.p = bVarH;
        } else {
            if (this.q == null) {
                if (this.E) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f26f.getTheme();
                    theme.resolveAttribute(d.a.a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f26f.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new d.a.o.d(this.f26f, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.f26f;
                    }
                    this.q = new ActionBarContextView(dVar);
                    PopupWindow popupWindow = new PopupWindow(dVar, (AttributeSet) null, d.a.a.actionModePopupWindowStyle);
                    this.r = popupWindow;
                    androidx.core.widget.h.b(popupWindow, 2);
                    this.r.setContentView(this.q);
                    this.r.setWidth(-1);
                    dVar.getTheme().resolveAttribute(d.a.a.actionBarSize, typedValue, true);
                    this.q.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.r.setHeight(-2);
                    this.s = new RunnableC0001f();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.w.findViewById(d.a.f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(Y()));
                        this.q = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.q != null) {
                U();
                this.q.k();
                d.a.o.e eVar = new d.a.o.e(this.q.getContext(), this.q, aVar, this.r == null);
                if (aVar.d(eVar, eVar.e())) {
                    eVar.k();
                    this.q.h(eVar);
                    this.p = eVar;
                    if (B0()) {
                        this.q.setAlpha(0.0f);
                        v vVarC = r.c(this.q);
                        vVarC.a(1.0f);
                        this.t = vVarC;
                        vVarC.f(new g());
                    } else {
                        this.q.setAlpha(1.0f);
                        this.q.setVisibility(0);
                        this.q.sendAccessibilityEvent(32);
                        if (this.q.getParent() instanceof View) {
                            r.a0((View) this.q.getParent());
                        }
                    }
                    if (this.r != null) {
                        this.f27g.getDecorView().post(this.s);
                    }
                } else {
                    this.p = null;
                }
            }
        }
        d.a.o.b bVar2 = this.p;
        if (bVar2 != null && (dVar2 = this.i) != null) {
            dVar2.c(bVar2);
        }
        return this.p;
    }

    public boolean F() {
        return G(true);
    }

    int J0(int i2) {
        boolean z;
        boolean z2;
        ActionBarContextView actionBarContextView = this.q;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.q.getLayoutParams();
            boolean z3 = true;
            if (this.q.isShown()) {
                if (this.Y == null) {
                    this.Y = new Rect();
                    this.Z = new Rect();
                }
                Rect rect = this.Y;
                Rect rect2 = this.Z;
                rect.set(0, i2, 0, 0);
                c1.a(this.w, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i2 : 0)) {
                    marginLayoutParams.topMargin = i2;
                    View view = this.y;
                    if (view == null) {
                        View view2 = new View(this.f26f);
                        this.y = view2;
                        view2.setBackgroundColor(this.f26f.getResources().getColor(d.a.c.abc_input_method_navigation_guard));
                        this.w.addView(this.y, -1, new ViewGroup.LayoutParams(-1, i2));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i2) {
                            layoutParams.height = i2;
                            this.y.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = this.y != null;
                if (!this.D && z3) {
                    i2 = 0;
                }
                boolean z4 = z3;
                z3 = z2;
                z = z4;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                z3 = false;
            }
            if (z3) {
                this.q.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.y;
        if (view3 != null) {
            view3.setVisibility(z ? 0 : 8);
        }
        return i2;
    }

    void K(int i2, o oVar, Menu menu) {
        if (menu == null) {
            if (oVar == null && i2 >= 0) {
                o[] oVarArr = this.H;
                if (i2 < oVarArr.length) {
                    oVar = oVarArr[i2];
                }
            }
            if (oVar != null) {
                menu = oVar.j;
            }
        }
        if ((oVar == null || oVar.o) && !this.N) {
            this.h.a().onPanelClosed(i2, menu);
        }
    }

    void L(androidx.appcompat.view.menu.g gVar) {
        if (this.G) {
            return;
        }
        this.G = true;
        this.m.j();
        Window.Callback callbackD0 = d0();
        if (callbackD0 != null && !this.N) {
            callbackD0.onPanelClosed(108, gVar);
        }
        this.G = false;
    }

    void N(int i2) {
        O(b0(i2, true), true);
    }

    void O(o oVar, boolean z) {
        ViewGroup viewGroup;
        c0 c0Var;
        if (z && oVar.a == 0 && (c0Var = this.m) != null && c0Var.e()) {
            L(oVar.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f26f.getSystemService("window");
        if (windowManager != null && oVar.o && (viewGroup = oVar.f33g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                K(oVar.a, oVar, null);
            }
        }
        oVar.m = false;
        oVar.n = false;
        oVar.o = false;
        oVar.h = null;
        oVar.q = true;
        if (this.I == oVar) {
            this.I = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View Q(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        AppCompatViewInflater appCompatViewInflater;
        boolean zC0 = false;
        if (this.a0 == null) {
            String string = this.f26f.obtainStyledAttributes(d.a.j.AppCompatTheme).getString(d.a.j.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                appCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.a0 = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    appCompatViewInflater = new AppCompatViewInflater();
                    this.a0 = appCompatViewInflater;
                }
            }
            this.a0 = appCompatViewInflater;
        }
        if (c0) {
            if (!(attributeSet instanceof XmlPullParser)) {
                zC0 = C0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                zC0 = true;
            }
            z = zC0;
        } else {
            z = false;
        }
        return this.a0.createView(view, str, context, attributeSet, z, c0, true, b1.b());
    }

    void R() {
        androidx.appcompat.view.menu.g gVar;
        c0 c0Var = this.m;
        if (c0Var != null) {
            c0Var.j();
        }
        if (this.r != null) {
            this.f27g.getDecorView().removeCallbacks(this.s);
            if (this.r.isShowing()) {
                try {
                    this.r.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.r = null;
        }
        U();
        o oVarB0 = b0(0, false);
        if (oVarB0 == null || (gVar = oVarB0.j) == null) {
            return;
        }
        gVar.close();
    }

    boolean S(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f25e;
        if (((obj instanceof d.f.k.d.a) || (obj instanceof androidx.appcompat.app.g)) && (decorView = this.f27g.getDecorView()) != null && d.f.k.d.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.h.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? n0(keyCode, keyEvent) : q0(keyCode, keyEvent);
    }

    void T(int i2) {
        o oVarB0;
        o oVarB1 = b0(i2, true);
        if (oVarB1.j != null) {
            Bundle bundle = new Bundle();
            oVarB1.j.Q(bundle);
            if (bundle.size() > 0) {
                oVarB1.s = bundle;
            }
            oVarB1.j.d0();
            oVarB1.j.clear();
        }
        oVarB1.r = true;
        oVarB1.q = true;
        if ((i2 != 108 && i2 != 0) || this.m == null || (oVarB0 = b0(0, false)) == null) {
            return;
        }
        oVarB0.m = false;
        y0(oVarB0, null);
    }

    void U() {
        v vVar = this.t;
        if (vVar != null) {
            vVar.b();
        }
    }

    o X(Menu menu) {
        o[] oVarArr = this.H;
        int length = oVarArr != null ? oVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            o oVar = oVarArr[i2];
            if (oVar != null && oVar.j == menu) {
                return oVar;
            }
        }
        return null;
    }

    final Context Y() {
        androidx.appcompat.app.a aVarK = k();
        Context contextK = aVarK != null ? aVarK.k() : null;
        return contextK == null ? this.f26f : contextK;
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void a(androidx.appcompat.view.menu.g gVar) {
        z0(gVar, true);
    }

    final l a0() {
        if (this.S == null) {
            this.S = new m(androidx.appcompat.app.k.a(this.f26f));
        }
        return this.S;
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean b(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        o oVarX;
        Window.Callback callbackD0 = d0();
        if (callbackD0 == null || this.N || (oVarX = X(gVar.D())) == null) {
            return false;
        }
        return callbackD0.onMenuItemSelected(oVarX.a, menuItem);
    }

    protected o b0(int i2, boolean z) {
        o[] oVarArr = this.H;
        if (oVarArr == null || oVarArr.length <= i2) {
            o[] oVarArr2 = new o[i2 + 1];
            if (oVarArr != null) {
                System.arraycopy(oVarArr, 0, oVarArr2, 0, oVarArr.length);
            }
            this.H = oVarArr2;
            oVarArr = oVarArr2;
        }
        o oVar = oVarArr[i2];
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = new o(i2);
        oVarArr[i2] = oVar2;
        return oVar2;
    }

    @Override // androidx.appcompat.app.e
    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        V();
        ((ViewGroup) this.w.findViewById(R.id.content)).addView(view, layoutParams);
        this.h.a().onContentChanged();
    }

    final CharSequence c0() {
        Object obj = this.f25e;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.l;
    }

    @Override // androidx.appcompat.app.e
    public void d(Context context) {
        G(false);
        this.K = true;
    }

    final Window.Callback d0() {
        return this.f27g.getCallback();
    }

    @Override // androidx.appcompat.app.e
    public <T extends View> T g(int i2) {
        V();
        return (T) this.f27g.findViewById(i2);
    }

    @Override // androidx.appcompat.app.e
    public int i() {
        return this.O;
    }

    @Override // androidx.appcompat.app.e
    public MenuInflater j() {
        if (this.k == null) {
            e0();
            androidx.appcompat.app.a aVar = this.j;
            this.k = new d.a.o.g(aVar != null ? aVar.k() : this.f26f);
        }
        return this.k;
    }

    @Override // androidx.appcompat.app.e
    public androidx.appcompat.app.a k() {
        e0();
        return this.j;
    }

    public boolean k0() {
        return this.u;
    }

    @Override // androidx.appcompat.app.e
    public void l() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f26f);
        if (layoutInflaterFrom.getFactory() == null) {
            d.f.k.e.b(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof f) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    int l0(int i2) {
        l lVarA0;
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                    lVarA0 = Z();
                }
            } else {
                if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) this.f26f.getSystemService(UiModeManager.class)).getNightMode() == 0) {
                    return -1;
                }
                lVarA0 = a0();
            }
            return lVarA0.c();
        }
        return i2;
    }

    @Override // androidx.appcompat.app.e
    public void m() {
        androidx.appcompat.app.a aVarK = k();
        if (aVarK == null || !aVarK.l()) {
            i0(0);
        }
    }

    boolean m0() {
        d.a.o.b bVar = this.p;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        androidx.appcompat.app.a aVarK = k();
        return aVarK != null && aVarK.h();
    }

    boolean n0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.J = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            o0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return Q(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.e
    public void p(Configuration configuration) {
        androidx.appcompat.app.a aVarK;
        if (this.B && this.v && (aVarK = k()) != null) {
            aVarK.m(configuration);
        }
        androidx.appcompat.widget.j.b().g(this.f26f);
        G(false);
    }

    boolean p0(int i2, KeyEvent keyEvent) {
        androidx.appcompat.app.a aVarK = k();
        if (aVarK != null && aVarK.o(i2, keyEvent)) {
            return true;
        }
        o oVar = this.I;
        if (oVar != null && x0(oVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            o oVar2 = this.I;
            if (oVar2 != null) {
                oVar2.n = true;
            }
            return true;
        }
        if (this.I == null) {
            o oVarB0 = b0(0, true);
            y0(oVarB0, keyEvent);
            boolean zX0 = x0(oVarB0, keyEvent.getKeyCode(), keyEvent, 1);
            oVarB0.m = false;
            if (zX0) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void q(Bundle bundle) {
        this.K = true;
        G(false);
        W();
        Object obj = this.f25e;
        if (obj instanceof Activity) {
            String strC = null;
            try {
                strC = androidx.core.app.e.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (strC != null) {
                androidx.appcompat.app.a aVarW0 = w0();
                if (aVarW0 == null) {
                    this.X = true;
                } else {
                    aVarW0.r(true);
                }
            }
        }
        this.L = true;
    }

    boolean q0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z = this.J;
            this.J = false;
            o oVarB0 = b0(0, false);
            if (oVarB0 != null && oVarB0.o) {
                if (!z) {
                    O(oVarB0, true);
                }
                return true;
            }
            if (m0()) {
                return true;
            }
        } else if (i2 == 82) {
            r0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void r() {
        androidx.appcompat.app.e.o(this);
        if (this.U) {
            this.f27g.getDecorView().removeCallbacks(this.W);
        }
        this.M = false;
        this.N = true;
        androidx.appcompat.app.a aVar = this.j;
        if (aVar != null) {
            aVar.n();
        }
        M();
    }

    @Override // androidx.appcompat.app.e
    public void s(Bundle bundle) {
        V();
    }

    void s0(int i2) {
        androidx.appcompat.app.a aVarK;
        if (i2 != 108 || (aVarK = k()) == null) {
            return;
        }
        aVarK.i(true);
    }

    @Override // androidx.appcompat.app.e
    public void t() {
        androidx.appcompat.app.a aVarK = k();
        if (aVarK != null) {
            aVarK.s(true);
        }
    }

    void t0(int i2) {
        if (i2 == 108) {
            androidx.appcompat.app.a aVarK = k();
            if (aVarK != null) {
                aVarK.i(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            o oVarB0 = b0(i2, true);
            if (oVarB0.o) {
                O(oVarB0, false);
            }
        }
    }

    @Override // androidx.appcompat.app.e
    public void u(Bundle bundle) {
        if (this.O != -100) {
            b0.put(this.f25e.getClass(), Integer.valueOf(this.O));
        }
    }

    void u0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.e
    public void v() {
        this.M = true;
        F();
        androidx.appcompat.app.e.n(this);
    }

    @Override // androidx.appcompat.app.e
    public void w() {
        this.M = false;
        androidx.appcompat.app.e.o(this);
        androidx.appcompat.app.a aVarK = k();
        if (aVarK != null) {
            aVarK.s(false);
        }
        if (this.f25e instanceof Dialog) {
            M();
        }
    }

    final androidx.appcompat.app.a w0() {
        return this.j;
    }

    @Override // androidx.appcompat.app.e
    public boolean y(int i2) {
        int iA0 = A0(i2);
        if (this.F && iA0 == 108) {
            return false;
        }
        if (this.B && iA0 == 1) {
            this.B = false;
        }
        if (iA0 == 1) {
            F0();
            this.F = true;
            return true;
        }
        if (iA0 == 2) {
            F0();
            this.z = true;
            return true;
        }
        if (iA0 == 5) {
            F0();
            this.A = true;
            return true;
        }
        if (iA0 == 10) {
            F0();
            this.D = true;
            return true;
        }
        if (iA0 == 108) {
            F0();
            this.B = true;
            return true;
        }
        if (iA0 != 109) {
            return this.f27g.requestFeature(iA0);
        }
        F0();
        this.C = true;
        return true;
    }

    @Override // androidx.appcompat.app.e
    public void z(int i2) {
        V();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f26f).inflate(i2, viewGroup);
        this.h.a().onContentChanged();
    }
}
