package n1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: renamed from: n1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2250a extends c {
    public C2250a(i iVar, d dVar, long j7, int i7) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f19079a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j8 = j7 + ((long) (i7 * 8));
        this.f19077a = iVar.T(byteBufferAllocate, j8);
        this.f19078b = iVar.T(byteBufferAllocate, j8 + 4);
    }
}
