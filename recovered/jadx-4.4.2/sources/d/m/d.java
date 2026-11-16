package d.m;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class d extends j0 {

    class a extends n {
        final /* synthetic */ View a;

        a(d dVar, View view) {
            this.a = view;
        }

        @Override // d.m.m.f
        public void c(m mVar) {
            c0.g(this.a, 1.0f);
            c0.a(this.a);
            mVar.P(this);
        }
    }

    private static class b extends AnimatorListenerAdapter {
        private final View a;
        private boolean b = false;

        b(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c0.g(this.a, 1.0f);
            if (this.b) {
                this.a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (d.f.k.r.F(this.a) && this.a.getLayerType() == 0) {
                this.b = true;
                this.a.setLayerType(2, null);
            }
        }
    }

    public d(int i) {
        i0(i);
    }

    private Animator j0(View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        c0.g(view, f2);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, c0.b, f3);
        objectAnimatorOfFloat.addListener(new b(view));
        a(new a(this, view));
        return objectAnimatorOfFloat;
    }

    private static float k0(s sVar, float f2) {
        Float f3;
        return (sVar == null || (f3 = (Float) sVar.a.get("android:fade:transitionAlpha")) == null) ? f2 : f3.floatValue();
    }

    @Override // d.m.j0
    public Animator e0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float fK0 = k0(sVar, 0.0f);
        return j0(view, fK0 != 1.0f ? fK0 : 0.0f, 1.0f);
    }

    @Override // d.m.j0
    public Animator g0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        c0.e(view);
        return j0(view, k0(sVar, 1.0f), 0.0f);
    }

    @Override // d.m.j0, d.m.m
    public void j(s sVar) {
        super.j(sVar);
        sVar.a.put("android:fade:transitionAlpha", Float.valueOf(c0.c(sVar.b)));
    }
}
