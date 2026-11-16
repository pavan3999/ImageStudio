package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
class p {
    final d.d.g<RecyclerView.d0, a> a = new d.d.g<>();
    final d.d.d<RecyclerView.d0> b = new d.d.d<>();

    static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static d.f.j.e<a> f480d = new d.f.j.f(20);
        int a;
        RecyclerView.l.c b;
        RecyclerView.l.c c;

        private a() {
        }

        static void a() {
            while (f480d.b() != null) {
            }
        }

        static a b() {
            a aVarB = f480d.b();
            return aVarB == null ? new a() : aVarB;
        }

        static void c(a aVar) {
            aVar.a = 0;
            aVar.b = null;
            aVar.c = null;
            f480d.a(aVar);
        }
    }

    interface b {
        void a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void b(RecyclerView.d0 d0Var);

        void c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    p() {
    }

    private RecyclerView.l.c l(RecyclerView.d0 d0Var, int i) {
        a aVarM;
        RecyclerView.l.c cVar;
        int iF = this.a.f(d0Var);
        if (iF >= 0 && (aVarM = this.a.m(iF)) != null) {
            int i2 = aVarM.a;
            if ((i2 & i) != 0) {
                aVarM.a = (i ^ (-1)) & i2;
                if (i == 4) {
                    cVar = aVarM.b;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cVar = aVarM.c;
                }
                if ((aVarM.a & 12) == 0) {
                    this.a.k(iF);
                    a.c(aVarM);
                }
                return cVar;
            }
        }
        return null;
    }

    void a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVarB = this.a.get(d0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.a.put(d0Var, aVarB);
        }
        aVarB.a |= 2;
        aVarB.b = cVar;
    }

    void b(RecyclerView.d0 d0Var) {
        a aVarB = this.a.get(d0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.a.put(d0Var, aVarB);
        }
        aVarB.a |= 1;
    }

    void c(long j, RecyclerView.d0 d0Var) {
        this.b.j(j, d0Var);
    }

    void d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVarB = this.a.get(d0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.a.put(d0Var, aVarB);
        }
        aVarB.c = cVar;
        aVarB.a |= 8;
    }

    void e(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVarB = this.a.get(d0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.a.put(d0Var, aVarB);
        }
        aVarB.b = cVar;
        aVarB.a |= 4;
    }

    void f() {
        this.a.clear();
        this.b.b();
    }

    RecyclerView.d0 g(long j) {
        return this.b.f(j);
    }

    boolean h(RecyclerView.d0 d0Var) {
        a aVar = this.a.get(d0Var);
        return (aVar == null || (aVar.a & 1) == 0) ? false : true;
    }

    boolean i(RecyclerView.d0 d0Var) {
        a aVar = this.a.get(d0Var);
        return (aVar == null || (aVar.a & 4) == 0) ? false : true;
    }

    void j() {
        a.a();
    }

    public void k(RecyclerView.d0 d0Var) {
        p(d0Var);
    }

    RecyclerView.l.c m(RecyclerView.d0 d0Var) {
        return l(d0Var, 8);
    }

    RecyclerView.l.c n(RecyclerView.d0 d0Var) {
        return l(d0Var, 4);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003a  */
    /* JADX WARN: Code duplicated, block: B:6:0x0021  */
    void o(b bVar) {
        RecyclerView.l.c cVar;
        RecyclerView.l.c cVar2;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            RecyclerView.d0 d0VarI = this.a.i(size);
            a aVarK = this.a.k(size);
            int i = aVarK.a;
            if ((i & 3) != 3) {
                if ((i & 1) != 0) {
                    cVar = aVarK.b;
                    if (cVar == null) {
                        bVar.b(d0VarI);
                    } else {
                        cVar2 = aVarK.c;
                    }
                } else if ((i & 14) == 14) {
                    bVar.d(d0VarI, aVarK.b, aVarK.c);
                } else if ((i & 12) == 12) {
                    bVar.c(d0VarI, aVarK.b, aVarK.c);
                } else if ((i & 4) != 0) {
                    cVar = aVarK.b;
                    cVar2 = null;
                } else if ((i & 8) != 0) {
                    bVar.d(d0VarI, aVarK.b, aVarK.c);
                }
                bVar.a(d0VarI, cVar, cVar2);
            } else {
                bVar.b(d0VarI);
            }
            a.c(aVarK);
        }
    }

    void p(RecyclerView.d0 d0Var) {
        a aVar = this.a.get(d0Var);
        if (aVar == null) {
            return;
        }
        aVar.a &= -2;
    }

    void q(RecyclerView.d0 d0Var) {
        for (int iM = this.b.m() - 1; iM >= 0; iM--) {
            if (d0Var == this.b.n(iM)) {
                this.b.l(iM);
                break;
            }
        }
        a aVarRemove = this.a.remove(d0Var);
        if (aVarRemove != null) {
            a.c(aVarRemove);
        }
    }
}
