package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements m {
    protected Context b;
    protected Context c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected g f66d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected LayoutInflater f67e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private m.a f68f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f69g;
    private int h;
    protected n i;

    public b(Context context, int i, int i2) {
        this.b = context;
        this.f67e = LayoutInflater.from(context);
        this.f69g = i;
        this.h = i2;
    }

    protected void a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.i).addView(view, i);
    }

    public abstract void b(i iVar, n.a aVar);

    @Override // androidx.appcompat.view.menu.m
    public void c(g gVar, boolean z) {
        m.a aVar = this.f68f;
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
        this.f68f = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean f(r rVar) {
        m.a aVar = this.f68f;
        if (aVar != null) {
            return aVar.d(rVar);
        }
        return false;
    }

    public n.a g(ViewGroup viewGroup) {
        return (n.a) this.f67e.inflate(this.h, viewGroup, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.m
    public void i(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.i;
        if (viewGroup == null) {
            return;
        }
        g gVar = this.f66d;
        int i = 0;
        if (gVar != null) {
            gVar.r();
            ArrayList<i> arrayListE = this.f66d.E();
            int size = arrayListE.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                i iVar = arrayListE.get(i3);
                if (q(i2, iVar)) {
                    View childAt = viewGroup.getChildAt(i2);
                    i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                    View viewN = n(iVar, childAt, viewGroup);
                    if (iVar != itemData) {
                        viewN.setPressed(false);
                        viewN.jumpDrawablesToCurrentState();
                    }
                    if (viewN != childAt) {
                        a(viewN, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!l(viewGroup, i)) {
                i++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void j(Context context, g gVar) {
        this.c = context;
        LayoutInflater.from(context);
        this.f66d = gVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean k(g gVar, i iVar) {
        return false;
    }

    protected boolean l(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public m.a m() {
        return this.f68f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View n(i iVar, View view, ViewGroup viewGroup) {
        n.a aVarG = view instanceof n.a ? (n.a) view : g(viewGroup);
        b(iVar, aVarG);
        return (View) aVarG;
    }

    public n o(ViewGroup viewGroup) {
        if (this.i == null) {
            n nVar = (n) this.f67e.inflate(this.f69g, viewGroup, false);
            this.i = nVar;
            nVar.d(this.f66d);
            i(true);
        }
        return this.i;
    }

    public void p(int i) {
    }

    public abstract boolean q(int i, i iVar);
}
