package com.google.android.gms.common.internal;

import P1.C0650d;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class m0 extends Q1.a {
    public static final Parcelable.Creator<m0> CREATOR = new n0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f11118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0650d[] f11119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C1195f f11121d;

    public m0(Bundle bundle, C0650d[] c0650dArr, int i7, C1195f c1195f) {
        this.f11118a = bundle;
        this.f11119b = c0650dArr;
        this.f11120c = i7;
        this.f11121d = c1195f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.j(parcel, 1, this.f11118a, false);
        Q1.c.H(parcel, 2, this.f11119b, i7, false);
        Q1.c.t(parcel, 3, this.f11120c);
        Q1.c.C(parcel, 4, this.f11121d, i7, false);
        Q1.c.b(parcel, iA);
    }
}
