package dh;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class t1 extends m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[] f8223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8224b;

    public t1(short[] bufferWithData) {
        kotlin.jvm.internal.t.f(bufferWithData, "bufferWithData");
        this.f8223a = bufferWithData;
        this.f8224b = bufferWithData.length;
        b(10);
    }

    @Override // dh.m1
    public void b(int i10) {
        short[] sArr = this.f8223a;
        if (sArr.length < i10) {
            short[] sArrCopyOf = Arrays.copyOf(sArr, vd.l.b(i10, sArr.length * 2));
            kotlin.jvm.internal.t.e(sArrCopyOf, "copyOf(...)");
            this.f8223a = sArrCopyOf;
        }
    }

    @Override // dh.m1
    public int d() {
        return this.f8224b;
    }

    public final void e(short s10) {
        m1.c(this, 0, 1, null);
        short[] sArr = this.f8223a;
        int iD = d();
        this.f8224b = iD + 1;
        sArr[iD] = s10;
    }

    @Override // dh.m1
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public short[] a() {
        short[] sArrCopyOf = Arrays.copyOf(this.f8223a, d());
        kotlin.jvm.internal.t.e(sArrCopyOf, "copyOf(...)");
        return sArrCopyOf;
    }
}
