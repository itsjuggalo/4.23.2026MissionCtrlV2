package n1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class k extends e {
    public k(i iVar, d dVar, long j7) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVar.f19079a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j8 = dVar.f19081c + (j7 * ((long) dVar.f19083e));
        this.f19088a = iVar.T(byteBufferAllocate, j8);
        this.f19089b = iVar.M(byteBufferAllocate, 8 + j8);
        this.f19090c = iVar.M(byteBufferAllocate, 16 + j8);
        this.f19091d = iVar.M(byteBufferAllocate, j8 + 40);
    }
}
