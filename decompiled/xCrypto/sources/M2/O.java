package M2;

import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class O implements y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y0 f1948a;

    public O(y0 y0Var) {
        this.f1948a = (y0) Z1.m.o(y0Var, "buf");
    }

    @Override // M2.y0
    public void C() {
        this.f1948a.C();
    }

    @Override // M2.y0
    public void Q(OutputStream outputStream, int i4) {
        this.f1948a.Q(outputStream, i4);
    }

    @Override // M2.y0
    public void Z(ByteBuffer byteBuffer) {
        this.f1948a.Z(byteBuffer);
    }

    @Override // M2.y0
    public int d() {
        return this.f1948a.d();
    }

    @Override // M2.y0
    public boolean markSupported() {
        return this.f1948a.markSupported();
    }

    @Override // M2.y0
    public y0 o(int i4) {
        return this.f1948a.o(i4);
    }

    @Override // M2.y0
    public int readUnsignedByte() {
        return this.f1948a.readUnsignedByte();
    }

    @Override // M2.y0
    public void reset() {
        this.f1948a.reset();
    }

    @Override // M2.y0
    public void skipBytes(int i4) {
        this.f1948a.skipBytes(i4);
    }

    public String toString() {
        return Z1.g.b(this).d("delegate", this.f1948a).toString();
    }

    @Override // M2.y0
    public void z(byte[] bArr, int i4, int i5) {
        this.f1948a.z(bArr, i4, i5);
    }
}
