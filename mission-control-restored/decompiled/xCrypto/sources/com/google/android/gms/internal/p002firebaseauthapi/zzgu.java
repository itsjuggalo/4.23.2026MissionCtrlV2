package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class zzgu {
    private static final ThreadLocal<Cipher> zza = new zzgt();

    public static AlgorithmParameterSpec zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public static SecretKey zzb(byte[] bArr) throws InvalidAlgorithmParameterException {
        zzzz.zza(bArr.length);
        return new SecretKeySpec(bArr, "AES");
    }

    public static AlgorithmParameterSpec zza(byte[] bArr, int i4, int i5) {
        Integer numZzb = zzqq.zzb();
        return (numZzb == null || numZzb.intValue() > 19) ? new GCMParameterSpec(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS, bArr, i4, i5) : new IvParameterSpec(bArr, i4, i5);
    }

    public static Cipher zza() {
        return zza.get();
    }
}
