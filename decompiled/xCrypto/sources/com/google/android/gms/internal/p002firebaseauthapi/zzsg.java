package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzsg implements zzqz {
    private static final zzix.zza zza = zzix.zza.zzb;

    public zzsg(zzrc zzrcVar) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
    }
}
