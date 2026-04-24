package W1;

import java.io.OutputStream;
import s3.D;

/* JADX INFO: loaded from: classes.dex */
public final class f extends OutputStream {
    public final String toString() {
        return "ByteStreams.nullOutputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        bArr.getClass();
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i6) {
        bArr.getClass();
        D.m(i, i6 + i, bArr.length);
    }
}
