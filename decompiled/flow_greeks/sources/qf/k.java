package qf;

import dd.u0;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface k extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19084a = a.f19085a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f19085a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final pd.k f19086b = j.f19083a;

        public static final boolean a(ef.f it) {
            kotlin.jvm.internal.t.f(it, "it");
            return true;
        }

        public final pd.k c() {
            return f19086b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f19087b = new b();

        @Override // qf.l, qf.k
        public Set b() {
            return u0.d();
        }

        @Override // qf.l, qf.k
        public Set d() {
            return u0.d();
        }

        @Override // qf.l, qf.k
        public Set f() {
            return u0.d();
        }
    }

    Collection a(ef.f fVar, ne.b bVar);

    Set b();

    Collection c(ef.f fVar, ne.b bVar);

    Set d();

    Set f();
}
