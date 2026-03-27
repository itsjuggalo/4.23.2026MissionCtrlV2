package com.google.android.gms.common.internal;

import Q1.C0792d;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends T1.a {
    public static final Parcelable.Creator<c0> CREATOR = new d0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f14955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0792d[] f14956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C1285e f14958d;

    public c0(Bundle bundle, C0792d[] c0792dArr, int i8, C1285e c1285e) {
        this.f14955a = bundle;
        this.f14956b = c0792dArr;
        this.f14957c = i8;
        this.f14958d = c1285e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int iA = T1.c.a(parcel);
        T1.c.e(parcel, 1, this.f14955a, false);
        T1.c.r(parcel, 2, this.f14956b, i8, false);
        T1.c.j(parcel, 3, this.f14957c);
        T1.c.o(parcel, 4, this.f14958d, i8, false);
        T1.c.b(parcel, iA);
    }
}
