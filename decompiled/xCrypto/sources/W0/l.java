package W0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class l extends f {
    public l(i iVar, d dVar, int i4) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f5416a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f5429a = iVar.J(byteBufferAllocate, dVar.f5419d + ((long) (i4 * dVar.f5422g)) + 28);
    }
}
