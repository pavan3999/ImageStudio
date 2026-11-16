package e.a.a.a.w;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.s;
import androidx.core.widget.c;
import com.google.android.material.internal.g;
import e.a.a.a.b;
import e.a.a.a.j;
import e.a.a.a.k;

/* JADX INFO: loaded from: classes.dex */
public class a extends s {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f929g = j.Widget_MaterialComponents_CompoundButton_RadioButton;
    private static final int[][] h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ColorStateList f930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f931f;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.radioButtonStyle);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(g.f(context, attributeSet, i, f929g), attributeSet, i);
        TypedArray typedArrayK = g.k(getContext(), attributeSet, k.MaterialRadioButton, i, f929g, new int[0]);
        this.f931f = typedArrayK.getBoolean(k.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayK.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f930e == null) {
            int iC = e.a.a.a.q.a.c(this, b.colorControlActivated);
            int iC2 = e.a.a.a.q.a.c(this, b.colorOnSurface);
            int iC3 = e.a.a.a.q.a.c(this, b.colorSurface);
            int[] iArr = new int[h.length];
            iArr[0] = e.a.a.a.q.a.f(iC3, iC, 1.0f);
            iArr[1] = e.a.a.a.q.a.f(iC3, iC2, 0.54f);
            iArr[2] = e.a.a.a.q.a.f(iC3, iC2, 0.38f);
            iArr[3] = e.a.a.a.q.a.f(iC3, iC2, 0.38f);
            this.f930e = new ColorStateList(h, iArr);
        }
        return this.f930e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f931f && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f931f = z;
        c.c(this, z ? getMaterialThemeColorsTintList() : null);
    }
}
