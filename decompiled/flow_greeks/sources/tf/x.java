package tf;

import xf.c1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface x {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22074a = new a();

        @Override // tf.x
        public xf.r0 a(ze.q proto, String flexibleId, c1 lowerBound, c1 upperBound) {
            kotlin.jvm.internal.t.f(proto, "proto");
            kotlin.jvm.internal.t.f(flexibleId, "flexibleId");
            kotlin.jvm.internal.t.f(lowerBound, "lowerBound");
            kotlin.jvm.internal.t.f(upperBound, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    xf.r0 a(ze.q qVar, String str, c1 c1Var, c1 c1Var2);
}
