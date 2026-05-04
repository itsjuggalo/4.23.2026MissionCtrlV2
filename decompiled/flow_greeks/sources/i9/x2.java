package i9;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import i9.e3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x2 implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f12207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f12208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f12209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.google.protobuf.i f12212f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements n9.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f12213a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12214b = true;

        public a(byte[] bArr) {
            c(bArr);
        }

        @Override // n9.n
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Cursor cursor) {
            byte[] blob = cursor.getBlob(0);
            c(blob);
            if (blob.length < 1000000) {
                this.f12214b = false;
            }
        }

        public final void c(byte[] bArr) {
            this.f12213a.add(com.google.protobuf.i.r(bArr));
        }

        public int d() {
            return this.f12213a.size();
        }

        public com.google.protobuf.i e() {
            return com.google.protobuf.i.q(this.f12213a);
        }
    }

    public x2(e3 e3Var, p pVar, e9.j jVar, m mVar) {
        this.f12207a = e3Var;
        this.f12208b = pVar;
        this.f12210d = jVar.b() ? jVar.a() : "";
        this.f12212f = m9.b1.f16123v;
        this.f12209c = mVar;
    }

    public static /* synthetic */ void m(x2 x2Var, Cursor cursor) {
        x2Var.getClass();
        x2Var.f12212f = com.google.protobuf.i.r(cursor.getBlob(0));
    }

    public static /* synthetic */ k9.g n(x2 x2Var, Cursor cursor) {
        x2Var.getClass();
        return x2Var.v(cursor.getInt(0), cursor.getBlob(1));
    }

    public static /* synthetic */ k9.g o(x2 x2Var, int i10, Cursor cursor) {
        x2Var.getClass();
        return x2Var.v(i10, cursor.getBlob(0));
    }

    public static /* synthetic */ void r(x2 x2Var, List list, Cursor cursor) {
        x2Var.getClass();
        list.add(x2Var.v(cursor.getInt(0), cursor.getBlob(1)));
    }

    public static /* synthetic */ void s(x2 x2Var, Set set, List list, Cursor cursor) {
        x2Var.getClass();
        int i10 = cursor.getInt(0);
        if (set.contains(Integer.valueOf(i10))) {
            return;
        }
        set.add(Integer.valueOf(i10));
        list.add(x2Var.v(i10, cursor.getBlob(1)));
    }

    @Override // i9.e1
    public k9.g a(a7.s sVar, List list, List list2) {
        int i10 = this.f12211e;
        this.f12211e = i10 + 1;
        k9.g gVar = new k9.g(i10, sVar, list, list2);
        this.f12207a.w("INSERT INTO mutations (uid, batch_id, mutations) VALUES (?, ?, ?)", this.f12210d, Integer.valueOf(i10), this.f12208b.o(gVar).i());
        HashSet hashSet = new HashSet();
        SQLiteStatement sQLiteStatementC = this.f12207a.C("INSERT INTO document_mutations (uid, path, batch_id) VALUES (?, ?, ?)");
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            j9.k kVarG = ((k9.f) it.next()).g();
            if (hashSet.add(kVarG)) {
                this.f12207a.v(sQLiteStatementC, this.f12210d, f.c(kVarG.s()), Integer.valueOf(i10));
                this.f12209c.l(kVarG.o());
            }
        }
        return gVar;
    }

    @Override // i9.e1
    public void b() {
        if (w()) {
            final ArrayList arrayList = new ArrayList();
            this.f12207a.D("SELECT path FROM document_mutations WHERE uid = ?").b(this.f12210d).e(new n9.n() { // from class: i9.t2
                @Override // n9.n
                public final void accept(Object obj) {
                    arrayList.add(f.b(((Cursor) obj).getString(0)));
                }
            });
            n9.b.d(arrayList.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty. Dangling keys: %s", arrayList);
        }
    }

    @Override // i9.e1
    public void c(k9.g gVar) {
        SQLiteStatement sQLiteStatementC = this.f12207a.C("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
        SQLiteStatement sQLiteStatementC2 = this.f12207a.C("DELETE FROM document_mutations WHERE uid = ? AND path = ? AND batch_id = ?");
        int iE = gVar.e();
        n9.b.d(this.f12207a.v(sQLiteStatementC, this.f12210d, Integer.valueOf(iE)) != 0, "Mutation batch (%s, %d) did not exist", this.f12210d, Integer.valueOf(gVar.e()));
        Iterator it = gVar.h().iterator();
        while (it.hasNext()) {
            j9.k kVarG = ((k9.f) it.next()).g();
            this.f12207a.v(sQLiteStatementC2, this.f12210d, f.c(kVarG.s()), Integer.valueOf(iE));
            this.f12207a.g().n(kVarG);
        }
    }

    @Override // i9.e1
    public List d(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(f.c(((j9.k) it.next()).s()));
        }
        e3.b bVar = new e3.b(this.f12207a, "SELECT DISTINCT dm.batch_id, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path IN (", Arrays.asList(1000000, this.f12210d), arrayList, ") AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id");
        final ArrayList arrayList2 = new ArrayList();
        final HashSet hashSet = new HashSet();
        while (bVar.d()) {
            bVar.e().e(new n9.n() { // from class: i9.p2
                @Override // n9.n
                public final void accept(Object obj) {
                    x2.s(this.f12113a, hashSet, arrayList2, (Cursor) obj);
                }
            });
        }
        if (bVar.c() > 1) {
            Collections.sort(arrayList2, new Comparator() { // from class: i9.q2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Integer.compare(((k9.g) obj).e(), ((k9.g) obj2).e());
                }
            });
        }
        return arrayList2;
    }

    @Override // i9.e1
    public void e(com.google.protobuf.i iVar) {
        this.f12212f = (com.google.protobuf.i) n9.x.b(iVar);
        y();
    }

    @Override // i9.e1
    public void f(k9.g gVar, com.google.protobuf.i iVar) {
        this.f12212f = (com.google.protobuf.i) n9.x.b(iVar);
        y();
    }

    @Override // i9.e1
    public k9.g g(int i10) {
        return (k9.g) this.f12207a.D("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id >= ? ORDER BY batch_id ASC LIMIT 1").b(1000000, this.f12210d, Integer.valueOf(i10 + 1)).d(new n9.t() { // from class: i9.o2
            @Override // n9.t
            public final Object apply(Object obj) {
                return x2.n(this.f12106a, (Cursor) obj);
            }
        });
    }

    @Override // i9.e1
    public int h() {
        return ((Integer) this.f12207a.D("SELECT IFNULL(MAX(batch_id), ?) FROM mutations WHERE uid = ?").b(-1, this.f12210d).d(new n9.t() { // from class: i9.n2
            @Override // n9.t
            public final Object apply(Object obj) {
                return Integer.valueOf(((Cursor) obj).getInt(0));
            }
        })).intValue();
    }

    @Override // i9.e1
    public k9.g i(final int i10) {
        return (k9.g) this.f12207a.D("SELECT SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id = ?").b(1000000, this.f12210d, Integer.valueOf(i10)).d(new n9.t() { // from class: i9.w2
            @Override // n9.t
            public final Object apply(Object obj) {
                return x2.o(this.f12197a, i10, (Cursor) obj);
            }
        });
    }

    @Override // i9.e1
    public com.google.protobuf.i j() {
        return this.f12212f;
    }

    @Override // i9.e1
    public List k() {
        final ArrayList arrayList = new ArrayList();
        this.f12207a.D("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? ORDER BY batch_id ASC").b(1000000, this.f12210d).e(new n9.n() { // from class: i9.s2
            @Override // n9.n
            public final void accept(Object obj) {
                x2.r(this.f12157a, arrayList, (Cursor) obj);
            }
        });
        return arrayList;
    }

    @Override // i9.e1
    public void start() {
        x();
        if (this.f12207a.D("SELECT last_stream_token FROM mutation_queues WHERE uid = ?").b(this.f12210d).c(new n9.n() { // from class: i9.r2
            @Override // n9.n
            public final void accept(Object obj) {
                x2.m(this.f12147a, (Cursor) obj);
            }
        }) == 0) {
            y();
        }
    }

    public final k9.g v(int i10, byte[] bArr) {
        try {
            if (bArr.length < 1000000) {
                return this.f12208b.f(l9.e.q0(bArr));
            }
            a aVar = new a(bArr);
            while (aVar.f12214b) {
                this.f12207a.D("SELECT SUBSTR(mutations, ?, ?) FROM mutations WHERE uid = ? AND batch_id = ?").b(Integer.valueOf((aVar.d() * 1000000) + 1), 1000000, this.f12210d, Integer.valueOf(i10)).c(aVar);
            }
            return this.f12208b.f(l9.e.p0(aVar.e()));
        } catch (com.google.protobuf.d0 e10) {
            throw n9.b.a("MutationBatch failed to parse: %s", e10);
        }
    }

    public boolean w() {
        return this.f12207a.D("SELECT batch_id FROM mutations WHERE uid = ? LIMIT 1").b(this.f12210d).f();
    }

    public final void x() {
        final ArrayList arrayList = new ArrayList();
        this.f12207a.D("SELECT uid FROM mutation_queues").e(new n9.n() { // from class: i9.u2
            @Override // n9.n
            public final void accept(Object obj) {
                arrayList.add(((Cursor) obj).getString(0));
            }
        });
        this.f12211e = 0;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f12207a.D("SELECT MAX(batch_id) FROM mutations WHERE uid = ?").b((String) it.next()).e(new n9.n() { // from class: i9.v2
                @Override // n9.n
                public final void accept(Object obj) {
                    x2 x2Var = this.f12184a;
                    x2Var.f12211e = Math.max(x2Var.f12211e, ((Cursor) obj).getInt(0));
                }
            });
        }
        this.f12211e++;
    }

    public final void y() {
        this.f12207a.w("INSERT OR REPLACE INTO mutation_queues (uid, last_acknowledged_batch_id, last_stream_token) VALUES (?, ?, ?)", this.f12210d, -1, this.f12212f.Y());
    }
}
