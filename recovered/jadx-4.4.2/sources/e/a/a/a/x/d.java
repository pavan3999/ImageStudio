package e.a.a.a.x;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import e.a.a.a.k;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public final float a;
    public final ColorStateList b;
    public final int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ColorStateList f934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f935g;
    public final float h;
    public final float i;
    private final int j;
    private boolean k = false;
    private Typeface l;

    class a extends androidx.core.content.c.f.a {
        final /* synthetic */ f a;

        a(f fVar) {
            this.a = fVar;
        }

        @Override // androidx.core.content.c.f.a
        public void c(int i) {
            d.this.k = true;
            this.a.a(i);
        }

        @Override // androidx.core.content.c.f.a
        public void d(Typeface typeface) {
            d dVar = d.this;
            dVar.l = Typeface.create(typeface, dVar.c);
            d.this.k = true;
            this.a.b(d.this.l, false);
        }
    }

    class b extends f {
        final /* synthetic */ TextPaint a;
        final /* synthetic */ f b;

        b(TextPaint textPaint, f fVar) {
            this.a = textPaint;
            this.b = fVar;
        }

        @Override // e.a.a.a.x.f
        public void a(int i) {
            this.b.a(i);
        }

        @Override // e.a.a.a.x.f
        public void b(Typeface typeface, boolean z) {
            d.this.k(this.a, typeface);
            this.b.b(typeface, z);
        }
    }

    public d(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, k.TextAppearance);
        this.a = typedArrayObtainStyledAttributes.getDimension(k.TextAppearance_android_textSize, 0.0f);
        this.b = c.a(context, typedArrayObtainStyledAttributes, k.TextAppearance_android_textColor);
        c.a(context, typedArrayObtainStyledAttributes, k.TextAppearance_android_textColorHint);
        c.a(context, typedArrayObtainStyledAttributes, k.TextAppearance_android_textColorLink);
        this.c = typedArrayObtainStyledAttributes.getInt(k.TextAppearance_android_textStyle, 0);
        this.f932d = typedArrayObtainStyledAttributes.getInt(k.TextAppearance_android_typeface, 1);
        int iE = c.e(typedArrayObtainStyledAttributes, k.TextAppearance_fontFamily, k.TextAppearance_android_fontFamily);
        this.j = typedArrayObtainStyledAttributes.getResourceId(iE, 0);
        this.f933e = typedArrayObtainStyledAttributes.getString(iE);
        typedArrayObtainStyledAttributes.getBoolean(k.TextAppearance_textAllCaps, false);
        this.f934f = c.a(context, typedArrayObtainStyledAttributes, k.TextAppearance_android_shadowColor);
        this.f935g = typedArrayObtainStyledAttributes.getFloat(k.TextAppearance_android_shadowDx, 0.0f);
        this.h = typedArrayObtainStyledAttributes.getFloat(k.TextAppearance_android_shadowDy, 0.0f);
        this.i = typedArrayObtainStyledAttributes.getFloat(k.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void d() {
        Typeface typeface;
        String str;
        if (this.l == null && (str = this.f933e) != null) {
            this.l = Typeface.create(str, this.c);
        }
        if (this.l == null) {
            int i = this.f932d;
            if (i == 1) {
                typeface = Typeface.SANS_SERIF;
            } else if (i != 2) {
                typeface = i != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE;
            } else {
                typeface = Typeface.SERIF;
            }
            this.l = typeface;
            this.l = Typeface.create(this.l, this.c);
        }
    }

    public Typeface e() {
        d();
        return this.l;
    }

    public Typeface f(Context context) {
        if (this.k) {
            return this.l;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceB = androidx.core.content.c.f.b(context, this.j);
                this.l = typefaceB;
                if (typefaceB != null) {
                    this.l = Typeface.create(typefaceB, this.c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e2) {
                Log.d("TextAppearance", "Error loading font " + this.f933e, e2);
            }
        }
        d();
        this.k = true;
        return this.l;
    }

    public void g(Context context, TextPaint textPaint, f fVar) {
        k(textPaint, e());
        h(context, new b(textPaint, fVar));
    }

    public void h(Context context, f fVar) {
        if (e.a()) {
            f(context);
        } else {
            d();
        }
        if (this.j == 0) {
            this.k = true;
        }
        if (this.k) {
            fVar.b(this.l, true);
            return;
        }
        try {
            androidx.core.content.c.f.d(context, this.j, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.k = true;
            fVar.a(1);
        } catch (Exception e2) {
            Log.d("TextAppearance", "Error loading font " + this.f933e, e2);
            this.k = true;
            fVar.a(-3);
        }
    }

    public void i(Context context, TextPaint textPaint, f fVar) {
        j(context, textPaint, fVar);
        ColorStateList colorStateList = this.b;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f2 = this.i;
        float f3 = this.f935g;
        float f4 = this.h;
        ColorStateList colorStateList2 = this.f934f;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void j(Context context, TextPaint textPaint, f fVar) {
        if (e.a()) {
            k(textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void k(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int style = (typeface.getStyle() ^ (-1)) & this.c;
        textPaint.setFakeBoldText((style & 1) != 0);
        textPaint.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.a);
    }
}
