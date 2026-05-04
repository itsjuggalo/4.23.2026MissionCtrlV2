package oe;

import fe.y0;
import jf.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s implements jf.j {
    @Override // jf.j
    public j.a a() {
        return j.a.BOTH;
    }

    @Override // jf.j
    public j.b b(fe.a superDescriptor, fe.a subDescriptor, fe.e eVar) {
        kotlin.jvm.internal.t.f(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.t.f(subDescriptor, "subDescriptor");
        if (!(subDescriptor instanceof y0) || !(superDescriptor instanceof y0)) {
            return j.b.UNKNOWN;
        }
        y0 y0Var = (y0) subDescriptor;
        y0 y0Var2 = (y0) superDescriptor;
        return !kotlin.jvm.internal.t.b(y0Var.getName(), y0Var2.getName()) ? j.b.UNKNOWN : (se.d.a(y0Var) && se.d.a(y0Var2)) ? j.b.OVERRIDABLE : (se.d.a(y0Var) || se.d.a(y0Var2)) ? j.b.INCOMPATIBLE : j.b.UNKNOWN;
    }
}
