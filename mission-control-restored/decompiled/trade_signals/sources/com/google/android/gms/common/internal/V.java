package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class V implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        int iR = 0;
        boolean zL = false;
        boolean zL2 = false;
        int iR2 = 0;
        int iR3 = 0;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            int iK = T1.b.k(iP);
            if (iK == 1) {
                iR = T1.b.r(parcel, iP);
            } else if (iK == 2) {
                zL = T1.b.l(parcel, iP);
            } else if (iK == 3) {
                zL2 = T1.b.l(parcel, iP);
            } else if (iK == 4) {
                iR2 = T1.b.r(parcel, iP);
            } else if (iK != 5) {
                T1.b.v(parcel, iP);
            } else {
                iR3 = T1.b.r(parcel, iP);
            }
        }
        T1.b.j(parcel, iW);
        return new C1296p(iR, zL, zL2, iR2, iR3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new C1296p[i8];
    }
}
