package r6;

import java.util.Arrays;

/* JADX INFO: renamed from: r6.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2622i extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f22890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22891b;

    public C2622i(byte[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f22890a = bufferWithData;
        this.f22891b = bufferWithData.length;
        b(10);
    }

    @Override // r6.e0
    public void b(int i7) {
        byte[] bArr = this.f22890a;
        if (bArr.length < i7) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, W5.l.b(i7, bArr.length * 2));
            kotlin.jvm.internal.r.e(bArrCopyOf, "copyOf(this, newSize)");
            this.f22890a = bArrCopyOf;
        }
    }

    @Override // r6.e0
    public int d() {
        return this.f22891b;
    }

    public final void e(byte b7) {
        e0.c(this, 0, 1, null);
        byte[] bArr = this.f22890a;
        int iD = d();
        this.f22891b = iD + 1;
        bArr[iD] = b7;
    }

    @Override // r6.e0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public byte[] a() {
        byte[] bArrCopyOf = Arrays.copyOf(this.f22890a, d());
        kotlin.jvm.internal.r.e(bArrCopyOf, "copyOf(this, newSize)");
        return bArrCopyOf;
    }
}
