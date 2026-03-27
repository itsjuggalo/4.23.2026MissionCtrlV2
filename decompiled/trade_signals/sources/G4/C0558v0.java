package G4;

import F4.P;
import F4.a0;
import G4.C0556u0;
import java.util.Map;
import v2.AbstractC2852r;

/* JADX INFO: renamed from: G4.v0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0558v0 extends F4.Q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f3238b;

    static {
        f3238b = !AbstractC2852r.b(System.getenv("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST")) && Boolean.parseBoolean(System.getenv("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST"));
    }

    @Override // F4.P.c
    public F4.P a(P.e eVar) {
        return f3238b ? new C0552s0(eVar) : new C0556u0(eVar);
    }

    @Override // F4.Q
    public String b() {
        return "pick_first";
    }

    @Override // F4.Q
    public int c() {
        return 5;
    }

    @Override // F4.Q
    public boolean d() {
        return true;
    }

    @Override // F4.Q
    public a0.b e(Map map) {
        try {
            return a0.b.a(new C0556u0.c(AbstractC0521c0.d(map, "shuffleAddressList")));
        } catch (RuntimeException e8) {
            return a0.b.b(F4.j0.f1812t.q(e8).r("Failed parsing configuration for " + b()));
        }
    }
}
