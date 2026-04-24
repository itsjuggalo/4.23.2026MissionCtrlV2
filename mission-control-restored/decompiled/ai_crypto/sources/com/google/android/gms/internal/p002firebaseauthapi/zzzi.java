package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzzi<JcePrimitiveT> implements zzzh<JcePrimitiveT> {
    private final zzzj<JcePrimitiveT> zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzzh
    public final JcePrimitiveT zza(String str) throws GeneralSecurityException {
        Iterator<Provider> it = zzzd.zza("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt").iterator();
        Exception exc = null;
        while (it.hasNext()) {
            try {
                return this.zza.zza(str, it.next());
            } catch (Exception e7) {
                if (exc == null) {
                    exc = e7;
                }
            }
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }

    private zzzi(zzzj<JcePrimitiveT> zzzjVar) {
        this.zza = zzzjVar;
    }
}
