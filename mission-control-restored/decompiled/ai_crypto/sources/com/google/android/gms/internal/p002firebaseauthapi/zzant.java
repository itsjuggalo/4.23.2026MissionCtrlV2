package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzant {
    private static final zzanv zza;

    static {
        if (zzanp.zzc()) {
            zzanp.zzd();
        }
        zza = new zzanu();
    }

    public static /* synthetic */ int zza(byte[] bArr, int i7, int i8) {
        byte b7 = bArr[i7 - 1];
        int i9 = i8 - i7;
        if (i9 == 0) {
            if (b7 > -12) {
                return -1;
            }
            return b7;
        }
        if (i9 == 1) {
            byte b8 = bArr[i7];
            if (b7 > -12 || b8 > -65) {
                return -1;
            }
            return (b8 << 8) ^ b7;
        }
        if (i9 != 2) {
            throw new AssertionError();
        }
        byte b9 = bArr[i7];
        byte b10 = bArr[i7 + 1];
        if (b7 > -12 || b9 > -65 || b10 > -65) {
            return -1;
        }
        return (b10 << 16) ^ ((b9 << 8) ^ b7);
    }

    public static String zzb(byte[] bArr, int i7, int i8) {
        return zza.zza(bArr, i7, i8);
    }

    public static boolean zzc(byte[] bArr, int i7, int i8) {
        return zza.zza(0, bArr, i7, i8) == 0;
    }

    public static int zza(String str, byte[] bArr, int i7, int i8) {
        return zza.zza(str, bArr, i7, i8);
    }

    public static int zza(String str) {
        int length = str.length();
        int i7 = 0;
        int i8 = 0;
        while (i8 < length && str.charAt(i8) < 128) {
            i8++;
        }
        int i9 = length;
        while (true) {
            if (i8 >= length) {
                break;
            }
            char cCharAt = str.charAt(i8);
            if (cCharAt < 2048) {
                i9 += (127 - cCharAt) >>> 31;
                i8++;
            } else {
                int length2 = str.length();
                while (i8 < length2) {
                    char cCharAt2 = str.charAt(i8);
                    if (cCharAt2 < 2048) {
                        i7 += (127 - cCharAt2) >>> 31;
                    } else {
                        i7 += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i8) < 65536) {
                                throw new zzanx(i8, length2);
                            }
                            i8++;
                        }
                    }
                    i8++;
                }
                i9 += i7;
            }
        }
        if (i9 >= length) {
            return i9;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i9) + 4294967296L));
    }
}
