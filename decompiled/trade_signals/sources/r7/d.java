package r7;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends IllegalArgumentException {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(I5.d baseClass, I5.d concreteClass) {
        this("Serializer for " + concreteClass + " already registered in the scope of " + baseClass);
        AbstractC2304t.f(baseClass, "baseClass");
        AbstractC2304t.f(concreteClass, "concreteClass");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String msg) {
        super(msg);
        AbstractC2304t.f(msg, "msg");
    }
}
