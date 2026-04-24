package K2;

import K2.k0;
import M2.C0450v0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class U {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static U f1086d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f1088a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f1089b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f1085c = Logger.getLogger(U.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Iterable f1087e = c();

    public static final class a implements k0.b {
        @Override // K2.k0.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(T t4) {
            return t4.c();
        }

        @Override // K2.k0.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(T t4) {
            return t4.d();
        }
    }

    public static synchronized U b() {
        try {
            if (f1086d == null) {
                List<T> listE = k0.e(T.class, f1087e, T.class.getClassLoader(), new a());
                f1086d = new U();
                for (T t4 : listE) {
                    f1085c.fine("Service loader found " + t4);
                    f1086d.a(t4);
                }
                f1086d.e();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f1086d;
    }

    public static List c() {
        ArrayList arrayList = new ArrayList();
        try {
            boolean z4 = C0450v0.f2660b;
            arrayList.add(C0450v0.class);
        } catch (ClassNotFoundException e4) {
            f1085c.log(Level.WARNING, "Unable to find pick-first LoadBalancer", (Throwable) e4);
        }
        try {
            int i4 = T2.k.f5224b;
            arrayList.add(T2.k.class);
        } catch (ClassNotFoundException e5) {
            f1085c.log(Level.FINE, "Unable to find round-robin LoadBalancer", (Throwable) e5);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(T t4) {
        Z1.m.e(t4.d(), "isAvailable() returned false");
        this.f1088a.add(t4);
    }

    public synchronized T d(String str) {
        return (T) this.f1089b.get(Z1.m.o(str, "policy"));
    }

    public final synchronized void e() {
        try {
            this.f1089b.clear();
            for (T t4 : this.f1088a) {
                String strB = t4.b();
                T t5 = (T) this.f1089b.get(strB);
                if (t5 == null || t5.c() < t4.c()) {
                    this.f1089b.put(strB, t4);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
