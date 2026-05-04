package rb;

import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import rb.b1;
import rb.j1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f19528e = Logger.getLogger(d1.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static d1 f19529f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b1.c f19530a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f19531b = FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet f19532c = new LinkedHashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q6.l f19533d = q6.l.k();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class b extends b1.c {
        public b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements j1.b {
        public c() {
        }

        @Override // rb.j1.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(c1 c1Var) {
            return c1Var.f();
        }

        @Override // rb.j1.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(c1 c1Var) {
            return c1Var.e();
        }
    }

    public static synchronized d1 b() {
        try {
            if (f19529f == null) {
                List<c1> listE = j1.e(c1.class, d(), c1.class.getClassLoader(), new c());
                if (listE.isEmpty()) {
                    f19528e.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                }
                f19529f = new d1();
                for (c1 c1Var : listE) {
                    f19528e.fine("Service loader found " + c1Var);
                    f19529f.a(c1Var);
                }
                f19529f.g();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f19529f;
    }

    public static List d() {
        ArrayList arrayList = new ArrayList();
        try {
            boolean z10 = tb.e0.f21211a;
            arrayList.add(tb.e0.class);
        } catch (ClassNotFoundException e10) {
            f19528e.log(Level.FINE, "Unable to find DNS NameResolver", (Throwable) e10);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(c1 c1Var) {
        p6.n.e(c1Var.e(), "isAvailable() returned false");
        this.f19532c.add(c1Var);
    }

    public synchronized String c() {
        return this.f19531b;
    }

    public c1 e(String str) {
        if (str == null) {
            return null;
        }
        return (c1) f().get(str.toLowerCase(Locale.US));
    }

    public synchronized Map f() {
        return this.f19533d;
    }

    public final synchronized void g() {
        try {
            HashMap map = new HashMap();
            String strD = FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE;
            int iF = Integer.MIN_VALUE;
            for (c1 c1Var : this.f19532c) {
                String strD2 = c1Var.d();
                c1 c1Var2 = (c1) map.get(strD2);
                if (c1Var2 == null || c1Var2.f() < c1Var.f()) {
                    map.put(strD2, c1Var);
                }
                if (iF < c1Var.f()) {
                    iF = c1Var.f();
                    strD = c1Var.d();
                }
            }
            this.f19533d = q6.l.c(map);
            this.f19531b = strD;
        } catch (Throwable th) {
            throw th;
        }
    }
}
