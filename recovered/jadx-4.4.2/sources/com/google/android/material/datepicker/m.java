package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class m extends BaseAdapter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f591f = r.k().getMaximum(4);
    final l b;
    final d<?> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    c f592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final a f593e;

    m(l lVar, d<?> dVar, a aVar) {
        this.b = lVar;
        this.c = dVar;
        this.f593e = aVar;
    }

    private void e(Context context) {
        if (this.f592d == null) {
            this.f592d = new c(context);
        }
    }

    int a(int i) {
        return b() + (i - 1);
    }

    int b() {
        return this.b.m();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i) {
        if (i < this.b.m() || i > h()) {
            return null;
        }
        return Long.valueOf(this.b.n(i(i)));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005e  */
    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public TextView getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        e(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(e.a.a.a.h.mtrl_calendar_day, viewGroup, false);
        }
        int iB = i - b();
        if (iB >= 0) {
            l lVar = this.b;
            if (iB >= lVar.f590g) {
                textView.setVisibility(8);
                textView.setEnabled(false);
            } else {
                int i2 = iB + 1;
                textView.setTag(lVar);
                textView.setText(String.valueOf(i2));
                long jN = this.b.n(i2);
                textView.setContentDescription(this.b.f588e == l.s().f588e ? e.a(jN) : e.c(jN));
                textView.setVisibility(0);
                textView.setEnabled(true);
            }
        } else {
            textView.setVisibility(8);
            textView.setEnabled(false);
        }
        Long item = getItem(i);
        if (item == null) {
            return textView;
        }
        if (this.f593e.n().i(item.longValue())) {
            textView.setEnabled(true);
            Iterator<Long> it = this.c.h().iterator();
            while (it.hasNext()) {
                if (r.a(item.longValue()) == r.a(it.next().longValue())) {
                    bVar = this.f592d.b;
                }
            }
            bVar = r.i().getTimeInMillis() == item.longValue() ? this.f592d.c : this.f592d.a;
        } else {
            textView.setEnabled(false);
            bVar = this.f592d.f582g;
        }
        bVar.d(textView);
        return textView;
    }

    boolean f(int i) {
        return i % this.b.f589f == 0;
    }

    boolean g(int i) {
        return (i + 1) % this.b.f589f == 0;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.f590g + b();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i / this.b.f589f;
    }

    int h() {
        return (this.b.m() + this.b.f590g) - 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    int i(int i) {
        return (i - this.b.m()) + 1;
    }

    boolean j(int i) {
        return i >= b() && i <= h();
    }
}
