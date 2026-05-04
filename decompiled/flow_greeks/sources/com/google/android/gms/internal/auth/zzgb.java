package com.google.android.gms.internal.auth;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzgb implements zzgi {
    private final zzfx zza;
    private final zzgz zzb;
    private final zzem zzc;

    private zzgb(zzgz zzgzVar, zzem zzemVar, zzfx zzfxVar) {
        this.zzb = zzgzVar;
        this.zzc = zzemVar;
        this.zza = zzfxVar;
    }

    public static zzgb zzb(zzgz zzgzVar, zzem zzemVar, zzfx zzfxVar) {
        return new zzgb(zzgzVar, zzemVar, zzfxVar);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final int zza(Object obj) {
        return this.zzb.zzb(obj).hashCode();
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final Object zzd() {
        zzfx zzfxVar = this.zza;
        return zzfxVar instanceof zzev ? ((zzev) zzfxVar).zzc() : ((zzet) ((zzev) zzfxVar).zzn(5, null, null)).zzd();
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zze(Object obj) {
        this.zzb.zze(obj);
        this.zzc.zzb(obj);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzf(Object obj, Object obj2) {
        zzgk.zzd(this.zzb, obj, obj2);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzg(Object obj, byte[] bArr, int i10, int i11, zzdt zzdtVar) {
        zzev zzevVar = (zzev) obj;
        if (zzevVar.zzc == zzha.zza()) {
            zzevVar.zzc = zzha.zzd();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final boolean zzh(Object obj, Object obj2) {
        return this.zzb.zzb(obj).equals(this.zzb.zzb(obj2));
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final boolean zzi(Object obj) {
        this.zzc.zza(obj);
        throw null;
    }
}
