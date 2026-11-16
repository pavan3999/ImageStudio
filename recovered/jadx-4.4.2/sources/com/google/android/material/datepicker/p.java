package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
abstract class p<S> extends Fragment {
    protected final LinkedHashSet<o<S>> X = new LinkedHashSet<>();

    p() {
    }

    boolean m1(o<S> oVar) {
        return this.X.add(oVar);
    }

    void n1() {
        this.X.clear();
    }
}
