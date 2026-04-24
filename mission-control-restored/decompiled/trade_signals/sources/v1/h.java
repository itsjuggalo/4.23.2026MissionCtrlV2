package v1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class h extends d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f23742j;

    public h(boolean z7, i iVar) {
        this.f23727a = z7;
        this.f23742j = iVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(z7 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f23728b = iVar.r(byteBufferAllocate, 16L);
        this.f23729c = iVar.B(byteBufferAllocate, 32L);
        this.f23730d = iVar.B(byteBufferAllocate, 40L);
        this.f23731e = iVar.r(byteBufferAllocate, 54L);
        this.f23732f = iVar.r(byteBufferAllocate, 56L);
        this.f23733g = iVar.r(byteBufferAllocate, 58L);
        this.f23734h = iVar.r(byteBufferAllocate, 60L);
        this.f23735i = iVar.r(byteBufferAllocate, 62L);
    }

    @Override // v1.d
    public c a(long j8, int i8) {
        return new b(this.f23742j, this, j8, i8);
    }

    @Override // v1.d
    public e b(long j8) {
        return new k(this.f23742j, this, j8);
    }

    @Override // v1.d
    public f c(int i8) {
        return new m(this.f23742j, this, i8);
    }
}
