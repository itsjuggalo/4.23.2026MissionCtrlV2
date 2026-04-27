package O3;

import java.io.EOFException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f3343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f3344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3345c;

    public n(t source) {
        kotlin.jvm.internal.r.f(source, "source");
        this.f3343a = source;
        this.f3344b = new d();
    }

    @Override // O3.f
    public byte[] L(long j4) throws EOFException {
        Y(j4);
        return this.f3344b.L(j4);
    }

    @Override // O3.f
    public void Y(long j4) throws EOFException {
        if (!e(j4)) {
            throw new EOFException();
        }
    }

    @Override // O3.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        if (this.f3345c) {
            return;
        }
        this.f3345c = true;
        this.f3343a.close();
        this.f3344b.f();
    }

    public boolean e(long j4) {
        if (j4 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        }
        if (this.f3345c) {
            throw new IllegalStateException("closed");
        }
        while (this.f3344b.i0() < j4) {
            if (this.f3343a.v(this.f3344b, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f3345c;
    }

    @Override // O3.f
    public g j(long j4) throws EOFException {
        Y(j4);
        return this.f3344b.j(j4);
    }

    @Override // O3.f
    public d q() {
        return this.f3344b;
    }

    @Override // O3.f
    public boolean r() {
        if (this.f3345c) {
            throw new IllegalStateException("closed");
        }
        return this.f3344b.r() && this.f3343a.v(this.f3344b, 8192L) == -1;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.r.f(sink, "sink");
        if (this.f3344b.i0() == 0 && this.f3343a.v(this.f3344b, 8192L) == -1) {
            return -1;
        }
        return this.f3344b.read(sink);
    }

    @Override // O3.f
    public byte readByte() throws EOFException {
        Y(1L);
        return this.f3344b.readByte();
    }

    @Override // O3.f
    public int readInt() throws EOFException {
        Y(4L);
        return this.f3344b.readInt();
    }

    @Override // O3.f
    public short readShort() throws EOFException {
        Y(2L);
        return this.f3344b.readShort();
    }

    @Override // O3.f
    public void skip(long j4) throws EOFException {
        if (this.f3345c) {
            throw new IllegalStateException("closed");
        }
        while (j4 > 0) {
            if (this.f3344b.i0() == 0 && this.f3343a.v(this.f3344b, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j4, this.f3344b.i0());
            this.f3344b.skip(jMin);
            j4 -= jMin;
        }
    }

    public String toString() {
        return "buffer(" + this.f3343a + ')';
    }

    @Override // O3.t
    public long v(d sink, long j4) {
        kotlin.jvm.internal.r.f(sink, "sink");
        if (j4 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        }
        if (this.f3345c) {
            throw new IllegalStateException("closed");
        }
        if (this.f3344b.i0() == 0 && this.f3343a.v(this.f3344b, 8192L) == -1) {
            return -1L;
        }
        return this.f3344b.v(sink, Math.min(j4, this.f3344b.i0()));
    }
}
