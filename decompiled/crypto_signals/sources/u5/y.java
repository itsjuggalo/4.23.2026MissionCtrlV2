package u5;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class y implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f10555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1250g f10556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10557c;

    public y(E source) {
        kotlin.jvm.internal.j.e(source, "source");
        this.f10555a = source;
        this.f10556b = new C1250g();
    }

    @Override // u5.E
    public final long a(long j4, C1250g sink) {
        kotlin.jvm.internal.j.e(sink, "sink");
        if (j4 < 0) {
            throw new IllegalArgumentException(k0.a.f("byteCount < 0: ", j4).toString());
        }
        if (this.f10557c) {
            throw new IllegalStateException("closed");
        }
        C1250g c1250g = this.f10556b;
        if (c1250g.f10526b == 0 && this.f10555a.a(8192L, c1250g) == -1) {
            return -1L;
        }
        return c1250g.a(Math.min(j4, c1250g.f10526b), sink);
    }

    @Override // u5.E
    public final G b() {
        return this.f10555a.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.f10557c) {
            return;
        }
        this.f10557c = true;
        this.f10555a.close();
        this.f10556b.d();
    }

    public final byte d() {
        o(1L);
        return this.f10556b.m();
    }

    public final j f(long j4) {
        o(j4);
        return this.f10556b.o(j4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00cc, code lost:
    
        if (r13 == 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ce, code lost:
    
        r17 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d1, code lost:
    
        r3 = v5.b.f10655a;
        r4 = r3[(r15 >> 4) & 15];
        r3 = r3[r15 & 15];
        r5 = new char[2];
        r5[r21] = r4;
        r5[r16] = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f2, code lost:
    
        throw new java.lang.NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(new java.lang.String(r5)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long g() throws java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u5.y.g():long");
    }

    public final int h() {
        o(4L);
        return this.f10556b.p();
    }

    public final int i() {
        o(4L);
        int iP = this.f10556b.p();
        return ((iP & 255) << 24) | (((-16777216) & iP) >>> 24) | ((16711680 & iP) >>> 8) | ((65280 & iP) << 8);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f10557c;
    }

    public final long j() throws EOFException {
        long jP;
        o(8L);
        C1250g c1250g = this.f10556b;
        if (c1250g.f10526b < 8) {
            throw new EOFException();
        }
        z zVar = c1250g.f10525a;
        kotlin.jvm.internal.j.b(zVar);
        int i = zVar.f10559b;
        int i6 = zVar.f10560c;
        if (i6 - i < 8) {
            jP = ((((long) c1250g.p()) & 4294967295L) << 32) | (4294967295L & ((long) c1250g.p()));
        } else {
            byte[] bArr = zVar.f10558a;
            int i7 = i + 7;
            long j4 = ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
            int i8 = i + 8;
            long j6 = j4 | (((long) bArr[i7]) & 255);
            c1250g.f10526b -= 8;
            if (i8 == i6) {
                c1250g.f10525a = zVar.a();
                A.a(zVar);
            } else {
                zVar.f10559b = i8;
            }
            jP = j6;
        }
        return ((jP & 255) << 56) | (((-72057594037927936L) & jP) >>> 56) | ((71776119061217280L & jP) >>> 40) | ((280375465082880L & jP) >>> 24) | ((1095216660480L & jP) >>> 8) | ((4278190080L & jP) << 8) | ((16711680 & jP) << 24) | ((65280 & jP) << 40);
    }

    public final short k() {
        o(2L);
        short sQ = this.f10556b.q();
        return (short) (((sQ & 255) << 8) | ((65280 & sQ) >>> 8));
    }

    public final String l(long j4) {
        o(j4);
        C1250g c1250g = this.f10556b;
        c1250g.getClass();
        return c1250g.r(j4, Y4.a.f3689a);
    }

    public final String m() throws EOFException {
        long j4;
        long j6;
        long j7;
        if (Long.MAX_VALUE < 0) {
            throw new IllegalArgumentException(k0.a.f("limit < 0: ", Long.MAX_VALUE).toString());
        }
        long j8 = Long.MAX_VALUE;
        long j9 = 1;
        long j10 = Long.MAX_VALUE == Long.MAX_VALUE ? Long.MAX_VALUE : Long.MAX_VALUE + 1;
        if (this.f10557c) {
            throw new IllegalStateException("closed");
        }
        if (0 > j10) {
            throw new IllegalArgumentException(k0.a.f("fromIndex=0 toIndex=", j10).toString());
        }
        long jMax = 0;
        while (true) {
            j4 = -1;
            if (jMax >= j10) {
                j6 = j8;
                break;
            }
            C1250g c1250g = this.f10556b;
            long j11 = c1250g.j((byte) 10, jMax, j10);
            if (j11 == -1) {
                j6 = j8;
                long j12 = c1250g.f10526b;
                if (j12 >= j10) {
                    break;
                }
                j7 = j9;
                if (this.f10555a.a(8192L, c1250g) == -1) {
                    break;
                }
                jMax = Math.max(jMax, j12);
                j8 = j6;
                j9 = j7;
            } else {
                j7 = j9;
                j4 = j11;
                j6 = j8;
                break;
            }
        }
        j7 = j9;
        C1250g c1250g2 = this.f10556b;
        if (j4 != -1) {
            return v5.a.a(j4, c1250g2);
        }
        if (j10 < j6 && n(j10) && c1250g2.i(j10 - j7) == 13 && n(j10 + j7) && c1250g2.i(j10) == 10) {
            return v5.a.a(j10, c1250g2);
        }
        C1250g c1250g3 = new C1250g();
        c1250g2.g(c1250g3, 0L, Math.min(32, c1250g2.f10526b));
        throw new EOFException("\\n not found: limit=" + Math.min(c1250g2.f10526b, Long.MAX_VALUE) + " content=" + c1250g3.o(c1250g3.f10526b).e() + (char) 8230);
    }

    public final boolean n(long j4) {
        C1250g c1250g;
        if (j4 < 0) {
            throw new IllegalArgumentException(k0.a.f("byteCount < 0: ", j4).toString());
        }
        if (this.f10557c) {
            throw new IllegalStateException("closed");
        }
        do {
            c1250g = this.f10556b;
            if (c1250g.f10526b >= j4) {
                return true;
            }
        } while (this.f10555a.a(8192L, c1250g) != -1);
        return false;
    }

    public final void o(long j4) {
        if (!n(j4)) {
            throw new EOFException();
        }
    }

    public final void p(long j4) {
        if (this.f10557c) {
            throw new IllegalStateException("closed");
        }
        while (j4 > 0) {
            C1250g c1250g = this.f10556b;
            if (c1250g.f10526b == 0 && this.f10555a.a(8192L, c1250g) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j4, c1250g.f10526b);
            c1250g.t(jMin);
            j4 -= jMin;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        kotlin.jvm.internal.j.e(sink, "sink");
        C1250g c1250g = this.f10556b;
        if (c1250g.f10526b == 0 && this.f10555a.a(8192L, c1250g) == -1) {
            return -1;
        }
        return c1250g.read(sink);
    }

    public final String toString() {
        return "buffer(" + this.f10555a + ')';
    }
}
