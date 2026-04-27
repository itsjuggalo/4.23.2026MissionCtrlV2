package q1;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: q1.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2626i extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22534a;

    public C2626i(InputStream inputStream) {
        super(inputStream);
        this.f22534a = Integer.MIN_VALUE;
    }

    public final long a(long j8) {
        int i8 = this.f22534a;
        if (i8 == 0) {
            return -1L;
        }
        return (i8 == Integer.MIN_VALUE || j8 <= ((long) i8)) ? j8 : i8;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int i8 = this.f22534a;
        return i8 == Integer.MIN_VALUE ? super.available() : Math.min(i8, super.available());
    }

    public final void c(long j8) {
        int i8 = this.f22534a;
        if (i8 == Integer.MIN_VALUE || j8 == -1) {
            return;
        }
        this.f22534a = (int) (((long) i8) - j8);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i8) {
        super.mark(i8);
        this.f22534a = i8;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int i8 = super.read();
        c(1L);
        return i8;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        this.f22534a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j8) throws IOException {
        long jA = a(j8);
        if (jA == -1) {
            return 0L;
        }
        long jSkip = super.skip(jA);
        c(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i8, int i9) throws IOException {
        int iA = (int) a(i9);
        if (iA == -1) {
            return -1;
        }
        int i10 = super.read(bArr, i8, iA);
        c(i10);
        return i10;
    }
}
