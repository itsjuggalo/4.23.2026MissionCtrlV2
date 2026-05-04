package pa;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.revenuecat.purchases.api.BuildConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class z implements sa.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final t5.e f18474j = t5.h.d();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Random f18475k = new Random();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map f18476l = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f18477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f18478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f18479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a7.g f18480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ga.h f18481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b7.c f18482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final fa.b f18483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f18484h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map f18485i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AtomicReference f18486a = new AtomicReference();

        public static void c(Context context) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference atomicReference = f18486a;
            if (atomicReference.get() == null) {
                a aVar = new a();
                if (com.amazon.a.a.l.d.a(atomicReference, null, aVar)) {
                    com.google.android.gms.common.api.internal.c.c(application);
                    com.google.android.gms.common.api.internal.c.b().a(aVar);
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.c.a
        public void a(boolean z10) {
            z.q(z10);
        }
    }

    public z(Context context, ScheduledExecutorService scheduledExecutorService, a7.g gVar, ga.h hVar, b7.c cVar, fa.b bVar) {
        this(context, scheduledExecutorService, gVar, hVar, cVar, bVar, true);
    }

    public static /* synthetic */ AnalyticsConnector b() {
        return null;
    }

    public static qa.r k(a7.g gVar, String str, fa.b bVar) {
        if (p(gVar) && str.equals("firebase")) {
            return new qa.r(bVar);
        }
        return null;
    }

    public static com.google.firebase.remoteconfig.internal.e n(Context context, String str, String str2) {
        return new com.google.firebase.remoteconfig.internal.e(context.getSharedPreferences(String.format("%s_%s_%s_%s", "frc", str, str2, "settings"), 0));
    }

    public static boolean o(a7.g gVar, String str) {
        return str.equals("firebase") && p(gVar);
    }

    public static boolean p(a7.g gVar) {
        return gVar.q().equals("[DEFAULT]");
    }

    public static synchronized void q(boolean z10) {
        Iterator it = f18476l.values().iterator();
        while (it.hasNext()) {
            ((o) it.next()).u(z10);
        }
    }

    @Override // sa.a
    public void a(String str, ta.f fVar) {
        e(str).q().e(fVar);
    }

    public synchronized o d(a7.g gVar, String str, ga.h hVar, b7.c cVar, Executor executor, qa.e eVar, qa.e eVar2, qa.e eVar3, com.google.firebase.remoteconfig.internal.c cVar2, qa.l lVar, com.google.firebase.remoteconfig.internal.e eVar4, ra.e eVar5) throws Throwable {
        z zVar;
        String str2;
        try {
            try {
                if (this.f18477a.containsKey(str)) {
                    zVar = this;
                    str2 = str;
                } else {
                    zVar = this;
                    str2 = str;
                    o oVar = new o(this.f18478b, gVar, hVar, o(gVar, str) ? cVar : null, executor, eVar, eVar2, eVar3, cVar2, lVar, eVar4, l(gVar, hVar, cVar2, eVar2, this.f18478b, str, eVar4), eVar5);
                    oVar.y();
                    zVar.f18477a.put(str2, oVar);
                    f18476l.put(str2, oVar);
                }
                return (o) zVar.f18477a.get(str2);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public synchronized o e(String str) throws Throwable {
        Throwable th;
        try {
            try {
                qa.e eVarF = f(str, "fetch");
                qa.e eVarF2 = f(str, "activate");
                qa.e eVarF3 = f(str, BuildConfig.FLAVOR_apis);
                com.google.firebase.remoteconfig.internal.e eVarN = n(this.f18478b, this.f18484h, str);
                qa.l lVarJ = j(eVarF2, eVarF3);
                final qa.r rVarK = k(this.f18480d, str, this.f18483g);
                if (rVarK != null) {
                    try {
                        lVarJ.b(new t5.d() { // from class: pa.w
                            @Override // t5.d
                            public final void accept(Object obj, Object obj2) {
                                rVarK.a((String) obj, (com.google.firebase.remoteconfig.internal.b) obj2);
                            }
                        });
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                return d(this.f18480d, str, this.f18481e, this.f18482f, this.f18479c, eVarF, eVarF2, eVarF3, h(str, eVarF, eVarN), lVarJ, eVarN, m(eVarF2, eVarF3));
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final qa.e f(String str, String str2) {
        return qa.e.h(this.f18479c, qa.p.c(this.f18478b, String.format("%s_%s_%s_%s.json", "frc", this.f18484h, str, str2)));
    }

    public o g() {
        return e("firebase");
    }

    public synchronized com.google.firebase.remoteconfig.internal.c h(String str, qa.e eVar, com.google.firebase.remoteconfig.internal.e eVar2) {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return new com.google.firebase.remoteconfig.internal.c(this.f18481e, p(this.f18480d) ? this.f18483g : new fa.b() { // from class: pa.y
            @Override // fa.b
            public final Object get() {
                return z.b();
            }
        }, this.f18479c, f18474j, f18475k, eVar, i(this.f18480d.r().b(), str, eVar2), eVar2, this.f18485i);
    }

    public ConfigFetchHttpClient i(String str, String str2, com.google.firebase.remoteconfig.internal.e eVar) {
        return new ConfigFetchHttpClient(this.f18478b, this.f18480d.r().c(), str, str2, eVar.c(), eVar.c());
    }

    public final qa.l j(qa.e eVar, qa.e eVar2) {
        return new qa.l(this.f18479c, eVar, eVar2);
    }

    public synchronized qa.m l(a7.g gVar, ga.h hVar, com.google.firebase.remoteconfig.internal.c cVar, qa.e eVar, Context context, String str, com.google.firebase.remoteconfig.internal.e eVar2) {
        return new qa.m(gVar, hVar, cVar, eVar, context, str, eVar2, this.f18479c);
    }

    public final ra.e m(qa.e eVar, qa.e eVar2) {
        return new ra.e(eVar, ra.a.a(eVar, eVar2), this.f18479c);
    }

    public z(Context context, ScheduledExecutorService scheduledExecutorService, a7.g gVar, ga.h hVar, b7.c cVar, fa.b bVar, boolean z10) {
        this.f18477a = new HashMap();
        this.f18485i = new HashMap();
        this.f18478b = context;
        this.f18479c = scheduledExecutorService;
        this.f18480d = gVar;
        this.f18481e = hVar;
        this.f18482f = cVar;
        this.f18483g = bVar;
        this.f18484h = gVar.r().c();
        a.c(context);
        if (z10) {
            Tasks.call(scheduledExecutorService, new Callable() { // from class: pa.x
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f18473a.g();
                }
            });
        }
    }
}
