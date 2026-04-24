package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import n1.C1617c;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzl extends zzb implements zzm {
    public zzl() {
        super("com.google.android.gms.auth.account.data.IGetAccountChangeEventsCallback");
    }

    @Override // com.google.android.gms.internal.auth.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 != 2) {
            return false;
        }
        Status status = (Status) zzc.zza(parcel, Status.CREATOR);
        C1617c c1617c = (C1617c) zzc.zza(parcel, C1617c.CREATOR);
        zzc.zzb(parcel);
        zzb(status, c1617c);
        return true;
    }
}
