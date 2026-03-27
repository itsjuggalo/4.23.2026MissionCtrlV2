package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public final class L implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
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
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    iF2 = Q1.b.F(parcel, iD);
                    break;
                case 2:
                    iF3 = Q1.b.F(parcel, iD);
                    break;
                case 3:
                    iF4 = Q1.b.F(parcel, iD);
                    break;
                case 4:
                    jH = Q1.b.H(parcel, iD);
                    break;
                case 5:
                    jH2 = Q1.b.H(parcel, iD);
                    break;
                case 6:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 7:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                case 8:
                    iF5 = Q1.b.F(parcel, iD);
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    iF = Q1.b.F(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new C1205p(iF2, iF3, iF4, jH, jH2, strQ, strQ2, iF5, iF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1205p[i7];
    }
}
