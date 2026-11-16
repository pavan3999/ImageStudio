package androidx.core.content.c;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return d(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    public static ColorStateList c(Resources resources, int i, Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i), theme);
        } catch (Exception e2) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e2);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006e  */
    private static ColorStateList d(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int i;
        int attributeCount;
        int i2;
        int attributeNameResource;
        int i3 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArrA = new int[20];
        int i4 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i3 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayF = f(resources, theme, attributeSet, d.f.c.ColorStateListItem);
                int color = typedArrayF.getColor(d.f.c.ColorStateListItem_android_color, -65281);
                float f2 = 1.0f;
                if (typedArrayF.hasValue(d.f.c.ColorStateListItem_android_alpha)) {
                    i = d.f.c.ColorStateListItem_android_alpha;
                } else {
                    if (typedArrayF.hasValue(d.f.c.ColorStateListItem_alpha)) {
                        i = d.f.c.ColorStateListItem_alpha;
                    }
                    typedArrayF.recycle();
                    attributeCount = attributeSet.getAttributeCount();
                    int[] iArr2 = new int[attributeCount];
                    int i5 = 0;
                    for (i2 = 0; i2 < attributeCount; i2++) {
                        attributeNameResource = attributeSet.getAttributeNameResource(i2);
                        if (attributeNameResource == 16843173 && attributeNameResource != 16843551 && attributeNameResource != d.f.a.alpha) {
                            int i6 = i5 + 1;
                            if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr2[i5] = attributeNameResource;
                            i5 = i6;
                        }
                    }
                    int[] iArrTrimStateSet = StateSet.trimStateSet(iArr2, i5);
                    iArrA = e.a(iArrA, i4, e(color, f2));
                    iArr = (int[][]) e.b(iArr, i4, iArrTrimStateSet);
                    i4++;
                }
                f2 = typedArrayF.getFloat(i, 1.0f);
                typedArrayF.recycle();
                attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i7 = 0;
                while (i2 < attributeCount) {
                    attributeNameResource = attributeSet.getAttributeNameResource(i2);
                    if (attributeNameResource == 16843173) {
                    }
                }
                int[] iArrTrimStateSet2 = StateSet.trimStateSet(iArr3, i7);
                iArrA = e.a(iArrA, i4, e(color, f2));
                iArr = (int[][]) e.b(iArr, i4, iArrTrimStateSet2);
                i4++;
            }
            i3 = 1;
        }
        int[] iArr4 = new int[i4];
        int[][] iArr5 = new int[i4][];
        System.arraycopy(iArrA, 0, iArr4, 0, i4);
        System.arraycopy(iArr, 0, iArr5, 0, i4);
        return new ColorStateList(iArr5, iArr4);
    }

    private static int e(int i, float f2) {
        return (i & 16777215) | (Math.round(Color.alpha(i) * f2) << 24);
    }

    private static TypedArray f(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
