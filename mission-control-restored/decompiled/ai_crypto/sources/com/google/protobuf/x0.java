package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public class x0 extends v0 {
    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public w0 g(Object obj) {
        return ((AbstractC1255y) obj).unknownFields;
    }

    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public int h(w0 w0Var) {
        return w0Var.d();
    }

    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public int i(w0 w0Var) {
        return w0Var.e();
    }

    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public w0 k(w0 w0Var, w0 w0Var2) {
        return w0.c().equals(w0Var2) ? w0Var : w0.c().equals(w0Var) ? w0.j(w0Var, w0Var2) : w0Var.i(w0Var2);
    }

    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public w0 n() {
        return w0.k();
    }

    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public void o(Object obj, w0 w0Var) {
        p(obj, w0Var);
    }

    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void p(Object obj, w0 w0Var) {
        ((AbstractC1255y) obj).unknownFields = w0Var;
    }

    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public w0 r(w0 w0Var) {
        w0Var.h();
        return w0Var;
    }

    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public void s(w0 w0Var, C0 c02) {
        w0Var.p(c02);
    }

    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(w0 w0Var, C0 c02) {
        w0Var.r(c02);
    }

    @Override // com.google.protobuf.v0
    public void j(Object obj) {
        g(obj).h();
    }

    @Override // com.google.protobuf.v0
    public boolean q(l0 l0Var) {
        return false;
    }

    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(w0 w0Var, int i7, int i8) {
        w0Var.n(B0.c(i7, 5), Integer.valueOf(i8));
    }

    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(w0 w0Var, int i7, long j7) {
        w0Var.n(B0.c(i7, 1), Long.valueOf(j7));
    }

    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(w0 w0Var, int i7, w0 w0Var2) {
        w0Var.n(B0.c(i7, 3), w0Var2);
    }

    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void d(w0 w0Var, int i7, AbstractC1240i abstractC1240i) {
        w0Var.n(B0.c(i7, 2), abstractC1240i);
    }

    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(w0 w0Var, int i7, long j7) {
        w0Var.n(B0.c(i7, 0), Long.valueOf(j7));
    }

    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public w0 f(Object obj) {
        w0 w0VarG = g(obj);
        if (w0VarG != w0.c()) {
            return w0VarG;
        }
        w0 w0VarK = w0.k();
        p(obj, w0VarK);
        return w0VarK;
    }
}
