package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g1 extends e1 {
    @Override // androidx.datastore.preferences.protobuf.e1
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public f1 g(Object obj) {
        return ((t) obj).unknownFields;
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public int h(f1 f1Var) {
        return f1Var.d();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public int i(f1 f1Var) {
        return f1Var.e();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public f1 k(f1 f1Var, f1 f1Var2) {
        return f1.c().equals(f1Var2) ? f1Var : f1.c().equals(f1Var) ? f1.j(f1Var, f1Var2) : f1Var.i(f1Var2);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public f1 n() {
        return f1.k();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public void o(Object obj, f1 f1Var) {
        p(obj, f1Var);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void p(Object obj, f1 f1Var) {
        ((t) obj).unknownFields = f1Var;
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public f1 r(f1 f1Var) {
        f1Var.h();
        return f1Var;
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public void s(f1 f1Var, k1 k1Var) {
        f1Var.p(k1Var);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(f1 f1Var, k1 k1Var) {
        f1Var.r(k1Var);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void j(Object obj) {
        g(obj).h();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public boolean q(w0 w0Var) {
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(f1 f1Var, int i10, int i11) {
        f1Var.n(j1.c(i10, 5), Integer.valueOf(i11));
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(f1 f1Var, int i10, long j10) {
        f1Var.n(j1.c(i10, 1), Long.valueOf(j10));
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(f1 f1Var, int i10, f1 f1Var2) {
        f1Var.n(j1.c(i10, 3), f1Var2);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void d(f1 f1Var, int i10, f fVar) {
        f1Var.n(j1.c(i10, 2), fVar);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(f1 f1Var, int i10, long j10) {
        f1Var.n(j1.c(i10, 0), Long.valueOf(j10));
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public f1 f(Object obj) {
        f1 f1VarG = g(obj);
        if (f1VarG != f1.c()) {
            return f1VarG;
        }
        f1 f1VarK = f1.k();
        p(obj, f1VarK);
        return f1VarK;
    }
}
