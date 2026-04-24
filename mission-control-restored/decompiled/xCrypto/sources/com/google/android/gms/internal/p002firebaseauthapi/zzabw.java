package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzabw implements zzafn<zzahd> {
    private final /* synthetic */ zzafn zza;
    private final /* synthetic */ zzaeg zzb;
    private final /* synthetic */ zzahn zzc;

    public zzabw(zzabt zzabtVar, zzafn zzafnVar, zzaeg zzaegVar, zzahn zzahnVar) {
        this.zza = zzafnVar;
        this.zzb = zzaegVar;
        this.zzc = zzahnVar;
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
            this.zzb.zza(this.zzc, listZza.get(0));
        }
    }
}
