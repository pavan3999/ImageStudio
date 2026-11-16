package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

/* JADX INFO: loaded from: classes.dex */
public class DropDownPreference extends ListPreference {
    private final Context y;
    private final ArrayAdapter z;

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.dropdownPreferenceStyle);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.y = context;
        this.z = z();
        A();
    }

    private void A() {
        this.z.clear();
        if (w() != null) {
            for (CharSequence charSequence : w()) {
                this.z.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    protected void m() {
        super.m();
        ArrayAdapter arrayAdapter = this.z;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    protected ArrayAdapter z() {
        return new ArrayAdapter(this.y, R.layout.simple_spinner_dropdown_item);
    }
}
