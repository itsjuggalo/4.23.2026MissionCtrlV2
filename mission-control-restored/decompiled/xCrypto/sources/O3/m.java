package O3;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f3340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f3341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3342c;

    public m(r sink) {
        kotlin.jvm.internal.r.f(sink, "sink");
        this.f3340a = sink;
        this.f3341b = new d();
    }

    @Override // O3.e
    public e M(byte[] source) {
        kotlin.jvm.internal.r.f(source, "source");
        if (this.f3342c) {
            throw new IllegalStateException("closed");
        }
        this.f3341b.M(source);
        return e();
    }

    @Override // O3.r
    public void c0(d source, long j4) {
        kotlin.jvm.internal.r.f(source, "source");
        if (this.f3342c) {
            throw new IllegalStateException("closed");
        }
        this.f3341b.c0(source, j4);
        e();
    }

    @Override // O3.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f3342c) {
            return;
        }
        try {
            if (this.f3341b.i0() > 0) {
                r rVar = this.f3340a;
                d dVar = this.f3341b;
                rVar.c0(dVar, dVar.i0());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f3340a.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f3342c = true;
        if (th != null) {
            throw th;
        }
    }

    public e e() {
        if (this.f3342c) {
            throw new IllegalStateException("closed");
        }
        long jP = this.f3341b.p();
        if (jP > 0) {
            this.f3340a.c0(this.f3341b, jP);
        }
        return this;
    }

    @Override // O3.e, O3.r, java.io.Flushable
    public void flush() {
        if (this.f3342c) {
            throw new IllegalStateException("closed");
        }
        if (this.f3341b.i0() > 0) {
            r rVar = this.f3340a;
            d dVar = this.f3341b;
            rVar.c0(dVar, dVar.i0());
        }
        this.f3340a.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f3342c;
    }

    @Override // O3.e
    public e l(int i4) {
        if (this.f3342c) {
            throw new IllegalStateException("closed");
        }
        this.f3341b.l(i4);
        return e();
    }

    @Override // O3.e
    public e m(int i4) {
        if (this.f3342c) {
            throw new IllegalStateException("closed");
        }
        this.f3341b.m(i4);
        return e();
    }

    @Override // O3.e
    public e s(int i4) {
        if (this.f3342c) {
            throw new IllegalStateException("closed");
        }
        this.f3341b.s(i4);
        return e();
    }

    public String toString() {
        return "buffer(" + this.f3340a + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        kotlin.jvm.internal.r.f(source, "source");
        if (this.f3342c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f3341b.write(source);
        e();
        return iWrite;
    }

    @Override // O3.e
    public e y(String string) {
        kotlin.jvm.internal.r.f(string, "string");
        if (this.f3342c) {
            throw new IllegalStateException("closed");
        }
        this.f3341b.y(string);
        return e();
    }
}
