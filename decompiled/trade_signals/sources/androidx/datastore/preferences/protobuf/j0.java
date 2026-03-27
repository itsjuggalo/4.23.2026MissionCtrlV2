package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11294a;

    public static class a {
        public static void h(byte b8, byte b9, byte b10, byte b11, char[] cArr, int i8) throws C1119v {
            if (m(b9) || (((b8 << 28) + (b9 + 112)) >> 30) != 0 || m(b10) || m(b11)) {
                throw C1119v.d();
            }
            int iR = ((b8 & 7) << 18) | (r(b9) << 12) | (r(b10) << 6) | r(b11);
            cArr[i8] = l(iR);
            cArr[i8 + 1] = q(iR);
        }

        public static void i(byte b8, char[] cArr, int i8) {
            cArr[i8] = (char) b8;
        }

        public static void j(byte b8, byte b9, byte b10, char[] cArr, int i8) throws C1119v {
            if (m(b9) || ((b8 == -32 && b9 < -96) || ((b8 == -19 && b9 >= -96) || m(b10)))) {
                throw C1119v.d();
            }
            cArr[i8] = (char) (((b8 & 15) << 12) | (r(b9) << 6) | r(b10));
        }

        public static void k(byte b8, byte b9, char[] cArr, int i8) throws C1119v {
            if (b8 < -62 || m(b9)) {
                throw C1119v.d();
            }
            cArr[i8] = (char) (((b8 & 31) << 6) | r(b9));
        }

        public static char l(int i8) {
            return (char) ((i8 >>> 10) + 55232);
        }

        public static boolean m(byte b8) {
            return b8 > -65;
        }

        public static boolean n(byte b8) {
            return b8 >= 0;
        }

        public static boolean o(byte b8) {
            return b8 < -16;
        }

        public static boolean p(byte b8) {
            return b8 < -32;
        }

        public static char q(int i8) {
            return (char) ((i8 & 1023) + 56320);
        }

        public static int r(byte b8) {
            return b8 & 63;
        }
    }

    public static abstract class b {
        public abstract String a(byte[] bArr, int i8, int i9);

        public abstract int b(String str, byte[] bArr, int i8, int i9);
    }

    public static final class c extends b {
        @Override // androidx.datastore.preferences.protobuf.j0.b
        public String a(byte[] bArr, int i8, int i9) throws C1119v {
            if ((i8 | i9 | ((bArr.length - i8) - i9)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i8), Integer.valueOf(i9)));
            }
            int i10 = i8 + i9;
            char[] cArr = new char[i9];
            int i11 = 0;
            while (i8 < i10) {
                byte b8 = bArr[i8];
                if (!a.n(b8)) {
                    break;
                }
                i8++;
                a.i(b8, cArr, i11);
                i11++;
            }
            int i12 = i11;
            while (i8 < i10) {
                int i13 = i8 + 1;
                byte b9 = bArr[i8];
                if (a.n(b9)) {
                    int i14 = i12 + 1;
                    a.i(b9, cArr, i12);
                    while (i13 < i10) {
                        byte b10 = bArr[i13];
                        if (!a.n(b10)) {
                            break;
                        }
                        i13++;
                        a.i(b10, cArr, i14);
                        i14++;
                    }
                    i12 = i14;
                    i8 = i13;
                } else if (a.p(b9)) {
                    if (i13 >= i10) {
                        throw C1119v.d();
                    }
                    i8 += 2;
                    a.k(b9, bArr[i13], cArr, i12);
                    i12++;
                } else if (a.o(b9)) {
                    if (i13 >= i10 - 1) {
                        throw C1119v.d();
                    }
                    int i15 = i8 + 2;
                    i8 += 3;
                    a.j(b9, bArr[i13], bArr[i15], cArr, i12);
                    i12++;
                } else {
                    if (i13 >= i10 - 2) {
                        throw C1119v.d();
                    }
                    byte b11 = bArr[i13];
                    int i16 = i8 + 3;
                    byte b12 = bArr[i8 + 2];
                    i8 += 4;
                    a.h(b9, b11, b12, bArr[i16], cArr, i12);
                    i12 += 2;
                }
            }
            return new String(cArr, 0, i12);
        }

        @Override // androidx.datastore.preferences.protobuf.j0.b
        public int b(String str, byte[] bArr, int i8, int i9) {
            int i10;
            int i11;
            char cCharAt;
            int length = str.length();
            int i12 = i9 + i8;
            int i13 = 0;
            while (i13 < length && (i11 = i13 + i8) < i12 && (cCharAt = str.charAt(i13)) < 128) {
                bArr[i11] = (byte) cCharAt;
                i13++;
            }
            if (i13 == length) {
                return i8 + length;
            }
            int i14 = i8 + i13;
            while (i13 < length) {
                char cCharAt2 = str.charAt(i13);
                if (cCharAt2 < 128 && i14 < i12) {
                    bArr[i14] = (byte) cCharAt2;
                    i14++;
                } else if (cCharAt2 < 2048 && i14 <= i12 - 2) {
                    int i15 = i14 + 1;
                    bArr[i14] = (byte) ((cCharAt2 >>> 6) | 960);
                    i14 += 2;
                    bArr[i15] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i14 > i12 - 3) {
                        if (i14 > i12 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i10 = i13 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i10)))) {
                                throw new d(i13, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i14);
                        }
                        int i16 = i13 + 1;
                        if (i16 != str.length()) {
                            char cCharAt3 = str.charAt(i16);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i14] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i14 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i17 = i14 + 3;
                                bArr[i14 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i14 += 4;
                                bArr[i17] = (byte) ((codePoint & 63) | 128);
                                i13 = i16;
                            } else {
                                i13 = i16;
                            }
                        }
                        throw new d(i13 - 1, length);
                    }
                    bArr[i14] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i18 = i14 + 2;
                    bArr[i14 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i14 += 3;
                    bArr[i18] = (byte) ((cCharAt2 & '?') | 128);
                }
                i13++;
            }
            return i14;
        }
    }

    public static class d extends IllegalArgumentException {
        public d(int i8, int i9) {
            super("Unpaired surrogate at index " + i8 + " of " + i9);
        }
    }

    public static final class e extends b {
        public static boolean c() {
            return i0.B() && i0.C();
        }

        @Override // androidx.datastore.preferences.protobuf.j0.b
        public String a(byte[] bArr, int i8, int i9) throws C1119v {
            Charset charset = AbstractC1118u.f11428b;
            String str = new String(bArr, i8, i9, charset);
            if (str.indexOf(65533) >= 0 && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i8, i9 + i8))) {
                throw C1119v.d();
            }
            return str;
        }

        @Override // androidx.datastore.preferences.protobuf.j0.b
        public int b(String str, byte[] bArr, int i8, int i9) {
            long j8;
            String str2;
            String str3;
            int i10;
            long j9;
            long j10;
            char cCharAt;
            long j11 = i8;
            long j12 = ((long) i9) + j11;
            int length = str.length();
            String str4 = " at index ";
            String str5 = "Failed writing ";
            if (length > i9 || bArr.length - i9 < i8) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(length - 1) + " at index " + (i8 + i9));
            }
            int i11 = 0;
            while (true) {
                j8 = 1;
                if (i11 >= length || (cCharAt = str.charAt(i11)) >= 128) {
                    break;
                }
                i0.H(bArr, j11, (byte) cCharAt);
                i11++;
                j11 = 1 + j11;
            }
            if (i11 == length) {
                return (int) j11;
            }
            while (i11 < length) {
                char cCharAt2 = str.charAt(i11);
                if (cCharAt2 >= 128 || j11 >= j12) {
                    if (cCharAt2 >= 2048 || j11 > j12 - 2) {
                        str2 = str4;
                        str3 = str5;
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j11 > j12 - 3) {
                            if (j11 > j12 - 4) {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i10 = i11 + 1) == length || !Character.isSurrogatePair(cCharAt2, str.charAt(i10)))) {
                                    throw new d(i11, length);
                                }
                                throw new ArrayIndexOutOfBoundsException(str3 + cCharAt2 + str2 + j11);
                            }
                            int i12 = i11 + 1;
                            if (i12 != length) {
                                char cCharAt3 = str.charAt(i12);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    j9 = 1;
                                    i0.H(bArr, j11, (byte) ((codePoint >>> 18) | 240));
                                    j10 = j12;
                                    i0.H(bArr, j11 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j13 = j11 + 3;
                                    i0.H(bArr, j11 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j11 += 4;
                                    i0.H(bArr, j13, (byte) ((codePoint & 63) | 128));
                                    i11 = i12;
                                } else {
                                    i11 = i12;
                                }
                            }
                            throw new d(i11 - 1, length);
                        }
                        i0.H(bArr, j11, (byte) ((cCharAt2 >>> '\f') | 480));
                        long j14 = j11 + 2;
                        i0.H(bArr, j11 + 1, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                        j11 += 3;
                        i0.H(bArr, j14, (byte) ((cCharAt2 & '?') | 128));
                    } else {
                        str2 = str4;
                        str3 = str5;
                        long j15 = j11 + j8;
                        i0.H(bArr, j11, (byte) ((cCharAt2 >>> 6) | 960));
                        j11 += 2;
                        i0.H(bArr, j15, (byte) ((cCharAt2 & '?') | 128));
                    }
                    j10 = j12;
                    j9 = 1;
                } else {
                    i0.H(bArr, j11, (byte) cCharAt2);
                    j10 = j12;
                    str3 = str5;
                    j9 = j8;
                    j11 += j8;
                    str2 = str4;
                }
                i11++;
                str4 = str2;
                str5 = str3;
                j8 = j9;
                j12 = j10;
            }
            return (int) j11;
        }
    }

    static {
        f11294a = (!e.c() || AbstractC1102d.c()) ? new c() : new e();
    }

    public static String a(byte[] bArr, int i8, int i9) {
        return f11294a.a(bArr, i8, i9);
    }

    public static int b(String str, byte[] bArr, int i8, int i9) {
        return f11294a.b(str, bArr, i8, i9);
    }

    public static int c(String str) {
        int length = str.length();
        int i8 = 0;
        while (i8 < length && str.charAt(i8) < 128) {
            i8++;
        }
        int iD = length;
        while (true) {
            if (i8 < length) {
                char cCharAt = str.charAt(i8);
                if (cCharAt >= 2048) {
                    iD += d(str, i8);
                    break;
                }
                iD += (127 - cCharAt) >>> 31;
                i8++;
            } else {
                break;
            }
        }
        if (iD >= length) {
            return iD;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iD) + 4294967296L));
    }

    public static int d(String str, int i8) {
        int length = str.length();
        int i9 = 0;
        while (i8 < length) {
            char cCharAt = str.charAt(i8);
            if (cCharAt < 2048) {
                i9 += (127 - cCharAt) >>> 31;
            } else {
                i9 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(str, i8) < 65536) {
                        throw new d(i8, length);
                    }
                    i8++;
                }
            }
            i8++;
        }
        return i9;
    }
}
