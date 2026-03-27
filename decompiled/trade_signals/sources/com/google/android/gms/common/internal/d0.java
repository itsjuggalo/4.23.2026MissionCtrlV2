package com.google.android.gms.common.internal;

import Q1.C0792d;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        Bundle bundleA = null;
        C1285e c1285e = null;
        int iR = 0;
        C0792d[] c0792dArr = null;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            int iK = T1.b.k(iP);
            if (iK == 1) {
                bundleA = T1.b.a(parcel, iP);
            } else if (iK == 2) {
                c0792dArr = (C0792d[]) T1.b.h(parcel, iP, C0792d.CREATOR);
            } else if (iK == 3) {
                iR = T1.b.r(parcel, iP);
            } else if (iK != 4) {
                T1.b.v(parcel, iP);
            } else {
                c1285e = (C1285e) T1.b.e(parcel, iP, C1285e.CREATOR);
            }
        }
        T1.b.j(parcel, iW);
        return new c0(bundleA, c0792dArr, iR, c1285e);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new c0[i8];
    }
}
