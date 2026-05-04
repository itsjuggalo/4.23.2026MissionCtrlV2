package vf;

import fe.b;
import fe.g1;
import fe.y0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n0 extends ie.k0 implements b {
    public final ze.n C;
    public final bf.c D;
    public final bf.g E;
    public final bf.h F;
    public final s G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(fe.m containingDeclaration, y0 y0Var, ge.h annotations, fe.e0 modality, fe.u visibility, boolean z10, ef.f name, b.a kind, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, ze.n proto, bf.c nameResolver, bf.g typeTable, bf.h versionRequirementTable, s sVar) {
        super(containingDeclaration, y0Var, annotations, modality, visibility, z10, name, kind, g1.f9483a, z11, z12, z15, false, z13, z14);
        kotlin.jvm.internal.t.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.t.f(annotations, "annotations");
        kotlin.jvm.internal.t.f(modality, "modality");
        kotlin.jvm.internal.t.f(visibility, "visibility");
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(kind, "kind");
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.t.f(typeTable, "typeTable");
        kotlin.jvm.internal.t.f(versionRequirementTable, "versionRequirementTable");
        this.C = proto;
        this.D = nameResolver;
        this.E = typeTable;
        this.F = versionRequirementTable;
        this.G = sVar;
    }

    @Override // ie.k0
    public ie.k0 P0(fe.m newOwner, fe.e0 newModality, fe.u newVisibility, y0 y0Var, b.a kind, ef.f newName, g1 source) {
        kotlin.jvm.internal.t.f(newOwner, "newOwner");
        kotlin.jvm.internal.t.f(newModality, "newModality");
        kotlin.jvm.internal.t.f(newVisibility, "newVisibility");
        kotlin.jvm.internal.t.f(kind, "kind");
        kotlin.jvm.internal.t.f(newName, "newName");
        kotlin.jvm.internal.t.f(source, "source");
        return new n0(newOwner, y0Var, getAnnotations(), newModality, newVisibility, i0(), newName, kind, q0(), A(), isExternal(), Q(), N(), F(), a0(), U(), g1(), c0());
    }

    @Override // vf.t
    public bf.g U() {
        return this.E;
    }

    @Override // vf.t
    public bf.c a0() {
        return this.D;
    }

    @Override // vf.t
    public s c0() {
        return this.G;
    }

    @Override // vf.t
    /* JADX INFO: renamed from: f1, reason: merged with bridge method [inline-methods] */
    public ze.n F() {
        return this.C;
    }

    public bf.h g1() {
        return this.F;
    }

    @Override // ie.k0, fe.d0
    public boolean isExternal() {
        Boolean boolD = bf.b.E.d(F().a0());
        kotlin.jvm.internal.t.e(boolD, "get(...)");
        return boolD.booleanValue();
    }
}
