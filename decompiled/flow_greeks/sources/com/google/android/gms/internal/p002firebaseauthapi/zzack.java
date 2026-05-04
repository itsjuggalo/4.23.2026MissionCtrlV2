package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import m7.c1;
import n7.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzack implements zzafv<zzahv> {
    private final /* synthetic */ c1 zza;
    private final /* synthetic */ zzael zzb;
    private final /* synthetic */ zzaar zzc;

    public zzack(zzaar zzaarVar, c1 c1Var, zzael zzaelVar) {
        this.zza = c1Var;
        this.zzb = zzaelVar;
        Objects.requireNonNull(zzaarVar);
        this.zzc = zzaarVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafs
    public final void zza(String str) {
        this.zzb.zza(r.a(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final /* synthetic */ void zza(zzahv zzahvVar) {
        zzahv zzahvVar2 = zzahvVar;
        zzail zzailVar = new zzail();
        zzailVar.zzd(zzahvVar2.zzc());
        if (this.zza.S() || this.zza.v() != null) {
            zzailVar.zzb(this.zza.v());
        }
        if (this.zza.zzc() || this.zza.R() != null) {
            zzailVar.zzg(this.zza.zza());
        }
        zzaar.zza(this.zzc, this.zzb, zzahvVar2, zzailVar, this);
    }
}
