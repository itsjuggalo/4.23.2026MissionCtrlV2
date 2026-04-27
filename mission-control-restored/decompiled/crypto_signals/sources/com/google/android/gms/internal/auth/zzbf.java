package com.google.android.gms.internal.auth;

import android.os.Parcel;
import q1.C0921b;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbf extends zzb implements zzbg {
    public zzbf() {
        super("com.google.android.gms.auth.api.internal.IAuthCallbacks");
    }

    @Override // com.google.android.gms.internal.auth.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i6) {
        if (i == 1) {
            C0921b c0921b = (C0921b) zzc.zza(parcel, C0921b.CREATOR);
            zzc.zzb(parcel);
            zzb(c0921b);
        } else {
            if (i != 2) {
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
