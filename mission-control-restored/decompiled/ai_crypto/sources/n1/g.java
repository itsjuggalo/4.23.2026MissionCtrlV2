package n1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class g extends d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f19093j;

    public g(boolean z7, i iVar) {
        this.f19079a = z7;
        this.f19093j = iVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(z7 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f19080b = iVar.K(byteBufferAllocate, 16L);
        this.f19081c = iVar.T(byteBufferAllocate, 28L);
        this.f19082d = iVar.T(byteBufferAllocate, 32L);
        this.f19083e = iVar.K(byteBufferAllocate, 42L);
        this.f19084f = iVar.K(byteBufferAllocate, 44L);
        this.f19085g = iVar.K(byteBufferAllocate, 46L);
        this.f19086h = iVar.K(byteBufferAllocate, 48L);
        this.f19087i = iVar.K(byteBufferAllocate, 50L);
    }

    @Override // n1.d
    public c a(long j7, int i7) {
        return new C2250a(this.f19093j, this, j7, i7);
    }

    @Override // n1.d
    public e b(long j7) {
        return new j(this.f19093j, this, j7);
    }

    @Override // n1.d
    public f c(int i7) {
        return new l(this.f19093j, this, i7);
    }
}
