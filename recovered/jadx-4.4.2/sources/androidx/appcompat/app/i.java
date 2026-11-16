package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.x0;
import d.f.k.r;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class i extends androidx.appcompat.app.a {
    d0 a;
    boolean b;
    Window.Callback c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f38d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f39e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<androidx.appcompat.app.a.b> f40f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Runnable f41g = new a();
    private final Toolbar.f h = new b();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.x();
        }
    }

    class b implements Toolbar.f {
        b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.f
        public boolean onMenuItemClick(MenuItem menuItem) {
            return i.this.c.onMenuItemSelected(0, menuItem);
        }
    }

    private final class c implements m.a {
        private boolean b;

        c() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void c(androidx.appcompat.view.menu.g gVar, boolean z) {
            if (this.b) {
                return;
            }
            this.b = true;
            i.this.a.h();
            Window.Callback callback = i.this.c;
            if (callback != null) {
                callback.onPanelClosed(108, gVar);
            }
            this.b = false;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean d(androidx.appcompat.view.menu.g gVar) {
            Window.Callback callback = i.this.c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, gVar);
            return true;
        }
    }

    private final class d implements androidx.appcompat.view.menu.g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void a(androidx.appcompat.view.menu.g gVar) {
            i iVar = i.this;
            if (iVar.c != null) {
                if (iVar.a.e()) {
                    i.this.c.onPanelClosed(108, gVar);
                } else if (i.this.c.onPreparePanel(0, null, gVar)) {
                    i.this.c.onMenuOpened(108, gVar);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean b(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            return false;
        }
    }

    private class e extends d.a.o.i {
        public e(Window.Callback callback) {
            super(callback);
        }

        @Override // d.a.o.i, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            return i == 0 ? new View(i.this.a.v()) : super.onCreatePanelView(i);
        }

        @Override // d.a.o.i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
            if (zOnPreparePanel) {
                i iVar = i.this;
                if (!iVar.b) {
                    iVar.a.d();
                    i.this.b = true;
                }
            }
            return zOnPreparePanel;
        }
    }

    i(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.a = new x0(toolbar, false);
        e eVar = new e(callback);
        this.c = eVar;
        this.a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(this.h);
        this.a.setWindowTitle(charSequence);
    }

    private Menu v() {
        if (!this.f38d) {
            this.a.i(new c(), new d());
            this.f38d = true;
        }
        return this.a.n();
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        return this.a.g();
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        if (!this.a.o()) {
            return false;
        }
        this.a.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z) {
        if (z == this.f39e) {
            return;
        }
        this.f39e = z;
        int size = this.f40f.size();
        for (int i = 0; i < size; i++) {
            this.f40f.get(i).a(z);
        }
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.a.k();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        return this.a.v();
    }

    @Override // androidx.appcompat.app.a
    public boolean l() {
        this.a.r().removeCallbacks(this.f41g);
        r.V(this.a.r(), this.f41g);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        super.m(configuration);
    }

    @Override // androidx.appcompat.app.a
    void n() {
        this.a.r().removeCallbacks(this.f41g);
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i, KeyEvent keyEvent) {
        Menu menuV = v();
        if (menuV == null) {
            return false;
        }
        menuV.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuV.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean q() {
        return this.a.a();
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void t(CharSequence charSequence) {
        this.a.setWindowTitle(charSequence);
    }

    public Window.Callback w() {
        return this.c;
    }

    void x() {
        Menu menuV = v();
        androidx.appcompat.view.menu.g gVar = menuV instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menuV : null;
        if (gVar != null) {
            gVar.d0();
        }
        try {
            menuV.clear();
            if (!this.c.onCreatePanelMenu(0, menuV) || !this.c.onPreparePanel(0, null, menuV)) {
                menuV.clear();
            }
        } finally {
            if (gVar != null) {
                gVar.c0();
            }
        }
    }
}
