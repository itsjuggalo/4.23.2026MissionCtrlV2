package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class zzca {
    private static final CopyOnWriteArrayList<zzbx> zza = new CopyOnWriteArrayList<>();

    public static zzbx zza(String str) throws GeneralSecurityException {
        for (zzbx zzbxVar : zza) {
            if (zzbxVar.zzb(str)) {
                return zzbxVar;
            }
        }
        throw new GeneralSecurityException(AbstractC1024h.b("No KMS client does support: ", str));
    }
}
