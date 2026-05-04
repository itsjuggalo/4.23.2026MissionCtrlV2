package oe;

import fe.w1;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u0 {
    public static final ge.c a(re.k c10, ve.c0 wildcardType) {
        Object next;
        kotlin.jvm.internal.t.f(c10, "c");
        kotlin.jvm.internal.t.f(wildcardType, "wildcardType");
        if (wildcardType.B() == null) {
            throw new IllegalArgumentException("Nullability annotations on unbounded wildcards aren't supported");
        }
        Iterator it = new re.g(c10, wildcardType, false, 4, null).iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ge.c cVar = (ge.c) next;
            for (ef.c cVar2 : b0.f()) {
                if (kotlin.jvm.internal.t.b(cVar.e(), cVar2)) {
                    break loop0;
                }
            }
        }
        return (ge.c) next;
    }

    public static final boolean b(fe.b memberDescriptor) {
        kotlin.jvm.internal.t.f(memberDescriptor, "memberDescriptor");
        return (memberDescriptor instanceof fe.z) && kotlin.jvm.internal.t.b(memberDescriptor.z(qe.e.H), Boolean.TRUE);
    }

    public static final boolean c(d0 javaTypeEnhancementState) {
        kotlin.jvm.internal.t.f(javaTypeEnhancementState, "javaTypeEnhancementState");
        return javaTypeEnhancementState.c().invoke(b0.e()) == o0.f18048e;
    }

    public static final fe.u d(w1 w1Var) {
        kotlin.jvm.internal.t.f(w1Var, "<this>");
        fe.u uVarG = y.g(w1Var);
        kotlin.jvm.internal.t.e(uVarG, "toDescriptorVisibility(...)");
        return uVarG;
    }
}
