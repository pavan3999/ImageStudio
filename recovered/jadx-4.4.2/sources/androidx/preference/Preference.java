package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.c.g;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    private Context b;
    private androidx.preference.b c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private androidx.preference.a f374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CharSequence f377g;
    private CharSequence h;
    private String i;
    private String j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private a q;
    private List<Preference> r;
    private c s;

    interface a {
        void a(Preference preference);
    }

    public interface b {
        boolean a(Preference preference, Object obj);
    }

    public interface c<T extends Preference> {
        CharSequence a(T t);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, androidx.preference.c.preferenceStyle, R.attr.preferenceStyle));
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x00c2  */
    public Preference(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean zHasValue;
        int i3;
        this.f376f = Integer.MAX_VALUE;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = true;
        this.b = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.Preference, i, i2);
        g.n(typedArrayObtainStyledAttributes, f.Preference_icon, f.Preference_android_icon, 0);
        this.i = g.o(typedArrayObtainStyledAttributes, f.Preference_key, f.Preference_android_key);
        this.f377g = g.p(typedArrayObtainStyledAttributes, f.Preference_title, f.Preference_android_title);
        this.h = g.p(typedArrayObtainStyledAttributes, f.Preference_summary, f.Preference_android_summary);
        this.f376f = g.d(typedArrayObtainStyledAttributes, f.Preference_order, f.Preference_android_order, Integer.MAX_VALUE);
        this.j = g.o(typedArrayObtainStyledAttributes, f.Preference_fragment, f.Preference_android_fragment);
        g.n(typedArrayObtainStyledAttributes, f.Preference_layout, f.Preference_android_layout, d.preference);
        g.n(typedArrayObtainStyledAttributes, f.Preference_widgetLayout, f.Preference_android_widgetLayout, 0);
        this.k = g.b(typedArrayObtainStyledAttributes, f.Preference_enabled, f.Preference_android_enabled, true);
        this.l = g.b(typedArrayObtainStyledAttributes, f.Preference_selectable, f.Preference_android_selectable, true);
        this.m = g.b(typedArrayObtainStyledAttributes, f.Preference_persistent, f.Preference_android_persistent, true);
        g.o(typedArrayObtainStyledAttributes, f.Preference_dependency, f.Preference_android_dependency);
        int i4 = f.Preference_allowDividerAbove;
        g.b(typedArrayObtainStyledAttributes, i4, i4, this.l);
        int i5 = f.Preference_allowDividerBelow;
        g.b(typedArrayObtainStyledAttributes, i5, i5, this.l);
        if (!typedArrayObtainStyledAttributes.hasValue(f.Preference_defaultValue)) {
            i3 = typedArrayObtainStyledAttributes.hasValue(f.Preference_android_defaultValue) ? f.Preference_android_defaultValue : i3;
            g.b(typedArrayObtainStyledAttributes, f.Preference_shouldDisableView, f.Preference_android_shouldDisableView, true);
            zHasValue = typedArrayObtainStyledAttributes.hasValue(f.Preference_singleLineTitle);
            this.p = zHasValue;
            if (zHasValue) {
                g.b(typedArrayObtainStyledAttributes, f.Preference_singleLineTitle, f.Preference_android_singleLineTitle, true);
            }
            g.b(typedArrayObtainStyledAttributes, f.Preference_iconSpaceReserved, f.Preference_android_iconSpaceReserved, false);
            int i6 = f.Preference_isPreferenceVisible;
            g.b(typedArrayObtainStyledAttributes, i6, i6, true);
            int i7 = f.Preference_enableCopying;
            g.b(typedArrayObtainStyledAttributes, i7, i7, false);
            typedArrayObtainStyledAttributes.recycle();
        }
        i3 = f.Preference_defaultValue;
        p(typedArrayObtainStyledAttributes, i3);
        g.b(typedArrayObtainStyledAttributes, f.Preference_shouldDisableView, f.Preference_android_shouldDisableView, true);
        zHasValue = typedArrayObtainStyledAttributes.hasValue(f.Preference_singleLineTitle);
        this.p = zHasValue;
        if (zHasValue) {
            g.b(typedArrayObtainStyledAttributes, f.Preference_singleLineTitle, f.Preference_android_singleLineTitle, true);
        }
        g.b(typedArrayObtainStyledAttributes, f.Preference_iconSpaceReserved, f.Preference_android_iconSpaceReserved, false);
        int i8 = f.Preference_isPreferenceVisible;
        g.b(typedArrayObtainStyledAttributes, i8, i8, true);
        int i9 = f.Preference_enableCopying;
        g.b(typedArrayObtainStyledAttributes, i9, i9, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public boolean a(Object obj) {
        b bVar = this.f375e;
        return bVar == null || bVar.a(this, obj);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(Preference preference) {
        int i = this.f376f;
        int i2 = preference.f376f;
        if (i != i2) {
            return i - i2;
        }
        CharSequence charSequence = this.f377g;
        CharSequence charSequence2 = preference.f377g;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.f377g.toString());
    }

    public Context c() {
        return this.b;
    }

    StringBuilder d() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequenceI = i();
        if (!TextUtils.isEmpty(charSequenceI)) {
            sb.append(charSequenceI);
            sb.append(' ');
        }
        CharSequence charSequenceG = g();
        if (!TextUtils.isEmpty(charSequenceG)) {
            sb.append(charSequenceG);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    protected boolean e(boolean z) {
        if (!u()) {
            return z;
        }
        androidx.preference.a aVarF = f();
        if (aVarF != null) {
            return aVarF.a(this.i, z);
        }
        this.c.f();
        throw null;
    }

    public androidx.preference.a f() {
        androidx.preference.a aVar = this.f374d;
        if (aVar != null) {
            return aVar;
        }
        androidx.preference.b bVar = this.c;
        if (bVar == null) {
            return null;
        }
        bVar.e();
        throw null;
    }

    public CharSequence g() {
        return h() != null ? h().a(this) : this.h;
    }

    public final c h() {
        return this.s;
    }

    public CharSequence i() {
        return this.f377g;
    }

    public boolean j() {
        return !TextUtils.isEmpty(this.i);
    }

    public boolean k() {
        return this.k && this.n && this.o;
    }

    public boolean l() {
        return this.m;
    }

    protected void m() {
        a aVar = this.q;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void n(boolean z) {
        List<Preference> list = this.r;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).o(this, z);
        }
    }

    public void o(Preference preference, boolean z) {
        if (this.n == z) {
            this.n = !z;
            n(t());
            m();
        }
    }

    protected Object p(TypedArray typedArray, int i) {
        return null;
    }

    public void q(Preference preference, boolean z) {
        if (this.o == z) {
            this.o = !z;
            n(t());
            m();
        }
    }

    protected boolean r(boolean z) {
        if (!u()) {
            return false;
        }
        if (z == e(!z)) {
            return true;
        }
        androidx.preference.a aVarF = f();
        if (aVarF != null) {
            aVarF.b(this.i, z);
            return true;
        }
        this.c.d();
        throw null;
    }

    public final void s(c cVar) {
        this.s = cVar;
        m();
    }

    public boolean t() {
        return !k();
    }

    public String toString() {
        return d().toString();
    }

    protected boolean u() {
        return this.c != null && l() && j();
    }
}
