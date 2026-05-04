package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import n5.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzm implements Parcelable.Creator<zzl> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzl createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        zzj zzjVar = null;
        int iF = 1;
        IBinder iBinderE = null;
        IBinder iBinderE2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW == 1) {
                iF = b.F(parcel, iD);
            } else if (iW == 2) {
                zzjVar = (zzj) b.p(parcel, iD, zzj.CREATOR);
            } else if (iW == 3) {
                iBinderE = b.E(parcel, iD);
            } else if (iW != 4) {
                b.L(parcel, iD);
            } else {
                iBinderE2 = b.E(parcel, iD);
            }
        }
        b.v(parcel, iM);
        return new zzl(iF, zzjVar, iBinderE, iBinderE2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzl[] newArray(int i10) {
        return new zzl[i10];
    }
}
