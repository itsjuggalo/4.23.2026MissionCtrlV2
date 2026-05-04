package com.google.android.gms.internal.fido;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzae {
    private static final Object zza = new Object();
    private static final zzai zzb = new zzai();
    private static volatile zzae zzc = null;
    private static volatile zzae zzd = null;
    private static final zzbp zze = zzbt.zza(new zzbp() { // from class: com.google.android.gms.internal.fido.zzad
        @Override // com.google.android.gms.internal.fido.zzbp
        public final Object zza() {
            throw null;
        }
    });

    public static zzae zza() {
        zzah.zza();
        zzah.zzb();
        zzah.zzd();
        throw new IllegalStateException("Must call PhenotypeContext.setContext() first");
    }

    public static boolean zzb() {
        zzah.zzd();
        zzah.zzc();
        return false;
    }
}
