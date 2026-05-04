package oe;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m0 implements k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f18041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wf.f f18042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wf.h f18043d;

    public m0(Map states) {
        kotlin.jvm.internal.t.f(states, "states");
        this.f18041b = states;
        wf.f fVar = new wf.f("Java nullability annotation states");
        this.f18042c = fVar;
        wf.h hVarH = fVar.h(new l0(this));
        kotlin.jvm.internal.t.e(hVarH, "createMemoizedFunctionWithNullableValues(...)");
        this.f18043d = hVarH;
    }

    public static final Object c(m0 m0Var, ef.c cVar) {
        kotlin.jvm.internal.t.c(cVar);
        return ef.e.a(cVar, m0Var.f18041b);
    }

    @Override // oe.k0
    public Object a(ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        return this.f18043d.invoke(fqName);
    }
}
