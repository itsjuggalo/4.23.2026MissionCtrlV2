package v1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: renamed from: v1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2834a extends c {
    public C2834a(i iVar, d dVar, long j8, int i8) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f23727a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j9 = j8 + ((long) (i8 * 8));
        this.f23725a = iVar.E(byteBufferAllocate, j9);
        this.f23726b = iVar.E(byteBufferAllocate, j9 + 4);
    }
}
