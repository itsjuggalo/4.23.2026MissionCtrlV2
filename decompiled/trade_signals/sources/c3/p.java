package c3;

import com.google.android.gms.common.internal.AbstractC1293m;
import h3.AbstractC1872h;
import h3.C1860D;
import h3.C1864H;
import h3.C1865a;
import h3.C1875k;
import h3.C1877m;
import k3.AbstractC2276j;
import k3.AbstractC2279m;
import k3.AbstractC2280n;
import l2.AbstractC2328l;
import p3.AbstractC2564r;
import p3.C2547a;
import p3.C2548b;
import p3.C2552f;
import p3.C2553g;
import p3.C2556j;
import p3.C2562p;
import p3.C2563q;
import p3.C2566t;
import p3.C2567u;
import p3.InterfaceC2560n;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1877m f13398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1875k f13399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m3.h f13400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f13401d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1872h f13402a;

        public a(AbstractC1872h abstractC1872h) {
            this.f13402a = abstractC1872h;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.f13398a.b0(this.f13402a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1872h f13404a;

        public b(AbstractC1872h abstractC1872h) {
            this.f13404a = abstractC1872h;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.f13398a.D(this.f13404a);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13406a;

        public c(boolean z7) {
            this.f13406a = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            p pVar = p.this;
            pVar.f13398a.Q(pVar.u(), this.f13406a);
        }
    }

    public p(C1877m c1877m, C1875k c1875k) {
        this.f13398a = c1877m;
        this.f13399b = c1875k;
        this.f13400c = m3.h.f21426i;
        this.f13401d = false;
    }

    public p A() {
        U();
        m3.h hVarW = this.f13400c.w(C2563q.j());
        V(hVarW);
        return new p(this.f13398a, this.f13399b, hVarW, true);
    }

    public p B() {
        U();
        return new p(this.f13398a, this.f13399b, this.f13400c.w(C2567u.j()), true);
    }

    public void C(InterfaceC1252a interfaceC1252a) {
        if (interfaceC1252a == null) {
            throw new NullPointerException("listener must not be null");
        }
        E(new C1865a(this.f13398a, interfaceC1252a, u()));
    }

    public void D(s sVar) {
        if (sVar == null) {
            throw new NullPointerException("listener must not be null");
        }
        E(new C1860D(this.f13398a, sVar, u()));
    }

    public final void E(AbstractC1872h abstractC1872h) {
        C1864H.b().e(abstractC1872h);
        this.f13398a.i0(new a(abstractC1872h));
    }

    public p F(double d8) {
        return N(d8, C2548b.l().b());
    }

    public p G(double d8, String str) {
        return J(new C2552f(Double.valueOf(d8), AbstractC2564r.a()), str);
    }

    public p H(String str) {
        return (str == null || !this.f13400c.d().equals(C2556j.j())) ? P(str, C2548b.l().b()) : O(AbstractC2276j.b(str));
    }

    public p I(String str, String str2) {
        if (str != null && this.f13400c.d().equals(C2556j.j())) {
            str = AbstractC2276j.b(str);
        }
        return J(str != null ? new C2566t(str, AbstractC2564r.a()) : C2553g.M(), str2);
    }

    public final p J(InterfaceC2560n interfaceC2560n, String str) {
        return Q(interfaceC2560n, AbstractC2276j.b(str));
    }

    public p K(boolean z7) {
        return S(z7, C2548b.l().b());
    }

    public p L(boolean z7, String str) {
        return J(new C2547a(Boolean.valueOf(z7), AbstractC2564r.a()), str);
    }

    public p M(double d8) {
        return N(d8, null);
    }

    public p N(double d8, String str) {
        return Q(new C2552f(Double.valueOf(d8), AbstractC2564r.a()), str);
    }

    public p O(String str) {
        return P(str, null);
    }

    public p P(String str, String str2) {
        return Q(str != null ? new C2566t(str, AbstractC2564r.a()) : C2553g.M(), str2);
    }

    public final p Q(InterfaceC2560n interfaceC2560n, String str) {
        AbstractC2280n.g(str);
        if (!interfaceC2560n.x() && !interfaceC2560n.isEmpty()) {
            throw new IllegalArgumentException("Can only use simple values for startAt() and startAfter()");
        }
        if (this.f13400c.o()) {
            throw new IllegalArgumentException("Can't call startAt(), startAfte(), or equalTo() multiple times");
        }
        m3.h hVarX = this.f13400c.x(interfaceC2560n, str != null ? str.equals("[MIN_NAME]") ? C2548b.m() : str.equals("[MAX_KEY]") ? C2548b.l() : C2548b.i(str) : null);
        T(hVarX);
        V(hVarX);
        AbstractC2279m.f(hVarX.q());
        return new p(this.f13398a, this.f13399b, hVarX, this.f13401d);
    }

    public p R(boolean z7) {
        return S(z7, null);
    }

    public p S(boolean z7, String str) {
        return Q(new C2547a(Boolean.valueOf(z7), AbstractC2564r.a()), str);
    }

    public final void T(m3.h hVar) {
        if (hVar.o() && hVar.m() && hVar.n() && !hVar.l()) {
            throw new IllegalArgumentException("Can't combine startAt(), startAfter(), endAt(), endBefore(), and limit(). Use limitToFirst() or limitToLast() instead");
        }
    }

    public final void U() {
        if (this.f13401d) {
            throw new IllegalArgumentException("You can't combine multiple orderBy calls!");
        }
    }

    public final void V(m3.h hVar) {
        if (!hVar.d().equals(C2556j.j())) {
            if (hVar.d().equals(C2563q.j())) {
                if ((hVar.o() && !AbstractC2564r.b(hVar.h())) || (hVar.m() && !AbstractC2564r.b(hVar.f()))) {
                    throw new IllegalArgumentException("When using orderByPriority(), values provided to startAt(), startAfter(), endAt(), endBefore(), or equalTo() must be valid priorities.");
                }
                return;
            }
            return;
        }
        if (hVar.o()) {
            InterfaceC2560n interfaceC2560nH = hVar.h();
            if (!AbstractC1293m.a(hVar.g(), C2548b.m()) || !(interfaceC2560nH instanceof C2566t)) {
                throw new IllegalArgumentException("You must use startAt(String value), startAfter(String value), endAt(String value), endBefore(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported");
            }
        }
        if (hVar.m()) {
            InterfaceC2560n interfaceC2560nF = hVar.f();
            if (!hVar.e().equals(C2548b.l()) || !(interfaceC2560nF instanceof C2566t)) {
                throw new IllegalArgumentException("You must use startAt(String value), startAfter(String value), endAt(String value), endBefore(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported");
            }
        }
    }

    public InterfaceC1252a a(InterfaceC1252a interfaceC1252a) {
        b(new C1865a(this.f13398a, interfaceC1252a, u()));
        return interfaceC1252a;
    }

    public final void b(AbstractC1872h abstractC1872h) {
        C1864H.b().c(abstractC1872h);
        this.f13398a.i0(new b(abstractC1872h));
    }

    public s c(s sVar) {
        b(new C1860D(this.f13398a, sVar, u()));
        return sVar;
    }

    public p d(double d8) {
        return e(d8, null);
    }

    public p e(double d8, String str) {
        return h(new C2552f(Double.valueOf(d8), AbstractC2564r.a()), str);
    }

    public p f(String str) {
        return g(str, null);
    }

    public p g(String str, String str2) {
        return h(str != null ? new C2566t(str, AbstractC2564r.a()) : C2553g.M(), str2);
    }

    public final p h(InterfaceC2560n interfaceC2560n, String str) {
        AbstractC2280n.g(str);
        if (!interfaceC2560n.x() && !interfaceC2560n.isEmpty()) {
            throw new IllegalArgumentException("Can only use simple values for endAt()");
        }
        C2548b c2548bI = str != null ? C2548b.i(str) : null;
        if (this.f13400c.m()) {
            throw new IllegalArgumentException("Can't call endAt() or equalTo() multiple times");
        }
        m3.h hVarB = this.f13400c.b(interfaceC2560n, c2548bI);
        T(hVarB);
        V(hVarB);
        AbstractC2279m.f(hVarB.q());
        return new p(this.f13398a, this.f13399b, hVarB, this.f13401d);
    }

    public p i(boolean z7) {
        return j(z7, null);
    }

    public p j(boolean z7, String str) {
        return h(new C2547a(Boolean.valueOf(z7), AbstractC2564r.a()), str);
    }

    public p k(double d8) {
        return e(d8, C2548b.m().b());
    }

    public p l(double d8, String str) {
        return o(new C2552f(Double.valueOf(d8), AbstractC2564r.a()), str);
    }

    public p m(String str) {
        return (str == null || !this.f13400c.d().equals(C2556j.j())) ? g(str, C2548b.m().b()) : f(AbstractC2276j.a(str));
    }

    public p n(String str, String str2) {
        if (str != null && this.f13400c.d().equals(C2556j.j())) {
            str = AbstractC2276j.a(str);
        }
        return o(str != null ? new C2566t(str, AbstractC2564r.a()) : C2553g.M(), str2);
    }

    public final p o(InterfaceC2560n interfaceC2560n, String str) {
        return h(interfaceC2560n, AbstractC2276j.a(str));
    }

    public p p(boolean z7) {
        return j(z7, C2548b.m().b());
    }

    public p q(boolean z7, String str) {
        return o(new C2547a(Boolean.valueOf(z7), AbstractC2564r.a()), str);
    }

    public AbstractC2328l r() {
        return this.f13398a.O(this);
    }

    public C1875k s() {
        return this.f13399b;
    }

    public e t() {
        return new e(this.f13398a, s());
    }

    public m3.i u() {
        return new m3.i(this.f13399b, this.f13400c);
    }

    public void v(boolean z7) {
        if (!this.f13399b.isEmpty() && this.f13399b.P().equals(C2548b.k())) {
            throw new d("Can't call keepSynced() on .info paths.");
        }
        this.f13398a.i0(new c(z7));
    }

    public p w(int i8) {
        if (i8 <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        }
        if (this.f13400c.n()) {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
        return new p(this.f13398a, this.f13399b, this.f13400c.s(i8), this.f13401d);
    }

    public p x(int i8) {
        if (i8 <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        }
        if (this.f13400c.n()) {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
        return new p(this.f13398a, this.f13399b, this.f13400c.t(i8), this.f13401d);
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
        AbstractC2280n.h(str);
        U();
        C1875k c1875k = new C1875k(str);
        if (c1875k.size() == 0) {
            throw new IllegalArgumentException("Can't use empty path, use orderByValue() instead!");
        }
        return new p(this.f13398a, this.f13399b, this.f13400c.w(new C2562p(c1875k)), true);
    }

    public p z() {
        U();
        m3.h hVarW = this.f13400c.w(C2556j.j());
        V(hVarW);
        return new p(this.f13398a, this.f13399b, hVarW, true);
    }

    public p(C1877m c1877m, C1875k c1875k, m3.h hVar, boolean z7) {
        this.f13398a = c1877m;
        this.f13399b = c1875k;
        this.f13400c = hVar;
        this.f13401d = z7;
        AbstractC2279m.g(hVar.q(), "Validation of queries failed.");
    }
}
