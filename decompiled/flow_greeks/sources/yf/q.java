package yf;

import xf.l2;
import xf.r0;
import xf.t1;
import yf.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f25425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f25426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final jf.o f25427e;

    public q(g kotlinTypeRefiner, f kotlinTypePreparator) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.jvm.internal.t.f(kotlinTypePreparator, "kotlinTypePreparator");
        this.f25425c = kotlinTypeRefiner;
        this.f25426d = kotlinTypePreparator;
        jf.o oVarM = jf.o.m(d());
        kotlin.jvm.internal.t.e(oVarM, "createWithTypeRefiner(...)");
        this.f25427e = oVarM;
    }

    @Override // yf.p
    public jf.o a() {
        return this.f25427e;
    }

    @Override // yf.e
    public boolean b(r0 a10, r0 b10) {
        kotlin.jvm.internal.t.f(a10, "a");
        kotlin.jvm.internal.t.f(b10, "b");
        return e(a.b(false, false, null, f(), d(), 6, null), a10.Q0(), b10.Q0());
    }

    @Override // yf.e
    public boolean c(r0 subtype, r0 supertype) {
        kotlin.jvm.internal.t.f(subtype, "subtype");
        kotlin.jvm.internal.t.f(supertype, "supertype");
        return g(a.b(true, false, null, f(), d(), 6, null), subtype.Q0(), supertype.Q0());
    }

    @Override // yf.p
    public g d() {
        return this.f25425c;
    }

    public final boolean e(t1 t1Var, l2 a10, l2 b10) {
        kotlin.jvm.internal.t.f(t1Var, "<this>");
        kotlin.jvm.internal.t.f(a10, "a");
        kotlin.jvm.internal.t.f(b10, "b");
        return xf.g.f24969a.m(t1Var, a10, b10);
    }

    public f f() {
        return this.f25426d;
    }

    public final boolean g(t1 t1Var, l2 subType, l2 superType) {
        kotlin.jvm.internal.t.f(t1Var, "<this>");
        kotlin.jvm.internal.t.f(subType, "subType");
        kotlin.jvm.internal.t.f(superType, "superType");
        return xf.g.v(xf.g.f24969a, t1Var, subType, superType, false, 8, null);
    }

    public /* synthetic */ q(g gVar, f fVar, int i10, kotlin.jvm.internal.k kVar) {
        this(gVar, (i10 & 2) != 0 ? f.a.f25403a : fVar);
    }
}
