package com.google.android.material.bottomappbar;

import e.a.a.a.a0.f;
import e.a.a.a.a0.m;

/* JADX INFO: loaded from: classes.dex */
public class a extends f implements Cloneable {
    private float b;
    private float c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f543f;

    @Override // e.a.a.a.a0.f
    public void a(float f2, float f3, float f4, m mVar) {
        float f5 = this.f541d;
        if (f5 == 0.0f) {
            mVar.l(f2, 0.0f);
            return;
        }
        float f6 = ((this.c * 2.0f) + f5) / 2.0f;
        float f7 = f4 * this.b;
        float f8 = f3 + this.f543f;
        float f9 = (this.f542e * f4) + ((1.0f - f4) * f6);
        if (f9 / f6 >= 1.0f) {
            mVar.l(f2, 0.0f);
            return;
        }
        float f10 = f6 + f7;
        float f11 = f9 + f7;
        float fSqrt = (float) Math.sqrt((f10 * f10) - (f11 * f11));
        float f12 = f8 - fSqrt;
        float f13 = f8 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f11));
        float f14 = 90.0f - degrees;
        mVar.l(f12, 0.0f);
        float f15 = f7 * 2.0f;
        mVar.a(f12 - f7, 0.0f, f12 + f7, f15, 270.0f, degrees);
        mVar.a(f8 - f6, (-f6) - f9, f8 + f6, f6 - f9, 180.0f - f14, (f14 * 2.0f) - 180.0f);
        mVar.a(f13 - f7, 0.0f, f13 + f7, f15, 270.0f - degrees, degrees);
        mVar.l(f2, 0.0f);
    }

    float b() {
        return this.f542e;
    }

    float c() {
        return this.c;
    }

    float d() {
        return this.b;
    }

    public float e() {
        return this.f541d;
    }

    void f(float f2) {
        this.f542e = f2;
    }

    void g(float f2) {
        this.c = f2;
    }

    void h(float f2) {
        this.b = f2;
    }

    public void i(float f2) {
        this.f541d = f2;
    }

    void j(float f2) {
        this.f543f = f2;
    }
}
