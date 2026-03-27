package v7;

import java.io.EOFException;
import kotlin.jvm.internal.AbstractC2304t;
import u7.C2811d;
import u7.Y;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f23907a = Y.a("0123456789abcdef");

    public static final byte[] a() {
        return f23907a;
    }

    public static final String b(C2811d c2811d, long j8) throws EOFException {
        AbstractC2304t.f(c2811d, "<this>");
        if (j8 > 0) {
            long j9 = j8 - 1;
            if (c2811d.K(j9) == 13) {
                String strJ = c2811d.j(j9);
                c2811d.skip(2L);
                return strJ;
            }
        }
        String strJ2 = c2811d.j(j8);
        c2811d.skip(1L);
        return strJ2;
    }
}
