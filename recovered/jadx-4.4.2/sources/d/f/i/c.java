package d.f.i;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: classes.dex */
public class c implements Spannable {
    private final Spannable b;
    private final a c;

    public static final class a {
        private final TextPaint a;
        private final TextDirectionHeuristic b;
        private final int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f784d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final PrecomputedText.Params f785e = null;

        /* JADX INFO: renamed from: d.f.i.c$a$a, reason: collision with other inner class name */
        public static class C0049a {
            private final TextPaint a;
            private TextDirectionHeuristic b;
            private int c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f786d;

            public C0049a(TextPaint textPaint) {
                this.a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.c = 1;
                    this.f786d = 1;
                } else {
                    this.f786d = 0;
                    this.c = 0;
                }
                this.b = Build.VERSION.SDK_INT >= 18 ? TextDirectionHeuristics.FIRSTSTRONG_LTR : null;
            }

            public a a() {
                return new a(this.a, this.b, this.c, this.f786d);
            }

            public C0049a b(int i) {
                this.c = i;
                return this;
            }

            public C0049a c(int i) {
                this.f786d = i;
                return this;
            }

            public C0049a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.b = textDirectionHeuristic;
                return this;
            }
        }

        public a(PrecomputedText.Params params) {
            this.a = params.getTextPaint();
            this.b = params.getTextDirection();
            this.c = params.getBreakStrategy();
            this.f784d = params.getHyphenationFrequency();
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            this.a = textPaint;
            this.b = textDirectionHeuristic;
            this.c = i;
            this.f784d = i2;
        }

        public boolean a(a aVar) {
            PrecomputedText.Params params = this.f785e;
            if (params != null) {
                return params.equals(aVar.f785e);
            }
            if ((Build.VERSION.SDK_INT >= 23 && (this.c != aVar.b() || this.f784d != aVar.c())) || this.a.getTextSize() != aVar.e().getTextSize() || this.a.getTextScaleX() != aVar.e().getTextScaleX() || this.a.getTextSkewX() != aVar.e().getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()))) || this.a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                if (!this.a.getTextLocales().equals(aVar.e().getTextLocales())) {
                    return false;
                }
            } else if (i >= 17 && !this.a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            if (this.a.getTypeface() == null) {
                return aVar.e().getTypeface() == null;
            }
            return this.a.getTypeface().equals(aVar.e().getTypeface());
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.f784d;
        }

        public TextDirectionHeuristic d() {
            return this.b;
        }

        public TextPaint e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (a(aVar)) {
                return Build.VERSION.SDK_INT < 18 || this.b == aVar.d();
            }
            return false;
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return d.f.j.c.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocales(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.f784d));
            }
            if (i >= 21) {
                return d.f.j.c.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.f784d));
            }
            if (i < 18 && i < 17) {
                return d.f.j.c.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTypeface(), this.b, Integer.valueOf(this.c), Integer.valueOf(this.f784d));
            }
            return d.f.j.c.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), this.b, Integer.valueOf(this.c), Integer.valueOf(this.f784d));
        }

        /* JADX WARN: Code duplicated, block: B:14:0x00e3  */
        /* JADX WARN: Instruction removed from duplicated block: B:14:0x00e3, please report this as an issue */
        public String toString() {
            StringBuilder sb;
            Object textLocale;
            StringBuilder sb2 = new StringBuilder("{");
            sb2.append("textSize=" + this.a.getTextSize());
            sb2.append(", textScaleX=" + this.a.getTextScaleX());
            sb2.append(", textSkewX=" + this.a.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb2.append(", letterSpacing=" + this.a.getLetterSpacing());
                sb2.append(", elegantTextHeight=" + this.a.isElegantTextHeight());
            }
            int i = Build.VERSION.SDK_INT;
            if (i < 24) {
                if (i >= 17) {
                    sb = new StringBuilder();
                    sb.append(", textLocale=");
                    textLocale = this.a.getTextLocale();
                }
                sb2.append(", typeface=" + this.a.getTypeface());
                if (Build.VERSION.SDK_INT >= 26) {
                    sb2.append(", variationSettings=" + this.a.getFontVariationSettings());
                }
                sb2.append(", textDir=" + this.b);
                sb2.append(", breakStrategy=" + this.c);
                sb2.append(", hyphenationFrequency=" + this.f784d);
                sb2.append("}");
                return sb2.toString();
            }
            sb = new StringBuilder();
            sb.append(", textLocale=");
            textLocale = this.a.getTextLocales();
            sb.append(textLocale);
            sb2.append(sb.toString());
            sb2.append(", typeface=" + this.a.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb2.append(", variationSettings=" + this.a.getFontVariationSettings());
            }
            sb2.append(", textDir=" + this.b);
            sb2.append(", breakStrategy=" + this.c);
            sb2.append(", hyphenationFrequency=" + this.f784d);
            sb2.append("}");
            return sb2.toString();
        }
    }

    public a a() {
        return this.c;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.b.charAt(i);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return (T[]) this.b.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.b.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        this.b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        this.b.setSpan(obj, i, i2, i3);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.b.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.b.toString();
    }
}
