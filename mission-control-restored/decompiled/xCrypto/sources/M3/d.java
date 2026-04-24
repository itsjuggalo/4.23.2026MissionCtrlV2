package M3;

import kotlin.jvm.internal.r;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends IllegalArgumentException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String msg) {
        super(msg);
        r.f(msg, "msg");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(InterfaceC1716c baseClass, InterfaceC1716c concreteClass) {
        this("Serializer for " + concreteClass + " already registered in the scope of " + baseClass);
        r.f(baseClass, "baseClass");
        r.f(concreteClass, "concreteClass");
    }
}
