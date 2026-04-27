package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Comparable, Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f11593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f11598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f11599g;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k createFromParcel(Parcel parcel) {
            return k.c(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public k[] newArray(int i7) {
            return new k[i7];
        }
    }

    public k(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarD = r.d(calendar);
        this.f11593a = calendarD;
        this.f11594b = calendarD.get(2);
        this.f11595c = calendarD.get(1);
        this.f11596d = calendarD.getMaximum(7);
        this.f11597e = calendarD.getActualMaximum(5);
        this.f11598f = calendarD.getTimeInMillis();
    }

    public static k c(int i7, int i8) {
        Calendar calendarI = r.i();
        calendarI.set(1, i7);
        calendarI.set(2, i8);
        return new k(calendarI);
    }

    public static k h(long j7) {
        Calendar calendarI = r.i();
        calendarI.setTimeInMillis(j7);
        return new k(calendarI);
    }

    public static k i() {
        return new k(r.g());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(k kVar) {
        return this.f11593a.compareTo(kVar.f11593a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f11594b == kVar.f11594b && this.f11595c == kVar.f11595c;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f11594b), Integer.valueOf(this.f11595c)});
    }

    public int j(int i7) {
        int i8 = this.f11593a.get(7);
        if (i7 <= 0) {
            i7 = this.f11593a.getFirstDayOfWeek();
        }
        int i9 = i8 - i7;
        return i9 < 0 ? i9 + this.f11596d : i9;
    }

    public long k(int i7) {
        Calendar calendarD = r.d(this.f11593a);
        calendarD.set(5, i7);
        return calendarD.getTimeInMillis();
    }

    public int m(long j7) {
        Calendar calendarD = r.d(this.f11593a);
        calendarD.setTimeInMillis(j7);
        return calendarD.get(5);
    }

    public String o() {
        if (this.f11599g == null) {
            this.f11599g = e.c(this.f11593a.getTimeInMillis());
        }
        return this.f11599g;
    }

    public long p() {
        return this.f11593a.getTimeInMillis();
    }

    public k v(int i7) {
        Calendar calendarD = r.d(this.f11593a);
        calendarD.add(2, i7);
        return new k(calendarD);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f11595c);
        parcel.writeInt(this.f11594b);
    }

    public int x(k kVar) {
        if (this.f11593a instanceof GregorianCalendar) {
            return ((kVar.f11595c - this.f11595c) * 12) + (kVar.f11594b - this.f11594b);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }
}
