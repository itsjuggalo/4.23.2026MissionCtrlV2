package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzlz implements zzmc {
    private final String zza;

    public zzlz(String str) {
        this.zza = str;
    }

    public final int zza() {
        return Mac.getInstance(this.zza).getMacLength();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmc
    public final byte[] zzb() throws GeneralSecurityException {
        String str = this.zza;
        str.getClass();
        switch (str) {
            case "HmacSha256":
                return zzmk.zzf;
            case "HmacSha384":
                return zzmk.zzg;
            case "HmacSha512":
                return zzmk.zzh;
            default:
                throw new GeneralSecurityException("Could not determine HPKE KDF ID");
        }
    }

    private final byte[] zza(byte[] bArr, byte[] bArr2, int i10) throws GeneralSecurityException {
        Mac macZza = zzzj.zzb.zza(this.zza);
        if (i10 > macZza.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        byte[] bArr3 = new byte[i10];
        macZza.init(new SecretKeySpec(bArr, this.zza));
        byte[] bArrDoFinal = new byte[0];
        int i11 = 1;
        int length = 0;
        while (true) {
            macZza.update(bArrDoFinal);
            macZza.update(bArr2);
            macZza.update((byte) i11);
            bArrDoFinal = macZza.doFinal();
            if (bArrDoFinal.length + length >= i10) {
                System.arraycopy(bArrDoFinal, 0, bArr3, length, i10 - length);
                return bArr3;
            }
            System.arraycopy(bArrDoFinal, 0, bArr3, length, bArrDoFinal.length);
            length += bArrDoFinal.length;
            i11++;
        }
    }

    private final byte[] zza(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        Mac macZza = zzzj.zzb.zza(this.zza);
        if (bArr2 != null && bArr2.length != 0) {
            macZza.init(new SecretKeySpec(bArr2, this.zza));
        } else {
            macZza.init(new SecretKeySpec(new byte[macZza.getMacLength()], this.zza));
        }
        return macZza.doFinal(bArr);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i10) {
        return zza(zza(zzmk.zza(str, bArr2, bArr4), null), zzmk.zza(str2, bArr3, bArr4, i10), i10);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmc
    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i10) {
        return zza(bArr, zzmk.zza(str, bArr2, bArr3, i10), i10);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmc
    public final byte[] zza(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return zza(zzmk.zza(str, bArr2, bArr3), bArr);
    }
}
