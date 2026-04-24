package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class P0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0 f5671a;

    static {
        f5671a = (M0.e && M0.f5657d && !AbstractC0454c.a()) ? new N0(1) : new N0(0);
    }

    public static int a(byte[] bArr, int i, int i6) {
        byte b3 = bArr[i - 1];
        int i7 = i6 - i;
        if (i7 == 0) {
            if (b3 > -12) {
                return -1;
            }
            return b3;
        }
        if (i7 == 1) {
            return d(b3, bArr[i]);
        }
        if (i7 == 2) {
            return e(b3, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    public static String b(int i, ByteBuffer byteBuffer, int i6) {
        y0 y0Var = f5671a;
        y0Var.getClass();
        if (byteBuffer.hasArray()) {
            return y0Var.i(byteBuffer.array(), byteBuffer.arrayOffset() + i, i6);
        }
        return byteBuffer.isDirect() ? y0Var.k(i, byteBuffer, i6) : y0.j(i, byteBuffer, i6);
    }

    public static int c(String str) {
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
                                throw new O0(i6, length2);
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
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i7) + 4294967296L));
    }

    public static int d(int i, int i6) {
        if (i > -12 || i6 > -65) {
            return -1;
        }
        return i ^ (i6 << 8);
    }

    public static int e(int i, int i6, int i7) {
        if (i > -12 || i6 > -65 || i7 > -65) {
            return -1;
        }
        return (i ^ (i6 << 8)) ^ (i7 << 16);
    }
}
