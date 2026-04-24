package L3;

import H3.j;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f1445a = new Object[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f1446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1447c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1448a = new a();
    }

    public G() {
        int[] iArr = new int[8];
        for (int i4 = 0; i4 < 8; i4++) {
            iArr[i4] = -1;
        }
        this.f1446b = iArr;
        this.f1447c = -1;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("$");
        int i4 = this.f1447c + 1;
        for (int i5 = 0; i5 < i4; i5++) {
            Object obj = this.f1445a[i5];
            if (obj instanceof H3.e) {
                H3.e eVar = (H3.e) obj;
                if (!kotlin.jvm.internal.r.b(eVar.e(), j.b.f767a)) {
                    int i6 = this.f1446b[i5];
                    if (i6 >= 0) {
                        sb.append(".");
                        sb.append(eVar.g(i6));
                    }
                } else if (this.f1446b[i5] != -1) {
                    sb.append("[");
                    sb.append(this.f1446b[i5]);
                    sb.append("]");
                }
            } else if (obj != a.f1448a) {
                sb.append("[");
                sb.append("'");
                sb.append(obj);
                sb.append("'");
                sb.append("]");
            }
        }
        String string = sb.toString();
        kotlin.jvm.internal.r.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final void b() {
        int i4 = this.f1447c;
        int[] iArr = this.f1446b;
        if (iArr[i4] == -2) {
            iArr[i4] = -1;
            this.f1447c = i4 - 1;
        }
        int i5 = this.f1447c;
        if (i5 != -1) {
            this.f1447c = i5 - 1;
        }
    }

    public final void c(H3.e sd) {
        kotlin.jvm.internal.r.f(sd, "sd");
        int i4 = this.f1447c + 1;
        this.f1447c = i4;
        if (i4 == this.f1445a.length) {
            e();
        }
        this.f1445a[i4] = sd;
    }

    public final void d() {
        int[] iArr = this.f1446b;
        int i4 = this.f1447c;
        if (iArr[i4] == -2) {
            this.f1445a[i4] = a.f1448a;
        }
    }

    public final void e() {
        int i4 = this.f1447c * 2;
        Object[] objArrCopyOf = Arrays.copyOf(this.f1445a, i4);
        kotlin.jvm.internal.r.e(objArrCopyOf, "copyOf(this, newSize)");
        this.f1445a = objArrCopyOf;
        int[] iArrCopyOf = Arrays.copyOf(this.f1446b, i4);
        kotlin.jvm.internal.r.e(iArrCopyOf, "copyOf(this, newSize)");
        this.f1446b = iArrCopyOf;
    }

    public final void f(Object obj) {
        int[] iArr = this.f1446b;
        int i4 = this.f1447c;
        if (iArr[i4] != -2) {
            int i5 = i4 + 1;
            this.f1447c = i5;
            if (i5 == this.f1445a.length) {
                e();
            }
        }
        Object[] objArr = this.f1445a;
        int i6 = this.f1447c;
        objArr[i6] = obj;
        this.f1446b[i6] = -2;
    }

    public final void g(int i4) {
        this.f1446b[this.f1447c] = i4;
    }

    public String toString() {
        return a();
    }
}
