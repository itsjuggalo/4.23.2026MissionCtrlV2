package r6;

import java.util.Arrays;

/* JADX INFO: renamed from: r6.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2626m extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f22901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22902b;

    public C2626m(char[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f22901a = bufferWithData;
        this.f22902b = bufferWithData.length;
        b(10);
    }

    @Override // r6.e0
    public void b(int i7) {
        char[] cArr = this.f22901a;
        if (cArr.length < i7) {
            char[] cArrCopyOf = Arrays.copyOf(cArr, W5.l.b(i7, cArr.length * 2));
            kotlin.jvm.internal.r.e(cArrCopyOf, "copyOf(this, newSize)");
            this.f22901a = cArrCopyOf;
        }
    }

    @Override // r6.e0
    public int d() {
        return this.f22902b;
    }

    public final void e(char c7) {
        e0.c(this, 0, 1, null);
        char[] cArr = this.f22901a;
        int iD = d();
        this.f22902b = iD + 1;
        cArr[iD] = c7;
    }

    @Override // r6.e0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public char[] a() {
        char[] cArrCopyOf = Arrays.copyOf(this.f22901a, d());
        kotlin.jvm.internal.r.e(cArrCopyOf, "copyOf(this, newSize)");
        return cArrCopyOf;
    }
}
