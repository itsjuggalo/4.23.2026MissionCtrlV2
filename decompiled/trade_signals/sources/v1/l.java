package v1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class l extends f {
    public l(i iVar, d dVar, int i8) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f23727a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f23740a = iVar.E(byteBufferAllocate, dVar.f23730d + ((long) (i8 * dVar.f23733g)) + 28);
    }
}
