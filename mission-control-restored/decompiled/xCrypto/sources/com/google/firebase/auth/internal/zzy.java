package com.google.firebase.auth.internal;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzy implements Parcelable.Creator<zzz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        zzaf zzafVar = null;
        zzx zzxVar = null;
        com.google.firebase.auth.zzc zzcVar = null;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW == 1) {
                zzafVar = (zzaf) b.p(parcel, iD, zzaf.CREATOR);
            } else if (iW == 2) {
                zzxVar = (zzx) b.p(parcel, iD, zzx.CREATOR);
            } else if (iW != 3) {
                b.L(parcel, iD);
            } else {
                zzcVar = (com.google.firebase.auth.zzc) b.p(parcel, iD, com.google.firebase.auth.zzc.CREATOR);
            }
        }
        b.v(parcel, iM);
        return new zzz(zzafVar, zzxVar, zzcVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz[] newArray(int i4) {
        return new zzz[i4];
    }
}
