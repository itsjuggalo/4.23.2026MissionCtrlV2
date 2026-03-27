package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import n1.C0866a;
import n1.C0867b;
import n1.C0871f;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzas extends zzb implements zzat {
    public zzas() {
        super("com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferCallbacks");
    }

    @Override // com.google.android.gms.internal.auth.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i6) {
        switch (i) {
            case 1:
                Status status = (Status) zzc.zza(parcel, Status.CREATOR);
                zzc.zzb(parcel);
                zzh(status);
                return true;
            case 2:
                Status status2 = (Status) zzc.zza(parcel, Status.CREATOR);
                C0871f c0871f = (C0871f) zzc.zza(parcel, C0871f.CREATOR);
                zzc.zzb(parcel);
                zzf(status2, c0871f);
                return true;
            case 3:
                Status status3 = (Status) zzc.zza(parcel, Status.CREATOR);
                C0867b c0867b = (C0867b) zzc.zza(parcel, C0867b.CREATOR);
                zzc.zzb(parcel);
                zzg(status3, c0867b);
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
                C0866a c0866a = (C0866a) zzc.zza(parcel, C0866a.CREATOR);
                zzc.zzb(parcel);
                zzc(c0866a);
                return true;
            default:
                return false;
        }
    }
}
