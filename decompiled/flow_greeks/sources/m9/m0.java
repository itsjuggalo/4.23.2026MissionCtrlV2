package m9;

import g9.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f16213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o0 f16214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f16215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f16216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f16217e;

    public n a(j.a aVar) {
        return new j(aVar.f10244a);
    }

    public q b(j.a aVar) {
        return new q(aVar.f10245b, j(), h());
    }

    public y c(j.a aVar) {
        return new y(aVar.f10245b, aVar.f10249f, aVar.f10250g, aVar.f10246c.a(), aVar.f10251h, i());
    }

    public h0 d(j.a aVar) {
        return new h0(aVar.f10245b, aVar.f10244a, aVar.f10246c, new u(aVar.f10249f, aVar.f10250g));
    }

    public o0 e(j.a aVar) {
        return new o0(aVar.f10246c.a());
    }

    public n f() {
        return (n) n9.b.e(this.f16217e, "connectivityMonitor not initialized yet", new Object[0]);
    }

    public q g() {
        return (q) n9.b.e(this.f16216d, "datastore not initialized yet", new Object[0]);
    }

    public y h() {
        return (y) n9.b.e(this.f16215c, "firestoreChannel not initialized yet", new Object[0]);
    }

    public h0 i() {
        return (h0) n9.b.e(this.f16213a, "grpcCallProvider not initialized yet", new Object[0]);
    }

    public o0 j() {
        return (o0) n9.b.e(this.f16214b, "remoteSerializer not initialized yet", new Object[0]);
    }

    public void k(j.a aVar) {
        this.f16214b = e(aVar);
        this.f16213a = d(aVar);
        this.f16215c = c(aVar);
        this.f16216d = b(aVar);
        this.f16217e = a(aVar);
    }
}
