package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class p extends n5.a {
    public static final Parcelable.Creator<p> CREATOR = new j0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f5772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f5773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f5775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f5776h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f5777i;

    public p(int i10, int i11, int i12, long j10, long j11, String str, String str2, int i13, int i14) {
        this.f5769a = i10;
        this.f5770b = i11;
        this.f5771c = i12;
        this.f5772d = j10;
        this.f5773e = j11;
        this.f5774f = str;
        this.f5775g = str2;
        this.f5776h = i13;
        this.f5777i = i14;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f5769a;
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, i11);
        n5.c.t(parcel, 2, this.f5770b);
        n5.c.t(parcel, 3, this.f5771c);
        n5.c.x(parcel, 4, this.f5772d);
        n5.c.x(parcel, 5, this.f5773e);
        n5.c.E(parcel, 6, this.f5774f, false);
        n5.c.E(parcel, 7, this.f5775g, false);
        n5.c.t(parcel, 8, this.f5776h);
        n5.c.t(parcel, 9, this.f5777i);
        n5.c.b(parcel, iA);
    }
}
