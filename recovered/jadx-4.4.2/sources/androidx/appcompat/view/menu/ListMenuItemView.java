package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.w0;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements n.a, AbsListView.SelectionBoundsAdjuster {
    private i b;
    private ImageView c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RadioButton f58d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f59e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CheckBox f60f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f61g;
    private ImageView h;
    private ImageView i;
    private LinearLayout j;
    private Drawable k;
    private int l;
    private Context m;
    private boolean n;
    private Drawable o;
    private boolean p;
    private LayoutInflater q;
    private boolean r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.a.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        w0 w0VarU = w0.u(getContext(), attributeSet, d.a.j.MenuView, i, 0);
        this.k = w0VarU.g(d.a.j.MenuView_android_itemBackground);
        this.l = w0VarU.n(d.a.j.MenuView_android_itemTextAppearance, -1);
        this.n = w0VarU.a(d.a.j.MenuView_preserveIconSpacing, false);
        this.m = context;
        this.o = w0VarU.g(d.a.j.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, d.a.a.dropDownListViewStyle, 0);
        this.p = typedArrayObtainStyledAttributes.hasValue(0);
        w0VarU.v();
        typedArrayObtainStyledAttributes.recycle();
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i) {
        LinearLayout linearLayout = this.j;
        if (linearLayout != null) {
            linearLayout.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    private void d() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(d.a.g.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f60f = checkBox;
        a(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(d.a.g.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.c = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(d.a.g.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f58d = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.q == null) {
            this.q = LayoutInflater.from(getContext());
        }
        return this.q;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.i;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        rect.top += this.i.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void e(i iVar, int i) {
        this.b = iVar;
        setVisibility(iVar.isVisible() ? 0 : 8);
        setTitle(iVar.i(this));
        setCheckable(iVar.isCheckable());
        h(iVar.A(), iVar.g());
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        setSubMenuArrowVisible(iVar.hasSubMenu());
        setContentDescription(iVar.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.b;
    }

    public void h(boolean z, char c) {
        int i = (z && this.b.A()) ? 0 : 8;
        if (i == 0) {
            this.f61g.setText(this.b.h());
        }
        if (this.f61g.getVisibility() != i) {
            this.f61g.setVisibility(i);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        d.f.k.r.f0(this, this.k);
        TextView textView = (TextView) findViewById(d.a.f.title);
        this.f59e = textView;
        int i = this.l;
        if (i != -1) {
            textView.setTextAppearance(this.m, i);
        }
        this.f61g = (TextView) findViewById(d.a.f.shortcut);
        ImageView imageView = (ImageView) findViewById(d.a.f.submenuarrow);
        this.h = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.o);
        }
        this.i = (ImageView) findViewById(d.a.f.group_divider);
        this.j = (LinearLayout) findViewById(d.a.f.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.c != null && this.n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.f58d == null && this.f60f == null) {
            return;
        }
        if (this.b.m()) {
            if (this.f58d == null) {
                g();
            }
            compoundButton = this.f58d;
            compoundButton2 = this.f60f;
        } else {
            if (this.f60f == null) {
                d();
            }
            compoundButton = this.f60f;
            compoundButton2 = this.f58d;
        }
        if (z) {
            compoundButton.setChecked(this.b.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f60f;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f58d;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.b.m()) {
            if (this.f58d == null) {
                g();
            }
            compoundButton = this.f58d;
        } else {
            if (this.f60f == null) {
                d();
            }
            compoundButton = this.f60f;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.r = z;
        this.n = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setVisibility((this.p || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.b.z() || this.r;
        if (z || this.n) {
            if (this.c == null && drawable == null && !this.n) {
                return;
            }
            if (this.c == null) {
                f();
            }
            if (drawable == null && !this.n) {
                this.c.setVisibility(8);
                return;
            }
            ImageView imageView = this.c;
            if (!z) {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
            if (this.c.getVisibility() != 0) {
                this.c.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        int i;
        TextView textView;
        if (charSequence != null) {
            this.f59e.setText(charSequence);
            if (this.f59e.getVisibility() == 0) {
                return;
            }
            textView = this.f59e;
            i = 0;
        } else {
            i = 8;
            if (this.f59e.getVisibility() == 8) {
                return;
            } else {
                textView = this.f59e;
            }
        }
        textView.setVisibility(i);
    }
}
