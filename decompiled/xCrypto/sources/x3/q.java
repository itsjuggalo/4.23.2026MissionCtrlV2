package x3;

import W2.E;
import a3.AbstractC0787c;
import v3.u;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements w3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f15787a;

    public q(u uVar) {
        this.f15787a = uVar;
    }

    @Override // w3.e
    public Object emit(Object obj, Z2.e eVar) {
        Object objA = this.f15787a.a(obj, eVar);
        return objA == AbstractC0787c.e() ? objA : E.f5463a;
    }
}
