package com.google.android.gms.internal.auth_blockstore;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import w1.C1904e;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzl extends zzb implements zzm {
    public zzl() {
        super("com.google.android.gms.auth.blockstore.internal.IRetrieveBytesCallback");
    }

    @Override // com.google.android.gms.internal.auth_blockstore.zzb
    public final boolean dispatchTransaction(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 == 1) {
            Status status = (Status) zzc.zza(parcel, Status.CREATOR);
            byte[] bArrCreateByteArray = parcel.createByteArray();
            enforceNoDataAvail(parcel);
            zza(status, bArrCreateByteArray);
        } else {
            if (i4 != 2) {
                return false;
            }
            Status status2 = (Status) zzc.zza(parcel, Status.CREATOR);
            C1904e c1904e = (C1904e) zzc.zza(parcel, C1904e.CREATOR);
            enforceNoDataAvail(parcel);
            zzb(status2, c1904e);
        }
        return true;
    }
}
