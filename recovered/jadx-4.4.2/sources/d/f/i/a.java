package d.f.i;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final d f777d = e.c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f778e = Character.toString(8206);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f779f = Character.toString(8207);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final a f780g = new a(false, 2, f777d);
    static final a h = new a(true, 2, f777d);
    private final boolean a;
    private final int b;
    private final d c;

    /* JADX INFO: renamed from: d.f.i.a$a, reason: collision with other inner class name */
    public static final class C0048a {
        private boolean a;
        private int b;
        private d c;

        public C0048a() {
            c(a.e(Locale.getDefault()));
        }

        private static a b(boolean z) {
            return z ? a.h : a.f780g;
        }

        private void c(boolean z) {
            this.a = z;
            this.c = a.f777d;
            this.b = 2;
        }

        public a a() {
            return (this.b == 2 && this.c == a.f777d) ? b(this.a) : new a(this.a, this.b, this.c);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final byte[] f781f = new byte[1792];
        private final CharSequence a;
        private final boolean b;
        private final int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f782d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private char f783e;

        static {
            for (int i = 0; i < 1792; i++) {
                f781f[i] = Character.getDirectionality(i);
            }
        }

        b(CharSequence charSequence, boolean z) {
            this.a = charSequence;
            this.b = z;
            this.c = charSequence.length();
        }

        private static byte c(char c) {
            return c < 1792 ? f781f[c] : Character.getDirectionality(c);
        }

        private byte f() {
            char cCharAt;
            int i = this.f782d;
            do {
                int i2 = this.f782d;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.a;
                int i3 = i2 - 1;
                this.f782d = i3;
                cCharAt = charSequence.charAt(i3);
                this.f783e = cCharAt;
                if (cCharAt == '&') {
                    return (byte) 12;
                }
            } while (cCharAt != ';');
            this.f782d = i;
            this.f783e = ';';
            return (byte) 13;
        }

        private byte g() {
            char cCharAt;
            do {
                int i = this.f782d;
                if (i >= this.c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.a;
                this.f782d = i + 1;
                cCharAt = charSequence.charAt(i);
                this.f783e = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char cCharAt;
            int i = this.f782d;
            while (true) {
                int i2 = this.f782d;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.a;
                int i3 = i2 - 1;
                this.f782d = i3;
                char cCharAt2 = charSequence.charAt(i3);
                this.f783e = cCharAt2;
                if (cCharAt2 == '<') {
                    return (byte) 12;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    char c = this.f783e;
                    do {
                        int i4 = this.f782d;
                        if (i4 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.a;
                        int i5 = i4 - 1;
                        this.f782d = i5;
                        cCharAt = charSequence2.charAt(i5);
                        this.f783e = cCharAt;
                    } while (cCharAt != c);
                }
            }
            this.f782d = i;
            this.f783e = '>';
            return (byte) 13;
        }

        private byte i() {
            char cCharAt;
            int i = this.f782d;
            while (true) {
                int i2 = this.f782d;
                if (i2 >= this.c) {
                    this.f782d = i;
                    this.f783e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.a;
                this.f782d = i2 + 1;
                char cCharAt2 = charSequence.charAt(i2);
                this.f783e = cCharAt2;
                if (cCharAt2 == '>') {
                    return (byte) 12;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    char c = this.f783e;
                    do {
                        int i3 = this.f782d;
                        if (i3 >= this.c) {
                            break;
                        }
                        CharSequence charSequence2 = this.a;
                        this.f782d = i3 + 1;
                        cCharAt = charSequence2.charAt(i3);
                        this.f783e = cCharAt;
                    } while (cCharAt != c);
                }
            }
        }

        byte a() {
            char cCharAt = this.a.charAt(this.f782d - 1);
            this.f783e = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.a, this.f782d);
                this.f782d -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f782d--;
            byte bC = c(this.f783e);
            if (!this.b) {
                return bC;
            }
            char c = this.f783e;
            if (c == '>') {
                return h();
            }
            return c == ';' ? f() : bC;
        }

        byte b() {
            char cCharAt = this.a.charAt(this.f782d);
            this.f783e = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.a, this.f782d);
                this.f782d += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f782d++;
            byte bC = c(this.f783e);
            if (!this.b) {
                return bC;
            }
            char c = this.f783e;
            if (c == '<') {
                return i();
            }
            return c == '&' ? g() : bC;
        }

        int d() {
            this.f782d = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.f782d < this.c && i == 0) {
                byte b = b();
                if (b != 0) {
                    if (b == 1 || b == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (b != 9) {
                        switch (b) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case 18:
                                i3--;
                                i2 = 0;
                                continue;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.f782d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                    default:
                        continue;
                }
                i3--;
            }
            return 0;
        }

        int e() {
            this.f782d = this.c;
            int i = 0;
            int i2 = 0;
            while (this.f782d > 0) {
                byte bA = a();
                if (bA == 0) {
                    if (i == 0) {
                        return -1;
                    }
                    if (i2 == 0) {
                        i2 = i;
                    }
                } else if (bA == 1 || bA == 2) {
                    if (i == 0) {
                        return 1;
                    }
                    if (i2 == 0) {
                        i2 = i;
                    }
                } else if (bA != 9) {
                    switch (bA) {
                        case 14:
                        case 15:
                            if (i2 == i) {
                                return -1;
                            }
                            i--;
                            break;
                        case 16:
                        case 17:
                            if (i2 == i) {
                                return 1;
                            }
                            i--;
                            break;
                        case 18:
                            i++;
                            break;
                        default:
                            if (i2 == 0) {
                                i2 = i;
                            }
                            break;
                    }
                } else {
                    continue;
                }
            }
            return 0;
        }
    }

    a(boolean z, int i, d dVar) {
        this.a = z;
        this.b = i;
        this.c = dVar;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0048a().a();
    }

    static boolean e(Locale locale) {
        return f.b(locale) == 1;
    }

    private String f(CharSequence charSequence, d dVar) {
        boolean zA = dVar.a(charSequence, 0, charSequence.length());
        if (!this.a && (zA || b(charSequence) == 1)) {
            return f778e;
        }
        if (this.a) {
            return (!zA || b(charSequence) == -1) ? f779f : "";
        }
        return "";
    }

    private String g(CharSequence charSequence, d dVar) {
        boolean zA = dVar.a(charSequence, 0, charSequence.length());
        if (!this.a && (zA || a(charSequence) == 1)) {
            return f778e;
        }
        if (this.a) {
            return (!zA || a(charSequence) == -1) ? f779f : "";
        }
        return "";
    }

    public boolean d() {
        return (this.b & 2) != 0;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.c, true);
    }

    public CharSequence i(CharSequence charSequence, d dVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean zA = dVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z) {
            spannableStringBuilder.append((CharSequence) g(charSequence, zA ? e.b : e.a));
        }
        if (zA != this.a) {
            spannableStringBuilder.append(zA ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) f(charSequence, zA ? e.b : e.a));
        }
        return spannableStringBuilder;
    }
}
