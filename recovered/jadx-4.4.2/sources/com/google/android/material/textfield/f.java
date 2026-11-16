package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.z;
import androidx.core.widget.i;
import d.f.k.r;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class f {
    private final Context a;
    private final TextInputLayout b;
    private LinearLayout c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FrameLayout f660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Animator f662g;
    private final float h;
    private int i;
    private int j;
    private CharSequence k;
    private boolean l;
    private TextView m;
    private int n;
    private ColorStateList o;
    private CharSequence p;
    private boolean q;
    private TextView r;
    private int s;
    private ColorStateList t;
    private Typeface u;

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ int a;
        final /* synthetic */ TextView b;
        final /* synthetic */ int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f663d;

        a(int i, TextView textView, int i2, TextView textView2) {
            this.a = i;
            this.b = textView;
            this.c = i2;
            this.f663d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.i = this.a;
            f.this.f662g = null;
            TextView textView = this.b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.c == 1 && f.this.m != null) {
                    f.this.m.setText((CharSequence) null);
                }
                TextView textView2 = this.f663d;
                if (textView2 != null) {
                    textView2.setTranslationY(0.0f);
                    this.f663d.setAlpha(1.0f);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f663d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public f(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.a = context;
        this.b = textInputLayout;
        this.h = context.getResources().getDimensionPixelSize(e.a.a.a.d.design_textinput_caption_translate_y);
    }

    private void F(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void H(ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean I(TextView textView, CharSequence charSequence) {
        return r.J(this.b) && this.b.isEnabled() && !(this.j == this.i && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void L(int i, int i2, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f662g = animatorSet;
            ArrayList arrayList = new ArrayList();
            h(arrayList, this.q, this.r, 2, i, i2);
            h(arrayList, this.l, this.m, 1, i, i2);
            e.a.a.a.l.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i2, l(i), i, l(i2)));
            animatorSet.start();
        } else {
            y(i, i2);
        }
        this.b.Y();
        this.b.c0(z);
        this.b.e0();
    }

    private boolean f() {
        return (this.c == null || this.b.getEditText() == null) ? false : true;
    }

    private void h(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            list.add(i(textView, i3 == i));
            if (i3 == i) {
                list.add(j(textView));
            }
        }
    }

    private ObjectAnimator i(TextView textView, boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(167L);
        objectAnimatorOfFloat.setInterpolator(e.a.a.a.l.a.a);
        return objectAnimatorOfFloat;
    }

    private ObjectAnimator j(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.h, 0.0f);
        objectAnimatorOfFloat.setDuration(217L);
        objectAnimatorOfFloat.setInterpolator(e.a.a.a.l.a.f918d);
        return objectAnimatorOfFloat;
    }

    private TextView l(int i) {
        if (i == 1) {
            return this.m;
        }
        if (i != 2) {
            return null;
        }
        return this.r;
    }

    private boolean t(int i) {
        return (i != 1 || this.m == null || TextUtils.isEmpty(this.k)) ? false : true;
    }

    private void y(int i, int i2) {
        TextView textViewL;
        TextView textViewL2;
        if (i == i2) {
            return;
        }
        if (i2 != 0 && (textViewL2 = l(i2)) != null) {
            textViewL2.setVisibility(0);
            textViewL2.setAlpha(1.0f);
        }
        if (i != 0 && (textViewL = l(i)) != null) {
            textViewL.setVisibility(4);
            if (i == 1) {
                textViewL.setText((CharSequence) null);
            }
        }
        this.i = i2;
    }

    void A(int i) {
        this.n = i;
        TextView textView = this.m;
        if (textView != null) {
            this.b.Q(textView, i);
        }
    }

    void B(ColorStateList colorStateList) {
        this.o = colorStateList;
        TextView textView = this.m;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void C(int i) {
        this.s = i;
        TextView textView = this.r;
        if (textView != null) {
            i.n(textView, i);
        }
    }

    void D(boolean z) {
        if (this.q == z) {
            return;
        }
        g();
        if (z) {
            z zVar = new z(this.a);
            this.r = zVar;
            zVar.setId(e.a.a.a.f.textinput_helper_text);
            Typeface typeface = this.u;
            if (typeface != null) {
                this.r.setTypeface(typeface);
            }
            this.r.setVisibility(4);
            r.e0(this.r, 1);
            C(this.s);
            E(this.t);
            d(this.r, 1);
        } else {
            s();
            x(this.r, 1);
            this.r = null;
            this.b.Y();
            this.b.e0();
        }
        this.q = z;
    }

    void E(ColorStateList colorStateList) {
        this.t = colorStateList;
        TextView textView = this.r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void G(Typeface typeface) {
        if (typeface != this.u) {
            this.u = typeface;
            F(this.m, typeface);
            F(this.r, typeface);
        }
    }

    void J(CharSequence charSequence) {
        g();
        this.k = charSequence;
        this.m.setText(charSequence);
        if (this.i != 1) {
            this.j = 1;
        }
        L(this.i, this.j, I(this.m, charSequence));
    }

    void K(CharSequence charSequence) {
        g();
        this.p = charSequence;
        this.r.setText(charSequence);
        if (this.i != 2) {
            this.j = 2;
        }
        L(this.i, this.j, I(this.r, charSequence));
    }

    void d(TextView textView, int i) {
        if (this.c == null && this.f660e == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            this.c = linearLayout;
            linearLayout.setOrientation(0);
            this.b.addView(this.c, -1, -2);
            FrameLayout frameLayout = new FrameLayout(this.a);
            this.f660e = frameLayout;
            this.c.addView(frameLayout, -1, new FrameLayout.LayoutParams(-2, -2));
            this.c.addView(new Space(this.a), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.b.getEditText() != null) {
                e();
            }
        }
        if (u(i)) {
            this.f660e.setVisibility(0);
            this.f660e.addView(textView);
            this.f661f++;
        } else {
            this.c.addView(textView, i);
        }
        this.c.setVisibility(0);
        this.f659d++;
    }

    void e() {
        if (f()) {
            r.p0(this.c, r.A(this.b.getEditText()), 0, r.z(this.b.getEditText()), 0);
        }
    }

    void g() {
        Animator animator = this.f662g;
        if (animator != null) {
            animator.cancel();
        }
    }

    boolean k() {
        return t(this.j);
    }

    CharSequence m() {
        return this.k;
    }

    int n() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    ColorStateList o() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    CharSequence p() {
        return this.p;
    }

    int q() {
        TextView textView = this.r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    void r() {
        this.k = null;
        g();
        if (this.i == 1) {
            this.j = (!this.q || TextUtils.isEmpty(this.p)) ? 0 : 2;
        }
        L(this.i, this.j, I(this.m, null));
    }

    void s() {
        g();
        if (this.i == 2) {
            this.j = 0;
        }
        L(this.i, this.j, I(this.r, null));
    }

    boolean u(int i) {
        return i == 0 || i == 1;
    }

    boolean v() {
        return this.l;
    }

    boolean w() {
        return this.q;
    }

    void x(TextView textView, int i) {
        FrameLayout frameLayout;
        if (this.c == null) {
            return;
        }
        if (!u(i) || (frameLayout = this.f660e) == null) {
            this.c.removeView(textView);
        } else {
            int i2 = this.f661f - 1;
            this.f661f = i2;
            H(frameLayout, i2);
            this.f660e.removeView(textView);
        }
        int i3 = this.f659d - 1;
        this.f659d = i3;
        H(this.c, i3);
    }

    void z(boolean z) {
        if (this.l == z) {
            return;
        }
        g();
        if (z) {
            z zVar = new z(this.a);
            this.m = zVar;
            zVar.setId(e.a.a.a.f.textinput_error);
            Typeface typeface = this.u;
            if (typeface != null) {
                this.m.setTypeface(typeface);
            }
            A(this.n);
            B(this.o);
            this.m.setVisibility(4);
            r.e0(this.m, 1);
            d(this.m, 0);
        } else {
            r();
            x(this.m, 0);
            this.m = null;
            this.b.Y();
            this.b.e0();
        }
        this.l = z;
    }
}
