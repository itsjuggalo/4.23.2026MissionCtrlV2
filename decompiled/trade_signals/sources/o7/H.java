package o7;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class H extends AbstractC2520n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f22111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22112b;

    public H(int[] bufferWithData) {
        AbstractC2304t.f(bufferWithData, "bufferWithData");
        this.f22111a = bufferWithData;
        this.f22112b = bufferWithData.length;
        b(10);
    }

    @Override // o7.AbstractC2520n0
    public void b(int i8) {
        int[] iArr = this.f22111a;
        if (iArr.length < i8) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, H5.i.b(i8, iArr.length * 2));
            AbstractC2304t.e(iArrCopyOf, "copyOf(...)");
            this.f22111a = iArrCopyOf;
        }
    }

    @Override // o7.AbstractC2520n0
    public int d() {
        return this.f22112b;
    }

    public final void e(int i8) {
        AbstractC2520n0.c(this, 0, 1, null);
        int[] iArr = this.f22111a;
        int iD = d();
        this.f22112b = iD + 1;
        iArr[iD] = i8;
    }

    @Override // o7.AbstractC2520n0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public int[] a() {
        int[] iArrCopyOf = Arrays.copyOf(this.f22111a, d());
        AbstractC2304t.e(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }
}
