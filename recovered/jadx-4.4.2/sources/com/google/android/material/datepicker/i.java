package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.t;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class i<S> extends androidx.fragment.app.c {
    static final Object B0 = "CONFIRM_BUTTON_TAG";
    static final Object C0 = "CANCEL_BUTTON_TAG";
    static final Object D0 = "TOGGLE_BUTTON_TAG";
    private Button A0;
    private final LinkedHashSet<j<? super S>> l0 = new LinkedHashSet<>();
    private final LinkedHashSet<View.OnClickListener> m0 = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnCancelListener> n0 = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnDismissListener> o0 = new LinkedHashSet<>();
    private int p0;
    private com.google.android.material.datepicker.d<S> q0;
    private p<S> r0;
    private com.google.android.material.datepicker.a s0;
    private h<S> t0;
    private int u0;
    private CharSequence v0;
    private boolean w0;
    private TextView x0;
    private CheckableImageButton y0;
    private e.a.a.a.a0.g z0;

    class a implements View.OnClickListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = i.this.l0.iterator();
            while (it.hasNext()) {
                ((j) it.next()).a(i.this.I1());
            }
            i.this.o1();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = i.this.m0.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            i.this.o1();
        }
    }

    class c implements o<S> {
        c() {
        }

        @Override // com.google.android.material.datepicker.o
        public void a(S s) {
            Button button;
            boolean z;
            i.this.O1();
            if (i.this.q0.b()) {
                button = i.this.A0;
                z = true;
            } else {
                button = i.this.A0;
                z = false;
            }
            button.setEnabled(z);
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.y0.toggle();
            i iVar = i.this;
            iVar.P1(iVar.y0);
            i.this.M1();
        }
    }

    private static Drawable E1(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, d.a.k.a.a.d(context, e.a.a.a.e.ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], d.a.k.a.a.d(context, e.a.a.a.e.ic_edit_black_24dp));
        return stateListDrawable;
    }

    private static int F1(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(e.a.a.a.d.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(e.a.a.a.d.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(e.a.a.a.d.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelSize(e.a.a.a.d.mtrl_calendar_days_of_week_height) + (m.f591f * resources.getDimensionPixelSize(e.a.a.a.d.mtrl_calendar_day_height)) + ((m.f591f - 1) * resources.getDimensionPixelOffset(e.a.a.a.d.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(e.a.a.a.d.mtrl_calendar_bottom_padding);
    }

    private static int H1(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(e.a.a.a.d.mtrl_calendar_content_padding);
        int i = l.s().f589f;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(e.a.a.a.d.mtrl_calendar_day_width) * i) + ((i - 1) * resources.getDimensionPixelOffset(e.a.a.a.d.mtrl_calendar_month_horizontal_padding));
    }

    private int J1(Context context) {
        int i = this.p0;
        return i != 0 ? i : this.q0.f(context);
    }

    private void K1(Context context) {
        this.y0.setTag(D0);
        this.y0.setImageDrawable(E1(context));
        d.f.k.r.c0(this.y0, null);
        P1(this.y0);
        this.y0.setOnClickListener(new d());
    }

    static boolean L1(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(e.a.a.a.x.b.c(context, e.a.a.a.b.materialCalendarStyle, h.class.getCanonicalName()), new int[]{R.attr.windowFullscreen});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M1() {
        this.t0 = h.D1(this.q0, J1(Z0()), this.s0);
        this.r0 = this.y0.isChecked() ? k.o1(this.q0, this.s0) : this.t0;
        O1();
        t tVarI = o().i();
        tVarI.m(e.a.a.a.f.mtrl_calendar_frame, this.r0);
        tVarI.h();
        this.r0.m1(new c());
    }

    public static long N1() {
        return l.s().h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1() {
        String strG1 = G1();
        this.x0.setContentDescription(String.format(H(e.a.a.a.i.mtrl_picker_announce_current_selection), strG1));
        this.x0.setText(strG1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P1(CheckableImageButton checkableImageButton) {
        this.y0.setContentDescription(checkableImageButton.getContext().getString(this.y0.isChecked() ? e.a.a.a.i.mtrl_picker_toggle_to_calendar_input_mode : e.a.a.a.i.mtrl_picker_toggle_to_text_input_mode));
    }

    public String G1() {
        return this.q0.d(p());
    }

    public final S I1() {
        return this.q0.a();
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public final void a0(Bundle bundle) {
        super.a0(bundle);
        if (bundle == null) {
            bundle = n();
        }
        this.p0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.q0 = (com.google.android.material.datepicker.d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.s0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.u0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.v0 = bundle.getCharSequence("TITLE_TEXT_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View e0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.w0 ? e.a.a.a.h.mtrl_picker_fullscreen : e.a.a.a.h.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.w0) {
            viewInflate.findViewById(e.a.a.a.f.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(H1(context), -2));
        } else {
            View viewFindViewById = viewInflate.findViewById(e.a.a.a.f.mtrl_calendar_main_pane);
            View viewFindViewById2 = viewInflate.findViewById(e.a.a.a.f.mtrl_calendar_frame);
            viewFindViewById.setLayoutParams(new LinearLayout.LayoutParams(H1(context), -1));
            viewFindViewById2.setMinimumHeight(F1(Z0()));
        }
        TextView textView = (TextView) viewInflate.findViewById(e.a.a.a.f.mtrl_picker_header_selection_text);
        this.x0 = textView;
        d.f.k.r.e0(textView, 1);
        this.y0 = (CheckableImageButton) viewInflate.findViewById(e.a.a.a.f.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) viewInflate.findViewById(e.a.a.a.f.mtrl_picker_title_text);
        CharSequence charSequence = this.v0;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.u0);
        }
        K1(context);
        this.A0 = (Button) viewInflate.findViewById(e.a.a.a.f.confirm_button);
        if (this.q0.b()) {
            this.A0.setEnabled(true);
        } else {
            this.A0.setEnabled(false);
        }
        this.A0.setTag(B0);
        this.A0.setOnClickListener(new a());
        Button button = (Button) viewInflate.findViewById(e.a.a.a.f.cancel_button);
        button.setTag(C0);
        button.setOnClickListener(new b());
        return viewInflate;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.n0.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.o0.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) J();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.c
    public final Dialog s1(Bundle bundle) {
        Dialog dialog = new Dialog(Z0(), J1(Z0()));
        Context context = dialog.getContext();
        this.w0 = L1(context);
        int iC = e.a.a.a.x.b.c(context, e.a.a.a.b.colorSurface, i.class.getCanonicalName());
        e.a.a.a.a0.g gVar = new e.a.a.a.a0.g(context, null, e.a.a.a.b.materialCalendarStyle, e.a.a.a.j.Widget_MaterialComponents_MaterialCalendar);
        this.z0 = gVar;
        gVar.L(context);
        this.z0.T(ColorStateList.valueOf(iC));
        this.z0.S(d.f.k.r.q(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public final void w0(Bundle bundle) {
        super.w0(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.p0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.q0);
        com.google.android.material.datepicker.a.b bVar = new com.google.android.material.datepicker.a.b(this.s0);
        if (this.t0.z1() != null) {
            bVar.b(this.t0.z1().h);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.u0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.v0);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void x0() {
        super.x0();
        Window window = t1().getWindow();
        if (this.w0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.z0);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = B().getDimensionPixelOffset(e.a.a.a.d.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.z0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new e.a.a.a.r.a(t1(), rect));
        }
        M1();
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void y0() {
        this.r0.n1();
        super.y0();
    }
}
