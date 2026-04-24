package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class zzalb {
    static final Charset zza;
    public static final byte[] zzb;

    static {
        Charset.forName("US-ASCII");
        zza = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        zzakb.zza(bArr, 0, bArr.length, false);
    }

    public static int zza(long j4) {
        return (int) (j4 ^ (j4 >>> 32));
    }

    public static int zza(boolean z4) {
        return z4 ? 1231 : 1237;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        int iZza = zza(length, bArr, 0, length);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    public static int zza(int i4, byte[] bArr, int i5, int i6) {
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            i4 = (i4 * 31) + bArr[i7];
        }
        return i4;
    }

    public static <T> T zza(T t4) {
        t4.getClass();
        return t4;
    }

    public static <T> T zza(T t4, String str) {
        if (t4 != null) {
            return t4;
        }
        throw new NullPointerException(str);
    }

    public static boolean zza(zzamc zzamcVar) {
        boolean z4 = zzamcVar instanceof zzajh;
        return false;
    }
}
