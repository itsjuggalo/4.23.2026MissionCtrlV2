package com.google.android.gms.internal.location;

import android.os.Parcel;
import f2.C1587m;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzan extends zzb implements zzao {
    public zzan() {
        super("com.google.android.gms.location.internal.ISettingsCallbacks");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i7, Parcel parcel, Parcel parcel2, int i8) {
        if (i7 != 1) {
            return false;
        }
        zzb((C1587m) zzc.zzb(parcel, C1587m.CREATOR));
        return true;
    }
}
