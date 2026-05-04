package qe;

import fe.b;
import fe.f1;
import fe.y0;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends f {
    public final f1 F;
    public final f1 G;
    public final y0 H;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(fe.e ownerDescriptor, f1 getterMethod, f1 f1Var, y0 overriddenProperty) {
        super(ownerDescriptor, ge.h.L.b(), getterMethod.l(), getterMethod.getVisibility(), f1Var != null, overriddenProperty.getName(), getterMethod.j(), null, b.a.DECLARATION, false, null);
        t.f(ownerDescriptor, "ownerDescriptor");
        t.f(getterMethod, "getterMethod");
        t.f(overriddenProperty, "overriddenProperty");
        this.F = getterMethod;
        this.G = f1Var;
        this.H = overriddenProperty;
    }
}
