package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class zzmo {
    static final Charset zza;
    public static final byte[] zzb;

    static {
        Charset.forName("US-ASCII");
        zza = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        int i4 = zzli.zza;
        try {
            new zzlh(bArr, 0, 0, false, null).zza(0);
        } catch (zzmq e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static Object zza(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("messageType");
    }

    public static int zzb(boolean z4) {
        return z4 ? 1231 : 1237;
    }

    public static int zzc(int i4, byte[] bArr, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            i4 = (i4 * 31) + bArr[i7];
        }
        return i4;
    }

    public static boolean zzd(zznl zznlVar) {
        if (zznlVar instanceof zzks) {
            throw null;
        }
        return false;
    }
}
