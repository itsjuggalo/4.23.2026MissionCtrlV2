package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzag implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        long jS = 0;
        long jS2 = 0;
        int iR = 0;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            int iK = T1.b.k(iP);
            if (iK == 1) {
                jS = T1.b.s(parcel, iP);
            } else if (iK == 2) {
                iR = T1.b.r(parcel, iP);
            } else if (iK != 3) {
                T1.b.v(parcel, iP);
            } else {
                jS2 = T1.b.s(parcel, iP);
            }
        }
        T1.b.j(parcel, iW);
        return new zzaf(jS, iR, jS2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new zzaf[i8];
    }
}
