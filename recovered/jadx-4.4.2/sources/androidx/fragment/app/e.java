package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes.dex */
class e {

    static class a implements d.f.g.a.InterfaceC0045a {
        final /* synthetic */ Fragment a;

        a(Fragment fragment) {
            this.a = fragment;
        }

        @Override // d.f.g.a.InterfaceC0045a
        public void a() {
            if (this.a.l() != null) {
                View viewL = this.a.l();
                this.a.d1(null);
                viewL.clearAnimation();
            }
            this.a.e1(null);
        }
    }

    static class b implements Animation.AnimationListener {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ Fragment b;
        final /* synthetic */ u.g c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.f.g.a f302d;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.b.l() != null) {
                    b.this.b.d1(null);
                    b bVar = b.this;
                    bVar.c.a(bVar.b, bVar.f302d);
                }
            }
        }

        b(ViewGroup viewGroup, Fragment fragment, u.g gVar, d.f.g.a aVar) {
            this.a = viewGroup;
            this.b = fragment;
            this.c = gVar;
            this.f302d = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    static class c extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ View b;
        final /* synthetic */ Fragment c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ u.g f303d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d.f.g.a f304e;

        c(ViewGroup viewGroup, View view, Fragment fragment, u.g gVar, d.f.g.a aVar) {
            this.a = viewGroup;
            this.b = view;
            this.c = fragment;
            this.f303d = gVar;
            this.f304e = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.endViewTransition(this.b);
            Animator animatorM = this.c.m();
            this.c.e1(null);
            if (animatorM == null || this.a.indexOfChild(this.b) >= 0) {
                return;
            }
            this.f303d.a(this.c, this.f304e);
        }
    }

    static class d {
        public final Animation a;
        public final Animator b;

        d(Animator animator) {
            this.a = null;
            this.b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        d(Animation animation) {
            this.a = animation;
            this.b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.e$e, reason: collision with other inner class name */
    private static class RunnableC0012e extends AnimationSet implements Runnable {
        private final ViewGroup b;
        private final View c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f305d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f306e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f307f;

        RunnableC0012e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f307f = true;
            this.b = viewGroup;
            this.c = view;
            addAnimation(animation);
            this.b.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.f307f = true;
            if (this.f305d) {
                return !this.f306e;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f305d = true;
                d.f.k.p.a(this.b, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f2) {
            this.f307f = true;
            if (this.f305d) {
                return !this.f306e;
            }
            if (!super.getTransformation(j, transformation, f2)) {
                this.f305d = true;
                d.f.k.p.a(this.b, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f305d || !this.f307f) {
                this.b.endViewTransition(this.c);
                this.f306e = true;
            } else {
                this.f307f = false;
                this.b.post(this);
            }
        }
    }

    static void a(Fragment fragment, d dVar, u.g gVar) {
        View view = fragment.H;
        ViewGroup viewGroup = fragment.G;
        viewGroup.startViewTransition(view);
        d.f.g.a aVar = new d.f.g.a();
        aVar.c(new a(fragment));
        gVar.b(fragment, aVar);
        if (dVar.a != null) {
            RunnableC0012e runnableC0012e = new RunnableC0012e(dVar.a, viewGroup, view);
            fragment.d1(fragment.H);
            runnableC0012e.setAnimationListener(new b(viewGroup, fragment, gVar, aVar));
            fragment.H.startAnimation(runnableC0012e);
            return;
        }
        Animator animator = dVar.b;
        fragment.e1(animator);
        animator.addListener(new c(viewGroup, view, fragment, gVar, aVar));
        animator.setTarget(fragment.H);
        animator.start();
    }

    static d b(Context context, f fVar, Fragment fragment, boolean z) {
        int iC;
        int iX = fragment.x();
        int iW = fragment.w();
        boolean z2 = false;
        fragment.h1(0);
        View viewC = fVar.c(fragment.x);
        if (viewC != null && viewC.getTag(d.i.b.visible_removing_fragment_view_tag) != null) {
            viewC.setTag(d.i.b.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup = fragment.G;
        if (viewGroup != null && viewGroup.getLayoutTransition() != null) {
            return null;
        }
        Animation animationB0 = fragment.b0(iX, z, iW);
        if (animationB0 != null) {
            return new d(animationB0);
        }
        Animator animatorC0 = fragment.c0(iX, z, iW);
        if (animatorC0 != null) {
            return new d(animatorC0);
        }
        if (iW != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(iW));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, iW);
                    if (animationLoadAnimation != null) {
                        return new d(animationLoadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iW);
                    if (animatorLoadAnimator != null) {
                        return new d(animatorLoadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (zEquals) {
                        throw e3;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, iW);
                    if (animationLoadAnimation2 != null) {
                        return new d(animationLoadAnimation2);
                    }
                }
            }
        }
        if (iX != 0 && (iC = c(iX, z)) >= 0) {
            return new d(AnimationUtils.loadAnimation(context, iC));
        }
        return null;
    }

    private static int c(int i, boolean z) {
        if (i == 4097) {
            return z ? d.i.a.fragment_open_enter : d.i.a.fragment_open_exit;
        }
        if (i == 4099) {
            return z ? d.i.a.fragment_fade_enter : d.i.a.fragment_fade_exit;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? d.i.a.fragment_close_enter : d.i.a.fragment_close_exit;
    }
}
