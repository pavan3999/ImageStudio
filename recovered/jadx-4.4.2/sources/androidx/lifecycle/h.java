package androidx.lifecycle;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h extends d {
    private final WeakReference<g> c;
    private d.b.a.b.a<f, b> a = new d.b.a.b.a<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f370d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f371e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f372f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList<d.b> f373g = new ArrayList<>();
    private d.b b = d.b.INITIALIZED;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[d.b.values().length];
            b = iArr;
            try {
                iArr[d.b.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[d.b.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[d.b.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[d.b.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[d.b.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[d.a.values().length];
            a = iArr2;
            try {
                iArr2[d.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[d.a.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[d.a.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[d.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[d.a.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[d.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[d.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static class b {
        d.b a;
        e b;

        b(f fVar, d.b bVar) {
            this.b = j.f(fVar);
            this.a = bVar;
        }

        void a(g gVar, d.a aVar) {
            d.b bVarH = h.h(aVar);
            this.a = h.l(this.a, bVarH);
            this.b.g(gVar, aVar);
            this.a = bVarH;
        }
    }

    public h(g gVar) {
        this.c = new WeakReference<>(gVar);
    }

    private void d(g gVar) {
        Iterator<Map.Entry<f, b>> itA = this.a.a();
        while (itA.hasNext() && !this.f372f) {
            Map.Entry<f, b> next = itA.next();
            b value = next.getValue();
            while (value.a.compareTo(this.b) > 0 && !this.f372f && this.a.contains(next.getKey())) {
                d.a aVarF = f(value.a);
                o(h(aVarF));
                value.a(gVar, aVarF);
                n();
            }
        }
    }

    private d.b e(f fVar) {
        Map.Entry<f, b> entryI = this.a.i(fVar);
        d.b bVar = null;
        d.b bVar2 = entryI != null ? entryI.getValue().a : null;
        if (!this.f373g.isEmpty()) {
            ArrayList<d.b> arrayList = this.f373g;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return l(l(this.b, bVar2), bVar);
    }

    private static d.a f(d.b bVar) {
        int i = a.b[bVar.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException();
        }
        if (i == 2) {
            return d.a.ON_DESTROY;
        }
        if (i == 3) {
            return d.a.ON_STOP;
        }
        if (i == 4) {
            return d.a.ON_PAUSE;
        }
        if (i == 5) {
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException("Unexpected state value " + bVar);
    }

    private void g(g gVar) {
        d.b.a.b.b<f, b>.d dVarD = this.a.d();
        while (dVarD.hasNext() && !this.f372f) {
            Map.Entry next = dVarD.next();
            b bVar = (b) next.getValue();
            while (bVar.a.compareTo(this.b) < 0 && !this.f372f && this.a.contains((f) next.getKey())) {
                o(bVar.a);
                bVar.a(gVar, r(bVar.a));
                n();
            }
        }
    }

    static d.b h(d.a aVar) {
        switch (a.a[aVar.ordinal()]) {
            case 1:
            case 2:
                return d.b.CREATED;
            case 3:
            case 4:
                return d.b.STARTED;
            case 5:
                return d.b.RESUMED;
            case 6:
                return d.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private boolean j() {
        if (this.a.size() == 0) {
            return true;
        }
        d.b bVar = this.a.b().getValue().a;
        d.b bVar2 = this.a.e().getValue().a;
        return bVar == bVar2 && this.b == bVar2;
    }

    static d.b l(d.b bVar, d.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    private void m(d.b bVar) {
        if (this.b == bVar) {
            return;
        }
        this.b = bVar;
        if (this.f371e || this.f370d != 0) {
            this.f372f = true;
            return;
        }
        this.f371e = true;
        q();
        this.f371e = false;
    }

    private void n() {
        ArrayList<d.b> arrayList = this.f373g;
        arrayList.remove(arrayList.size() - 1);
    }

    private void o(d.b bVar) {
        this.f373g.add(bVar);
    }

    private void q() {
        g gVar = this.c.get();
        if (gVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            boolean zJ = j();
            this.f372f = false;
            if (zJ) {
                return;
            }
            if (this.b.compareTo(this.a.b().getValue().a) < 0) {
                d(gVar);
            }
            Map.Entry<f, b> entryE = this.a.e();
            if (!this.f372f && entryE != null && this.b.compareTo(entryE.getValue().a) > 0) {
                g(gVar);
            }
        }
    }

    private static d.a r(d.b bVar) {
        int i = a.b[bVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return d.a.ON_START;
            }
            if (i == 3) {
                return d.a.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return d.a.ON_CREATE;
    }

    @Override // androidx.lifecycle.d
    public void a(f fVar) {
        g gVar;
        d.b bVar = this.b;
        d.b bVar2 = d.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = d.b.INITIALIZED;
        }
        b bVar3 = new b(fVar, bVar2);
        if (this.a.g(fVar, bVar3) == null && (gVar = this.c.get()) != null) {
            boolean z = this.f370d != 0 || this.f371e;
            d.b bVarE = e(fVar);
            this.f370d++;
            while (bVar3.a.compareTo(bVarE) < 0 && this.a.contains(fVar)) {
                o(bVar3.a);
                bVar3.a(gVar, r(bVar3.a));
                n();
                bVarE = e(fVar);
            }
            if (!z) {
                q();
            }
            this.f370d--;
        }
    }

    @Override // androidx.lifecycle.d
    public d.b b() {
        return this.b;
    }

    @Override // androidx.lifecycle.d
    public void c(f fVar) {
        this.a.h(fVar);
    }

    public void i(d.a aVar) {
        m(h(aVar));
    }

    @Deprecated
    public void k(d.b bVar) {
        p(bVar);
    }

    public void p(d.b bVar) {
        m(bVar);
    }
}
