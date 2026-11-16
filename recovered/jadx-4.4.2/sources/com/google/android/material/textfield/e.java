package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: classes.dex */
abstract class e {
    TextInputLayout a;
    Context b;
    CheckableImageButton c;

    e(TextInputLayout textInputLayout) {
        this.a = textInputLayout;
        this.b = textInputLayout.getContext();
        this.c = textInputLayout.getEndIconView();
    }

    abstract void a();

    boolean b(int i) {
        return true;
    }

    boolean c() {
        return false;
    }
}
