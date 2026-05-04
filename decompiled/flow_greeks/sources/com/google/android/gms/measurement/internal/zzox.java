package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzox implements zzgw {
    final /* synthetic */ String zza;
    final /* synthetic */ zzpj zzb;
    final /* synthetic */ zzpg zzc;

    public zzox(zzpg zzpgVar, String str, zzpj zzpjVar) {
        this.zza = str;
        this.zzb = zzpjVar;
        Objects.requireNonNull(zzpgVar);
        this.zzc = zzpgVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgw
    public final void zza(String str, int i10, Throwable th, byte[] bArr, Map map) {
        this.zzc.zzQ(this.zza, i10, th, bArr, this.zzb);
    }
}
