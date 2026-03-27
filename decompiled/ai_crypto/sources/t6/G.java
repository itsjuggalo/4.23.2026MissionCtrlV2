package t6;

import java.util.Arrays;
import p6.j;

/* JADX INFO: loaded from: classes2.dex */
public final class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f24238a = new Object[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f24239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f24240c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f24241a = new a();
    }

    public G() {
        int[] iArr = new int[8];
        for (int i7 = 0; i7 < 8; i7++) {
            iArr[i7] = -1;
        }
        this.f24239b = iArr;
        this.f24240c = -1;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("$");
        int i7 = this.f24240c + 1;
        for (int i8 = 0; i8 < i7; i8++) {
            Object obj = this.f24238a[i8];
            if (obj instanceof p6.e) {
                p6.e eVar = (p6.e) obj;
                if (!kotlin.jvm.internal.r.b(eVar.e(), j.b.f22095a)) {
                    int i9 = this.f24239b[i8];
                    if (i9 >= 0) {
                        sb.append(".");
                        sb.append(eVar.g(i9));
                    }
                } else if (this.f24239b[i8] != -1) {
                    sb.append("[");
                    sb.append(this.f24239b[i8]);
                    sb.append("]");
                }
            } else if (obj != a.f24241a) {
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
        int i7 = this.f24240c;
        int[] iArr = this.f24239b;
        if (iArr[i7] == -2) {
            iArr[i7] = -1;
            this.f24240c = i7 - 1;
        }
        int i8 = this.f24240c;
        if (i8 != -1) {
            this.f24240c = i8 - 1;
        }
    }

    public final void c(p6.e sd) {
        kotlin.jvm.internal.r.f(sd, "sd");
        int i7 = this.f24240c + 1;
        this.f24240c = i7;
        if (i7 == this.f24238a.length) {
            e();
        }
        this.f24238a[i7] = sd;
    }

    public final void d() {
        int[] iArr = this.f24239b;
        int i7 = this.f24240c;
        if (iArr[i7] == -2) {
            this.f24238a[i7] = a.f24241a;
        }
    }

    public final void e() {
        int i7 = this.f24240c * 2;
        Object[] objArrCopyOf = Arrays.copyOf(this.f24238a, i7);
        kotlin.jvm.internal.r.e(objArrCopyOf, "copyOf(this, newSize)");
        this.f24238a = objArrCopyOf;
        int[] iArrCopyOf = Arrays.copyOf(this.f24239b, i7);
        kotlin.jvm.internal.r.e(iArrCopyOf, "copyOf(this, newSize)");
        this.f24239b = iArrCopyOf;
    }

    public final void f(Object obj) {
        int[] iArr = this.f24239b;
        int i7 = this.f24240c;
        if (iArr[i7] != -2) {
            int i8 = i7 + 1;
            this.f24240c = i8;
            if (i8 == this.f24238a.length) {
                e();
            }
        }
        Object[] objArr = this.f24238a;
        int i9 = this.f24240c;
        objArr[i9] = obj;
        this.f24239b[i9] = -2;
    }

    public final void g(int i7) {
        this.f24239b[this.f24240c] = i7;
    }

    public String toString() {
        return a();
    }
}
