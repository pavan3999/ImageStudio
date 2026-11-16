package e.a.a.a.p;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class b extends FrameLayout implements d {
    private final c b;

    @Override // e.a.a.a.p.d
    public void a() {
        this.b.b();
        throw null;
    }

    @Override // e.a.a.a.p.d
    public void b() {
        this.b.a();
        throw null;
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        c cVar = this.b;
        if (cVar == null) {
            super.draw(canvas);
        } else {
            cVar.c(canvas);
            throw null;
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        this.b.d();
        throw null;
    }

    @Override // e.a.a.a.p.d
    public int getCircularRevealScrimColor() {
        this.b.e();
        throw null;
    }

    @Override // e.a.a.a.p.d
    public d.e getRevealInfo() {
        this.b.f();
        throw null;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        c cVar = this.b;
        if (cVar == null) {
            return super.isOpaque();
        }
        cVar.g();
        throw null;
    }

    @Override // e.a.a.a.p.d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.b.h(drawable);
        throw null;
    }

    @Override // e.a.a.a.p.d
    public void setCircularRevealScrimColor(int i) {
        this.b.i(i);
        throw null;
    }

    @Override // e.a.a.a.p.d
    public void setRevealInfo(d.e eVar) {
        this.b.j(eVar);
        throw null;
    }
}
