package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzans {
    private static boolean zza(byte b4) {
        return b4 > -65;
    }

    public static /* synthetic */ void zza(byte b4, byte b5, byte b6, byte b7, char[] cArr, int i4) throws zzalf {
        if (zza(b5) || (((b4 << 28) + (b5 + 112)) >> 30) != 0 || zza(b6) || zza(b7)) {
            throw zzalf.zzd();
        }
        int i5 = ((b4 & 7) << 18) | ((b5 & 63) << 12) | ((b6 & 63) << 6) | (b7 & 63);
        cArr[i4] = (char) ((i5 >>> 10) + 55232);
        cArr[i4 + 1] = (char) ((i5 & 1023) + 56320);
    }

    public static /* synthetic */ void zza(byte b4, char[] cArr, int i4) {
        cArr[i4] = (char) b4;
    }

    public static /* synthetic */ void zza(byte b4, byte b5, byte b6, char[] cArr, int i4) throws zzalf {
        if (!zza(b5) && ((b4 != -32 || b5 >= -96) && ((b4 != -19 || b5 < -96) && !zza(b6)))) {
            cArr[i4] = (char) (((b4 & 15) << 12) | ((b5 & 63) << 6) | (b6 & 63));
            return;
        }
        throw zzalf.zzd();
    }

    public static /* synthetic */ void zza(byte b4, byte b5, char[] cArr, int i4) throws zzalf {
        if (b4 >= -62 && !zza(b5)) {
            cArr[i4] = (char) (((b4 & 31) << 6) | (b5 & 63));
            return;
        }
        throw zzalf.zzd();
    }
}
