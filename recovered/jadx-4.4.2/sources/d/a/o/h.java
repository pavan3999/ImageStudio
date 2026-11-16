package d.a.o;

import android.view.View;
import android.view.animation.Interpolator;
import d.f.k.v;
import d.f.k.w;
import d.f.k.x;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class h {
    private Interpolator c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    w f708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f709e;
    private long b = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final x f710f = new a();
    final ArrayList<v> a = new ArrayList<>();

    class a extends x {
        private boolean a = false;
        private int b = 0;

        a() {
        }

        @Override // d.f.k.w
        public void a(View view) {
            int i = this.b + 1;
            this.b = i;
            if (i == h.this.a.size()) {
                w wVar = h.this.f708d;
                if (wVar != null) {
                    wVar.a(null);
                }
                d();
            }
        }

        @Override // d.f.k.x, d.f.k.w
        public void b(View view) {
            if (this.a) {
                return;
            }
            this.a = true;
            w wVar = h.this.f708d;
            if (wVar != null) {
                wVar.b(null);
            }
        }

        void d() {
            this.b = 0;
            this.a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f709e) {
            Iterator<v> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f709e = false;
        }
    }

    void b() {
        this.f709e = false;
    }

    public h c(v vVar) {
        if (!this.f709e) {
            this.a.add(vVar);
        }
        return this;
    }

    public h d(v vVar, v vVar2) {
        this.a.add(vVar);
        vVar2.h(vVar.c());
        this.a.add(vVar2);
        return this;
    }

    public h e(long j) {
        if (!this.f709e) {
            this.b = j;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f709e) {
            this.c = interpolator;
        }
        return this;
    }

    public h g(w wVar) {
        if (!this.f709e) {
            this.f708d = wVar;
        }
        return this;
    }

    public void h() {
        if (this.f709e) {
            return;
        }
        for (v vVar : this.a) {
            long j = this.b;
            if (j >= 0) {
                vVar.d(j);
            }
            Interpolator interpolator = this.c;
            if (interpolator != null) {
                vVar.e(interpolator);
            }
            if (this.f708d != null) {
                vVar.f(this.f710f);
            }
            vVar.j();
        }
        this.f709e = true;
    }
}
