package i9;

import android.database.Cursor;
import com.google.android.gms.common.api.a;
import i9.e3;
import j9.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k3 implements o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f12033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f12034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f12035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f12036d = new c();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b {
        NO_DOCUMENT(1),
        FOUND_DOCUMENT(2),
        UNKNOWN_DOCUMENT(3),
        INVALID_DOCUMENT(4);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12042a;

        b(int i10) {
            this.f12042a = i10;
        }

        public static b b(j9.r rVar) {
            if (rVar.i()) {
                return NO_DOCUMENT;
            }
            if (rVar.b()) {
                return FOUND_DOCUMENT;
            }
            if (rVar.j()) {
                return UNKNOWN_DOCUMENT;
            }
            n9.b.d(!rVar.o(), "MutableDocument has an unknown type", new Object[0]);
            return INVALID_DOCUMENT;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap f12043a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f12044a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f12045b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f12046c;

            public a(String str, int i10, int i11) {
                this.f12044a = str;
                this.f12045b = i10;
                this.f12046c = i11;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return this.f12045b == aVar.f12045b && this.f12046c == aVar.f12046c && Objects.equals(this.f12044a, aVar.f12044a);
            }

            public int hashCode() {
                return Objects.hash(this.f12044a, Integer.valueOf(this.f12045b), Integer.valueOf(this.f12046c));
            }

            public String toString() {
                return "DocumentTypeBackfiller.BackfillKey(path=" + this.f12044a + ", readTimeSeconds=" + this.f12045b + ", readTimeNanos=" + this.f12046c + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f12047a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Object[] f12048b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f12049c;

            public b(String str, Object[] objArr, int i10) {
                this.f12047a = str;
                this.f12048b = objArr;
                this.f12049c = i10;
            }
        }

        public c() {
            this.f12043a = new ConcurrentHashMap();
        }

        public void a(e3 e3Var) {
            while (true) {
                b bVarB = b();
                if (bVarB == null) {
                    return;
                } else {
                    e3Var.w(bVarB.f12047a, bVarB.f12048b);
                }
            }
        }

        public b b() {
            if (this.f12043a.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            Iterator it = this.f12043a.keySet().iterator();
            int i10 = 0;
            while (it.hasNext() && arrayList.size() < 900) {
                a aVar = (a) it.next();
                b bVar = (b) this.f12043a.remove(aVar);
                if (bVar != null) {
                    i10++;
                    arrayList.add(aVar.f12044a);
                    int size = arrayList.size();
                    arrayList.add(Integer.valueOf(aVar.f12045b));
                    int size2 = arrayList.size();
                    arrayList.add(Integer.valueOf(aVar.f12046c));
                    int size3 = arrayList.size();
                    arrayList.add(Integer.valueOf(bVar.f12042a));
                    int size4 = arrayList.size();
                    sb2.append(" WHEN path=?");
                    sb2.append(size);
                    sb2.append(" AND read_time_seconds=?");
                    sb2.append(size2);
                    sb2.append(" AND read_time_nanos=?");
                    sb2.append(size3);
                    sb2.append(" THEN ?");
                    sb2.append(size4);
                    if (sb3.length() > 0) {
                        sb3.append(" OR");
                    }
                    sb3.append(" (path=?");
                    sb3.append(size);
                    sb3.append(" AND read_time_seconds=?");
                    sb3.append(size2);
                    sb3.append(" AND read_time_nanos=?");
                    sb3.append(size3);
                    sb3.append(')');
                }
            }
            if (i10 == 0) {
                return null;
            }
            return new b("UPDATE remote_documents SET document_type = CASE" + ((Object) sb2) + " ELSE NULL END WHERE" + ((Object) sb3), arrayList.toArray(), i10);
        }

        public void c(String str, int i10, int i11, j9.r rVar) {
            this.f12043a.putIfAbsent(new a(str, i10, i11), b.b(rVar));
        }
    }

    public k3(e3 e3Var, p pVar) {
        this.f12033a = e3Var;
        this.f12034b = pVar;
    }

    public static /* synthetic */ void h(k3 k3Var, byte[] bArr, int i10, int i11, boolean z10, String str, n9.t tVar, Map map) {
        j9.r rVarK = k3Var.k(bArr, i10, i11);
        if (z10) {
            k3Var.f12036d.c(str, i10, i11, rVarK);
        }
        if (tVar == null || ((Boolean) tVar.apply(rVarK)).booleanValue()) {
            synchronized (map) {
                map.put(rVarK.getKey(), rVarK);
            }
        }
    }

    public static /* synthetic */ void i(k3 k3Var, n9.m mVar, Map map, n9.t tVar, i1 i1Var, Cursor cursor) {
        k3Var.n(mVar, map, cursor, tVar);
        if (i1Var != null) {
            i1Var.b();
        }
    }

    @Override // i9.o1
    public Map a(final g9.b1 b1Var, p.a aVar, final Set set, i1 i1Var) {
        return l(Collections.singletonList(b1Var.n()), aVar, a.e.API_PRIORITY_OTHER, b.FOUND_DOCUMENT, new n9.t() { // from class: i9.h3
            @Override // n9.t
            public final Object apply(Object obj) {
                j9.r rVar = (j9.r) obj;
                return Boolean.valueOf(b1Var.u(rVar) || set.contains(rVar.getKey()));
            }
        }, i1Var);
    }

    @Override // i9.o1
    public Map b(Iterable iterable) {
        final HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            j9.k kVar = (j9.k) it.next();
            arrayList.add(f.c(kVar.s()));
            map.put(kVar, j9.r.q(kVar));
        }
        e3.b bVar = new e3.b(this.f12033a, "SELECT contents, read_time_seconds, read_time_nanos, document_type, path FROM remote_documents WHERE path IN (", arrayList, ") ORDER BY path");
        final n9.m mVar = new n9.m();
        while (bVar.d()) {
            bVar.e().e(new n9.n() { // from class: i9.g3
                @Override // n9.n
                public final void accept(Object obj) {
                    this.f11946a.n(mVar, map, (Cursor) obj, null);
                }
            });
        }
        mVar.b();
        this.f12036d.a(this.f12033a);
        synchronized (map) {
        }
        return map;
    }

    @Override // i9.o1
    public Map c(String str, p.a aVar, int i10) {
        List listG = this.f12035c.g(str);
        ArrayList arrayList = new ArrayList(listG.size());
        Iterator it = listG.iterator();
        while (it.hasNext()) {
            arrayList.add((j9.t) ((j9.t) it.next()).b(str));
        }
        if (arrayList.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        if (arrayList.size() * 9 < 900) {
            return m(arrayList, aVar, i10, null);
        }
        HashMap map = new HashMap();
        int i11 = 0;
        while (i11 < arrayList.size()) {
            int i12 = i11 + 100;
            map.putAll(m(arrayList.subList(i11, Math.min(arrayList.size(), i12)), aVar, i10, null));
            i11 = i12;
        }
        return n9.g0.t(map, i10, p.a.f14251b);
    }

    @Override // i9.o1
    public void d(j9.r rVar, j9.v vVar) {
        n9.b.d(!vVar.equals(j9.v.f14278b), "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
        j9.k key = rVar.getKey();
        a7.s sVarB = vVar.b();
        this.f12033a.w("INSERT OR REPLACE INTO remote_documents (path, path_length, read_time_seconds, read_time_nanos, document_type, contents) VALUES (?, ?, ?, ?, ?, ?)", f.c(key.s()), Integer.valueOf(key.s().u()), Long.valueOf(sVarB.h()), Integer.valueOf(sVarB.b()), Integer.valueOf(b.b(rVar).f12042a), this.f12034b.m(rVar).i());
        this.f12035c.l(rVar.getKey().o());
    }

    @Override // i9.o1
    public void e(m mVar) {
        this.f12035c = mVar;
    }

    @Override // i9.o1
    public j9.r f(j9.k kVar) {
        return (j9.r) b(Collections.singletonList(kVar)).get(kVar);
    }

    public final j9.r k(byte[] bArr, int i10, int i11) {
        try {
            return this.f12034b.d(l9.a.k0(bArr)).v(new j9.v(new a7.s(i10, i11)));
        } catch (com.google.protobuf.d0 e10) {
            throw n9.b.a("MaybeDocument failed to parse: %s", e10);
        }
    }

    public final Map l(List list, p.a aVar, int i10, b bVar, final n9.t tVar, final i1 i1Var) {
        a7.s sVarB = aVar.m().b();
        j9.k kVarK = aVar.k();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT contents, read_time_seconds, read_time_nanos, document_type, path FROM remote_documents WHERE path >= ? AND path < ? AND path_length = ? ");
        sb2.append(bVar == null ? "" : " AND (document_type IS NULL OR document_type = ?) ");
        sb2.append("AND (read_time_seconds > ? OR ( read_time_seconds = ? AND read_time_nanos > ?) OR ( read_time_seconds = ? AND read_time_nanos = ? and path > ?)) ");
        StringBuilder sbU = n9.g0.u(sb2.toString(), list.size(), " UNION ");
        sbU.append("ORDER BY read_time_seconds, read_time_nanos, path LIMIT ?");
        int i11 = 0;
        Object[] objArr = new Object[(((bVar != null ? 1 : 0) + 9) * list.size()) + 1];
        Iterator it = list.iterator();
        while (it.hasNext()) {
            j9.t tVar2 = (j9.t) it.next();
            String strC = f.c(tVar2);
            objArr[i11] = strC;
            objArr[i11 + 1] = f.f(strC);
            int i12 = i11 + 3;
            objArr[i11 + 2] = Integer.valueOf(tVar2.u() + 1);
            if (bVar != null) {
                objArr[i12] = Integer.valueOf(bVar.f12042a);
                i12 = i11 + 4;
            }
            objArr[i12] = Long.valueOf(sVarB.h());
            objArr[i12 + 1] = Long.valueOf(sVarB.h());
            objArr[i12 + 2] = Integer.valueOf(sVarB.b());
            objArr[i12 + 3] = Long.valueOf(sVarB.h());
            objArr[i12 + 4] = Integer.valueOf(sVarB.b());
            objArr[i12 + 5] = f.c(kVarK.s());
            i11 = i12 + 6;
        }
        objArr[i11] = Integer.valueOf(i10);
        final n9.m mVar = new n9.m();
        final HashMap map = new HashMap();
        this.f12033a.D(sbU.toString()).b(objArr).e(new n9.n() { // from class: i9.j3
            @Override // n9.n
            public final void accept(Object obj) {
                k3.i(this.f12001a, mVar, map, tVar, i1Var, (Cursor) obj);
            }
        });
        mVar.b();
        this.f12036d.a(this.f12033a);
        synchronized (map) {
        }
        return map;
    }

    public final Map m(List list, p.a aVar, int i10, n9.t tVar) {
        return l(list, aVar, i10, null, tVar, null);
    }

    public final void n(n9.m mVar, final Map map, Cursor cursor, final n9.t tVar) {
        final byte[] blob = cursor.getBlob(0);
        final int i10 = cursor.getInt(1);
        final int i11 = cursor.getInt(2);
        final boolean zIsNull = cursor.isNull(3);
        final String string = cursor.getString(4);
        Runnable runnable = new Runnable() { // from class: i9.i3
            @Override // java.lang.Runnable
            public final void run() {
                k3.h(this.f11977a, blob, i10, i11, zIsNull, string, tVar, map);
            }
        };
        if (cursor.isFirst() && cursor.isLast()) {
            runnable.run();
        } else {
            mVar.c(runnable);
        }
    }

    @Override // i9.o1
    public void removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        g8.c cVarA = j9.i.a();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            j9.k kVar = (j9.k) it.next();
            arrayList.add(f.c(kVar.s()));
            cVarA = cVarA.q(kVar, j9.r.r(kVar, j9.v.f14278b));
        }
        e3.b bVar = new e3.b(this.f12033a, "DELETE FROM remote_documents WHERE path IN (", arrayList, ")");
        while (bVar.d()) {
            bVar.a();
        }
        this.f12035c.h(cVarA);
    }
}
