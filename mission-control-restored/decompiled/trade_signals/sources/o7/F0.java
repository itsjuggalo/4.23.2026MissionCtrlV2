package o7;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2463A;

/* JADX INFO: loaded from: classes2.dex */
public final class F0 extends AbstractC2520n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f22107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22108b;

    public F0(int[] bufferWithData) {
        AbstractC2304t.f(bufferWithData, "bufferWithData");
        this.f22107a = bufferWithData;
        this.f22108b = C2463A.I(bufferWithData);
        b(10);
    }

    @Override // o7.AbstractC2520n0
    public /* bridge */ /* synthetic */ Object a() {
        return C2463A.a(f());
    }

    @Override // o7.AbstractC2520n0
    public void b(int i8) {
        if (C2463A.I(this.f22107a) < i8) {
            int[] iArr = this.f22107a;
            int[] iArrCopyOf = Arrays.copyOf(iArr, H5.i.b(i8, C2463A.I(iArr) * 2));
            AbstractC2304t.e(iArrCopyOf, "copyOf(...)");
            this.f22107a = C2463A.e(iArrCopyOf);
        }
    }

    @Override // o7.AbstractC2520n0
    public int d() {
        return this.f22108b;
    }

    public final void e(int i8) {
        AbstractC2520n0.c(this, 0, 1, null);
        int[] iArr = this.f22107a;
        int iD = d();
        this.f22108b = iD + 1;
        C2463A.M(iArr, iD, i8);
    }

    public int[] f() {
        int[] iArrCopyOf = Arrays.copyOf(this.f22107a, d());
        AbstractC2304t.e(iArrCopyOf, "copyOf(...)");
        return C2463A.e(iArrCopyOf);
    }

    public /* synthetic */ F0(int[] iArr, AbstractC2296k abstractC2296k) {
        this(iArr);
    }
}
