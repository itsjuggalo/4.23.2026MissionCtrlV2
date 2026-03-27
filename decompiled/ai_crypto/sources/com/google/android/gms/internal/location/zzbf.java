package com.google.android.gms.internal.location;

import Q1.b;
import android.os.Parcel;
import android.os.Parcelable;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public final class zzbf implements Parcelable.Creator<zzbe> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbe createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        String strQ = null;
        int iF = 0;
        short sJ = 0;
        int iF2 = 0;
        double dZ = 0.0d;
        double dZ2 = 0.0d;
        float fB = 0.0f;
        long jH = 0;
        int iF3 = -1;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            switch (b.w(iD)) {
                case 1:
                    strQ = b.q(parcel, iD);
                    break;
                case 2:
                    jH = b.H(parcel, iD);
                    break;
                case 3:
                    sJ = b.J(parcel, iD);
                    break;
                case 4:
                    dZ = b.z(parcel, iD);
                    break;
                case 5:
                    dZ2 = b.z(parcel, iD);
                    break;
                case 6:
                    fB = b.B(parcel, iD);
                    break;
                case 7:
                    iF = b.F(parcel, iD);
                    break;
                case 8:
                    iF2 = b.F(parcel, iD);
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    iF3 = b.F(parcel, iD);
                    break;
                default:
                    b.L(parcel, iD);
                    break;
            }
        }
        b.v(parcel, iM);
        return new zzbe(strQ, iF, sJ, dZ, dZ2, fB, jH, iF2, iF3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbe[] newArray(int i7) {
        return new zzbe[i7];
    }
}
