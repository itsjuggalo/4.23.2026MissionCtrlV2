package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.AbstractC1294n;

/* JADX INFO: loaded from: classes.dex */
final class zzog {
    private final W1.e zza;
    private long zzb;

    public zzog(W1.e eVar) {
        AbstractC1294n.j(eVar);
        this.zza = eVar;
    }

    public final void zza() {
        this.zzb = this.zza.b();
    }

    public final void zzb() {
        this.zzb = 0L;
    }

    public final boolean zzc(long j8) {
        return this.zzb == 0 || this.zza.b() - this.zzb >= 3600000;
    }
}
