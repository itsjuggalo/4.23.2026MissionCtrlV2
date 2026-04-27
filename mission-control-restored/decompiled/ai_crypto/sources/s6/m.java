package s6;

import t6.V;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(f configuration, u6.e module) {
        super(configuration, module, null);
        kotlin.jvm.internal.r.f(configuration, "configuration");
        kotlin.jvm.internal.r.f(module, "module");
        h();
    }

    public final void h() {
        if (kotlin.jvm.internal.r.b(a(), u6.g.a())) {
            return;
        }
        a().a(new V(f().l(), f().c()));
    }
}
