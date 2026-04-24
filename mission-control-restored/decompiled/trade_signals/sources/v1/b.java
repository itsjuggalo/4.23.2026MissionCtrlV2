package v1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class b extends c {
    public b(i iVar, d dVar, long j8, int i8) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVar.f23727a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j9 = j8 + ((long) (i8 * 16));
        this.f23725a = iVar.B(byteBufferAllocate, j9);
        this.f23726b = iVar.B(byteBufferAllocate, j9 + 8);
    }
}
