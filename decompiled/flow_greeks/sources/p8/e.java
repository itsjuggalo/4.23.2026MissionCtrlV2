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
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f18425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f18426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f18427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f18428d;

    public e(o8.h hVar) {
        this.f18425a = new b(hVar.d());
        this.f18426b = hVar.d();
        this.f18427c = i(hVar);
        this.f18428d = g(hVar);
    }

    public static m g(o8.h hVar) {
        if (!hVar.m()) {
            return hVar.d().g();
        }
        return hVar.d().f(hVar.e(), hVar.f());
    }

    public static m i(o8.h hVar) {
        if (!hVar.o()) {
            return hVar.d().h();
        }
        return hVar.d().f(hVar.g(), hVar.h());
    }

    @Override // p8.d
    public d a() {
        return this.f18425a;
    }

    @Override // p8.d
    public boolean b() {
        return true;
    }

    @Override // p8.d
    public i c(i iVar, i iVar2, a aVar) {
        i iVarD;
        if (iVar2.g().J()) {
            iVarD = i.d(g.y(), this.f18426b);
        } else {
            i iVarS = iVar2.s(r.a());
            Iterator it = iVar2.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                if (!j(mVar)) {
                    iVarS = iVarS.r(mVar.c(), g.y());
                }
            }
            iVarD = iVarS;
        }
        return this.f18425a.c(iVar, iVarD, aVar);
    }

    @Override // p8.d
    public i e(i iVar, r8.b bVar, n nVar, l lVar, d.a aVar, a aVar2) {
        if (!j(new m(bVar, nVar))) {
            nVar = g.y();
        }
        return this.f18425a.e(iVar, bVar, nVar, lVar, aVar, aVar2);
    }

    public m f() {
        return this.f18428d;
    }

    @Override // p8.d
    public h getIndex() {
        return this.f18426b;
    }

    public m h() {
        return this.f18427c;
    }

    public boolean j(m mVar) {
        return this.f18426b.compare(h(), mVar) <= 0 && this.f18426b.compare(mVar, f()) <= 0;
    }

    @Override // p8.d
    public i d(i iVar, n nVar) {
        return iVar;
    }
}
