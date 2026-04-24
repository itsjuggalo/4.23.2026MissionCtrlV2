package o7;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2465C;

/* JADX INFO: loaded from: classes2.dex */
public final class I0 extends AbstractC2520n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f22116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22117b;

    public I0(long[] bufferWithData) {
        AbstractC2304t.f(bufferWithData, "bufferWithData");
        this.f22116a = bufferWithData;
        this.f22117b = C2465C.I(bufferWithData);
        b(10);
    }

    @Override // o7.AbstractC2520n0
    public /* bridge */ /* synthetic */ Object a() {
        return C2465C.a(f());
    }

    @Override // o7.AbstractC2520n0
    public void b(int i8) {
        if (C2465C.I(this.f22116a) < i8) {
            long[] jArr = this.f22116a;
            long[] jArrCopyOf = Arrays.copyOf(jArr, H5.i.b(i8, C2465C.I(jArr) * 2));
            AbstractC2304t.e(jArrCopyOf, "copyOf(...)");
            this.f22116a = C2465C.e(jArrCopyOf);
        }
    }

    @Override // o7.AbstractC2520n0
    public int d() {
        return this.f22117b;
    }

    public final void e(long j8) {
        AbstractC2520n0.c(this, 0, 1, null);
        long[] jArr = this.f22116a;
        int iD = d();
        this.f22117b = iD + 1;
        C2465C.M(jArr, iD, j8);
    }

    public long[] f() {
        long[] jArrCopyOf = Arrays.copyOf(this.f22116a, d());
        AbstractC2304t.e(jArrCopyOf, "copyOf(...)");
        return C2465C.e(jArrCopyOf);
    }

    public /* synthetic */ I0(long[] jArr, AbstractC2296k abstractC2296k) {
        this(jArr);
    }
}
