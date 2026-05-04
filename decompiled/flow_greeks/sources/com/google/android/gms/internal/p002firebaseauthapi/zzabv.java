package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import n7.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzabv implements zzafv<zzagy> {
    private final /* synthetic */ zzael zza;
    private final /* synthetic */ zzabw zzb;

    public zzabv(zzabw zzabwVar, zzael zzaelVar) {
        this.zza = zzaelVar;
        Objects.requireNonNull(zzabwVar);
        this.zzb = zzabwVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafs
    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final /* synthetic */ void zza(zzagy zzagyVar) {
        zzagy zzagyVar2 = zzagyVar;
        this.zzb.zza.zza(new zzahv(zzagyVar2.zzb(), zzagyVar2.zza(), Long.valueOf(zzahx.zza(zzagyVar2.zza())), "Bearer"), null, null, Boolean.FALSE, null, this.zza, this);
    }
}
