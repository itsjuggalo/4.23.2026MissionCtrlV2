package X;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class c extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f3358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteOrder f3359b;

    public c(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.f3358a = outputStream;
        this.f3359b = byteOrder;
    }

    public final void d(int i) throws IOException {
        this.f3358a.write(i);
    }

    public final void f(int i) throws IOException {
        ByteOrder byteOrder = this.f3359b;
        ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
        OutputStream outputStream = this.f3358a;
        if (byteOrder == byteOrder2) {
            outputStream.write(i & 255);
            outputStream.write((i >>> 8) & 255);
            outputStream.write((i >>> 16) & 255);
            outputStream.write((i >>> 24) & 255);
            return;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            outputStream.write((i >>> 24) & 255);
            outputStream.write((i >>> 16) & 255);
            outputStream.write((i >>> 8) & 255);
            outputStream.write(i & 255);
        }
    }

    public final void g(short s6) throws IOException {
        ByteOrder byteOrder = this.f3359b;
        ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
        OutputStream outputStream = this.f3358a;
        if (byteOrder == byteOrder2) {
            outputStream.write(s6 & 255);
            outputStream.write((s6 >>> 8) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            outputStream.write((s6 >>> 8) & 255);
            outputStream.write(s6 & 255);
        }
    }

    public final void h(long j4) throws IOException {
        if (j4 > 4294967295L) {
            throw new IllegalArgumentException("val is larger than the maximum value of a 32-bit unsigned integer");
        }
        f((int) j4);
    }

    public final void i(int i) throws IOException {
        if (i > 65535) {
            throw new IllegalArgumentException("val is larger than the maximum value of a 16-bit unsigned integer");
        }
        g((short) i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        this.f3358a.write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i6) throws IOException {
        this.f3358a.write(bArr, i, i6);
    }
}
