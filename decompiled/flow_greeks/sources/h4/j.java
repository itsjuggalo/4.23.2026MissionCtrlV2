package h4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j extends e {
    public j(i iVar, d dVar, long j10) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f10988a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j11 = dVar.f10990c + (j10 * ((long) dVar.f10992e));
        this.f10997a = iVar.H(byteBufferAllocate, j11);
        this.f10998b = iVar.H(byteBufferAllocate, 4 + j11);
        this.f10999c = iVar.H(byteBufferAllocate, 8 + j11);
        this.f11000d = iVar.H(byteBufferAllocate, j11 + 20);
    }
}
