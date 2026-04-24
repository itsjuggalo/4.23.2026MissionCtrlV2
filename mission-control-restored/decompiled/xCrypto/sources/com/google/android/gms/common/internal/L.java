package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class L implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        int iF = -1;
        int iF2 = 0;
        int iF3 = 0;
        int iF4 = 0;
        int iF5 = 0;
        String strQ = null;
        String strQ2 = null;
        long jH = 0;
        long jH2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    iF2 = A1.b.F(parcel, iD);
                    break;
                case 2:
                    iF3 = A1.b.F(parcel, iD);
                    break;
                case 3:
                    iF4 = A1.b.F(parcel, iD);
                    break;
                case 4:
                    jH = A1.b.H(parcel, iD);
                    break;
                case 5:
                    jH2 = A1.b.H(parcel, iD);
                    break;
                case 6:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 7:
                    strQ2 = A1.b.q(parcel, iD);
                    break;
                case 8:
                    iF5 = A1.b.F(parcel, iD);
                    break;
                case 9:
                    iF = A1.b.F(parcel, iD);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new C0938p(iF2, iF3, iF4, jH, jH2, strQ, strQ2, iF5, iF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0938p[i4];
    }
}
