package t5;

import java.util.Map;
import r5.S;
import r5.c0;
import t5.C2703u0;

/* JADX INFO: renamed from: t5.v0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2705v0 extends r5.T {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f24211b;

    static {
        f24211b = !H2.q.a(System.getenv("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST")) && Boolean.parseBoolean(System.getenv("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST"));
    }

    @Override // r5.S.c
    public r5.S a(S.e eVar) {
        return f24211b ? new C2699s0(eVar) : new C2703u0(eVar);
    }

    @Override // r5.T
    public String b() {
        return "pick_first";
    }

    @Override // r5.T
    public int c() {
        return 5;
    }

    @Override // r5.T
    public boolean d() {
        return true;
    }

    @Override // r5.T
    public c0.b e(Map map) {
        try {
            return c0.b.a(new C2703u0.c(AbstractC2668c0.d(map, "shuffleAddressList")));
        } catch (RuntimeException e7) {
            return c0.b.b(r5.l0.f22720t.p(e7).q("Failed parsing configuration for " + b()));
        }
    }
}
