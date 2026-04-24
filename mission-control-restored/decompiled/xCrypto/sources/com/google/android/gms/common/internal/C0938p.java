package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0938p extends A1.a {
    public static final Parcelable.Creator<C0938p> CREATOR = new L();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f9945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f9946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f9947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f9948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f9949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f9950i;

    public C0938p(int i4, int i5, int i6, long j4, long j5, String str, String str2, int i7, int i8) {
        this.f9942a = i4;
        this.f9943b = i5;
        this.f9944c = i6;
        this.f9945d = j4;
        this.f9946e = j5;
        this.f9947f = str;
        this.f9948g = str2;
        this.f9949h = i7;
        this.f9950i = i8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f9942a;
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, i5);
        A1.c.t(parcel, 2, this.f9943b);
        A1.c.t(parcel, 3, this.f9944c);
        A1.c.x(parcel, 4, this.f9945d);
        A1.c.x(parcel, 5, this.f9946e);
        A1.c.E(parcel, 6, this.f9947f, false);
        A1.c.E(parcel, 7, this.f9948g, false);
        A1.c.t(parcel, 8, this.f9949h);
        A1.c.t(parcel, 9, this.f9950i);
        A1.c.b(parcel, iA);
    }
}
