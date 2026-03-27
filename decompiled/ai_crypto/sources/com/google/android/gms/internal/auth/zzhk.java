package com.google.android.gms.internal.auth;

/* JADX INFO: loaded from: classes.dex */
final class zzhk {
    public static /* bridge */ /* synthetic */ void zza(byte b7, byte b8, byte b9, byte b10, char[] cArr, int i7) throws zzfb {
        if (zze(b8) || (((b7 << 28) + (b8 + 112)) >> 30) != 0 || zze(b9) || zze(b10)) {
            throw zzfb.zzb();
        }
        int i8 = ((b7 & 7) << 18) | ((b8 & 63) << 12) | ((b9 & 63) << 6) | (b10 & 63);
        cArr[i7] = (char) ((i8 >>> 10) + 55232);
        cArr[i7 + 1] = (char) ((i8 & 1023) + 56320);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0016 A[PHI: r2
      0x0016: PHI (r2v3 byte) = (r2v2 byte), (r2v9 byte) binds: [B:9:0x0011, B:11:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* bridge */ /* synthetic */ void zzb(byte r2, byte r3, byte r4, char[] r5, int r6) throws com.google.android.gms.internal.auth.zzfb {
        /*
            boolean r0 = zze(r3)
            if (r0 != 0) goto L2c
            r0 = -96
            r1 = -32
            if (r2 != r1) goto Lf
            if (r3 < r0) goto L2c
            r2 = r1
        Lf:
            r1 = -19
            if (r2 != r1) goto L16
            if (r3 >= r0) goto L2c
            r2 = r1
        L16:
            boolean r0 = zze(r4)
            if (r0 != 0) goto L2c
            r2 = r2 & 15
            r3 = r3 & 63
            r4 = r4 & 63
            int r2 = r2 << 12
            int r3 = r3 << 6
            r2 = r2 | r3
            r2 = r2 | r4
            char r2 = (char) r2
            r5[r6] = r2
            return
        L2c:
            com.google.android.gms.internal.auth.zzfb r2 = com.google.android.gms.internal.auth.zzfb.zzb()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzhk.zzb(byte, byte, byte, char[], int):void");
    }

    public static /* bridge */ /* synthetic */ void zzc(byte b7, byte b8, char[] cArr, int i7) throws zzfb {
        if (b7 < -62 || zze(b8)) {
            throw zzfb.zzb();
        }
        cArr[i7] = (char) (((b7 & 31) << 6) | (b8 & 63));
    }

    public static /* bridge */ /* synthetic */ boolean zzd(byte b7) {
        return b7 >= 0;
    }

    private static boolean zze(byte b7) {
        return b7 > -65;
    }
}
