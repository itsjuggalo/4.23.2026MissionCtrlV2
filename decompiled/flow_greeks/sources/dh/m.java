package dh;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f8184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8185b;

    public m(char[] bufferWithData) {
        kotlin.jvm.internal.t.f(bufferWithData, "bufferWithData");
        this.f8184a = bufferWithData;
        this.f8185b = bufferWithData.length;
        b(10);
    }

    @Override // dh.m1
    public void b(int i10) {
        char[] cArr = this.f8184a;
        if (cArr.length < i10) {
            char[] cArrCopyOf = Arrays.copyOf(cArr, vd.l.b(i10, cArr.length * 2));
            kotlin.jvm.internal.t.e(cArrCopyOf, "copyOf(...)");
            this.f8184a = cArrCopyOf;
        }
    }

    @Override // dh.m1
    public int d() {
        return this.f8185b;
    }

    public final void e(char c10) {
        m1.c(this, 0, 1, null);
        char[] cArr = this.f8184a;
        int iD = d();
        this.f8185b = iD + 1;
        cArr[iD] = c10;
    }

    @Override // dh.m1
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public char[] a() {
        char[] cArrCopyOf = Arrays.copyOf(this.f8184a, d());
        kotlin.jvm.internal.t.e(cArrCopyOf, "copyOf(...)");
        return cArrCopyOf;
    }
}
