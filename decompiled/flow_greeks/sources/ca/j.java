package ca;

import aa.m3;
import aa.n3;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f3780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f3781b;

    public j(d dVar, bd.a aVar) {
        this.f3780a = dVar;
        this.f3781b = aVar;
    }

    public static j a(d dVar, bd.a aVar) {
        return new j(dVar, aVar);
    }

    public static n3 c(d dVar, m3 m3Var) {
        return (n3) r9.d.e(dVar.f(m3Var));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public n3 get() {
        return c(this.f3780a, (m3) this.f3781b.get());
    }
}
