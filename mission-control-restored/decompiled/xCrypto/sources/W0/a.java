package W0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class a extends c {
    public a(i iVar, d dVar, long j4, int i4) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f5416a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j5 = j4 + ((long) (i4 * 8));
        this.f5414a = iVar.J(byteBufferAllocate, j5);
        this.f5415b = iVar.J(byteBufferAllocate, j5 + 4);
    }
}
