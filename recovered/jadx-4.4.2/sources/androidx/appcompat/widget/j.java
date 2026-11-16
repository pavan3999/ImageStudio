package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    private static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    private static j c;
    private m0 a;

    static class a implements m0.e {
        private final int[] a = {d.a.e.abc_textfield_search_default_mtrl_alpha, d.a.e.abc_textfield_default_mtrl_alpha, d.a.e.abc_ab_share_pack_mtrl_alpha};
        private final int[] b = {d.a.e.abc_ic_commit_search_api_mtrl_alpha, d.a.e.abc_seekbar_tick_mark_material, d.a.e.abc_ic_menu_share_mtrl_alpha, d.a.e.abc_ic_menu_copy_mtrl_am_alpha, d.a.e.abc_ic_menu_cut_mtrl_alpha, d.a.e.abc_ic_menu_selectall_mtrl_alpha, d.a.e.abc_ic_menu_paste_mtrl_am_alpha};
        private final int[] c = {d.a.e.abc_textfield_activated_mtrl_alpha, d.a.e.abc_textfield_search_activated_mtrl_alpha, d.a.e.abc_cab_background_top_mtrl_alpha, d.a.e.abc_text_cursor_material, d.a.e.abc_text_select_handle_left_mtrl_dark, d.a.e.abc_text_select_handle_middle_mtrl_dark, d.a.e.abc_text_select_handle_right_mtrl_dark, d.a.e.abc_text_select_handle_left_mtrl_light, d.a.e.abc_text_select_handle_middle_mtrl_light, d.a.e.abc_text_select_handle_right_mtrl_light};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f179d = {d.a.e.abc_popup_background_mtrl_mult, d.a.e.abc_cab_background_internal_bg, d.a.e.abc_menu_hardkey_panel_mtrl_mult};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f180e = {d.a.e.abc_tab_indicator_material, d.a.e.abc_textfield_search_material};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int[] f181f = {d.a.e.abc_btn_check_material, d.a.e.abc_btn_radio_material, d.a.e.abc_btn_check_material_anim, d.a.e.abc_btn_radio_material_anim};

        a() {
        }

        private boolean f(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i) {
            int iB = r0.b(context, d.a.a.colorControlHighlight);
            return new ColorStateList(new int[][]{r0.b, r0.f207d, r0.c, r0.f209f}, new int[]{r0.a(context, d.a.a.colorButtonNormal), d.f.d.a.b(iB, i), d.f.d.a.b(iB, i), i});
        }

        private ColorStateList i(Context context) {
            return h(context, r0.b(context, d.a.a.colorAccent));
        }

        private ColorStateList j(Context context) {
            return h(context, r0.b(context, d.a.a.colorButtonNormal));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList colorStateListD = r0.d(context, d.a.a.colorSwitchThumbNormal);
            if (colorStateListD == null || !colorStateListD.isStateful()) {
                iArr[0] = r0.b;
                iArr2[0] = r0.a(context, d.a.a.colorSwitchThumbNormal);
                iArr[1] = r0.f208e;
                iArr2[1] = r0.b(context, d.a.a.colorControlActivated);
                iArr[2] = r0.f209f;
                iArr2[2] = r0.b(context, d.a.a.colorSwitchThumbNormal);
            } else {
                iArr[0] = r0.b;
                iArr2[0] = colorStateListD.getColorForState(iArr[0], 0);
                iArr[1] = r0.f208e;
                iArr2[1] = r0.b(context, d.a.a.colorControlActivated);
                iArr[2] = r0.f209f;
                iArr2[2] = colorStateListD.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private void l(Drawable drawable, int i, PorterDuff.Mode mode) {
            if (e0.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = j.b;
            }
            drawable.setColorFilter(j.e(i, mode));
        }

        @Override // androidx.appcompat.widget.m0.e
        public Drawable a(m0 m0Var, Context context, int i) {
            if (i == d.a.e.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{m0Var.j(context, d.a.e.abc_cab_background_internal_bg), m0Var.j(context, d.a.e.abc_cab_background_top_mtrl_alpha)});
            }
            return null;
        }

        @Override // androidx.appcompat.widget.m0.e
        public ColorStateList b(Context context, int i) {
            if (i == d.a.e.abc_edit_text_material) {
                return d.a.k.a.a.c(context, d.a.c.abc_tint_edittext);
            }
            if (i == d.a.e.abc_switch_track_mtrl_alpha) {
                return d.a.k.a.a.c(context, d.a.c.abc_tint_switch_track);
            }
            if (i == d.a.e.abc_switch_thumb_material) {
                return k(context);
            }
            if (i == d.a.e.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i == d.a.e.abc_btn_borderless_material) {
                return g(context);
            }
            if (i == d.a.e.abc_btn_colored_material) {
                return i(context);
            }
            if (i == d.a.e.abc_spinner_mtrl_am_alpha || i == d.a.e.abc_spinner_textfield_background_material) {
                return d.a.k.a.a.c(context, d.a.c.abc_tint_spinner);
            }
            if (f(this.b, i)) {
                return r0.d(context, d.a.a.colorControlNormal);
            }
            if (f(this.f180e, i)) {
                return d.a.k.a.a.c(context, d.a.c.abc_tint_default);
            }
            if (f(this.f181f, i)) {
                return d.a.k.a.a.c(context, d.a.c.abc_tint_btn_checkable);
            }
            if (i == d.a.e.abc_seekbar_thumb_material) {
                return d.a.k.a.a.c(context, d.a.c.abc_tint_seek_thumb);
            }
            return null;
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0046  */
        /* JADX WARN: Code duplicated, block: B:23:0x004c  */
        /* JADX WARN: Code duplicated, block: B:26:0x005d  */
        /* JADX WARN: Code duplicated, block: B:28:0x0061 A[RETURN] */
        @Override // androidx.appcompat.widget.m0.e
        public boolean c(Context context, int i, Drawable drawable) {
            int iRound;
            boolean z;
            PorterDuff.Mode mode = j.b;
            boolean zF = f(this.a, i);
            int i2 = R.attr.colorBackground;
            if (zF) {
                i2 = d.a.a.colorControlNormal;
            } else if (f(this.c, i)) {
                i2 = d.a.a.colorControlActivated;
            } else {
                if (!f(this.f179d, i)) {
                    if (i == d.a.e.abc_list_divider_mtrl_alpha) {
                        i2 = R.attr.colorForeground;
                        iRound = Math.round(40.8f);
                        z = true;
                    } else if (i != d.a.e.abc_dialog_material_background) {
                        iRound = -1;
                        z = false;
                        i2 = 0;
                    }
                    if (z) {
                        return false;
                    }
                    if (e0.a(drawable)) {
                        drawable = drawable.mutate();
                    }
                    drawable.setColorFilter(j.e(r0.b(context, i2), mode));
                    if (iRound != -1) {
                        drawable.setAlpha(iRound);
                    }
                    return true;
                }
                mode = PorterDuff.Mode.MULTIPLY;
            }
            iRound = -1;
            z = true;
            if (z) {
                return false;
            }
            if (e0.a(drawable)) {
                drawable = drawable.mutate();
            }
            drawable.setColorFilter(j.e(r0.b(context, i2), mode));
            if (iRound != -1) {
                drawable.setAlpha(iRound);
            }
            return true;
        }

        @Override // androidx.appcompat.widget.m0.e
        public boolean d(Context context, int i, Drawable drawable) {
            LayerDrawable layerDrawable;
            Drawable drawableFindDrawableByLayerId;
            int i2;
            if (i == d.a.e.abc_seekbar_track_material) {
                layerDrawable = (LayerDrawable) drawable;
                l(layerDrawable.findDrawableByLayerId(R.id.background), r0.b(context, d.a.a.colorControlNormal), j.b);
                drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.secondaryProgress);
                i2 = d.a.a.colorControlNormal;
            } else {
                if (i != d.a.e.abc_ratingbar_material && i != d.a.e.abc_ratingbar_indicator_material && i != d.a.e.abc_ratingbar_small_material) {
                    return false;
                }
                layerDrawable = (LayerDrawable) drawable;
                l(layerDrawable.findDrawableByLayerId(R.id.background), r0.a(context, d.a.a.colorControlNormal), j.b);
                drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.secondaryProgress);
                i2 = d.a.a.colorControlActivated;
            }
            l(drawableFindDrawableByLayerId, r0.b(context, i2), j.b);
            l(layerDrawable.findDrawableByLayerId(R.id.progress), r0.b(context, d.a.a.colorControlActivated), j.b);
            return true;
        }

        @Override // androidx.appcompat.widget.m0.e
        public PorterDuff.Mode e(int i) {
            if (i == d.a.e.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }
    }

    public static synchronized j b() {
        if (c == null) {
            h();
        }
        return c;
    }

    public static synchronized PorterDuffColorFilter e(int i, PorterDuff.Mode mode) {
        return m0.l(i, mode);
    }

    public static synchronized void h() {
        if (c == null) {
            j jVar = new j();
            c = jVar;
            jVar.a = m0.h();
            c.a.u(new a());
        }
    }

    static void i(Drawable drawable, u0 u0Var, int[] iArr) {
        m0.w(drawable, u0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i) {
        return this.a.j(context, i);
    }

    synchronized Drawable d(Context context, int i, boolean z) {
        return this.a.k(context, i, z);
    }

    synchronized ColorStateList f(Context context, int i) {
        return this.a.m(context, i);
    }

    public synchronized void g(Context context) {
        this.a.s(context);
    }
}
