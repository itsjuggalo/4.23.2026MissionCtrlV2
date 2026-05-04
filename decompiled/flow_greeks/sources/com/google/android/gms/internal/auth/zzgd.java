package com.google.android.gms.internal.auth;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzgd {
    private static final zzgc zza;
    private static final zzgc zzb;

    static {
        zzgc zzgcVar = null;
        try {
            zzgcVar = (zzgc) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzgcVar;
        zzb = new zzgc();
    }

    public static zzgc zza() {
        return zza;
    }

    public static zzgc zzb() {
        return zzb;
    }
}
