package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0023a();
    private final l b;
    private final l c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final l f569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c f570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f572g;

    /* JADX INFO: renamed from: com.google.android.material.datepicker.a$a, reason: collision with other inner class name */
    static class C0023a implements Parcelable.Creator<a> {
        C0023a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a((l) parcel.readParcelable(l.class.getClassLoader()), (l) parcel.readParcelable(l.class.getClassLoader()), (l) parcel.readParcelable(l.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final long f573e = r.a(l.k(1900, 0).h);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final long f574f = r.a(l.k(2100, 11).h);
        private long a;
        private long b;
        private Long c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private c f575d;

        b(a aVar) {
            this.a = f573e;
            this.b = f574f;
            this.f575d = f.j(Long.MIN_VALUE);
            this.a = aVar.b.h;
            this.b = aVar.c.h;
            this.c = Long.valueOf(aVar.f569d.h);
            this.f575d = aVar.f570e;
        }

        public a a() {
            if (this.c == null) {
                long jN1 = i.N1();
                if (this.a > jN1 || jN1 > this.b) {
                    jN1 = this.a;
                }
                this.c = Long.valueOf(jN1);
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f575d);
            return new a(l.l(this.a), l.l(this.b), l.l(this.c.longValue()), (c) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY"), null);
        }

        public b b(long j) {
            this.c = Long.valueOf(j);
            return this;
        }
    }

    public interface c extends Parcelable {
        boolean i(long j);
    }

    private a(l lVar, l lVar2, l lVar3, c cVar) {
        this.b = lVar;
        this.c = lVar2;
        this.f569d = lVar3;
        this.f570e = cVar;
        if (lVar.compareTo(lVar3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (lVar3.compareTo(lVar2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f572g = lVar.r(lVar2) + 1;
        this.f571f = (lVar2.f588e - lVar.f588e) + 1;
    }

    /* synthetic */ a(l lVar, l lVar2, l lVar3, c cVar, C0023a c0023a) {
        this(lVar, lVar2, lVar3, cVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.b.equals(aVar.b) && this.c.equals(aVar.c) && this.f569d.equals(aVar.f569d) && this.f570e.equals(aVar.f570e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.f569d, this.f570e});
    }

    public c n() {
        return this.f570e;
    }

    l o() {
        return this.c;
    }

    int p() {
        return this.f572g;
    }

    l q() {
        return this.f569d;
    }

    l r() {
        return this.b;
    }

    int s() {
        return this.f571f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.c, 0);
        parcel.writeParcelable(this.f569d, 0);
        parcel.writeParcelable(this.f570e, 0);
    }
}
