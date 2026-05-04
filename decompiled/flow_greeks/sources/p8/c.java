package p8;

import j8.l;
import java.util.Iterator;
import p8.d;
import r8.g;
import r8.h;
import r8.i;
import r8.m;
import r8.n;
import r8.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f18421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f18422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18424d;

    public c(o8.h hVar) {
        this.f18421a = new e(hVar);
        this.f18422b = hVar.d();
        this.f18423c = hVar.i();
        this.f18424d = !hVar.r();
    }

    @Override // p8.d
    public d a() {
        return this.f18421a.a();
    }

    @Override // p8.d
    public boolean b() {
        return true;
    }

    @Override // p8.d
    public i c(i iVar, i iVar2, a aVar) {
        i iVarD;
        Iterator it;
        m mVarH;
        m mVarF;
        int i10;
        if (iVar2.g().J() || iVar2.g().isEmpty()) {
            iVarD = i.d(g.y(), this.f18422b);
        } else {
            iVarD = iVar2.s(r.a());
            if (this.f18424d) {
                it = iVar2.P();
                mVarH = this.f18421a.f();
                mVarF = this.f18421a.h();
                i10 = -1;
            } else {
                it = iVar2.iterator();
                mVarH = this.f18421a.h();
                mVarF = this.f18421a.f();
                i10 = 1;
            }
            boolean z10 = false;
            int i11 = 0;
            while (it.hasNext()) {
                m mVar = (m) it.next();
                if (!z10 && this.f18422b.compare(mVarH, mVar) * i10 <= 0) {
                    z10 = true;
                }
                if (!z10 || i11 >= this.f18423c || this.f18422b.compare(mVar, mVarF) * i10 > 0) {
                    iVarD = iVarD.r(mVar.c(), g.y());
                } else {
                    i11++;
                }
            }
        }
        return this.f18421a.a().c(iVar, iVarD, aVar);
    }

    @Override // p8.d
    public i e(i iVar, r8.b bVar, n nVar, l lVar, d.a aVar, a aVar2) {
        if (!this.f18421a.j(new m(bVar, nVar))) {
            nVar = g.y();
        }
        n nVar2 = nVar;
        return iVar.g().z(bVar).equals(nVar2) ? iVar : iVar.g().j() < this.f18423c ? this.f18421a.a().e(iVar, bVar, nVar2, lVar, aVar, aVar2) : f(iVar, bVar, nVar2, aVar, aVar2);
    }

    public final i f(i iVar, r8.b bVar, n nVar, d.a aVar, a aVar2) {
        m8.m.f(iVar.g().j() == this.f18423c);
        m mVar = new m(bVar, nVar);
        m mVarE = this.f18424d ? iVar.e() : iVar.f();
        boolean zJ = this.f18421a.j(mVar);
        if (!iVar.g().F(bVar)) {
            if (nVar.isEmpty() || !zJ || this.f18422b.a(mVarE, mVar, this.f18424d) < 0) {
                return iVar;
            }
            if (aVar2 != null) {
                aVar2.b(o8.c.h(mVarE.c(), mVarE.d()));
                aVar2.b(o8.c.c(bVar, nVar));
            }
            return iVar.r(bVar, nVar).r(mVarE.c(), g.y());
        }
        n nVarZ = iVar.g().z(bVar);
        m mVarA = aVar.a(this.f18422b, mVarE, this.f18424d);
        while (mVarA != null && (mVarA.c().equals(bVar) || iVar.g().F(mVarA.c()))) {
            mVarA = aVar.a(this.f18422b, mVarA, this.f18424d);
        }
        int iA = mVarA != null ? this.f18422b.a(mVarA, mVar, this.f18424d) : 1;
        if (zJ && !nVar.isEmpty() && iA >= 0) {
            if (aVar2 != null) {
                aVar2.b(o8.c.e(bVar, nVar, nVarZ));
            }
            return iVar.r(bVar, nVar);
        }
        if (aVar2 != null) {
            aVar2.b(o8.c.h(bVar, nVarZ));
        }
        i iVarR = iVar.r(bVar, g.y());
        if (mVarA == null || !this.f18421a.j(mVarA)) {
            return iVarR;
        }
        if (aVar2 != null) {
            aVar2.b(o8.c.c(mVarA.c(), mVarA.d()));
        }
        return iVarR.r(mVarA.c(), mVarA.d());
    }

    @Override // p8.d
    public h getIndex() {
        return this.f18422b;
    }

    @Override // p8.d
    public i d(i iVar, n nVar) {
        return iVar;
    }
}
