package com.google.android.gms.internal.p002firebaseauthapi;

import k0.a;

/* JADX INFO: loaded from: classes.dex */
final class zzaoa {
    private static final zzaob zza;

    static {
        if (zzanz.zzc()) {
            zzanz.zzd();
        }
        zza = new zzaoe();
    }

    public static /* synthetic */ int zza(byte[] bArr, int i, int i6) {
        byte b3 = bArr[i - 1];
        int i7 = i6 - i;
        if (i7 == 0) {
            if (b3 > -12) {
                return -1;
            }
            return b3;
        }
        if (i7 == 1) {
            byte b6 = bArr[i];
            if (b3 > -12 || b6 > -65) {
                return -1;
            }
            return (b6 << 8) ^ b3;
        }
        if (i7 != 2) {
            throw new AssertionError();
        }
        byte b7 = bArr[i];
        byte b8 = bArr[i + 1];
        if (b3 > -12 || b7 > -65 || b8 > -65) {
            return -1;
        }
        return (b8 << 16) ^ ((b7 << 8) ^ b3);
    }

    public static String zzb(byte[] bArr, int i, int i6) {
        return zza.zza(bArr, i, i6);
    }

    public static boolean zzc(byte[] bArr, int i, int i6) {
        return zza.zza(0, bArr, i, i6) == 0;
    }

    public static int zza(String str, byte[] bArr, int i, int i6) {
        return zza.zza(str, bArr, i, i6);
    }

    public static int zza(String str) {
        int length = str.length();
        int i = 0;
        int i6 = 0;
        while (i6 < length && str.charAt(i6) < 128) {
            i6++;
        }
        int i7 = length;
        while (true) {
            if (i6 >= length) {
                break;
            }
            char cCharAt = str.charAt(i6);
            if (cCharAt < 2048) {
                i7 += (127 - cCharAt) >>> 31;
                i6++;
            } else {
                int length2 = str.length();
                while (i6 < length2) {
                    char cCharAt2 = str.charAt(i6);
                    if (cCharAt2 < 2048) {
                        i += (127 - cCharAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i6) < 65536) {
                                throw new zzaod(i6, length2);
                            }
                            i6++;
                        }
                    }
                    i6++;
                }
                i7 += i;
            }
        }
        if (i7 >= length) {
            return i7;
        }
        throw new IllegalArgumentException(a.f("UTF-8 length does not fit in int: ", ((long) i7) + 4294967296L));
    }
}
