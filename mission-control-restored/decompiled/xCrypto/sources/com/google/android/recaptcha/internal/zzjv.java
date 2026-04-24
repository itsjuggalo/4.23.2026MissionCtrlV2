package com.google.android.recaptcha.internal;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzjv {
    private static final char[] zza = "0123456789abcdef".toCharArray();
    public static final /* synthetic */ int zzb = 0;

    public final boolean equals(Object obj) {
        if (obj instanceof zzjv) {
            zzjv zzjvVar = (zzjv) obj;
            if (zzb() == zzjvVar.zzb() && zzc(zzjvVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (zzb() >= 32) {
            return zza();
        }
        byte[] bArrZze = zze();
        int i4 = bArrZze[0] & 255;
        for (int i5 = 1; i5 < bArrZze.length; i5++) {
            i4 |= (bArrZze[i5] & 255) << (i5 * 8);
        }
        return i4;
    }

    public final String toString() {
        byte[] bArrZze = zze();
        int length = bArrZze.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b4 : bArrZze) {
            char[] cArr = zza;
            sb.append(cArr[(b4 >> 4) & 15]);
            sb.append(cArr[b4 & 15]);
        }
        return sb.toString();
    }

    public abstract int zza();

    public abstract int zzb();

    public abstract boolean zzc(zzjv zzjvVar);

    public abstract byte[] zzd();

    public byte[] zze() {
        throw null;
    }
}
