package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import d.f.k.r;

/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {
    d.h.b.c a;
    b b;
    private boolean c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f530e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f529d = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f531f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f532g = 0.5f;
    float h = 0.0f;
    float i = 0.5f;
    private final d.h.b.c.AbstractC0059c j = new a();

    class a extends d.h.b.c.AbstractC0059c {
        private int a;
        private int b = -1;

        a() {
        }

        private boolean n(View view, float f2) {
            if (f2 == 0.0f) {
                return Math.abs(view.getLeft() - this.a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f532g);
            }
            boolean z = r.v(view) == 1;
            int i = SwipeDismissBehavior.this.f531f;
            if (i == 2) {
                return true;
            }
            if (i == 0) {
                if (z) {
                    if (f2 >= 0.0f) {
                        return false;
                    }
                } else if (f2 <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i != 1) {
                return false;
            }
            if (z) {
                if (f2 <= 0.0f) {
                    return false;
                }
            } else if (f2 >= 0.0f) {
                return false;
            }
            return true;
        }

        /* JADX WARN: Code duplicated, block: B:10:0x001c  */
        /* JADX WARN: Code duplicated, block: B:9:0x0012  */
        @Override // d.h.b.c.AbstractC0059c
        public int a(View view, int i, int i2) {
            int width;
            int width2;
            boolean z = r.v(view) == 1;
            int i3 = SwipeDismissBehavior.this.f531f;
            if (i3 == 0) {
                if (z) {
                    width = this.a - view.getWidth();
                    width2 = this.a;
                } else {
                    width = this.a;
                    width2 = view.getWidth() + width;
                }
            } else if (i3 != 1) {
                width = this.a - view.getWidth();
                width2 = view.getWidth() + this.a;
            } else if (z) {
                width = this.a;
                width2 = view.getWidth() + width;
            } else {
                width = this.a - view.getWidth();
                width2 = this.a;
            }
            return SwipeDismissBehavior.G(width, i, width2);
        }

        @Override // d.h.b.c.AbstractC0059c
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // d.h.b.c.AbstractC0059c
        public int d(View view) {
            return view.getWidth();
        }

        @Override // d.h.b.c.AbstractC0059c
        public void i(View view, int i) {
            this.b = i;
            this.a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // d.h.b.c.AbstractC0059c
        public void j(int i) {
            b bVar = SwipeDismissBehavior.this.b;
            if (bVar != null) {
                bVar.b(i);
            }
        }

        @Override // d.h.b.c.AbstractC0059c
        public void k(View view, int i, int i2, int i3, int i4) {
            float width = this.a + (view.getWidth() * SwipeDismissBehavior.this.h);
            float width2 = this.a + (view.getWidth() * SwipeDismissBehavior.this.i);
            float f2 = i;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.F(0.0f, 1.0f - SwipeDismissBehavior.I(width, width2, f2), 1.0f));
            }
        }

        @Override // d.h.b.c.AbstractC0059c
        public void l(View view, float f2, float f3) {
            int i;
            boolean z;
            b bVar;
            this.b = -1;
            int width = view.getWidth();
            if (n(view, f2)) {
                int left = view.getLeft();
                int i2 = this.a;
                i = left < i2 ? i2 - width : i2 + width;
                z = true;
            } else {
                i = this.a;
                z = false;
            }
            if (SwipeDismissBehavior.this.a.F(i, view.getTop())) {
                r.V(view, new c(view, z));
            } else {
                if (!z || (bVar = SwipeDismissBehavior.this.b) == null) {
                    return;
                }
                bVar.a(view);
            }
        }

        @Override // d.h.b.c.AbstractC0059c
        public boolean m(View view, int i) {
            int i2 = this.b;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.E(view);
        }
    }

    public interface b {
        void a(View view);

        void b(int i);
    }

    private class c implements Runnable {
        private final View b;
        private final boolean c;

        c(View view, boolean z) {
            this.b = view;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            d.h.b.c cVar = SwipeDismissBehavior.this.a;
            if (cVar != null && cVar.k(true)) {
                r.V(this.b, this);
            } else {
                if (!this.c || (bVar = SwipeDismissBehavior.this.b) == null) {
                    return;
                }
                bVar.a(this.b);
            }
        }
    }

    static float F(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    static int G(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private void H(ViewGroup viewGroup) {
        if (this.a == null) {
            this.a = this.f530e ? d.h.b.c.l(viewGroup, this.f529d, this.j) : d.h.b.c.m(viewGroup, this.j);
        }
    }

    static float I(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        d.h.b.c cVar = this.a;
        if (cVar == null) {
            return false;
        }
        cVar.z(motionEvent);
        return true;
    }

    public boolean E(View view) {
        return true;
    }

    public void J(float f2) {
        this.i = F(0.0f, f2, 1.0f);
    }

    public void K(b bVar) {
        this.b = bVar;
    }

    public void L(float f2) {
        this.h = F(0.0f, f2, 1.0f);
    }

    public void M(int i) {
        this.f531f = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean zB = this.c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zB = coordinatorLayout.B(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.c = zB;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.c = false;
        }
        if (!zB) {
            return false;
        }
        H(coordinatorLayout);
        return this.a.G(motionEvent);
    }
}
