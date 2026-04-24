package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.e1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1328e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f15407a = 100;

    public static int a(byte[] bArr, int i8, C1323d1 c1323d1) throws R1 {
        int i9 = i(bArr, i8, c1323d1);
        int i10 = c1323d1.f15402a;
        if (i10 < 0) {
            throw new R1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i10 > bArr.length - i9) {
            throw new R1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i10 == 0) {
            c1323d1.f15404c = AbstractC1378o1.f15475b;
            return i9;
        }
        c1323d1.f15404c = AbstractC1378o1.H(bArr, i9, i10);
        return i9 + i10;
    }

    public static int b(byte[] bArr, int i8) {
        int i9 = bArr[i8] & 255;
        int i10 = bArr[i8 + 1] & 255;
        int i11 = bArr[i8 + 2] & 255;
        return ((bArr[i8 + 3] & 255) << 24) | (i10 << 8) | i9 | (i11 << 16);
    }

    public static int c(InterfaceC1384p2 interfaceC1384p2, byte[] bArr, int i8, int i9, int i10, C1323d1 c1323d1) throws R1 {
        Object objZze = interfaceC1384p2.zze();
        int iM = m(objZze, interfaceC1384p2, bArr, i8, i9, i10, c1323d1);
        interfaceC1384p2.c(objZze);
        c1323d1.f15404c = objZze;
        return iM;
    }

    public static int d(InterfaceC1384p2 interfaceC1384p2, byte[] bArr, int i8, int i9, C1323d1 c1323d1) throws R1 {
        Object objZze = interfaceC1384p2.zze();
        int iN = n(objZze, interfaceC1384p2, bArr, i8, i9, c1323d1);
        interfaceC1384p2.c(objZze);
        c1323d1.f15404c = objZze;
        return iN;
    }

    public static int e(InterfaceC1384p2 interfaceC1384p2, int i8, byte[] bArr, int i9, int i10, O1 o12, C1323d1 c1323d1) throws R1 {
        int iD = d(interfaceC1384p2, bArr, i9, i10, c1323d1);
        while (true) {
            o12.add(c1323d1.f15404c);
            if (iD >= i10) {
                break;
            }
            int i11 = i(bArr, iD, c1323d1);
            if (i8 != c1323d1.f15402a) {
                break;
            }
            iD = d(interfaceC1384p2, bArr, i11, i10, c1323d1);
        }
        return iD;
    }

    public static int f(byte[] bArr, int i8, O1 o12, C1323d1 c1323d1) throws R1 {
        K1 k12 = (K1) o12;
        int i9 = i(bArr, i8, c1323d1);
        int i10 = c1323d1.f15402a + i9;
        while (i9 < i10) {
            i9 = i(bArr, i9, c1323d1);
            k12.f(c1323d1.f15402a);
        }
        if (i9 == i10) {
            return i9;
        }
        throw new R1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int g(byte[] bArr, int i8, C1323d1 c1323d1) throws R1 {
        int i9;
        int i10 = i(bArr, i8, c1323d1);
        int i11 = c1323d1.f15402a;
        if (i11 < 0) {
            throw new R1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i11 == 0) {
            c1323d1.f15404c = "";
            return i10;
        }
        int i12 = F2.f15163a;
        int length = bArr.length;
        if ((((length - i10) - i11) | i10 | i11) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i10), Integer.valueOf(i11)));
        }
        int i13 = i10 + i11;
        char[] cArr = new char[i11];
        int i14 = 0;
        while (i10 < i13) {
            byte b8 = bArr[i10];
            if (!D2.d(b8)) {
                break;
            }
            i10++;
            cArr[i14] = (char) b8;
            i14++;
        }
        int i15 = i14;
        while (i10 < i13) {
            int i16 = i10 + 1;
            byte b9 = bArr[i10];
            if (D2.d(b9)) {
                cArr[i15] = (char) b9;
                i15++;
                i10 = i16;
                while (i10 < i13) {
                    byte b10 = bArr[i10];
                    if (D2.d(b10)) {
                        i10++;
                        cArr[i15] = (char) b10;
                        i15++;
                    }
                }
            } else {
                if (b9 < -32) {
                    if (i16 >= i13) {
                        throw new R1("Protocol message had invalid UTF-8.");
                    }
                    i9 = i15 + 1;
                    i10 += 2;
                    D2.c(b9, bArr[i16], cArr, i15);
                } else if (b9 < -16) {
                    if (i16 >= i13 - 1) {
                        throw new R1("Protocol message had invalid UTF-8.");
                    }
                    i9 = i15 + 1;
                    int i17 = i10 + 2;
                    i10 += 3;
                    D2.b(b9, bArr[i16], bArr[i17], cArr, i15);
                } else {
                    if (i16 >= i13 - 2) {
                        throw new R1("Protocol message had invalid UTF-8.");
                    }
                    byte b11 = bArr[i16];
                    int i18 = i10 + 3;
                    byte b12 = bArr[i10 + 2];
                    i10 += 4;
                    D2.a(b9, b11, b12, bArr[i18], cArr, i15);
                    i15 += 2;
                }
                i15 = i9;
            }
        }
        c1323d1.f15404c = new String(cArr, 0, i15);
        return i13;
    }

    public static int h(int i8, byte[] bArr, int i9, int i10, C1417w2 c1417w2, C1323d1 c1323d1) throws R1 {
        if ((i8 >>> 3) == 0) {
            throw new R1("Protocol message contained an invalid tag (zero).");
        }
        int i11 = i8 & 7;
        if (i11 == 0) {
            int iL = l(bArr, i9, c1323d1);
            c1417w2.j(i8, Long.valueOf(c1323d1.f15403b));
            return iL;
        }
        if (i11 == 1) {
            c1417w2.j(i8, Long.valueOf(o(bArr, i9)));
            return i9 + 8;
        }
        if (i11 == 2) {
            int i12 = i(bArr, i9, c1323d1);
            int i13 = c1323d1.f15402a;
            if (i13 < 0) {
                throw new R1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i13 > bArr.length - i12) {
                throw new R1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            c1417w2.j(i8, i13 == 0 ? AbstractC1378o1.f15475b : AbstractC1378o1.H(bArr, i12, i13));
            return i12 + i13;
        }
        if (i11 != 3) {
            if (i11 != 5) {
                throw new R1("Protocol message contained an invalid tag (zero).");
            }
            c1417w2.j(i8, Integer.valueOf(b(bArr, i9)));
            return i9 + 4;
        }
        int i14 = (i8 & (-8)) | 4;
        C1417w2 c1417w2F = C1417w2.f();
        int i15 = c1323d1.f15406e + 1;
        c1323d1.f15406e = i15;
        p(i15);
        int i16 = 0;
        while (true) {
            if (i9 >= i10) {
                break;
            }
            int i17 = i(bArr, i9, c1323d1);
            i16 = c1323d1.f15402a;
            if (i16 == i14) {
                i9 = i17;
                break;
            }
            i9 = h(i16, bArr, i17, i10, c1417w2F, c1323d1);
        }
        c1323d1.f15406e--;
        if (i9 > i10 || i16 != i14) {
            throw new R1("Failed to parse the message.");
        }
        c1417w2.j(i8, c1417w2F);
        return i9;
    }

    public static int i(byte[] bArr, int i8, C1323d1 c1323d1) {
        int i9 = i8 + 1;
        byte b8 = bArr[i8];
        if (b8 < 0) {
            return j(b8, bArr, i9, c1323d1);
        }
        c1323d1.f15402a = b8;
        return i9;
    }

    public static int j(int i8, byte[] bArr, int i9, C1323d1 c1323d1) {
        int i10;
        byte b8 = bArr[i9];
        int i11 = i9 + 1;
        int i12 = i8 & 127;
        if (b8 >= 0) {
            i10 = b8 << 7;
        } else {
            int i13 = i12 | ((b8 & 127) << 7);
            int i14 = i9 + 2;
            byte b9 = bArr[i11];
            if (b9 >= 0) {
                c1323d1.f15402a = i13 | (b9 << 14);
                return i14;
            }
            i12 = i13 | ((b9 & 127) << 14);
            i11 = i9 + 3;
            byte b10 = bArr[i14];
            if (b10 >= 0) {
                i10 = b10 << 21;
            } else {
                int i15 = i12 | ((b10 & 127) << 21);
                int i16 = i9 + 4;
                byte b11 = bArr[i11];
                if (b11 >= 0) {
                    c1323d1.f15402a = i15 | (b11 << 28);
                    return i16;
                }
                int i17 = i15 | ((b11 & 127) << 28);
                while (true) {
                    int i18 = i16 + 1;
                    if (bArr[i16] >= 0) {
                        c1323d1.f15402a = i17;
                        return i18;
                    }
                    i16 = i18;
                }
            }
        }
        c1323d1.f15402a = i12 | i10;
        return i11;
    }

    public static int k(int i8, byte[] bArr, int i9, int i10, O1 o12, C1323d1 c1323d1) {
        K1 k12 = (K1) o12;
        int i11 = i(bArr, i9, c1323d1);
        while (true) {
            k12.f(c1323d1.f15402a);
            if (i11 >= i10) {
                break;
            }
            int i12 = i(bArr, i11, c1323d1);
            if (i8 != c1323d1.f15402a) {
                break;
            }
            i11 = i(bArr, i12, c1323d1);
        }
        return i11;
    }

    public static int l(byte[] bArr, int i8, C1323d1 c1323d1) {
        long j8 = bArr[i8];
        int i9 = i8 + 1;
        if (j8 >= 0) {
            c1323d1.f15403b = j8;
            return i9;
        }
        int i10 = i8 + 2;
        byte b8 = bArr[i9];
        long j9 = (j8 & 127) | (((long) (b8 & 127)) << 7);
        int i11 = 7;
        while (b8 < 0) {
            int i12 = i10 + 1;
            byte b9 = bArr[i10];
            i11 += 7;
            j9 |= ((long) (b9 & 127)) << i11;
            b8 = b9;
            i10 = i12;
        }
        c1323d1.f15403b = j9;
        return i10;
    }

    public static int m(Object obj, InterfaceC1384p2 interfaceC1384p2, byte[] bArr, int i8, int i9, int i10, C1323d1 c1323d1) throws R1 {
        C1349i2 c1349i2 = (C1349i2) interfaceC1384p2;
        int i11 = c1323d1.f15406e + 1;
        c1323d1.f15406e = i11;
        p(i11);
        int iW = c1349i2.w(obj, bArr, i8, i9, i10, c1323d1);
        c1323d1.f15406e--;
        c1323d1.f15404c = obj;
        return iW;
    }

    public static int n(Object obj, InterfaceC1384p2 interfaceC1384p2, byte[] bArr, int i8, int i9, C1323d1 c1323d1) throws R1 {
        int iJ = i8 + 1;
        int i10 = bArr[i8];
        if (i10 < 0) {
            iJ = j(i10, bArr, iJ, c1323d1);
            i10 = c1323d1.f15402a;
        }
        int i11 = iJ;
        if (i10 < 0 || i10 > i9 - i11) {
            throw new R1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i12 = c1323d1.f15406e + 1;
        c1323d1.f15406e = i12;
        p(i12);
        int i13 = i10 + i11;
        interfaceC1384p2.g(obj, bArr, i11, i13, c1323d1);
        c1323d1.f15406e--;
        c1323d1.f15404c = obj;
        return i13;
    }

    public static long o(byte[] bArr, int i8) {
        return (((long) bArr[i8]) & 255) | ((((long) bArr[i8 + 1]) & 255) << 8) | ((((long) bArr[i8 + 2]) & 255) << 16) | ((((long) bArr[i8 + 3]) & 255) << 24) | ((((long) bArr[i8 + 4]) & 255) << 32) | ((((long) bArr[i8 + 5]) & 255) << 40) | ((((long) bArr[i8 + 6]) & 255) << 48) | ((((long) bArr[i8 + 7]) & 255) << 56);
    }

    public static void p(int i8) throws R1 {
        if (i8 >= f15407a) {
            throw new R1("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
