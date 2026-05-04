package com.google.protobuf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class w1 extends u1 {
    @Override // com.google.protobuf.u1
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public v1 g(Object obj) {
        return ((y) obj).unknownFields;
    }

    @Override // com.google.protobuf.u1
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public int h(v1 v1Var) {
        return v1Var.d();
    }

    @Override // com.google.protobuf.u1
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public int i(v1 v1Var) {
        return v1Var.e();
    }

    @Override // com.google.protobuf.u1
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public v1 k(v1 v1Var, v1 v1Var2) {
        return v1.c().equals(v1Var2) ? v1Var : v1.c().equals(v1Var) ? v1.j(v1Var, v1Var2) : v1Var.i(v1Var2);
    }

    @Override // com.google.protobuf.u1
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public v1 n() {
        return v1.k();
    }

    @Override // com.google.protobuf.u1
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public void o(Object obj, v1 v1Var) {
        p(obj, v1Var);
    }

    @Override // com.google.protobuf.u1
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void p(Object obj, v1 v1Var) {
        ((y) obj).unknownFields = v1Var;
    }

    @Override // com.google.protobuf.u1
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public v1 r(v1 v1Var) {
        v1Var.h();
        return v1Var;
    }

    @Override // com.google.protobuf.u1
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public void s(v1 v1Var, b2 b2Var) {
        v1Var.p(b2Var);
    }

    @Override // com.google.protobuf.u1
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(v1 v1Var, b2 b2Var) {
        v1Var.r(b2Var);
    }

    @Override // com.google.protobuf.u1
    public void j(Object obj) {
        g(obj).h();
    }

    @Override // com.google.protobuf.u1
    public boolean q(k1 k1Var) {
        return false;
    }

    @Override // com.google.protobuf.u1
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(v1 v1Var, int i10, int i11) {
        v1Var.n(a2.c(i10, 5), Integer.valueOf(i11));
    }

    @Override // com.google.protobuf.u1
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(v1 v1Var, int i10, long j10) {
        v1Var.n(a2.c(i10, 1), Long.valueOf(j10));
    }

    @Override // com.google.protobuf.u1
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(v1 v1Var, int i10, v1 v1Var2) {
        v1Var.n(a2.c(i10, 3), v1Var2);
    }

    @Override // com.google.protobuf.u1
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void d(v1 v1Var, int i10, i iVar) {
        v1Var.n(a2.c(i10, 2), iVar);
    }

    @Override // com.google.protobuf.u1
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(v1 v1Var, int i10, long j10) {
        v1Var.n(a2.c(i10, 0), Long.valueOf(j10));
    }

    @Override // com.google.protobuf.u1
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public v1 f(Object obj) {
        v1 v1VarG = g(obj);
        if (v1VarG != v1.c()) {
            return v1VarG;
        }
        v1 v1VarK = v1.k();
        p(obj, v1VarK);
        return v1VarK;
    }
}
