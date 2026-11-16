package d.f.h;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import d.f.d.i;
import d.f.j.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class b {
    static final d.d.e<String, Typeface> a = new d.d.e<>(16);
    private static final d.f.h.c b = new d.f.h.c("fonts", 10, 10000);
    static final Object c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final d.d.g<String, ArrayList<d.f.h.c.d<g>>> f763d = new d.d.g<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Comparator<byte[]> f764e = new d();

    static class a implements Callable<g> {
        final /* synthetic */ Context b;
        final /* synthetic */ d.f.h.a c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f765d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f766e;

        a(Context context, d.f.h.a aVar, int i, String str) {
            this.b = context;
            this.c = aVar;
            this.f765d = i;
            this.f766e = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g call() {
            g gVarF = b.f(this.b, this.c, this.f765d);
            Typeface typeface = gVarF.a;
            if (typeface != null) {
                b.a.d(this.f766e, typeface);
            }
            return gVarF;
        }
    }

    /* JADX INFO: renamed from: d.f.h.b$b, reason: collision with other inner class name */
    static class C0046b implements d.f.h.c.d<g> {
        final /* synthetic */ androidx.core.content.c.f.a a;
        final /* synthetic */ Handler b;

        C0046b(androidx.core.content.c.f.a aVar, Handler handler) {
            this.a = aVar;
            this.b = handler;
        }

        @Override // d.f.h.c.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g gVar) {
            int i;
            androidx.core.content.c.f.a aVar;
            if (gVar == null) {
                aVar = this.a;
                i = 1;
            } else {
                i = gVar.b;
                if (i == 0) {
                    this.a.b(gVar.a, this.b);
                    return;
                }
                aVar = this.a;
            }
            aVar.a(i, this.b);
        }
    }

    static class c implements d.f.h.c.d<g> {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // d.f.h.c.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g gVar) {
            synchronized (b.c) {
                ArrayList<d.f.h.c.d<g>> arrayList = b.f763d.get(this.a);
                if (arrayList == null) {
                    return;
                }
                b.f763d.remove(this.a);
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i).a(gVar);
                }
            }
        }
    }

    static class d implements Comparator<byte[]> {
        d() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            int length;
            int length2;
            if (bArr.length == bArr2.length) {
                for (int i = 0; i < bArr.length; i++) {
                    if (bArr[i] != bArr2[i]) {
                        length = bArr[i];
                        length2 = bArr2[i];
                    }
                }
                return 0;
            }
            length = bArr.length;
            length2 = bArr2.length;
            return length - length2;
        }
    }

    public static class e {
        private final int a;
        private final f[] b;

        public e(int i, f[] fVarArr) {
            this.a = i;
            this.b = fVarArr;
        }

        public f[] a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }
    }

    public static class f {
        private final Uri a;
        private final int b;
        private final int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f767d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f768e;

        public f(Uri uri, int i, int i2, boolean z, int i3) {
            h.c(uri);
            this.a = uri;
            this.b = i;
            this.c = i2;
            this.f767d = z;
            this.f768e = i3;
        }

        public int a() {
            return this.f768e;
        }

        public int b() {
            return this.b;
        }

        public Uri c() {
            return this.a;
        }

        public int d() {
            return this.c;
        }

        public boolean e() {
            return this.f767d;
        }
    }

    private static final class g {
        final Typeface a;
        final int b;

        g(Typeface typeface, int i) {
            this.a = typeface;
            this.b = i;
        }
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean b(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static e c(Context context, CancellationSignal cancellationSignal, d.f.h.a aVar) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoH = h(context.getPackageManager(), aVar, context.getResources());
        return providerInfoH == null ? new e(1, null) : new e(0, e(context, aVar, providerInfoH.authority, cancellationSignal));
    }

    private static List<List<byte[]>> d(d.f.h.a aVar, Resources resources) {
        return aVar.a() != null ? aVar.a() : androidx.core.content.c.c.c(resources, aVar.b());
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0136  */
    static f[] e(Context context, d.f.h.a aVar, String str, CancellationSignal cancellationSignal) throws Throwable {
        Cursor cursor;
        String str2;
        String str3;
        int i;
        Cursor cursorQuery;
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        try {
            if (Build.VERSION.SDK_INT > 16) {
                str2 = "file_id";
                cursorQuery = context.getContentResolver().query(uriBuild, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, null, cancellationSignal);
                str3 = "_id";
                i = 1;
            } else {
                str2 = "file_id";
                str3 = "_id";
                i = 1;
                cursorQuery = context.getContentResolver().query(uriBuild, new String[]{str3, str2, "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, null);
            }
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        int columnIndex = cursorQuery.getColumnIndex("result_code");
                        ArrayList arrayList3 = new ArrayList();
                        int columnIndex2 = cursorQuery.getColumnIndex(str3);
                        int columnIndex3 = cursorQuery.getColumnIndex(str2);
                        int columnIndex4 = cursorQuery.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursorQuery.getColumnIndex("font_weight");
                        int columnIndex6 = cursorQuery.getColumnIndex("font_italic");
                        while (cursorQuery.moveToNext()) {
                            int i2 = columnIndex != -1 ? cursorQuery.getInt(columnIndex) : 0;
                            arrayList3.add(new f(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3)), columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorQuery.getInt(columnIndex6) == i, i2));
                        }
                        arrayList = arrayList3;
                    } else {
                        arrayList = arrayList2;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } else {
                arrayList = arrayList2;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return (f[]) arrayList.toArray(new f[0]);
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    static g f(Context context, d.f.h.a aVar, int i) {
        try {
            e eVarC = c(context, null, aVar);
            if (eVarC.b() != 0) {
                return new g(null, eVarC.b() == 1 ? -2 : -3);
            }
            Typeface typefaceB = d.f.d.c.b(context, null, eVarC.a(), i);
            return new g(typefaceB, typefaceB != null ? 0 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new g(null, -1);
        }
    }

    public static Typeface g(Context context, d.f.h.a aVar, androidx.core.content.c.f.a aVar2, Handler handler, boolean z, int i, int i2) {
        String str = aVar.c() + "-" + i2;
        Typeface typefaceC = a.c(str);
        if (typefaceC != null) {
            if (aVar2 != null) {
                aVar2.d(typefaceC);
            }
            return typefaceC;
        }
        if (z && i == -1) {
            g gVarF = f(context, aVar, i2);
            if (aVar2 != null) {
                int i3 = gVarF.b;
                if (i3 == 0) {
                    aVar2.b(gVarF.a, handler);
                } else {
                    aVar2.a(i3, handler);
                }
            }
            return gVarF.a;
        }
        a aVar3 = new a(context, aVar, i2, str);
        if (z) {
            try {
                return ((g) b.e(aVar3, i)).a;
            } catch (InterruptedException unused) {
                return null;
            }
        }
        C0046b c0046b = aVar2 == null ? null : new C0046b(aVar2, handler);
        synchronized (c) {
            ArrayList<d.f.h.c.d<g>> arrayList = f763d.get(str);
            if (arrayList != null) {
                if (c0046b != null) {
                    arrayList.add(c0046b);
                }
                return null;
            }
            if (c0046b != null) {
                ArrayList<d.f.h.c.d<g>> arrayList2 = new ArrayList<>();
                arrayList2.add(c0046b);
                f763d.put(str, arrayList2);
            }
            b.d(aVar3, new c(str));
            return null;
        }
    }

    public static ProviderInfo h(PackageManager packageManager, d.f.h.a aVar, Resources resources) throws PackageManager.NameNotFoundException {
        String strD = aVar.d();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strD, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strD);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(aVar.e())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strD + ", but package was not " + aVar.e());
        }
        List<byte[]> listA = a(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listA, f764e);
        List<List<byte[]>> listD = d(aVar, resources);
        for (int i = 0; i < listD.size(); i++) {
            ArrayList arrayList = new ArrayList(listD.get(i));
            Collections.sort(arrayList, f764e);
            if (b(listA, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    public static Map<Uri, ByteBuffer> i(Context context, f[] fVarArr, CancellationSignal cancellationSignal) {
        HashMap map = new HashMap();
        for (f fVar : fVarArr) {
            if (fVar.a() == 0) {
                Uri uriC = fVar.c();
                if (!map.containsKey(uriC)) {
                    map.put(uriC, i.f(context, cancellationSignal, uriC));
                }
            }
        }
        return Collections.unmodifiableMap(map);
    }
}
