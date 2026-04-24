package t5;

import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class O implements y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y0 f23499a;

    public O(y0 y0Var) {
        this.f23499a = (y0) H2.m.o(y0Var, "buf");
    }

    @Override // t5.y0
    public void J(byte[] bArr, int i7, int i8) {
        this.f23499a.J(bArr, i7, i8);
    }

    @Override // t5.y0
    public void Q() {
        this.f23499a.Q();
    }

    @Override // t5.y0
    public int e() {
        return this.f23499a.e();
    }

    @Override // t5.y0
    public void f0(OutputStream outputStream, int i7) {
        this.f23499a.f0(outputStream, i7);
    }

    @Override // t5.y0
    public boolean markSupported() {
        return this.f23499a.markSupported();
    }

    @Override // t5.y0
    public void p0(ByteBuffer byteBuffer) {
        this.f23499a.p0(byteBuffer);
    }

    @Override // t5.y0
    public int readUnsignedByte() {
        return this.f23499a.readUnsignedByte();
    }

    @Override // t5.y0
    public void reset() {
        this.f23499a.reset();
    }

    @Override // t5.y0
    public y0 s(int i7) {
        return this.f23499a.s(i7);
    }

    @Override // t5.y0
    public void skipBytes(int i7) {
        this.f23499a.skipBytes(i7);
    }

    public String toString() {
        return H2.g.b(this).d("delegate", this.f23499a).toString();
    }
}
