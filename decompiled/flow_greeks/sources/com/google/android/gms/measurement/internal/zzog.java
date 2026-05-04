package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.s;
import t5.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzog {
    private final e zza;
    private long zzb;

    public zzog(e eVar) {
        s.k(eVar);
        this.zza = eVar;
    }

    public final void zza() {
        this.zzb = this.zza.b();
    }

    public final void zzb() {
        this.zzb = 0L;
    }

    public final boolean zzc(long j10) {
        return this.zzb == 0 || this.zza.b() - this.zzb >= 3600000;
    }
}
