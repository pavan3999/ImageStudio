package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class h<S> extends p<S> {
    static final Object i0 = "MONTHS_VIEW_GROUP_TAG";
    static final Object j0 = "NAVIGATION_PREV_TAG";
    static final Object k0 = "NAVIGATION_NEXT_TAG";
    static final Object l0 = "SELECTOR_TOGGLE_TAG";
    private int Y;
    private com.google.android.material.datepicker.d<S> Z;
    private com.google.android.material.datepicker.a a0;
    private com.google.android.material.datepicker.l b0;
    private k c0;
    private com.google.android.material.datepicker.c d0;
    private RecyclerView e0;
    private RecyclerView f0;
    private View g0;
    private View h0;

    class a implements Runnable {
        final /* synthetic */ int b;

        a(int i) {
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f0.smoothScrollToPosition(this.b);
        }
    }

    class b extends d.f.k.a {
        b(h hVar) {
        }

        @Override // d.f.k.a
        public void g(View view, d.f.k.a0.c cVar) {
            super.g(view, cVar);
            cVar.X(null);
        }
    }

    class c extends q {
        final /* synthetic */ int I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, int i, boolean z, int i2) {
            super(context, i, z);
            this.I = i2;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void M1(RecyclerView.a0 a0Var, int[] iArr) {
            if (this.I == 0) {
                iArr[0] = h.this.f0.getWidth();
                iArr[1] = h.this.f0.getWidth();
            } else {
                iArr[0] = h.this.f0.getHeight();
                iArr[1] = h.this.f0.getHeight();
            }
        }
    }

    class d implements l {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.h.l
        public void a(long j) {
            if (h.this.a0.n().i(j)) {
                h.this.Z.c(j);
                Iterator<o<S>> it = h.this.X.iterator();
                while (it.hasNext()) {
                    it.next().a(h.this.Z.a());
                }
                h.this.f0.getAdapter().h();
                if (h.this.e0 != null) {
                    h.this.e0.getAdapter().h();
                }
            }
        }
    }

    class e extends RecyclerView.n {
        private final Calendar a = r.k();
        private final Calendar b = r.k();

        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void g(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            if ((recyclerView.getAdapter() instanceof s) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                s sVar = (s) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (d.f.j.d<Long, Long> dVar : h.this.Z.g()) {
                    Long l = dVar.a;
                    if (l != null && dVar.b != null) {
                        this.a.setTimeInMillis(l.longValue());
                        this.b.setTimeInMillis(dVar.b.longValue());
                        int iW = sVar.w(this.a.get(1));
                        int iW2 = sVar.w(this.b.get(1));
                        View viewC = gridLayoutManager.C(iW);
                        View viewC2 = gridLayoutManager.C(iW2);
                        int iX2 = iW / gridLayoutManager.X2();
                        int iX3 = iW2 / gridLayoutManager.X2();
                        int i = iX2;
                        while (i <= iX3) {
                            View viewC3 = gridLayoutManager.C(gridLayoutManager.X2() * i);
                            if (viewC3 != null) {
                                canvas.drawRect(i == iX2 ? viewC.getLeft() + (viewC.getWidth() / 2) : 0, viewC3.getTop() + h.this.d0.f579d.c(), i == iX3 ? viewC2.getLeft() + (viewC2.getWidth() / 2) : recyclerView.getWidth(), viewC3.getBottom() - h.this.d0.f579d.b(), h.this.d0.h);
                            }
                            i++;
                        }
                    }
                }
            }
        }
    }

    class f extends d.f.k.a {
        f() {
        }

        @Override // d.f.k.a
        public void g(View view, d.f.k.a0.c cVar) {
            h hVar;
            int i;
            super.g(view, cVar);
            if (h.this.h0.getVisibility() == 0) {
                hVar = h.this;
                i = e.a.a.a.i.mtrl_picker_toggle_to_year_selection;
            } else {
                hVar = h.this;
                i = e.a.a.a.i.mtrl_picker_toggle_to_day_selection;
            }
            cVar.h0(hVar.H(i));
        }
    }

    class g extends RecyclerView.t {
        final /* synthetic */ n a;
        final /* synthetic */ MaterialButton b;

        g(n nVar, MaterialButton materialButton) {
            this.a = nVar;
            this.b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            if (i == 0) {
                CharSequence text = this.b.getText();
                if (Build.VERSION.SDK_INT >= 16) {
                    recyclerView.announceForAccessibility(text);
                } else {
                    recyclerView.sendAccessibilityEvent(2048);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            LinearLayoutManager linearLayoutManagerC1 = h.this.C1();
            int iZ1 = i < 0 ? linearLayoutManagerC1.Z1() : linearLayoutManagerC1.c2();
            h.this.b0 = this.a.v(iZ1);
            this.b.setText(this.a.w(iZ1));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.h$h, reason: collision with other inner class name */
    class ViewOnClickListenerC0024h implements View.OnClickListener {
        ViewOnClickListenerC0024h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.H1();
        }
    }

    class i implements View.OnClickListener {
        final /* synthetic */ n b;

        i(n nVar) {
            this.b = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iZ1 = h.this.C1().Z1() + 1;
            if (iZ1 < h.this.f0.getAdapter().c()) {
                h.this.F1(this.b.v(iZ1));
            }
        }
    }

    class j implements View.OnClickListener {
        final /* synthetic */ n b;

        j(n nVar) {
            this.b = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iC2 = h.this.C1().c2() - 1;
            if (iC2 >= 0) {
                h.this.F1(this.b.v(iC2));
            }
        }
    }

    enum k {
        DAY,
        YEAR
    }

    interface l {
        void a(long j);
    }

    static int B1(Context context) {
        return context.getResources().getDimensionPixelSize(e.a.a.a.d.mtrl_calendar_day_height);
    }

    static <T> h<T> D1(com.google.android.material.datepicker.d<T> dVar, int i2, com.google.android.material.datepicker.a aVar) {
        h<T> hVar = new h<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        bundle.putParcelable("CURRENT_MONTH_KEY", aVar.q());
        hVar.f1(bundle);
        return hVar;
    }

    private void E1(int i2) {
        this.f0.post(new a(i2));
    }

    private void v1(View view, n nVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(e.a.a.a.f.month_navigation_fragment_toggle);
        materialButton.setTag(l0);
        d.f.k.r.c0(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(e.a.a.a.f.month_navigation_previous);
        materialButton2.setTag(j0);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(e.a.a.a.f.month_navigation_next);
        materialButton3.setTag(k0);
        this.g0 = view.findViewById(e.a.a.a.f.mtrl_calendar_year_selector_frame);
        this.h0 = view.findViewById(e.a.a.a.f.mtrl_calendar_day_selector_frame);
        G1(k.DAY);
        materialButton.setText(this.b0.o());
        this.f0.addOnScrollListener(new g(nVar, materialButton));
        materialButton.setOnClickListener(new ViewOnClickListenerC0024h());
        materialButton3.setOnClickListener(new i(nVar));
        materialButton2.setOnClickListener(new j(nVar));
    }

    private RecyclerView.n w1() {
        return new e();
    }

    public com.google.android.material.datepicker.d<S> A1() {
        return this.Z;
    }

    LinearLayoutManager C1() {
        return (LinearLayoutManager) this.f0.getLayoutManager();
    }

    void F1(com.google.android.material.datepicker.l lVar) {
        RecyclerView recyclerView;
        int i2;
        n nVar = (n) this.f0.getAdapter();
        int iX = nVar.x(lVar);
        int iX2 = iX - nVar.x(this.b0);
        boolean z = Math.abs(iX2) > 3;
        boolean z2 = iX2 > 0;
        this.b0 = lVar;
        if (!z || !z2) {
            if (z) {
                recyclerView = this.f0;
                i2 = iX + 3;
            }
            E1(iX);
        }
        recyclerView = this.f0;
        i2 = iX - 3;
        recyclerView.scrollToPosition(i2);
        E1(iX);
    }

    void G1(k kVar) {
        this.c0 = kVar;
        if (kVar == k.YEAR) {
            this.e0.getLayoutManager().x1(((s) this.e0.getAdapter()).w(this.b0.f588e));
            this.g0.setVisibility(0);
            this.h0.setVisibility(8);
        } else if (kVar == k.DAY) {
            this.g0.setVisibility(8);
            this.h0.setVisibility(0);
            F1(this.b0);
        }
    }

    void H1() {
        k kVar;
        k kVar2 = this.c0;
        if (kVar2 == k.YEAR) {
            kVar = k.DAY;
        } else if (kVar2 != k.DAY) {
            return;
        } else {
            kVar = k.YEAR;
        }
        G1(kVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void a0(Bundle bundle) {
        super.a0(bundle);
        if (bundle == null) {
            bundle = n();
        }
        this.Y = bundle.getInt("THEME_RES_ID_KEY");
        this.Z = (com.google.android.material.datepicker.d) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.a0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.b0 = (com.google.android.material.datepicker.l) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View e0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(p(), this.Y);
        this.d0 = new com.google.android.material.datepicker.c(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        com.google.android.material.datepicker.l lVarR = this.a0.r();
        if (com.google.android.material.datepicker.i.L1(contextThemeWrapper)) {
            i2 = e.a.a.a.h.mtrl_calendar_vertical;
            i3 = 1;
        } else {
            i2 = e.a.a.a.h.mtrl_calendar_horizontal;
            i3 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i2, viewGroup, false);
        GridView gridView = (GridView) viewInflate.findViewById(e.a.a.a.f.mtrl_calendar_days_of_week);
        d.f.k.r.c0(gridView, new b(this));
        gridView.setAdapter((ListAdapter) new com.google.android.material.datepicker.g());
        gridView.setNumColumns(lVarR.f589f);
        gridView.setEnabled(false);
        this.f0 = (RecyclerView) viewInflate.findViewById(e.a.a.a.f.mtrl_calendar_months);
        this.f0.setLayoutManager(new c(p(), i3, false, i3));
        this.f0.setTag(i0);
        n nVar = new n(contextThemeWrapper, this.Z, this.a0, new d());
        this.f0.setAdapter(nVar);
        int integer = contextThemeWrapper.getResources().getInteger(e.a.a.a.g.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(e.a.a.a.f.mtrl_calendar_year_selector_frame);
        this.e0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.e0.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.e0.setAdapter(new s(this));
            this.e0.addItemDecoration(w1());
        }
        if (viewInflate.findViewById(e.a.a.a.f.month_navigation_fragment_toggle) != null) {
            v1(viewInflate, nVar);
        }
        if (!com.google.android.material.datepicker.i.L1(contextThemeWrapper)) {
            new androidx.recyclerview.widget.h().b(this.f0);
        }
        this.f0.scrollToPosition(nVar.x(this.b0));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void w0(Bundle bundle) {
        super.w0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.Y);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.Z);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.a0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.b0);
    }

    com.google.android.material.datepicker.a x1() {
        return this.a0;
    }

    com.google.android.material.datepicker.c y1() {
        return this.d0;
    }

    com.google.android.material.datepicker.l z1() {
        return this.b0;
    }
}
