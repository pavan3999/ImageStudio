package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes.dex */
class h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, m.a {
    private g b;
    private androidx.appcompat.app.b c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    e f88d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private m.a f89e;

    public h(g gVar) {
        this.b = gVar;
    }

    public void a() {
        androidx.appcompat.app.b bVar = this.c;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    public void b(IBinder iBinder) {
        g gVar = this.b;
        androidx.appcompat.app.b.a aVar = new androidx.appcompat.app.b.a(gVar.u());
        e eVar = new e(aVar.b(), d.a.g.abc_list_menu_item_layout);
        this.f88d = eVar;
        eVar.e(this);
        this.b.b(this.f88d);
        aVar.c(this.f88d.a(), this);
        View viewY = gVar.y();
        if (viewY != null) {
            aVar.d(viewY);
        } else {
            aVar.e(gVar.w());
            aVar.m(gVar.x());
        }
        aVar.i(this);
        androidx.appcompat.app.b bVarA = aVar.a();
        this.c = bVarA;
        bVarA.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.c.show();
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void c(g gVar, boolean z) {
        if (z || gVar == this.b) {
            a();
        }
        m.a aVar = this.f89e;
        if (aVar != null) {
            aVar.c(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean d(g gVar) {
        m.a aVar = this.f89e;
        if (aVar != null) {
            return aVar.d(gVar);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.b.L((i) this.f88d.a().getItem(i), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f88d.c(this.b, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.b.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.b.performShortcut(i, keyEvent, 0);
    }
}
