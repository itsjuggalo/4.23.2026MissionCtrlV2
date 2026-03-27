package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class N0 extends y0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5661c;

    public /* synthetic */ N0(int i) {
        this.f5661c = i;
    }

    public static int y(long j4, byte[] bArr, int i, int i6) {
        if (i6 == 0) {
            y0 y0Var = P0.f5671a;
            if (i > -12) {
                return -1;
            }
            return i;
        }
        if (i6 == 1) {
            return P0.d(i, M0.g(bArr, j4));
        }
        if (i6 == 2) {
            return P0.e(i, M0.g(bArr, j4), M0.g(bArr, j4 + 1));
        }
        throw new AssertionError();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    @Override // com.google.protobuf.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String i(byte[] r8, int r9, int r10) throws com.google.protobuf.O {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.N0.i(byte[], int, int):java.lang.String");
    }

    @Override // com.google.protobuf.y0
    public final String k(int i, ByteBuffer byteBuffer, int i6) throws O {
        long j4;
        byte bE;
        byte bE2;
        switch (this.f5661c) {
            case 0:
                return y0.j(i, byteBuffer, i6);
            default:
                if ((i | i6 | ((byteBuffer.limit() - i) - i6)) < 0) {
                    throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i6)));
                }
                long j6 = M0.f5656c.j(byteBuffer, M0.f5659g) + ((long) i);
                long j7 = ((long) i6) + j6;
                char[] cArr = new char[i6];
                int i7 = 0;
                while (true) {
                    j4 = 1;
                    if (j6 < j7 && (bE2 = M0.f5656c.e(j6)) >= 0) {
                        j6++;
                        cArr[i7] = (char) bE2;
                        i7++;
                    }
                }
                int i8 = i7;
                while (j6 < j7) {
                    long j8 = j6 + j4;
                    L0 l02 = M0.f5656c;
                    byte bE3 = l02.e(j6);
                    if (bE3 >= 0) {
                        int i9 = i8 + 1;
                        cArr[i8] = (char) bE3;
                        while (j8 < j7 && (bE = M0.f5656c.e(j8)) >= 0) {
                            j8 += j4;
                            cArr[i9] = (char) bE;
                            i9++;
                        }
                        i8 = i9;
                        j6 = j8;
                    } else {
                        if (!(bE3 < -32)) {
                            if (bE3 < -16) {
                                if (j8 >= j7 - j4) {
                                    throw O.c();
                                }
                                long j9 = j6 + 2;
                                j6 += 3;
                                y0.c(bE3, l02.e(j8), l02.e(j9), cArr, i8);
                                i8++;
                            } else {
                                if (j8 >= j7 - 2) {
                                    throw O.c();
                                }
                                byte bE4 = l02.e(j8);
                                long j10 = j6 + 3;
                                byte bE5 = l02.e(j6 + 2);
                                j6 += 4;
                                y0.a(bE3, bE4, bE5, l02.e(j10), cArr, i8);
                                i8 += 2;
                            }
                        } else {
                            if (j8 >= j7) {
                                throw O.c();
                            }
                            j6 += 2;
                            y0.b(bE3, l02.e(j8), cArr, i8);
                            i8++;
                        }
                    }
                    j4 = 1;
                }
                return new String(cArr, 0, i8);
        }
    }

    @Override // com.google.protobuf.y0
    public final int p(String str, byte[] bArr, int i, int i6) {
        int i7;
        int i8;
        char cCharAt;
        long j4;
        char c6;
        long j6;
        long j7;
        char c7;
        int i9;
        char cCharAt2;
        switch (this.f5661c) {
            case 0:
                int length = str.length();
                int i10 = i6 + i;
                int i11 = 0;
                while (i11 < length && (i8 = i11 + i) < i10 && (cCharAt = str.charAt(i11)) < 128) {
                    bArr[i8] = (byte) cCharAt;
                    i11++;
                }
                if (i11 == length) {
                    return i + length;
                }
                int i12 = i + i11;
                while (i11 < length) {
                    char cCharAt3 = str.charAt(i11);
                    if (cCharAt3 < 128 && i12 < i10) {
                        bArr[i12] = (byte) cCharAt3;
                        i12++;
                    } else if (cCharAt3 < 2048 && i12 <= i10 - 2) {
                        int i13 = i12 + 1;
                        bArr[i12] = (byte) ((cCharAt3 >>> 6) | 960);
                        i12 += 2;
                        bArr[i13] = (byte) ((cCharAt3 & '?') | 128);
                    } else {
                        if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || i12 > i10 - 3) {
                            if (i12 > i10 - 4) {
                                if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i7 = i11 + 1) == str.length() || !Character.isSurrogatePair(cCharAt3, str.charAt(i7)))) {
                                    throw new O0(i11, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt3 + " at index " + i12);
                            }
                            int i14 = i11 + 1;
                            if (i14 != str.length()) {
                                char cCharAt4 = str.charAt(i14);
                                if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                    int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                    bArr[i12] = (byte) ((codePoint >>> 18) | 240);
                                    bArr[i12 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i15 = i12 + 3;
                                    bArr[i12 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i12 += 4;
                                    bArr[i15] = (byte) ((codePoint & 63) | 128);
                                    i11 = i14;
                                } else {
                                    i11 = i14;
                                }
                            }
                            throw new O0(i11 - 1, length);
                        }
                        bArr[i12] = (byte) ((cCharAt3 >>> '\f') | 480);
                        int i16 = i12 + 2;
                        bArr[i12 + 1] = (byte) (((cCharAt3 >>> 6) & 63) | 128);
                        i12 += 3;
                        bArr[i16] = (byte) ((cCharAt3 & '?') | 128);
                    }
                    i11++;
                }
                return i12;
            default:
                long j8 = i;
                long j9 = ((long) i6) + j8;
                int length2 = str.length();
                if (length2 > i6 || bArr.length - i6 < i) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(length2 - 1) + " at index " + (i + i6));
                }
                int i17 = 0;
                while (true) {
                    j4 = 1;
                    c6 = 128;
                    if (i17 < length2 && (cCharAt2 = str.charAt(i17)) < 128) {
                        M0.k(bArr, j8, (byte) cCharAt2);
                        i17++;
                        j8 = 1 + j8;
                    }
                }
                if (i17 == length2) {
                    return (int) j8;
                }
                while (i17 < length2) {
                    char cCharAt5 = str.charAt(i17);
                    if (cCharAt5 < c6 && j8 < j9) {
                        M0.k(bArr, j8, (byte) cCharAt5);
                        c7 = c6;
                        j6 = j4;
                        j7 = j8 + j4;
                    } else if (cCharAt5 >= 2048 || j8 > j9 - 2) {
                        j6 = j4;
                        if ((cCharAt5 >= 55296 && 57343 >= cCharAt5) || j8 > j9 - 3) {
                            long j10 = j8;
                            if (j10 > j9 - 4) {
                                if (55296 <= cCharAt5 && cCharAt5 <= 57343 && ((i9 = i17 + 1) == length2 || !Character.isSurrogatePair(cCharAt5, str.charAt(i9)))) {
                                    throw new O0(i17, length2);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt5 + " at index " + j10);
                            }
                            int i18 = i17 + 1;
                            if (i18 != length2) {
                                char cCharAt6 = str.charAt(i18);
                                if (Character.isSurrogatePair(cCharAt5, cCharAt6)) {
                                    int codePoint2 = Character.toCodePoint(cCharAt5, cCharAt6);
                                    M0.k(bArr, j10, (byte) ((codePoint2 >>> 18) | 240));
                                    c7 = 128;
                                    M0.k(bArr, j10 + j6, (byte) (((codePoint2 >>> 12) & 63) | 128));
                                    M0.k(bArr, j10 + 2, (byte) (((codePoint2 >>> 6) & 63) | 128));
                                    M0.k(bArr, j10 + 3, (byte) ((codePoint2 & 63) | 128));
                                    j7 = j10 + 4;
                                    i17 = i18;
                                } else {
                                    i17 = i18;
                                }
                            }
                            throw new O0(i17 - 1, length2);
                        }
                        M0.k(bArr, j8, (byte) ((cCharAt5 >>> '\f') | 480));
                        long j11 = j8;
                        M0.k(bArr, j8 + j6, (byte) (((cCharAt5 >>> 6) & 63) | 128));
                        j7 = j11 + 3;
                        M0.k(bArr, j11 + 2, (byte) ((cCharAt5 & '?') | 128));
                        c7 = 128;
                    } else {
                        j6 = j4;
                        M0.k(bArr, j8, (byte) ((cCharAt5 >>> 6) | 960));
                        M0.k(bArr, j8 + j6, (byte) ((cCharAt5 & '?') | c6));
                        j7 = j8 + 2;
                        c7 = c6;
                    }
                    i17++;
                    c6 = c7;
                    j8 = j7;
                    j4 = j6;
                }
                return (int) j8;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
    
        if (com.google.protobuf.M0.g(r23, r5) > (-65)) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
    
        r5 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006f, code lost:
    
        if (com.google.protobuf.M0.g(r23, r5) > (-65)) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b5, code lost:
    
        if (com.google.protobuf.M0.g(r23, r5) > (-65)) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0256 A[ADDED_TO_REGION, LOOP:6: B:175:0x0256->B:267:0x0256, LOOP_START, PHI: r2
      0x0256: PHI (r2v3 int) = (r2v2 int), (r2v7 int) binds: [B:173:0x0253, B:267:0x0256] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x011f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x011d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:246:? A[PHI: r2
      PHI (r2v1 int) = (r2v0 int), (r2v13 int), (r2v19 int), (r2v22 int) binds: [B:124:0x01c5, B:167:0x0247, B:148:0x0204, B:133:0x01d7] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0122  */
    @Override // com.google.protobuf.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int v(int r22, byte[] r23, int r24, int r25) {
        /*
            Method dump skipped, instruction units count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.N0.v(int, byte[], int, int):int");
    }
}
