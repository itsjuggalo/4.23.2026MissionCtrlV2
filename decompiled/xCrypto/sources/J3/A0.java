package J3;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC1585j;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public final class A0 extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[] f860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f861b;

    public /* synthetic */ A0(short[] sArr, AbstractC1585j abstractC1585j) {
        this(sArr);
    }

    @Override // J3.e0
    public /* bridge */ /* synthetic */ Object a() {
        return W2.C.f(f());
    }

    @Override // J3.e0
    public void b(int i4) {
        if (W2.C.r(this.f860a) < i4) {
            short[] sArr = this.f860a;
            short[] sArrCopyOf = Arrays.copyOf(sArr, AbstractC1681l.b(i4, W2.C.r(sArr) * 2));
            kotlin.jvm.internal.r.e(sArrCopyOf, "copyOf(this, newSize)");
            this.f860a = W2.C.k(sArrCopyOf);
        }
    }

    @Override // J3.e0
    public int d() {
        return this.f861b;
    }

    public final void e(short s4) {
        e0.c(this, 0, 1, null);
        short[] sArr = this.f860a;
        int iD = d();
        this.f861b = iD + 1;
        W2.C.v(sArr, iD, s4);
    }

    public short[] f() {
        short[] sArrCopyOf = Arrays.copyOf(this.f860a, d());
        kotlin.jvm.internal.r.e(sArrCopyOf, "copyOf(this, newSize)");
        return W2.C.k(sArrCopyOf);
    }

    public A0(short[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f860a = bufferWithData;
        this.f861b = W2.C.r(bufferWithData);
        b(10);
    }
}
