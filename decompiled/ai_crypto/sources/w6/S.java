package w6;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class S implements InterfaceC2793f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X f25043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2792e f25044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25045c;

    public S(X sink) {
        kotlin.jvm.internal.r.f(sink, "sink");
        this.f25043a = sink;
        this.f25044b = new C2792e();
    }

    @Override // w6.InterfaceC2793f
    public InterfaceC2793f B() {
        if (this.f25045c) {
            throw new IllegalStateException("closed");
        }
        long jG = this.f25044b.G();
        if (jG > 0) {
            this.f25043a.L(this.f25044b, jG);
        }
        return this;
    }

    @Override // w6.InterfaceC2793f
    public InterfaceC2793f I(String string) {
        kotlin.jvm.internal.r.f(string, "string");
        if (this.f25045c) {
            throw new IllegalStateException("closed");
        }
        this.f25044b.I(string);
        return B();
    }

    @Override // w6.X
    public void L(C2792e source, long j7) {
        kotlin.jvm.internal.r.f(source, "source");
        if (this.f25045c) {
            throw new IllegalStateException("closed");
        }
        this.f25044b.L(source, j7);
        B();
    }

    @Override // w6.InterfaceC2793f
    public InterfaceC2793f P(long j7) {
        if (this.f25045c) {
            throw new IllegalStateException("closed");
        }
        this.f25044b.P(j7);
        return B();
    }

    @Override // w6.InterfaceC2793f
    public InterfaceC2793f a0(byte[] source) {
        kotlin.jvm.internal.r.f(source, "source");
        if (this.f25045c) {
            throw new IllegalStateException("closed");
        }
        this.f25044b.a0(source);
        return B();
    }

    @Override // w6.X, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f25045c) {
            return;
        }
        try {
            if (this.f25044b.E0() > 0) {
                X x7 = this.f25043a;
                C2792e c2792e = this.f25044b;
                x7.L(c2792e, c2792e.E0());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f25043a.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f25045c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // w6.InterfaceC2793f
    public C2792e d() {
        return this.f25044b;
    }

    @Override // w6.X
    public a0 f() {
        return this.f25043a.f();
    }

    @Override // w6.InterfaceC2793f, w6.X, java.io.Flushable
    public void flush() {
        if (this.f25045c) {
            throw new IllegalStateException("closed");
        }
        if (this.f25044b.E0() > 0) {
            X x7 = this.f25043a;
            C2792e c2792e = this.f25044b;
            x7.L(c2792e, c2792e.E0());
        }
        this.f25043a.flush();
    }

    @Override // w6.InterfaceC2793f
    public InterfaceC2793f g(byte[] source, int i7, int i8) {
        kotlin.jvm.internal.r.f(source, "source");
        if (this.f25045c) {
            throw new IllegalStateException("closed");
        }
        this.f25044b.g(source, i7, i8);
        return B();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f25045c;
    }

    @Override // w6.InterfaceC2793f
    public InterfaceC2793f m(C2795h byteString) {
        kotlin.jvm.internal.r.f(byteString, "byteString");
        if (this.f25045c) {
            throw new IllegalStateException("closed");
        }
        this.f25044b.m(byteString);
        return B();
    }

    @Override // w6.InterfaceC2793f
    public long n(Z source) {
        kotlin.jvm.internal.r.f(source, "source");
        long j7 = 0;
        while (true) {
            long jZ = source.z(this.f25044b, 8192L);
            if (jZ == -1) {
                return j7;
            }
            j7 += jZ;
            B();
        }
    }

    @Override // w6.InterfaceC2793f
    public InterfaceC2793f p() {
        if (this.f25045c) {
            throw new IllegalStateException("closed");
        }
        long jE0 = this.f25044b.E0();
        if (jE0 > 0) {
            this.f25043a.L(this.f25044b, jE0);
        }
        return this;
    }

    @Override // w6.InterfaceC2793f
    public InterfaceC2793f q(int i7) {
        if (this.f25045c) {
            throw new IllegalStateException("closed");
        }
        this.f25044b.q(i7);
        return B();
    }

    @Override // w6.InterfaceC2793f
    public InterfaceC2793f q0(long j7) {
        if (this.f25045c) {
            throw new IllegalStateException("closed");
        }
        this.f25044b.q0(j7);
        return B();
    }

    @Override // w6.InterfaceC2793f
    public InterfaceC2793f r(int i7) {
        if (this.f25045c) {
            throw new IllegalStateException("closed");
        }
        this.f25044b.r(i7);
        return B();
    }

    @Override // w6.InterfaceC2793f
    public OutputStream r0() {
        return new a();
    }

    public String toString() {
        return "buffer(" + this.f25043a + ')';
    }

    @Override // w6.InterfaceC2793f
    public InterfaceC2793f v(int i7) {
        if (this.f25045c) {
            throw new IllegalStateException("closed");
        }
        this.f25044b.v(i7);
        return B();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        kotlin.jvm.internal.r.f(source, "source");
        if (this.f25045c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f25044b.write(source);
        B();
        return iWrite;
    }

    public static final class a extends OutputStream {
        public a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws Throwable {
            S.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            S s7 = S.this;
            if (s7.f25045c) {
                return;
            }
            s7.flush();
        }

        public String toString() {
            return S.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i7) throws IOException {
            S s7 = S.this;
            if (s7.f25045c) {
                throw new IOException("closed");
            }
            s7.f25044b.v((byte) i7);
            S.this.B();
        }

        @Override // java.io.OutputStream
        public void write(byte[] data, int i7, int i8) throws IOException {
            kotlin.jvm.internal.r.f(data, "data");
            S s7 = S.this;
            if (!s7.f25045c) {
                s7.f25044b.g(data, i7, i8);
                S.this.B();
                return;
            }
            throw new IOException("closed");
        }
    }
}
