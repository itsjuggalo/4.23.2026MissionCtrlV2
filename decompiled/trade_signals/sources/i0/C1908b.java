package i0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: renamed from: i0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1908b extends AbstractC1909c {
    public static C1908b h(ByteBuffer byteBuffer) {
        return i(byteBuffer, new C1908b());
    }

    public static C1908b i(ByteBuffer byteBuffer, C1908b c1908b) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return c1908b.f(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public C1908b f(int i8, ByteBuffer byteBuffer) {
        g(i8, byteBuffer);
        return this;
    }

    public void g(int i8, ByteBuffer byteBuffer) {
        c(i8, byteBuffer);
    }

    public C1907a j(C1907a c1907a, int i8) {
        int iB = b(6);
        if (iB != 0) {
            return c1907a.f(a(d(iB) + (i8 * 4)), this.f18746b);
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
            return this.f18746b.getInt(iB + this.f18745a);
        }
        return 0;
    }
}
