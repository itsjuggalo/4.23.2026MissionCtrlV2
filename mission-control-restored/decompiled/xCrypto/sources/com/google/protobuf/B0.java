package com.google.protobuf;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class B0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10880a;

    public static class a {
        public static void h(byte b4, byte b5, byte b6, byte b7, char[] cArr, int i4) throws D {
            if (m(b5) || (((b4 << 28) + (b5 + 112)) >> 30) != 0 || m(b6) || m(b7)) {
                throw D.d();
            }
            int iR = ((b4 & 7) << 18) | (r(b5) << 12) | (r(b6) << 6) | r(b7);
            cArr[i4] = l(iR);
            cArr[i4 + 1] = q(iR);
        }

        public static void i(byte b4, char[] cArr, int i4) {
            cArr[i4] = (char) b4;
        }

        public static void j(byte b4, byte b5, byte b6, char[] cArr, int i4) throws D {
            if (m(b5) || ((b4 == -32 && b5 < -96) || ((b4 == -19 && b5 >= -96) || m(b6)))) {
                throw D.d();
            }
            cArr[i4] = (char) (((b4 & 15) << 12) | (r(b5) << 6) | r(b6));
        }

        public static void k(byte b4, byte b5, char[] cArr, int i4) throws D {
            if (b4 < -62 || m(b5)) {
                throw D.d();
            }
            cArr[i4] = (char) (((b4 & 31) << 6) | r(b5));
        }

        public static char l(int i4) {
            return (char) ((i4 >>> 10) + 55232);
        }

        public static boolean m(byte b4) {
            return b4 > -65;
        }

        public static boolean n(byte b4) {
            return b4 >= 0;
        }

        public static boolean o(byte b4) {
            return b4 < -16;
        }

        public static boolean p(byte b4) {
            return b4 < -32;
        }

        public static char q(int i4) {
            return (char) ((i4 & 1023) + 56320);
        }

        public static int r(byte b4) {
            return b4 & 63;
        }
    }

    public static abstract class b {
        public static int j(ByteBuffer byteBuffer, int i4, int i5) {
            int iL = i4 + B0.l(byteBuffer, i4, i5);
            while (iL < i5) {
                int i6 = iL + 1;
                byte b4 = byteBuffer.get(iL);
                if (b4 >= 0) {
                    iL = i6;
                } else if (b4 < -32) {
                    if (i6 >= i5) {
                        return b4;
                    }
                    if (b4 < -62 || byteBuffer.get(i6) > -65) {
                        return -1;
                    }
                    iL += 2;
                } else {
                    if (b4 >= -16) {
                        if (i6 >= i5 - 2) {
                            return B0.p(byteBuffer, b4, i6, i5 - i6);
                        }
                        int i7 = iL + 2;
                        byte b5 = byteBuffer.get(i6);
                        if (b5 <= -65 && (((b4 << 28) + (b5 + 112)) >> 30) == 0) {
                            int i8 = iL + 3;
                            if (byteBuffer.get(i7) <= -65) {
                                iL += 4;
                                if (byteBuffer.get(i8) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i6 >= i5 - 1) {
                        return B0.p(byteBuffer, b4, i6, i5 - i6);
                    }
                    int i9 = iL + 2;
                    byte b6 = byteBuffer.get(i6);
                    if (b6 > -65 || ((b4 == -32 && b6 < -96) || ((b4 == -19 && b6 >= -96) || byteBuffer.get(i9) > -65))) {
                        return -1;
                    }
                    iL += 3;
                }
            }
            return 0;
        }

        public final String a(ByteBuffer byteBuffer, int i4, int i5) {
            if (byteBuffer.hasArray()) {
                return b(byteBuffer.array(), byteBuffer.arrayOffset() + i4, i5);
            }
            return byteBuffer.isDirect() ? d(byteBuffer, i4, i5) : c(byteBuffer, i4, i5);
        }

        public abstract String b(byte[] bArr, int i4, int i5);

        public final String c(ByteBuffer byteBuffer, int i4, int i5) throws D {
            if ((i4 | i5 | ((byteBuffer.limit() - i4) - i5)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i4), Integer.valueOf(i5)));
            }
            int i6 = i4 + i5;
            char[] cArr = new char[i5];
            int i7 = 0;
            while (i4 < i6) {
                byte b4 = byteBuffer.get(i4);
                if (!a.n(b4)) {
                    break;
                }
                i4++;
                a.i(b4, cArr, i7);
                i7++;
            }
            int i8 = i7;
            while (i4 < i6) {
                int i9 = i4 + 1;
                byte b5 = byteBuffer.get(i4);
                if (a.n(b5)) {
                    int i10 = i8 + 1;
                    a.i(b5, cArr, i8);
                    int i11 = i9;
                    while (i11 < i6) {
                        byte b6 = byteBuffer.get(i11);
                        if (!a.n(b6)) {
                            break;
                        }
                        i11++;
                        a.i(b6, cArr, i10);
                        i10++;
                    }
                    i8 = i10;
                    i4 = i11;
                } else if (a.p(b5)) {
                    if (i9 >= i6) {
                        throw D.d();
                    }
                    i4 += 2;
                    a.k(b5, byteBuffer.get(i9), cArr, i8);
                    i8++;
                } else if (a.o(b5)) {
                    if (i9 >= i6 - 1) {
                        throw D.d();
                    }
                    int i12 = i4 + 2;
                    i4 += 3;
                    a.j(b5, byteBuffer.get(i9), byteBuffer.get(i12), cArr, i8);
                    i8++;
                } else {
                    if (i9 >= i6 - 2) {
                        throw D.d();
                    }
                    byte b7 = byteBuffer.get(i9);
                    int i13 = i4 + 3;
                    byte b8 = byteBuffer.get(i4 + 2);
                    i4 += 4;
                    a.h(b5, b7, b8, byteBuffer.get(i13), cArr, i8);
                    i8 += 2;
                }
            }
            return new String(cArr, 0, i8);
        }

        public abstract String d(ByteBuffer byteBuffer, int i4, int i5);

        public abstract int e(CharSequence charSequence, byte[] bArr, int i4, int i5);

        public final boolean f(ByteBuffer byteBuffer, int i4, int i5) {
            return h(0, byteBuffer, i4, i5) == 0;
        }

        public final boolean g(byte[] bArr, int i4, int i5) {
            return i(0, bArr, i4, i5) == 0;
        }

        public final int h(int i4, ByteBuffer byteBuffer, int i5, int i6) {
            if (!byteBuffer.hasArray()) {
                return byteBuffer.isDirect() ? l(i4, byteBuffer, i5, i6) : k(i4, byteBuffer, i5, i6);
            }
            int iArrayOffset = byteBuffer.arrayOffset();
            return i(i4, byteBuffer.array(), i5 + iArrayOffset, iArrayOffset + i6);
        }

        public abstract int i(int i4, byte[] bArr, int i5, int i6);

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
                int r7 = com.google.protobuf.B0.a(r0, r9)
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
                int r7 = com.google.protobuf.B0.a(r0, r1)
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
                int r7 = com.google.protobuf.B0.b(r0, r1, r7)
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.B0.b.k(int, java.nio.ByteBuffer, int, int):int");
        }

        public abstract int l(int i4, ByteBuffer byteBuffer, int i5, int i6);
    }

    public static final class c extends b {
        public static int m(byte[] bArr, int i4, int i5) {
            while (i4 < i5 && bArr[i4] >= 0) {
                i4++;
            }
            if (i4 >= i5) {
                return 0;
            }
            return n(bArr, i4, i5);
        }

        public static int n(byte[] bArr, int i4, int i5) {
            while (i4 < i5) {
                int i6 = i4 + 1;
                byte b4 = bArr[i4];
                if (b4 < 0) {
                    if (b4 < -32) {
                        if (i6 >= i5) {
                            return b4;
                        }
                        if (b4 >= -62) {
                            i4 += 2;
                            if (bArr[i6] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b4 >= -16) {
                        if (i6 >= i5 - 2) {
                            return B0.q(bArr, i6, i5);
                        }
                        int i7 = i4 + 2;
                        byte b5 = bArr[i6];
                        if (b5 <= -65 && (((b4 << 28) + (b5 + 112)) >> 30) == 0) {
                            int i8 = i4 + 3;
                            if (bArr[i7] <= -65) {
                                i4 += 4;
                                if (bArr[i8] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i6 >= i5 - 1) {
                        return B0.q(bArr, i6, i5);
                    }
                    int i9 = i4 + 2;
                    byte b6 = bArr[i6];
                    if (b6 <= -65 && ((b4 != -32 || b6 >= -96) && (b4 != -19 || b6 < -96))) {
                        i4 += 3;
                        if (bArr[i9] > -65) {
                        }
                    }
                    return -1;
                }
                i4 = i6;
            }
            return 0;
        }

        @Override // com.google.protobuf.B0.b
        public String b(byte[] bArr, int i4, int i5) throws D {
            if ((i4 | i5 | ((bArr.length - i4) - i5)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i4), Integer.valueOf(i5)));
            }
            int i6 = i4 + i5;
            char[] cArr = new char[i5];
            int i7 = 0;
            while (i4 < i6) {
                byte b4 = bArr[i4];
                if (!a.n(b4)) {
                    break;
                }
                i4++;
                a.i(b4, cArr, i7);
                i7++;
            }
            int i8 = i7;
            while (i4 < i6) {
                int i9 = i4 + 1;
                byte b5 = bArr[i4];
                if (a.n(b5)) {
                    int i10 = i8 + 1;
                    a.i(b5, cArr, i8);
                    int i11 = i9;
                    while (i11 < i6) {
                        byte b6 = bArr[i11];
                        if (!a.n(b6)) {
                            break;
                        }
                        i11++;
                        a.i(b6, cArr, i10);
                        i10++;
                    }
                    i8 = i10;
                    i4 = i11;
                } else if (a.p(b5)) {
                    if (i9 >= i6) {
                        throw D.d();
                    }
                    i4 += 2;
                    a.k(b5, bArr[i9], cArr, i8);
                    i8++;
                } else if (a.o(b5)) {
                    if (i9 >= i6 - 1) {
                        throw D.d();
                    }
                    int i12 = i4 + 2;
                    i4 += 3;
                    a.j(b5, bArr[i9], bArr[i12], cArr, i8);
                    i8++;
                } else {
                    if (i9 >= i6 - 2) {
                        throw D.d();
                    }
                    byte b7 = bArr[i9];
                    int i13 = i4 + 3;
                    byte b8 = bArr[i4 + 2];
                    i4 += 4;
                    a.h(b5, b7, b8, bArr[i13], cArr, i8);
                    i8 += 2;
                }
            }
            return new String(cArr, 0, i8);
        }

        @Override // com.google.protobuf.B0.b
        public String d(ByteBuffer byteBuffer, int i4, int i5) {
            return c(byteBuffer, i4, i5);
        }

        @Override // com.google.protobuf.B0.b
        public int e(CharSequence charSequence, byte[] bArr, int i4, int i5) {
            int i6;
            int i7;
            char cCharAt;
            int length = charSequence.length();
            int i8 = i5 + i4;
            int i9 = 0;
            while (i9 < length && (i7 = i9 + i4) < i8 && (cCharAt = charSequence.charAt(i9)) < 128) {
                bArr[i7] = (byte) cCharAt;
                i9++;
            }
            if (i9 == length) {
                return i4 + length;
            }
            int i10 = i4 + i9;
            while (i9 < length) {
                char cCharAt2 = charSequence.charAt(i9);
                if (cCharAt2 < 128 && i10 < i8) {
                    bArr[i10] = (byte) cCharAt2;
                    i10++;
                } else if (cCharAt2 < 2048 && i10 <= i8 - 2) {
                    int i11 = i10 + 1;
                    bArr[i10] = (byte) ((cCharAt2 >>> 6) | 960);
                    i10 += 2;
                    bArr[i11] = (byte) ((cCharAt2 & '?') | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i10 > i8 - 3) {
                        if (i10 > i8 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i6 = i9 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i6)))) {
                                throw new d(i9, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i10);
                        }
                        int i12 = i9 + 1;
                        if (i12 != charSequence.length()) {
                            char cCharAt3 = charSequence.charAt(i12);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i10] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i10 + 1] = (byte) (((codePoint >>> 12) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                                int i13 = i10 + 3;
                                bArr[i10 + 2] = (byte) (((codePoint >>> 6) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                                i10 += 4;
                                bArr[i13] = (byte) ((codePoint & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                                i9 = i12;
                            } else {
                                i9 = i12;
                            }
                        }
                        throw new d(i9 - 1, length);
                    }
                    bArr[i10] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i14 = i10 + 2;
                    bArr[i10 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                    i10 += 3;
                    bArr[i14] = (byte) ((cCharAt2 & '?') | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                }
                i9++;
            }
            return i10;
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
        @Override // com.google.protobuf.B0.b
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
                int r7 = com.google.protobuf.B0.a(r0, r9)
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
                int r7 = com.google.protobuf.B0.a(r0, r1)
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
                int r7 = com.google.protobuf.B0.b(r0, r1, r7)
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.B0.c.i(int, byte[], int, int):int");
        }

        @Override // com.google.protobuf.B0.b
        public int l(int i4, ByteBuffer byteBuffer, int i5, int i6) {
            return k(i4, byteBuffer, i5, i6);
        }
    }

    public static class d extends IllegalArgumentException {
        public d(int i4, int i5) {
            super("Unpaired surrogate at index " + i4 + " of " + i5);
        }
    }

    public static final class e extends b {
        public static boolean m() {
            return A0.I() && A0.J();
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
                byte r1 = com.google.protobuf.A0.w(r10)
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
                byte r10 = com.google.protobuf.A0.w(r10)
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
                byte r0 = com.google.protobuf.A0.w(r10)
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
                byte r0 = com.google.protobuf.A0.w(r2)
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
                byte r0 = com.google.protobuf.A0.w(r10)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r10
                byte r0 = com.google.protobuf.A0.w(r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r10 = r10 + r0
                byte r0 = com.google.protobuf.A0.w(r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.B0.e.n(long, int):int");
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
                byte r1 = com.google.protobuf.A0.x(r10, r11)
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
                byte r11 = com.google.protobuf.A0.x(r10, r11)
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
                byte r0 = com.google.protobuf.A0.x(r10, r11)
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
                byte r0 = com.google.protobuf.A0.x(r10, r2)
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
                byte r0 = com.google.protobuf.A0.x(r10, r11)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r11
                byte r0 = com.google.protobuf.A0.x(r10, r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r11 = r11 + r0
                byte r0 = com.google.protobuf.A0.x(r10, r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.B0.e.o(byte[], long, int):int");
        }

        public static int p(long j4, int i4) {
            if (i4 < 16) {
                return 0;
            }
            int i5 = (int) ((-j4) & 7);
            int i6 = i5;
            while (i6 > 0) {
                long j5 = 1 + j4;
                if (A0.w(j4) < 0) {
                    return i5 - i6;
                }
                i6--;
                j4 = j5;
            }
            int i7 = i4 - i5;
            while (i7 >= 8 && (A0.D(j4) & (-9187201950435737472L)) == 0) {
                j4 += 8;
                i7 -= 8;
            }
            return i4 - i7;
        }

        public static int q(byte[] bArr, long j4, int i4) {
            int i5 = 0;
            if (i4 < 16) {
                return 0;
            }
            int i6 = 8 - (((int) j4) & 7);
            while (i5 < i6) {
                long j5 = 1 + j4;
                if (A0.x(bArr, j4) < 0) {
                    return i5;
                }
                i5++;
                j4 = j5;
            }
            while (true) {
                int i7 = i5 + 8;
                if (i7 > i4 || (A0.E(bArr, A0.f10860h + j4) & (-9187201950435737472L)) != 0) {
                    break;
                }
                j4 += 8;
                i5 = i7;
            }
            while (i5 < i4) {
                long j6 = j4 + 1;
                if (A0.x(bArr, j4) < 0) {
                    return i5;
                }
                i5++;
                j4 = j6;
            }
            return i4;
        }

        public static int r(long j4, int i4, int i5) {
            if (i5 == 0) {
                return B0.m(i4);
            }
            if (i5 == 1) {
                return B0.n(i4, A0.w(j4));
            }
            if (i5 == 2) {
                return B0.o(i4, A0.w(j4), A0.w(j4 + 1));
            }
            throw new AssertionError();
        }

        public static int s(byte[] bArr, int i4, long j4, int i5) {
            if (i5 == 0) {
                return B0.m(i4);
            }
            if (i5 == 1) {
                return B0.n(i4, A0.x(bArr, j4));
            }
            if (i5 == 2) {
                return B0.o(i4, A0.x(bArr, j4), A0.x(bArr, j4 + 1));
            }
            throw new AssertionError();
        }

        @Override // com.google.protobuf.B0.b
        public String b(byte[] bArr, int i4, int i5) throws D {
            Charset charset = C.f10882b;
            String str = new String(bArr, i4, i5, charset);
            if (str.contains("�") && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i4, i5 + i4))) {
                throw D.d();
            }
            return str;
        }

        @Override // com.google.protobuf.B0.b
        public String d(ByteBuffer byteBuffer, int i4, int i5) throws D {
            if ((i4 | i5 | ((byteBuffer.limit() - i4) - i5)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i4), Integer.valueOf(i5)));
            }
            long jK = A0.k(byteBuffer) + ((long) i4);
            long j4 = ((long) i5) + jK;
            char[] cArr = new char[i5];
            int i6 = 0;
            while (jK < j4) {
                byte bW = A0.w(jK);
                if (!a.n(bW)) {
                    break;
                }
                jK++;
                a.i(bW, cArr, i6);
                i6++;
            }
            int i7 = i6;
            while (jK < j4) {
                long j5 = jK + 1;
                byte bW2 = A0.w(jK);
                if (a.n(bW2)) {
                    int i8 = i7 + 1;
                    a.i(bW2, cArr, i7);
                    long j6 = j5;
                    while (j6 < j4) {
                        byte bW3 = A0.w(j6);
                        if (!a.n(bW3)) {
                            break;
                        }
                        j6++;
                        a.i(bW3, cArr, i8);
                        i8++;
                    }
                    i7 = i8;
                    jK = j6;
                } else if (a.p(bW2)) {
                    if (j5 >= j4) {
                        throw D.d();
                    }
                    jK += 2;
                    a.k(bW2, A0.w(j5), cArr, i7);
                    i7++;
                } else if (a.o(bW2)) {
                    if (j5 >= j4 - 1) {
                        throw D.d();
                    }
                    long j7 = 2 + jK;
                    jK += 3;
                    a.j(bW2, A0.w(j5), A0.w(j7), cArr, i7);
                    i7++;
                } else {
                    if (j5 >= j4 - 2) {
                        throw D.d();
                    }
                    byte bW4 = A0.w(j5);
                    long j8 = jK + 3;
                    byte bW5 = A0.w(2 + jK);
                    jK += 4;
                    a.h(bW2, bW4, bW5, A0.w(j8), cArr, i7);
                    i7 += 2;
                }
            }
            return new String(cArr, 0, i7);
        }

        @Override // com.google.protobuf.B0.b
        public int e(CharSequence charSequence, byte[] bArr, int i4, int i5) {
            long j4;
            long j5;
            long j6;
            int i6;
            char cCharAt;
            long j7 = i4;
            long j8 = ((long) i5) + j7;
            int length = charSequence.length();
            if (length > i5 || bArr.length - i5 < i4) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i4 + i5));
            }
            int i7 = 0;
            while (true) {
                j4 = 1;
                if (i7 >= length || (cCharAt = charSequence.charAt(i7)) >= 128) {
                    break;
                }
                A0.O(bArr, j7, (byte) cCharAt);
                i7++;
                j7 = 1 + j7;
            }
            if (i7 == length) {
                return (int) j7;
            }
            while (i7 < length) {
                char cCharAt2 = charSequence.charAt(i7);
                if (cCharAt2 < 128 && j7 < j8) {
                    A0.O(bArr, j7, (byte) cCharAt2);
                    j6 = j8;
                    j5 = j4;
                    j7 += j4;
                } else if (cCharAt2 >= 2048 || j7 > j8 - 2) {
                    j5 = j4;
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j7 > j8 - 3) {
                        j6 = j8;
                        if (j7 > j6 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i6 = i7 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i6)))) {
                                throw new d(i7, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + j7);
                        }
                        int i8 = i7 + 1;
                        if (i8 != length) {
                            char cCharAt3 = charSequence.charAt(i8);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                A0.O(bArr, j7, (byte) ((codePoint >>> 18) | 240));
                                A0.O(bArr, j7 + j5, (byte) (((codePoint >>> 12) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                                long j9 = j7 + 3;
                                A0.O(bArr, j7 + 2, (byte) (((codePoint >>> 6) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                                j7 += 4;
                                A0.O(bArr, j9, (byte) ((codePoint & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                                i7 = i8;
                            } else {
                                i7 = i8;
                            }
                        }
                        throw new d(i7 - 1, length);
                    }
                    A0.O(bArr, j7, (byte) ((cCharAt2 >>> '\f') | 480));
                    long j10 = j7 + 2;
                    j6 = j8;
                    A0.O(bArr, j7 + j5, (byte) (((cCharAt2 >>> 6) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                    j7 += 3;
                    A0.O(bArr, j10, (byte) ((cCharAt2 & '?') | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                } else {
                    j5 = j4;
                    long j11 = j7 + j5;
                    A0.O(bArr, j7, (byte) ((cCharAt2 >>> 6) | 960));
                    j7 += 2;
                    A0.O(bArr, j11, (byte) ((cCharAt2 & '?') | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                    j6 = j8;
                }
                i7++;
                j4 = j5;
                j8 = j6;
            }
            return (int) j7;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0058, code lost:
        
            if (com.google.protobuf.A0.x(r12, r0) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
        
            if (com.google.protobuf.A0.x(r12, r0) > (-65)) goto L59;
         */
        @Override // com.google.protobuf.B0.b
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
                byte r11 = com.google.protobuf.A0.x(r12, r0)
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
                byte r11 = com.google.protobuf.A0.x(r12, r0)
                int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r0 < 0) goto L43
                int r11 = com.google.protobuf.B0.a(r2, r11)
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
                byte r11 = com.google.protobuf.A0.x(r12, r0)
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
                byte r3 = com.google.protobuf.A0.x(r12, r0)
                int r11 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r11 < 0) goto L73
                int r11 = com.google.protobuf.B0.a(r2, r3)
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
                byte r11 = com.google.protobuf.A0.x(r12, r0)
                int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r0 < 0) goto L8a
                int r11 = com.google.protobuf.B0.b(r2, r3, r11)
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
                byte r11 = com.google.protobuf.A0.x(r12, r0)
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.B0.e.i(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        
            if (com.google.protobuf.A0.w(r0) > (-65)) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0061, code lost:
        
            if (com.google.protobuf.A0.w(r0) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:
        
            if (com.google.protobuf.A0.w(r0) > (-65)) goto L57;
         */
        @Override // com.google.protobuf.B0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int l(int r10, java.nio.ByteBuffer r11, int r12, int r13) {
            /*
                Method dump skipped, instruction units count: 205
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.B0.e.l(int, java.nio.ByteBuffer, int, int):int");
        }
    }

    static {
        f10880a = (!e.m() || AbstractC1056d.c()) ? new c() : new e();
    }

    public static String g(ByteBuffer byteBuffer, int i4, int i5) {
        return f10880a.a(byteBuffer, i4, i5);
    }

    public static String h(byte[] bArr, int i4, int i5) {
        return f10880a.b(bArr, i4, i5);
    }

    public static int i(CharSequence charSequence, byte[] bArr, int i4, int i5) {
        return f10880a.e(charSequence, bArr, i4, i5);
    }

    public static int j(CharSequence charSequence) {
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length && charSequence.charAt(i4) < 128) {
            i4++;
        }
        int iK = length;
        while (true) {
            if (i4 < length) {
                char cCharAt = charSequence.charAt(i4);
                if (cCharAt >= 2048) {
                    iK += k(charSequence, i4);
                    break;
                }
                iK += (127 - cCharAt) >>> 31;
                i4++;
            } else {
                break;
            }
        }
        if (iK >= length) {
            return iK;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iK) + 4294967296L));
    }

    public static int k(CharSequence charSequence, int i4) {
        int length = charSequence.length();
        int i5 = 0;
        while (i4 < length) {
            char cCharAt = charSequence.charAt(i4);
            if (cCharAt < 2048) {
                i5 += (127 - cCharAt) >>> 31;
            } else {
                i5 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i4) < 65536) {
                        throw new d(i4, length);
                    }
                    i4++;
                }
            }
            i4++;
        }
        return i5;
    }

    public static int l(ByteBuffer byteBuffer, int i4, int i5) {
        int i6 = i5 - 7;
        int i7 = i4;
        while (i7 < i6 && (byteBuffer.getLong(i7) & (-9187201950435737472L)) == 0) {
            i7 += 8;
        }
        return i7 - i4;
    }

    public static int m(int i4) {
        if (i4 > -12) {
            return -1;
        }
        return i4;
    }

    public static int n(int i4, int i5) {
        if (i4 > -12 || i5 > -65) {
            return -1;
        }
        return i4 ^ (i5 << 8);
    }

    public static int o(int i4, int i5, int i6) {
        if (i4 > -12 || i5 > -65 || i6 > -65) {
            return -1;
        }
        return (i4 ^ (i5 << 8)) ^ (i6 << 16);
    }

    public static int p(ByteBuffer byteBuffer, int i4, int i5, int i6) {
        if (i6 == 0) {
            return m(i4);
        }
        if (i6 == 1) {
            return n(i4, byteBuffer.get(i5));
        }
        if (i6 == 2) {
            return o(i4, byteBuffer.get(i5), byteBuffer.get(i5 + 1));
        }
        throw new AssertionError();
    }

    public static int q(byte[] bArr, int i4, int i5) {
        byte b4 = bArr[i4 - 1];
        int i6 = i5 - i4;
        if (i6 == 0) {
            return m(b4);
        }
        if (i6 == 1) {
            return n(b4, bArr[i4]);
        }
        if (i6 == 2) {
            return o(b4, bArr[i4], bArr[i4 + 1]);
        }
        throw new AssertionError();
    }

    public static boolean r(ByteBuffer byteBuffer) {
        return f10880a.f(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public static boolean s(byte[] bArr) {
        return f10880a.g(bArr, 0, bArr.length);
    }

    public static boolean t(byte[] bArr, int i4, int i5) {
        return f10880a.g(bArr, i4, i5);
    }

    public static int u(int i4, ByteBuffer byteBuffer, int i5, int i6) {
        return f10880a.h(i4, byteBuffer, i5, i6);
    }

    public static int v(int i4, byte[] bArr, int i5, int i6) {
        return f10880a.i(i4, bArr, i5, i6);
    }
}
