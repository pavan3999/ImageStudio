package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.content.c.g;

/* JADX INFO: loaded from: classes.dex */
public abstract class DialogPreference extends Preference {
    private CharSequence t;

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, c.dialogPreferenceStyle, R.attr.dialogPreferenceStyle));
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.DialogPreference, i, i2);
        String strO = g.o(typedArrayObtainStyledAttributes, f.DialogPreference_dialogTitle, f.DialogPreference_android_dialogTitle);
        this.t = strO;
        if (strO == null) {
            this.t = i();
        }
        g.o(typedArrayObtainStyledAttributes, f.DialogPreference_dialogMessage, f.DialogPreference_android_dialogMessage);
        g.c(typedArrayObtainStyledAttributes, f.DialogPreference_dialogIcon, f.DialogPreference_android_dialogIcon);
        g.o(typedArrayObtainStyledAttributes, f.DialogPreference_positiveButtonText, f.DialogPreference_android_positiveButtonText);
        g.o(typedArrayObtainStyledAttributes, f.DialogPreference_negativeButtonText, f.DialogPreference_android_negativeButtonText);
        g.n(typedArrayObtainStyledAttributes, f.DialogPreference_dialogLayout, f.DialogPreference_android_dialogLayout, 0);
        typedArrayObtainStyledAttributes.recycle();
    }
}
