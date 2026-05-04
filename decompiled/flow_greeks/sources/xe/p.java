package xe;

import xf.c1;
import xf.r0;
import xf.u0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements tf.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f24904a = new p();

    @Override // tf.x
    public r0 a(ze.q proto, String flexibleId, c1 lowerBound, c1 upperBound) {
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(flexibleId, "flexibleId");
        kotlin.jvm.internal.t.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.t.f(upperBound, "upperBound");
        return !kotlin.jvm.internal.t.b(flexibleId, "kotlin.jvm.PlatformType") ? zf.l.d(zf.k.Q, flexibleId, lowerBound.toString(), upperBound.toString()) : proto.x(cf.a.f4056g) ? new te.k(lowerBound, upperBound) : u0.e(lowerBound, upperBound);
    }
}
