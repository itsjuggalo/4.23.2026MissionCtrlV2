package i0;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: i0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1737c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f14982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AbstractC1738d f14985e = AbstractC1738d.a();

    public int a(int i7) {
        return i7 + this.f14982b.getInt(i7);
    }

    public int b(int i7) {
        if (i7 < this.f14984d) {
            return this.f14982b.getShort(this.f14983c + i7);
        }
        return 0;
    }

    public void c(int i7, ByteBuffer byteBuffer) {
        this.f14982b = byteBuffer;
        if (byteBuffer == null) {
            this.f14981a = 0;
            this.f14983c = 0;
            this.f14984d = 0;
        } else {
            this.f14981a = i7;
            int i8 = i7 - byteBuffer.getInt(i7);
            this.f14983c = i8;
            this.f14984d = this.f14982b.getShort(i8);
        }
    }

    public int d(int i7) {
        int i8 = i7 + this.f14981a;
        return i8 + this.f14982b.getInt(i8) + 4;
    }

    public int e(int i7) {
        int i8 = i7 + this.f14981a;
        return this.f14982b.getInt(i8 + this.f14982b.getInt(i8));
    }
}
