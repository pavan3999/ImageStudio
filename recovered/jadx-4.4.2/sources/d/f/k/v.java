package d.f.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class v {
    private WeakReference<View> a;
    Runnable b = null;
    Runnable c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f803d = -1;

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ w a;
        final /* synthetic */ View b;

        a(v vVar, w wVar, View view) {
            this.a = wVar;
            this.b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a.c(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.a(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.b(this.b);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ y a;
        final /* synthetic */ View b;

        b(v vVar, y yVar, View view) {
            this.a = yVar;
            this.b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.a(this.b);
        }
    }

    static class c implements w {
        v a;
        boolean b;

        c(v vVar) {
            this.a = vVar;
        }

        @Override // d.f.k.w
        public void a(View view) {
            int i = this.a.f803d;
            if (i > -1) {
                view.setLayerType(i, null);
                this.a.f803d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.b) {
                v vVar = this.a;
                Runnable runnable = vVar.c;
                if (runnable != null) {
                    vVar.c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                w wVar = tag instanceof w ? (w) tag : null;
                if (wVar != null) {
                    wVar.a(view);
                }
                this.b = true;
            }
        }

        @Override // d.f.k.w
        public void b(View view) {
            this.b = false;
            if (this.a.f803d > -1) {
                view.setLayerType(2, null);
            }
            v vVar = this.a;
            Runnable runnable = vVar.b;
            if (runnable != null) {
                vVar.b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            w wVar = tag instanceof w ? (w) tag : null;
            if (wVar != null) {
                wVar.b(view);
            }
        }

        @Override // d.f.k.w
        public void c(View view) {
            Object tag = view.getTag(2113929216);
            w wVar = tag instanceof w ? (w) tag : null;
            if (wVar != null) {
                wVar.c(view);
            }
        }
    }

    v(View view) {
        this.a = new WeakReference<>(view);
    }

    private void g(View view, w wVar) {
        if (wVar != null) {
            view.animate().setListener(new a(this, wVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public v a(float f2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public void b() {
        View view = this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long c() {
        View view = this.a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public v d(long j) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public v e(Interpolator interpolator) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public v f(w wVar) {
        View view = this.a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT < 16) {
                view.setTag(2113929216, wVar);
                wVar = new c(this);
            }
            g(view, wVar);
        }
        return this;
    }

    public v h(long j) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public v i(y yVar) {
        View view = this.a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(yVar != null ? new b(this, yVar, view) : null);
        }
        return this;
    }

    public void j() {
        View view = this.a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public v k(float f2) {
        View view = this.a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }
}
