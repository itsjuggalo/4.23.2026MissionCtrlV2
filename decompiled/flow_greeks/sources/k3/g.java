package k3;

import i3.v;
import k3.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g extends c4.h implements h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h.a f14504e;

    public g(long j10) {
        super(j10);
    }

    @Override // k3.h
    public void a(int i10) {
        if (i10 >= 40) {
            b();
        } else if (i10 >= 20 || i10 == 15) {
            m(h() / 2);
        }
    }

    @Override // k3.h
    public /* bridge */ /* synthetic */ v c(g3.f fVar) {
        return (v) super.l(fVar);
    }

    @Override // k3.h
    public /* bridge */ /* synthetic */ v d(g3.f fVar, v vVar) {
        return (v) super.k(fVar, vVar);
    }

    @Override // k3.h
    public void e(h.a aVar) {
        this.f14504e = aVar;
    }

    @Override // c4.h
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int i(v vVar) {
        return vVar == null ? super.i(null) : vVar.c();
    }

    @Override // c4.h
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(g3.f fVar, v vVar) {
        h.a aVar = this.f14504e;
        if (aVar == null || vVar == null) {
            return;
        }
        aVar.d(vVar);
    }
}
