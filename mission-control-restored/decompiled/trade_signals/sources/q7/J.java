package q7;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2304t;
import m7.m;

/* JADX INFO: loaded from: classes2.dex */
public final class J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f22798a = new Object[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f22799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22800c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22801a = new a();
    }

    public J() {
        int[] iArr = new int[8];
        for (int i8 = 0; i8 < 8; i8++) {
            iArr[i8] = -1;
        }
        this.f22799b = iArr;
        this.f22800c = -1;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("$");
        int i8 = this.f22800c + 1;
        for (int i9 = 0; i9 < i8; i9++) {
            Object obj = this.f22798a[i9];
            if (obj instanceof m7.e) {
                m7.e eVar = (m7.e) obj;
                if (!AbstractC2304t.b(eVar.i(), m.b.f21532a)) {
                    int i10 = this.f22799b[i9];
                    if (i10 >= 0) {
                        sb.append(".");
                        sb.append(eVar.f(i10));
                    }
                } else if (this.f22799b[i9] != -1) {
                    sb.append("[");
                    sb.append(this.f22799b[i9]);
                    sb.append("]");
                }
            } else if (obj != a.f22801a) {
                sb.append("[");
                sb.append("'");
                sb.append(obj);
                sb.append("'");
                sb.append("]");
            }
        }
        String string = sb.toString();
        AbstractC2304t.e(string, "toString(...)");
        return string;
    }

    public final void b() {
        int i8 = this.f22800c;
        int[] iArr = this.f22799b;
        if (iArr[i8] == -2) {
            iArr[i8] = -1;
            this.f22800c = i8 - 1;
        }
        int i9 = this.f22800c;
        if (i9 != -1) {
            this.f22800c = i9 - 1;
        }
    }

    public final void c(m7.e sd) {
        AbstractC2304t.f(sd, "sd");
        int i8 = this.f22800c + 1;
        this.f22800c = i8;
        if (i8 == this.f22798a.length) {
            e();
        }
        this.f22798a[i8] = sd;
    }

    public final void d() {
        int[] iArr = this.f22799b;
        int i8 = this.f22800c;
        if (iArr[i8] == -2) {
            this.f22798a[i8] = a.f22801a;
        }
    }

    public final void e() {
        int i8 = this.f22800c * 2;
        Object[] objArrCopyOf = Arrays.copyOf(this.f22798a, i8);
        AbstractC2304t.e(objArrCopyOf, "copyOf(...)");
        this.f22798a = objArrCopyOf;
        int[] iArrCopyOf = Arrays.copyOf(this.f22799b, i8);
        AbstractC2304t.e(iArrCopyOf, "copyOf(...)");
        this.f22799b = iArrCopyOf;
    }

    public final void f(Object obj) {
        int[] iArr = this.f22799b;
        int i8 = this.f22800c;
        if (iArr[i8] != -2) {
            int i9 = i8 + 1;
            this.f22800c = i9;
            if (i9 == this.f22798a.length) {
                e();
            }
        }
        Object[] objArr = this.f22798a;
        int i10 = this.f22800c;
        objArr[i10] = obj;
        this.f22799b[i10] = -2;
    }

    public final void g(int i8) {
        this.f22799b[this.f22800c] = i8;
    }

    public String toString() {
        return a();
    }
}
