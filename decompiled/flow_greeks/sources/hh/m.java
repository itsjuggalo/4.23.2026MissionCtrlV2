package hh;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f11488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f11489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11490c;

    public m(r sink) {
        kotlin.jvm.internal.t.f(sink, "sink");
        this.f11488a = sink;
        this.f11489b = new d();
    }

    @Override // hh.r
    public void L(d source, long j10) {
        kotlin.jvm.internal.t.f(source, "source");
        if (this.f11490c) {
            throw new IllegalStateException("closed");
        }
        this.f11489b.L(source, j10);
        b();
    }

    public e b() {
        if (this.f11490c) {
            throw new IllegalStateException("closed");
        }
        long jC = this.f11489b.C();
        if (jC > 0) {
            this.f11488a.L(this.f11489b, jC);
        }
        return this;
    }

    @Override // hh.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f11490c) {
            return;
        }
        try {
            if (this.f11489b.size() > 0) {
                r rVar = this.f11488a;
                d dVar = this.f11489b;
                rVar.L(dVar, dVar.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f11488a.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f11490c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // hh.e, hh.r, java.io.Flushable
    public void flush() {
        if (this.f11490c) {
            throw new IllegalStateException("closed");
        }
        if (this.f11489b.size() > 0) {
            r rVar = this.f11488a;
            d dVar = this.f11489b;
            rVar.L(dVar, dVar.size());
        }
        this.f11488a.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f11490c;
    }

    public String toString() {
        return "buffer(" + this.f11488a + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        kotlin.jvm.internal.t.f(source, "source");
        if (this.f11490c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f11489b.write(source);
        b();
        return iWrite;
    }

    @Override // hh.e
    public e writeByte(int i10) {
        if (this.f11490c) {
            throw new IllegalStateException("closed");
        }
        this.f11489b.writeByte(i10);
        return b();
    }

    @Override // hh.e
    public e writeInt(int i10) {
        if (this.f11490c) {
            throw new IllegalStateException("closed");
        }
        this.f11489b.writeInt(i10);
        return b();
    }

    @Override // hh.e
    public e writeShort(int i10) {
        if (this.f11490c) {
            throw new IllegalStateException("closed");
        }
        this.f11489b.writeShort(i10);
        return b();
    }

    @Override // hh.e
    public e x(String string) {
        kotlin.jvm.internal.t.f(string, "string");
        if (this.f11490c) {
            throw new IllegalStateException("closed");
        }
        this.f11489b.x(string);
        return b();
    }

    @Override // hh.e
    public e write(byte[] source) {
        kotlin.jvm.internal.t.f(source, "source");
        if (!this.f11490c) {
            this.f11489b.write(source);
            return b();
        }
        throw new IllegalStateException("closed");
    }
}
