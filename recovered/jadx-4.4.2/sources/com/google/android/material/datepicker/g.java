package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class g extends BaseAdapter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f583e;
    private final Calendar b;
    private final int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f584d;

    static {
        f583e = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public g() {
        Calendar calendarK = r.k();
        this.b = calendarK;
        this.c = calendarK.getMaximum(7);
        this.f584d = this.b.getFirstDayOfWeek();
    }

    private int b(int i) {
        int i2 = i + this.f584d;
        int i3 = this.c;
        return i2 > i3 ? i2 - i3 : i2;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i) {
        if (i >= this.c) {
            return null;
        }
        return Integer.valueOf(b(i));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(e.a.a.a.h.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.b.set(7, b(i));
        textView.setText(this.b.getDisplayName(7, f583e, Locale.getDefault()));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(e.a.a.a.i.mtrl_picker_day_of_week_column_header), this.b.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
