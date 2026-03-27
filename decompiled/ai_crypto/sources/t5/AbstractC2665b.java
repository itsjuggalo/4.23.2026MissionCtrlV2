package t5;

/* JADX INFO: renamed from: t5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2665b implements y0 {
    public final void h(int i7) {
        if (e() < i7) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // t5.y0
    public boolean markSupported() {
        return false;
    }

    public final int readInt() {
        h(4);
        return (readUnsignedByte() << 24) | (readUnsignedByte() << 16) | (readUnsignedByte() << 8) | readUnsignedByte();
    }

    @Override // t5.y0
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // t5.y0
    public void Q() {
    }

    @Override // t5.y0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
