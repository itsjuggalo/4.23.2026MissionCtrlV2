package G4;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import v2.AbstractC2842h;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class O implements y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y0 f2536a;

    public O(y0 y0Var) {
        this.f2536a = (y0) AbstractC2848n.o(y0Var, "buf");
    }

    @Override // G4.y0
    public void J(byte[] bArr, int i8, int i9) {
        this.f2536a.J(bArr, i8, i9);
    }

    @Override // G4.y0
    public void P() {
        this.f2536a.P();
    }

    @Override // G4.y0
    public int d() {
        return this.f2536a.d();
    }

    @Override // G4.y0
    public void e0(OutputStream outputStream, int i8) {
        this.f2536a.e0(outputStream, i8);
    }

    @Override // G4.y0
    public boolean markSupported() {
        return this.f2536a.markSupported();
    }

    @Override // G4.y0
    public void p0(ByteBuffer byteBuffer) {
        this.f2536a.p0(byteBuffer);
    }

    @Override // G4.y0
    public int readUnsignedByte() {
        return this.f2536a.readUnsignedByte();
    }

    @Override // G4.y0
    public void reset() {
        this.f2536a.reset();
    }

    @Override // G4.y0
    public void skipBytes(int i8) {
        this.f2536a.skipBytes(i8);
    }

    @Override // G4.y0
    public y0 t(int i8) {
        return this.f2536a.t(i8);
    }

    public String toString() {
        return AbstractC2842h.b(this).d("delegate", this.f2536a).toString();
    }
}
