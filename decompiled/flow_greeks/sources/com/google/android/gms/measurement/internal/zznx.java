package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zznx implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zzny zzc;

    public zznx(zzny zznyVar, long j10, long j11) {
        Objects.requireNonNull(zznyVar);
        this.zzc = zznyVar;
        this.zza = j10;
        this.zzb = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzu.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zznx zznxVar = this.zza;
                zzoc zzocVar = zznxVar.zzc.zza;
                zzocVar.zzg();
                zzic zzicVar = zzocVar.zzu;
                zzicVar.zzaV().zzj().zza("Application going to the background");
                zzicVar.zzd().zzn.zzb(true);
                zzocVar.zzh(true);
                if (!zzicVar.zzc().zzv()) {
                    long j10 = zznxVar.zzb;
                    zzoa zzoaVar = zzocVar.zzb;
                    zzoaVar.zzd(false, false, j10);
                    zzoaVar.zzb(j10);
                }
                zzicVar.zzaV().zzi().zzb("Application backgrounded at: timestamp_millis", Long.valueOf(zznxVar.zza));
                zzic zzicVar2 = zzocVar.zzu;
                zzlj zzljVarZzj = zzicVar2.zzj();
                zzljVarZzj.zzg();
                zzic zzicVar3 = zzljVarZzj.zzu;
                zzljVarZzj.zzb();
                zznl zznlVarZzt = zzicVar3.zzt();
                zznlVarZzt.zzg();
                zznlVarZzt.zzb();
                if (!zznlVarZzt.zzK() || zznlVarZzt.zzu.zzk().zzah() >= 242600) {
                    zzicVar3.zzt().zzF();
                }
                if (zzicVar.zzc().zzp(null, zzfy.zzaN)) {
                    long jZzl = zzicVar.zzk().zzaa(zzicVar.zzaY().getPackageName(), zzicVar.zzc().zzz()) ? 1000L : zzicVar.zzc().zzl(zzicVar.zzaY().getPackageName(), zzfy.zzD);
                    zzicVar.zzaV().zzk().zzb("[sgtm] Scheduling batch upload with minimum latency in millis", Long.valueOf(jZzl));
                    zzicVar2.zzx().zzh(jZzl);
                }
            }
        });
    }
}
