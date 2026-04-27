package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzos {
    public static final /* synthetic */ int zza = 0;

    static {
        if (zzop.zza() && zzop.zzb()) {
            int i8 = zzkv.zza;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0073 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0077 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zza(byte[] r6, int r7, int r8) {
        /*
        L0:
            if (r7 >= r8) goto L9
            r0 = r6[r7]
            if (r0 < 0) goto L9
            int r7 = r7 + 1
            goto L0
        L9:
            if (r7 < r8) goto Ld
            goto L77
        Ld:
            if (r7 >= r8) goto L77
            int r0 = r7 + 1
            r1 = r6[r7]
            if (r1 >= 0) goto L75
            r2 = -32
            r3 = -65
            if (r1 >= r2) goto L29
            if (r0 < r8) goto L1e
            goto L54
        L1e:
            r2 = -62
            if (r1 < r2) goto L73
            int r7 = r7 + 2
            r0 = r6[r0]
            if (r0 <= r3) goto Ld
            goto L73
        L29:
            r4 = -16
            if (r1 >= r4) goto L4f
            int r4 = r8 + (-1)
            if (r0 < r4) goto L36
        L31:
            int r1 = zzd(r6, r0, r8)
            goto L54
        L36:
            int r4 = r7 + 2
            r0 = r6[r0]
            if (r0 > r3) goto L73
            r5 = -96
            if (r1 != r2) goto L42
            if (r0 < r5) goto L73
        L42:
            r2 = -19
            if (r1 != r2) goto L48
            if (r0 >= r5) goto L73
        L48:
            int r7 = r7 + 3
            r0 = r6[r4]
            if (r0 <= r3) goto Ld
            goto L73
        L4f:
            int r2 = r8 + (-2)
            if (r0 < r2) goto L57
            goto L31
        L54:
            if (r1 == 0) goto L77
            goto L73
        L57:
            int r2 = r7 + 2
            r0 = r6[r0]
            if (r0 > r3) goto L73
            int r1 = r1 << 28
            int r0 = r0 + 112
            int r1 = r1 + r0
            int r0 = r1 >> 30
            if (r0 != 0) goto L73
            int r0 = r7 + 3
            r1 = r6[r2]
            if (r1 > r3) goto L73
            int r7 = r7 + 4
            r0 = r6[r0]
            if (r0 > r3) goto L73
            goto Ld
        L73:
            r6 = 0
            return r6
        L75:
            r7 = r0
            goto Ld
        L77:
            r6 = 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzos.zza(byte[], int, int):boolean");
    }

    public static int zzb(String str) {
        int length = str.length();
        int i8 = 0;
        int i9 = 0;
        while (i9 < length && str.charAt(i9) < 128) {
            i9++;
        }
        int i10 = length;
        while (true) {
            if (i9 >= length) {
                break;
            }
            char cCharAt = str.charAt(i9);
            if (cCharAt < 2048) {
                i10 += (127 - cCharAt) >>> 31;
                i9++;
            } else {
                int length2 = str.length();
                while (i9 < length2) {
                    char cCharAt2 = str.charAt(i9);
                    if (cCharAt2 < 2048) {
                        i8 += (127 - cCharAt2) >>> 31;
                    } else {
                        i8 += 2;
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i9) < 65536) {
                                throw new zzor(i9, length2);
                            }
                            i9++;
                        }
                    }
                    i9++;
                }
                i10 += i8;
            }
        }
        if (i10 >= length) {
            return i10;
        }
        long j8 = ((long) i10) + 4294967296L;
        StringBuilder sb = new StringBuilder(String.valueOf(j8).length() + 34);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j8);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int zzc(String str, byte[] bArr, int i8, int i9) {
        int i10;
        int i11;
        int i12;
        char cCharAt;
        int length = str.length();
        int i13 = 0;
        while (true) {
            i10 = i8 + i9;
            if (i13 >= length || (i12 = i13 + i8) >= i10 || (cCharAt = str.charAt(i13)) >= 128) {
                break;
            }
            bArr[i12] = (byte) cCharAt;
            i13++;
        }
        if (i13 == length) {
            return i8 + length;
        }
        int i14 = i8 + i13;
        while (i13 < length) {
            char cCharAt2 = str.charAt(i13);
            if (cCharAt2 < 128 && i14 < i10) {
                bArr[i14] = (byte) cCharAt2;
                i14++;
            } else if (cCharAt2 < 2048 && i14 <= i10 - 2) {
                bArr[i14] = (byte) ((cCharAt2 >>> 6) | 960);
                bArr[i14 + 1] = (byte) ((cCharAt2 & '?') | 128);
                i14 += 2;
            } else {
                if ((cCharAt2 >= 55296 && cCharAt2 <= 57343) || i14 > i10 - 3) {
                    if (i14 > i10 - 4) {
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343 && ((i11 = i13 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i11)))) {
                            throw new zzor(i13, length);
                        }
                        StringBuilder sb = new StringBuilder(String.valueOf(cCharAt2).length() + 25 + String.valueOf(i14).length());
                        sb.append("Failed writing ");
                        sb.append(cCharAt2);
                        sb.append(" at index ");
                        sb.append(i14);
                        throw new ArrayIndexOutOfBoundsException(sb.toString());
                    }
                    int i15 = i13 + 1;
                    if (i15 != str.length()) {
                        char cCharAt3 = str.charAt(i15);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int i16 = i14 + 3;
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i14] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i14 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            bArr[i14 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i14 += 4;
                            bArr[i16] = (byte) ((codePoint & 63) | 128);
                            i13 = i15;
                        } else {
                            i13 = i15;
                        }
                    }
                    throw new zzor(i13 - 1, length);
                }
                bArr[i14] = (byte) ((cCharAt2 >>> '\f') | 480);
                bArr[i14 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                bArr[i14 + 2] = (byte) ((cCharAt2 & '?') | 128);
                i14 += 3;
            }
            i13++;
        }
        return i14;
    }

    public static /* synthetic */ int zzd(byte[] bArr, int i8, int i9) {
        int i10 = i9 - i8;
        byte b8 = bArr[i8 - 1];
        if (i10 == 0) {
            if (b8 <= -12) {
                return b8;
            }
            return -1;
        }
        if (i10 == 1) {
            byte b9 = bArr[i8];
            if (b8 > -12 || b9 > -65) {
                return -1;
            }
            return (b9 << 8) ^ b8;
        }
        if (i10 != 2) {
            throw new AssertionError();
        }
        byte b10 = bArr[i8];
        byte b11 = bArr[i8 + 1];
        if (b8 > -12 || b10 > -65 || b11 > -65) {
            return -1;
        }
        return (b11 << 16) ^ ((b10 << 8) ^ b8);
    }
}
