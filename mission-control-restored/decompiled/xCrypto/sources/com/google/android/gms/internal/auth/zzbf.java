package com.google.android.gms.internal.auth;

import android.os.Parcel;
import t1.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbf extends zzb implements zzbg {
    public zzbf() {
        super("com.google.android.gms.auth.api.internal.IAuthCallbacks");
    }

    @Override // com.google.android.gms.internal.auth.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 == 1) {
            c cVar = (c) zzc.zza(parcel, c.CREATOR);
            zzc.zzb(parcel);
            zzb(cVar);
        } else {
            if (i4 != 2) {
                return false;
            }
            String string = parcel.readString();
            zzc.zzb(parcel);
            zzc(string);
        }
        parcel2.writeNoException();
        return true;
    }
}
