package te;

import cd.q;
import dd.a0;
import dd.s;
import hf.n;
import hf.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kg.c0;
import kotlin.jvm.internal.t;
import xf.a2;
import xf.b1;
import xf.c1;
import xf.i0;
import xf.q1;
import xf.r0;
import xf.z1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends i0 implements b1 {
    public k(c1 c1Var, c1 c1Var2, boolean z10) {
        super(c1Var, c1Var2);
        if (z10) {
            return;
        }
        yf.e.f25402a.c(c1Var, c1Var2);
    }

    public static final CharSequence b1(String it) {
        t.f(it, "it");
        return "(raw) " + it;
    }

    public static final boolean c1(String str, String str2) {
        return t.b(str, c0.y0(str2, "out ")) || t.b(str2, "*");
    }

    public static final List d1(n nVar, r0 r0Var) {
        List listL0 = r0Var.L0();
        ArrayList arrayList = new ArrayList(s.u(listL0, 10));
        Iterator it = listL0.iterator();
        while (it.hasNext()) {
            arrayList.add(nVar.T((a2) it.next()));
        }
        return arrayList;
    }

    public static final String e1(String str, String str2) {
        if (!c0.O(str, '<', false, 2, null)) {
            return str;
        }
        return c0.W0(str, '<', null, 2, null) + '<' + str2 + '>' + c0.S0(str, '>', null, 2, null);
    }

    @Override // xf.i0
    public c1 U0() {
        return V0();
    }

    @Override // xf.i0
    public String X0(n renderer, w options) {
        t.f(renderer, "renderer");
        t.f(options, "options");
        String strS = renderer.S(V0());
        String strS2 = renderer.S(W0());
        if (options.n()) {
            return "raw (" + strS + ".." + strS2 + ')';
        }
        if (W0().L0().isEmpty()) {
            return renderer.P(strS, strS2, cg.d.n(this));
        }
        List listD1 = d1(renderer, V0());
        List listD12 = d1(renderer, W0());
        String strI0 = a0.i0(listD1, ", ", null, null, 0, null, j.f21927a, 30, null);
        List<q> listS0 = a0.S0(listD1, listD12);
        if (listS0 == null || !listS0.isEmpty()) {
            for (q qVar : listS0) {
                if (!c1((String) qVar.c(), (String) qVar.d())) {
                    break;
                }
            }
            strS2 = e1(strS2, strI0);
        } else {
            strS2 = e1(strS2, strI0);
        }
        String strE1 = e1(strS, strI0);
        return t.b(strE1, strS2) ? strE1 : renderer.P(strE1, strS2, cg.d.n(this));
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public k R0(boolean z10) {
        return new k(V0().R0(z10), W0().R0(z10));
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public i0 X0(yf.g kotlinTypeRefiner) {
        t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        r0 r0VarA = kotlinTypeRefiner.a(V0());
        t.d(r0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        r0 r0VarA2 = kotlinTypeRefiner.a(W0());
        t.d(r0VarA2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new k((c1) r0VarA, (c1) r0VarA2, true);
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: f1, reason: merged with bridge method [inline-methods] */
    public k T0(q1 newAttributes) {
        t.f(newAttributes, "newAttributes");
        return new k(V0().T0(newAttributes), W0().T0(newAttributes));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xf.i0, xf.r0
    public qf.k q() {
        fe.h hVarB = N0().b();
        z1 z1Var = null;
        Object[] objArr = 0;
        fe.e eVar = hVarB instanceof fe.e ? (fe.e) hVarB : null;
        if (eVar != null) {
            qf.k kVarH0 = eVar.h0(new i(z1Var, 1, objArr == true ? 1 : 0));
            t.e(kVarH0, "getMemberScope(...)");
            return kVarH0;
        }
        throw new IllegalStateException(("Incorrect classifier: " + N0().b()).toString());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(c1 lowerBound, c1 upperBound) {
        this(lowerBound, upperBound, false);
        t.f(lowerBound, "lowerBound");
        t.f(upperBound, "upperBound");
    }
}
