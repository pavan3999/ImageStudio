package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {
    protected boolean t;
    private CharSequence u;
    private CharSequence v;
    private boolean w;
    private boolean x;

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.preference.Preference
    protected Object p(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    @Override // androidx.preference.Preference
    public boolean t() {
        boolean z;
        if (this.x) {
            z = this.t;
        } else {
            z = !this.t;
        }
        return z || super.t();
    }

    public boolean v() {
        return this.t;
    }

    public void w(boolean z) {
        boolean z2 = this.t != z;
        if (z2 || !this.w) {
            this.t = z;
            this.w = true;
            r(z);
            if (z2) {
                n(t());
                m();
            }
        }
    }

    public void x(boolean z) {
        this.x = z;
    }

    public void y(CharSequence charSequence) {
        this.v = charSequence;
        if (v()) {
            return;
        }
        m();
    }

    public void z(CharSequence charSequence) {
        this.u = charSequence;
        if (v()) {
            m();
        }
    }
}
