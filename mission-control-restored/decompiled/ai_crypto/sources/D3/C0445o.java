package D3;

import D3.g0;
import K3.AbstractC0612b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: D3.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0445o implements g0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0 f1374a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f1376c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a0 f1377d = a0.UNKNOWN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f1375b = new HashMap();

    /* JADX INFO: renamed from: D3.o$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f1379b;

        static {
            int[] iArr = new int[c.values().length];
            f1379b = iArr;
            try {
                iArr[c.TERMINATE_LOCAL_LISTEN_AND_REQUIRE_WATCH_DISCONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1379b[c.TERMINATE_LOCAL_LISTEN_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1379b[c.REQUIRE_WATCH_DISCONNECTION_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.values().length];
            f1378a = iArr2;
            try {
                iArr2[d.INITIALIZE_LOCAL_LISTEN_AND_REQUIRE_WATCH_CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1378a[d.INITIALIZE_LOCAL_LISTEN_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1378a[d.REQUIRE_WATCH_CONNECTION_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: renamed from: D3.o$b */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public A3.T f1383d = A3.T.DEFAULT;
    }

    /* JADX INFO: renamed from: D3.o$c */
    public enum c {
        TERMINATE_LOCAL_LISTEN_AND_REQUIRE_WATCH_DISCONNECTION,
        TERMINATE_LOCAL_LISTEN_ONLY,
        REQUIRE_WATCH_DISCONNECTION_ONLY,
        NO_ACTION_REQUIRED
    }

    /* JADX INFO: renamed from: D3.o$d */
    public enum d {
        INITIALIZE_LOCAL_LISTEN_AND_REQUIRE_WATCH_CONNECTION,
        INITIALIZE_LOCAL_LISTEN_ONLY,
        REQUIRE_WATCH_CONNECTION_ONLY,
        NO_ACTION_REQUIRED
    }

    /* JADX INFO: renamed from: D3.o$e */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f1394a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public z0 f1395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1396c;

        public boolean f() {
            Iterator it = this.f1394a.iterator();
            while (it.hasNext()) {
                if (((d0) it.next()).b()) {
                    return true;
                }
            }
            return false;
        }
    }

    public C0445o(g0 g0Var) {
        this.f1374a = g0Var;
        g0Var.y(this);
    }

    @Override // D3.g0.c
    public void a(a0 a0Var) {
        this.f1377d = a0Var;
        Iterator it = this.f1375b.values().iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            Iterator it2 = ((e) it.next()).f1394a.iterator();
            while (it2.hasNext()) {
                if (((d0) it2.next()).d(a0Var)) {
                    z7 = true;
                }
            }
        }
        if (z7) {
            f();
        }
    }

    @Override // D3.g0.c
    public void b(c0 c0Var, r5.l0 l0Var) {
        e eVar = (e) this.f1375b.get(c0Var);
        if (eVar != null) {
            Iterator it = eVar.f1394a.iterator();
            while (it.hasNext()) {
                ((d0) it.next()).c(K3.I.u(l0Var));
            }
        }
        this.f1375b.remove(c0Var);
    }

    @Override // D3.g0.c
    public void c(List list) {
        Iterator it = list.iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            z0 z0Var = (z0) it.next();
            e eVar = (e) this.f1375b.get(z0Var.h());
            if (eVar != null) {
                Iterator it2 = eVar.f1394a.iterator();
                while (it2.hasNext()) {
                    if (((d0) it2.next()).e(z0Var)) {
                        z7 = true;
                    }
                }
                eVar.f1395b = z0Var;
            }
        }
        if (z7) {
            f();
        }
    }

    public int d(d0 d0Var) {
        c0 c0VarA = d0Var.a();
        d dVar = d.NO_ACTION_REQUIRED;
        e eVar = (e) this.f1375b.get(c0VarA);
        if (eVar == null) {
            eVar = new e();
            this.f1375b.put(c0VarA, eVar);
            dVar = d0Var.b() ? d.INITIALIZE_LOCAL_LISTEN_AND_REQUIRE_WATCH_CONNECTION : d.INITIALIZE_LOCAL_LISTEN_ONLY;
        } else if (!eVar.f() && d0Var.b()) {
            dVar = d.REQUIRE_WATCH_CONNECTION_ONLY;
        }
        eVar.f1394a.add(d0Var);
        AbstractC0612b.d(!d0Var.d(this.f1377d), "onOnlineStateChanged() shouldn't raise an event for brand-new listeners.", new Object[0]);
        if (eVar.f1395b != null && d0Var.e(eVar.f1395b)) {
            f();
        }
        int i7 = a.f1378a[dVar.ordinal()];
        if (i7 == 1) {
            eVar.f1396c = this.f1374a.n(c0VarA, true);
        } else if (i7 == 2) {
            eVar.f1396c = this.f1374a.n(c0VarA, false);
        } else if (i7 == 3) {
            this.f1374a.o(c0VarA);
        }
        return eVar.f1396c;
    }

    public void e(A3.r rVar) {
        this.f1376c.add(rVar);
        rVar.a(null, null);
    }

    public final void f() {
        Iterator it = this.f1376c.iterator();
        while (it.hasNext()) {
            ((A3.r) it.next()).a(null, null);
        }
    }

    public void g(d0 d0Var) {
        c0 c0VarA = d0Var.a();
        e eVar = (e) this.f1375b.get(c0VarA);
        c cVar = c.NO_ACTION_REQUIRED;
        if (eVar == null) {
            return;
        }
        eVar.f1394a.remove(d0Var);
        if (eVar.f1394a.isEmpty()) {
            cVar = d0Var.b() ? c.TERMINATE_LOCAL_LISTEN_AND_REQUIRE_WATCH_DISCONNECTION : c.TERMINATE_LOCAL_LISTEN_ONLY;
        } else if (!eVar.f() && d0Var.b()) {
            cVar = c.REQUIRE_WATCH_DISCONNECTION_ONLY;
        }
        int i7 = a.f1379b[cVar.ordinal()];
        if (i7 == 1) {
            this.f1375b.remove(c0VarA);
            this.f1374a.z(c0VarA, true);
        } else if (i7 == 2) {
            this.f1375b.remove(c0VarA);
            this.f1374a.z(c0VarA, false);
        } else {
            if (i7 != 3) {
                return;
            }
            this.f1374a.A(c0VarA);
        }
    }

    public void h(A3.r rVar) {
        this.f1376c.remove(rVar);
    }
}
