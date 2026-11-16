package d.k.a;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import d.d.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
class b extends d.k.a.a {
    static boolean c = false;
    private final g a;
    private final c b;

    /* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<D>] */
    public static class a<D> extends l<D> {
        private final int j;
        private final Bundle k;
        private final d.k.b.a<D> l;
        private g m;
        private C0060b<D> n;
        private d.k.b.a<D> o;

        @Override // androidx.lifecycle.LiveData
        protected void e() {
            if (b.c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.l.d();
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        protected void f() {
            if (b.c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.l.e();
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void g(m<? super D> mVar) {
            super.g(mVar);
            this.m = null;
            this.n = null;
        }

        @Override // androidx.lifecycle.l, androidx.lifecycle.LiveData
        public void h(D d2) {
            super.h(d2);
            d.k.b.a<D> aVar = this.o;
            if (aVar == null) {
                return;
            }
            aVar.c();
            throw null;
        }

        d.k.b.a<D> i(boolean z) {
            if (b.c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.l.a();
            throw null;
        }

        public void j(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.j);
            printWriter.print(" mArgs=");
            printWriter.println(this.k);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.l);
            this.l.b(str + "  ", fileDescriptor, printWriter, strArr);
            throw null;
        }

        void k() {
            g gVar = this.m;
            C0060b<D> c0060b = this.n;
            if (gVar == null || c0060b == null) {
                return;
            }
            super.g(c0060b);
            d(gVar, c0060b);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.j);
            sb.append(" : ");
            d.f.j.a.a(this.l, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: d.k.a.b$b, reason: collision with other inner class name */
    static class C0060b<D> implements m<D> {
    }

    static class c extends q {
        private static final r.a c = new a();
        private h<a> b = new h<>();

        static class a implements r.a {
            a() {
            }

            @Override // androidx.lifecycle.r.a
            public <T extends q> T a(Class<T> cls) {
                return new c();
            }
        }

        c() {
        }

        static c f(s sVar) {
            return (c) new r(sVar, c).a(c.class);
        }

        @Override // androidx.lifecycle.q
        protected void d() {
            super.d();
            if (this.b.k() <= 0) {
                this.b.b();
            } else {
                this.b.l(0).i(true);
                throw null;
            }
        }

        public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.b.k() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                if (this.b.k() <= 0) {
                    return;
                }
                a aVarL = this.b.l(0);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.b.h(0));
                printWriter.print(": ");
                printWriter.println(aVarL.toString());
                aVarL.j(str2, fileDescriptor, printWriter, strArr);
                throw null;
            }
        }

        void g() {
            int iK = this.b.k();
            for (int i = 0; i < iK; i++) {
                this.b.l(i).k();
            }
        }
    }

    b(g gVar, s sVar) {
        this.a = gVar;
        this.b = c.f(sVar);
    }

    @Override // d.k.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.b.e(str, fileDescriptor, printWriter, strArr);
    }

    @Override // d.k.a.a
    public void c() {
        this.b.g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        d.f.j.a.a(this.a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
