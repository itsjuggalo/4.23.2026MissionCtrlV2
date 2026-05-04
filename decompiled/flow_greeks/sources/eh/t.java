package eh;

import fh.s0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class t extends b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(g configuration, gh.e module) {
        super(configuration, module, null);
        kotlin.jvm.internal.t.f(configuration, "configuration");
        kotlin.jvm.internal.t.f(module, "module");
        h();
    }

    public final void h() {
        if (kotlin.jvm.internal.t.b(a(), gh.g.a())) {
            return;
        }
        a().a(new s0(f().p(), f().e()));
    }
}
