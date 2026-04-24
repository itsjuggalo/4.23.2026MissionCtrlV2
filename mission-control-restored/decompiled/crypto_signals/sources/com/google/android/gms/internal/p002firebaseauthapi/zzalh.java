package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class zzalh {
    static final Charset zza;
    public static final byte[] zzb;

    static {
        Charset.forName("US-ASCII");
        zza = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        zzakh.zza(bArr, 0, bArr.length, false);
    }

    public static int zza(long j4) {
        return (int) (j4 ^ (j4 >>> 32));
    }

    public static int zza(boolean z6) {
        return z6 ? 1231 : 1237;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        int iZza = zza(length, bArr, 0, length);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    public static int zza(int i, byte[] bArr, int i6, int i7) {
        for (int i8 = i6; i8 < i6 + i7; i8++) {
            i = (i * 31) + bArr[i8];
        }
        return i;
    }

    public static <T> T zza(T t6) {
        t6.getClass();
        return t6;
    }

    public static <T> T zza(T t6, String str) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(str);
    }

    public static boolean zza(zzamm zzammVar) {
        boolean z6 = zzammVar instanceof zzajn;
        return false;
    }
}
