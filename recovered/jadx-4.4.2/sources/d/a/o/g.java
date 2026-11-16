package d.a.o;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.w0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class g extends MenuInflater {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Class<?>[] f701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Class<?>[] f702f;
    final Object[] a;
    final Object[] b;
    Context c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f703d;

    private static class a implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] c = {MenuItem.class};
        private Object a;
        private Method b;

        public a(Object obj, String str) {
            this.a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.b = cls.getMethod(str, c);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.b.invoke(this.a, menuItem)).booleanValue();
                }
                this.b.invoke(this.a, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private class b {
        d.f.k.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;
        private Menu a;
        private int b;
        private int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f704d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f705e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f706f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f707g;
        private boolean h;
        private int i;
        private int j;
        private CharSequence k;
        private CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public b(Menu menu) {
            this.a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i = this.v;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.z != null) {
                if (g.this.c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.z));
            }
            boolean z2 = menuItem instanceof androidx.appcompat.view.menu.i;
            if (z2) {
            }
            if (this.r >= 2) {
                if (z2) {
                    ((androidx.appcompat.view.menu.i) menuItem).t(true);
                } else if (menuItem instanceof j) {
                    ((j) menuItem).h(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f701e, g.this.a));
                z = true;
            }
            int i2 = this.w;
            if (i2 > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i2);
                }
            }
            d.f.k.b bVar = this.A;
            if (bVar != null) {
                d.f.k.g.a(menuItem, bVar);
            }
            d.f.k.g.c(menuItem, this.B);
            d.f.k.g.g(menuItem, this.C);
            d.f.k.g.b(menuItem, this.n, this.o);
            d.f.k.g.f(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                d.f.k.g.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                d.f.k.g.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.h = true;
            i(this.a.add(this.b, this.i, this.j, this.k));
        }

        public SubMenu b() {
            this.h = true;
            SubMenu subMenuAddSubMenu = this.a.addSubMenu(this.b, this.i, this.j, this.k);
            i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean d() {
            return this.h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.c.obtainStyledAttributes(attributeSet, d.a.j.MenuGroup);
            this.b = typedArrayObtainStyledAttributes.getResourceId(d.a.j.MenuGroup_android_id, 0);
            this.c = typedArrayObtainStyledAttributes.getInt(d.a.j.MenuGroup_android_menuCategory, 0);
            this.f704d = typedArrayObtainStyledAttributes.getInt(d.a.j.MenuGroup_android_orderInCategory, 0);
            this.f705e = typedArrayObtainStyledAttributes.getInt(d.a.j.MenuGroup_android_checkableBehavior, 0);
            this.f706f = typedArrayObtainStyledAttributes.getBoolean(d.a.j.MenuGroup_android_visible, true);
            this.f707g = typedArrayObtainStyledAttributes.getBoolean(d.a.j.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void g(AttributeSet attributeSet) {
            w0 w0VarT = w0.t(g.this.c, attributeSet, d.a.j.MenuItem);
            this.i = w0VarT.n(d.a.j.MenuItem_android_id, 0);
            this.j = (w0VarT.k(d.a.j.MenuItem_android_menuCategory, this.c) & (-65536)) | (w0VarT.k(d.a.j.MenuItem_android_orderInCategory, this.f704d) & 65535);
            this.k = w0VarT.p(d.a.j.MenuItem_android_title);
            this.l = w0VarT.p(d.a.j.MenuItem_android_titleCondensed);
            this.m = w0VarT.n(d.a.j.MenuItem_android_icon, 0);
            this.n = c(w0VarT.o(d.a.j.MenuItem_android_alphabeticShortcut));
            this.o = w0VarT.k(d.a.j.MenuItem_alphabeticModifiers, 4096);
            this.p = c(w0VarT.o(d.a.j.MenuItem_android_numericShortcut));
            this.q = w0VarT.k(d.a.j.MenuItem_numericModifiers, 4096);
            this.r = w0VarT.r(d.a.j.MenuItem_android_checkable) ? w0VarT.a(d.a.j.MenuItem_android_checkable, false) : this.f705e;
            this.s = w0VarT.a(d.a.j.MenuItem_android_checked, false);
            this.t = w0VarT.a(d.a.j.MenuItem_android_visible, this.f706f);
            this.u = w0VarT.a(d.a.j.MenuItem_android_enabled, this.f707g);
            this.v = w0VarT.k(d.a.j.MenuItem_showAsAction, -1);
            this.z = w0VarT.o(d.a.j.MenuItem_android_onClick);
            this.w = w0VarT.n(d.a.j.MenuItem_actionLayout, 0);
            this.x = w0VarT.o(d.a.j.MenuItem_actionViewClass);
            String strO = w0VarT.o(d.a.j.MenuItem_actionProviderClass);
            this.y = strO;
            boolean z = strO != null;
            if (z && this.w == 0 && this.x == null) {
                this.A = (d.f.k.b) e(this.y, g.f702f, g.this.b);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = w0VarT.p(d.a.j.MenuItem_contentDescription);
            this.C = w0VarT.p(d.a.j.MenuItem_tooltipText);
            if (w0VarT.r(d.a.j.MenuItem_iconTintMode)) {
                this.E = e0.e(w0VarT.k(d.a.j.MenuItem_iconTintMode, -1), this.E);
            } else {
                this.E = null;
            }
            if (w0VarT.r(d.a.j.MenuItem_iconTint)) {
                this.D = w0VarT.c(d.a.j.MenuItem_iconTint);
            } else {
                this.D = null;
            }
            w0VarT.v();
            this.h = false;
        }

        public void h() {
            this.b = 0;
            this.c = 0;
            this.f704d = 0;
            this.f705e = 0;
            this.f706f = true;
            this.f707g = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f701e = clsArr;
        f702f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.c = context;
        Object[] objArr = {context};
        this.a = objArr;
        this.b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                    break;
                }
                throw new RuntimeException("Expecting menu, got " + name);
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        str = null;
                        z2 = false;
                    } else if (name2.equals("group")) {
                        bVar.h();
                    } else if (name2.equals("item")) {
                        if (!bVar.d()) {
                            d.f.k.b bVar2 = bVar.A;
                            if (bVar2 == null || !bVar2.a()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z = true;
                    }
                }
            } else if (!z2) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z2 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    Object b() {
        if (this.f703d == null) {
            this.f703d = a(this.c);
        }
        return this.f703d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof d.f.e.a.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.c.getResources().getLayout(i);
                    c(layout, Xml.asAttributeSet(layout), menu);
                    if (layout != null) {
                        layout.close();
                    }
                } catch (XmlPullParserException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (IOException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } catch (Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
