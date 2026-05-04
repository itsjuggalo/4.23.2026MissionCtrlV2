package dh;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h2 extends m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f8154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8155b;

    public /* synthetic */ h2(long[] jArr, kotlin.jvm.internal.k kVar) {
        this(jArr);
    }

    @Override // dh.m1
    public /* bridge */ /* synthetic */ Object a() {
        return cd.c0.a(f());
    }

    @Override // dh.m1
    public void b(int i10) {
        if (cd.c0.u(this.f8154a) < i10) {
            long[] jArr = this.f8154a;
            long[] jArrCopyOf = Arrays.copyOf(jArr, vd.l.b(i10, cd.c0.u(jArr) * 2));
            kotlin.jvm.internal.t.e(jArrCopyOf, "copyOf(...)");
            this.f8154a = cd.c0.e(jArrCopyOf);
        }
    }

    @Override // dh.m1
    public int d() {
        return this.f8155b;
    }

    public final void e(long j10) {
        m1.c(this, 0, 1, null);
        long[] jArr = this.f8154a;
        int iD = d();
        this.f8155b = iD + 1;
        cd.c0.A(jArr, iD, j10);
    }

    public long[] f() {
        long[] jArrCopyOf = Arrays.copyOf(this.f8154a, d());
        kotlin.jvm.internal.t.e(jArrCopyOf, "copyOf(...)");
        return cd.c0.e(jArrCopyOf);
    }

    public h2(long[] bufferWithData) {
        kotlin.jvm.internal.t.f(bufferWithData, "bufferWithData");
        this.f8154a = bufferWithData;
        this.f8155b = cd.c0.u(bufferWithData);
        b(10);
    }
}
