package com.google.android.recaptcha.internal;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzev {
    public static final zzrl zza(zzbn zzbnVar, zzbn zzbnVar2) {
        zzrj zzrjVarZzf = zzrl.zzf();
        zzrjVarZzf.zzq(zzqb.zzb(zzbnVar.zzb()));
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        zzrjVarZzf.zzr(zzpz.zza(zzbnVar.zza(timeUnit)));
        zzrjVarZzf.zze(zzqb.zzb(zzbnVar2.zzb()));
        zzrjVarZzf.zzf(zzpz.zza(zzbnVar2.zza(timeUnit)));
        return (zzrl) zzrjVarZzf.zzk();
    }
}
