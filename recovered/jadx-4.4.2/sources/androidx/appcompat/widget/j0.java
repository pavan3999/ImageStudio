package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class j0 implements androidx.appcompat.view.menu.p {
    private static Method G;
    private static Method H;
    private static Method I;
    private final b A;
    final Handler B;
    private final Rect C;
    private Rect D;
    private boolean E;
    PopupWindow F;
    private Context b;
    private ListAdapter c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    f0 f182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f185g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private boolean n;
    private boolean o;
    int p;
    private View q;
    private int r;
    private DataSetObserver s;
    private View t;
    private Drawable u;
    private AdapterView.OnItemClickListener v;
    private AdapterView.OnItemSelectedListener w;
    final f x;
    private final e y;
    private final d z;

    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            f0 f0Var;
            if (i == -1 || (f0Var = j0.this.f182d) == null) {
                return;
            }
            f0Var.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.r();
        }
    }

    private class c extends DataSetObserver {
        c() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (j0.this.a()) {
                j0.this.b();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            j0.this.dismiss();
        }
    }

    private class d implements AbsListView.OnScrollListener {
        d() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || j0.this.w() || j0.this.F.getContentView() == null) {
                return;
            }
            j0 j0Var = j0.this;
            j0Var.B.removeCallbacks(j0Var.x);
            j0.this.x.run();
        }
    }

    private class e implements View.OnTouchListener {
        e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = j0.this.F) != null && popupWindow.isShowing() && x >= 0 && x < j0.this.F.getWidth() && y >= 0 && y < j0.this.F.getHeight()) {
                j0 j0Var = j0.this;
                j0Var.B.postDelayed(j0Var.x, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            j0 j0Var2 = j0.this;
            j0Var2.B.removeCallbacks(j0Var2.x);
            return false;
        }
    }

    private class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f0 f0Var = j0.this.f182d;
            if (f0Var == null || !d.f.k.r.I(f0Var) || j0.this.f182d.getCount() <= j0.this.f182d.getChildCount()) {
                return;
            }
            int childCount = j0.this.f182d.getChildCount();
            j0 j0Var = j0.this;
            if (childCount <= j0Var.p) {
                j0Var.F.setInputMethodMode(2);
                j0.this.b();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                I = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                H = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public j0(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public j0(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f183e = -2;
        this.f184f = -2;
        this.i = 1002;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = Integer.MAX_VALUE;
        this.r = 0;
        this.x = new f();
        this.y = new e();
        this.z = new d();
        this.A = new b();
        this.C = new Rect();
        this.b = context;
        this.B = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.j.ListPopupWindow, i, i2);
        this.f185g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(d.a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(d.a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.j = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        q qVar = new q(context, attributeSet, i, i2);
        this.F = qVar;
        qVar.setInputMethodMode(1);
    }

    private void J(boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            this.F.setIsClippedToScreen(z);
            return;
        }
        Method method = G;
        if (method != null) {
            try {
                method.invoke(this.F, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0124 A[PHI: r1
      0x0124: PHI (r1v1 int) = (r1v0 int), (r1v6 int) binds: [B:45:0x0119, B:47:0x011d] A[DONT_GENERATE, DONT_INLINE]] */
    private int q() {
        int measuredHeight;
        int i;
        int iMakeMeasureSpec;
        View view;
        int i2;
        f0 f0Var = this.f182d;
        int i3 = RecyclerView.UNDEFINED_DURATION;
        if (f0Var == null) {
            Context context = this.b;
            f0 f0VarS = s(context, !this.E);
            this.f182d = f0VarS;
            Drawable drawable = this.u;
            if (drawable != null) {
                f0VarS.setSelector(drawable);
            }
            this.f182d.setAdapter(this.c);
            this.f182d.setOnItemClickListener(this.v);
            this.f182d.setFocusable(true);
            this.f182d.setFocusableInTouchMode(true);
            this.f182d.setOnItemSelectedListener(new a());
            this.f182d.setOnScrollListener(this.z);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.w;
            if (onItemSelectedListener != null) {
                this.f182d.setOnItemSelectedListener(onItemSelectedListener);
            }
            f0 f0Var2 = this.f182d;
            View view2 = this.q;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i4 = this.r;
                if (i4 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(f0Var2, layoutParams);
                } else if (i4 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.r);
                } else {
                    linearLayout.addView(f0Var2, layoutParams);
                    linearLayout.addView(view2);
                }
                int i5 = this.f184f;
                if (i5 >= 0) {
                    i2 = RecyclerView.UNDEFINED_DURATION;
                } else {
                    i5 = 0;
                    i2 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i5, i2), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = f0Var2;
            }
            this.F.setContentView(view);
        } else {
            View view3 = this.q;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.F.getBackground();
        if (background != null) {
            background.getPadding(this.C);
            Rect rect = this.C;
            int i6 = rect.top;
            i = rect.bottom + i6;
            if (!this.j) {
                this.h = -i6;
            }
        } else {
            this.C.setEmpty();
            i = 0;
        }
        int iU = u(t(), this.h, this.F.getInputMethodMode() == 2);
        if (this.n || this.f183e == -1) {
            return iU + i;
        }
        int i7 = this.f184f;
        if (i7 != -2) {
            i3 = 1073741824;
            if (i7 != -1) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
            } else {
                int i8 = this.b.getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = this.C;
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8 - (rect2.left + rect2.right), i3);
            }
        } else {
            int i9 = this.b.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect3.left + rect3.right), i3);
        }
        int iD = this.f182d.d(iMakeMeasureSpec, 0, -1, iU - measuredHeight, -1);
        if (iD > 0) {
            measuredHeight += i + this.f182d.getPaddingTop() + this.f182d.getPaddingBottom();
        }
        return iD + measuredHeight;
    }

    private int u(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.F.getMaxAvailableHeight(view, i, z);
        }
        Method method = H;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.F, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.F.getMaxAvailableHeight(view, i);
    }

    private void y() {
        View view = this.q;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.q);
            }
        }
    }

    public void A(int i) {
        this.F.setAnimationStyle(i);
    }

    public void B(int i) {
        Drawable background = this.F.getBackground();
        if (background == null) {
            M(i);
            return;
        }
        background.getPadding(this.C);
        Rect rect = this.C;
        this.f184f = rect.left + rect.right + i;
    }

    public void C(int i) {
        this.m = i;
    }

    public void D(Rect rect) {
        this.D = rect != null ? new Rect(rect) : null;
    }

    public void E(int i) {
        this.F.setInputMethodMode(i);
    }

    public void F(boolean z) {
        this.E = z;
        this.F.setFocusable(z);
    }

    public void G(PopupWindow.OnDismissListener onDismissListener) {
        this.F.setOnDismissListener(onDismissListener);
    }

    public void H(AdapterView.OnItemClickListener onItemClickListener) {
        this.v = onItemClickListener;
    }

    public void I(boolean z) {
        this.l = true;
        this.k = z;
    }

    public void K(int i) {
        this.r = i;
    }

    public void L(int i) {
        f0 f0Var = this.f182d;
        if (!a() || f0Var == null) {
            return;
        }
        f0Var.setListSelectionHidden(false);
        f0Var.setSelection(i);
        if (f0Var.getChoiceMode() != 0) {
            f0Var.setItemChecked(i, true);
        }
    }

    public void M(int i) {
        this.f184f = i;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a() {
        return this.F.isShowing();
    }

    @Override // androidx.appcompat.view.menu.p
    public void b() {
        int iQ = q();
        boolean zW = w();
        androidx.core.widget.h.b(this.F, this.i);
        if (this.F.isShowing()) {
            if (d.f.k.r.I(t())) {
                int width = this.f184f;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = t().getWidth();
                }
                int i = this.f183e;
                if (i == -1) {
                    if (!zW) {
                        iQ = -1;
                    }
                    if (zW) {
                        this.F.setWidth(this.f184f == -1 ? -1 : 0);
                        this.F.setHeight(0);
                    } else {
                        this.F.setWidth(this.f184f == -1 ? -1 : 0);
                        this.F.setHeight(-1);
                    }
                } else if (i != -2) {
                    iQ = i;
                }
                this.F.setOutsideTouchable((this.o || this.n) ? false : true);
                this.F.update(t(), this.f185g, this.h, width < 0 ? -1 : width, iQ < 0 ? -1 : iQ);
                return;
            }
            return;
        }
        int width2 = this.f184f;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = t().getWidth();
        }
        int i2 = this.f183e;
        if (i2 == -1) {
            iQ = -1;
        } else if (i2 != -2) {
            iQ = i2;
        }
        this.F.setWidth(width2);
        this.F.setHeight(iQ);
        J(true);
        this.F.setOutsideTouchable((this.o || this.n) ? false : true);
        this.F.setTouchInterceptor(this.y);
        if (this.l) {
            androidx.core.widget.h.a(this.F, this.k);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = I;
            if (method != null) {
                try {
                    method.invoke(this.F, this.D);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.F.setEpicenterBounds(this.D);
        }
        androidx.core.widget.h.c(this.F, t(), this.f185g, this.h, this.m);
        this.f182d.setSelection(-1);
        if (!this.E || this.f182d.isInTouchMode()) {
            r();
        }
        if (this.E) {
            return;
        }
        this.B.post(this.A);
    }

    public void c(Drawable drawable) {
        this.F.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        this.F.dismiss();
        y();
        this.F.setContentView(null);
        this.f182d = null;
        this.B.removeCallbacks(this.x);
    }

    public void e(int i) {
        this.f185g = i;
    }

    public int f() {
        return this.f185g;
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView g() {
        return this.f182d;
    }

    public int k() {
        if (this.j) {
            return this.h;
        }
        return 0;
    }

    public void m(int i) {
        this.h = i;
        this.j = true;
    }

    public Drawable n() {
        return this.F.getBackground();
    }

    public void o(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.s;
        if (dataSetObserver == null) {
            this.s = new c();
        } else {
            ListAdapter listAdapter2 = this.c;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.c = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.s);
        }
        f0 f0Var = this.f182d;
        if (f0Var != null) {
            f0Var.setAdapter(this.c);
        }
    }

    public void r() {
        f0 f0Var = this.f182d;
        if (f0Var != null) {
            f0Var.setListSelectionHidden(true);
            f0Var.requestLayout();
        }
    }

    f0 s(Context context, boolean z) {
        return new f0(context, z);
    }

    public View t() {
        return this.t;
    }

    public int v() {
        return this.f184f;
    }

    public boolean w() {
        return this.F.getInputMethodMode() == 2;
    }

    public boolean x() {
        return this.E;
    }

    public void z(View view) {
        this.t = view;
    }
}
