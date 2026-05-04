package gh;

import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends IllegalArgumentException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String msg) {
        super(msg);
        t.f(msg, "msg");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(wd.d baseClass, wd.d concreteClass) {
        this("Serializer for " + concreteClass + " already registered in the scope of " + baseClass);
        t.f(baseClass, "baseClass");
        t.f(concreteClass, "concreteClass");
    }
}
