package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import z1.C1986d;

/* JADX INFO: loaded from: classes.dex */
public final class m0 extends A1.a {
    public static final Parcelable.Creator<m0> CREATOR = new n0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f9935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C1986d[] f9936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0928f f9938d;

    public m0(Bundle bundle, C1986d[] c1986dArr, int i4, C0928f c0928f) {
        this.f9935a = bundle;
        this.f9936b = c1986dArr;
        this.f9937c = i4;
        this.f9938d = c0928f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.j(parcel, 1, this.f9935a, false);
        A1.c.H(parcel, 2, this.f9936b, i4, false);
        A1.c.t(parcel, 3, this.f9937c);
        A1.c.C(parcel, 4, this.f9938d, i4, false);
        A1.c.b(parcel, iA);
    }
}
