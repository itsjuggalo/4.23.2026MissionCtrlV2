package lf;

import fe.h0;
import xf.c1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends g {
    public m(float f10) {
        super(Float.valueOf(f10));
    }

    @Override // lf.g
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public c1 a(h0 module) {
        kotlin.jvm.internal.t.f(module, "module");
        c1 c1VarC = module.p().C();
        kotlin.jvm.internal.t.e(c1VarC, "getFloatType(...)");
        return c1VarC;
    }

    @Override // lf.g
    public String toString() {
        return ((Number) b()).floatValue() + ".toFloat()";
    }
}
