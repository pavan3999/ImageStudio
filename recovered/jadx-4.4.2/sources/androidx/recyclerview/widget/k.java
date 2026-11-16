package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import d.f.k.r;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class k extends d.f.k.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final RecyclerView f473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f474e;

    public static class a extends d.f.k.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final k f475d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map<View, d.f.k.a> f476e = new WeakHashMap();

        public a(k kVar) {
            this.f475d = kVar;
        }

        @Override // d.f.k.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            d.f.k.a aVar = this.f476e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        @Override // d.f.k.a
        public d.f.k.a0.d b(View view) {
            d.f.k.a aVar = this.f476e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // d.f.k.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            d.f.k.a aVar = this.f476e.get(view);
            if (aVar != null) {
                aVar.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // d.f.k.a
        public void g(View view, d.f.k.a0.c cVar) {
            if (!this.f475d.o() && this.f475d.f473d.getLayoutManager() != null) {
                this.f475d.f473d.getLayoutManager().O0(view, cVar);
                d.f.k.a aVar = this.f476e.get(view);
                if (aVar != null) {
                    aVar.g(view, cVar);
                    return;
                }
            }
            super.g(view, cVar);
        }

        @Override // d.f.k.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            d.f.k.a aVar = this.f476e.get(view);
            if (aVar != null) {
                aVar.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // d.f.k.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            d.f.k.a aVar = this.f476e.get(viewGroup);
            return aVar != null ? aVar.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // d.f.k.a
        public boolean j(View view, int i, Bundle bundle) {
            if (this.f475d.o() || this.f475d.f473d.getLayoutManager() == null) {
                return super.j(view, i, bundle);
            }
            d.f.k.a aVar = this.f476e.get(view);
            if (aVar != null) {
                if (aVar.j(view, i, bundle)) {
                    return true;
                }
            } else if (super.j(view, i, bundle)) {
                return true;
            }
            return this.f475d.f473d.getLayoutManager().i1(view, i, bundle);
        }

        @Override // d.f.k.a
        public void l(View view, int i) {
            d.f.k.a aVar = this.f476e.get(view);
            if (aVar != null) {
                aVar.l(view, i);
            } else {
                super.l(view, i);
            }
        }

        @Override // d.f.k.a
        public void m(View view, AccessibilityEvent accessibilityEvent) {
            d.f.k.a aVar = this.f476e.get(view);
            if (aVar != null) {
                aVar.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        d.f.k.a n(View view) {
            return this.f476e.remove(view);
        }

        void o(View view) {
            d.f.k.a aVarH = r.h(view);
            if (aVarH == null || aVarH == this) {
                return;
            }
            this.f476e.put(view, aVarH);
        }
    }

    public k(RecyclerView recyclerView) {
        this.f473d = recyclerView;
        d.f.k.a aVarN = n();
        this.f474e = (aVarN == null || !(aVarN instanceof a)) ? new a(this) : (a) aVarN;
    }

    @Override // d.f.k.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().K0(accessibilityEvent);
        }
    }

    @Override // d.f.k.a
    public void g(View view, d.f.k.a0.c cVar) {
        super.g(view, cVar);
        if (o() || this.f473d.getLayoutManager() == null) {
            return;
        }
        this.f473d.getLayoutManager().M0(cVar);
    }

    @Override // d.f.k.a
    public boolean j(View view, int i, Bundle bundle) {
        if (super.j(view, i, bundle)) {
            return true;
        }
        if (o() || this.f473d.getLayoutManager() == null) {
            return false;
        }
        return this.f473d.getLayoutManager().g1(i, bundle);
    }

    public d.f.k.a n() {
        return this.f474e;
    }

    boolean o() {
        return this.f473d.hasPendingAdapterUpdates();
    }
}
