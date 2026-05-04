package qf;

import fe.i1;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import qf.n;
import xf.d2;
import xf.f2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f19097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cd.k f19098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f2 f19099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map f19100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final cd.k f19101f;

    public t(k workerScope, f2 givenSubstitutor) {
        kotlin.jvm.internal.t.f(workerScope, "workerScope");
        kotlin.jvm.internal.t.f(givenSubstitutor, "givenSubstitutor");
        this.f19097b = workerScope;
        this.f19098c = cd.l.b(new r(givenSubstitutor));
        d2 d2VarJ = givenSubstitutor.j();
        kotlin.jvm.internal.t.e(d2VarJ, "getSubstitution(...)");
        this.f19099d = kf.e.h(d2VarJ, false, 1, null).c();
        this.f19101f = cd.l.b(new s(this));
    }

    public static final Collection h(t tVar) {
        return tVar.m(n.a.a(tVar.f19097b, null, null, 3, null));
    }

    public static final f2 n(f2 f2Var) {
        return f2Var.j().c();
    }

    @Override // qf.k
    public Collection a(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        return m(this.f19097b.a(name, location));
    }

    @Override // qf.k
    public Set b() {
        return this.f19097b.b();
    }

    @Override // qf.k
    public Collection c(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        return m(this.f19097b.c(name, location));
    }

    @Override // qf.k
    public Set d() {
        return this.f19097b.d();
    }

    @Override // qf.n
    public fe.h e(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        fe.h hVarE = this.f19097b.e(name, location);
        if (hVarE != null) {
            return (fe.h) l(hVarE);
        }
        return null;
    }

    @Override // qf.k
    public Set f() {
        return this.f19097b.f();
    }

    @Override // qf.n
    public Collection g(d kindFilter, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        return k();
    }

    public final Collection k() {
        return (Collection) this.f19101f.getValue();
    }

    public final fe.m l(fe.m mVar) {
        if (this.f19099d.k()) {
            return mVar;
        }
        if (this.f19100e == null) {
            this.f19100e = new HashMap();
        }
        Map map = this.f19100e;
        kotlin.jvm.internal.t.c(map);
        Object objC = map.get(mVar);
        if (objC == null) {
            if (!(mVar instanceof i1)) {
                throw new IllegalStateException(("Unknown descriptor in scope: " + mVar).toString());
            }
            objC = ((i1) mVar).c(this.f19099d);
            if (objC == null) {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + mVar + " substitution fails");
            }
            map.put(mVar, objC);
        }
        fe.m mVar2 = (fe.m) objC;
        kotlin.jvm.internal.t.d(mVar2, "null cannot be cast to non-null type D of org.jetbrains.kotlin.resolve.scopes.SubstitutingScope.substitute");
        return mVar2;
    }

    public final Collection m(Collection collection) {
        if (this.f19099d.k() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet linkedHashSetG = hg.a.g(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSetG.add(l((fe.m) it.next()));
        }
        return linkedHashSetG;
    }
}
