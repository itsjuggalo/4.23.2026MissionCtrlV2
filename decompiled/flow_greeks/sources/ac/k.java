package ac;

import java.util.Map;
import rb.b1;
import rb.r0;
import rb.s0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends s0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f731b = 0;

    @Override // rb.r0.c
    public r0 a(r0.e eVar) {
        return new j(eVar);
    }

    @Override // rb.s0
    public String b() {
        return "round_robin";
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
        return b1.b.a("no service config");
    }
}
