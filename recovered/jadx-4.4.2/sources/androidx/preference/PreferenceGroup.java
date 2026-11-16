package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import d.d.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    final g<String, Long> t;
    private List<Preference> u;

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.t = new g<>();
        new Handler();
        this.u = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.PreferenceGroup, i, i2);
        int i3 = f.PreferenceGroup_orderingFromXml;
        androidx.core.content.c.g.b(typedArrayObtainStyledAttributes, i3, i3, true);
        if (typedArrayObtainStyledAttributes.hasValue(f.PreferenceGroup_initialExpandedChildrenCount)) {
            int i4 = f.PreferenceGroup_initialExpandedChildrenCount;
            x(androidx.core.content.c.g.d(typedArrayObtainStyledAttributes, i4, i4, Integer.MAX_VALUE));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void n(boolean z) {
        super.n(z);
        int iW = w();
        for (int i = 0; i < iW; i++) {
            v(i).q(this, z);
        }
    }

    public Preference v(int i) {
        return this.u.get(i);
    }

    public int w() {
        return this.u.size();
    }

    public void x(int i) {
        if (i == Integer.MAX_VALUE || j()) {
            return;
        }
        Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
    }
}
