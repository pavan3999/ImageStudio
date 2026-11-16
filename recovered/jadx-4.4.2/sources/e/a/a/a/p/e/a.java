package e.a.a.a.p.e;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import e.a.a.a.p.c;
import e.a.a.a.p.d;

/* JADX INFO: loaded from: classes.dex */
public class a extends e.a.a.a.n.a implements d {
    private final c o;

    @Override // e.a.a.a.p.d
    public void a() {
        this.o.b();
        throw null;
    }

    @Override // e.a.a.a.p.d
    public void b() {
        this.o.a();
        throw null;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        c cVar = this.o;
        if (cVar == null) {
            super.draw(canvas);
        } else {
            cVar.c(canvas);
            throw null;
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        this.o.d();
        throw null;
    }

    @Override // e.a.a.a.p.d
    public int getCircularRevealScrimColor() {
        this.o.e();
        throw null;
    }

    @Override // e.a.a.a.p.d
    public d.e getRevealInfo() {
        this.o.f();
        throw null;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        c cVar = this.o;
        if (cVar == null) {
            return super.isOpaque();
        }
        cVar.g();
        throw null;
    }

    @Override // e.a.a.a.p.d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.o.h(drawable);
        throw null;
    }

    @Override // e.a.a.a.p.d
    public void setCircularRevealScrimColor(int i) {
        this.o.i(i);
        throw null;
    }

    @Override // e.a.a.a.p.d
    public void setRevealInfo(d.e eVar) {
        this.o.j(eVar);
        throw null;
    }
}
