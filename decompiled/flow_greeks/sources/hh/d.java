package hh;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements f, e, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f11469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f11470b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f11471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public o f11472b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f11474d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f11473c = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11475e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11476f = -1;

        public final void b(o oVar) {
            this.f11472b = oVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f11471a == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.f11471a = null;
            b(null);
            this.f11473c = -1L;
            this.f11474d = null;
            this.f11475e = -1;
            this.f11476f = -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends OutputStream {
        public b() {
        }

        public String toString() {
            return d.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            d.this.writeByte(i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] data, int i10, int i11) {
            kotlin.jvm.internal.t.f(data, "data");
            d.this.l0(data, i10, i11);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }
    }

    @Override // hh.t
    public long B(d sink, long j10) {
        kotlin.jvm.internal.t.f(sink, "sink");
        if (j10 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j10 > size()) {
            j10 = size();
        }
        sink.L(this, j10);
        return j10;
    }

    public final long C() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        o oVar = this.f11469a;
        kotlin.jvm.internal.t.c(oVar);
        o oVar2 = oVar.f11501g;
        kotlin.jvm.internal.t.c(oVar2);
        int i10 = oVar2.f11497c;
        return (i10 >= 8192 || !oVar2.f11499e) ? size : size - ((long) (i10 - oVar2.f11496b));
    }

    public final d E() {
        d dVar = new d();
        if (size() == 0) {
            return dVar;
        }
        o oVar = this.f11469a;
        kotlin.jvm.internal.t.c(oVar);
        o oVarD = oVar.d();
        dVar.f11469a = oVarD;
        oVarD.f11501g = oVarD;
        oVarD.f11500f = oVarD;
        for (o oVar2 = oVar.f11500f; oVar2 != oVar; oVar2 = oVar2.f11500f) {
            o oVar3 = oVarD.f11501g;
            kotlin.jvm.internal.t.c(oVar3);
            kotlin.jvm.internal.t.c(oVar2);
            oVar3.c(oVar2.d());
        }
        dVar.f0(size());
        return dVar;
    }

    public final d G(d out, long j10, long j11) {
        kotlin.jvm.internal.t.f(out, "out");
        long j12 = j10;
        hh.b.b(size(), j12, j11);
        if (j11 != 0) {
            out.f0(out.size() + j11);
            o oVar = this.f11469a;
            while (true) {
                kotlin.jvm.internal.t.c(oVar);
                int i10 = oVar.f11497c;
                int i11 = oVar.f11496b;
                if (j12 < i10 - i11) {
                    break;
                }
                j12 -= (long) (i10 - i11);
                oVar = oVar.f11500f;
            }
            o oVar2 = oVar;
            long j13 = j11;
            while (j13 > 0) {
                kotlin.jvm.internal.t.c(oVar2);
                o oVarD = oVar2.d();
                int i12 = oVarD.f11496b + ((int) j12);
                oVarD.f11496b = i12;
                oVarD.f11497c = Math.min(i12 + ((int) j13), oVarD.f11497c);
                o oVar3 = out.f11469a;
                if (oVar3 == null) {
                    oVarD.f11501g = oVarD;
                    oVarD.f11500f = oVarD;
                    out.f11469a = oVarD;
                } else {
                    kotlin.jvm.internal.t.c(oVar3);
                    o oVar4 = oVar3.f11501g;
                    kotlin.jvm.internal.t.c(oVar4);
                    oVar4.c(oVarD);
                }
                j13 -= (long) (oVarD.f11497c - oVarD.f11496b);
                oVar2 = oVar2.f11500f;
                j12 = 0;
            }
        }
        return this;
    }

    public final byte H(long j10) {
        hh.b.b(size(), j10, 1L);
        o oVar = this.f11469a;
        if (oVar == null) {
            kotlin.jvm.internal.t.c(null);
            throw null;
        }
        if (size() - j10 < j10) {
            long size = size();
            while (size > j10) {
                oVar = oVar.f11501g;
                kotlin.jvm.internal.t.c(oVar);
                size -= (long) (oVar.f11497c - oVar.f11496b);
            }
            kotlin.jvm.internal.t.c(oVar);
            return oVar.f11495a[(int) ((((long) oVar.f11496b) + j10) - size)];
        }
        long j11 = 0;
        while (true) {
            long j12 = ((long) (oVar.f11497c - oVar.f11496b)) + j11;
            if (j12 > j10) {
                kotlin.jvm.internal.t.c(oVar);
                return oVar.f11495a[(int) ((((long) oVar.f11496b) + j10) - j11)];
            }
            oVar = oVar.f11500f;
            kotlin.jvm.internal.t.c(oVar);
            j11 = j12;
        }
    }

    @Override // hh.f
    public byte[] J(long j10) throws EOFException {
        if (j10 < 0 || j10 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (size() < j10) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j10];
        Z(bArr);
        return bArr;
    }

    public long K(byte b10, long j10, long j11) {
        o oVar;
        int i10;
        long size = 0;
        if (0 > j10 || j10 > j11) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        if (j11 > size()) {
            j11 = size();
        }
        if (j10 == j11 || (oVar = this.f11469a) == null) {
            return -1L;
        }
        if (size() - j10 < j10) {
            size = size();
            while (size > j10) {
                oVar = oVar.f11501g;
                kotlin.jvm.internal.t.c(oVar);
                size -= (long) (oVar.f11497c - oVar.f11496b);
            }
            while (size < j11) {
                byte[] bArr = oVar.f11495a;
                int iMin = (int) Math.min(oVar.f11497c, (((long) oVar.f11496b) + j11) - size);
                i10 = (int) ((((long) oVar.f11496b) + j10) - size);
                while (i10 < iMin) {
                    if (bArr[i10] != b10) {
                        i10++;
                    }
                }
                size += (long) (oVar.f11497c - oVar.f11496b);
                oVar = oVar.f11500f;
                kotlin.jvm.internal.t.c(oVar);
                j10 = size;
            }
            return -1L;
        }
        while (true) {
            long j12 = ((long) (oVar.f11497c - oVar.f11496b)) + size;
            if (j12 > j10) {
                break;
            }
            oVar = oVar.f11500f;
            kotlin.jvm.internal.t.c(oVar);
            size = j12;
        }
        while (size < j11) {
            byte[] bArr2 = oVar.f11495a;
            int iMin2 = (int) Math.min(oVar.f11497c, (((long) oVar.f11496b) + j11) - size);
            i10 = (int) ((((long) oVar.f11496b) + j10) - size);
            while (i10 < iMin2) {
                if (bArr2[i10] != b10) {
                    i10++;
                }
            }
            size += (long) (oVar.f11497c - oVar.f11496b);
            oVar = oVar.f11500f;
            kotlin.jvm.internal.t.c(oVar);
            j10 = size;
        }
        return -1L;
        return ((long) (i10 - oVar.f11496b)) + size;
    }

    @Override // hh.r
    public void L(d source, long j10) {
        o oVar;
        kotlin.jvm.internal.t.f(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        hh.b.b(source.size(), 0L, j10);
        while (j10 > 0) {
            o oVar2 = source.f11469a;
            kotlin.jvm.internal.t.c(oVar2);
            int i10 = oVar2.f11497c;
            kotlin.jvm.internal.t.c(source.f11469a);
            if (j10 < i10 - r1.f11496b) {
                o oVar3 = this.f11469a;
                if (oVar3 != null) {
                    kotlin.jvm.internal.t.c(oVar3);
                    oVar = oVar3.f11501g;
                } else {
                    oVar = null;
                }
                if (oVar != null && oVar.f11499e) {
                    if ((((long) oVar.f11497c) + j10) - ((long) (oVar.f11498d ? 0 : oVar.f11496b)) <= 8192) {
                        o oVar4 = source.f11469a;
                        kotlin.jvm.internal.t.c(oVar4);
                        oVar4.f(oVar, (int) j10);
                        source.f0(source.size() - j10);
                        f0(size() + j10);
                        return;
                    }
                }
                o oVar5 = source.f11469a;
                kotlin.jvm.internal.t.c(oVar5);
                source.f11469a = oVar5.e((int) j10);
            }
            o oVar6 = source.f11469a;
            kotlin.jvm.internal.t.c(oVar6);
            long j11 = oVar6.f11497c - oVar6.f11496b;
            source.f11469a = oVar6.b();
            o oVar7 = this.f11469a;
            if (oVar7 == null) {
                this.f11469a = oVar6;
                oVar6.f11501g = oVar6;
                oVar6.f11500f = oVar6;
            } else {
                kotlin.jvm.internal.t.c(oVar7);
                o oVar8 = oVar7.f11501g;
                kotlin.jvm.internal.t.c(oVar8);
                oVar8.c(oVar6).a();
            }
            source.f0(source.size() - j11);
            f0(size() + j11);
            j10 -= j11;
        }
    }

    public OutputStream N() {
        return new b();
    }

    public byte[] O() {
        return J(size());
    }

    public g R() {
        return k(size());
    }

    @Override // hh.f
    public void V(long j10) throws EOFException {
        if (this.f11470b < j10) {
            throw new EOFException();
        }
    }

    public void Z(byte[] sink) throws EOFException {
        kotlin.jvm.internal.t.f(sink, "sink");
        int i10 = 0;
        while (i10 < sink.length) {
            int i11 = read(sink, i10, sink.length - i10);
            if (i11 == -1) {
                throw new EOFException();
            }
            i10 += i11;
        }
    }

    public String a0(long j10, Charset charset) throws EOFException {
        kotlin.jvm.internal.t.f(charset, "charset");
        if (j10 < 0 || j10 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (this.f11470b < j10) {
            throw new EOFException();
        }
        if (j10 == 0) {
            return "";
        }
        o oVar = this.f11469a;
        kotlin.jvm.internal.t.c(oVar);
        int i10 = oVar.f11496b;
        if (((long) i10) + j10 > oVar.f11497c) {
            return new String(J(j10), charset);
        }
        int i11 = (int) j10;
        String str = new String(oVar.f11495a, i10, i11, charset);
        int i12 = oVar.f11496b + i11;
        oVar.f11496b = i12;
        this.f11470b -= j10;
        if (i12 == oVar.f11497c) {
            this.f11469a = oVar.b();
            p.b(oVar);
        }
        return str;
    }

    public String b0() {
        return a0(this.f11470b, kg.c.f14857b);
    }

    public final void c() throws EOFException {
        skip(size());
    }

    public String c0(long j10) {
        return a0(j10, kg.c.f14857b);
    }

    public String d0() {
        return e0(Long.MAX_VALUE);
    }

    public String e0(long j10) throws EOFException {
        if (j10 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j10).toString());
        }
        long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
        long jK = K((byte) 10, 0L, j11);
        if (jK != -1) {
            return ih.a.b(this, jK);
        }
        if (j11 < size() && H(j11 - 1) == 13 && H(j11) == 10) {
            return ih.a.b(this, j11);
        }
        d dVar = new d();
        G(dVar, 0L, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j10) + " content=" + dVar.R().o() + (char) 8230);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (size() != dVar.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        o oVar = this.f11469a;
        kotlin.jvm.internal.t.c(oVar);
        o oVar2 = dVar.f11469a;
        kotlin.jvm.internal.t.c(oVar2);
        int i10 = oVar.f11496b;
        int i11 = oVar2.f11496b;
        long j10 = 0;
        while (j10 < size()) {
            long jMin = Math.min(oVar.f11497c - i10, oVar2.f11497c - i11);
            long j11 = 0;
            while (j11 < jMin) {
                int i12 = i10 + 1;
                int i13 = i11 + 1;
                if (oVar.f11495a[i10] != oVar2.f11495a[i11]) {
                    return false;
                }
                j11++;
                i10 = i12;
                i11 = i13;
            }
            if (i10 == oVar.f11497c) {
                oVar = oVar.f11500f;
                kotlin.jvm.internal.t.c(oVar);
                i10 = oVar.f11496b;
            }
            if (i11 == oVar2.f11497c) {
                oVar2 = oVar2.f11500f;
                kotlin.jvm.internal.t.c(oVar2);
                i11 = oVar2.f11496b;
            }
            j10 += jMin;
        }
        return true;
    }

    public final void f0(long j10) {
        this.f11470b = j10;
    }

    public final g g0() {
        if (size() <= 2147483647L) {
            return h0((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    public final g h0(int i10) {
        if (i10 == 0) {
            return g.f11479e;
        }
        hh.b.b(size(), 0L, i10);
        o oVar = this.f11469a;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            kotlin.jvm.internal.t.c(oVar);
            int i14 = oVar.f11497c;
            int i15 = oVar.f11496b;
            if (i14 == i15) {
                throw new AssertionError("s.limit == s.pos");
            }
            i12 += i14 - i15;
            i13++;
            oVar = oVar.f11500f;
        }
        byte[][] bArr = new byte[i13][];
        int[] iArr = new int[i13 * 2];
        o oVar2 = this.f11469a;
        int i16 = 0;
        while (i11 < i10) {
            kotlin.jvm.internal.t.c(oVar2);
            bArr[i16] = oVar2.f11495a;
            i11 += oVar2.f11497c - oVar2.f11496b;
            iArr[i16] = Math.min(i11, i10);
            iArr[i16 + i13] = oVar2.f11496b;
            oVar2.f11498d = true;
            i16++;
            oVar2 = oVar2.f11500f;
        }
        return new q(bArr, iArr);
    }

    public int hashCode() {
        o oVar = this.f11469a;
        if (oVar == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = oVar.f11497c;
            for (int i12 = oVar.f11496b; i12 < i11; i12++) {
                i10 = (i10 * 31) + oVar.f11495a[i12];
            }
            oVar = oVar.f11500f;
            kotlin.jvm.internal.t.c(oVar);
        } while (oVar != this.f11469a);
        return i10;
    }

    public final o i0(int i10) {
        if (i10 < 1 || i10 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        o oVar = this.f11469a;
        if (oVar != null) {
            kotlin.jvm.internal.t.c(oVar);
            o oVar2 = oVar.f11501g;
            kotlin.jvm.internal.t.c(oVar2);
            return (oVar2.f11497c + i10 > 8192 || !oVar2.f11499e) ? oVar2.c(p.c()) : oVar2;
        }
        o oVarC = p.c();
        this.f11469a = oVarC;
        oVarC.f11501g = oVarC;
        oVarC.f11500f = oVarC;
        return oVarC;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public d j0(g byteString) {
        kotlin.jvm.internal.t.f(byteString, "byteString");
        byteString.L(this, 0, byteString.B());
        return this;
    }

    @Override // hh.f
    public g k(long j10) throws EOFException {
        if (j10 < 0 || j10 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (size() < j10) {
            throw new EOFException();
        }
        if (j10 < 4096) {
            return new g(J(j10));
        }
        g gVarH0 = h0((int) j10);
        skip(j10);
        return gVarH0;
    }

    @Override // hh.e
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public d write(byte[] source) {
        kotlin.jvm.internal.t.f(source, "source");
        return l0(source, 0, source.length);
    }

    public d l0(byte[] source, int i10, int i11) {
        kotlin.jvm.internal.t.f(source, "source");
        long j10 = i11;
        hh.b.b(source.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            o oVarI0 = i0(1);
            int iMin = Math.min(i12 - i10, 8192 - oVarI0.f11497c);
            int i13 = i10 + iMin;
            dd.l.e(source, oVarI0.f11495a, oVarI0.f11497c, i10, i13);
            oVarI0.f11497c += iMin;
            i10 = i13;
        }
        f0(size() + j10);
        return this;
    }

    @Override // hh.e
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public d writeByte(int i10) {
        o oVarI0 = i0(1);
        byte[] bArr = oVarI0.f11495a;
        int i11 = oVarI0.f11497c;
        oVarI0.f11497c = i11 + 1;
        bArr[i11] = (byte) i10;
        f0(size() + 1);
        return this;
    }

    public d n0(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        long j11 = (j10 >>> 1) | j10;
        long j12 = j11 | (j11 >>> 2);
        long j13 = j12 | (j12 >>> 4);
        long j14 = j13 | (j13 >>> 8);
        long j15 = j14 | (j14 >>> 16);
        long j16 = j15 | (j15 >>> 32);
        long j17 = j16 - ((j16 >>> 1) & 6148914691236517205L);
        long j18 = ((j17 >>> 2) & 3689348814741910323L) + (j17 & 3689348814741910323L);
        long j19 = ((j18 >>> 4) + j18) & 1085102592571150095L;
        long j20 = j19 + (j19 >>> 8);
        long j21 = j20 + (j20 >>> 16);
        int i10 = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        o oVarI0 = i0(i10);
        byte[] bArr = oVarI0.f11495a;
        int i11 = oVarI0.f11497c;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = ih.a.a()[(int) (15 & j10)];
            j10 >>>= 4;
        }
        oVarI0.f11497c += i10;
        f0(size() + ((long) i10));
        return this;
    }

    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public d clone() {
        return E();
    }

    @Override // hh.e
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public d writeInt(int i10) {
        o oVarI0 = i0(4);
        byte[] bArr = oVarI0.f11495a;
        int i11 = oVarI0.f11497c;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        bArr[i11 + 1] = (byte) ((i10 >>> 16) & 255);
        bArr[i11 + 2] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 3] = (byte) (i10 & 255);
        oVarI0.f11497c = i11 + 4;
        f0(size() + 4);
        return this;
    }

    @Override // hh.e
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public d writeShort(int i10) {
        o oVarI0 = i0(2);
        byte[] bArr = oVarI0.f11495a;
        int i11 = oVarI0.f11497c;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 1] = (byte) (i10 & 255);
        oVarI0.f11497c = i11 + 2;
        f0(size() + 2);
        return this;
    }

    @Override // hh.f
    public boolean q() {
        return this.f11470b == 0;
    }

    public final d q0(OutputStream out, long j10) throws IOException {
        kotlin.jvm.internal.t.f(out, "out");
        hh.b.b(this.f11470b, 0L, j10);
        o oVar = this.f11469a;
        long j11 = j10;
        while (j11 > 0) {
            kotlin.jvm.internal.t.c(oVar);
            int iMin = (int) Math.min(j11, oVar.f11497c - oVar.f11496b);
            out.write(oVar.f11495a, oVar.f11496b, iMin);
            int i10 = oVar.f11496b + iMin;
            oVar.f11496b = i10;
            long j12 = iMin;
            this.f11470b -= j12;
            j11 -= j12;
            if (i10 == oVar.f11497c) {
                o oVarB = oVar.b();
                this.f11469a = oVarB;
                p.b(oVar);
                oVar = oVarB;
            }
        }
        return this;
    }

    @Override // hh.e
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public d x(String string) {
        kotlin.jvm.internal.t.f(string, "string");
        return s0(string, 0, string.length());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.t.f(sink, "sink");
        o oVar = this.f11469a;
        if (oVar == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), oVar.f11497c - oVar.f11496b);
        sink.put(oVar.f11495a, oVar.f11496b, iMin);
        int i10 = oVar.f11496b + iMin;
        oVar.f11496b = i10;
        this.f11470b -= (long) iMin;
        if (i10 == oVar.f11497c) {
            this.f11469a = oVar.b();
            p.b(oVar);
        }
        return iMin;
    }

    @Override // hh.f
    public byte readByte() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        o oVar = this.f11469a;
        kotlin.jvm.internal.t.c(oVar);
        int i10 = oVar.f11496b;
        int i11 = oVar.f11497c;
        int i12 = i10 + 1;
        byte b10 = oVar.f11495a[i10];
        f0(size() - 1);
        if (i12 != i11) {
            oVar.f11496b = i12;
            return b10;
        }
        this.f11469a = oVar.b();
        p.b(oVar);
        return b10;
    }

    @Override // hh.f
    public int readInt() throws EOFException {
        if (size() < 4) {
            throw new EOFException();
        }
        o oVar = this.f11469a;
        kotlin.jvm.internal.t.c(oVar);
        int i10 = oVar.f11496b;
        int i11 = oVar.f11497c;
        if (i11 - i10 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = oVar.f11495a;
        int i12 = i10 + 3;
        int i13 = ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 2] & 255) << 8);
        int i14 = i10 + 4;
        int i15 = (bArr[i12] & 255) | i13;
        f0(size() - 4);
        if (i14 != i11) {
            oVar.f11496b = i14;
            return i15;
        }
        this.f11469a = oVar.b();
        p.b(oVar);
        return i15;
    }

    @Override // hh.f
    public short readShort() throws EOFException {
        if (size() < 2) {
            throw new EOFException();
        }
        o oVar = this.f11469a;
        kotlin.jvm.internal.t.c(oVar);
        int i10 = oVar.f11496b;
        int i11 = oVar.f11497c;
        if (i11 - i10 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = oVar.f11495a;
        int i12 = i10 + 1;
        int i13 = (bArr[i10] & 255) << 8;
        int i14 = i10 + 2;
        int i15 = (bArr[i12] & 255) | i13;
        f0(size() - 2);
        if (i14 == i11) {
            this.f11469a = oVar.b();
            p.b(oVar);
        } else {
            oVar.f11496b = i14;
        }
        return (short) i15;
    }

    public d s0(String string, int i10, int i11) {
        char cCharAt;
        kotlin.jvm.internal.t.f(string, "string");
        if (i10 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
        }
        if (i11 < i10) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
        }
        if (i11 > string.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + string.length()).toString());
        }
        while (i10 < i11) {
            char cCharAt2 = string.charAt(i10);
            if (cCharAt2 < 128) {
                o oVarI0 = i0(1);
                byte[] bArr = oVarI0.f11495a;
                int i12 = oVarI0.f11497c - i10;
                int iMin = Math.min(i11, 8192 - i12);
                int i13 = i10 + 1;
                bArr[i10 + i12] = (byte) cCharAt2;
                while (true) {
                    i10 = i13;
                    if (i10 >= iMin || (cCharAt = string.charAt(i10)) >= 128) {
                        break;
                    }
                    i13 = i10 + 1;
                    bArr[i10 + i12] = (byte) cCharAt;
                }
                int i14 = oVarI0.f11497c;
                int i15 = (i12 + i10) - i14;
                oVarI0.f11497c = i14 + i15;
                f0(size() + ((long) i15));
            } else {
                if (cCharAt2 < 2048) {
                    o oVarI02 = i0(2);
                    byte[] bArr2 = oVarI02.f11495a;
                    int i16 = oVarI02.f11497c;
                    bArr2[i16] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i16 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    oVarI02.f11497c = i16 + 2;
                    f0(size() + 2);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    o oVarI03 = i0(3);
                    byte[] bArr3 = oVarI03.f11495a;
                    int i17 = oVarI03.f11497c;
                    bArr3[i17] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i17 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i17 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    oVarI03.f11497c = i17 + 3;
                    f0(size() + 3);
                } else {
                    int i18 = i10 + 1;
                    char cCharAt3 = i18 < i11 ? string.charAt(i18) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        writeByte(63);
                        i10 = i18;
                    } else {
                        int i19 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        o oVarI04 = i0(4);
                        byte[] bArr4 = oVarI04.f11495a;
                        int i20 = oVarI04.f11497c;
                        bArr4[i20] = (byte) ((i19 >> 18) | 240);
                        bArr4[i20 + 1] = (byte) (((i19 >> 12) & 63) | 128);
                        bArr4[i20 + 2] = (byte) (((i19 >> 6) & 63) | 128);
                        bArr4[i20 + 3] = (byte) ((i19 & 63) | 128);
                        oVarI04.f11497c = i20 + 4;
                        f0(size() + 4);
                        i10 += 2;
                    }
                }
                i10++;
            }
        }
        return this;
    }

    public final long size() {
        return this.f11470b;
    }

    @Override // hh.f
    public void skip(long j10) throws EOFException {
        while (j10 > 0) {
            o oVar = this.f11469a;
            if (oVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j10, oVar.f11497c - oVar.f11496b);
            long j11 = iMin;
            f0(size() - j11);
            j10 -= j11;
            int i10 = oVar.f11496b + iMin;
            oVar.f11496b = i10;
            if (i10 == oVar.f11497c) {
                this.f11469a = oVar.b();
                p.b(oVar);
            }
        }
    }

    public d t0(int i10) {
        if (i10 < 128) {
            writeByte(i10);
            return this;
        }
        if (i10 < 2048) {
            o oVarI0 = i0(2);
            byte[] bArr = oVarI0.f11495a;
            int i11 = oVarI0.f11497c;
            bArr[i11] = (byte) ((i10 >> 6) | 192);
            bArr[i11 + 1] = (byte) ((i10 & 63) | 128);
            oVarI0.f11497c = i11 + 2;
            f0(size() + 2);
            return this;
        }
        if (55296 <= i10 && i10 < 57344) {
            writeByte(63);
            return this;
        }
        if (i10 < 65536) {
            o oVarI02 = i0(3);
            byte[] bArr2 = oVarI02.f11495a;
            int i12 = oVarI02.f11497c;
            bArr2[i12] = (byte) ((i10 >> 12) | 224);
            bArr2[i12 + 1] = (byte) (((i10 >> 6) & 63) | 128);
            bArr2[i12 + 2] = (byte) ((i10 & 63) | 128);
            oVarI02.f11497c = i12 + 3;
            f0(size() + 3);
            return this;
        }
        if (i10 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x" + hh.b.d(i10));
        }
        o oVarI03 = i0(4);
        byte[] bArr3 = oVarI03.f11495a;
        int i13 = oVarI03.f11497c;
        bArr3[i13] = (byte) ((i10 >> 18) | 240);
        bArr3[i13 + 1] = (byte) (((i10 >> 12) & 63) | 128);
        bArr3[i13 + 2] = (byte) (((i10 >> 6) & 63) | 128);
        bArr3[i13 + 3] = (byte) ((i10 & 63) | 128);
        oVarI03.f11497c = i13 + 4;
        f0(size() + 4);
        return this;
    }

    public String toString() {
        return g0().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        kotlin.jvm.internal.t.f(source, "source");
        int iRemaining = source.remaining();
        int i10 = iRemaining;
        while (i10 > 0) {
            o oVarI0 = i0(1);
            int iMin = Math.min(i10, 8192 - oVarI0.f11497c);
            source.get(oVarI0.f11495a, oVarI0.f11497c, iMin);
            i10 -= iMin;
            oVarI0.f11497c += iMin;
        }
        this.f11470b += (long) iRemaining;
        return iRemaining;
    }

    public int read(byte[] sink, int i10, int i11) {
        kotlin.jvm.internal.t.f(sink, "sink");
        hh.b.b(sink.length, i10, i11);
        o oVar = this.f11469a;
        if (oVar == null) {
            return -1;
        }
        int iMin = Math.min(i11, oVar.f11497c - oVar.f11496b);
        byte[] bArr = oVar.f11495a;
        int i12 = oVar.f11496b;
        dd.l.e(bArr, sink, i10, i12, i12 + iMin);
        oVar.f11496b += iMin;
        f0(size() - ((long) iMin));
        if (oVar.f11496b == oVar.f11497c) {
            this.f11469a = oVar.b();
            p.b(oVar);
        }
        return iMin;
    }

    public d b() {
        return this;
    }

    @Override // hh.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // hh.e, hh.r, java.io.Flushable
    public void flush() {
    }

    @Override // hh.f
    public d p() {
        return this;
    }
}
