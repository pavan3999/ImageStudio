package d.f.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class d extends h {
    private static Class b = null;
    private static Constructor c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f753d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f754e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f755f = false;

    d() {
    }

    private static boolean k(Object obj, String str, int i, boolean z) throws NoSuchMethodException {
        n();
        try {
            return ((Boolean) f753d.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Typeface l(Object obj) throws NoSuchMethodException {
        n();
        try {
            Object objNewInstance = Array.newInstance((Class<?>) b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f754e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private File m(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(str).st_mode)) {
                return new File(str);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void n() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (f755f) {
            return;
        }
        f755f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        c = constructor;
        b = cls;
        f753d = method2;
        f754e = method;
    }

    private static Object o() throws NoSuchMethodException {
        n();
        try {
            return c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // d.f.d.h
    public Typeface b(Context context, androidx.core.content.c.c.b bVar, Resources resources, int i) throws NoSuchMethodException {
        Object objO = o();
        for (androidx.core.content.c.c.C0008c c0008c : bVar.a()) {
            File fileE = i.e(context);
            if (fileE == null) {
                return null;
            }
            try {
                if (!i.c(fileE, resources, c0008c.b())) {
                    fileE.delete();
                    return null;
                }
                boolean zK = k(objO, fileE.getPath(), c0008c.e(), c0008c.f());
                fileE.delete();
                if (!zK) {
                    return null;
                }
            } catch (RuntimeException unused) {
                fileE.delete();
                return null;
            } catch (Throwable th) {
                fileE.delete();
                throw th;
            }
        }
        return l(objO);
    }

    @Override // d.f.d.h
    public Typeface c(Context context, CancellationSignal cancellationSignal, d.f.h.b.f[] fVarArr, int i) {
        if (fVarArr.length < 1) {
            return null;
        }
        d.f.h.b.f fVarH = h(fVarArr, i);
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(fVarH.c(), "r", cancellationSignal);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
                return null;
            }
            try {
                File fileM = m(parcelFileDescriptorOpenFileDescriptor);
                if (fileM != null && fileM.canRead()) {
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(fileM);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return typefaceCreateFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    Typeface typefaceD = super.d(context, fileInputStream);
                    fileInputStream.close();
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return typefaceD;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th4;
                }
            }
        } catch (IOException unused3) {
            return null;
        }
    }
}
