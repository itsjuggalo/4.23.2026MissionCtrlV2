package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class A0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12505a;

    public static class a {
        public static void h(byte b7, byte b8, byte b9, byte b10, char[] cArr, int i7) throws D {
            if (m(b8) || (((b7 << 28) + (b8 + 112)) >> 30) != 0 || m(b9) || m(b10)) {
                throw D.d();
            }
            int iR = ((b7 & 7) << 18) | (r(b8) << 12) | (r(b9) << 6) | r(b10);
            cArr[i7] = l(iR);
            cArr[i7 + 1] = q(iR);
        }

        public static void i(byte b7, char[] cArr, int i7) {
            cArr[i7] = (char) b7;
        }

        public static void j(byte b7, byte b8, byte b9, char[] cArr, int i7) throws D {
            if (m(b8) || ((b7 == -32 && b8 < -96) || ((b7 == -19 && b8 >= -96) || m(b9)))) {
                throw D.d();
            }
            cArr[i7] = (char) (((b7 & 15) << 12) | (r(b8) << 6) | r(b9));
        }

        public static void k(byte b7, byte b8, char[] cArr, int i7) throws D {
            if (b7 < -62 || m(b8)) {
                throw D.d();
            }
            cArr[i7] = (char) (((b7 & 31) << 6) | r(b8));
        }

        public static char l(int i7) {
            return (char) ((i7 >>> 10) + 55232);
        }

        public static boolean m(byte b7) {
            return b7 > -65;
        }

        public static boolean n(byte b7) {
            return b7 >= 0;
        }

        public static boolean o(byte b7) {
            return b7 < -16;
        }

        public static boolean p(byte b7) {
            return b7 < -32;
        }

        public static char q(int i7) {
            return (char) ((i7 & 1023) + 56320);
        }

        public static int r(byte b7) {
            return b7 & 63;
        }
    }

    public static abstract class b {
        public static int j(ByteBuffer byteBuffer, int i7, int i8) {
            int iL = i7 + A0.l(byteBuffer, i7, i8);
            while (iL < i8) {
                int i9 = iL + 1;
                byte b7 = byteBuffer.get(iL);
                if (b7 >= 0) {
                    iL = i9;
                } else if (b7 < -32) {
                    if (i9 >= i8) {
                        return b7;
                    }
                    if (b7 < -62 || byteBuffer.get(i9) > -65) {
                        return -1;
                    }
                    iL += 2;
                } else {
                    if (b7 >= -16) {
                        if (i9 >= i8 - 2) {
                            return A0.p(byteBuffer, b7, i9, i8 - i9);
                        }
                        int i10 = iL + 2;
                        byte b8 = byteBuffer.get(i9);
                        if (b8 <= -65 && (((b7 << 28) + (b8 + 112)) >> 30) == 0) {
                            int i11 = iL + 3;
                            if (byteBuffer.get(i10) <= -65) {
                                iL += 4;
                                if (byteBuffer.get(i11) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i9 >= i8 - 1) {
                        return A0.p(byteBuffer, b7, i9, i8 - i9);
                    }
                    int i12 = iL + 2;
                    byte b9 = byteBuffer.get(i9);
                    if (b9 > -65 || ((b7 == -32 && b9 < -96) || ((b7 == -19 && b9 >= -96) || byteBuffer.get(i12) > -65))) {
                        return -1;
                    }
                    iL += 3;
                }
            }
            return 0;
        }

        public final String a(ByteBuffer byteBuffer, int i7, int i8) {
            if (byteBuffer.hasArray()) {
                return b(byteBuffer.array(), byteBuffer.arrayOffset() + i7, i8);
            }
            return byteBuffer.isDirect() ? d(byteBuffer, i7, i8) : c(byteBuffer, i7, i8);
        }

        public abstract String b(byte[] bArr, int i7, int i8);

        public final String c(ByteBuffer byteBuffer, int i7, int i8) throws D {
            if ((i7 | i8 | ((byteBuffer.limit() - i7) - i8)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i7), Integer.valueOf(i8)));
            }
            int i9 = i7 + i8;
            char[] cArr = new char[i8];
            int i10 = 0;
            while (i7 < i9) {
                byte b7 = byteBuffer.get(i7);
                if (!a.n(b7)) {
                    break;
                }
                i7++;
                a.i(b7, cArr, i10);
                i10++;
            }
            int i11 = i10;
            while (i7 < i9) {
                int i12 = i7 + 1;
                byte b8 = byteBuffer.get(i7);
                if (a.n(b8)) {
                    int i13 = i11 + 1;
                    a.i(b8, cArr, i11);
                    while (i12 < i9) {
                        byte b9 = byteBuffer.get(i12);
                        if (!a.n(b9)) {
                            break;
                        }
                        i12++;
                        a.i(b9, cArr, i13);
                        i13++;
                    }
                    i11 = i13;
                    i7 = i12;
                } else if (a.p(b8)) {
                    if (i12 >= i9) {
                        throw D.d();
                    }
                    i7 += 2;
                    a.k(b8, byteBuffer.get(i12), cArr, i11);
                    i11++;
                } else if (a.o(b8)) {
                    if (i12 >= i9 - 1) {
                        throw D.d();
                    }
                    int i14 = i7 + 2;
                    i7 += 3;
                    a.j(b8, byteBuffer.get(i12), byteBuffer.get(i14), cArr, i11);
                    i11++;
                } else {
                    if (i12 >= i9 - 2) {
                        throw D.d();
                    }
                    byte b10 = byteBuffer.get(i12);
                    int i15 = i7 + 3;
                    byte b11 = byteBuffer.get(i7 + 2);
                    i7 += 4;
                    a.h(b8, b10, b11, byteBuffer.get(i15), cArr, i11);
                    i11 += 2;
                }
            }
            return new String(cArr, 0, i11);
        }

        public abstract String d(ByteBuffer byteBuffer, int i7, int i8);

        public abstract int e(CharSequence charSequence, byte[] bArr, int i7, int i8);

        public final boolean f(ByteBuffer byteBuffer, int i7, int i8) {
            return h(0, byteBuffer, i7, i8) == 0;
        }

        public final boolean g(byte[] bArr, int i7, int i8) {
            return i(0, bArr, i7, i8) == 0;
        }

        public final int h(int i7, ByteBuffer byteBuffer, int i8, int i9) {
            if (!byteBuffer.hasArray()) {
                return byteBuffer.isDirect() ? l(i7, byteBuffer, i8, i9) : k(i7, byteBuffer, i8, i9);
            }
            int iArrayOffset = byteBuffer.arrayOffset();
            return i(i7, byteBuffer.array(), i8 + iArrayOffset, iArrayOffset + i9);
        }

        public abstract int i(int i7, byte[] bArr, int i8, int i9);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r8.get(r9) > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
        
            if (r8.get(r9) > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008f, code lost:
        
            if (r8.get(r7) > (-65)) goto L53;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int k(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L92
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1e
                r7 = -62
                if (r0 < r7) goto L1d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
                goto L1d
            L1a:
                r9 = r7
                goto L92
            L1d:
                return r2
            L1e:
                r4 = -16
                if (r0 >= r4) goto L4f
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L38
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L35
                int r7 = com.google.protobuf.A0.a(r0, r9)
                return r7
            L35:
                r5 = r9
                r9 = r7
                r7 = r5
            L38:
                if (r7 > r3) goto L4e
                r4 = -96
                if (r0 != r1) goto L40
                if (r7 < r4) goto L4e
            L40:
                r1 = -19
                if (r0 != r1) goto L46
                if (r7 >= r4) goto L4e
            L46:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
            L4e:
                return r2
            L4f:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L64
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L62
                int r7 = com.google.protobuf.A0.a(r0, r1)
                return r7
            L62:
                r9 = 0
                goto L6a
            L64:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L6a:
                if (r9 != 0) goto L7c
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r9 < r10) goto L79
                int r7 = com.google.protobuf.A0.b(r0, r1, r7)
                return r7
            L79:
                r5 = r9
                r9 = r7
                r7 = r5
            L7c:
                if (r1 > r3) goto L91
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L91
                if (r9 > r3) goto L91
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r7 <= r3) goto L92
            L91:
                return r2
            L92:
                int r7 = j(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.A0.b.k(int, java.nio.ByteBuffer, int, int):int");
        }

        public abstract int l(int i7, ByteBuffer byteBuffer, int i8, int i9);
    }

    public static final class c extends b {
        public static int m(byte[] bArr, int i7, int i8) {
            while (i7 < i8 && bArr[i7] >= 0) {
                i7++;
            }
            if (i7 >= i8) {
                return 0;
            }
            return n(bArr, i7, i8);
        }

        public static int n(byte[] bArr, int i7, int i8) {
            while (i7 < i8) {
                int i9 = i7 + 1;
                byte b7 = bArr[i7];
                if (b7 < 0) {
                    if (b7 < -32) {
                        if (i9 >= i8) {
                            return b7;
                        }
                        if (b7 >= -62) {
                            i7 += 2;
                            if (bArr[i9] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b7 >= -16) {
                        if (i9 >= i8 - 2) {
                            return A0.q(bArr, i9, i8);
                        }
                        int i10 = i7 + 2;
                        byte b8 = bArr[i9];
                        if (b8 <= -65 && (((b7 << 28) + (b8 + 112)) >> 30) == 0) {
                            int i11 = i7 + 3;
                            if (bArr[i10] <= -65) {
                                i7 += 4;
                                if (bArr[i11] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i9 >= i8 - 1) {
                        return A0.q(bArr, i9, i8);
                    }
                    int i12 = i7 + 2;
                    byte b9 = bArr[i9];
                    if (b9 <= -65 && ((b7 != -32 || b9 >= -96) && (b7 != -19 || b9 < -96))) {
                        i7 += 3;
                        if (bArr[i12] > -65) {
                        }
                    }
                    return -1;
                }
                i7 = i9;
            }
            return 0;
        }

        @Override // com.google.protobuf.A0.b
        public String b(byte[] bArr, int i7, int i8) throws D {
            if ((i7 | i8 | ((bArr.length - i7) - i8)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i7), Integer.valueOf(i8)));
            }
            int i9 = i7 + i8;
            char[] cArr = new char[i8];
            int i10 = 0;
            while (i7 < i9) {
                byte b7 = bArr[i7];
                if (!a.n(b7)) {
                    break;
                }
                i7++;
                a.i(b7, cArr, i10);
                i10++;
            }
            int i11 = i10;
            while (i7 < i9) {
                int i12 = i7 + 1;
                byte b8 = bArr[i7];
                if (a.n(b8)) {
                    int i13 = i11 + 1;
                    a.i(b8, cArr, i11);
                    while (i12 < i9) {
                        byte b9 = bArr[i12];
                        if (!a.n(b9)) {
                            break;
                        }
                        i12++;
                        a.i(b9, cArr, i13);
                        i13++;
                    }
                    i11 = i13;
                    i7 = i12;
                } else if (a.p(b8)) {
                    if (i12 >= i9) {
                        throw D.d();
                    }
                    i7 += 2;
                    a.k(b8, bArr[i12], cArr, i11);
                    i11++;
                } else if (a.o(b8)) {
                    if (i12 >= i9 - 1) {
                        throw D.d();
                    }
                    int i14 = i7 + 2;
                    i7 += 3;
                    a.j(b8, bArr[i12], bArr[i14], cArr, i11);
                    i11++;
                } else {
                    if (i12 >= i9 - 2) {
                        throw D.d();
                    }
                    byte b10 = bArr[i12];
                    int i15 = i7 + 3;
                    byte b11 = bArr[i7 + 2];
                    i7 += 4;
                    a.h(b8, b10, b11, bArr[i15], cArr, i11);
                    i11 += 2;
                }
            }
            return new String(cArr, 0, i11);
        }

        @Override // com.google.protobuf.A0.b
        public String d(ByteBuffer byteBuffer, int i7, int i8) {
            return c(byteBuffer, i7, i8);
        }

        @Override // com.google.protobuf.A0.b
        public int e(CharSequence charSequence, byte[] bArr, int i7, int i8) {
            int i9;
            int i10;
            char cCharAt;
            int length = charSequence.length();
            int i11 = i8 + i7;
            int i12 = 0;
            while (i12 < length && (i10 = i12 + i7) < i11 && (cCharAt = charSequence.charAt(i12)) < 128) {
                bArr[i10] = (byte) cCharAt;
                i12++;
            }
            if (i12 == length) {
                return i7 + length;
            }
            int i13 = i7 + i12;
            while (i12 < length) {
                char cCharAt2 = charSequence.charAt(i12);
                if (cCharAt2 < 128 && i13 < i11) {
                    bArr[i13] = (byte) cCharAt2;
                    i13++;
                } else if (cCharAt2 < 2048 && i13 <= i11 - 2) {
                    int i14 = i13 + 1;
                    bArr[i13] = (byte) ((cCharAt2 >>> 6) | 960);
                    i13 += 2;
                    bArr[i14] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i13 > i11 - 3) {
                        if (i13 > i11 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i9 = i12 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i9)))) {
                                throw new d(i12, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i13);
                        }
                        int i15 = i12 + 1;
                        if (i15 != charSequence.length()) {
                            char cCharAt3 = charSequence.charAt(i15);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i13] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i13 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i16 = i13 + 3;
                                bArr[i13 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i13 += 4;
                                bArr[i16] = (byte) ((codePoint & 63) | 128);
                                i12 = i15;
                            } else {
                                i12 = i15;
                            }
                        }
                        throw new d(i12 - 1, length);
                    }
                    bArr[i13] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i17 = i13 + 2;
                    bArr[i13 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i13 += 3;
                    bArr[i17] = (byte) ((cCharAt2 & '?') | 128);
                }
                i12++;
            }
            return i13;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r8[r9] > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
        
            if (r8[r9] > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0083, code lost:
        
            if (r8[r7] > (-65)) goto L53;
         */
        @Override // com.google.protobuf.A0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int i(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L86
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1c
                r7 = -62
                if (r0 < r7) goto L1b
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
                goto L1b
            L18:
                r9 = r7
                goto L86
            L1b:
                return r2
            L1c:
                r4 = -16
                if (r0 >= r4) goto L49
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L34
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L31
                int r7 = com.google.protobuf.A0.a(r0, r9)
                return r7
            L31:
                r5 = r9
                r9 = r7
                r7 = r5
            L34:
                if (r7 > r3) goto L48
                r4 = -96
                if (r0 != r1) goto L3c
                if (r7 < r4) goto L48
            L3c:
                r1 = -19
                if (r0 != r1) goto L42
                if (r7 >= r4) goto L48
            L42:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L48:
                return r2
            L49:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L5c
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L5a
                int r7 = com.google.protobuf.A0.a(r0, r1)
                return r7
            L5a:
                r9 = 0
                goto L62
            L5c:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L62:
                if (r9 != 0) goto L72
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r9 < r10) goto L6f
                int r7 = com.google.protobuf.A0.b(r0, r1, r7)
                return r7
            L6f:
                r5 = r9
                r9 = r7
                r7 = r5
            L72:
                if (r1 > r3) goto L85
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L85
                if (r9 > r3) goto L85
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r7 <= r3) goto L86
            L85:
                return r2
            L86:
                int r7 = m(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.A0.c.i(int, byte[], int, int):int");
        }

        @Override // com.google.protobuf.A0.b
        public int l(int i7, ByteBuffer byteBuffer, int i8, int i9) {
            return k(i7, byteBuffer, i8, i9);
        }
    }

    public static class d extends IllegalArgumentException {
        public d(int i7, int i8) {
            super("Unpaired surrogate at index " + i7 + " of " + i8);
        }
    }

    public static final class e extends b {
        public static boolean m() {
            return z0.I() && z0.J();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int n(long r10, int r12) {
            /*
                int r0 = p(r10, r12)
                long r1 = (long) r0
                long r10 = r10 + r1
                int r12 = r12 - r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r12 <= 0) goto L1a
                long r4 = r10 + r2
                byte r1 = com.google.protobuf.z0.w(r10)
                if (r1 < 0) goto L19
                int r12 = r12 + (-1)
                r10 = r4
                goto L9
            L19:
                r10 = r4
            L1a:
                if (r12 != 0) goto L1d
                return r0
            L1d:
                int r0 = r12 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r12 = r12 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r10
                byte r10 = com.google.protobuf.z0.w(r10)
                if (r10 <= r6) goto L37
                goto L39
            L37:
                r10 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = r(r10, r1, r0)
                return r10
            L48:
                int r12 = r12 + (-3)
                long r2 = r2 + r10
                byte r0 = com.google.protobuf.z0.w(r10)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r10 = r10 + r8
                byte r0 = com.google.protobuf.z0.w(r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = r(r10, r1, r0)
                return r10
            L6d:
                int r12 = r12 + (-4)
                long r2 = r2 + r10
                byte r0 = com.google.protobuf.z0.w(r10)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r10
                byte r0 = com.google.protobuf.z0.w(r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r10 = r10 + r0
                byte r0 = com.google.protobuf.z0.w(r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.A0.e.n(long, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int o(byte[] r10, long r11, int r13) {
            /*
                int r0 = q(r10, r11, r13)
                int r13 = r13 - r0
                long r0 = (long) r0
                long r11 = r11 + r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r13 <= 0) goto L1a
                long r4 = r11 + r2
                byte r1 = com.google.protobuf.z0.x(r10, r11)
                if (r1 < 0) goto L19
                int r13 = r13 + (-1)
                r11 = r4
                goto L9
            L19:
                r11 = r4
            L1a:
                if (r13 != 0) goto L1d
                return r0
            L1d:
                int r0 = r13 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r13 = r13 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r11
                byte r11 = com.google.protobuf.z0.x(r10, r11)
                if (r11 <= r6) goto L37
                goto L39
            L37:
                r11 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = s(r10, r1, r11, r0)
                return r10
            L48:
                int r13 = r13 + (-3)
                long r2 = r2 + r11
                byte r0 = com.google.protobuf.z0.x(r10, r11)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r11 = r11 + r8
                byte r0 = com.google.protobuf.z0.x(r10, r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = s(r10, r1, r11, r0)
                return r10
            L6d:
                int r13 = r13 + (-4)
                long r2 = r2 + r11
                byte r0 = com.google.protobuf.z0.x(r10, r11)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r11
                byte r0 = com.google.protobuf.z0.x(r10, r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r11 = r11 + r0
                byte r0 = com.google.protobuf.z0.x(r10, r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.A0.e.o(byte[], long, int):int");
        }

        public static int p(long j7, int i7) {
            if (i7 < 16) {
                return 0;
            }
            int i8 = (int) ((-j7) & 7);
            int i9 = i8;
            while (i9 > 0) {
                long j8 = 1 + j7;
                if (z0.w(j7) < 0) {
                    return i8 - i9;
                }
                i9--;
                j7 = j8;
            }
            int i10 = i7 - i8;
            while (i10 >= 8 && (z0.D(j7) & (-9187201950435737472L)) == 0) {
                j7 += 8;
                i10 -= 8;
            }
            return i7 - i10;
        }

        public static int q(byte[] bArr, long j7, int i7) {
            int i8 = 0;
            if (i7 < 16) {
                return 0;
            }
            int i9 = 8 - (((int) j7) & 7);
            while (i8 < i9) {
                long j8 = 1 + j7;
                if (z0.x(bArr, j7) < 0) {
                    return i8;
                }
                i8++;
                j7 = j8;
            }
            while (true) {
                int i10 = i8 + 8;
                if (i10 > i7 || (z0.E(bArr, z0.f12892h + j7) & (-9187201950435737472L)) != 0) {
                    break;
                }
                j7 += 8;
                i8 = i10;
            }
            while (i8 < i7) {
                long j9 = j7 + 1;
                if (z0.x(bArr, j7) < 0) {
                    return i8;
                }
                i8++;
                j7 = j9;
            }
            return i7;
        }

        public static int r(long j7, int i7, int i8) {
            if (i8 == 0) {
                return A0.m(i7);
            }
            if (i8 == 1) {
                return A0.n(i7, z0.w(j7));
            }
            if (i8 == 2) {
                return A0.o(i7, z0.w(j7), z0.w(j7 + 1));
            }
            throw new AssertionError();
        }

        public static int s(byte[] bArr, int i7, long j7, int i8) {
            if (i8 == 0) {
                return A0.m(i7);
            }
            if (i8 == 1) {
                return A0.n(i7, z0.x(bArr, j7));
            }
            if (i8 == 2) {
                return A0.o(i7, z0.x(bArr, j7), z0.x(bArr, j7 + 1));
            }
            throw new AssertionError();
        }

        @Override // com.google.protobuf.A0.b
        public String b(byte[] bArr, int i7, int i8) throws D {
            Charset charset = C.f12546b;
            String str = new String(bArr, i7, i8, charset);
            if (str.contains("�") && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i7, i8 + i7))) {
                throw D.d();
            }
            return str;
        }

        @Override // com.google.protobuf.A0.b
        public String d(ByteBuffer byteBuffer, int i7, int i8) throws D {
            if ((i7 | i8 | ((byteBuffer.limit() - i7) - i8)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i7), Integer.valueOf(i8)));
            }
            long jK = z0.k(byteBuffer) + ((long) i7);
            long j7 = ((long) i8) + jK;
            char[] cArr = new char[i8];
            int i9 = 0;
            while (jK < j7) {
                byte bW = z0.w(jK);
                if (!a.n(bW)) {
                    break;
                }
                jK++;
                a.i(bW, cArr, i9);
                i9++;
            }
            int i10 = i9;
            while (jK < j7) {
                long j8 = jK + 1;
                byte bW2 = z0.w(jK);
                if (a.n(bW2)) {
                    int i11 = i10 + 1;
                    a.i(bW2, cArr, i10);
                    while (j8 < j7) {
                        byte bW3 = z0.w(j8);
                        if (!a.n(bW3)) {
                            break;
                        }
                        j8++;
                        a.i(bW3, cArr, i11);
                        i11++;
                    }
                    i10 = i11;
                    jK = j8;
                } else if (a.p(bW2)) {
                    if (j8 >= j7) {
                        throw D.d();
                    }
                    jK += 2;
                    a.k(bW2, z0.w(j8), cArr, i10);
                    i10++;
                } else if (a.o(bW2)) {
                    if (j8 >= j7 - 1) {
                        throw D.d();
                    }
                    long j9 = 2 + jK;
                    jK += 3;
                    a.j(bW2, z0.w(j8), z0.w(j9), cArr, i10);
                    i10++;
                } else {
                    if (j8 >= j7 - 2) {
                        throw D.d();
                    }
                    byte bW4 = z0.w(j8);
                    long j10 = 3 + jK;
                    byte bW5 = z0.w(2 + jK);
                    jK += 4;
                    a.h(bW2, bW4, bW5, z0.w(j10), cArr, i10);
                    i10 += 2;
                }
            }
            return new String(cArr, 0, i10);
        }

        @Override // com.google.protobuf.A0.b
        public int e(CharSequence charSequence, byte[] bArr, int i7, int i8) {
            long j7;
            String str;
            String str2;
            int i9;
            long j8;
            long j9;
            char cCharAt;
            long j10 = i7;
            long j11 = ((long) i8) + j10;
            int length = charSequence.length();
            String str3 = " at index ";
            String str4 = "Failed writing ";
            if (length > i8 || bArr.length - i8 < i7) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i7 + i8));
            }
            int i10 = 0;
            while (true) {
                j7 = 1;
                if (i10 >= length || (cCharAt = charSequence.charAt(i10)) >= 128) {
                    break;
                }
                z0.O(bArr, j10, (byte) cCharAt);
                i10++;
                j10 = 1 + j10;
            }
            if (i10 == length) {
                return (int) j10;
            }
            while (i10 < length) {
                char cCharAt2 = charSequence.charAt(i10);
                if (cCharAt2 >= 128 || j10 >= j11) {
                    if (cCharAt2 >= 2048 || j10 > j11 - 2) {
                        str = str3;
                        str2 = str4;
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j10 > j11 - 3) {
                            if (j10 > j11 - 4) {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i9 = i10 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i9)))) {
                                    throw new d(i10, length);
                                }
                                throw new ArrayIndexOutOfBoundsException(str2 + cCharAt2 + str + j10);
                            }
                            int i11 = i10 + 1;
                            if (i11 != length) {
                                char cCharAt3 = charSequence.charAt(i11);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    j8 = 1;
                                    z0.O(bArr, j10, (byte) ((codePoint >>> 18) | 240));
                                    j9 = j11;
                                    z0.O(bArr, j10 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j12 = j10 + 3;
                                    z0.O(bArr, j10 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j10 += 4;
                                    z0.O(bArr, j12, (byte) ((codePoint & 63) | 128));
                                    i10 = i11;
                                } else {
                                    i10 = i11;
                                }
                            }
                            throw new d(i10 - 1, length);
                        }
                        z0.O(bArr, j10, (byte) ((cCharAt2 >>> '\f') | 480));
                        long j13 = j10 + 2;
                        z0.O(bArr, j10 + 1, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                        j10 += 3;
                        z0.O(bArr, j13, (byte) ((cCharAt2 & '?') | 128));
                    } else {
                        str = str3;
                        str2 = str4;
                        long j14 = j10 + j7;
                        z0.O(bArr, j10, (byte) ((cCharAt2 >>> 6) | 960));
                        j10 += 2;
                        z0.O(bArr, j14, (byte) ((cCharAt2 & '?') | 128));
                    }
                    j9 = j11;
                    j8 = 1;
                } else {
                    z0.O(bArr, j10, (byte) cCharAt2);
                    j9 = j11;
                    str2 = str4;
                    j8 = j7;
                    j10 += j7;
                    str = str3;
                }
                i10++;
                str3 = str;
                str4 = str2;
                j7 = j8;
                j11 = j9;
            }
            return (int) j10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0058, code lost:
        
            if (com.google.protobuf.z0.x(r12, r0) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
        
            if (com.google.protobuf.z0.x(r12, r0) > (-65)) goto L59;
         */
        @Override // com.google.protobuf.A0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int i(int r11, byte[] r12, int r13, int r14) {
            /*
                r10 = this;
                r0 = r13 | r14
                int r1 = r12.length
                int r1 = r1 - r14
                r0 = r0 | r1
                if (r0 < 0) goto La8
                long r0 = (long) r13
                long r13 = (long) r14
                if (r11 == 0) goto La1
                int r2 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
                if (r2 < 0) goto L10
                return r11
            L10:
                byte r2 = (byte) r11
                r3 = -32
                r4 = -1
                r5 = -65
                r6 = 1
                if (r2 >= r3) goto L2a
                r11 = -62
                if (r2 < r11) goto L29
                long r6 = r6 + r0
                byte r11 = com.google.protobuf.z0.x(r12, r0)
                if (r11 <= r5) goto L26
                goto L29
            L26:
                r0 = r6
                goto La1
            L29:
                return r4
            L2a:
                r8 = -16
                if (r2 >= r8) goto L5e
                int r11 = r11 >> 8
                int r11 = ~r11
                byte r11 = (byte) r11
                if (r11 != 0) goto L44
                long r8 = r0 + r6
                byte r11 = com.google.protobuf.z0.x(r12, r0)
                int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r0 < 0) goto L43
                int r11 = com.google.protobuf.A0.a(r2, r11)
                return r11
            L43:
                r0 = r8
            L44:
                if (r11 > r5) goto L5d
                r8 = -96
                if (r2 != r3) goto L4c
                if (r11 < r8) goto L5d
            L4c:
                r3 = -19
                if (r2 != r3) goto L52
                if (r11 >= r8) goto L5d
            L52:
                long r2 = r0 + r6
                byte r11 = com.google.protobuf.z0.x(r12, r0)
                if (r11 <= r5) goto L5b
                goto L5d
            L5b:
                r0 = r2
                goto La1
            L5d:
                return r4
            L5e:
                int r3 = r11 >> 8
                int r3 = ~r3
                byte r3 = (byte) r3
                if (r3 != 0) goto L76
                long r8 = r0 + r6
                byte r3 = com.google.protobuf.z0.x(r12, r0)
                int r11 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r11 < 0) goto L73
                int r11 = com.google.protobuf.A0.a(r2, r3)
                return r11
            L73:
                r11 = 0
                r0 = r8
                goto L79
            L76:
                int r11 = r11 >> 16
                byte r11 = (byte) r11
            L79:
                if (r11 != 0) goto L8b
                long r8 = r0 + r6
                byte r11 = com.google.protobuf.z0.x(r12, r0)
                int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r0 < 0) goto L8a
                int r11 = com.google.protobuf.A0.b(r2, r3, r11)
                return r11
            L8a:
                r0 = r8
            L8b:
                if (r3 > r5) goto La0
                int r2 = r2 << 28
                int r3 = r3 + 112
                int r2 = r2 + r3
                int r2 = r2 >> 30
                if (r2 != 0) goto La0
                if (r11 > r5) goto La0
                long r2 = r0 + r6
                byte r11 = com.google.protobuf.z0.x(r12, r0)
                if (r11 <= r5) goto L5b
            La0:
                return r4
            La1:
                long r13 = r13 - r0
                int r11 = (int) r13
                int r11 = o(r12, r0, r11)
                return r11
            La8:
                java.lang.ArrayIndexOutOfBoundsException r11 = new java.lang.ArrayIndexOutOfBoundsException
                int r12 = r12.length
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                java.lang.Object[] r12 = new java.lang.Object[]{r12, r13, r14}
                java.lang.String r13 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r12 = java.lang.String.format(r13, r12)
                r11.<init>(r12)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.A0.e.i(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        
            if (com.google.protobuf.z0.w(r0) > (-65)) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0061, code lost:
        
            if (com.google.protobuf.z0.w(r0) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:
        
            if (com.google.protobuf.z0.w(r0) > (-65)) goto L57;
         */
        @Override // com.google.protobuf.A0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int l(int r10, java.nio.ByteBuffer r11, int r12, int r13) {
            /*
                Method dump skipped, instruction units count: 205
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.A0.e.l(int, java.nio.ByteBuffer, int, int):int");
        }
    }

    static {
        f12505a = (!e.m() || AbstractC1235d.c()) ? new c() : new e();
    }

    public static String g(ByteBuffer byteBuffer, int i7, int i8) {
        return f12505a.a(byteBuffer, i7, i8);
    }

    public static String h(byte[] bArr, int i7, int i8) {
        return f12505a.b(bArr, i7, i8);
    }

    public static int i(CharSequence charSequence, byte[] bArr, int i7, int i8) {
        return f12505a.e(charSequence, bArr, i7, i8);
    }

    public static int j(CharSequence charSequence) {
        int length = charSequence.length();
        int i7 = 0;
        while (i7 < length && charSequence.charAt(i7) < 128) {
            i7++;
        }
        int iK = length;
        while (true) {
            if (i7 < length) {
                char cCharAt = charSequence.charAt(i7);
                if (cCharAt >= 2048) {
                    iK += k(charSequence, i7);
                    break;
                }
                iK += (127 - cCharAt) >>> 31;
                i7++;
            } else {
                break;
            }
        }
        if (iK >= length) {
            return iK;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iK) + 4294967296L));
    }

    public static int k(CharSequence charSequence, int i7) {
        int length = charSequence.length();
        int i8 = 0;
        while (i7 < length) {
            char cCharAt = charSequence.charAt(i7);
            if (cCharAt < 2048) {
                i8 += (127 - cCharAt) >>> 31;
            } else {
                i8 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i7) < 65536) {
                        throw new d(i7, length);
                    }
                    i7++;
                }
            }
            i7++;
        }
        return i8;
    }

    public static int l(ByteBuffer byteBuffer, int i7, int i8) {
        int i9 = i8 - 7;
        int i10 = i7;
        while (i10 < i9 && (byteBuffer.getLong(i10) & (-9187201950435737472L)) == 0) {
            i10 += 8;
        }
        return i10 - i7;
    }

    public static int m(int i7) {
        if (i7 > -12) {
            return -1;
        }
        return i7;
    }

    public static int n(int i7, int i8) {
        if (i7 > -12 || i8 > -65) {
            return -1;
        }
        return i7 ^ (i8 << 8);
    }

    public static int o(int i7, int i8, int i9) {
        if (i7 > -12 || i8 > -65 || i9 > -65) {
            return -1;
        }
        return (i7 ^ (i8 << 8)) ^ (i9 << 16);
    }

    public static int p(ByteBuffer byteBuffer, int i7, int i8, int i9) {
        if (i9 == 0) {
            return m(i7);
        }
        if (i9 == 1) {
            return n(i7, byteBuffer.get(i8));
        }
        if (i9 == 2) {
            return o(i7, byteBuffer.get(i8), byteBuffer.get(i8 + 1));
        }
        throw new AssertionError();
    }

    public static int q(byte[] bArr, int i7, int i8) {
        byte b7 = bArr[i7 - 1];
        int i9 = i8 - i7;
        if (i9 == 0) {
            return m(b7);
        }
        if (i9 == 1) {
            return n(b7, bArr[i7]);
        }
        if (i9 == 2) {
            return o(b7, bArr[i7], bArr[i7 + 1]);
        }
        throw new AssertionError();
    }

    public static boolean r(ByteBuffer byteBuffer) {
        return f12505a.f(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public static boolean s(byte[] bArr) {
        return f12505a.g(bArr, 0, bArr.length);
    }

    public static boolean t(byte[] bArr, int i7, int i8) {
        return f12505a.g(bArr, i7, i8);
    }

    public static int u(int i7, ByteBuffer byteBuffer, int i8, int i9) {
        return f12505a.h(i7, byteBuffer, i8, i9);
    }

    public static int v(int i7, byte[] bArr, int i8, int i9) {
        return f12505a.i(i7, bArr, i8, i9);
    }
}
