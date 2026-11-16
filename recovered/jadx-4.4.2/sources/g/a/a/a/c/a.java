package g.a.a.a.c;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class a {

    private static class b implements f {
        private final c a;
        private final c b;
        private final c c;

        protected b(c cVar, c cVar2, c cVar3) {
            this.a = cVar;
            this.b = cVar2;
            this.c = cVar3;
        }

        @Override // g.a.a.a.c.a.f
        public c a() {
            return this.c;
        }

        @Override // g.a.a.a.c.a.f
        public c b() {
            return this.b;
        }

        @Override // g.a.a.a.c.a.f
        public c c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return defpackage.a.a(this.a, bVar.a) && defpackage.a.a(this.b, bVar.b) && defpackage.a.a(this.c, bVar.c);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.a, this.b, this.c});
        }

        public String toString() {
            return String.format("%,d files, %,d directories, %,d bytes", Long.valueOf(this.c.b()), Long.valueOf(this.b.b()), Long.valueOf(this.a.b()));
        }
    }

    public interface c {
        void a();

        long b();

        void c(long j);
    }

    private static class d implements c {
        private long a;

        private d() {
        }

        @Override // g.a.a.a.c.a.c
        public void a() {
            this.a++;
        }

        @Override // g.a.a.a.c.a.c
        public long b() {
            return this.a;
        }

        @Override // g.a.a.a.c.a.c
        public void c(long j) {
            this.a += j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && this.a == ((c) obj).b();
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{Long.valueOf(this.a)});
        }

        public String toString() {
            return Long.toString(this.a);
        }
    }

    private static class e extends b {
        protected e() {
            super(a.a(), a.a(), a.a());
        }
    }

    public interface f {
        c a();

        c b();

        c c();
    }

    public static c a() {
        return new d();
    }

    public static f b() {
        return new e();
    }
}
