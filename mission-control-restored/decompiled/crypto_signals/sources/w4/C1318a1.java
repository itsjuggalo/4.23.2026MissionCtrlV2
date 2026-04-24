package w4;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import u4.AbstractC1225g;

/* JADX INFO: renamed from: w4.a1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1318a1 extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a2 f11172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f11173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f11174d;
    public long e;

    public C1318a1(InputStream inputStream, int i, a2 a2Var) {
        super(inputStream);
        this.e = -1L;
        this.f11171a = i;
        this.f11172b = a2Var;
    }

    public final void d() {
        long j4 = this.f11174d;
        long j6 = this.f11173c;
        if (j4 > j6) {
            long j7 = j4 - j6;
            for (AbstractC1225g abstractC1225g : this.f11172b.f11175a) {
                abstractC1225g.f(j7);
            }
            this.f11173c = this.f11174d;
        }
    }

    public final void f() {
        long j4 = this.f11174d;
        int i = this.f11171a;
        if (j4 <= i) {
            return;
        }
        throw new u4.l0(u4.j0.f10440k.g("Decompressed gRPC message exceeds maximum size " + i));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        ((FilterInputStream) this).in.mark(i);
        this.e = this.f11174d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i = ((FilterInputStream) this).in.read();
        if (i != -1) {
            this.f11174d++;
        }
        f();
        d();
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.e == -1) {
            throw new IOException("Mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.f11174d = this.e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j4) throws IOException {
        long jSkip = ((FilterInputStream) this).in.skip(j4);
        this.f11174d += jSkip;
        f();
        d();
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i6) throws IOException {
        int i7 = ((FilterInputStream) this).in.read(bArr, i, i6);
        if (i7 != -1) {
            this.f11174d += (long) i7;
        }
        f();
        d();
        return i7;
    }
}
