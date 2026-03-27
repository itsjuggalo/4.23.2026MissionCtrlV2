package Q2;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import b3.C0986c;
import b3.C0989f;
import b3.n;
import b3.w;
import c3.EnumC1131D;
import com.google.android.gms.common.api.internal.ComponentCallbacks2C1166c;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import h4.AbstractC1714c;
import h4.C1713b;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import u.C2736a;
import z3.InterfaceC2891c;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f4490k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map f4491l = new C2736a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f4494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b3.n f4495d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w f4498g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final N3.b f4499h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f4496e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f4497f = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f4500i = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f4501j = new CopyOnWriteArrayList();

    public interface a {
        void a(boolean z7);
    }

    public static class b implements ComponentCallbacks2C1166c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static AtomicReference f4502a = new AtomicReference();

        public static void c(Context context) {
            if (W1.m.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f4502a.get() == null) {
                    b bVar = new b();
                    if (com.amazon.a.a.l.d.a(f4502a, null, bVar)) {
                        ComponentCallbacks2C1166c.c(application);
                        ComponentCallbacks2C1166c.b().a(bVar);
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.ComponentCallbacks2C1166c.a
        public void a(boolean z7) {
            synchronized (g.f4490k) {
                try {
                    for (g gVar : new ArrayList(g.f4491l.values())) {
                        if (gVar.f4496e.get()) {
                            gVar.C(z7);
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
        public static AtomicReference f4503b = new AtomicReference();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f4504a;

        public c(Context context) {
            this.f4504a = context;
        }

        public static void b(Context context) {
            if (f4503b.get() == null) {
                c cVar = new c(context);
                if (com.amazon.a.a.l.d.a(f4503b, null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f4504a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (g.f4490k) {
                try {
                    Iterator it = g.f4491l.values().iterator();
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
        this.f4492a = (Context) AbstractC1207s.k(context);
        this.f4493b = AbstractC1207s.e(str);
        this.f4494c = (p) AbstractC1207s.k(pVar);
        r rVarB = FirebaseInitProvider.b();
        AbstractC1714c.b("Firebase");
        AbstractC1714c.b("ComponentDiscovery");
        List listB = C0989f.c(context, ComponentDiscoveryService.class).b();
        AbstractC1714c.a();
        AbstractC1714c.b("Runtime");
        n.b bVarG = b3.n.m(EnumC1131D.INSTANCE).d(listB).c(new FirebaseCommonRegistrar()).c(new ExecutorsRegistrar()).b(C0986c.s(context, Context.class, new Class[0])).b(C0986c.s(this, g.class, new Class[0])).b(C0986c.s(pVar, p.class, new Class[0])).g(new C1713b());
        if (M.o.a(context) && FirebaseInitProvider.c()) {
            bVarG.b(C0986c.s(rVarB, r.class, new Class[0]));
        }
        b3.n nVarE = bVarG.e();
        this.f4495d = nVarE;
        AbstractC1714c.a();
        this.f4498g = new w(new N3.b() { // from class: Q2.e
            @Override // N3.b
            public final Object get() {
                return this.f4487a.z(context);
            }
        });
        this.f4499h = nVarE.d(L3.f.class);
        g(new a() { // from class: Q2.f
            @Override // Q2.g.a
            public final void a(boolean z7) {
                this.f4489a.A(z7);
            }
        });
        AbstractC1714c.a();
    }

    public static String B(String str) {
        return str.trim();
    }

    public static List l() {
        ArrayList arrayList = new ArrayList();
        synchronized (f4490k) {
            try {
                Iterator it = f4491l.values().iterator();
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
        synchronized (f4490k) {
            arrayList = new ArrayList(f4491l.values());
        }
        return arrayList;
    }

    public static g o() {
        g gVar;
        synchronized (f4490k) {
            try {
                gVar = (g) f4491l.get("[DEFAULT]");
                if (gVar == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + W1.p.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
                ((L3.f) gVar.f4499h.get()).l();
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    public static g p(String str) {
        g gVar;
        String str2;
        synchronized (f4490k) {
            try {
                gVar = (g) f4491l.get(B(str));
                if (gVar == null) {
                    List listL = l();
                    if (listL.isEmpty()) {
                        str2 = "";
                    } else {
                        str2 = "Available app names: " + TextUtils.join(", ", listL);
                    }
                    throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", str, str2));
                }
                ((L3.f) gVar.f4499h.get()).l();
            } finally {
            }
        }
        return gVar;
    }

    public static g u(Context context) {
        synchronized (f4490k) {
            try {
                if (f4491l.containsKey("[DEFAULT]")) {
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
        String strB = B(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f4490k) {
            Map map = f4491l;
            AbstractC1207s.o(!map.containsKey(strB), "FirebaseApp name " + strB + " already exists!");
            AbstractC1207s.l(context, "Application context cannot be null.");
            gVar = new g(context, strB, pVar);
            map.put(strB, gVar);
        }
        gVar.t();
        return gVar;
    }

    public final /* synthetic */ void A(boolean z7) {
        if (z7) {
            return;
        }
        ((L3.f) this.f4499h.get()).l();
    }

    public final void C(boolean z7) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator it = this.f4500i.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(z7);
        }
    }

    public final void D() {
        Iterator it = this.f4501j.iterator();
        while (it.hasNext()) {
            ((h) it.next()).a(this.f4493b, this.f4494c);
        }
    }

    public void E(boolean z7) {
        i();
        if (this.f4496e.compareAndSet(!z7, z7)) {
            boolean zD = ComponentCallbacks2C1166c.b().d();
            if (z7 && zD) {
                C(true);
            } else {
                if (z7 || !zD) {
                    return;
                }
                C(false);
            }
        }
    }

    public void F(Boolean bool) {
        i();
        ((S3.a) this.f4498g.get()).e(bool);
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f4493b.equals(((g) obj).q());
        }
        return false;
    }

    public void g(a aVar) {
        i();
        if (this.f4496e.get() && ComponentCallbacks2C1166c.b().d()) {
            aVar.a(true);
        }
        this.f4500i.add(aVar);
    }

    public void h(h hVar) {
        i();
        AbstractC1207s.k(hVar);
        this.f4501j.add(hVar);
    }

    public int hashCode() {
        return this.f4493b.hashCode();
    }

    public final void i() {
        AbstractC1207s.o(!this.f4497f.get(), "FirebaseApp was deleted");
    }

    public void j() {
        if (this.f4497f.compareAndSet(false, true)) {
            synchronized (f4490k) {
                f4491l.remove(this.f4493b);
            }
            D();
        }
    }

    public Object k(Class cls) {
        i();
        return this.f4495d.a(cls);
    }

    public Context m() {
        i();
        return this.f4492a;
    }

    public String q() {
        i();
        return this.f4493b;
    }

    public p r() {
        i();
        return this.f4494c;
    }

    public String s() {
        return W1.c.e(q().getBytes(Charset.defaultCharset())) + "+" + W1.c.e(r().c().getBytes(Charset.defaultCharset()));
    }

    public final void t() {
        if (!M.o.a(this.f4492a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + q());
            c.b(this.f4492a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + q());
        this.f4495d.p(y());
        ((L3.f) this.f4499h.get()).l();
    }

    public String toString() {
        return AbstractC1206q.d(this).a("name", this.f4493b).a("options", this.f4494c).toString();
    }

    public boolean x() {
        i();
        return ((S3.a) this.f4498g.get()).b();
    }

    public boolean y() {
        return "[DEFAULT]".equals(q());
    }

    public final /* synthetic */ S3.a z(Context context) {
        return new S3.a(context, s(), (InterfaceC2891c) this.f4495d.a(InterfaceC2891c.class));
    }
}
