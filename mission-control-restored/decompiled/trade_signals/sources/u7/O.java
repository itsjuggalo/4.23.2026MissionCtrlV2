package u7;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class O implements InterfaceC2813f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V f23590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2811d f23591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23592c;

    public static final class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            O o8 = O.this;
            if (o8.f23592c) {
                throw new IOException("closed");
            }
            return (int) Math.min(o8.f23591b.s0(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws EOFException {
            O.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            O o8 = O.this;
            if (o8.f23592c) {
                throw new IOException("closed");
            }
            if (o8.f23591b.s0() == 0) {
                O o9 = O.this;
                if (o9.f23590a.o0(o9.f23591b, 8192L) == -1) {
                    return -1;
                }
            }
            return O.this.f23591b.readByte() & 255;
        }

        public String toString() {
            return O.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] data, int i8, int i9) throws IOException {
            AbstractC2304t.f(data, "data");
            if (O.this.f23592c) {
                throw new IOException("closed");
            }
            AbstractC2809b.b(data.length, i8, i9);
            if (O.this.f23591b.s0() == 0) {
                O o8 = O.this;
                if (o8.f23590a.o0(o8.f23591b, 8192L) == -1) {
                    return -1;
                }
            }
            return O.this.f23591b.read(data, i8, i9);
        }
    }

    public O(V source) {
        AbstractC2304t.f(source, "source");
        this.f23590a = source;
        this.f23591b = new C2811d();
    }

    @Override // u7.InterfaceC2813f
    public int V() throws EOFException {
        n0(4L);
        return this.f23591b.V();
    }

    @Override // u7.InterfaceC2813f
    public byte[] Y(long j8) throws EOFException {
        n0(j8);
        return this.f23591b.Y(j8);
    }

    public boolean a(long j8) {
        if (j8 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j8).toString());
        }
        if (!(!this.f23592c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.f23591b.s0() < j8) {
            if (this.f23590a.o0(this.f23591b, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // u7.InterfaceC2813f
    public short c0() throws EOFException {
        n0(2L);
        return this.f23591b.c0();
    }

    @Override // u7.V, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        if (this.f23592c) {
            return;
        }
        this.f23592c = true;
        this.f23590a.close();
        this.f23591b.e();
    }

    @Override // u7.InterfaceC2813f
    public long f0() throws EOFException {
        n0(8L);
        return this.f23591b.f0();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f23592c;
    }

    @Override // u7.InterfaceC2813f
    public String j(long j8) throws EOFException {
        n0(j8);
        return this.f23591b.j(j8);
    }

    @Override // u7.InterfaceC2813f
    public void n0(long j8) throws EOFException {
        if (!a(j8)) {
            throw new EOFException();
        }
    }

    @Override // u7.V
    public long o0(C2811d sink, long j8) {
        AbstractC2304t.f(sink, "sink");
        if (j8 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j8).toString());
        }
        if (!(!this.f23592c)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f23591b.s0() == 0 && this.f23590a.o0(this.f23591b, 8192L) == -1) {
            return -1L;
        }
        return this.f23591b.o0(sink, Math.min(j8, this.f23591b.s0()));
    }

    @Override // u7.InterfaceC2813f
    public C2814g p(long j8) throws EOFException {
        n0(j8);
        return this.f23591b.p(j8);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        AbstractC2304t.f(sink, "sink");
        if (this.f23591b.s0() == 0 && this.f23590a.o0(this.f23591b, 8192L) == -1) {
            return -1;
        }
        return this.f23591b.read(sink);
    }

    @Override // u7.InterfaceC2813f
    public byte readByte() throws EOFException {
        n0(1L);
        return this.f23591b.readByte();
    }

    @Override // u7.InterfaceC2813f
    public int readInt() throws EOFException {
        n0(4L);
        return this.f23591b.readInt();
    }

    @Override // u7.InterfaceC2813f
    public short readShort() throws EOFException {
        n0(2L);
        return this.f23591b.readShort();
    }

    @Override // u7.InterfaceC2813f
    public void skip(long j8) throws EOFException {
        if (!(!this.f23592c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j8 > 0) {
            if (this.f23591b.s0() == 0 && this.f23590a.o0(this.f23591b, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j8, this.f23591b.s0());
            this.f23591b.skip(jMin);
            j8 -= jMin;
        }
    }

    public String toString() {
        return "buffer(" + this.f23590a + ')';
    }

    @Override // u7.InterfaceC2813f
    public InputStream u0() {
        return new a();
    }

    @Override // u7.InterfaceC2813f
    public C2811d v() {
        return this.f23591b;
    }

    @Override // u7.InterfaceC2813f
    public boolean w() {
        if (!this.f23592c) {
            return this.f23591b.w() && this.f23590a.o0(this.f23591b, 8192L) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }
}
