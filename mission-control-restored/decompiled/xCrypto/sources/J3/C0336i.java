package J3;

import java.util.Arrays;
import o3.AbstractC1681l;

/* JADX INFO: renamed from: J3.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0336i extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f934b;

    public C0336i(byte[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f933a = bufferWithData;
        this.f934b = bufferWithData.length;
        b(10);
    }

    @Override // J3.e0
    public void b(int i4) {
        byte[] bArr = this.f933a;
        if (bArr.length < i4) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, AbstractC1681l.b(i4, bArr.length * 2));
            kotlin.jvm.internal.r.e(bArrCopyOf, "copyOf(this, newSize)");
            this.f933a = bArrCopyOf;
        }
    }

    @Override // J3.e0
    public int d() {
        return this.f934b;
    }

    public final void e(byte b4) {
        e0.c(this, 0, 1, null);
        byte[] bArr = this.f933a;
        int iD = d();
        this.f934b = iD + 1;
        bArr[iD] = b4;
    }

    @Override // J3.e0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public byte[] a() {
        byte[] bArrCopyOf = Arrays.copyOf(this.f933a, d());
        kotlin.jvm.internal.r.e(bArrCopyOf, "copyOf(this, newSize)");
        return bArrCopyOf;
    }
}
