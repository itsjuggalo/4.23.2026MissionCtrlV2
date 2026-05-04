package i9;

import android.util.SparseArray;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d1 implements m4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11893c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b1 f11896f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11891a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n1 f11892b = new n1();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j9.v f11894d = j9.v.f14278b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f11895e = 0;

    public d1(b1 b1Var) {
        this.f11896f = b1Var;
    }

    @Override // i9.m4
    public n4 a(g9.g1 g1Var) {
        return (n4) this.f11891a.get(g1Var);
    }

    @Override // i9.m4
    public void b(g8.e eVar, int i10) {
        this.f11892b.g(eVar, i10);
        m1 m1VarG = this.f11896f.g();
        Iterator it = eVar.iterator();
        while (it.hasNext()) {
            m1VarG.d((j9.k) it.next());
        }
    }

    @Override // i9.m4
    public void c(n4 n4Var) {
        this.f11891a.put(n4Var.g(), n4Var);
        int iH = n4Var.h();
        if (iH > this.f11893c) {
            this.f11893c = iH;
        }
        if (n4Var.e() > this.f11895e) {
            this.f11895e = n4Var.e();
        }
    }

    @Override // i9.m4
    public int d() {
        return this.f11893c;
    }

    @Override // i9.m4
    public void e(g8.e eVar, int i10) {
        this.f11892b.b(eVar, i10);
        m1 m1VarG = this.f11896f.g();
        Iterator it = eVar.iterator();
        while (it.hasNext()) {
            m1VarG.e((j9.k) it.next());
        }
    }

    @Override // i9.m4
    public g8.e f(int i10) {
        return this.f11892b.d(i10);
    }

    @Override // i9.m4
    public j9.v g() {
        return this.f11894d;
    }

    @Override // i9.m4
    public void h(n4 n4Var) {
        c(n4Var);
    }

    @Override // i9.m4
    public void i(int i10) {
        this.f11892b.h(i10);
    }

    @Override // i9.m4
    public void j(j9.v vVar) {
        this.f11894d = vVar;
    }

    public boolean k(j9.k kVar) {
        return this.f11892b.c(kVar);
    }

    public void l(n9.n nVar) {
        Iterator it = this.f11891a.values().iterator();
        while (it.hasNext()) {
            nVar.accept((n4) it.next());
        }
    }

    public long m(p pVar) {
        Iterator it = this.f11891a.entrySet().iterator();
        long jB = 0;
        while (it.hasNext()) {
            jB += (long) pVar.q((n4) ((Map.Entry) it.next()).getValue()).b();
        }
        return jB;
    }

    public long n() {
        return this.f11895e;
    }

    public long o() {
        return this.f11891a.size();
    }

    public int p(long j10, SparseArray sparseArray) {
        Iterator it = this.f11891a.entrySet().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            int iH = ((n4) entry.getValue()).h();
            if (((n4) entry.getValue()).e() <= j10 && sparseArray.get(iH) == null) {
                it.remove();
                i(iH);
                i10++;
            }
        }
        return i10;
    }

    public void q(n4 n4Var) {
        this.f11891a.remove(n4Var.g());
        this.f11892b.h(n4Var.h());
    }
}
