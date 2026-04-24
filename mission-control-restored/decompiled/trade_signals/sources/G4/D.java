package G4;

import F4.C0487a;
import F4.C0509x;
import F4.a0;
import G4.L0;
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
import v2.AbstractC2848n;
import v2.AbstractC2856v;
import v2.AbstractC2858x;
import v2.C2851q;
import v2.C2859y;

/* JADX INFO: loaded from: classes2.dex */
public class D extends F4.a0 {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static String f2438A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Logger f2439s = Logger.getLogger(D.class.getName());

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Set f2440t = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f2441u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f2442v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f2443w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f2444x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f2445y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f2446z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F4.f0 f2447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Random f2448b = new Random();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile b f2449c = d.INSTANCE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f2450d = new AtomicReference();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final L0.d f2454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f2455i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final F4.n0 f2456j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C2851q f2457k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2458l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2459m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Executor f2460n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f2461o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a0.f f2462p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2463q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a0.d f2464r;

    public interface b {
        List a(String str);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public F4.j0 f2465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f2466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a0.b f2467c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public C0487a f2468d;

        public c() {
        }
    }

    public enum d implements b {
        INSTANCE;

        @Override // G4.D.b
        public List a(String str) {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
        }
    }

    public final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a0.d f2471a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f2473a;

            public a(boolean z7) {
                this.f2473a = z7;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f2473a) {
                    D d8 = D.this;
                    d8.f2458l = true;
                    if (d8.f2455i > 0) {
                        D.this.f2457k.f().g();
                    }
                }
                D.this.f2463q = false;
            }
        }

        public e(a0.d dVar) {
            this.f2471a = (a0.d) AbstractC2848n.o(dVar, "savedListener");
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z7;
            F4.n0 n0Var;
            a aVar;
            Logger logger = D.f2439s;
            Level level = Level.FINER;
            if (logger.isLoggable(level)) {
                D.f2439s.finer("Attempting DNS resolution of " + D.this.f2452f);
            }
            c cVarN = null;
            try {
                try {
                    C0509x c0509xM = D.this.m();
                    a0.e.a aVarD = a0.e.d();
                    if (c0509xM != null) {
                        if (D.f2439s.isLoggable(level)) {
                            D.f2439s.finer("Using proxy address " + c0509xM);
                        }
                        aVarD.b(Collections.singletonList(c0509xM));
                    } else {
                        cVarN = D.this.n(false);
                        if (cVarN.f2465a != null) {
                            this.f2471a.a(cVarN.f2465a);
                            D.this.f2456j.execute(new a(cVarN != null && cVarN.f2465a == null));
                            return;
                        }
                        if (cVarN.f2466b != null) {
                            aVarD.b(cVarN.f2466b);
                        }
                        if (cVarN.f2467c != null) {
                            aVarD.d(cVarN.f2467c);
                        }
                        C0487a c0487a = cVarN.f2468d;
                        if (c0487a != null) {
                            aVarD.c(c0487a);
                        }
                    }
                    this.f2471a.b(aVarD.a());
                    z7 = cVarN != null && cVarN.f2465a == null;
                    n0Var = D.this.f2456j;
                    aVar = new a(z7);
                } catch (IOException e8) {
                    this.f2471a.a(F4.j0.f1812t.r("Unable to resolve host " + D.this.f2452f).q(e8));
                    z7 = 0 != 0 && null.f2465a == null;
                    n0Var = D.this.f2456j;
                    aVar = new a(z7);
                }
                n0Var.execute(aVar);
            } catch (Throwable th) {
                D.this.f2456j.execute(new a(0 != 0 && null.f2465a == null));
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
        f2441u = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", com.amazon.a.a.o.b.ag);
        f2442v = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", com.amazon.a.a.o.b.ag);
        f2443w = property3;
        f2444x = Boolean.parseBoolean(property);
        f2445y = Boolean.parseBoolean(property2);
        f2446z = Boolean.parseBoolean(property3);
        u(D.class.getClassLoader());
    }

    public D(String str, String str2, a0.a aVar, L0.d dVar, C2851q c2851q, boolean z7) {
        AbstractC2848n.o(aVar, "args");
        this.f2454h = dVar;
        URI uriCreate = URI.create("//" + ((String) AbstractC2848n.o(str2, "name")));
        AbstractC2848n.j(uriCreate.getHost() != null, "Invalid DNS name: %s", str2);
        this.f2451e = (String) AbstractC2848n.p(uriCreate.getAuthority(), "nameUri (%s) doesn't have an authority", uriCreate);
        this.f2452f = uriCreate.getHost();
        this.f2453g = uriCreate.getPort() == -1 ? aVar.a() : uriCreate.getPort();
        this.f2447a = (F4.f0) AbstractC2848n.o(aVar.c(), "proxyDetector");
        this.f2455i = r(z7);
        this.f2457k = (C2851q) AbstractC2848n.o(c2851q, "stopwatch");
        this.f2456j = (F4.n0) AbstractC2848n.o(aVar.f(), "syncContext");
        Executor executorB = aVar.b();
        this.f2460n = executorB;
        this.f2461o = executorB == null;
        this.f2462p = (a0.f) AbstractC2848n.o(aVar.e(), "serviceConfigParser");
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
        for (int i8 = 0; i8 < str.length(); i8++) {
            char cCharAt = str.charAt(i8);
            if (cCharAt != '.') {
                z9 &= cCharAt >= '0' && cCharAt <= '9';
            }
        }
        return true ^ z9;
    }

    public static final List o(Map map) {
        return AbstractC0521c0.g(map, "clientLanguage");
    }

    public static final List p(Map map) {
        return AbstractC0521c0.g(map, "clientHostname");
    }

    public static String q() {
        if (f2438A == null) {
            try {
                f2438A = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e8) {
                throw new RuntimeException(e8);
            }
        }
        return f2438A;
    }

    public static long r(boolean z7) {
        if (z7) {
            return 0L;
        }
        String property = System.getProperty("networkaddress.cache.ttl");
        long j8 = 30;
        if (property != null) {
            try {
                j8 = Long.parseLong(property);
            } catch (NumberFormatException unused) {
                f2439s.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, 30L});
            }
        }
        return j8 > 0 ? TimeUnit.SECONDS.toNanos(j8) : j8;
    }

    public static final Double s(Map map) {
        return AbstractC0521c0.h(map, "percentage");
    }

    public static g u(ClassLoader classLoader) {
        Logger logger;
        Level level;
        String str;
        try {
            try {
                try {
                    android.support.v4.media.session.b.a(Class.forName("G4.a0", true, classLoader).asSubclass(g.class).getConstructor(null).newInstance(null));
                    throw null;
                } catch (Exception e8) {
                    e = e8;
                    logger = f2439s;
                    level = Level.FINE;
                    str = "Can't construct JndiResourceResolverFactory, skipping.";
                    logger.log(level, str, e);
                    return null;
                }
            } catch (Exception e9) {
                e = e9;
                logger = f2439s;
                level = Level.FINE;
                str = "Can't find JndiResourceResolverFactory ctor, skipping.";
            }
        } catch (ClassCastException e10) {
            e = e10;
            logger = f2439s;
            level = Level.FINE;
            str = "Unable to cast JndiResourceResolverFactory, skipping.";
        } catch (ClassNotFoundException e11) {
            e = e11;
            logger = f2439s;
            level = Level.FINE;
            str = "Unable to find JndiResourceResolverFactory, skipping.";
        }
    }

    public static Map v(Map map, Random random, String str) {
        for (Map.Entry entry : map.entrySet()) {
            AbstractC2858x.a(f2440t.contains(entry.getKey()), "Bad key: %s", entry);
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
            AbstractC2858x.a(iIntValue >= 0 && iIntValue <= 100, "Bad percentage: %s", dS);
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
        Map mapJ = AbstractC0521c0.j(map, "serviceConfig");
        if (mapJ != null) {
            return mapJ;
        }
        throw new C2859y(String.format("key '%s' missing in '%s'", map, "serviceConfig"));
    }

    public static a0.b w(List list, Random random, String str) {
        F4.j0 j0Var;
        String str2;
        try {
            Iterator it = x(list).iterator();
            Map mapV = null;
            while (it.hasNext()) {
                try {
                    mapV = v((Map) it.next(), random, str);
                    if (mapV != null) {
                        break;
                    }
                } catch (RuntimeException e8) {
                    e = e8;
                    j0Var = F4.j0.f1799g;
                    str2 = "failed to pick service config choice";
                    return a0.b.b(j0Var.r(str2).q(e));
                }
            }
            if (mapV == null) {
                return null;
            }
            return a0.b.a(mapV);
        } catch (IOException | RuntimeException e9) {
            e = e9;
            j0Var = F4.j0.f1799g;
            str2 = "failed to parse TXT records";
        }
    }

    public static List x(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.startsWith("grpc_config=")) {
                Object objA = AbstractC0519b0.a(str.substring(12));
                if (!(objA instanceof List)) {
                    throw new ClassCastException("wrong type " + objA);
                }
                arrayList.addAll(AbstractC0521c0.a((List) objA));
            } else {
                f2439s.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            }
        }
        return arrayList;
    }

    public final a0.b A() {
        List listEmptyList = Collections.emptyList();
        t();
        if (listEmptyList.isEmpty()) {
            f2439s.log(Level.FINE, "No TXT records found for {0}", new Object[]{this.f2452f});
            return null;
        }
        a0.b bVarW = w(listEmptyList, this.f2448b, q());
        if (bVarW == null) {
            return null;
        }
        if (bVarW.d() != null) {
            return a0.b.b(bVarW.d());
        }
        return this.f2462p.a((Map) bVarW.c());
    }

    @Override // F4.a0
    public String a() {
        return this.f2451e;
    }

    @Override // F4.a0
    public void b() {
        AbstractC2848n.u(this.f2464r != null, "not started");
        y();
    }

    @Override // F4.a0
    public void c() {
        if (this.f2459m) {
            return;
        }
        this.f2459m = true;
        Executor executor = this.f2460n;
        if (executor == null || !this.f2461o) {
            return;
        }
        this.f2460n = (Executor) L0.f(this.f2454h, executor);
    }

    @Override // F4.a0
    public void d(a0.d dVar) {
        AbstractC2848n.u(this.f2464r == null, "already started");
        if (this.f2461o) {
            this.f2460n = (Executor) L0.d(this.f2454h);
        }
        this.f2464r = (a0.d) AbstractC2848n.o(dVar, "listener");
        y();
    }

    public final boolean l() {
        if (this.f2458l) {
            long j8 = this.f2455i;
            if (j8 != 0 && (j8 <= 0 || this.f2457k.d(TimeUnit.NANOSECONDS) <= this.f2455i)) {
                return false;
            }
        }
        return true;
    }

    public final C0509x m() {
        F4.e0 e0VarA = this.f2447a.a(InetSocketAddress.createUnresolved(this.f2452f, this.f2453g));
        if (e0VarA != null) {
            return new C0509x(e0VarA);
        }
        return null;
    }

    public c n(boolean z7) {
        c cVar = new c();
        try {
            cVar.f2466b = z();
        } catch (Exception e8) {
            if (!z7) {
                cVar.f2465a = F4.j0.f1812t.r("Unable to resolve host " + this.f2452f).q(e8);
                return cVar;
            }
        }
        if (f2446z) {
            cVar.f2467c = A();
        }
        return cVar;
    }

    public f t() {
        if (!B(f2444x, f2445y, this.f2452f)) {
            return null;
        }
        android.support.v4.media.session.b.a(this.f2450d.get());
        return null;
    }

    public final void y() {
        if (this.f2463q || this.f2459m || !l()) {
            return;
        }
        this.f2463q = true;
        this.f2460n.execute(new e(this.f2464r));
    }

    public final List z() {
        Exception e8 = null;
        try {
            try {
                List listA = this.f2449c.a(this.f2452f);
                ArrayList arrayList = new ArrayList(listA.size());
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    arrayList.add(new C0509x(new InetSocketAddress((InetAddress) it.next(), this.f2453g)));
                }
                return Collections.unmodifiableList(arrayList);
            } catch (Exception e9) {
                e8 = e9;
                AbstractC2856v.f(e8);
                throw new RuntimeException(e8);
            }
        } catch (Throwable th) {
            if (e8 != null) {
                f2439s.log(Level.FINE, "Address resolution failure", (Throwable) e8);
            }
            throw th;
        }
    }
}
