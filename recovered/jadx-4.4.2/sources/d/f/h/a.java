package d.f.h;

import android.util.Base64;
import d.f.j.h;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private final String a;
    private final String b;
    private final String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<List<byte[]>> f760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f762f;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        h.c(str);
        this.a = str;
        h.c(str2);
        this.b = str2;
        h.c(str3);
        this.c = str3;
        h.c(list);
        this.f760d = list;
        this.f761e = 0;
        this.f762f = this.a + "-" + this.b + "-" + this.c;
    }

    public List<List<byte[]>> a() {
        return this.f760d;
    }

    public int b() {
        return this.f761e;
    }

    public String c() {
        return this.f762f;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.b;
    }

    public String f() {
        return this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.a + ", mProviderPackage: " + this.b + ", mQuery: " + this.c + ", mCertificates:");
        for (int i = 0; i < this.f760d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f760d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f761e);
        return sb.toString();
    }
}
