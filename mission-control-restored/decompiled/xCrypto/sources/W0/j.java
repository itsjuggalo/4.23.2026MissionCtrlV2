package W0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class j extends e {
    public j(i iVar, d dVar, long j4) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f5416a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j5 = dVar.f5418c + (j4 * ((long) dVar.f5420e));
        this.f5425a = iVar.J(byteBufferAllocate, j5);
        this.f5426b = iVar.J(byteBufferAllocate, 4 + j5);
        this.f5427c = iVar.J(byteBufferAllocate, 8 + j5);
        this.f5428d = iVar.J(byteBufferAllocate, j5 + 20);
    }
}
