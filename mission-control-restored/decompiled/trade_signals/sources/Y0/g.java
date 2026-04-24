package Y0;

import W0.v;
import Y0.h;
import q1.C2625h;

/* JADX INFO: loaded from: classes.dex */
public class g extends C2625h implements h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h.a f9508e;

    public g(long j8) {
        super(j8);
    }

    @Override // Y0.h
    public void a(int i8) {
        if (i8 >= 40) {
            b();
        } else if (i8 >= 20 || i8 == 15) {
            m(h() / 2);
        }
    }

    @Override // Y0.h
    public /* bridge */ /* synthetic */ v c(U0.f fVar) {
        return (v) super.l(fVar);
    }

    @Override // Y0.h
    public /* bridge */ /* synthetic */ v d(U0.f fVar, v vVar) {
        return (v) super.k(fVar, vVar);
    }

    @Override // Y0.h
    public void e(h.a aVar) {
        this.f9508e = aVar;
    }

    @Override // q1.C2625h
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int i(v vVar) {
        return vVar == null ? super.i(null) : vVar.c();
    }

    @Override // q1.C2625h
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(U0.f fVar, v vVar) {
        h.a aVar = this.f9508e;
        if (aVar == null || vVar == null) {
            return;
        }
        aVar.d(vVar);
    }
}
