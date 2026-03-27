package p7;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u {
    public static final AbstractC2609b a(AbstractC2609b from, B5.k builderAction) {
        AbstractC2304t.f(from, "from");
        AbstractC2304t.f(builderAction, "builderAction");
        C2612e c2612e = new C2612e(from);
        builderAction.invoke(c2612e);
        return new t(c2612e.a(), c2612e.b());
    }

    public static /* synthetic */ AbstractC2609b b(AbstractC2609b abstractC2609b, B5.k kVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            abstractC2609b = AbstractC2609b.f22439d;
        }
        return a(abstractC2609b, kVar);
    }
}
