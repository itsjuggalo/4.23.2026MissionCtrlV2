package com.google.android.gms.internal.p002firebaseauthapi;

import Q1.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.c.a.a.c;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public final class zzais implements Parcelable.Creator<zzait> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzait createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        String strQ8 = null;
        String strQ9 = null;
        String strQ10 = null;
        String strQ11 = null;
        String strQ12 = null;
        String strQ13 = null;
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            switch (b.w(iD)) {
                case 2:
                    strQ = b.q(parcel, iD);
                    break;
                case 3:
                    strQ2 = b.q(parcel, iD);
                    break;
                case 4:
                    strQ3 = b.q(parcel, iD);
                    break;
                case 5:
                    strQ4 = b.q(parcel, iD);
                    break;
                case 6:
                    strQ5 = b.q(parcel, iD);
                    break;
                case 7:
                    strQ6 = b.q(parcel, iD);
                    break;
                case 8:
                    strQ7 = b.q(parcel, iD);
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    strQ8 = b.q(parcel, iD);
                    break;
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    zX = b.x(parcel, iD);
                    break;
                case 11:
                    zX2 = b.x(parcel, iD);
                    break;
                case 12:
                    strQ9 = b.q(parcel, iD);
                    break;
                case 13:
                    strQ10 = b.q(parcel, iD);
                    break;
                case 14:
                    strQ11 = b.q(parcel, iD);
                    break;
                case 15:
                    strQ12 = b.q(parcel, iD);
                    break;
                case c.f10119g /* 16 */:
                    zX3 = b.x(parcel, iD);
                    break;
                case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    strQ13 = b.q(parcel, iD);
                    break;
                default:
                    b.L(parcel, iD);
                    break;
            }
        }
        b.v(parcel, iM);
        return new zzait(strQ, strQ2, strQ3, strQ4, strQ5, strQ6, strQ7, strQ8, zX, zX2, strQ9, strQ10, strQ11, strQ12, zX3, strQ13);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzait[] newArray(int i7) {
        return new zzait[i7];
    }
}
