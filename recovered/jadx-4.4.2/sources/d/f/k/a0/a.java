package d.f.k.a0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ClickableSpan {
    private final int b;
    private final c c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f788d;

    public a(int i, c cVar, int i2) {
        this.b = i;
        this.c = cVar;
        this.f788d = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.b);
        this.c.M(this.f788d, bundle);
    }
}
