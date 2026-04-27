package r6;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class A0 extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[] f22817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22818b;

    public /* synthetic */ A0(short[] sArr, AbstractC2148j abstractC2148j) {
        this(sArr);
    }

    @Override // r6.e0
    public /* bridge */ /* synthetic */ Object a() {
        return E5.C.a(f());
    }

    @Override // r6.e0
    public void b(int i7) {
        if (E5.C.p(this.f22817a) < i7) {
            short[] sArr = this.f22817a;
            short[] sArrCopyOf = Arrays.copyOf(sArr, W5.l.b(i7, E5.C.p(sArr) * 2));
            kotlin.jvm.internal.r.e(sArrCopyOf, "copyOf(this, newSize)");
            this.f22817a = E5.C.g(sArrCopyOf);
        }
    }

    @Override // r6.e0
    public int d() {
        return this.f22818b;
    }

    public final void e(short s7) {
        e0.c(this, 0, 1, null);
        short[] sArr = this.f22817a;
        int iD = d();
        this.f22818b = iD + 1;
        E5.C.t(sArr, iD, s7);
    }

    public short[] f() {
        short[] sArrCopyOf = Arrays.copyOf(this.f22817a, d());
        kotlin.jvm.internal.r.e(sArrCopyOf, "copyOf(this, newSize)");
        return E5.C.g(sArrCopyOf);
    }

    public A0(short[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f22817a = bufferWithData;
        this.f22818b = E5.C.p(bufferWithData);
        b(10);
    }
}
