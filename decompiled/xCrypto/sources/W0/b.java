package W0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class b extends c {
    public b(i iVar, d dVar, long j4, int i4) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVar.f5416a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j5 = j4 + ((long) (i4 * 16));
        this.f5414a = iVar.E(byteBufferAllocate, j5);
        this.f5415b = iVar.E(byteBufferAllocate, j5 + 8);
    }
}
