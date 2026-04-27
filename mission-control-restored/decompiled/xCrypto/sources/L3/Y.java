package L3;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f1503a = X2.Q.e(G3.a.r(W2.w.f5503b).getDescriptor(), G3.a.s(W2.y.f5508b).getDescriptor(), G3.a.q(W2.u.f5498b).getDescriptor(), G3.a.t(W2.B.f5458b).getDescriptor());

    public static final boolean a(H3.e eVar) {
        kotlin.jvm.internal.r.f(eVar, "<this>");
        return eVar.isInline() && kotlin.jvm.internal.r.b(eVar, K3.i.p());
    }

    public static final boolean b(H3.e eVar) {
        kotlin.jvm.internal.r.f(eVar, "<this>");
        return eVar.isInline() && f1503a.contains(eVar);
    }
}
