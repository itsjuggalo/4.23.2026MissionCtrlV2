package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzaoc {
    private static boolean zza(byte b3) {
        return b3 > -65;
    }

    public static /* synthetic */ void zza(byte b3, byte b6, byte b7, byte b8, char[] cArr, int i) throws zzall {
        if (!zza(b6)) {
            if ((((b6 + 112) + (b3 << 28)) >> 30) == 0 && !zza(b7) && !zza(b8)) {
                int i6 = ((b3 & 7) << 18) | ((b6 & 63) << 12) | ((b7 & 63) << 6) | (b8 & 63);
                cArr[i] = (char) ((i6 >>> 10) + 55232);
                cArr[i + 1] = (char) ((i6 & 1023) + 56320);
                return;
            }
        }
        throw zzall.zzd();
    }

    public static /* synthetic */ void zza(byte b3, char[] cArr, int i) {
        cArr[i] = (char) b3;
    }

    public static /* synthetic */ void zza(byte b3, byte b6, byte b7, char[] cArr, int i) throws zzall {
        if (!zza(b6) && ((b3 != -32 || b6 >= -96) && ((b3 != -19 || b6 < -96) && !zza(b7)))) {
            cArr[i] = (char) (((b3 & 15) << 12) | ((b6 & 63) << 6) | (b7 & 63));
            return;
        }
        throw zzall.zzd();
    }

    public static /* synthetic */ void zza(byte b3, byte b6, char[] cArr, int i) throws zzall {
        if (b3 >= -62 && !zza(b6)) {
            cArr[i] = (char) (((b3 & 31) << 6) | (b6 & 63));
            return;
        }
        throw zzall.zzd();
    }
}
