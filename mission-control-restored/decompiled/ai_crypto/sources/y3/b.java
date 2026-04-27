package y3;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class b extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f25645a = 0;

    public long h() {
        return this.f25645a;
    }

    @Override // java.io.OutputStream
    public void write(int i7) {
        this.f25645a++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f25645a += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i7, int i8) {
        int i9;
        if (i7 >= 0 && i7 <= bArr.length && i8 >= 0 && (i9 = i7 + i8) <= bArr.length && i9 >= 0) {
            this.f25645a += (long) i8;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
