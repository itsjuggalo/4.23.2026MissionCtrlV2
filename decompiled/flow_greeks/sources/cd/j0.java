package cd;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j0 {
    public static final int a(int i10, int i11) {
        return kotlin.jvm.internal.t.g(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE);
    }

    public static final int b(long j10, long j11) {
        return kotlin.jvm.internal.t.h(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
    }

    public static final String c(long j10, int i10) {
        if (j10 >= 0) {
            String string = Long.toString(j10, kg.a.a(i10));
            kotlin.jvm.internal.t.e(string, "toString(...)");
            return string;
        }
        long j11 = i10;
        long j12 = ((j10 >>> 1) / j11) << 1;
        long j13 = j10 - (j12 * j11);
        if (j13 >= j11) {
            j13 -= j11;
            j12++;
        }
        StringBuilder sb2 = new StringBuilder();
        String string2 = Long.toString(j12, kg.a.a(i10));
        kotlin.jvm.internal.t.e(string2, "toString(...)");
        sb2.append(string2);
        String string3 = Long.toString(j13, kg.a.a(i10));
        kotlin.jvm.internal.t.e(string3, "toString(...)");
        sb2.append(string3);
        return sb2.toString();
    }
}
