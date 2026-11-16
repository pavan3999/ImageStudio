package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class f {
    private float c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e.a.a.a.x.d f628f;
    private final TextPaint a = new TextPaint(1);
    private final e.a.a.a.x.f b = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f626d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WeakReference<b> f627e = new WeakReference<>(null);

    class a extends e.a.a.a.x.f {
        a() {
        }

        @Override // e.a.a.a.x.f
        public void a(int i) {
            f.this.f626d = true;
            b bVar = (b) f.this.f627e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // e.a.a.a.x.f
        public void b(Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            f.this.f626d = true;
            b bVar = (b) f.this.f627e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public f(b bVar) {
        g(bVar);
    }

    private float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.a.measureText(charSequence, 0, charSequence.length());
    }

    public e.a.a.a.x.d d() {
        return this.f628f;
    }

    public TextPaint e() {
        return this.a;
    }

    public float f(String str) {
        if (!this.f626d) {
            return this.c;
        }
        float fC = c(str);
        this.c = fC;
        this.f626d = false;
        return fC;
    }

    public void g(b bVar) {
        this.f627e = new WeakReference<>(bVar);
    }

    public void h(e.a.a.a.x.d dVar, Context context) {
        if (this.f628f != dVar) {
            this.f628f = dVar;
            if (dVar != null) {
                dVar.j(context, this.a, this.b);
                b bVar = this.f627e.get();
                if (bVar != null) {
                    this.a.drawableState = bVar.getState();
                }
                dVar.i(context, this.a, this.b);
                this.f626d = true;
            }
            b bVar2 = this.f627e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void i(boolean z) {
        this.f626d = z;
    }

    public void j(Context context) {
        this.f628f.i(context, this.a, this.b);
    }
}
