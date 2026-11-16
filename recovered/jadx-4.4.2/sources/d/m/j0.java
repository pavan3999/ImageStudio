package d.m;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class j0 extends m {
    private static final String[] L = {"android:visibility:visibility", "android:visibility:parent"};
    private int K = 3;

    class a extends n {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ View b;
        final /* synthetic */ View c;

        a(ViewGroup viewGroup, View view, View view2) {
            this.a = viewGroup;
            this.b = view;
            this.c = view2;
        }

        @Override // d.m.m.f
        public void c(m mVar) {
            this.c.setTag(j.save_overlay_view, null);
            x.a(this.a).a(this.b);
            mVar.P(this);
        }

        @Override // d.m.n, d.m.m.f
        public void d(m mVar) {
            x.a(this.a).a(this.b);
        }

        @Override // d.m.n, d.m.m.f
        public void e(m mVar) {
            if (this.b.getParent() == null) {
                x.a(this.a).c(this.b);
            } else {
                j0.this.f();
            }
        }
    }

    private static class b extends AnimatorListenerAdapter implements m.f, d.m.a.InterfaceC0061a {
        private final View a;
        private final int b;
        private final ViewGroup c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f839d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f840e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f841f = false;

        b(View view, int i, boolean z) {
            this.a = view;
            this.b = i;
            this.c = (ViewGroup) view.getParent();
            this.f839d = z;
            g(true);
        }

        private void f() {
            if (!this.f841f) {
                c0.h(this.a, this.b);
                ViewGroup viewGroup = this.c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z) {
            ViewGroup viewGroup;
            if (!this.f839d || this.f840e == z || (viewGroup = this.c) == null) {
                return;
            }
            this.f840e = z;
            x.c(viewGroup, z);
        }

        @Override // d.m.m.f
        public void a(m mVar) {
        }

        @Override // d.m.m.f
        public void b(m mVar) {
        }

        @Override // d.m.m.f
        public void c(m mVar) {
            f();
            mVar.P(this);
        }

        @Override // d.m.m.f
        public void d(m mVar) {
            g(false);
        }

        @Override // d.m.m.f
        public void e(m mVar) {
            g(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f841f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, d.m.a.InterfaceC0061a
        public void onAnimationPause(Animator animator) {
            if (this.f841f) {
                return;
            }
            c0.h(this.a, this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, d.m.a.InterfaceC0061a
        public void onAnimationResume(Animator animator) {
            if (this.f841f) {
                return;
            }
            c0.h(this.a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    private static class c {
        boolean a;
        boolean b;
        int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f842d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ViewGroup f843e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ViewGroup f844f;

        c() {
        }
    }

    private void c0(s sVar) {
        sVar.a.put("android:visibility:visibility", Integer.valueOf(sVar.b.getVisibility()));
        sVar.a.put("android:visibility:parent", sVar.b.getParent());
        int[] iArr = new int[2];
        sVar.b.getLocationOnScreen(iArr);
        sVar.a.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0097  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        if (r9 == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0083, code lost:
    
        if (r0.f843e == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0095, code lost:
    
        if (r0.c == 0) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c d0(s sVar, s sVar2) {
        c cVar = new c();
        cVar.a = false;
        cVar.b = false;
        if (sVar == null || !sVar.a.containsKey("android:visibility:visibility")) {
            cVar.c = -1;
            cVar.f843e = null;
        } else {
            cVar.c = ((Integer) sVar.a.get("android:visibility:visibility")).intValue();
            cVar.f843e = (ViewGroup) sVar.a.get("android:visibility:parent");
        }
        if (sVar2 == null || !sVar2.a.containsKey("android:visibility:visibility")) {
            cVar.f842d = -1;
            cVar.f844f = null;
        } else {
            cVar.f842d = ((Integer) sVar2.a.get("android:visibility:visibility")).intValue();
            cVar.f844f = (ViewGroup) sVar2.a.get("android:visibility:parent");
        }
        if (sVar == null || sVar2 == null) {
            if (sVar == null && cVar.f842d == 0) {
                cVar.b = true;
                cVar.a = true;
            } else if (sVar2 == null) {
            }
        } else {
            if (cVar.c == cVar.f842d && cVar.f843e == cVar.f844f) {
                return cVar;
            }
            int i = cVar.c;
            int i2 = cVar.f842d;
            if (i != i2) {
                if (i == 0) {
                    cVar.b = false;
                    cVar.a = true;
                }
            } else if (cVar.f844f == null) {
                cVar.b = false;
                cVar.a = true;
            }
        }
        return cVar;
    }

    @Override // d.m.m
    public String[] D() {
        return L;
    }

    @Override // d.m.m
    public boolean F(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar != null && sVar2 != null && sVar2.a.containsKey("android:visibility:visibility") != sVar.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c cVarD0 = d0(sVar, sVar2);
        if (cVarD0.a) {
            return cVarD0.c == 0 || cVarD0.f842d == 0;
        }
        return false;
    }

    public abstract Animator e0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    public Animator f0(ViewGroup viewGroup, s sVar, int i, s sVar2, int i2) {
        if ((this.K & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.b.getParent();
            if (d0(t(view, false), E(view, false)).a) {
                return null;
            }
        }
        return e0(viewGroup, sVar2.b, sVar, sVar2);
    }

    @Override // d.m.m
    public void g(s sVar) {
        c0(sVar);
    }

    public abstract Animator g0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    /* JADX WARN: Code duplicated, block: B:25:0x003b  */
    public Animator h0(ViewGroup viewGroup, s sVar, int i, s sVar2, int i2) {
        View view;
        boolean z;
        boolean z2;
        View view2;
        if ((this.K & 2) != 2 || sVar == null) {
            return null;
        }
        View view3 = sVar.b;
        View viewA = sVar2 != null ? sVar2.b : null;
        View view4 = (View) view3.getTag(j.save_overlay_view);
        if (view4 != null) {
            view2 = null;
            z2 = true;
        } else {
            if (viewA == null || viewA.getParent() == null) {
                if (viewA != null) {
                    view = null;
                    z = false;
                } else {
                    viewA = null;
                    view = null;
                    z = true;
                }
            } else if (i2 == 4 || view3 == viewA) {
                view = viewA;
                z = false;
                viewA = null;
            } else {
                viewA = null;
                view = null;
                z = true;
            }
            if (z) {
                if (view3.getParent() != null) {
                    if (view3.getParent() instanceof View) {
                        View view5 = (View) view3.getParent();
                        if (d0(E(view5, true), t(view5, true)).a) {
                            int id = view5.getId();
                            if (view5.getParent() != null || id == -1 || viewGroup.findViewById(id) == null || !this.w) {
                            }
                        } else {
                            viewA = r.a(viewGroup, view3, view5);
                        }
                    }
                    z2 = false;
                    View view6 = view;
                    view4 = viewA;
                    view2 = view6;
                }
                view2 = view;
                z2 = false;
                view4 = view3;
            } else {
                z2 = false;
                View view7 = view;
                view4 = viewA;
                view2 = view7;
            }
        }
        if (view4 == null) {
            if (view2 == null) {
                return null;
            }
            int visibility = view2.getVisibility();
            c0.h(view2, 0);
            Animator animatorG0 = g0(viewGroup, view2, sVar, sVar2);
            if (animatorG0 != null) {
                b bVar = new b(view2, i2, true);
                animatorG0.addListener(bVar);
                d.m.a.a(animatorG0, bVar);
                a(bVar);
            } else {
                c0.h(view2, visibility);
            }
            return animatorG0;
        }
        if (!z2) {
            int[] iArr = (int[]) sVar.a.get("android:visibility:screenLocation");
            int i3 = iArr[0];
            int i4 = iArr[1];
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            view4.offsetLeftAndRight((i3 - iArr2[0]) - view4.getLeft());
            view4.offsetTopAndBottom((i4 - iArr2[1]) - view4.getTop());
            x.a(viewGroup).c(view4);
        }
        Animator animatorG1 = g0(viewGroup, view4, sVar, sVar2);
        if (!z2) {
            if (animatorG1 == null) {
                x.a(viewGroup).a(view4);
            } else {
                view3.setTag(j.save_overlay_view, view4);
                a(new a(viewGroup, view4, view3));
            }
        }
        return animatorG1;
    }

    public void i0(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.K = i;
    }

    @Override // d.m.m
    public void j(s sVar) {
        c0(sVar);
    }

    @Override // d.m.m
    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        c cVarD0 = d0(sVar, sVar2);
        if (!cVarD0.a) {
            return null;
        }
        if (cVarD0.f843e == null && cVarD0.f844f == null) {
            return null;
        }
        return cVarD0.b ? f0(viewGroup, sVar, cVarD0.c, sVar2, cVarD0.f842d) : h0(viewGroup, sVar, cVarD0.c, sVar2, cVarD0.f842d);
    }
}
