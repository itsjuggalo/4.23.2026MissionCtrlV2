package ke;

import cd.h0;
import kotlin.jvm.internal.t;
import tf.n;
import xe.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f14838c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f14839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ke.a f14840b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final k a(ClassLoader classLoader) {
            t.f(classLoader, "classLoader");
            g gVar = new g(classLoader);
            k.a aVar = xe.k.f24890b;
            ClassLoader classLoader2 = h0.class.getClassLoader();
            t.e(classLoader2, "getClassLoader(...)");
            k.a.C0457a c0457aA = aVar.a(gVar, new g(classLoader2), new d(classLoader), "runtime module for " + classLoader, j.f14837b, l.f14841a);
            return new k(c0457aA.a().a(), new ke.a(c0457aA.b(), gVar), null);
        }

        public a() {
        }
    }

    public /* synthetic */ k(n nVar, ke.a aVar, kotlin.jvm.internal.k kVar) {
        this(nVar, aVar);
    }

    public final n a() {
        return this.f14839a;
    }

    public final fe.h0 b() {
        return this.f14839a.q();
    }

    public final ke.a c() {
        return this.f14840b;
    }

    public k(n nVar, ke.a aVar) {
        this.f14839a = nVar;
        this.f14840b = aVar;
    }
}
