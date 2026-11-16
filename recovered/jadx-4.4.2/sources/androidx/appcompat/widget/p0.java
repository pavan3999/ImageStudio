package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class p0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    Runnable b;
    private c c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    i0 f197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Spinner f198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f200g;
    int h;
    private int i;
    private int j;

    class a implements Runnable {
        final /* synthetic */ View b;

        a(View view) {
            this.b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            p0.this.smoothScrollTo(this.b.getLeft() - ((p0.this.getWidth() - this.b.getWidth()) / 2), 0);
            p0.this.b = null;
        }
    }

    private class b extends BaseAdapter {
        b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return p0.this.f197d.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((d) p0.this.f197d.getChildAt(i)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return p0.this.c((androidx.appcompat.app.a.c) getItem(i), true);
            }
            ((d) view).a((androidx.appcompat.app.a.c) getItem(i));
            return view;
        }
    }

    private class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).b().e();
            int childCount = p0.this.f197d.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = p0.this.f197d.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private class d extends LinearLayout {
        private final int[] b;
        private androidx.appcompat.app.a.c c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private TextView f201d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ImageView f202e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f203f;

        public d(Context context, androidx.appcompat.app.a.c cVar, boolean z) {
            super(context, null, d.a.a.actionBarTabStyle);
            int[] iArr = {R.attr.background};
            this.b = iArr;
            this.c = cVar;
            w0 w0VarU = w0.u(context, null, iArr, d.a.a.actionBarTabStyle, 0);
            if (w0VarU.r(0)) {
                setBackgroundDrawable(w0VarU.g(0));
            }
            w0VarU.v();
            if (z) {
                setGravity(8388627);
            }
            c();
        }

        public void a(androidx.appcompat.app.a.c cVar) {
            this.c = cVar;
            c();
        }

        public androidx.appcompat.app.a.c b() {
            return this.c;
        }

        public void c() {
            androidx.appcompat.app.a.c cVar = this.c;
            View viewB = cVar.b();
            if (viewB != null) {
                ViewParent parent = viewB.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewB);
                    }
                    addView(viewB);
                }
                this.f203f = viewB;
                TextView textView = this.f201d;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f202e;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f202e.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f203f;
            if (view != null) {
                removeView(view);
                this.f203f = null;
            }
            Drawable drawableC = cVar.c();
            CharSequence charSequenceD = cVar.d();
            if (drawableC != null) {
                if (this.f202e == null) {
                    o oVar = new o(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    oVar.setLayoutParams(layoutParams);
                    addView(oVar, 0);
                    this.f202e = oVar;
                }
                this.f202e.setImageDrawable(drawableC);
                this.f202e.setVisibility(0);
            } else {
                ImageView imageView2 = this.f202e;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f202e.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(charSequenceD);
            if (z) {
                if (this.f201d == null) {
                    z zVar = new z(getContext(), null, d.a.a.actionBarTabTextStyle);
                    zVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    zVar.setLayoutParams(layoutParams2);
                    addView(zVar);
                    this.f201d = zVar;
                }
                this.f201d.setText(charSequenceD);
                this.f201d.setVisibility(0);
            } else {
                TextView textView2 = this.f201d;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f201d.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f202e;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            y0.a(this, z ? null : cVar.a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (p0.this.f200g > 0) {
                int measuredWidth = getMeasuredWidth();
                int i3 = p0.this.f200g;
                if (measuredWidth > i3) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    static {
        new DecelerateInterpolator();
    }

    private Spinner b() {
        w wVar = new w(getContext(), null, d.a.a.actionDropDownStyle);
        wVar.setLayoutParams(new i0.a(-2, -1));
        wVar.setOnItemSelectedListener(this);
        return wVar;
    }

    private boolean d() {
        Spinner spinner = this.f198e;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (d()) {
            return;
        }
        if (this.f198e == null) {
            this.f198e = b();
        }
        removeView(this.f197d);
        addView(this.f198e, new ViewGroup.LayoutParams(-2, -1));
        if (this.f198e.getAdapter() == null) {
            this.f198e.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.b;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.b = null;
        }
        this.f198e.setSelection(this.j);
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f198e);
        addView(this.f197d, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f198e.getSelectedItemPosition());
        return false;
    }

    public void a(int i) {
        View childAt = this.f197d.getChildAt(i);
        Runnable runnable = this.b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.b = aVar;
        post(aVar);
    }

    d c(androidx.appcompat.app.a.c cVar, boolean z) {
        d dVar = new d(getContext(), cVar, z);
        if (z) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.i));
        } else {
            dVar.setFocusable(true);
            if (this.c == null) {
                this.c = new c();
            }
            dVar.setOnClickListener(this.c);
        }
        return dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.b;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d.a.o.a aVarB = d.a.o.a.b(getContext());
        setContentHeight(aVarB.f());
        this.h = aVarB.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((d) view).b().e();
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0067  */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int iMin;
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f197d.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            iMin = -1;
        } else {
            if (childCount > 2) {
                this.f200g = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.f200g = View.MeasureSpec.getSize(i) / 2;
            }
            iMin = Math.min(this.f200g, this.h);
        }
        this.f200g = iMin;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
        if (!z && this.f199f) {
            this.f197d.measure(0, iMakeMeasureSpec);
            if (this.f197d.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                e();
            } else {
                f();
            }
        } else {
            f();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.j);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f199f = z;
    }

    public void setContentHeight(int i) {
        this.i = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.j = i;
        int childCount = this.f197d.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f197d.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
            i2++;
        }
        Spinner spinner = this.f198e;
        if (spinner == null || i < 0) {
            return;
        }
        spinner.setSelection(i);
    }
}
