package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public class h0 extends f0 {
    @Override // com.google.protobuf.f0
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public g0 g(Object obj) {
        return ((AbstractC1480t) obj).unknownFields;
    }

    @Override // com.google.protobuf.f0
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public int h(g0 g0Var) {
        return g0Var.d();
    }

    @Override // com.google.protobuf.f0
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public int i(g0 g0Var) {
        return g0Var.e();
    }

    @Override // com.google.protobuf.f0
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public g0 k(g0 g0Var, g0 g0Var2) {
        return g0.c().equals(g0Var2) ? g0Var : g0.c().equals(g0Var) ? g0.j(g0Var, g0Var2) : g0Var.i(g0Var2);
    }

    @Override // com.google.protobuf.f0
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public g0 n() {
        return g0.k();
    }

    @Override // com.google.protobuf.f0
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public void o(Object obj, g0 g0Var) {
        p(obj, g0Var);
    }

    @Override // com.google.protobuf.f0
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void p(Object obj, g0 g0Var) {
        ((AbstractC1480t) obj).unknownFields = g0Var;
    }

    @Override // com.google.protobuf.f0
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public g0 r(g0 g0Var) {
        g0Var.h();
        return g0Var;
    }

    @Override // com.google.protobuf.f0
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public void s(g0 g0Var, m0 m0Var) {
        g0Var.p(m0Var);
    }

    @Override // com.google.protobuf.f0
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(g0 g0Var, m0 m0Var) {
        g0Var.r(m0Var);
    }

    @Override // com.google.protobuf.f0
    public void j(Object obj) {
        g(obj).h();
    }

    @Override // com.google.protobuf.f0
    public boolean q(X x8) {
        return false;
    }

    @Override // com.google.protobuf.f0
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(g0 g0Var, int i8, int i9) {
        g0Var.n(l0.c(i8, 5), Integer.valueOf(i9));
    }

    @Override // com.google.protobuf.f0
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(g0 g0Var, int i8, long j8) {
        g0Var.n(l0.c(i8, 1), Long.valueOf(j8));
    }

    @Override // com.google.protobuf.f0
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(g0 g0Var, int i8, g0 g0Var2) {
        g0Var.n(l0.c(i8, 3), g0Var2);
    }

    @Override // com.google.protobuf.f0
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void d(g0 g0Var, int i8, AbstractC1467f abstractC1467f) {
        g0Var.n(l0.c(i8, 2), abstractC1467f);
    }

    @Override // com.google.protobuf.f0
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(g0 g0Var, int i8, long j8) {
        g0Var.n(l0.c(i8, 0), Long.valueOf(j8));
    }

    @Override // com.google.protobuf.f0
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public g0 f(Object obj) {
        g0 g0VarG = g(obj);
        if (g0VarG != g0.c()) {
            return g0VarG;
        }
        g0 g0VarK = g0.k();
        p(obj, g0VarK);
        return g0VarK;
    }
}
