package q1;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: q1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2620c extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f22518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22519b;

    public C2620c(InputStream inputStream, long j8) {
        super(inputStream);
        this.f22518a = j8;
    }

    public static InputStream c(InputStream inputStream, long j8) {
        return new C2620c(inputStream, j8);
    }

    public final int a(int i8) throws IOException {
        if (i8 >= 0) {
            this.f22519b += i8;
        } else if (this.f22518a - ((long) this.f22519b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f22518a + ", but read: " + this.f22519b);
        }
        return i8;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.f22518a - ((long) this.f22519b), ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int i8;
        i8 = super.read();
        a(i8 >= 0 ? 1 : -1);
        return i8;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i8, int i9) {
        return a(super.read(bArr, i8, i9));
    }
}
