package com.google.android.recaptcha.internal;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* JADX INFO: loaded from: classes.dex */
final class zzpv {
    static {
        if (zzps.zzx() && zzps.zzy()) {
            int i4 = zzks.zza;
        }
    }

    public static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i4, int i5) {
        int i6 = i5 - i4;
        byte b4 = bArr[i4 - 1];
        if (i6 == 0) {
            if (b4 <= -12) {
                return b4;
            }
            return -1;
        }
        if (i6 == 1) {
            byte b5 = bArr[i4];
            if (b4 > -12 || b5 > -65) {
                return -1;
            }
            return (b5 << 8) ^ b4;
        }
        if (i6 != 2) {
            throw new AssertionError();
        }
        byte b6 = bArr[i4];
        byte b7 = bArr[i4 + 1];
        if (b4 > -12 || b6 > -65 || b7 > -65) {
            return -1;
        }
        return (b7 << 16) ^ ((b6 << 8) ^ b4);
    }

    public static int zzb(String str, byte[] bArr, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        char cCharAt;
        int length = str.length();
        int i9 = 0;
        while (true) {
            i6 = i4 + i5;
            if (i9 >= length || (i8 = i9 + i4) >= i6 || (cCharAt = str.charAt(i9)) >= 128) {
                break;
            }
            bArr[i8] = (byte) cCharAt;
            i9++;
        }
        if (i9 == length) {
            return i4 + length;
        }
        int i10 = i4 + i9;
        while (i9 < length) {
            char cCharAt2 = str.charAt(i9);
            if (cCharAt2 < 128 && i10 < i6) {
                bArr[i10] = (byte) cCharAt2;
                i10++;
            } else if (cCharAt2 < 2048 && i10 <= i6 - 2) {
                bArr[i10] = (byte) ((cCharAt2 >>> 6) | 960);
                bArr[i10 + 1] = (byte) ((cCharAt2 & '?') | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                i10 += 2;
            } else {
                if ((cCharAt2 >= 55296 && cCharAt2 <= 57343) || i10 > i6 - 3) {
                    if (i10 > i6 - 4) {
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343 && ((i7 = i9 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i7)))) {
                            throw new zzpu(i9, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i10);
                    }
                    int i11 = i9 + 1;
                    if (i11 != str.length()) {
                        char cCharAt3 = str.charAt(i11);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int i12 = i10 + 3;
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i10] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i10 + 1] = (byte) (((codePoint >>> 12) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                            bArr[i10 + 2] = (byte) (((codePoint >>> 6) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                            i10 += 4;
                            bArr[i12] = (byte) ((codePoint & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                            i9 = i11;
                        } else {
                            i9 = i11;
                        }
                    }
                    throw new zzpu(i9 - 1, length);
                }
                bArr[i10] = (byte) ((cCharAt2 >>> '\f') | 480);
                bArr[i10 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                bArr[i10 + 2] = (byte) ((cCharAt2 & '?') | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                i10 += 3;
            }
            i9++;
        }
        return i10;
    }

    public static int zzc(String str) {
        int length = str.length();
        int i4 = 0;
        int i5 = 0;
        while (i5 < length && str.charAt(i5) < 128) {
            i5++;
        }
        int i6 = length;
        while (true) {
            if (i5 >= length) {
                break;
            }
            char cCharAt = str.charAt(i5);
            if (cCharAt < 2048) {
                i6 += (127 - cCharAt) >>> 31;
                i5++;
            } else {
                int length2 = str.length();
                while (i5 < length2) {
                    char cCharAt2 = str.charAt(i5);
                    if (cCharAt2 < 2048) {
                        i4 += (127 - cCharAt2) >>> 31;
                    } else {
                        i4 += 2;
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i5) < 65536) {
                                throw new zzpu(i5, length2);
                            }
                            i5++;
                        }
                    }
                    i5++;
                }
                i6 += i4;
            }
        }
        if (i6 >= length) {
            return i6;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i6) + 4294967296L));
    }

    public static String zzd(byte[] bArr, int i4, int i5) throws zznn {
        int i6;
        int length = bArr.length;
        if ((((length - i4) - i5) | i4 | i5) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i4), Integer.valueOf(i5)));
        }
        int i7 = i4 + i5;
        char[] cArr = new char[i5];
        int i8 = 0;
        while (i4 < i7) {
            byte b4 = bArr[i4];
            if (!zzpt.zzd(b4)) {
                break;
            }
            i4++;
            cArr[i8] = (char) b4;
            i8++;
        }
        int i9 = i8;
        while (i4 < i7) {
            int i10 = i4 + 1;
            byte b5 = bArr[i4];
            if (zzpt.zzd(b5)) {
                cArr[i9] = (char) b5;
                i9++;
                i4 = i10;
                while (i4 < i7) {
                    byte b6 = bArr[i4];
                    if (zzpt.zzd(b6)) {
                        i4++;
                        cArr[i9] = (char) b6;
                        i9++;
                    }
                }
            } else {
                if (b5 < -32) {
                    if (i10 >= i7) {
                        throw new zznn("Protocol message had invalid UTF-8.");
                    }
                    i6 = i9 + 1;
                    i4 += 2;
                    zzpt.zzc(b5, bArr[i10], cArr, i9);
                } else if (b5 < -16) {
                    if (i10 >= i7 - 1) {
                        throw new zznn("Protocol message had invalid UTF-8.");
                    }
                    i6 = i9 + 1;
                    int i11 = i4 + 2;
                    i4 += 3;
                    zzpt.zzb(b5, bArr[i10], bArr[i11], cArr, i9);
                } else {
                    if (i10 >= i7 - 2) {
                        throw new zznn("Protocol message had invalid UTF-8.");
                    }
                    byte b7 = bArr[i10];
                    int i12 = i4 + 3;
                    byte b8 = bArr[i4 + 2];
                    i4 += 4;
                    zzpt.zza(b5, b7, b8, bArr[i12], cArr, i9);
                    i9 += 2;
                }
                i9 = i6;
            }
        }
        return new String(cArr, 0, i9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0076 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x007a A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zze(byte[] r6, int r7, int r8) {
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
            int r1 = zza(r6, r0, r8)
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
            int r1 = zza(r6, r0, r8)
        L57:
            if (r1 == 0) goto L7a
            goto L76
        L5a:
            int r2 = r7 + 2
            r0 = r6[r0]
            if (r0 > r3) goto L76
            int r1 = r1 << 28
            int r0 = r0 + 112
            int r1 = r1 + r0
            int r0 = r1 >> 30
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzpv.zze(byte[], int, int):boolean");
    }
}
