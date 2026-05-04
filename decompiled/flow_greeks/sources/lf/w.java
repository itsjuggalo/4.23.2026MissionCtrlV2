package lf;

import fe.h0;
import xf.c1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends r {
    public w(short s10) {
        super(Short.valueOf(s10));
    }

    @Override // lf.g
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public c1 a(h0 module) {
        kotlin.jvm.internal.t.f(module, "module");
        c1 c1VarU = module.p().U();
        kotlin.jvm.internal.t.e(c1VarU, "getShortType(...)");
        return c1VarU;
    }

    @Override // lf.g
    public String toString() {
        return ((Number) b()).intValue() + ".toShort()";
    }
}
