package tb;

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
import rb.b1;
import tb.k2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class d0 extends rb.b1 {
    public static String A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Logger f21157s = Logger.getLogger(d0.class.getName());

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Set f21158t = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f21159u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f21160v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f21161w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f21162x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f21163y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f21164z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rb.g1 f21165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Random f21166b = new Random();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile b f21167c = d.INSTANCE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f21168d = new AtomicReference();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f21169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f21170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f21171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k2.d f21172h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f21173i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final rb.o1 f21174j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p6.q f21175k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f21176l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f21177m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Executor f21178n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f21179o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b1.f f21180p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f21181q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b1.d f21182r;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        List a(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public rb.k1 f21183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f21184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b1.b f21185c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public rb.a f21186d;

        public c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum d implements b {
        INSTANCE;

        @Override // tb.d0.b
        public List a(String str) {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b1.d f21189a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f21191a;

            public a(boolean z10) {
                this.f21191a = z10;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f21191a) {
                    d0 d0Var = d0.this;
                    d0Var.f21176l = true;
                    if (d0Var.f21173i > 0) {
                        d0.this.f21175k.f().g();
                    }
                }
                d0.this.f21181q = false;
            }
        }

        public e(b1.d dVar) {
            this.f21189a = (b1.d) p6.n.o(dVar, "savedListener");
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            rb.o1 o1Var;
            a aVar;
            rb.x xVarM;
            b1.e.a aVarD;
            Logger logger = d0.f21157s;
            Level level = Level.FINER;
            if (logger.isLoggable(level)) {
                d0.f21157s.finer("Attempting DNS resolution of " + d0.this.f21170f);
            }
            c cVarN = null;
            try {
                try {
                    xVarM = d0.this.m();
                    aVarD = b1.e.d();
                } catch (IOException e10) {
                    this.f21189a.a(rb.k1.f19607t.r("Unable to resolve host " + d0.this.f21170f).q(e10));
                    z10 = 0 != 0 && null.f21183a == null;
                    o1Var = d0.this.f21174j;
                    aVar = new a(z10);
                }
                if (xVarM != null) {
                    if (d0.f21157s.isLoggable(level)) {
                        d0.f21157s.finer("Using proxy address " + xVarM);
                    }
                    aVarD.b(Collections.singletonList(xVarM));
                } else {
                    cVarN = d0.this.n(false);
                    if (cVarN.f21183a != null) {
                        this.f21189a.a(cVarN.f21183a);
                        z10 = cVarN != null && cVarN.f21183a == null;
                        o1Var = d0.this.f21174j;
                        aVar = new a(z10);
                        o1Var.execute(aVar);
                    }
                    if (cVarN.f21184b != null) {
                        aVarD.b(cVarN.f21184b);
                    }
                    if (cVarN.f21185c != null) {
                        aVarD.d(cVarN.f21185c);
                    }
                    rb.a aVar2 = cVarN.f21186d;
                    if (aVar2 != null) {
                        aVarD.c(aVar2);
                    }
                }
                this.f21189a.b(aVarD.a());
                z10 = cVarN != null && cVarN.f21183a == null;
                o1Var = d0.this.f21174j;
                aVar = new a(z10);
                o1Var.execute(aVar);
            } catch (Throwable th) {
                d0.this.f21174j.execute(new a(0 != 0 && null.f21183a == null));
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface f {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface g {
    }

    static {
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", com.amazon.a.a.o.b.f4545af);
        f21159u = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", com.amazon.a.a.o.b.f4546ag);
        f21160v = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", com.amazon.a.a.o.b.f4546ag);
        f21161w = property3;
        f21162x = Boolean.parseBoolean(property);
        f21163y = Boolean.parseBoolean(property2);
        f21164z = Boolean.parseBoolean(property3);
        u(d0.class.getClassLoader());
    }

    public d0(String str, String str2, b1.a aVar, k2.d dVar, p6.q qVar, boolean z10) {
        p6.n.o(aVar, "args");
        this.f21172h = dVar;
        URI uriCreate = URI.create("//" + ((String) p6.n.o(str2, "name")));
        p6.n.j(uriCreate.getHost() != null, "Invalid DNS name: %s", str2);
        this.f21169e = (String) p6.n.p(uriCreate.getAuthority(), "nameUri (%s) doesn't have an authority", uriCreate);
        this.f21170f = uriCreate.getHost();
        if (uriCreate.getPort() == -1) {
            this.f21171g = aVar.a();
        } else {
            this.f21171g = uriCreate.getPort();
        }
        this.f21165a = (rb.g1) p6.n.o(aVar.c(), "proxyDetector");
        this.f21173i = r(z10);
        this.f21175k = (p6.q) p6.n.o(qVar, "stopwatch");
        this.f21174j = (rb.o1) p6.n.o(aVar.f(), "syncContext");
        Executor executorB = aVar.b();
        this.f21178n = executorB;
        this.f21179o = executorB == null;
        this.f21180p = (b1.f) p6.n.o(aVar.e(), "serviceConfigParser");
    }

    public static boolean B(boolean z10, boolean z11, String str) {
        if (!z10) {
            return false;
        }
        if ("localhost".equalsIgnoreCase(str)) {
            return z11;
        }
        if (str.contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) {
            return false;
        }
        boolean z12 = true;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '.') {
                z12 &= cCharAt >= '0' && cCharAt <= '9';
            }
        }
        return true ^ z12;
    }

    public static final List o(Map map) {
        return b1.g(map, "clientLanguage");
    }

    public static final List p(Map map) {
        return b1.g(map, "clientHostname");
    }

    public static String q() {
        if (A == null) {
            try {
                A = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e10) {
                throw new RuntimeException(e10);
            }
        }
        return A;
    }

    public static long r(boolean z10) {
        if (z10) {
            return 0L;
        }
        String property = System.getProperty("networkaddress.cache.ttl");
        long j10 = 30;
        if (property != null) {
            try {
                j10 = Long.parseLong(property);
            } catch (NumberFormatException unused) {
                f21157s.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, 30L});
            }
        }
        return j10 > 0 ? TimeUnit.SECONDS.toNanos(j10) : j10;
    }

    public static final Double s(Map map) {
        return b1.h(map, "percentage");
    }

    public static g u(ClassLoader classLoader) {
        try {
            try {
                try {
                    android.support.v4.media.session.b.a(Class.forName("tb.z0", true, classLoader).asSubclass(g.class).getConstructor(null).newInstance(null));
                    throw null;
                } catch (Exception e10) {
                    f21157s.log(Level.FINE, "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e10);
                    return null;
                }
            } catch (Exception e11) {
                f21157s.log(Level.FINE, "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e11);
                return null;
            }
        } catch (ClassCastException e12) {
            f21157s.log(Level.FINE, "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e12);
            return null;
        } catch (ClassNotFoundException e13) {
            f21157s.log(Level.FINE, "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e13);
            return null;
        }
    }

    public static Map v(Map map, Random random, String str) {
        for (Map.Entry entry : map.entrySet()) {
            p6.x.a(f21158t.contains(entry.getKey()), "Bad key: %s", entry);
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
            p6.x.a(iIntValue >= 0 && iIntValue <= 100, "Bad percentage: %s", dS);
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
        Map mapJ = b1.j(map, "serviceConfig");
        if (mapJ != null) {
            return mapJ;
        }
        throw new p6.y(String.format("key '%s' missing in '%s'", map, "serviceConfig"));
    }

    public static b1.b w(List list, Random random, String str) {
        try {
            Iterator it = x(list).iterator();
            Map mapV = null;
            while (it.hasNext()) {
                try {
                    mapV = v((Map) it.next(), random, str);
                    if (mapV != null) {
                        break;
                    }
                } catch (RuntimeException e10) {
                    return b1.b.b(rb.k1.f19594g.r("failed to pick service config choice").q(e10));
                }
            }
            if (mapV == null) {
                return null;
            }
            return b1.b.a(mapV);
        } catch (IOException | RuntimeException e11) {
            return b1.b.b(rb.k1.f19594g.r("failed to parse TXT records").q(e11));
        }
    }

    public static List x(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.startsWith("grpc_config=")) {
                Object objA = a1.a(str.substring(12));
                if (!(objA instanceof List)) {
                    throw new ClassCastException("wrong type " + objA);
                }
                arrayList.addAll(b1.a((List) objA));
            } else {
                f21157s.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            }
        }
        return arrayList;
    }

    public final b1.b A() {
        List list = Collections.EMPTY_LIST;
        t();
        if (list.isEmpty()) {
            f21157s.log(Level.FINE, "No TXT records found for {0}", new Object[]{this.f21170f});
            return null;
        }
        b1.b bVarW = w(list, this.f21166b, q());
        if (bVarW == null) {
            return null;
        }
        if (bVarW.d() != null) {
            return b1.b.b(bVarW.d());
        }
        return this.f21180p.a((Map) bVarW.c());
    }

    @Override // rb.b1
    public String a() {
        return this.f21169e;
    }

    @Override // rb.b1
    public void b() {
        p6.n.u(this.f21182r != null, "not started");
        y();
    }

    @Override // rb.b1
    public void c() {
        if (this.f21177m) {
            return;
        }
        this.f21177m = true;
        Executor executor = this.f21178n;
        if (executor == null || !this.f21179o) {
            return;
        }
        this.f21178n = (Executor) k2.f(this.f21172h, executor);
    }

    @Override // rb.b1
    public void d(b1.d dVar) {
        p6.n.u(this.f21182r == null, "already started");
        if (this.f21179o) {
            this.f21178n = (Executor) k2.d(this.f21172h);
        }
        this.f21182r = (b1.d) p6.n.o(dVar, "listener");
        y();
    }

    public final boolean l() {
        if (!this.f21176l) {
            return true;
        }
        long j10 = this.f21173i;
        if (j10 != 0) {
            return j10 > 0 && this.f21175k.d(TimeUnit.NANOSECONDS) > this.f21173i;
        }
        return true;
    }

    public final rb.x m() {
        rb.f1 f1VarA = this.f21165a.a(InetSocketAddress.createUnresolved(this.f21170f, this.f21171g));
        if (f1VarA != null) {
            return new rb.x(f1VarA);
        }
        return null;
    }

    public c n(boolean z10) {
        c cVar = new c();
        try {
            cVar.f21184b = z();
        } catch (Exception e10) {
            if (!z10) {
                cVar.f21183a = rb.k1.f19607t.r("Unable to resolve host " + this.f21170f).q(e10);
                return cVar;
            }
        }
        if (f21164z) {
            cVar.f21185c = A();
        }
        return cVar;
    }

    public f t() {
        if (!B(f21162x, f21163y, this.f21170f)) {
            return null;
        }
        android.support.v4.media.session.b.a(this.f21168d.get());
        return null;
    }

    public final void y() {
        if (this.f21181q || this.f21177m || !l()) {
            return;
        }
        this.f21181q = true;
        this.f21178n.execute(new e(this.f21182r));
    }

    public final List z() {
        Exception e10 = null;
        try {
            try {
                List listA = this.f21167c.a(this.f21170f);
                ArrayList arrayList = new ArrayList(listA.size());
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    arrayList.add(new rb.x(new InetSocketAddress((InetAddress) it.next(), this.f21171g)));
                }
                return Collections.unmodifiableList(arrayList);
            } catch (Exception e11) {
                e10 = e11;
                p6.v.f(e10);
                throw new RuntimeException(e10);
            }
        } catch (Throwable th) {
            if (e10 != null) {
                f21157s.log(Level.FINE, "Address resolution failure", (Throwable) e10);
            }
            throw th;
        }
    }
}
