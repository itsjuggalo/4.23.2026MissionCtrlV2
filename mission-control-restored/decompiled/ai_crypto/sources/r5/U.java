package r5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import r5.k0;
import t5.C2705v0;

/* JADX INFO: loaded from: classes2.dex */
public final class U {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static U f22576d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f22578a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f22579b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f22575c = Logger.getLogger(U.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Iterable f22577e = c();

    public static final class a implements k0.b {
        @Override // r5.k0.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(T t7) {
            return t7.c();
        }

        @Override // r5.k0.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(T t7) {
            return t7.d();
        }
    }

    public static synchronized U b() {
        try {
            if (f22576d == null) {
                List<T> listE = k0.e(T.class, f22577e, T.class.getClassLoader(), new a());
                f22576d = new U();
                for (T t7 : listE) {
                    f22575c.fine("Service loader found " + t7);
                    f22576d.a(t7);
                }
                f22576d.e();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f22576d;
    }

    public static List c() {
        ArrayList arrayList = new ArrayList();
        try {
            boolean z7 = C2705v0.f24211b;
            arrayList.add(C2705v0.class);
        } catch (ClassNotFoundException e7) {
            f22575c.log(Level.WARNING, "Unable to find pick-first LoadBalancer", (Throwable) e7);
        }
        try {
            int i7 = A5.k.f387b;
            arrayList.add(A5.k.class);
        } catch (ClassNotFoundException e8) {
            f22575c.log(Level.FINE, "Unable to find round-robin LoadBalancer", (Throwable) e8);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(T t7) {
        H2.m.e(t7.d(), "isAvailable() returned false");
        this.f22578a.add(t7);
    }

    public synchronized T d(String str) {
        return (T) this.f22579b.get(H2.m.o(str, "policy"));
    }

    public final synchronized void e() {
        try {
            this.f22579b.clear();
            for (T t7 : this.f22578a) {
                String strB = t7.b();
                T t8 = (T) this.f22579b.get(strB);
                if (t8 == null || t8.c() < t7.c()) {
                    this.f22579b.put(strB, t7);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
