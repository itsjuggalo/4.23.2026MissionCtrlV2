package n1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class j extends e {
    public j(i iVar, d dVar, long j7) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f19079a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j8 = dVar.f19081c + (j7 * ((long) dVar.f19083e));
        this.f19088a = iVar.T(byteBufferAllocate, j8);
        this.f19089b = iVar.T(byteBufferAllocate, 4 + j8);
        this.f19090c = iVar.T(byteBufferAllocate, 8 + j8);
        this.f19091d = iVar.T(byteBufferAllocate, j8 + 20);
    }
}
