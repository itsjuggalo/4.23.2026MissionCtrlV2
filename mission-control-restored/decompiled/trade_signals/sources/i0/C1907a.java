package i0;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: i0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1907a extends AbstractC1909c {
    public C1907a f(int i8, ByteBuffer byteBuffer) {
        g(i8, byteBuffer);
        return this;
    }

    public void g(int i8, ByteBuffer byteBuffer) {
        c(i8, byteBuffer);
    }

    public int h(int i8) {
        int iB = b(16);
        if (iB != 0) {
            return this.f18746b.getInt(d(iB) + (i8 * 4));
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
        return (iB == 0 || this.f18746b.get(iB + this.f18745a) == 0) ? false : true;
    }

    public short k() {
        int iB = b(14);
        if (iB != 0) {
            return this.f18746b.getShort(iB + this.f18745a);
        }
        return (short) 0;
    }

    public int l() {
        int iB = b(4);
        if (iB != 0) {
            return this.f18746b.getInt(iB + this.f18745a);
        }
        return 0;
    }

    public short m() {
        int iB = b(8);
        if (iB != 0) {
            return this.f18746b.getShort(iB + this.f18745a);
        }
        return (short) 0;
    }

    public short n() {
        int iB = b(12);
        if (iB != 0) {
            return this.f18746b.getShort(iB + this.f18745a);
        }
        return (short) 0;
    }
}
