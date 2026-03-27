package W0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class g extends d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f5430j;

    public g(boolean z4, i iVar) {
        this.f5416a = z4;
        this.f5430j = iVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(z4 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f5417b = iVar.A(byteBufferAllocate, 16L);
        this.f5418c = iVar.J(byteBufferAllocate, 28L);
        this.f5419d = iVar.J(byteBufferAllocate, 32L);
        this.f5420e = iVar.A(byteBufferAllocate, 42L);
        this.f5421f = iVar.A(byteBufferAllocate, 44L);
        this.f5422g = iVar.A(byteBufferAllocate, 46L);
        this.f5423h = iVar.A(byteBufferAllocate, 48L);
        this.f5424i = iVar.A(byteBufferAllocate, 50L);
    }

    @Override // W0.d
    public c a(long j4, int i4) {
        return new a(this.f5430j, this, j4, i4);
    }

    @Override // W0.d
    public e b(long j4) {
        return new j(this.f5430j, this, j4);
    }

    @Override // W0.d
    public f c(int i4) {
        return new l(this.f5430j, this, i4);
    }
}
