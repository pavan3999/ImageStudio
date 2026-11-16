package e.a.a.a.a0;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class g extends Drawable implements androidx.core.graphics.drawable.b, n {
    private static final Paint w = new Paint(1);
    private c b;
    private final m.g[] c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m.g[] f886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Matrix f888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Path f889g;
    private final Path h;
    private final RectF i;
    private final RectF j;
    private final Region k;
    private final Region l;
    private k m;
    private final Paint n;
    private final Paint o;
    private final e.a.a.a.z.a p;
    private final l.a q;
    private final l r;
    private PorterDuffColorFilter s;
    private PorterDuffColorFilter t;
    private Rect u;
    private final RectF v;

    class a implements l.a {
        a() {
        }

        @Override // e.a.a.a.a0.l.a
        public void a(m mVar, Matrix matrix, int i) {
            g.this.c[i] = mVar.e(matrix);
        }

        @Override // e.a.a.a.a0.l.a
        public void b(m mVar, Matrix matrix, int i) {
            g.this.f886d[i] = mVar.e(matrix);
        }
    }

    class b implements k.c {
        final /* synthetic */ float a;

        b(g gVar, float f2) {
            this.a = f2;
        }

        @Override // e.a.a.a.a0.k.c
        public e.a.a.a.a0.c a(e.a.a.a.a0.c cVar) {
            return cVar instanceof i ? cVar : new e.a.a.a.a0.b(this.a, cVar);
        }
    }

    static final class c extends Drawable.ConstantState {
        public k a;
        public e.a.a.a.t.a b;
        public ColorFilter c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ColorStateList f890d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ColorStateList f891e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ColorStateList f892f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ColorStateList f893g;
        public PorterDuff.Mode h;
        public Rect i;
        public float j;
        public float k;
        public float l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;

        public c(c cVar) {
            this.f890d = null;
            this.f891e = null;
            this.f892f = null;
            this.f893g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = cVar.a;
            this.b = cVar.b;
            this.l = cVar.l;
            this.c = cVar.c;
            this.f890d = cVar.f890d;
            this.f891e = cVar.f891e;
            this.h = cVar.h;
            this.f893g = cVar.f893g;
            this.m = cVar.m;
            this.j = cVar.j;
            this.s = cVar.s;
            this.q = cVar.q;
            this.u = cVar.u;
            this.k = cVar.k;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
            this.r = cVar.r;
            this.t = cVar.t;
            this.f892f = cVar.f892f;
            this.v = cVar.v;
            if (cVar.i != null) {
                this.i = new Rect(cVar.i);
            }
        }

        public c(k kVar, e.a.a.a.t.a aVar) {
            this.f890d = null;
            this.f891e = null;
            this.f892f = null;
            this.f893g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = kVar;
            this.b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this, null);
            gVar.f887e = true;
            return gVar;
        }
    }

    public g() {
        this(new k());
    }

    public g(Context context, AttributeSet attributeSet, int i, int i2) {
        this(k.e(context, attributeSet, i, i2).m());
    }

    private g(c cVar) {
        this.c = new m.g[4];
        this.f886d = new m.g[4];
        this.f888f = new Matrix();
        this.f889g = new Path();
        this.h = new Path();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new Region();
        this.l = new Region();
        this.n = new Paint(1);
        this.o = new Paint(1);
        this.p = new e.a.a.a.z.a();
        this.r = new l();
        this.v = new RectF();
        this.b = cVar;
        this.o.setStyle(Paint.Style.STROKE);
        this.n.setStyle(Paint.Style.FILL);
        w.setColor(-1);
        w.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        d0();
        c0(getState());
        this.q = new a();
    }

    /* synthetic */ g(c cVar, a aVar) {
        this(cVar);
    }

    public g(k kVar) {
        this(new c(kVar, null));
    }

    private float C() {
        if (K()) {
            return this.o.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean I() {
        c cVar = this.b;
        int i = cVar.q;
        return i != 1 && cVar.r > 0 && (i == 2 || R());
    }

    private boolean J() {
        Paint.Style style = this.b.v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean K() {
        Paint.Style style = this.b.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.o.getStrokeWidth() > 0.0f;
    }

    private void M() {
        super.invalidateSelf();
    }

    private static int P(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    private void Q(Canvas canvas) {
        int iY = y();
        int iZ = z();
        if (Build.VERSION.SDK_INT < 21) {
            Rect clipBounds = canvas.getClipBounds();
            int i = this.b.r;
            clipBounds.inset(-i, -i);
            clipBounds.offset(iY, iZ);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate(iY, iZ);
    }

    private boolean R() {
        return Build.VERSION.SDK_INT < 21 || !(O() || this.f889g.isConvex());
    }

    private boolean c0(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.b.f890d == null || color2 == (colorForState2 = this.b.f890d.getColorForState(iArr, (color2 = this.n.getColor())))) {
            z = false;
        } else {
            this.n.setColor(colorForState2);
            z = true;
        }
        if (this.b.f891e == null || color == (colorForState = this.b.f891e.getColorForState(iArr, (color = this.o.getColor())))) {
            return z;
        }
        this.o.setColor(colorForState);
        return true;
    }

    private boolean d0() {
        PorterDuffColorFilter porterDuffColorFilter = this.s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.t;
        c cVar = this.b;
        this.s = j(cVar.f893g, cVar.h, this.n, true);
        c cVar2 = this.b;
        this.t = j(cVar2.f892f, cVar2.h, this.o, false);
        c cVar3 = this.b;
        if (cVar3.u) {
            this.p.d(cVar3.f893g.getColorForState(getState(), 0));
        }
        return (d.f.j.c.a(porterDuffColorFilter, this.s) && d.f.j.c.a(porterDuffColorFilter2, this.t)) ? false : true;
    }

    private PorterDuffColorFilter e(Paint paint, boolean z) {
        int color;
        int iK;
        if (!z || (iK = k((color = paint.getColor()))) == color) {
            return null;
        }
        return new PorterDuffColorFilter(iK, PorterDuff.Mode.SRC_IN);
    }

    private void e0() {
        float fH = H();
        this.b.r = (int) Math.ceil(0.75f * fH);
        this.b.s = (int) Math.ceil(fH * 0.25f);
        d0();
        M();
    }

    private void f(RectF rectF, Path path) {
        g(rectF, path);
        if (this.b.j != 1.0f) {
            this.f888f.reset();
            Matrix matrix = this.f888f;
            float f2 = this.b.j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f888f);
        }
        path.computeBounds(this.v, true);
    }

    private void h() {
        k kVarX = B().x(new b(this, -C()));
        this.m = kVarX;
        this.r.d(kVarX, this.b.k, u(), this.h);
    }

    private PorterDuffColorFilter i(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = k(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        return (colorStateList == null || mode == null) ? e(paint, z) : i(colorStateList, mode, z);
    }

    private int k(int i) {
        float fH = H() + x();
        e.a.a.a.t.a aVar = this.b.b;
        return aVar != null ? aVar.c(i, fH) : i;
    }

    public static g l(Context context, float f2) {
        int iB = e.a.a.a.q.a.b(context, e.a.a.a.b.colorSurface, g.class.getSimpleName());
        g gVar = new g();
        gVar.L(context);
        gVar.T(ColorStateList.valueOf(iB));
        gVar.S(f2);
        return gVar;
    }

    private void m(Canvas canvas) {
        if (this.b.s != 0) {
            canvas.drawPath(this.f889g, this.p.c());
        }
        for (int i = 0; i < 4; i++) {
            this.c[i].b(this.p, this.b.r, canvas);
            this.f886d[i].b(this.p, this.b.r, canvas);
        }
        int iY = y();
        int iZ = z();
        canvas.translate(-iY, -iZ);
        canvas.drawPath(this.f889g, w);
        canvas.translate(iY, iZ);
    }

    private void n(Canvas canvas) {
        p(canvas, this.n, this.f889g, this.b.a, t());
    }

    private void p(Canvas canvas, Paint paint, Path path, k kVar, RectF rectF) {
        if (!kVar.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = kVar.t().a(rectF);
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    private void q(Canvas canvas) {
        p(canvas, this.o, this.h, this.m, u());
    }

    private RectF u() {
        RectF rectFT = t();
        float fC = C();
        this.j.set(rectFT.left + fC, rectFT.top + fC, rectFT.right - fC, rectFT.bottom - fC);
        return this.j;
    }

    public int A() {
        return this.b.r;
    }

    public k B() {
        return this.b.a;
    }

    public ColorStateList D() {
        return this.b.f893g;
    }

    public float E() {
        return this.b.a.r().a(t());
    }

    public float F() {
        return this.b.a.t().a(t());
    }

    public float G() {
        return this.b.p;
    }

    public float H() {
        return v() + G();
    }

    public void L(Context context) {
        this.b.b = new e.a.a.a.t.a(context);
        e0();
    }

    public boolean N() {
        e.a.a.a.t.a aVar = this.b.b;
        return aVar != null && aVar.d();
    }

    public boolean O() {
        return this.b.a.u(t());
    }

    public void S(float f2) {
        c cVar = this.b;
        if (cVar.o != f2) {
            cVar.o = f2;
            e0();
        }
    }

    public void T(ColorStateList colorStateList) {
        c cVar = this.b;
        if (cVar.f890d != colorStateList) {
            cVar.f890d = colorStateList;
            onStateChange(getState());
        }
    }

    public void U(float f2) {
        c cVar = this.b;
        if (cVar.k != f2) {
            cVar.k = f2;
            this.f887e = true;
            invalidateSelf();
        }
    }

    public void V(int i, int i2, int i3, int i4) {
        c cVar = this.b;
        if (cVar.i == null) {
            cVar.i = new Rect();
        }
        this.b.i.set(i, i2, i3, i4);
        this.u = this.b.i;
        invalidateSelf();
    }

    public void W(float f2) {
        c cVar = this.b;
        if (cVar.n != f2) {
            cVar.n = f2;
            e0();
        }
    }

    public void X(int i) {
        c cVar = this.b;
        if (cVar.t != i) {
            cVar.t = i;
            M();
        }
    }

    public void Y(float f2, int i) {
        b0(f2);
        a0(ColorStateList.valueOf(i));
    }

    public void Z(float f2, ColorStateList colorStateList) {
        b0(f2);
        a0(colorStateList);
    }

    public void a0(ColorStateList colorStateList) {
        c cVar = this.b;
        if (cVar.f891e != colorStateList) {
            cVar.f891e = colorStateList;
            onStateChange(getState());
        }
    }

    public void b0(float f2) {
        this.b.l = f2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.n.setColorFilter(this.s);
        int alpha = this.n.getAlpha();
        this.n.setAlpha(P(alpha, this.b.m));
        this.o.setColorFilter(this.t);
        this.o.setStrokeWidth(this.b.l);
        int alpha2 = this.o.getAlpha();
        this.o.setAlpha(P(alpha2, this.b.m));
        if (this.f887e) {
            h();
            f(t(), this.f889g);
            this.f887e = false;
        }
        if (I()) {
            canvas.save();
            Q(canvas);
            int iWidth = (int) (this.v.width() - getBounds().width());
            int iHeight = (int) (this.v.height() - getBounds().height());
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.v.width()) + (this.b.r * 2) + iWidth, ((int) this.v.height()) + (this.b.r * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f2 = (getBounds().left - this.b.r) - iWidth;
            float f3 = (getBounds().top - this.b.r) - iHeight;
            canvas2.translate(-f2, -f3);
            m(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f2, f3, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
        if (J()) {
            n(canvas);
        }
        if (K()) {
            q(canvas);
        }
        this.n.setAlpha(alpha);
        this.o.setAlpha(alpha2);
    }

    protected final void g(RectF rectF, Path path) {
        l lVar = this.r;
        c cVar = this.b;
        lVar.e(cVar.a, cVar.k, rectF, this.q, path);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.b.q == 2) {
            return;
        }
        if (O()) {
            outline.setRoundRect(getBounds(), E());
        } else {
            f(t(), this.f889g);
            if (this.f889g.isConvex()) {
                outline.setConvexPath(this.f889g);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.u;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.k.set(getBounds());
        f(t(), this.f889g);
        this.l.setPath(this.f889g, this.k);
        this.k.op(this.l, Region.Op.DIFFERENCE);
        return this.k;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f887e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.b.f893g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.b.f892f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.b.f891e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.b.f890d) != null && colorStateList4.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.b = new c(this.b);
        return this;
    }

    protected void o(Canvas canvas, Paint paint, Path path, RectF rectF) {
        p(canvas, paint, path, this.b.a, rectF);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f887e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.f.b
    protected boolean onStateChange(int[] iArr) {
        boolean z = c0(iArr) || d0();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public float r() {
        return this.b.a.j().a(t());
    }

    public float s() {
        return this.b.a.l().a(t());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        c cVar = this.b;
        if (cVar.m != i) {
            cVar.m = i;
            M();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.c = colorFilter;
        M();
    }

    @Override // e.a.a.a.a0.n
    public void setShapeAppearanceModel(k kVar) {
        this.b.a = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.b.f893g = colorStateList;
        d0();
        M();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.b;
        if (cVar.h != mode) {
            cVar.h = mode;
            d0();
            M();
        }
    }

    protected RectF t() {
        Rect bounds = getBounds();
        this.i.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        return this.i;
    }

    public float v() {
        return this.b.o;
    }

    public ColorStateList w() {
        return this.b.f890d;
    }

    public float x() {
        return this.b.n;
    }

    public int y() {
        c cVar = this.b;
        double d2 = cVar.s;
        double dSin = Math.sin(Math.toRadians(cVar.t));
        Double.isNaN(d2);
        return (int) (d2 * dSin);
    }

    public int z() {
        c cVar = this.b;
        double d2 = cVar.s;
        double dCos = Math.cos(Math.toRadians(cVar.t));
        Double.isNaN(d2);
        return (int) (d2 * dCos);
    }
}
