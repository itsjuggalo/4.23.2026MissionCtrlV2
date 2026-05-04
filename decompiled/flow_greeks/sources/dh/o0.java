package dh;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o0 extends m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f8197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8198b;

    public o0(long[] bufferWithData) {
        kotlin.jvm.internal.t.f(bufferWithData, "bufferWithData");
        this.f8197a = bufferWithData;
        this.f8198b = bufferWithData.length;
        b(10);
    }

    @Override // dh.m1
    public void b(int i10) {
        long[] jArr = this.f8197a;
        if (jArr.length < i10) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, vd.l.b(i10, jArr.length * 2));
            kotlin.jvm.internal.t.e(jArrCopyOf, "copyOf(...)");
            this.f8197a = jArrCopyOf;
        }
    }

    @Override // dh.m1
    public int d() {
        return this.f8198b;
    }

    public final void e(long j10) {
        m1.c(this, 0, 1, null);
        long[] jArr = this.f8197a;
        int iD = d();
        this.f8198b = iD + 1;
        jArr[iD] = j10;
    }

    @Override // dh.m1
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public long[] a() {
        long[] jArrCopyOf = Arrays.copyOf(this.f8197a, d());
        kotlin.jvm.internal.t.e(jArrCopyOf, "copyOf(...)");
        return jArrCopyOf;
    }
}
