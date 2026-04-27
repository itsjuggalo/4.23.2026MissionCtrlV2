package com.google.android.gms.internal.common;

import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
final class zzo extends zzn {
    private final char zza;

    public zzo(char c6) {
        this.zza = c6;
    }

    public final String toString() {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        int i = this.zza;
        for (int i6 = 0; i6 < 4; i6++) {
            cArr[5 - i6] = "0123456789ABCDEF".charAt(i & 15);
            i >>= 4;
        }
        return AbstractC1024h.c("CharMatcher.is('", String.copyValueOf(cArr), "')");
    }

    @Override // com.google.android.gms.internal.common.zzr
    public final boolean zza(char c6) {
        return c6 == this.zza;
    }
}
