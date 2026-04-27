package H5;

import H5.g;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public interface e extends g.b {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final b f2668J = b.f2669a;

    public static final class a {
        public static g.b a(e eVar, g.c key) {
            g.b bVarB;
            r.f(key, "key");
            if (!(key instanceof H5.b)) {
                if (e.f2668J != key) {
                    return null;
                }
                r.d(eVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return eVar;
            }
            H5.b bVar = (H5.b) key;
            if (!bVar.a(eVar.getKey()) || (bVarB = bVar.b(eVar)) == null) {
                return null;
            }
            return bVarB;
        }

        public static g b(e eVar, g.c key) {
            r.f(key, "key");
            if (!(key instanceof H5.b)) {
                return e.f2668J == key ? h.f2671a : eVar;
            }
            H5.b bVar = (H5.b) key;
            return (!bVar.a(eVar.getKey()) || bVar.b(eVar) == null) ? eVar : h.f2671a;
        }
    }

    public static final class b implements g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f2669a = new b();
    }

    void A(d dVar);

    d K(d dVar);
}
