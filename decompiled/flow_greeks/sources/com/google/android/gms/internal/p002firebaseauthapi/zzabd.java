package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import n7.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzabd implements zzafv<zzajf> {
    private final /* synthetic */ zzael zza;
    private final /* synthetic */ zzaar zzb;

    public zzabd(zzaar zzaarVar, zzael zzaelVar) {
        this.zza = zzaelVar;
        Objects.requireNonNull(zzaarVar);
        this.zzb = zzaarVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafs
    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final /* synthetic */ void zza(zzajf zzajfVar) {
        zzajf zzajfVar2 = zzajfVar;
        this.zzb.zza(new zzahv(zzajfVar2.zzc(), zzajfVar2.zzb(), Long.valueOf(zzajfVar2.zza()), "Bearer"), null, null, Boolean.valueOf(zzajfVar2.zzd()), null, this.zza, this);
    }
}
