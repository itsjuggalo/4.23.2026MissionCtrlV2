package ie;

import xf.d2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z implements fe.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12516a = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final qf.k a(fe.e eVar, d2 typeSubstitution, yf.g kotlinTypeRefiner) {
            qf.k kVarW;
            kotlin.jvm.internal.t.f(eVar, "<this>");
            kotlin.jvm.internal.t.f(typeSubstitution, "typeSubstitution");
            kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            z zVar = eVar instanceof z ? (z) eVar : null;
            if (zVar != null && (kVarW = zVar.w(typeSubstitution, kotlinTypeRefiner)) != null) {
                return kVarW;
            }
            qf.k kVarH0 = eVar.h0(typeSubstitution);
            kotlin.jvm.internal.t.e(kVarH0, "getMemberScope(...)");
            return kVarH0;
        }

        public final qf.k b(fe.e eVar, yf.g kotlinTypeRefiner) {
            qf.k kVarI;
            kotlin.jvm.internal.t.f(eVar, "<this>");
            kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            z zVar = eVar instanceof z ? (z) eVar : null;
            if (zVar != null && (kVarI = zVar.I(kotlinTypeRefiner)) != null) {
                return kVarI;
            }
            qf.k kVarD0 = eVar.D0();
            kotlin.jvm.internal.t.e(kVarD0, "getUnsubstitutedMemberScope(...)");
            return kVarD0;
        }

        public a() {
        }
    }

    public abstract qf.k I(yf.g gVar);

    public abstract qf.k w(d2 d2Var, yf.g gVar);
}
