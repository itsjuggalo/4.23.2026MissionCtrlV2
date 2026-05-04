package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import n7.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzabl implements zzafv<zzahv> {
    final /* synthetic */ zzaar zza;
    private final /* synthetic */ zzajb zzb;
    private final /* synthetic */ zzael zzc;

    public zzabl(zzaar zzaarVar, zzajb zzajbVar, zzael zzaelVar) {
        this.zzb = zzajbVar;
        this.zzc = zzaelVar;
        Objects.requireNonNull(zzaarVar);
        this.zza = zzaarVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafs
    public final void zza(String str) {
        this.zzc.zza(r.a(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final /* synthetic */ void zza(zzahv zzahvVar) {
        this.zzb.zzb(true);
        this.zzb.zza(zzahvVar.zzc());
        this.zza.zza.zza(this.zzb, new zzabo(this, this.zzc, this));
    }
}
