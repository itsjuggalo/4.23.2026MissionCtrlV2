package qf;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface n {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public static /* synthetic */ Collection a(n nVar, d dVar, pd.k kVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
            }
            if ((i10 & 1) != 0) {
                dVar = d.f19058o;
            }
            if ((i10 & 2) != 0) {
                kVar = k.f19084a.c();
            }
            return nVar.g(dVar, kVar);
        }
    }

    fe.h e(ef.f fVar, ne.b bVar);

    Collection g(d dVar, pd.k kVar);
}
