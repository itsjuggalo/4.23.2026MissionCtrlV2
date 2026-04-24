package M2;

import K2.C0353a;
import K2.C0375x;
import K2.c0;
import M2.L0;
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

/* JADX INFO: loaded from: classes3.dex */
public class D extends K2.c0 {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static String f1850A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Logger f1851s = Logger.getLogger(D.class.getName());

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Set f1852t = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f1853u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f1854v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f1855w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f1856x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f1857y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f1858z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K2.h0 f1859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Random f1860b = new Random();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile b f1861c = d.INSTANCE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f1862d = new AtomicReference();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f1863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final L0.d f1866h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f1867i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final K2.p0 f1868j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Z1.p f1869k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1870l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1871m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Executor f1872n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f1873o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c0.f f1874p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1875q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c0.d f1876r;

    public interface b {
        List a(String str);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public K2.l0 f1877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f1878b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c0.b f1879c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public C0353a f1880d;

        public c() {
        }
    }

    public enum d implements b {
        INSTANCE;

        @Override // M2.D.b
        public List a(String str) {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
        }
    }

    public final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c0.d f1883a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f1885a;

            public a(boolean z4) {
                this.f1885a = z4;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f1885a) {
                    D d4 = D.this;
                    d4.f1870l = true;
                    if (d4.f1867i > 0) {
                        D.this.f1869k.f().g();
                    }
                }
                D.this.f1875q = false;
            }
        }

        public e(c0.d dVar) {
            this.f1883a = (c0.d) Z1.m.o(dVar, "savedListener");
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z4;
            K2.p0 p0Var;
            a aVar;
            Logger logger = D.f1851s;
            Level level = Level.FINER;
            if (logger.isLoggable(level)) {
                D.f1851s.finer("Attempting DNS resolution of " + D.this.f1864f);
            }
            c cVarN = null;
            try {
                try {
                    C0375x c0375xM = D.this.m();
                    c0.e.a aVarD = c0.e.d();
                    if (c0375xM != null) {
                        if (D.f1851s.isLoggable(level)) {
                            D.f1851s.finer("Using proxy address " + c0375xM);
                        }
                        aVarD.b(Collections.singletonList(c0375xM));
                    } else {
                        cVarN = D.this.n(false);
                        if (cVarN.f1877a != null) {
                            this.f1883a.a(cVarN.f1877a);
                            z4 = cVarN != null && cVarN.f1877a == null;
                            p0Var = D.this.f1868j;
                            aVar = new a(z4);
                            p0Var.execute(aVar);
                        }
                        if (cVarN.f1878b != null) {
                            aVarD.b(cVarN.f1878b);
                        }
                        if (cVarN.f1879c != null) {
                            aVarD.d(cVarN.f1879c);
                        }
                        C0353a c0353a = cVarN.f1880d;
                        if (c0353a != null) {
                            aVarD.c(c0353a);
                        }
                    }
                    this.f1883a.b(aVarD.a());
                    z4 = cVarN != null && cVarN.f1877a == null;
                    p0Var = D.this.f1868j;
                    aVar = new a(z4);
                    p0Var.execute(aVar);
                } catch (IOException e4) {
                    this.f1883a.a(K2.l0.f1230t.q("Unable to resolve host " + D.this.f1864f).p(e4));
                    D.this.f1868j.execute(new a(0 != 0 && null.f1877a == null));
                }
            } catch (Throwable th) {
                D.this.f1868j.execute(new a(0 != 0 && null.f1877a == null));
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
        f1853u = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", com.amazon.a.a.o.b.ag);
        f1854v = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", com.amazon.a.a.o.b.ag);
        f1855w = property3;
        f1856x = Boolean.parseBoolean(property);
        f1857y = Boolean.parseBoolean(property2);
        f1858z = Boolean.parseBoolean(property3);
        u(D.class.getClassLoader());
    }

    public D(String str, String str2, c0.a aVar, L0.d dVar, Z1.p pVar, boolean z4) {
        Z1.m.o(aVar, "args");
        this.f1866h = dVar;
        URI uriCreate = URI.create("//" + ((String) Z1.m.o(str2, "name")));
        Z1.m.j(uriCreate.getHost() != null, "Invalid DNS name: %s", str2);
        this.f1863e = (String) Z1.m.p(uriCreate.getAuthority(), "nameUri (%s) doesn't have an authority", uriCreate);
        this.f1864f = uriCreate.getHost();
        if (uriCreate.getPort() == -1) {
            this.f1865g = aVar.a();
        } else {
            this.f1865g = uriCreate.getPort();
        }
        this.f1859a = (K2.h0) Z1.m.o(aVar.c(), "proxyDetector");
        this.f1867i = r(z4);
        this.f1869k = (Z1.p) Z1.m.o(pVar, "stopwatch");
        this.f1868j = (K2.p0) Z1.m.o(aVar.f(), "syncContext");
        Executor executorB = aVar.b();
        this.f1872n = executorB;
        this.f1873o = executorB == null;
        this.f1874p = (c0.f) Z1.m.o(aVar.e(), "serviceConfigParser");
    }

    public static boolean B(boolean z4, boolean z5, String str) {
        if (!z4) {
            return false;
        }
        if ("localhost".equalsIgnoreCase(str)) {
            return z5;
        }
        if (str.contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) {
            return false;
        }
        boolean z6 = true;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char cCharAt = str.charAt(i4);
            if (cCharAt != '.') {
                z6 &= cCharAt >= '0' && cCharAt <= '9';
            }
        }
        return true ^ z6;
    }

    public static final List o(Map map) {
        return AbstractC0413c0.g(map, "clientLanguage");
    }

    public static final List p(Map map) {
        return AbstractC0413c0.g(map, "clientHostname");
    }

    public static String q() {
        if (f1850A == null) {
            try {
                f1850A = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e4) {
                throw new RuntimeException(e4);
            }
        }
        return f1850A;
    }

    public static long r(boolean z4) {
        if (z4) {
            return 0L;
        }
        String property = System.getProperty("networkaddress.cache.ttl");
        long j4 = 30;
        if (property != null) {
            try {
                j4 = Long.parseLong(property);
            } catch (NumberFormatException unused) {
                f1851s.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, 30L});
            }
        }
        return j4 > 0 ? TimeUnit.SECONDS.toNanos(j4) : j4;
    }

    public static final Double s(Map map) {
        return AbstractC0413c0.h(map, "percentage");
    }

    public static g u(ClassLoader classLoader) {
        try {
            try {
                try {
                    android.support.v4.media.session.b.a(Class.forName("M2.a0", true, classLoader).asSubclass(g.class).getConstructor(new Class[0]).newInstance(new Object[0]));
                    throw null;
                } catch (Exception e4) {
                    f1851s.log(Level.FINE, "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e4);
                    return null;
                }
            } catch (Exception e5) {
                f1851s.log(Level.FINE, "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e5);
                return null;
            }
        } catch (ClassCastException e6) {
            f1851s.log(Level.FINE, "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e6);
            return null;
        } catch (ClassNotFoundException e7) {
            f1851s.log(Level.FINE, "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e7);
            return null;
        }
    }

    public static Map v(Map map, Random random, String str) {
        for (Map.Entry entry : map.entrySet()) {
            Z1.w.a(f1852t.contains(entry.getKey()), "Bad key: %s", entry);
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
            Z1.w.a(iIntValue >= 0 && iIntValue <= 100, "Bad percentage: %s", dS);
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
        Map mapJ = AbstractC0413c0.j(map, "serviceConfig");
        if (mapJ != null) {
            return mapJ;
        }
        throw new Z1.x(String.format("key '%s' missing in '%s'", map, "serviceConfig"));
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
                } catch (RuntimeException e4) {
                    return c0.b.b(K2.l0.f1217g.q("failed to pick service config choice").p(e4));
                }
            }
            if (mapV == null) {
                return null;
            }
            return c0.b.a(mapV);
        } catch (IOException | RuntimeException e5) {
            return c0.b.b(K2.l0.f1217g.q("failed to parse TXT records").p(e5));
        }
    }

    public static List x(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.startsWith("grpc_config=")) {
                Object objA = AbstractC0411b0.a(str.substring(12));
                if (!(objA instanceof List)) {
                    throw new ClassCastException("wrong type " + objA);
                }
                arrayList.addAll(AbstractC0413c0.a((List) objA));
            } else {
                f1851s.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            }
        }
        return arrayList;
    }

    public final c0.b A() {
        List list = Collections.EMPTY_LIST;
        t();
        if (list.isEmpty()) {
            f1851s.log(Level.FINE, "No TXT records found for {0}", new Object[]{this.f1864f});
            return null;
        }
        c0.b bVarW = w(list, this.f1860b, q());
        if (bVarW == null) {
            return null;
        }
        if (bVarW.d() != null) {
            return c0.b.b(bVarW.d());
        }
        return this.f1874p.a((Map) bVarW.c());
    }

    @Override // K2.c0
    public String a() {
        return this.f1863e;
    }

    @Override // K2.c0
    public void b() {
        Z1.m.u(this.f1876r != null, "not started");
        y();
    }

    @Override // K2.c0
    public void c() {
        if (this.f1871m) {
            return;
        }
        this.f1871m = true;
        Executor executor = this.f1872n;
        if (executor == null || !this.f1873o) {
            return;
        }
        this.f1872n = (Executor) L0.f(this.f1866h, executor);
    }

    @Override // K2.c0
    public void d(c0.d dVar) {
        Z1.m.u(this.f1876r == null, "already started");
        if (this.f1873o) {
            this.f1872n = (Executor) L0.d(this.f1866h);
        }
        this.f1876r = (c0.d) Z1.m.o(dVar, "listener");
        y();
    }

    public final boolean l() {
        if (!this.f1870l) {
            return true;
        }
        long j4 = this.f1867i;
        if (j4 != 0) {
            return j4 > 0 && this.f1869k.d(TimeUnit.NANOSECONDS) > this.f1867i;
        }
        return true;
    }

    public final C0375x m() {
        K2.g0 g0VarA = this.f1859a.a(InetSocketAddress.createUnresolved(this.f1864f, this.f1865g));
        if (g0VarA != null) {
            return new C0375x(g0VarA);
        }
        return null;
    }

    public c n(boolean z4) {
        c cVar = new c();
        try {
            cVar.f1878b = z();
        } catch (Exception e4) {
            if (!z4) {
                cVar.f1877a = K2.l0.f1230t.q("Unable to resolve host " + this.f1864f).p(e4);
                return cVar;
            }
        }
        if (f1858z) {
            cVar.f1879c = A();
        }
        return cVar;
    }

    public f t() {
        if (!B(f1856x, f1857y, this.f1864f)) {
            return null;
        }
        android.support.v4.media.session.b.a(this.f1862d.get());
        return null;
    }

    public final void y() {
        if (this.f1875q || this.f1871m || !l()) {
            return;
        }
        this.f1875q = true;
        this.f1872n.execute(new e(this.f1876r));
    }

    public final List z() {
        Exception e4 = null;
        try {
            try {
                List listA = this.f1861c.a(this.f1864f);
                ArrayList arrayList = new ArrayList(listA.size());
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    arrayList.add(new C0375x(new InetSocketAddress((InetAddress) it.next(), this.f1865g)));
                }
                return Collections.unmodifiableList(arrayList);
            } catch (Exception e5) {
                e4 = e5;
                Z1.u.f(e4);
                throw new RuntimeException(e4);
            }
        } catch (Throwable th) {
            if (e4 != null) {
                f1851s.log(Level.FINE, "Address resolution failure", (Throwable) e4);
            }
            throw th;
        }
    }
}
