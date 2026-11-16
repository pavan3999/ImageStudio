package d.m;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class o {
    private static m a = new b();
    private static ThreadLocal<WeakReference<d.d.a<ViewGroup, ArrayList<m>>>> b = new ThreadLocal<>();
    static ArrayList<ViewGroup> c = new ArrayList<>();

    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        m b;
        ViewGroup c;

        /* JADX INFO: renamed from: d.m.o$a$a, reason: collision with other inner class name */
        class C0063a extends n {
            final /* synthetic */ d.d.a a;

            C0063a(d.d.a aVar) {
                this.a = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // d.m.m.f
            public void c(m mVar) {
                ((ArrayList) this.a.get(a.this.c)).remove(mVar);
                mVar.P(this);
            }
        }

        a(m mVar, ViewGroup viewGroup) {
            this.b = mVar;
            this.c = viewGroup;
        }

        private void a() {
            this.c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.c.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!o.c.remove(this.c)) {
                return true;
            }
            d.d.a<ViewGroup, ArrayList<m>> aVarB = o.b();
            ArrayList<m> arrayList = aVarB.get(this.c);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                aVarB.put(this.c, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.b);
            this.b.a(new C0063a(aVarB));
            this.b.k(this.c, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((m) it.next()).R(this.c);
                }
            }
            this.b.O(this.c);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            o.c.remove(this.c);
            ArrayList<m> arrayList = o.b().get(this.c);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().R(this.c);
                }
            }
            this.b.l(true);
        }
    }

    public static void a(ViewGroup viewGroup, m mVar) {
        if (c.contains(viewGroup) || !d.f.k.r.J(viewGroup)) {
            return;
        }
        c.add(viewGroup);
        if (mVar == null) {
            mVar = a;
        }
        m mVarClone = mVar.clone();
        d(viewGroup, mVarClone);
        l.c(viewGroup, null);
        c(viewGroup, mVarClone);
    }

    static d.d.a<ViewGroup, ArrayList<m>> b() {
        d.d.a<ViewGroup, ArrayList<m>> aVar;
        WeakReference<d.d.a<ViewGroup, ArrayList<m>>> weakReference = b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        d.d.a<ViewGroup, ArrayList<m>> aVar2 = new d.d.a<>();
        b.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    private static void c(ViewGroup viewGroup, m mVar) {
        if (mVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(mVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void d(ViewGroup viewGroup, m mVar) {
        ArrayList<m> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().N(viewGroup);
            }
        }
        if (mVar != null) {
            mVar.k(viewGroup, true);
        }
        l lVarB = l.b(viewGroup);
        if (lVarB != null) {
            lVarB.a();
        }
    }
}
