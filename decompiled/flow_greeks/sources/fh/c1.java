package fh;

import bh.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c1 {
    public static final boolean c(bh.e eVar) {
        return (eVar.h() instanceof bh.d) || eVar.h() == l.b.f3401a;
    }

    public static final eh.i d(eh.b json, Object obj, zg.k serializer) {
        kotlin.jvm.internal.t.f(json, "json");
        kotlin.jvm.internal.t.f(serializer, "serializer");
        final kotlin.jvm.internal.m0 m0Var = new kotlin.jvm.internal.m0();
        new l0(json, new pd.k() { // from class: fh.b1
            @Override // pd.k
            public final Object invoke(Object obj2) {
                return c1.e(m0Var, (eh.i) obj2);
            }
        }).B(serializer, obj);
        Object obj2 = m0Var.f14947a;
        if (obj2 != null) {
            return (eh.i) obj2;
        }
        kotlin.jvm.internal.t.s("result");
        return null;
    }

    public static final cd.h0 e(kotlin.jvm.internal.m0 m0Var, eh.i it) {
        kotlin.jvm.internal.t.f(it, "it");
        m0Var.f14947a = it;
        return cd.h0.f3852a;
    }
}
