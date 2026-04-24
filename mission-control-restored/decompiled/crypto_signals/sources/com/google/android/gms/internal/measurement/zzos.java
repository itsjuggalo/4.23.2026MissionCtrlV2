package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzos {
    public static final /* synthetic */ int zza = 0;

    static {
        if (zzop.zza() && zzop.zzb()) {
            int i = zzkv.zza;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0076 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x007a A[ORIG_RETURN, RETURN] */
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
            goto L7a
        Ld:
            if (r7 >= r8) goto L7a
            int r0 = r7 + 1
            r1 = r6[r7]
            if (r1 >= 0) goto L78
            r2 = -32
            r3 = -65
            if (r1 >= r2) goto L29
            if (r0 < r8) goto L1e
            goto L57
        L1e:
            r2 = -62
            if (r1 < r2) goto L76
            int r7 = r7 + 2
            r0 = r6[r0]
            if (r0 <= r3) goto Ld
            goto L76
        L29:
            r4 = -16
            if (r1 >= r4) goto L4f
            int r4 = r8 + (-1)
            if (r0 < r4) goto L36
            int r1 = zzd(r6, r0, r8)
            goto L57
        L36:
            int r4 = r7 + 2
            r0 = r6[r0]
            if (r0 > r3) goto L76
            r5 = -96
            if (r1 != r2) goto L42
            if (r0 < r5) goto L76
        L42:
            r2 = -19
            if (r1 != r2) goto L48
            if (r0 >= r5) goto L76
        L48:
            int r7 = r7 + 3
            r0 = r6[r4]
            if (r0 <= r3) goto Ld
            goto L76
        L4f:
            int r2 = r8 + (-2)
            if (r0 < r2) goto L5a
            int r1 = zzd(r6, r0, r8)
        L57:
            if (r1 == 0) goto L7a
            goto L76
        L5a:
            int r2 = r7 + 2
            r0 = r6[r0]
            if (r0 > r3) goto L76
            int r1 = r1 << 28
            int r0 = r0 + 112
            int r0 = r0 + r1
            int r0 = r0 >> 30
            if (r0 != 0) goto L76
            int r0 = r7 + 3
            r1 = r6[r2]
            if (r1 > r3) goto L76
            int r7 = r7 + 4
            r0 = r6[r0]
            if (r0 > r3) goto L76
            goto Ld
        L76:
            r6 = 0
            return r6
        L78:
            r7 = r0
            goto Ld
        L7a:
            r6 = 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzos.zza(byte[], int, int):boolean");
    }

    public static int zzb(String str) {
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
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i6) < 65536) {
                                throw new zzor(i6, length2);
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
        long j4 = ((long) i7) + 4294967296L;
        StringBuilder sb = new StringBuilder(String.valueOf(j4).length() + 34);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j4);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int zzc(String str, byte[] bArr, int i, int i6) {
        int i7;
        int i8;
        int i9;
        char cCharAt;
        int length = str.length();
        int i10 = 0;
        while (true) {
            i7 = i + i6;
            if (i10 >= length || (i9 = i10 + i) >= i7 || (cCharAt = str.charAt(i10)) >= 128) {
                break;
            }
            bArr[i9] = (byte) cCharAt;
            i10++;
        }
        if (i10 == length) {
            return i + length;
        }
        int i11 = i + i10;
        while (i10 < length) {
            char cCharAt2 = str.charAt(i10);
            if (cCharAt2 < 128 && i11 < i7) {
                bArr[i11] = (byte) cCharAt2;
                i11++;
            } else if (cCharAt2 < 2048 && i11 <= i7 - 2) {
                bArr[i11] = (byte) ((cCharAt2 >>> 6) | 960);
                bArr[i11 + 1] = (byte) ((cCharAt2 & '?') | 128);
                i11 += 2;
            } else {
                if ((cCharAt2 >= 55296 && cCharAt2 <= 57343) || i11 > i7 - 3) {
                    if (i11 > i7 - 4) {
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343 && ((i8 = i10 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i8)))) {
                            throw new zzor(i10, length);
                        }
                        StringBuilder sb = new StringBuilder(String.valueOf(cCharAt2).length() + 25 + String.valueOf(i11).length());
                        sb.append("Failed writing ");
                        sb.append(cCharAt2);
                        sb.append(" at index ");
                        sb.append(i11);
                        throw new ArrayIndexOutOfBoundsException(sb.toString());
                    }
                    int i12 = i10 + 1;
                    if (i12 != str.length()) {
                        char cCharAt3 = str.charAt(i12);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int i13 = i11 + 3;
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i11] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i11 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            bArr[i11 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i11 += 4;
                            bArr[i13] = (byte) ((codePoint & 63) | 128);
                            i10 = i12;
                        } else {
                            i10 = i12;
                        }
                    }
                    throw new zzor(i10 - 1, length);
                }
                bArr[i11] = (byte) ((cCharAt2 >>> '\f') | 480);
                bArr[i11 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                bArr[i11 + 2] = (byte) ((cCharAt2 & '?') | 128);
                i11 += 3;
            }
            i10++;
        }
        return i11;
    }

    public static /* synthetic */ int zzd(byte[] bArr, int i, int i6) {
        int i7 = i6 - i;
        byte b3 = bArr[i - 1];
        if (i7 == 0) {
            if (b3 <= -12) {
                return b3;
            }
            return -1;
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
}
