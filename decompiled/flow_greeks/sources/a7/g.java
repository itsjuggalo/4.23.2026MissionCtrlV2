package a7;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.internal.c;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import o7.n;
import o7.w;
import p7.a0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f311k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map f312l = new w.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o7.n f316d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w f319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final fa.b f320h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f317e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f318f = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f321i = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f322j = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void a(boolean z10);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static AtomicReference f323a = new AtomicReference();

        public static void c(Context context) {
            if (t5.n.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f323a.get() == null) {
                    b bVar = new b();
                    if (com.amazon.a.a.l.d.a(f323a, null, bVar)) {
                        com.google.android.gms.common.api.internal.c.c(application);
                        com.google.android.gms.common.api.internal.c.b().a(bVar);
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.c.a
        public void a(boolean z10) {
            synchronized (g.f311k) {
                try {
                    for (g gVar : new ArrayList(g.f312l.values())) {
                        if (gVar.f317e.get()) {
                            gVar.A(z10);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static AtomicReference f324b = new AtomicReference();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f325a;

        public c(Context context) {
            this.f325a = context;
        }

        public static void b(Context context) {
            if (f324b.get() == null) {
                c cVar = new c(context);
                if (com.amazon.a.a.l.d.a(f324b, null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f325a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (g.f311k) {
                try {
                    Iterator it = g.f312l.values().iterator();
                    while (it.hasNext()) {
                        ((g) it.next()).t();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            c();
        }
    }

    public g(final Context context, String str, p pVar) {
        this.f313a = (Context) com.google.android.gms.common.internal.s.k(context);
        this.f314b = com.google.android.gms.common.internal.s.e(str);
        this.f315c = (p) com.google.android.gms.common.internal.s.k(pVar);
        r rVarB = FirebaseInitProvider.b();
        ya.c.b("Firebase");
        ya.c.b("ComponentDiscovery");
        List listB = o7.f.c(context, ComponentDiscoveryService.class).b();
        ya.c.a();
        ya.c.b("Runtime");
        n.b bVarF = o7.n.l(a0.INSTANCE).d(listB).c(new FirebaseCommonRegistrar()).c(new ExecutorsRegistrar()).b(o7.c.q(context, Context.class, new Class[0])).b(o7.c.q(this, g.class, new Class[0])).b(o7.c.q(pVar, p.class, new Class[0])).f(new ya.b());
        if (p0.l.a(context) && FirebaseInitProvider.c()) {
            bVarF.b(o7.c.q(rVarB, r.class, new Class[0]));
        }
        o7.n nVarE = bVarF.e();
        this.f316d = nVarE;
        ya.c.a();
        this.f319g = new w(new fa.b() { // from class: a7.e
            @Override // fa.b
            public final Object get() {
                return g.b(this.f308a, context);
            }
        });
        this.f320h = nVarE.b(o9.f.class);
        g(new a() { // from class: a7.f
            @Override // a7.g.a
            public final void a(boolean z10) {
                g.a(this.f310a, z10);
            }
        });
        ya.c.a();
    }

    public static /* synthetic */ void a(g gVar, boolean z10) {
        if (z10) {
            gVar.getClass();
        } else {
            ((o9.f) gVar.f320h.get()).h();
        }
    }

    public static /* synthetic */ ka.a b(g gVar, Context context) {
        return new ka.a(context, gVar.s(), (c9.c) gVar.f316d.get(c9.c.class));
    }

    public static List l() {
        ArrayList arrayList = new ArrayList();
        synchronized (f311k) {
            try {
                Iterator it = f312l.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(((g) it.next()).q());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static List n(Context context) {
        ArrayList arrayList;
        synchronized (f311k) {
            arrayList = new ArrayList(f312l.values());
        }
        return arrayList;
    }

    public static g o() {
        g gVar;
        synchronized (f311k) {
            try {
                gVar = (g) f312l.get("[DEFAULT]");
                if (gVar == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + t5.o.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
                ((o9.f) gVar.f320h.get()).h();
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    public static g p(String str) {
        g gVar;
        String str2;
        synchronized (f311k) {
            try {
                gVar = (g) f312l.get(z(str));
                if (gVar == null) {
                    List listL = l();
                    if (listL.isEmpty()) {
                        str2 = "";
                    } else {
                        str2 = "Available app names: " + TextUtils.join(", ", listL);
                    }
                    throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", str, str2));
                }
                ((o9.f) gVar.f320h.get()).h();
            } finally {
            }
        }
        return gVar;
    }

    public static g u(Context context) {
        synchronized (f311k) {
            try {
                if (f312l.containsKey("[DEFAULT]")) {
                    return o();
                }
                p pVarA = p.a(context);
                if (pVarA == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return v(context, pVarA);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static g v(Context context, p pVar) {
        return w(context, pVar, "[DEFAULT]");
    }

    public static g w(Context context, p pVar, String str) {
        g gVar;
        b.c(context);
        String strZ = z(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f311k) {
            Map map = f312l;
            com.google.android.gms.common.internal.s.o(!map.containsKey(strZ), "FirebaseApp name " + strZ + " already exists!");
            com.google.android.gms.common.internal.s.l(context, "Application context cannot be null.");
            gVar = new g(context, strZ, pVar);
            map.put(strZ, gVar);
        }
        gVar.t();
        return gVar;
    }

    public static String z(String str) {
        return str.trim();
    }

    public final void A(boolean z10) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator it = this.f321i.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(z10);
        }
    }

    public final void B() {
        Iterator it = this.f322j.iterator();
        while (it.hasNext()) {
            ((h) it.next()).a(this.f314b, this.f315c);
        }
    }

    public void C(boolean z10) {
        i();
        if (this.f317e.compareAndSet(!z10, z10)) {
            boolean zD = com.google.android.gms.common.api.internal.c.b().d();
            if (z10 && zD) {
                A(true);
            } else {
                if (z10 || !zD) {
                    return;
                }
                A(false);
            }
        }
    }

    public void D(Boolean bool) {
        i();
        ((ka.a) this.f319g.get()).e(bool);
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f314b.equals(((g) obj).q());
        }
        return false;
    }

    public void g(a aVar) {
        i();
        if (this.f317e.get() && com.google.android.gms.common.api.internal.c.b().d()) {
            aVar.a(true);
        }
        this.f321i.add(aVar);
    }

    public void h(h hVar) {
        i();
        com.google.android.gms.common.internal.s.k(hVar);
        this.f322j.add(hVar);
    }

    public int hashCode() {
        return this.f314b.hashCode();
    }

    public final void i() {
        com.google.android.gms.common.internal.s.o(!this.f318f.get(), "FirebaseApp was deleted");
    }

    public void j() {
        if (this.f318f.compareAndSet(false, true)) {
            synchronized (f311k) {
                f312l.remove(this.f314b);
            }
            B();
        }
    }

    public Object k(Class cls) {
        i();
        return this.f316d.get(cls);
    }

    public Context m() {
        i();
        return this.f313a;
    }

    public String q() {
        i();
        return this.f314b;
    }

    public p r() {
        i();
        return this.f315c;
    }

    public String s() {
        return t5.c.e(q().getBytes(Charset.defaultCharset())) + "+" + t5.c.e(r().c().getBytes(Charset.defaultCharset()));
    }

    public final void t() {
        if (!p0.l.a(this.f313a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + q());
            c.b(this.f313a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + q());
        this.f316d.o(y());
        ((o9.f) this.f320h.get()).h();
    }

    public String toString() {
        return com.google.android.gms.common.internal.q.d(this).a("name", this.f314b).a("options", this.f315c).toString();
    }

    public boolean x() {
        i();
        return ((ka.a) this.f319g.get()).b();
    }

    public boolean y() {
        return "[DEFAULT]".equals(q());
    }
}
