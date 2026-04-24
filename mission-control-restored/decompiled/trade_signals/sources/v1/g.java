package v1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class g extends d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f23741j;

    public g(boolean z7, i iVar) {
        this.f23727a = z7;
        this.f23741j = iVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(z7 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f23728b = iVar.r(byteBufferAllocate, 16L);
        this.f23729c = iVar.E(byteBufferAllocate, 28L);
        this.f23730d = iVar.E(byteBufferAllocate, 32L);
        this.f23731e = iVar.r(byteBufferAllocate, 42L);
        this.f23732f = iVar.r(byteBufferAllocate, 44L);
        this.f23733g = iVar.r(byteBufferAllocate, 46L);
        this.f23734h = iVar.r(byteBufferAllocate, 48L);
        this.f23735i = iVar.r(byteBufferAllocate, 50L);
    }

    @Override // v1.d
    public c a(long j8, int i8) {
        return new C2834a(this.f23741j, this, j8, i8);
    }

    @Override // v1.d
    public e b(long j8) {
        return new j(this.f23741j, this, j8);
    }

    @Override // v1.d
    public f c(int i8) {
        return new l(this.f23741j, this, i8);
    }
}
