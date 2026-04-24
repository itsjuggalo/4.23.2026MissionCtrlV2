package o5;

import V6.AbstractC0975a;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o5.J, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2472J {
    public static final int a(int i8, int i9) {
        return AbstractC2304t.g(i8 ^ Integer.MIN_VALUE, i9 ^ Integer.MIN_VALUE);
    }

    public static final int b(long j8, long j9) {
        return AbstractC2304t.h(j8 ^ Long.MIN_VALUE, j9 ^ Long.MIN_VALUE);
    }

    public static final String c(long j8, int i8) {
        if (j8 >= 0) {
            String string = Long.toString(j8, AbstractC0975a.a(i8));
            AbstractC2304t.e(string, "toString(...)");
            return string;
        }
        long j9 = i8;
        long j10 = ((j8 >>> 1) / j9) << 1;
        long j11 = j8 - (j10 * j9);
        if (j11 >= j9) {
            j11 -= j9;
            j10++;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = Long.toString(j10, AbstractC0975a.a(i8));
        AbstractC2304t.e(string2, "toString(...)");
        sb.append(string2);
        String string3 = Long.toString(j11, AbstractC0975a.a(i8));
        AbstractC2304t.e(string3, "toString(...)");
        sb.append(string3);
        return sb.toString();
    }
}
