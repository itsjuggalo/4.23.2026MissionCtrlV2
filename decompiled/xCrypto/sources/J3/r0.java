package J3;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC1585j;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f967b;

    public /* synthetic */ r0(byte[] bArr, AbstractC1585j abstractC1585j) {
        this(bArr);
    }

    @Override // J3.e0
    public /* bridge */ /* synthetic */ Object a() {
        return W2.v.f(f());
    }

    @Override // J3.e0
    public void b(int i4) {
        if (W2.v.r(this.f966a) < i4) {
            byte[] bArr = this.f966a;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, AbstractC1681l.b(i4, W2.v.r(bArr) * 2));
            kotlin.jvm.internal.r.e(bArrCopyOf, "copyOf(this, newSize)");
            this.f966a = W2.v.k(bArrCopyOf);
        }
    }

    @Override // J3.e0
    public int d() {
        return this.f967b;
    }

    public final void e(byte b4) {
        e0.c(this, 0, 1, null);
        byte[] bArr = this.f966a;
        int iD = d();
        this.f967b = iD + 1;
        W2.v.v(bArr, iD, b4);
    }

    public byte[] f() {
        byte[] bArrCopyOf = Arrays.copyOf(this.f966a, d());
        kotlin.jvm.internal.r.e(bArrCopyOf, "copyOf(this, newSize)");
        return W2.v.k(bArrCopyOf);
    }

    public r0(byte[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f966a = bufferWithData;
        this.f967b = W2.v.r(bufferWithData);
        b(10);
    }
}
