package tb;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements x1 {
    public final void b(int i10) {
        if (d() < i10) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // tb.x1
    public boolean markSupported() {
        return false;
    }

    public final int readInt() {
        b(4);
        return (readUnsignedByte() << 24) | (readUnsignedByte() << 16) | (readUnsignedByte() << 8) | readUnsignedByte();
    }

    @Override // tb.x1
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // tb.x1
    public void D() {
    }

    @Override // tb.x1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
