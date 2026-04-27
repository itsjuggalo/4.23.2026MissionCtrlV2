package M2;

import K2.S;
import K2.c0;
import M2.C0448u0;
import java.util.Map;

/* JADX INFO: renamed from: M2.v0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0450v0 extends K2.T {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f2660b;

    static {
        f2660b = !Z1.q.a(System.getenv("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST")) && Boolean.parseBoolean(System.getenv("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST"));
    }

    @Override // K2.S.c
    public K2.S a(S.e eVar) {
        return f2660b ? new C0444s0(eVar) : new C0448u0(eVar);
    }

    @Override // K2.T
    public String b() {
        return "pick_first";
    }

    @Override // K2.T
    public int c() {
        return 5;
    }

    @Override // K2.T
    public boolean d() {
        return true;
    }

    @Override // K2.T
    public c0.b e(Map map) {
        try {
            return c0.b.a(new C0448u0.c(AbstractC0413c0.d(map, "shuffleAddressList")));
        } catch (RuntimeException e4) {
            return c0.b.b(K2.l0.f1230t.p(e4).q("Failed parsing configuration for " + b()));
        }
    }
}
