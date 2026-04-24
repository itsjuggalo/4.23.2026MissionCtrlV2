package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
public final class zzzv implements zzso {
    private static final zzix.zza zza = zzix.zza.zzb;
    private final ThreadLocal<Mac> zzb;
    private final String zzc;
    private final Key zzd;
    private final int zze;

    public zzzv(String str, Key key) throws GeneralSecurityException {
        zzzy zzzyVar = new zzzy(this);
        this.zzb = zzzyVar;
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.zzc = str;
        this.zzd = key;
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        str.hashCode();
        switch (str) {
            case "HMACSHA1":
                this.zze = 20;
                break;
            case "HMACSHA224":
                this.zze = 28;
                break;
            case "HMACSHA256":
                this.zze = 32;
                break;
            case "HMACSHA384":
                this.zze = 48;
                break;
            case "HMACSHA512":
                this.zze = 64;
                break;
            default:
                throw new NoSuchAlgorithmException("unknown Hmac algorithm: " + str);
        }
        zzzyVar.get();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzso
    public final byte[] zza(byte[] bArr, int i7) throws InvalidAlgorithmParameterException {
        if (i7 > this.zze) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        this.zzb.get().update(bArr);
        return Arrays.copyOf(this.zzb.get().doFinal(), i7);
    }
}
