package F4;

import F4.a0;
import F4.i0;
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
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f1776e = Logger.getLogger(c0.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static c0 f1777f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0.c f1778a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1779b = FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet f1780c = new LinkedHashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w2.l f1781d = w2.l.j();

    public final class b extends a0.c {
        public b() {
        }
    }

    public static final class c implements i0.b {
        public c() {
        }

        @Override // F4.i0.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(b0 b0Var) {
            return b0Var.f();
        }

        @Override // F4.i0.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(b0 b0Var) {
            return b0Var.e();
        }
    }

    public static synchronized c0 b() {
        try {
            if (f1777f == null) {
                List<b0> listE = i0.e(b0.class, d(), b0.class.getClassLoader(), new c());
                if (listE.isEmpty()) {
                    f1776e.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                }
                f1777f = new c0();
                for (b0 b0Var : listE) {
                    f1776e.fine("Service loader found " + b0Var);
                    f1777f.a(b0Var);
                }
                f1777f.g();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f1777f;
    }

    public static List d() {
        ArrayList arrayList = new ArrayList();
        try {
            boolean z7 = G4.E.f2481a;
            arrayList.add(G4.E.class);
        } catch (ClassNotFoundException e8) {
            f1776e.log(Level.FINE, "Unable to find DNS NameResolver", (Throwable) e8);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(b0 b0Var) {
        AbstractC2848n.e(b0Var.e(), "isAvailable() returned false");
        this.f1780c.add(b0Var);
    }

    public synchronized String c() {
        return this.f1779b;
    }

    public b0 e(String str) {
        if (str == null) {
            return null;
        }
        return (b0) f().get(str.toLowerCase(Locale.US));
    }

    public synchronized Map f() {
        return this.f1781d;
    }

    public final synchronized void g() {
        try {
            HashMap map = new HashMap();
            String strD = FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE;
            int iF = Integer.MIN_VALUE;
            for (b0 b0Var : this.f1780c) {
                String strD2 = b0Var.d();
                b0 b0Var2 = (b0) map.get(strD2);
                if (b0Var2 == null || b0Var2.f() < b0Var.f()) {
                    map.put(strD2, b0Var);
                }
                if (iF < b0Var.f()) {
                    iF = b0Var.f();
                    strD = b0Var.d();
                }
            }
            this.f1781d = w2.l.c(map);
            this.f1779b = strD;
        } catch (Throwable th) {
            throw th;
        }
    }
}
