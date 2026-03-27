package r6;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f22923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22924b;

    public /* synthetic */ r0(byte[] bArr, AbstractC2148j abstractC2148j) {
        this(bArr);
    }

    @Override // r6.e0
    public /* bridge */ /* synthetic */ Object a() {
        return E5.v.a(f());
    }

    @Override // r6.e0
    public void b(int i7) {
        if (E5.v.p(this.f22923a) < i7) {
            byte[] bArr = this.f22923a;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, W5.l.b(i7, E5.v.p(bArr) * 2));
            kotlin.jvm.internal.r.e(bArrCopyOf, "copyOf(this, newSize)");
            this.f22923a = E5.v.g(bArrCopyOf);
        }
    }

    @Override // r6.e0
    public int d() {
        return this.f22924b;
    }

    public final void e(byte b7) {
        e0.c(this, 0, 1, null);
        byte[] bArr = this.f22923a;
        int iD = d();
        this.f22924b = iD + 1;
        E5.v.t(bArr, iD, b7);
    }

    public byte[] f() {
        byte[] bArrCopyOf = Arrays.copyOf(this.f22923a, d());
        kotlin.jvm.internal.r.e(bArrCopyOf, "copyOf(this, newSize)");
        return E5.v.g(bArrCopyOf);
    }

    public r0(byte[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f22923a = bufferWithData;
        this.f22924b = E5.v.p(bufferWithData);
        b(10);
    }
}
