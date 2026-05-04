package h4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g extends d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f11002j;

    public g(boolean z10, i iVar) {
        this.f10988a = z10;
        this.f11002j = iVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(z10 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f10989b = iVar.C(byteBufferAllocate, 16L);
        this.f10990c = iVar.H(byteBufferAllocate, 28L);
        this.f10991d = iVar.H(byteBufferAllocate, 32L);
        this.f10992e = iVar.C(byteBufferAllocate, 42L);
        this.f10993f = iVar.C(byteBufferAllocate, 44L);
        this.f10994g = iVar.C(byteBufferAllocate, 46L);
        this.f10995h = iVar.C(byteBufferAllocate, 48L);
        this.f10996i = iVar.C(byteBufferAllocate, 50L);
    }

    @Override // h4.d
    public c a(long j10, int i10) {
        return new a(this.f11002j, this, j10, i10);
    }

    @Override // h4.d
    public e b(long j10) {
        return new j(this.f11002j, this, j10);
    }

    @Override // h4.d
    public f c(int i10) {
        return new l(this.f11002j, this, i10);
    }
}
