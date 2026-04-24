package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1292l extends T1.a {
    public static final Parcelable.Creator<C1292l> CREATOR = new F();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f15030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f15031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f15032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f15033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f15034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f15035i;

    public C1292l(int i8, int i9, int i10, long j8, long j9, String str, String str2, int i11, int i12) {
        this.f15027a = i8;
        this.f15028b = i9;
        this.f15029c = i10;
        this.f15030d = j8;
        this.f15031e = j9;
        this.f15032f = str;
        this.f15033g = str2;
        this.f15034h = i11;
        this.f15035i = i12;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = this.f15027a;
        int iA = T1.c.a(parcel);
        T1.c.j(parcel, 1, i9);
        T1.c.j(parcel, 2, this.f15028b);
        T1.c.j(parcel, 3, this.f15029c);
        T1.c.m(parcel, 4, this.f15030d);
        T1.c.m(parcel, 5, this.f15031e);
        T1.c.p(parcel, 6, this.f15032f, false);
        T1.c.p(parcel, 7, this.f15033g, false);
        T1.c.j(parcel, 8, this.f15034h);
        T1.c.j(parcel, 9, this.f15035i);
        T1.c.b(parcel, iA);
    }
}
