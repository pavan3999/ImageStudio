package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.appcompat.widget.m;
import d.f.k.r;

/* JADX INFO: loaded from: classes.dex */
public class CheckableImageButton extends m implements Checkable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f613g = {R.attr.state_checked};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f615e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f616f;

    class a extends d.f.k.a {
        a() {
        }

        @Override // d.f.k.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // d.f.k.a
        public void g(View view, d.f.k.a0.c cVar) {
            super.g(view, cVar);
            cVar.T(CheckableImageButton.this.a());
            cVar.U(CheckableImageButton.this.isChecked());
        }
    }

    static class b extends d.h.a.a {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f618d;

        static class a implements Parcelable.ClassLoaderCreator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            k(parcel);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        private void k(Parcel parcel) {
            this.f618d = parcel.readInt() == 1;
        }

        @Override // d.h.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f618d ? 1 : 0);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.a.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f615e = true;
        this.f616f = true;
        r.c0(this, new a());
    }

    public boolean a() {
        return this.f615e;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f614d;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        return this.f614d ? ImageButton.mergeDrawableStates(super.onCreateDrawableState(i + f613g.length), f613g) : super.onCreateDrawableState(i);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.j());
        setChecked(bVar.f618d);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f618d = this.f614d;
        return bVar;
    }

    public void setCheckable(boolean z) {
        if (this.f615e != z) {
            this.f615e = z;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (!this.f615e || this.f614d == z) {
            return;
        }
        this.f614d = z;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z) {
        this.f616f = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.f616f) {
            super.setPressed(z);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f614d);
    }
}
