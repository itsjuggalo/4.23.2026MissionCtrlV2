package c4;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f3587a = new LinkedHashMap(100, 0.75f, true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3590d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f3591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3592b;

        public a(Object obj, int i10) {
            this.f3591a = obj;
            this.f3592b = i10;
        }
    }

    public h(long j10) {
        this.f3588b = j10;
        this.f3589c = j10;
    }

    public void b() {
        m(0L);
    }

    public final void f() {
        m(this.f3589c);
    }

    public synchronized Object g(Object obj) {
        a aVar;
        aVar = (a) this.f3587a.get(obj);
        return aVar != null ? aVar.f3591a : null;
    }

    public synchronized long h() {
        return this.f3589c;
    }

    public int i(Object obj) {
        return 1;
    }

    public synchronized Object k(Object obj, Object obj2) {
        int i10 = i(obj2);
        long j10 = i10;
        if (j10 >= this.f3589c) {
            j(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.f3590d += j10;
        }
        a aVar = (a) this.f3587a.put(obj, obj2 == null ? null : new a(obj2, i10));
        if (aVar != null) {
            this.f3590d -= (long) aVar.f3592b;
            if (!aVar.f3591a.equals(obj2)) {
                j(obj, aVar.f3591a);
            }
        }
        f();
        return aVar != null ? aVar.f3591a : null;
    }

    public synchronized Object l(Object obj) {
        a aVar = (a) this.f3587a.remove(obj);
        if (aVar == null) {
            return null;
        }
        this.f3590d -= (long) aVar.f3592b;
        return aVar.f3591a;
    }

    public synchronized void m(long j10) {
        while (this.f3590d > j10) {
            Iterator it = this.f3587a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            a aVar = (a) entry.getValue();
            this.f3590d -= (long) aVar.f3592b;
            Object key = entry.getKey();
            it.remove();
            j(key, aVar.f3591a);
        }
    }

    public void j(Object obj, Object obj2) {
    }
}
