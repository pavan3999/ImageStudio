package androidx.appcompat.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
class o0 {
    private int a = 0;
    private int b = 0;
    private int c = RecyclerView.UNDEFINED_DURATION;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f192d = RecyclerView.UNDEFINED_DURATION;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f193e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f194f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f195g = false;
    private boolean h = false;

    o0() {
    }

    public int a() {
        return this.f195g ? this.a : this.b;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.f195g ? this.b : this.a;
    }

    public void e(int i, int i2) {
        this.h = false;
        if (i != Integer.MIN_VALUE) {
            this.f193e = i;
            this.a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f194f = i2;
            this.b = i2;
        }
    }

    public void f(boolean z) {
        int i;
        if (z == this.f195g) {
            return;
        }
        this.f195g = z;
        if (this.h) {
            if (z) {
                int i2 = this.f192d;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = this.f193e;
                }
                this.a = i2;
                i = this.c;
                if (i == Integer.MIN_VALUE) {
                }
            } else {
                int i3 = this.c;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = this.f193e;
                }
                this.a = i3;
                i = this.f192d;
                if (i == Integer.MIN_VALUE) {
                }
            }
            this.b = i;
        }
        this.a = this.f193e;
        i = this.f194f;
        this.b = i;
    }

    public void g(int i, int i2) {
        this.c = i;
        this.f192d = i2;
        this.h = true;
        if (this.f195g) {
            if (i2 != Integer.MIN_VALUE) {
                this.a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.b = i2;
        }
    }
}
