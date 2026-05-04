package fe;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface j1 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements j1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9488a = new a();

        @Override // fe.j1
        public Collection a(xf.u1 currentTypeConstructor, Collection superTypes, pd.k neighbors, pd.k reportLoop) {
            kotlin.jvm.internal.t.f(currentTypeConstructor, "currentTypeConstructor");
            kotlin.jvm.internal.t.f(superTypes, "superTypes");
            kotlin.jvm.internal.t.f(neighbors, "neighbors");
            kotlin.jvm.internal.t.f(reportLoop, "reportLoop");
            return superTypes;
        }
    }

    Collection a(xf.u1 u1Var, Collection collection, pd.k kVar, pd.k kVar2);
}
