package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzne implements Runnable {
    final /* synthetic */ m5.b zza;
    final /* synthetic */ zznf zzb;

    public zzne(zznf zznfVar, m5.b bVar) {
        this.zza = bVar;
        Objects.requireNonNull(zznfVar);
        this.zzb = zznfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.zzb.zza;
        zznlVar.zzaa(null);
        if (this.zza.R() != 7777) {
            zznlVar.zzX();
            return;
        }
        if (zznlVar.zzab() == null) {
            zznlVar.zzac(Executors.newScheduledThreadPool(1));
        }
        zznlVar.zzab().schedule(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznc
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                final zznl zznlVar2 = this.zza.zzb.zza;
                zznlVar2.zzu.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznd
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zznlVar2.zzI();
                    }
                });
            }
        }, ((Long) zzfy.zzZ.zzb(null)).longValue(), TimeUnit.MILLISECONDS);
    }
}
