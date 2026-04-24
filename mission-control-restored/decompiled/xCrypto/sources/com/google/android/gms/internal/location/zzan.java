package com.google.android.gms.internal.location;

import P1.C0502m;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzan extends zzb implements zzao {
    public zzan() {
        super("com.google.android.gms.location.internal.ISettingsCallbacks");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 != 1) {
            return false;
        }
        zzb((C0502m) zzc.zzb(parcel, C0502m.CREATOR));
        return true;
    }
}
