package i9;

import i9.l;
import j9.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import n9.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f12058f = TimeUnit.SECONDS.toMillis(15);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f12059g = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f12060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h1 f12061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p6.s f12062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p6.s f12063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12064e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements l4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g.b f12065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n9.g f12066b;

        public a(n9.g gVar) {
            this.f12066b = gVar;
        }

        public static /* synthetic */ void a(a aVar) {
            n9.v.a("IndexBackfiller", "Documents written: %s", Integer.valueOf(l.this.d()));
            aVar.b(l.f12059g);
        }

        public final void b(long j10) {
            this.f12065a = this.f12066b.k(g.d.INDEX_BACKFILL, j10, new Runnable() { // from class: i9.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.a.a(this.f12008a);
                }
            });
        }

        @Override // i9.l4
        public void start() {
            b(l.f12058f);
        }

        @Override // i9.l4
        public void stop() {
            g.b bVar = this.f12065a;
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(h1 h1Var, n9.g gVar, final k0 k0Var) {
        this(h1Var, gVar, new p6.s() { // from class: i9.h
            @Override // p6.s
            public final Object get() {
                return k0Var.E();
            }
        }, new p6.s() { // from class: i9.i
            @Override // p6.s
            public final Object get() {
                return k0Var.I();
            }
        });
        Objects.requireNonNull(k0Var);
    }

    public int d() {
        return ((Integer) this.f12061b.k("Backfill Indexes", new n9.y() { // from class: i9.j
            @Override // n9.y
            public final Object get() {
                return Integer.valueOf(this.f11988a.h());
            }
        })).intValue();
    }

    public final p.a e(p.a aVar, n nVar) {
        Iterator it = nVar.c().iterator();
        p.a aVar2 = aVar;
        while (it.hasNext()) {
            p.a aVarI = p.a.i((j9.h) ((Map.Entry) it.next()).getValue());
            if (aVarI.compareTo(aVar2) > 0) {
                aVar2 = aVarI;
            }
        }
        return p.a.c(aVar2.m(), aVar2.k(), Math.max(nVar.b(), aVar.l()));
    }

    public a f() {
        return this.f12060a;
    }

    public final int g(String str, int i10) {
        m mVar = (m) this.f12062c.get();
        o oVar = (o) this.f12063d.get();
        p.a aVarK = mVar.k(str);
        n nVarK = oVar.k(str, aVarK, i10);
        mVar.h(nVarK.c());
        p.a aVarE = e(aVarK, nVarK);
        n9.v.a("IndexBackfiller", "Updating offset: %s", aVarE);
        mVar.j(str, aVarE);
        return nVarK.c().size();
    }

    public final int h() {
        m mVar = (m) this.f12062c.get();
        HashSet hashSet = new HashSet();
        int iG = this.f12064e;
        while (iG > 0) {
            String strF = mVar.f();
            if (strF == null || hashSet.contains(strF)) {
                break;
            }
            n9.v.a("IndexBackfiller", "Processing collection: %s", strF);
            iG -= g(strF, iG);
            hashSet.add(strF);
        }
        return this.f12064e - iG;
    }

    public l(h1 h1Var, n9.g gVar, p6.s sVar, p6.s sVar2) {
        this.f12064e = 50;
        this.f12061b = h1Var;
        this.f12060a = new a(gVar);
        this.f12062c = sVar;
        this.f12063d = sVar2;
    }
}
