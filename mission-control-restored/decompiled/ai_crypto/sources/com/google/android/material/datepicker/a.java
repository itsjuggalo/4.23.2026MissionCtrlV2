package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0187a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f11493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f11494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f11495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f11496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f11498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f11499g;

    /* JADX INFO: renamed from: com.google.android.material.datepicker.a$a, reason: collision with other inner class name */
    public class C0187a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a((k) parcel.readParcelable(k.class.getClassLoader()), (k) parcel.readParcelable(k.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), (k) parcel.readParcelable(k.class.getClassLoader()), parcel.readInt(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i7) {
            return new a[i7];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final long f11500f = r.a(k.c(1900, 0).f11598f);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final long f11501g = r.a(k.c(2100, 11).f11598f);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f11502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f11503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f11504c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11505d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f11506e;

        public b(a aVar) {
            this.f11502a = f11500f;
            this.f11503b = f11501g;
            this.f11506e = f.a(Long.MIN_VALUE);
            this.f11502a = aVar.f11493a.f11598f;
            this.f11503b = aVar.f11494b.f11598f;
            this.f11504c = Long.valueOf(aVar.f11496d.f11598f);
            this.f11505d = aVar.f11497e;
            this.f11506e = aVar.f11495c;
        }

        public a a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f11506e);
            k kVarH = k.h(this.f11502a);
            k kVarH2 = k.h(this.f11503b);
            c cVar = (c) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l7 = this.f11504c;
            return new a(kVarH, kVarH2, cVar, l7 == null ? null : k.h(l7.longValue()), this.f11505d, null);
        }

        public b b(long j7) {
            this.f11504c = Long.valueOf(j7);
            return this;
        }
    }

    public interface c extends Parcelable {
        boolean t(long j7);
    }

    public /* synthetic */ a(k kVar, k kVar2, c cVar, k kVar3, int i7, C0187a c0187a) {
        this(kVar, kVar2, cVar, kVar3, i7);
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
        return this.f11493a.equals(aVar.f11493a) && this.f11494b.equals(aVar.f11494b) && P.b.a(this.f11496d, aVar.f11496d) && this.f11497e == aVar.f11497e && this.f11495c.equals(aVar.f11495c);
    }

    public c g() {
        return this.f11495c;
    }

    public k h() {
        return this.f11494b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11493a, this.f11494b, this.f11496d, Integer.valueOf(this.f11497e), this.f11495c});
    }

    public int i() {
        return this.f11497e;
    }

    public int j() {
        return this.f11499g;
    }

    public k k() {
        return this.f11496d;
    }

    public k m() {
        return this.f11493a;
    }

    public int o() {
        return this.f11498f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeParcelable(this.f11493a, 0);
        parcel.writeParcelable(this.f11494b, 0);
        parcel.writeParcelable(this.f11496d, 0);
        parcel.writeParcelable(this.f11495c, 0);
        parcel.writeInt(this.f11497e);
    }

    public a(k kVar, k kVar2, c cVar, k kVar3, int i7) {
        this.f11493a = kVar;
        this.f11494b = kVar2;
        this.f11496d = kVar3;
        this.f11497e = i7;
        this.f11495c = cVar;
        if (kVar3 != null && kVar.compareTo(kVar3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (kVar3 != null && kVar3.compareTo(kVar2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i7 < 0 || i7 > r.i().getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.f11499g = kVar.x(kVar2) + 1;
        this.f11498f = (kVar2.f11595c - kVar.f11595c) + 1;
    }
}
