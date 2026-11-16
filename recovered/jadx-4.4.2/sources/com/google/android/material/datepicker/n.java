package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
class n extends RecyclerView.g<b> {
    private final com.google.android.material.datepicker.a c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d<?> f594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h.l f595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f596f;

    class a implements AdapterView.OnItemClickListener {
        final /* synthetic */ MaterialCalendarGridView b;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.b = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.b.getAdapter().j(i)) {
                n.this.f595e.a(this.b.getAdapter().getItem(i).longValue());
            }
        }
    }

    public static class b extends RecyclerView.d0 {
        final TextView t;
        final MaterialCalendarGridView u;

        b(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(e.a.a.a.f.month_title);
            this.t = textView;
            d.f.k.r.d0(textView, true);
            this.u = (MaterialCalendarGridView) linearLayout.findViewById(e.a.a.a.f.month_grid);
            if (z) {
                return;
            }
            this.t.setVisibility(8);
        }
    }

    n(Context context, d<?> dVar, com.google.android.material.datepicker.a aVar, h.l lVar) {
        l lVarR = aVar.r();
        l lVarO = aVar.o();
        l lVarQ = aVar.q();
        if (lVarR.compareTo(lVarQ) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (lVarQ.compareTo(lVarO) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f596f = (m.f591f * h.B1(context)) + (i.L1(context) ? h.B1(context) : 0);
        this.c = aVar;
        this.f594d = dVar;
        this.f595e = lVar;
        s(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.c.p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long d(int i) {
        return this.c.r().q(i).p();
    }

    l v(int i) {
        return this.c.r().q(i);
    }

    CharSequence w(int i) {
        return v(i).o();
    }

    int x(l lVar) {
        return this.c.r().r(lVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void j(b bVar, int i) {
        l lVarQ = this.c.r().q(i);
        bVar.t.setText(lVarQ.o());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.u.findViewById(e.a.a.a.f.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !lVarQ.equals(materialCalendarGridView.getAdapter().b)) {
            m mVar = new m(lVarQ, this.f594d, this.c);
            materialCalendarGridView.setNumColumns(lVarQ.f589f);
            materialCalendarGridView.setAdapter((ListAdapter) mVar);
        } else {
            materialCalendarGridView.getAdapter().notifyDataSetChanged();
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public b l(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(e.a.a.a.h.mtrl_calendar_month_labeled, viewGroup, false);
        if (!i.L1(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.p(-1, this.f596f));
        return new b(linearLayout, true);
    }
}
