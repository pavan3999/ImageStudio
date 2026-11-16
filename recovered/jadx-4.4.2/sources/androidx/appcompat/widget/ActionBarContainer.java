package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {
    private boolean b;
    private View c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Drawable f109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Drawable f110g;
    Drawable h;
    boolean i;
    boolean j;
    private int k;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d.f.k.r.f0(this, new b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.j.ActionBar);
        this.f109f = typedArrayObtainStyledAttributes.getDrawable(d.a.j.ActionBar_background);
        this.f110g = typedArrayObtainStyledAttributes.getDrawable(d.a.j.ActionBar_backgroundStacked);
        this.k = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.a.j.ActionBar_height, -1);
        boolean z = true;
        if (getId() == d.a.f.split_action_bar) {
            this.i = true;
            this.h = typedArrayObtainStyledAttributes.getDrawable(d.a.j.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.i ? this.f109f != null || this.f110g != null : this.h != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f109f;
        if (drawable != null && drawable.isStateful()) {
            this.f109f.setState(getDrawableState());
        }
        Drawable drawable2 = this.f110g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f110g.setState(getDrawableState());
        }
        Drawable drawable3 = this.h;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.h.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f109f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f110g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f107d = findViewById(d.a.f.action_bar);
        this.f108e = findViewById(d.a.f.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.b || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        Drawable drawable2;
        int left;
        int top;
        int right;
        View view;
        super.onLayout(z, i, i2, i3, i4);
        View view2 = this.c;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view2 == null || view2.getVisibility() == 8) ? false : true;
        if (view2 != null && view2.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
            int measuredHeight2 = measuredHeight - view2.getMeasuredHeight();
            int i5 = layoutParams.bottomMargin;
            view2.layout(i, measuredHeight2 - i5, i3, measuredHeight - i5);
        }
        if (this.i) {
            Drawable drawable3 = this.h;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f109f != null) {
                if (this.f107d.getVisibility() == 0) {
                    drawable2 = this.f109f;
                    left = this.f107d.getLeft();
                    top = this.f107d.getTop();
                    right = this.f107d.getRight();
                    view = this.f107d;
                } else {
                    View view3 = this.f108e;
                    if (view3 == null || view3.getVisibility() != 0) {
                        this.f109f.setBounds(0, 0, 0, 0);
                    } else {
                        drawable2 = this.f109f;
                        left = this.f108e.getLeft();
                        top = this.f108e.getTop();
                        right = this.f108e.getRight();
                        view = this.f108e;
                    }
                    z3 = true;
                }
                drawable2.setBounds(left, top, right, view.getBottom());
                z3 = true;
            }
            this.j = z4;
            if (!z4 || (drawable = this.f110g) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0055  */
    /* JADX WARN: Code duplicated, block: B:28:0x005a  */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int iA;
        View view;
        int size;
        int i3;
        if (this.f107d == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i3 = this.k) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, View.MeasureSpec.getSize(i2)), RecyclerView.UNDEFINED_DURATION);
        }
        super.onMeasure(i, i2);
        if (this.f107d == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        View view2 = this.c;
        if (view2 == null || view2.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (b(this.f107d)) {
            if (b(this.f108e)) {
                iA = 0;
            } else {
                view = this.f108e;
            }
            if (mode == Integer.MIN_VALUE) {
                size = View.MeasureSpec.getSize(i2);
            } else {
                size = Integer.MAX_VALUE;
            }
            setMeasuredDimension(getMeasuredWidth(), Math.min(iA + a(this.c), size));
        }
        view = this.f107d;
        iA = a(view);
        if (mode == Integer.MIN_VALUE) {
            size = View.MeasureSpec.getSize(i2);
        } else {
            size = Integer.MAX_VALUE;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(iA + a(this.c), size));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f109f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f109f);
        }
        this.f109f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f107d;
            if (view != null) {
                this.f109f.setBounds(view.getLeft(), this.f107d.getTop(), this.f107d.getRight(), this.f107d.getBottom());
            }
        }
        boolean z = true;
        if (!this.i ? this.f109f != null || this.f110g != null : this.h != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.h);
        }
        this.h = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.i && (drawable2 = this.h) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.i ? !(this.f109f != null || this.f110g != null) : this.h == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f110g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f110g);
        }
        this.f110g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.j && (drawable2 = this.f110g) != null) {
                drawable2.setBounds(this.c.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
            }
        }
        boolean z = true;
        if (!this.i ? this.f109f != null || this.f110g != null : this.h != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(p0 p0Var) {
        View view = this.c;
        if (view != null) {
            removeView(view);
        }
        this.c = p0Var;
        if (p0Var != null) {
            addView(p0Var);
            ViewGroup.LayoutParams layoutParams = p0Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            p0Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.b = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f109f;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f110g;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.h;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f109f && !this.i) || (drawable == this.f110g && this.j) || ((drawable == this.h && this.i) || super.verifyDrawable(drawable));
    }
}
