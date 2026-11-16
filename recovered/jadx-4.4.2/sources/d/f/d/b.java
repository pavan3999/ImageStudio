package d.f.d;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    private static class a {
        int a;
        boolean b;

        a() {
        }
    }

    /* JADX INFO: renamed from: d.f.d.b$b, reason: collision with other inner class name */
    public static class C0044b {
        public char a;
        public float[] b;

        C0044b(char c, float[] fArr) {
            this.a = c;
            this.b = fArr;
        }

        C0044b(C0044b c0044b) {
            this.a = c0044b.a;
            float[] fArr = c0044b.b;
            this.b = b.c(fArr, 0, fArr.length);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void a(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            char c3 = c2;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            float f13 = fArr[3];
            float f14 = fArr[4];
            float f15 = fArr[5];
            switch (c3) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f14, f15);
                    f10 = f14;
                    f12 = f10;
                    f11 = f15;
                    f13 = f11;
                    i = 2;
                    break;
            }
            float f16 = f10;
            float f17 = f11;
            float f18 = f14;
            float f19 = f15;
            int i3 = 0;
            char c4 = c;
            while (i3 < fArr2.length) {
                if (c3 != 'A') {
                    if (c3 == 'C') {
                        i2 = i3;
                        int i4 = i2 + 2;
                        int i5 = i2 + 3;
                        int i6 = i2 + 4;
                        int i7 = i2 + 5;
                        path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i4], fArr2[i5], fArr2[i6], fArr2[i7]);
                        f16 = fArr2[i6];
                        float f20 = fArr2[i7];
                        float f21 = fArr2[i4];
                        float f22 = fArr2[i5];
                        f17 = f20;
                        f13 = f22;
                        f12 = f21;
                    } else if (c3 == 'H') {
                        i2 = i3;
                        int i8 = i2 + 0;
                        path.lineTo(fArr2[i8], f17);
                        f16 = fArr2[i8];
                    } else if (c3 == 'Q') {
                        i2 = i3;
                        int i9 = i2 + 0;
                        int i10 = i2 + 1;
                        int i11 = i2 + 2;
                        int i12 = i2 + 3;
                        path.quadTo(fArr2[i9], fArr2[i10], fArr2[i11], fArr2[i12]);
                        float f23 = fArr2[i9];
                        float f24 = fArr2[i10];
                        f16 = fArr2[i11];
                        f17 = fArr2[i12];
                        f12 = f23;
                        f13 = f24;
                    } else if (c3 == 'V') {
                        i2 = i3;
                        int i13 = i2 + 0;
                        path.lineTo(f16, fArr2[i13]);
                        f17 = fArr2[i13];
                    } else if (c3 != 'a') {
                        if (c3 != 'c') {
                            if (c3 == 'h') {
                                int i14 = i3 + 0;
                                path.rLineTo(fArr2[i14], 0.0f);
                                f16 += fArr2[i14];
                            } else if (c3 != 'q') {
                                if (c3 == 'v') {
                                    int i15 = i3 + 0;
                                    path.rLineTo(0.0f, fArr2[i15]);
                                    f5 = fArr2[i15];
                                } else if (c3 == 'L') {
                                    int i16 = i3 + 0;
                                    int i17 = i3 + 1;
                                    path.lineTo(fArr2[i16], fArr2[i17]);
                                    f16 = fArr2[i16];
                                    f17 = fArr2[i17];
                                } else if (c3 == 'M') {
                                    int i18 = i3 + 0;
                                    f16 = fArr2[i18];
                                    int i19 = i3 + 1;
                                    f17 = fArr2[i19];
                                    if (i3 > 0) {
                                        path.lineTo(fArr2[i18], fArr2[i19]);
                                    } else {
                                        path.moveTo(fArr2[i18], fArr2[i19]);
                                        i2 = i3;
                                        f19 = f17;
                                        f18 = f16;
                                    }
                                } else if (c3 == 'S') {
                                    if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                        f16 = (f16 * 2.0f) - f12;
                                        f17 = (f17 * 2.0f) - f13;
                                    }
                                    float f25 = f17;
                                    int i20 = i3 + 0;
                                    int i21 = i3 + 1;
                                    int i22 = i3 + 2;
                                    int i23 = i3 + 3;
                                    path.cubicTo(f16, f25, fArr2[i20], fArr2[i21], fArr2[i22], fArr2[i23]);
                                    f2 = fArr2[i20];
                                    f3 = fArr2[i21];
                                    f16 = fArr2[i22];
                                    f17 = fArr2[i23];
                                    f12 = f2;
                                    f13 = f3;
                                } else if (c3 == 'T') {
                                    if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                        f16 = (f16 * 2.0f) - f12;
                                        f17 = (f17 * 2.0f) - f13;
                                    }
                                    int i24 = i3 + 0;
                                    int i25 = i3 + 1;
                                    path.quadTo(f16, f17, fArr2[i24], fArr2[i25]);
                                    float f26 = fArr2[i24];
                                    float f27 = fArr2[i25];
                                    i2 = i3;
                                    f13 = f17;
                                    f12 = f16;
                                    f16 = f26;
                                    f17 = f27;
                                } else if (c3 == 'l') {
                                    int i26 = i3 + 0;
                                    int i27 = i3 + 1;
                                    path.rLineTo(fArr2[i26], fArr2[i27]);
                                    f16 += fArr2[i26];
                                    f5 = fArr2[i27];
                                } else if (c3 == 'm') {
                                    int i28 = i3 + 0;
                                    f16 += fArr2[i28];
                                    int i29 = i3 + 1;
                                    f17 += fArr2[i29];
                                    if (i3 > 0) {
                                        path.rLineTo(fArr2[i28], fArr2[i29]);
                                    } else {
                                        path.rMoveTo(fArr2[i28], fArr2[i29]);
                                        i2 = i3;
                                        f19 = f17;
                                        f18 = f16;
                                    }
                                } else if (c3 == 's') {
                                    if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                        float f28 = f16 - f12;
                                        f6 = f17 - f13;
                                        f7 = f28;
                                    } else {
                                        f7 = 0.0f;
                                        f6 = 0.0f;
                                    }
                                    int i30 = i3 + 0;
                                    int i31 = i3 + 1;
                                    int i32 = i3 + 2;
                                    int i33 = i3 + 3;
                                    path.rCubicTo(f7, f6, fArr2[i30], fArr2[i31], fArr2[i32], fArr2[i33]);
                                    f2 = fArr2[i30] + f16;
                                    f3 = fArr2[i31] + f17;
                                    f16 += fArr2[i32];
                                    f4 = fArr2[i33];
                                } else if (c3 == 't') {
                                    if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                        f8 = f16 - f12;
                                        f9 = f17 - f13;
                                    } else {
                                        f9 = 0.0f;
                                        f8 = 0.0f;
                                    }
                                    int i34 = i3 + 0;
                                    int i35 = i3 + 1;
                                    path.rQuadTo(f8, f9, fArr2[i34], fArr2[i35]);
                                    float f29 = f8 + f16;
                                    float f30 = f9 + f17;
                                    f16 += fArr2[i34];
                                    f17 += fArr2[i35];
                                    f13 = f30;
                                    f12 = f29;
                                }
                                f17 += f5;
                            } else {
                                int i36 = i3 + 0;
                                int i37 = i3 + 1;
                                int i38 = i3 + 2;
                                int i39 = i3 + 3;
                                path.rQuadTo(fArr2[i36], fArr2[i37], fArr2[i38], fArr2[i39]);
                                f2 = fArr2[i36] + f16;
                                f3 = fArr2[i37] + f17;
                                f16 += fArr2[i38];
                                f4 = fArr2[i39];
                            }
                            i2 = i3;
                        } else {
                            int i40 = i3 + 2;
                            int i41 = i3 + 3;
                            int i42 = i3 + 4;
                            int i43 = i3 + 5;
                            path.rCubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i40], fArr2[i41], fArr2[i42], fArr2[i43]);
                            f2 = fArr2[i40] + f16;
                            f3 = fArr2[i41] + f17;
                            f16 += fArr2[i42];
                            f4 = fArr2[i43];
                        }
                        f17 += f4;
                        f12 = f2;
                        f13 = f3;
                        i2 = i3;
                    } else {
                        int i44 = i3 + 5;
                        int i45 = i3 + 6;
                        i2 = i3;
                        c(path, f16, f17, fArr2[i44] + f16, fArr2[i45] + f17, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                        f16 += fArr2[i44];
                        f17 += fArr2[i45];
                    }
                    i3 = i2 + i;
                    c4 = c2;
                    c3 = c4;
                } else {
                    i2 = i3;
                    int i46 = i2 + 5;
                    int i47 = i2 + 6;
                    c(path, f16, f17, fArr2[i46], fArr2[i47], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                    f16 = fArr2[i46];
                    f17 = fArr2[i47];
                }
                f13 = f17;
                f12 = f16;
                i3 = i2 + i;
                c4 = c2;
                c3 = c4;
            }
            fArr[0] = f16;
            fArr[1] = f17;
            fArr[2] = f12;
            fArr[3] = f13;
            fArr[4] = f18;
            fArr[5] = f19;
        }

        private static void b(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            double d11 = d4;
            int iCeil = (int) Math.ceil(Math.abs((d10 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d8);
            double dSin = Math.sin(d8);
            double dCos2 = Math.cos(d9);
            double dSin2 = Math.sin(d9);
            double d12 = -d11;
            double d13 = d12 * dCos;
            double d14 = d5 * dSin;
            double d15 = (d13 * dSin2) - (d14 * dCos2);
            double d16 = d12 * dSin;
            double d17 = d5 * dCos;
            double d18 = (dSin2 * d16) + (dCos2 * d17);
            double d19 = iCeil;
            Double.isNaN(d19);
            double d20 = d10 / d19;
            double d21 = d9;
            double d22 = d18;
            double d23 = d15;
            int i = 0;
            double d24 = d6;
            double d25 = d7;
            while (i < iCeil) {
                double d26 = d21 + d20;
                double dSin3 = Math.sin(d26);
                double dCos3 = Math.cos(d26);
                double d27 = (d2 + ((d11 * dCos) * dCos3)) - (d14 * dSin3);
                double d28 = d3 + (d11 * dSin * dCos3) + (d17 * dSin3);
                double d29 = (d13 * dSin3) - (d14 * dCos3);
                double d30 = (dSin3 * d16) + (dCos3 * d17);
                double d31 = d26 - d21;
                double dTan = Math.tan(d31 / 2.0d);
                double dSin4 = (Math.sin(d31) * (Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d)) / 3.0d;
                double d32 = d24 + (d23 * dSin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d32, (float) (d25 + (d22 * dSin4)), (float) (d27 - (dSin4 * d29)), (float) (d28 - (dSin4 * d30)), (float) d27, (float) d28);
                i++;
                d20 = d20;
                dSin = dSin;
                d24 = d27;
                d16 = d16;
                dCos = dCos;
                d21 = d26;
                d22 = d30;
                d23 = d29;
                iCeil = iCeil;
                d25 = d28;
                d11 = d4;
            }
        }

        private static void c(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
            double d2;
            double d3;
            double radians = Math.toRadians(f8);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d4 = f2;
            Double.isNaN(d4);
            double d5 = d4 * dCos;
            double d6 = f3;
            Double.isNaN(d6);
            double d7 = f6;
            Double.isNaN(d7);
            double d8 = (d5 + (d6 * dSin)) / d7;
            double d9 = -f2;
            Double.isNaN(d9);
            Double.isNaN(d6);
            double d10 = (d9 * dSin) + (d6 * dCos);
            double d11 = f7;
            Double.isNaN(d11);
            double d12 = d10 / d11;
            double d13 = f4;
            Double.isNaN(d13);
            double d14 = f5;
            Double.isNaN(d14);
            Double.isNaN(d7);
            double d15 = ((d13 * dCos) + (d14 * dSin)) / d7;
            double d16 = -f4;
            Double.isNaN(d16);
            Double.isNaN(d14);
            Double.isNaN(d11);
            double d17 = ((d16 * dSin) + (d14 * dCos)) / d11;
            double d18 = d8 - d15;
            double d19 = d12 - d17;
            double d20 = (d8 + d15) / 2.0d;
            double d21 = (d12 + d17) / 2.0d;
            double d22 = (d18 * d18) + (d19 * d19);
            if (d22 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d23 = (1.0d / d22) - 0.25d;
            if (d23 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d22);
                float fSqrt = (float) (Math.sqrt(d22) / 1.99999d);
                c(path, f2, f3, f4, f5, f6 * fSqrt, f7 * fSqrt, f8, z, z2);
                return;
            }
            double dSqrt = Math.sqrt(d23);
            double d24 = d18 * dSqrt;
            double d25 = dSqrt * d19;
            if (z == z2) {
                d2 = d20 - d25;
                d3 = d21 + d24;
            } else {
                d2 = d20 + d25;
                d3 = d21 - d24;
            }
            double dAtan2 = Math.atan2(d12 - d3, d8 - d2);
            double dAtan3 = Math.atan2(d17 - d3, d15 - d2) - dAtan2;
            if (z2 != (dAtan3 >= 0.0d)) {
                dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
            }
            Double.isNaN(d7);
            double d26 = d2 * d7;
            Double.isNaN(d11);
            double d27 = d3 * d11;
            b(path, (d26 * dCos) - (d27 * dSin), (d26 * dSin) + (d27 * dCos), d7, d11, d4, d6, radians, dAtan2, dAtan3);
        }

        public static void e(C0044b[] c0044bArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (int i = 0; i < c0044bArr.length; i++) {
                a(path, fArr, c, c0044bArr[i].a, c0044bArr[i].b);
                c = c0044bArr[i].a;
            }
        }

        public void d(C0044b c0044b, C0044b c0044b2, float f2) {
            this.a = c0044b.a;
            int i = 0;
            while (true) {
                float[] fArr = c0044b.b;
                if (i >= fArr.length) {
                    return;
                }
                this.b[i] = (fArr[i] * (1.0f - f2)) + (c0044b2.b[i] * f2);
                i++;
            }
        }
    }

    private static void a(ArrayList<C0044b> arrayList, char c, float[] fArr) {
        arrayList.add(new C0044b(c, fArr));
    }

    public static boolean b(C0044b[] c0044bArr, C0044b[] c0044bArr2) {
        if (c0044bArr == null || c0044bArr2 == null || c0044bArr.length != c0044bArr2.length) {
            return false;
        }
        for (int i = 0; i < c0044bArr.length; i++) {
            if (c0044bArr[i].a != c0044bArr2[i].a || c0044bArr[i].b.length != c0044bArr2[i].b.length) {
                return false;
            }
        }
        return true;
    }

    static float[] c(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int iMin = Math.min(i3, length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, iMin);
        return fArr2;
    }

    public static C0044b[] d(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int i3 = i(str, i);
            String strTrim = str.substring(i2, i3).trim();
            if (strTrim.length() > 0) {
                a(arrayList, strTrim.charAt(0), h(strTrim));
            }
            i2 = i3;
            i = i3 + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a(arrayList, str.charAt(i2), new float[0]);
        }
        return (C0044b[]) arrayList.toArray(new C0044b[arrayList.size()]);
    }

    public static Path e(String str) {
        Path path = new Path();
        C0044b[] c0044bArrD = d(str);
        if (c0044bArrD == null) {
            return null;
        }
        try {
            C0044b.e(c0044bArrD, path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException("Error in parsing " + str, e2);
        }
    }

    public static C0044b[] f(C0044b[] c0044bArr) {
        if (c0044bArr == null) {
            return null;
        }
        C0044b[] c0044bArr2 = new C0044b[c0044bArr.length];
        for (int i = 0; i < c0044bArr.length; i++) {
            c0044bArr2[i] = new C0044b(c0044bArr[i]);
        }
        return c0044bArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:15:0x0027  */
    /* JADX WARN: Code duplicated, block: B:19:0x002f  */
    /* JADX WARN: Code duplicated, block: B:21:0x0033  */
    private static void g(String str, int i, a aVar) {
        aVar.b = false;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = i; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == ' ') {
                z = false;
                z3 = true;
            } else if (cCharAt != 'E' && cCharAt != 'e') {
                switch (cCharAt) {
                    case ',':
                        z = false;
                        z3 = true;
                        break;
                    case '-':
                        if (i2 == i || z) {
                            z = false;
                        } else {
                            aVar.b = true;
                            z = false;
                            z3 = true;
                        }
                        break;
                    case '.':
                        if (z2) {
                            aVar.b = true;
                            z = false;
                            z3 = true;
                        } else {
                            z = false;
                            z2 = true;
                        }
                        break;
                    default:
                        z = false;
                        break;
                }
            } else {
                z = true;
            }
            if (z3) {
                aVar.a = i2;
            }
        }
        aVar.a = i2;
    }

    private static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                g(str, i, aVar);
                int i3 = aVar.a;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = aVar.b ? i3 : i3 + 1;
            }
            return c(fArr, 0, i2);
        } catch (NumberFormatException e2) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e2);
        }
    }

    private static int i(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (((cCharAt - 'A') * (cCharAt - 'Z') <= 0 || (cCharAt - 'a') * (cCharAt - 'z') <= 0) && cCharAt != 'e' && cCharAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    public static void j(C0044b[] c0044bArr, C0044b[] c0044bArr2) {
        for (int i = 0; i < c0044bArr2.length; i++) {
            c0044bArr[i].a = c0044bArr2[i].a;
            for (int i2 = 0; i2 < c0044bArr2[i].b.length; i2++) {
                c0044bArr[i].b[i2] = c0044bArr2[i].b[i2];
            }
        }
    }
}
