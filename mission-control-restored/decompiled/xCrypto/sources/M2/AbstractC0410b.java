package M2;

/* JADX INFO: renamed from: M2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0410b implements y0 {
    public final void e(int i4) {
        if (d() < i4) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // M2.y0
    public boolean markSupported() {
        return false;
    }

    public final int readInt() {
        e(4);
        return (readUnsignedByte() << 24) | (readUnsignedByte() << 16) | (readUnsignedByte() << 8) | readUnsignedByte();
    }

    @Override // M2.y0
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // M2.y0
    public void C() {
    }

    @Override // M2.y0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
