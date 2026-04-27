package O3;

import X2.AbstractC0763j;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import r3.C1756c;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements f, e, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f3321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3322b;

    public static final class a implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f3323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public o f3324b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f3326d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f3325c = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3327e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3328f = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f3323a == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.f3323a = null;
            e(null);
            this.f3325c = -1L;
            this.f3326d = null;
            this.f3327e = -1;
            this.f3328f = -1;
        }

        public final void e(o oVar) {
            this.f3324b = oVar;
        }
    }

    public static final class b extends OutputStream {
        public b() {
        }

        public String toString() {
            return d.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i4) {
            d.this.s(i4);
        }

        @Override // java.io.OutputStream
        public void write(byte[] data, int i4, int i5) {
            kotlin.jvm.internal.r.f(data, "data");
            d.this.o0(data, i4, i5);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }
    }

    public final d A(d out, long j4, long j5) {
        kotlin.jvm.internal.r.f(out, "out");
        long j6 = j4;
        O3.b.b(i0(), j6, j5);
        if (j5 != 0) {
            out.h0(out.i0() + j5);
            o oVar = this.f3321a;
            while (true) {
                kotlin.jvm.internal.r.c(oVar);
                int i4 = oVar.f3349c;
                int i5 = oVar.f3348b;
                if (j6 < i4 - i5) {
                    break;
                }
                j6 -= (long) (i4 - i5);
                oVar = oVar.f3352f;
            }
            o oVar2 = oVar;
            long j7 = j5;
            while (j7 > 0) {
                kotlin.jvm.internal.r.c(oVar2);
                o oVarD = oVar2.d();
                int i6 = oVarD.f3348b + ((int) j6);
                oVarD.f3348b = i6;
                oVarD.f3349c = Math.min(i6 + ((int) j7), oVarD.f3349c);
                o oVar3 = out.f3321a;
                if (oVar3 == null) {
                    oVarD.f3353g = oVarD;
                    oVarD.f3352f = oVarD;
                    out.f3321a = oVarD;
                } else {
                    kotlin.jvm.internal.r.c(oVar3);
                    o oVar4 = oVar3.f3353g;
                    kotlin.jvm.internal.r.c(oVar4);
                    oVar4.c(oVarD);
                }
                j7 -= (long) (oVarD.f3349c - oVarD.f3348b);
                oVar2 = oVar2.f3352f;
                j6 = 0;
            }
        }
        return this;
    }

    public final byte E(long j4) {
        O3.b.b(i0(), j4, 1L);
        o oVar = this.f3321a;
        if (oVar == null) {
            kotlin.jvm.internal.r.c(null);
            throw null;
        }
        if (i0() - j4 < j4) {
            long jI0 = i0();
            while (jI0 > j4) {
                oVar = oVar.f3353g;
                kotlin.jvm.internal.r.c(oVar);
                jI0 -= (long) (oVar.f3349c - oVar.f3348b);
            }
            kotlin.jvm.internal.r.c(oVar);
            return oVar.f3347a[(int) ((((long) oVar.f3348b) + j4) - jI0)];
        }
        long j5 = 0;
        while (true) {
            long j6 = ((long) (oVar.f3349c - oVar.f3348b)) + j5;
            if (j6 > j4) {
                kotlin.jvm.internal.r.c(oVar);
                return oVar.f3347a[(int) ((((long) oVar.f3348b) + j4) - j5)];
            }
            oVar = oVar.f3352f;
            kotlin.jvm.internal.r.c(oVar);
            j5 = j6;
        }
    }

    public long G(byte b4, long j4, long j5) {
        o oVar;
        int i4;
        long jI0 = 0;
        if (0 > j4 || j4 > j5) {
            throw new IllegalArgumentException(("size=" + i0() + " fromIndex=" + j4 + " toIndex=" + j5).toString());
        }
        if (j5 > i0()) {
            j5 = i0();
        }
        if (j4 == j5 || (oVar = this.f3321a) == null) {
            return -1L;
        }
        if (i0() - j4 < j4) {
            jI0 = i0();
            while (jI0 > j4) {
                oVar = oVar.f3353g;
                kotlin.jvm.internal.r.c(oVar);
                jI0 -= (long) (oVar.f3349c - oVar.f3348b);
            }
            while (jI0 < j5) {
                byte[] bArr = oVar.f3347a;
                int iMin = (int) Math.min(oVar.f3349c, (((long) oVar.f3348b) + j5) - jI0);
                i4 = (int) ((((long) oVar.f3348b) + j4) - jI0);
                while (i4 < iMin) {
                    if (bArr[i4] != b4) {
                        i4++;
                    }
                }
                jI0 += (long) (oVar.f3349c - oVar.f3348b);
                oVar = oVar.f3352f;
                kotlin.jvm.internal.r.c(oVar);
                j4 = jI0;
            }
            return -1L;
        }
        while (true) {
            long j6 = ((long) (oVar.f3349c - oVar.f3348b)) + jI0;
            if (j6 > j4) {
                break;
            }
            oVar = oVar.f3352f;
            kotlin.jvm.internal.r.c(oVar);
            jI0 = j6;
        }
        while (jI0 < j5) {
            byte[] bArr2 = oVar.f3347a;
            int iMin2 = (int) Math.min(oVar.f3349c, (((long) oVar.f3348b) + j5) - jI0);
            i4 = (int) ((((long) oVar.f3348b) + j4) - jI0);
            while (i4 < iMin2) {
                if (bArr2[i4] != b4) {
                    i4++;
                }
            }
            jI0 += (long) (oVar.f3349c - oVar.f3348b);
            oVar = oVar.f3352f;
            kotlin.jvm.internal.r.c(oVar);
            j4 = jI0;
        }
        return -1L;
        return ((long) (i4 - oVar.f3348b)) + jI0;
    }

    public OutputStream J() {
        return new b();
    }

    public byte[] K() {
        return L(i0());
    }

    @Override // O3.f
    public byte[] L(long j4) throws EOFException {
        if (j4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j4).toString());
        }
        if (i0() < j4) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j4];
        S(bArr);
        return bArr;
    }

    public g P() {
        return j(i0());
    }

    public void S(byte[] sink) throws EOFException {
        kotlin.jvm.internal.r.f(sink, "sink");
        int i4 = 0;
        while (i4 < sink.length) {
            int i5 = read(sink, i4, sink.length - i4);
            if (i5 == -1) {
                throw new EOFException();
            }
            i4 += i5;
        }
    }

    @Override // O3.f
    public void Y(long j4) throws EOFException {
        if (this.f3322b < j4) {
            throw new EOFException();
        }
    }

    public String a0(long j4, Charset charset) throws EOFException {
        kotlin.jvm.internal.r.f(charset, "charset");
        if (j4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j4).toString());
        }
        if (this.f3322b < j4) {
            throw new EOFException();
        }
        if (j4 == 0) {
            return "";
        }
        o oVar = this.f3321a;
        kotlin.jvm.internal.r.c(oVar);
        int i4 = oVar.f3348b;
        if (((long) i4) + j4 > oVar.f3349c) {
            return new String(L(j4), charset);
        }
        int i5 = (int) j4;
        String str = new String(oVar.f3347a, i4, i5, charset);
        int i6 = oVar.f3348b + i5;
        oVar.f3348b = i6;
        this.f3322b -= j4;
        if (i6 == oVar.f3349c) {
            this.f3321a = oVar.b();
            p.b(oVar);
        }
        return str;
    }

    @Override // O3.r
    public void c0(d source, long j4) {
        o oVar;
        kotlin.jvm.internal.r.f(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        O3.b.b(source.i0(), 0L, j4);
        while (j4 > 0) {
            o oVar2 = source.f3321a;
            kotlin.jvm.internal.r.c(oVar2);
            int i4 = oVar2.f3349c;
            kotlin.jvm.internal.r.c(source.f3321a);
            if (j4 < i4 - r1.f3348b) {
                o oVar3 = this.f3321a;
                if (oVar3 != null) {
                    kotlin.jvm.internal.r.c(oVar3);
                    oVar = oVar3.f3353g;
                } else {
                    oVar = null;
                }
                if (oVar != null && oVar.f3351e) {
                    if ((((long) oVar.f3349c) + j4) - ((long) (oVar.f3350d ? 0 : oVar.f3348b)) <= 8192) {
                        o oVar4 = source.f3321a;
                        kotlin.jvm.internal.r.c(oVar4);
                        oVar4.f(oVar, (int) j4);
                        source.h0(source.i0() - j4);
                        h0(i0() + j4);
                        return;
                    }
                }
                o oVar5 = source.f3321a;
                kotlin.jvm.internal.r.c(oVar5);
                source.f3321a = oVar5.e((int) j4);
            }
            o oVar6 = source.f3321a;
            kotlin.jvm.internal.r.c(oVar6);
            long j5 = oVar6.f3349c - oVar6.f3348b;
            source.f3321a = oVar6.b();
            o oVar7 = this.f3321a;
            if (oVar7 == null) {
                this.f3321a = oVar6;
                oVar6.f3353g = oVar6;
                oVar6.f3352f = oVar6;
            } else {
                kotlin.jvm.internal.r.c(oVar7);
                o oVar8 = oVar7.f3353g;
                kotlin.jvm.internal.r.c(oVar8);
                oVar8.c(oVar6).a();
            }
            source.h0(source.i0() - j5);
            h0(i0() + j5);
            j4 -= j5;
        }
    }

    public String d0() {
        return a0(this.f3322b, C1756c.f14563b);
    }

    public String e0(long j4) {
        return a0(j4, C1756c.f14563b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (i0() != dVar.i0()) {
            return false;
        }
        if (i0() == 0) {
            return true;
        }
        o oVar = this.f3321a;
        kotlin.jvm.internal.r.c(oVar);
        o oVar2 = dVar.f3321a;
        kotlin.jvm.internal.r.c(oVar2);
        int i4 = oVar.f3348b;
        int i5 = oVar2.f3348b;
        long j4 = 0;
        while (j4 < i0()) {
            long jMin = Math.min(oVar.f3349c - i4, oVar2.f3349c - i5);
            long j5 = 0;
            while (j5 < jMin) {
                int i6 = i4 + 1;
                int i7 = i5 + 1;
                if (oVar.f3347a[i4] != oVar2.f3347a[i5]) {
                    return false;
                }
                j5++;
                i4 = i6;
                i5 = i7;
            }
            if (i4 == oVar.f3349c) {
                oVar = oVar.f3352f;
                kotlin.jvm.internal.r.c(oVar);
                i4 = oVar.f3348b;
            }
            if (i5 == oVar2.f3349c) {
                oVar2 = oVar2.f3352f;
                kotlin.jvm.internal.r.c(oVar2);
                i5 = oVar2.f3348b;
            }
            j4 += jMin;
        }
        return true;
    }

    public final void f() throws EOFException {
        skip(i0());
    }

    public String f0() {
        return g0(Long.MAX_VALUE);
    }

    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public d clone() {
        return x();
    }

    public String g0(long j4) throws EOFException {
        if (j4 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j4).toString());
        }
        long j5 = j4 != Long.MAX_VALUE ? j4 + 1 : Long.MAX_VALUE;
        long jG = G((byte) 10, 0L, j5);
        if (jG != -1) {
            return P3.a.b(this, jG);
        }
        if (j5 < i0() && E(j5 - 1) == 13 && E(j5) == 10) {
            return P3.a.b(this, j5);
        }
        d dVar = new d();
        A(dVar, 0L, Math.min(32, i0()));
        throw new EOFException("\\n not found: limit=" + Math.min(i0(), j4) + " content=" + dVar.P().n() + (char) 8230);
    }

    public final void h0(long j4) {
        this.f3322b = j4;
    }

    public int hashCode() {
        o oVar = this.f3321a;
        if (oVar == null) {
            return 0;
        }
        int i4 = 1;
        do {
            int i5 = oVar.f3349c;
            for (int i6 = oVar.f3348b; i6 < i5; i6++) {
                i4 = (i4 * 31) + oVar.f3347a[i6];
            }
            oVar = oVar.f3352f;
            kotlin.jvm.internal.r.c(oVar);
        } while (oVar != this.f3321a);
        return i4;
    }

    public final long i0() {
        return this.f3322b;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // O3.f
    public g j(long j4) throws EOFException {
        if (j4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j4).toString());
        }
        if (i0() < j4) {
            throw new EOFException();
        }
        if (j4 < 4096) {
            return new g(L(j4));
        }
        g gVarK0 = k0((int) j4);
        skip(j4);
        return gVarK0;
    }

    public final g j0() {
        if (i0() <= 2147483647L) {
            return k0((int) i0());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + i0()).toString());
    }

    public final g k0(int i4) {
        if (i4 == 0) {
            return g.f3331e;
        }
        O3.b.b(i0(), 0L, i4);
        o oVar = this.f3321a;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            kotlin.jvm.internal.r.c(oVar);
            int i8 = oVar.f3349c;
            int i9 = oVar.f3348b;
            if (i8 == i9) {
                throw new AssertionError("s.limit == s.pos");
            }
            i6 += i8 - i9;
            i7++;
            oVar = oVar.f3352f;
        }
        byte[][] bArr = new byte[i7][];
        int[] iArr = new int[i7 * 2];
        o oVar2 = this.f3321a;
        int i10 = 0;
        while (i5 < i4) {
            kotlin.jvm.internal.r.c(oVar2);
            bArr[i10] = oVar2.f3347a;
            i5 += oVar2.f3349c - oVar2.f3348b;
            iArr[i10] = Math.min(i5, i4);
            iArr[i10 + i7] = oVar2.f3348b;
            oVar2.f3350d = true;
            i10++;
            oVar2 = oVar2.f3352f;
        }
        return new q(bArr, iArr);
    }

    public final o l0(int i4) {
        if (i4 < 1 || i4 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        o oVar = this.f3321a;
        if (oVar != null) {
            kotlin.jvm.internal.r.c(oVar);
            o oVar2 = oVar.f3353g;
            kotlin.jvm.internal.r.c(oVar2);
            return (oVar2.f3349c + i4 > 8192 || !oVar2.f3351e) ? oVar2.c(p.c()) : oVar2;
        }
        o oVarC = p.c();
        this.f3321a = oVarC;
        oVarC.f3353g = oVarC;
        oVarC.f3352f = oVarC;
        return oVarC;
    }

    public d m0(g byteString) {
        kotlin.jvm.internal.r.f(byteString, "byteString");
        byteString.A(this, 0, byteString.v());
        return this;
    }

    @Override // O3.e
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public d M(byte[] source) {
        kotlin.jvm.internal.r.f(source, "source");
        return o0(source, 0, source.length);
    }

    public d o0(byte[] source, int i4, int i5) {
        kotlin.jvm.internal.r.f(source, "source");
        long j4 = i5;
        O3.b.b(source.length, i4, j4);
        int i6 = i5 + i4;
        while (i4 < i6) {
            o oVarL0 = l0(1);
            int iMin = Math.min(i6 - i4, 8192 - oVarL0.f3349c);
            int i7 = i4 + iMin;
            AbstractC0763j.d(source, oVarL0.f3347a, oVarL0.f3349c, i4, i7);
            oVarL0.f3349c += iMin;
            i4 = i7;
        }
        h0(i0() + j4);
        return this;
    }

    public final long p() {
        long jI0 = i0();
        if (jI0 == 0) {
            return 0L;
        }
        o oVar = this.f3321a;
        kotlin.jvm.internal.r.c(oVar);
        o oVar2 = oVar.f3353g;
        kotlin.jvm.internal.r.c(oVar2);
        int i4 = oVar2.f3349c;
        return (i4 >= 8192 || !oVar2.f3351e) ? jI0 : jI0 - ((long) (i4 - oVar2.f3348b));
    }

    @Override // O3.e
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public d s(int i4) {
        o oVarL0 = l0(1);
        byte[] bArr = oVarL0.f3347a;
        int i5 = oVarL0.f3349c;
        oVarL0.f3349c = i5 + 1;
        bArr[i5] = (byte) i4;
        h0(i0() + 1);
        return this;
    }

    public d q0(long j4) {
        if (j4 == 0) {
            return s(48);
        }
        long j5 = (j4 >>> 1) | j4;
        long j6 = j5 | (j5 >>> 2);
        long j7 = j6 | (j6 >>> 4);
        long j8 = j7 | (j7 >>> 8);
        long j9 = j8 | (j8 >>> 16);
        long j10 = j9 | (j9 >>> 32);
        long j11 = j10 - ((j10 >>> 1) & 6148914691236517205L);
        long j12 = ((j11 >>> 2) & 3689348814741910323L) + (j11 & 3689348814741910323L);
        long j13 = ((j12 >>> 4) + j12) & 1085102592571150095L;
        long j14 = j13 + (j13 >>> 8);
        long j15 = j14 + (j14 >>> 16);
        int i4 = (int) ((((j15 & 63) + ((j15 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        o oVarL0 = l0(i4);
        byte[] bArr = oVarL0.f3347a;
        int i5 = oVarL0.f3349c;
        for (int i6 = (i5 + i4) - 1; i6 >= i5; i6--) {
            bArr[i6] = P3.a.a()[(int) (15 & j4)];
            j4 >>>= 4;
        }
        oVarL0.f3349c += i4;
        h0(i0() + ((long) i4));
        return this;
    }

    @Override // O3.f
    public boolean r() {
        return this.f3322b == 0;
    }

    @Override // O3.e
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public d m(int i4) {
        o oVarL0 = l0(4);
        byte[] bArr = oVarL0.f3347a;
        int i5 = oVarL0.f3349c;
        bArr[i5] = (byte) ((i4 >>> 24) & 255);
        bArr[i5 + 1] = (byte) ((i4 >>> 16) & 255);
        bArr[i5 + 2] = (byte) ((i4 >>> 8) & 255);
        bArr[i5 + 3] = (byte) (i4 & 255);
        oVarL0.f3349c = i5 + 4;
        h0(i0() + 4);
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.r.f(sink, "sink");
        o oVar = this.f3321a;
        if (oVar == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), oVar.f3349c - oVar.f3348b);
        sink.put(oVar.f3347a, oVar.f3348b, iMin);
        int i4 = oVar.f3348b + iMin;
        oVar.f3348b = i4;
        this.f3322b -= (long) iMin;
        if (i4 == oVar.f3349c) {
            this.f3321a = oVar.b();
            p.b(oVar);
        }
        return iMin;
    }

    @Override // O3.f
    public byte readByte() throws EOFException {
        if (i0() == 0) {
            throw new EOFException();
        }
        o oVar = this.f3321a;
        kotlin.jvm.internal.r.c(oVar);
        int i4 = oVar.f3348b;
        int i5 = oVar.f3349c;
        int i6 = i4 + 1;
        byte b4 = oVar.f3347a[i4];
        h0(i0() - 1);
        if (i6 != i5) {
            oVar.f3348b = i6;
            return b4;
        }
        this.f3321a = oVar.b();
        p.b(oVar);
        return b4;
    }

    @Override // O3.f
    public int readInt() throws EOFException {
        if (i0() < 4) {
            throw new EOFException();
        }
        o oVar = this.f3321a;
        kotlin.jvm.internal.r.c(oVar);
        int i4 = oVar.f3348b;
        int i5 = oVar.f3349c;
        if (i5 - i4 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = oVar.f3347a;
        int i6 = i4 + 3;
        int i7 = ((bArr[i4 + 1] & 255) << 16) | ((bArr[i4] & 255) << 24) | ((bArr[i4 + 2] & 255) << 8);
        int i8 = i4 + 4;
        int i9 = (bArr[i6] & 255) | i7;
        h0(i0() - 4);
        if (i8 != i5) {
            oVar.f3348b = i8;
            return i9;
        }
        this.f3321a = oVar.b();
        p.b(oVar);
        return i9;
    }

    @Override // O3.f
    public short readShort() throws EOFException {
        if (i0() < 2) {
            throw new EOFException();
        }
        o oVar = this.f3321a;
        kotlin.jvm.internal.r.c(oVar);
        int i4 = oVar.f3348b;
        int i5 = oVar.f3349c;
        if (i5 - i4 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = oVar.f3347a;
        int i6 = i4 + 1;
        int i7 = (bArr[i4] & 255) << 8;
        int i8 = i4 + 2;
        int i9 = (bArr[i6] & 255) | i7;
        h0(i0() - 2);
        if (i8 == i5) {
            this.f3321a = oVar.b();
            p.b(oVar);
        } else {
            oVar.f3348b = i8;
        }
        return (short) i9;
    }

    @Override // O3.e
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public d l(int i4) {
        o oVarL0 = l0(2);
        byte[] bArr = oVarL0.f3347a;
        int i5 = oVarL0.f3349c;
        bArr[i5] = (byte) ((i4 >>> 8) & 255);
        bArr[i5 + 1] = (byte) (i4 & 255);
        oVarL0.f3349c = i5 + 2;
        h0(i0() + 2);
        return this;
    }

    @Override // O3.f
    public void skip(long j4) throws EOFException {
        while (j4 > 0) {
            o oVar = this.f3321a;
            if (oVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j4, oVar.f3349c - oVar.f3348b);
            long j5 = iMin;
            h0(i0() - j5);
            j4 -= j5;
            int i4 = oVar.f3348b + iMin;
            oVar.f3348b = i4;
            if (i4 == oVar.f3349c) {
                this.f3321a = oVar.b();
                p.b(oVar);
            }
        }
    }

    public final d t0(OutputStream out, long j4) throws IOException {
        kotlin.jvm.internal.r.f(out, "out");
        O3.b.b(this.f3322b, 0L, j4);
        o oVar = this.f3321a;
        long j5 = j4;
        while (j5 > 0) {
            kotlin.jvm.internal.r.c(oVar);
            int iMin = (int) Math.min(j5, oVar.f3349c - oVar.f3348b);
            out.write(oVar.f3347a, oVar.f3348b, iMin);
            int i4 = oVar.f3348b + iMin;
            oVar.f3348b = i4;
            long j6 = iMin;
            this.f3322b -= j6;
            j5 -= j6;
            if (i4 == oVar.f3349c) {
                o oVarB = oVar.b();
                this.f3321a = oVarB;
                p.b(oVar);
                oVar = oVarB;
            }
        }
        return this;
    }

    public String toString() {
        return j0().toString();
    }

    @Override // O3.e
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public d y(String string) {
        kotlin.jvm.internal.r.f(string, "string");
        return v0(string, 0, string.length());
    }

    @Override // O3.t
    public long v(d sink, long j4) {
        kotlin.jvm.internal.r.f(sink, "sink");
        if (j4 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        }
        if (i0() == 0) {
            return -1L;
        }
        if (j4 > i0()) {
            j4 = i0();
        }
        sink.c0(this, j4);
        return j4;
    }

    public d v0(String string, int i4, int i5) {
        char cCharAt;
        kotlin.jvm.internal.r.f(string, "string");
        if (i4 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i4).toString());
        }
        if (i5 < i4) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i5 + " < " + i4).toString());
        }
        if (i5 > string.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i5 + " > " + string.length()).toString());
        }
        while (i4 < i5) {
            char cCharAt2 = string.charAt(i4);
            if (cCharAt2 < 128) {
                o oVarL0 = l0(1);
                byte[] bArr = oVarL0.f3347a;
                int i6 = oVarL0.f3349c - i4;
                int iMin = Math.min(i5, 8192 - i6);
                int i7 = i4 + 1;
                bArr[i4 + i6] = (byte) cCharAt2;
                while (true) {
                    i4 = i7;
                    if (i4 >= iMin || (cCharAt = string.charAt(i4)) >= 128) {
                        break;
                    }
                    i7 = i4 + 1;
                    bArr[i4 + i6] = (byte) cCharAt;
                }
                int i8 = oVarL0.f3349c;
                int i9 = (i6 + i4) - i8;
                oVarL0.f3349c = i8 + i9;
                h0(i0() + ((long) i9));
            } else {
                if (cCharAt2 < 2048) {
                    o oVarL02 = l0(2);
                    byte[] bArr2 = oVarL02.f3347a;
                    int i10 = oVarL02.f3349c;
                    bArr2[i10] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i10 + 1] = (byte) ((cCharAt2 & '?') | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                    oVarL02.f3349c = i10 + 2;
                    h0(i0() + 2);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    o oVarL03 = l0(3);
                    byte[] bArr3 = oVarL03.f3347a;
                    int i11 = oVarL03.f3349c;
                    bArr3[i11] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i11 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                    bArr3[i11 + 2] = (byte) ((cCharAt2 & '?') | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                    oVarL03.f3349c = i11 + 3;
                    h0(i0() + 3);
                } else {
                    int i12 = i4 + 1;
                    char cCharAt3 = i12 < i5 ? string.charAt(i12) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        s(63);
                        i4 = i12;
                    } else {
                        int i13 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        o oVarL04 = l0(4);
                        byte[] bArr4 = oVarL04.f3347a;
                        int i14 = oVarL04.f3349c;
                        bArr4[i14] = (byte) ((i13 >> 18) | 240);
                        bArr4[i14 + 1] = (byte) (((i13 >> 12) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                        bArr4[i14 + 2] = (byte) (((i13 >> 6) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                        bArr4[i14 + 3] = (byte) ((i13 & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                        oVarL04.f3349c = i14 + 4;
                        h0(i0() + 4);
                        i4 += 2;
                    }
                }
                i4++;
            }
        }
        return this;
    }

    public d w0(int i4) {
        if (i4 < 128) {
            s(i4);
            return this;
        }
        if (i4 < 2048) {
            o oVarL0 = l0(2);
            byte[] bArr = oVarL0.f3347a;
            int i5 = oVarL0.f3349c;
            bArr[i5] = (byte) ((i4 >> 6) | 192);
            bArr[i5 + 1] = (byte) ((i4 & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
            oVarL0.f3349c = i5 + 2;
            h0(i0() + 2);
            return this;
        }
        if (55296 <= i4 && i4 < 57344) {
            s(63);
            return this;
        }
        if (i4 < 65536) {
            o oVarL02 = l0(3);
            byte[] bArr2 = oVarL02.f3347a;
            int i6 = oVarL02.f3349c;
            bArr2[i6] = (byte) ((i4 >> 12) | 224);
            bArr2[i6 + 1] = (byte) (((i4 >> 6) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
            bArr2[i6 + 2] = (byte) ((i4 & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
            oVarL02.f3349c = i6 + 3;
            h0(i0() + 3);
            return this;
        }
        if (i4 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x" + O3.b.d(i4));
        }
        o oVarL03 = l0(4);
        byte[] bArr3 = oVarL03.f3347a;
        int i7 = oVarL03.f3349c;
        bArr3[i7] = (byte) ((i4 >> 18) | 240);
        bArr3[i7 + 1] = (byte) (((i4 >> 12) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
        bArr3[i7 + 2] = (byte) (((i4 >> 6) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
        bArr3[i7 + 3] = (byte) ((i4 & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
        oVarL03.f3349c = i7 + 4;
        h0(i0() + 4);
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        kotlin.jvm.internal.r.f(source, "source");
        int iRemaining = source.remaining();
        int i4 = iRemaining;
        while (i4 > 0) {
            o oVarL0 = l0(1);
            int iMin = Math.min(i4, 8192 - oVarL0.f3349c);
            source.get(oVarL0.f3347a, oVarL0.f3349c, iMin);
            i4 -= iMin;
            oVarL0.f3349c += iMin;
        }
        this.f3322b += (long) iRemaining;
        return iRemaining;
    }

    public final d x() {
        d dVar = new d();
        if (i0() == 0) {
            return dVar;
        }
        o oVar = this.f3321a;
        kotlin.jvm.internal.r.c(oVar);
        o oVarD = oVar.d();
        dVar.f3321a = oVarD;
        oVarD.f3353g = oVarD;
        oVarD.f3352f = oVarD;
        for (o oVar2 = oVar.f3352f; oVar2 != oVar; oVar2 = oVar2.f3352f) {
            o oVar3 = oVarD.f3353g;
            kotlin.jvm.internal.r.c(oVar3);
            kotlin.jvm.internal.r.c(oVar2);
            oVar3.c(oVar2.d());
        }
        dVar.h0(i0());
        return dVar;
    }

    public int read(byte[] sink, int i4, int i5) {
        kotlin.jvm.internal.r.f(sink, "sink");
        O3.b.b(sink.length, i4, i5);
        o oVar = this.f3321a;
        if (oVar == null) {
            return -1;
        }
        int iMin = Math.min(i5, oVar.f3349c - oVar.f3348b);
        byte[] bArr = oVar.f3347a;
        int i6 = oVar.f3348b;
        AbstractC0763j.d(bArr, sink, i4, i6, i6 + iMin);
        oVar.f3348b += iMin;
        h0(i0() - ((long) iMin));
        if (oVar.f3348b == oVar.f3349c) {
            this.f3321a = oVar.b();
            p.b(oVar);
        }
        return iMin;
    }

    @Override // O3.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public d e() {
        return this;
    }

    @Override // O3.e, O3.r, java.io.Flushable
    public void flush() {
    }

    @Override // O3.f
    public d q() {
        return this;
    }
}
