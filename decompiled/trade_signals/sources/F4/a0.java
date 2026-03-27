package F4;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import v2.AbstractC2842h;
import v2.AbstractC2844j;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public abstract class a0 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f0 f1730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final n0 f1731c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f f1732d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ScheduledExecutorService f1733e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AbstractC0492f f1734f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Executor f1735g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f1736h;

        /* JADX INFO: renamed from: F4.a0$a$a, reason: collision with other inner class name */
        public static final class C0027a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Integer f1737a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public f0 f1738b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public n0 f1739c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public f f1740d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public ScheduledExecutorService f1741e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public AbstractC0492f f1742f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public Executor f1743g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String f1744h;

            public a a() {
                return new a(this.f1737a, this.f1738b, this.f1739c, this.f1740d, this.f1741e, this.f1742f, this.f1743g, this.f1744h, null);
            }

            public C0027a b(AbstractC0492f abstractC0492f) {
                this.f1742f = (AbstractC0492f) AbstractC2848n.n(abstractC0492f);
                return this;
            }

            public C0027a c(int i8) {
                this.f1737a = Integer.valueOf(i8);
                return this;
            }

            public C0027a d(Executor executor) {
                this.f1743g = executor;
                return this;
            }

            public C0027a e(String str) {
                this.f1744h = str;
                return this;
            }

            public C0027a f(f0 f0Var) {
                this.f1738b = (f0) AbstractC2848n.n(f0Var);
                return this;
            }

            public C0027a g(ScheduledExecutorService scheduledExecutorService) {
                this.f1741e = (ScheduledExecutorService) AbstractC2848n.n(scheduledExecutorService);
                return this;
            }

            public C0027a h(f fVar) {
                this.f1740d = (f) AbstractC2848n.n(fVar);
                return this;
            }

            public C0027a i(n0 n0Var) {
                this.f1739c = (n0) AbstractC2848n.n(n0Var);
                return this;
            }
        }

        public a(Integer num, f0 f0Var, n0 n0Var, f fVar, ScheduledExecutorService scheduledExecutorService, AbstractC0492f abstractC0492f, Executor executor, String str) {
            this.f1729a = ((Integer) AbstractC2848n.o(num, "defaultPort not set")).intValue();
            this.f1730b = (f0) AbstractC2848n.o(f0Var, "proxyDetector not set");
            this.f1731c = (n0) AbstractC2848n.o(n0Var, "syncContext not set");
            this.f1732d = (f) AbstractC2848n.o(fVar, "serviceConfigParser not set");
            this.f1733e = scheduledExecutorService;
            this.f1734f = abstractC0492f;
            this.f1735g = executor;
            this.f1736h = str;
        }

        public static C0027a g() {
            return new C0027a();
        }

        public int a() {
            return this.f1729a;
        }

        public Executor b() {
            return this.f1735g;
        }

        public f0 c() {
            return this.f1730b;
        }

        public ScheduledExecutorService d() {
            ScheduledExecutorService scheduledExecutorService = this.f1733e;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService;
            }
            throw new IllegalStateException("ScheduledExecutorService not set in Builder");
        }

        public f e() {
            return this.f1732d;
        }

        public n0 f() {
            return this.f1731c;
        }

        public String toString() {
            return AbstractC2842h.b(this).b("defaultPort", this.f1729a).d("proxyDetector", this.f1730b).d("syncContext", this.f1731c).d("serviceConfigParser", this.f1732d).d("scheduledExecutorService", this.f1733e).d("channelLogger", this.f1734f).d("executor", this.f1735g).d("overrideAuthority", this.f1736h).toString();
        }

        public /* synthetic */ a(Integer num, f0 f0Var, n0 n0Var, f fVar, ScheduledExecutorService scheduledExecutorService, AbstractC0492f abstractC0492f, Executor executor, String str, Z z7) {
            this(num, f0Var, n0Var, fVar, scheduledExecutorService, abstractC0492f, executor, str);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j0 f1745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f1746b;

        public b(j0 j0Var) {
            this.f1746b = null;
            this.f1745a = (j0) AbstractC2848n.o(j0Var, "status");
            AbstractC2848n.j(!j0Var.p(), "cannot use OK status: %s", j0Var);
        }

        public static b a(Object obj) {
            return new b(obj);
        }

        public static b b(j0 j0Var) {
            return new b(j0Var);
        }

        public Object c() {
            return this.f1746b;
        }

        public j0 d() {
            return this.f1745a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC2844j.a(this.f1745a, bVar.f1745a) && AbstractC2844j.a(this.f1746b, bVar.f1746b);
        }

        public int hashCode() {
            return AbstractC2844j.b(this.f1745a, this.f1746b);
        }

        public String toString() {
            AbstractC2842h.b bVarB;
            String str;
            Object obj;
            if (this.f1746b != null) {
                bVarB = AbstractC2842h.b(this);
                str = "config";
                obj = this.f1746b;
            } else {
                bVarB = AbstractC2842h.b(this);
                str = "error";
                obj = this.f1745a;
            }
            return bVarB.d(str, obj).toString();
        }

        public b(Object obj) {
            this.f1746b = AbstractC2848n.o(obj, "config");
            this.f1745a = null;
        }
    }

    public static abstract class c {
        public abstract String a();

        public abstract a0 b(URI uri, a aVar);
    }

    public static abstract class d {
        public abstract void a(j0 j0Var);

        public abstract void b(e eVar);
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f1747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0487a f1748b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f1749c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List f1750a = Collections.emptyList();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public C0487a f1751b = C0487a.f1724c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public b f1752c;

            public e a() {
                return new e(this.f1750a, this.f1751b, this.f1752c);
            }

            public a b(List list) {
                this.f1750a = list;
                return this;
            }

            public a c(C0487a c0487a) {
                this.f1751b = c0487a;
                return this;
            }

            public a d(b bVar) {
                this.f1752c = bVar;
                return this;
            }
        }

        public e(List list, C0487a c0487a, b bVar) {
            this.f1747a = Collections.unmodifiableList(new ArrayList(list));
            this.f1748b = (C0487a) AbstractC2848n.o(c0487a, "attributes");
            this.f1749c = bVar;
        }

        public static a d() {
            return new a();
        }

        public List a() {
            return this.f1747a;
        }

        public C0487a b() {
            return this.f1748b;
        }

        public b c() {
            return this.f1749c;
        }

        public a e() {
            return d().b(this.f1747a).c(this.f1748b).d(this.f1749c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return AbstractC2844j.a(this.f1747a, eVar.f1747a) && AbstractC2844j.a(this.f1748b, eVar.f1748b) && AbstractC2844j.a(this.f1749c, eVar.f1749c);
        }

        public int hashCode() {
            return AbstractC2844j.b(this.f1747a, this.f1748b, this.f1749c);
        }

        public String toString() {
            return AbstractC2842h.b(this).d("addresses", this.f1747a).d("attributes", this.f1748b).d("serviceConfig", this.f1749c).toString();
        }
    }

    public static abstract class f {
        public abstract b a(Map map);
    }

    public abstract String a();

    public abstract void b();

    public abstract void c();

    public abstract void d(d dVar);
}
