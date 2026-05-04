package dh;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f8122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8123b;

    public b0(float[] bufferWithData) {
        kotlin.jvm.internal.t.f(bufferWithData, "bufferWithData");
        this.f8122a = bufferWithData;
        this.f8123b = bufferWithData.length;
        b(10);
    }

    @Override // dh.m1
    public void b(int i10) {
        float[] fArr = this.f8122a;
        if (fArr.length < i10) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, vd.l.b(i10, fArr.length * 2));
            kotlin.jvm.internal.t.e(fArrCopyOf, "copyOf(...)");
            this.f8122a = fArrCopyOf;
        }
    }

    @Override // dh.m1
    public int d() {
        return this.f8123b;
    }

    public final void e(float f10) {
        m1.c(this, 0, 1, null);
        float[] fArr = this.f8122a;
        int iD = d();
        this.f8123b = iD + 1;
        fArr[iD] = f10;
    }

    @Override // dh.m1
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public float[] a() {
        float[] fArrCopyOf = Arrays.copyOf(this.f8122a, d());
        kotlin.jvm.internal.t.e(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }
}
