package n1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class l extends f {
    public l(i iVar, d dVar, int i7) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f19079a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f19092a = iVar.T(byteBufferAllocate, dVar.f19082d + ((long) (i7 * dVar.f19085g)) + 28);
    }
}
