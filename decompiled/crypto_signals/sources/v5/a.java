package v5;

import java.io.EOFException;
import kotlin.jvm.internal.j;
import u5.C1250g;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f10654a;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(Y4.a.f3689a);
        j.d(bytes, "this as java.lang.String).getBytes(charset)");
        f10654a = bytes;
    }

    public static final String a(long j4, C1250g c1250g) throws EOFException {
        j.e(c1250g, "<this>");
        if (j4 > 0) {
            long j6 = j4 - 1;
            if (c1250g.i(j6) == 13) {
                String strR = c1250g.r(j6, Y4.a.f3689a);
                c1250g.t(2L);
                return strR;
            }
        }
        String strR2 = c1250g.r(j4, Y4.a.f3689a);
        c1250g.t(1L);
        return strR2;
    }
}
