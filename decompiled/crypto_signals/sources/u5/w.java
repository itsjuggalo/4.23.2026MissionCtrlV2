package u5;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class w implements InterfaceC1251h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C f10551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1250g f10552b = new C1250g();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10553c;

    public w(C c6) {
        this.f10551a = c6;
    }

    @Override // u5.C
    public final void c(long j4, C1250g source) {
        kotlin.jvm.internal.j.e(source, "source");
        if (this.f10553c) {
            throw new IllegalStateException("closed");
        }
        this.f10552b.c(j4, source);
        d();
    }

    @Override // u5.C, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        C c6 = this.f10551a;
        if (this.f10553c) {
            return;
        }
        try {
            C1250g c1250g = this.f10552b;
            long j4 = c1250g.f10526b;
            if (j4 > 0) {
                c6.c(j4, c1250g);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            c6.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f10553c = true;
        if (th != null) {
            throw th;
        }
    }

    public final InterfaceC1251h d() {
        if (this.f10553c) {
            throw new IllegalStateException("closed");
        }
        C1250g c1250g = this.f10552b;
        long jF = c1250g.f();
        if (jF > 0) {
            this.f10551a.c(jF, c1250g);
        }
        return this;
    }

    @Override // u5.InterfaceC1251h
    public final InterfaceC1251h e(String string) {
        kotlin.jvm.internal.j.e(string, "string");
        if (this.f10553c) {
            throw new IllegalStateException("closed");
        }
        this.f10552b.E(string);
        d();
        return this;
    }

    public final InterfaceC1251h f(byte[] source) {
        kotlin.jvm.internal.j.e(source, "source");
        if (this.f10553c) {
            throw new IllegalStateException("closed");
        }
        this.f10552b.y(source);
        d();
        return this;
    }

    @Override // u5.C, java.io.Flushable
    public final void flush() {
        if (this.f10553c) {
            throw new IllegalStateException("closed");
        }
        C1250g c1250g = this.f10552b;
        long j4 = c1250g.f10526b;
        C c6 = this.f10551a;
        if (j4 > 0) {
            c6.c(j4, c1250g);
        }
        c6.flush();
    }

    public final InterfaceC1251h g(int i) {
        if (this.f10553c) {
            throw new IllegalStateException("closed");
        }
        this.f10552b.B(i);
        d();
        return this;
    }

    public final InterfaceC1251h h(int i) {
        if (this.f10553c) {
            throw new IllegalStateException("closed");
        }
        C1250g c1250g = this.f10552b;
        z zVarW = c1250g.w(4);
        int i6 = zVarW.f10560c;
        byte[] bArr = zVarW.f10558a;
        bArr[i6] = (byte) ((i >>> 24) & 255);
        bArr[i6 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i6 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i6 + 3] = (byte) (i & 255);
        zVarW.f10560c = i6 + 4;
        c1250g.f10526b += 4;
        d();
        return this;
    }

    public final InterfaceC1251h i(int i) {
        if (this.f10553c) {
            throw new IllegalStateException("closed");
        }
        C1250g c1250g = this.f10552b;
        z zVarW = c1250g.w(2);
        int i6 = zVarW.f10560c;
        byte[] bArr = zVarW.f10558a;
        bArr[i6] = (byte) ((i >>> 8) & 255);
        bArr[i6 + 1] = (byte) (i & 255);
        zVarW.f10560c = i6 + 2;
        c1250g.f10526b += 2;
        d();
        return this;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f10553c;
    }

    public final String toString() {
        return "buffer(" + this.f10551a + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        kotlin.jvm.internal.j.e(source, "source");
        if (this.f10553c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f10552b.write(source);
        d();
        return iWrite;
    }
}
