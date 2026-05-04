package p8;

import j8.l;
import m8.m;
import p8.d;
import r8.h;
import r8.i;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f18420a;

    public b(h hVar) {
        this.f18420a = hVar;
    }

    @Override // p8.d
    public boolean b() {
        return false;
    }

    @Override // p8.d
    public i c(i iVar, i iVar2, a aVar) {
        m.g(iVar2.q(this.f18420a), "Can't use IndexedNode that doesn't have filter's index");
        if (aVar != null) {
            for (r8.m mVar : iVar.g()) {
                if (!iVar2.g().F(mVar.c())) {
                    aVar.b(o8.c.h(mVar.c(), mVar.d()));
                }
            }
            if (!iVar2.g().J()) {
                for (r8.m mVar2 : iVar2.g()) {
                    if (iVar.g().F(mVar2.c())) {
                        n nVarZ = iVar.g().z(mVar2.c());
                        if (!nVarZ.equals(mVar2.d())) {
                            aVar.b(o8.c.e(mVar2.c(), mVar2.d(), nVarZ));
                        }
                    } else {
                        aVar.b(o8.c.c(mVar2.c(), mVar2.d()));
                    }
                }
            }
        }
        return iVar2;
    }

    @Override // p8.d
    public i d(i iVar, n nVar) {
        return iVar.g().isEmpty() ? iVar : iVar.s(nVar);
    }

    @Override // p8.d
    public i e(i iVar, r8.b bVar, n nVar, l lVar, d.a aVar, a aVar2) {
        m.g(iVar.q(this.f18420a), "The index must match the filter");
        n nVarG = iVar.g();
        n nVarZ = nVarG.z(bVar);
        if (!nVarZ.O(lVar).equals(nVar.O(lVar)) || nVarZ.isEmpty() != nVar.isEmpty()) {
            if (aVar2 != null) {
                if (nVar.isEmpty()) {
                    if (nVarG.F(bVar)) {
                        aVar2.b(o8.c.h(bVar, nVarZ));
                    } else {
                        m.g(nVarG.J(), "A child remove without an old child only makes sense on a leaf node");
                    }
                } else if (nVarZ.isEmpty()) {
                    aVar2.b(o8.c.c(bVar, nVar));
                } else {
                    aVar2.b(o8.c.e(bVar, nVar, nVarZ));
                }
            }
            if (!nVarG.J() || !nVar.isEmpty()) {
                return iVar.r(bVar, nVar);
            }
        }
        return iVar;
    }

    @Override // p8.d
    public h getIndex() {
        return this.f18420a;
    }

    @Override // p8.d
    public d a() {
        return this;
    }
}
