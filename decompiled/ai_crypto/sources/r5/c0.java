package r5;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c0 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f22653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h0 f22654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p0 f22655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f f22656d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ScheduledExecutorService f22657e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AbstractC2590f f22658f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Executor f22659g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f22660h;

        /* JADX INFO: renamed from: r5.c0$a$a, reason: collision with other inner class name */
        public static final class C0352a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Integer f22661a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public h0 f22662b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public p0 f22663c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public f f22664d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public ScheduledExecutorService f22665e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public AbstractC2590f f22666f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public Executor f22667g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String f22668h;

            public a a() {
                return new a(this.f22661a, this.f22662b, this.f22663c, this.f22664d, this.f22665e, this.f22666f, this.f22667g, this.f22668h, null);
            }

            public C0352a b(AbstractC2590f abstractC2590f) {
                this.f22666f = (AbstractC2590f) H2.m.n(abstractC2590f);
                return this;
            }

            public C0352a c(int i7) {
                this.f22661a = Integer.valueOf(i7);
                return this;
            }

            public C0352a d(Executor executor) {
                this.f22667g = executor;
                return this;
            }

            public C0352a e(String str) {
                this.f22668h = str;
                return this;
            }

            public C0352a f(h0 h0Var) {
                this.f22662b = (h0) H2.m.n(h0Var);
                return this;
            }

            public C0352a g(ScheduledExecutorService scheduledExecutorService) {
                this.f22665e = (ScheduledExecutorService) H2.m.n(scheduledExecutorService);
                return this;
            }

            public C0352a h(f fVar) {
                this.f22664d = (f) H2.m.n(fVar);
                return this;
            }

            public C0352a i(p0 p0Var) {
                this.f22663c = (p0) H2.m.n(p0Var);
                return this;
            }
        }

        public /* synthetic */ a(Integer num, h0 h0Var, p0 p0Var, f fVar, ScheduledExecutorService scheduledExecutorService, AbstractC2590f abstractC2590f, Executor executor, String str, b0 b0Var) {
            this(num, h0Var, p0Var, fVar, scheduledExecutorService, abstractC2590f, executor, str);
        }

        public static C0352a g() {
            return new C0352a();
        }

        public int a() {
            return this.f22653a;
        }

        public Executor b() {
            return this.f22659g;
        }

        public h0 c() {
            return this.f22654b;
        }

        public ScheduledExecutorService d() {
            ScheduledExecutorService scheduledExecutorService = this.f22657e;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService;
            }
            throw new IllegalStateException("ScheduledExecutorService not set in Builder");
        }

        public f e() {
            return this.f22656d;
        }

        public p0 f() {
            return this.f22655c;
        }

        public String toString() {
            return H2.g.b(this).b("defaultPort", this.f22653a).d("proxyDetector", this.f22654b).d("syncContext", this.f22655c).d("serviceConfigParser", this.f22656d).d("scheduledExecutorService", this.f22657e).d("channelLogger", this.f22658f).d("executor", this.f22659g).d("overrideAuthority", this.f22660h).toString();
        }

        public a(Integer num, h0 h0Var, p0 p0Var, f fVar, ScheduledExecutorService scheduledExecutorService, AbstractC2590f abstractC2590f, Executor executor, String str) {
            this.f22653a = ((Integer) H2.m.o(num, "defaultPort not set")).intValue();
            this.f22654b = (h0) H2.m.o(h0Var, "proxyDetector not set");
            this.f22655c = (p0) H2.m.o(p0Var, "syncContext not set");
            this.f22656d = (f) H2.m.o(fVar, "serviceConfigParser not set");
            this.f22657e = scheduledExecutorService;
            this.f22658f = abstractC2590f;
            this.f22659g = executor;
            this.f22660h = str;
        }
    }

    public static abstract class c {
        public abstract String a();

        public abstract c0 b(URI uri, a aVar);
    }

    public static abstract class d {
        public abstract void a(l0 l0Var);

        public abstract void b(e eVar);
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f22671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C2585a f22672b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f22673c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List f22674a = Collections.emptyList();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public C2585a f22675b = C2585a.f22601c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public b f22676c;

            public e a() {
                return new e(this.f22674a, this.f22675b, this.f22676c);
            }

            public a b(List list) {
                this.f22674a = list;
                return this;
            }

            public a c(C2585a c2585a) {
                this.f22675b = c2585a;
                return this;
            }

            public a d(b bVar) {
                this.f22676c = bVar;
                return this;
            }
        }

        public e(List list, C2585a c2585a, b bVar) {
            this.f22671a = Collections.unmodifiableList(new ArrayList(list));
            this.f22672b = (C2585a) H2.m.o(c2585a, "attributes");
            this.f22673c = bVar;
        }

        public static a d() {
            return new a();
        }

        public List a() {
            return this.f22671a;
        }

        public C2585a b() {
            return this.f22672b;
        }

        public b c() {
            return this.f22673c;
        }

        public a e() {
            return d().b(this.f22671a).c(this.f22672b).d(this.f22673c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return H2.i.a(this.f22671a, eVar.f22671a) && H2.i.a(this.f22672b, eVar.f22672b) && H2.i.a(this.f22673c, eVar.f22673c);
        }

        public int hashCode() {
            return H2.i.b(this.f22671a, this.f22672b, this.f22673c);
        }

        public String toString() {
            return H2.g.b(this).d("addresses", this.f22671a).d("attributes", this.f22672b).d("serviceConfig", this.f22673c).toString();
        }
    }

    public static abstract class f {
        public abstract b a(Map map);
    }

    public abstract String a();

    public abstract void b();

    public abstract void c();

    public abstract void d(d dVar);

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0 f22669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f22670b;

        public b(Object obj) {
            this.f22670b = H2.m.o(obj, "config");
            this.f22669a = null;
        }

        public static b a(Object obj) {
            return new b(obj);
        }

        public static b b(l0 l0Var) {
            return new b(l0Var);
        }

        public Object c() {
            return this.f22670b;
        }

        public l0 d() {
            return this.f22669a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return H2.i.a(this.f22669a, bVar.f22669a) && H2.i.a(this.f22670b, bVar.f22670b);
        }

        public int hashCode() {
            return H2.i.b(this.f22669a, this.f22670b);
        }

        public String toString() {
            return this.f22670b != null ? H2.g.b(this).d("config", this.f22670b).toString() : H2.g.b(this).d("error", this.f22669a).toString();
        }

        public b(l0 l0Var) {
            this.f22670b = null;
            this.f22669a = (l0) H2.m.o(l0Var, "status");
            H2.m.j(!l0Var.o(), "cannot use OK status: %s", l0Var);
        }
    }
}
