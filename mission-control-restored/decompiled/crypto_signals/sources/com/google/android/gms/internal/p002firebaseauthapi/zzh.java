package com.google.android.gms.internal.p002firebaseauthapi;

import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
final class zzh extends zzi {
    private final char zza;

    public zzh(char c6) {
        this.zza = c6;
    }

    public final String toString() {
        char c6 = this.zza;
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c6 & 15);
            c6 = (char) (c6 >> 4);
        }
        return AbstractC1024h.c("CharMatcher.is('", String.copyValueOf(cArr), "')");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzf
    public final boolean zza(char c6) {
        return c6 == this.zza;
    }
}
