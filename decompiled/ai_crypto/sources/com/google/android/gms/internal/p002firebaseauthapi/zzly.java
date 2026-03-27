package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
final class zzly implements zzmf {
    private final String zza;

    public zzly(String str) {
        this.zza = str;
    }

    public final int zza() {
        return Mac.getInstance(this.zza).getMacLength();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final byte[] zzb() throws GeneralSecurityException {
        String str = this.zza;
        str.hashCode();
        switch (str) {
            case "HmacSha256":
                return zzmn.zzf;
            case "HmacSha384":
                return zzmn.zzg;
            case "HmacSha512":
                return zzmn.zzh;
            default:
                throw new GeneralSecurityException("Could not determine HPKE KDF ID");
        }
    }

    private final byte[] zza(byte[] bArr, byte[] bArr2, int i7) throws GeneralSecurityException {
        Mac macZza = zzzd.zzb.zza(this.zza);
        if (i7 > macZza.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        byte[] bArr3 = new byte[i7];
        macZza.init(new SecretKeySpec(bArr, this.zza));
        byte[] bArrDoFinal = new byte[0];
        int i8 = 1;
        int length = 0;
        while (true) {
            macZza.update(bArrDoFinal);
            macZza.update(bArr2);
            macZza.update((byte) i8);
            bArrDoFinal = macZza.doFinal();
            if (bArrDoFinal.length + length >= i7) {
                System.arraycopy(bArrDoFinal, 0, bArr3, length, i7 - length);
                return bArr3;
            }
            System.arraycopy(bArrDoFinal, 0, bArr3, length, bArrDoFinal.length);
            length += bArrDoFinal.length;
            i8++;
        }
    }

    private final byte[] zza(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        Mac macZza = zzzd.zzb.zza(this.zza);
        if (bArr2 != null && bArr2.length != 0) {
            macZza.init(new SecretKeySpec(bArr2, this.zza));
        } else {
            macZza.init(new SecretKeySpec(new byte[macZza.getMacLength()], this.zza));
        }
        return macZza.doFinal(bArr);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i7) {
        return zza(zza(zzmn.zza(str, bArr2, bArr4), null), zzmn.zza(str2, bArr3, bArr4, i7), i7);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i7) {
        return zza(bArr, zzmn.zza(str, bArr2, bArr3, i7), i7);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return zza(zzmn.zza(str, bArr2, bArr3), bArr);
    }
}
