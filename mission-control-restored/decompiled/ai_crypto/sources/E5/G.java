package E5;

import Z5.AbstractC0794a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class G {
    public static final int a(int i7, int i8) {
        return kotlin.jvm.internal.r.g(i7 ^ Integer.MIN_VALUE, i8 ^ Integer.MIN_VALUE);
    }

    public static final int b(long j7, long j8) {
        return kotlin.jvm.internal.r.h(j7 ^ Long.MIN_VALUE, j8 ^ Long.MIN_VALUE);
    }

    public static final String c(long j7, int i7) {
        if (j7 >= 0) {
            String string = Long.toString(j7, AbstractC0794a.a(i7));
            kotlin.jvm.internal.r.e(string, "toString(...)");
            return string;
        }
        long j8 = i7;
        long j9 = ((j7 >>> 1) / j8) << 1;
        long j10 = j7 - (j9 * j8);
        if (j10 >= j8) {
            j10 -= j8;
            j9++;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = Long.toString(j9, AbstractC0794a.a(i7));
        kotlin.jvm.internal.r.e(string2, "toString(...)");
        sb.append(string2);
        String string3 = Long.toString(j10, AbstractC0794a.a(i7));
        kotlin.jvm.internal.r.e(string3, "toString(...)");
        sb.append(string3);
        return sb.toString();
    }
}
