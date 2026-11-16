package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public class c extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private Handler X;
    private Runnable Y = new a();
    private DialogInterface.OnCancelListener Z = new b();
    private DialogInterface.OnDismissListener a0 = new DialogInterfaceOnDismissListenerC0011c();
    private int b0 = 0;
    private int c0 = 0;
    private boolean d0 = true;
    private boolean e0 = true;
    private int f0 = -1;
    private boolean g0;
    private Dialog h0;
    private boolean i0;
    private boolean j0;
    private boolean k0;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            c.this.a0.onDismiss(c.this.h0);
        }
    }

    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(DialogInterface dialogInterface) {
            if (c.this.h0 != null) {
                c cVar = c.this;
                cVar.onCancel(cVar.h0);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.c$c, reason: collision with other inner class name */
    class DialogInterfaceOnDismissListenerC0011c implements DialogInterface.OnDismissListener {
        DialogInterfaceOnDismissListenerC0011c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(DialogInterface dialogInterface) {
            if (c.this.h0 != null) {
                c cVar = c.this;
                cVar.onDismiss(cVar.h0);
            }
        }
    }

    private void p1(boolean z, boolean z2) {
        if (this.j0) {
            return;
        }
        this.j0 = true;
        this.k0 = false;
        Dialog dialog = this.h0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.h0.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.X.getLooper()) {
                    onDismiss(this.h0);
                } else {
                    this.X.post(this.Y);
                }
            }
        }
        this.i0 = true;
        if (this.f0 >= 0) {
            z().D0(this.f0, 1);
            this.f0 = -1;
            return;
        }
        t tVarI = z().i();
        tVarI.l(this);
        if (z) {
            tVarI.g();
        } else {
            tVarI.f();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void U(Bundle bundle) {
        Bundle bundle2;
        super.U(bundle);
        if (this.e0) {
            View viewJ = J();
            if (this.h0 != null) {
                if (viewJ != null) {
                    if (viewJ.getParent() != null) {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                    this.h0.setContentView(viewJ);
                }
                d dVarI = i();
                if (dVarI != null) {
                    this.h0.setOwnerActivity(dVarI);
                }
                this.h0.setCancelable(this.d0);
                this.h0.setOnCancelListener(this.Z);
                this.h0.setOnDismissListener(this.a0);
                if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                    return;
                }
                this.h0.onRestoreInstanceState(bundle2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void X(Context context) {
        super.X(context);
        if (this.k0) {
            return;
        }
        this.j0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void a0(Bundle bundle) {
        super.a0(bundle);
        this.X = new Handler();
        this.e0 = this.x == 0;
        if (bundle != null) {
            this.b0 = bundle.getInt("android:style", 0);
            this.c0 = bundle.getInt("android:theme", 0);
            this.d0 = bundle.getBoolean("android:cancelable", true);
            this.e0 = bundle.getBoolean("android:showsDialog", this.e0);
            this.f0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void h0() {
        super.h0();
        Dialog dialog = this.h0;
        if (dialog != null) {
            this.i0 = true;
            dialog.setOnDismissListener(null);
            this.h0.dismiss();
            if (!this.j0) {
                onDismiss(this.h0);
            }
            this.h0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void i0() {
        super.i0();
        if (this.k0 || this.j0) {
            return;
        }
        this.j0 = true;
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater j0(Bundle bundle) {
        LayoutInflater layoutInflaterJ0 = super.j0(bundle);
        if (!this.e0 || this.g0) {
            return layoutInflaterJ0;
        }
        try {
            this.g0 = true;
            Dialog dialogS1 = s1(bundle);
            this.h0 = dialogS1;
            u1(dialogS1, this.b0);
            return layoutInflaterJ0.cloneInContext(t1().getContext());
        } finally {
            this.g0 = false;
        }
    }

    public void o1() {
        p1(false, false);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.i0) {
            return;
        }
        p1(true, true);
    }

    public Dialog q1() {
        return this.h0;
    }

    public int r1() {
        return this.c0;
    }

    public Dialog s1(Bundle bundle) {
        return new Dialog(Z0(), r1());
    }

    public final Dialog t1() {
        Dialog dialogQ1 = q1();
        if (dialogQ1 != null) {
            return dialogQ1;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void u1(Dialog dialog, int i) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void v1(m mVar, String str) {
        this.j0 = false;
        this.k0 = true;
        t tVarI = mVar.i();
        tVarI.d(this, str);
        tVarI.f();
    }

    @Override // androidx.fragment.app.Fragment
    public void w0(Bundle bundle) {
        super.w0(bundle);
        Dialog dialog = this.h0;
        if (dialog != null) {
            bundle.putBundle("android:savedDialogState", dialog.onSaveInstanceState());
        }
        int i = this.b0;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.c0;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.d0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.e0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.f0;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void x0() {
        super.x0();
        Dialog dialog = this.h0;
        if (dialog != null) {
            this.i0 = false;
            dialog.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void y0() {
        super.y0();
        Dialog dialog = this.h0;
        if (dialog != null) {
            dialog.hide();
        }
    }
}
