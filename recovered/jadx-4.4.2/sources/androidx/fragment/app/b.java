package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    final int[] b;
    final ArrayList<String> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int[] f297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int[] f298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final String f300g;
    final int h;
    final int i;
    final CharSequence j;
    final int k;
    final CharSequence l;
    final ArrayList<String> m;
    final ArrayList<String> n;
    final boolean o;

    static class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    public b(Parcel parcel) {
        this.b = parcel.createIntArray();
        this.c = parcel.createStringArrayList();
        this.f297d = parcel.createIntArray();
        this.f298e = parcel.createIntArray();
        this.f299f = parcel.readInt();
        this.f300g = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.k = parcel.readInt();
        this.l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }

    public b(androidx.fragment.app.a aVar) {
        int size = aVar.a.size();
        this.b = new int[size * 5];
        if (!aVar.f330g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.c = new ArrayList<>(size);
        this.f297d = new int[size];
        this.f298e = new int[size];
        int i = 0;
        int i2 = 0;
        while (i < size) {
            t.a aVar2 = aVar.a.get(i);
            int i3 = i2 + 1;
            this.b[i2] = aVar2.a;
            ArrayList<String> arrayList = this.c;
            Fragment fragment = aVar2.b;
            arrayList.add(fragment != null ? fragment.f291f : null);
            int[] iArr = this.b;
            int i4 = i3 + 1;
            iArr[i3] = aVar2.c;
            int i5 = i4 + 1;
            iArr[i4] = aVar2.f331d;
            int i6 = i5 + 1;
            iArr[i5] = aVar2.f332e;
            iArr[i6] = aVar2.f333f;
            this.f297d[i] = aVar2.f334g.ordinal();
            this.f298e[i] = aVar2.h.ordinal();
            i++;
            i2 = i6 + 1;
        }
        this.f299f = aVar.f329f;
        this.f300g = aVar.h;
        this.h = aVar.s;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public androidx.fragment.app.a j(m mVar) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(mVar);
        int i = 0;
        int i2 = 0;
        while (i < this.b.length) {
            t.a aVar2 = new t.a();
            int i3 = i + 1;
            aVar2.a = this.b[i];
            if (m.p0(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i2 + " base fragment #" + this.b[i3]);
            }
            String str = this.c.get(i2);
            aVar2.b = str != null ? mVar.V(str) : null;
            aVar2.f334g = androidx.lifecycle.d.b.values()[this.f297d[i2]];
            aVar2.h = androidx.lifecycle.d.b.values()[this.f298e[i2]];
            int[] iArr = this.b;
            int i4 = i3 + 1;
            int i5 = iArr[i3];
            aVar2.c = i5;
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            aVar2.f331d = i7;
            int i8 = i6 + 1;
            int i9 = iArr[i6];
            aVar2.f332e = i9;
            int i10 = iArr[i8];
            aVar2.f333f = i10;
            aVar.b = i5;
            aVar.c = i7;
            aVar.f327d = i9;
            aVar.f328e = i10;
            aVar.e(aVar2);
            i2++;
            i = i8 + 1;
        }
        aVar.f329f = this.f299f;
        aVar.h = this.f300g;
        aVar.s = this.h;
        aVar.f330g = true;
        aVar.i = this.i;
        aVar.j = this.j;
        aVar.k = this.k;
        aVar.l = this.l;
        aVar.m = this.m;
        aVar.n = this.n;
        aVar.o = this.o;
        aVar.p(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.b);
        parcel.writeStringList(this.c);
        parcel.writeIntArray(this.f297d);
        parcel.writeIntArray(this.f298e);
        parcel.writeInt(this.f299f);
        parcel.writeString(this.f300g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        TextUtils.writeToParcel(this.j, parcel, 0);
        parcel.writeInt(this.k);
        TextUtils.writeToParcel(this.l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }
}
