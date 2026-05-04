package vf;

import fe.b;
import fe.g1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends ie.i implements b {
    public final ze.d F;
    public final bf.c G;
    public final bf.g H;
    public final bf.h I;
    public final s Q;

    public /* synthetic */ c(fe.e eVar, fe.l lVar, ge.h hVar, boolean z10, b.a aVar, ze.d dVar, bf.c cVar, bf.g gVar, bf.h hVar2, s sVar, g1 g1Var, int i10, kotlin.jvm.internal.k kVar) {
        this(eVar, lVar, hVar, z10, aVar, dVar, cVar, gVar, hVar2, sVar, (i10 & 1024) != 0 ? null : g1Var);
    }

    @Override // ie.s, fe.z
    public boolean R() {
        return false;
    }

    @Override // vf.t
    public bf.g U() {
        return this.H;
    }

    @Override // vf.t
    public bf.c a0() {
        return this.G;
    }

    @Override // vf.t
    public s c0() {
        return this.Q;
    }

    @Override // ie.s, fe.d0
    public boolean isExternal() {
        return false;
    }

    @Override // ie.s, fe.z
    public boolean isInline() {
        return false;
    }

    @Override // ie.s, fe.z
    public boolean isSuspend() {
        return false;
    }

    @Override // ie.i
    /* JADX INFO: renamed from: s1, reason: merged with bridge method [inline-methods] */
    public c L0(fe.m newOwner, fe.z zVar, b.a kind, ef.f fVar, ge.h annotations, g1 source) {
        kotlin.jvm.internal.t.f(newOwner, "newOwner");
        kotlin.jvm.internal.t.f(kind, "kind");
        kotlin.jvm.internal.t.f(annotations, "annotations");
        kotlin.jvm.internal.t.f(source, "source");
        c cVar = new c((fe.e) newOwner, (fe.l) zVar, annotations, this.E, kind, F(), a0(), U(), u1(), c0(), source);
        cVar.Y0(Q0());
        return cVar;
    }

    @Override // vf.t
    /* JADX INFO: renamed from: t1, reason: merged with bridge method [inline-methods] */
    public ze.d F() {
        return this.F;
    }

    public bf.h u1() {
        return this.I;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public c(fe.e r12, fe.l r13, ge.h r14, boolean r15, fe.b.a r16, ze.d r17, bf.c r18, bf.g r19, bf.h r20, vf.s r21, fe.g1 r22) {
        /*
            r11 = this;
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            java.lang.String r0 = "containingDeclaration"
            kotlin.jvm.internal.t.f(r12, r0)
            java.lang.String r0 = "annotations"
            kotlin.jvm.internal.t.f(r14, r0)
            java.lang.String r0 = "kind"
            r5 = r16
            kotlin.jvm.internal.t.f(r5, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.t.f(r7, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.t.f(r8, r0)
            java.lang.String r0 = "typeTable"
            kotlin.jvm.internal.t.f(r9, r0)
            java.lang.String r0 = "versionRequirementTable"
            kotlin.jvm.internal.t.f(r10, r0)
            if (r22 != 0) goto L38
            fe.g1 r0 = fe.g1.f9483a
            r6 = r0
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r0 = r11
            goto L3f
        L38:
            r6 = r22
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
        L3f:
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r11.F = r7
            r11.G = r8
            r11.H = r9
            r11.I = r10
            r1 = r21
            r11.Q = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: vf.c.<init>(fe.e, fe.l, ge.h, boolean, fe.b$a, ze.d, bf.c, bf.g, bf.h, vf.s, fe.g1):void");
    }
}
