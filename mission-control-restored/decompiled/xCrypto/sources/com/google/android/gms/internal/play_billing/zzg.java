package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
final class zzg {
    static final zzg zza;
    static final zzg zzb;
    final Throwable zzc;

    static {
        if (zzq.zza) {
            zzb = null;
            zza = null;
        } else {
            zzb = new zzg(false, null);
            zza = new zzg(true, null);
        }
    }

    public zzg(boolean z4, Throwable th) {
        this.zzc = th;
    }
}
