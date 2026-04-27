package U5;

import I6.E0;
import R5.InterfaceC0848e;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements InterfaceC0848e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8428a = new a(null);

    public static final class a {
        public a() {
        }

        public final B6.k a(InterfaceC0848e interfaceC0848e, E0 typeSubstitution, J6.g kotlinTypeRefiner) {
            B6.k kVarI;
            AbstractC2304t.f(interfaceC0848e, "<this>");
            AbstractC2304t.f(typeSubstitution, "typeSubstitution");
            AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            z zVar = interfaceC0848e instanceof z ? (z) interfaceC0848e : null;
            if (zVar != null && (kVarI = zVar.I(typeSubstitution, kotlinTypeRefiner)) != null) {
                return kVarI;
            }
            B6.k kVarR0 = interfaceC0848e.r0(typeSubstitution);
            AbstractC2304t.e(kVarR0, "getMemberScope(...)");
            return kVarR0;
        }

        public final B6.k b(InterfaceC0848e interfaceC0848e, J6.g kotlinTypeRefiner) {
            B6.k kVarR;
            AbstractC2304t.f(interfaceC0848e, "<this>");
            AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            z zVar = interfaceC0848e instanceof z ? (z) interfaceC0848e : null;
            if (zVar != null && (kVarR = zVar.R(kotlinTypeRefiner)) != null) {
                return kVarR;
            }
            B6.k kVarF0 = interfaceC0848e.F0();
            AbstractC2304t.e(kVarF0, "getUnsubstitutedMemberScope(...)");
            return kVarF0;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public abstract B6.k I(E0 e02, J6.g gVar);

    public abstract B6.k R(J6.g gVar);
}
