package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import q1.C1719a;
import q1.C1720b;
import q1.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzas extends zzb implements zzat {
    public zzas() {
        super("com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferCallbacks");
    }

    @Override // com.google.android.gms.internal.auth.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) {
        switch (i4) {
            case 1:
                Status status = (Status) zzc.zza(parcel, Status.CREATOR);
                zzc.zzb(parcel);
                zzh(status);
                return true;
            case 2:
                Status status2 = (Status) zzc.zza(parcel, Status.CREATOR);
                i iVar = (i) zzc.zza(parcel, i.CREATOR);
                zzc.zzb(parcel);
                zzf(status2, iVar);
                return true;
            case 3:
                Status status3 = (Status) zzc.zza(parcel, Status.CREATOR);
                C1720b c1720b = (C1720b) zzc.zza(parcel, C1720b.CREATOR);
                zzc.zzb(parcel);
                zzg(status3, c1720b);
                return true;
            case 4:
                zze();
                return true;
            case 5:
                Status status4 = (Status) zzc.zza(parcel, Status.CREATOR);
                zzc.zzb(parcel);
                zzd(status4);
                return true;
            case 6:
                byte[] bArrCreateByteArray = parcel.createByteArray();
                zzc.zzb(parcel);
                zzb(bArrCreateByteArray);
                return true;
            case 7:
                C1719a c1719a = (C1719a) zzc.zza(parcel, C1719a.CREATOR);
                zzc.zzb(parcel);
                zzc(c1719a);
                return true;
            default:
                return false;
        }
    }
}
