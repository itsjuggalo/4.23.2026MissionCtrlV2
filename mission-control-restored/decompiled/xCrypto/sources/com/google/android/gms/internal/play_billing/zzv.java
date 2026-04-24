package com.google.android.gms.internal.play_billing;

import H0.T;

/* JADX INFO: loaded from: classes.dex */
public final class zzv {
    public static zzeu zza(T t4) {
        zzr zzrVar = new zzr();
        zzu zzuVar = new zzu(zzrVar);
        zzrVar.zzb = zzuVar;
        zzrVar.zza = t4.getClass();
        try {
            zzrVar.zza = t4.a(zzrVar);
            return zzuVar;
        } catch (Exception e4) {
            zzuVar.zzc(e4);
            return zzuVar;
        }
    }
}
