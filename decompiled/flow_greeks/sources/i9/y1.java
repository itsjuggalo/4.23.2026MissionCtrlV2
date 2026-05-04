package i9;

import android.database.Cursor;
import i9.e3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class y1 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f12225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f12226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12227c;

    public y1(e3 e3Var, p pVar, e9.j jVar) {
        this.f12225a = e3Var;
        this.f12226b = pVar;
        this.f12227c = jVar.b() ? jVar.a() : "";
    }

    public static /* synthetic */ void g(y1 y1Var, byte[] bArr, int i10, Map map) {
        k9.k kVarM = y1Var.m(bArr, i10);
        synchronized (map) {
            map.put(kVarM.b(), kVarM);
        }
    }

    public static /* synthetic */ k9.k i(y1 y1Var, Cursor cursor) {
        y1Var.getClass();
        return y1Var.m(cursor.getBlob(0), cursor.getInt(1));
    }

    public static /* synthetic */ void k(y1 y1Var, int[] iArr, String[] strArr, String[] strArr2, n9.m mVar, Map map, Cursor cursor) {
        y1Var.getClass();
        iArr[0] = cursor.getInt(1);
        strArr[0] = cursor.getString(2);
        strArr2[0] = cursor.getString(3);
        y1Var.n(mVar, map, cursor);
    }

    @Override // i9.b
    public Map a(SortedSet sortedSet) {
        n9.b.d(sortedSet.comparator() == null, "getOverlays() requires natural order", new Object[0]);
        HashMap map = new HashMap();
        n9.m mVar = new n9.m();
        j9.t tVarO = j9.t.f14277b;
        ArrayList arrayList = new ArrayList();
        Iterator it = sortedSet.iterator();
        while (it.hasNext()) {
            j9.k kVar = (j9.k) it.next();
            if (!tVarO.equals(kVar.o())) {
                o(map, mVar, tVarO, arrayList);
                tVarO = kVar.o();
                arrayList.clear();
            }
            arrayList.add(kVar.q());
        }
        o(map, mVar, tVarO, arrayList);
        mVar.b();
        return map;
    }

    @Override // i9.b
    public k9.k b(j9.k kVar) {
        return (k9.k) this.f12225a.D("SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_path = ? AND document_id = ?").b(this.f12227c, f.c((j9.t) kVar.s().w()), kVar.s().m()).d(new n9.t() { // from class: i9.t1
            @Override // n9.t
            public final Object apply(Object obj) {
                return y1.i(this.f12163a, (Cursor) obj);
            }
        });
    }

    @Override // i9.b
    public Map c(j9.t tVar, int i10) {
        final HashMap map = new HashMap();
        final n9.m mVar = new n9.m();
        this.f12225a.D("SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_path = ? AND largest_batch_id > ?").b(this.f12227c, f.c(tVar), Integer.valueOf(i10)).e(new n9.n() { // from class: i9.s1
            @Override // n9.n
            public final void accept(Object obj) {
                this.f12154a.n(mVar, map, (Cursor) obj);
            }
        });
        mVar.b();
        return map;
    }

    @Override // i9.b
    public void d(int i10) {
        this.f12225a.w("DELETE FROM document_overlays WHERE uid = ? AND largest_batch_id = ?", this.f12227c, Integer.valueOf(i10));
    }

    @Override // i9.b
    public void e(int i10, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            j9.k kVar = (j9.k) entry.getKey();
            p(i10, kVar, (k9.f) n9.x.d((k9.f) entry.getValue(), "null value for key: %s", kVar));
        }
    }

    @Override // i9.b
    public Map f(String str, int i10, int i11) {
        final HashMap map = new HashMap();
        final String[] strArr = new String[1];
        final String[] strArr2 = new String[1];
        final int[] iArr = new int[1];
        final n9.m mVar = new n9.m();
        this.f12225a.D("SELECT overlay_mutation, largest_batch_id, collection_path, document_id  FROM document_overlays WHERE uid = ? AND collection_group = ? AND largest_batch_id > ? ORDER BY largest_batch_id, collection_path, document_id LIMIT ?").b(this.f12227c, str, Integer.valueOf(i10), Integer.valueOf(i11)).e(new n9.n() { // from class: i9.w1
            @Override // n9.n
            public final void accept(Object obj) {
                y1.k(this.f12191a, iArr, strArr, strArr2, mVar, map, (Cursor) obj);
            }
        });
        if (strArr[0] == null) {
            return map;
        }
        e3.d dVarD = this.f12225a.D("SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_group = ? AND (collection_path > ? OR (collection_path = ? AND document_id > ?)) AND largest_batch_id = ?");
        String str2 = this.f12227c;
        String str3 = strArr[0];
        dVarD.b(str2, str, str3, str3, strArr2[0], Integer.valueOf(iArr[0])).e(new n9.n() { // from class: i9.x1
            @Override // n9.n
            public final void accept(Object obj) {
                this.f12204a.n(mVar, map, (Cursor) obj);
            }
        });
        mVar.b();
        return map;
    }

    public final k9.k m(byte[] bArr, int i10) {
        try {
            return k9.k.a(i10, this.f12226b.e(bb.e0.w0(bArr)));
        } catch (com.google.protobuf.d0 e10) {
            throw n9.b.a("Overlay failed to parse: %s", e10);
        }
    }

    public final void n(n9.m mVar, final Map map, Cursor cursor) {
        final byte[] blob = cursor.getBlob(0);
        final int i10 = cursor.getInt(1);
        Runnable runnable = new Runnable() { // from class: i9.v1
            @Override // java.lang.Runnable
            public final void run() {
                y1.g(this.f12180a, blob, i10, map);
            }
        };
        if (cursor.isFirst() && cursor.isLast()) {
            runnable.run();
        } else {
            mVar.c(runnable);
        }
    }

    public final void o(final Map map, final n9.m mVar, j9.t tVar, List list) {
        if (list.isEmpty()) {
            return;
        }
        e3.b bVar = new e3.b(this.f12225a, "SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_path = ? AND document_id IN (", Arrays.asList(this.f12227c, f.c(tVar)), list, ")");
        while (bVar.d()) {
            bVar.e().e(new n9.n() { // from class: i9.u1
                @Override // n9.n
                public final void accept(Object obj) {
                    this.f12171a.n(mVar, map, (Cursor) obj);
                }
            });
        }
    }

    public final void p(int i10, j9.k kVar, k9.f fVar) {
        this.f12225a.w("INSERT OR REPLACE INTO document_overlays (uid, collection_group, collection_path, document_id, largest_batch_id, overlay_mutation) VALUES (?, ?, ?, ?, ?, ?)", this.f12227c, kVar.m(), f.c((j9.t) kVar.s().w()), kVar.s().m(), Integer.valueOf(i10), this.f12226b.n(fVar).i());
    }
}
