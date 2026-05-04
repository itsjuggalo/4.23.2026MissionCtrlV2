package rb;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b1 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g1 f19471b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o1 f19472c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f f19473d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ScheduledExecutorService f19474e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final rb.f f19475f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Executor f19476g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f19477h;

        /* JADX INFO: renamed from: rb.b1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0343a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Integer f19478a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public g1 f19479b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public o1 f19480c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public f f19481d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public ScheduledExecutorService f19482e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public rb.f f19483f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public Executor f19484g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String f19485h;

            public a a() {
                return new a(this.f19478a, this.f19479b, this.f19480c, this.f19481d, this.f19482e, this.f19483f, this.f19484g, this.f19485h, null);
            }

            public C0343a b(rb.f fVar) {
                this.f19483f = (rb.f) p6.n.n(fVar);
                return this;
            }

            public C0343a c(int i10) {
                this.f19478a = Integer.valueOf(i10);
                return this;
            }

            public C0343a d(Executor executor) {
                this.f19484g = executor;
                return this;
            }

            public C0343a e(String str) {
                this.f19485h = str;
                return this;
            }

            public C0343a f(g1 g1Var) {
                this.f19479b = (g1) p6.n.n(g1Var);
                return this;
            }

            public C0343a g(ScheduledExecutorService scheduledExecutorService) {
                this.f19482e = (ScheduledExecutorService) p6.n.n(scheduledExecutorService);
                return this;
            }

            public C0343a h(f fVar) {
                this.f19481d = (f) p6.n.n(fVar);
                return this;
            }

            public C0343a i(o1 o1Var) {
                this.f19480c = (o1) p6.n.n(o1Var);
                return this;
            }
        }

        public /* synthetic */ a(Integer num, g1 g1Var, o1 o1Var, f fVar, ScheduledExecutorService scheduledExecutorService, rb.f fVar2, Executor executor, String str, a1 a1Var) {
            this(num, g1Var, o1Var, fVar, scheduledExecutorService, fVar2, executor, str);
        }

        public static C0343a g() {
            return new C0343a();
        }

        public int a() {
            return this.f19470a;
        }

        public Executor b() {
            return this.f19476g;
        }

        public g1 c() {
            return this.f19471b;
        }

        public ScheduledExecutorService d() {
            ScheduledExecutorService scheduledExecutorService = this.f19474e;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService;
            }
            throw new IllegalStateException("ScheduledExecutorService not set in Builder");
        }

        public f e() {
            return this.f19473d;
        }

        public o1 f() {
            return this.f19472c;
        }

        public String toString() {
            return p6.h.b(this).b("defaultPort", this.f19470a).d("proxyDetector", this.f19471b).d("syncContext", this.f19472c).d("serviceConfigParser", this.f19473d).d("scheduledExecutorService", this.f19474e).d("channelLogger", this.f19475f).d("executor", this.f19476g).d("overrideAuthority", this.f19477h).toString();
        }

        public a(Integer num, g1 g1Var, o1 o1Var, f fVar, ScheduledExecutorService scheduledExecutorService, rb.f fVar2, Executor executor, String str) {
            this.f19470a = ((Integer) p6.n.o(num, "defaultPort not set")).intValue();
            this.f19471b = (g1) p6.n.o(g1Var, "proxyDetector not set");
            this.f19472c = (o1) p6.n.o(o1Var, "syncContext not set");
            this.f19473d = (f) p6.n.o(fVar, "serviceConfigParser not set");
            this.f19474e = scheduledExecutorService;
            this.f19475f = fVar2;
            this.f19476g = executor;
            this.f19477h = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class c {
        public abstract String a();

        public abstract b1 b(URI uri, a aVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class d {
        public abstract void a(k1 k1Var);

        public abstract void b(e eVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f19488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final rb.a f19489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f19490c;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List f19491a = Collections.EMPTY_LIST;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public rb.a f19492b = rb.a.f19462c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public b f19493c;

            public e a() {
                return new e(this.f19491a, this.f19492b, this.f19493c);
            }

            public a b(List list) {
                this.f19491a = list;
                return this;
            }

            public a c(rb.a aVar) {
                this.f19492b = aVar;
                return this;
            }

            public a d(b bVar) {
                this.f19493c = bVar;
                return this;
            }
        }

        public e(List list, rb.a aVar, b bVar) {
            this.f19488a = Collections.unmodifiableList(new ArrayList(list));
            this.f19489b = (rb.a) p6.n.o(aVar, "attributes");
            this.f19490c = bVar;
        }

        public static a d() {
            return new a();
        }

        public List a() {
            return this.f19488a;
        }

        public rb.a b() {
            return this.f19489b;
        }

        public b c() {
            return this.f19490c;
        }

        public a e() {
            return d().b(this.f19488a).c(this.f19489b).d(this.f19490c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return p6.j.a(this.f19488a, eVar.f19488a) && p6.j.a(this.f19489b, eVar.f19489b) && p6.j.a(this.f19490c, eVar.f19490c);
        }

        public int hashCode() {
            return p6.j.b(this.f19488a, this.f19489b, this.f19490c);
        }

        public String toString() {
            return p6.h.b(this).d("addresses", this.f19488a).d("attributes", this.f19489b).d("serviceConfig", this.f19490c).toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class f {
        public abstract b a(Map map);
    }

    public abstract String a();

    public abstract void b();

    public abstract void c();

    public abstract void d(d dVar);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k1 f19486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f19487b;

        public b(Object obj) {
            this.f19487b = p6.n.o(obj, "config");
            this.f19486a = null;
        }

        public static b a(Object obj) {
            return new b(obj);
        }

        public static b b(k1 k1Var) {
            return new b(k1Var);
        }

        public Object c() {
            return this.f19487b;
        }

        public k1 d() {
            return this.f19486a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                if (p6.j.a(this.f19486a, bVar.f19486a) && p6.j.a(this.f19487b, bVar.f19487b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return p6.j.b(this.f19486a, this.f19487b);
        }

        public String toString() {
            return this.f19487b != null ? p6.h.b(this).d("config", this.f19487b).toString() : p6.h.b(this).d("error", this.f19486a).toString();
        }

        public b(k1 k1Var) {
            this.f19487b = null;
            this.f19486a = (k1) p6.n.o(k1Var, "status");
            p6.n.j(!k1Var.p(), "cannot use OK status: %s", k1Var);
        }
    }
}
