package c4;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3577b;

    public c(InputStream inputStream, long j10) {
        super(inputStream);
        this.f3576a = j10;
    }

    public static InputStream c(InputStream inputStream, long j10) {
        return new c(inputStream, j10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.f3576a - ((long) this.f3577b), ((FilterInputStream) this).in.available());
    }

    public final int b(int i10) throws IOException {
        if (i10 >= 0) {
            this.f3577b += i10;
            return i10;
        }
        if (this.f3576a - ((long) this.f3577b) <= 0) {
            return i10;
        }
        throw new IOException("Failed to read all expected data, expected: " + this.f3576a + ", but read: " + this.f3577b);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int i10;
        i10 = super.read();
        b(i10 >= 0 ? 1 : -1);
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i10, int i11) {
        return b(super.read(bArr, i10, i11));
    }
}
