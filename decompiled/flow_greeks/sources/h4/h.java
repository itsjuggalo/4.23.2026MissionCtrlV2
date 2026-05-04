package h4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h extends d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f11003j;

    public h(boolean z10, i iVar) {
        this.f10988a = z10;
        this.f11003j = iVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(z10 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f10989b = iVar.C(byteBufferAllocate, 16L);
        this.f10990c = iVar.E(byteBufferAllocate, 32L);
        this.f10991d = iVar.E(byteBufferAllocate, 40L);
        this.f10992e = iVar.C(byteBufferAllocate, 54L);
        this.f10993f = iVar.C(byteBufferAllocate, 56L);
        this.f10994g = iVar.C(byteBufferAllocate, 58L);
        this.f10995h = iVar.C(byteBufferAllocate, 60L);
        this.f10996i = iVar.C(byteBufferAllocate, 62L);
    }

    @Override // h4.d
    public c a(long j10, int i10) {
        return new b(this.f11003j, this, j10, i10);
    }

    @Override // h4.d
    public e b(long j10) {
        return new k(this.f11003j, this, j10);
    }

    @Override // h4.d
    public f c(int i10) {
        return new m(this.f11003j, this, i10);
    }
}
