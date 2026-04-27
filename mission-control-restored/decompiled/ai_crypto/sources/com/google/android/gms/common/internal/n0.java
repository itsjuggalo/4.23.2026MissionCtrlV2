package com.google.android.gms.common.internal;

import P1.C0650d;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class n0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        Bundle bundleF = null;
        C1195f c1195f = null;
        int iF = 0;
        C0650d[] c0650dArr = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                bundleF = Q1.b.f(parcel, iD);
            } else if (iW == 2) {
                c0650dArr = (C0650d[]) Q1.b.t(parcel, iD, C0650d.CREATOR);
            } else if (iW == 3) {
                iF = Q1.b.F(parcel, iD);
            } else if (iW != 4) {
                Q1.b.L(parcel, iD);
            } else {
                c1195f = (C1195f) Q1.b.p(parcel, iD, C1195f.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new m0(bundleF, c0650dArr, iF, c1195f);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new m0[i7];
    }
}
