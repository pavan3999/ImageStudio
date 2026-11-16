package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes.dex */
final class l implements Comparable<l>, Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new a();
    private final Calendar b;
    private final String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f590g;
    final long h;

    static class a implements Parcelable.Creator<l> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public l createFromParcel(Parcel parcel) {
            return l.k(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public l[] newArray(int i) {
            return new l[i];
        }
    }

    private l(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarD = r.d(calendar);
        this.b = calendarD;
        this.f587d = calendarD.get(2);
        this.f588e = this.b.get(1);
        this.f589f = this.b.getMaximum(7);
        this.f590g = this.b.getActualMaximum(5);
        this.c = r.n().format(this.b.getTime());
        this.h = this.b.getTimeInMillis();
    }

    static l k(int i, int i2) {
        Calendar calendarK = r.k();
        calendarK.set(1, i);
        calendarK.set(2, i2);
        return new l(calendarK);
    }

    static l l(long j) {
        Calendar calendarK = r.k();
        calendarK.setTimeInMillis(j);
        return new l(calendarK);
    }

    static l s() {
        return new l(r.i());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f587d == lVar.f587d && this.f588e == lVar.f588e;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f587d), Integer.valueOf(this.f588e)});
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(l lVar) {
        return this.b.compareTo(lVar.b);
    }

    int m() {
        int firstDayOfWeek = this.b.get(7) - this.b.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f589f : firstDayOfWeek;
    }

    long n(int i) {
        Calendar calendarD = r.d(this.b);
        calendarD.set(5, i);
        return calendarD.getTimeInMillis();
    }

    String o() {
        return this.c;
    }

    long p() {
        return this.b.getTimeInMillis();
    }

    l q(int i) {
        Calendar calendarD = r.d(this.b);
        calendarD.add(2, i);
        return new l(calendarD);
    }

    int r(l lVar) {
        if (this.b instanceof GregorianCalendar) {
            return ((lVar.f588e - this.f588e) * 12) + (lVar.f587d - this.f587d);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f588e);
        parcel.writeInt(this.f587d);
    }
}
