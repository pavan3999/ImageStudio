package d.m;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
class h<T> extends Property<T, Float> {
    private final Property<T, PointF> a;
    private final PathMeasure b;
    private final float c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PointF f835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f836f;

    h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f834d = new float[2];
        this.f835e = new PointF();
        this.a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.b = pathMeasure;
        this.c = pathMeasure.getLength();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(T t) {
        return Float.valueOf(this.f836f);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(T t, Float f2) {
        this.f836f = f2.floatValue();
        this.b.getPosTan(this.c * f2.floatValue(), this.f834d, null);
        PointF pointF = this.f835e;
        float[] fArr = this.f834d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.a.set(t, pointF);
    }
}
