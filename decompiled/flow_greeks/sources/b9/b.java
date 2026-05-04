package b9;

import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3037a = 0;

    public long b() {
        return this.f3037a;
    }

    @Override // java.io.OutputStream
    public void write(int i10) {
        this.f3037a++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f3037a += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        int i12;
        if (i10 >= 0 && i10 <= bArr.length && i11 >= 0 && (i12 = i10 + i11) <= bArr.length && i12 >= 0) {
            this.f3037a += (long) i11;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
