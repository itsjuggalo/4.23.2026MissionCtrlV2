package w6;

import F5.AbstractC0551i;
import Z5.C0796c;
import com.google.android.gms.common.api.a;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: w6.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2792e implements InterfaceC2794g, InterfaceC2793f, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f25095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f25096b;

    /* JADX INFO: renamed from: w6.e$a */
    public static final class a implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C2792e f25097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f25098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public U f25099c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f25101e;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f25100d = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f25102f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f25103g = -1;

        public final int A(long j7) {
            U uC;
            C2792e c2792e = this.f25097a;
            if (c2792e == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (j7 < -1 || j7 > c2792e.E0()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + j7 + " > size=" + c2792e.E0());
            }
            if (j7 == -1 || j7 == c2792e.E0()) {
                G(null);
                this.f25100d = j7;
                this.f25101e = null;
                this.f25102f = -1;
                this.f25103g = -1;
                return -1;
            }
            long jE0 = c2792e.E0();
            U uH = c2792e.f25095a;
            long j8 = 0;
            if (h() != null) {
                long j9 = this.f25100d;
                int i7 = this.f25102f;
                U uH2 = h();
                kotlin.jvm.internal.r.c(uH2);
                long j10 = j9 - ((long) (i7 - uH2.f25053b));
                if (j10 > j7) {
                    uC = uH;
                    uH = h();
                    jE0 = j10;
                } else {
                    uC = h();
                    j8 = j10;
                }
            } else {
                uC = uH;
            }
            if (jE0 - j7 > j7 - j8) {
                while (true) {
                    kotlin.jvm.internal.r.c(uC);
                    int i8 = uC.f25054c;
                    int i9 = uC.f25053b;
                    if (j7 < ((long) (i8 - i9)) + j8) {
                        break;
                    }
                    j8 += (long) (i8 - i9);
                    uC = uC.f25057f;
                }
            } else {
                while (jE0 > j7) {
                    kotlin.jvm.internal.r.c(uH);
                    uH = uH.f25058g;
                    kotlin.jvm.internal.r.c(uH);
                    jE0 -= (long) (uH.f25054c - uH.f25053b);
                }
                j8 = jE0;
                uC = uH;
            }
            if (this.f25098b) {
                kotlin.jvm.internal.r.c(uC);
                if (uC.f25055d) {
                    U uF = uC.f();
                    if (c2792e.f25095a == uC) {
                        c2792e.f25095a = uF;
                    }
                    uC = uC.c(uF);
                    U u7 = uC.f25058g;
                    kotlin.jvm.internal.r.c(u7);
                    u7.b();
                }
            }
            G(uC);
            this.f25100d = j7;
            kotlin.jvm.internal.r.c(uC);
            this.f25101e = uC.f25052a;
            int i10 = uC.f25053b + ((int) (j7 - j8));
            this.f25102f = i10;
            int i11 = uC.f25054c;
            this.f25103g = i11;
            return i11 - i10;
        }

        public final void G(U u7) {
            this.f25099c = u7;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f25097a == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.f25097a = null;
            G(null);
            this.f25100d = -1L;
            this.f25101e = null;
            this.f25102f = -1;
            this.f25103g = -1;
        }

        public final U h() {
            return this.f25099c;
        }

        public final int i() {
            long j7 = this.f25100d;
            C2792e c2792e = this.f25097a;
            kotlin.jvm.internal.r.c(c2792e);
            if (j7 == c2792e.E0()) {
                throw new IllegalStateException("no more bytes");
            }
            long j8 = this.f25100d;
            return A(j8 == -1 ? 0L : j8 + ((long) (this.f25103g - this.f25102f)));
        }
    }

    /* JADX INFO: renamed from: w6.e$c */
    public static final class c extends OutputStream {
        public c() {
        }

        public String toString() {
            return C2792e.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i7) {
            C2792e.this.v(i7);
        }

        @Override // java.io.OutputStream
        public void write(byte[] data, int i7, int i8) {
            kotlin.jvm.internal.r.f(data, "data");
            C2792e.this.g(data, i7, i8);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }
    }

    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public C2792e clone() {
        return H();
    }

    public C2795h A0() {
        return o(E0());
    }

    public String B0(long j7, Charset charset) throws EOFException {
        kotlin.jvm.internal.r.f(charset, "charset");
        if (j7 < 0 || j7 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j7).toString());
        }
        if (this.f25096b < j7) {
            throw new EOFException();
        }
        if (j7 == 0) {
            return "";
        }
        U u7 = this.f25095a;
        kotlin.jvm.internal.r.c(u7);
        int i7 = u7.f25053b;
        if (((long) i7) + j7 > u7.f25054c) {
            return new String(Y(j7), charset);
        }
        int i8 = (int) j7;
        String str = new String(u7.f25052a, i7, i8, charset);
        int i9 = u7.f25053b + i8;
        u7.f25053b = i9;
        this.f25096b -= j7;
        if (i9 == u7.f25054c) {
            this.f25095a = u7.b();
            V.b(u7);
        }
        return str;
    }

    @Override // w6.InterfaceC2794g
    public long C() throws EOFException {
        if (E0() == 0) {
            throw new EOFException();
        }
        int i7 = 0;
        boolean z7 = false;
        long j7 = 0;
        long j8 = -7;
        boolean z8 = false;
        do {
            U u7 = this.f25095a;
            kotlin.jvm.internal.r.c(u7);
            byte[] bArr = u7.f25052a;
            int i8 = u7.f25053b;
            int i9 = u7.f25054c;
            while (i8 < i9) {
                byte b7 = bArr[i8];
                if (b7 >= 48 && b7 <= 57) {
                    int i10 = 48 - b7;
                    if (j7 < -922337203685477580L || (j7 == -922337203685477580L && i10 < j8)) {
                        C2792e c2792eV = new C2792e().q0(j7).v(b7);
                        if (!z7) {
                            c2792eV.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + c2792eV.C0());
                    }
                    j7 = (j7 * 10) + ((long) i10);
                } else {
                    if (b7 != 45 || i7 != 0) {
                        z8 = true;
                        break;
                    }
                    j8--;
                    z7 = true;
                }
                i8++;
                i7++;
            }
            if (i8 == i9) {
                this.f25095a = u7.b();
                V.b(u7);
            } else {
                u7.f25053b = i8;
            }
            if (z8) {
                break;
            }
        } while (this.f25095a != null);
        D0(E0() - ((long) i7));
        if (i7 >= (z7 ? 2 : 1)) {
            return z7 ? j7 : -j7;
        }
        if (E0() == 0) {
            throw new EOFException();
        }
        throw new NumberFormatException((z7 ? "Expected a digit" : "Expected a digit or '-'") + " but was 0x" + AbstractC2789b.i(T(0L)));
    }

    public String C0() {
        return B0(this.f25096b, C0796c.f6018b);
    }

    public final void D0(long j7) {
        this.f25096b = j7;
    }

    @Override // w6.InterfaceC2794g
    public String E(long j7) throws EOFException {
        if (j7 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j7).toString());
        }
        long j8 = j7 != Long.MAX_VALUE ? j7 + 1 : Long.MAX_VALUE;
        long jV = V((byte) 10, 0L, j8);
        if (jV != -1) {
            return x6.a.c(this, jV);
        }
        if (j8 < E0() && T(j8 - 1) == 13 && T(j8) == 10) {
            return x6.a.c(this, j8);
        }
        C2792e c2792e = new C2792e();
        K(c2792e, 0L, Math.min(32, E0()));
        throw new EOFException("\\n not found: limit=" + Math.min(E0(), j7) + " content=" + c2792e.A0().q() + (char) 8230);
    }

    public final long E0() {
        return this.f25096b;
    }

    public final C2795h F0() {
        if (E0() <= 2147483647L) {
            return G0((int) E0());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + E0()).toString());
    }

    public final long G() {
        long jE0 = E0();
        if (jE0 == 0) {
            return 0L;
        }
        U u7 = this.f25095a;
        kotlin.jvm.internal.r.c(u7);
        U u8 = u7.f25058g;
        kotlin.jvm.internal.r.c(u8);
        int i7 = u8.f25054c;
        if (i7 < 8192 && u8.f25056e) {
            jE0 -= (long) (i7 - u8.f25053b);
        }
        return jE0;
    }

    public final C2795h G0(int i7) {
        if (i7 == 0) {
            return C2795h.f25107e;
        }
        AbstractC2789b.b(E0(), 0L, i7);
        U u7 = this.f25095a;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i7) {
            kotlin.jvm.internal.r.c(u7);
            int i11 = u7.f25054c;
            int i12 = u7.f25053b;
            if (i11 == i12) {
                throw new AssertionError("s.limit == s.pos");
            }
            i9 += i11 - i12;
            i10++;
            u7 = u7.f25057f;
        }
        byte[][] bArr = new byte[i10][];
        int[] iArr = new int[i10 * 2];
        U u8 = this.f25095a;
        int i13 = 0;
        while (i8 < i7) {
            kotlin.jvm.internal.r.c(u8);
            bArr[i13] = u8.f25052a;
            i8 += u8.f25054c - u8.f25053b;
            iArr[i13] = Math.min(i8, i7);
            iArr[i13 + i10] = u8.f25053b;
            u8.f25055d = true;
            i13++;
            u8 = u8.f25057f;
        }
        return new W(bArr, iArr);
    }

    public final C2792e H() {
        C2792e c2792e = new C2792e();
        if (E0() != 0) {
            U u7 = this.f25095a;
            kotlin.jvm.internal.r.c(u7);
            U uD = u7.d();
            c2792e.f25095a = uD;
            uD.f25058g = uD;
            uD.f25057f = uD;
            for (U u8 = u7.f25057f; u8 != u7; u8 = u8.f25057f) {
                U u9 = uD.f25058g;
                kotlin.jvm.internal.r.c(u9);
                kotlin.jvm.internal.r.c(u8);
                u9.c(u8.d());
            }
            c2792e.D0(E0());
        }
        return c2792e;
    }

    public final U H0(int i7) {
        if (i7 < 1 || i7 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        U u7 = this.f25095a;
        if (u7 != null) {
            kotlin.jvm.internal.r.c(u7);
            U u8 = u7.f25058g;
            kotlin.jvm.internal.r.c(u8);
            return (u8.f25054c + i7 > 8192 || !u8.f25056e) ? u8.c(V.c()) : u8;
        }
        U uC = V.c();
        this.f25095a = uC;
        uC.f25058g = uC;
        uC.f25057f = uC;
        return uC;
    }

    @Override // w6.InterfaceC2793f
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public C2792e m(C2795h byteString) {
        kotlin.jvm.internal.r.f(byteString, "byteString");
        byteString.O(this, 0, byteString.H());
        return this;
    }

    @Override // w6.InterfaceC2793f
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public C2792e a0(byte[] source) {
        kotlin.jvm.internal.r.f(source, "source");
        return g(source, 0, source.length);
    }

    public final C2792e K(C2792e out, long j7, long j8) {
        kotlin.jvm.internal.r.f(out, "out");
        AbstractC2789b.b(E0(), j7, j8);
        if (j8 != 0) {
            out.D0(out.E0() + j8);
            U u7 = this.f25095a;
            while (true) {
                kotlin.jvm.internal.r.c(u7);
                int i7 = u7.f25054c;
                int i8 = u7.f25053b;
                if (j7 < i7 - i8) {
                    break;
                }
                j7 -= (long) (i7 - i8);
                u7 = u7.f25057f;
            }
            while (j8 > 0) {
                kotlin.jvm.internal.r.c(u7);
                U uD = u7.d();
                int i9 = uD.f25053b + ((int) j7);
                uD.f25053b = i9;
                uD.f25054c = Math.min(i9 + ((int) j8), uD.f25054c);
                U u8 = out.f25095a;
                if (u8 == null) {
                    uD.f25058g = uD;
                    uD.f25057f = uD;
                    out.f25095a = uD;
                } else {
                    kotlin.jvm.internal.r.c(u8);
                    U u9 = u8.f25058g;
                    kotlin.jvm.internal.r.c(u9);
                    u9.c(uD);
                }
                j8 -= (long) (uD.f25054c - uD.f25053b);
                u7 = u7.f25057f;
                j7 = 0;
            }
        }
        return this;
    }

    @Override // w6.InterfaceC2793f
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public C2792e g(byte[] source, int i7, int i8) {
        kotlin.jvm.internal.r.f(source, "source");
        long j7 = i8;
        AbstractC2789b.b(source.length, i7, j7);
        int i9 = i8 + i7;
        while (i7 < i9) {
            U uH0 = H0(1);
            int iMin = Math.min(i9 - i7, 8192 - uH0.f25054c);
            int i10 = i7 + iMin;
            AbstractC0551i.d(source, uH0.f25052a, uH0.f25054c, i7, i10);
            uH0.f25054c += iMin;
            i7 = i10;
        }
        D0(E0() + j7);
        return this;
    }

    @Override // w6.X
    public void L(C2792e source, long j7) {
        U u7;
        kotlin.jvm.internal.r.f(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        AbstractC2789b.b(source.E0(), 0L, j7);
        while (j7 > 0) {
            U u8 = source.f25095a;
            kotlin.jvm.internal.r.c(u8);
            int i7 = u8.f25054c;
            kotlin.jvm.internal.r.c(source.f25095a);
            if (j7 < i7 - r1.f25053b) {
                U u9 = this.f25095a;
                if (u9 != null) {
                    kotlin.jvm.internal.r.c(u9);
                    u7 = u9.f25058g;
                } else {
                    u7 = null;
                }
                if (u7 != null && u7.f25056e) {
                    if ((((long) u7.f25054c) + j7) - ((long) (u7.f25055d ? 0 : u7.f25053b)) <= 8192) {
                        U u10 = source.f25095a;
                        kotlin.jvm.internal.r.c(u10);
                        u10.g(u7, (int) j7);
                        source.D0(source.E0() - j7);
                        D0(E0() + j7);
                        return;
                    }
                }
                U u11 = source.f25095a;
                kotlin.jvm.internal.r.c(u11);
                source.f25095a = u11.e((int) j7);
            }
            U u12 = source.f25095a;
            kotlin.jvm.internal.r.c(u12);
            long j8 = u12.f25054c - u12.f25053b;
            source.f25095a = u12.b();
            U u13 = this.f25095a;
            if (u13 == null) {
                this.f25095a = u12;
                u12.f25058g = u12;
                u12.f25057f = u12;
            } else {
                kotlin.jvm.internal.r.c(u13);
                U u14 = u13.f25058g;
                kotlin.jvm.internal.r.c(u14);
                u14.c(u12).a();
            }
            source.D0(source.E0() - j8);
            D0(E0() + j8);
            j7 -= j8;
        }
    }

    @Override // w6.InterfaceC2793f
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public C2792e v(int i7) {
        U uH0 = H0(1);
        byte[] bArr = uH0.f25052a;
        int i8 = uH0.f25054c;
        uH0.f25054c = i8 + 1;
        bArr[i8] = (byte) i7;
        D0(E0() + 1);
        return this;
    }

    @Override // w6.InterfaceC2793f
    /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
    public C2792e q0(long j7) {
        boolean z7;
        if (j7 == 0) {
            return v(48);
        }
        int i7 = 1;
        if (j7 < 0) {
            j7 = -j7;
            if (j7 < 0) {
                return I("-9223372036854775808");
            }
            z7 = true;
        } else {
            z7 = false;
        }
        if (j7 >= 100000000) {
            i7 = j7 < 1000000000000L ? j7 < 10000000000L ? j7 < 1000000000 ? 9 : 10 : j7 < 100000000000L ? 11 : 12 : j7 < 1000000000000000L ? j7 < 10000000000000L ? 13 : j7 < 100000000000000L ? 14 : 15 : j7 < 100000000000000000L ? j7 < 10000000000000000L ? 16 : 17 : j7 < 1000000000000000000L ? 18 : 19;
        } else if (j7 >= 10000) {
            i7 = j7 < 1000000 ? j7 < 100000 ? 5 : 6 : j7 < 10000000 ? 7 : 8;
        } else if (j7 >= 100) {
            i7 = j7 < 1000 ? 3 : 4;
        } else if (j7 >= 10) {
            i7 = 2;
        }
        if (z7) {
            i7++;
        }
        U uH0 = H0(i7);
        byte[] bArr = uH0.f25052a;
        int i8 = uH0.f25054c + i7;
        while (j7 != 0) {
            long j8 = 10;
            i8--;
            bArr[i8] = x6.a.b()[(int) (j7 % j8)];
            j7 /= j8;
        }
        if (z7) {
            bArr[i8 - 1] = 45;
        }
        uH0.f25054c += i7;
        D0(E0() + ((long) i7));
        return this;
    }

    @Override // w6.InterfaceC2793f
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public C2792e P(long j7) {
        if (j7 == 0) {
            return v(48);
        }
        long j8 = (j7 >>> 1) | j7;
        long j9 = j8 | (j8 >>> 2);
        long j10 = j9 | (j9 >>> 4);
        long j11 = j10 | (j10 >>> 8);
        long j12 = j11 | (j11 >>> 16);
        long j13 = j12 | (j12 >>> 32);
        long j14 = j13 - ((j13 >>> 1) & 6148914691236517205L);
        long j15 = ((j14 >>> 2) & 3689348814741910323L) + (j14 & 3689348814741910323L);
        long j16 = ((j15 >>> 4) + j15) & 1085102592571150095L;
        long j17 = j16 + (j16 >>> 8);
        long j18 = j17 + (j17 >>> 16);
        int i7 = (int) ((((j18 & 63) + ((j18 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        U uH0 = H0(i7);
        byte[] bArr = uH0.f25052a;
        int i8 = uH0.f25054c;
        for (int i9 = (i8 + i7) - 1; i9 >= i8; i9--) {
            bArr[i9] = x6.a.b()[(int) (15 & j7)];
            j7 >>>= 4;
        }
        uH0.f25054c += i7;
        D0(E0() + ((long) i7));
        return this;
    }

    @Override // w6.InterfaceC2793f
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public C2792e r(int i7) {
        U uH0 = H0(4);
        byte[] bArr = uH0.f25052a;
        int i8 = uH0.f25054c;
        bArr[i8] = (byte) ((i7 >>> 24) & 255);
        bArr[i8 + 1] = (byte) ((i7 >>> 16) & 255);
        bArr[i8 + 2] = (byte) ((i7 >>> 8) & 255);
        bArr[i8 + 3] = (byte) (i7 & 255);
        uH0.f25054c = i8 + 4;
        D0(E0() + 4);
        return this;
    }

    public C2792e P0(long j7) {
        U uH0 = H0(8);
        byte[] bArr = uH0.f25052a;
        int i7 = uH0.f25054c;
        bArr[i7] = (byte) ((j7 >>> 56) & 255);
        bArr[i7 + 1] = (byte) ((j7 >>> 48) & 255);
        bArr[i7 + 2] = (byte) ((j7 >>> 40) & 255);
        bArr[i7 + 3] = (byte) ((j7 >>> 32) & 255);
        bArr[i7 + 4] = (byte) ((j7 >>> 24) & 255);
        bArr[i7 + 5] = (byte) ((j7 >>> 16) & 255);
        bArr[i7 + 6] = (byte) ((j7 >>> 8) & 255);
        bArr[i7 + 7] = (byte) (j7 & 255);
        uH0.f25054c = i7 + 8;
        D0(E0() + 8);
        return this;
    }

    @Override // w6.InterfaceC2793f
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public C2792e q(int i7) {
        U uH0 = H0(2);
        byte[] bArr = uH0.f25052a;
        int i8 = uH0.f25054c;
        bArr[i8] = (byte) ((i7 >>> 8) & 255);
        bArr[i8 + 1] = (byte) (i7 & 255);
        uH0.f25054c = i8 + 2;
        D0(E0() + 2);
        return this;
    }

    @Override // w6.InterfaceC2794g
    public boolean R(long j7, C2795h bytes) {
        kotlin.jvm.internal.r.f(bytes, "bytes");
        return i0(j7, bytes, 0, bytes.H());
    }

    public C2792e R0(String string, int i7, int i8, Charset charset) {
        kotlin.jvm.internal.r.f(string, "string");
        kotlin.jvm.internal.r.f(charset, "charset");
        if (i7 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i7).toString());
        }
        if (i8 < i7) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i8 + " < " + i7).toString());
        }
        if (i8 > string.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i8 + " > " + string.length()).toString());
        }
        if (kotlin.jvm.internal.r.b(charset, C0796c.f6018b)) {
            return U0(string, i7, i8);
        }
        String strSubstring = string.substring(i7, i8);
        kotlin.jvm.internal.r.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] bytes = strSubstring.getBytes(charset);
        kotlin.jvm.internal.r.e(bytes, "this as java.lang.String).getBytes(charset)");
        return g(bytes, 0, bytes.length);
    }

    public final C2792e S0(OutputStream out, long j7) throws IOException {
        kotlin.jvm.internal.r.f(out, "out");
        AbstractC2789b.b(this.f25096b, 0L, j7);
        U u7 = this.f25095a;
        while (j7 > 0) {
            kotlin.jvm.internal.r.c(u7);
            int iMin = (int) Math.min(j7, u7.f25054c - u7.f25053b);
            out.write(u7.f25052a, u7.f25053b, iMin);
            int i7 = u7.f25053b + iMin;
            u7.f25053b = i7;
            long j8 = iMin;
            this.f25096b -= j8;
            j7 -= j8;
            if (i7 == u7.f25054c) {
                U uB = u7.b();
                this.f25095a = uB;
                V.b(u7);
                u7 = uB;
            }
        }
        return this;
    }

    public final byte T(long j7) {
        AbstractC2789b.b(E0(), j7, 1L);
        U u7 = this.f25095a;
        if (u7 == null) {
            kotlin.jvm.internal.r.c(null);
            throw null;
        }
        if (E0() - j7 < j7) {
            long jE0 = E0();
            while (jE0 > j7) {
                u7 = u7.f25058g;
                kotlin.jvm.internal.r.c(u7);
                jE0 -= (long) (u7.f25054c - u7.f25053b);
            }
            kotlin.jvm.internal.r.c(u7);
            return u7.f25052a[(int) ((((long) u7.f25053b) + j7) - jE0)];
        }
        long j8 = 0;
        while (true) {
            long j9 = ((long) (u7.f25054c - u7.f25053b)) + j8;
            if (j9 > j7) {
                kotlin.jvm.internal.r.c(u7);
                return u7.f25052a[(int) ((((long) u7.f25053b) + j7) - j8)];
            }
            u7 = u7.f25057f;
            kotlin.jvm.internal.r.c(u7);
            j8 = j9;
        }
    }

    @Override // w6.InterfaceC2793f
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public C2792e I(String string) {
        kotlin.jvm.internal.r.f(string, "string");
        return U0(string, 0, string.length());
    }

    @Override // w6.InterfaceC2794g
    public String U() {
        return E(Long.MAX_VALUE);
    }

    public C2792e U0(String string, int i7, int i8) {
        char cCharAt;
        kotlin.jvm.internal.r.f(string, "string");
        if (i7 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i7).toString());
        }
        if (i8 < i7) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i8 + " < " + i7).toString());
        }
        if (i8 > string.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i8 + " > " + string.length()).toString());
        }
        while (i7 < i8) {
            char cCharAt2 = string.charAt(i7);
            if (cCharAt2 < 128) {
                U uH0 = H0(1);
                byte[] bArr = uH0.f25052a;
                int i9 = uH0.f25054c - i7;
                int iMin = Math.min(i8, 8192 - i9);
                int i10 = i7 + 1;
                bArr[i7 + i9] = (byte) cCharAt2;
                while (true) {
                    i7 = i10;
                    if (i7 >= iMin || (cCharAt = string.charAt(i7)) >= 128) {
                        break;
                    }
                    i10 = i7 + 1;
                    bArr[i7 + i9] = (byte) cCharAt;
                }
                int i11 = uH0.f25054c;
                int i12 = (i9 + i7) - i11;
                uH0.f25054c = i11 + i12;
                D0(E0() + ((long) i12));
            } else {
                if (cCharAt2 < 2048) {
                    U uH02 = H0(2);
                    byte[] bArr2 = uH02.f25052a;
                    int i13 = uH02.f25054c;
                    bArr2[i13] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i13 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    uH02.f25054c = i13 + 2;
                    D0(E0() + 2);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    U uH03 = H0(3);
                    byte[] bArr3 = uH03.f25052a;
                    int i14 = uH03.f25054c;
                    bArr3[i14] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i14 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i14 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    uH03.f25054c = i14 + 3;
                    D0(E0() + 3);
                } else {
                    int i15 = i7 + 1;
                    char cCharAt3 = i15 < i8 ? string.charAt(i15) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        v(63);
                        i7 = i15;
                    } else {
                        int i16 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        U uH04 = H0(4);
                        byte[] bArr4 = uH04.f25052a;
                        int i17 = uH04.f25054c;
                        bArr4[i17] = (byte) ((i16 >> 18) | 240);
                        bArr4[i17 + 1] = (byte) (((i16 >> 12) & 63) | 128);
                        bArr4[i17 + 2] = (byte) (((i16 >> 6) & 63) | 128);
                        bArr4[i17 + 3] = (byte) ((i16 & 63) | 128);
                        uH04.f25054c = i17 + 4;
                        D0(E0() + 4);
                        i7 += 2;
                    }
                }
                i7++;
            }
        }
        return this;
    }

    public long V(byte b7, long j7, long j8) {
        U u7;
        int i7;
        long jE0 = 0;
        if (0 > j7 || j7 > j8) {
            throw new IllegalArgumentException(("size=" + E0() + " fromIndex=" + j7 + " toIndex=" + j8).toString());
        }
        if (j8 > E0()) {
            j8 = E0();
        }
        if (j7 == j8 || (u7 = this.f25095a) == null) {
            return -1L;
        }
        if (E0() - j7 < j7) {
            jE0 = E0();
            while (jE0 > j7) {
                u7 = u7.f25058g;
                kotlin.jvm.internal.r.c(u7);
                jE0 -= (long) (u7.f25054c - u7.f25053b);
            }
            while (jE0 < j8) {
                byte[] bArr = u7.f25052a;
                int iMin = (int) Math.min(u7.f25054c, (((long) u7.f25053b) + j8) - jE0);
                i7 = (int) ((((long) u7.f25053b) + j7) - jE0);
                while (i7 < iMin) {
                    if (bArr[i7] != b7) {
                        i7++;
                    }
                }
                jE0 += (long) (u7.f25054c - u7.f25053b);
                u7 = u7.f25057f;
                kotlin.jvm.internal.r.c(u7);
                j7 = jE0;
            }
            return -1L;
        }
        while (true) {
            long j9 = ((long) (u7.f25054c - u7.f25053b)) + jE0;
            if (j9 > j7) {
                break;
            }
            u7 = u7.f25057f;
            kotlin.jvm.internal.r.c(u7);
            jE0 = j9;
        }
        while (jE0 < j8) {
            byte[] bArr2 = u7.f25052a;
            int iMin2 = (int) Math.min(u7.f25054c, (((long) u7.f25053b) + j8) - jE0);
            i7 = (int) ((((long) u7.f25053b) + j7) - jE0);
            while (i7 < iMin2) {
                if (bArr2[i7] != b7) {
                    i7++;
                }
            }
            jE0 += (long) (u7.f25054c - u7.f25053b);
            u7 = u7.f25057f;
            kotlin.jvm.internal.r.c(u7);
            j7 = jE0;
        }
        return -1L;
        return ((long) (i7 - u7.f25053b)) + jE0;
    }

    public C2792e V0(int i7) {
        if (i7 < 128) {
            v(i7);
        } else if (i7 < 2048) {
            U uH0 = H0(2);
            byte[] bArr = uH0.f25052a;
            int i8 = uH0.f25054c;
            bArr[i8] = (byte) ((i7 >> 6) | 192);
            bArr[i8 + 1] = (byte) ((i7 & 63) | 128);
            uH0.f25054c = i8 + 2;
            D0(E0() + 2);
        } else if (55296 <= i7 && i7 < 57344) {
            v(63);
        } else if (i7 < 65536) {
            U uH02 = H0(3);
            byte[] bArr2 = uH02.f25052a;
            int i9 = uH02.f25054c;
            bArr2[i9] = (byte) ((i7 >> 12) | 224);
            bArr2[i9 + 1] = (byte) (((i7 >> 6) & 63) | 128);
            bArr2[i9 + 2] = (byte) ((i7 & 63) | 128);
            uH02.f25054c = i9 + 3;
            D0(E0() + 3);
        } else {
            if (i7 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x" + AbstractC2789b.j(i7));
            }
            U uH03 = H0(4);
            byte[] bArr3 = uH03.f25052a;
            int i10 = uH03.f25054c;
            bArr3[i10] = (byte) ((i7 >> 18) | 240);
            bArr3[i10 + 1] = (byte) (((i7 >> 12) & 63) | 128);
            bArr3[i10 + 2] = (byte) (((i7 >> 6) & 63) | 128);
            bArr3[i10 + 3] = (byte) ((i7 & 63) | 128);
            uH03.f25054c = i10 + 4;
            D0(E0() + 4);
        }
        return this;
    }

    @Override // w6.InterfaceC2794g
    public int W() {
        return AbstractC2789b.f(readInt());
    }

    public long X(C2795h targetBytes) {
        kotlin.jvm.internal.r.f(targetBytes, "targetBytes");
        return c0(targetBytes, 0L);
    }

    @Override // w6.InterfaceC2794g
    public byte[] Y(long j7) throws EOFException {
        if (j7 < 0 || j7 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j7).toString());
        }
        if (E0() < j7) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j7];
        readFully(bArr);
        return bArr;
    }

    public long c0(C2795h targetBytes, long j7) {
        int i7;
        int i8;
        kotlin.jvm.internal.r.f(targetBytes, "targetBytes");
        long jE0 = 0;
        if (j7 < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j7).toString());
        }
        U u7 = this.f25095a;
        if (u7 == null) {
            return -1L;
        }
        if (E0() - j7 < j7) {
            jE0 = E0();
            while (jE0 > j7) {
                u7 = u7.f25058g;
                kotlin.jvm.internal.r.c(u7);
                jE0 -= (long) (u7.f25054c - u7.f25053b);
            }
            if (targetBytes.H() == 2) {
                byte bL = targetBytes.l(0);
                byte bL2 = targetBytes.l(1);
                while (jE0 < E0()) {
                    byte[] bArr = u7.f25052a;
                    i7 = (int) ((((long) u7.f25053b) + j7) - jE0);
                    int i9 = u7.f25054c;
                    while (i7 < i9) {
                        byte b7 = bArr[i7];
                        if (b7 == bL || b7 == bL2) {
                            i8 = u7.f25053b;
                        } else {
                            i7++;
                        }
                    }
                    jE0 += (long) (u7.f25054c - u7.f25053b);
                    u7 = u7.f25057f;
                    kotlin.jvm.internal.r.c(u7);
                    j7 = jE0;
                }
                return -1L;
            }
            byte[] bArrU = targetBytes.u();
            while (jE0 < E0()) {
                byte[] bArr2 = u7.f25052a;
                i7 = (int) ((((long) u7.f25053b) + j7) - jE0);
                int i10 = u7.f25054c;
                while (i7 < i10) {
                    byte b8 = bArr2[i7];
                    for (byte b9 : bArrU) {
                        if (b8 == b9) {
                            i8 = u7.f25053b;
                        }
                    }
                    i7++;
                }
                jE0 += (long) (u7.f25054c - u7.f25053b);
                u7 = u7.f25057f;
                kotlin.jvm.internal.r.c(u7);
                j7 = jE0;
            }
            return -1L;
        }
        while (true) {
            long j8 = ((long) (u7.f25054c - u7.f25053b)) + jE0;
            if (j8 > j7) {
                break;
            }
            u7 = u7.f25057f;
            kotlin.jvm.internal.r.c(u7);
            jE0 = j8;
        }
        if (targetBytes.H() == 2) {
            byte bL3 = targetBytes.l(0);
            byte bL4 = targetBytes.l(1);
            while (jE0 < E0()) {
                byte[] bArr3 = u7.f25052a;
                i7 = (int) ((((long) u7.f25053b) + j7) - jE0);
                int i11 = u7.f25054c;
                while (i7 < i11) {
                    byte b10 = bArr3[i7];
                    if (b10 == bL3 || b10 == bL4) {
                        i8 = u7.f25053b;
                    } else {
                        i7++;
                    }
                }
                jE0 += (long) (u7.f25054c - u7.f25053b);
                u7 = u7.f25057f;
                kotlin.jvm.internal.r.c(u7);
                j7 = jE0;
            }
            return -1L;
        }
        byte[] bArrU2 = targetBytes.u();
        while (jE0 < E0()) {
            byte[] bArr4 = u7.f25052a;
            i7 = (int) ((((long) u7.f25053b) + j7) - jE0);
            int i12 = u7.f25054c;
            while (i7 < i12) {
                byte b11 = bArr4[i7];
                for (byte b12 : bArrU2) {
                    if (b11 == b12) {
                        i8 = u7.f25053b;
                    }
                }
                i7++;
            }
            jE0 += (long) (u7.f25054c - u7.f25053b);
            u7 = u7.f25057f;
            kotlin.jvm.internal.r.c(u7);
            j7 = jE0;
        }
        return -1L;
        return ((long) (i7 - i8)) + jE0;
    }

    @Override // w6.InterfaceC2794g
    public short d0() {
        return AbstractC2789b.h(readShort());
    }

    @Override // w6.InterfaceC2794g
    public void e0(C2792e sink, long j7) throws EOFException {
        kotlin.jvm.internal.r.f(sink, "sink");
        if (E0() >= j7) {
            sink.L(this, j7);
        } else {
            sink.L(this, E0());
            throw new EOFException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2792e) {
            C2792e c2792e = (C2792e) obj;
            if (E0() == c2792e.E0()) {
                if (E0() == 0) {
                    return true;
                }
                U u7 = this.f25095a;
                kotlin.jvm.internal.r.c(u7);
                U u8 = c2792e.f25095a;
                kotlin.jvm.internal.r.c(u8);
                int i7 = u7.f25053b;
                int i8 = u8.f25053b;
                long j7 = 0;
                while (j7 < E0()) {
                    long jMin = Math.min(u7.f25054c - i7, u8.f25054c - i8);
                    long j8 = 0;
                    while (j8 < jMin) {
                        int i9 = i7 + 1;
                        int i10 = i8 + 1;
                        if (u7.f25052a[i7] == u8.f25052a[i8]) {
                            j8++;
                            i7 = i9;
                            i8 = i10;
                        }
                    }
                    if (i7 == u7.f25054c) {
                        u7 = u7.f25057f;
                        kotlin.jvm.internal.r.c(u7);
                        i7 = u7.f25053b;
                    }
                    if (i8 == u8.f25054c) {
                        u8 = u8.f25057f;
                        kotlin.jvm.internal.r.c(u8);
                        i8 = u8.f25053b;
                    }
                    j7 += jMin;
                }
                return true;
            }
        }
        return false;
    }

    @Override // w6.Z
    public a0 f() {
        return a0.f25070e;
    }

    @Override // w6.InterfaceC2794g
    public long h0() {
        return AbstractC2789b.g(readLong());
    }

    public int hashCode() {
        U u7 = this.f25095a;
        if (u7 == null) {
            return 0;
        }
        int i7 = 1;
        do {
            int i8 = u7.f25054c;
            for (int i9 = u7.f25053b; i9 < i8; i9++) {
                i7 = (i7 * 31) + u7.f25052a[i9];
            }
            u7 = u7.f25057f;
            kotlin.jvm.internal.r.c(u7);
        } while (u7 != this.f25095a);
        return i7;
    }

    public final void i() throws EOFException {
        skip(E0());
    }

    public boolean i0(long j7, C2795h bytes, int i7, int i8) {
        kotlin.jvm.internal.r.f(bytes, "bytes");
        if (j7 < 0 || i7 < 0 || i8 < 0 || E0() - j7 < i8 || bytes.H() - i7 < i8) {
            return false;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            if (T(((long) i9) + j7) != bytes.l(i7 + i9)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // w6.InterfaceC2794g
    public String k(long j7) {
        return B0(j7, C0796c.f6018b);
    }

    @Override // w6.InterfaceC2793f
    public long n(Z source) {
        kotlin.jvm.internal.r.f(source, "source");
        long j7 = 0;
        while (true) {
            long jZ = source.z(this, 8192L);
            if (jZ == -1) {
                return j7;
            }
            j7 += jZ;
        }
    }

    @Override // w6.InterfaceC2794g
    public C2795h o(long j7) throws EOFException {
        if (j7 < 0 || j7 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j7).toString());
        }
        if (E0() < j7) {
            throw new EOFException();
        }
        if (j7 < 4096) {
            return new C2795h(Y(j7));
        }
        C2795h c2795hG0 = G0((int) j7);
        skip(j7);
        return c2795hG0;
    }

    @Override // w6.InterfaceC2794g
    public void o0(long j7) throws EOFException {
        if (this.f25096b < j7) {
            throw new EOFException();
        }
    }

    @Override // w6.InterfaceC2793f
    public OutputStream r0() {
        return new c();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.r.f(sink, "sink");
        U u7 = this.f25095a;
        if (u7 == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), u7.f25054c - u7.f25053b);
        sink.put(u7.f25052a, u7.f25053b, iMin);
        int i7 = u7.f25053b + iMin;
        u7.f25053b = i7;
        this.f25096b -= (long) iMin;
        if (i7 == u7.f25054c) {
            this.f25095a = u7.b();
            V.b(u7);
        }
        return iMin;
    }

    @Override // w6.InterfaceC2794g
    public byte readByte() throws EOFException {
        if (E0() == 0) {
            throw new EOFException();
        }
        U u7 = this.f25095a;
        kotlin.jvm.internal.r.c(u7);
        int i7 = u7.f25053b;
        int i8 = u7.f25054c;
        int i9 = i7 + 1;
        byte b7 = u7.f25052a[i7];
        D0(E0() - 1);
        if (i9 == i8) {
            this.f25095a = u7.b();
            V.b(u7);
        } else {
            u7.f25053b = i9;
        }
        return b7;
    }

    @Override // w6.InterfaceC2794g
    public void readFully(byte[] sink) throws EOFException {
        kotlin.jvm.internal.r.f(sink, "sink");
        int i7 = 0;
        while (i7 < sink.length) {
            int i8 = read(sink, i7, sink.length - i7);
            if (i8 == -1) {
                throw new EOFException();
            }
            i7 += i8;
        }
    }

    @Override // w6.InterfaceC2794g
    public int readInt() throws EOFException {
        if (E0() < 4) {
            throw new EOFException();
        }
        U u7 = this.f25095a;
        kotlin.jvm.internal.r.c(u7);
        int i7 = u7.f25053b;
        int i8 = u7.f25054c;
        if (i8 - i7 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = u7.f25052a;
        int i9 = i7 + 3;
        int i10 = ((bArr[i7 + 1] & 255) << 16) | ((bArr[i7] & 255) << 24) | ((bArr[i7 + 2] & 255) << 8);
        int i11 = i7 + 4;
        int i12 = (bArr[i9] & 255) | i10;
        D0(E0() - 4);
        if (i11 == i8) {
            this.f25095a = u7.b();
            V.b(u7);
        } else {
            u7.f25053b = i11;
        }
        return i12;
    }

    @Override // w6.InterfaceC2794g
    public long readLong() throws EOFException {
        if (E0() < 8) {
            throw new EOFException();
        }
        U u7 = this.f25095a;
        kotlin.jvm.internal.r.c(u7);
        int i7 = u7.f25053b;
        int i8 = u7.f25054c;
        if (i8 - i7 < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = u7.f25052a;
        int i9 = i7 + 7;
        long j7 = ((((long) bArr[i7]) & 255) << 56) | ((((long) bArr[i7 + 1]) & 255) << 48) | ((((long) bArr[i7 + 2]) & 255) << 40) | ((((long) bArr[i7 + 3]) & 255) << 32) | ((((long) bArr[i7 + 4]) & 255) << 24) | ((((long) bArr[i7 + 5]) & 255) << 16) | ((((long) bArr[i7 + 6]) & 255) << 8);
        int i10 = i7 + 8;
        long j8 = j7 | (((long) bArr[i9]) & 255);
        D0(E0() - 8);
        if (i10 == i8) {
            this.f25095a = u7.b();
            V.b(u7);
        } else {
            u7.f25053b = i10;
        }
        return j8;
    }

    @Override // w6.InterfaceC2794g
    public short readShort() throws EOFException {
        if (E0() < 2) {
            throw new EOFException();
        }
        U u7 = this.f25095a;
        kotlin.jvm.internal.r.c(u7);
        int i7 = u7.f25053b;
        int i8 = u7.f25054c;
        if (i8 - i7 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = u7.f25052a;
        int i9 = i7 + 1;
        int i10 = (bArr[i7] & 255) << 8;
        int i11 = i7 + 2;
        int i12 = (bArr[i9] & 255) | i10;
        D0(E0() - 2);
        if (i11 == i8) {
            this.f25095a = u7.b();
            V.b(u7);
        } else {
            u7.f25053b = i11;
        }
        return (short) i12;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a7 A[EDGE_INSN: B:43:0x00a7->B:37:0x00a7 BREAK  A[LOOP:0: B:5:0x000d->B:45:?], SYNTHETIC] */
    @Override // w6.InterfaceC2794g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long s0() throws java.io.EOFException {
        /*
            r14 = this;
            long r0 = r14.E0()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lb1
            r0 = 0
            r1 = r0
            r4 = r2
        Ld:
            w6.U r6 = r14.f25095a
            kotlin.jvm.internal.r.c(r6)
            byte[] r7 = r6.f25052a
            int r8 = r6.f25053b
            int r9 = r6.f25054c
        L18:
            if (r8 >= r9) goto L93
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L27
            r11 = 57
            if (r10 > r11) goto L27
            int r11 = r10 + (-48)
            goto L3c
        L27:
            r11 = 97
            if (r10 < r11) goto L32
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L32
            int r11 = r10 + (-87)
            goto L3c
        L32:
            r11 = 65
            if (r10 < r11) goto L74
            r11 = 70
            if (r10 > r11) goto L74
            int r11 = r10 + (-55)
        L3c:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L4c
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L4c:
            w6.e r0 = new w6.e
            r0.<init>()
            w6.e r0 = r0.P(r4)
            w6.e r0 = r0.v(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.C0()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L74:
            if (r0 == 0) goto L78
            r1 = 1
            goto L93
        L78:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = w6.AbstractC2789b.i(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L93:
            if (r8 != r9) goto L9f
            w6.U r7 = r6.b()
            r14.f25095a = r7
            w6.V.b(r6)
            goto La1
        L9f:
            r6.f25053b = r8
        La1:
            if (r1 != 0) goto La7
            w6.U r6 = r14.f25095a
            if (r6 != 0) goto Ld
        La7:
            long r1 = r14.E0()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.D0(r1)
            return r4
        Lb1:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w6.C2792e.s0():long");
    }

    @Override // w6.InterfaceC2794g
    public void skip(long j7) throws EOFException {
        while (j7 > 0) {
            U u7 = this.f25095a;
            if (u7 == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j7, u7.f25054c - u7.f25053b);
            long j8 = iMin;
            D0(E0() - j8);
            j7 -= j8;
            int i7 = u7.f25053b + iMin;
            u7.f25053b = i7;
            if (i7 == u7.f25054c) {
                this.f25095a = u7.b();
                V.b(u7);
            }
        }
    }

    public String toString() {
        return F0().toString();
    }

    @Override // w6.InterfaceC2794g
    public boolean u() {
        return this.f25096b == 0;
    }

    @Override // w6.InterfaceC2794g
    public InputStream v0() {
        return new b();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        kotlin.jvm.internal.r.f(source, "source");
        int iRemaining = source.remaining();
        int i7 = iRemaining;
        while (i7 > 0) {
            U uH0 = H0(1);
            int iMin = Math.min(i7, 8192 - uH0.f25054c);
            source.get(uH0.f25052a, uH0.f25054c, iMin);
            i7 -= iMin;
            uH0.f25054c += iMin;
        }
        this.f25096b += (long) iRemaining;
        return iRemaining;
    }

    public final a y0(a unsafeCursor) {
        kotlin.jvm.internal.r.f(unsafeCursor, "unsafeCursor");
        return x6.a.a(this, unsafeCursor);
    }

    @Override // w6.Z
    public long z(C2792e sink, long j7) {
        kotlin.jvm.internal.r.f(sink, "sink");
        if (j7 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        if (E0() == 0) {
            return -1L;
        }
        if (j7 > E0()) {
            j7 = E0();
        }
        sink.L(this, j7);
        return j7;
    }

    public byte[] z0() {
        return Y(E0());
    }

    /* JADX INFO: renamed from: w6.e$b */
    public static final class b extends InputStream {
        public b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(C2792e.this.E0(), a.e.API_PRIORITY_OTHER);
        }

        @Override // java.io.InputStream
        public int read() {
            if (C2792e.this.E0() > 0) {
                return C2792e.this.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return C2792e.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] sink, int i7, int i8) {
            kotlin.jvm.internal.r.f(sink, "sink");
            return C2792e.this.read(sink, i7, i8);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    public int read(byte[] sink, int i7, int i8) {
        kotlin.jvm.internal.r.f(sink, "sink");
        AbstractC2789b.b(sink.length, i7, i8);
        U u7 = this.f25095a;
        if (u7 == null) {
            return -1;
        }
        int iMin = Math.min(i8, u7.f25054c - u7.f25053b);
        byte[] bArr = u7.f25052a;
        int i9 = u7.f25053b;
        AbstractC0551i.d(bArr, sink, i7, i9, i9 + iMin);
        u7.f25053b += iMin;
        D0(E0() - ((long) iMin));
        if (u7.f25053b == u7.f25054c) {
            this.f25095a = u7.b();
            V.b(u7);
        }
        return iMin;
    }

    @Override // w6.InterfaceC2793f
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public C2792e p() {
        return this;
    }

    @Override // w6.InterfaceC2793f
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public C2792e B() {
        return this;
    }

    @Override // w6.Z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // w6.InterfaceC2794g
    public C2792e d() {
        return this;
    }

    @Override // w6.InterfaceC2793f, w6.X, java.io.Flushable
    public void flush() {
    }

    @Override // w6.InterfaceC2794g
    public C2792e t() {
        return this;
    }
}
