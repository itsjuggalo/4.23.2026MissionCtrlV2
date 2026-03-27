package B6;

import R5.InterfaceC0851h;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public interface n {

    public static final class a {
        public static /* synthetic */ Collection a(n nVar, d dVar, B5.k kVar, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
            }
            if ((i8 & 1) != 0) {
                dVar = d.f190o;
            }
            if ((i8 & 2) != 0) {
                kVar = k.f216a.c();
            }
            return nVar.g(dVar, kVar);
        }
    }

    InterfaceC0851h e(q6.f fVar, Z5.b bVar);

    Collection g(d dVar, B5.k kVar);
}
