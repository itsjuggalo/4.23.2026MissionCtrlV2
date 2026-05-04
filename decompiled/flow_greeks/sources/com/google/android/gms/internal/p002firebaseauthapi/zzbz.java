package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbz {
    public static zzbm zza(zzbv zzbvVar, zzch zzchVar) {
        if (zzchVar != null) {
            return zzbm.zza(zzbvVar.zzb());
        }
        throw new NullPointerException("SecretKeyAccess cannot be null");
    }

    public static void zza(zzbm zzbmVar, zzby zzbyVar, zzch zzchVar) {
        if (zzchVar != null) {
            zzbyVar.zza(zzbmVar.zzd());
            return;
        }
        throw new NullPointerException("SecretKeyAccess cannot be null");
    }
}
