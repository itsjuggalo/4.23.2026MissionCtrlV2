package com.google.android.gms.common.internal;

import N1.X1;
import android.os.Parcel;
import android.os.Parcelable;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class r extends AbstractC1255a {
    public static final Parcelable.Creator<r> CREATOR = new X1(24);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f5274d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5275f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f5276k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f5277l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f5278m;

    public r(int i, int i6, int i7, long j4, long j6, String str, String str2, int i8, int i9) {
        this.f5271a = i;
        this.f5272b = i6;
        this.f5273c = i7;
        this.f5274d = j4;
        this.e = j6;
        this.f5275f = str;
        this.f5276k = str2;
        this.f5277l = i8;
        this.f5278m = i9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.b0(parcel, 1, 4);
        parcel.writeInt(this.f5271a);
        u0.b0(parcel, 2, 4);
        parcel.writeInt(this.f5272b);
        u0.b0(parcel, 3, 4);
        parcel.writeInt(this.f5273c);
        u0.b0(parcel, 4, 8);
        parcel.writeLong(this.f5274d);
        u0.b0(parcel, 5, 8);
        parcel.writeLong(this.e);
        u0.T(parcel, 6, this.f5275f, false);
        u0.T(parcel, 7, this.f5276k, false);
        u0.b0(parcel, 8, 4);
        parcel.writeInt(this.f5277l);
        u0.b0(parcel, 9, 4);
        parcel.writeInt(this.f5278m);
        u0.a0(iX, parcel);
    }
}
