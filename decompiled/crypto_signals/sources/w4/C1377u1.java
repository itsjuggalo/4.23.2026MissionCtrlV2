package w4;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

/* JADX INFO: renamed from: w4.u1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1377u1 extends AbstractC1322c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f11409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11410d = -1;

    public C1377u1(byte[] bArr, int i, int i6) {
        s3.D.f("offset must be >= 0", i >= 0);
        s3.D.f("length must be >= 0", i6 >= 0);
        int i7 = i6 + i;
        s3.D.f("offset + length exceeds array boundary", i7 <= bArr.length);
        this.f11409c = bArr;
        this.f11407a = i;
        this.f11408b = i7;
    }

    @Override // w4.AbstractC1322c
    public final void f() {
        this.f11410d = this.f11407a;
    }

    @Override // w4.AbstractC1322c
    public final AbstractC1322c h(int i) {
        d(i);
        int i6 = this.f11407a;
        this.f11407a = i6 + i;
        return new C1377u1(this.f11409c, i6, i);
    }

    @Override // w4.AbstractC1322c
    public final void i(OutputStream outputStream, int i) throws IOException {
        d(i);
        outputStream.write(this.f11409c, this.f11407a, i);
        this.f11407a += i;
    }

    @Override // w4.AbstractC1322c
    public final void j(ByteBuffer byteBuffer) {
        s3.D.j(byteBuffer, "dest");
        int iRemaining = byteBuffer.remaining();
        d(iRemaining);
        byteBuffer.put(this.f11409c, this.f11407a, iRemaining);
        this.f11407a += iRemaining;
    }

    @Override // w4.AbstractC1322c
    public final void k(byte[] bArr, int i, int i6) {
        System.arraycopy(this.f11409c, this.f11407a, bArr, i, i6);
        this.f11407a += i6;
    }

    @Override // w4.AbstractC1322c
    public final int l() {
        d(1);
        int i = this.f11407a;
        this.f11407a = i + 1;
        return this.f11409c[i] & 255;
    }

    @Override // w4.AbstractC1322c
    public final int m() {
        return this.f11408b - this.f11407a;
    }

    @Override // w4.AbstractC1322c
    public final void n() {
        int i = this.f11410d;
        if (i == -1) {
            throw new InvalidMarkException();
        }
        this.f11407a = i;
    }

    @Override // w4.AbstractC1322c
    public final void o(int i) {
        d(i);
        this.f11407a += i;
    }
}
