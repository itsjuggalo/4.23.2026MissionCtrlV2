package x6;

import java.io.EOFException;
import kotlin.jvm.internal.r;
import w6.AbstractC2789b;
import w6.C2792e;
import w6.c0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f25325a = c0.a("0123456789abcdef");

    public static final C2792e.a a(C2792e c2792e, C2792e.a unsafeCursor) {
        r.f(c2792e, "<this>");
        r.f(unsafeCursor, "unsafeCursor");
        C2792e.a aVarE = AbstractC2789b.e(unsafeCursor);
        if (aVarE.f25097a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        aVarE.f25097a = c2792e;
        aVarE.f25098b = true;
        return aVarE;
    }

    public static final byte[] b() {
        return f25325a;
    }

    public static final String c(C2792e c2792e, long j7) throws EOFException {
        r.f(c2792e, "<this>");
        if (j7 > 0) {
            long j8 = j7 - 1;
            if (c2792e.T(j8) == 13) {
                String strK = c2792e.k(j8);
                c2792e.skip(2L);
                return strK;
            }
        }
        String strK2 = c2792e.k(j7);
        c2792e.skip(1L);
        return strK2;
    }
}
