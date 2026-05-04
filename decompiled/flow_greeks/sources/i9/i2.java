package i9;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import g9.a1;
import g9.k;
import g9.p;
import i9.e3;
import i9.m;
import i9.w0;
import j9.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i2 implements m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f11965k = "i2";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte[] f11966l = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f11967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f11968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f11970d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w0.a f11971e = new w0.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f11972f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Queue f11973g = new PriorityQueue(10, new Comparator() { // from class: i9.a2
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return i2.s((j9.p) obj, (j9.p) obj2);
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f11974h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11975i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f11976j = -1;

    public i2(e3 e3Var, p pVar, e9.j jVar) {
        this.f11967a = e3Var;
        this.f11968b = pVar;
        this.f11969c = jVar.b() ? jVar.a() : "";
    }

    public static /* synthetic */ void q(i2 i2Var, Map map, Cursor cursor) {
        i2Var.getClass();
        try {
            int i10 = cursor.getInt(0);
            i2Var.O(j9.p.b(i10, cursor.getString(1), i2Var.f11968b.c(za.a.g0(cursor.getBlob(2))), map.containsKey(Integer.valueOf(i10)) ? (p.b) map.get(Integer.valueOf(i10)) : j9.p.f14248a));
        } catch (com.google.protobuf.d0 e10) {
            throw n9.b.a("Failed to decode index: " + e10, new Object[0]);
        }
    }

    public static /* synthetic */ int s(j9.p pVar, j9.p pVar2) {
        int iCompare = Long.compare(pVar.g().d(), pVar2.g().d());
        return iCompare == 0 ? pVar.d().compareTo(pVar2.d()) : iCompare;
    }

    public final byte[] A(j9.p pVar, j9.h hVar) {
        h9.d dVar = new h9.d();
        for (p.c cVar : pVar.e()) {
            bb.d0 d0VarH = hVar.h(cVar.c());
            if (d0VarH == null) {
                return null;
            }
            h9.c.f11244a.e(d0VarH, dVar.b(cVar.h()));
        }
        return dVar.c();
    }

    public final byte[] B(j9.p pVar) {
        return this.f11968b.l(pVar.h()).i();
    }

    public final byte[] C(bb.d0 d0Var) {
        h9.d dVar = new h9.d();
        h9.c.f11244a.e(d0Var, dVar.b(p.c.a.ASCENDING));
        return dVar.c();
    }

    public final Object[] D(j9.p pVar, g9.g1 g1Var, Collection collection) {
        if (collection == null) {
            return null;
        }
        List<h9.d> arrayList = new ArrayList();
        arrayList.add(new h9.d());
        Iterator it = collection.iterator();
        for (p.c cVar : pVar.e()) {
            bb.d0 d0Var = (bb.d0) it.next();
            for (h9.d dVar : arrayList) {
                if (N(g1Var, cVar.c()) && j9.y.u(d0Var)) {
                    arrayList = E(arrayList, cVar, d0Var);
                } else {
                    h9.c.f11244a.e(d0Var, dVar.b(cVar.h()));
                }
            }
        }
        return H(arrayList);
    }

    public final List E(List list, p.c cVar, bb.d0 d0Var) {
        ArrayList<h9.d> arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList();
        for (bb.d0 d0Var2 : d0Var.l0().h()) {
            for (h9.d dVar : arrayList) {
                h9.d dVar2 = new h9.d();
                dVar2.d(dVar.c());
                h9.c.f11244a.e(d0Var2, dVar2.b(cVar.h()));
                arrayList2.add(dVar2);
            }
        }
        return arrayList2;
    }

    public final Object[] F(int i10, int i11, List list, Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size = i10 / (list != null ? list.size() : 1);
        int i12 = 0;
        Object[] objArr4 = new Object[(i10 * 5) + (objArr3 != null ? objArr3.length : 0)];
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            objArr4[i13] = Integer.valueOf(i11);
            int i15 = i13 + 2;
            objArr4[i13 + 1] = this.f11969c;
            int i16 = i13 + 3;
            objArr4[i15] = list != null ? C((bb.d0) list.get(i14 / size)) : f11966l;
            int i17 = i13 + 4;
            int i18 = i14 % size;
            objArr4[i16] = objArr[i18];
            i13 += 5;
            objArr4[i17] = objArr2[i18];
        }
        if (objArr3 != null) {
            int length = objArr3.length;
            while (i12 < length) {
                objArr4[i13] = objArr3[i12];
                i12++;
                i13++;
            }
        }
        return objArr4;
    }

    public final Object[] G(g9.g1 g1Var, int i10, List list, Object[] objArr, String str, Object[] objArr2, String str2, Object[] objArr3) {
        int i11;
        StringBuilder sb2;
        List list2;
        int size = (list != null ? list.size() : 1) * Math.max(objArr.length, objArr2.length);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("SELECT document_key, directional_value FROM index_entries ");
        sb3.append("WHERE index_id = ? AND uid = ? ");
        sb3.append("AND array_value = ? ");
        sb3.append("AND directional_value ");
        sb3.append(str);
        sb3.append(" ? ");
        sb3.append("AND directional_value ");
        sb3.append(str2);
        sb3.append(" ? ");
        CharSequence charSequenceU = n9.g0.u(sb3, size, " UNION ");
        if (objArr3 != null) {
            StringBuilder sb4 = new StringBuilder("SELECT document_key, directional_value FROM (");
            sb4.append(charSequenceU);
            sb4.append(") WHERE directional_value NOT IN (");
            sb4.append((CharSequence) n9.g0.u("?", objArr3.length, ", "));
            sb4.append(")");
            list2 = list;
            i11 = size;
            sb2 = sb4;
        } else {
            i11 = size;
            sb2 = charSequenceU;
            list2 = list;
        }
        Object[] objArrF = F(i11, i10, list2, objArr, objArr2, objArr3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(sb2.toString());
        arrayList.addAll(Arrays.asList(objArrF));
        return arrayList.toArray();
    }

    public final Object[] H(List list) {
        Object[] objArr = new Object[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            objArr[i10] = ((h9.d) list.get(i10)).c();
        }
        return objArr;
    }

    public final SortedSet I(final j9.k kVar, final j9.p pVar) {
        final TreeSet treeSet = new TreeSet();
        this.f11967a.D("SELECT array_value, directional_value FROM index_entries WHERE index_id = ? AND document_key = ? AND uid = ?").b(Integer.valueOf(pVar.f()), kVar.toString(), this.f11969c).e(new n9.n() { // from class: i9.f2
            @Override // n9.n
            public final void accept(Object obj) {
                Cursor cursor = (Cursor) obj;
                treeSet.add(h9.e.b(pVar.f(), kVar, cursor.getBlob(0), cursor.getBlob(1)));
            }
        });
        return treeSet;
    }

    public final j9.p J(g9.g1 g1Var) {
        n9.b.d(this.f11974h, "IndexManager not started", new Object[0]);
        j9.x xVar = new j9.x(g1Var);
        Collection<j9.p> collectionK = K(g1Var.d() != null ? g1Var.d() : g1Var.n().m());
        j9.p pVar = null;
        if (collectionK.isEmpty()) {
            return null;
        }
        for (j9.p pVar2 : collectionK) {
            if (xVar.g(pVar2) && (pVar == null || pVar2.h().size() > pVar.h().size())) {
                pVar = pVar2;
            }
        }
        return pVar;
    }

    public Collection K(String str) {
        n9.b.d(this.f11974h, "IndexManager not started", new Object[0]);
        Map map = (Map) this.f11972f.get(str);
        return map == null ? Collections.EMPTY_LIST : map.values();
    }

    public final p.a L(Collection collection) {
        n9.b.d(!collection.isEmpty(), "Found empty index group when looking for least recent index offset.", new Object[0]);
        Iterator it = collection.iterator();
        p.a aVarC = ((j9.p) it.next()).g().c();
        int iL = aVarC.l();
        while (it.hasNext()) {
            p.a aVarC2 = ((j9.p) it.next()).g().c();
            if (aVarC2.compareTo(aVarC) < 0) {
                aVarC = aVarC2;
            }
            iL = Math.max(aVarC2.l(), iL);
        }
        return p.a.c(aVarC.m(), aVarC.k(), iL);
    }

    public final List M(g9.g1 g1Var) {
        if (this.f11970d.containsKey(g1Var)) {
            return (List) this.f11970d.get(g1Var);
        }
        ArrayList arrayList = new ArrayList();
        if (g1Var.h().isEmpty()) {
            arrayList.add(g1Var);
        } else {
            Iterator it = n9.w.i(new g9.k(g1Var.h(), k.a.AND)).iterator();
            while (it.hasNext()) {
                arrayList.add(new g9.g1(g1Var.n(), g1Var.d(), ((g9.q) it.next()).b(), g1Var.m(), g1Var.j(), g1Var.p(), g1Var.f()));
            }
        }
        this.f11970d.put(g1Var, arrayList);
        return arrayList;
    }

    public final boolean N(g9.g1 g1Var, j9.q qVar) {
        for (g9.q qVar2 : g1Var.h()) {
            if (qVar2 instanceof g9.p) {
                g9.p pVar = (g9.p) qVar2;
                if (pVar.f().equals(qVar)) {
                    p.b bVarG = pVar.g();
                    if (bVarG.equals(p.b.IN) || bVarG.equals(p.b.NOT_IN)) {
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    public final void O(j9.p pVar) {
        Map map = (Map) this.f11972f.get(pVar.d());
        if (map == null) {
            map = new HashMap();
            this.f11972f.put(pVar.d(), map);
        }
        j9.p pVar2 = (j9.p) map.get(Integer.valueOf(pVar.f()));
        if (pVar2 != null) {
            this.f11973g.remove(pVar2);
        }
        map.put(Integer.valueOf(pVar.f()), pVar);
        this.f11973g.add(pVar);
        this.f11975i = Math.max(this.f11975i, pVar.f());
        this.f11976j = Math.max(this.f11976j, pVar.g().d());
    }

    public final void P(final j9.h hVar, SortedSet sortedSet, SortedSet sortedSet2) {
        n9.v.a(f11965k, "Updating index entries for document '%s'", hVar.getKey());
        n9.g0.r(sortedSet, sortedSet2, new n9.n() { // from class: i9.d2
            @Override // n9.n
            public final void accept(Object obj) {
                this.f11897a.w(hVar, (h9.e) obj);
            }
        }, new n9.n() { // from class: i9.e2
            @Override // n9.n
            public final void accept(Object obj) {
                this.f11907a.y(hVar, (h9.e) obj);
            }
        });
    }

    @Override // i9.m
    public m.a a(g9.g1 g1Var) {
        m.a aVar = m.a.FULL;
        List listM = M(g1Var);
        Iterator it = listM.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            g9.g1 g1Var2 = (g9.g1) it.next();
            j9.p pVarJ = J(g1Var2);
            if (pVarJ == null) {
                aVar = m.a.NONE;
                break;
            }
            if (pVarJ.h().size() < g1Var2.o()) {
                aVar = m.a.PARTIAL;
            }
        }
        return (g1Var.r() && listM.size() > 1 && aVar == m.a.FULL) ? m.a.PARTIAL : aVar;
    }

    @Override // i9.m
    public void b(j9.p pVar) {
        n9.b.d(this.f11974h, "IndexManager not started", new Object[0]);
        int i10 = this.f11975i + 1;
        j9.p pVarB = j9.p.b(i10, pVar.d(), pVar.h(), pVar.g());
        this.f11967a.w("INSERT INTO index_configuration (index_id, collection_group, index_proto) VALUES(?, ?, ?)", Integer.valueOf(i10), pVarB.d(), B(pVarB));
        O(pVarB);
    }

    @Override // i9.m
    public p.a c(g9.g1 g1Var) {
        ArrayList arrayList = new ArrayList();
        Iterator it = M(g1Var).iterator();
        while (it.hasNext()) {
            j9.p pVarJ = J((g9.g1) it.next());
            if (pVarJ != null) {
                arrayList.add(pVarJ);
            }
        }
        return L(arrayList);
    }

    @Override // i9.m
    public void d(j9.p pVar) {
        this.f11967a.w("DELETE FROM index_configuration WHERE index_id = ?", Integer.valueOf(pVar.f()));
        this.f11967a.w("DELETE FROM index_entries WHERE index_id = ?", Integer.valueOf(pVar.f()));
        this.f11967a.w("DELETE FROM index_state WHERE index_id = ?", Integer.valueOf(pVar.f()));
        this.f11973g.remove(pVar);
        Map map = (Map) this.f11972f.get(pVar.d());
        if (map != null) {
            map.remove(Integer.valueOf(pVar.f()));
        }
    }

    @Override // i9.m
    public Collection e() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f11972f.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(((Map) it.next()).values());
        }
        return arrayList;
    }

    @Override // i9.m
    public String f() {
        n9.b.d(this.f11974h, "IndexManager not started", new Object[0]);
        j9.p pVar = (j9.p) this.f11973g.peek();
        if (pVar != null) {
            return pVar.d();
        }
        return null;
    }

    @Override // i9.m
    public List g(String str) {
        n9.b.d(this.f11974h, "IndexManager not started", new Object[0]);
        final ArrayList arrayList = new ArrayList();
        this.f11967a.D("SELECT parent FROM collection_parents WHERE collection_id = ?").b(str).e(new n9.n() { // from class: i9.b2
            @Override // n9.n
            public final void accept(Object obj) {
                arrayList.add(f.b(((Cursor) obj).getString(0)));
            }
        });
        return arrayList;
    }

    @Override // i9.m
    public void h(g8.c cVar) {
        n9.b.d(this.f11974h, "IndexManager not started", new Object[0]);
        Iterator it = cVar.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            for (j9.p pVar : K(((j9.k) entry.getKey()).m())) {
                SortedSet sortedSetI = I((j9.k) entry.getKey(), pVar);
                SortedSet sortedSetX = x((j9.h) entry.getValue(), pVar);
                if (!sortedSetI.equals(sortedSetX)) {
                    P((j9.h) entry.getValue(), sortedSetI, sortedSetX);
                }
            }
        }
    }

    @Override // i9.m
    public void i() {
        this.f11967a.w("DELETE FROM index_configuration", new Object[0]);
        this.f11967a.w("DELETE FROM index_entries", new Object[0]);
        this.f11967a.w("DELETE FROM index_state", new Object[0]);
        this.f11973g.clear();
        this.f11972f.clear();
    }

    @Override // i9.m
    public void j(String str, p.a aVar) {
        n9.b.d(this.f11974h, "IndexManager not started", new Object[0]);
        this.f11976j++;
        for (j9.p pVar : K(str)) {
            j9.p pVarB = j9.p.b(pVar.f(), pVar.d(), pVar.h(), p.b.a(this.f11976j, aVar));
            this.f11967a.w("REPLACE INTO index_state (index_id, uid,  sequence_number, read_time_seconds, read_time_nanos, document_key, largest_batch_id) VALUES(?, ?, ?, ?, ?, ?, ?)", Integer.valueOf(pVar.f()), this.f11969c, Long.valueOf(this.f11976j), Long.valueOf(aVar.m().b().h()), Integer.valueOf(aVar.m().b().b()), f.c(aVar.k().s()), Integer.valueOf(aVar.l()));
            O(pVarB);
        }
    }

    @Override // i9.m
    public p.a k(String str) {
        Collection collectionK = K(str);
        n9.b.d(!collectionK.isEmpty(), "minOffset was called for collection without indexes", new Object[0]);
        return L(collectionK);
    }

    @Override // i9.m
    public void l(j9.t tVar) {
        n9.b.d(this.f11974h, "IndexManager not started", new Object[0]);
        n9.b.d(tVar.u() % 2 == 1, "Expected a collection path.", new Object[0]);
        if (this.f11971e.a(tVar)) {
            this.f11967a.w("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)", tVar.m(), f.c((j9.t) tVar.w()));
        }
    }

    @Override // i9.m
    public List m(g9.g1 g1Var) {
        n9.b.d(this.f11974h, "IndexManager not started", new Object[0]);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (g9.g1 g1Var2 : M(g1Var)) {
            j9.p pVarJ = J(g1Var2);
            if (pVarJ == null) {
                return null;
            }
            arrayList3.add(Pair.create(g1Var2, pVarJ));
        }
        Iterator it = arrayList3.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Pair pair = (Pair) it.next();
            g9.g1 g1Var3 = (g9.g1) pair.first;
            j9.p pVar = (j9.p) pair.second;
            List listA = g1Var3.a(pVar);
            Collection collectionL = g1Var3.l(pVar);
            g9.i iVarK = g1Var3.k(pVar);
            g9.i iVarQ = g1Var3.q(pVar);
            if (n9.v.c()) {
                n9.v.a(f11965k, "Using index '%s' to execute '%s' (Arrays: %s, Lower bound: %s, Upper bound: %s)", pVar, g1Var3, listA, iVarK, iVarQ);
            }
            Object[] objArrG = G(g1Var3, pVar.f(), listA, z(pVar, g1Var3, iVarK), iVarK.c() ? ">=" : ">", z(pVar, g1Var3, iVarQ), iVarQ.c() ? "<=" : "<", D(pVar, g1Var3, collectionL));
            arrayList.add(String.valueOf(objArrG[0]));
            arrayList2.addAll(Arrays.asList(objArrG).subList(1, objArrG.length));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(TextUtils.join(" UNION ", arrayList));
        sb2.append("ORDER BY directional_value, document_key ");
        sb2.append(g1Var.i().equals(a1.a.ASCENDING) ? "asc " : "desc ");
        String str = "SELECT DISTINCT document_key FROM (" + sb2.toString() + ")";
        if (g1Var.r()) {
            str = str + " LIMIT " + g1Var.j();
        }
        n9.b.d(arrayList2.size() < 1000, "Cannot perform query with more than 999 bind elements", new Object[0]);
        e3.d dVarB = this.f11967a.D(str).b(arrayList2.toArray());
        final ArrayList arrayList4 = new ArrayList();
        dVarB.e(new n9.n() { // from class: i9.c2
            @Override // n9.n
            public final void accept(Object obj) {
                arrayList4.add(j9.k.k(j9.t.B(((Cursor) obj).getString(0))));
            }
        });
        n9.v.a(f11965k, "Index scan returned %s documents", Integer.valueOf(arrayList4.size()));
        return arrayList4;
    }

    @Override // i9.m
    public void n(g9.g1 g1Var) {
        n9.b.d(this.f11974h, "IndexManager not started", new Object[0]);
        for (g9.g1 g1Var2 : M(g1Var)) {
            m.a aVarA = a(g1Var2);
            if (aVarA == m.a.NONE || aVarA == m.a.PARTIAL) {
                j9.p pVarB = new j9.x(g1Var2).b();
                if (pVarB != null) {
                    b(pVarB);
                }
            }
        }
    }

    @Override // i9.m
    public void start() {
        final HashMap map = new HashMap();
        this.f11967a.D("SELECT index_id, sequence_number, read_time_seconds, read_time_nanos, document_key, largest_batch_id FROM index_state WHERE uid = ?").b(this.f11969c).e(new n9.n() { // from class: i9.g2
            @Override // n9.n
            public final void accept(Object obj) {
                Cursor cursor = (Cursor) obj;
                map.put(Integer.valueOf(cursor.getInt(0)), p.b.b(cursor.getLong(1), new j9.v(new a7.s(cursor.getLong(2), cursor.getInt(3))), j9.k.k(f.b(cursor.getString(4))), cursor.getInt(5)));
            }
        });
        this.f11967a.D("SELECT index_id, collection_group, index_proto FROM index_configuration").e(new n9.n() { // from class: i9.h2
            @Override // n9.n
            public final void accept(Object obj) {
                i2.q(this.f11954a, map, (Cursor) obj);
            }
        });
        this.f11974h = true;
    }

    public final void w(j9.h hVar, h9.e eVar) {
        this.f11967a.w("INSERT INTO index_entries (index_id, uid, array_value, directional_value, document_key) VALUES(?, ?, ?, ?, ?)", Integer.valueOf(eVar.k()), this.f11969c, eVar.c(), eVar.h(), hVar.getKey().toString());
    }

    public final SortedSet x(j9.h hVar, j9.p pVar) {
        TreeSet treeSet = new TreeSet();
        byte[] bArrA = A(pVar, hVar);
        if (bArrA != null) {
            p.c cVarC = pVar.c();
            if (cVarC == null) {
                treeSet.add(h9.e.b(pVar.f(), hVar.getKey(), new byte[0], bArrA));
                return treeSet;
            }
            bb.d0 d0VarH = hVar.h(cVarC.c());
            if (j9.y.u(d0VarH)) {
                Iterator it = d0VarH.l0().h().iterator();
                while (it.hasNext()) {
                    treeSet.add(h9.e.b(pVar.f(), hVar.getKey(), C((bb.d0) it.next()), bArrA));
                }
            }
        }
        return treeSet;
    }

    public final void y(j9.h hVar, h9.e eVar) {
        this.f11967a.w("DELETE FROM index_entries WHERE index_id = ? AND uid = ? AND array_value = ? AND directional_value = ? AND document_key = ?", Integer.valueOf(eVar.k()), this.f11969c, eVar.c(), eVar.h(), hVar.getKey().toString());
    }

    public final Object[] z(j9.p pVar, g9.g1 g1Var, g9.i iVar) {
        return D(pVar, g1Var, iVar.b());
    }
}
