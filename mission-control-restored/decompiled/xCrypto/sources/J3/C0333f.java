package J3;

import java.util.Arrays;
import o3.AbstractC1681l;

/* JADX INFO: renamed from: J3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0333f extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean[] f924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f925b;

    public C0333f(boolean[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f924a = bufferWithData;
        this.f925b = bufferWithData.length;
        b(10);
    }

    @Override // J3.e0
    public void b(int i4) {
        boolean[] zArr = this.f924a;
        if (zArr.length < i4) {
            boolean[] zArrCopyOf = Arrays.copyOf(zArr, AbstractC1681l.b(i4, zArr.length * 2));
            kotlin.jvm.internal.r.e(zArrCopyOf, "copyOf(this, newSize)");
            this.f924a = zArrCopyOf;
        }
    }

    @Override // J3.e0
    public int d() {
        return this.f925b;
    }

    public final void e(boolean z4) {
        e0.c(this, 0, 1, null);
        boolean[] zArr = this.f924a;
        int iD = d();
        this.f925b = iD + 1;
        zArr[iD] = z4;
    }

    @Override // J3.e0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean[] a() {
        boolean[] zArrCopyOf = Arrays.copyOf(this.f924a, d());
        kotlin.jvm.internal.r.e(zArrCopyOf, "copyOf(this, newSize)");
        return zArrCopyOf;
    }
}
