package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w0 f5818a = new w0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x0 f5819b = new x0();

    public static void a(byte b3, byte b6, byte b7, byte b8, char[] cArr, int i) throws O {
        if (!r(b6)) {
            if ((((b6 + 112) + (b3 << 28)) >> 30) == 0 && !r(b7) && !r(b8)) {
                int i6 = ((b3 & 7) << 18) | ((b6 & 63) << 12) | ((b7 & 63) << 6) | (b8 & 63);
                cArr[i] = (char) ((i6 >>> 10) + 55232);
                cArr[i + 1] = (char) ((i6 & 1023) + 56320);
                return;
            }
        }
        throw O.c();
    }

    public static void b(byte b3, byte b6, char[] cArr, int i) throws O {
        if (b3 < -62 || r(b6)) {
            throw O.c();
        }
        cArr[i] = (char) (((b3 & 31) << 6) | (b6 & 63));
    }

    public static void c(byte b3, byte b6, byte b7, char[] cArr, int i) throws O {
        if (r(b6) || ((b3 == -32 && b6 < -96) || ((b3 == -19 && b6 >= -96) || r(b7)))) {
            throw O.c();
        }
        cArr[i] = (char) (((b3 & 15) << 12) | ((b6 & 63) << 6) | (b7 & 63));
    }

    public static int d(byte[] bArr, int i, C0458e c0458e) throws O {
        int iM = m(bArr, i, c0458e);
        int i6 = c0458e.f5713a;
        if (i6 < 0) {
            throw O.f();
        }
        if (i6 > bArr.length - iM) {
            throw O.h();
        }
        if (i6 == 0) {
            c0458e.f5715c = AbstractC0472l.f5744b;
            return iM;
        }
        c0458e.f5715c = AbstractC0472l.k(bArr, iM, i6);
        return iM + i6;
    }

    public static int e(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static long f(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static int g(InterfaceC0488t0 interfaceC0488t0, int i, byte[] bArr, int i6, int i7, L l6, C0458e c0458e) throws O {
        E eD = interfaceC0488t0.d();
        InterfaceC0488t0 interfaceC0488t02 = interfaceC0488t0;
        byte[] bArr2 = bArr;
        int i8 = i7;
        C0458e c0458e2 = c0458e;
        int iU = u(eD, interfaceC0488t02, bArr2, i6, i8, c0458e2);
        interfaceC0488t02.b(eD);
        c0458e2.f5715c = eD;
        l6.add(eD);
        while (iU < i8) {
            C0458e c0458e3 = c0458e2;
            int i9 = i8;
            int iM = m(bArr2, iU, c0458e3);
            if (i != c0458e3.f5713a) {
                break;
            }
            byte[] bArr3 = bArr2;
            InterfaceC0488t0 interfaceC0488t03 = interfaceC0488t02;
            E eD2 = interfaceC0488t03.d();
            iU = u(eD2, interfaceC0488t03, bArr3, iM, i9, c0458e3);
            interfaceC0488t02 = interfaceC0488t03;
            bArr2 = bArr3;
            i8 = i9;
            c0458e2 = c0458e3;
            interfaceC0488t02.b(eD2);
            c0458e2.f5715c = eD2;
            l6.add(eD2);
        }
        return iU;
    }

    public static int h(int i, byte[] bArr, int i6, int i7, D0 d02, C0458e c0458e) throws O {
        if ((i >>> 3) == 0) {
            throw O.b();
        }
        int i8 = i & 7;
        if (i8 == 0) {
            int iO = o(bArr, i6, c0458e);
            d02.d(i, Long.valueOf(c0458e.f5714b));
            return iO;
        }
        if (i8 == 1) {
            d02.d(i, Long.valueOf(f(bArr, i6)));
            return i6 + 8;
        }
        if (i8 == 2) {
            int iM = m(bArr, i6, c0458e);
            int i9 = c0458e.f5713a;
            if (i9 < 0) {
                throw O.f();
            }
            if (i9 > bArr.length - iM) {
                throw O.h();
            }
            if (i9 == 0) {
                d02.d(i, AbstractC0472l.f5744b);
            } else {
                d02.d(i, AbstractC0472l.k(bArr, iM, i9));
            }
            return iM + i9;
        }
        if (i8 != 3) {
            if (i8 != 5) {
                throw O.b();
            }
            d02.d(i, Integer.valueOf(e(bArr, i6)));
            return i6 + 4;
        }
        D0 d0C = D0.c();
        int i10 = (i & (-8)) | 4;
        int i11 = c0458e.f5716d + 1;
        c0458e.f5716d = i11;
        if (i11 >= 100) {
            throw new O("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i12 = 0;
        while (true) {
            if (i6 >= i7) {
                break;
            }
            int iM2 = m(bArr, i6, c0458e);
            i12 = c0458e.f5713a;
            if (i12 == i10) {
                i6 = iM2;
                break;
            }
            i6 = h(i12, bArr, iM2, i7, d0C, c0458e);
        }
        c0458e.f5716d--;
        if (i6 > i7 || i12 != i10) {
            throw O.g();
        }
        d02.d(i, d0C);
        return i6;
    }

    public static String j(int i, ByteBuffer byteBuffer, int i6) throws O {
        if ((i | i6 | ((byteBuffer.limit() - i) - i6)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i6)));
        }
        int i7 = i + i6;
        char[] cArr = new char[i6];
        int i8 = 0;
        while (i < i7) {
            byte b3 = byteBuffer.get(i);
            if (b3 < 0) {
                break;
            }
            i++;
            cArr[i8] = (char) b3;
            i8++;
        }
        int i9 = i8;
        while (i < i7) {
            int i10 = i + 1;
            byte b6 = byteBuffer.get(i);
            if (b6 >= 0) {
                int i11 = i9 + 1;
                cArr[i9] = (char) b6;
                int i12 = i10;
                while (i12 < i7) {
                    byte b7 = byteBuffer.get(i12);
                    if (b7 < 0) {
                        break;
                    }
                    i12++;
                    cArr[i11] = (char) b7;
                    i11++;
                }
                i9 = i11;
                i = i12;
            } else if (b6 < -32) {
                if (i10 >= i7) {
                    throw O.c();
                }
                i += 2;
                b(b6, byteBuffer.get(i10), cArr, i9);
                i9++;
            } else if (b6 < -16) {
                if (i10 >= i7 - 1) {
                    throw O.c();
                }
                int i13 = i + 2;
                i += 3;
                c(b6, byteBuffer.get(i10), byteBuffer.get(i13), cArr, i9);
                i9++;
            } else {
                if (i10 >= i7 - 2) {
                    throw O.c();
                }
                byte b8 = byteBuffer.get(i10);
                int i14 = i + 3;
                byte b9 = byteBuffer.get(i + 2);
                i += 4;
                a(b6, b8, b9, byteBuffer.get(i14), cArr, i9);
                i9 += 2;
            }
        }
        return new String(cArr, 0, i9);
    }

    public static int l(int i, byte[] bArr, int i6, C0458e c0458e) {
        int i7 = i & 127;
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            c0458e.f5713a = i7 | (b3 << 7);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 7);
        int i10 = i6 + 2;
        byte b6 = bArr[i8];
        if (b6 >= 0) {
            c0458e.f5713a = i9 | (b6 << 14);
            return i10;
        }
        int i11 = i9 | ((b6 & 127) << 14);
        int i12 = i6 + 3;
        byte b7 = bArr[i10];
        if (b7 >= 0) {
            c0458e.f5713a = i11 | (b7 << 21);
            return i12;
        }
        int i13 = i11 | ((b7 & 127) << 21);
        int i14 = i6 + 4;
        byte b8 = bArr[i12];
        if (b8 >= 0) {
            c0458e.f5713a = i13 | (b8 << 28);
            return i14;
        }
        int i15 = i13 | ((b8 & 127) << 28);
        while (true) {
            int i16 = i14 + 1;
            if (bArr[i14] >= 0) {
                c0458e.f5713a = i15;
                return i16;
            }
            i14 = i16;
        }
    }

    public static int m(byte[] bArr, int i, C0458e c0458e) {
        int i6 = i + 1;
        byte b3 = bArr[i];
        if (b3 < 0) {
            return l(b3, bArr, i6, c0458e);
        }
        c0458e.f5713a = b3;
        return i6;
    }

    public static int n(int i, byte[] bArr, int i6, int i7, L l6, C0458e c0458e) {
        I i8 = (I) l6;
        int iM = m(bArr, i6, c0458e);
        i8.b(c0458e.f5713a);
        while (iM < i7) {
            int iM2 = m(bArr, iM, c0458e);
            if (i != c0458e.f5713a) {
                break;
            }
            iM = m(bArr, iM2, c0458e);
            i8.b(c0458e.f5713a);
        }
        return iM;
    }

    public static int o(byte[] bArr, int i, C0458e c0458e) {
        int i6 = i + 1;
        long j4 = bArr[i];
        if (j4 >= 0) {
            c0458e.f5714b = j4;
            return i6;
        }
        int i7 = i + 2;
        byte b3 = bArr[i6];
        long j6 = (j4 & 127) | (((long) (b3 & 127)) << 7);
        int i8 = 7;
        while (b3 < 0) {
            int i9 = i7 + 1;
            byte b6 = bArr[i7];
            i8 += 7;
            j6 |= ((long) (b6 & 127)) << i8;
            b3 = b6;
            i7 = i9;
        }
        c0458e.f5714b = j6;
        return i7;
    }

    public static String q(AbstractC0472l abstractC0472l) {
        StringBuilder sb = new StringBuilder(abstractC0472l.size());
        for (int i = 0; i < abstractC0472l.size(); i++) {
            byte bC = abstractC0472l.c(i);
            if (bC == 34) {
                sb.append("\\\"");
            } else if (bC == 39) {
                sb.append("\\'");
            } else if (bC != 92) {
                switch (bC) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case s3.I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                        sb.append("\\t");
                        break;
                    case s3.I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case s3.B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bC < 32 || bC > 126) {
                            sb.append('\\');
                            sb.append((char) (((bC >>> 6) & 3) + 48));
                            sb.append((char) (((bC >>> 3) & 7) + 48));
                            sb.append((char) ((bC & 7) + 48));
                        } else {
                            sb.append((char) bC);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static boolean r(byte b3) {
        return b3 > -65;
    }

    public static int t(Object obj, InterfaceC0488t0 interfaceC0488t0, byte[] bArr, int i, int i6, int i7, C0458e c0458e) throws O {
        C0465h0 c0465h0 = (C0465h0) interfaceC0488t0;
        int i8 = c0458e.f5716d + 1;
        c0458e.f5716d = i8;
        if (i8 >= 100) {
            throw new O("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iH = c0465h0.H(obj, bArr, i, i6, i7, c0458e);
        c0458e.f5716d--;
        c0458e.f5715c = obj;
        return iH;
    }

    public static int u(Object obj, InterfaceC0488t0 interfaceC0488t0, byte[] bArr, int i, int i6, C0458e c0458e) throws O {
        int iL = i + 1;
        int i7 = bArr[i];
        if (i7 < 0) {
            iL = l(i7, bArr, iL, c0458e);
            i7 = c0458e.f5713a;
        }
        int i8 = iL;
        if (i7 < 0 || i7 > i6 - i8) {
            throw O.h();
        }
        int i9 = c0458e.f5716d + 1;
        c0458e.f5716d = i9;
        if (i9 >= 100) {
            throw new O("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i10 = i8 + i7;
        interfaceC0488t0.h(obj, bArr, i8, i10, c0458e);
        c0458e.f5716d--;
        c0458e.f5715c = obj;
        return i10;
    }

    public static int w(int i, byte[] bArr, int i6, int i7, C0458e c0458e) throws O {
        if ((i >>> 3) == 0) {
            throw O.b();
        }
        int i8 = i & 7;
        if (i8 == 0) {
            return o(bArr, i6, c0458e);
        }
        if (i8 == 1) {
            return i6 + 8;
        }
        if (i8 == 2) {
            return m(bArr, i6, c0458e) + c0458e.f5713a;
        }
        if (i8 != 3) {
            if (i8 == 5) {
                return i6 + 4;
            }
            throw O.b();
        }
        int i9 = (i & (-8)) | 4;
        int i10 = 0;
        while (i6 < i7) {
            i6 = m(bArr, i6, c0458e);
            i10 = c0458e.f5713a;
            if (i10 == i9) {
                break;
            }
            i6 = w(i10, bArr, i6, i7, c0458e);
        }
        if (i6 > i7 || i10 != i9) {
            throw O.g();
        }
        return i6;
    }

    public abstract String i(byte[] bArr, int i, int i6);

    public abstract String k(int i, ByteBuffer byteBuffer, int i6);

    public abstract int p(String str, byte[] bArr, int i, int i6);

    public boolean s(byte[] bArr, int i, int i6) {
        return v(0, bArr, i, i6) == 0;
    }

    public abstract int v(int i, byte[] bArr, int i6, int i7);

    public abstract void x(byte[] bArr, int i, int i6);
}
