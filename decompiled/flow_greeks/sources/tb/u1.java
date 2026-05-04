package tb;

import java.util.Map;
import rb.b1;
import rb.r0;
import tb.t1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class u1 extends rb.s0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f21768b;

    static {
        f21768b = !p6.r.b(System.getenv("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST")) && Boolean.parseBoolean(System.getenv("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST"));
    }

    @Override // rb.r0.c
    public rb.r0 a(r0.e eVar) {
        return f21768b ? new r1(eVar) : new t1(eVar);
    }

    @Override // rb.s0
    public String b() {
        return "pick_first";
    }

    @Override // rb.s0
    public int c() {
        return 5;
    }

    @Override // rb.s0
    public boolean d() {
        return true;
    }

    @Override // rb.s0
    public b1.b e(Map map) {
        try {
            return b1.b.a(new t1.c(b1.d(map, "shuffleAddressList")));
        } catch (RuntimeException e10) {
            return b1.b.b(rb.k1.f19607t.q(e10).r("Failed parsing configuration for " + b()));
        }
    }
}
