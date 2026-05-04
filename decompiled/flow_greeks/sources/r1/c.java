package r1;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f19217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f19220e = d.a();

    public int a(int i10) {
        return i10 + this.f19217b.getInt(i10);
    }

    public int b(int i10) {
        if (i10 < this.f19219d) {
            return this.f19217b.getShort(this.f19218c + i10);
        }
        return 0;
    }

    public void c(int i10, ByteBuffer byteBuffer) {
        this.f19217b = byteBuffer;
        if (byteBuffer == null) {
            this.f19216a = 0;
            this.f19218c = 0;
            this.f19219d = 0;
        } else {
            this.f19216a = i10;
            int i11 = i10 - byteBuffer.getInt(i10);
            this.f19218c = i11;
            this.f19219d = this.f19217b.getShort(i11);
        }
    }

    public int d(int i10) {
        int i11 = i10 + this.f19216a;
        return i11 + this.f19217b.getInt(i11) + 4;
    }

    public int e(int i10) {
        int i11 = i10 + this.f19216a;
        return this.f19217b.getInt(i11 + this.f19217b.getInt(i11));
    }
}
