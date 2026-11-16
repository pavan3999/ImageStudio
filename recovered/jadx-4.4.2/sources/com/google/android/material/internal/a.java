package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import d.f.k.r;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final boolean V;
    private static final Paint W;
    private boolean A;
    private Bitmap B;
    private Paint C;
    private float D;
    private float E;
    private float F;
    private float G;
    private int[] H;
    private boolean I;
    private TimeInterpolator L;
    private TimeInterpolator M;
    private float N;
    private float O;
    private float P;
    private ColorStateList Q;
    private float R;
    private float S;
    private float T;
    private ColorStateList U;
    private final View a;
    private boolean b;
    private float c;
    private ColorStateList k;
    private ColorStateList l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private Typeface s;
    private Typeface t;
    private Typeface u;
    private e.a.a.a.x.a v;
    private e.a.a.a.x.a w;
    private CharSequence x;
    private CharSequence y;
    private boolean z;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f623g = 16;
    private int h = 16;
    private float i = 15.0f;
    private float j = 15.0f;
    private final TextPaint J = new TextPaint(129);
    private final TextPaint K = new TextPaint(this.J);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Rect f621e = new Rect();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f620d = new Rect();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RectF f622f = new RectF();

    /* JADX INFO: renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    class C0026a implements e.a.a.a.x.a.InterfaceC0070a {
        C0026a() {
        }

        @Override // e.a.a.a.x.a.InterfaceC0070a
        public void a(Typeface typeface) {
            a.this.G(typeface);
        }
    }

    static {
        V = Build.VERSION.SDK_INT < 18;
        Paint paint = null;
        W = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            W.setColor(-65281);
        }
    }

    public a(View view) {
        this.a = view;
    }

    private static boolean A(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    private boolean H(Typeface typeface) {
        e.a.a.a.x.a aVar = this.w;
        if (aVar != null) {
            aVar.c();
        }
        if (this.s == typeface) {
            return false;
        }
        this.s = typeface;
        return true;
    }

    private boolean N(Typeface typeface) {
        e.a.a.a.x.a aVar = this.v;
        if (aVar != null) {
            aVar.c();
        }
        if (this.t == typeface) {
            return false;
        }
        this.t = typeface;
        return true;
    }

    private void P(float f2) {
        g(f2);
        boolean z = V && this.F != 1.0f;
        this.A = z;
        if (z) {
            j();
        }
        r.U(this.a);
    }

    private static int a(int i, int i2, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i) * f3) + (Color.alpha(i2) * f2)), (int) ((Color.red(i) * f3) + (Color.red(i2) * f2)), (int) ((Color.green(i) * f3) + (Color.green(i2) * f2)), (int) ((Color.blue(i) * f3) + (Color.blue(i2) * f2)));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0069 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x006b  */
    /* JADX WARN: Code duplicated, block: B:17:0x0073  */
    /* JADX WARN: Code duplicated, block: B:18:0x0079  */
    /* JADX WARN: Code duplicated, block: B:22:0x008d  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:27:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:28:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:32:0x00dc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x00de  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ea  */
    private void b() {
        float fAscent;
        int i;
        float fCenterX;
        float fMeasureText;
        int i2;
        float fAscent2;
        int i3;
        float fCenterX2;
        float f2;
        float f3 = this.G;
        g(this.j);
        CharSequence charSequence = this.y;
        float fMeasureText2 = charSequence != null ? this.J.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int iB = d.f.k.c.b(this.h, this.z ? 1 : 0);
        int i4 = iB & 112;
        if (i4 != 48) {
            if (i4 != 80) {
                this.n = this.f621e.centerY() + (((this.J.descent() - this.J.ascent()) / 2.0f) - this.J.descent());
            } else {
                fAscent = this.f621e.bottom;
            }
            i = iB & 8388615;
            if (i != 1) {
                if (i != 5) {
                    this.p = this.f621e.left;
                } else {
                    fCenterX = this.f621e.right;
                }
                g(this.i);
                CharSequence charSequence2 = this.y;
                fMeasureText = charSequence2 != null ? this.J.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
                int iB2 = d.f.k.c.b(this.f623g, this.z ? 1 : 0);
                i2 = iB2 & 112;
                if (i2 != 48) {
                    if (i2 != 80) {
                        this.m = this.f620d.centerY() + (((this.J.descent() - this.J.ascent()) / 2.0f) - this.J.descent());
                    } else {
                        fAscent2 = this.f620d.bottom;
                    }
                    i3 = iB2 & 8388615;
                    if (i3 != 1) {
                        if (i3 != 5) {
                            f2 = this.f620d.left;
                        } else {
                            fCenterX2 = this.f620d.right;
                        }
                        this.o = f2;
                        h();
                        P(f3);
                    }
                    fCenterX2 = this.f620d.centerX();
                    fMeasureText /= 2.0f;
                    f2 = fCenterX2 - fMeasureText;
                    this.o = f2;
                    h();
                    P(f3);
                }
                fAscent2 = this.f620d.top - this.J.ascent();
                this.m = fAscent2;
                i3 = iB2 & 8388615;
                if (i3 != 1) {
                    if (i3 != 5) {
                        f2 = this.f620d.left;
                    } else {
                        fCenterX2 = this.f620d.right;
                    }
                    this.o = f2;
                    h();
                    P(f3);
                }
                fCenterX2 = this.f620d.centerX();
                fMeasureText /= 2.0f;
                f2 = fCenterX2 - fMeasureText;
                this.o = f2;
                h();
                P(f3);
            }
            fCenterX = this.f621e.centerX();
            fMeasureText2 /= 2.0f;
            this.p = fCenterX - fMeasureText2;
            g(this.i);
            CharSequence charSequence3 = this.y;
            if (charSequence3 != null) {
            }
            int iB3 = d.f.k.c.b(this.f623g, this.z ? 1 : 0);
            i2 = iB3 & 112;
            if (i2 != 48) {
                if (i2 != 80) {
                    this.m = this.f620d.centerY() + (((this.J.descent() - this.J.ascent()) / 2.0f) - this.J.descent());
                } else {
                    fAscent2 = this.f620d.bottom;
                }
                i3 = iB3 & 8388615;
                if (i3 != 1) {
                    if (i3 != 5) {
                        f2 = this.f620d.left;
                    } else {
                        fCenterX2 = this.f620d.right;
                    }
                    this.o = f2;
                    h();
                    P(f3);
                }
                fCenterX2 = this.f620d.centerX();
                fMeasureText /= 2.0f;
                f2 = fCenterX2 - fMeasureText;
                this.o = f2;
                h();
                P(f3);
            }
            fAscent2 = this.f620d.top - this.J.ascent();
            this.m = fAscent2;
            i3 = iB3 & 8388615;
            if (i3 != 1) {
                if (i3 != 5) {
                    f2 = this.f620d.left;
                } else {
                    fCenterX2 = this.f620d.right;
                }
                this.o = f2;
                h();
                P(f3);
            }
            fCenterX2 = this.f620d.centerX();
            fMeasureText /= 2.0f;
            f2 = fCenterX2 - fMeasureText;
            this.o = f2;
            h();
            P(f3);
        }
        fAscent = this.f621e.top - this.J.ascent();
        this.n = fAscent;
        i = iB & 8388615;
        if (i != 1) {
            if (i != 5) {
                this.p = this.f621e.left;
            } else {
                fCenterX = this.f621e.right;
            }
            g(this.i);
            CharSequence charSequence4 = this.y;
            if (charSequence4 != null) {
            }
            int iB4 = d.f.k.c.b(this.f623g, this.z ? 1 : 0);
            i2 = iB4 & 112;
            if (i2 != 48) {
                if (i2 != 80) {
                    this.m = this.f620d.centerY() + (((this.J.descent() - this.J.ascent()) / 2.0f) - this.J.descent());
                } else {
                    fAscent2 = this.f620d.bottom;
                }
                i3 = iB4 & 8388615;
                if (i3 != 1) {
                    if (i3 != 5) {
                        f2 = this.f620d.left;
                    } else {
                        fCenterX2 = this.f620d.right;
                    }
                    this.o = f2;
                    h();
                    P(f3);
                }
                fCenterX2 = this.f620d.centerX();
                fMeasureText /= 2.0f;
                f2 = fCenterX2 - fMeasureText;
                this.o = f2;
                h();
                P(f3);
            }
            fAscent2 = this.f620d.top - this.J.ascent();
            this.m = fAscent2;
            i3 = iB4 & 8388615;
            if (i3 != 1) {
                if (i3 != 5) {
                    f2 = this.f620d.left;
                } else {
                    fCenterX2 = this.f620d.right;
                }
                this.o = f2;
                h();
                P(f3);
            }
            fCenterX2 = this.f620d.centerX();
            fMeasureText /= 2.0f;
            f2 = fCenterX2 - fMeasureText;
            this.o = f2;
            h();
            P(f3);
        }
        fCenterX = this.f621e.centerX();
        fMeasureText2 /= 2.0f;
        this.p = fCenterX - fMeasureText2;
        g(this.i);
        CharSequence charSequence5 = this.y;
        if (charSequence5 != null) {
        }
        int iB5 = d.f.k.c.b(this.f623g, this.z ? 1 : 0);
        i2 = iB5 & 112;
        if (i2 != 48) {
            if (i2 != 80) {
                this.m = this.f620d.centerY() + (((this.J.descent() - this.J.ascent()) / 2.0f) - this.J.descent());
            } else {
                fAscent2 = this.f620d.bottom;
            }
            i3 = iB5 & 8388615;
            if (i3 != 1) {
                if (i3 != 5) {
                    f2 = this.f620d.left;
                } else {
                    fCenterX2 = this.f620d.right;
                }
                this.o = f2;
                h();
                P(f3);
            }
            fCenterX2 = this.f620d.centerX();
            fMeasureText /= 2.0f;
            f2 = fCenterX2 - fMeasureText;
            this.o = f2;
            h();
            P(f3);
        }
        fAscent2 = this.f620d.top - this.J.ascent();
        this.m = fAscent2;
        i3 = iB5 & 8388615;
        if (i3 != 1) {
            if (i3 != 5) {
                f2 = this.f620d.left;
            } else {
                fCenterX2 = this.f620d.right;
            }
            this.o = f2;
            h();
            P(f3);
        }
        fCenterX2 = this.f620d.centerX();
        fMeasureText /= 2.0f;
        f2 = fCenterX2 - fMeasureText;
        this.o = f2;
        h();
        P(f3);
    }

    private void d() {
        f(this.c);
    }

    private boolean e(CharSequence charSequence) {
        return (r.v(this.a) == 1 ? d.f.i.e.f787d : d.f.i.e.c).a(charSequence, 0, charSequence.length());
    }

    private void f(float f2) {
        TextPaint textPaint;
        int iN;
        u(f2);
        this.q = x(this.o, this.p, f2, this.L);
        this.r = x(this.m, this.n, f2, this.L);
        P(x(this.i, this.j, f2, this.M));
        if (this.l != this.k) {
            textPaint = this.J;
            iN = a(p(), n(), f2);
        } else {
            textPaint = this.J;
            iN = n();
        }
        textPaint.setColor(iN);
        this.J.setShadowLayer(x(this.R, this.N, f2, null), x(this.S, this.O, f2, null), x(this.T, this.P, f2, null), a(o(this.U), o(this.Q), f2));
        r.U(this.a);
    }

    private void g(float f2) {
        boolean z;
        float f3;
        boolean z2;
        if (this.x == null) {
            return;
        }
        float fWidth = this.f621e.width();
        float fWidth2 = this.f620d.width();
        if (v(f2, this.j)) {
            f3 = this.j;
            this.F = 1.0f;
            Typeface typeface = this.u;
            Typeface typeface2 = this.s;
            if (typeface != typeface2) {
                this.u = typeface2;
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            float f4 = this.i;
            Typeface typeface3 = this.u;
            Typeface typeface4 = this.t;
            if (typeface3 != typeface4) {
                this.u = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (v(f2, this.i)) {
                this.F = 1.0f;
            } else {
                this.F = f2 / this.i;
            }
            float f5 = this.j / this.i;
            fWidth = fWidth2 * f5 > fWidth ? Math.min(fWidth / f5, fWidth2) : fWidth2;
            f3 = f4;
            z2 = z;
        }
        if (fWidth > 0.0f) {
            z2 = this.G != f3 || this.I || z2;
            this.G = f3;
            this.I = false;
        }
        if (this.y == null || z2) {
            this.J.setTextSize(this.G);
            this.J.setTypeface(this.u);
            this.J.setLinearText(this.F != 1.0f);
            CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.x, this.J, fWidth, TextUtils.TruncateAt.END);
            if (TextUtils.equals(charSequenceEllipsize, this.y)) {
                return;
            }
            this.y = charSequenceEllipsize;
            this.z = e(charSequenceEllipsize);
        }
    }

    private void h() {
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            bitmap.recycle();
            this.B = null;
        }
    }

    private void j() {
        if (this.B != null || this.f620d.isEmpty() || TextUtils.isEmpty(this.y)) {
            return;
        }
        f(0.0f);
        this.D = this.J.ascent();
        this.E = this.J.descent();
        TextPaint textPaint = this.J;
        CharSequence charSequence = this.y;
        int iRound = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
        int iRound2 = Math.round(this.E - this.D);
        if (iRound <= 0 || iRound2 <= 0) {
            return;
        }
        this.B = Bitmap.createBitmap(iRound, iRound2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.B);
        CharSequence charSequence2 = this.y;
        canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, iRound2 - this.J.descent(), this.J);
        if (this.C == null) {
            this.C = new Paint(3);
        }
    }

    private int o(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.H;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    private int p() {
        return o(this.k);
    }

    private void s(TextPaint textPaint) {
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
    }

    private void t(TextPaint textPaint) {
        textPaint.setTextSize(this.i);
        textPaint.setTypeface(this.t);
    }

    private void u(float f2) {
        this.f622f.left = x(this.f620d.left, this.f621e.left, f2, this.L);
        this.f622f.top = x(this.m, this.n, f2, this.L);
        this.f622f.right = x(this.f620d.right, this.f621e.right, f2, this.L);
        this.f622f.bottom = x(this.f620d.bottom, this.f621e.bottom, f2, this.L);
    }

    private static boolean v(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    private static float x(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return e.a.a.a.l.a.a(f2, f3, f4);
    }

    public void B(int i, int i2, int i3, int i4) {
        if (A(this.f621e, i, i2, i3, i4)) {
            return;
        }
        this.f621e.set(i, i2, i3, i4);
        this.I = true;
        y();
    }

    public void C(Rect rect) {
        B(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void D(int i) {
        e.a.a.a.x.d dVar = new e.a.a.a.x.d(this.a.getContext(), i);
        ColorStateList colorStateList = dVar.b;
        if (colorStateList != null) {
            this.l = colorStateList;
        }
        float f2 = dVar.a;
        if (f2 != 0.0f) {
            this.j = f2;
        }
        ColorStateList colorStateList2 = dVar.f934f;
        if (colorStateList2 != null) {
            this.Q = colorStateList2;
        }
        this.O = dVar.f935g;
        this.P = dVar.h;
        this.N = dVar.i;
        e.a.a.a.x.a aVar = this.w;
        if (aVar != null) {
            aVar.c();
        }
        this.w = new e.a.a.a.x.a(new C0026a(), dVar.e());
        dVar.h(this.a.getContext(), this.w);
        z();
    }

    public void E(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            z();
        }
    }

    public void F(int i) {
        if (this.h != i) {
            this.h = i;
            z();
        }
    }

    public void G(Typeface typeface) {
        if (H(typeface)) {
            z();
        }
    }

    public void I(int i, int i2, int i3, int i4) {
        if (A(this.f620d, i, i2, i3, i4)) {
            return;
        }
        this.f620d.set(i, i2, i3, i4);
        this.I = true;
        y();
    }

    public void J(Rect rect) {
        I(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void K(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            z();
        }
    }

    public void L(int i) {
        if (this.f623g != i) {
            this.f623g = i;
            z();
        }
    }

    public void M(float f2) {
        if (this.i != f2) {
            this.i = f2;
            z();
        }
    }

    public void O(float f2) {
        float fA = d.f.f.a.a(f2, 0.0f, 1.0f);
        if (fA != this.c) {
            this.c = fA;
            d();
        }
    }

    public void Q(TimeInterpolator timeInterpolator) {
        this.L = timeInterpolator;
        z();
    }

    public final boolean R(int[] iArr) {
        this.H = iArr;
        if (!w()) {
            return false;
        }
        z();
        return true;
    }

    public void S(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.x, charSequence)) {
            this.x = charSequence;
            this.y = null;
            h();
            z();
        }
    }

    public void T(TimeInterpolator timeInterpolator) {
        this.M = timeInterpolator;
        z();
    }

    public void U(Typeface typeface) {
        boolean zH = H(typeface);
        boolean zN = N(typeface);
        if (zH || zN) {
            z();
        }
    }

    public float c() {
        if (this.x == null) {
            return 0.0f;
        }
        s(this.K);
        TextPaint textPaint = this.K;
        CharSequence charSequence = this.x;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void i(Canvas canvas) {
        float fAscent;
        int iSave = canvas.save();
        if (this.y != null && this.b) {
            float f2 = this.q;
            float f3 = this.r;
            boolean z = this.A && this.B != null;
            if (z) {
                fAscent = this.D * this.F;
            } else {
                fAscent = this.J.ascent() * this.F;
                this.J.descent();
            }
            if (z) {
                f3 += fAscent;
            }
            float f4 = f3;
            float f5 = this.F;
            if (f5 != 1.0f) {
                canvas.scale(f5, f5, f2, f4);
            }
            if (z) {
                canvas.drawBitmap(this.B, f2, f4, this.C);
            } else {
                CharSequence charSequence = this.y;
                canvas.drawText(charSequence, 0, charSequence.length(), f2, f4, this.J);
            }
        }
        canvas.restoreToCount(iSave);
    }

    public void k(RectF rectF) {
        boolean zE = e(this.x);
        Rect rect = this.f621e;
        float fC = !zE ? rect.left : rect.right - c();
        rectF.left = fC;
        Rect rect2 = this.f621e;
        rectF.top = rect2.top;
        rectF.right = !zE ? fC + c() : rect2.right;
        rectF.bottom = this.f621e.top + m();
    }

    public ColorStateList l() {
        return this.l;
    }

    public float m() {
        s(this.K);
        return -this.K.ascent();
    }

    public int n() {
        return o(this.l);
    }

    public float q() {
        t(this.K);
        return -this.K.ascent();
    }

    public float r() {
        return this.c;
    }

    public final boolean w() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.l;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.k) != null && colorStateList.isStateful());
    }

    void y() {
        this.b = this.f621e.width() > 0 && this.f621e.height() > 0 && this.f620d.width() > 0 && this.f620d.height() > 0;
    }

    public void z() {
        if (this.a.getHeight() <= 0 || this.a.getWidth() <= 0) {
            return;
        }
        b();
        d();
    }
}
