package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.SparseArray;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzjw implements u6.c {
    final /* synthetic */ zzoh zza;
    final /* synthetic */ zzlj zzb;

    public zzjw(zzlj zzljVar, zzoh zzohVar) {
        this.zza = zzohVar;
        Objects.requireNonNull(zzljVar);
        this.zzb = zzljVar;
    }

    private final void zza() {
        zzic zzicVar = this.zzb.zzu;
        SparseArray sparseArrayZzf = zzicVar.zzd().zzf();
        zzoh zzohVar = this.zza;
        sparseArrayZzf.put(zzohVar.zzc, Long.valueOf(zzohVar.zzb));
        zzhh zzhhVarZzd = zzicVar.zzd();
        int[] iArr = new int[sparseArrayZzf.size()];
        long[] jArr = new long[sparseArrayZzf.size()];
        for (int i10 = 0; i10 < sparseArrayZzf.size(); i10++) {
            iArr[i10] = sparseArrayZzf.keyAt(i10);
            jArr[i10] = ((Long) sparseArrayZzf.valueAt(i10)).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        zzhhVarZzd.zzi.zzb(bundle);
    }

    @Override // u6.c
    public final void onFailure(Throwable th) {
        zzlj zzljVar = this.zzb;
        zzljVar.zzg();
        zzljVar.zzam(false);
        zzic zzicVar = zzljVar.zzu;
        int iZzaq = (zzicVar.zzc().zzp(null, zzfy.zzaT) ? zzljVar.zzaq(th) : 2) - 1;
        if (iZzaq == 0) {
            zzicVar.zzaV().zze().zzc("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", zzgu.zzl(zzljVar.zzu.zzv().zzj()), zzgu.zzl(th.toString()));
            zzljVar.zzao(1);
            zzljVar.zzy().add(this.zza);
            return;
        }
        if (iZzaq != 1) {
            zzicVar.zzaV().zzb().zzc("registerTriggerAsync failed. Dropping URI. App ID, Throwable", zzgu.zzl(zzljVar.zzu.zzv().zzj()), th);
            zza();
            zzljVar.zzao(1);
            zzljVar.zzz();
            return;
        }
        zzljVar.zzy().add(this.zza);
        if (zzljVar.zzan() > ((Integer) zzfy.zzaw.zzb(null)).intValue()) {
            zzljVar.zzao(1);
            zzicVar.zzaV().zze().zzc("registerTriggerAsync failed. May try later. App ID, throwable", zzgu.zzl(zzljVar.zzu.zzv().zzj()), zzgu.zzl(th.toString()));
        } else {
            zzicVar.zzaV().zze().zzd("registerTriggerAsync failed. App ID, delay in seconds, throwable", zzgu.zzl(zzljVar.zzu.zzv().zzj()), zzgu.zzl(String.valueOf(zzljVar.zzan())), zzgu.zzl(th.toString()));
            zzljVar.zzai(zzljVar.zzan());
            int iZzan = zzljVar.zzan();
            zzljVar.zzao(iZzan + iZzan);
        }
    }

    @Override // u6.c
    public final void onSuccess(Object obj) {
        zzlj zzljVar = this.zzb;
        zzljVar.zzg();
        zza();
        zzljVar.zzam(false);
        zzljVar.zzao(1);
        zzljVar.zzu.zzaV().zzj().zzb("Successfully registered trigger URI", this.zza.zza);
        zzljVar.zzz();
    }
}
