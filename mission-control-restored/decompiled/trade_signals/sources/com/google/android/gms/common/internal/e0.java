package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class e0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        C1296p c1296p = null;
        int[] iArrC = null;
        int[] iArrC2 = null;
        boolean zL = false;
        boolean zL2 = false;
        int iR = 0;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            switch (T1.b.k(iP)) {
                case 1:
                    c1296p = (C1296p) T1.b.e(parcel, iP, C1296p.CREATOR);
                    break;
                case 2:
                    zL = T1.b.l(parcel, iP);
                    break;
                case 3:
                    zL2 = T1.b.l(parcel, iP);
                    break;
                case 4:
                    iArrC = T1.b.c(parcel, iP);
                    break;
                case 5:
                    iR = T1.b.r(parcel, iP);
                    break;
                case 6:
                    iArrC2 = T1.b.c(parcel, iP);
                    break;
                default:
                    T1.b.v(parcel, iP);
                    break;
            }
        }
        T1.b.j(parcel, iW);
        return new C1285e(c1296p, zL, zL2, iArrC, iR, iArrC2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new C1285e[i8];
    }
}
