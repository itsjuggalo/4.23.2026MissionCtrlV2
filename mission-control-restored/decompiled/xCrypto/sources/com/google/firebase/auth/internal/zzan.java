package com.google.firebase.auth.internal;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzan implements Parcelable.Creator<zzal> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzal createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        ArrayList arrayListU = null;
        zzam zzamVar = null;
        String strQ = null;
        com.google.firebase.auth.zzc zzcVar = null;
        zzaf zzafVar = null;
        ArrayList arrayListU2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            switch (b.w(iD)) {
                case 1:
                    arrayListU = b.u(parcel, iD, PhoneMultiFactorInfo.CREATOR);
                    break;
                case 2:
                    zzamVar = (zzam) b.p(parcel, iD, zzam.CREATOR);
                    break;
                case 3:
                    strQ = b.q(parcel, iD);
                    break;
                case 4:
                    zzcVar = (com.google.firebase.auth.zzc) b.p(parcel, iD, com.google.firebase.auth.zzc.CREATOR);
                    break;
                case 5:
                    zzafVar = (zzaf) b.p(parcel, iD, zzaf.CREATOR);
                    break;
                case 6:
                    arrayListU2 = b.u(parcel, iD, TotpMultiFactorInfo.CREATOR);
                    break;
                default:
                    b.L(parcel, iD);
                    break;
            }
        }
        b.v(parcel, iM);
        return new zzal(arrayListU, zzamVar, strQ, zzcVar, zzafVar, arrayListU2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzal[] newArray(int i4) {
        return new zzal[i4];
    }
}
