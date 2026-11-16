package e.a.a.a.l;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* JADX INFO: loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {
    private final float[] a = new float[9];
    private final float[] b = new float[9];
    private final Matrix c = new Matrix();

    public Matrix a(float f2, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.a);
        matrix2.getValues(this.b);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.b;
            float f3 = fArr[i];
            float[] fArr2 = this.a;
            fArr[i] = fArr2[i] + ((f3 - fArr2[i]) * f2);
        }
        this.c.setValues(this.b);
        return this.c;
    }
}
