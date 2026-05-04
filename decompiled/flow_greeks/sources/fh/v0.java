package fh;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f9651a = dd.u0.h(ah.a.r(cd.z.f3889b).getDescriptor(), ah.a.s(cd.b0.f3836b).getDescriptor(), ah.a.q(cd.x.f3884b).getDescriptor(), ah.a.t(cd.e0.f3846b).getDescriptor());

    public static final boolean a(bh.e eVar) {
        kotlin.jvm.internal.t.f(eVar, "<this>");
        return eVar.isInline() && kotlin.jvm.internal.t.b(eVar, eh.j.p());
    }

    public static final boolean b(bh.e eVar) {
        kotlin.jvm.internal.t.f(eVar, "<this>");
        return eVar.isInline() && f9651a.contains(eVar);
    }
}
