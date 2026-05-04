package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import bb.d0;
import io.flutter.Build;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzs implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        boolean zX = false;
        int iF = 0;
        boolean zX2 = false;
        boolean zX3 = false;
        int iF2 = 0;
        int iF3 = 0;
        long jH = 0;
        long jH2 = 0;
        long jH3 = 0;
        long jH4 = 0;
        long jH5 = 0;
        long jH6 = 0;
        long jH7 = 0;
        String strQ = "";
        String strQ2 = strQ;
        String strQ3 = strQ2;
        String strQ4 = strQ3;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        String strQ8 = null;
        String strQ9 = null;
        String strQ10 = null;
        Boolean boolY = null;
        ArrayList arrayListS = null;
        String strQ11 = null;
        String strQ12 = null;
        int iF4 = 100;
        boolean zX4 = true;
        boolean zX5 = true;
        long jH8 = -2147483648L;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 2:
                    strQ5 = n5.b.q(parcel, iD);
                    break;
                case 3:
                    strQ6 = n5.b.q(parcel, iD);
                    break;
                case 4:
                    strQ7 = n5.b.q(parcel, iD);
                    break;
                case 5:
                    strQ8 = n5.b.q(parcel, iD);
                    break;
                case 6:
                    jH = n5.b.H(parcel, iD);
                    break;
                case 7:
                    jH2 = n5.b.H(parcel, iD);
                    break;
                case 8:
                    strQ9 = n5.b.q(parcel, iD);
                    break;
                case 9:
                    zX4 = n5.b.x(parcel, iD);
                    break;
                case 10:
                    zX = n5.b.x(parcel, iD);
                    break;
                case 11:
                    jH8 = n5.b.H(parcel, iD);
                    break;
                case 12:
                    strQ10 = n5.b.q(parcel, iD);
                    break;
                case 13:
                case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                case 19:
                case 20:
                case 24:
                case Build.API_LEVELS.API_33 /* 33 */:
                default:
                    n5.b.L(parcel, iD);
                    break;
                case 14:
                    jH3 = n5.b.H(parcel, iD);
                    break;
                case 15:
                    iF = n5.b.F(parcel, iD);
                    break;
                case 16:
                    zX5 = n5.b.x(parcel, iD);
                    break;
                case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                    zX2 = n5.b.x(parcel, iD);
                    break;
                case Build.API_LEVELS.API_21 /* 21 */:
                    boolY = n5.b.y(parcel, iD);
                    break;
                case Build.API_LEVELS.API_22 /* 22 */:
                    jH4 = n5.b.H(parcel, iD);
                    break;
                case Build.API_LEVELS.API_23 /* 23 */:
                    arrayListS = n5.b.s(parcel, iD);
                    break;
                case Build.API_LEVELS.API_25 /* 25 */:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case Build.API_LEVELS.API_26 /* 26 */:
                    strQ2 = n5.b.q(parcel, iD);
                    break;
                case Build.API_LEVELS.API_27 /* 27 */:
                    strQ11 = n5.b.q(parcel, iD);
                    break;
                case Build.API_LEVELS.API_28 /* 28 */:
                    zX3 = n5.b.x(parcel, iD);
                    break;
                case Build.API_LEVELS.API_29 /* 29 */:
                    jH5 = n5.b.H(parcel, iD);
                    break;
                case Build.API_LEVELS.API_30 /* 30 */:
                    iF4 = n5.b.F(parcel, iD);
                    break;
                case Build.API_LEVELS.API_31 /* 31 */:
                    strQ3 = n5.b.q(parcel, iD);
                    break;
                case 32:
                    iF2 = n5.b.F(parcel, iD);
                    break;
                case Build.API_LEVELS.API_34 /* 34 */:
                    jH6 = n5.b.H(parcel, iD);
                    break;
                case Build.API_LEVELS.API_35 /* 35 */:
                    strQ12 = n5.b.q(parcel, iD);
                    break;
                case Build.API_LEVELS.API_36 /* 36 */:
                    strQ4 = n5.b.q(parcel, iD);
                    break;
                case 37:
                    jH7 = n5.b.H(parcel, iD);
                    break;
                case 38:
                    iF3 = n5.b.F(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new zzr(strQ5, strQ6, strQ7, strQ8, jH, jH2, strQ9, zX4, zX, jH8, strQ10, jH3, iF, zX5, zX2, boolY, jH4, arrayListS, strQ, strQ2, strQ11, zX3, jH5, iF4, strQ3, iF2, jH6, strQ12, strQ4, jH7, iF3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzr[i10];
    }
}
