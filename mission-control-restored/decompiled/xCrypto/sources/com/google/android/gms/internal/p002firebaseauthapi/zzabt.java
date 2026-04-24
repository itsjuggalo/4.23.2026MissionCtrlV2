package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: loaded from: classes.dex */
final class zzabt implements zzafn<zzahn> {
    private final /* synthetic */ zzaeg zza;
    private final /* synthetic */ zzaam zzb;

    public zzabt(zzaam zzaamVar, zzaeg zzaegVar) {
        this.zza = zzaegVar;
        this.zzb = zzaamVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzahn zzahnVar) {
        zzahn zzahnVar2 = zzahnVar;
        this.zzb.zza.zza(new zzaha(zzahnVar2.zzc()), new zzabw(this, this, this.zza, zzahnVar2));
    }
}
