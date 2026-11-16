package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends i0 implements androidx.appcompat.view.menu.g.b, androidx.appcompat.view.menu.n {
    private int A;
    e B;
    private androidx.appcompat.view.menu.g q;
    private Context r;
    private int s;
    private boolean t;
    private androidx.appcompat.widget.c u;
    private androidx.appcompat.view.menu.m.a v;
    androidx.appcompat.view.menu.g.a w;
    private boolean x;
    private int y;
    private int z;

    public interface a {
        boolean a();

        boolean b();
    }

    private static class b implements androidx.appcompat.view.menu.m.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void c(androidx.appcompat.view.menu.g gVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean d(androidx.appcompat.view.menu.g gVar) {
            return false;
        }
    }

    public static class c extends i0.a {

        @ViewDebug.ExportedProperty
        public boolean c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f115d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f116e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f117f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f118g;
        boolean h;

        public c(int i, int i2) {
            super(i, i2);
            this.c = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.c = cVar.c;
        }
    }

    private class d implements androidx.appcompat.view.menu.g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void a(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.g.a aVar = ActionMenuView.this.w;
            if (aVar != null) {
                aVar.a(gVar);
            }
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean b(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.B;
            return eVar != null && eVar.onMenuItemClick(menuItem);
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.z = (int) (56.0f * f2);
        this.A = (int) (f2 * 4.0f);
        this.r = context;
        this.s = 0;
    }

    static int L(View view, int i, int i2, int i3, int i4) {
        c cVar = (c) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = actionMenuItemView != null && actionMenuItemView.f();
        int i5 = 2;
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, RecyclerView.UNDEFINED_DURATION), iMakeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z || i6 >= 2) {
                i5 = i6;
            }
        }
        cVar.f117f = !cVar.c && z;
        cVar.f115d = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), iMakeMeasureSpec);
        return i5;
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    private void M(int i, int i2) {
        boolean z;
        int i3;
        boolean z2;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
        int i4 = size - paddingLeft;
        int i5 = this.z;
        int i6 = i4 / i5;
        int i7 = i4 % i5;
        if (i6 == 0) {
            setMeasuredDimension(i4, 0);
            return;
        }
        int i8 = i5 + (i7 / i6);
        int childCount = getChildCount();
        int iMax = 0;
        int i9 = 0;
        boolean z3 = false;
        int i10 = 0;
        int iMax2 = 0;
        int i11 = 0;
        long j = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            int i12 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z4 = childAt instanceof ActionMenuItemView;
                int i13 = i10 + 1;
                if (z4) {
                    int i14 = this.A;
                    r14 = 0;
                    childAt.setPadding(i14, 0, i14, 0);
                } else {
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.h = r14;
                cVar.f116e = r14;
                cVar.f115d = r14;
                cVar.f117f = r14;
                ((ViewGroup.MarginLayoutParams) cVar).leftMargin = r14;
                ((ViewGroup.MarginLayoutParams) cVar).rightMargin = r14;
                cVar.f118g = z4 && ((ActionMenuItemView) childAt).f();
                int iL = L(childAt, i8, cVar.c ? 1 : i6, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iL);
                if (cVar.f117f) {
                    i11++;
                }
                if (cVar.c) {
                    z3 = true;
                }
                i6 -= iL;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iL == 1) {
                    j |= (long) (1 << i9);
                    iMax = iMax;
                }
                i10 = i13;
            }
            i9++;
            size2 = i12;
        }
        int i15 = size2;
        boolean z5 = z3 && i10 == 2;
        boolean z6 = false;
        while (true) {
            if (i11 <= 0 || i6 <= 0) {
                z = z6;
                i3 = iMax;
                break;
            }
            int i16 = 0;
            int i17 = 0;
            int i18 = Integer.MAX_VALUE;
            long j2 = 0;
            while (i17 < childCount) {
                boolean z7 = z6;
                c cVar2 = (c) getChildAt(i17).getLayoutParams();
                int i19 = iMax;
                if (cVar2.f117f) {
                    int i20 = cVar2.f115d;
                    if (i20 < i18) {
                        j2 = 1 << i17;
                        i18 = i20;
                        i16 = 1;
                    } else if (i20 == i18) {
                        i16++;
                        j2 |= 1 << i17;
                    }
                }
                i17++;
                iMax = i19;
                z6 = z7;
            }
            z = z6;
            i3 = iMax;
            j |= j2;
            if (i16 > i6) {
                break;
            }
            int i21 = i18 + 1;
            int i22 = 0;
            while (i22 < childCount) {
                View childAt2 = getChildAt(i22);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i23 = i4;
                int i24 = mode;
                long j3 = 1 << i22;
                if ((j2 & j3) == 0) {
                    if (cVar3.f115d == i21) {
                        j |= j3;
                    }
                    z5 = z5;
                } else {
                    if (z5 && cVar3.f118g && i6 == 1) {
                        int i25 = this.A;
                        childAt2.setPadding(i25 + i8, 0, i25, 0);
                    }
                    cVar3.f115d++;
                    cVar3.h = true;
                    i6--;
                }
                i22++;
                mode = i24;
                i4 = i23;
                z5 = z5;
            }
            iMax = i3;
            z6 = true;
        }
        boolean z8 = !z3 && i10 == 1;
        if (i6 <= 0 || j == 0 || (i6 >= i10 - 1 && !z8 && iMax2 <= 1)) {
            z2 = z;
        } else {
            float fBitCount = Long.bitCount(j);
            if (!z8) {
                if ((j & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f118g) {
                    fBitCount -= 0.5f;
                }
                int i26 = childCount - 1;
                if ((j & ((long) (1 << i26))) != 0 && !((c) getChildAt(i26).getLayoutParams()).f118g) {
                    fBitCount -= 0.5f;
                }
            }
            int i27 = fBitCount > 0.0f ? (int) ((i6 * i8) / fBitCount) : 0;
            z2 = z;
            for (int i28 = 0; i28 < childCount; i28++) {
                if ((j & ((long) (1 << i28))) != 0) {
                    View childAt3 = getChildAt(i28);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f116e = i27;
                        cVar4.h = true;
                        if (i28 == 0 && !cVar4.f118g) {
                            ((ViewGroup.MarginLayoutParams) cVar4).leftMargin = (-i27) / 2;
                        }
                    } else if (cVar4.c) {
                        cVar4.f116e = i27;
                        cVar4.h = true;
                        ((ViewGroup.MarginLayoutParams) cVar4).rightMargin = (-i27) / 2;
                    } else {
                        if (i28 != 0) {
                            ((ViewGroup.MarginLayoutParams) cVar4).leftMargin = i27 / 2;
                        }
                        if (i28 != childCount - 1) {
                            ((ViewGroup.MarginLayoutParams) cVar4).rightMargin = i27 / 2;
                        }
                    }
                    z2 = true;
                }
            }
        }
        if (z2) {
            for (int i29 = 0; i29 < childCount; i29++) {
                View childAt4 = getChildAt(i29);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.h) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f115d * i8) + cVar5.f116e, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i4, mode != 1073741824 ? i3 : i15);
    }

    public void B() {
        androidx.appcompat.widget.c cVar = this.u;
        if (cVar != null) {
            cVar.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.i0
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        cVar.b = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.i0
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.i0
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (cVar.b <= 0) {
            cVar.b = 16;
        }
        return cVar;
    }

    public c F() {
        c cVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        cVarGenerateDefaultLayoutParams.c = true;
        return cVarGenerateDefaultLayoutParams;
    }

    protected boolean G(int i) {
        boolean zB = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            zB = false | ((a) childAt).b();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? zB : zB | ((a) childAt2).a();
    }

    public boolean H() {
        androidx.appcompat.widget.c cVar = this.u;
        return cVar != null && cVar.A();
    }

    public boolean I() {
        androidx.appcompat.widget.c cVar = this.u;
        return cVar != null && cVar.C();
    }

    public boolean J() {
        androidx.appcompat.widget.c cVar = this.u;
        return cVar != null && cVar.D();
    }

    public boolean K() {
        return this.t;
    }

    public androidx.appcompat.view.menu.g N() {
        return this.q;
    }

    public void O(androidx.appcompat.view.menu.m.a aVar, androidx.appcompat.view.menu.g.a aVar2) {
        this.v = aVar;
        this.w = aVar2;
    }

    public boolean P() {
        androidx.appcompat.widget.c cVar = this.u;
        return cVar != null && cVar.J();
    }

    @Override // androidx.appcompat.view.menu.g.b
    public boolean b(androidx.appcompat.view.menu.i iVar) {
        return this.q.L(iVar, 0);
    }

    @Override // androidx.appcompat.widget.i0, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // androidx.appcompat.view.menu.n
    public void d(androidx.appcompat.view.menu.g gVar) {
        this.q = gVar;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.q == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
            this.q = gVar;
            gVar.R(new d());
            androidx.appcompat.widget.c cVar = new androidx.appcompat.widget.c(context);
            this.u = cVar;
            cVar.I(true);
            androidx.appcompat.widget.c cVar2 = this.u;
            androidx.appcompat.view.menu.m.a bVar = this.v;
            if (bVar == null) {
                bVar = new b();
            }
            cVar2.e(bVar);
            this.q.c(this.u, this.r);
            this.u.G(this);
        }
        return this.q;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.u.z();
    }

    public int getPopupTheme() {
        return this.s;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.widget.c cVar = this.u;
        if (cVar != null) {
            cVar.i(false);
            if (this.u.D()) {
                this.u.A();
                this.u.J();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    @Override // androidx.appcompat.widget.i0, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int paddingLeft;
        if (!this.x) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i5 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i6 = i3 - i;
        int paddingRight = (i6 - getPaddingRight()) - getPaddingLeft();
        boolean zB = c1.b(this);
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.c) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (G(i9)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zB) {
                        paddingLeft = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i10 = i5 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i10, width, measuredHeight + i10);
                    paddingRight -= measuredWidth;
                    i7 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin) + ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                    G(i9);
                    i8++;
                }
            }
        }
        if (childCount == 1 && i7 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i11 = (i6 / 2) - (measuredWidth2 / 2);
            int i12 = i5 - (measuredHeight2 / 2);
            childAt2.layout(i11, i12, measuredWidth2 + i11, measuredHeight2 + i12);
            return;
        }
        int i13 = i8 - (i7 ^ 1);
        int iMax = Math.max(0, i13 > 0 ? paddingRight / i13 : 0);
        if (zB) {
            int width2 = getWidth() - getPaddingRight();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt3 = getChildAt(i14);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.c) {
                    int i15 = width2 - ((ViewGroup.MarginLayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i16 = i5 - (measuredHeight3 / 2);
                    childAt3.layout(i15 - measuredWidth3, i16, i15, measuredHeight3 + i16);
                    width2 = i15 - ((measuredWidth3 + ((ViewGroup.MarginLayoutParams) cVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt4 = getChildAt(i17);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.c) {
                int i18 = paddingLeft2 + ((ViewGroup.MarginLayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i19 = i5 - (measuredHeight4 / 2);
                childAt4.layout(i18, i19, i18 + measuredWidth4, measuredHeight4 + i19);
                paddingLeft2 = i18 + measuredWidth4 + ((ViewGroup.MarginLayoutParams) cVar3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.i0, android.view.View
    protected void onMeasure(int i, int i2) {
        androidx.appcompat.view.menu.g gVar;
        boolean z = this.x;
        boolean z2 = View.MeasureSpec.getMode(i) == 1073741824;
        this.x = z2;
        if (z != z2) {
            this.y = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.x && (gVar = this.q) != null && size != this.y) {
            this.y = size;
            gVar.K(true);
        }
        int childCount = getChildCount();
        if (this.x && childCount > 0) {
            M(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            c cVar = (c) getChildAt(i3).getLayoutParams();
            ((ViewGroup.MarginLayoutParams) cVar).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.u.F(z);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.B = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.u.H(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.t = z;
    }

    public void setPopupTheme(int i) {
        if (this.s != i) {
            this.s = i;
            if (i == 0) {
                this.r = getContext();
            } else {
                this.r = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(androidx.appcompat.widget.c cVar) {
        this.u = cVar;
        cVar.G(this);
    }
}
