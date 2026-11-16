package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class o implements Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new a();
    ArrayList<q> b;
    ArrayList<String> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    b[] f316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f318f;

    static class a implements Parcelable.Creator<o> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public o createFromParcel(Parcel parcel) {
            return new o(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public o[] newArray(int i) {
            return new o[i];
        }
    }

    public o() {
        this.f318f = null;
    }

    public o(Parcel parcel) {
        this.f318f = null;
        this.b = parcel.createTypedArrayList(q.CREATOR);
        this.c = parcel.createStringArrayList();
        this.f316d = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f317e = parcel.readInt();
        this.f318f = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.b);
        parcel.writeStringList(this.c);
        parcel.writeTypedArray(this.f316d, i);
        parcel.writeInt(this.f317e);
        parcel.writeString(this.f318f);
    }
}
