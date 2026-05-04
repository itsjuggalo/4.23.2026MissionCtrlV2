package gh;

import gh.i;
import java.util.List;
import kotlin.jvm.internal.t;
import pd.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface i {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public static void b(i iVar, wd.d kClass, final zg.b serializer) {
            t.f(kClass, "kClass");
            t.f(serializer, "serializer");
            iVar.d(kClass, new k() { // from class: gh.h
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return i.a.c(serializer, (List) obj);
                }
            });
        }

        public static zg.b c(zg.b bVar, List it) {
            t.f(it, "it");
            return bVar;
        }
    }

    void a(wd.d dVar, wd.d dVar2, zg.b bVar);

    void b(wd.d dVar, zg.b bVar);

    void c(wd.d dVar, k kVar);

    void d(wd.d dVar, k kVar);

    void e(wd.d dVar, k kVar);
}
