package fh;

import bh.l;
import bh.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e1 {
    public static final bh.e a(bh.e eVar, gh.e module) {
        bh.e eVarA;
        kotlin.jvm.internal.t.f(eVar, "<this>");
        kotlin.jvm.internal.t.f(module, "module");
        if (!kotlin.jvm.internal.t.b(eVar.h(), l.a.f3400a)) {
            return eVar.isInline() ? a(eVar.o(0), module) : eVar;
        }
        bh.e eVarB = bh.b.b(module, eVar);
        return (eVarB == null || (eVarA = a(eVarB, module)) == null) ? eVar : eVarA;
    }

    public static final d1 b(eh.b bVar, bh.e desc) {
        kotlin.jvm.internal.t.f(bVar, "<this>");
        kotlin.jvm.internal.t.f(desc, "desc");
        bh.l lVarH = desc.h();
        if (lVarH instanceof bh.c) {
            return d1.f9559f;
        }
        if (kotlin.jvm.internal.t.b(lVarH, m.b.f3403a)) {
            return d1.f9557d;
        }
        if (!kotlin.jvm.internal.t.b(lVarH, m.c.f3404a)) {
            return d1.f9556c;
        }
        bh.e eVarA = a(desc.o(0), bVar.a());
        bh.l lVarH2 = eVarA.h();
        if ((lVarH2 instanceof bh.d) || kotlin.jvm.internal.t.b(lVarH2, l.b.f3401a)) {
            return d1.f9558e;
        }
        if (bVar.f().c()) {
            return d1.f9557d;
        }
        throw c0.d(eVarA);
    }
}
