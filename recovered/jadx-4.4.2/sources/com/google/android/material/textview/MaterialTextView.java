package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.z;
import e.a.a.a.k;
import e.a.a.a.x.b;
import e.a.a.a.x.c;

/* JADX INFO: loaded from: classes.dex */
public class MaterialTextView extends z {
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        int iH;
        super(context, attributeSet, i);
        if (g(context)) {
            Resources.Theme theme = context.getTheme();
            if (j(context, theme, attributeSet, i, i2) || (iH = h(theme, attributeSet, i, i2)) == -1) {
                return;
            }
            f(theme, iH);
        }
    }

    private void f(Resources.Theme theme, int i) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i, k.MaterialTextAppearance);
        int i2 = i(getContext(), typedArrayObtainStyledAttributes, k.MaterialTextAppearance_android_lineHeight, k.MaterialTextAppearance_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (i2 >= 0) {
            setLineHeight(i2);
        }
    }

    private static boolean g(Context context) {
        return b.b(context, e.a.a.a.b.textAppearanceLineHeightEnabled, true);
    }

    private static int h(Resources.Theme theme, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, k.MaterialTextView, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(k.MaterialTextView_android_textAppearance, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int i(Context context, TypedArray typedArray, int... iArr) {
        int iC = -1;
        for (int i = 0; i < iArr.length && iC < 0; i++) {
            iC = c.c(context, typedArray, iArr[i], -1);
        }
        return iC;
    }

    private static boolean j(Context context, Resources.Theme theme, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, k.MaterialTextView, i, i2);
        int i3 = i(context, typedArrayObtainStyledAttributes, k.MaterialTextView_android_lineHeight, k.MaterialTextView_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        return i3 != -1;
    }

    @Override // androidx.appcompat.widget.z, android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (g(context)) {
            f(context.getTheme(), i);
        }
    }
}
