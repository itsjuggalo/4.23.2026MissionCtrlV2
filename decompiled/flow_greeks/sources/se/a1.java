package se;

import java.util.Collection;
import java.util.List;
import se.t0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a1 extends t0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a1(re.k c10) {
        super(c10, null, 2, 0 == true ? 1 : 0);
        kotlin.jvm.internal.t.f(c10, "c");
    }

    @Override // se.t0
    public void C(ef.f name, Collection result) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(result, "result");
    }

    @Override // se.t0
    public fe.b1 O() {
        return null;
    }

    @Override // se.t0
    public t0.a Y(ve.r method, List methodTypeParameters, xf.r0 returnType, List valueParameters) {
        kotlin.jvm.internal.t.f(method, "method");
        kotlin.jvm.internal.t.f(methodTypeParameters, "methodTypeParameters");
        kotlin.jvm.internal.t.f(returnType, "returnType");
        kotlin.jvm.internal.t.f(valueParameters, "valueParameters");
        return new t0.a(returnType, null, valueParameters, methodTypeParameters, false, dd.r.k());
    }
}
