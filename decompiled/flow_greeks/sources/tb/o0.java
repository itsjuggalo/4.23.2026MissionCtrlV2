package tb;

import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o0 implements x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x1 f21563a;

    public o0(x1 x1Var) {
        this.f21563a = (x1) p6.n.o(x1Var, "buf");
    }

    @Override // tb.x1
    public void D() {
        this.f21563a.D();
    }

    @Override // tb.x1
    public void P(OutputStream outputStream, int i10) {
        this.f21563a.P(outputStream, i10);
    }

    @Override // tb.x1
    public void W(ByteBuffer byteBuffer) {
        this.f21563a.W(byteBuffer);
    }

    @Override // tb.x1
    public int d() {
        return this.f21563a.d();
    }

    @Override // tb.x1
    public boolean markSupported() {
        return this.f21563a.markSupported();
    }

    @Override // tb.x1
    public x1 n(int i10) {
        return this.f21563a.n(i10);
    }

    @Override // tb.x1
    public int readUnsignedByte() {
        return this.f21563a.readUnsignedByte();
    }

    @Override // tb.x1
    public void reset() {
        this.f21563a.reset();
    }

    @Override // tb.x1
    public void skipBytes(int i10) {
        this.f21563a.skipBytes(i10);
    }

    public String toString() {
        return p6.h.b(this).d("delegate", this.f21563a).toString();
    }

    @Override // tb.x1
    public void z(byte[] bArr, int i10, int i11) {
        this.f21563a.z(bArr, i10, i11);
    }
}
