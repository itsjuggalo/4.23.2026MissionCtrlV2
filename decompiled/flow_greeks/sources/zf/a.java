package zf;

import dd.r;
import dd.t0;
import fe.e0;
import fe.g1;
import fe.h0;
import java.util.List;
import kotlin.jvm.internal.t;
import xf.d2;
import xf.f2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends ie.k {
    /* JADX WARN: Illegal instructions before constructor call */
    public a(ef.f name) {
        t.f(name, "name");
        l lVar = l.f26552a;
        h0 h0VarI = lVar.i();
        e0 e0Var = e0.f9463d;
        fe.f fVar = fe.f.f9473b;
        List listK = r.k();
        g1 g1Var = g1.f9483a;
        super(h0VarI, name, e0Var, fVar, listK, g1Var, false, wf.f.f24060e);
        ie.i iVarN1 = ie.i.n1(this, ge.h.L.b(), true, g1Var);
        iVarN1.q1(r.k(), fe.t.f9510d);
        t.e(iVarN1, "apply(...)");
        qf.k kVarB = l.b(h.f26485j, iVarN1.getName().toString(), "");
        k kVar = k.A0;
        iVarN1.g1(new i(lVar.e(kVar, new String[0]), kVarB, kVar, null, false, new String[0], 24, null));
        K0(kVarB, t0.c(iVarN1), iVarN1);
    }

    @Override // ie.a, fe.i1
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public fe.e c(f2 substitutor) {
        t.f(substitutor, "substitutor");
        return this;
    }

    @Override // ie.k
    public String toString() {
        String strB = getName().b();
        t.e(strB, "asString(...)");
        return strB;
    }

    @Override // ie.a, ie.z
    public qf.k w(d2 typeSubstitution, yf.g kotlinTypeRefiner) {
        t.f(typeSubstitution, "typeSubstitution");
        t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return l.b(h.f26485j, getName().toString(), typeSubstitution.toString());
    }
}
