package e8;

import com.google.android.gms.tasks.Task;
import j8.e0;
import j8.i0;
import r8.t;
import r8.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j8.n f8517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j8.l f8518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o8.h f8519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8520d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j8.i f8521a;

        public a(j8.i iVar) {
            this.f8521a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.f8517a.d0(this.f8521a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j8.i f8523a;

        public b(j8.i iVar) {
            this.f8523a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.f8517a.E(this.f8523a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f8525a;

        public c(boolean z10) {
            this.f8525a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            p pVar = p.this;
            pVar.f8517a.S(pVar.u(), this.f8525a);
        }
    }

    public p(j8.n nVar, j8.l lVar, o8.h hVar, boolean z10) {
        this.f8517a = nVar;
        this.f8518b = lVar;
        this.f8519c = hVar;
        this.f8520d = z10;
        m8.m.g(hVar.q(), "Validation of queries failed.");
    }

    public p A() {
        U();
        o8.h hVarW = this.f8519c.w(r8.q.j());
        V(hVarW);
        return new p(this.f8517a, this.f8518b, hVarW, true);
    }

    public p B() {
        U();
        return new p(this.f8517a, this.f8518b, this.f8519c.w(u.j()), true);
    }

    public void C(e8.a aVar) {
        if (aVar == null) {
            throw new NullPointerException("listener must not be null");
        }
        E(new j8.a(this.f8517a, aVar, u()));
    }

    public void D(s sVar) {
        if (sVar == null) {
            throw new NullPointerException("listener must not be null");
        }
        E(new e0(this.f8517a, sVar, u()));
    }

    public final void E(j8.i iVar) {
        i0.b().e(iVar);
        this.f8517a.k0(new a(iVar));
    }

    public p F(double d10) {
        return N(d10, r8.b.k().b());
    }

    public p G(double d10, String str) {
        return J(new r8.f(Double.valueOf(d10), r8.r.a()), str);
    }

    public p H(String str) {
        return (str == null || !this.f8519c.d().equals(r8.j.j())) ? P(str, r8.b.k().b()) : O(m8.j.b(str));
    }

    public p I(String str, String str2) {
        if (str != null && this.f8519c.d().equals(r8.j.j())) {
            str = m8.j.b(str);
        }
        return J(str != null ? new t(str, r8.r.a()) : r8.g.y(), str2);
    }

    public final p J(r8.n nVar, String str) {
        return Q(nVar, m8.j.b(str));
    }

    public p K(boolean z10) {
        return S(z10, r8.b.k().b());
    }

    public p L(boolean z10, String str) {
        return J(new r8.a(Boolean.valueOf(z10), r8.r.a()), str);
    }

    public p M(double d10) {
        return N(d10, null);
    }

    public p N(double d10, String str) {
        return Q(new r8.f(Double.valueOf(d10), r8.r.a()), str);
    }

    public p O(String str) {
        return P(str, null);
    }

    public p P(String str, String str2) {
        return Q(str != null ? new t(str, r8.r.a()) : r8.g.y(), str2);
    }

    public final p Q(r8.n nVar, String str) {
        m8.n.g(str);
        if (!nVar.J() && !nVar.isEmpty()) {
            throw new IllegalArgumentException("Can only use simple values for startAt() and startAfter()");
        }
        if (this.f8519c.o()) {
            throw new IllegalArgumentException("Can't call startAt(), startAfte(), or equalTo() multiple times");
        }
        o8.h hVarX = this.f8519c.x(nVar, str != null ? str.equals("[MIN_NAME]") ? r8.b.l() : str.equals("[MAX_KEY]") ? r8.b.k() : r8.b.h(str) : null);
        T(hVarX);
        V(hVarX);
        m8.m.f(hVarX.q());
        return new p(this.f8517a, this.f8518b, hVarX, this.f8520d);
    }

    public p R(boolean z10) {
        return S(z10, null);
    }

    public p S(boolean z10, String str) {
        return Q(new r8.a(Boolean.valueOf(z10), r8.r.a()), str);
    }

    public final void T(o8.h hVar) {
        if (hVar.o() && hVar.m() && hVar.n() && !hVar.l()) {
            throw new IllegalArgumentException("Can't combine startAt(), startAfter(), endAt(), endBefore(), and limit(). Use limitToFirst() or limitToLast() instead");
        }
    }

    public final void U() {
        if (this.f8520d) {
            throw new IllegalArgumentException("You can't combine multiple orderBy calls!");
        }
    }

    public final void V(o8.h hVar) {
        if (!hVar.d().equals(r8.j.j())) {
            if (hVar.d().equals(r8.q.j())) {
                if ((hVar.o() && !r8.r.b(hVar.h())) || (hVar.m() && !r8.r.b(hVar.f()))) {
                    throw new IllegalArgumentException("When using orderByPriority(), values provided to startAt(), startAfter(), endAt(), endBefore(), or equalTo() must be valid priorities.");
                }
                return;
            }
            return;
        }
        if (hVar.o()) {
            r8.n nVarH = hVar.h();
            if (!com.google.android.gms.common.internal.q.b(hVar.g(), r8.b.l()) || !(nVarH instanceof t)) {
                throw new IllegalArgumentException("You must use startAt(String value), startAfter(String value), endAt(String value), endBefore(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported");
            }
        }
        if (hVar.m()) {
            r8.n nVarF = hVar.f();
            if (!hVar.e().equals(r8.b.k()) || !(nVarF instanceof t)) {
                throw new IllegalArgumentException("You must use startAt(String value), startAfter(String value), endAt(String value), endBefore(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported");
            }
        }
    }

    public e8.a a(e8.a aVar) {
        b(new j8.a(this.f8517a, aVar, u()));
        return aVar;
    }

    public final void b(j8.i iVar) {
        i0.b().c(iVar);
        this.f8517a.k0(new b(iVar));
    }

    public s c(s sVar) {
        b(new e0(this.f8517a, sVar, u()));
        return sVar;
    }

    public p d(double d10) {
        return e(d10, null);
    }

    public p e(double d10, String str) {
        return h(new r8.f(Double.valueOf(d10), r8.r.a()), str);
    }

    public p f(String str) {
        return g(str, null);
    }

    public p g(String str, String str2) {
        return h(str != null ? new t(str, r8.r.a()) : r8.g.y(), str2);
    }

    public final p h(r8.n nVar, String str) {
        m8.n.g(str);
        if (!nVar.J() && !nVar.isEmpty()) {
            throw new IllegalArgumentException("Can only use simple values for endAt()");
        }
        r8.b bVarH = str != null ? r8.b.h(str) : null;
        if (this.f8519c.m()) {
            throw new IllegalArgumentException("Can't call endAt() or equalTo() multiple times");
        }
        o8.h hVarB = this.f8519c.b(nVar, bVarH);
        T(hVarB);
        V(hVarB);
        m8.m.f(hVarB.q());
        return new p(this.f8517a, this.f8518b, hVarB, this.f8520d);
    }

    public p i(boolean z10) {
        return j(z10, null);
    }

    public p j(boolean z10, String str) {
        return h(new r8.a(Boolean.valueOf(z10), r8.r.a()), str);
    }

    public p k(double d10) {
        return e(d10, r8.b.l().b());
    }

    public p l(double d10, String str) {
        return o(new r8.f(Double.valueOf(d10), r8.r.a()), str);
    }

    public p m(String str) {
        return (str == null || !this.f8519c.d().equals(r8.j.j())) ? g(str, r8.b.l().b()) : f(m8.j.a(str));
    }

    public p n(String str, String str2) {
        if (str != null && this.f8519c.d().equals(r8.j.j())) {
            str = m8.j.a(str);
        }
        return o(str != null ? new t(str, r8.r.a()) : r8.g.y(), str2);
    }

    public final p o(r8.n nVar, String str) {
        return h(nVar, m8.j.a(str));
    }

    public p p(boolean z10) {
        return j(z10, r8.b.l().b());
    }

    public p q(boolean z10, String str) {
        return o(new r8.a(Boolean.valueOf(z10), r8.r.a()), str);
    }

    public Task r() {
        return this.f8517a.Q(this);
    }

    public j8.l s() {
        return this.f8518b;
    }

    public e t() {
        return new e(this.f8517a, s());
    }

    public o8.i u() {
        return new o8.i(this.f8518b, this.f8519c);
    }

    public void v(boolean z10) {
        if (!this.f8518b.isEmpty() && this.f8518b.K().equals(r8.b.i())) {
            throw new d("Can't call keepSynced() on .info paths.");
        }
        this.f8517a.k0(new c(z10));
    }

    public p w(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        }
        if (this.f8519c.n()) {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
        return new p(this.f8517a, this.f8518b, this.f8519c.s(i10), this.f8520d);
    }

    public p x(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        }
        if (this.f8519c.n()) {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
        return new p(this.f8517a, this.f8518b, this.f8519c.t(i10), this.f8520d);
    }

    public p y(String str) {
        if (str == null) {
            throw new NullPointerException("Key can't be null");
        }
        if (str.equals("$key") || str.equals(".key")) {
            throw new IllegalArgumentException("Can't use '" + str + "' as path, please use orderByKey() instead!");
        }
        if (str.equals("$priority") || str.equals(".priority")) {
            throw new IllegalArgumentException("Can't use '" + str + "' as path, please use orderByPriority() instead!");
        }
        if (str.equals("$value") || str.equals(".value")) {
            throw new IllegalArgumentException("Can't use '" + str + "' as path, please use orderByValue() instead!");
        }
        m8.n.h(str);
        U();
        j8.l lVar = new j8.l(str);
        if (lVar.size() == 0) {
            throw new IllegalArgumentException("Can't use empty path, use orderByValue() instead!");
        }
        return new p(this.f8517a, this.f8518b, this.f8519c.w(new r8.p(lVar)), true);
    }

    public p z() {
        U();
        o8.h hVarW = this.f8519c.w(r8.j.j());
        V(hVarW);
        return new p(this.f8517a, this.f8518b, hVarW, true);
    }

    public p(j8.n nVar, j8.l lVar) {
        this.f8517a = nVar;
        this.f8518b = lVar;
        this.f8519c = o8.h.f17629i;
        this.f8520d = false;
    }
}
