package i9;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.util.SparseArray;
import i9.k4;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k4 implements m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f12050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f12051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f12053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j9.v f12054e = j9.v.f14278b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f12055f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g8.e f12056a;

        public b() {
            this.f12056a = j9.k.h();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n4 f12057a;

        public c() {
        }
    }

    public k4(e3 e3Var, p pVar) {
        this.f12050a = e3Var;
        this.f12051b = pVar;
    }

    public static /* synthetic */ void l(k4 k4Var, g9.g1 g1Var, c cVar, Cursor cursor) {
        k4Var.getClass();
        n4 n4VarP = k4Var.p(cursor.getBlob(0));
        if (g1Var.equals(n4VarP.g())) {
            cVar.f12057a = n4VarP;
        }
    }

    public static /* synthetic */ void m(k4 k4Var, Cursor cursor) {
        k4Var.getClass();
        k4Var.f12052c = cursor.getInt(0);
        k4Var.f12053d = cursor.getInt(1);
        k4Var.f12054e = new j9.v(new a7.s(cursor.getLong(2), cursor.getInt(3)));
        k4Var.f12055f = cursor.getLong(4);
    }

    public static /* synthetic */ void n(k4 k4Var, SparseArray sparseArray, int[] iArr, Cursor cursor) {
        k4Var.getClass();
        int i10 = cursor.getInt(0);
        if (sparseArray.get(i10) == null) {
            k4Var.u(i10);
            iArr[0] = iArr[0] + 1;
        }
    }

    public static /* synthetic */ void o(k4 k4Var, n9.n nVar, Cursor cursor) {
        k4Var.getClass();
        nVar.accept(k4Var.p(cursor.getBlob(0)));
    }

    @Override // i9.m4
    public n4 a(final g9.g1 g1Var) {
        String strC = g1Var.c();
        final c cVar = new c();
        this.f12050a.D("SELECT target_proto FROM targets WHERE canonical_id = ?").b(strC).e(new n9.n() { // from class: i9.h4
            @Override // n9.n
            public final void accept(Object obj) {
                k4.l(this.f11958a, g1Var, cVar, (Cursor) obj);
            }
        });
        return cVar.f12057a;
    }

    @Override // i9.m4
    public void b(g8.e eVar, int i10) {
        SQLiteStatement sQLiteStatementC = this.f12050a.C("DELETE FROM target_documents WHERE target_id = ? AND path = ?");
        m2 m2VarA = this.f12050a.g();
        Iterator it = eVar.iterator();
        while (it.hasNext()) {
            j9.k kVar = (j9.k) it.next();
            this.f12050a.v(sQLiteStatementC, Integer.valueOf(i10), f.c(kVar.s()));
            m2VarA.d(kVar);
        }
    }

    @Override // i9.m4
    public void c(n4 n4Var) {
        v(n4Var);
        x(n4Var);
        this.f12055f++;
        y();
    }

    @Override // i9.m4
    public int d() {
        return this.f12052c;
    }

    @Override // i9.m4
    public void e(g8.e eVar, int i10) {
        SQLiteStatement sQLiteStatementC = this.f12050a.C("INSERT OR IGNORE INTO target_documents (target_id, path) VALUES (?, ?)");
        m2 m2VarA = this.f12050a.g();
        Iterator it = eVar.iterator();
        while (it.hasNext()) {
            j9.k kVar = (j9.k) it.next();
            this.f12050a.v(sQLiteStatementC, Integer.valueOf(i10), f.c(kVar.s()));
            m2VarA.e(kVar);
        }
    }

    @Override // i9.m4
    public g8.e f(int i10) {
        final b bVar = new b();
        this.f12050a.D("SELECT path FROM target_documents WHERE target_id = ?").b(Integer.valueOf(i10)).e(new n9.n() { // from class: i9.f4
            @Override // n9.n
            public final void accept(Object obj) {
                k4.b bVar2 = bVar;
                bVar2.f12056a = bVar2.f12056a.e(j9.k.k(f.b(((Cursor) obj).getString(0))));
            }
        });
        return bVar.f12056a;
    }

    @Override // i9.m4
    public j9.v g() {
        return this.f12054e;
    }

    @Override // i9.m4
    public void h(n4 n4Var) {
        v(n4Var);
        if (x(n4Var)) {
            y();
        }
    }

    @Override // i9.m4
    public void i(int i10) {
        this.f12050a.w("DELETE FROM target_documents WHERE target_id = ?", Integer.valueOf(i10));
    }

    @Override // i9.m4
    public void j(j9.v vVar) {
        this.f12054e = vVar;
        y();
    }

    public final n4 p(byte[] bArr) {
        try {
            return this.f12051b.h(l9.c.s0(bArr));
        } catch (com.google.protobuf.d0 e10) {
            throw n9.b.a("TargetData failed to parse: %s", e10);
        }
    }

    public void q(final n9.n nVar) {
        this.f12050a.D("SELECT target_proto FROM targets").e(new n9.n() { // from class: i9.j4
            @Override // n9.n
            public final void accept(Object obj) {
                k4.o(this.f12006a, nVar, (Cursor) obj);
            }
        });
    }

    public long r() {
        return this.f12053d;
    }

    public long s() {
        return this.f12055f;
    }

    public int t(long j10, final SparseArray sparseArray) {
        final int[] iArr = new int[1];
        this.f12050a.D("SELECT target_id FROM targets WHERE last_listen_sequence_number <= ?").b(Long.valueOf(j10)).e(new n9.n() { // from class: i9.i4
            @Override // n9.n
            public final void accept(Object obj) {
                k4.n(this.f11985a, sparseArray, iArr, (Cursor) obj);
            }
        });
        y();
        return iArr[0];
    }

    public final void u(int i10) {
        i(i10);
        this.f12050a.w("DELETE FROM targets WHERE target_id = ?", Integer.valueOf(i10));
        this.f12055f--;
    }

    public final void v(n4 n4Var) {
        int iH = n4Var.h();
        String strC = n4Var.g().c();
        a7.s sVarB = n4Var.f().b();
        this.f12050a.w("INSERT OR REPLACE INTO targets (target_id, canonical_id, snapshot_version_seconds, snapshot_version_nanos, resume_token, last_listen_sequence_number, target_proto) VALUES (?, ?, ?, ?, ?, ?, ?)", Integer.valueOf(iH), strC, Long.valueOf(sVarB.h()), Integer.valueOf(sVarB.b()), n4Var.d().Y(), Long.valueOf(n4Var.e()), this.f12051b.q(n4Var).i());
    }

    public void w() {
        n9.b.d(this.f12050a.D("SELECT highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos, target_count FROM target_globals LIMIT 1").c(new n9.n() { // from class: i9.g4
            @Override // n9.n
            public final void accept(Object obj) {
                k4.m(this.f11949a, (Cursor) obj);
            }
        }) == 1, "Missing target_globals entry", new Object[0]);
    }

    public final boolean x(n4 n4Var) {
        boolean z10;
        if (n4Var.h() > this.f12052c) {
            this.f12052c = n4Var.h();
            z10 = true;
        } else {
            z10 = false;
        }
        if (n4Var.e() <= this.f12053d) {
            return z10;
        }
        this.f12053d = n4Var.e();
        return true;
    }

    public final void y() {
        this.f12050a.w("UPDATE target_globals SET highest_target_id = ?, highest_listen_sequence_number = ?, last_remote_snapshot_version_seconds = ?, last_remote_snapshot_version_nanos = ?, target_count = ?", Integer.valueOf(this.f12052c), Long.valueOf(this.f12053d), Long.valueOf(this.f12054e.b().h()), Integer.valueOf(this.f12054e.b().b()), Long.valueOf(this.f12055f));
    }
}
