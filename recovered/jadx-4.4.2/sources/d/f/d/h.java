package d.f.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class h {
    private ConcurrentHashMap<Long, androidx.core.content.c.c.b> a = new ConcurrentHashMap<>();

    class a implements c<d.f.h.b.f> {
        a(h hVar) {
        }

        @Override // d.f.d.h.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(d.f.h.b.f fVar) {
            return fVar.d();
        }

        @Override // d.f.d.h.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(d.f.h.b.f fVar) {
            return fVar.e();
        }
    }

    class b implements c<androidx.core.content.c.c.C0008c> {
        b(h hVar) {
        }

        @Override // d.f.d.h.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(androidx.core.content.c.c.C0008c c0008c) {
            return c0008c.e();
        }

        @Override // d.f.d.h.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(androidx.core.content.c.c.C0008c c0008c) {
            return c0008c.f();
        }
    }

    private interface c<T> {
        int a(T t);

        boolean b(T t);
    }

    h() {
    }

    private void a(Typeface typeface, androidx.core.content.c.c.b bVar) {
        long j = j(typeface);
        if (j != 0) {
            this.a.put(Long.valueOf(j), bVar);
        }
    }

    private androidx.core.content.c.c.C0008c f(androidx.core.content.c.c.b bVar, int i) {
        return (androidx.core.content.c.c.C0008c) g(bVar.a(), i, new b(this));
    }

    private static <T> T g(T[] tArr, int i, c<T> cVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int iAbs = (Math.abs(cVar.a(t2) - i2) * 2) + (cVar.b(t2) == z ? 0 : 1);
            if (t == null || i3 > iAbs) {
                t = t2;
                i3 = iAbs;
            }
        }
        return t;
    }

    private static long j(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        } catch (NoSuchFieldException e3) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e3);
            return 0L;
        }
    }

    public Typeface b(Context context, androidx.core.content.c.c.b bVar, Resources resources, int i) {
        androidx.core.content.c.c.C0008c c0008cF = f(bVar, i);
        if (c0008cF == null) {
            return null;
        }
        Typeface typefaceD = d.f.d.c.d(context, resources, c0008cF.b(), c0008cF.a(), i);
        a(typefaceD, bVar);
        return typefaceD;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, d.f.h.b.f[] fVarArr, int i) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        if (fVarArr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(h(fVarArr, i).c());
            try {
                Typeface typefaceD = d(context, inputStreamOpenInputStream);
                i.a(inputStreamOpenInputStream);
                return typefaceD;
            } catch (IOException unused) {
                i.a(inputStreamOpenInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                i.a(inputStream);
                throw th;
            }
        } catch (IOException unused2) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    protected Typeface d(Context context, InputStream inputStream) {
        File fileE = i.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (i.d(fileE, inputStream)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i, String str, int i2) {
        File fileE = i.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (i.c(fileE, resources, i)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    protected d.f.h.b.f h(d.f.h.b.f[] fVarArr, int i) {
        return (d.f.h.b.f) g(fVarArr, i, new a(this));
    }

    androidx.core.content.c.c.b i(Typeface typeface) {
        long j = j(typeface);
        if (j == 0) {
            return null;
        }
        return this.a.get(Long.valueOf(j));
    }
}
