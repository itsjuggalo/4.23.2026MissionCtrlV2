package W5;

import E6.C0475n;
import R5.H;
import j6.C2247k;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f9300c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0475n f9301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final W5.a f9302b;

    public static final class a {
        public a() {
        }

        public final k a(ClassLoader classLoader) {
            AbstractC2304t.f(classLoader, "classLoader");
            g gVar = new g(classLoader);
            C2247k.a aVar = C2247k.f20197b;
            ClassLoader classLoader2 = C2470H.class.getClassLoader();
            AbstractC2304t.e(classLoader2, "getClassLoader(...)");
            C2247k.a.C0334a c0334aA = aVar.a(gVar, new g(classLoader2), new d(classLoader), "runtime module for " + classLoader, j.f9299b, l.f9303a);
            return new k(c0334aA.a().a(), new W5.a(c0334aA.b(), gVar), null);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public k(C0475n c0475n, W5.a aVar) {
        this.f9301a = c0475n;
        this.f9302b = aVar;
    }

    public final C0475n a() {
        return this.f9301a;
    }

    public final H b() {
        return this.f9301a.q();
    }

    public final W5.a c() {
        return this.f9302b;
    }

    public /* synthetic */ k(C0475n c0475n, W5.a aVar, AbstractC2296k abstractC2296k) {
        this(c0475n, aVar);
    }
}
