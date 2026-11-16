package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference extends Preference {
    int t;
    private int u;
    private int v;
    boolean w;
    boolean x;

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.seekBarPreferenceStyle);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.SeekBarPreference, i, i2);
        this.t = typedArrayObtainStyledAttributes.getInt(f.SeekBarPreference_min, 0);
        v(typedArrayObtainStyledAttributes.getInt(f.SeekBarPreference_android_max, 100));
        w(typedArrayObtainStyledAttributes.getInt(f.SeekBarPreference_seekBarIncrement, 0));
        this.w = typedArrayObtainStyledAttributes.getBoolean(f.SeekBarPreference_adjustable, true);
        typedArrayObtainStyledAttributes.getBoolean(f.SeekBarPreference_showSeekBarValue, false);
        this.x = typedArrayObtainStyledAttributes.getBoolean(f.SeekBarPreference_updatesContinuously, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    protected Object p(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }

    public final void v(int i) {
        int i2 = this.t;
        if (i < i2) {
            i = i2;
        }
        if (i != this.u) {
            this.u = i;
            m();
        }
    }

    public final void w(int i) {
        if (i != this.v) {
            this.v = Math.min(this.u - this.t, Math.abs(i));
            m();
        }
    }
}
