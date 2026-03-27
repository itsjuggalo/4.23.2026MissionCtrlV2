package u7;

import V6.C0977c;
import io.flutter.embedding.android.KeyboardMap;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2590l;

/* JADX INFO: renamed from: u7.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2811d implements InterfaceC2813f, InterfaceC2812e, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public P f23638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f23639b;

    /* JADX INFO: renamed from: u7.d$a */
    public static final class a implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C2811d f23640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public P f23641b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f23643d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f23642c = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f23644e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f23645f = -1;

        public final void a(P p8) {
            this.f23641b = p8;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f23640a == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.f23640a = null;
            a(null);
            this.f23642c = -1L;
            this.f23643d = null;
            this.f23644e = -1;
            this.f23645f = -1;
        }
    }

    /* JADX INFO: renamed from: u7.d$b */
    public static final class b extends InputStream {
        public b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(C2811d.this.s0(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream
        public int read() {
            if (C2811d.this.s0() > 0) {
                return C2811d.this.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return C2811d.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] sink, int i8, int i9) {
            AbstractC2304t.f(sink, "sink");
            return C2811d.this.read(sink, i8, i9);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    /* JADX INFO: renamed from: u7.d$c */
    public static final class c extends OutputStream {
        public c() {
        }

        public String toString() {
            return C2811d.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i8) {
            C2811d.this.x(i8);
        }

        @Override // java.io.OutputStream
        public void write(byte[] data, int i8, int i9) {
            AbstractC2304t.f(data, "data");
            C2811d.this.A0(data, i8, i9);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }
    }

    public C2811d A0(byte[] source, int i8, int i9) {
        AbstractC2304t.f(source, "source");
        long j8 = i9;
        AbstractC2809b.b(source.length, i8, j8);
        int i10 = i9 + i8;
        while (i8 < i10) {
            P pX0 = x0(1);
            int iMin = Math.min(i10 - i8, 8192 - pX0.f23597c);
            int i11 = i8 + iMin;
            AbstractC2590l.e(source, pX0.f23595a, pX0.f23597c, i8, i11);
            pX0.f23597c += iMin;
            i8 = i11;
        }
        r0(s0() + j8);
        return this;
    }

    public final long B() {
        long jS0 = s0();
        if (jS0 == 0) {
            return 0L;
        }
        P p8 = this.f23638a;
        AbstractC2304t.c(p8);
        P p9 = p8.f23601g;
        AbstractC2304t.c(p9);
        int i8 = p9.f23597c;
        if (i8 < 8192 && p9.f23599e) {
            jS0 -= (long) (i8 - p9.f23596b);
        }
        return jS0;
    }

    public long B0(V source) {
        AbstractC2304t.f(source, "source");
        long j8 = 0;
        while (true) {
            long jO0 = source.o0(this, 8192L);
            if (jO0 == -1) {
                return j8;
            }
            j8 += jO0;
        }
    }

    @Override // u7.InterfaceC2812e
    /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] */
    public C2811d x(int i8) {
        P pX0 = x0(1);
        byte[] bArr = pX0.f23595a;
        int i9 = pX0.f23597c;
        pX0.f23597c = i9 + 1;
        bArr[i9] = (byte) i8;
        r0(s0() + 1);
        return this;
    }

    public final C2811d D() {
        C2811d c2811d = new C2811d();
        if (s0() != 0) {
            P p8 = this.f23638a;
            AbstractC2304t.c(p8);
            P pD = p8.d();
            c2811d.f23638a = pD;
            pD.f23601g = pD;
            pD.f23600f = pD;
            for (P p9 = p8.f23600f; p9 != p8; p9 = p9.f23600f) {
                P p10 = pD.f23601g;
                AbstractC2304t.c(p10);
                AbstractC2304t.c(p9);
                p10.c(p9.d());
            }
            c2811d.r0(s0());
        }
        return c2811d;
    }

    public C2811d D0(long j8) {
        if (j8 == 0) {
            return x(48);
        }
        long j9 = (j8 >>> 1) | j8;
        long j10 = j9 | (j9 >>> 2);
        long j11 = j10 | (j10 >>> 4);
        long j12 = j11 | (j11 >>> 8);
        long j13 = j12 | (j12 >>> 16);
        long j14 = j13 | (j13 >>> 32);
        long j15 = j14 - ((j14 >>> 1) & 6148914691236517205L);
        long j16 = ((j15 >>> 2) & 3689348814741910323L) + (j15 & 3689348814741910323L);
        long j17 = ((j16 >>> 4) + j16) & 1085102592571150095L;
        long j18 = j17 + (j17 >>> 8);
        long j19 = j18 + (j18 >>> 16);
        int i8 = (int) ((((j19 & 63) + ((j19 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        P pX0 = x0(i8);
        byte[] bArr = pX0.f23595a;
        int i9 = pX0.f23597c;
        for (int i10 = (i9 + i8) - 1; i10 >= i9; i10--) {
            bArr[i10] = v7.a.a()[(int) (15 & j8)];
            j8 >>>= 4;
        }
        pX0.f23597c += i8;
        r0(s0() + ((long) i8));
        return this;
    }

    public final C2811d E(C2811d out, long j8, long j9) {
        AbstractC2304t.f(out, "out");
        AbstractC2809b.b(s0(), j8, j9);
        if (j9 != 0) {
            out.r0(out.s0() + j9);
            P p8 = this.f23638a;
            while (true) {
                AbstractC2304t.c(p8);
                int i8 = p8.f23597c;
                int i9 = p8.f23596b;
                if (j8 < i8 - i9) {
                    break;
                }
                j8 -= (long) (i8 - i9);
                p8 = p8.f23600f;
            }
            while (j9 > 0) {
                AbstractC2304t.c(p8);
                P pD = p8.d();
                int i10 = pD.f23596b + ((int) j8);
                pD.f23596b = i10;
                pD.f23597c = Math.min(i10 + ((int) j9), pD.f23597c);
                P p9 = out.f23638a;
                if (p9 == null) {
                    pD.f23601g = pD;
                    pD.f23600f = pD;
                    out.f23638a = pD;
                } else {
                    AbstractC2304t.c(p9);
                    P p10 = p9.f23601g;
                    AbstractC2304t.c(p10);
                    p10.c(pD);
                }
                j9 -= (long) (pD.f23597c - pD.f23596b);
                p8 = p8.f23600f;
                j8 = 0;
            }
        }
        return this;
    }

    @Override // u7.InterfaceC2812e
    /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
    public C2811d s(int i8) {
        P pX0 = x0(4);
        byte[] bArr = pX0.f23595a;
        int i9 = pX0.f23597c;
        bArr[i9] = (byte) ((i8 >>> 24) & 255);
        bArr[i9 + 1] = (byte) ((i8 >>> 16) & 255);
        bArr[i9 + 2] = (byte) ((i8 >>> 8) & 255);
        bArr[i9 + 3] = (byte) (i8 & 255);
        pX0.f23597c = i9 + 4;
        r0(s0() + 4);
        return this;
    }

    @Override // u7.InterfaceC2812e
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public C2811d q(int i8) {
        P pX0 = x0(2);
        byte[] bArr = pX0.f23595a;
        int i9 = pX0.f23597c;
        bArr[i9] = (byte) ((i8 >>> 8) & 255);
        bArr[i9 + 1] = (byte) (i8 & 255);
        pX0.f23597c = i9 + 2;
        r0(s0() + 2);
        return this;
    }

    public final C2811d G0(OutputStream out, long j8) throws IOException {
        AbstractC2304t.f(out, "out");
        AbstractC2809b.b(this.f23639b, 0L, j8);
        P p8 = this.f23638a;
        while (j8 > 0) {
            AbstractC2304t.c(p8);
            int iMin = (int) Math.min(j8, p8.f23597c - p8.f23596b);
            out.write(p8.f23595a, p8.f23596b, iMin);
            int i8 = p8.f23596b + iMin;
            p8.f23596b = i8;
            long j9 = iMin;
            this.f23639b -= j9;
            j8 -= j9;
            if (i8 == p8.f23597c) {
                P pB = p8.b();
                this.f23638a = pB;
                Q.b(p8);
                p8 = pB;
            }
        }
        return this;
    }

    @Override // u7.T
    public void H(C2811d source, long j8) {
        P p8;
        AbstractC2304t.f(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this".toString());
        }
        AbstractC2809b.b(source.s0(), 0L, j8);
        while (j8 > 0) {
            P p9 = source.f23638a;
            AbstractC2304t.c(p9);
            int i8 = p9.f23597c;
            AbstractC2304t.c(source.f23638a);
            if (j8 < i8 - r1.f23596b) {
                P p10 = this.f23638a;
                if (p10 != null) {
                    AbstractC2304t.c(p10);
                    p8 = p10.f23601g;
                } else {
                    p8 = null;
                }
                if (p8 != null && p8.f23599e) {
                    if ((((long) p8.f23597c) + j8) - ((long) (p8.f23598d ? 0 : p8.f23596b)) <= 8192) {
                        P p11 = source.f23638a;
                        AbstractC2304t.c(p11);
                        p11.f(p8, (int) j8);
                        source.r0(source.s0() - j8);
                        r0(s0() + j8);
                        return;
                    }
                }
                P p12 = source.f23638a;
                AbstractC2304t.c(p12);
                source.f23638a = p12.e((int) j8);
            }
            P p13 = source.f23638a;
            AbstractC2304t.c(p13);
            long j9 = p13.f23597c - p13.f23596b;
            source.f23638a = p13.b();
            P p14 = this.f23638a;
            if (p14 == null) {
                this.f23638a = p13;
                p13.f23601g = p13;
                p13.f23600f = p13;
            } else {
                AbstractC2304t.c(p14);
                P p15 = p14.f23601g;
                AbstractC2304t.c(p15);
                p15.c(p13).a();
            }
            source.r0(source.s0() - j9);
            r0(s0() + j9);
            j8 -= j9;
        }
    }

    @Override // u7.InterfaceC2812e
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public C2811d G(String string) {
        AbstractC2304t.f(string, "string");
        return I0(string, 0, string.length());
    }

    public C2811d I0(String string, int i8, int i9) {
        char cCharAt;
        long jS0;
        long j8;
        AbstractC2304t.f(string, "string");
        if (i8 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i8).toString());
        }
        if (i9 < i8) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i9 + " < " + i8).toString());
        }
        if (i9 > string.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i9 + " > " + string.length()).toString());
        }
        while (i8 < i9) {
            char cCharAt2 = string.charAt(i8);
            if (cCharAt2 < 128) {
                P pX0 = x0(1);
                byte[] bArr = pX0.f23595a;
                int i10 = pX0.f23597c - i8;
                int iMin = Math.min(i9, 8192 - i10);
                int i11 = i8 + 1;
                bArr[i8 + i10] = (byte) cCharAt2;
                while (true) {
                    i8 = i11;
                    if (i8 >= iMin || (cCharAt = string.charAt(i8)) >= 128) {
                        break;
                    }
                    i11 = i8 + 1;
                    bArr[i8 + i10] = (byte) cCharAt;
                }
                int i12 = pX0.f23597c;
                int i13 = (i10 + i8) - i12;
                pX0.f23597c = i12 + i13;
                r0(s0() + ((long) i13));
            } else {
                if (cCharAt2 < 2048) {
                    P pX02 = x0(2);
                    byte[] bArr2 = pX02.f23595a;
                    int i14 = pX02.f23597c;
                    bArr2[i14] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i14 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    pX02.f23597c = i14 + 2;
                    jS0 = s0();
                    j8 = 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    P pX03 = x0(3);
                    byte[] bArr3 = pX03.f23595a;
                    int i15 = pX03.f23597c;
                    bArr3[i15] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i15 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i15 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    pX03.f23597c = i15 + 3;
                    jS0 = s0();
                    j8 = 3;
                } else {
                    int i16 = i8 + 1;
                    char cCharAt3 = i16 < i9 ? string.charAt(i16) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        x(63);
                        i8 = i16;
                    } else {
                        int i17 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        P pX04 = x0(4);
                        byte[] bArr4 = pX04.f23595a;
                        int i18 = pX04.f23597c;
                        bArr4[i18] = (byte) ((i17 >> 18) | 240);
                        bArr4[i18 + 1] = (byte) (((i17 >> 12) & 63) | 128);
                        bArr4[i18 + 2] = (byte) (((i17 >> 6) & 63) | 128);
                        bArr4[i18 + 3] = (byte) ((i17 & 63) | 128);
                        pX04.f23597c = i18 + 4;
                        r0(s0() + 4);
                        i8 += 2;
                    }
                }
                r0(jS0 + j8);
                i8++;
            }
        }
        return this;
    }

    public C2811d J0(int i8) {
        long jS0;
        long j8;
        if (i8 < 128) {
            x(i8);
        } else {
            if (i8 < 2048) {
                P pX0 = x0(2);
                byte[] bArr = pX0.f23595a;
                int i9 = pX0.f23597c;
                bArr[i9] = (byte) ((i8 >> 6) | 192);
                bArr[i9 + 1] = (byte) ((i8 & 63) | 128);
                pX0.f23597c = i9 + 2;
                jS0 = s0();
                j8 = 2;
            } else if (55296 <= i8 && i8 < 57344) {
                x(63);
            } else if (i8 < 65536) {
                P pX02 = x0(3);
                byte[] bArr2 = pX02.f23595a;
                int i10 = pX02.f23597c;
                bArr2[i10] = (byte) ((i8 >> 12) | 224);
                bArr2[i10 + 1] = (byte) (((i8 >> 6) & 63) | 128);
                bArr2[i10 + 2] = (byte) ((i8 & 63) | 128);
                pX02.f23597c = i10 + 3;
                jS0 = s0();
                j8 = 3;
            } else {
                if (i8 > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: 0x" + AbstractC2809b.h(i8));
                }
                P pX03 = x0(4);
                byte[] bArr3 = pX03.f23595a;
                int i11 = pX03.f23597c;
                bArr3[i11] = (byte) ((i8 >> 18) | 240);
                bArr3[i11 + 1] = (byte) (((i8 >> 12) & 63) | 128);
                bArr3[i11 + 2] = (byte) (((i8 >> 6) & 63) | 128);
                bArr3[i11 + 3] = (byte) ((i8 & 63) | 128);
                pX03.f23597c = i11 + 4;
                jS0 = s0();
                j8 = 4;
            }
            r0(jS0 + j8);
        }
        return this;
    }

    public final byte K(long j8) {
        AbstractC2809b.b(s0(), j8, 1L);
        P p8 = this.f23638a;
        if (p8 == null) {
            AbstractC2304t.c(null);
            throw null;
        }
        if (s0() - j8 < j8) {
            long jS0 = s0();
            while (jS0 > j8) {
                p8 = p8.f23601g;
                AbstractC2304t.c(p8);
                jS0 -= (long) (p8.f23597c - p8.f23596b);
            }
            AbstractC2304t.c(p8);
            return p8.f23595a[(int) ((((long) p8.f23596b) + j8) - jS0)];
        }
        long j9 = 0;
        while (true) {
            long j10 = ((long) (p8.f23597c - p8.f23596b)) + j9;
            if (j10 > j8) {
                AbstractC2304t.c(p8);
                return p8.f23595a[(int) ((((long) p8.f23596b) + j8) - j9)];
            }
            p8 = p8.f23600f;
            AbstractC2304t.c(p8);
            j9 = j10;
        }
    }

    public long M(byte b8, long j8, long j9) {
        P p8;
        int i8;
        long jS0 = 0;
        if (0 > j8 || j8 > j9) {
            throw new IllegalArgumentException(("size=" + s0() + " fromIndex=" + j8 + " toIndex=" + j9).toString());
        }
        if (j9 > s0()) {
            j9 = s0();
        }
        if (j8 == j9 || (p8 = this.f23638a) == null) {
            return -1L;
        }
        if (s0() - j8 < j8) {
            jS0 = s0();
            while (jS0 > j8) {
                p8 = p8.f23601g;
                AbstractC2304t.c(p8);
                jS0 -= (long) (p8.f23597c - p8.f23596b);
            }
            while (jS0 < j9) {
                byte[] bArr = p8.f23595a;
                int iMin = (int) Math.min(p8.f23597c, (((long) p8.f23596b) + j9) - jS0);
                i8 = (int) ((((long) p8.f23596b) + j8) - jS0);
                while (i8 < iMin) {
                    if (bArr[i8] != b8) {
                        i8++;
                    }
                }
                jS0 += (long) (p8.f23597c - p8.f23596b);
                p8 = p8.f23600f;
                AbstractC2304t.c(p8);
                j8 = jS0;
            }
            return -1L;
        }
        while (true) {
            long j10 = ((long) (p8.f23597c - p8.f23596b)) + jS0;
            if (j10 > j8) {
                break;
            }
            p8 = p8.f23600f;
            AbstractC2304t.c(p8);
            jS0 = j10;
        }
        while (jS0 < j9) {
            byte[] bArr2 = p8.f23595a;
            int iMin2 = (int) Math.min(p8.f23597c, (((long) p8.f23596b) + j9) - jS0);
            i8 = (int) ((((long) p8.f23596b) + j8) - jS0);
            while (i8 < iMin2) {
                if (bArr2[i8] != b8) {
                    i8++;
                }
            }
            jS0 += (long) (p8.f23597c - p8.f23596b);
            p8 = p8.f23600f;
            AbstractC2304t.c(p8);
            j8 = jS0;
        }
        return -1L;
        return ((long) (i8 - p8.f23596b)) + jS0;
    }

    public long N(C2814g targetBytes) {
        AbstractC2304t.f(targetBytes, "targetBytes");
        return O(targetBytes, 0L);
    }

    public long O(C2814g targetBytes, long j8) {
        int i8;
        AbstractC2304t.f(targetBytes, "targetBytes");
        long jS0 = 0;
        if (j8 < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j8).toString());
        }
        P p8 = this.f23638a;
        if (p8 == null) {
            return -1L;
        }
        if (s0() - j8 < j8) {
            jS0 = s0();
            while (jS0 > j8) {
                p8 = p8.f23601g;
                AbstractC2304t.c(p8);
                jS0 -= (long) (p8.f23597c - p8.f23596b);
            }
            if (targetBytes.R() == 2) {
                byte bK = targetBytes.k(0);
                byte bK2 = targetBytes.k(1);
                while (jS0 < s0()) {
                    byte[] bArr = p8.f23595a;
                    i8 = (int) ((((long) p8.f23596b) + j8) - jS0);
                    int i9 = p8.f23597c;
                    while (i8 < i9) {
                        byte b8 = bArr[i8];
                        if (b8 != bK && b8 != bK2) {
                            i8++;
                        }
                    }
                    jS0 += (long) (p8.f23597c - p8.f23596b);
                    p8 = p8.f23600f;
                    AbstractC2304t.c(p8);
                    j8 = jS0;
                }
                return -1L;
            }
            byte[] bArrH = targetBytes.H();
            while (jS0 < s0()) {
                byte[] bArr2 = p8.f23595a;
                i8 = (int) ((((long) p8.f23596b) + j8) - jS0);
                int i10 = p8.f23597c;
                while (i8 < i10) {
                    byte b9 = bArr2[i8];
                    for (byte b10 : bArrH) {
                        if (b9 != b10) {
                        }
                    }
                    i8++;
                }
                jS0 += (long) (p8.f23597c - p8.f23596b);
                p8 = p8.f23600f;
                AbstractC2304t.c(p8);
                j8 = jS0;
            }
            return -1L;
        }
        while (true) {
            long j9 = ((long) (p8.f23597c - p8.f23596b)) + jS0;
            if (j9 > j8) {
                break;
            }
            p8 = p8.f23600f;
            AbstractC2304t.c(p8);
            jS0 = j9;
        }
        if (targetBytes.R() == 2) {
            byte bK3 = targetBytes.k(0);
            byte bK4 = targetBytes.k(1);
            while (jS0 < s0()) {
                byte[] bArr3 = p8.f23595a;
                i8 = (int) ((((long) p8.f23596b) + j8) - jS0);
                int i11 = p8.f23597c;
                while (i8 < i11) {
                    byte b11 = bArr3[i8];
                    if (b11 != bK3 && b11 != bK4) {
                        i8++;
                    }
                }
                jS0 += (long) (p8.f23597c - p8.f23596b);
                p8 = p8.f23600f;
                AbstractC2304t.c(p8);
                j8 = jS0;
            }
            return -1L;
        }
        byte[] bArrH2 = targetBytes.H();
        while (jS0 < s0()) {
            byte[] bArr4 = p8.f23595a;
            i8 = (int) ((((long) p8.f23596b) + j8) - jS0);
            int i12 = p8.f23597c;
            while (i8 < i12) {
                byte b12 = bArr4[i8];
                for (byte b13 : bArrH2) {
                    if (b12 != b13) {
                    }
                }
                i8++;
            }
            jS0 += (long) (p8.f23597c - p8.f23596b);
            p8 = p8.f23600f;
            AbstractC2304t.c(p8);
            j8 = jS0;
        }
        return -1L;
        return ((long) (i8 - p8.f23596b)) + jS0;
    }

    public boolean Q(long j8, C2814g bytes) {
        AbstractC2304t.f(bytes, "bytes");
        return R(j8, bytes, 0, bytes.R());
    }

    public boolean R(long j8, C2814g bytes, int i8, int i9) {
        AbstractC2304t.f(bytes, "bytes");
        if (j8 < 0 || i8 < 0 || i9 < 0 || s0() - j8 < i9 || bytes.R() - i8 < i9) {
            return false;
        }
        for (int i10 = 0; i10 < i9; i10++) {
            if (K(((long) i10) + j8) != bytes.k(i8 + i10)) {
                return false;
            }
        }
        return true;
    }

    public byte[] S() {
        return Y(s0());
    }

    public C2814g T() {
        return p(s0());
    }

    public void U(byte[] sink) throws EOFException {
        AbstractC2304t.f(sink, "sink");
        int i8 = 0;
        while (i8 < sink.length) {
            int i9 = read(sink, i8, sink.length - i8);
            if (i9 == -1) {
                throw new EOFException();
            }
            i8 += i9;
        }
    }

    @Override // u7.InterfaceC2813f
    public int V() {
        return AbstractC2809b.e(readInt());
    }

    public long W() throws EOFException {
        if (s0() < 8) {
            throw new EOFException();
        }
        P p8 = this.f23638a;
        AbstractC2304t.c(p8);
        int i8 = p8.f23596b;
        int i9 = p8.f23597c;
        if (i9 - i8 < 8) {
            return ((((long) readInt()) & KeyboardMap.kValueMask) << 32) | (KeyboardMap.kValueMask & ((long) readInt()));
        }
        byte[] bArr = p8.f23595a;
        int i10 = i8 + 7;
        long j8 = ((((long) bArr[i8]) & 255) << 56) | ((((long) bArr[i8 + 1]) & 255) << 48) | ((((long) bArr[i8 + 2]) & 255) << 40) | ((((long) bArr[i8 + 3]) & 255) << 32) | ((((long) bArr[i8 + 4]) & 255) << 24) | ((((long) bArr[i8 + 5]) & 255) << 16) | ((((long) bArr[i8 + 6]) & 255) << 8);
        int i11 = i8 + 8;
        long j9 = j8 | (((long) bArr[i10]) & 255);
        r0(s0() - 8);
        if (i11 == i9) {
            this.f23638a = p8.b();
            Q.b(p8);
        } else {
            p8.f23596b = i11;
        }
        return j9;
    }

    public String X(long j8, Charset charset) throws EOFException {
        AbstractC2304t.f(charset, "charset");
        if (j8 < 0 || j8 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j8).toString());
        }
        if (this.f23639b < j8) {
            throw new EOFException();
        }
        if (j8 == 0) {
            return "";
        }
        P p8 = this.f23638a;
        AbstractC2304t.c(p8);
        int i8 = p8.f23596b;
        if (((long) i8) + j8 > p8.f23597c) {
            return new String(Y(j8), charset);
        }
        int i9 = (int) j8;
        String str = new String(p8.f23595a, i8, i9, charset);
        int i10 = p8.f23596b + i9;
        p8.f23596b = i10;
        this.f23639b -= j8;
        if (i10 == p8.f23597c) {
            this.f23638a = p8.b();
            Q.b(p8);
        }
        return str;
    }

    @Override // u7.InterfaceC2813f
    public byte[] Y(long j8) throws EOFException {
        if (j8 < 0 || j8 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j8).toString());
        }
        if (s0() < j8) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j8];
        U(bArr);
        return bArr;
    }

    public String b0() {
        return X(this.f23639b, C0977c.f8956b);
    }

    @Override // u7.InterfaceC2813f
    public short c0() {
        return AbstractC2809b.g(readShort());
    }

    public final void e() throws EOFException {
        skip(s0());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2811d) {
            C2811d c2811d = (C2811d) obj;
            if (s0() == c2811d.s0()) {
                if (s0() == 0) {
                    return true;
                }
                P p8 = this.f23638a;
                AbstractC2304t.c(p8);
                P p9 = c2811d.f23638a;
                AbstractC2304t.c(p9);
                int i8 = p8.f23596b;
                int i9 = p9.f23596b;
                long j8 = 0;
                while (j8 < s0()) {
                    long jMin = Math.min(p8.f23597c - i8, p9.f23597c - i9);
                    long j9 = 0;
                    while (j9 < jMin) {
                        int i10 = i8 + 1;
                        int i11 = i9 + 1;
                        if (p8.f23595a[i8] == p9.f23595a[i9]) {
                            j9++;
                            i8 = i10;
                            i9 = i11;
                        }
                    }
                    if (i8 == p8.f23597c) {
                        p8 = p8.f23600f;
                        AbstractC2304t.c(p8);
                        i8 = p8.f23596b;
                    }
                    if (i9 == p9.f23597c) {
                        p9 = p9.f23600f;
                        AbstractC2304t.c(p9);
                        i9 = p9.f23596b;
                    }
                    j8 += jMin;
                }
                return true;
            }
        }
        return false;
    }

    @Override // u7.InterfaceC2813f
    public long f0() {
        return AbstractC2809b.f(W());
    }

    public int hashCode() {
        P p8 = this.f23638a;
        if (p8 == null) {
            return 0;
        }
        int i8 = 1;
        do {
            int i9 = p8.f23597c;
            for (int i10 = p8.f23596b; i10 < i9; i10++) {
                i8 = (i8 * 31) + p8.f23595a[i10];
            }
            p8 = p8.f23600f;
            AbstractC2304t.c(p8);
        } while (p8 != this.f23638a);
        return i8;
    }

    public String i0() {
        return m0(Long.MAX_VALUE);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // u7.InterfaceC2813f
    public String j(long j8) {
        return X(j8, C0977c.f8956b);
    }

    public String m0(long j8) throws EOFException {
        if (j8 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j8).toString());
        }
        long j9 = j8 != Long.MAX_VALUE ? j8 + 1 : Long.MAX_VALUE;
        long jM = M((byte) 10, 0L, j9);
        if (jM != -1) {
            return v7.a.b(this, jM);
        }
        if (j9 < s0() && K(j9 - 1) == 13 && K(j9) == 10) {
            return v7.a.b(this, j9);
        }
        C2811d c2811d = new C2811d();
        E(c2811d, 0L, Math.min(32, s0()));
        throw new EOFException("\\n not found: limit=" + Math.min(s0(), j8) + " content=" + c2811d.T().r() + (char) 8230);
    }

    @Override // u7.InterfaceC2813f
    public void n0(long j8) throws EOFException {
        if (this.f23639b < j8) {
            throw new EOFException();
        }
    }

    @Override // u7.V
    public long o0(C2811d sink, long j8) {
        AbstractC2304t.f(sink, "sink");
        if (j8 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j8).toString());
        }
        if (s0() == 0) {
            return -1L;
        }
        if (j8 > s0()) {
            j8 = s0();
        }
        sink.H(this, j8);
        return j8;
    }

    @Override // u7.InterfaceC2813f
    public C2814g p(long j8) throws EOFException {
        if (j8 < 0 || j8 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j8).toString());
        }
        if (s0() < j8) {
            throw new EOFException();
        }
        if (j8 < 4096) {
            return new C2814g(Y(j8));
        }
        C2814g c2814gW0 = w0((int) j8);
        skip(j8);
        return c2814gW0;
    }

    @Override // u7.InterfaceC2812e
    public OutputStream q0() {
        return new c();
    }

    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public C2811d clone() {
        return D();
    }

    public final void r0(long j8) {
        this.f23639b = j8;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        AbstractC2304t.f(sink, "sink");
        P p8 = this.f23638a;
        if (p8 == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), p8.f23597c - p8.f23596b);
        sink.put(p8.f23595a, p8.f23596b, iMin);
        int i8 = p8.f23596b + iMin;
        p8.f23596b = i8;
        this.f23639b -= (long) iMin;
        if (i8 == p8.f23597c) {
            this.f23638a = p8.b();
            Q.b(p8);
        }
        return iMin;
    }

    @Override // u7.InterfaceC2813f
    public byte readByte() throws EOFException {
        if (s0() == 0) {
            throw new EOFException();
        }
        P p8 = this.f23638a;
        AbstractC2304t.c(p8);
        int i8 = p8.f23596b;
        int i9 = p8.f23597c;
        int i10 = i8 + 1;
        byte b8 = p8.f23595a[i8];
        r0(s0() - 1);
        if (i10 == i9) {
            this.f23638a = p8.b();
            Q.b(p8);
        } else {
            p8.f23596b = i10;
        }
        return b8;
    }

    @Override // u7.InterfaceC2813f
    public int readInt() throws EOFException {
        if (s0() < 4) {
            throw new EOFException();
        }
        P p8 = this.f23638a;
        AbstractC2304t.c(p8);
        int i8 = p8.f23596b;
        int i9 = p8.f23597c;
        if (i9 - i8 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = p8.f23595a;
        int i10 = i8 + 3;
        int i11 = ((bArr[i8 + 1] & 255) << 16) | ((bArr[i8] & 255) << 24) | ((bArr[i8 + 2] & 255) << 8);
        int i12 = i8 + 4;
        int i13 = (bArr[i10] & 255) | i11;
        r0(s0() - 4);
        if (i12 == i9) {
            this.f23638a = p8.b();
            Q.b(p8);
        } else {
            p8.f23596b = i12;
        }
        return i13;
    }

    @Override // u7.InterfaceC2813f
    public short readShort() throws EOFException {
        if (s0() < 2) {
            throw new EOFException();
        }
        P p8 = this.f23638a;
        AbstractC2304t.c(p8);
        int i8 = p8.f23596b;
        int i9 = p8.f23597c;
        if (i9 - i8 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = p8.f23595a;
        int i10 = i8 + 1;
        int i11 = (bArr[i8] & 255) << 8;
        int i12 = i8 + 2;
        int i13 = (bArr[i10] & 255) | i11;
        r0(s0() - 2);
        if (i12 == i9) {
            this.f23638a = p8.b();
            Q.b(p8);
        } else {
            p8.f23596b = i12;
        }
        return (short) i13;
    }

    public final long s0() {
        return this.f23639b;
    }

    @Override // u7.InterfaceC2813f
    public void skip(long j8) throws EOFException {
        while (j8 > 0) {
            P p8 = this.f23638a;
            if (p8 == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j8, p8.f23597c - p8.f23596b);
            long j9 = iMin;
            r0(s0() - j9);
            j8 -= j9;
            int i8 = p8.f23596b + iMin;
            p8.f23596b = i8;
            if (i8 == p8.f23597c) {
                this.f23638a = p8.b();
                Q.b(p8);
            }
        }
    }

    public String toString() {
        return v0().toString();
    }

    @Override // u7.InterfaceC2813f
    public InputStream u0() {
        return new b();
    }

    public final C2814g v0() {
        if (s0() <= 2147483647L) {
            return w0((int) s0());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + s0()).toString());
    }

    @Override // u7.InterfaceC2813f
    public boolean w() {
        return this.f23639b == 0;
    }

    public final C2814g w0(int i8) {
        if (i8 == 0) {
            return C2814g.f23649e;
        }
        AbstractC2809b.b(s0(), 0L, i8);
        P p8 = this.f23638a;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i8) {
            AbstractC2304t.c(p8);
            int i12 = p8.f23597c;
            int i13 = p8.f23596b;
            if (i12 == i13) {
                throw new AssertionError("s.limit == s.pos");
            }
            i10 += i12 - i13;
            i11++;
            p8 = p8.f23600f;
        }
        byte[][] bArr = new byte[i11][];
        int[] iArr = new int[i11 * 2];
        P p9 = this.f23638a;
        int i14 = 0;
        while (i9 < i8) {
            AbstractC2304t.c(p9);
            bArr[i14] = p9.f23595a;
            i9 += p9.f23597c - p9.f23596b;
            iArr[i14] = Math.min(i9, i8);
            iArr[i14 + i11] = p9.f23596b;
            p9.f23598d = true;
            i14++;
            p9 = p9.f23600f;
        }
        return new S(bArr, iArr);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        AbstractC2304t.f(source, "source");
        int iRemaining = source.remaining();
        int i8 = iRemaining;
        while (i8 > 0) {
            P pX0 = x0(1);
            int iMin = Math.min(i8, 8192 - pX0.f23597c);
            source.get(pX0.f23595a, pX0.f23597c, iMin);
            i8 -= iMin;
            pX0.f23597c += iMin;
        }
        this.f23639b += (long) iRemaining;
        return iRemaining;
    }

    public final P x0(int i8) {
        if (i8 < 1 || i8 > 8192) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        P p8 = this.f23638a;
        if (p8 != null) {
            AbstractC2304t.c(p8);
            P p9 = p8.f23601g;
            AbstractC2304t.c(p9);
            return (p9.f23597c + i8 > 8192 || !p9.f23599e) ? p9.c(Q.c()) : p9;
        }
        P pC = Q.c();
        this.f23638a = pC;
        pC.f23601g = pC;
        pC.f23600f = pC;
        return pC;
    }

    public C2811d y0(C2814g byteString) {
        AbstractC2304t.f(byteString, "byteString");
        byteString.Y(this, 0, byteString.R());
        return this;
    }

    @Override // u7.InterfaceC2812e
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public C2811d Z(byte[] source) {
        AbstractC2304t.f(source, "source");
        return A0(source, 0, source.length);
    }

    public int read(byte[] sink, int i8, int i9) {
        AbstractC2304t.f(sink, "sink");
        AbstractC2809b.b(sink.length, i8, i9);
        P p8 = this.f23638a;
        if (p8 == null) {
            return -1;
        }
        int iMin = Math.min(i9, p8.f23597c - p8.f23596b);
        byte[] bArr = p8.f23595a;
        int i10 = p8.f23596b;
        AbstractC2590l.e(bArr, sink, i8, i10, i10 + iMin);
        p8.f23596b += iMin;
        r0(s0() - ((long) iMin));
        if (p8.f23596b == p8.f23597c) {
            this.f23638a = p8.b();
            Q.b(p8);
        }
        return iMin;
    }

    public C2811d c() {
        return this;
    }

    @Override // u7.V, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // u7.InterfaceC2812e, u7.T, java.io.Flushable
    public void flush() {
    }

    @Override // u7.InterfaceC2813f
    public C2811d v() {
        return this;
    }
}
