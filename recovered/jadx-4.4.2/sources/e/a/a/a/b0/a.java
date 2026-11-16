package e.a.a.a.b0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import d.d.g;

/* JADX INFO: loaded from: classes.dex */
public class a extends d.h.a.a {
    public static final Parcelable.Creator<a> CREATOR = new C0066a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g<String, Bundle> f917d;

    /* JADX INFO: renamed from: e.a.a.a.b0.a$a, reason: collision with other inner class name */
    static class C0066a implements Parcelable.ClassLoaderCreator<a> {
        C0066a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null, 0 == true ? 1 : 0);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    private a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i = parcel.readInt();
        String[] strArr = new String[i];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f917d = new g<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.f917d.put(strArr[i2], bundleArr[i2]);
        }
    }

    /* synthetic */ a(Parcel parcel, ClassLoader classLoader, C0066a c0066a) {
        this(parcel, classLoader);
    }

    public a(Parcelable parcelable) {
        super(parcelable);
        this.f917d = new g<>();
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f917d + "}";
    }

    @Override // d.h.a.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int size = this.f917d.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = this.f917d.i(i2);
            bundleArr[i2] = this.f917d.m(i2);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
