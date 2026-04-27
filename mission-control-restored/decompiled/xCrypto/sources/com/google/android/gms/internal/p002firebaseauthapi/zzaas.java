package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzaas implements zzafn<zzahd> {
    private final /* synthetic */ zzafk zza;
    private final /* synthetic */ zzaeg zzb;
    private final /* synthetic */ zzahn zzc;
    private final /* synthetic */ zzaid zzd;
    private final /* synthetic */ zzaam zze;

    public zzaas(zzaam zzaamVar, zzafk zzafkVar, zzaeg zzaegVar, zzahn zzahnVar, zzaid zzaidVar) {
        this.zza = zzafkVar;
        this.zzb = zzaegVar;
        this.zzc = zzahnVar;
        this.zzd = zzaidVar;
        this.zze = zzaamVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzahd zzahdVar) {
        List<zzahc> listZza = zzahdVar.zza();
        if (listZza == null || listZza.isEmpty()) {
            this.zza.zza("No users");
        } else {
            zzaam.zza(this.zze, this.zzb, this.zzc, listZza.get(0), this.zzd, this.zza);
        }
    }
}
