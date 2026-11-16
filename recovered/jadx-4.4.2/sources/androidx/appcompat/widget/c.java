package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class c extends androidx.appcompat.view.menu.b implements d.f.k.b.a {
    private b A;
    final f B;
    int C;
    d j;
    private Drawable k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private final SparseBooleanArray w;
    e x;
    a y;
    RunnableC0004c z;

    private class a extends androidx.appcompat.view.menu.l {
        public a(Context context, androidx.appcompat.view.menu.r rVar, View view) {
            super(context, rVar, view, false, d.a.a.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.i) rVar.getItem()).l()) {
                View view2 = c.this.j;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.b) c.this).i : view2);
            }
            j(c.this.B);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            c cVar = c.this;
            cVar.y = null;
            cVar.C = 0;
            super.e();
        }
    }

    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.p a() {
            a aVar = c.this.y;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$c, reason: collision with other inner class name */
    private class RunnableC0004c implements Runnable {
        private e b;

        public RunnableC0004c(e eVar) {
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.b) c.this).f66d != null) {
                ((androidx.appcompat.view.menu.b) c.this).f66d.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.b) c.this).i;
            if (view != null && view.getWindowToken() != null && this.b.m()) {
                c.this.x = this.b;
            }
            c.this.z = null;
        }
    }

    private class d extends o implements ActionMenuView.a {

        class a extends h0 {
            a(View view, c cVar) {
                super(view);
            }

            @Override // androidx.appcompat.widget.h0
            public androidx.appcompat.view.menu.p b() {
                e eVar = c.this.x;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.h0
            public boolean c() {
                c.this.J();
                return true;
            }

            @Override // androidx.appcompat.widget.h0
            public boolean d() {
                c cVar = c.this;
                if (cVar.z != null) {
                    return false;
                }
                cVar.A();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, d.a.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            y0.a(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.J();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.l(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    private class e extends androidx.appcompat.view.menu.l {
        public e(Context context, androidx.appcompat.view.menu.g gVar, View view, boolean z) {
            super(context, gVar, view, z, d.a.a.actionOverflowMenuStyle);
            h(8388613);
            j(c.this.B);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            if (((androidx.appcompat.view.menu.b) c.this).f66d != null) {
                ((androidx.appcompat.view.menu.b) c.this).f66d.close();
            }
            c.this.x = null;
            super.e();
        }
    }

    private class f implements androidx.appcompat.view.menu.m.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void c(androidx.appcompat.view.menu.g gVar, boolean z) {
            if (gVar instanceof androidx.appcompat.view.menu.r) {
                gVar.D().e(false);
            }
            androidx.appcompat.view.menu.m.a aVarM = c.this.m();
            if (aVarM != null) {
                aVarM.c(gVar, z);
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean d(androidx.appcompat.view.menu.g gVar) {
            if (gVar == null) {
                return false;
            }
            c.this.C = ((androidx.appcompat.view.menu.r) gVar).getItem().getItemId();
            androidx.appcompat.view.menu.m.a aVarM = c.this.m();
            if (aVarM != null) {
                return aVarM.d(gVar);
            }
            return false;
        }
    }

    public c(Context context) {
        super(context, d.a.g.abc_action_menu_layout, d.a.g.abc_action_menu_item_layout);
        this.w = new SparseBooleanArray();
        this.B = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View y(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof androidx.appcompat.view.menu.n.a) && ((androidx.appcompat.view.menu.n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean A() {
        Object obj;
        RunnableC0004c runnableC0004c = this.z;
        if (runnableC0004c != null && (obj = this.i) != null) {
            ((View) obj).removeCallbacks(runnableC0004c);
            this.z = null;
            return true;
        }
        e eVar = this.x;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean B() {
        a aVar = this.y;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean C() {
        return this.z != null || D();
    }

    public boolean D() {
        e eVar = this.x;
        return eVar != null && eVar.d();
    }

    public void E(Configuration configuration) {
        if (!this.r) {
            this.q = d.a.o.a.b(this.c).d();
        }
        androidx.appcompat.view.menu.g gVar = this.f66d;
        if (gVar != null) {
            gVar.K(true);
        }
    }

    public void F(boolean z) {
        this.u = z;
    }

    public void G(ActionMenuView actionMenuView) {
        this.i = actionMenuView;
        actionMenuView.d(this.f66d);
    }

    public void H(Drawable drawable) {
        d dVar = this.j;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.l = true;
            this.k = drawable;
        }
    }

    public void I(boolean z) {
        this.m = z;
        this.n = true;
    }

    public boolean J() {
        androidx.appcompat.view.menu.g gVar;
        if (!this.m || D() || (gVar = this.f66d) == null || this.i == null || this.z != null || gVar.z().isEmpty()) {
            return false;
        }
        RunnableC0004c runnableC0004c = new RunnableC0004c(new e(this.c, this.f66d, this.j, true));
        this.z = runnableC0004c;
        ((View) this.i).post(runnableC0004c);
        super.f(null);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b
    public void b(androidx.appcompat.view.menu.i iVar, androidx.appcompat.view.menu.n.a aVar) {
        aVar.e(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.i);
        if (this.A == null) {
            this.A = new b();
        }
        actionMenuItemView.setPopupCallback(this.A);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void c(androidx.appcompat.view.menu.g gVar, boolean z) {
        x();
        super.c(gVar, z);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public boolean f(androidx.appcompat.view.menu.r rVar) {
        boolean z = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.r rVar2 = rVar;
        while (rVar2.e0() != this.f66d) {
            rVar2 = (androidx.appcompat.view.menu.r) rVar2.e0();
        }
        View viewY = y(rVar2.getItem());
        if (viewY == null) {
            return false;
        }
        rVar.getItem().getItemId();
        int size = rVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = rVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        a aVar = new a(this.c, rVar, viewY);
        this.y = aVar;
        aVar.g(z);
        this.y.k();
        super.f(rVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean h() {
        ArrayList<androidx.appcompat.view.menu.i> arrayListE;
        int size;
        int i;
        int iL;
        c cVar = this;
        androidx.appcompat.view.menu.g gVar = cVar.f66d;
        View view = null;
        int i2 = 0;
        if (gVar != null) {
            arrayListE = gVar.E();
            size = arrayListE.size();
        } else {
            arrayListE = null;
            size = 0;
        }
        int i3 = cVar.q;
        int i4 = cVar.p;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.i;
        boolean z = false;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            androidx.appcompat.view.menu.i iVar = arrayListE.get(i7);
            if (iVar.o()) {
                i5++;
            } else if (iVar.n()) {
                i6++;
            } else {
                z = true;
            }
            if (cVar.u && iVar.isActionViewExpanded()) {
                i3 = 0;
            }
        }
        if (cVar.m && (z || i6 + i5 > i3)) {
            i3--;
        }
        int i8 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = cVar.w;
        sparseBooleanArray.clear();
        if (cVar.s) {
            int i9 = cVar.v;
            iL = i4 / i9;
            i = i9 + ((i4 % i9) / iL);
        } else {
            i = 0;
            iL = 0;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            androidx.appcompat.view.menu.i iVar2 = arrayListE.get(i10);
            if (iVar2.o()) {
                View viewN = cVar.n(iVar2, view, viewGroup);
                if (cVar.s) {
                    iL -= ActionMenuView.L(viewN, i, iL, iMakeMeasureSpec, i2);
                } else {
                    viewN.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewN.getMeasuredWidth();
                i4 -= measuredWidth;
                if (i11 == 0) {
                    i11 = measuredWidth;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.u(true);
            } else {
                if (iVar2.n()) {
                    int groupId2 = iVar2.getGroupId();
                    boolean z2 = sparseBooleanArray.get(groupId2);
                    boolean z3 = (i8 > 0 || z2) && i4 > 0 && (!cVar.s || iL > 0);
                    boolean z4 = z3;
                    if (z3) {
                        View viewN2 = cVar.n(iVar2, null, viewGroup);
                        if (cVar.s) {
                            int iL2 = ActionMenuView.L(viewN2, i, iL, iMakeMeasureSpec, 0);
                            iL -= iL2;
                            if (iL2 == 0) {
                                z4 = false;
                            }
                        } else {
                            viewN2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        }
                        boolean z5 = z4;
                        int measuredWidth2 = viewN2.getMeasuredWidth();
                        i4 -= measuredWidth2;
                        if (i11 == 0) {
                            i11 = measuredWidth2;
                        }
                        z3 = z5 & (!cVar.s ? i4 + i11 <= 0 : i4 < 0);
                    }
                    if (z3 && groupId2 != 0) {
                        sparseBooleanArray.put(groupId2, true);
                    } else if (z2) {
                        sparseBooleanArray.put(groupId2, false);
                        for (int i12 = 0; i12 < i10; i12++) {
                            androidx.appcompat.view.menu.i iVar3 = arrayListE.get(i12);
                            if (iVar3.getGroupId() == groupId2) {
                                if (iVar3.l()) {
                                    i8++;
                                }
                                iVar3.u(false);
                            }
                        }
                    }
                    if (z3) {
                        i8--;
                    }
                    iVar2.u(z3);
                } else {
                    size = size;
                    iVar2.u(false);
                }
                i10++;
                view = null;
                cVar = this;
                size = size;
                i2 = 0;
            }
            i10++;
            view = null;
            cVar = this;
            size = size;
            i2 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void i(boolean z) {
        super.i(z);
        ((View) this.i).requestLayout();
        androidx.appcompat.view.menu.g gVar = this.f66d;
        boolean z2 = false;
        if (gVar != null) {
            ArrayList<androidx.appcompat.view.menu.i> arrayListS = gVar.s();
            int size = arrayListS.size();
            for (int i = 0; i < size; i++) {
                d.f.k.b bVarA = arrayListS.get(i).a();
                if (bVarA != null) {
                    bVarA.i(this);
                }
            }
        }
        androidx.appcompat.view.menu.g gVar2 = this.f66d;
        ArrayList<androidx.appcompat.view.menu.i> arrayListZ = gVar2 != null ? gVar2.z() : null;
        if (this.m && arrayListZ != null) {
            int size2 = arrayListZ.size();
            if (size2 == 1) {
                z2 = !arrayListZ.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        d dVar = this.j;
        if (z2) {
            if (dVar == null) {
                this.j = new d(this.b);
            }
            ViewGroup viewGroup = (ViewGroup) this.j.getParent();
            if (viewGroup != this.i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.i;
                actionMenuView.addView(this.j, actionMenuView.F());
            }
        } else if (dVar != null) {
            Object parent = dVar.getParent();
            Object obj = this.i;
            if (parent == obj) {
                ((ViewGroup) obj).removeView(this.j);
            }
        }
        ((ActionMenuView) this.i).setOverflowReserved(this.m);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void j(Context context, androidx.appcompat.view.menu.g gVar) {
        super.j(context, gVar);
        Resources resources = context.getResources();
        d.a.o.a aVarB = d.a.o.a.b(context);
        if (!this.n) {
            this.m = aVarB.h();
        }
        if (!this.t) {
            this.o = aVarB.c();
        }
        if (!this.r) {
            this.q = aVarB.d();
        }
        int measuredWidth = this.o;
        if (this.m) {
            if (this.j == null) {
                d dVar = new d(this.b);
                this.j = dVar;
                if (this.l) {
                    dVar.setImageDrawable(this.k);
                    this.k = null;
                    this.l = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.j.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.j.getMeasuredWidth();
        } else {
            this.j = null;
        }
        this.p = measuredWidth;
        this.v = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean l(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.j) {
            return false;
        }
        return super.l(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.b
    public View n(androidx.appcompat.view.menu.i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.j()) {
            actionView = super.n(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.n o(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.n nVar = this.i;
        androidx.appcompat.view.menu.n nVarO = super.o(viewGroup);
        if (nVar != nVarO) {
            ((ActionMenuView) nVarO).setPresenter(this);
        }
        return nVarO;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean q(int i, androidx.appcompat.view.menu.i iVar) {
        return iVar.l();
    }

    public boolean x() {
        return A() | B();
    }

    public Drawable z() {
        d dVar = this.j;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.l) {
            return this.k;
        }
        return null;
    }
}
