package o7;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o7.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2503f extends AbstractC2520n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean[] f22163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22164b;

    public C2503f(boolean[] bufferWithData) {
        AbstractC2304t.f(bufferWithData, "bufferWithData");
        this.f22163a = bufferWithData;
        this.f22164b = bufferWithData.length;
        b(10);
    }

    @Override // o7.AbstractC2520n0
    public void b(int i8) {
        boolean[] zArr = this.f22163a;
        if (zArr.length < i8) {
            boolean[] zArrCopyOf = Arrays.copyOf(zArr, H5.i.b(i8, zArr.length * 2));
            AbstractC2304t.e(zArrCopyOf, "copyOf(...)");
            this.f22163a = zArrCopyOf;
        }
    }

    @Override // o7.AbstractC2520n0
    public int d() {
        return this.f22164b;
    }

    public final void e(boolean z7) {
        AbstractC2520n0.c(this, 0, 1, null);
        boolean[] zArr = this.f22163a;
        int iD = d();
        this.f22164b = iD + 1;
        zArr[iD] = z7;
    }

    @Override // o7.AbstractC2520n0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean[] a() {
        boolean[] zArrCopyOf = Arrays.copyOf(this.f22163a, d());
        AbstractC2304t.e(zArrCopyOf, "copyOf(...)");
        return zArrCopyOf;
    }
}
