package i9;

import android.util.SparseArray;
import i9.q0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class y0 implements m1, m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b1 f12218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f12219b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n1 f12221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q0 f12222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g9.w0 f12223f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f12220c = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f12224g = -1;

    public y0(b1 b1Var, q0.b bVar, p pVar) {
        this.f12218a = b1Var;
        this.f12219b = pVar;
        this.f12223f = new g9.w0(b1Var.i().n());
        this.f12222e = new q0(this, bVar);
    }

    public static /* synthetic */ void p(long[] jArr, Long l10) {
        jArr[0] = jArr[0] + 1;
    }

    @Override // i9.m0
    public long a() {
        long jM = this.f12218a.i().m(this.f12219b) + this.f12218a.h().h(this.f12219b);
        Iterator it = this.f12218a.r().iterator();
        while (it.hasNext()) {
            jM += ((z0) it.next()).m(this.f12219b);
        }
        return jM;
    }

    @Override // i9.m0
    public void b(n9.n nVar) {
        for (Map.Entry entry : this.f12220c.entrySet()) {
            if (!q((j9.k) entry.getKey(), ((Long) entry.getValue()).longValue())) {
                nVar.accept((Long) entry.getValue());
            }
        }
    }

    @Override // i9.m0
    public int c(long j10, SparseArray sparseArray) {
        return this.f12218a.i().p(j10, sparseArray);
    }

    @Override // i9.m1
    public void d(j9.k kVar) {
        this.f12220c.put(kVar, Long.valueOf(i()));
    }

    @Override // i9.m1
    public void e(j9.k kVar) {
        this.f12220c.put(kVar, Long.valueOf(i()));
    }

    @Override // i9.m0
    public q0 f() {
        return this.f12222e;
    }

    @Override // i9.m1
    public void g() {
        n9.b.d(this.f12224g == -1, "Starting a transaction without committing the previous one", new Object[0]);
        this.f12224g = this.f12223f.a();
    }

    @Override // i9.m1
    public void h(n1 n1Var) {
        this.f12221d = n1Var;
    }

    @Override // i9.m1
    public long i() {
        n9.b.d(this.f12224g != -1, "Attempting to get a sequence number outside of a transaction", new Object[0]);
        return this.f12224g;
    }

    @Override // i9.m0
    public void j(n9.n nVar) {
        this.f12218a.i().l(nVar);
    }

    @Override // i9.m0
    public long k() {
        long jO = this.f12218a.i().o();
        final long[] jArr = new long[1];
        b(new n9.n() { // from class: i9.x0
            @Override // n9.n
            public final void accept(Object obj) {
                y0.p(jArr, (Long) obj);
            }
        });
        return jO + jArr[0];
    }

    @Override // i9.m0
    public int l(long j10) {
        c1 c1VarH = this.f12218a.h();
        ArrayList arrayList = new ArrayList();
        Iterator it = c1VarH.i().iterator();
        while (it.hasNext()) {
            j9.k key = ((j9.h) it.next()).getKey();
            if (!q(key, j10)) {
                arrayList.add(key);
                this.f12220c.remove(key);
            }
        }
        c1VarH.removeAll(arrayList);
        return arrayList.size();
    }

    @Override // i9.m1
    public void m(j9.k kVar) {
        this.f12220c.put(kVar, Long.valueOf(i()));
    }

    @Override // i9.m1
    public void n(j9.k kVar) {
        this.f12220c.put(kVar, Long.valueOf(i()));
    }

    @Override // i9.m1
    public void o(n4 n4Var) {
        this.f12218a.i().h(n4Var.l(i()));
    }

    @Override // i9.m1
    public void onTransactionCommitted() {
        n9.b.d(this.f12224g != -1, "Committing a transaction without having started one", new Object[0]);
        this.f12224g = -1L;
    }

    public final boolean q(j9.k kVar, long j10) {
        if (r(kVar) || this.f12221d.c(kVar) || this.f12218a.i().k(kVar)) {
            return true;
        }
        Long l10 = (Long) this.f12220c.get(kVar);
        return l10 != null && l10.longValue() > j10;
    }

    public final boolean r(j9.k kVar) {
        Iterator it = this.f12218a.r().iterator();
        while (it.hasNext()) {
            if (((z0) it.next()).l(kVar)) {
                return true;
            }
        }
        return false;
    }
}
