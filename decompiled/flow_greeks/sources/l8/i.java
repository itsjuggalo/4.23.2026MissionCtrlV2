package l8;

import j8.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m8.d;
import m8.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m8.i f15559f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final m8.i f15560g = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final m8.i f15561h = new c();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final m8.i f15562i = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m8.d f15563a = new m8.d(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l8.f f15564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q8.c f15565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m8.a f15566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f15567e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements m8.i {
        @Override // m8.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(Map map) {
            h hVar = (h) map.get(o8.h.f17629i);
            return hVar != null && hVar.f15557d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements m8.i {
        @Override // m8.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(Map map) {
            h hVar = (h) map.get(o8.h.f17629i);
            return hVar != null && hVar.f15558e;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements m8.i {
        @Override // m8.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(h hVar) {
            return !hVar.f15558e;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements m8.i {
        @Override // m8.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(h hVar) {
            return !i.f15561h.a(hVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements d.c {
        public e() {
        }

        @Override // m8.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(l lVar, Map map, Void r32) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                h hVar = (h) ((Map.Entry) it.next()).getValue();
                if (!hVar.f15557d) {
                    i.this.s(hVar.b());
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(h hVar, h hVar2) {
            return m.b(hVar.f15556c, hVar2.f15556c);
        }
    }

    public i(l8.f fVar, q8.c cVar, m8.a aVar) {
        this.f15567e = 0L;
        this.f15564b = fVar;
        this.f15565c = cVar;
        this.f15566d = aVar;
        r();
        for (h hVar : fVar.s()) {
            this.f15567e = Math.max(hVar.f15554a + 1, this.f15567e);
            d(hVar);
        }
    }

    public static void c(o8.i iVar) {
        m.g(!iVar.g() || iVar.f(), "Can't have tracked non-default query that loads all data");
    }

    public static long e(l8.a aVar, long j10) {
        return j10 - Math.min((long) Math.floor(j10 * (1.0f - aVar.c())), aVar.b());
    }

    public static o8.i o(o8.i iVar) {
        return iVar.g() ? o8.i.a(iVar.e()) : iVar;
    }

    public final void d(h hVar) {
        c(hVar.f15555b);
        Map map = (Map) this.f15563a.q(hVar.f15555b.e());
        if (map == null) {
            map = new HashMap();
            this.f15563a = this.f15563a.A(hVar.f15555b.e(), map);
        }
        h hVar2 = (h) map.get(hVar.f15555b.d());
        m.f(hVar2 == null || hVar2.f15554a == hVar.f15554a);
        map.put(hVar.f15555b.d(), hVar);
    }

    public long f() {
        return k(f15561h).size();
    }

    public void g(l lVar) {
        h hVarB;
        if (m(lVar)) {
            return;
        }
        o8.i iVarA = o8.i.a(lVar);
        h hVarI = i(iVarA);
        if (hVarI == null) {
            long j10 = this.f15567e;
            this.f15567e = 1 + j10;
            hVarB = new h(j10, iVarA, this.f15566d.millis(), true, false);
        } else {
            m.g(!hVarI.f15557d, "This should have been handled above!");
            hVarB = hVarI.b();
        }
        s(hVarB);
    }

    public final Set h(l lVar) {
        HashSet hashSet = new HashSet();
        Map map = (Map) this.f15563a.q(lVar);
        if (map != null) {
            for (h hVar : map.values()) {
                if (!hVar.f15555b.g()) {
                    hashSet.add(Long.valueOf(hVar.f15554a));
                }
            }
        }
        return hashSet;
    }

    public h i(o8.i iVar) {
        o8.i iVarO = o(iVar);
        Map map = (Map) this.f15563a.q(iVarO.e());
        if (map != null) {
            return (h) map.get(iVarO.d());
        }
        return null;
    }

    public Set j(l lVar) {
        m.g(!n(o8.i.a(lVar)), "Path is fully complete.");
        HashSet hashSet = new HashSet();
        Set setH = h(lVar);
        if (!setH.isEmpty()) {
            hashSet.addAll(this.f15564b.m(setH));
        }
        for (Map.Entry entry : this.f15563a.K(lVar).s()) {
            r8.b bVar = (r8.b) entry.getKey();
            m8.d dVar = (m8.d) entry.getValue();
            if (dVar.getValue() != null && f15559f.a((Map) dVar.getValue())) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    public final List k(m8.i iVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f15563a.iterator();
        while (it.hasNext()) {
            for (h hVar : ((Map) ((Map.Entry) it.next()).getValue()).values()) {
                if (iVar.a(hVar)) {
                    arrayList.add(hVar);
                }
            }
        }
        return arrayList;
    }

    public boolean l(l lVar) {
        return this.f15563a.y(lVar, f15560g) != null;
    }

    public final boolean m(l lVar) {
        return this.f15563a.d(lVar, f15559f) != null;
    }

    public boolean n(o8.i iVar) {
        Map map;
        if (m(iVar.e())) {
            return true;
        }
        return !iVar.g() && (map = (Map) this.f15563a.q(iVar.e())) != null && map.containsKey(iVar.d()) && ((h) map.get(iVar.d())).f15557d;
    }

    public g p(l8.a aVar) {
        List listK = k(f15561h);
        long jE = e(aVar, listK.size());
        g gVar = new g();
        if (this.f15565c.f()) {
            this.f15565c.b("Pruning old queries.  Prunable: " + listK.size() + " Count to prune: " + jE, new Object[0]);
        }
        Collections.sort(listK, new f());
        for (int i10 = 0; i10 < jE; i10++) {
            h hVar = (h) listK.get(i10);
            gVar = gVar.d(hVar.f15555b.e());
            q(hVar.f15555b);
        }
        for (int i11 = (int) jE; i11 < listK.size(); i11++) {
            gVar = gVar.c(((h) listK.get(i11)).f15555b.e());
        }
        List listK2 = k(f15562i);
        if (this.f15565c.f()) {
            this.f15565c.b("Unprunable queries: " + listK2.size(), new Object[0]);
        }
        Iterator it = listK2.iterator();
        while (it.hasNext()) {
            gVar = gVar.c(((h) it.next()).f15555b.e());
        }
        return gVar;
    }

    public void q(o8.i iVar) {
        o8.i iVarO = o(iVar);
        h hVarI = i(iVarO);
        m.g(hVarI != null, "Query must exist to be removed.");
        this.f15564b.g(hVarI.f15554a);
        Map map = (Map) this.f15563a.q(iVarO.e());
        map.remove(iVarO.d());
        if (map.isEmpty()) {
            this.f15563a = this.f15563a.w(iVarO.e());
        }
    }

    public final void r() {
        try {
            this.f15564b.f();
            this.f15564b.o(this.f15566d.millis());
            this.f15564b.l();
        } finally {
            this.f15564b.n();
        }
    }

    public final void s(h hVar) {
        d(hVar);
        this.f15564b.i(hVar);
    }

    public void t(l lVar) {
        this.f15563a.K(lVar).p(new e());
    }

    public void u(o8.i iVar) {
        v(iVar, true);
    }

    public final void v(o8.i iVar, boolean z10) {
        h hVar;
        o8.i iVarO = o(iVar);
        h hVarI = i(iVarO);
        long jMillis = this.f15566d.millis();
        if (hVarI != null) {
            hVar = hVarI.c(jMillis).a(z10);
        } else {
            m.g(z10, "If we're setting the query to inactive, we should already be tracking it!");
            long j10 = this.f15567e;
            this.f15567e = 1 + j10;
            hVar = new h(j10, iVarO, jMillis, false, z10);
        }
        s(hVar);
    }

    public void w(o8.i iVar) {
        h hVarI = i(o(iVar));
        if (hVarI == null || hVarI.f15557d) {
            return;
        }
        s(hVarI.b());
    }

    public void x(o8.i iVar) {
        v(iVar, false);
    }
}
