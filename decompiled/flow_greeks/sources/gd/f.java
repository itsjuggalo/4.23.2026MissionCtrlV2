package gd;

import gd.i;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface f extends i.b {
    public static final b K = b.f10530a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public static i.b a(f fVar, i.c key) {
            i.b bVarB;
            t.f(key, "key");
            if (!(key instanceof gd.b)) {
                if (f.K != key) {
                    return null;
                }
                t.d(fVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return fVar;
            }
            gd.b bVar = (gd.b) key;
            if (!bVar.a(fVar.getKey()) || (bVarB = bVar.b(fVar)) == null) {
                return null;
            }
            return bVarB;
        }

        public static i b(f fVar, i.c key) {
            t.f(key, "key");
            if (!(key instanceof gd.b)) {
                return f.K == key ? j.f10531a : fVar;
            }
            gd.b bVar = (gd.b) key;
            return (!bVar.a(fVar.getKey()) || bVar.b(fVar) == null) ? fVar : j.f10531a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f10530a = new b();
    }

    void O(e eVar);

    e R(e eVar);
}
