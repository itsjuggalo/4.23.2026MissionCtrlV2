package F4;

import F4.i0;
import G4.C0558v0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public final class S {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static S f1675d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f1677a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f1678b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f1674c = Logger.getLogger(S.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Iterable f1676e = c();

    public static final class a implements i0.b {
        @Override // F4.i0.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(Q q8) {
            return q8.c();
        }

        @Override // F4.i0.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(Q q8) {
            return q8.d();
        }
    }

    public static synchronized S b() {
        try {
            if (f1675d == null) {
                List<Q> listE = i0.e(Q.class, f1676e, Q.class.getClassLoader(), new a());
                f1675d = new S();
                for (Q q8 : listE) {
                    f1674c.fine("Service loader found " + q8);
                    f1675d.a(q8);
                }
                f1675d.e();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f1675d;
    }

    public static List c() {
        ArrayList arrayList = new ArrayList();
        try {
            boolean z7 = C0558v0.f3238b;
            arrayList.add(C0558v0.class);
        } catch (ClassNotFoundException e8) {
            f1674c.log(Level.WARNING, "Unable to find pick-first LoadBalancer", (Throwable) e8);
        }
        try {
            int i8 = N4.k.f5878b;
            arrayList.add(N4.k.class);
        } catch (ClassNotFoundException e9) {
            f1674c.log(Level.FINE, "Unable to find round-robin LoadBalancer", (Throwable) e9);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(Q q8) {
        AbstractC2848n.e(q8.d(), "isAvailable() returned false");
        this.f1677a.add(q8);
    }

    public synchronized Q d(String str) {
        return (Q) this.f1678b.get(AbstractC2848n.o(str, "policy"));
    }

    public final synchronized void e() {
        try {
            this.f1678b.clear();
            for (Q q8 : this.f1677a) {
                String strB = q8.b();
                Q q9 = (Q) this.f1678b.get(strB);
                if (q9 == null || q9.c() < q8.c()) {
                    this.f1678b.put(strB, q8);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
