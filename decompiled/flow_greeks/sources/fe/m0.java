package fe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import qf.k;
import xf.m2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wf.n f9491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f9492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wf.g f9493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wf.g f9494d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ef.b f9495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f9496b;

        public a(ef.b classId, List typeParametersCount) {
            kotlin.jvm.internal.t.f(classId, "classId");
            kotlin.jvm.internal.t.f(typeParametersCount, "typeParametersCount");
            this.f9495a = classId;
            this.f9496b = typeParametersCount;
        }

        public final ef.b a() {
            return this.f9495a;
        }

        public final List b() {
            return this.f9496b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.t.b(this.f9495a, aVar.f9495a) && kotlin.jvm.internal.t.b(this.f9496b, aVar.f9496b);
        }

        public int hashCode() {
            return (this.f9495a.hashCode() * 31) + this.f9496b.hashCode();
        }

        public String toString() {
            return "ClassRequest(classId=" + this.f9495a + ", typeParametersCount=" + this.f9496b + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends ie.j {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f9497i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final List f9498j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final xf.u f9499k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(wf.n storageManager, m container, ef.f name, boolean z10, int i10) {
            super(storageManager, container, name, g1.f9483a, false);
            kotlin.jvm.internal.t.f(storageManager, "storageManager");
            kotlin.jvm.internal.t.f(container, "container");
            kotlin.jvm.internal.t.f(name, "name");
            this.f9497i = z10;
            vd.g gVarL = vd.l.l(0, i10);
            ArrayList arrayList = new ArrayList(dd.s.u(gVarL, 10));
            Iterator it = gVarL.iterator();
            while (it.hasNext()) {
                int iNextInt = ((dd.j0) it).nextInt();
                ge.h hVarB = ge.h.L.b();
                m2 m2Var = m2.f25015e;
                StringBuilder sb2 = new StringBuilder();
                sb2.append('T');
                sb2.append(iNextInt);
                arrayList.add(ie.t0.R0(this, hVarB, false, m2Var, ef.f.k(sb2.toString()), iNextInt, storageManager));
            }
            this.f9498j = arrayList;
            this.f9499k = new xf.u(this, p1.g(this), dd.t0.c(nf.e.s(this).p().i()), storageManager);
        }

        @Override // fe.e
        public boolean E() {
            return false;
        }

        @Override // fe.d0
        public boolean E0() {
            return false;
        }

        @Override // fe.e
        public boolean H0() {
            return false;
        }

        @Override // fe.e
        public Collection K() {
            return dd.r.k();
        }

        @Override // fe.e
        /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
        public k.b T() {
            return k.b.f19087b;
        }

        @Override // fe.h
        /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
        public xf.u k() {
            return this.f9499k;
        }

        @Override // ie.z
        /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
        public k.b I(yf.g kotlinTypeRefiner) {
            kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            return k.b.f19087b;
        }

        @Override // fe.d0
        public boolean N() {
            return false;
        }

        @Override // fe.i
        public boolean P() {
            return this.f9497i;
        }

        @Override // fe.e
        public d S() {
            return null;
        }

        @Override // fe.e
        public e V() {
            return null;
        }

        @Override // ge.a
        public ge.h getAnnotations() {
            return ge.h.L.b();
        }

        @Override // fe.e, fe.d0, fe.q
        public u getVisibility() {
            u PUBLIC = t.f9511e;
            kotlin.jvm.internal.t.e(PUBLIC, "PUBLIC");
            return PUBLIC;
        }

        @Override // fe.e
        public f h() {
            return f.f9473b;
        }

        @Override // ie.j, fe.d0
        public boolean isExternal() {
            return false;
        }

        @Override // fe.e
        public boolean isInline() {
            return false;
        }

        @Override // fe.e, fe.d0
        public e0 l() {
            return e0.f9461b;
        }

        @Override // fe.e
        public Collection m() {
            return dd.u0.d();
        }

        @Override // fe.e
        public boolean n() {
            return false;
        }

        public String toString() {
            return "class " + getName() + " (not found)";
        }

        @Override // fe.e, fe.i
        public List v() {
            return this.f9498j;
        }

        @Override // fe.e
        public boolean y() {
            return false;
        }

        @Override // fe.e
        public q1 y0() {
            return null;
        }
    }

    public m0(wf.n storageManager, h0 module) {
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(module, "module");
        this.f9491a = storageManager;
        this.f9492b = module;
        this.f9493c = storageManager.i(new k0(this));
        this.f9494d = storageManager.i(new l0(this));
    }

    public static final e c(m0 m0Var, a aVar) {
        m mVarD;
        kotlin.jvm.internal.t.f(aVar, "<destruct>");
        ef.b bVarA = aVar.a();
        List listB = aVar.b();
        if (bVarA.i()) {
            throw new UnsupportedOperationException("Unresolved local class: " + bVarA);
        }
        ef.b bVarE = bVarA.e();
        if (bVarE == null || (mVarD = m0Var.d(bVarE, dd.a0.T(listB, 1))) == null) {
            mVarD = (g) m0Var.f9493c.invoke(bVarA.f());
        }
        m mVar = mVarD;
        boolean zJ = bVarA.j();
        wf.n nVar = m0Var.f9491a;
        ef.f fVarH = bVarA.h();
        Integer num = (Integer) dd.a0.b0(listB);
        return new b(nVar, mVar, fVarH, zJ, num != null ? num.intValue() : 0);
    }

    public static final n0 e(m0 m0Var, ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        return new ie.p(m0Var.f9492b, fqName);
    }

    public final e d(ef.b classId, List typeParametersCount) {
        kotlin.jvm.internal.t.f(classId, "classId");
        kotlin.jvm.internal.t.f(typeParametersCount, "typeParametersCount");
        return (e) this.f9494d.invoke(new a(classId, typeParametersCount));
    }
}
