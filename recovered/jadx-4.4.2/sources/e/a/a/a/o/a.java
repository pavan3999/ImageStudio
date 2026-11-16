package e.a.a.a.o;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.g;
import androidx.core.widget.c;
import e.a.a.a.b;
import e.a.a.a.j;
import e.a.a.a.k;

/* JADX INFO: loaded from: classes.dex */
public class a extends g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f923g = j.Widget_MaterialComponents_CompoundButton_CheckBox;
    private static final int[][] h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ColorStateList f924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f925f;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.checkboxStyle);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(com.google.android.material.internal.g.f(context, attributeSet, i, f923g), attributeSet, i);
        Context context2 = getContext();
        TypedArray typedArrayK = com.google.android.material.internal.g.k(context2, attributeSet, k.MaterialCheckBox, i, f923g, new int[0]);
        if (typedArrayK.hasValue(k.MaterialCheckBox_buttonTint)) {
            c.c(this, e.a.a.a.x.c.a(context2, typedArrayK, k.MaterialCheckBox_buttonTint));
        }
        this.f925f = typedArrayK.getBoolean(k.MaterialCheckBox_useMaterialThemeColors, false);
        typedArrayK.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f924e == null) {
            int[] iArr = new int[h.length];
            int iC = e.a.a.a.q.a.c(this, b.colorControlActivated);
            int iC2 = e.a.a.a.q.a.c(this, b.colorSurface);
            int iC3 = e.a.a.a.q.a.c(this, b.colorOnSurface);
            iArr[0] = e.a.a.a.q.a.f(iC2, iC, 1.0f);
            iArr[1] = e.a.a.a.q.a.f(iC2, iC3, 0.54f);
            iArr[2] = e.a.a.a.q.a.f(iC2, iC3, 0.38f);
            iArr[3] = e.a.a.a.q.a.f(iC2, iC3, 0.38f);
            this.f924e = new ColorStateList(h, iArr);
        }
        return this.f924e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f925f && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f925f = z;
        c.c(this, z ? getMaterialThemeColorsTintList() : null);
    }
}
