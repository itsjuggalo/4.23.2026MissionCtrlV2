package G2;

import M2.C0700c;
import M2.C0703f;
import M2.n;
import M2.w;
import N2.B;
import S1.ComponentCallbacks2C0871c;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1293m;
import com.google.android.gms.common.internal.AbstractC1294n;
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
import k4.C2282b;
import w.C2882a;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f2168k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map f2169l = new C2882a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f2172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final M2.n f2173d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w f2176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final S3.b f2177h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f2174e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f2175f = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f2178i = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f2179j = new CopyOnWriteArrayList();

    public interface a {
        void a(boolean z7);
    }

    public static class b implements ComponentCallbacks2C0871c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static AtomicReference f2180a = new AtomicReference();

        public static void c(Context context) {
            if (W1.l.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f2180a.get() == null) {
                    b bVar = new b();
                    if (com.amazon.a.a.l.d.a(f2180a, null, bVar)) {
                        ComponentCallbacks2C0871c.c(application);
                        ComponentCallbacks2C0871c.b().a(bVar);
                    }
                }
            }
        }

        @Override // S1.ComponentCallbacks2C0871c.a
        public void a(boolean z7) {
            synchronized (f.f2168k) {
                try {
                    for (f fVar : new ArrayList(f.f2169l.values())) {
                        if (fVar.f2174e.get()) {
                            fVar.C(z7);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static AtomicReference f2181b = new AtomicReference();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f2182a;

        public c(Context context) {
            this.f2182a = context;
        }

        public static void b(Context context) {
            if (f2181b.get() == null) {
                c cVar = new c(context);
                if (com.amazon.a.a.l.d.a(f2181b, null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f2182a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (f.f2168k) {
                try {
                    Iterator it = f.f2169l.values().iterator();
                    while (it.hasNext()) {
                        ((f) it.next()).t();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            c();
        }
    }

    public f(final Context context, String str, n nVar) {
        this.f2170a = (Context) AbstractC1294n.j(context);
        this.f2171b = AbstractC1294n.d(str);
        this.f2172c = (n) AbstractC1294n.j(nVar);
        o oVarB = FirebaseInitProvider.b();
        k4.c.b("Firebase");
        k4.c.b("ComponentDiscovery");
        List listB = C0703f.c(context, ComponentDiscoveryService.class).b();
        k4.c.a();
        k4.c.b("Runtime");
        n.b bVarG = M2.n.l(B.INSTANCE).d(listB).c(new FirebaseCommonRegistrar()).c(new ExecutorsRegistrar()).b(C0700c.s(context, Context.class, new Class[0])).b(C0700c.s(this, f.class, new Class[0])).b(C0700c.s(nVar, n.class, new Class[0])).g(new C2282b());
        if (P.m.a(context) && FirebaseInitProvider.c()) {
            bVarG.b(C0700c.s(oVarB, o.class, new Class[0]));
        }
        M2.n nVarE = bVarG.e();
        this.f2173d = nVarE;
        k4.c.a();
        this.f2176g = new w(new S3.b() { // from class: G2.d
            @Override // S3.b
            public final Object get() {
                return this.f2165a.z(context);
            }
        });
        this.f2177h = nVarE.c(B3.f.class);
        g(new a() { // from class: G2.e
            @Override // G2.f.a
            public final void a(boolean z7) {
                this.f2167a.A(z7);
            }
        });
        k4.c.a();
    }

    public static String B(String str) {
        return str.trim();
    }

    public static List l() {
        ArrayList arrayList = new ArrayList();
        synchronized (f2168k) {
            try {
                Iterator it = f2169l.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(((f) it.next()).q());
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
        synchronized (f2168k) {
            arrayList = new ArrayList(f2169l.values());
        }
        return arrayList;
    }

    public static f o() {
        f fVar;
        synchronized (f2168k) {
            try {
                fVar = (f) f2169l.get("[DEFAULT]");
                if (fVar == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + W1.o.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
                ((B3.f) fVar.f2177h.get()).l();
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public static f p(String str) {
        f fVar;
        String str2;
        synchronized (f2168k) {
            try {
                fVar = (f) f2169l.get(B(str));
                if (fVar == null) {
                    List listL = l();
                    if (listL.isEmpty()) {
                        str2 = "";
                    } else {
                        str2 = "Available app names: " + TextUtils.join(", ", listL);
                    }
                    throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", str, str2));
                }
                ((B3.f) fVar.f2177h.get()).l();
            } finally {
            }
        }
        return fVar;
    }

    public static f u(Context context) {
        synchronized (f2168k) {
            try {
                if (f2169l.containsKey("[DEFAULT]")) {
                    return o();
                }
                n nVarA = n.a(context);
                if (nVarA == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return v(context, nVarA);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static f v(Context context, n nVar) {
        return w(context, nVar, "[DEFAULT]");
    }

    public static f w(Context context, n nVar, String str) {
        f fVar;
        b.c(context);
        String strB = B(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f2168k) {
            Map map = f2169l;
            AbstractC1294n.n(!map.containsKey(strB), "FirebaseApp name " + strB + " already exists!");
            AbstractC1294n.k(context, "Application context cannot be null.");
            fVar = new f(context, strB, nVar);
            map.put(strB, fVar);
        }
        fVar.t();
        return fVar;
    }

    public final /* synthetic */ void A(boolean z7) {
        if (z7) {
            return;
        }
        ((B3.f) this.f2177h.get()).l();
    }

    public final void C(boolean z7) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator it = this.f2178i.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(z7);
        }
    }

    public final void D() {
        Iterator it = this.f2179j.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(this.f2171b, this.f2172c);
        }
    }

    public void E(boolean z7) {
        boolean z8;
        i();
        if (this.f2174e.compareAndSet(!z7, z7)) {
            boolean zD = ComponentCallbacks2C0871c.b().d();
            if (z7 && zD) {
                z8 = true;
            } else if (z7 || !zD) {
                return;
            } else {
                z8 = false;
            }
            C(z8);
        }
    }

    public void F(Boolean bool) {
        i();
        ((X3.a) this.f2176g.get()).e(bool);
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f2171b.equals(((f) obj).q());
        }
        return false;
    }

    public void g(a aVar) {
        i();
        if (this.f2174e.get() && ComponentCallbacks2C0871c.b().d()) {
            aVar.a(true);
        }
        this.f2178i.add(aVar);
    }

    public void h(g gVar) {
        i();
        AbstractC1294n.j(gVar);
        this.f2179j.add(gVar);
    }

    public int hashCode() {
        return this.f2171b.hashCode();
    }

    public final void i() {
        AbstractC1294n.n(!this.f2175f.get(), "FirebaseApp was deleted");
    }

    public void j() {
        if (this.f2175f.compareAndSet(false, true)) {
            synchronized (f2168k) {
                f2169l.remove(this.f2171b);
            }
            D();
        }
    }

    public Object k(Class cls) {
        i();
        return this.f2173d.get(cls);
    }

    public Context m() {
        i();
        return this.f2170a;
    }

    public String q() {
        i();
        return this.f2171b;
    }

    public n r() {
        i();
        return this.f2172c;
    }

    public String s() {
        return W1.c.a(q().getBytes(Charset.defaultCharset())) + "+" + W1.c.a(r().c().getBytes(Charset.defaultCharset()));
    }

    public final void t() {
        if (!P.m.a(this.f2170a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + q());
            c.b(this.f2170a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + q());
        this.f2173d.o(y());
        ((B3.f) this.f2177h.get()).l();
    }

    public String toString() {
        return AbstractC1293m.c(this).a("name", this.f2171b).a("options", this.f2172c).toString();
    }

    public boolean x() {
        i();
        return ((X3.a) this.f2176g.get()).b();
    }

    public boolean y() {
        return "[DEFAULT]".equals(q());
    }

    public final /* synthetic */ X3.a z(Context context) {
        return new X3.a(context, s(), (A3.c) this.f2173d.get(A3.c.class));
    }
}
