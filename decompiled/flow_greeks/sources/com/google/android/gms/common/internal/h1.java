package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h1 extends n5.a {
    public static final Parcelable.Creator<h1> CREATOR = new i1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f5723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m5.d[] f5724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f5726d;

    public h1(Bundle bundle, m5.d[] dVarArr, int i10, f fVar) {
        this.f5723a = bundle;
        this.f5724b = dVarArr;
        this.f5725c = i10;
        this.f5726d = fVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.j(parcel, 1, this.f5723a, false);
        n5.c.H(parcel, 2, this.f5724b, i10, false);
        n5.c.t(parcel, 3, this.f5725c);
        n5.c.C(parcel, 4, this.f5726d, i10, false);
        n5.c.b(parcel, iA);
    }
}
