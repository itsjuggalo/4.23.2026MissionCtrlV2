package com.google.android.gms.internal.play_billing;

import Y0.T;

/* JADX INFO: loaded from: classes.dex */
public final class zzv {
    public static zzeu zza(T t7) {
        zzr zzrVar = new zzr();
        zzu zzuVar = new zzu(zzrVar);
        zzrVar.zzb = zzuVar;
        zzrVar.zza = t7.getClass();
        try {
            zzrVar.zza = t7.a(zzrVar);
        } catch (Exception e7) {
            zzuVar.zzc(e7);
        }
        return zzuVar;
    }
}
