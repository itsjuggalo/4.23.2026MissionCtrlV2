package r6;

import java.util.Arrays;

/* JADX INFO: renamed from: r6.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2638z extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f22957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22958b;

    public C2638z(float[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f22957a = bufferWithData;
        this.f22958b = bufferWithData.length;
        b(10);
    }

    @Override // r6.e0
    public void b(int i7) {
        float[] fArr = this.f22957a;
        if (fArr.length < i7) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, W5.l.b(i7, fArr.length * 2));
            kotlin.jvm.internal.r.e(fArrCopyOf, "copyOf(this, newSize)");
            this.f22957a = fArrCopyOf;
        }
    }

    @Override // r6.e0
    public int d() {
        return this.f22958b;
    }

    public final void e(float f7) {
        e0.c(this, 0, 1, null);
        float[] fArr = this.f22957a;
        int iD = d();
        this.f22958b = iD + 1;
        fArr[iD] = f7;
    }

    @Override // r6.e0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public float[] a() {
        float[] fArrCopyOf = Arrays.copyOf(this.f22957a, d());
        kotlin.jvm.internal.r.e(fArrCopyOf, "copyOf(this, newSize)");
        return fArrCopyOf;
    }
}
