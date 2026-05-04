package j8;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f14006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g0 f14007b;

    public h0(l lVar, g0 g0Var) {
        this.f14006a = lVar;
        this.f14007b = g0Var;
    }

    public r8.n a(r8.b bVar, o8.a aVar) {
        return this.f14007b.c(this.f14006a, bVar, aVar);
    }

    public r8.n b(r8.n nVar) {
        return c(nVar, Collections.EMPTY_LIST);
    }

    public r8.n c(r8.n nVar, List list) {
        return d(nVar, list, false);
    }

    public r8.n d(r8.n nVar, List list, boolean z10) {
        return this.f14007b.d(this.f14006a, nVar, list, z10);
    }

    public r8.n e(r8.n nVar) {
        return this.f14007b.e(this.f14006a, nVar);
    }

    public r8.n f(l lVar, r8.n nVar, r8.n nVar2) {
        return this.f14007b.f(this.f14006a, lVar, nVar, nVar2);
    }

    public r8.m g(r8.n nVar, r8.m mVar, boolean z10, r8.h hVar) {
        return this.f14007b.g(this.f14006a, nVar, mVar, z10, hVar);
    }

    public h0 h(r8.b bVar) {
        return new h0(this.f14006a.v(bVar), this.f14007b);
    }

    public r8.n i(l lVar) {
        return this.f14007b.o(this.f14006a.u(lVar));
    }
}
