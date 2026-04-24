package com.google.android.gms.internal.fido;

import J1.B;
import J1.C0048y;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzs extends zza implements IInterface {
    public zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fido.fido2.internal.regular.IFido2AppService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzc(zzr zzrVar, C0048y c0048y) {
        Parcel parcelZza = zza();
        int i = zzc.zza;
        parcelZza.writeStrongBinder(zzrVar);
        zzc.zzd(parcelZza, c0048y);
        zzb(1, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzd(zzr zzrVar, B b3) {
        Parcel parcelZza = zza();
        int i = zzc.zza;
        parcelZza.writeStrongBinder(zzrVar);
        zzc.zzd(parcelZza, b3);
        zzb(2, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zze(zze zzeVar) {
        Parcel parcelZza = zza();
        int i = zzc.zza;
        parcelZza.writeStrongBinder(zzeVar);
        zzb(3, parcelZza);
    }
}
