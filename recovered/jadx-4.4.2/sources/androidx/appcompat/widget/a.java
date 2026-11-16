package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends ViewGroup {
    protected final C0003a b;
    protected final Context c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected ActionMenuView f145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected c f146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected d.f.k.v f148g;
    private boolean h;
    private boolean i;

    /* JADX INFO: renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    protected class C0003a implements d.f.k.w {
        private boolean a = false;
        int b;

        protected C0003a() {
        }

        @Override // d.f.k.w
        public void a(View view) {
            if (this.a) {
                return;
            }
            a aVar = a.this;
            aVar.f148g = null;
            a.super.setVisibility(this.b);
        }

        @Override // d.f.k.w
        public void b(View view) {
            a.super.setVisibility(0);
            this.a = false;
        }

        @Override // d.f.k.w
        public void c(View view) {
            this.a = true;
        }

        public C0003a d(d.f.k.v vVar, int i) {
            a.this.f148g = vVar;
            this.b = i;
            return this;
        }
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new C0003a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(d.a.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.c = context;
        } else {
            this.c = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int d(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected int c(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, RecyclerView.UNDEFINED_DURATION), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected int e(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public d.f.k.v f(int i, long j) {
        d.f.k.v vVar = this.f148g;
        if (vVar != null) {
            vVar.b();
        }
        if (i != 0) {
            d.f.k.v vVarC = d.f.k.r.c(this);
            vVarC.a(0.0f);
            vVarC.d(j);
            C0003a c0003a = this.b;
            c0003a.d(vVarC, i);
            vVarC.f(c0003a);
            return vVarC;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        d.f.k.v vVarC2 = d.f.k.r.c(this);
        vVarC2.a(1.0f);
        vVarC2.d(j);
        C0003a c0003a2 = this.b;
        c0003a2.d(vVarC2, i);
        vVarC2.f(c0003a2);
        return vVarC2;
    }

    public int getAnimatedVisibility() {
        return this.f148g != null ? this.b.b : getVisibility();
    }

    public int getContentHeight() {
        return this.f147f;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, d.a.j.ActionBar, d.a.a.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(d.a.j.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        c cVar = this.f146e;
        if (cVar != null) {
            cVar.E(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.i = false;
        }
        if (!this.i) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.i = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.i = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.h = false;
        }
        if (!this.h) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            d.f.k.v vVar = this.f148g;
            if (vVar != null) {
                vVar.b();
            }
            super.setVisibility(i);
        }
    }
}
