package androidx.core.content.c;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
final class d {

    static final class a {
        final int[] a;
        final float[] b;

        a(int i, int i2) {
            this.a = new int[]{i, i2};
            this.b = new float[]{0.0f, 1.0f};
        }

        a(int i, int i2, int i3) {
            this.a = new int[]{i, i2, i3};
            this.b = new float[]{0.0f, 0.5f, 1.0f};
        }

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.a = new int[size];
            this.b = new float[size];
            for (int i = 0; i < size; i++) {
                this.a[i] = list.get(i).intValue();
                this.b[i] = list2.get(i).floatValue();
            }
        }
    }

    private static a a(a aVar, int i, int i2, boolean z, int i3) {
        if (aVar != null) {
            return aVar;
        }
        return z ? new a(i, i3, i2) : new a(i, i2);
    }

    static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayS = g.s(resources, theme, attributeSet, d.f.c.GradientColor);
        float fJ = g.j(typedArrayS, xmlPullParser, "startX", d.f.c.GradientColor_android_startX, 0.0f);
        float fJ2 = g.j(typedArrayS, xmlPullParser, "startY", d.f.c.GradientColor_android_startY, 0.0f);
        float fJ3 = g.j(typedArrayS, xmlPullParser, "endX", d.f.c.GradientColor_android_endX, 0.0f);
        float fJ4 = g.j(typedArrayS, xmlPullParser, "endY", d.f.c.GradientColor_android_endY, 0.0f);
        float fJ5 = g.j(typedArrayS, xmlPullParser, "centerX", d.f.c.GradientColor_android_centerX, 0.0f);
        float fJ6 = g.j(typedArrayS, xmlPullParser, "centerY", d.f.c.GradientColor_android_centerY, 0.0f);
        int iK = g.k(typedArrayS, xmlPullParser, "type", d.f.c.GradientColor_android_type, 0);
        int iF = g.f(typedArrayS, xmlPullParser, "startColor", d.f.c.GradientColor_android_startColor, 0);
        boolean zR = g.r(xmlPullParser, "centerColor");
        int iF2 = g.f(typedArrayS, xmlPullParser, "centerColor", d.f.c.GradientColor_android_centerColor, 0);
        int iF3 = g.f(typedArrayS, xmlPullParser, "endColor", d.f.c.GradientColor_android_endColor, 0);
        int iK2 = g.k(typedArrayS, xmlPullParser, "tileMode", d.f.c.GradientColor_android_tileMode, 0);
        float fJ7 = g.j(typedArrayS, xmlPullParser, "gradientRadius", d.f.c.GradientColor_android_gradientRadius, 0.0f);
        typedArrayS.recycle();
        a aVarA = a(c(resources, xmlPullParser, attributeSet, theme), iF, iF3, zR, iF2);
        if (iK != 1) {
            return iK != 2 ? new LinearGradient(fJ, fJ2, fJ3, fJ4, aVarA.a, aVarA.b, d(iK2)) : new SweepGradient(fJ5, fJ6, aVarA.a, aVarA.b);
        }
        if (fJ7 > 0.0f) {
            return new RadialGradient(fJ5, fJ6, fJ7, aVarA.a, aVarA.b, d(iK2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    private static a c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayS = g.s(resources, theme, attributeSet, d.f.c.GradientColorItem);
                boolean zHasValue = typedArrayS.hasValue(d.f.c.GradientColorItem_android_color);
                boolean zHasValue2 = typedArrayS.hasValue(d.f.c.GradientColorItem_android_offset);
                if (!zHasValue || !zHasValue2) {
                    throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                int color = typedArrayS.getColor(d.f.c.GradientColorItem_android_color, 0);
                float f2 = typedArrayS.getFloat(d.f.c.GradientColorItem_android_offset, 0.0f);
                typedArrayS.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f2));
            }
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }

    private static Shader.TileMode d(int i) {
        if (i != 1) {
            return i != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }
}
