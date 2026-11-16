package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class f extends BaseAdapter {
    g b;
    private int c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f80d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f81e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LayoutInflater f82f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f83g;

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.f81e = z;
        this.f82f = layoutInflater;
        this.b = gVar;
        this.f83g = i;
        a();
    }

    void a() {
        i iVarV = this.b.v();
        if (iVarV != null) {
            ArrayList<i> arrayListZ = this.b.z();
            int size = arrayListZ.size();
            for (int i = 0; i < size; i++) {
                if (arrayListZ.get(i) == iVarV) {
                    this.c = i;
                    return;
                }
            }
        }
        this.c = -1;
    }

    public g b() {
        return this.b;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public i getItem(int i) {
        ArrayList<i> arrayListZ = this.f81e ? this.b.z() : this.b.E();
        int i2 = this.c;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return arrayListZ.get(i);
    }

    public void d(boolean z) {
        this.f80d = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<i> arrayListZ = this.f81e ? this.b.z() : this.b.E();
        int i = this.c;
        int size = arrayListZ.size();
        return i < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f82f.inflate(this.f83g, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.b.F() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        n.a aVar = (n.a) view;
        if (this.f80d) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.e(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
