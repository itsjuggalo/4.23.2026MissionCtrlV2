package vf;

import vf.m;

/* JADX INFO: loaded from: classes3.dex */
public class o implements pd.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m.c f23473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f23474b;

    public o(m.c cVar, m mVar) {
        this.f23473a = cVar;
        this.f23474b = mVar;
    }

    @Override // pd.k
    public Object invoke(Object obj) {
        return m.c.f(this.f23473a, this.f23474b, (ef.f) obj);
    }
}
