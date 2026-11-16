package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
public abstract class w {

    class a implements Runnable {
        final /* synthetic */ int b;
        final /* synthetic */ ArrayList c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f356d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f357e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f358f;

        a(w wVar, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.b = i;
            this.c = arrayList;
            this.f356d = arrayList2;
            this.f357e = arrayList3;
            this.f358f = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < this.b; i++) {
                d.f.k.r.r0((View) this.c.get(i), (String) this.f356d.get(i));
                d.f.k.r.r0((View) this.f357e.get(i), (String) this.f358f.get(i));
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ ArrayList b;
        final /* synthetic */ Map c;

        b(w wVar, ArrayList arrayList, Map map) {
            this.b = arrayList;
            this.c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.b.get(i);
                String strB = d.f.k.r.B(view);
                if (strB != null) {
                    d.f.k.r.r0(view, w.i(this.c, strB));
                }
            }
        }
    }

    class c implements Runnable {
        final /* synthetic */ ArrayList b;
        final /* synthetic */ Map c;

        c(w wVar, ArrayList arrayList, Map map) {
            this.b = arrayList;
            this.c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.b.get(i);
                d.f.k.r.r0(view, (String) this.c.get(d.f.k.r.B(view)));
            }
        }
    }

    protected static void d(List<View> list, View view) {
        int size = list.size();
        if (h(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i = size; i < list.size(); i++) {
            View view2 = list.get(i);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (!h(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean h(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    static String i(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    protected static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object B(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    void f(ArrayList<View> arrayList, View view) {
        View view2;
        ViewGroup viewGroup;
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
                if (!d.f.k.t.a(viewGroup)) {
                    int childCount = viewGroup.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        view2 = view;
                        view2 = viewGroup;
                        f(arrayList, viewGroup.getChildAt(i));
                    }
                    view2 = view;
                    view2 = viewGroup;
                    return;
                }
            }
            view2 = view;
            view2 = viewGroup;
            view2 = view;
            arrayList.add(view2);
        }
    }

    public abstract Object g(Object obj);

    void j(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String strB = d.f.k.r.B(view);
            if (strB != null) {
                map.put(strB, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    j(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    protected void k(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    ArrayList<String> o(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(d.f.k.r.B(view));
            d.f.k.r.r0(view, null);
        }
        return arrayList2;
    }

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void r(Object obj, View view, ArrayList<View> arrayList);

    void s(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        d.f.k.p.a(viewGroup, new c(this, arrayList, map));
    }

    public abstract void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    public void w(Fragment fragment, Object obj, d.f.g.a aVar, Runnable runnable) {
        runnable.run();
    }

    void x(View view, ArrayList<View> arrayList, Map<String, String> map) {
        d.f.k.p.a(view, new b(this, arrayList, map));
    }

    void y(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String strB = d.f.k.r.B(view2);
            arrayList4.add(strB);
            if (strB != null) {
                d.f.k.r.r0(view2, null);
                String str = map.get(strB);
                for (int i2 = 0; i2 < size; i2++) {
                    if (str.equals(arrayList3.get(i2))) {
                        d.f.k.r.r0(arrayList2.get(i2), strB);
                        break;
                    }
                }
            }
        }
        d.f.k.p.a(view, new a(this, size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void z(Object obj, View view, ArrayList<View> arrayList);
}
