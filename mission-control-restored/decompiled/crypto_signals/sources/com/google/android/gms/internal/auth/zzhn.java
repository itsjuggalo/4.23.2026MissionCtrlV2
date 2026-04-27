package com.google.android.gms.internal.auth;

/* JADX INFO: loaded from: classes.dex */
final class zzhn {
    public static final /* synthetic */ int zza = 0;
    private static final zzhl zzb;

    static {
        if (zzhj.zzu() && zzhj.zzv()) {
            int i = zzds.zza;
        }
        zzb = new zzhm();
    }

    public static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i, int i6) {
        int i7 = i6 - i;
        byte b3 = bArr[i - 1];
        if (i7 == 0) {
            if (b3 > -12) {
                return -1;
            }
            return b3;
        }
        if (i7 == 1) {
            byte b6 = bArr[i];
            if (b3 > -12 || b6 > -65) {
                return -1;
            }
            return (b6 << 8) ^ b3;
        }
        if (i7 != 2) {
            throw new AssertionError();
        }
        byte b7 = bArr[i];
        byte b8 = bArr[i + 1];
        if (b3 > -12 || b7 > -65 || b8 > -65) {
            return -1;
        }
        return (b8 << 16) ^ ((b7 << 8) ^ b3);
    }

    public static boolean zzb(byte[] bArr) {
        return zzb.zzb(bArr, 0, bArr.length);
    }

    public static boolean zzc(byte[] bArr, int i, int i6) {
        return zzb.zzb(bArr, i, i6);
    }
}
