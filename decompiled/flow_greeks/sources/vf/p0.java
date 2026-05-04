package vf;

import fe.g1;
import fe.k1;
import fe.p1;
import java.util.List;
import xf.c1;
import xf.e2;
import xf.f2;
import xf.m2;
import xf.v0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class p0 extends ie.g implements t {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ze.r f23476k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final bf.c f23477l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final bf.g f23478m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final bf.h f23479n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final s f23480o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c1 f23481p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public c1 f23482q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f23483r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public c1 f23484s;

    /* JADX WARN: Illegal instructions before constructor call */
    public p0(wf.n storageManager, fe.m containingDeclaration, ge.h annotations, ef.f name, fe.u visibility, ze.r proto, bf.c nameResolver, bf.g typeTable, bf.h versionRequirementTable, s sVar) {
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.t.f(annotations, "annotations");
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(visibility, "visibility");
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.t.f(typeTable, "typeTable");
        kotlin.jvm.internal.t.f(versionRequirementTable, "versionRequirementTable");
        g1 NO_SOURCE = g1.f9483a;
        kotlin.jvm.internal.t.e(NO_SOURCE, "NO_SOURCE");
        super(storageManager, containingDeclaration, annotations, name, NO_SOURCE, visibility);
        this.f23476k = proto;
        this.f23477l = nameResolver;
        this.f23478m = typeTable;
        this.f23479n = versionRequirementTable;
        this.f23480o = sVar;
    }

    @Override // ie.g
    public List R0() {
        List list = this.f23483r;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.t.s("typeConstructorParameters");
        return null;
    }

    @Override // vf.t
    public bf.g U() {
        return this.f23478m;
    }

    @Override // vf.t
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public ze.r F() {
        return this.f23476k;
    }

    public bf.h V0() {
        return this.f23479n;
    }

    public final void W0(List declaredTypeParameters, c1 underlyingType, c1 expandedType) {
        kotlin.jvm.internal.t.f(declaredTypeParameters, "declaredTypeParameters");
        kotlin.jvm.internal.t.f(underlyingType, "underlyingType");
        kotlin.jvm.internal.t.f(expandedType, "expandedType");
        S0(declaredTypeParameters);
        this.f23481p = underlyingType;
        this.f23482q = expandedType;
        this.f23483r = p1.g(this);
        this.f23484s = M0();
    }

    @Override // fe.k1
    public c1 X() {
        c1 c1Var = this.f23482q;
        if (c1Var != null) {
            return c1Var;
        }
        kotlin.jvm.internal.t.s("expandedType");
        return null;
    }

    @Override // fe.i1
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public k1 c(f2 substitutor) {
        kotlin.jvm.internal.t.f(substitutor, "substitutor");
        if (substitutor.k()) {
            return this;
        }
        wf.n nVarG0 = g0();
        fe.m mVarB = b();
        kotlin.jvm.internal.t.e(mVarB, "getContainingDeclaration(...)");
        ge.h annotations = getAnnotations();
        kotlin.jvm.internal.t.e(annotations, "<get-annotations>(...)");
        ef.f name = getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        p0 p0Var = new p0(nVarG0, mVarB, annotations, name, getVisibility(), F(), a0(), U(), V0(), c0());
        List listV = v();
        c1 c1VarF0 = f0();
        m2 m2Var = m2.f25015e;
        xf.r0 r0VarN = substitutor.n(c1VarF0, m2Var);
        kotlin.jvm.internal.t.e(r0VarN, "safeSubstitute(...)");
        c1 c1VarA = e2.a(r0VarN);
        xf.r0 r0VarN2 = substitutor.n(X(), m2Var);
        kotlin.jvm.internal.t.e(r0VarN2, "safeSubstitute(...)");
        p0Var.W0(listV, c1VarA, e2.a(r0VarN2));
        return p0Var;
    }

    @Override // vf.t
    public bf.c a0() {
        return this.f23477l;
    }

    @Override // vf.t
    public s c0() {
        return this.f23480o;
    }

    @Override // fe.k1
    public c1 f0() {
        c1 c1Var = this.f23481p;
        if (c1Var != null) {
            return c1Var;
        }
        kotlin.jvm.internal.t.s("underlyingType");
        return null;
    }

    @Override // fe.k1
    public fe.e r() {
        if (v0.a(X())) {
            return null;
        }
        fe.h hVarB = X().N0().b();
        if (hVarB instanceof fe.e) {
            return (fe.e) hVarB;
        }
        return null;
    }

    @Override // fe.h
    public c1 s() {
        c1 c1Var = this.f23484s;
        if (c1Var != null) {
            return c1Var;
        }
        kotlin.jvm.internal.t.s("defaultTypeImpl");
        return null;
    }
}
