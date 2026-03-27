package W0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class h extends d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f5431j;

    public h(boolean z4, i iVar) {
        this.f5416a = z4;
        this.f5431j = iVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(z4 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f5417b = iVar.A(byteBufferAllocate, 16L);
        this.f5418c = iVar.E(byteBufferAllocate, 32L);
        this.f5419d = iVar.E(byteBufferAllocate, 40L);
        this.f5420e = iVar.A(byteBufferAllocate, 54L);
        this.f5421f = iVar.A(byteBufferAllocate, 56L);
        this.f5422g = iVar.A(byteBufferAllocate, 58L);
        this.f5423h = iVar.A(byteBufferAllocate, 60L);
        this.f5424i = iVar.A(byteBufferAllocate, 62L);
    }

    @Override // W0.d
    public c a(long j4, int i4) {
        return new b(this.f5431j, this, j4, i4);
    }

    @Override // W0.d
    public e b(long j4) {
        return new k(this.f5431j, this, j4);
    }

    @Override // W0.d
    public f c(int i4) {
        return new m(this.f5431j, this, i4);
    }
}
