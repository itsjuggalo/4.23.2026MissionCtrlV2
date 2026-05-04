package oe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(d0 javaTypeEnhancementState) {
        super(javaTypeEnhancementState);
        kotlin.jvm.internal.t.f(javaTypeEnhancementState, "javaTypeEnhancementState");
    }

    @Override // oe.b
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public Iterable m(ge.c cVar) {
        ge.h annotations;
        kotlin.jvm.internal.t.f(cVar, "<this>");
        fe.e eVarL = nf.e.l(cVar);
        return (eVarL == null || (annotations = eVarL.getAnnotations()) == null) ? dd.r.k() : annotations;
    }

    public final List B(lf.g gVar) {
        if (!(gVar instanceof lf.b)) {
            return gVar instanceof lf.k ? dd.q.e(((lf.k) gVar).c().h()) : dd.r.k();
        }
        Iterable iterable = (Iterable) ((lf.b) gVar).b();
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            dd.w.z(arrayList, B((lf.g) it.next()));
        }
        return arrayList;
    }

    @Override // oe.b
    public boolean o() {
        return false;
    }

    @Override // oe.b
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public Iterable c(ge.c cVar, boolean z10) {
        kotlin.jvm.internal.t.f(cVar, "<this>");
        Map mapA = cVar.a();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : mapA.entrySet()) {
            dd.w.z(arrayList, (!z10 || kotlin.jvm.internal.t.b((ef.f) entry.getKey(), i0.f17983c)) ? B((lf.g) entry.getValue()) : dd.r.k());
        }
        return arrayList;
    }

    @Override // oe.b
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public ef.c k(ge.c cVar) {
        kotlin.jvm.internal.t.f(cVar, "<this>");
        return cVar.e();
    }

    @Override // oe.b
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object l(ge.c cVar) {
        kotlin.jvm.internal.t.f(cVar, "<this>");
        fe.e eVarL = nf.e.l(cVar);
        kotlin.jvm.internal.t.c(eVarL);
        return eVarL;
    }
}
