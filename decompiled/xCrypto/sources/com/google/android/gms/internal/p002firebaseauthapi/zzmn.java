package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzki;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzmn {
    public static final byte[] zza = zza(1, 0);
    public static final byte[] zzb;
    public static final byte[] zzc;
    public static final byte[] zzd;
    public static final byte[] zze;
    public static final byte[] zzf;
    public static final byte[] zzg;
    public static final byte[] zzh;
    public static final byte[] zzi;
    public static final byte[] zzj;
    public static final byte[] zzk;
    public static final byte[] zzl;
    private static final byte[] zzm;
    private static final byte[] zzn;
    private static final byte[] zzo;

    static {
        zza(1, 2);
        zzb = zza(2, 32);
        zzc = zza(2, 16);
        zzd = zza(2, 17);
        zze = zza(2, 18);
        zzf = zza(2, 1);
        zzg = zza(2, 2);
        zzh = zza(2, 3);
        zzi = zza(2, 1);
        zzj = zza(2, 2);
        zzk = zza(2, 3);
        zzl = new byte[0];
        Charset charset = zzqq.zza;
        zzm = "KEM".getBytes(charset);
        zzn = "HPKE".getBytes(charset);
        zzo = "HPKE-v1".getBytes(charset);
    }

    public static int zza(zzki.zzd zzdVar) throws GeneralSecurityException {
        if (zzdVar == zzki.zzd.zzd || zzdVar == zzki.zzd.zza) {
            return 32;
        }
        if (zzdVar == zzki.zzd.zzb) {
            return 48;
        }
        if (zzdVar == zzki.zzd.zzc) {
            return 66;
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    public static int zzb(zzki.zzd zzdVar) throws GeneralSecurityException {
        if (zzdVar == zzki.zzd.zzd) {
            return 32;
        }
        if (zzdVar == zzki.zzd.zza) {
            return 65;
        }
        if (zzdVar == zzki.zzd.zzb) {
            return 97;
        }
        if (zzdVar == zzki.zzd.zzc) {
            return 133;
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    public static zzzc zzc(zzki.zzd zzdVar) throws GeneralSecurityException {
        if (zzdVar == zzki.zzd.zza) {
            return zzzc.NIST_P256;
        }
        if (zzdVar == zzki.zzd.zzb) {
            return zzzc.NIST_P384;
        }
        if (zzdVar == zzki.zzd.zzc) {
            return zzzc.NIST_P521;
        }
        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
    }

    public static byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return zzyt.zza(zzn, bArr, bArr2, bArr3);
    }

    private static byte[] zza(int i4, int i5) {
        if (i4 > 4 || i4 < 0) {
            throw new IllegalArgumentException("capacity must be between 0 and 4");
        }
        if (i5 >= 0 && (i4 >= 4 || i5 < (1 << (i4 << 3)))) {
            byte[] bArr = new byte[i4];
            for (int i6 = 0; i6 < i4; i6++) {
                bArr[i6] = (byte) (i5 >> (((i4 - i6) - 1) * 8));
            }
            return bArr;
        }
        throw new IllegalArgumentException("value too large");
    }

    public static byte[] zza(byte[] bArr) {
        return zzyt.zza(zzm, bArr);
    }

    public static byte[] zza(String str, byte[] bArr, byte[] bArr2) {
        return zzyt.zza(zzo, bArr2, str.getBytes(zzqq.zza), bArr);
    }

    public static byte[] zza(String str, byte[] bArr, byte[] bArr2, int i4) {
        return zzyt.zza(zza(2, i4), zzo, bArr2, str.getBytes(zzqq.zza), bArr);
    }
}
