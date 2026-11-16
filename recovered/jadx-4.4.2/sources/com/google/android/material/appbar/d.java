package com.google.android.material.appbar;

import android.view.View;
import d.f.k.r;

/* JADX INFO: loaded from: classes.dex */
class d {
    private final View a;
    private int b;
    private int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f526f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f527g = true;

    public d(View view) {
        this.a = view;
    }

    void a() {
        View view = this.a;
        r.P(view, this.f524d - (view.getTop() - this.b));
        View view2 = this.a;
        r.O(view2, this.f525e - (view2.getLeft() - this.c));
    }

    public int b() {
        return this.f524d;
    }

    void c() {
        this.b = this.a.getTop();
        this.c = this.a.getLeft();
    }

    public boolean d(int i) {
        if (!this.f527g || this.f525e == i) {
            return false;
        }
        this.f525e = i;
        a();
        return true;
    }

    public boolean e(int i) {
        if (!this.f526f || this.f524d == i) {
            return false;
        }
        this.f524d = i;
        a();
        return true;
    }
}
