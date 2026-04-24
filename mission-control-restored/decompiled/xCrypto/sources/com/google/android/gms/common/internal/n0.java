package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import z1.C1986d;

/* JADX INFO: loaded from: classes.dex */
public final class n0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        Bundle bundleF = null;
        C0928f c0928f = null;
        int iF = 0;
        C1986d[] c1986dArr = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                bundleF = A1.b.f(parcel, iD);
            } else if (iW == 2) {
                c1986dArr = (C1986d[]) A1.b.t(parcel, iD, C1986d.CREATOR);
            } else if (iW == 3) {
                iF = A1.b.F(parcel, iD);
            } else if (iW != 4) {
                A1.b.L(parcel, iD);
            } else {
                c0928f = (C0928f) A1.b.p(parcel, iD, C0928f.CREATOR);
            }
        }
        A1.b.v(parcel, iM);
        return new m0(bundleF, c1986dArr, iF, c0928f);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new m0[i4];
    }
}
