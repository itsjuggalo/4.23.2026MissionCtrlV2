package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import java.util.Objects;
import n7.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzabp implements zzafv<zzahl> {
    private final /* synthetic */ zzafv zza;
    private final /* synthetic */ zzahv zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzael zzd;
    private final /* synthetic */ zzabq zze;

    public zzabp(zzabq zzabqVar, zzafv zzafvVar, zzahv zzahvVar, String str, zzael zzaelVar) {
        this.zza = zzafvVar;
        this.zzb = zzahvVar;
        this.zzc = str;
        this.zzd = zzaelVar;
        Objects.requireNonNull(zzabqVar);
        this.zze = zzabqVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafs
    public final void zza(String str) {
        this.zzd.zza(r.a(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafv
    public final /* synthetic */ void zza(zzahl zzahlVar) {
        List<zzahk> listZza = zzahlVar.zza();
        if (listZza != null && !listZza.isEmpty()) {
            zzahk zzahkVar = listZza.get(0);
            zzail zzailVar = new zzail();
            zzailVar.zzd(this.zzb.zzc()).zza(this.zzc);
            zzaar.zza(this.zze.zza, this.zzd, this.zzb, zzahkVar, zzailVar, this.zza);
            return;
        }
        this.zza.zza("No users.");
    }
}
