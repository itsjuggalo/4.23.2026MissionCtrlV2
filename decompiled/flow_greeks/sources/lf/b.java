package lf;

import fe.h0;
import java.util.List;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class b extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pd.k f15651b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(List value, pd.k computeType) {
        super(value);
        kotlin.jvm.internal.t.f(value, "value");
        kotlin.jvm.internal.t.f(computeType, "computeType");
        this.f15651b = computeType;
    }

    @Override // lf.g
    public r0 a(h0 module) {
        kotlin.jvm.internal.t.f(module, "module");
        r0 r0Var = (r0) this.f15651b.invoke(module);
        if (!ce.i.d0(r0Var) && !ce.i.r0(r0Var)) {
            ce.i.E0(r0Var);
        }
        return r0Var;
    }
}
