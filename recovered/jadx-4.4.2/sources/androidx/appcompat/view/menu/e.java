package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e implements m, AdapterView.OnItemClickListener {
    Context b;
    LayoutInflater c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    g f76d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ExpandedMenuView f77e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f78f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f79g;
    int h;
    private m.a i;
    a j;

    private class a extends BaseAdapter {
        private int b = -1;

        public a() {
            a();
        }

        void a() {
            i iVarV = e.this.f76d.v();
            if (iVarV != null) {
                ArrayList<i> arrayListZ = e.this.f76d.z();
                int size = arrayListZ.size();
                for (int i = 0; i < size; i++) {
                    if (arrayListZ.get(i) == iVarV) {
                        this.b = i;
                        return;
                    }
                }
            }
            this.b = -1;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i getItem(int i) {
            ArrayList<i> arrayListZ = e.this.f76d.z();
            int i2 = i + e.this.f78f;
            int i3 = this.b;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return arrayListZ.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = e.this.f76d.z().size() - e.this.f78f;
            return this.b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.c.inflate(eVar.h, viewGroup, false);
            }
            ((n.a) view).e(getItem(i), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(int i, int i2) {
        this.h = i;
        this.f79g = i2;
    }

    public e(Context context, int i) {
        this(i, 0);
        this.b = context;
        this.c = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.j == null) {
            this.j = new a();
        }
        return this.j;
    }

    public n b(ViewGroup viewGroup) {
        if (this.f77e == null) {
            this.f77e = (ExpandedMenuView) this.c.inflate(d.a.g.abc_expanded_menu_layout, viewGroup, false);
            if (this.j == null) {
                this.j = new a();
            }
            this.f77e.setAdapter((ListAdapter) this.j);
            this.f77e.setOnItemClickListener(this);
        }
        return this.f77e;
    }

    @Override // androidx.appcompat.view.menu.m
    public void c(g gVar, boolean z) {
        m.a aVar = this.i;
        if (aVar != null) {
            aVar.c(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void e(m.a aVar) {
        this.i = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean f(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        new h(rVar).b(null);
        m.a aVar = this.i;
        if (aVar == null) {
            return true;
        }
        aVar.d(rVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean h() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void i(boolean z) {
        a aVar = this.j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // androidx.appcompat.view.menu.m
    public void j(Context context, g gVar) {
        LayoutInflater layoutInflaterFrom;
        a aVar;
        if (this.f79g == 0) {
            if (this.b != null) {
                this.b = context;
                if (this.c == null) {
                    layoutInflaterFrom = LayoutInflater.from(context);
                }
            }
            this.f76d = gVar;
            aVar = this.j;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f79g);
        this.b = contextThemeWrapper;
        layoutInflaterFrom = LayoutInflater.from(contextThemeWrapper);
        this.c = layoutInflaterFrom;
        this.f76d = gVar;
        aVar = this.j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean k(g gVar, i iVar) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f76d.M(this.j.getItem(i), this, 0);
    }
}
