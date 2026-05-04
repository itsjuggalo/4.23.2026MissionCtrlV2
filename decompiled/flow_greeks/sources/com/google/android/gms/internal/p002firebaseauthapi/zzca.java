package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzca {
    private static final CopyOnWriteArrayList<zzbx> zza = new CopyOnWriteArrayList<>();

    public static zzbx zza(String str) throws GeneralSecurityException {
        for (zzbx zzbxVar : zza) {
            if (zzbxVar.zzb(str)) {
                return zzbxVar;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: " + str);
    }
}
