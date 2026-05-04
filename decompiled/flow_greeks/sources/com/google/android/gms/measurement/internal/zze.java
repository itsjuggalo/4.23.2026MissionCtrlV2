package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zze {
    private final zzji zza;

    public zze(zzji zzjiVar) {
        this.zza = zzjiVar;
    }

    public static zze zzc(String str) {
        return new zze((TextUtils.isEmpty(str) || str.length() > 1) ? zzji.UNINITIALIZED : zzjl.zzj(str.charAt(0)));
    }

    public final zzji zza() {
        return this.zza;
    }

    public final String zzb() {
        return String.valueOf(zzjl.zzm(this.zza));
    }
}
