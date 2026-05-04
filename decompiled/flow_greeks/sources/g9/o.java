package g9;

import g9.f1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements f1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f1 f10294a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f10296c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public z0 f10297d = z0.UNKNOWN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f10295b = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f10299b;

        static {
            int[] iArr = new int[c.values().length];
            f10299b = iArr;
            try {
                iArr[c.TERMINATE_LOCAL_LISTEN_AND_REQUIRE_WATCH_DISCONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10299b[c.TERMINATE_LOCAL_LISTEN_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10299b[c.REQUIRE_WATCH_DISCONNECTION_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.values().length];
            f10298a = iArr2;
            try {
                iArr2[d.INITIALIZE_LOCAL_LISTEN_AND_REQUIRE_WATCH_CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10298a[d.INITIALIZE_LOCAL_LISTEN_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10298a[d.REQUIRE_WATCH_CONNECTION_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f10300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f10301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10302c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d9.s0 f10303d = d9.s0.DEFAULT;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum c {
        TERMINATE_LOCAL_LISTEN_AND_REQUIRE_WATCH_DISCONNECTION,
        TERMINATE_LOCAL_LISTEN_ONLY,
        REQUIRE_WATCH_DISCONNECTION_ONLY,
        NO_ACTION_REQUIRED
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum d {
        INITIALIZE_LOCAL_LISTEN_AND_REQUIRE_WATCH_CONNECTION,
        INITIALIZE_LOCAL_LISTEN_ONLY,
        REQUIRE_WATCH_CONNECTION_ONLY,
        NO_ACTION_REQUIRED
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f10314a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public y1 f10315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f10316c;

        public boolean f() {
            Iterator it = this.f10314a.iterator();
            while (it.hasNext()) {
                if (((c1) it.next()).b()) {
                    return true;
                }
            }
            return false;
        }
    }

    public o(f1 f1Var) {
        this.f10294a = f1Var;
        f1Var.y(this);
    }

    @Override // g9.f1.c
    public void a(z0 z0Var) {
        this.f10297d = z0Var;
        Iterator it = this.f10295b.values().iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            Iterator it2 = ((e) it.next()).f10314a.iterator();
            while (it2.hasNext()) {
                if (((c1) it2.next()).d(z0Var)) {
                    z10 = true;
                }
            }
        }
        if (z10) {
            f();
        }
    }

    @Override // g9.f1.c
    public void b(b1 b1Var, rb.k1 k1Var) {
        e eVar = (e) this.f10295b.get(b1Var);
        if (eVar != null) {
            Iterator it = eVar.f10314a.iterator();
            while (it.hasNext()) {
                ((c1) it.next()).c(n9.g0.s(k1Var));
            }
        }
        this.f10295b.remove(b1Var);
    }

    @Override // g9.f1.c
    public void c(List list) {
        Iterator it = list.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            y1 y1Var = (y1) it.next();
            e eVar = (e) this.f10295b.get(y1Var.h());
            if (eVar != null) {
                Iterator it2 = eVar.f10314a.iterator();
                while (it2.hasNext()) {
                    if (((c1) it2.next()).e(y1Var)) {
                        z10 = true;
                    }
                }
                eVar.f10315b = y1Var;
            }
        }
        if (z10) {
            f();
        }
    }

    public int d(c1 c1Var) {
        b1 b1VarA = c1Var.a();
        d dVar = d.NO_ACTION_REQUIRED;
        e eVar = (e) this.f10295b.get(b1VarA);
        if (eVar == null) {
            eVar = new e();
            this.f10295b.put(b1VarA, eVar);
            dVar = c1Var.b() ? d.INITIALIZE_LOCAL_LISTEN_AND_REQUIRE_WATCH_CONNECTION : d.INITIALIZE_LOCAL_LISTEN_ONLY;
        } else if (!eVar.f() && c1Var.b()) {
            dVar = d.REQUIRE_WATCH_CONNECTION_ONLY;
        }
        eVar.f10314a.add(c1Var);
        n9.b.d(!c1Var.d(this.f10297d), "onOnlineStateChanged() shouldn't raise an event for brand-new listeners.", new Object[0]);
        if (eVar.f10315b != null && c1Var.e(eVar.f10315b)) {
            f();
        }
        int i10 = a.f10298a[dVar.ordinal()];
        if (i10 == 1) {
            eVar.f10316c = this.f10294a.n(b1VarA, true);
        } else if (i10 == 2) {
            eVar.f10316c = this.f10294a.n(b1VarA, false);
        } else if (i10 == 3) {
            this.f10294a.o(b1VarA);
        }
        return eVar.f10316c;
    }

    public void e(d9.r rVar) {
        this.f10296c.add(rVar);
        rVar.a(null, null);
    }

    public final void f() {
        Iterator it = this.f10296c.iterator();
        while (it.hasNext()) {
            ((d9.r) it.next()).a(null, null);
        }
    }

    public void g(c1 c1Var) {
        b1 b1VarA = c1Var.a();
        e eVar = (e) this.f10295b.get(b1VarA);
        c cVar = c.NO_ACTION_REQUIRED;
        if (eVar == null) {
            return;
        }
        eVar.f10314a.remove(c1Var);
        if (eVar.f10314a.isEmpty()) {
            cVar = c1Var.b() ? c.TERMINATE_LOCAL_LISTEN_AND_REQUIRE_WATCH_DISCONNECTION : c.TERMINATE_LOCAL_LISTEN_ONLY;
        } else if (!eVar.f() && c1Var.b()) {
            cVar = c.REQUIRE_WATCH_DISCONNECTION_ONLY;
        }
        int i10 = a.f10299b[cVar.ordinal()];
        if (i10 == 1) {
            this.f10295b.remove(b1VarA);
            this.f10294a.z(b1VarA, true);
        } else if (i10 == 2) {
            this.f10295b.remove(b1VarA);
            this.f10294a.z(b1VarA, false);
        } else {
            if (i10 != 3) {
                return;
            }
            this.f10294a.A(b1VarA);
        }
    }

    public void h(d9.r rVar) {
        this.f10296c.remove(rVar);
    }
}
