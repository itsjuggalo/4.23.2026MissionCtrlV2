package com.google.android.gms.internal.location;

import Q1.b;
import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzbd implements Parcelable.Creator<zzbc> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbc createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        int iF = 1;
        zzba zzbaVar = null;
        IBinder iBinderE = null;
        PendingIntent pendingIntent = null;
        IBinder iBinderE2 = null;
        IBinder iBinderE3 = null;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            switch (b.w(iD)) {
                case 1:
                    iF = b.F(parcel, iD);
                    break;
                case 2:
                    zzbaVar = (zzba) b.p(parcel, iD, zzba.CREATOR);
                    break;
                case 3:
                    iBinderE = b.E(parcel, iD);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) b.p(parcel, iD, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinderE2 = b.E(parcel, iD);
                    break;
                case 6:
                    iBinderE3 = b.E(parcel, iD);
                    break;
                default:
                    b.L(parcel, iD);
                    break;
            }
        }
        b.v(parcel, iM);
        return new zzbc(iF, zzbaVar, iBinderE, pendingIntent, iBinderE2, iBinderE3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbc[] newArray(int i7) {
        return new zzbc[i7];
    }
}
