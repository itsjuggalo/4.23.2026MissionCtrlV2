package i0;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: i0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1909c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f18746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f18748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AbstractC1910d f18749e = AbstractC1910d.a();

    public int a(int i8) {
        return i8 + this.f18746b.getInt(i8);
    }

    public int b(int i8) {
        if (i8 < this.f18748d) {
            return this.f18746b.getShort(this.f18747c + i8);
        }
        return 0;
    }

    public void c(int i8, ByteBuffer byteBuffer) {
        short s8;
        this.f18746b = byteBuffer;
        if (byteBuffer != null) {
            this.f18745a = i8;
            int i9 = i8 - byteBuffer.getInt(i8);
            this.f18747c = i9;
            s8 = this.f18746b.getShort(i9);
        } else {
            s8 = 0;
            this.f18745a = 0;
            this.f18747c = 0;
        }
        this.f18748d = s8;
    }

    public int d(int i8) {
        int i9 = i8 + this.f18745a;
        return i9 + this.f18746b.getInt(i9) + 4;
    }

    public int e(int i8) {
        int i9 = i8 + this.f18745a;
        return this.f18746b.getInt(i9 + this.f18746b.getInt(i9));
    }
}
