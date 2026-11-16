package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.content.c.g;

/* JADX INFO: loaded from: classes.dex */
public class ListPreference extends DialogPreference {
    private CharSequence[] u;
    private CharSequence[] v;
    private String w;
    private String x;

    public static final class a implements Preference.c<ListPreference> {
        private static a a;

        private a() {
        }

        public static a b() {
            if (a == null) {
                a = new a();
            }
            return a;
        }

        @Override // androidx.preference.Preference.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(ListPreference listPreference) {
            return TextUtils.isEmpty(listPreference.x()) ? listPreference.c().getString(e.not_set) : listPreference.x();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, c.dialogPreferenceStyle, R.attr.dialogPreferenceStyle));
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.ListPreference, i, i2);
        this.u = g.q(typedArrayObtainStyledAttributes, f.ListPreference_entries, f.ListPreference_android_entries);
        this.v = g.q(typedArrayObtainStyledAttributes, f.ListPreference_entryValues, f.ListPreference_android_entryValues);
        int i3 = f.ListPreference_useSimpleSummaryProvider;
        if (g.b(typedArrayObtainStyledAttributes, i3, i3, false)) {
            s(a.b());
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f.Preference, i, i2);
        this.x = g.o(typedArrayObtainStyledAttributes2, f.Preference_summary, f.Preference_android_summary);
        typedArrayObtainStyledAttributes2.recycle();
    }

    private int y() {
        return v(this.w);
    }

    @Override // androidx.preference.Preference
    public CharSequence g() {
        if (h() != null) {
            return h().a(this);
        }
        CharSequence charSequenceX = x();
        CharSequence charSequenceG = super.g();
        String str = this.x;
        if (str == null) {
            return charSequenceG;
        }
        Object[] objArr = new Object[1];
        if (charSequenceX == null) {
            charSequenceX = "";
        }
        objArr[0] = charSequenceX;
        String str2 = String.format(str, objArr);
        if (TextUtils.equals(str2, charSequenceG)) {
            return charSequenceG;
        }
        Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return str2;
    }

    @Override // androidx.preference.Preference
    protected Object p(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    public int v(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.v) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.v[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] w() {
        return this.u;
    }

    public CharSequence x() {
        CharSequence[] charSequenceArr;
        int iY = y();
        if (iY < 0 || (charSequenceArr = this.u) == null) {
            return null;
        }
        return charSequenceArr[iY];
    }
}
