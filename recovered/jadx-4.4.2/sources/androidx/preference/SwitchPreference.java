package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.core.content.c.g;

/* JADX INFO: loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
    private CharSequence A;
    private final a y;
    private CharSequence z;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (SwitchPreference.this.a(Boolean.valueOf(z))) {
                SwitchPreference.this.w(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, c.switchPreferenceStyle, R.attr.switchPreferenceStyle));
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.y = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.SwitchPreference, i, i2);
        z(g.o(typedArrayObtainStyledAttributes, f.SwitchPreference_summaryOn, f.SwitchPreference_android_summaryOn));
        y(g.o(typedArrayObtainStyledAttributes, f.SwitchPreference_summaryOff, f.SwitchPreference_android_summaryOff));
        B(g.o(typedArrayObtainStyledAttributes, f.SwitchPreference_switchTextOn, f.SwitchPreference_android_switchTextOn));
        A(g.o(typedArrayObtainStyledAttributes, f.SwitchPreference_switchTextOff, f.SwitchPreference_android_switchTextOff));
        x(g.b(typedArrayObtainStyledAttributes, f.SwitchPreference_disableDependentsState, f.SwitchPreference_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public void A(CharSequence charSequence) {
        this.A = charSequence;
        m();
    }

    public void B(CharSequence charSequence) {
        this.z = charSequence;
        m();
    }
}
