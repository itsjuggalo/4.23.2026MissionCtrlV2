package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class F implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        int iR = -1;
        int iR2 = 0;
        int iR3 = 0;
        int iR4 = 0;
        int iR5 = 0;
        String strF = null;
        String strF2 = null;
        long jS = 0;
        long jS2 = 0;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            switch (T1.b.k(iP)) {
                case 1:
                    iR2 = T1.b.r(parcel, iP);
                    break;
                case 2:
                    iR3 = T1.b.r(parcel, iP);
                    break;
                case 3:
                    iR4 = T1.b.r(parcel, iP);
                    break;
                case 4:
                    jS = T1.b.s(parcel, iP);
                    break;
                case 5:
                    jS2 = T1.b.s(parcel, iP);
                    break;
                case 6:
                    strF = T1.b.f(parcel, iP);
                    break;
                case 7:
                    strF2 = T1.b.f(parcel, iP);
                    break;
                case 8:
                    iR5 = T1.b.r(parcel, iP);
                    break;
                case 9:
                    iR = T1.b.r(parcel, iP);
                    break;
                default:
                    T1.b.v(parcel, iP);
                    break;
            }
        }
        T1.b.j(parcel, iW);
        return new C1292l(iR2, iR3, iR4, jS, jS2, strF, strF2, iR5, iR);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new C1292l[i8];
    }
}
