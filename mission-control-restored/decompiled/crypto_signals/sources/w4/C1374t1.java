package w4;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: w4.t1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1374t1 extends InputStream implements u4.G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC1322c f11402a;

    @Override // java.io.InputStream
    public final int available() {
        return this.f11402a.m();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f11402a.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.f11402a.f();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f11402a.g();
    }

    @Override // java.io.InputStream
    public final int read() {
        AbstractC1322c abstractC1322c = this.f11402a;
        if (abstractC1322c.m() == 0) {
            return -1;
        }
        return abstractC1322c.l();
    }

    @Override // java.io.InputStream
    public final void reset() {
        this.f11402a.n();
    }

    @Override // java.io.InputStream
    public final long skip(long j4) {
        AbstractC1322c abstractC1322c = this.f11402a;
        int iMin = (int) Math.min(abstractC1322c.m(), j4);
        abstractC1322c.o(iMin);
        return iMin;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i6) {
        AbstractC1322c abstractC1322c = this.f11402a;
        if (abstractC1322c.m() == 0) {
            return -1;
        }
        int iMin = Math.min(abstractC1322c.m(), i6);
        abstractC1322c.k(bArr, i, iMin);
        return iMin;
    }
}
