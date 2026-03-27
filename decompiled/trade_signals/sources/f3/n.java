package f3;

import f3.C1745b;
import f3.InterfaceC1747d;
import f3.InterfaceC1751h;
import g3.C1784a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import l2.AbstractC2328l;
import l2.AbstractC2331o;
import l2.C2329m;
import l2.InterfaceC2323g;
import l2.InterfaceC2324h;
import o3.C2460c;
import r3.C2674a;

/* JADX INFO: loaded from: classes.dex */
public class n implements C1745b.a, InterfaceC1751h {

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static long f17427H;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public String f17428A;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public long f17433F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f17434G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1751h.a f17435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1749f f17436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f17437c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f17440f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C1745b f17441g;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map f17446l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f17447m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map f17448n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Map f17449o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Map f17450p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f17451q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f17452r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f17453s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f17454t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final C1746c f17455u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final InterfaceC1747d f17456v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final InterfaceC1747d f17457w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ScheduledExecutorService f17458x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final C2460c f17459y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final C1784a f17460z;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashSet f17438d = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f17439e = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k f17442h = k.Disconnected;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f17443i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f17444j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f17445k = 0;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public long f17429B = 0;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int f17430C = 0;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int f17431D = 0;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public ScheduledFuture f17432E = null;

    public class a implements InterfaceC1747d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C2329m f17461a;

        public a(C2329m c2329m) {
            this.f17461a = c2329m;
        }

        @Override // f3.InterfaceC1747d.a
        public void a(String str) {
            this.f17461a.c(str);
        }
    }

    public class b implements InterfaceC1747d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C2329m f17463a;

        public b(C2329m c2329m) {
            this.f17463a = c2329m;
        }

        @Override // f3.InterfaceC1747d.a
        public void a(String str) {
            this.f17463a.c(str);
        }
    }

    public class c implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f3.p f17465a;

        public c(f3.p pVar) {
            this.f17465a = pVar;
        }

        @Override // f3.n.j
        public void a(Map map) {
            String str;
            String str2 = (String) map.get("s");
            if (str2.equals("ok")) {
                str2 = null;
                str = null;
            } else {
                str = (String) map.get("d");
            }
            f3.p pVar = this.f17465a;
            if (pVar != null) {
                pVar.a(str2, str);
            }
        }
    }

    public class d implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f17467a;

        public d(boolean z7) {
            this.f17467a = z7;
        }

        @Override // f3.n.j
        public void a(Map map) {
            String str = (String) map.get("s");
            if (str.equals("ok")) {
                n.this.f17442h = k.Connected;
                n.this.f17430C = 0;
                n.this.u0(this.f17467a);
                return;
            }
            n.this.f17451q = null;
            n.this.f17452r = true;
            n.this.f17435a.b(false);
            String str2 = (String) map.get("d");
            n.this.f17459y.b("Authentication failed: " + str + " (" + str2 + ")", new Object[0]);
            n.this.f17441g.c();
            if (str.equals("invalid_token")) {
                n.z(n.this);
                if (n.this.f17430C >= 3) {
                    n.this.f17460z.d();
                    n.this.f17459y.i("Provided authentication credentials are invalid. This usually indicates your FirebaseApp instance was not initialized correctly. Make sure your google-services.json file has the correct firebase_url and api_key. You can re-download google-services.json from https://console.firebase.google.com/.");
                }
            }
        }
    }

    public class e implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f17470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f17471c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f3.p f17472d;

        public e(String str, long j8, o oVar, f3.p pVar) {
            this.f17469a = str;
            this.f17470b = j8;
            this.f17471c = oVar;
            this.f17472d = pVar;
        }

        @Override // f3.n.j
        public void a(Map map) {
            if (n.this.f17459y.f()) {
                n.this.f17459y.b(this.f17469a + " response: " + map, new Object[0]);
            }
            if (((o) n.this.f17448n.get(Long.valueOf(this.f17470b))) == this.f17471c) {
                n.this.f17448n.remove(Long.valueOf(this.f17470b));
                if (this.f17472d != null) {
                    String str = (String) map.get("s");
                    if (str.equals("ok")) {
                        this.f17472d.a(null, null);
                    } else {
                        this.f17472d.a(str, (String) map.get("d"));
                    }
                }
            } else if (n.this.f17459y.f()) {
                n.this.f17459y.b("Ignoring on complete for put " + this.f17470b + " because it was removed already.", new Object[0]);
            }
            n.this.U();
        }
    }

    public class f implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Long f17474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m f17475b;

        public f(Long l8, m mVar) {
            this.f17474a = l8;
            this.f17475b = mVar;
        }

        @Override // f3.n.j
        public void a(Map map) {
            if (((m) n.this.f17449o.get(this.f17474a)) == this.f17475b) {
                n.this.f17449o.remove(this.f17474a);
                this.f17475b.d().a(map);
            } else if (n.this.f17459y.f()) {
                n.this.f17459y.b("Ignoring on complete for get " + this.f17474a + " because it was removed already.", new Object[0]);
            }
        }
    }

    public class g implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0301n f17477a;

        public g(C0301n c0301n) {
            this.f17477a = c0301n;
        }

        @Override // f3.n.j
        public void a(Map map) {
            String str = (String) map.get("s");
            if (str.equals("ok")) {
                Map map2 = (Map) map.get("d");
                if (map2.containsKey("w")) {
                    n.this.H0((List) map2.get("w"), this.f17477a.f17495b);
                }
            }
            if (((C0301n) n.this.f17450p.get(this.f17477a.d())) == this.f17477a) {
                if (str.equals("ok")) {
                    this.f17477a.f17494a.a(null, null);
                    return;
                }
                n.this.p0(this.f17477a.d());
                this.f17477a.f17494a.a(str, (String) map.get("d"));
            }
        }
    }

    public class h implements j {
        public h() {
        }

        @Override // f3.n.j
        public void a(Map map) {
            String str = (String) map.get("s");
            if (str.equals("ok")) {
                return;
            }
            String str2 = (String) map.get("d");
            if (n.this.f17459y.f()) {
                n.this.f17459y.b("Failed to send stats: " + str + " (message: " + str2 + ")", new Object[0]);
            }
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.f17432E = null;
            if (n.this.Z()) {
                n.this.i("connection_idle");
            } else {
                n.this.U();
            }
        }
    }

    public interface j {
        void a(Map map);
    }

    public enum k {
        Disconnected,
        GettingToken,
        Connecting,
        Authenticating,
        Connected
    }

    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f17488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f17489c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f3.p f17490d;

        public l(String str, List list, Object obj, f3.p pVar) {
            this.f17487a = str;
            this.f17488b = list;
            this.f17489c = obj;
            this.f17490d = pVar;
        }

        public String b() {
            return this.f17487a;
        }

        public Object c() {
            return this.f17489c;
        }

        public f3.p d() {
            return this.f17490d;
        }

        public List e() {
            return this.f17488b;
        }

        public /* synthetic */ l(String str, List list, Object obj, f3.p pVar, a aVar) {
            this(str, list, obj, pVar);
        }
    }

    public static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f17491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j f17492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f17493c;

        public m(String str, Map map, j jVar) {
            this.f17491a = map;
            this.f17492b = jVar;
            this.f17493c = false;
        }

        public final j d() {
            return this.f17492b;
        }

        public final Map e() {
            return this.f17491a;
        }

        public final boolean f() {
            if (this.f17493c) {
                return false;
            }
            this.f17493c = true;
            return true;
        }

        public /* synthetic */ m(String str, Map map, j jVar, a aVar) {
            this(str, map, jVar);
        }
    }

    /* JADX INFO: renamed from: f3.n$n, reason: collision with other inner class name */
    public static class C0301n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f3.p f17494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f17495b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final InterfaceC1750g f17496c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Long f17497d;

        public C0301n(f3.p pVar, p pVar2, Long l8, InterfaceC1750g interfaceC1750g) {
            this.f17494a = pVar;
            this.f17495b = pVar2;
            this.f17496c = interfaceC1750g;
            this.f17497d = l8;
        }

        public InterfaceC1750g c() {
            return this.f17496c;
        }

        public p d() {
            return this.f17495b;
        }

        public Long e() {
            return this.f17497d;
        }

        public String toString() {
            return this.f17495b.toString() + " (Tag: " + this.f17497d + ")";
        }

        public /* synthetic */ C0301n(f3.p pVar, p pVar2, Long l8, InterfaceC1750g interfaceC1750g, a aVar) {
            this(pVar, pVar2, l8, interfaceC1750g);
        }
    }

    public static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f17499b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f3.p f17500c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f17501d;

        public o(String str, Map map, f3.p pVar) {
            this.f17498a = str;
            this.f17499b = map;
            this.f17500c = pVar;
        }

        public String b() {
            return this.f17498a;
        }

        public f3.p c() {
            return this.f17500c;
        }

        public Map d() {
            return this.f17499b;
        }

        public void e() {
            this.f17501d = true;
        }

        public boolean f() {
            return this.f17501d;
        }

        public /* synthetic */ o(String str, Map map, f3.p pVar, a aVar) {
            this(str, map, pVar);
        }
    }

    public static class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f17502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f17503b;

        public p(List list, Map map) {
            this.f17502a = list;
            this.f17503b = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof p)) {
                return false;
            }
            p pVar = (p) obj;
            if (this.f17502a.equals(pVar.f17502a)) {
                return this.f17503b.equals(pVar.f17503b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f17502a.hashCode() * 31) + this.f17503b.hashCode();
        }

        public String toString() {
            return AbstractC1748e.d(this.f17502a) + " (params: " + this.f17503b + ")";
        }
    }

    public n(C1746c c1746c, C1749f c1749f, InterfaceC1751h.a aVar) {
        this.f17435a = aVar;
        this.f17455u = c1746c;
        ScheduledExecutorService scheduledExecutorServiceE = c1746c.e();
        this.f17458x = scheduledExecutorServiceE;
        this.f17456v = c1746c.c();
        this.f17457w = c1746c.a();
        this.f17436b = c1749f;
        this.f17450p = new HashMap();
        this.f17446l = new HashMap();
        this.f17448n = new HashMap();
        this.f17449o = new ConcurrentHashMap();
        this.f17447m = new ArrayList();
        this.f17460z = new C1784a.b(scheduledExecutorServiceE, c1746c.f(), "ConnectionRetryHelper").d(1000L).e(1.3d).c(30000L).b(0.7d).a();
        long j8 = f17427H;
        f17427H = 1 + j8;
        this.f17459y = new C2460c(c1746c.f(), "PersistentConnection", "pc_" + j8);
        this.f17428A = null;
        U();
    }

    public static /* synthetic */ void c0(C2329m c2329m, Map map) {
        if (((String) map.get("s")).equals("ok")) {
            c2329m.c(map.get("d"));
        } else {
            c2329m.b(new Exception((String) map.get("d")));
        }
    }

    public static /* synthetic */ int z(n nVar) {
        int i8 = nVar.f17430C;
        nVar.f17430C = i8 + 1;
        return i8;
    }

    public final void A0(String str, List list, Object obj, f3.p pVar) {
        HashMap map = new HashMap();
        map.put("p", AbstractC1748e.d(list));
        map.put("d", obj);
        t0(str, map, new c(pVar));
    }

    public final void B0(long j8) {
        AbstractC1748e.b(R(), "sendPut called when we can't send writes (we're disconnected or writes are paused).", new Object[0]);
        o oVar = (o) this.f17448n.get(Long.valueOf(j8));
        f3.p pVarC = oVar.c();
        String strB = oVar.b();
        oVar.e();
        t0(strB, oVar.d(), new e(strB, j8, oVar, pVarC));
    }

    public final void C0(String str, boolean z7, Map map, j jVar) {
        long jH0 = h0();
        HashMap map2 = new HashMap();
        map2.put("r", Long.valueOf(jH0));
        map2.put("a", str);
        map2.put("b", map);
        this.f17441g.m(map2, z7);
        this.f17446l.put(Long.valueOf(jH0), jVar);
    }

    public final void D0(Map map) {
        if (map.isEmpty()) {
            if (this.f17459y.f()) {
                this.f17459y.b("Not sending stats because stats are empty", new Object[0]);
            }
        } else {
            HashMap map2 = new HashMap();
            map2.put("c", map);
            t0("s", map2, new h());
        }
    }

    public final void E0(C0301n c0301n) {
        HashMap map = new HashMap();
        map.put("p", AbstractC1748e.d(c0301n.f17495b.f17502a));
        Long lE = c0301n.e();
        if (lE != null) {
            map.put("q", c0301n.d().f17503b);
            map.put("t", lE);
        }
        t0("n", map, null);
    }

    public boolean F0() {
        return this.f17438d.size() == 0;
    }

    public final void G0() {
        if (F0()) {
            k kVar = this.f17442h;
            AbstractC1748e.b(kVar == k.Disconnected, "Not in disconnected state: %s", kVar);
            final boolean z7 = this.f17452r;
            final boolean z8 = this.f17454t;
            this.f17459y.b("Scheduling connection attempt", new Object[0]);
            this.f17452r = false;
            this.f17454t = false;
            this.f17460z.c(new Runnable() { // from class: f3.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17415a.g0(z7, z8);
                }
            });
        }
    }

    public final void H0(List list, p pVar) {
        if (list.contains("no_index")) {
            String str = "\".indexOn\": \"" + pVar.f17503b.get("i") + '\"';
            this.f17459y.i("Using an unspecified index. Your data will be downloaded and filtered on the client. Consider adding '" + str + "' at " + AbstractC1748e.d(pVar.f17502a) + " to your security and Firebase Database rules for better performance");
        }
    }

    public final boolean Q() {
        return this.f17442h == k.Connected;
    }

    public final boolean R() {
        return this.f17442h == k.Connected;
    }

    public final void S() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f17448n.entrySet().iterator();
        while (it.hasNext()) {
            o oVar = (o) ((Map.Entry) it.next()).getValue();
            if (oVar.d().containsKey("h") && oVar.f()) {
                arrayList.add(oVar);
                it.remove();
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((o) it2.next()).c().a("disconnected", null);
        }
    }

    public final boolean T() {
        k kVar = this.f17442h;
        return kVar == k.Authenticating || kVar == k.Connected;
    }

    public final void U() {
        if (a0()) {
            ScheduledFuture scheduledFuture = this.f17432E;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.f17432E = this.f17458x.schedule(new i(), 60000L, TimeUnit.MILLISECONDS);
            return;
        }
        if (b0("connection_idle")) {
            AbstractC1748e.a(!a0());
            m("connection_idle");
        }
    }

    public final AbstractC2328l V(boolean z7) {
        C2329m c2329m = new C2329m();
        this.f17459y.b("Trying to fetch app check token", new Object[0]);
        this.f17457w.a(z7, new b(c2329m));
        return c2329m.a();
    }

    public final AbstractC2328l W(boolean z7) {
        C2329m c2329m = new C2329m();
        this.f17459y.b("Trying to fetch auth token", new Object[0]);
        this.f17456v.a(z7, new a(c2329m));
        return c2329m.a();
    }

    public final Map X(List list, Object obj, String str) {
        HashMap map = new HashMap();
        map.put("p", AbstractC1748e.d(list));
        map.put("d", obj);
        if (str != null) {
            map.put("h", str);
        }
        return map;
    }

    public final void Y(long j8) {
        if (this.f17459y.f()) {
            this.f17459y.b("handling timestamp", new Object[0]);
        }
        long jCurrentTimeMillis = j8 - System.currentTimeMillis();
        HashMap map = new HashMap();
        map.put("serverTimeOffset", Long.valueOf(jCurrentTimeMillis));
        this.f17435a.d(map);
    }

    public final boolean Z() {
        return a0() && System.currentTimeMillis() > this.f17433F + 60000;
    }

    @Override // f3.InterfaceC1751h
    public void a() {
        G0();
    }

    public final boolean a0() {
        return this.f17450p.isEmpty() && this.f17449o.isEmpty() && this.f17446l.isEmpty() && !this.f17434G && this.f17448n.isEmpty();
    }

    @Override // f3.InterfaceC1751h
    public void b(List list, Object obj, String str, f3.p pVar) {
        o0("p", list, obj, str, pVar);
    }

    public boolean b0(String str) {
        return this.f17438d.contains(str);
    }

    @Override // f3.InterfaceC1751h
    public void c(List list, Object obj, f3.p pVar) {
        o0("p", list, obj, null, pVar);
    }

    @Override // f3.InterfaceC1751h
    public AbstractC2328l d(List list, Map map) {
        p pVar = new p(list, map);
        final C2329m c2329m = new C2329m();
        long j8 = this.f17444j;
        this.f17444j = 1 + j8;
        HashMap map2 = new HashMap();
        map2.put("p", AbstractC1748e.d(pVar.f17502a));
        map2.put("q", pVar.f17503b);
        this.f17449o.put(Long.valueOf(j8), new m("g", map2, new j() { // from class: f3.j
            @Override // f3.n.j
            public final void a(Map map3) {
                n.c0(c2329m, map3);
            }
        }, null));
        if (Q()) {
            y0(Long.valueOf(j8));
        }
        U();
        return c2329m.a();
    }

    public final /* synthetic */ void d0(boolean z7, Map map) {
        String str = (String) map.get("s");
        if (str.equals("ok")) {
            this.f17431D = 0;
        } else {
            this.f17453s = null;
            this.f17454t = true;
            String str2 = (String) map.get("d");
            this.f17459y.b("App check failed: " + str + " (" + str2 + ")", new Object[0]);
        }
        if (z7) {
            r0();
        }
    }

    @Override // f3.InterfaceC1751h
    public void e() {
        for (o oVar : this.f17448n.values()) {
            if (oVar.f17500c != null) {
                oVar.f17500c.a("write_canceled", null);
            }
        }
        for (l lVar : this.f17447m) {
            if (lVar.f17490d != null) {
                lVar.f17490d.a("write_canceled", null);
            }
        }
        this.f17448n.clear();
        this.f17447m.clear();
        if (!T()) {
            this.f17434G = false;
        }
        U();
    }

    public final /* synthetic */ void e0(long j8, AbstractC2328l abstractC2328l, AbstractC2328l abstractC2328l2, Void r72) {
        if (j8 != this.f17429B) {
            this.f17459y.b("Ignoring getToken result, because this was not the latest attempt.", new Object[0]);
            return;
        }
        k kVar = this.f17442h;
        if (kVar == k.GettingToken) {
            this.f17459y.b("Successfully fetched token, opening connection", new Object[0]);
            n0((String) abstractC2328l.k(), (String) abstractC2328l2.k());
        } else if (kVar == k.Disconnected) {
            this.f17459y.b("Not opening connection after token refresh, because connection was set to disconnected", new Object[0]);
        }
    }

    @Override // f3.InterfaceC1751h
    public void f(List list, f3.p pVar) {
        if (R()) {
            A0("oc", list, null, pVar);
        } else {
            this.f17447m.add(new l("oc", list, null, pVar, null));
        }
        U();
    }

    public final /* synthetic */ void f0(long j8, Exception exc) {
        if (j8 != this.f17429B) {
            this.f17459y.b("Ignoring getToken error, because this was not the latest attempt.", new Object[0]);
            return;
        }
        this.f17442h = k.Disconnected;
        this.f17459y.b("Error fetching token: " + exc, new Object[0]);
        G0();
    }

    @Override // f3.InterfaceC1751h
    public void g(List list, Map map, f3.p pVar) {
        this.f17434G = true;
        if (R()) {
            A0("om", list, map, pVar);
        } else {
            this.f17447m.add(new l("om", list, map, pVar, null));
        }
        U();
    }

    public final /* synthetic */ void g0(boolean z7, boolean z8) {
        k kVar = this.f17442h;
        AbstractC1748e.b(kVar == k.Disconnected, "Not in disconnected state: %s", kVar);
        this.f17442h = k.GettingToken;
        final long j8 = this.f17429B + 1;
        this.f17429B = j8;
        final AbstractC2328l abstractC2328lW = W(z7);
        final AbstractC2328l abstractC2328lV = V(z8);
        AbstractC2331o.g(abstractC2328lW, abstractC2328lV).f(this.f17458x, new InterfaceC2324h() { // from class: f3.k
            @Override // l2.InterfaceC2324h
            public final void onSuccess(Object obj) {
                this.f17419a.e0(j8, abstractC2328lW, abstractC2328lV, (Void) obj);
            }
        }).d(this.f17458x, new InterfaceC2323g() { // from class: f3.l
            @Override // l2.InterfaceC2323g
            public final void onFailure(Exception exc) {
                this.f17423a.f0(j8, exc);
            }
        });
    }

    @Override // f3.InterfaceC1751h
    public void h(List list, Map map, InterfaceC1750g interfaceC1750g, Long l8, f3.p pVar) {
        p pVar2 = new p(list, map);
        if (this.f17459y.f()) {
            this.f17459y.b("Listening on " + pVar2, new Object[0]);
        }
        AbstractC1748e.b(!this.f17450p.containsKey(pVar2), "listen() called twice for same QuerySpec.", new Object[0]);
        if (this.f17459y.f()) {
            this.f17459y.b("Adding listen query: " + pVar2, new Object[0]);
        }
        C0301n c0301n = new C0301n(pVar, pVar2, l8, interfaceC1750g, null);
        this.f17450p.put(pVar2, c0301n);
        if (T()) {
            z0(c0301n);
        }
        U();
    }

    public final long h0() {
        long j8 = this.f17445k;
        this.f17445k = 1 + j8;
        return j8;
    }

    @Override // f3.InterfaceC1751h
    public void i(String str) {
        if (this.f17459y.f()) {
            this.f17459y.b("Connection interrupted for: " + str, new Object[0]);
        }
        this.f17438d.add(str);
        C1745b c1745b = this.f17441g;
        if (c1745b != null) {
            c1745b.c();
            this.f17441g = null;
        } else {
            this.f17460z.b();
            this.f17442h = k.Disconnected;
        }
        this.f17460z.e();
    }

    public final void i0(String str, String str2) {
        this.f17459y.b("App check token revoked: " + str + " (" + str2 + ")", new Object[0]);
        this.f17453s = null;
        this.f17454t = true;
    }

    @Override // f3.InterfaceC1751h
    public void j(List list, Map map, f3.p pVar) {
        o0("m", list, map, null, pVar);
    }

    public final void j0(String str, String str2) {
        this.f17459y.b("Auth token revoked: " + str + " (" + str2 + ")", new Object[0]);
        this.f17451q = null;
        this.f17452r = true;
        this.f17435a.b(false);
        this.f17441g.c();
    }

    @Override // f3.InterfaceC1751h
    public void k(List list, Object obj, f3.p pVar) {
        this.f17434G = true;
        if (R()) {
            A0("o", list, obj, pVar);
        } else {
            this.f17447m.add(new l("o", list, obj, pVar, null));
        }
        U();
    }

    public final void k0(String str, Map map) {
        if (this.f17459y.f()) {
            this.f17459y.b("handleServerMessage: " + str + " " + map, new Object[0]);
        }
        if (str.equals("d") || str.equals("m")) {
            boolean zEquals = str.equals("m");
            String str2 = (String) map.get("p");
            Object obj = map.get("d");
            Long lC = AbstractC1748e.c(map.get("t"));
            if (!zEquals || !(obj instanceof Map) || ((Map) obj).size() != 0) {
                this.f17435a.a(AbstractC1748e.e(str2), obj, zEquals, lC);
                return;
            }
            if (this.f17459y.f()) {
                this.f17459y.b("ignoring empty merge for path " + str2, new Object[0]);
                return;
            }
            return;
        }
        if (!str.equals("rm")) {
            if (str.equals("c")) {
                l0(AbstractC1748e.e((String) map.get("p")));
                return;
            }
            if (str.equals("ac")) {
                j0((String) map.get("s"), (String) map.get("d"));
                return;
            }
            if (str.equals("apc")) {
                i0((String) map.get("s"), (String) map.get("d"));
                return;
            }
            if (str.equals("sd")) {
                m0(map);
                return;
            }
            if (this.f17459y.f()) {
                this.f17459y.b("Unrecognized action from server: " + str, new Object[0]);
                return;
            }
            return;
        }
        String str3 = (String) map.get("p");
        List listE = AbstractC1748e.e(str3);
        Object obj2 = map.get("d");
        Long lC2 = AbstractC1748e.c(map.get("t"));
        ArrayList arrayList = new ArrayList();
        for (Map map2 : (List) obj2) {
            String str4 = (String) map2.get("s");
            String str5 = (String) map2.get("e");
            List listE2 = null;
            List listE3 = str4 != null ? AbstractC1748e.e(str4) : null;
            if (str5 != null) {
                listE2 = AbstractC1748e.e(str5);
            }
            arrayList.add(new f3.o(listE3, listE2, map2.get("m")));
        }
        if (!arrayList.isEmpty()) {
            this.f17435a.f(listE, arrayList, lC2);
            return;
        }
        if (this.f17459y.f()) {
            this.f17459y.b("Ignoring empty range merge for path " + str3, new Object[0]);
        }
    }

    @Override // f3.C1745b.a
    public void l(String str) {
        this.f17437c = str;
    }

    public final void l0(List list) {
        Collection collectionQ0 = q0(list);
        if (collectionQ0 != null) {
            Iterator it = collectionQ0.iterator();
            while (it.hasNext()) {
                ((C0301n) it.next()).f17494a.a("permission_denied", null);
            }
        }
    }

    @Override // f3.InterfaceC1751h
    public void m(String str) {
        if (this.f17459y.f()) {
            this.f17459y.b("Connection no longer interrupted for: " + str, new Object[0]);
        }
        this.f17438d.remove(str);
        if (F0() && this.f17442h == k.Disconnected) {
            G0();
        }
    }

    public final void m0(Map map) {
        this.f17459y.e((String) map.get("msg"));
    }

    @Override // f3.C1745b.a
    public void n(String str) {
        if (str.equals("Invalid appcheck token")) {
            int i8 = this.f17431D;
            if (i8 < 3) {
                this.f17431D = i8 + 1;
                this.f17459y.i("Detected invalid AppCheck token. Reconnecting (" + (3 - ((long) this.f17431D)) + " attempts remaining)");
                return;
            }
        }
        this.f17459y.i("Firebase Database connection was forcefully killed by the server. Will not attempt reconnect. Reason: " + str);
        i("server_kill");
    }

    public void n0(String str, String str2) {
        k kVar = this.f17442h;
        AbstractC1748e.b(kVar == k.GettingToken, "Trying to open network connection while in the wrong state: %s", kVar);
        if (str == null) {
            this.f17435a.b(false);
        }
        this.f17451q = str;
        this.f17453s = str2;
        this.f17442h = k.Connecting;
        C1745b c1745b = new C1745b(this.f17455u, this.f17436b, this.f17437c, this, this.f17428A, str2);
        this.f17441g = c1745b;
        c1745b.k();
    }

    @Override // f3.C1745b.a
    public void o(C1745b.EnumC0300b enumC0300b) {
        boolean z7 = false;
        if (this.f17459y.f()) {
            this.f17459y.b("Got on disconnect due to " + enumC0300b.name(), new Object[0]);
        }
        this.f17442h = k.Disconnected;
        this.f17441g = null;
        this.f17434G = false;
        this.f17446l.clear();
        S();
        if (F0()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j8 = this.f17440f;
            long j9 = jCurrentTimeMillis - j8;
            if (j8 > 0 && j9 > 30000) {
                z7 = true;
            }
            if (enumC0300b == C1745b.EnumC0300b.SERVER_RESET || z7) {
                this.f17460z.e();
            }
            G0();
        }
        this.f17440f = 0L;
        this.f17435a.e();
    }

    public final void o0(String str, List list, Object obj, String str2, f3.p pVar) {
        Map mapX = X(list, obj, str2);
        long j8 = this.f17443i;
        this.f17443i = 1 + j8;
        this.f17448n.put(Long.valueOf(j8), new o(str, mapX, pVar, null));
        if (R()) {
            B0(j8);
        }
        this.f17433F = System.currentTimeMillis();
        U();
    }

    @Override // f3.C1745b.a
    public void p(long j8, String str) {
        if (this.f17459y.f()) {
            this.f17459y.b("onReady", new Object[0]);
        }
        this.f17440f = System.currentTimeMillis();
        Y(j8);
        if (this.f17439e) {
            x0();
        }
        s0();
        this.f17439e = false;
        this.f17428A = str;
        this.f17435a.c();
    }

    public final C0301n p0(p pVar) {
        if (this.f17459y.f()) {
            this.f17459y.b("removing query " + pVar, new Object[0]);
        }
        if (this.f17450p.containsKey(pVar)) {
            C0301n c0301n = (C0301n) this.f17450p.get(pVar);
            this.f17450p.remove(pVar);
            U();
            return c0301n;
        }
        if (!this.f17459y.f()) {
            return null;
        }
        this.f17459y.b("Trying to remove listener for QuerySpec " + pVar + " but no listener exists.", new Object[0]);
        return null;
    }

    @Override // f3.C1745b.a
    public void q(Map map) {
        if (map.containsKey("r")) {
            j jVar = (j) this.f17446l.remove(Long.valueOf(((Integer) map.get("r")).intValue()));
            if (jVar != null) {
                jVar.a((Map) map.get("b"));
                return;
            }
            return;
        }
        if (map.containsKey("error")) {
            return;
        }
        if (map.containsKey("a")) {
            k0((String) map.get("a"), (Map) map.get("b"));
            return;
        }
        if (this.f17459y.f()) {
            this.f17459y.b("Ignoring unknown message: " + map, new Object[0]);
        }
    }

    public final Collection q0(List list) {
        if (this.f17459y.f()) {
            this.f17459y.b("removing all listens at path " + list, new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.f17450p.entrySet()) {
            p pVar = (p) entry.getKey();
            C0301n c0301n = (C0301n) entry.getValue();
            if (pVar.f17502a.equals(list)) {
                arrayList.add(c0301n);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f17450p.remove(((C0301n) it.next()).d());
        }
        U();
        return arrayList;
    }

    @Override // f3.InterfaceC1751h
    public void r(List list, Map map) {
        p pVar = new p(list, map);
        if (this.f17459y.f()) {
            this.f17459y.b("unlistening on " + pVar, new Object[0]);
        }
        C0301n c0301nP0 = p0(pVar);
        if (c0301nP0 != null && T()) {
            E0(c0301nP0);
        }
        U();
    }

    public final void r0() {
        k kVar = this.f17442h;
        AbstractC1748e.b(kVar == k.Connected, "Should be connected if we're restoring state, but we are: %s", kVar);
        if (this.f17459y.f()) {
            this.f17459y.b("Restoring outstanding listens", new Object[0]);
        }
        for (C0301n c0301n : this.f17450p.values()) {
            if (this.f17459y.f()) {
                this.f17459y.b("Restoring listen " + c0301n.d(), new Object[0]);
            }
            z0(c0301n);
        }
        if (this.f17459y.f()) {
            this.f17459y.b("Restoring writes.", new Object[0]);
        }
        ArrayList arrayList = new ArrayList(this.f17448n.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            B0(((Long) it.next()).longValue());
        }
        for (l lVar : this.f17447m) {
            A0(lVar.b(), lVar.e(), lVar.c(), lVar.d());
        }
        this.f17447m.clear();
        if (this.f17459y.f()) {
            this.f17459y.b("Restoring reads.", new Object[0]);
        }
        ArrayList arrayList2 = new ArrayList(this.f17449o.keySet());
        Collections.sort(arrayList2);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            y0((Long) it2.next());
        }
    }

    public final void s0() {
        if (this.f17459y.f()) {
            this.f17459y.b("calling restore tokens", new Object[0]);
        }
        k kVar = this.f17442h;
        AbstractC1748e.b(kVar == k.Connecting, "Wanted to restore tokens, but was in wrong state: %s", kVar);
        if (this.f17451q != null) {
            if (this.f17459y.f()) {
                this.f17459y.b("Restoring auth.", new Object[0]);
            }
            this.f17442h = k.Authenticating;
            v0();
            return;
        }
        if (this.f17459y.f()) {
            this.f17459y.b("Not restoring auth because auth token is null.", new Object[0]);
        }
        this.f17442h = k.Connected;
        u0(true);
    }

    public final void t0(String str, Map map, j jVar) {
        C0(str, false, map, jVar);
    }

    public final void u0(final boolean z7) {
        if (this.f17453s == null) {
            r0();
            return;
        }
        AbstractC1748e.b(T(), "Must be connected to send auth, but was: %s", this.f17442h);
        if (this.f17459y.f()) {
            this.f17459y.b("Sending app check.", new Object[0]);
        }
        j jVar = new j() { // from class: f3.m
            @Override // f3.n.j
            public final void a(Map map) {
                this.f17425a.d0(z7, map);
            }
        };
        HashMap map = new HashMap();
        AbstractC1748e.b(this.f17453s != null, "App check token must be set!", new Object[0]);
        map.put("token", this.f17453s);
        C0("appcheck", true, map, jVar);
    }

    public final void v0() {
        w0(true);
    }

    public final void w0(boolean z7) {
        String str;
        AbstractC1748e.b(T(), "Must be connected to send auth, but was: %s", this.f17442h);
        if (this.f17459y.f()) {
            this.f17459y.b("Sending auth.", new Object[0]);
        }
        d dVar = new d(z7);
        HashMap map = new HashMap();
        C2674a c2674aC = C2674a.c(this.f17451q);
        if (c2674aC != null) {
            map.put("cred", c2674aC.b());
            if (c2674aC.a() != null) {
                map.put("authvar", c2674aC.a());
            }
            str = "gauth";
        } else {
            map.put("cred", this.f17451q);
            str = "auth";
        }
        C0(str, true, map, dVar);
    }

    public final void x0() {
        HashMap map = new HashMap();
        if (this.f17455u.i()) {
            map.put("persistence.android.enabled", 1);
        }
        map.put("sdk.android." + this.f17455u.d().replace(com.amazon.a.a.o.c.a.b.f14112a, '-'), 1);
        if (this.f17459y.f()) {
            this.f17459y.b("Sending first connection stats", new Object[0]);
        }
        D0(map);
    }

    public final void y0(Long l8) {
        AbstractC1748e.b(Q(), "sendGet called when we can't send gets", new Object[0]);
        m mVar = (m) this.f17449o.get(l8);
        if (mVar.f() || !this.f17459y.f()) {
            t0("g", mVar.e(), new f(l8, mVar));
            return;
        }
        this.f17459y.b(com.amazon.a.a.o.b.au + l8 + " cancelled, ignoring.", new Object[0]);
    }

    public final void z0(C0301n c0301n) {
        HashMap map = new HashMap();
        map.put("p", AbstractC1748e.d(c0301n.d().f17502a));
        Long lE = c0301n.e();
        if (lE != null) {
            map.put("q", c0301n.f17495b.f17503b);
            map.put("t", lE);
        }
        InterfaceC1750g interfaceC1750gC = c0301n.c();
        map.put("h", interfaceC1750gC.d());
        if (interfaceC1750gC.c()) {
            C1744a c1744aA = interfaceC1750gC.a();
            ArrayList arrayList = new ArrayList();
            Iterator it = c1744aA.b().iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC1748e.d((List) it.next()));
            }
            HashMap map2 = new HashMap();
            map2.put("hs", c1744aA.a());
            map2.put("ps", arrayList);
            map.put("ch", map2);
        }
        t0("q", map, new g(c0301n));
    }
}
