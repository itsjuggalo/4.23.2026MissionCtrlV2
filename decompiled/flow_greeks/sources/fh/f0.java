package fh;

import bh.m;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f9577a = new Object[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f9578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9579c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9580a = new a();
    }

    public f0() {
        int[] iArr = new int[8];
        for (int i10 = 0; i10 < 8; i10++) {
            iArr[i10] = -1;
        }
        this.f9578b = iArr;
        this.f9579c = -1;
    }

    public final String a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("$");
        int i10 = this.f9579c + 1;
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj = this.f9577a[i11];
            if (obj instanceof bh.e) {
                bh.e eVar = (bh.e) obj;
                if (!kotlin.jvm.internal.t.b(eVar.h(), m.b.f3403a)) {
                    int i12 = this.f9578b[i11];
                    if (i12 >= 0) {
                        sb2.append(".");
                        sb2.append(eVar.m(i12));
                    }
                } else if (this.f9578b[i11] != -1) {
                    sb2.append("[");
                    sb2.append(this.f9578b[i11]);
                    sb2.append("]");
                }
            } else if (obj != a.f9580a) {
                sb2.append("[");
                sb2.append("'");
                sb2.append(obj);
                sb2.append("'");
                sb2.append("]");
            }
        }
        String string = sb2.toString();
        kotlin.jvm.internal.t.e(string, "toString(...)");
        return string;
    }

    public final void b() {
        int i10 = this.f9579c;
        int[] iArr = this.f9578b;
        if (iArr[i10] == -2) {
            iArr[i10] = -1;
            this.f9579c = i10 - 1;
        }
        int i11 = this.f9579c;
        if (i11 != -1) {
            this.f9579c = i11 - 1;
        }
    }

    public final void c(bh.e sd2) {
        kotlin.jvm.internal.t.f(sd2, "sd");
        int i10 = this.f9579c + 1;
        this.f9579c = i10;
        if (i10 == this.f9577a.length) {
            e();
        }
        this.f9577a[i10] = sd2;
    }

    public final void d() {
        int[] iArr = this.f9578b;
        int i10 = this.f9579c;
        if (iArr[i10] == -2) {
            this.f9577a[i10] = a.f9580a;
        }
    }

    public final void e() {
        int i10 = this.f9579c * 2;
        Object[] objArrCopyOf = Arrays.copyOf(this.f9577a, i10);
        kotlin.jvm.internal.t.e(objArrCopyOf, "copyOf(...)");
        this.f9577a = objArrCopyOf;
        int[] iArrCopyOf = Arrays.copyOf(this.f9578b, i10);
        kotlin.jvm.internal.t.e(iArrCopyOf, "copyOf(...)");
        this.f9578b = iArrCopyOf;
    }

    public final void f(Object obj) {
        int[] iArr = this.f9578b;
        int i10 = this.f9579c;
        if (iArr[i10] != -2) {
            int i11 = i10 + 1;
            this.f9579c = i11;
            if (i11 == this.f9577a.length) {
                e();
            }
        }
        Object[] objArr = this.f9577a;
        int i12 = this.f9579c;
        objArr[i12] = obj;
        this.f9578b[i12] = -2;
    }

    public final void g(int i10) {
        this.f9578b[this.f9579c] = i10;
    }

    public String toString() {
        return a();
    }
}
