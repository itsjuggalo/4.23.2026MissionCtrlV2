package K2;

import com.google.firebase.messaging.Constants;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c0 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h0 f1164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p0 f1165c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f f1166d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ScheduledExecutorService f1167e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AbstractC0358f f1168f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Executor f1169g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f1170h;

        /* JADX INFO: renamed from: K2.c0$a$a, reason: collision with other inner class name */
        public static final class C0032a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Integer f1171a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public h0 f1172b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public p0 f1173c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public f f1174d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public ScheduledExecutorService f1175e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public AbstractC0358f f1176f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public Executor f1177g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String f1178h;

            public a a() {
                return new a(this.f1171a, this.f1172b, this.f1173c, this.f1174d, this.f1175e, this.f1176f, this.f1177g, this.f1178h, null);
            }

            public C0032a b(AbstractC0358f abstractC0358f) {
                this.f1176f = (AbstractC0358f) Z1.m.n(abstractC0358f);
                return this;
            }

            public C0032a c(int i4) {
                this.f1171a = Integer.valueOf(i4);
                return this;
            }

            public C0032a d(Executor executor) {
                this.f1177g = executor;
                return this;
            }

            public C0032a e(String str) {
                this.f1178h = str;
                return this;
            }

            public C0032a f(h0 h0Var) {
                this.f1172b = (h0) Z1.m.n(h0Var);
                return this;
            }

            public C0032a g(ScheduledExecutorService scheduledExecutorService) {
                this.f1175e = (ScheduledExecutorService) Z1.m.n(scheduledExecutorService);
                return this;
            }

            public C0032a h(f fVar) {
                this.f1174d = (f) Z1.m.n(fVar);
                return this;
            }

            public C0032a i(p0 p0Var) {
                this.f1173c = (p0) Z1.m.n(p0Var);
                return this;
            }
        }

        public /* synthetic */ a(Integer num, h0 h0Var, p0 p0Var, f fVar, ScheduledExecutorService scheduledExecutorService, AbstractC0358f abstractC0358f, Executor executor, String str, b0 b0Var) {
            this(num, h0Var, p0Var, fVar, scheduledExecutorService, abstractC0358f, executor, str);
        }

        public static C0032a g() {
            return new C0032a();
        }

        public int a() {
            return this.f1163a;
        }

        public Executor b() {
            return this.f1169g;
        }

        public h0 c() {
            return this.f1164b;
        }

        public ScheduledExecutorService d() {
            ScheduledExecutorService scheduledExecutorService = this.f1167e;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService;
            }
            throw new IllegalStateException("ScheduledExecutorService not set in Builder");
        }

        public f e() {
            return this.f1166d;
        }

        public p0 f() {
            return this.f1165c;
        }

        public String toString() {
            return Z1.g.b(this).b("defaultPort", this.f1163a).d("proxyDetector", this.f1164b).d("syncContext", this.f1165c).d("serviceConfigParser", this.f1166d).d("scheduledExecutorService", this.f1167e).d("channelLogger", this.f1168f).d("executor", this.f1169g).d("overrideAuthority", this.f1170h).toString();
        }

        public a(Integer num, h0 h0Var, p0 p0Var, f fVar, ScheduledExecutorService scheduledExecutorService, AbstractC0358f abstractC0358f, Executor executor, String str) {
            this.f1163a = ((Integer) Z1.m.o(num, "defaultPort not set")).intValue();
            this.f1164b = (h0) Z1.m.o(h0Var, "proxyDetector not set");
            this.f1165c = (p0) Z1.m.o(p0Var, "syncContext not set");
            this.f1166d = (f) Z1.m.o(fVar, "serviceConfigParser not set");
            this.f1167e = scheduledExecutorService;
            this.f1168f = abstractC0358f;
            this.f1169g = executor;
            this.f1170h = str;
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
        public final List f1181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0353a f1182b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f1183c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List f1184a = Collections.EMPTY_LIST;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public C0353a f1185b = C0353a.f1111c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public b f1186c;

            public e a() {
                return new e(this.f1184a, this.f1185b, this.f1186c);
            }

            public a b(List list) {
                this.f1184a = list;
                return this;
            }

            public a c(C0353a c0353a) {
                this.f1185b = c0353a;
                return this;
            }

            public a d(b bVar) {
                this.f1186c = bVar;
                return this;
            }
        }

        public e(List list, C0353a c0353a, b bVar) {
            this.f1181a = Collections.unmodifiableList(new ArrayList(list));
            this.f1182b = (C0353a) Z1.m.o(c0353a, "attributes");
            this.f1183c = bVar;
        }

        public static a d() {
            return new a();
        }

        public List a() {
            return this.f1181a;
        }

        public C0353a b() {
            return this.f1182b;
        }

        public b c() {
            return this.f1183c;
        }

        public a e() {
            return d().b(this.f1181a).c(this.f1182b).d(this.f1183c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return Z1.i.a(this.f1181a, eVar.f1181a) && Z1.i.a(this.f1182b, eVar.f1182b) && Z1.i.a(this.f1183c, eVar.f1183c);
        }

        public int hashCode() {
            return Z1.i.b(this.f1181a, this.f1182b, this.f1183c);
        }

        public String toString() {
            return Z1.g.b(this).d("addresses", this.f1181a).d("attributes", this.f1182b).d("serviceConfig", this.f1183c).toString();
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
        public final l0 f1179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f1180b;

        public b(Object obj) {
            this.f1180b = Z1.m.o(obj, "config");
            this.f1179a = null;
        }

        public static b a(Object obj) {
            return new b(obj);
        }

        public static b b(l0 l0Var) {
            return new b(l0Var);
        }

        public Object c() {
            return this.f1180b;
        }

        public l0 d() {
            return this.f1179a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                if (Z1.i.a(this.f1179a, bVar.f1179a) && Z1.i.a(this.f1180b, bVar.f1180b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Z1.i.b(this.f1179a, this.f1180b);
        }

        public String toString() {
            return this.f1180b != null ? Z1.g.b(this).d("config", this.f1180b).toString() : Z1.g.b(this).d(Constants.IPC_BUNDLE_KEY_SEND_ERROR, this.f1179a).toString();
        }

        public b(l0 l0Var) {
            this.f1180b = null;
            this.f1179a = (l0) Z1.m.o(l0Var, "status");
            Z1.m.j(!l0Var.o(), "cannot use OK status: %s", l0Var);
        }
    }
}
