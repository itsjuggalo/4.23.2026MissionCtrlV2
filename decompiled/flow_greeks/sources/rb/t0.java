package rb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rb.j1;
import tb.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class t0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static t0 f19726d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f19728a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f19729b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f19725c = Logger.getLogger(t0.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Iterable f19727e = c();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements j1.b {
        @Override // rb.j1.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(s0 s0Var) {
            return s0Var.c();
        }

        @Override // rb.j1.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(s0 s0Var) {
            return s0Var.d();
        }
    }

    public static synchronized t0 b() {
        try {
            if (f19726d == null) {
                List<s0> listE = j1.e(s0.class, f19727e, s0.class.getClassLoader(), new a());
                f19726d = new t0();
                for (s0 s0Var : listE) {
                    f19725c.fine("Service loader found " + s0Var);
                    f19726d.a(s0Var);
                }
                f19726d.e();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f19726d;
    }

    public static List c() {
        ArrayList arrayList = new ArrayList();
        try {
            boolean z10 = u1.f21768b;
            arrayList.add(u1.class);
        } catch (ClassNotFoundException e10) {
            f19725c.log(Level.WARNING, "Unable to find pick-first LoadBalancer", (Throwable) e10);
        }
        try {
            int i10 = ac.k.f731b;
            arrayList.add(ac.k.class);
        } catch (ClassNotFoundException e11) {
            f19725c.log(Level.FINE, "Unable to find round-robin LoadBalancer", (Throwable) e11);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(s0 s0Var) {
        p6.n.e(s0Var.d(), "isAvailable() returned false");
        this.f19728a.add(s0Var);
    }

    public synchronized s0 d(String str) {
        return (s0) this.f19729b.get(p6.n.o(str, "policy"));
    }

    public final synchronized void e() {
        try {
            this.f19729b.clear();
            for (s0 s0Var : this.f19728a) {
                String strB = s0Var.b();
                s0 s0Var2 = (s0) this.f19729b.get(strB);
                if (s0Var2 == null || s0Var2.c() < s0Var.c()) {
                    this.f19729b.put(strB, s0Var);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
