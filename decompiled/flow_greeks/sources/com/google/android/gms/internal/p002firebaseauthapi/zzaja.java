package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import bb.d0;
import n5.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaja implements Parcelable.Creator<zzajb> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzajb createFromParcel(Parcel parcel) {
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
                case 9:
                    strQ8 = b.q(parcel, iD);
                    break;
                case 10:
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
                case 16:
                    zX3 = b.x(parcel, iD);
                    break;
                case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    strQ13 = b.q(parcel, iD);
                    break;
                default:
                    b.L(parcel, iD);
                    break;
            }
        }
        b.v(parcel, iM);
        return new zzajb(strQ, strQ2, strQ3, strQ4, strQ5, strQ6, strQ7, strQ8, zX, zX2, strQ9, strQ10, strQ11, strQ12, zX3, strQ13);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzajb[] newArray(int i10) {
        return new zzajb[i10];
    }
}
