package n1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class h extends d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f19094j;

    public h(boolean z7, i iVar) {
        this.f19079a = z7;
        this.f19094j = iVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(z7 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f19080b = iVar.K(byteBufferAllocate, 16L);
        this.f19081c = iVar.M(byteBufferAllocate, 32L);
        this.f19082d = iVar.M(byteBufferAllocate, 40L);
        this.f19083e = iVar.K(byteBufferAllocate, 54L);
        this.f19084f = iVar.K(byteBufferAllocate, 56L);
        this.f19085g = iVar.K(byteBufferAllocate, 58L);
        this.f19086h = iVar.K(byteBufferAllocate, 60L);
        this.f19087i = iVar.K(byteBufferAllocate, 62L);
    }

    @Override // n1.d
    public c a(long j7, int i7) {
        return new C2251b(this.f19094j, this, j7, i7);
    }

    @Override // n1.d
    public e b(long j7) {
        return new k(this.f19094j, this, j7);
    }

    @Override // n1.d
    public f c(int i7) {
        return new m(this.f19094j, this, i7);
    }
}
