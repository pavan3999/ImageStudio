package d.f.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class e extends h {
    private static final Class b;
    private static final Constructor c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Method f756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Method f757e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
        }
        c = constructor;
        b = cls;
        f756d = method2;
        f757e = method;
    }

    e() {
    }

    private static boolean k(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f756d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface l(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f757e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean m() {
        if (f756d == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f756d != null;
    }

    private static Object n() {
        try {
            return c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // d.f.d.h
    public Typeface b(Context context, androidx.core.content.c.c.b bVar, Resources resources, int i) {
        Object objN = n();
        if (objN == null) {
            return null;
        }
        for (androidx.core.content.c.c.C0008c c0008c : bVar.a()) {
            ByteBuffer byteBufferB = i.b(context, resources, c0008c.b());
            if (byteBufferB == null || !k(objN, byteBufferB, c0008c.c(), c0008c.e(), c0008c.f())) {
                return null;
            }
        }
        return l(objN);
    }

    @Override // d.f.d.h
    public Typeface c(Context context, CancellationSignal cancellationSignal, d.f.h.b.f[] fVarArr, int i) {
        Object objN = n();
        if (objN == null) {
            return null;
        }
        d.d.g gVar = new d.d.g();
        for (d.f.h.b.f fVar : fVarArr) {
            Uri uriC = fVar.c();
            ByteBuffer byteBufferF = (ByteBuffer) gVar.get(uriC);
            if (byteBufferF == null) {
                byteBufferF = i.f(context, cancellationSignal, uriC);
                gVar.put(uriC, byteBufferF);
            }
            if (byteBufferF == null || !k(objN, byteBufferF, fVar.b(), fVar.d(), fVar.e())) {
                return null;
            }
        }
        Typeface typefaceL = l(objN);
        if (typefaceL == null) {
            return null;
        }
        return Typeface.create(typefaceL, i);
    }
}
