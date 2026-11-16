package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class g extends Dialog implements d {
    private e b;
    private final d.f.k.d.a c;

    class a implements d.f.k.d.a {
        a() {
        }

        @Override // d.f.k.d.a
        public boolean i(KeyEvent keyEvent) {
            return g.this.d(keyEvent);
        }
    }

    public g(Context context, int i) {
        super(context, b(context, i));
        this.c = new a();
        e eVarA = a();
        eVarA.D(b(context, i));
        eVarA.q(null);
    }

    private static int b(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(d.a.a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public e a() {
        if (this.b == null) {
            this.b = e.f(this, this);
        }
        return this.b;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().c(view, layoutParams);
    }

    @Override // androidx.appcompat.app.d
    public void c(d.a.o.b bVar) {
    }

    boolean d(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return d.f.k.d.e(this.c, getWindow().getDecorView(), this, keyEvent);
    }

    public boolean e(int i) {
        return a().y(i);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) a().g(i);
    }

    @Override // androidx.appcompat.app.d
    public void g(d.a.o.b bVar) {
    }

    @Override // androidx.appcompat.app.d
    public d.a.o.b h(d.a.o.b.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().m();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        a().l();
        super.onCreate(bundle);
        a().q(bundle);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        a().w();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        a().z(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().A(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().B(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        a().E(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().E(charSequence);
    }
}
