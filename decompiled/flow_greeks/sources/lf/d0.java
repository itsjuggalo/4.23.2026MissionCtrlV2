package lf;

import ce.o;
import fe.h0;
import xf.c1;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends e0 {
    public d0(short s10) {
        super(Short.valueOf(s10));
    }

    @Override // lf.g
    public r0 a(h0 module) {
        c1 c1VarS;
        kotlin.jvm.internal.t.f(module, "module");
        fe.e eVarB = fe.y.b(module, o.a.E0);
        return (eVarB == null || (c1VarS = eVarB.s()) == null) ? zf.l.d(zf.k.E0, "UShort") : c1VarS;
    }

    @Override // lf.g
    public String toString() {
        return ((Number) b()).intValue() + ".toUShort()";
    }
}
