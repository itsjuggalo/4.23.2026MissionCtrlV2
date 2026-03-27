package r6;

import java.util.Arrays;

/* JADX INFO: renamed from: r6.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2619f extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean[] f22881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22882b;

    public C2619f(boolean[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f22881a = bufferWithData;
        this.f22882b = bufferWithData.length;
        b(10);
    }

    @Override // r6.e0
    public void b(int i7) {
        boolean[] zArr = this.f22881a;
        if (zArr.length < i7) {
            boolean[] zArrCopyOf = Arrays.copyOf(zArr, W5.l.b(i7, zArr.length * 2));
            kotlin.jvm.internal.r.e(zArrCopyOf, "copyOf(this, newSize)");
            this.f22881a = zArrCopyOf;
        }
    }

    @Override // r6.e0
    public int d() {
        return this.f22882b;
    }

    public final void e(boolean z7) {
        e0.c(this, 0, 1, null);
        boolean[] zArr = this.f22881a;
        int iD = d();
        this.f22882b = iD + 1;
        zArr[iD] = z7;
    }

    @Override // r6.e0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean[] a() {
        boolean[] zArrCopyOf = Arrays.copyOf(this.f22881a, d());
        kotlin.jvm.internal.r.e(zArrCopyOf, "copyOf(this, newSize)");
        return zArrCopyOf;
    }
}
