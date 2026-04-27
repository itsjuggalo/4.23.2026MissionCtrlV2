package J3;

import java.util.Arrays;
import o3.AbstractC1681l;

/* JADX INFO: renamed from: J3.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0340m extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f945b;

    public C0340m(char[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f944a = bufferWithData;
        this.f945b = bufferWithData.length;
        b(10);
    }

    @Override // J3.e0
    public void b(int i4) {
        char[] cArr = this.f944a;
        if (cArr.length < i4) {
            char[] cArrCopyOf = Arrays.copyOf(cArr, AbstractC1681l.b(i4, cArr.length * 2));
            kotlin.jvm.internal.r.e(cArrCopyOf, "copyOf(this, newSize)");
            this.f944a = cArrCopyOf;
        }
    }

    @Override // J3.e0
    public int d() {
        return this.f945b;
    }

    public final void e(char c4) {
        e0.c(this, 0, 1, null);
        char[] cArr = this.f944a;
        int iD = d();
        this.f945b = iD + 1;
        cArr[iD] = c4;
    }

    @Override // J3.e0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public char[] a() {
        char[] cArrCopyOf = Arrays.copyOf(this.f944a, d());
        kotlin.jvm.internal.r.e(cArrCopyOf, "copyOf(this, newSize)");
        return cArrCopyOf;
    }
}
