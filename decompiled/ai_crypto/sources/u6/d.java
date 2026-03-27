package u6;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends IllegalArgumentException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String msg) {
        super(msg);
        r.f(msg, "msg");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(X5.c baseClass, X5.c concreteClass) {
        this("Serializer for " + concreteClass + " already registered in the scope of " + baseClass);
        r.f(baseClass, "baseClass");
        r.f(concreteClass, "concreteClass");
    }
}
