package W0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class k extends e {
    public k(i iVar, d dVar, long j4) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVar.f5416a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j5 = dVar.f5418c + (j4 * ((long) dVar.f5420e));
        this.f5425a = iVar.J(byteBufferAllocate, j5);
        this.f5426b = iVar.E(byteBufferAllocate, 8 + j5);
        this.f5427c = iVar.E(byteBufferAllocate, 16 + j5);
        this.f5428d = iVar.E(byteBufferAllocate, j5 + 40);
    }
}
