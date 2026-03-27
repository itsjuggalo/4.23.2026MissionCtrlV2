package q7;

import kotlin.jvm.internal.AbstractC2304t;
import m7.l;
import o5.C2470H;
import p7.AbstractC2609b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h0 {
    public static final boolean c(m7.e eVar) {
        return (eVar.i() instanceof m7.d) || eVar.i() == l.b.f21530a;
    }

    public static final p7.i d(AbstractC2609b json, Object obj, k7.k serializer) {
        AbstractC2304t.f(json, "json");
        AbstractC2304t.f(serializer, "serializer");
        final kotlin.jvm.internal.N n8 = new kotlin.jvm.internal.N();
        new P(json, new B5.k() { // from class: q7.g0
            @Override // B5.k
            public final Object invoke(Object obj2) {
                return h0.e(n8, (p7.i) obj2);
            }
        }).C(serializer, obj);
        Object obj2 = n8.f20469a;
        if (obj2 != null) {
            return (p7.i) obj2;
        }
        AbstractC2304t.s("result");
        return null;
    }

    public static final C2470H e(kotlin.jvm.internal.N n8, p7.i it) {
        AbstractC2304t.f(it, "it");
        n8.f20469a = it;
        return C2470H.f21956a;
    }
}
