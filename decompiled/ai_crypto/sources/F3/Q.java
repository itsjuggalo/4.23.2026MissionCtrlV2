package F3;

import F3.Q;
import K3.C0617g;
import android.util.SparseArray;
import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class Q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f2054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f2055d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final M f2056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f2057b;

    public class a implements M1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0617g f2058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final K f2059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2060c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public C0617g.b f2061d;

        public a(C0617g c0617g, K k7) {
            this.f2058a = c0617g;
            this.f2059b = k7;
        }

        @Override // F3.M1
        public void a() {
            C0617g.b bVar = this.f2061d;
            if (bVar != null) {
                bVar.c();
            }
        }

        public final /* synthetic */ void c() {
            this.f2059b.z(Q.this);
            this.f2060c = true;
            d();
        }

        public final void d() {
            this.f2061d = this.f2058a.k(C0617g.d.GARBAGE_COLLECTION, this.f2060c ? Q.f2055d : Q.f2054c, new Runnable() { // from class: F3.P
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2053a.c();
                }
            });
        }

        @Override // F3.M1
        public void start() {
            if (Q.this.f2057b.f2063a != -1) {
                d();
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2065c;

        public b(long j7, int i7, int i8) {
            this.f2063a = j7;
            this.f2064b = i7;
            this.f2065c = i8;
        }

        public static b a(long j7) {
            return new b(j7, 10, 1000);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2068c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f2069d;

        public c(boolean z7, int i7, int i8, int i9) {
            this.f2066a = z7;
            this.f2067b = i7;
            this.f2068c = i8;
            this.f2069d = i9;
        }

        public static c a() {
            return new c(false, 0, 0, 0);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Comparator f2070c = new Comparator() { // from class: F3.S
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Q.d.d((Long) obj, (Long) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PriorityQueue f2071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2072b;

        public d(int i7) {
            this.f2072b = i7;
            this.f2071a = new PriorityQueue(i7, f2070c);
        }

        public static /* synthetic */ int d(Long l7, Long l8) {
            return l8.compareTo(l7);
        }

        public void b(Long l7) {
            if (this.f2071a.size() < this.f2072b) {
                this.f2071a.add(l7);
                return;
            }
            if (l7.longValue() < ((Long) this.f2071a.peek()).longValue()) {
                this.f2071a.poll();
                this.f2071a.add(l7);
            }
        }

        public long c() {
            return ((Long) this.f2071a.peek()).longValue();
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        f2054c = timeUnit.toMillis(1L);
        f2055d = timeUnit.toMillis(5L);
    }

    public Q(M m7, b bVar) {
        this.f2056a = m7;
        this.f2057b = bVar;
    }

    public static /* synthetic */ void i(d dVar, O1 o12) {
        dVar.b(Long.valueOf(o12.e()));
    }

    public int e(int i7) {
        return (int) ((i7 / 100.0f) * this.f2056a.j());
    }

    public c f(SparseArray sparseArray) {
        if (this.f2057b.f2063a == -1) {
            K3.x.a("LruGarbageCollector", "Garbage collection skipped; disabled", new Object[0]);
            return c.a();
        }
        long jG = g();
        if (jG >= this.f2057b.f2063a) {
            return m(sparseArray);
        }
        K3.x.a("LruGarbageCollector", "Garbage collection skipped; Cache size " + jG + " is lower than threshold " + this.f2057b.f2063a, new Object[0]);
        return c.a();
    }

    public long g() {
        return this.f2056a.m();
    }

    public long h(int i7) {
        if (i7 == 0) {
            return -1L;
        }
        final d dVar = new d(i7);
        this.f2056a.p(new K3.n() { // from class: F3.N
            @Override // K3.n
            public final void accept(Object obj) {
                Q.i(dVar, (O1) obj);
            }
        });
        this.f2056a.g(new K3.n() { // from class: F3.O
            @Override // K3.n
            public final void accept(Object obj) {
                dVar.b((Long) obj);
            }
        });
        return dVar.c();
    }

    public a j(C0617g c0617g, K k7) {
        return new a(c0617g, k7);
    }

    public int k(long j7) {
        return this.f2056a.k(j7);
    }

    public int l(long j7, SparseArray sparseArray) {
        return this.f2056a.a(j7, sparseArray);
    }

    public final c m(SparseArray sparseArray) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iE = e(this.f2057b.f2064b);
        if (iE > this.f2057b.f2065c) {
            K3.x.a("LruGarbageCollector", "Capping sequence numbers to collect down to the maximum of " + this.f2057b.f2065c + " from " + iE, new Object[0]);
            iE = this.f2057b.f2065c;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        long jH = h(iE);
        long jCurrentTimeMillis3 = System.currentTimeMillis();
        int iL = l(jH, sparseArray);
        long jCurrentTimeMillis4 = System.currentTimeMillis();
        int iK = k(jH);
        long jCurrentTimeMillis5 = System.currentTimeMillis();
        if (K3.x.c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("LRU Garbage Collection:\n\tCounted targets in " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + "ms\n");
            Locale locale = Locale.ROOT;
            sb.append(String.format(locale, "\tDetermined least recently used %d sequence numbers in %dms\n", Integer.valueOf(iE), Long.valueOf(jCurrentTimeMillis3 - jCurrentTimeMillis2)));
            K3.x.a("LruGarbageCollector", ((sb.toString() + String.format(locale, "\tRemoved %d targets in %dms\n", Integer.valueOf(iL), Long.valueOf(jCurrentTimeMillis4 - jCurrentTimeMillis3))) + String.format(locale, "\tRemoved %d documents in %dms\n", Integer.valueOf(iK), Long.valueOf(jCurrentTimeMillis5 - jCurrentTimeMillis4))) + String.format(locale, "Total Duration: %dms", Long.valueOf(jCurrentTimeMillis5 - jCurrentTimeMillis)), new Object[0]);
        }
        return new c(true, iE, iL, iK);
    }
}
