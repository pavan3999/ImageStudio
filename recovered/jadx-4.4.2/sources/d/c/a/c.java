package d.c.a;

import android.content.res.ColorStateList;

/* JADX INFO: loaded from: classes.dex */
class c implements f {
    c() {
    }

    private g n(e eVar) {
        return (g) eVar.d();
    }

    @Override // d.c.a.f
    public float a(e eVar) {
        return n(eVar).c();
    }

    @Override // d.c.a.f
    public float b(e eVar) {
        return n(eVar).d();
    }

    @Override // d.c.a.f
    public void c(e eVar) {
        k(eVar, a(eVar));
    }

    @Override // d.c.a.f
    public void d(e eVar, ColorStateList colorStateList) {
        n(eVar).f(colorStateList);
    }

    @Override // d.c.a.f
    public float e(e eVar) {
        return b(eVar) * 2.0f;
    }

    @Override // d.c.a.f
    public float f(e eVar) {
        return eVar.b().getElevation();
    }

    @Override // d.c.a.f
    public float g(e eVar) {
        return b(eVar) * 2.0f;
    }

    @Override // d.c.a.f
    public void h(e eVar) {
        k(eVar, a(eVar));
    }

    @Override // d.c.a.f
    public ColorStateList i(e eVar) {
        return n(eVar).b();
    }

    @Override // d.c.a.f
    public void j(e eVar, float f2) {
        eVar.b().setElevation(f2);
    }

    @Override // d.c.a.f
    public void k(e eVar, float f2) {
        n(eVar).g(f2, eVar.c(), eVar.f());
        o(eVar);
    }

    @Override // d.c.a.f
    public void l() {
    }

    @Override // d.c.a.f
    public void m(e eVar, float f2) {
        n(eVar).h(f2);
    }

    public void o(e eVar) {
        if (!eVar.c()) {
            eVar.a(0, 0, 0, 0);
            return;
        }
        float fA = a(eVar);
        float fB = b(eVar);
        int iCeil = (int) Math.ceil(h.c(fA, fB, eVar.f()));
        int iCeil2 = (int) Math.ceil(h.d(fA, fB, eVar.f()));
        eVar.a(iCeil, iCeil2, iCeil, iCeil2);
    }
}
