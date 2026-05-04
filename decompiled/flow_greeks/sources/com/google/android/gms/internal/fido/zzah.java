package com.google.android.gms.internal.fido;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzah {
    private static final Object zza = new Object();
    private static volatile boolean zzb = false;
    private static volatile zzag zzc = null;
    private static volatile boolean zzd = false;
    private static volatile zzag zze;

    public static void zza() {
        zzd = true;
    }

    public static void zzb() {
        if (zze == null) {
            zze = new zzag(null);
        }
    }

    public static void zzc() {
        if (zzc == null) {
            zzc = new zzag(null);
        }
    }

    public static boolean zzd() {
        synchronized (zza) {
        }
        return false;
    }
}
