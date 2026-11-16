package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.k0;
import androidx.appcompat.widget.l0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class d extends k implements m, View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int C = d.a.g.abc_cascading_menu_item_layout;
    private PopupWindow.OnDismissListener A;
    boolean B;
    private final Context c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f70d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f71e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f72f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f73g;
    final Handler h;
    private View p;
    View q;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private boolean x;
    private m.a y;
    ViewTreeObserver z;
    private final List<g> i = new ArrayList();
    final List<C0002d> j = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener k = new a();
    private final View.OnAttachStateChangeListener l = new b();
    private final k0 m = new c();
    private int n = 0;
    private int o = 0;
    private boolean w = false;
    private int r = D();

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!d.this.a() || d.this.j.size() <= 0 || d.this.j.get(0).a.x()) {
                return;
            }
            View view = d.this.q;
            if (view == null || !view.isShown()) {
                d.this.dismiss();
                return;
            }
            Iterator<C0002d> it = d.this.j.iterator();
            while (it.hasNext()) {
                it.next().a.b();
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = d.this.z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.z = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.z.removeGlobalOnLayoutListener(dVar.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    class c implements k0 {

        class a implements Runnable {
            final /* synthetic */ C0002d b;
            final /* synthetic */ MenuItem c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ g f74d;

            a(C0002d c0002d, MenuItem menuItem, g gVar) {
                this.b = c0002d;
                this.c = menuItem;
                this.f74d = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0002d c0002d = this.b;
                if (c0002d != null) {
                    d.this.B = true;
                    c0002d.b.e(false);
                    d.this.B = false;
                }
                if (this.c.isEnabled() && this.c.hasSubMenu()) {
                    this.f74d.L(this.c, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.k0
        public void i(g gVar, MenuItem menuItem) {
            d.this.h.removeCallbacksAndMessages(null);
            int size = d.this.j.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (gVar == d.this.j.get(i).b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            d.this.h.postAtTime(new a(i2 < d.this.j.size() ? d.this.j.get(i2) : null, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.k0
        public void l(g gVar, MenuItem menuItem) {
            d.this.h.removeCallbacksAndMessages(gVar);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.view.menu.d$d, reason: collision with other inner class name */
    private static class C0002d {
        public final l0 a;
        public final g b;
        public final int c;

        public C0002d(l0 l0Var, g gVar, int i) {
            this.a = l0Var;
            this.b = gVar;
            this.c = i;
        }

        public ListView a() {
            return this.a.g();
        }
    }

    public d(Context context, View view, int i, int i2, boolean z) {
        this.c = context;
        this.p = view;
        this.f71e = i;
        this.f72f = i2;
        this.f73g = z;
        Resources resources = context.getResources();
        this.f70d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.a.d.abc_config_prefDialogWidth));
        this.h = new Handler();
    }

    private int A(g gVar) {
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            if (gVar == this.j.get(i).b) {
                return i;
            }
        }
        return -1;
    }

    private MenuItem B(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = gVar.getItem(i);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View C(C0002d c0002d, g gVar) {
        f fVar;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemB = B(c0002d.b, gVar);
        if (menuItemB == null) {
            return null;
        }
        ListView listViewA = c0002d.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            headersCount = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i >= count) {
                i = -1;
                break;
            }
            if (menuItemB == fVar.getItem(i)) {
                break;
            }
            i++;
        }
        if (i != -1 && (firstVisiblePosition = (i + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int D() {
        return d.f.k.r.v(this.p) == 1 ? 0 : 1;
    }

    private int E(int i) {
        List<C0002d> list = this.j;
        ListView listViewA = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.q.getWindowVisibleDisplayFrame(rect);
        if (this.r == 1) {
            return (iArr[0] + listViewA.getWidth()) + i > rect.right ? 0 : 1;
        }
        return iArr[0] - i < 0 ? 1 : 0;
    }

    private void F(g gVar) {
        C0002d c0002d;
        View viewC;
        int i;
        int i2;
        int i3;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.c);
        f fVar = new f(gVar, layoutInflaterFrom, this.f73g, C);
        if (!a() && this.w) {
            fVar.d(true);
        } else if (a()) {
            fVar.d(k.x(gVar));
        }
        int iO = k.o(fVar, null, this.c, this.f70d);
        l0 l0VarZ = z();
        l0VarZ.o(fVar);
        l0VarZ.B(iO);
        l0VarZ.C(this.o);
        if (this.j.size() > 0) {
            List<C0002d> list = this.j;
            c0002d = list.get(list.size() - 1);
            viewC = C(c0002d, gVar);
        } else {
            c0002d = null;
            viewC = null;
        }
        if (viewC != null) {
            l0VarZ.Q(false);
            l0VarZ.N(null);
            int iE = E(iO);
            boolean z = iE == 1;
            this.r = iE;
            if (Build.VERSION.SDK_INT >= 26) {
                l0VarZ.z(viewC);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewC.getLocationOnScreen(iArr2);
                if ((this.o & 7) == 5) {
                    iArr[0] = iArr[0] + this.p.getWidth();
                    iArr2[0] = iArr2[0] + viewC.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.o & 5) == 5) {
                if (z) {
                    i3 = i + iO;
                } else {
                    iO = viewC.getWidth();
                    i3 = i - iO;
                }
            } else if (z) {
                iO = viewC.getWidth();
                i3 = i + iO;
            } else {
                i3 = i - iO;
            }
            l0VarZ.e(i3);
            l0VarZ.I(true);
            l0VarZ.m(i2);
        } else {
            if (this.s) {
                l0VarZ.e(this.u);
            }
            if (this.t) {
                l0VarZ.m(this.v);
            }
            l0VarZ.D(n());
        }
        this.j.add(new C0002d(l0VarZ, gVar, this.r));
        l0VarZ.b();
        ListView listViewG = l0VarZ.g();
        listViewG.setOnKeyListener(this);
        if (c0002d == null && this.x && gVar.x() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(d.a.g.abc_popup_menu_header_item_layout, (ViewGroup) listViewG, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(gVar.x());
            listViewG.addHeaderView(frameLayout, null, false);
            l0VarZ.b();
        }
    }

    private l0 z() {
        l0 l0Var = new l0(this.c, null, this.f71e, this.f72f);
        l0Var.P(this.m);
        l0Var.H(this);
        l0Var.G(this);
        l0Var.z(this.p);
        l0Var.C(this.o);
        l0Var.F(true);
        l0Var.E(2);
        return l0Var;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a() {
        return this.j.size() > 0 && this.j.get(0).a.a();
    }

    @Override // androidx.appcompat.view.menu.p
    public void b() {
        if (a()) {
            return;
        }
        Iterator<g> it = this.i.iterator();
        while (it.hasNext()) {
            F(it.next());
        }
        this.i.clear();
        View view = this.p;
        this.q = view;
        if (view != null) {
            boolean z = this.z == null;
            ViewTreeObserver viewTreeObserver = this.q.getViewTreeObserver();
            this.z = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.k);
            }
            this.q.addOnAttachStateChangeListener(this.l);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void c(g gVar, boolean z) {
        int iA = A(gVar);
        if (iA < 0) {
            return;
        }
        int i = iA + 1;
        if (i < this.j.size()) {
            this.j.get(i).b.e(false);
        }
        C0002d c0002dRemove = this.j.remove(iA);
        c0002dRemove.b.O(this);
        if (this.B) {
            c0002dRemove.a.O(null);
            c0002dRemove.a.A(0);
        }
        c0002dRemove.a.dismiss();
        int size = this.j.size();
        this.r = size > 0 ? this.j.get(size - 1).c : D();
        if (size != 0) {
            if (z) {
                this.j.get(0).b.e(false);
                return;
            }
            return;
        }
        dismiss();
        m.a aVar = this.y;
        if (aVar != null) {
            aVar.c(gVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.z;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.z.removeGlobalOnLayoutListener(this.k);
            }
            this.z = null;
        }
        this.q.removeOnAttachStateChangeListener(this.l);
        this.A.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        int size = this.j.size();
        if (size > 0) {
            C0002d[] c0002dArr = (C0002d[]) this.j.toArray(new C0002d[size]);
            for (int i = size - 1; i >= 0; i--) {
                C0002d c0002d = c0002dArr[i];
                if (c0002d.a.a()) {
                    c0002d.a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void e(m.a aVar) {
        this.y = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean f(r rVar) {
        for (C0002d c0002d : this.j) {
            if (rVar == c0002d.b) {
                c0002d.a().requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        l(rVar);
        m.a aVar = this.y;
        if (aVar != null) {
            aVar.d(rVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView g() {
        if (this.j.isEmpty()) {
            return null;
        }
        List<C0002d> list = this.j;
        return list.get(list.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean h() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void i(boolean z) {
        Iterator<C0002d> it = this.j.iterator();
        while (it.hasNext()) {
            k.y(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void l(g gVar) {
        gVar.c(this, this.c);
        if (a()) {
            F(gVar);
        } else {
            this.i.add(gVar);
        }
    }

    @Override // androidx.appcompat.view.menu.k
    protected boolean m() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C0002d c0002d;
        int size = this.j.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                c0002d = null;
                break;
            }
            c0002d = this.j.get(i);
            if (!c0002d.a.a()) {
                break;
            } else {
                i++;
            }
        }
        if (c0002d != null) {
            c0002d.b.e(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.k
    public void p(View view) {
        if (this.p != view) {
            this.p = view;
            this.o = d.f.k.c.b(this.n, d.f.k.r.v(view));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void r(boolean z) {
        this.w = z;
    }

    @Override // androidx.appcompat.view.menu.k
    public void s(int i) {
        if (this.n != i) {
            this.n = i;
            this.o = d.f.k.c.b(i, d.f.k.r.v(this.p));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void t(int i) {
        this.s = true;
        this.u = i;
    }

    @Override // androidx.appcompat.view.menu.k
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void v(boolean z) {
        this.x = z;
    }

    @Override // androidx.appcompat.view.menu.k
    public void w(int i) {
        this.t = true;
        this.v = i;
    }
}
