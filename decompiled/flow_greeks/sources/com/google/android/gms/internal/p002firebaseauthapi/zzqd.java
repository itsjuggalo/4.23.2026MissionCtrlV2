package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzqd {
    private static final ThreadLocal<SecureRandom> zza = new zzqg();

    public static /* synthetic */ SecureRandom zza() {
        SecureRandom secureRandomZzb = zzb();
        secureRandomZzb.nextLong();
        return secureRandomZzb;
    }

    private static SecureRandom zzb() {
        Provider providerZza = zznh.zza();
        if (providerZza != null) {
            try {
                return SecureRandom.getInstance("SHA1PRNG", providerZza);
            } catch (GeneralSecurityException unused) {
            }
        }
        Provider providerZzb = zznh.zzb();
        if (providerZzb != null) {
            try {
                return SecureRandom.getInstance("SHA1PRNG", providerZzb);
            } catch (GeneralSecurityException unused2) {
            }
        }
        return new SecureRandom();
    }

    public static byte[] zza(int i10) {
        byte[] bArr = new byte[i10];
        zza.get().nextBytes(bArr);
        return bArr;
    }
}
