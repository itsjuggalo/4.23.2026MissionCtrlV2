package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import n7.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzabh implements zzafv<zzahv> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzael zze;
    private final /* synthetic */ zzaar zzf;

    public zzabh(zzaar zzaarVar, String str, String str2, String str3, String str4, zzael zzaelVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = zzaelVar;
        Objects.requireNonNull(zzaarVar);
        this.zzf = zzaarVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafs
    public final void zza(String str) {
        this.zze.zza(r.a(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final /* synthetic */ void zza(zzahv zzahvVar) {
        zzaar.zza(this.zzf, this.zze, new zzaim(this.zza, this.zzb, null, this.zzc, this.zzd, zzahvVar.zzc()), this);
    }
}
