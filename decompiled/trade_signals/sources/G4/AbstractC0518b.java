package G4;

/* JADX INFO: renamed from: G4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0518b implements y0 {
    public final void a(int i8) {
        if (d() < i8) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // G4.y0
    public boolean markSupported() {
        return false;
    }

    public final int readInt() {
        a(4);
        return (readUnsignedByte() << 24) | (readUnsignedByte() << 16) | (readUnsignedByte() << 8) | readUnsignedByte();
    }

    @Override // G4.y0
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // G4.y0
    public void P() {
    }

    @Override // G4.y0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
