package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class q implements Parcelable {
    public static final Parcelable.Creator<q> CREATOR = new a();
    final String b;
    final String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final String f326g;
    final boolean h;
    final boolean i;
    final boolean j;
    final Bundle k;
    final boolean l;
    final int m;
    Bundle n;

    static class a implements Parcelable.Creator<q> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public q createFromParcel(Parcel parcel) {
            return new q(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public q[] newArray(int i) {
            return new q[i];
        }
    }

    q(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.f323d = parcel.readInt() != 0;
        this.f324e = parcel.readInt();
        this.f325f = parcel.readInt();
        this.f326g = parcel.readString();
        this.h = parcel.readInt() != 0;
        this.i = parcel.readInt() != 0;
        this.j = parcel.readInt() != 0;
        this.k = parcel.readBundle();
        this.l = parcel.readInt() != 0;
        this.n = parcel.readBundle();
        this.m = parcel.readInt();
    }

    q(Fragment fragment) {
        this.b = fragment.getClass().getName();
        this.c = fragment.f291f;
        this.f323d = fragment.n;
        this.f324e = fragment.w;
        this.f325f = fragment.x;
        this.f326g = fragment.y;
        this.h = fragment.B;
        this.i = fragment.m;
        this.j = fragment.A;
        this.k = fragment.f292g;
        this.l = fragment.z;
        this.m = fragment.Q.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.b);
        sb.append(" (");
        sb.append(this.c);
        sb.append(")}:");
        if (this.f323d) {
            sb.append(" fromLayout");
        }
        if (this.f325f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f325f));
        }
        String str = this.f326g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f326g);
        }
        if (this.h) {
            sb.append(" retainInstance");
        }
        if (this.i) {
            sb.append(" removing");
        }
        if (this.j) {
            sb.append(" detached");
        }
        if (this.l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.f323d ? 1 : 0);
        parcel.writeInt(this.f324e);
        parcel.writeInt(this.f325f);
        parcel.writeString(this.f326g);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeBundle(this.k);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeBundle(this.n);
        parcel.writeInt(this.m);
    }
}
