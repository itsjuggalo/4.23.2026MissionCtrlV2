package N4;

import F4.P;
import F4.Q;
import F4.a0;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends Q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f5878b = 0;

    @Override // F4.P.c
    public P a(P.e eVar) {
        return new j(eVar);
    }

    @Override // F4.Q
    public String b() {
        return "round_robin";
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
        return a0.b.a("no service config");
    }
}
