package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: loaded from: classes.dex */
final class zzabh implements zzafn<zzahn> {
    final /* synthetic */ zzaam zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzaeg zzc;

    public zzabh(zzaam zzaamVar, String str, zzaeg zzaegVar) {
        this.zzb = str;
        this.zzc = zzaegVar;
        this.zza = zzaamVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zzc.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzahn zzahnVar) {
        zzahn zzahnVar2 = zzahnVar;
        this.zza.zza.zza(new zzaha(zzahnVar2.zzc()), new zzabk(this, this, zzahnVar2, this.zzb, this.zzc));
    }
}
