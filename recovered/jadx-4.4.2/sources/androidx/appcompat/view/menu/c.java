package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class c {
    final Context a;
    private Map<d.f.e.a.b, MenuItem> b;
    private Map<d.f.e.a.c, SubMenu> c;

    c(Context context) {
        this.a = context;
    }

    final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof d.f.e.a.b)) {
            return menuItem;
        }
        d.f.e.a.b bVar = (d.f.e.a.b) menuItem;
        if (this.b == null) {
            this.b = new d.d.a();
        }
        MenuItem menuItem2 = this.b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        j jVar = new j(this.a, bVar);
        this.b.put(bVar, jVar);
        return jVar;
    }

    final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof d.f.e.a.c)) {
            return subMenu;
        }
        d.f.e.a.c cVar = (d.f.e.a.c) subMenu;
        if (this.c == null) {
            this.c = new d.d.a();
        }
        SubMenu subMenu2 = this.c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        s sVar = new s(this.a, cVar);
        this.c.put(cVar, sVar);
        return sVar;
    }

    final void e() {
        Map<d.f.e.a.b, MenuItem> map = this.b;
        if (map != null) {
            map.clear();
        }
        Map<d.f.e.a.c, SubMenu> map2 = this.c;
        if (map2 != null) {
            map2.clear();
        }
    }

    final void f(int i) {
        Map<d.f.e.a.b, MenuItem> map = this.b;
        if (map == null) {
            return;
        }
        Iterator<d.f.e.a.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getGroupId()) {
                it.remove();
            }
        }
    }

    final void g(int i) {
        Map<d.f.e.a.b, MenuItem> map = this.b;
        if (map == null) {
            return;
        }
        Iterator<d.f.e.a.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }
}
