package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class s extends RecyclerView.g<b> {
    private final h<?> c;

    class a implements View.OnClickListener {
        final /* synthetic */ int b;

        a(int i) {
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s.this.c.F1(l.k(this.b, s.this.c.z1().f587d));
            s.this.c.G1(h.k.DAY);
        }
    }

    public static class b extends RecyclerView.d0 {
        final TextView t;

        b(TextView textView) {
            super(textView);
            this.t = textView;
        }
    }

    s(h<?> hVar) {
        this.c = hVar;
    }

    private View.OnClickListener v(int i) {
        return new a(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.c.x1().s();
    }

    int w(int i) {
        return i - this.c.x1().r().f588e;
    }

    int x(int i) {
        return this.c.x1().r().f588e + i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void j(b bVar, int i) {
        int iX = x(i);
        String string = bVar.t.getContext().getString(e.a.a.a.i.mtrl_picker_navigate_to_year_description);
        bVar.t.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(iX)));
        bVar.t.setContentDescription(String.format(string, Integer.valueOf(iX)));
        c cVarY1 = this.c.y1();
        Calendar calendarI = r.i();
        com.google.android.material.datepicker.b bVar2 = calendarI.get(1) == iX ? cVarY1.f581f : cVarY1.f579d;
        Iterator<Long> it = this.c.A1().h().iterator();
        while (it.hasNext()) {
            calendarI.setTimeInMillis(it.next().longValue());
            if (calendarI.get(1) == iX) {
                bVar2 = cVarY1.f580e;
            }
        }
        bVar2.d(bVar.t);
        bVar.t.setOnClickListener(v(iX));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public b l(ViewGroup viewGroup, int i) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(e.a.a.a.h.mtrl_calendar_year, viewGroup, false));
    }
}
