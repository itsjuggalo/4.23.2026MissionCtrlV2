package Z2;

import Z2.i;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public interface f extends i.b {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final b f6010J = b.f6011a;

    public static final class a {
        public static i.b a(f fVar, i.c key) {
            i.b bVarB;
            r.f(key, "key");
            if (!(key instanceof Z2.b)) {
                if (f.f6010J != key) {
                    return null;
                }
                r.d(fVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return fVar;
            }
            Z2.b bVar = (Z2.b) key;
            if (!bVar.a(fVar.getKey()) || (bVarB = bVar.b(fVar)) == null) {
                return null;
            }
            return bVarB;
        }

        public static i b(f fVar, i.c key) {
            r.f(key, "key");
            if (!(key instanceof Z2.b)) {
                return f.f6010J == key ? j.f6012a : fVar;
            }
            Z2.b bVar = (Z2.b) key;
            return (!bVar.a(fVar.getKey()) || bVar.b(fVar) == null) ? fVar : j.f6012a;
        }
    }

    public static final class b implements i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f6011a = new b();
    }

    e J(e eVar);

    void S(e eVar);
}
