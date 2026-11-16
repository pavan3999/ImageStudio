package androidx.lifecycle;

import androidx.savedstate.SavedStateRegistry;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class SavedStateHandleController implements e {
    private boolean a;
    private final p b;

    /* JADX INFO: renamed from: androidx.lifecycle.SavedStateHandleController$1, reason: invalid class name */
    final class AnonymousClass1 implements e {
        final /* synthetic */ d a;
        final /* synthetic */ SavedStateRegistry b;

        @Override // androidx.lifecycle.e
        public void g(g gVar, d.a aVar) {
            if (aVar == d.a.ON_START) {
                this.a.c(this);
                this.b.e(a.class);
            }
        }
    }

    static final class a implements SavedStateRegistry.a {
        a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.a
        public void a(androidx.savedstate.b bVar) {
            if (!(bVar instanceof t)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
            }
            s sVarF = ((t) bVar).f();
            SavedStateRegistry savedStateRegistryE = bVar.e();
            Iterator<String> it = sVarF.c().iterator();
            while (it.hasNext()) {
                SavedStateHandleController.h(sVarF.b(it.next()), savedStateRegistryE, bVar.a());
            }
            if (sVarF.c().isEmpty()) {
                return;
            }
            savedStateRegistryE.e(a.class);
        }
    }

    static void h(q qVar, SavedStateRegistry savedStateRegistry, d dVar) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) qVar.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.j()) {
            return;
        }
        savedStateHandleController.i(savedStateRegistry, dVar);
        throw null;
    }

    @Override // androidx.lifecycle.e
    public void g(g gVar, d.a aVar) {
        if (aVar == d.a.ON_DESTROY) {
            this.a = false;
            gVar.a().c(this);
        }
    }

    void i(SavedStateRegistry savedStateRegistry, d dVar) {
        if (this.a) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.a = true;
        dVar.a(this);
        this.b.a();
        throw null;
    }

    boolean j() {
        return this.a;
    }
}
