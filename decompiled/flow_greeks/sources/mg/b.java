package mg;

import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final void a(long j10, byte[] dst, int i10, int i11, int i12) {
        t.f(dst, "dst");
        c.f(j10, dst, i10, i11, i12);
    }

    public static final a b(String hexString) {
        t.f(hexString, "hexString");
        return c.h(hexString);
    }

    public static final a c(String hexDashString) {
        t.f(hexDashString, "hexDashString");
        return c.i(hexDashString);
    }
}
