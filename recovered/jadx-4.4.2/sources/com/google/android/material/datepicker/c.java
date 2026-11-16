package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes.dex */
final class c {
    final b a;
    final b b;
    final b c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final b f579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final b f580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final b f581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final b f582g;
    final Paint h;

    c(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(e.a.a.a.x.b.c(context, e.a.a.a.b.materialCalendarStyle, h.class.getCanonicalName()), e.a.a.a.k.MaterialCalendar);
        this.a = b.a(context, typedArrayObtainStyledAttributes.getResourceId(e.a.a.a.k.MaterialCalendar_dayStyle, 0));
        this.f582g = b.a(context, typedArrayObtainStyledAttributes.getResourceId(e.a.a.a.k.MaterialCalendar_dayInvalidStyle, 0));
        this.b = b.a(context, typedArrayObtainStyledAttributes.getResourceId(e.a.a.a.k.MaterialCalendar_daySelectedStyle, 0));
        this.c = b.a(context, typedArrayObtainStyledAttributes.getResourceId(e.a.a.a.k.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateListA = e.a.a.a.x.c.a(context, typedArrayObtainStyledAttributes, e.a.a.a.k.MaterialCalendar_rangeFillColor);
        this.f579d = b.a(context, typedArrayObtainStyledAttributes.getResourceId(e.a.a.a.k.MaterialCalendar_yearStyle, 0));
        this.f580e = b.a(context, typedArrayObtainStyledAttributes.getResourceId(e.a.a.a.k.MaterialCalendar_yearSelectedStyle, 0));
        this.f581f = b.a(context, typedArrayObtainStyledAttributes.getResourceId(e.a.a.a.k.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
