package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class k implements LayoutInflater.Factory2 {
    private final m b;

    k(m mVar) {
        this.b = mVar;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (g.class.getName().equals(str)) {
            return new g(context, attributeSet, this.b);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.i.c.Fragment);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(d.i.c.Fragment_android_name);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(d.i.c.Fragment_android_id, -1);
        String string = typedArrayObtainStyledAttributes.getString(d.i.c.Fragment_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !i.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentW = resourceId != -1 ? this.b.W(resourceId) : null;
        if (fragmentW == null && string != null) {
            fragmentW = this.b.X(string);
        }
        if (fragmentW == null && id != -1) {
            fragmentW = this.b.W(id);
        }
        if (m.p0(2)) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + fragmentW);
        }
        if (fragmentW == null) {
            fragmentW = this.b.e0().a(context.getClassLoader(), attributeValue);
            fragmentW.n = true;
            fragmentW.w = resourceId != 0 ? resourceId : id;
            fragmentW.x = id;
            fragmentW.y = string;
            fragmentW.o = true;
            m mVar = this.b;
            fragmentW.s = mVar;
            j<?> jVar = mVar.o;
            fragmentW.t = jVar;
            fragmentW.m0(jVar.i(), attributeSet, fragmentW.c);
            this.b.d(fragmentW);
            this.b.z0(fragmentW);
        } else {
            if (fragmentW.o) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            fragmentW.o = true;
            j<?> jVar2 = this.b.o;
            fragmentW.t = jVar2;
            fragmentW.m0(jVar2.i(), attributeSet, fragmentW.c);
        }
        m mVar2 = this.b;
        if (mVar2.n >= 1 || !fragmentW.n) {
            this.b.z0(fragmentW);
        } else {
            mVar2.A0(fragmentW, 1);
        }
        View view2 = fragmentW.H;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragmentW.H.getTag() == null) {
                fragmentW.H.setTag(string);
            }
            return fragmentW.H;
        }
        throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
