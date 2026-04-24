package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzoi implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        int iR = 0;
        long jS = 0;
        String strF = null;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            int iK = T1.b.k(iP);
            if (iK == 1) {
                strF = T1.b.f(parcel, iP);
            } else if (iK == 2) {
                jS = T1.b.s(parcel, iP);
            } else if (iK != 3) {
                T1.b.v(parcel, iP);
            } else {
                iR = T1.b.r(parcel, iP);
            }
        }
        T1.b.j(parcel, iW);
        return new zzoh(strF, jS, iR);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new zzoh[i8];
    }
}
