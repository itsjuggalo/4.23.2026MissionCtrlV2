package com.google.firebase.auth;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzb implements Parcelable.Creator<ActionCodeSettings> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActionCodeSettings createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        String strQ8 = null;
        boolean zX = false;
        boolean zX2 = false;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            switch (b.w(iD)) {
                case 1:
                    strQ = b.q(parcel, iD);
                    break;
                case 2:
                    strQ2 = b.q(parcel, iD);
                    break;
                case 3:
                    strQ3 = b.q(parcel, iD);
                    break;
                case 4:
                    strQ4 = b.q(parcel, iD);
                    break;
                case 5:
                    zX = b.x(parcel, iD);
                    break;
                case 6:
                    strQ5 = b.q(parcel, iD);
                    break;
                case 7:
                    zX2 = b.x(parcel, iD);
                    break;
                case 8:
                    strQ6 = b.q(parcel, iD);
                    break;
                case 9:
                    iF = b.F(parcel, iD);
                    break;
                case 10:
                    strQ7 = b.q(parcel, iD);
                    break;
                case 11:
                    strQ8 = b.q(parcel, iD);
                    break;
                default:
                    b.L(parcel, iD);
                    break;
            }
        }
        b.v(parcel, iM);
        return new ActionCodeSettings(strQ, strQ2, strQ3, strQ4, zX, strQ5, zX2, strQ6, iF, strQ7, strQ8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActionCodeSettings[] newArray(int i4) {
        return new ActionCodeSettings[i4];
    }
}
