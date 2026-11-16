package e.a.a.a.r;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private final Dialog b;
    private final int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f927e;

    public a(Dialog dialog, Rect rect) {
        this.b = dialog;
        this.c = rect.left;
        this.f926d = rect.top;
        this.f927e = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = this.c + viewFindViewById.getLeft();
        int width = viewFindViewById.getWidth() + left;
        int top = this.f926d + viewFindViewById.getTop();
        if (new RectF(left, top, width, viewFindViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(4);
        if (Build.VERSION.SDK_INT < 28) {
            motionEventObtain.setAction(0);
            int i = this.f927e;
            motionEventObtain.setLocation((-i) - 1, (-i) - 1);
        }
        view.performClick();
        return this.b.onTouchEvent(motionEventObtain);
    }
}
