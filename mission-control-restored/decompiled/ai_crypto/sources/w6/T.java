package w6;

import Z5.AbstractC0794a;
import com.google.android.gms.common.api.a;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class T implements InterfaceC2794g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z f25047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2792e f25048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25049c;

    public T(Z source) {
        kotlin.jvm.internal.r.f(source, "source");
        this.f25047a = source;
        this.f25048b = new C2792e();
    }

    public boolean A(long j7, C2795h bytes, int i7, int i8) {
        kotlin.jvm.internal.r.f(bytes, "bytes");
        if (this.f25049c) {
            throw new IllegalStateException("closed");
        }
        if (j7 < 0 || i7 < 0 || i8 < 0 || bytes.H() - i7 < i8) {
            return false;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            long j8 = ((long) i9) + j7;
            if (!G(1 + j8) || this.f25048b.T(j8) != bytes.l(i7 + i9)) {
                return false;
            }
        }
        return true;
    }

    @Override // w6.InterfaceC2794g
    public long C() {
        byte bT;
        o0(1L);
        long j7 = 0;
        while (true) {
            long j8 = j7 + 1;
            if (!G(j8)) {
                break;
            }
            bT = this.f25048b.T(j7);
            if ((bT < 48 || bT > 57) && !(j7 == 0 && bT == 45)) {
                break;
            }
            j7 = j8;
        }
        if (j7 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a digit or '-' but was 0x");
            String string = Integer.toString(bT, AbstractC0794a.a(AbstractC0794a.a(16)));
            kotlin.jvm.internal.r.e(string, "toString(this, checkRadix(radix))");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return this.f25048b.C();
    }

    @Override // w6.InterfaceC2794g
    public String E(long j7) throws EOFException {
        if (j7 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j7).toString());
        }
        long j8 = j7 == Long.MAX_VALUE ? Long.MAX_VALUE : j7 + 1;
        long jI = i((byte) 10, 0L, j8);
        if (jI != -1) {
            return x6.a.c(this.f25048b, jI);
        }
        if (j8 < Long.MAX_VALUE && G(j8) && this.f25048b.T(j8 - 1) == 13 && G(1 + j8) && this.f25048b.T(j8) == 10) {
            return x6.a.c(this.f25048b, j8);
        }
        C2792e c2792e = new C2792e();
        C2792e c2792e2 = this.f25048b;
        c2792e2.K(c2792e, 0L, Math.min(32, c2792e2.E0()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f25048b.E0(), j7) + " content=" + c2792e.A0().q() + (char) 8230);
    }

    public boolean G(long j7) {
        if (j7 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        if (this.f25049c) {
            throw new IllegalStateException("closed");
        }
        while (this.f25048b.E0() < j7) {
            if (this.f25047a.z(this.f25048b, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // w6.InterfaceC2794g
    public boolean R(long j7, C2795h bytes) {
        kotlin.jvm.internal.r.f(bytes, "bytes");
        return A(j7, bytes, 0, bytes.H());
    }

    @Override // w6.InterfaceC2794g
    public String U() {
        return E(Long.MAX_VALUE);
    }

    @Override // w6.InterfaceC2794g
    public int W() {
        o0(4L);
        return this.f25048b.W();
    }

    @Override // w6.InterfaceC2794g
    public byte[] Y(long j7) {
        o0(j7);
        return this.f25048b.Y(j7);
    }

    @Override // w6.Z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        if (this.f25049c) {
            return;
        }
        this.f25049c = true;
        this.f25047a.close();
        this.f25048b.i();
    }

    @Override // w6.InterfaceC2794g
    public C2792e d() {
        return this.f25048b;
    }

    @Override // w6.InterfaceC2794g
    public short d0() {
        o0(2L);
        return this.f25048b.d0();
    }

    @Override // w6.InterfaceC2794g
    public void e0(C2792e sink, long j7) throws EOFException {
        kotlin.jvm.internal.r.f(sink, "sink");
        try {
            o0(j7);
            this.f25048b.e0(sink, j7);
        } catch (EOFException e7) {
            sink.n(this.f25048b);
            throw e7;
        }
    }

    @Override // w6.Z
    public a0 f() {
        return this.f25047a.f();
    }

    public long h(byte b7) {
        return i(b7, 0L, Long.MAX_VALUE);
    }

    @Override // w6.InterfaceC2794g
    public long h0() {
        o0(8L);
        return this.f25048b.h0();
    }

    public long i(byte b7, long j7, long j8) {
        if (this.f25049c) {
            throw new IllegalStateException("closed");
        }
        if (0 > j7 || j7 > j8) {
            throw new IllegalArgumentException(("fromIndex=" + j7 + " toIndex=" + j8).toString());
        }
        while (j7 < j8) {
            long jV = this.f25048b.V(b7, j7, j8);
            if (jV != -1) {
                return jV;
            }
            long jE0 = this.f25048b.E0();
            if (jE0 >= j8 || this.f25047a.z(this.f25048b, 8192L) == -1) {
                return -1L;
            }
            j7 = Math.max(j7, jE0);
        }
        return -1L;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f25049c;
    }

    @Override // w6.InterfaceC2794g
    public String k(long j7) {
        o0(j7);
        return this.f25048b.k(j7);
    }

    @Override // w6.InterfaceC2794g
    public C2795h o(long j7) {
        o0(j7);
        return this.f25048b.o(j7);
    }

    @Override // w6.InterfaceC2794g
    public void o0(long j7) {
        if (!G(j7)) {
            throw new EOFException();
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.r.f(sink, "sink");
        if (this.f25048b.E0() == 0 && this.f25047a.z(this.f25048b, 8192L) == -1) {
            return -1;
        }
        return this.f25048b.read(sink);
    }

    @Override // w6.InterfaceC2794g
    public byte readByte() {
        o0(1L);
        return this.f25048b.readByte();
    }

    @Override // w6.InterfaceC2794g
    public void readFully(byte[] sink) throws EOFException {
        kotlin.jvm.internal.r.f(sink, "sink");
        try {
            o0(sink.length);
            this.f25048b.readFully(sink);
        } catch (EOFException e7) {
            int i7 = 0;
            while (this.f25048b.E0() > 0) {
                C2792e c2792e = this.f25048b;
                int i8 = c2792e.read(sink, i7, (int) c2792e.E0());
                if (i8 == -1) {
                    throw new AssertionError();
                }
                i7 += i8;
            }
            throw e7;
        }
    }

    @Override // w6.InterfaceC2794g
    public int readInt() {
        o0(4L);
        return this.f25048b.readInt();
    }

    @Override // w6.InterfaceC2794g
    public long readLong() {
        o0(8L);
        return this.f25048b.readLong();
    }

    @Override // w6.InterfaceC2794g
    public short readShort() {
        o0(2L);
        return this.f25048b.readShort();
    }

    @Override // w6.InterfaceC2794g
    public long s0() {
        byte bT;
        o0(1L);
        int i7 = 0;
        while (true) {
            int i8 = i7 + 1;
            if (!G(i8)) {
                break;
            }
            bT = this.f25048b.T(i7);
            if ((bT < 48 || bT > 57) && ((bT < 97 || bT > 102) && (bT < 65 || bT > 70))) {
                break;
            }
            i7 = i8;
        }
        if (i7 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            String string = Integer.toString(bT, AbstractC0794a.a(AbstractC0794a.a(16)));
            kotlin.jvm.internal.r.e(string, "toString(this, checkRadix(radix))");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return this.f25048b.s0();
    }

    @Override // w6.InterfaceC2794g
    public void skip(long j7) {
        if (this.f25049c) {
            throw new IllegalStateException("closed");
        }
        while (j7 > 0) {
            if (this.f25048b.E0() == 0 && this.f25047a.z(this.f25048b, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j7, this.f25048b.E0());
            this.f25048b.skip(jMin);
            j7 -= jMin;
        }
    }

    @Override // w6.InterfaceC2794g
    public C2792e t() {
        return this.f25048b;
    }

    public String toString() {
        return "buffer(" + this.f25047a + ')';
    }

    @Override // w6.InterfaceC2794g
    public boolean u() {
        if (this.f25049c) {
            throw new IllegalStateException("closed");
        }
        return this.f25048b.u() && this.f25047a.z(this.f25048b, 8192L) == -1;
    }

    @Override // w6.InterfaceC2794g
    public InputStream v0() {
        return new a();
    }

    @Override // w6.Z
    public long z(C2792e sink, long j7) {
        kotlin.jvm.internal.r.f(sink, "sink");
        if (j7 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        if (this.f25049c) {
            throw new IllegalStateException("closed");
        }
        if (this.f25048b.E0() == 0 && this.f25047a.z(this.f25048b, 8192L) == -1) {
            return -1L;
        }
        return this.f25048b.z(sink, Math.min(j7, this.f25048b.E0()));
    }

    public static final class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            T t7 = T.this;
            if (t7.f25049c) {
                throw new IOException("closed");
            }
            return (int) Math.min(t7.f25048b.E0(), a.e.API_PRIORITY_OTHER);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws EOFException {
            T.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            T t7 = T.this;
            if (t7.f25049c) {
                throw new IOException("closed");
            }
            if (t7.f25048b.E0() == 0) {
                T t8 = T.this;
                if (t8.f25047a.z(t8.f25048b, 8192L) == -1) {
                    return -1;
                }
            }
            return T.this.f25048b.readByte() & 255;
        }

        public String toString() {
            return T.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] data, int i7, int i8) throws IOException {
            kotlin.jvm.internal.r.f(data, "data");
            if (!T.this.f25049c) {
                AbstractC2789b.b(data.length, i7, i8);
                if (T.this.f25048b.E0() == 0) {
                    T t7 = T.this;
                    if (t7.f25047a.z(t7.f25048b, 8192L) == -1) {
                        return -1;
                    }
                }
                return T.this.f25048b.read(data, i7, i8);
            }
            throw new IOException("closed");
        }
    }
}
