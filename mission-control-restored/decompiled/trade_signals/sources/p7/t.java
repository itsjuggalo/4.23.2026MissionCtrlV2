package p7;

import kotlin.jvm.internal.AbstractC2304t;
import q7.X;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends AbstractC2609b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(C2614g configuration, r7.e module) {
        super(configuration, module, null);
        AbstractC2304t.f(configuration, "configuration");
        AbstractC2304t.f(module, "module");
        h();
    }

    public final void h() {
        if (AbstractC2304t.b(a(), r7.g.a())) {
            return;
        }
        a().a(new X(f().p(), f().e()));
    }
}
