package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzbz {
    private static final CopyOnWriteArrayList<zzca> zza = new CopyOnWriteArrayList<>();

    public static zzca zza(String str) throws GeneralSecurityException {
        for (zzca zzcaVar : zza) {
            if (zzcaVar.zzb(str)) {
                return zzcaVar;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: " + str);
    }
}
