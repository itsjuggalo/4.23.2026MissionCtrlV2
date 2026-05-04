package ng;

import gd.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b3 implements i.b, i.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b3 f17076a = new b3();

    @Override // gd.i.b, gd.i
    public Object fold(Object obj, pd.o oVar) {
        return i.b.a.a(this, obj, oVar);
    }

    @Override // gd.i.b, gd.i
    public i.b get(i.c cVar) {
        return i.b.a.b(this, cVar);
    }

    @Override // gd.i.b, gd.i
    public gd.i minusKey(i.c cVar) {
        return i.b.a.c(this, cVar);
    }

    @Override // gd.i
    public gd.i plus(gd.i iVar) {
        return i.b.a.d(this, iVar);
    }

    @Override // gd.i.b
    public i.c getKey() {
        return this;
    }
}
