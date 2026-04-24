package u7;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class N implements InterfaceC2812e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f23586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2811d f23587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23588c;

    public static final class a extends OutputStream {
        public a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws Throwable {
            N.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            N n8 = N.this;
            if (n8.f23588c) {
                return;
            }
            n8.flush();
        }

        public String toString() {
            return N.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i8) throws IOException {
            N n8 = N.this;
            if (n8.f23588c) {
                throw new IOException("closed");
            }
            n8.f23587b.x((byte) i8);
            N.this.a();
        }

        @Override // java.io.OutputStream
        public void write(byte[] data, int i8, int i9) throws IOException {
            AbstractC2304t.f(data, "data");
            N n8 = N.this;
            if (n8.f23588c) {
                throw new IOException("closed");
            }
            n8.f23587b.A0(data, i8, i9);
            N.this.a();
        }
    }

    public N(T sink) {
        AbstractC2304t.f(sink, "sink");
        this.f23586a = sink;
        this.f23587b = new C2811d();
    }

    @Override // u7.InterfaceC2812e
    public InterfaceC2812e G(String string) {
        AbstractC2304t.f(string, "string");
        if (!(!this.f23588c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f23587b.G(string);
        return a();
    }

    @Override // u7.T
    public void H(C2811d source, long j8) {
        AbstractC2304t.f(source, "source");
        if (!(!this.f23588c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f23587b.H(source, j8);
        a();
    }

    @Override // u7.InterfaceC2812e
    public InterfaceC2812e Z(byte[] source) {
        AbstractC2304t.f(source, "source");
        if (!(!this.f23588c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f23587b.Z(source);
        return a();
    }

    public InterfaceC2812e a() {
        if (!(!this.f23588c)) {
            throw new IllegalStateException("closed".toString());
        }
        long jB = this.f23587b.B();
        if (jB > 0) {
            this.f23586a.H(this.f23587b, jB);
        }
        return this;
    }

    @Override // u7.T, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f23588c) {
            return;
        }
        try {
            if (this.f23587b.s0() > 0) {
                T t8 = this.f23586a;
                C2811d c2811d = this.f23587b;
                t8.H(c2811d, c2811d.s0());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f23586a.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f23588c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // u7.InterfaceC2812e, u7.T, java.io.Flushable
    public void flush() {
        if (!(!this.f23588c)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f23587b.s0() > 0) {
            T t8 = this.f23586a;
            C2811d c2811d = this.f23587b;
            t8.H(c2811d, c2811d.s0());
        }
        this.f23586a.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f23588c;
    }

    @Override // u7.InterfaceC2812e
    public InterfaceC2812e q(int i8) {
        if (!(!this.f23588c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f23587b.q(i8);
        return a();
    }

    @Override // u7.InterfaceC2812e
    public OutputStream q0() {
        return new a();
    }

    @Override // u7.InterfaceC2812e
    public InterfaceC2812e s(int i8) {
        if (!(!this.f23588c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f23587b.s(i8);
        return a();
    }

    public String toString() {
        return "buffer(" + this.f23586a + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        AbstractC2304t.f(source, "source");
        if (!(!this.f23588c)) {
            throw new IllegalStateException("closed".toString());
        }
        int iWrite = this.f23587b.write(source);
        a();
        return iWrite;
    }

    @Override // u7.InterfaceC2812e
    public InterfaceC2812e x(int i8) {
        if (!(!this.f23588c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f23587b.x(i8);
        return a();
    }
}
