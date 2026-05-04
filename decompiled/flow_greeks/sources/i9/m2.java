package i9;

import android.database.Cursor;
import android.util.SparseArray;
import i9.q0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class m2 implements m1, m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f12081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g9.w0 f12082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f12083c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q0 f12084d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n1 f12085e;

    public m2(e3 e3Var, q0.b bVar) {
        this.f12081a = e3Var;
        this.f12084d = new q0(this, bVar);
    }

    public static /* synthetic */ void q(m2 m2Var, int[] iArr, List list, j9.t[] tVarArr, Cursor cursor) {
        m2Var.getClass();
        j9.t tVarB = f.b(cursor.getString(0));
        j9.k kVarK = j9.k.k(tVarB);
        if (!m2Var.s(kVarK)) {
            iArr[0] = iArr[0] + 1;
            list.add(kVarK);
            m2Var.u(kVarK);
        }
        tVarArr[0] = tVarB;
    }

    private boolean t(j9.k kVar) {
        return !this.f12081a.D("SELECT 1 FROM document_mutations WHERE path = ?").b(f.c(kVar.s())).f();
    }

    @Override // i9.m0
    public long a() {
        return this.f12081a.x();
    }

    @Override // i9.m0
    public void b(final n9.n nVar) {
        this.f12081a.D("select sequence_number from target_documents group by path having COUNT(*) = 1 AND target_id = 0").e(new n9.n() { // from class: i9.l2
            @Override // n9.n
            public final void accept(Object obj) {
                nVar.accept(Long.valueOf(((Cursor) obj).getLong(0)));
            }
        });
    }

    @Override // i9.m0
    public int c(long j10, SparseArray sparseArray) {
        return this.f12081a.i().t(j10, sparseArray);
    }

    @Override // i9.m1
    public void d(j9.k kVar) {
        w(kVar);
    }

    @Override // i9.m1
    public void e(j9.k kVar) {
        w(kVar);
    }

    @Override // i9.m0
    public q0 f() {
        return this.f12084d;
    }

    @Override // i9.m1
    public void g() {
        n9.b.d(this.f12083c == -1, "Starting a transaction without committing the previous one", new Object[0]);
        this.f12083c = this.f12082b.a();
    }

    @Override // i9.m1
    public void h(n1 n1Var) {
        this.f12085e = n1Var;
    }

    @Override // i9.m1
    public long i() {
        n9.b.d(this.f12083c != -1, "Attempting to get a sequence number outside of a transaction", new Object[0]);
        return this.f12083c;
    }

    @Override // i9.m0
    public void j(n9.n nVar) {
        this.f12081a.i().q(nVar);
    }

    @Override // i9.m0
    public long k() {
        return this.f12081a.i().s() + ((Long) this.f12081a.D("SELECT COUNT(*) FROM (SELECT sequence_number FROM target_documents GROUP BY path HAVING COUNT(*) = 1 AND target_id = 0)").d(new n9.t() { // from class: i9.k2
            @Override // n9.t
            public final Object apply(Object obj) {
                return Long.valueOf(((Cursor) obj).getLong(0));
            }
        })).longValue();
    }

    @Override // i9.m0
    public int l(long j10) {
        final int[] iArr = new int[1];
        final ArrayList arrayList = new ArrayList();
        final j9.t[] tVarArr = {j9.t.f14277b};
        while (this.f12081a.D("select path from target_documents group by path having COUNT(*) = 1 AND target_id = 0 AND sequence_number <= ? AND path > ? LIMIT ?").b(Long.valueOf(j10), f.c(tVarArr[0]), 100).e(new n9.n() { // from class: i9.j2
            @Override // n9.n
            public final void accept(Object obj) {
                m2.q(this.f11997a, iArr, arrayList, tVarArr, (Cursor) obj);
            }
        }) == 100) {
        }
        this.f12081a.h().removeAll(arrayList);
        return iArr[0];
    }

    @Override // i9.m1
    public void m(j9.k kVar) {
        w(kVar);
    }

    @Override // i9.m1
    public void n(j9.k kVar) {
        w(kVar);
    }

    @Override // i9.m1
    public void o(n4 n4Var) {
        this.f12081a.i().h(n4Var.l(i()));
    }

    @Override // i9.m1
    public void onTransactionCommitted() {
        n9.b.d(this.f12083c != -1, "Committing a transaction without having started one", new Object[0]);
        this.f12083c = -1L;
    }

    public final boolean s(j9.k kVar) {
        if (this.f12085e.c(kVar)) {
            return true;
        }
        return t(kVar);
    }

    public final void u(j9.k kVar) {
        this.f12081a.w("DELETE FROM target_documents WHERE path = ? AND target_id = 0", f.c(kVar.s()));
    }

    public void v(long j10) {
        this.f12082b = new g9.w0(j10);
    }

    public final void w(j9.k kVar) {
        this.f12081a.w("INSERT OR REPLACE INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)", f.c(kVar.s()), Long.valueOf(i()));
    }
}
