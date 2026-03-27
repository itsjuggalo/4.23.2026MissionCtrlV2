package I2;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class b extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f627a;

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.f627a++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f627a += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i6) {
        int i7;
        if (i >= 0 && i <= bArr.length && i6 >= 0 && (i7 = i + i6) <= bArr.length && i7 >= 0) {
            this.f627a += (long) i6;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
