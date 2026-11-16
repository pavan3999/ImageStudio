package androidx.fragment.app;

import android.view.ViewGroup;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class t {
    int b;
    int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f328e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f329f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f330g;
    String h;
    int i;
    CharSequence j;
    int k;
    CharSequence l;
    ArrayList<String> m;
    ArrayList<String> n;
    ArrayList<Runnable> p;
    ArrayList<a> a = new ArrayList<>();
    boolean o = false;

    static final class a {
        int a;
        Fragment b;
        int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f331d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f332e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f333f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        androidx.lifecycle.d.b f334g;
        androidx.lifecycle.d.b h;

        a() {
        }

        a(int i, Fragment fragment) {
            this.a = i;
            this.b = fragment;
            androidx.lifecycle.d.b bVar = androidx.lifecycle.d.b.RESUMED;
            this.f334g = bVar;
            this.h = bVar;
        }
    }

    t(i iVar, ClassLoader classLoader) {
    }

    public t b(int i, Fragment fragment, String str) {
        k(i, fragment, str, 1);
        return this;
    }

    t c(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.G = viewGroup;
        b(viewGroup.getId(), fragment, str);
        return this;
    }

    public t d(Fragment fragment, String str) {
        k(0, fragment, str, 1);
        return this;
    }

    void e(a aVar) {
        this.a.add(aVar);
        aVar.c = this.b;
        aVar.f331d = this.c;
        aVar.f332e = this.f327d;
        aVar.f333f = this.f328e;
    }

    public abstract int f();

    public abstract int g();

    public abstract void h();

    public abstract void i();

    public t j() {
        if (this.f330g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        return this;
    }

    void k(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.y;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.y + " now " + str);
            }
            fragment.y = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i3 = fragment.w;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.w + " now " + i);
            }
            fragment.w = i;
            fragment.x = i;
        }
        e(new a(i2, fragment));
    }

    public t l(Fragment fragment) {
        e(new a(3, fragment));
        return this;
    }

    public t m(int i, Fragment fragment) {
        n(i, fragment, null);
        return this;
    }

    public t n(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        k(i, fragment, str, 2);
        return this;
    }

    public t o(boolean z) {
        this.o = z;
        return this;
    }
}
