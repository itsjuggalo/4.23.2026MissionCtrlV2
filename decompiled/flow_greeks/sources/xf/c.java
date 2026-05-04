package xf;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;
import xf.t1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f24936a = new c();

    public final boolean a(t1 t1Var, bg.j type, t1.c supertypesPolicy) {
        kotlin.jvm.internal.t.f(t1Var, "<this>");
        kotlin.jvm.internal.t.f(type, "type");
        kotlin.jvm.internal.t.f(supertypesPolicy, "supertypesPolicy");
        bg.p pVarJ = t1Var.j();
        if ((pVarJ.A(type) && !pVarJ.n(type)) || pVarJ.p(type)) {
            return true;
        }
        t1Var.k();
        ArrayDeque arrayDequeH = t1Var.h();
        kotlin.jvm.internal.t.c(arrayDequeH);
        Set setI = t1Var.i();
        kotlin.jvm.internal.t.c(setI);
        arrayDequeH.push(type);
        while (!arrayDequeH.isEmpty()) {
            bg.j jVar = (bg.j) arrayDequeH.pop();
            kotlin.jvm.internal.t.c(jVar);
            if (setI.add(jVar)) {
                t1.c cVar = pVarJ.n(jVar) ? t1.c.C0460c.f25074a : supertypesPolicy;
                if (kotlin.jvm.internal.t.b(cVar, t1.c.C0460c.f25074a)) {
                    cVar = null;
                }
                if (cVar == null) {
                    continue;
                } else {
                    bg.p pVarJ2 = t1Var.j();
                    Iterator it = pVarJ2.a0(pVarJ2.f(jVar)).iterator();
                    while (it.hasNext()) {
                        bg.j jVarA = cVar.a(t1Var, (bg.i) it.next());
                        if ((pVarJ.A(jVarA) && !pVarJ.n(jVarA)) || pVarJ.p(jVarA)) {
                            t1Var.e();
                            return true;
                        }
                        arrayDequeH.add(jVarA);
                    }
                }
            }
        }
        t1Var.e();
        return false;
    }

    public final boolean b(t1 state, bg.j start, bg.n end) {
        kotlin.jvm.internal.t.f(state, "state");
        kotlin.jvm.internal.t.f(start, "start");
        kotlin.jvm.internal.t.f(end, "end");
        bg.p pVarJ = state.j();
        if (f24936a.c(state, start, end)) {
            return true;
        }
        state.k();
        ArrayDeque arrayDequeH = state.h();
        kotlin.jvm.internal.t.c(arrayDequeH);
        Set setI = state.i();
        kotlin.jvm.internal.t.c(setI);
        arrayDequeH.push(start);
        while (!arrayDequeH.isEmpty()) {
            bg.j jVar = (bg.j) arrayDequeH.pop();
            kotlin.jvm.internal.t.c(jVar);
            if (setI.add(jVar)) {
                t1.c cVar = pVarJ.n(jVar) ? t1.c.C0460c.f25074a : t1.c.b.f25073a;
                if (kotlin.jvm.internal.t.b(cVar, t1.c.C0460c.f25074a)) {
                    cVar = null;
                }
                if (cVar == null) {
                    continue;
                } else {
                    bg.p pVarJ2 = state.j();
                    Iterator it = pVarJ2.a0(pVarJ2.f(jVar)).iterator();
                    while (it.hasNext()) {
                        bg.j jVarA = cVar.a(state, (bg.i) it.next());
                        if (f24936a.c(state, jVarA, end)) {
                            state.e();
                            return true;
                        }
                        arrayDequeH.add(jVarA);
                    }
                }
            }
        }
        state.e();
        return false;
    }

    public final boolean c(t1 t1Var, bg.j jVar, bg.n nVar) {
        bg.p pVarJ = t1Var.j();
        if (pVarJ.q(jVar)) {
            return true;
        }
        if (pVarJ.n(jVar)) {
            return false;
        }
        if (t1Var.n() && pVarJ.N(jVar)) {
            return true;
        }
        return pVarJ.K(pVarJ.f(jVar), nVar);
    }

    public final boolean d(t1 state, bg.j subType, bg.j superType) {
        kotlin.jvm.internal.t.f(state, "state");
        kotlin.jvm.internal.t.f(subType, "subType");
        kotlin.jvm.internal.t.f(superType, "superType");
        return e(state, subType, superType);
    }

    public final boolean e(t1 t1Var, bg.j jVar, bg.j jVar2) {
        bg.p pVarJ = t1Var.j();
        if (g.f24970b) {
            if (!pVarJ.b(jVar) && !pVarJ.h0(pVarJ.f(jVar))) {
                t1Var.l(jVar);
            }
            if (!pVarJ.b(jVar2)) {
                t1Var.l(jVar2);
            }
        }
        if (pVarJ.n(jVar2) || pVarJ.p(jVar) || pVarJ.l(jVar)) {
            return true;
        }
        if ((jVar instanceof bg.d) && pVarJ.m0((bg.d) jVar)) {
            return true;
        }
        c cVar = f24936a;
        if (cVar.a(t1Var, jVar, t1.c.b.f25073a)) {
            return true;
        }
        if (pVarJ.p(jVar2) || cVar.a(t1Var, jVar2, t1.c.d.f25075a) || pVarJ.A(jVar)) {
            return false;
        }
        return cVar.b(t1Var, jVar, pVarJ.f(jVar2));
    }
}
