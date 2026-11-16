package e.a.a.a.z;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final int[] h = new int[3];
    private static final float[] i = {0.0f, 0.5f, 1.0f};
    private static final int[] j = new int[4];
    private static final float[] k = {0.0f, 0.0f, 0.5f, 1.0f};
    private final Paint a;
    private final Paint b;
    private final Paint c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Path f939g;

    public a() {
        this(-16777216);
    }

    public a(int i2) {
        this.f939g = new Path();
        d(i2);
        Paint paint = new Paint(4);
        this.b = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.a = paint2;
        paint2.setColor(this.f936d);
        this.c = new Paint(this.b);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i2, float f2, float f3) {
        boolean z = f3 < 0.0f;
        Path path = this.f939g;
        if (z) {
            int[] iArr = j;
            iArr[0] = 0;
            iArr[1] = this.f938f;
            iArr[2] = this.f937e;
            iArr[3] = this.f936d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f2, f3);
            path.close();
            float f4 = -i2;
            rectF.inset(f4, f4);
            int[] iArr2 = j;
            iArr2[0] = 0;
            iArr2[1] = this.f936d;
            iArr2[2] = this.f937e;
            iArr2[3] = this.f938f;
        }
        float fWidth = 1.0f - (i2 / (rectF.width() / 2.0f));
        float[] fArr = k;
        fArr[1] = fWidth;
        fArr[2] = ((1.0f - fWidth) / 2.0f) + fWidth;
        this.b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, j, k, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        if (!z) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
        }
        canvas.drawArc(rectF, f2, f3, true, this.b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i2) {
        rectF.bottom += i2;
        rectF.offset(0.0f, -i2);
        int[] iArr = h;
        iArr[0] = this.f938f;
        iArr[1] = this.f937e;
        iArr[2] = this.f936d;
        Paint paint = this.c;
        float f2 = rectF.left;
        paint.setShader(new LinearGradient(f2, rectF.top, f2, rectF.bottom, h, i, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.c);
        canvas.restore();
    }

    public Paint c() {
        return this.a;
    }

    public void d(int i2) {
        this.f936d = d.f.d.a.d(i2, 68);
        this.f937e = d.f.d.a.d(i2, 20);
        this.f938f = d.f.d.a.d(i2, 0);
    }
}
