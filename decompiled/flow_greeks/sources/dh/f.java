package dh;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean[] f8139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8140b;

    public f(boolean[] bufferWithData) {
        kotlin.jvm.internal.t.f(bufferWithData, "bufferWithData");
        this.f8139a = bufferWithData;
        this.f8140b = bufferWithData.length;
        b(10);
    }

    @Override // dh.m1
    public void b(int i10) {
        boolean[] zArr = this.f8139a;
        if (zArr.length < i10) {
            boolean[] zArrCopyOf = Arrays.copyOf(zArr, vd.l.b(i10, zArr.length * 2));
            kotlin.jvm.internal.t.e(zArrCopyOf, "copyOf(...)");
            this.f8139a = zArrCopyOf;
        }
    }

    @Override // dh.m1
    public int d() {
        return this.f8140b;
    }

    public final void e(boolean z10) {
        m1.c(this, 0, 1, null);
        boolean[] zArr = this.f8139a;
        int iD = d();
        this.f8140b = iD + 1;
        zArr[iD] = z10;
    }

    @Override // dh.m1
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean[] a() {
        boolean[] zArrCopyOf = Arrays.copyOf(this.f8139a, d());
        kotlin.jvm.internal.t.e(zArrCopyOf, "copyOf(...)");
        return zArrCopyOf;
    }
}
