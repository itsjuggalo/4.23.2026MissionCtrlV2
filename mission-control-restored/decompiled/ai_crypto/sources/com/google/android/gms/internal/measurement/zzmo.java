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
        int i7 = zzli.zza;
        try {
            new zzlh(bArr, 0, 0, false, null).zza(0);
        } catch (zzmq e7) {
            throw new IllegalArgumentException(e7);
        }
    }

    public static Object zza(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("messageType");
    }

    public static int zzb(boolean z7) {
        return z7 ? 1231 : 1237;
    }

    public static int zzc(int i7, byte[] bArr, int i8, int i9) {
        for (int i10 = 0; i10 < i9; i10++) {
            i7 = (i7 * 31) + bArr[i10];
        }
        return i7;
    }

    public static boolean zzd(zznl zznlVar) {
        if (zznlVar instanceof zzks) {
            throw null;
        }
        return false;
    }
}
