package com.google.firebase.auth;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzait;

/* JADX INFO: loaded from: classes.dex */
public final class zze implements Parcelable.Creator<zzc> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        zzait zzaitVar = null;
        String strQ4 = null;
        String strQ5 = null;
        String strQ6 = null;
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
                    zzaitVar = (zzait) b.p(parcel, iD, zzait.CREATOR);
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
                default:
                    b.L(parcel, iD);
                    break;
            }
        }
        b.v(parcel, iM);
        return new zzc(strQ, strQ2, strQ3, zzaitVar, strQ4, strQ5, strQ6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc[] newArray(int i4) {
        return new zzc[i4];
    }
}
