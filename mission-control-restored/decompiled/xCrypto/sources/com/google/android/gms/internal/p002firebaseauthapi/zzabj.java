package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* JADX INFO: loaded from: classes.dex */
final class zzabj implements zzafn<zzahn> {
    final /* synthetic */ zzaam zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzaeg zzd;

    public zzabj(zzaam zzaamVar, String str, String str2, zzaeg zzaegVar) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzaegVar;
        this.zza = zzaamVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafk
    public final void zza(String str) {
        this.zzd.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafn
    public final /* synthetic */ void zza(zzahn zzahnVar) {
        this.zza.zza.zza(new zzaja(zzahnVar.zzc(), this.zzb, this.zzc), new zzabm(this, this.zzd));
    }
}
