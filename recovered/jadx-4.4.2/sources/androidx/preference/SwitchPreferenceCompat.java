package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.core.content.c.g;

/* JADX INFO: loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
    private CharSequence A;
    private final a y;
    private CharSequence z;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (SwitchPreferenceCompat.this.a(Boolean.valueOf(z))) {
                SwitchPreferenceCompat.this.w(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.switchPreferenceCompatStyle);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.y = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.SwitchPreferenceCompat, i, i2);
        z(g.o(typedArrayObtainStyledAttributes, f.SwitchPreferenceCompat_summaryOn, f.SwitchPreferenceCompat_android_summaryOn));
        y(g.o(typedArrayObtainStyledAttributes, f.SwitchPreferenceCompat_summaryOff, f.SwitchPreferenceCompat_android_summaryOff));
        B(g.o(typedArrayObtainStyledAttributes, f.SwitchPreferenceCompat_switchTextOn, f.SwitchPreferenceCompat_android_switchTextOn));
        A(g.o(typedArrayObtainStyledAttributes, f.SwitchPreferenceCompat_switchTextOff, f.SwitchPreferenceCompat_android_switchTextOff));
        x(g.b(typedArrayObtainStyledAttributes, f.SwitchPreferenceCompat_disableDependentsState, f.SwitchPreferenceCompat_android_disableDependentsState, false));
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
