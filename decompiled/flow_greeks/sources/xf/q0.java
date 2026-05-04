package xf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q0 implements u1, bg.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r0 f25038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f25039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f25040c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pd.k f25041a;

        public a(pd.k kVar) {
            this.f25041a = kVar;
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            r0 r0Var = (r0) obj;
            pd.k kVar = this.f25041a;
            kotlin.jvm.internal.t.c(r0Var);
            String string = kVar.invoke(r0Var).toString();
            r0 r0Var2 = (r0) obj2;
            pd.k kVar2 = this.f25041a;
            kotlin.jvm.internal.t.c(r0Var2);
            return fd.a.a(string, kVar2.invoke(r0Var2).toString());
        }
    }

    public q0(Collection typesToIntersect) {
        kotlin.jvm.internal.t.f(typesToIntersect, "typesToIntersect");
        typesToIntersect.isEmpty();
        LinkedHashSet linkedHashSet = new LinkedHashSet(typesToIntersect);
        this.f25039b = linkedHashSet;
        this.f25040c = linkedHashSet.hashCode();
    }

    public static final c1 k(q0 q0Var, yf.g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return q0Var.a(kotlinTypeRefiner).j();
    }

    public static /* synthetic */ String n(q0 q0Var, pd.k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            kVar = o0.f25029a;
        }
        return q0Var.m(kVar);
    }

    public static final String o(r0 it) {
        kotlin.jvm.internal.t.f(it, "it");
        return it.toString();
    }

    public static final CharSequence q(pd.k kVar, r0 r0Var) {
        kotlin.jvm.internal.t.c(r0Var);
        return kVar.invoke(r0Var).toString();
    }

    @Override // xf.u1
    public fe.h b() {
        return null;
    }

    @Override // xf.u1
    public Collection c() {
        return this.f25039b;
    }

    @Override // xf.u1
    public boolean d() {
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q0) {
            return kotlin.jvm.internal.t.b(this.f25039b, ((q0) obj).f25039b);
        }
        return false;
    }

    @Override // xf.u1
    public List getParameters() {
        return dd.r.k();
    }

    public int hashCode() {
        return this.f25040c;
    }

    public final qf.k i() {
        return qf.x.f19105d.a("member scope for intersection type", this.f25039b);
    }

    public final c1 j() {
        return u0.n(q1.f25042b.k(), this, dd.r.k(), false, i(), new p0(this));
    }

    public final r0 l() {
        return this.f25038a;
    }

    public final String m(pd.k getProperTypeRelatedToStringify) {
        kotlin.jvm.internal.t.f(getProperTypeRelatedToStringify, "getProperTypeRelatedToStringify");
        return dd.a0.i0(dd.a0.A0(this.f25039b, new a(getProperTypeRelatedToStringify)), " & ", "{", "}", 0, null, new n0(getProperTypeRelatedToStringify), 24, null);
    }

    @Override // xf.u1
    public ce.i p() {
        ce.i iVarP = ((r0) this.f25039b.iterator().next()).N0().p();
        kotlin.jvm.internal.t.e(iVarP, "getBuiltIns(...)");
        return iVarP;
    }

    @Override // xf.u1
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public q0 a(yf.g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        Collection collectionC = c();
        ArrayList arrayList = new ArrayList(dd.s.u(collectionC, 10));
        Iterator it = collectionC.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            arrayList.add(((r0) it.next()).X0(kotlinTypeRefiner));
            z10 = true;
        }
        q0 q0VarS = null;
        if (z10) {
            r0 r0VarL = l();
            q0VarS = new q0(arrayList).s(r0VarL != null ? r0VarL.X0(kotlinTypeRefiner) : null);
        }
        return q0VarS == null ? this : q0VarS;
    }

    public final q0 s(r0 r0Var) {
        return new q0(this.f25039b, r0Var);
    }

    public String toString() {
        return n(this, null, 1, null);
    }

    public q0(Collection collection, r0 r0Var) {
        this(collection);
        this.f25038a = r0Var;
    }
}
