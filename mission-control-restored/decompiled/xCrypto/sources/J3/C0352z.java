package J3;

import java.util.Arrays;
import o3.AbstractC1681l;

/* JADX INFO: renamed from: J3.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0352z extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f1000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1001b;

    public C0352z(float[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f1000a = bufferWithData;
        this.f1001b = bufferWithData.length;
        b(10);
    }

    @Override // J3.e0
    public void b(int i4) {
        float[] fArr = this.f1000a;
        if (fArr.length < i4) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, AbstractC1681l.b(i4, fArr.length * 2));
            kotlin.jvm.internal.r.e(fArrCopyOf, "copyOf(this, newSize)");
            this.f1000a = fArrCopyOf;
        }
    }

    @Override // J3.e0
    public int d() {
        return this.f1001b;
    }

    public final void e(float f4) {
        e0.c(this, 0, 1, null);
        float[] fArr = this.f1000a;
        int iD = d();
        this.f1001b = iD + 1;
        fArr[iD] = f4;
    }

    @Override // J3.e0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public float[] a() {
        float[] fArrCopyOf = Arrays.copyOf(this.f1000a, d());
        kotlin.jvm.internal.r.e(fArrCopyOf, "copyOf(this, newSize)");
        return fArrCopyOf;
    }
}
