package vf;

import fe.b;
import fe.f1;
import fe.g1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o0 extends ie.o0 implements b {
    public final ze.i E;
    public final bf.c F;
    public final bf.g G;
    public final bf.h H;
    public final s I;

    public /* synthetic */ o0(fe.m mVar, f1 f1Var, ge.h hVar, ef.f fVar, b.a aVar, ze.i iVar, bf.c cVar, bf.g gVar, bf.h hVar2, s sVar, g1 g1Var, int i10, kotlin.jvm.internal.k kVar) {
        this(mVar, f1Var, hVar, fVar, aVar, iVar, cVar, gVar, hVar2, sVar, (i10 & 1024) != 0 ? null : g1Var);
    }

    @Override // ie.o0, ie.s
    public ie.s L0(fe.m newOwner, fe.z zVar, b.a kind, ef.f fVar, ge.h annotations, g1 source) {
        ef.f fVar2;
        kotlin.jvm.internal.t.f(newOwner, "newOwner");
        kotlin.jvm.internal.t.f(kind, "kind");
        kotlin.jvm.internal.t.f(annotations, "annotations");
        kotlin.jvm.internal.t.f(source, "source");
        f1 f1Var = (f1) zVar;
        if (fVar == null) {
            ef.f name = getName();
            kotlin.jvm.internal.t.e(name, "getName(...)");
            fVar2 = name;
        } else {
            fVar2 = fVar;
        }
        o0 o0Var = new o0(newOwner, f1Var, annotations, fVar2, kind, F(), a0(), U(), q1(), c0(), source);
        o0Var.Y0(Q0());
        return o0Var;
    }

    @Override // vf.t
    public bf.g U() {
        return this.G;
    }

    @Override // vf.t
    public bf.c a0() {
        return this.F;
    }

    @Override // vf.t
    public s c0() {
        return this.I;
    }

    @Override // vf.t
    /* JADX INFO: renamed from: p1, reason: merged with bridge method [inline-methods] */
    public ze.i F() {
        return this.E;
    }

    public bf.h q1() {
        return this.H;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public o0(fe.m r12, fe.f1 r13, ge.h r14, ef.f r15, fe.b.a r16, ze.i r17, bf.c r18, bf.g r19, bf.h r20, vf.s r21, fe.g1 r22) {
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
            java.lang.String r0 = "name"
            kotlin.jvm.internal.t.f(r15, r0)
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
            if (r22 != 0) goto L3d
            fe.g1 r0 = fe.g1.f9483a
            r6 = r0
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r0 = r11
            goto L44
        L3d:
            r6 = r22
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
        L44:
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r11.E = r7
            r11.F = r8
            r11.G = r9
            r11.H = r10
            r1 = r21
            r11.I = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: vf.o0.<init>(fe.m, fe.f1, ge.h, ef.f, fe.b$a, ze.i, bf.c, bf.g, bf.h, vf.s, fe.g1):void");
    }
}
