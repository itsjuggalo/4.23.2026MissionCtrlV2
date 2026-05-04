package hh;

import java.io.EOFException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f11491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f11492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11493c;

    public n(t source) {
        kotlin.jvm.internal.t.f(source, "source");
        this.f11491a = source;
        this.f11492b = new d();
    }

    @Override // hh.t
    public long B(d sink, long j10) {
        kotlin.jvm.internal.t.f(sink, "sink");
        if (j10 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (this.f11493c) {
            throw new IllegalStateException("closed");
        }
        if (this.f11492b.size() == 0 && this.f11491a.B(this.f11492b, 8192L) == -1) {
            return -1L;
        }
        return this.f11492b.B(sink, Math.min(j10, this.f11492b.size()));
    }

    @Override // hh.f
    public byte[] J(long j10) throws EOFException {
        V(j10);
        return this.f11492b.J(j10);
    }

    @Override // hh.f
    public void V(long j10) throws EOFException {
        if (!b(j10)) {
            throw new EOFException();
        }
    }

    public boolean b(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (this.f11493c) {
            throw new IllegalStateException("closed");
        }
        while (this.f11492b.size() < j10) {
            if (this.f11491a.B(this.f11492b, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // hh.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        if (this.f11493c) {
            return;
        }
        this.f11493c = true;
        this.f11491a.close();
        this.f11492b.c();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f11493c;
    }

    @Override // hh.f
    public g k(long j10) throws EOFException {
        V(j10);
        return this.f11492b.k(j10);
    }

    @Override // hh.f
    public d p() {
        return this.f11492b;
    }

    @Override // hh.f
    public boolean q() {
        if (this.f11493c) {
            throw new IllegalStateException("closed");
        }
        return this.f11492b.q() && this.f11491a.B(this.f11492b, 8192L) == -1;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.t.f(sink, "sink");
        if (this.f11492b.size() == 0 && this.f11491a.B(this.f11492b, 8192L) == -1) {
            return -1;
        }
        return this.f11492b.read(sink);
    }

    @Override // hh.f
    public byte readByte() throws EOFException {
        V(1L);
        return this.f11492b.readByte();
    }

    @Override // hh.f
    public int readInt() throws EOFException {
        V(4L);
        return this.f11492b.readInt();
    }

    @Override // hh.f
    public short readShort() throws EOFException {
        V(2L);
        return this.f11492b.readShort();
    }

    @Override // hh.f
    public void skip(long j10) throws EOFException {
        if (this.f11493c) {
            throw new IllegalStateException("closed");
        }
        while (j10 > 0) {
            if (this.f11492b.size() == 0 && this.f11491a.B(this.f11492b, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j10, this.f11492b.size());
            this.f11492b.skip(jMin);
            j10 -= jMin;
        }
    }

    public String toString() {
        return "buffer(" + this.f11491a + ')';
    }
}
