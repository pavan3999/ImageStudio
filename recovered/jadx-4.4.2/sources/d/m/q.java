package d.m;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class q extends m {
    int M;
    private ArrayList<m> K = new ArrayList<>();
    private boolean L = true;
    boolean N = false;
    private int O = 0;

    class a extends n {
        final /* synthetic */ m a;

        a(q qVar, m mVar) {
            this.a = mVar;
        }

        @Override // d.m.m.f
        public void c(m mVar) {
            this.a.T();
            mVar.P(this);
        }
    }

    static class b extends n {
        q a;

        b(q qVar) {
            this.a = qVar;
        }

        @Override // d.m.n, d.m.m.f
        public void a(m mVar) {
            q qVar = this.a;
            if (qVar.N) {
                return;
            }
            qVar.a0();
            this.a.N = true;
        }

        @Override // d.m.m.f
        public void c(m mVar) {
            q qVar = this.a;
            int i = qVar.M - 1;
            qVar.M = i;
            if (i == 0) {
                qVar.N = false;
                qVar.p();
            }
            mVar.P(this);
        }
    }

    private void f0(m mVar) {
        this.K.add(mVar);
        mVar.s = this;
    }

    private void o0() {
        b bVar = new b(this);
        Iterator<m> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.M = this.K.size();
    }

    @Override // d.m.m
    public void N(View view) {
        super.N(view);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).N(view);
        }
    }

    @Override // d.m.m
    public void R(View view) {
        super.R(view);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).R(view);
        }
    }

    @Override // d.m.m
    protected void T() {
        if (this.K.isEmpty()) {
            a0();
            p();
            return;
        }
        o0();
        if (this.L) {
            Iterator<m> it = this.K.iterator();
            while (it.hasNext()) {
                it.next().T();
            }
            return;
        }
        for (int i = 1; i < this.K.size(); i++) {
            this.K.get(i - 1).a(new a(this, this.K.get(i)));
        }
        m mVar = this.K.get(0);
        if (mVar != null) {
            mVar.T();
        }
    }

    @Override // d.m.m
    public /* bridge */ /* synthetic */ m U(long j) {
        k0(j);
        return this;
    }

    @Override // d.m.m
    public void V(m.e eVar) {
        super.V(eVar);
        this.O |= 8;
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).V(eVar);
        }
    }

    @Override // d.m.m
    public void X(g gVar) {
        super.X(gVar);
        this.O |= 4;
        if (this.K != null) {
            for (int i = 0; i < this.K.size(); i++) {
                this.K.get(i).X(gVar);
            }
        }
    }

    @Override // d.m.m
    public void Y(p pVar) {
        super.Y(pVar);
        this.O |= 2;
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).Y(pVar);
        }
    }

    @Override // d.m.m
    String b0(String str) {
        String strB0 = super.b0(str);
        for (int i = 0; i < this.K.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strB0);
            sb.append("\n");
            sb.append(this.K.get(i).b0(str + "  "));
            strB0 = sb.toString();
        }
        return strB0;
    }

    @Override // d.m.m
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public q a(m.f fVar) {
        super.a(fVar);
        return this;
    }

    @Override // d.m.m
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public q b(View view) {
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).b(view);
        }
        super.b(view);
        return this;
    }

    public q e0(m mVar) {
        f0(mVar);
        long j = this.f845d;
        if (j >= 0) {
            mVar.U(j);
        }
        if ((this.O & 1) != 0) {
            mVar.W(s());
        }
        if ((this.O & 2) != 0) {
            mVar.Y(w());
        }
        if ((this.O & 4) != 0) {
            mVar.X(v());
        }
        if ((this.O & 8) != 0) {
            mVar.V(r());
        }
        return this;
    }

    @Override // d.m.m
    protected void f() {
        super.f();
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).f();
        }
    }

    @Override // d.m.m
    public void g(s sVar) {
        if (G(sVar.b)) {
            for (m mVar : this.K) {
                if (mVar.G(sVar.b)) {
                    mVar.g(sVar);
                    sVar.c.add(mVar);
                }
            }
        }
    }

    public m g0(int i) {
        if (i < 0 || i >= this.K.size()) {
            return null;
        }
        return this.K.get(i);
    }

    public int h0() {
        return this.K.size();
    }

    @Override // d.m.m
    void i(s sVar) {
        super.i(sVar);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).i(sVar);
        }
    }

    @Override // d.m.m
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public q P(m.f fVar) {
        super.P(fVar);
        return this;
    }

    @Override // d.m.m
    public void j(s sVar) {
        if (G(sVar.b)) {
            for (m mVar : this.K) {
                if (mVar.G(sVar.b)) {
                    mVar.j(sVar);
                    sVar.c.add(mVar);
                }
            }
        }
    }

    @Override // d.m.m
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public q Q(View view) {
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).Q(view);
        }
        super.Q(view);
        return this;
    }

    public q k0(long j) {
        ArrayList<m> arrayList;
        super.U(j);
        if (this.f845d >= 0 && (arrayList = this.K) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.K.get(i).U(j);
            }
        }
        return this;
    }

    @Override // d.m.m
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public q W(TimeInterpolator timeInterpolator) {
        this.O |= 1;
        ArrayList<m> arrayList = this.K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.K.get(i).W(timeInterpolator);
            }
        }
        super.W(timeInterpolator);
        return this;
    }

    @Override // d.m.m
    /* JADX INFO: renamed from: m */
    public m clone() {
        q qVar = (q) super.clone();
        qVar.K = new ArrayList<>();
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            qVar.f0(this.K.get(i).clone());
        }
        return qVar;
    }

    public q m0(int i) {
        if (i == 0) {
            this.L = true;
        } else {
            if (i != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
            }
            this.L = false;
        }
        return this;
    }

    @Override // d.m.m
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public q Z(long j) {
        super.Z(j);
        return this;
    }

    @Override // d.m.m
    protected void o(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        long jY = y();
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.K.get(i);
            if (jY > 0 && (this.L || i == 0)) {
                long jY2 = mVar.y();
                if (jY2 > 0) {
                    mVar.Z(jY2 + jY);
                } else {
                    mVar.Z(jY);
                }
            }
            mVar.o(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }
}
