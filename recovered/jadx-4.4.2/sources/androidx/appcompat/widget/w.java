package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class w extends Spinner implements d.f.k.q {
    private static final int[] j = {R.attr.spinnerMode};
    private final androidx.appcompat.widget.e b;
    private final Context c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h0 f218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SpinnerAdapter f219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f220f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private g f221g;
    int h;
    final Rect i;

    class a extends h0 {
        final /* synthetic */ e k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, e eVar) {
            super(view);
            this.k = eVar;
        }

        @Override // androidx.appcompat.widget.h0
        public androidx.appcompat.view.menu.p b() {
            return this.k;
        }

        @Override // androidx.appcompat.widget.h0
        @SuppressLint({"SyntheticAccessor"})
        public boolean c() {
            if (w.this.getInternalPopup().a()) {
                return true;
            }
            w.this.b();
            return true;
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!w.this.getInternalPopup().a()) {
                w.this.b();
            }
            ViewTreeObserver viewTreeObserver = w.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        }
    }

    class c implements g, DialogInterface.OnClickListener {
        androidx.appcompat.app.b b;
        private ListAdapter c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f222d;

        c() {
        }

        @Override // androidx.appcompat.widget.w.g
        public boolean a() {
            androidx.appcompat.app.b bVar = this.b;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.w.g
        public void c(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.w.g
        public CharSequence d() {
            return this.f222d;
        }

        @Override // androidx.appcompat.widget.w.g
        public void dismiss() {
            androidx.appcompat.app.b bVar = this.b;
            if (bVar != null) {
                bVar.dismiss();
                this.b = null;
            }
        }

        @Override // androidx.appcompat.widget.w.g
        public void e(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.w.g
        public int f() {
            return 0;
        }

        @Override // androidx.appcompat.widget.w.g
        public void h(int i, int i2) {
            if (this.c == null) {
                return;
            }
            androidx.appcompat.app.b.a aVar = new androidx.appcompat.app.b.a(w.this.getPopupContext());
            CharSequence charSequence = this.f222d;
            if (charSequence != null) {
                aVar.m(charSequence);
            }
            aVar.l(this.c, w.this.getSelectedItemPosition(), this);
            androidx.appcompat.app.b bVarA = aVar.a();
            this.b = bVarA;
            ListView listViewF = bVarA.f();
            if (Build.VERSION.SDK_INT >= 17) {
                listViewF.setTextDirection(i);
                listViewF.setTextAlignment(i2);
            }
            this.b.show();
        }

        @Override // androidx.appcompat.widget.w.g
        public void j(CharSequence charSequence) {
            this.f222d = charSequence;
        }

        @Override // androidx.appcompat.widget.w.g
        public int k() {
            return 0;
        }

        @Override // androidx.appcompat.widget.w.g
        public void m(int i) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.w.g
        public Drawable n() {
            return null;
        }

        @Override // androidx.appcompat.widget.w.g
        public void o(ListAdapter listAdapter) {
            this.c = listAdapter;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            w.this.setSelection(i);
            if (w.this.getOnItemClickListener() != null) {
                w.this.performItemClick(null, i, this.c.getItemId(i));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.w.g
        public void p(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }
    }

    private static class d implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter b;
        private ListAdapter c;

        public d(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.b = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.c = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof s0) {
                    s0 s0Var = (s0) spinnerAdapter;
                    if (s0Var.getDropDownViewTheme() == null) {
                        s0Var.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.c;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.b;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.c;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    class e extends j0 implements g {
        private CharSequence J;
        ListAdapter K;
        private final Rect L;
        private int M;

        class a implements AdapterView.OnItemClickListener {
            a(w wVar) {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                w.this.setSelection(i);
                if (w.this.getOnItemClickListener() != null) {
                    e eVar = e.this;
                    w.this.performItemClick(view, i, eVar.K.getItemId(i));
                }
                e.this.dismiss();
            }
        }

        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                e eVar = e.this;
                if (!eVar.Q(w.this)) {
                    e.this.dismiss();
                } else {
                    e.this.O();
                    e.super.b();
                }
            }
        }

        class c implements PopupWindow.OnDismissListener {
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener b;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.b = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = w.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.b);
                }
            }
        }

        public e(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.L = new Rect();
            z(w.this);
            F(true);
            K(0);
            H(new a(w.this));
        }

        /* JADX WARN: Code duplicated, block: B:23:0x008d  */
        /* JADX WARN: Code duplicated, block: B:24:0x009a  */
        void O() {
            int iMax;
            int iP;
            Drawable drawableN = n();
            int i = 0;
            if (drawableN != null) {
                drawableN.getPadding(w.this.i);
                i = c1.b(w.this) ? w.this.i.right : -w.this.i.left;
            } else {
                Rect rect = w.this.i;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = w.this.getPaddingLeft();
            int paddingRight = w.this.getPaddingRight();
            int width = w.this.getWidth();
            w wVar = w.this;
            int i2 = wVar.h;
            if (i2 != -2) {
                if (i2 == -1) {
                    iMax = (width - paddingLeft) - paddingRight;
                } else {
                    B(i2);
                }
                if (c1.b(w.this)) {
                    iP = i + (((width - paddingRight) - v()) - P());
                } else {
                    iP = i + paddingLeft + P();
                }
                e(iP);
            }
            int iA = wVar.a((SpinnerAdapter) this.K, n());
            int i3 = w.this.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = w.this.i;
            int i4 = (i3 - rect2.left) - rect2.right;
            if (iA > i4) {
                iA = i4;
            }
            iMax = Math.max(iA, (width - paddingLeft) - paddingRight);
            B(iMax);
            if (c1.b(w.this)) {
                iP = i + (((width - paddingRight) - v()) - P());
            } else {
                iP = i + paddingLeft + P();
            }
            e(iP);
        }

        public int P() {
            return this.M;
        }

        boolean Q(View view) {
            return d.f.k.r.I(view) && view.getGlobalVisibleRect(this.L);
        }

        @Override // androidx.appcompat.widget.w.g
        public CharSequence d() {
            return this.J;
        }

        @Override // androidx.appcompat.widget.w.g
        public void h(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean zA = a();
            O();
            E(2);
            super.b();
            ListView listViewG = g();
            listViewG.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                listViewG.setTextDirection(i);
                listViewG.setTextAlignment(i2);
            }
            L(w.this.getSelectedItemPosition());
            if (zA || (viewTreeObserver = w.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            G(new c(bVar));
        }

        @Override // androidx.appcompat.widget.w.g
        public void j(CharSequence charSequence) {
            this.J = charSequence;
        }

        @Override // androidx.appcompat.widget.j0, androidx.appcompat.widget.w.g
        public void o(ListAdapter listAdapter) {
            super.o(listAdapter);
            this.K = listAdapter;
        }

        @Override // androidx.appcompat.widget.w.g
        public void p(int i) {
            this.M = i;
        }
    }

    static class f extends View.BaseSavedState {
        public static final Parcelable.Creator<f> CREATOR = new a();
        boolean b;

        static class a implements Parcelable.Creator<f> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i) {
                return new f[i];
            }
        }

        f(Parcel parcel) {
            super(parcel);
            this.b = parcel.readByte() != 0;
        }

        f(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        }
    }

    interface g {
        boolean a();

        void c(Drawable drawable);

        CharSequence d();

        void dismiss();

        void e(int i);

        int f();

        void h(int i, int i2);

        void j(CharSequence charSequence);

        int k();

        void m(int i);

        Drawable n();

        void o(ListAdapter listAdapter);

        void p(int i);
    }

    public w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.a.spinnerStyle);
    }

    public w(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public w(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0042 A[Catch: Exception -> 0x004c, all -> 0x005c, TRY_LEAVE, TryCatch #1 {Exception -> 0x004c, blocks: (B:13:0x003c, B:15:0x0042), top: B:46:0x003c }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0048 A[PHI: r10 r11
      0x0048: PHI (r10v2 int) = (r10v0 int), (r10v4 int) binds: [B:25:0x0059, B:16:0x0046] A[DONT_GENERATE, DONT_INLINE]
      0x0048: PHI (r11v7 android.content.res.TypedArray) = (r11v6 android.content.res.TypedArray), (r11v9 android.content.res.TypedArray) binds: [B:25:0x0059, B:16:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x0060  */
    /* JADX WARN: Code duplicated, block: B:34:0x0067 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:49:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public w(Context context, AttributeSet attributeSet, int i, int i2, Resources.Theme theme) throws Throwable {
        d.a.o.d dVar;
        TypedArray typedArrayObtainStyledAttributes;
        CharSequence[] charSequenceArrQ;
        SpinnerAdapter spinnerAdapter;
        super(context, attributeSet, i);
        this.i = new Rect();
        w0 w0VarU = w0.u(context, attributeSet, d.a.j.Spinner, i, 0);
        this.b = new androidx.appcompat.widget.e(this);
        if (theme == null) {
            int iN = w0VarU.n(d.a.j.Spinner_popupTheme, 0);
            if (iN != 0) {
                dVar = new d.a.o.d(context, iN);
            } else {
                this.c = context;
            }
            TypedArray typedArray = null;
            if (i2 == -1) {
                try {
                    typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j, i, 0);
                    try {
                        try {
                            i2 = typedArrayObtainStyledAttributes.hasValue(0) ? typedArrayObtainStyledAttributes.getInt(0, 0) : i2;
                            if (typedArrayObtainStyledAttributes != null) {
                                typedArrayObtainStyledAttributes.recycle();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                            if (typedArrayObtainStyledAttributes != null) {
                                typedArrayObtainStyledAttributes.recycle();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        typedArray = typedArrayObtainStyledAttributes;
                        if (typedArray != null) {
                            typedArray.recycle();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    typedArrayObtainStyledAttributes = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (typedArray != null) {
                        typedArray.recycle();
                    }
                    throw th;
                }
            }
            if (i2 != 0) {
                c cVar = new c();
                this.f221g = cVar;
                cVar.j(w0VarU.o(d.a.j.Spinner_android_prompt));
            } else if (i2 == 1) {
                e eVar = new e(this.c, attributeSet, i);
                w0 w0VarU2 = w0.u(this.c, attributeSet, d.a.j.Spinner, i, 0);
                this.h = w0VarU2.m(d.a.j.Spinner_android_dropDownWidth, -2);
                eVar.c(w0VarU2.g(d.a.j.Spinner_android_popupBackground));
                eVar.j(w0VarU.o(d.a.j.Spinner_android_prompt));
                w0VarU2.v();
                this.f221g = eVar;
                this.f218d = new a(this, eVar);
            }
            charSequenceArrQ = w0VarU.q(d.a.j.Spinner_android_entries);
            if (charSequenceArrQ != null) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, charSequenceArrQ);
                arrayAdapter.setDropDownViewResource(d.a.g.support_simple_spinner_dropdown_item);
                setAdapter((SpinnerAdapter) arrayAdapter);
            }
            w0VarU.v();
            this.f220f = true;
            spinnerAdapter = this.f219e;
            if (spinnerAdapter != null) {
                setAdapter(spinnerAdapter);
                this.f219e = null;
            }
            this.b.e(attributeSet, i);
        }
        dVar = new d.a.o.d(context, theme);
        this.c = dVar;
        TypedArray typedArray2 = null;
        if (i2 == -1) {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j, i, 0);
            if (typedArrayObtainStyledAttributes.hasValue(0)) {
            }
            if (typedArrayObtainStyledAttributes != null) {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        if (i2 != 0) {
            c cVar2 = new c();
            this.f221g = cVar2;
            cVar2.j(w0VarU.o(d.a.j.Spinner_android_prompt));
        } else if (i2 == 1) {
            e eVar2 = new e(this.c, attributeSet, i);
            w0 w0VarU3 = w0.u(this.c, attributeSet, d.a.j.Spinner, i, 0);
            this.h = w0VarU3.m(d.a.j.Spinner_android_dropDownWidth, -2);
            eVar2.c(w0VarU3.g(d.a.j.Spinner_android_popupBackground));
            eVar2.j(w0VarU.o(d.a.j.Spinner_android_prompt));
            w0VarU3.v();
            this.f221g = eVar2;
            this.f218d = new a(this, eVar2);
        }
        charSequenceArrQ = w0VarU.q(d.a.j.Spinner_android_entries);
        if (charSequenceArrQ != null) {
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(context, R.layout.simple_spinner_item, charSequenceArrQ);
            arrayAdapter2.setDropDownViewResource(d.a.g.support_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter2);
        }
        w0VarU.v();
        this.f220f = true;
        spinnerAdapter = this.f219e;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.f219e = null;
        }
        this.b.e(attributeSet, i);
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.i);
        Rect rect = this.i;
        return iMax2 + rect.left + rect.right;
    }

    void b() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f221g.h(getTextDirection(), getTextAlignment());
        } else {
            this.f221g.h(-1, -1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.e eVar = this.b;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        g gVar = this.f221g;
        if (gVar != null) {
            return gVar.f();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        g gVar = this.f221g;
        if (gVar != null) {
            return gVar.k();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f221g != null) {
            return this.h;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    final g getInternalPopup() {
        return this.f221g;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        g gVar = this.f221g;
        if (gVar != null) {
            return gVar.n();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.c;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        g gVar = this.f221g;
        return gVar != null ? gVar.d() : super.getPrompt();
    }

    @Override // d.f.k.q
    public ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.e eVar = this.b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // d.f.k.q
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.e eVar = this.b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.f221g;
        if (gVar == null || !gVar.a()) {
            return;
        }
        this.f221g.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f221g == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        if (!fVar.b || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        g gVar = this.f221g;
        fVar.b = gVar != null && gVar.a();
        return fVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        h0 h0Var = this.f218d;
        if (h0Var == null || !h0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        g gVar = this.f221g;
        if (gVar == null) {
            return super.performClick();
        }
        if (gVar.a()) {
            return true;
        }
        b();
        return true;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f220f) {
            this.f219e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f221g != null) {
            Context context = this.c;
            if (context == null) {
                context = getContext();
            }
            this.f221g.o(new d(spinnerAdapter, context.getTheme()));
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.e eVar = this.b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        androidx.appcompat.widget.e eVar = this.b;
        if (eVar != null) {
            eVar.g(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        g gVar = this.f221g;
        if (gVar != null) {
            gVar.p(i);
            this.f221g.e(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        g gVar = this.f221g;
        if (gVar != null) {
            gVar.m(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.f221g != null) {
            this.h = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        g gVar = this.f221g;
        if (gVar != null) {
            gVar.c(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(d.a.k.a.a.d(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        g gVar = this.f221g;
        if (gVar != null) {
            gVar.j(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // d.f.k.q
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        androidx.appcompat.widget.e eVar = this.b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // d.f.k.q
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        androidx.appcompat.widget.e eVar = this.b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }
}
