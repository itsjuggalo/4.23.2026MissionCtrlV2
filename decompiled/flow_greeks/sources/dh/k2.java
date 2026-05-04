package dh;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k2 extends m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[] f8180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8181b;

    public /* synthetic */ k2(short[] sArr, kotlin.jvm.internal.k kVar) {
        this(sArr);
    }

    @Override // dh.m1
    public /* bridge */ /* synthetic */ Object a() {
        return cd.f0.a(f());
    }

    @Override // dh.m1
    public void b(int i10) {
        if (cd.f0.u(this.f8180a) < i10) {
            short[] sArr = this.f8180a;
            short[] sArrCopyOf = Arrays.copyOf(sArr, vd.l.b(i10, cd.f0.u(sArr) * 2));
            kotlin.jvm.internal.t.e(sArrCopyOf, "copyOf(...)");
            this.f8180a = cd.f0.e(sArrCopyOf);
        }
    }

    @Override // dh.m1
    public int d() {
        return this.f8181b;
    }

    public final void e(short s10) {
        m1.c(this, 0, 1, null);
        short[] sArr = this.f8180a;
        int iD = d();
        this.f8181b = iD + 1;
        cd.f0.A(sArr, iD, s10);
    }

    public short[] f() {
        short[] sArrCopyOf = Arrays.copyOf(this.f8180a, d());
        kotlin.jvm.internal.t.e(sArrCopyOf, "copyOf(...)");
        return cd.f0.e(sArrCopyOf);
    }

    public k2(short[] bufferWithData) {
        kotlin.jvm.internal.t.f(bufferWithData, "bufferWithData");
        this.f8180a = bufferWithData;
        this.f8181b = cd.f0.u(bufferWithData);
        b(10);
    }
}
