package com.google.protobuf;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f6933a = q.b();

    public final u0 d(u0 u0Var) throws d0 {
        if (u0Var == null || u0Var.d()) {
            return u0Var;
        }
        throw e(u0Var).a().k(u0Var);
    }

    public final t1 e(u0 u0Var) {
        return u0Var instanceof a ? ((a) u0Var).n() : new t1(u0Var);
    }

    @Override // com.google.protobuf.e1
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public u0 b(j jVar, q qVar) {
        return d((u0) c(jVar, qVar));
    }

    @Override // com.google.protobuf.e1
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public u0 a(InputStream inputStream) {
        return h(inputStream, f6933a);
    }

    public u0 h(InputStream inputStream, q qVar) {
        return d(i(inputStream, qVar));
    }

    public u0 i(InputStream inputStream, q qVar) throws d0 {
        j jVarG = j.g(inputStream);
        u0 u0Var = (u0) c(jVarG, qVar);
        try {
            jVarG.a(0);
            return u0Var;
        } catch (d0 e10) {
            throw e10.k(u0Var);
        }
    }
}
