package androidx.core.content.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import d.f.j.h;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    public static abstract class a {

        /* JADX INFO: renamed from: androidx.core.content.c.f$a$a, reason: collision with other inner class name */
        class RunnableC0009a implements Runnable {
            final /* synthetic */ Typeface b;

            RunnableC0009a(Typeface typeface) {
                this.b = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.d(this.b);
            }
        }

        class b implements Runnable {
            final /* synthetic */ int b;

            b(int i) {
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(this.b);
            }
        }

        public final void a(int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new b(i));
        }

        public final void b(Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new RunnableC0009a(typeface));
        }

        public abstract void c(int i);

        public abstract void d(Typeface typeface);
    }

    public static Drawable a(Resources resources, int i, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }

    public static Typeface b(Context context, int i) {
        if (context.isRestricted()) {
            return null;
        }
        return e(context, i, new TypedValue(), 0, null, null, false);
    }

    public static Typeface c(Context context, int i, TypedValue typedValue, int i2, a aVar) {
        if (context.isRestricted()) {
            return null;
        }
        return e(context, i, typedValue, i2, aVar, null, true);
    }

    public static void d(Context context, int i, a aVar, Handler handler) {
        h.c(aVar);
        if (context.isRestricted()) {
            aVar.a(-4, handler);
        } else {
            e(context, i, new TypedValue(), 0, aVar, handler, false);
        }
    }

    private static Typeface e(Context context, int i, TypedValue typedValue, int i2, a aVar, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface typefaceF = f(context, resources, typedValue, i, i2, aVar, handler, z);
        if (typefaceF != null || aVar != null) {
            return typefaceF;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0096  */
    private static Typeface f(Context context, Resources resources, TypedValue typedValue, int i, int i2, a aVar, Handler handler, boolean z) {
        StringBuilder sb;
        String str;
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        if (!string.startsWith("res/")) {
            if (aVar != null) {
                aVar.a(-3, handler);
            }
            return null;
        }
        Typeface typefaceF = d.f.d.c.f(resources, i, i2);
        if (typefaceF != null) {
            if (aVar != null) {
                aVar.b(typefaceF, handler);
            }
            return typefaceF;
        }
        try {
            if (!string.toLowerCase().endsWith(".xml")) {
                Typeface typefaceD = d.f.d.c.d(context, resources, i, string, i2);
                if (aVar != null) {
                    if (typefaceD != null) {
                        aVar.b(typefaceD, handler);
                    } else {
                        aVar.a(-3, handler);
                    }
                }
                return typefaceD;
            }
            c.a aVarB = c.b(resources.getXml(i), resources);
            if (aVarB != null) {
                return d.f.d.c.c(context, aVarB, resources, i, i2, aVar, handler, z);
            }
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            if (aVar != null) {
                aVar.a(-3, handler);
            }
            return null;
        } catch (IOException e2) {
            e = e2;
            sb = new StringBuilder();
            str = "Failed to read xml resource ";
            sb.append(str);
            sb.append(string);
            Log.e("ResourcesCompat", sb.toString(), e);
            if (aVar != null) {
                aVar.a(-3, handler);
            }
            return null;
        } catch (XmlPullParserException e3) {
            e = e3;
            sb = new StringBuilder();
            str = "Failed to parse xml resource ";
            sb.append(str);
            sb.append(string);
            Log.e("ResourcesCompat", sb.toString(), e);
            if (aVar != null) {
                aVar.a(-3, handler);
            }
            return null;
        }
    }
}
