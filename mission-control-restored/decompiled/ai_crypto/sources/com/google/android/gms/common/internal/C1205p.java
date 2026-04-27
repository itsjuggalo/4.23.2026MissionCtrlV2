package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1205p extends Q1.a {
    public static final Parcelable.Creator<C1205p> CREATOR = new L();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f11128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f11129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f11130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f11131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f11132h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f11133i;

    public C1205p(int i7, int i8, int i9, long j7, long j8, String str, String str2, int i10, int i11) {
        this.f11125a = i7;
        this.f11126b = i8;
        this.f11127c = i9;
        this.f11128d = j7;
        this.f11129e = j8;
        this.f11130f = str;
        this.f11131g = str2;
        this.f11132h = i10;
        this.f11133i = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int i8 = this.f11125a;
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, i8);
        Q1.c.t(parcel, 2, this.f11126b);
        Q1.c.t(parcel, 3, this.f11127c);
        Q1.c.x(parcel, 4, this.f11128d);
        Q1.c.x(parcel, 5, this.f11129e);
        Q1.c.E(parcel, 6, this.f11130f, false);
        Q1.c.E(parcel, 7, this.f11131g, false);
        Q1.c.t(parcel, 8, this.f11132h);
        Q1.c.t(parcel, 9, this.f11133i);
        Q1.c.b(parcel, iA);
    }
}
