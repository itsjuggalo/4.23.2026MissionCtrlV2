package W2;

import r3.AbstractC1754a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class G {
    public static final int a(int i4, int i5) {
        return kotlin.jvm.internal.r.g(i4 ^ Integer.MIN_VALUE, i5 ^ Integer.MIN_VALUE);
    }

    public static final int b(long j4, long j5) {
        return kotlin.jvm.internal.r.h(j4 ^ Long.MIN_VALUE, j5 ^ Long.MIN_VALUE);
    }

    public static final String c(long j4, int i4) {
        if (j4 >= 0) {
            String string = Long.toString(j4, AbstractC1754a.a(i4));
            kotlin.jvm.internal.r.e(string, "toString(...)");
            return string;
        }
        long j5 = i4;
        long j6 = ((j4 >>> 1) / j5) << 1;
        long j7 = j4 - (j6 * j5);
        if (j7 >= j5) {
            j7 -= j5;
            j6++;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = Long.toString(j6, AbstractC1754a.a(i4));
        kotlin.jvm.internal.r.e(string2, "toString(...)");
        sb.append(string2);
        String string3 = Long.toString(j7, AbstractC1754a.a(i4));
        kotlin.jvm.internal.r.e(string3, "toString(...)");
        sb.append(string3);
        return sb.toString();
    }
}
