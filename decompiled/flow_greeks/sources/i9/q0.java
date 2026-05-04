package i9;

import android.util.SparseArray;
import i9.q0;
import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import n9.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f12120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f12121d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f12122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f12123b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements l4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n9.g f12124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k0 f12125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f12126c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public g.b f12127d;

        public a(n9.g gVar, k0 k0Var) {
            this.f12124a = gVar;
            this.f12125b = k0Var;
        }

        public static /* synthetic */ void a(a aVar) {
            aVar.f12125b.z(q0.this);
            aVar.f12126c = true;
            aVar.b();
        }

        public final void b() {
            this.f12127d = this.f12124a.k(g.d.GARBAGE_COLLECTION, this.f12126c ? q0.f12121d : q0.f12120c, new Runnable() { // from class: i9.p0
                @Override // java.lang.Runnable
                public final void run() {
                    q0.a.a(this.f12111a);
                }
            });
        }

        @Override // i9.l4
        public void start() {
            if (q0.this.f12123b.f12129a != -1) {
                b();
            }
        }

        @Override // i9.l4
        public void stop() {
            g.b bVar = this.f12127d;
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f12129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f12131c;

        public b(long j10, int i10, int i11) {
            this.f12129a = j10;
            this.f12130b = i10;
            this.f12131c = i11;
        }

        public static b a(long j10) {
            return new b(j10, 10, 1000);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f12132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f12134c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f12135d;

        public c(boolean z10, int i10, int i11, int i12) {
            this.f12132a = z10;
            this.f12133b = i10;
            this.f12134c = i11;
            this.f12135d = i12;
        }

        public static c a() {
            return new c(false, 0, 0, 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Comparator f12136c = new Comparator() { // from class: i9.r0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Long) obj2).compareTo((Long) obj);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PriorityQueue f12137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12138b;

        public d(int i10) {
            this.f12138b = i10;
            this.f12137a = new PriorityQueue(i10, f12136c);
        }

        public void b(Long l10) {
            if (this.f12137a.size() < this.f12138b) {
                this.f12137a.add(l10);
                return;
            }
            if (l10.longValue() < ((Long) this.f12137a.peek()).longValue()) {
                this.f12137a.poll();
                this.f12137a.add(l10);
            }
        }

        public long c() {
            return ((Long) this.f12137a.peek()).longValue();
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        f12120c = timeUnit.toMillis(1L);
        f12121d = timeUnit.toMillis(5L);
    }

    public q0(m0 m0Var, b bVar) {
        this.f12122a = m0Var;
        this.f12123b = bVar;
    }

    public int e(int i10) {
        return (int) ((i10 / 100.0f) * this.f12122a.k());
    }

    public c f(SparseArray sparseArray) {
        if (this.f12123b.f12129a == -1) {
            n9.v.a("LruGarbageCollector", "Garbage collection skipped; disabled", new Object[0]);
            return c.a();
        }
        long jG = g();
        if (jG >= this.f12123b.f12129a) {
            return l(sparseArray);
        }
        n9.v.a("LruGarbageCollector", "Garbage collection skipped; Cache size " + jG + " is lower than threshold " + this.f12123b.f12129a, new Object[0]);
        return c.a();
    }

    public long g() {
        return this.f12122a.a();
    }

    public long h(int i10) {
        if (i10 == 0) {
            return -1L;
        }
        final d dVar = new d(i10);
        this.f12122a.j(new n9.n() { // from class: i9.n0
            @Override // n9.n
            public final void accept(Object obj) {
                dVar.b(Long.valueOf(((n4) obj).e()));
            }
        });
        this.f12122a.b(new n9.n() { // from class: i9.o0
            @Override // n9.n
            public final void accept(Object obj) {
                dVar.b((Long) obj);
            }
        });
        return dVar.c();
    }

    public a i(n9.g gVar, k0 k0Var) {
        return new a(gVar, k0Var);
    }

    public int j(long j10) {
        return this.f12122a.l(j10);
    }

    public int k(long j10, SparseArray sparseArray) {
        return this.f12122a.c(j10, sparseArray);
    }

    public final c l(SparseArray sparseArray) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iE = e(this.f12123b.f12130b);
        if (iE > this.f12123b.f12131c) {
            n9.v.a("LruGarbageCollector", "Capping sequence numbers to collect down to the maximum of " + this.f12123b.f12131c + " from " + iE, new Object[0]);
            iE = this.f12123b.f12131c;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        long jH = h(iE);
        long jCurrentTimeMillis3 = System.currentTimeMillis();
        int iK = k(jH, sparseArray);
        long jCurrentTimeMillis4 = System.currentTimeMillis();
        int iJ = j(jH);
        long jCurrentTimeMillis5 = System.currentTimeMillis();
        if (n9.v.c()) {
            String str = "LRU Garbage Collection:\n\tCounted targets in " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + "ms\n";
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            Locale locale = Locale.ROOT;
            sb2.append(String.format(locale, "\tDetermined least recently used %d sequence numbers in %dms\n", Integer.valueOf(iE), Long.valueOf(jCurrentTimeMillis3 - jCurrentTimeMillis2)));
            n9.v.a("LruGarbageCollector", ((sb2.toString() + String.format(locale, "\tRemoved %d targets in %dms\n", Integer.valueOf(iK), Long.valueOf(jCurrentTimeMillis4 - jCurrentTimeMillis3))) + String.format(locale, "\tRemoved %d documents in %dms\n", Integer.valueOf(iJ), Long.valueOf(jCurrentTimeMillis5 - jCurrentTimeMillis4))) + String.format(locale, "Total Duration: %dms", Long.valueOf(jCurrentTimeMillis5 - jCurrentTimeMillis)), new Object[0]);
        }
        return new c(true, iE, iK, iJ);
    }
}
