package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
final class b {
    private final Rect a;
    private final ColorStateList b;
    private final ColorStateList c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ColorStateList f576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e.a.a.a.a0.k f578f;

    private b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, e.a.a.a.a0.k kVar, Rect rect) {
        d.f.j.h.b(rect.left);
        d.f.j.h.b(rect.top);
        d.f.j.h.b(rect.right);
        d.f.j.h.b(rect.bottom);
        this.a = rect;
        this.b = colorStateList2;
        this.c = colorStateList;
        this.f576d = colorStateList3;
        this.f577e = i;
        this.f578f = kVar;
    }

    static b a(Context context, int i) {
        d.f.j.h.a(i != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, e.a.a.a.k.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(e.a.a.a.k.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(e.a.a.a.k.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(e.a.a.a.k.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(e.a.a.a.k.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateListA = e.a.a.a.x.c.a(context, typedArrayObtainStyledAttributes, e.a.a.a.k.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateListA2 = e.a.a.a.x.c.a(context, typedArrayObtainStyledAttributes, e.a.a.a.k.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateListA3 = e.a.a.a.x.c.a(context, typedArrayObtainStyledAttributes, e.a.a.a.k.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(e.a.a.a.k.MaterialCalendarItem_itemStrokeWidth, 0);
        e.a.a.a.a0.k kVarM = e.a.a.a.a0.k.b(context, typedArrayObtainStyledAttributes.getResourceId(e.a.a.a.k.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(e.a.a.a.k.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m();
        typedArrayObtainStyledAttributes.recycle();
        return new b(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, kVarM, rect);
    }

    int b() {
        return this.a.bottom;
    }

    int c() {
        return this.a.top;
    }

    void d(TextView textView) {
        e.a.a.a.a0.g gVar = new e.a.a.a.a0.g();
        e.a.a.a.a0.g gVar2 = new e.a.a.a.a0.g();
        gVar.setShapeAppearanceModel(this.f578f);
        gVar2.setShapeAppearanceModel(this.f578f);
        gVar.T(this.c);
        gVar.Z(this.f577e, this.f576d);
        textView.setTextColor(this.b);
        Drawable rippleDrawable = Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.b.withAlpha(30), gVar, gVar2) : gVar;
        Rect rect = this.a;
        d.f.k.r.f0(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
