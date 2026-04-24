package P3;

import O3.d;
import O3.v;
import java.io.EOFException;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f3536a = v.a("0123456789abcdef");

    public static final byte[] a() {
        return f3536a;
    }

    public static final String b(d dVar, long j4) throws EOFException {
        r.f(dVar, "<this>");
        if (j4 > 0) {
            long j5 = j4 - 1;
            if (dVar.E(j5) == 13) {
                String strE0 = dVar.e0(j5);
                dVar.skip(2L);
                return strE0;
            }
        }
        String strE02 = dVar.e0(j4);
        dVar.skip(1L);
        return strE02;
    }
}
