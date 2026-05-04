package xf;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p extends v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wf.i f25030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f25031c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class a implements u1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final yf.g f25032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final cd.k f25033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ p f25034c;

        public a(p pVar, yf.g kotlinTypeRefiner) {
            kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.f25034c = pVar;
            this.f25032a = kotlinTypeRefiner;
            this.f25033b = cd.l.a(cd.n.f3864b, new o(this, pVar));
        }

        public static final List i(a aVar, p pVar) {
            return yf.h.b(aVar.f25032a, pVar.c());
        }

        @Override // xf.u1
        public u1 a(yf.g kotlinTypeRefiner) {
            kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this.f25034c.a(kotlinTypeRefiner);
        }

        @Override // xf.u1
        public fe.h b() {
            return this.f25034c.b();
        }

        @Override // xf.u1
        public boolean d() {
            return this.f25034c.d();
        }

        public boolean equals(Object obj) {
            return this.f25034c.equals(obj);
        }

        public final List g() {
            return (List) this.f25033b.getValue();
        }

        @Override // xf.u1
        public List getParameters() {
            List parameters = this.f25034c.getParameters();
            kotlin.jvm.internal.t.e(parameters, "getParameters(...)");
            return parameters;
        }

        @Override // xf.u1
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public List c() {
            return g();
        }

        public int hashCode() {
            return this.f25034c.hashCode();
        }

        @Override // xf.u1
        public ce.i p() {
            ce.i iVarP = this.f25034c.p();
            kotlin.jvm.internal.t.e(iVarP, "getBuiltIns(...)");
            return iVarP;
        }

        public String toString() {
            return this.f25034c.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collection f25035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f25036b;

        public b(Collection allSupertypes) {
            kotlin.jvm.internal.t.f(allSupertypes, "allSupertypes");
            this.f25035a = allSupertypes;
            this.f25036b = dd.q.e(zf.l.f26552a.l());
        }

        public final Collection a() {
            return this.f25035a;
        }

        public final List b() {
            return this.f25036b;
        }

        public final void c(List list) {
            kotlin.jvm.internal.t.f(list, "<set-?>");
            this.f25036b = list;
        }
    }

    public p(wf.n storageManager) {
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        this.f25030b = storageManager.a(new h(this), i.f24982a, new j(this));
    }

    public static final b A(p pVar) {
        return new b(pVar.r());
    }

    public static final b B(boolean z10) {
        return new b(dd.q.e(zf.l.f26552a.l()));
    }

    public static final cd.h0 C(p pVar, b supertypes) {
        kotlin.jvm.internal.t.f(supertypes, "supertypes");
        Collection collectionA = pVar.v().a(pVar, supertypes.a(), new k(pVar), new l(pVar));
        if (collectionA.isEmpty()) {
            r0 r0VarS = pVar.s();
            collectionA = r0VarS != null ? dd.q.e(r0VarS) : null;
            if (collectionA == null) {
                collectionA = dd.r.k();
            }
        }
        if (pVar.u()) {
            pVar.v().a(pVar, collectionA, new m(pVar), new n(pVar));
        }
        List listI0 = collectionA instanceof List ? (List) collectionA : null;
        if (listI0 == null) {
            listI0 = dd.a0.I0(collectionA);
        }
        supertypes.c(pVar.x(listI0));
        return cd.h0.f3852a;
    }

    public static final Iterable D(p pVar, u1 it) {
        kotlin.jvm.internal.t.f(it, "it");
        return pVar.q(it, false);
    }

    public static final cd.h0 E(p pVar, r0 it) {
        kotlin.jvm.internal.t.f(it, "it");
        pVar.z(it);
        return cd.h0.f3852a;
    }

    public static final Iterable F(p pVar, u1 it) {
        kotlin.jvm.internal.t.f(it, "it");
        return pVar.q(it, true);
    }

    public static final cd.h0 G(p pVar, r0 it) {
        kotlin.jvm.internal.t.f(it, "it");
        pVar.y(it);
        return cd.h0.f3852a;
    }

    @Override // xf.u1
    public u1 a(yf.g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new a(this, kotlinTypeRefiner);
    }

    public final Collection q(u1 u1Var, boolean z10) {
        List listS0;
        p pVar = u1Var instanceof p ? (p) u1Var : null;
        if (pVar != null && (listS0 = dd.a0.s0(((b) pVar.f25030b.invoke()).a(), pVar.t(z10))) != null) {
            return listS0;
        }
        Collection collectionC = u1Var.c();
        kotlin.jvm.internal.t.e(collectionC, "getSupertypes(...)");
        return collectionC;
    }

    public abstract Collection r();

    public abstract r0 s();

    public Collection t(boolean z10) {
        return dd.r.k();
    }

    public boolean u() {
        return this.f25031c;
    }

    public abstract fe.j1 v();

    @Override // xf.u1
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public List c() {
        return ((b) this.f25030b.invoke()).b();
    }

    public List x(List supertypes) {
        kotlin.jvm.internal.t.f(supertypes, "supertypes");
        return supertypes;
    }

    public void y(r0 type) {
        kotlin.jvm.internal.t.f(type, "type");
    }

    public void z(r0 type) {
        kotlin.jvm.internal.t.f(type, "type");
    }
}
