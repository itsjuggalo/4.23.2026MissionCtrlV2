package o7;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2468F;

/* JADX INFO: loaded from: classes2.dex */
public final class L0 extends AbstractC2520n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[] f22123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22124b;

    public L0(short[] bufferWithData) {
        AbstractC2304t.f(bufferWithData, "bufferWithData");
        this.f22123a = bufferWithData;
        this.f22124b = C2468F.I(bufferWithData);
        b(10);
    }

    @Override // o7.AbstractC2520n0
    public /* bridge */ /* synthetic */ Object a() {
        return C2468F.a(f());
    }

    @Override // o7.AbstractC2520n0
    public void b(int i8) {
        if (C2468F.I(this.f22123a) < i8) {
            short[] sArr = this.f22123a;
            short[] sArrCopyOf = Arrays.copyOf(sArr, H5.i.b(i8, C2468F.I(sArr) * 2));
            AbstractC2304t.e(sArrCopyOf, "copyOf(...)");
            this.f22123a = C2468F.e(sArrCopyOf);
        }
    }

    @Override // o7.AbstractC2520n0
    public int d() {
        return this.f22124b;
    }

    public final void e(short s8) {
        AbstractC2520n0.c(this, 0, 1, null);
        short[] sArr = this.f22123a;
        int iD = d();
        this.f22124b = iD + 1;
        C2468F.M(sArr, iD, s8);
    }

    public short[] f() {
        short[] sArrCopyOf = Arrays.copyOf(this.f22123a, d());
        AbstractC2304t.e(sArrCopyOf, "copyOf(...)");
        return C2468F.e(sArrCopyOf);
    }

    public /* synthetic */ L0(short[] sArr, AbstractC2296k abstractC2296k) {
        this(sArr);
    }
}
