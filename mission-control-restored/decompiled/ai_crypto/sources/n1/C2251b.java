package n1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: renamed from: n1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2251b extends c {
    public C2251b(i iVar, d dVar, long j7, int i7) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVar.f19079a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j8 = j7 + ((long) (i7 * 16));
        this.f19077a = iVar.M(byteBufferAllocate, j8);
        this.f19078b = iVar.M(byteBufferAllocate, j8 + 8);
    }
}
