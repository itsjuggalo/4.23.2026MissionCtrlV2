package t5;

import com.revenuecat.purchases.common.Constants;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import r5.C2585a;
import r5.C2607x;
import r5.c0;
import t5.L0;

/* JADX INFO: loaded from: classes2.dex */
public class D extends r5.c0 {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static String f23401A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Logger f23402s = Logger.getLogger(D.class.getName());

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Set f23403t = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f23404u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f23405v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f23406w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f23407x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f23408y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f23409z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r5.h0 f23410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Random f23411b = new Random();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile b f23412c = d.INSTANCE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f23413d = new AtomicReference();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f23414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f23415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f23416g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final L0.d f23417h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f23418i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final r5.p0 f23419j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final H2.p f23420k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f23421l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f23422m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Executor f23423n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f23424o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c0.f f23425p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f23426q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c0.d f23427r;

    public interface b {
        List a(String str);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public r5.l0 f23428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f23429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c0.b f23430c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public C2585a f23431d;

        public c() {
        }
    }

    public enum d implements b {
        INSTANCE;

        @Override // t5.D.b
        public List a(String str) {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
        }
    }

    public final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c0.d f23434a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f23436a;

            public a(boolean z7) {
                this.f23436a = z7;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f23436a) {
                    D d7 = D.this;
                    d7.f23421l = true;
                    if (d7.f23418i > 0) {
                        D.this.f23420k.f().g();
                    }
                }
                D.this.f23426q = false;
            }
        }

        public e(c0.d dVar) {
            this.f23434a = (c0.d) H2.m.o(dVar, "savedListener");
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z7;
            r5.p0 p0Var;
            a aVar;
            Logger logger = D.f23402s;
            Level level = Level.FINER;
            if (logger.isLoggable(level)) {
                D.f23402s.finer("Attempting DNS resolution of " + D.this.f23415f);
            }
            c cVarN = null;
            try {
                try {
                    C2607x c2607xM = D.this.m();
                    c0.e.a aVarD = c0.e.d();
                    if (c2607xM != null) {
                        if (D.f23402s.isLoggable(level)) {
                            D.f23402s.finer("Using proxy address " + c2607xM);
                        }
                        aVarD.b(Collections.singletonList(c2607xM));
                    } else {
                        cVarN = D.this.n(false);
                        if (cVarN.f23428a != null) {
                            this.f23434a.a(cVarN.f23428a);
                            D.this.f23419j.execute(new a(cVarN != null && cVarN.f23428a == null));
                            return;
                        }
                        if (cVarN.f23429b != null) {
                            aVarD.b(cVarN.f23429b);
                        }
                        if (cVarN.f23430c != null) {
                            aVarD.d(cVarN.f23430c);
                        }
                        C2585a c2585a = cVarN.f23431d;
                        if (c2585a != null) {
                            aVarD.c(c2585a);
                        }
                    }
                    this.f23434a.b(aVarD.a());
                    z7 = cVarN != null && cVarN.f23428a == null;
                    p0Var = D.this.f23419j;
                    aVar = new a(z7);
                } catch (IOException e7) {
                    this.f23434a.a(r5.l0.f22720t.q("Unable to resolve host " + D.this.f23415f).p(e7));
                    z7 = 0 != 0 && null.f23428a == null;
                    p0Var = D.this.f23419j;
                    aVar = new a(z7);
                }
                p0Var.execute(aVar);
            } catch (Throwable th) {
                D.this.f23419j.execute(new a(0 != 0 && null.f23428a == null));
                throw th;
            }
        }
    }

    public interface f {
    }

    public interface g {
    }

    static {
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", com.amazon.a.a.o.b.af);
        f23404u = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", com.amazon.a.a.o.b.ag);
        f23405v = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", com.amazon.a.a.o.b.ag);
        f23406w = property3;
        f23407x = Boolean.parseBoolean(property);
        f23408y = Boolean.parseBoolean(property2);
        f23409z = Boolean.parseBoolean(property3);
        u(D.class.getClassLoader());
    }

    public D(String str, String str2, c0.a aVar, L0.d dVar, H2.p pVar, boolean z7) {
        H2.m.o(aVar, "args");
        this.f23417h = dVar;
        URI uriCreate = URI.create("//" + ((String) H2.m.o(str2, "name")));
        H2.m.j(uriCreate.getHost() != null, "Invalid DNS name: %s", str2);
        this.f23414e = (String) H2.m.p(uriCreate.getAuthority(), "nameUri (%s) doesn't have an authority", uriCreate);
        this.f23415f = uriCreate.getHost();
        if (uriCreate.getPort() == -1) {
            this.f23416g = aVar.a();
        } else {
            this.f23416g = uriCreate.getPort();
        }
        this.f23410a = (r5.h0) H2.m.o(aVar.c(), "proxyDetector");
        this.f23418i = r(z7);
        this.f23420k = (H2.p) H2.m.o(pVar, "stopwatch");
        this.f23419j = (r5.p0) H2.m.o(aVar.f(), "syncContext");
        Executor executorB = aVar.b();
        this.f23423n = executorB;
        this.f23424o = executorB == null;
        this.f23425p = (c0.f) H2.m.o(aVar.e(), "serviceConfigParser");
    }

    public static boolean B(boolean z7, boolean z8, String str) {
        if (!z7) {
            return false;
        }
        if ("localhost".equalsIgnoreCase(str)) {
            return z8;
        }
        if (str.contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) {
            return false;
        }
        boolean z9 = true;
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt != '.') {
                z9 &= cCharAt >= '0' && cCharAt <= '9';
            }
        }
        return true ^ z9;
    }

    public static final List o(Map map) {
        return AbstractC2668c0.g(map, "clientLanguage");
    }

    public static final List p(Map map) {
        return AbstractC2668c0.g(map, "clientHostname");
    }

    public static String q() {
        if (f23401A == null) {
            try {
                f23401A = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e7) {
                throw new RuntimeException(e7);
            }
        }
        return f23401A;
    }

    public static long r(boolean z7) {
        if (z7) {
            return 0L;
        }
        String property = System.getProperty("networkaddress.cache.ttl");
        long j7 = 30;
        if (property != null) {
            try {
                j7 = Long.parseLong(property);
            } catch (NumberFormatException unused) {
                f23402s.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, 30L});
            }
        }
        return j7 > 0 ? TimeUnit.SECONDS.toNanos(j7) : j7;
    }

    public static final Double s(Map map) {
        return AbstractC2668c0.h(map, "percentage");
    }

    public static g u(ClassLoader classLoader) {
        try {
            try {
                try {
                    android.support.v4.media.session.b.a(Class.forName("t5.a0", true, classLoader).asSubclass(g.class).getConstructor(null).newInstance(null));
                    throw null;
                } catch (Exception e7) {
                    f23402s.log(Level.FINE, "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e7);
                    return null;
                }
            } catch (Exception e8) {
                f23402s.log(Level.FINE, "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e8);
                return null;
            }
        } catch (ClassCastException e9) {
            f23402s.log(Level.FINE, "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e9);
            return null;
        } catch (ClassNotFoundException e10) {
            f23402s.log(Level.FINE, "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e10);
            return null;
        }
    }

    public static Map v(Map map, Random random, String str) {
        for (Map.Entry entry : map.entrySet()) {
            H2.w.a(f23403t.contains(entry.getKey()), "Bad key: %s", entry);
        }
        List listO = o(map);
        if (listO != null && !listO.isEmpty()) {
            Iterator it = listO.iterator();
            while (it.hasNext()) {
                if ("java".equalsIgnoreCase((String) it.next())) {
                }
            }
            return null;
        }
        Double dS = s(map);
        if (dS != null) {
            int iIntValue = dS.intValue();
            H2.w.a(iIntValue >= 0 && iIntValue <= 100, "Bad percentage: %s", dS);
            if (random.nextInt(100) >= iIntValue) {
                return null;
            }
        }
        List listP = p(map);
        if (listP != null && !listP.isEmpty()) {
            Iterator it2 = listP.iterator();
            while (it2.hasNext()) {
                if (((String) it2.next()).equals(str)) {
                }
            }
            return null;
        }
        Map mapJ = AbstractC2668c0.j(map, "serviceConfig");
        if (mapJ != null) {
            return mapJ;
        }
        throw new H2.x(String.format("key '%s' missing in '%s'", map, "serviceConfig"));
    }

    public static c0.b w(List list, Random random, String str) {
        try {
            Iterator it = x(list).iterator();
            Map mapV = null;
            while (it.hasNext()) {
                try {
                    mapV = v((Map) it.next(), random, str);
                    if (mapV != null) {
                        break;
                    }
                } catch (RuntimeException e7) {
                    return c0.b.b(r5.l0.f22707g.q("failed to pick service config choice").p(e7));
                }
            }
            if (mapV == null) {
                return null;
            }
            return c0.b.a(mapV);
        } catch (IOException | RuntimeException e8) {
            return c0.b.b(r5.l0.f22707g.q("failed to parse TXT records").p(e8));
        }
    }

    public static List x(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.startsWith("grpc_config=")) {
                Object objA = AbstractC2666b0.a(str.substring(12));
                if (!(objA instanceof List)) {
                    throw new ClassCastException("wrong type " + objA);
                }
                arrayList.addAll(AbstractC2668c0.a((List) objA));
            } else {
                f23402s.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            }
        }
        return arrayList;
    }

    public final c0.b A() {
        List listEmptyList = Collections.emptyList();
        t();
        if (listEmptyList.isEmpty()) {
            f23402s.log(Level.FINE, "No TXT records found for {0}", new Object[]{this.f23415f});
            return null;
        }
        c0.b bVarW = w(listEmptyList, this.f23411b, q());
        if (bVarW == null) {
            return null;
        }
        if (bVarW.d() != null) {
            return c0.b.b(bVarW.d());
        }
        return this.f23425p.a((Map) bVarW.c());
    }

    @Override // r5.c0
    public String a() {
        return this.f23414e;
    }

    @Override // r5.c0
    public void b() {
        H2.m.u(this.f23427r != null, "not started");
        y();
    }

    @Override // r5.c0
    public void c() {
        if (this.f23422m) {
            return;
        }
        this.f23422m = true;
        Executor executor = this.f23423n;
        if (executor == null || !this.f23424o) {
            return;
        }
        this.f23423n = (Executor) L0.f(this.f23417h, executor);
    }

    @Override // r5.c0
    public void d(c0.d dVar) {
        H2.m.u(this.f23427r == null, "already started");
        if (this.f23424o) {
            this.f23423n = (Executor) L0.d(this.f23417h);
        }
        this.f23427r = (c0.d) H2.m.o(dVar, "listener");
        y();
    }

    public final boolean l() {
        if (this.f23421l) {
            long j7 = this.f23418i;
            if (j7 != 0 && (j7 <= 0 || this.f23420k.d(TimeUnit.NANOSECONDS) <= this.f23418i)) {
                return false;
            }
        }
        return true;
    }

    public final C2607x m() {
        r5.g0 g0VarA = this.f23410a.a(InetSocketAddress.createUnresolved(this.f23415f, this.f23416g));
        if (g0VarA != null) {
            return new C2607x(g0VarA);
        }
        return null;
    }

    public c n(boolean z7) {
        c cVar = new c();
        try {
            cVar.f23429b = z();
        } catch (Exception e7) {
            if (!z7) {
                cVar.f23428a = r5.l0.f22720t.q("Unable to resolve host " + this.f23415f).p(e7);
                return cVar;
            }
        }
        if (f23409z) {
            cVar.f23430c = A();
        }
        return cVar;
    }

    public f t() {
        if (!B(f23407x, f23408y, this.f23415f)) {
            return null;
        }
        android.support.v4.media.session.b.a(this.f23413d.get());
        return null;
    }

    public final void y() {
        if (this.f23426q || this.f23422m || !l()) {
            return;
        }
        this.f23426q = true;
        this.f23423n.execute(new e(this.f23427r));
    }

    public final List z() {
        Exception e7 = null;
        try {
            try {
                List listA = this.f23412c.a(this.f23415f);
                ArrayList arrayList = new ArrayList(listA.size());
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    arrayList.add(new C2607x(new InetSocketAddress((InetAddress) it.next(), this.f23416g)));
                }
                return Collections.unmodifiableList(arrayList);
            } catch (Exception e8) {
                e7 = e8;
                H2.u.f(e7);
                throw new RuntimeException(e7);
            }
        } catch (Throwable th) {
            if (e7 != null) {
                f23402s.log(Level.FINE, "Address resolution failure", (Throwable) e7);
            }
            throw th;
        }
    }
}
