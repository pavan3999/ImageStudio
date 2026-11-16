package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import d.f.k.r;

/* JADX INFO: loaded from: classes.dex */
abstract class a<V extends View> extends c<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    OverScroller f516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f518g;
    private int h;
    private int i;
    private VelocityTracker j;

    /* JADX INFO: renamed from: com.google.android.material.appbar.a$a, reason: collision with other inner class name */
    private class RunnableC0021a implements Runnable {
        private final CoordinatorLayout b;
        private final V c;

        RunnableC0021a(CoordinatorLayout coordinatorLayout, V v) {
            this.b = coordinatorLayout;
            this.c = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.c == null || (overScroller = a.this.f516e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                a.this.N(this.b, this.c);
                return;
            }
            a aVar = a.this;
            aVar.P(this.b, this.c, aVar.f516e.getCurrY());
            r.V(this.c, this);
        }
    }

    public a() {
        this.f518g = -1;
        this.i = -1;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f518g = -1;
        this.i = -1;
    }

    private void I() {
        if (this.j == null) {
            this.j = VelocityTracker.obtain();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.i < 0) {
            this.i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.j;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    this.j.computeCurrentVelocity(1000);
                    J(coordinatorLayout, v, -L(v), 0, this.j.getYVelocity(this.f518g));
                }
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f518g);
                if (iFindPointerIndex == -1) {
                    return false;
                }
                int y = (int) motionEvent.getY(iFindPointerIndex);
                int i = this.h - y;
                if (!this.f517f) {
                    int iAbs = Math.abs(i);
                    int i2 = this.i;
                    if (iAbs > i2) {
                        this.f517f = true;
                        i = i > 0 ? i - i2 : i + i2;
                    }
                }
                int i3 = i;
                if (this.f517f) {
                    this.h = y;
                    O(coordinatorLayout, v, i3, K(v), 0);
                }
            } else if (actionMasked == 3) {
            }
            this.f517f = false;
            this.f518g = -1;
            VelocityTracker velocityTracker2 = this.j;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.j = null;
            }
        } else {
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (!coordinatorLayout.B(v, x, y2) || !H(v)) {
                return false;
            }
            this.h = y2;
            this.f518g = motionEvent.getPointerId(0);
            I();
        }
        VelocityTracker velocityTracker3 = this.j;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
        }
        return true;
    }

    abstract boolean H(V v);

    final boolean J(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f2) {
        Runnable runnable = this.f515d;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.f515d = null;
        }
        if (this.f516e == null) {
            this.f516e = new OverScroller(v.getContext());
        }
        this.f516e.fling(0, E(), 0, Math.round(f2), 0, 0, i, i2);
        if (!this.f516e.computeScrollOffset()) {
            N(coordinatorLayout, v);
            return false;
        }
        RunnableC0021a runnableC0021a = new RunnableC0021a(coordinatorLayout, v);
        this.f515d = runnableC0021a;
        r.V(v, runnableC0021a);
        return true;
    }

    abstract int K(V v);

    abstract int L(V v);

    abstract int M();

    abstract void N(CoordinatorLayout coordinatorLayout, V v);

    final int O(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return Q(coordinatorLayout, v, M() - i, i2, i3);
    }

    int P(CoordinatorLayout coordinatorLayout, V v, int i) {
        return Q(coordinatorLayout, v, i, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE);
    }

    abstract int Q(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3);

    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int iFindPointerIndex;
        if (this.i < 0) {
            this.i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f517f) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f517f = false;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (H(v) && coordinatorLayout.B(v, x, y)) {
                this.h = y;
                this.f518g = motionEvent.getPointerId(0);
                I();
            }
        } else if (actionMasked == 1) {
            this.f517f = false;
            this.f518g = -1;
            velocityTracker = this.j;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.j = null;
            }
        } else if (actionMasked == 2) {
            int i = this.f518g;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                int y2 = (int) motionEvent.getY(iFindPointerIndex);
                if (Math.abs(y2 - this.h) > this.i) {
                    this.f517f = true;
                    this.h = y2;
                }
            }
        } else if (actionMasked == 3) {
            this.f517f = false;
            this.f518g = -1;
            velocityTracker = this.j;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.j = null;
            }
        }
        VelocityTracker velocityTracker2 = this.j;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return this.f517f;
    }
}
