package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    static final PorterDuff.Mode j = PorterDuff.Mode.SRC_IN;
    Object b;
    public int a = -1;
    public byte[] c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f263d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f264e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f265f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f266g = null;
    PorterDuff.Mode h = j;
    public String i = null;

    private static int b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon resource", e4);
            return 0;
        }
    }

    private static String d(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon package", e4);
            return null;
        }
    }

    private static String g(int i) {
        if (i == 1) {
            return "BITMAP";
        }
        if (i == 2) {
            return "RESOURCE";
        }
        if (i == 3) {
            return "DATA";
        }
        if (i != 4) {
            return i != 5 ? "UNKNOWN" : "BITMAP_MASKABLE";
        }
        return "URI";
    }

    public int a() {
        if (this.a == -1 && Build.VERSION.SDK_INT >= 23) {
            return b((Icon) this.b);
        }
        if (this.a == 2) {
            return this.f264e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String c() {
        if (this.a == -1 && Build.VERSION.SDK_INT >= 23) {
            return d((Icon) this.b);
        }
        if (this.a == 2) {
            return ((String) this.b).split(":", -1)[0];
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public void e() {
        Parcelable parcelable;
        this.h = PorterDuff.Mode.valueOf(this.i);
        int i = this.a;
        if (i != -1) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.b = this.c;
                        return;
                    } else if (i != 4) {
                        if (i != 5) {
                            return;
                        }
                    }
                }
                this.b = new String(this.c, Charset.forName("UTF-16"));
                return;
            }
            parcelable = this.f263d;
            if (parcelable == null) {
                byte[] bArr = this.c;
                this.b = bArr;
                this.a = 3;
                this.f264e = 0;
                this.f265f = bArr.length;
                return;
            }
        } else {
            parcelable = this.f263d;
            if (parcelable == null) {
                throw new IllegalArgumentException("Invalid icon");
            }
        }
        this.b = parcelable;
    }

    public void f(boolean z) {
        this.i = this.h.name();
        int i = this.a;
        if (i != -1) {
            if (i != 1) {
                if (i == 2) {
                    this.c = ((String) this.b).getBytes(Charset.forName("UTF-16"));
                    return;
                }
                if (i == 3) {
                    this.c = (byte[]) this.b;
                    return;
                } else if (i == 4) {
                    this.c = this.b.toString().getBytes(Charset.forName("UTF-16"));
                    return;
                } else if (i != 5) {
                    return;
                }
            }
            if (z) {
                Bitmap bitmap = (Bitmap) this.b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.c = byteArrayOutputStream.toByteArray();
                return;
            }
        } else if (z) {
            throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
        }
        this.f263d = (Parcelable) this.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        if (r1 != 5) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        int height;
        if (this.a == -1) {
            return String.valueOf(this.b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(g(this.a));
        int i = this.a;
        if (i == 1) {
            sb.append(" size=");
            sb.append(((Bitmap) this.b).getWidth());
            sb.append("x");
            height = ((Bitmap) this.b).getHeight();
            sb.append(height);
        } else if (i == 2) {
            sb.append(" pkg=");
            sb.append(c());
            sb.append(" id=");
            sb.append(String.format("0x%08x", Integer.valueOf(a())));
        } else if (i == 3) {
            sb.append(" len=");
            sb.append(this.f264e);
            if (this.f265f != 0) {
                sb.append(" off=");
                height = this.f265f;
                sb.append(height);
            }
        } else if (i == 4) {
            sb.append(" uri=");
            sb.append(this.b);
        }
        if (this.f266g != null) {
            sb.append(" tint=");
            sb.append(this.f266g);
        }
        if (this.h != j) {
            sb.append(" mode=");
            sb.append(this.h);
        }
        sb.append(")");
        return sb.toString();
    }
}
