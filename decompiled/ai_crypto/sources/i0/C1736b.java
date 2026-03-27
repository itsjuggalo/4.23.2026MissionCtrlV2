package i0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: renamed from: i0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1736b extends AbstractC1737c {
    public static C1736b h(ByteBuffer byteBuffer) {
        return i(byteBuffer, new C1736b());
    }

    public static C1736b i(ByteBuffer byteBuffer, C1736b c1736b) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return c1736b.f(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public C1736b f(int i7, ByteBuffer byteBuffer) {
        g(i7, byteBuffer);
        return this;
    }

    public void g(int i7, ByteBuffer byteBuffer) {
        c(i7, byteBuffer);
    }

    public C1735a j(C1735a c1735a, int i7) {
        int iB = b(6);
        if (iB != 0) {
            return c1735a.f(a(d(iB) + (i7 * 4)), this.f14982b);
        }
        return null;
    }

    public int k() {
        int iB = b(6);
        if (iB != 0) {
            return e(iB);
        }
        return 0;
    }

    public int l() {
        int iB = b(4);
        if (iB != 0) {
            return this.f14982b.getInt(iB + this.f14981a);
        }
        return 0;
    }
}
