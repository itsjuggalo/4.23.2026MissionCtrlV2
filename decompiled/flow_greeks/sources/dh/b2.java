package dh;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b2 extends m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f8127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8128b;

    public /* synthetic */ b2(byte[] bArr, kotlin.jvm.internal.k kVar) {
        this(bArr);
    }

    @Override // dh.m1
    public /* bridge */ /* synthetic */ Object a() {
        return cd.y.a(f());
    }

    @Override // dh.m1
    public void b(int i10) {
        if (cd.y.u(this.f8127a) < i10) {
            byte[] bArr = this.f8127a;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, vd.l.b(i10, cd.y.u(bArr) * 2));
            kotlin.jvm.internal.t.e(bArrCopyOf, "copyOf(...)");
            this.f8127a = cd.y.e(bArrCopyOf);
        }
    }

    @Override // dh.m1
    public int d() {
        return this.f8128b;
    }

    public final void e(byte b10) {
        m1.c(this, 0, 1, null);
        byte[] bArr = this.f8127a;
        int iD = d();
        this.f8128b = iD + 1;
        cd.y.A(bArr, iD, b10);
    }

    public byte[] f() {
        byte[] bArrCopyOf = Arrays.copyOf(this.f8127a, d());
        kotlin.jvm.internal.t.e(bArrCopyOf, "copyOf(...)");
        return cd.y.e(bArrCopyOf);
    }

    public b2(byte[] bufferWithData) {
        kotlin.jvm.internal.t.f(bufferWithData, "bufferWithData");
        this.f8127a = bufferWithData;
        this.f8128b = cd.y.u(bufferWithData);
        b(10);
    }
}
