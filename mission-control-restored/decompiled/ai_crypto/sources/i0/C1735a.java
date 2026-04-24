package i0;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: i0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1735a extends AbstractC1737c {
    public C1735a f(int i7, ByteBuffer byteBuffer) {
        g(i7, byteBuffer);
        return this;
    }

    public void g(int i7, ByteBuffer byteBuffer) {
        c(i7, byteBuffer);
    }

    public int h(int i7) {
        int iB = b(16);
        if (iB != 0) {
            return this.f14982b.getInt(d(iB) + (i7 * 4));
        }
        return 0;
    }

    public int i() {
        int iB = b(16);
        if (iB != 0) {
            return e(iB);
        }
        return 0;
    }

    public boolean j() {
        int iB = b(6);
        return (iB == 0 || this.f14982b.get(iB + this.f14981a) == 0) ? false : true;
    }

    public short k() {
        int iB = b(14);
        if (iB != 0) {
            return this.f14982b.getShort(iB + this.f14981a);
        }
        return (short) 0;
    }

    public int l() {
        int iB = b(4);
        if (iB != 0) {
            return this.f14982b.getInt(iB + this.f14981a);
        }
        return 0;
    }

    public short m() {
        int iB = b(8);
        if (iB != 0) {
            return this.f14982b.getShort(iB + this.f14981a);
        }
        return (short) 0;
    }

    public short n() {
        int iB = b(12);
        if (iB != 0) {
            return this.f14982b.getShort(iB + this.f14981a);
        }
        return (short) 0;
    }
}
