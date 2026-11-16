package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;

/* JADX INFO: loaded from: classes.dex */
class FragmentStateAdapter$5 implements e {
    final /* synthetic */ Handler a;
    final /* synthetic */ Runnable b;

    @Override // androidx.lifecycle.e
    public void g(g gVar, d.a aVar) {
        if (aVar == d.a.ON_DESTROY) {
            this.a.removeCallbacks(this.b);
            gVar.a().c(this);
        }
    }
}
