package h8;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import h8.b;
import h8.d;
import h8.h;
import i8.a;
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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n implements b.a, h8.h {
    public static long H;
    public String A;
    public long F;
    public boolean G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h.a f11146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h8.f f11147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f11148c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f11151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h8.b f11152g;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map f11157l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f11158m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map f11159n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Map f11160o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Map f11161p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f11162q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f11163r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f11164s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f11165t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h8.c f11166u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h8.d f11167v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final h8.d f11168w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ScheduledExecutorService f11169x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final q8.c f11170y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final i8.a f11171z;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashSet f11149d = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11150e = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k f11153h = k.Disconnected;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f11154i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f11155j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f11156k = 0;
    public long B = 0;
    public int C = 0;
    public int D = 0;
    public ScheduledFuture E = null;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f11172a;

        public a(TaskCompletionSource taskCompletionSource) {
            this.f11172a = taskCompletionSource;
        }

        @Override // h8.d.a
        public void a(String str) {
            this.f11172a.setResult(str);
        }

        @Override // h8.d.a
        public void onError(String str) {
            this.f11172a.setException(new Exception(str));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f11174a;

        public b(TaskCompletionSource taskCompletionSource) {
            this.f11174a = taskCompletionSource;
        }

        @Override // h8.d.a
        public void a(String str) {
            this.f11174a.setResult(str);
        }

        @Override // h8.d.a
        public void onError(String str) {
            this.f11174a.setException(new Exception(str));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h8.p f11176a;

        public c(h8.p pVar) {
            this.f11176a = pVar;
        }

        @Override // h8.n.j
        public void a(Map map) {
            String str;
            String str2 = (String) map.get("s");
            if (str2.equals("ok")) {
                str2 = null;
                str = null;
            } else {
                str = (String) map.get("d");
            }
            h8.p pVar = this.f11176a;
            if (pVar != null) {
                pVar.a(str2, str);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f11178a;

        public d(boolean z10) {
            this.f11178a = z10;
        }

        @Override // h8.n.j
        public void a(Map map) {
            String str = (String) map.get("s");
            if (str.equals("ok")) {
                n.this.f11153h = k.Connected;
                n.this.C = 0;
                n.this.r0(this.f11178a);
                return;
            }
            n.this.f11162q = null;
            n.this.f11163r = true;
            n.this.f11146a.b(false);
            String str2 = (String) map.get("d");
            n.this.f11170y.b("Authentication failed: " + str + " (" + str2 + ")", new Object[0]);
            n.this.f11152g.c();
            if (str.equals("invalid_token")) {
                n.B(n.this);
                if (n.this.C >= 3) {
                    n.this.f11171z.d();
                    n.this.f11170y.i("Provided authentication credentials are invalid. This usually indicates your FirebaseApp instance was not initialized correctly. Make sure your google-services.json file has the correct firebase_url and api_key. You can re-download google-services.json from https://console.firebase.google.com/.");
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f11181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f11182c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h8.p f11183d;

        public e(String str, long j10, o oVar, h8.p pVar) {
            this.f11180a = str;
            this.f11181b = j10;
            this.f11182c = oVar;
            this.f11183d = pVar;
        }

        @Override // h8.n.j
        public void a(Map map) {
            if (n.this.f11170y.f()) {
                n.this.f11170y.b(this.f11180a + " response: " + map, new Object[0]);
            }
            if (((o) n.this.f11159n.get(Long.valueOf(this.f11181b))) == this.f11182c) {
                n.this.f11159n.remove(Long.valueOf(this.f11181b));
                if (this.f11183d != null) {
                    String str = (String) map.get("s");
                    if (str.equals("ok")) {
                        this.f11183d.a(null, null);
                    } else {
                        this.f11183d.a(str, (String) map.get("d"));
                    }
                }
            } else if (n.this.f11170y.f()) {
                n.this.f11170y.b("Ignoring on complete for put " + this.f11181b + " because it was removed already.", new Object[0]);
            }
            n.this.W();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Long f11185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m f11186b;

        public f(Long l10, m mVar) {
            this.f11185a = l10;
            this.f11186b = mVar;
        }

        @Override // h8.n.j
        public void a(Map map) {
            if (((m) n.this.f11160o.get(this.f11185a)) == this.f11186b) {
                n.this.f11160o.remove(this.f11185a);
                this.f11186b.d().a(map);
            } else if (n.this.f11170y.f()) {
                n.this.f11170y.b("Ignoring on complete for get " + this.f11185a + " because it was removed already.", new Object[0]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class g implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0204n f11188a;

        public g(C0204n c0204n) {
            this.f11188a = c0204n;
        }

        @Override // h8.n.j
        public void a(Map map) {
            String str = (String) map.get("s");
            if (str.equals("ok")) {
                Map map2 = (Map) map.get("d");
                if (map2.containsKey("w")) {
                    n.this.I0((List) map2.get("w"), this.f11188a.f11206b);
                }
            }
            if (((C0204n) n.this.f11161p.get(this.f11188a.d())) == this.f11188a) {
                if (str.equals("ok")) {
                    this.f11188a.f11205a.a(null, null);
                    return;
                }
                n.this.m0(this.f11188a.d());
                this.f11188a.f11205a.a(str, (String) map.get("d"));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class h implements j {
        public h() {
        }

        @Override // h8.n.j
        public void a(Map map) {
            String str = (String) map.get("s");
            if (str.equals("ok")) {
                return;
            }
            String str2 = (String) map.get("d");
            if (n.this.f11170y.f()) {
                n.this.f11170y.b("Failed to send stats: " + str + " (message: " + str2 + ")", new Object[0]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.E = null;
            if (n.this.b0()) {
                n.this.f("connection_idle");
            } else {
                n.this.W();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface j {
        void a(Map map);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum k {
        Disconnected,
        GettingToken,
        Connecting,
        Authenticating,
        Connected
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f11199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f11200c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h8.p f11201d;

        public /* synthetic */ l(String str, List list, Object obj, h8.p pVar, a aVar) {
            this(str, list, obj, pVar);
        }

        public String b() {
            return this.f11198a;
        }

        public Object c() {
            return this.f11200c;
        }

        public h8.p d() {
            return this.f11201d;
        }

        public List e() {
            return this.f11199b;
        }

        public l(String str, List list, Object obj, h8.p pVar) {
            this.f11198a = str;
            this.f11199b = list;
            this.f11200c = obj;
            this.f11201d = pVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f11202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j f11203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f11204c;

        public /* synthetic */ m(String str, Map map, j jVar, a aVar) {
            this(str, map, jVar);
        }

        public final j d() {
            return this.f11203b;
        }

        public final Map e() {
            return this.f11202a;
        }

        public final boolean f() {
            if (this.f11204c) {
                return false;
            }
            this.f11204c = true;
            return true;
        }

        public m(String str, Map map, j jVar) {
            this.f11202a = map;
            this.f11203b = jVar;
            this.f11204c = false;
        }
    }

    /* JADX INFO: renamed from: h8.n$n, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0204n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h8.p f11205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f11206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h8.g f11207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Long f11208d;

        public /* synthetic */ C0204n(h8.p pVar, p pVar2, Long l10, h8.g gVar, a aVar) {
            this(pVar, pVar2, l10, gVar);
        }

        public h8.g c() {
            return this.f11207c;
        }

        public p d() {
            return this.f11206b;
        }

        public Long e() {
            return this.f11208d;
        }

        public String toString() {
            return this.f11206b.toString() + " (Tag: " + this.f11208d + ")";
        }

        public C0204n(h8.p pVar, p pVar2, Long l10, h8.g gVar) {
            this.f11205a = pVar;
            this.f11206b = pVar2;
            this.f11207c = gVar;
            this.f11208d = l10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f11210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h8.p f11211c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f11212d;

        public /* synthetic */ o(String str, Map map, h8.p pVar, a aVar) {
            this(str, map, pVar);
        }

        public String b() {
            return this.f11209a;
        }

        public h8.p c() {
            return this.f11211c;
        }

        public Map d() {
            return this.f11210b;
        }

        public void e() {
            this.f11212d = true;
        }

        public boolean f() {
            return this.f11212d;
        }

        public o(String str, Map map, h8.p pVar) {
            this.f11209a = str;
            this.f11210b = map;
            this.f11211c = pVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f11213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f11214b;

        public p(List list, Map map) {
            this.f11213a = list;
            this.f11214b = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof p)) {
                return false;
            }
            p pVar = (p) obj;
            if (this.f11213a.equals(pVar.f11213a)) {
                return this.f11214b.equals(pVar.f11214b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f11213a.hashCode() * 31) + this.f11214b.hashCode();
        }

        public String toString() {
            return h8.e.d(this.f11213a) + " (params: " + this.f11214b + ")";
        }
    }

    public n(h8.c cVar, h8.f fVar, h.a aVar) {
        this.f11146a = aVar;
        this.f11166u = cVar;
        ScheduledExecutorService scheduledExecutorServiceE = cVar.e();
        this.f11169x = scheduledExecutorServiceE;
        this.f11167v = cVar.c();
        this.f11168w = cVar.a();
        this.f11147b = fVar;
        this.f11161p = new HashMap();
        this.f11157l = new HashMap();
        this.f11159n = new HashMap();
        this.f11160o = new ConcurrentHashMap();
        this.f11158m = new ArrayList();
        this.f11171z = new a.b(scheduledExecutorServiceE, cVar.f(), "ConnectionRetryHelper").d(1000L).e(1.3d).c(HTTPTimeoutManager.DEFAULT_TIMEOUT_MS).b(0.7d).a();
        long j10 = H;
        H = 1 + j10;
        this.f11170y = new q8.c(cVar.f(), "PersistentConnection", "pc_" + j10);
        this.A = null;
        W();
    }

    public static /* synthetic */ int B(n nVar) {
        int i10 = nVar.C;
        nVar.C = i10 + 1;
        return i10;
    }

    public static /* synthetic */ void u(n nVar, boolean z10, Map map) {
        nVar.getClass();
        String str = (String) map.get("s");
        if (str.equals("ok")) {
            nVar.D = 0;
        } else {
            nVar.f11164s = null;
            nVar.f11165t = true;
            String str2 = (String) map.get("d");
            nVar.f11170y.b("App check failed: " + str + " (" + str2 + ")", new Object[0]);
        }
        if (z10) {
            nVar.o0();
        }
    }

    public static /* synthetic */ void v(n nVar, long j10, Task task, Task task2, Void r72) {
        if (j10 != nVar.B) {
            nVar.f11170y.b("Ignoring getToken result, because this was not the latest attempt.", new Object[0]);
            return;
        }
        k kVar = nVar.f11153h;
        if (kVar == k.GettingToken) {
            nVar.f11170y.b("Successfully fetched token, opening connection", new Object[0]);
            nVar.k0((String) task.getResult(), (String) task2.getResult());
        } else if (kVar == k.Disconnected) {
            nVar.f11170y.b("Not opening connection after token refresh, because connection was set to disconnected", new Object[0]);
        }
    }

    public static /* synthetic */ void w(TaskCompletionSource taskCompletionSource, Map map) {
        if (((String) map.get("s")).equals("ok")) {
            taskCompletionSource.setResult(map.get("d"));
        } else {
            taskCompletionSource.setException(new Exception((String) map.get("d")));
        }
    }

    public static /* synthetic */ void x(final n nVar, boolean z10, boolean z11) {
        k kVar = nVar.f11153h;
        h8.e.b(kVar == k.Disconnected, "Not in disconnected state: %s", kVar);
        nVar.f11153h = k.GettingToken;
        final long j10 = nVar.B + 1;
        nVar.B = j10;
        final Task taskY = nVar.Y(z10);
        final Task taskX = nVar.X(z11);
        Tasks.whenAll((Task<?>[]) new Task[]{taskY, taskX}).addOnSuccessListener(nVar.f11169x, new OnSuccessListener() { // from class: h8.k
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                n.v(this.f11138a, j10, taskY, taskX, (Void) obj);
            }
        }).addOnFailureListener(nVar.f11169x, new OnFailureListener() { // from class: h8.l
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                n.y(this.f11142a, j10, exc);
            }
        });
    }

    public static /* synthetic */ void y(n nVar, long j10, Exception exc) {
        if (j10 != nVar.B) {
            nVar.f11170y.b("Ignoring getToken error, because this was not the latest attempt.", new Object[0]);
            return;
        }
        nVar.f11153h = k.Disconnected;
        nVar.f11170y.b("Error fetching token: " + exc, new Object[0]);
        nVar.F0();
    }

    public final void A0(Map map) {
        if (map.isEmpty()) {
            if (this.f11170y.f()) {
                this.f11170y.b("Not sending stats because stats are empty", new Object[0]);
            }
        } else {
            HashMap map2 = new HashMap();
            map2.put("c", map);
            q0("s", map2, new h());
        }
    }

    public final void B0() {
        h8.e.b(V(), "Must be connected to send unauth.", new Object[0]);
        h8.e.b(this.f11164s == null, "App check token must not be set.", new Object[0]);
        q0("unappcheck", Collections.EMPTY_MAP, null);
    }

    public final void C0() {
        h8.e.b(V(), "Must be connected to send unauth.", new Object[0]);
        h8.e.b(this.f11162q == null, "Auth token must not be set.", new Object[0]);
        q0("unauth", Collections.EMPTY_MAP, null);
    }

    public final void D0(C0204n c0204n) {
        HashMap map = new HashMap();
        map.put("p", h8.e.d(c0204n.f11206b.f11213a));
        Long lE = c0204n.e();
        if (lE != null) {
            map.put("q", c0204n.d().f11214b);
            map.put("t", lE);
        }
        q0("n", map, null);
    }

    public boolean E0() {
        return this.f11149d.size() == 0;
    }

    public final void F0() {
        if (E0()) {
            k kVar = this.f11153h;
            h8.e.b(kVar == k.Disconnected, "Not in disconnected state: %s", kVar);
            final boolean z10 = this.f11163r;
            final boolean z11 = this.f11165t;
            this.f11170y.b("Scheduling connection attempt", new Object[0]);
            this.f11163r = false;
            this.f11165t = false;
            this.f11171z.c(new Runnable() { // from class: h8.i
                @Override // java.lang.Runnable
                public final void run() {
                    n.x(this.f11134a, z10, z11);
                }
            });
        }
    }

    public final void G0() {
        r0(false);
    }

    public final void H0() {
        t0(false);
    }

    public final void I0(List list, p pVar) {
        if (list.contains("no_index")) {
            String str = "\".indexOn\": \"" + pVar.f11214b.get("i") + '\"';
            this.f11170y.i("Using an unspecified index. Your data will be downloaded and filtered on the client. Consider adding '" + str + "' at " + h8.e.d(pVar.f11213a) + " to your security and Firebase Database rules for better performance");
        }
    }

    public final boolean S() {
        return this.f11153h == k.Connected;
    }

    public final boolean T() {
        return this.f11153h == k.Connected;
    }

    public final void U() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f11159n.entrySet().iterator();
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

    public final boolean V() {
        k kVar = this.f11153h;
        return kVar == k.Authenticating || kVar == k.Connected;
    }

    public final void W() {
        if (c0()) {
            ScheduledFuture scheduledFuture = this.E;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.E = this.f11169x.schedule(new i(), 60000L, TimeUnit.MILLISECONDS);
            return;
        }
        if (d0("connection_idle")) {
            h8.e.a(!c0());
            h("connection_idle");
        }
    }

    public final Task X(boolean z10) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f11170y.b("Trying to fetch app check token", new Object[0]);
        this.f11168w.a(z10, new b(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final Task Y(boolean z10) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f11170y.b("Trying to fetch auth token", new Object[0]);
        this.f11167v.a(z10, new a(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final Map Z(List list, Object obj, String str) {
        HashMap map = new HashMap();
        map.put("p", h8.e.d(list));
        map.put("d", obj);
        if (str != null) {
            map.put("h", str);
        }
        return map;
    }

    @Override // h8.h
    public void a() {
        F0();
    }

    public final void a0(long j10) {
        if (this.f11170y.f()) {
            this.f11170y.b("handling timestamp", new Object[0]);
        }
        long jCurrentTimeMillis = j10 - System.currentTimeMillis();
        HashMap map = new HashMap();
        map.put("serverTimeOffset", Long.valueOf(jCurrentTimeMillis));
        this.f11146a.d(map);
    }

    @Override // h8.h
    public Task b(List list, Map map) {
        p pVar = new p(list, map);
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        long j10 = this.f11155j;
        this.f11155j = 1 + j10;
        HashMap map2 = new HashMap();
        map2.put("p", h8.e.d(pVar.f11213a));
        map2.put("q", pVar.f11214b);
        this.f11160o.put(Long.valueOf(j10), new m("g", map2, new j() { // from class: h8.j
            @Override // h8.n.j
            public final void a(Map map3) {
                n.w(taskCompletionSource, map3);
            }
        }, null));
        if (S()) {
            v0(Long.valueOf(j10));
        }
        W();
        return taskCompletionSource.getTask();
    }

    public final boolean b0() {
        return c0() && System.currentTimeMillis() > this.F + 60000;
    }

    @Override // h8.h
    public void c() {
        for (o oVar : this.f11159n.values()) {
            if (oVar.f11211c != null) {
                oVar.f11211c.a("write_canceled", null);
            }
        }
        for (l lVar : this.f11158m) {
            if (lVar.f11201d != null) {
                lVar.f11201d.a("write_canceled", null);
            }
        }
        this.f11159n.clear();
        this.f11158m.clear();
        if (!V()) {
            this.G = false;
        }
        W();
    }

    public final boolean c0() {
        return this.f11161p.isEmpty() && this.f11160o.isEmpty() && this.f11157l.isEmpty() && !this.G && this.f11159n.isEmpty();
    }

    @Override // h8.b.a
    public void d(b.EnumC0203b enumC0203b) {
        boolean z10 = false;
        if (this.f11170y.f()) {
            this.f11170y.b("Got on disconnect due to " + enumC0203b.name(), new Object[0]);
        }
        this.f11153h = k.Disconnected;
        this.f11152g = null;
        this.G = false;
        this.f11157l.clear();
        U();
        if (E0()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j10 = this.f11151f;
            long j11 = jCurrentTimeMillis - j10;
            if (j10 > 0 && j11 > HTTPTimeoutManager.DEFAULT_TIMEOUT_MS) {
                z10 = true;
            }
            if (enumC0203b == b.EnumC0203b.SERVER_RESET || z10) {
                this.f11171z.e();
            }
            F0();
        }
        this.f11151f = 0L;
        this.f11146a.e();
    }

    public boolean d0(String str) {
        return this.f11149d.contains(str);
    }

    @Override // h8.h
    public void e(List list, Map map, h8.p pVar) {
        this.G = true;
        if (T()) {
            x0("om", list, map, pVar);
        } else {
            this.f11158m.add(new l("om", list, map, pVar, null));
        }
        W();
    }

    public final long e0() {
        long j10 = this.f11156k;
        this.f11156k = 1 + j10;
        return j10;
    }

    @Override // h8.h
    public void f(String str) {
        if (this.f11170y.f()) {
            this.f11170y.b("Connection interrupted for: " + str, new Object[0]);
        }
        this.f11149d.add(str);
        h8.b bVar = this.f11152g;
        if (bVar != null) {
            bVar.c();
            this.f11152g = null;
        } else {
            this.f11171z.b();
            this.f11153h = k.Disconnected;
        }
        this.f11171z.e();
    }

    public final void f0(String str, String str2) {
        this.f11170y.b("App check token revoked: " + str + " (" + str2 + ")", new Object[0]);
        this.f11164s = null;
        this.f11165t = true;
    }

    @Override // h8.b.a
    public void g(String str) {
        this.f11148c = str;
    }

    public final void g0(String str, String str2) {
        this.f11170y.b("Auth token revoked: " + str + " (" + str2 + ")", new Object[0]);
        this.f11162q = null;
        this.f11163r = true;
        this.f11146a.b(false);
        this.f11152g.c();
    }

    @Override // h8.h
    public void h(String str) {
        if (this.f11170y.f()) {
            this.f11170y.b("Connection no longer interrupted for: " + str, new Object[0]);
        }
        this.f11149d.remove(str);
        if (E0() && this.f11153h == k.Disconnected) {
            F0();
        }
    }

    public final void h0(String str, Map map) {
        if (this.f11170y.f()) {
            this.f11170y.b("handleServerMessage: " + str + " " + map, new Object[0]);
        }
        if (str.equals("d") || str.equals("m")) {
            boolean zEquals = str.equals("m");
            String str2 = (String) map.get("p");
            Object obj = map.get("d");
            Long lC = h8.e.c(map.get("t"));
            if (!zEquals || !(obj instanceof Map) || ((Map) obj).size() != 0) {
                this.f11146a.a(h8.e.e(str2), obj, zEquals, lC);
                return;
            }
            if (this.f11170y.f()) {
                this.f11170y.b("ignoring empty merge for path " + str2, new Object[0]);
                return;
            }
            return;
        }
        if (!str.equals("rm")) {
            if (str.equals("c")) {
                i0(h8.e.e((String) map.get("p")));
                return;
            }
            if (str.equals("ac")) {
                g0((String) map.get("s"), (String) map.get("d"));
                return;
            }
            if (str.equals("apc")) {
                f0((String) map.get("s"), (String) map.get("d"));
                return;
            }
            if (str.equals("sd")) {
                j0(map);
                return;
            }
            if (this.f11170y.f()) {
                this.f11170y.b("Unrecognized action from server: " + str, new Object[0]);
                return;
            }
            return;
        }
        String str3 = (String) map.get("p");
        List listE = h8.e.e(str3);
        Object obj2 = map.get("d");
        Long lC2 = h8.e.c(map.get("t"));
        ArrayList arrayList = new ArrayList();
        for (Map map2 : (List) obj2) {
            String str4 = (String) map2.get("s");
            String str5 = (String) map2.get("e");
            List listE2 = null;
            List listE3 = str4 != null ? h8.e.e(str4) : null;
            if (str5 != null) {
                listE2 = h8.e.e(str5);
            }
            arrayList.add(new h8.o(listE3, listE2, map2.get("m")));
        }
        if (!arrayList.isEmpty()) {
            this.f11146a.f(listE, arrayList, lC2);
            return;
        }
        if (this.f11170y.f()) {
            this.f11170y.b("Ignoring empty range merge for path " + str3, new Object[0]);
        }
    }

    @Override // h8.h
    public void i(List list, Map map, h8.p pVar) {
        l0("m", list, map, null, pVar);
    }

    public final void i0(List list) {
        Collection collectionN0 = n0(list);
        if (collectionN0 != null) {
            Iterator it = collectionN0.iterator();
            while (it.hasNext()) {
                ((C0204n) it.next()).f11205a.a("permission_denied", null);
            }
        }
    }

    @Override // h8.b.a
    public void j(String str) {
        if (str.equals("Invalid appcheck token")) {
            int i10 = this.D;
            if (i10 < 3) {
                this.D = i10 + 1;
                this.f11170y.i("Detected invalid AppCheck token. Reconnecting (" + (3 - ((long) this.D)) + " attempts remaining)");
                return;
            }
        }
        this.f11170y.i("Firebase Database connection was forcefully killed by the server. Will not attempt reconnect. Reason: " + str);
        f("server_kill");
    }

    public final void j0(Map map) {
        this.f11170y.e((String) map.get("msg"));
    }

    @Override // h8.h
    public void k(List list, Object obj, h8.p pVar) {
        this.G = true;
        if (T()) {
            x0("o", list, obj, pVar);
        } else {
            this.f11158m.add(new l("o", list, obj, pVar, null));
        }
        W();
    }

    public void k0(String str, String str2) {
        k kVar = this.f11153h;
        h8.e.b(kVar == k.GettingToken, "Trying to open network connection while in the wrong state: %s", kVar);
        if (str == null) {
            this.f11146a.b(false);
        }
        this.f11162q = str;
        this.f11164s = str2;
        this.f11153h = k.Connecting;
        h8.b bVar = new h8.b(this.f11166u, this.f11147b, this.f11148c, this, this.A, str2);
        this.f11152g = bVar;
        bVar.k();
    }

    @Override // h8.h
    public void l(List list, Object obj, h8.p pVar) {
        l0("p", list, obj, null, pVar);
    }

    public final void l0(String str, List list, Object obj, String str2, h8.p pVar) {
        Map mapZ = Z(list, obj, str2);
        long j10 = this.f11154i;
        this.f11154i = 1 + j10;
        this.f11159n.put(Long.valueOf(j10), new o(str, mapZ, pVar, null));
        if (T()) {
            y0(j10);
        }
        this.F = System.currentTimeMillis();
        W();
    }

    @Override // h8.b.a
    public void m(long j10, String str) {
        if (this.f11170y.f()) {
            this.f11170y.b("onReady", new Object[0]);
        }
        this.f11151f = System.currentTimeMillis();
        a0(j10);
        if (this.f11150e) {
            u0();
        }
        p0();
        this.f11150e = false;
        this.A = str;
        this.f11146a.c();
    }

    public final C0204n m0(p pVar) {
        if (this.f11170y.f()) {
            this.f11170y.b("removing query " + pVar, new Object[0]);
        }
        if (this.f11161p.containsKey(pVar)) {
            C0204n c0204n = (C0204n) this.f11161p.get(pVar);
            this.f11161p.remove(pVar);
            W();
            return c0204n;
        }
        if (!this.f11170y.f()) {
            return null;
        }
        this.f11170y.b("Trying to remove listener for QuerySpec " + pVar + " but no listener exists.", new Object[0]);
        return null;
    }

    @Override // h8.h
    public void n(String str) {
        this.f11170y.b("Auth token refreshed.", new Object[0]);
        this.f11162q = str;
        if (V()) {
            if (str != null) {
                H0();
            } else {
                C0();
            }
        }
    }

    public final Collection n0(List list) {
        if (this.f11170y.f()) {
            this.f11170y.b("removing all listens at path " + list, new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.f11161p.entrySet()) {
            p pVar = (p) entry.getKey();
            C0204n c0204n = (C0204n) entry.getValue();
            if (pVar.f11213a.equals(list)) {
                arrayList.add(c0204n);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f11161p.remove(((C0204n) it.next()).d());
        }
        W();
        return arrayList;
    }

    @Override // h8.h
    public void o(List list, Object obj, String str, h8.p pVar) {
        l0("p", list, obj, str, pVar);
    }

    public final void o0() {
        k kVar = this.f11153h;
        h8.e.b(kVar == k.Connected, "Should be connected if we're restoring state, but we are: %s", kVar);
        if (this.f11170y.f()) {
            this.f11170y.b("Restoring outstanding listens", new Object[0]);
        }
        for (C0204n c0204n : this.f11161p.values()) {
            if (this.f11170y.f()) {
                this.f11170y.b("Restoring listen " + c0204n.d(), new Object[0]);
            }
            w0(c0204n);
        }
        if (this.f11170y.f()) {
            this.f11170y.b("Restoring writes.", new Object[0]);
        }
        ArrayList arrayList = new ArrayList(this.f11159n.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            y0(((Long) it.next()).longValue());
        }
        for (l lVar : this.f11158m) {
            x0(lVar.b(), lVar.e(), lVar.c(), lVar.d());
        }
        this.f11158m.clear();
        if (this.f11170y.f()) {
            this.f11170y.b("Restoring reads.", new Object[0]);
        }
        ArrayList arrayList2 = new ArrayList(this.f11160o.keySet());
        Collections.sort(arrayList2);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            v0((Long) it2.next());
        }
    }

    @Override // h8.h
    public void p(List list, h8.p pVar) {
        if (T()) {
            x0("oc", list, null, pVar);
        } else {
            this.f11158m.add(new l("oc", list, null, pVar, null));
        }
        W();
    }

    public final void p0() {
        if (this.f11170y.f()) {
            this.f11170y.b("calling restore tokens", new Object[0]);
        }
        k kVar = this.f11153h;
        h8.e.b(kVar == k.Connecting, "Wanted to restore tokens, but was in wrong state: %s", kVar);
        if (this.f11162q != null) {
            if (this.f11170y.f()) {
                this.f11170y.b("Restoring auth.", new Object[0]);
            }
            this.f11153h = k.Authenticating;
            s0();
            return;
        }
        if (this.f11170y.f()) {
            this.f11170y.b("Not restoring auth because auth token is null.", new Object[0]);
        }
        this.f11153h = k.Connected;
        r0(true);
    }

    @Override // h8.h
    public void q(List list, Map map, h8.g gVar, Long l10, h8.p pVar) {
        p pVar2 = new p(list, map);
        if (this.f11170y.f()) {
            this.f11170y.b("Listening on " + pVar2, new Object[0]);
        }
        h8.e.b(!this.f11161p.containsKey(pVar2), "listen() called twice for same QuerySpec.", new Object[0]);
        if (this.f11170y.f()) {
            this.f11170y.b("Adding listen query: " + pVar2, new Object[0]);
        }
        C0204n c0204n = new C0204n(pVar, pVar2, l10, gVar, null);
        this.f11161p.put(pVar2, c0204n);
        if (V()) {
            w0(c0204n);
        }
        W();
    }

    public final void q0(String str, Map map, j jVar) {
        z0(str, false, map, jVar);
    }

    @Override // h8.h
    public void r(String str) {
        this.f11170y.b("App check token refreshed.", new Object[0]);
        this.f11164s = str;
        if (V()) {
            if (str != null) {
                G0();
            } else {
                B0();
            }
        }
    }

    public final void r0(final boolean z10) {
        if (this.f11164s == null) {
            o0();
            return;
        }
        h8.e.b(V(), "Must be connected to send auth, but was: %s", this.f11153h);
        if (this.f11170y.f()) {
            this.f11170y.b("Sending app check.", new Object[0]);
        }
        j jVar = new j() { // from class: h8.m
            @Override // h8.n.j
            public final void a(Map map) {
                n.u(this.f11144a, z10, map);
            }
        };
        HashMap map = new HashMap();
        h8.e.b(this.f11164s != null, "App check token must be set!", new Object[0]);
        map.put("token", this.f11164s);
        z0("appcheck", true, map, jVar);
    }

    @Override // h8.b.a
    public void s(Map map) {
        if (map.containsKey("r")) {
            j jVar = (j) this.f11157l.remove(Long.valueOf(((Integer) map.get("r")).intValue()));
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
            h0((String) map.get("a"), (Map) map.get("b"));
            return;
        }
        if (this.f11170y.f()) {
            this.f11170y.b("Ignoring unknown message: " + map, new Object[0]);
        }
    }

    public final void s0() {
        t0(true);
    }

    @Override // h8.h
    public void t(List list, Map map) {
        p pVar = new p(list, map);
        if (this.f11170y.f()) {
            this.f11170y.b("unlistening on " + pVar, new Object[0]);
        }
        C0204n c0204nM0 = m0(pVar);
        if (c0204nM0 != null && V()) {
            D0(c0204nM0);
        }
        W();
    }

    public final void t0(boolean z10) {
        h8.e.b(V(), "Must be connected to send auth, but was: %s", this.f11153h);
        if (this.f11170y.f()) {
            this.f11170y.b("Sending auth.", new Object[0]);
        }
        d dVar = new d(z10);
        HashMap map = new HashMap();
        t8.a aVarC = t8.a.c(this.f11162q);
        if (aVarC == null) {
            map.put("cred", this.f11162q);
            z0("auth", true, map, dVar);
        } else {
            map.put("cred", aVarC.b());
            if (aVarC.a() != null) {
                map.put("authvar", aVarC.a());
            }
            z0("gauth", true, map, dVar);
        }
    }

    public final void u0() {
        HashMap map = new HashMap();
        if (this.f11166u.i()) {
            map.put("persistence.android.enabled", 1);
        }
        map.put("sdk.android." + this.f11166u.d().replace(com.amazon.a.a.o.c.a.b.f4610a, '-'), 1);
        if (this.f11170y.f()) {
            this.f11170y.b("Sending first connection stats", new Object[0]);
        }
        A0(map);
    }

    public final void v0(Long l10) {
        h8.e.b(S(), "sendGet called when we can't send gets", new Object[0]);
        m mVar = (m) this.f11160o.get(l10);
        if (mVar.f() || !this.f11170y.f()) {
            q0("g", mVar.e(), new f(l10, mVar));
            return;
        }
        this.f11170y.b(com.amazon.a.a.o.b.au + l10 + " cancelled, ignoring.", new Object[0]);
    }

    public final void w0(C0204n c0204n) {
        HashMap map = new HashMap();
        map.put("p", h8.e.d(c0204n.d().f11213a));
        Long lE = c0204n.e();
        if (lE != null) {
            map.put("q", c0204n.f11206b.f11214b);
            map.put("t", lE);
        }
        h8.g gVarC = c0204n.c();
        map.put("h", gVarC.d());
        if (gVarC.b()) {
            h8.a aVarA = gVarC.a();
            ArrayList arrayList = new ArrayList();
            Iterator it = aVarA.b().iterator();
            while (it.hasNext()) {
                arrayList.add(h8.e.d((List) it.next()));
            }
            HashMap map2 = new HashMap();
            map2.put("hs", aVarA.a());
            map2.put("ps", arrayList);
            map.put("ch", map2);
        }
        q0("q", map, new g(c0204n));
    }

    public final void x0(String str, List list, Object obj, h8.p pVar) {
        HashMap map = new HashMap();
        map.put("p", h8.e.d(list));
        map.put("d", obj);
        q0(str, map, new c(pVar));
    }

    public final void y0(long j10) {
        h8.e.b(T(), "sendPut called when we can't send writes (we're disconnected or writes are paused).", new Object[0]);
        o oVar = (o) this.f11159n.get(Long.valueOf(j10));
        h8.p pVarC = oVar.c();
        String strB = oVar.b();
        oVar.e();
        q0(strB, oVar.d(), new e(strB, j10, oVar, pVarC));
    }

    public final void z0(String str, boolean z10, Map map, j jVar) {
        long jE0 = e0();
        HashMap map2 = new HashMap();
        map2.put("r", Long.valueOf(jE0));
        map2.put("a", str);
        map2.put("b", map);
        this.f11152g.m(map2, z10);
        this.f11157l.put(Long.valueOf(jE0), jVar);
    }
}
