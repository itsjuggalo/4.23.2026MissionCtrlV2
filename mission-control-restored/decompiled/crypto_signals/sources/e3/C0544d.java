package e3;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: e3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0544d extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f6133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f6134b;

    public C0544d(InputStream inputStream) {
        super(inputStream);
        this.f6134b = -1L;
        this.f6133a = 1048577L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        return (int) Math.min(((FilterInputStream) this).in.available(), this.f6133a);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        ((FilterInputStream) this).in.mark(i);
        this.f6134b = this.f6133a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (this.f6133a == 0) {
            return -1;
        }
        int i = ((FilterInputStream) this).in.read();
        if (i != -1) {
            this.f6133a--;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.f6134b == -1) {
            throw new IOException("Mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.f6133a = this.f6134b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j4) throws IOException {
        long jSkip = ((FilterInputStream) this).in.skip(Math.min(j4, this.f6133a));
        this.f6133a -= jSkip;
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i6) throws IOException {
        long j4 = this.f6133a;
        if (j4 == 0) {
            return -1;
        }
        int i7 = ((FilterInputStream) this).in.read(bArr, i, (int) Math.min(i6, j4));
        if (i7 != -1) {
            this.f6133a -= (long) i7;
        }
        return i7;
    }
}
