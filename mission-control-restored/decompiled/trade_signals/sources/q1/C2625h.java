package q1;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: renamed from: q1.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2625h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f22528a = new LinkedHashMap(100, 0.75f, true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f22529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f22530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f22531d;

    /* JADX INFO: renamed from: q1.h$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f22532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f22533b;

        public a(Object obj, int i8) {
            this.f22532a = obj;
            this.f22533b = i8;
        }
    }

    public C2625h(long j8) {
        this.f22529b = j8;
        this.f22530c = j8;
    }

    public void b() {
        m(0L);
    }

    public final void f() {
        m(this.f22530c);
    }

    public synchronized Object g(Object obj) {
        a aVar;
        aVar = (a) this.f22528a.get(obj);
        return aVar != null ? aVar.f22532a : null;
    }

    public synchronized long h() {
        return this.f22530c;
    }

    public int i(Object obj) {
        return 1;
    }

    public synchronized Object k(Object obj, Object obj2) {
        int i8 = i(obj2);
        long j8 = i8;
        if (j8 >= this.f22530c) {
            j(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.f22531d += j8;
        }
        a aVar = (a) this.f22528a.put(obj, obj2 == null ? null : new a(obj2, i8));
        if (aVar != null) {
            this.f22531d -= (long) aVar.f22533b;
            if (!aVar.f22532a.equals(obj2)) {
                j(obj, aVar.f22532a);
            }
        }
        f();
        return aVar != null ? aVar.f22532a : null;
    }

    public synchronized Object l(Object obj) {
        a aVar = (a) this.f22528a.remove(obj);
        if (aVar == null) {
            return null;
        }
        this.f22531d -= (long) aVar.f22533b;
        return aVar.f22532a;
    }

    public synchronized void m(long j8) {
        while (this.f22531d > j8) {
            Iterator it = this.f22528a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            a aVar = (a) entry.getValue();
            this.f22531d -= (long) aVar.f22533b;
            Object key = entry.getKey();
            it.remove();
            j(key, aVar.f22532a);
        }
    }

    public void j(Object obj, Object obj2) {
    }
}
