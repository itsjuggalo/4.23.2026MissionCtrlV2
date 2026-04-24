package com.google.android.gms.internal.p002firebaseauthapi;

import a3.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class zzyu implements zzaaa {
    private static final zziv.zza zza = zziv.zza.zzb;
    private static final ThreadLocal<Cipher> zzb = new zzyt();
    private final SecretKeySpec zzc;
    private final int zzd;
    private final int zze;

    public zzyu(byte[] bArr, int i) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzaai.zza(bArr.length);
        this.zzc = new SecretKeySpec(bArr, "AES");
        int blockSize = zzb.get().getBlockSize();
        this.zze = blockSize;
        if (i < 12 || i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzd = i;
    }

    private final void zza(byte[] bArr, int i, int i6, byte[] bArr2, int i7, byte[] bArr3, boolean z6) throws GeneralSecurityException {
        Cipher cipher = zzb.get();
        byte[] bArr4 = new byte[this.zze];
        System.arraycopy(bArr3, 0, bArr4, 0, this.zzd);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        if (z6) {
            cipher.init(1, this.zzc, ivParameterSpec);
        } else {
            cipher.init(2, this.zzc, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i, i6, bArr2, i7) != i6) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaaa
    public final byte[] zzb(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzd;
        if (length > f.API_PRIORITY_OTHER - i) {
            throw new GeneralSecurityException(d.f(f.API_PRIORITY_OTHER - this.zzd, "plaintext length can not exceed "));
        }
        byte[] bArr2 = new byte[bArr.length + i];
        byte[] bArrZza = zzqd.zza(i);
        System.arraycopy(bArrZza, 0, bArr2, 0, this.zzd);
        zza(bArr, 0, bArr.length, bArr2, this.zzd, bArrZza, true);
        return bArr2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaaa
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzd;
        if (length >= i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            int length2 = bArr.length;
            int i6 = this.zzd;
            byte[] bArr3 = new byte[length2 - i6];
            zza(bArr, i6, bArr.length - i6, bArr3, 0, bArr2, false);
            return bArr3;
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
