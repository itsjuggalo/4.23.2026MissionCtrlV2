package ih;

import hh.d;
import hh.v;
import java.io.EOFException;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f12518a = v.a("0123456789abcdef");

    public static final byte[] a() {
        return f12518a;
    }

    public static final String b(d dVar, long j10) throws EOFException {
        t.f(dVar, "<this>");
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (dVar.H(j11) == 13) {
                String strC0 = dVar.c0(j11);
                dVar.skip(2L);
                return strC0;
            }
        }
        String strC02 = dVar.c0(j10);
        dVar.skip(1L);
        return strC02;
    }
}
