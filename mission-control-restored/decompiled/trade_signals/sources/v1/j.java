package v1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class j extends e {
    public j(i iVar, d dVar, long j8) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f23727a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j9 = dVar.f23729c + (j8 * ((long) dVar.f23731e));
        this.f23736a = iVar.E(byteBufferAllocate, j9);
        this.f23737b = iVar.E(byteBufferAllocate, 4 + j9);
        this.f23738c = iVar.E(byteBufferAllocate, 8 + j9);
        this.f23739d = iVar.E(byteBufferAllocate, j9 + 20);
    }
}
