package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.b1;

/* JADX INFO: loaded from: classes.dex */
public class c extends androidx.fragment.app.d implements d, androidx.core.app.g.a {
    private e r;
    private Resources s;

    private boolean C(int i, KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Deprecated
    public void A() {
    }

    public boolean B() {
        Intent intentJ = j();
        if (intentJ == null) {
            return false;
        }
        if (!F(intentJ)) {
            E(intentJ);
            return true;
        }
        androidx.core.app.g gVarD = androidx.core.app.g.d(this);
        x(gVarD);
        z(gVarD);
        gVarD.e();
        try {
            androidx.core.app.a.h(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    public void D(Toolbar toolbar) {
        v().C(toolbar);
    }

    public void E(Intent intent) {
        androidx.core.app.e.e(this, intent);
    }

    public boolean F(Intent intent) {
        return androidx.core.app.e.f(this, intent);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        v().c(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        v().d(context);
    }

    @Override // androidx.appcompat.app.d
    public void c(d.a.o.b bVar) {
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        a aVarW = w();
        if (getWindow().hasFeature(0)) {
            if (aVarW == null || !aVarW.g()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.core.app.d, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a aVarW = w();
        if (keyCode == 82 && aVarW != null && aVarW.p(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) v().g(i);
    }

    @Override // androidx.appcompat.app.d
    public void g(d.a.o.b bVar) {
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return v().j();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.s == null && b1.b()) {
            this.s = new b1(this, super.getResources());
        }
        Resources resources = this.s;
        return resources == null ? super.getResources() : resources;
    }

    @Override // androidx.appcompat.app.d
    public d.a.o.b h(d.a.o.b.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        v().m();
    }

    @Override // androidx.core.app.g.a
    public Intent j() {
        return androidx.core.app.e.a(this);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.s != null) {
            this.s.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        v().p(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        A();
    }

    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        e eVarV = v();
        eVarV.l();
        eVarV.q(bundle);
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        v().r();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (C(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a aVarW = w();
        if (menuItem.getItemId() != 16908332 || aVarW == null || (aVarW.j() & 4) == 0) {
            return false;
        }
        return B();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        v().s(bundle);
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        v().t();
    }

    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.d, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        v().u(bundle);
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onStart() {
        super.onStart();
        v().v();
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onStop() {
        super.onStop();
        v().w();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        v().E(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        a aVarW = w();
        if (getWindow().hasFeature(0)) {
            if (aVarW == null || !aVarW.q()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        v().z(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        v().A(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        v().B(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        v().D(i);
    }

    @Override // androidx.fragment.app.d
    public void u() {
        v().m();
    }

    public e v() {
        if (this.r == null) {
            this.r = e.e(this, this);
        }
        return this.r;
    }

    public a w() {
        return v().k();
    }

    public void x(androidx.core.app.g gVar) {
        gVar.b(this);
    }

    protected void y(int i) {
    }

    public void z(androidx.core.app.g gVar) {
    }
}
